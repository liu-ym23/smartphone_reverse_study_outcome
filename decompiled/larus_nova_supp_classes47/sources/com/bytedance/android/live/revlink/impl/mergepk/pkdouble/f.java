package com.bytedance.android.live.revlink.impl.mergepk.pkdouble;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.v3;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final List<IBattleRivalTag> a;
    public final String b;
    public final int c;
    public final String d;
    public final int e;
    public final int f;
    public final IBattleConfigSetting g;
    public final String h;
    public final int i;
    public final long j;
    public final v3 k;
    public final String l;
    public final HashMap<String, String> m;

    public f() {
        this(null, null, 0, null, 0, null, null, 0, 0, null, null, null, 8191);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f) == false) goto L32;
        f r7 = (f) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L28;
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
        List<IBattleRivalTag> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        String r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((((r6 + r8) * 31) + this.e) * 31) + this.f) * 31;
        IBattleConfigSetting r10 = this.g;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.h;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (((r13 + r15) * 31) + this.i) * 31;
        long r17 = this.j;
        int r18 = (r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        v3 r19 = this.k;
        if (r19 == null) goto L25;
        int r20 = r19.hashCode();
    L26:
        int r22 = (r18 + r20) * 31;
        String r23 = this.l;
        if (r23 == null) goto L29;
        int r24 = r23.hashCode();
    L30:
        int r25 = (r22 + r24) * 31;
        HashMap<String, String> r26 = this.m;
        if (r26 == null) goto L34;
        r1 = r26.hashCode();
    L34:
        return r25 + r1;
    L29:
        r24 = 0;
        goto L30
    L25:
        r20 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PkInviteParams(rivalTag=" + this.a + ", theme=" + this.b + ", duration=" + this.c + ", activityName=" + this.d + ", inviteSource=" + this.e + ", multiPkMode=" + this.f + ", battleConfigSetting=" + this.g + ", battleAttachedInfo=" + this.h + ", inviteIndex=" + this.i + ", decideDuration=" + this.j + ", clientAttachedInfo=" + this.k + ", gameId=" + this.l + ", logMap=" + this.m + ")";
    }

    public f(List r17, String r18, int r19, String r20, int r22, IBattleConfigSetting r23, String r24, int r25, long r26, v3 r27, String r28, HashMap r29, int r30) {
        HashMap r3 = null;
        if ((r30 & 1) == 0) goto L5;
        List r2 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r4 = l51.a.m();
    L11:
        if ((r30 & 4) == 0) goto L13;
        int r5 = l51.a.j();
    L14:
        String r7 = "";
        if ((r30 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r30 & 16) == 0) goto L21;
        int r8 = 0;
    L23:
        if ((r30 & 64) == 0) goto L25;
        IBattleConfigSetting r10 = null;
    L27:
        if ((r30 & 128) != 0) goto L31;
        r7 = r24;
    L31:
        if ((r30 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L33;
        int r12 = 0;
    L35:
        if ((r30 & 512) == 0) goto L37;
        long r13 = 0;
    L39:
        if ((r30 & 1024) == 0) goto L41;
        v3 r14 = null;
    L43:
        if ((r30 & 2048) == 0) goto L45;
        String r15 = null;
    L47:
        if ((r30 & 4096) != 0) goto L50;
        r3 = r29;
    L50:
        Intrinsics.checkNotNullParameter(r4, FileUtils.PICTURE_THEME);
        Intrinsics.checkNotNullParameter(r6, "activityName");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = 0;
        this.g = r10;
        this.h = r7;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r3;
        return;
    L45:
        r15 = r28;
        goto L47
    L41:
        r14 = r27;
        goto L43
    L37:
        r13 = r26;
        goto L39
    L33:
        r12 = r25;
        goto L35
    L25:
        r10 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L14
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }
}
