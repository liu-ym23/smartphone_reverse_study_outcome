package androidx.media.session;

import ai.j0;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.d;
import android.support.v4.media.e;
import android.support.v4.media.f;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.media.MediaBrowserServiceCompat;
import java.util.HashSet;
import java.util.List;
import s6.c;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    public static class MediaButtonConnectionCallback extends d {
        private final Context mContext;
        private final Intent mIntent;
        private f mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        public MediaButtonConnectionCallback(Context r5, Intent r10, BroadcastReceiver.PendingResult r11) {
            this.mContext = r5;
            this.mIntent = r10;
            this.mPendingResult = r11;
        }

        private void finish() {
            e r5 = this.mMediaBrowser.f373a;
            c r10 = r5.f;
            if (r10 == null) goto L10;
            Messenger r11 = r5.g;
            if (r11 == null) goto L10;
            r10.C(7, null, r11);     // Catch: RemoteException -> L9
        L9:
            Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
        L10:
            r5.f369b.disconnect();
            this.mPendingResult.finish();
        }

        @Override // android.support.v4.media.d
        public void onConnected() {
            Context r5 = this.mContext;     // Catch: RemoteException -> L12
            e r10 = this.mMediaBrowser.f373a;     // Catch: RemoteException -> L12
            if (r10.f371h != null) goto L5;
            r10.f371h = MediaSessionCompat$Token.c(r10.f369b.getSessionToken(), null);     // Catch: RemoteException -> L12
        L5:
            MediaSessionCompat$Token r11 = r10.f371h;     // Catch: RemoteException -> L12
            new HashSet();     // Catch: RemoteException -> L12
            if (r11 == null) goto L15;
            android.support.v4.media.session.e r12 = new android.support.v4.media.session.e(r5, r11);     // Catch: RemoteException -> L12
            KeyEvent r13 = (KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");     // Catch: RemoteException -> L12
            if (r13 == null) goto L11;
            r12.f397a.dispatchMediaButtonEvent(r13);     // Catch: RemoteException -> L12
        L17:
            finish();
            return;
        L11:
            throw new IllegalArgumentException("KeyEvent may not be null");     // Catch: RemoteException -> L12
        L15:
            throw new IllegalArgumentException("sessionToken must not be null");     // Catch: RemoteException -> L12
        L12:
            e = move-exception;
            Log.e(MediaButtonReceiver.TAG, "Failed to create a media controller", e);
            goto L17
        }

        @Override // android.support.v4.media.d
        public void onConnectionFailed() {
            finish();
        }

        @Override // android.support.v4.media.d
        public void onConnectionSuspended() {
            finish();
        }

        public void setMediaBrowser(f r5) {
            this.mMediaBrowser = r5;
        }
    }

    public MediaButtonReceiver() {
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context r5, long r10) {
        ComponentName r11 = getMediaButtonReceiverComponent(r5);
        if (r11 != null) goto L7;
        Log.w(TAG, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    L7:
        return buildMediaButtonPendingIntent(r5, r11, r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static ComponentName getMediaButtonReceiverComponent(Context r5) {
        Intent r10 = new Intent("android.intent.action.MEDIA_BUTTON");
        r10.setPackage(r5.getPackageName());
        List<ResolveInfo> r11 = r5.getPackageManager().queryBroadcastReceivers(r10, 0);
        if (r11.size() != 1) goto L7;
        ActivityInfo r12 = r11.get(0).activityInfo;
        return new ComponentName(r12.packageName, r12.name);
    L7:
        if (r11.size() <= 1) goto L11;
        Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    L11:
        return null;
    }

    private static ComponentName getServiceComponentByAction(Context r5, String r10) {
        PackageManager r11 = r5.getPackageManager();
        Intent r12 = new Intent(r10);
        r12.setPackage(r5.getPackageName());
        List<ResolveInfo> r13 = r11.queryIntentServices(r12, 0);
        if (r13.size() != 1) goto L7;
        ServiceInfo r14 = r13.get(0).serviceInfo;
        return new ComponentName(r14.packageName, r14.name);
    L7:
        if (r13.isEmpty() == false) goto L10;
        return null;
    L10:
        StringBuilder r15 = j0.x("Expected 1 service that handles ", r10, ", found ");
        r15.append(r13.size());
        throw new IllegalStateException(r15.toString());
    }

    public static KeyEvent handleIntent(android.support.v4.media.session.f r5, Intent r10) {
        return null;
    }

    private static void startForegroundService(Context r5, Intent r10) {
        r5.startForegroundService(r10);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r5, Intent r10) {
        if (r10 != null) goto L4;
    L18:
        Log.d(TAG, "Ignore unsupported intent: " + r10);
        return;
    L4:
        if ("android.intent.action.MEDIA_BUTTON".equals(r10.getAction()) == false) goto L18;
        if (r10.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L18;
        ComponentName r11 = getServiceComponentByAction(r5, "android.intent.action.MEDIA_BUTTON");
        if (r11 == null) goto L12;
        r10.setComponent(r11);
        startForegroundService(r5, r10);
        return;
    L12:
        ComponentName r12 = getServiceComponentByAction(r5, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (r12 == null) goto L17;
        BroadcastReceiver.PendingResult r13 = goAsync();
        Context r14 = r5.getApplicationContext();
        MediaButtonConnectionCallback r15 = new MediaButtonConnectionCallback(r14, r10, r13);
        f r16 = new f(r14, r12, r15);
        r15.setMediaBrowser(r16);
        r16.f373a.f369b.connect();
        return;
    L17:
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context r10, ComponentName r11, long r12) {
        if (r11 != null) goto L7;
        Log.w(TAG, "The component name of media button receiver should be provided.");
        return null;
    L7:
        if (r12 != 4) goto L10;
        int r5 = 126;
    L31:
        if (r5 != 0) goto L34;
        Log.w(TAG, "Cannot build a media button pending intent with the given action: " + r12);
        return null;
    L34:
        Intent r13 = new Intent("android.intent.action.MEDIA_BUTTON");
        r13.setComponent(r11);
        r13.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, r5));
        return PendingIntent.getBroadcast(r10, r5, r13, 0);
    L10:
        if (r12 != 2) goto L13;
        r5 = 127;
        goto L31
    L13:
        if (r12 != 32) goto L16;
        r5 = 87;
        goto L31
    L16:
        if (r12 != 16) goto L19;
        r5 = 88;
        goto L31
    L19:
        if (r12 != 1) goto L22;
        r5 = 86;
        goto L31
    L22:
        if (r12 != 64) goto L25;
        r5 = 90;
        goto L31
    L25:
        if (r12 != 8) goto L28;
        r5 = 89;
        goto L31
    L28:
        if (r12 != 512) goto L30;
        r5 = 85;
        goto L31
    L30:
        r5 = 0;
        goto L31
    }
}
