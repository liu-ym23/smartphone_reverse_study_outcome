package com.obric.flow.cardlistpage.data;

import ai.j0;
import cn.nubia.neopush.commons.Constant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11485c;
    public final String d;
    public final String e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f11486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f11487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f11488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f11489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f11490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f11491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f11492n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f11493o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f11494p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f11495q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f11496r;

    public j(String r10, String r11, String r12, String r13, String r14, int r15, int r16, boolean r17, Integer r18, Long r19, Long r110, Integer r111, String r20, String r21, String r22, String r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "originalId");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, Constant.TITLE);
        Intrinsics.checkNotNullParameter(r14, Constant.DESCRIPTION);
        this.f11483a = r10;
        this.f11484b = r11;
        this.f11485c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.f11486h = r17;
        this.f11487i = r18;
        this.f11488j = r19;
        this.f11489k = r110;
        this.f11490l = r111;
        this.f11491m = r20;
        this.f11492n = r21;
        this.f11493o = r22;
        this.f11494p = r23;
        this.f11495q = r24;
        this.f11496r = r25;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r10 = (j) r5;
        String r11 = r10.f11483a;
        if (Intrinsics.areEqual(this.f11483a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11484b, r10.f11484b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f11485c, r10.f11485c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.f11486h == r10.f11486h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f11487i, r10.f11487i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f11488j, r10.f11488j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f11489k, r10.f11489k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f11490l, r10.f11490l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f11491m, r10.f11491m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f11492n, r10.f11492n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f11493o, r10.f11493o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f11494p, r10.f11494p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f11495q, r10.f11495q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f11496r, r10.f11496r) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.room.jarjarred.org.antlr.runtime.a.c(this.g, androidx.room.jarjarred.org.antlr.runtime.a.c(this.f, androidx.constraintlayout.motion.widget.a.c(androidx.constraintlayout.motion.widget.a.c(androidx.constraintlayout.motion.widget.a.c(androidx.constraintlayout.motion.widget.a.c(this.f11483a.hashCode() * 31, 31, this.f11484b), 31, this.f11485c), 31, this.d), 31, this.e), 31), 31), 31, this.f11486h);
        int r10 = 0;
        Integer r11 = this.f11487i;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        Long r14 = this.f11488j;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.f11489k;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.f11490l;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.f11491m;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.f11492n;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.f11493o;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.f11494p;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 31;
        String r35 = this.f11495q;
        if (r35 != null) goto L37;
        int r36 = 0;
    L38:
        int r37 = (r34 + r36) * 31;
        String r38 = this.f11496r;
        if (r38 == null) goto L43;
        r10 = r38.hashCode();
    L43:
        return r37 + r10;
    L37:
        r36 = r35.hashCode();
        goto L38
    L33:
        r33 = r32.hashCode();
        goto L34
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("CardEntity(id=");
        r5.append(this.f11483a);
        r5.append(", originalId=");
        r5.append(this.f11484b);
        r5.append(", type=");
        r5.append(this.f11485c);
        r5.append(", title=");
        r5.append(this.d);
        r5.append(", description=");
        r5.append(this.e);
        r5.append(", spanX=");
        r5.append(this.f);
        r5.append(", spanY=");
        r5.append(this.g);
        r5.append(", isVisible=");
        r5.append(this.f11486h);
        r5.append(", sortIndex=");
        r5.append(this.f11487i);
        r5.append(", createTime=");
        r5.append(this.f11488j);
        r5.append(", modifyTime=");
        r5.append(this.f11489k);
        r5.append(", instanceId=");
        r5.append(this.f11490l);
        r5.append(", appletId=");
        r5.append(this.f11491m);
        r5.append(", widgetId=");
        r5.append(this.f11492n);
        r5.append(", definitionId=");
        r5.append(this.f11493o);
        r5.append(", config=");
        r5.append(this.f11494p);
        r5.append(", extras=");
        r5.append(this.f11495q);
        r5.append(", data=");
        return j0.q(r5, this.f11496r, ")");
    }
}
