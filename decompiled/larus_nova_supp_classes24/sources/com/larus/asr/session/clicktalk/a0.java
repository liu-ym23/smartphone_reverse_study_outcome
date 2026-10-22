package com.larus.asr.session.clicktalk;

import com.larus.asr.session.e2;
import com.larus.audio.call.RealtimeCallParam;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a0 implements l {
    public final com.larus.audio.call.a a;
    public final k b;
    public RealtimeCallParam c;

    @Override // com.larus.asr.session.clicktalk.l
    public final void a() {
        Intrinsics.checkNotNullParameter("", "endMethod");
        Function1<? super String, Unit> r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.invoke("");
        return;
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void p() {
        this.a.c();
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void q() {
        this.a.a(this.c);
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void release() {
        this.a.b();
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void stop() {
        this.a.e(this.c);
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void r(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        this.c = r2;
        this.a.d(r2);
        this.b.onEvent(j.m.a);
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void updateScreenshotForAsr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tosKey");
        this.a.g(r2);
    }

    public a0(com.larus.audio.call.a r7, RealtimeCallParam r8, CoroutineScope r9, e2 r10) {
        Intrinsics.checkNotNullParameter(r7, "realtimeCallService");
        Intrinsics.checkNotNullParameter(r8, "initialCallParam");
        Intrinsics.checkNotNullParameter(r9, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r10, "eventListener");
        this.a = r7;
        this.b = r10;
        this.c = r8;
        r7.h = new u(this);
        r7.g = new v(this);
        r7.a = new w(this);
        r7.f = new x(this);
        r7.e = new y(this);
        r7.b = new z(this);
        BuildersKt.launch$default(r9, null, null, new ClickTalkRealtimeCallService$7(this, null), 3, null);
    }
}
