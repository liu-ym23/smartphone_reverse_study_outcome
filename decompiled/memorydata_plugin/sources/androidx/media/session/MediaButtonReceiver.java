package androidx.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.MediaBrowserServiceCompat;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends PluginBroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    private static class MediaButtonConnectionCallback extends MediaBrowserCompat.b {
        private final Context mContext;
        private final Intent mIntent;
        private MediaBrowserCompat mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        MediaButtonConnectionCallback(Context r3, Intent r4, BroadcastReceiver.PendingResult r5) {
            this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.mIntent = r4;
            this.mPendingResult = r5;
        }

        private void finish() {
            this.mMediaBrowser.b();
            this.mPendingResult.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void onConnected() {
            new MediaControllerCompat(this.mContext, this.mMediaBrowser.c()).a((KeyEvent) ZeusTransformUtils.preCheckCast(this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT"), KeyEvent.class, "com.obric.memorydata.plugin"));     // Catch: RemoteException -> L4
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

        void setMediaBrowser(MediaBrowserCompat r1) {
            this.mMediaBrowser = r1;
        }
    }

    public MediaButtonReceiver() {
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context r2, long r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        ComponentName r0 = getMediaButtonReceiverComponent(r4);
        if (r0 != null) goto L7;
        Log.w(TAG, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    L7:
        return buildMediaButtonPendingIntent(r4, r0, r3);
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context r3, ComponentName r4, long r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        String r7 = "The component name of media button receiver should be provided.";
    L5:
        Log.w(TAG, r7);
        return null;
    L7:
        int r2 = PlaybackStateCompat.toKeyCode(r5);
        if (r2 != 0) goto L10;
        r7 = "Cannot build a media button pending intent with the given action: " + r5;
        goto L5
    L10:
        Intent r8 = new Intent("android.intent.action.MEDIA_BUTTON");
        r8.setComponent(r4);
        r8.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, r2));
        return PendingIntent.getBroadcast(r6, r2, r8, 0);
    }

    public static ComponentName getMediaButtonReceiverComponent(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intent r0 = new Intent("android.intent.action.MEDIA_BUTTON");
        r0.setPackage(r5.getPackageName());
        List<ResolveInfo> r6 = r5.getPackageManager().queryBroadcastReceivers(r0, 0);
        if (r6.size() != 1) goto L7;
        ResolveInfo r7 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r6.get(0), ResolveInfo.class, "com.obric.memorydata.plugin");
        return new ComponentName(r7.activityInfo.packageName, r7.activityInfo.name);
    L7:
        if (r6.size() <= 1) goto L11;
        Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    L11:
        return null;
    }

    private static ComponentName getServiceComponentByAction(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        PackageManager r0 = r6.getPackageManager();
        Intent r2 = new Intent(r5);
        r2.setPackage(r6.getPackageName());
        List<ResolveInfo> r1 = r0.queryIntentServices(r2, 0);
        if (r1.size() != 1) goto L7;
        ResolveInfo r7 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r1.get(0), ResolveInfo.class, "com.obric.memorydata.plugin");
        return new ComponentName(r7.serviceInfo.packageName, r7.serviceInfo.name);
    L7:
        if (r1.isEmpty() == false) goto L11;
        return null;
    L11:
        throw new IllegalStateException("Expected 1 service that handles " + r5 + ", found " + r1.size());
    }

    public static KeyEvent handleIntent(MediaSessionCompat r2, Intent r3) {
        if (r2 == null) goto L11;
        if (r3 != null) goto L5;
        return null;
    L5:
        if ("android.intent.action.MEDIA_BUTTON".equals(r3.getAction()) == true) goto L7;
        return null;
    L7:
        if (r3.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L15;
        KeyEvent r4 = (KeyEvent) ZeusTransformUtils.preCheckCast(r3.getParcelableExtra("android.intent.extra.KEY_EVENT"), KeyEvent.class, "com.obric.memorydata.plugin");
        r2.a().a(r4);
        return r4;
    L15:
        return null;
    L11:
        return null;
    }

    private static void startForegroundService(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        int r0 = Build.VERSION.SDK_INT;
        ZeusTransformUtils.startService(r5, r4, "com.obric.memorydata.plugin");
    }

    public void onReceive(Context r4, Intent r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L19:
        Log.d(TAG, "Ignore unsupported intent: " + r5);
        return;
    L5:
        if ("android.intent.action.MEDIA_BUTTON".equals(r5.getAction()) == false) goto L19;
        if (r5.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L19;
        ComponentName r0 = getServiceComponentByAction(r6, "android.intent.action.MEDIA_BUTTON");
        if (r0 == null) goto L13;
        r5.setComponent(r0);
        startForegroundService(r6, r5);
        return;
    L13:
        ComponentName r1 = getServiceComponentByAction(r6, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (r1 == null) goto L18;
        BroadcastReceiver.PendingResult r3 = goAsync();
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        MediaButtonConnectionCallback r2 = new MediaButtonConnectionCallback(r7, r5, r3);
        MediaBrowserCompat r8 = new MediaBrowserCompat(r7, r1, r2, null);
        r2.setMediaBrowser(r8);
        r8.a();
        return;
    L18:
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }
}
