package com.bytedance.ai.applet.page;

import com.bytedance.ai.bridge.ContainerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppletPageFragment$createLynxView$lynxView$2$1 extends FunctionReferenceImpl implements Function2<String, ContainerType, Boolean> {
    public AppletPageFragment$createLynxView$lynxView$2$1(Object r10) {
        super(2, r10, s4.d.class, "check", "check(Ljava/lang/String;Lcom/bytedance/ai/bridge/ContainerType;)Z", 0);
    }

    public final Boolean invoke(String r10, ContainerType r11) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        ((s4.d) ((CallableReference) this).receiver).getClass();
        return Boolean.valueOf(s4.d.a(r10, r11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((String) r1, (ContainerType) r10);
    }
}
