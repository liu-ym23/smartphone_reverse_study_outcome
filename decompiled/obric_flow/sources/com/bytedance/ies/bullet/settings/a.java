package com.bytedance.ies.bullet.settings;

import com.bytedance.android.monitorV2.settings.f;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import tc.c;
import xc.e;
import ym.d;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends tc.a implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c5.a f6161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rb.b f6162c;
    public o d;

    public a(c5.a r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        this.f6161b = r5;
        this.f6162c = new rb.b();
        pg.a.b("Bullet").f21343a = new d(this);
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.c(LogLevel.f5954b, "bullet init: ");
        boolean r11 = r5.f1118b;
        pg.a r12 = pg.a.b("Bullet");
        r12.f21345c.put(new f(this, 1), Boolean.valueOf(!r11));
        c r13 = c.f22119c;
        b r14 = (b) fj.a.a(c.f22119c, b.class, b.class);
        if (r14 == null) goto L5;
        com.bytedance.ies.bullet.service.base.d r15 = (com.bytedance.ies.bullet.service.base.d) r14.f6163b.getValue();
    L5:
        pg.a.b("Bullet").d();
    }

    @Override // xc.e
    public final Object a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(this.f6162c.a(r5));     // Catch: Throwable -> L5
    L8:
        if (Result.m130isFailureimpl(r11) == false) goto L13;
        return null;
    L13:
        return r11;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
