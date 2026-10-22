package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m3 implements Function1 {
    public final /* synthetic */ ManualOnlyReason a;
    public final /* synthetic */ d5 b;
    public final /* synthetic */ CheckPurpose c;
    public final /* synthetic */ long d;
    public final /* synthetic */ OtaMode e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ e5 g;
    public final /* synthetic */ q5 h;
    public final /* synthetic */ a5 i;

    public /* synthetic */ m3(ManualOnlyReason r1, d5 r2, CheckPurpose r3, long r4, OtaMode r6, boolean r7, e5 r8, q5 r9, a5 r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public final Object invoke(Object r64) {
        ManualOnlyReason r11 = this.a;
        d5 r12 = this.b;
        CheckPurpose r14 = this.c;
        long r8 = this.d;
        OtaMode r15 = this.e;
        boolean r13 = this.f;
        e5 r10 = this.g;
        q5 r6 = this.h;
        a5 r7 = this.i;
        f r4 = (f) r64;
        Intrinsics.checkNotNullParameter(r4, "it");
        w4 r32 = new w4(0, null, false, null, 31);
        f5 r34 = f5.a(r4.l(), null, null, 0, 0, 0, null, r11, r12, 127);
        CheckPurpose r1 = CheckPurpose.INSTALL;
        if (r14 != r1) goto L5;
        v4 r2 = v4.a(r4.f(), InstallPhase.QUEUED, 0, null, 0, 0, false, null, null, 0, 0, 0, BlockReason.PACKAGE_MISSING, null, false, 28670);
    L6:
        v4 r37 = r2;
        DownloadPhase r16 = DownloadPhase.QUEUED;
        if (r14 != r1) goto L9;
        boolean r21 = true;
    L11:
        return f.a(r4, null, null, null, null, null, r32, r10, r34, null, new l(r16, r8, null, r15, r21, r13, null, null, 3444), r37, null, null, j5.a(r4.m(), 0, "", 0, 0, 0, 0, 60), r6, null, r7, 74303);
    L9:
        r21 = false;
        goto L11
    L5:
        r2 = r4.f();
        goto L6
    }
}
