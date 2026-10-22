package com.bytedance.android.anniex.utils;

import android.view.View;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class WebcastContainerInitializerInAnnieX {
    public static void a(ra.a r10, final View r11, LynxBDXBridge r12, m16.b r13) {
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r13, "providerFactory");
        x0.a(r11, r12, r13, r10.g, r10.b, new WebcastContainerInitializerInAnnieX$initializeWithAnnieXLynxModelInLynx$1(r11));
    }
}
