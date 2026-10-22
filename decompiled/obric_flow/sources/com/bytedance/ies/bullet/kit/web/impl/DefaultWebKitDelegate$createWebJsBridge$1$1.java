package com.bytedance.ies.bullet.kit.web.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
final /* synthetic */ class DefaultWebKitDelegate$createWebJsBridge$1$1 extends FunctionReferenceImpl implements Function2<String, com.bytedance.ies.bullet.core.kit.bridge.c, Unit> {
    public DefaultWebKitDelegate$createWebJsBridge$1$1(i r10) {
        super(2, r10, i.class, "onPerfDataReady", "onPerfDataReady(Ljava/lang/String;Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;)V", 0);
    }

    public final void a(String r5, com.bytedance.ies.bullet.core.kit.bridge.c r10) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        Intrinsics.checkNotNullParameter(r10, "p1");
        i r11 = (i) this.receiver;
        r11.getClass();
        h.f.b(new f(r11, r10, r5), h.f.g);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final /* bridge */ /* synthetic */ Unit mo2invoke(String r5, com.bytedance.ies.bullet.core.kit.bridge.c r10) {
        a(r5, r10);
        return Unit.INSTANCE;
    }
}
