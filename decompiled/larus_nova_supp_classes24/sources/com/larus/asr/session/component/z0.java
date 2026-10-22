package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z0 implements o0 {
    public final com.larus.asr.session.p a;
    public final f0 b;
    public final boolean c;

    @Override // com.larus.asr.session.component.o0
    public final void a(byte[] r1) {
    }

    @Override // com.larus.asr.session.component.o0
    public final void onClear() {
    }

    @Override // com.larus.asr.session.component.o0
    public final void onStop() {
    }

    @Override // com.larus.asr.session.component.o0
    public final void c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.asr.session.component.o0
    public final void d(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.c == false) goto L6;
        int r3 = AsrSessionComponentUtils.a;
        AsrSessionComponentUtils.d(this.b);
        return;
    }

    @Override // com.larus.asr.session.component.o0
    public final void e(j0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.c == false) goto L6;
        int r3 = AsrSessionComponentUtils.a;
        AsrSessionComponentUtils.d(this.b);
        return;
    }

    @Override // com.larus.asr.session.component.o0
    public final void i(j0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.asr.session.component.o0
    public final void j(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a.Ga(r2);
    }

    @Override // com.larus.asr.session.component.o0
    public final void h(a0 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    @Override // com.larus.asr.session.component.o0
    public final void l(a0 r2, com.larus.audio.b r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    public z0(com.larus.asr.session.p r2, f0 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "asrContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.larus.asr.session.component.o0
    public final void f(a0 r1, String r2, String r3, long r4, int r6) {
        Intrinsics.checkNotNullParameter(r1, "scope");
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "path");
    }
}
