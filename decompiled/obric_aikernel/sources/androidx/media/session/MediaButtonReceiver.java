package androidx.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    private static class MediaButtonConnectionCallback extends MediaBrowserCompat.b {
        private final Context mContext;
        private final Intent mIntent;
        private MediaBrowserCompat mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        MediaButtonConnectionCallback(Context r10, Intent r11, BroadcastReceiver.PendingResult r12) {
            this.mContext = r10;
            this.mIntent = r11;
            this.mPendingResult = r12;
        }

        private void finish() {
            this.mMediaBrowser.b();
            this.mPendingResult.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void onConnected() {
            new MediaControllerCompat(this.mContext, this.mMediaBrowser.c()).a((KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT"));     // Catch: RemoteException -> L4
        L6:
            finish();
            return;
        L4:
            e = move-exception;
            Log.e(MediaButtonReceiver.TAG, "Failed to create a media controller", e);
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void onConnectionFailed() {
            finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void onConnectionSuspended() {
            finish();
        }

        void setMediaBrowser(MediaBrowserCompat r10) {
            this.mMediaBrowser = r10;
        }
    }

    public MediaButtonReceiver() {
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context r10, long r11) {
        ComponentName r12 = getMediaButtonReceiverComponent(r10);
        if (r12 != null) goto L7;
        Log.w(TAG, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    L7:
        return buildMediaButtonPendingIntent(r10, r12, r11);
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context r10, ComponentName r11, long r12) {
        if (r11 != null) goto L7;
        String r13 = "The component name of media button receiver should be provided.";
    L5:
        Log.w(TAG, r13);
        return null;
    L7:
        int r14 = PlaybackStateCompat.toKeyCode(r12);
        if (r14 != 0) goto L10;
        r13 = "Cannot build a media button pending intent with the given action: " + r12;
        goto L5
    L10:
        Intent r15 = new Intent("android.intent.action.MEDIA_BUTTON");
        r15.setComponent(r11);
        r15.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, r14));
        return PendingIntent.getBroadcast(r10, r14, r15, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static ComponentName getMediaButtonReceiverComponent(Context r10) {
        Intent r11 = new Intent("android.intent.action.MEDIA_BUTTON");
        r11.setPackage(r10.getPackageName());
        List<ResolveInfo> r12 = r10.getPackageManager().queryBroadcastReceivers(r11, 0);
        if (r12.size() != 1) goto L7;
        ActivityInfo r13 = r12.get(0).activityInfo;
        return new ComponentName(r13.packageName, r13.name);
    L7:
        if (r12.size() <= 1) goto L11;
        Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    L11:
        return null;
    }

    private static ComponentName getServiceComponentByAction(Context r10, String r11) {
        PackageManager r12 = r10.getPackageManager();
        Intent r13 = new Intent(r11);
        r13.setPackage(r10.getPackageName());
        List<ResolveInfo> r14 = r12.queryIntentServices(r13, 0);
        if (r14.size() != 1) goto L7;
        ServiceInfo r15 = r14.get(0).serviceInfo;
        return new ComponentName(r15.packageName, r15.name);
    L7:
        if (r14.isEmpty() == false) goto L11;
        return null;
    L11:
        throw new IllegalStateException("Expected 1 service that handles " + r11 + ", found " + r14.size());
    }

    public static KeyEvent handleIntent(MediaSessionCompat r10, Intent r11) {
        if (r10 == null) goto L11;
        if (r11 != null) goto L5;
        return null;
    L5:
        if ("android.intent.action.MEDIA_BUTTON".equals(r11.getAction()) == true) goto L7;
        return null;
    L7:
        if (r11.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L15;
        KeyEvent r12 = (KeyEvent) r11.getParcelableExtra("android.intent.extra.KEY_EVENT");
        r10.b().a(r12);
        return r12;
    L15:
        return null;
    L11:
        return null;
    }

    private static void startForegroundService(Context r10, Intent r11) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r10.startForegroundService(r11);
        return;
    L5:
        r10.startService(r11);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11 != null) goto L4;
    L18:
        Log.d(TAG, "Ignore unsupported intent: " + r11);
        return;
    L4:
        if ("android.intent.action.MEDIA_BUTTON".equals(r11.getAction()) == false) goto L18;
        if (r11.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L18;
        ComponentName r12 = getServiceComponentByAction(r10, "android.intent.action.MEDIA_BUTTON");
        if (r12 == null) goto L12;
        r11.setComponent(r12);
        startForegroundService(r10, r11);
        return;
    L12:
        ComponentName r13 = getServiceComponentByAction(r10, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (r13 == null) goto L17;
        BroadcastReceiver.PendingResult r14 = goAsync();
        Context r15 = r10.getApplicationContext();
        MediaButtonConnectionCallback r16 = new MediaButtonConnectionCallback(r15, r11, r14);
        MediaBrowserCompat r17 = new MediaBrowserCompat(r15, r13, r16, null);
        r16.setMediaBrowser(r17);
        r17.a();
        return;
    L17:
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }
}
