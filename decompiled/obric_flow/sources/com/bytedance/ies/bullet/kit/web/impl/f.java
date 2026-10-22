package com.bytedance.ies.bullet.kit.web.impl;

import com.bytedance.ies.bullet.service.base.x;
import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f5512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.core.kit.bridge.c f5513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5514c;

    public f(i r5, com.bytedance.ies.bullet.core.kit.bridge.c r10, String r11) {
        this.f5512a = r5;
        this.f5513b = r10;
        this.f5514c = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        com.bytedance.ies.bullet.service.webkit.c r5 = this.f5512a.f5522a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.base.i.class, "clazz");
        tc.c r10 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.base.i r11 = (com.bytedance.ies.bullet.service.base.i) tc.c.f22119c.a(com.bytedance.ies.bullet.service.base.i.class, r5.f22117a);
        if (r11 == null) goto L14;
        i r12 = this.f5512a;
        com.bytedance.ies.bullet.core.kit.bridge.c r13 = this.f5513b;
        String r14 = this.f5514c;
        x r15 = new x("bdx_monitor_bridge_duration");
        if (r12.f5524c == null) goto L7;
        r15.f6027j = r12.d().f5303q;
    L7:
        r15.f = r13.b();
        JSONObject r16 = new JSONObject();
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L10
        Result.m124constructorimpl(r16.put("method_name", r14));     // Catch: Throwable -> L10
    L12:
        r15.e = r16;
        r15.f6024c = "web";
        r15.f6026i = Boolean.TRUE;
        ((com.bytedance.ies.bullet.service.monitor.i) r11).d(r15);
        return r11;
    L10:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    L14:
        return null;
    }
}
