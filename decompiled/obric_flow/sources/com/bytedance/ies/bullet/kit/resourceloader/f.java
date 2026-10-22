package com.bytedance.ies.bullet.kit.resourceloader;

import com.bytedance.ies.bullet.service.base.a0;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends h {
    @Override // com.bytedance.ies.bullet.kit.resourceloader.h
    public final d a(String r5, wc.g r10, Function1 r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "resolve");
        Intrinsics.checkNotNullParameter(r12, "reject");
        dc.b.b("placeHolder loadAsync " + r5);
        r12.invoke(new Throwable("rl not init"));
        return new d();
    }

    @Override // com.bytedance.ies.bullet.kit.resourceloader.h
    public final a0 c(String r5, wc.g r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "config");
        dc.b.b("placeHolder loadSync " + r5);
        return null;
    }
}
