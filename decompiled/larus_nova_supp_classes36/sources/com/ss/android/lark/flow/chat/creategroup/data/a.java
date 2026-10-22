package com.ss.android.lark.flow.chat.creategroup.data;

import com.bytedance.lark.pb.basic.v1.DeniedReason;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int o = 0;
    public final long a;
    public final long b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final e m;
    public final List<DeniedReason> n;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.creategroup.data.a$a, reason: collision with other inner class name */
    public static final class C0020a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (((((((((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        int r4 = 1231;
        if (this.i == false) goto L5;
        int r5 = 1231;
    L6:
        int r6 = (r2 + r5) * 31;
        if (this.j == false) goto L9;
        int r7 = 1231;
    L10:
        int r8 = (r6 + r7) * 31;
        if (this.k == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r8 + r9) * 31;
        if (this.l == true) goto L18;
        r4 = 1237;
    L18:
        int r11 = (r10 + r4) * 31;
        e r12 = this.m;
        int r13 = 0;
        if (r12 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r11 + r14) * 31;
        List<DeniedReason> r16 = this.n;
        if (r16 == null) goto L27;
        r13 = r16.hashCode();
    L27:
        return r15 + r13;
    L21:
        r14 = r12.hashCode();
        goto L22
    L13:
        r9 = 1237;
        goto L14
    L9:
        r7 = 1237;
        goto L10
    L5:
        r5 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowGroupCreateContactItemModel(feishuUserId=" + this.a + ", dbUserId=" + this.b + ", name=" + this.c + ", alias=" + this.d + ", displayName=" + this.e + ", displayNamePinyin=" + this.f + ", avatarKey=" + this.g + ", doubaoKey=" + this.h + ", isBusinessUser=" + this.i + ", isDeleted=" + this.j + ", isInChat=" + this.k + ", isResigned=" + this.l + ", relation=" + this.m + ", deniedReasons=" + this.n + ')';
    }

    public a(long r10, long r12, String r14, String r15, String r16, String r17, String r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23, e r24, List<? extends DeniedReason> r25) {
        Intrinsics.checkNotNullParameter(r14, "name");
        Intrinsics.checkNotNullParameter(r15, "alias");
        Intrinsics.checkNotNullParameter(r16, "displayName");
        Intrinsics.checkNotNullParameter(r17, "displayNamePinyin");
        Intrinsics.checkNotNullParameter(r18, "avatarKey");
        Intrinsics.checkNotNullParameter(r19, "doubaoKey");
        this.a = r10;
        this.b = r12;
        this.c = r14;
        this.d = r15;
        this.e = r16;
        this.f = r17;
        this.g = r18;
        this.h = r19;
        this.i = r20;
        this.j = r21;
        this.k = r22;
        this.l = r23;
        this.m = r24;
        this.n = r25;
    }
}
