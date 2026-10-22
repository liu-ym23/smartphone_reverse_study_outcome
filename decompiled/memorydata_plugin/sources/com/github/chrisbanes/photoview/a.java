package com.github.chrisbanes.photoview;

import android.os.Build;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class a {
    public static void a(View r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        b(r2, r4);
        return;
    L5:
        r2.postDelayed(r4, 16);
    }

    private static void b(View r2, Runnable r3) {
        r2.postOnAnimation((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
    }
}
