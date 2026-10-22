package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends cj.a {
    public final PlatformType f;

    public d(String r5, SSWebView r10, b r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "containerID");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "jsEventDelegate");
        Intrinsics.checkNotNullParameter(r12, "namespace");
        super(r5, r10, r12);
        this.f = PlatformType.f7288b;
    }

    @Override // cj.e
    /* JADX INFO: renamed from: a */
    public final PlatformType mo116a() {
        return this.f;
    }
}
