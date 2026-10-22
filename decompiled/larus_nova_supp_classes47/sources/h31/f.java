package h31;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.pk.utils.l;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.v0;
import com.bytedance.android.livesdk.link.model.w2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final PkBaseDataContext.PKModType a;
    public final long b;
    public final d c;
    public final e d;
    public final i e;
    public final c f;
    public final w2 g;
    public final h9 h;
    public final v0 i;
    public final h j;
    public final long k;
    public final l l;
    public final IBattleConfigSetting m;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f) == false) goto L32;
        f r7 = (f) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        PkBaseDataContext.PKModType r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        d r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        e r8 = this.d;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        i r12 = this.e;
        if (r12 == null) goto L17;
        int r13 = r12.hashCode();
    L18:
        int r14 = (r10 + r13) * 31;
        c r15 = this.f;
        if (r15 == null) goto L21;
        int r16 = r15.hashCode();
    L22:
        int r17 = (r14 + r16) * 31;
        w2 r18 = this.g;
        if (r18 == null) goto L25;
        int r19 = r18.hashCode();
    L26:
        int r20 = (r17 + r19) * 31;
        h9 r22 = this.h;
        if (r22 == null) goto L29;
        int r23 = r22.hashCode();
    L30:
        int r24 = (r20 + r23) * 31;
        v0 r25 = this.i;
        if (r25 == null) goto L33;
        int r26 = r25.hashCode();
    L34:
        int r27 = (r24 + r26) * 31;
        h r28 = this.j;
        if (r28 == null) goto L37;
        int r29 = r28.hashCode();
    L38:
        int r30 = (r27 + r29) * 31;
        long r32 = this.k;
        int r33 = (r30 + ((int) (r32 ^ (r32 >>> 32)))) * 31;
        l r34 = this.l;
        if (r34 == null) goto L41;
        int r35 = r34.hashCode();
    L42:
        int r36 = (r33 + r35) * 31;
        IBattleConfigSetting r37 = this.m;
        if (r37 == null) goto L46;
        r1 = r37.hashCode();
    L46:
        return r36 + r1;
    L41:
        r35 = 0;
        goto L42
    L37:
        r29 = 0;
        goto L38
    L33:
        r26 = 0;
        goto L34
    L29:
        r23 = 0;
        goto L30
    L25:
        r19 = 0;
        goto L26
    L21:
        r16 = 0;
        goto L22
    L17:
        r13 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiBattleDataContext(type=" + this.a + ", duration=" + this.b + ", firstPkData=" + this.c + ", inviteData=" + this.d + ", voteOpenData=" + this.e + ", customPKData=" + this.f + ", shellConfig=" + this.g + ", specifyGiftConfig=" + this.h + ", cloudCollaborateConfig=" + this.i + ", multiPlayMode=" + this.j + ", decideDuration=" + this.k + ", pageSource=" + this.l + ", battleConfigSetting=" + this.m + ")";
    }

    public final PkBaseDataContext.PKModType getType() {
        return this.a;
    }

    public f(PkBaseDataContext.PKModType r10, long r12, d r13, e r14, i r15, c r16, w2 r17, h9 r18, h r19, long r20, l r22, IBattleConfigSetting r23, int r24) {
        if ((r24 & 128) == 0) goto L5;
        h9 r5 = null;
    L7:
        if ((r24 & 4096) == 0) goto L9;
        IBattleConfigSetting r4 = null;
    L10:
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r19, "multiPlayMode");
        Intrinsics.checkNotNullParameter(r22, "pageSource");
        this.a = r10;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r5;
        this.i = null;
        this.j = r19;
        this.k = r20;
        this.l = r22;
        this.m = r4;
        return;
    L9:
        r4 = r23;
        goto L10
    L5:
        r5 = r18;
        goto L7
    }
}
