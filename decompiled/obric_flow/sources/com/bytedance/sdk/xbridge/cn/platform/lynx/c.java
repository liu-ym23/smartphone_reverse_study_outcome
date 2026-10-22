package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends cj.a {
    public final LynxView f;
    public final PlatformType g;

    public c(a r5, LynxView r10, String r11, String r12) {
        PlatformType r13 = PlatformType.f7287a;
        Intrinsics.checkNotNullParameter(r11, "containerID");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r5, "jsEventDelegate");
        Intrinsics.checkNotNullParameter(r12, "namespace");
        Intrinsics.checkNotNullParameter(r13, "platformType");
        super(r11, r10, r12);
        this.f = r10;
        this.g = r13;
    }

    @Override // cj.e
    /* JADX INFO: renamed from: a */
    public final PlatformType mo116a() {
        return this.g;
    }
}
