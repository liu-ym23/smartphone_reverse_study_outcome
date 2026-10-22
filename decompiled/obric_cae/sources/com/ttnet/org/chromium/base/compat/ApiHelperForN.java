package com.ttnet.org.chromium.base.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ClipData;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.view.PointerIcon;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ttnet.org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(24)
@DoNotInline
public final class ApiHelperForN {
    private ApiHelperForN() {
    }

    public static PointerIcon createPointerIcon(Bitmap r8, float r10, float r11) {
        return PointerIcon.create(r8, r10, r11);
    }

    public static JobInfo getPendingJob(JobScheduler r8, int r10) {
        return r8.getPendingJob(r10);
    }

    public static void setCryptoInfoPattern(MediaCodec.CryptoInfo r8, int r10, int r11) {
        r8.setPattern(new MediaCodec.CryptoInfo.Pattern(r10, r11));
    }

    public static void setPointerIcon(View r8, PointerIcon r10) {
        r8.setPointerIcon(r10);
    }

    public static void setVrModeEnabled(Activity r8, boolean r10, ComponentName r11) {
        r8.setVrModeEnabled(r10, r11);
    }

    public static boolean shouldOverrideUrlLoading(WebViewClient r8, WebView r10, WebResourceRequest r11) {
        return r8.shouldOverrideUrlLoading(r10, r11);
    }

    public static boolean startDragAndDrop(View r8, ClipData r10, View.DragShadowBuilder r11, Object r12, int r13) {
        return r8.startDragAndDrop(r10, r11, r12, r13);
    }
}
