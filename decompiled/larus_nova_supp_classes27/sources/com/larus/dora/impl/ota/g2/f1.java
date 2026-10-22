package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f1 implements Function1 {
    public final /* synthetic */ FailureReason a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ TerminalResult c;
    public final /* synthetic */ long d;
    public final /* synthetic */ b5 e;

    public /* synthetic */ f1(FailureReason r1, boolean r2, TerminalResult r3, long r4, b5 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final Object invoke(Object r43) {
        FailureReason r5 = this.a;
        boolean r13 = this.b;
        TerminalResult r14 = this.c;
        long r11 = this.d;
        b5 r15 = this.e;
        f r9 = (f) r43;
        Intrinsics.checkNotNullParameter(r9, "it");
        OtaMode r1 = r9.f().i();
        if (r1 != null) goto L5;
        r1 = r9.f().e();
    L5:
        OtaMode r20 = r1;
        v4 r16 = v4.a(r9.f(), InstallPhase.TERMINAL_PENDING_ACK, 0, r20, 0, 0, false, null, null, 0, 0, 0, null, r5, false, 20726);
        FailureReason r17 = FailureReason.DOWNLOAD_MD5_FAILED;
        if (r5 != r17) goto L8;
        l r2 = l.a(r9.c(), null, 0, r20, 0, 0, 0, false, null, false, null, null, 4087);
    L9:
        l r26 = r2;
        if (r13 == false) goto L12;
        FailureReason r44 = r5;
        f5 r24 = f5.a(r9.l(), PackagePhase.ABANDONED, null, 0, 0, 0, r5, null, null, 446);
        long r40 = r11;
        TerminalResult r18 = r14;
    L17:
        j5 r3 = r9.m();
        if (r44 != r17) goto L20;
        int r8 = r9.m().e() + 1;
    L22:
        if (r18 == TerminalResult.FAILURE) goto L24;
    L26:
        long r10 = r9.m().d();
    L28:
        return f.a(r9, null, null, null, null, null, null, null, r24, null, r26, r16, null, null, j5.a(r3, 0, null, 0, 0, r8, r10, 15), null, null, null, 242431);
    L24:
        if (r9.f().e() != OtaMode.SILENT_G2) goto L26;
        c4.INSTANCE.getClass();
        r10 = c4.E(r15, r40);
        goto L28
    L20:
        r8 = r9.m().e();
        goto L22
    L12:
        r44 = r5;
        r18 = r14;
        if (r18 != TerminalResult.UNKNOWN) goto L15;
        r40 = r11;
        f5 r4 = f5.a(r9.l(), PackagePhase.UNCONFIRMED, null, 0, j0.G2_OTA_PARTIAL_TTL_MS + r11, 0, r44, null, null, 430);
    L16:
        r24 = r4;
        goto L17
    L15:
        r40 = r11;
        r4 = r9.l();
        goto L16
    L8:
        r2 = r9.c();
        goto L9
    }
}
