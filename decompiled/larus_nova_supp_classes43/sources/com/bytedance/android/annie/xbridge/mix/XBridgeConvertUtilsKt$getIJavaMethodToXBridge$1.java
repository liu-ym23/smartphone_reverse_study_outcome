package com.bytedance.android.annie.xbridge.mix;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/annie/xbridge/mix/XBridgeConvertUtilsKt$getIJavaMethodToXBridge$1", "Lcom/bytedance/android/annie/xbridge/mix/IJavaMethod2Annie;", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class XBridgeConvertUtilsKt$getIJavaMethodToXBridge$1 extends IJavaMethod2Annie {
    public final String e;
    public final /* synthetic */ n56.c f;

    public final String getName() {
        return this.e;
    }

    @Override // com.bytedance.android.annie.xbridge.mix.IJavaMethod2Annie
    public final n56.c c(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        com.bytedance.android.anniex.assemble.a.h();
        return this.f;
    }

    public XBridgeConvertUtilsKt$getIJavaMethodToXBridge$1(String r1, m16.b r10, n56.c r11) {
        this.f = r11;
        super(r10);
        this.e = r1;
    }
}
