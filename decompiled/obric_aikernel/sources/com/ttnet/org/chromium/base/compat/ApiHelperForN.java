package com.ttnet.org.chromium.base.compat;

import android.app.Activity;
import android.app.Notification;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ClipData;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.net.ConnectivityManager;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public final class ApiHelperForN {
    private ApiHelperForN() {
    }

    public static PointerIcon createPointerIcon(Bitmap r10, float r11, float r12) {
        return PointerIcon.create(r10, r11, r12);
    }

    public static JobInfo getPendingJob(JobScheduler r10, int r11) {
        return r10.getPendingJob(r11);
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager r10) {
        return r10.getRestrictBackgroundStatus();
    }

    public static long getStartUptimeMillis() {
        return Process.getStartUptimeMillis();
    }

    public static boolean isCleartextTrafficPermitted(String r10) {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r10);
    }

    public static PointerIcon onResolvePointerIcon(View r10, MotionEvent r11, int r12) {
        return r10.onResolvePointerIcon(r11, r12);
    }

    public static void setCryptoInfoPattern(MediaCodec.CryptoInfo r10, int r11, int r12) {
        r10.setPattern(new MediaCodec.CryptoInfo.Pattern(r11, r12));
    }

    public static Notification.Builder setCustomBigContentView(Notification.Builder r10, RemoteViews r11) {
        return r10.setCustomBigContentView(r11);
    }

    public static Notification.Builder setCustomContentView(Notification.Builder r10, RemoteViews r11) {
        return r10.setCustomContentView(r11);
    }

    public static void setPointerIcon(View r10, PointerIcon r11) {
        r10.setPointerIcon(r11);
    }

    public static void setVrModeEnabled(Activity r10, boolean r11, ComponentName r12) {
        r10.setVrModeEnabled(r11, r12);
    }

    public static boolean shouldOverrideUrlLoading(WebViewClient r10, WebView r11, WebResourceRequest r12) {
        return r10.shouldOverrideUrlLoading(r11, r12);
    }

    public static boolean startDragAndDrop(View r10, ClipData r11, View.DragShadowBuilder r12, Object r13, int r14) {
        return r10.startDragAndDrop(r11, r12, r13, r14);
    }
}
