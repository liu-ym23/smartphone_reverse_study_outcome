package com.bytedance.ai.lynx;

import android.net.Uri;
import com.lynx.tasm.LynxError;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface r {
    void onDetachedFromWindow(g r1);

    void onFirstScreen(g r1);

    void onLoadUriSuccess(Uri r1, g r10);

    void onPageStart(g r1, String r10);

    void onPageUpdate(g r1);

    void onReceivedError(g r1, LynxError r10);

    void onRuntimeReady(g r1);

    void onTimingSetup(g r1, Map<String, Object> r10);

    void onTimingUpdate(g r1, Map<String, Object> r10, Map<String, Long> r11, String r12);
}
