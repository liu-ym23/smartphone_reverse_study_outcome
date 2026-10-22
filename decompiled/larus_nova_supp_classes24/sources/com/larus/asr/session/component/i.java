package com.larus.asr.session.component;

import com.larus.asr.KmpAsrSessionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements KmpAsrSessionAdapter.a {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ h b;
    public final /* synthetic */ b0 c;

    @Override // com.larus.asr.KmpAsrSessionAdapter.a
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        if (this.b.d.b == false) goto L6;
        this.c.b.b(r2);
        return;
    }

    @Override // com.larus.asr.KmpAsrSessionAdapter.a
    public final void c(com.larus.audio.b r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.c.b.d(r2);
    }

    @Override // com.larus.asr.KmpAsrSessionAdapter.a
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionTaskId");
        if (this.a.a() == false) goto L6;
        this.b.g();
        return;
    }

    @Override // com.larus.asr.KmpAsrSessionAdapter.a
    public final void d(String r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.c.b.a(r3);
    }

    public i(f0 r1, h r2, b0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.larus.asr.KmpAsrSessionAdapter.a
    public final void e(String r8, String r9, long r10, int r12) {
        Intrinsics.checkNotNullParameter(r8, "sessionTaskId");
        Intrinsics.checkNotNullParameter(r9, "audioFilePath");
        this.c.b.c(r8, r9, r10, r12);
    }
}
