package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l0 implements o0 {
    public final com.larus.asr.session.p a;
    public final f0 b;

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
    public final void c(a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = AsrSessionComponentUtils.a;
        AsrSessionComponentUtils.b(this.a, r5.a, null, "onCancel:" + r5.a, 12);
        this.b.e(com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a);
    }

    @Override // com.larus.asr.session.component.o0
    public final void d(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.asr.session.component.o0
    public final void e(j0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.asr.session.component.o0
    public final void i(j0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.asr.session.component.o0
    public final void j(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public l0(com.larus.asr.session.p r2, f0 r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "asrContext");
        this.a = r2;
        this.b = r3;
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

    @Override // com.larus.asr.session.component.o0
    public final void f(a0 r1, String r2, String r3, long r4, int r6) {
        Intrinsics.checkNotNullParameter(r1, "scope");
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "path");
    }
}
