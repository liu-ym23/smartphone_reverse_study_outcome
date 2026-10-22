package com.ivy.ivykit.plugin.impl.applet;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends tc.a implements xc.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.bullet.settings.a f9512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rb.b f9513c;

    public e(xc.a r5, com.bytedance.ies.bullet.settings.a r10) {
        Intrinsics.checkNotNullParameter(r5, "appInfo");
        this.f9512b = r10;
        rb.b r11 = new rb.b();
        this.f9513c = r11;
        com.lynx.tasm.behavior.d r12 = new com.lynx.tasm.behavior.d(8);
        Intrinsics.checkNotNullParameter(r5, "appInfo");
        Intrinsics.checkNotNullParameter(r12, "network");
        com.bytedance.ies.bullet.base.settings.d r13 = new com.bytedance.ies.bullet.base.settings.d();
        r13.g();
        Unit r14 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.base.settings.d.class, "clazz");
        r11.b(com.bytedance.ies.bullet.base.settings.d.class, new rb.a(r13, 0));
        xc.d r15 = new xc.d();
        r15.J();
        Intrinsics.checkNotNullParameter(xc.d.class, "clazz");
        r11.b(xc.d.class, new rb.a(r15, 0));
    }

    @Override // xc.e
    public final Object a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(this.f9513c.a(r5));     // Catch: Throwable -> L5
    L8:
        if (Result.m130isFailureimpl(r11) == false) goto L10;
        r11 = null;
    L10:
        if (r11 != null) goto L15;
        com.bytedance.ies.bullet.settings.a r12 = this.f9512b;
        if (r12 != null) goto L19;
        return null;
    L19:
        return r12.a(r5);
    L15:
        return r11;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
