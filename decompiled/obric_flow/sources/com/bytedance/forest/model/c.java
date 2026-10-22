package com.bytedance.forest.model;

import ai.j0;
import com.bytedance.keva.KevaImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4362c;
    public int d;
    public int e;
    public String f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4364i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4365j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f4366k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4367l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f4368m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f4369n;

    public final int a(ErrorInfo$Type r5, int r10, String r11) {
        int r12 = r5.ordinal();
        if (r12 != 1) goto L5;
        this.f4364i = r11;
        return r10 * 10;
    L5:
        if (r12 != 2) goto L7;
        this.f4361b = r10;
        this.f4365j = r11;
        return r10 * 100;
    L7:
        if (r12 != 3) goto L9;
        this.f4366k = r11;
        return r10 * 1000;
    L9:
        if (r12 != 4) goto L11;
        this.f4367l = r11;
        return r10 * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
    L11:
        if (r12 == 5) goto L14;
        this.f4368m = r11;
        return r10;
    L14:
        this.f4369n = r11;
        return r10 * 100000;
    }

    public final void b(c r10, ErrorInfo$Type... r11) {
        this.f4360a = r10.f4360a;
        this.f4361b = r10.f4361b;
        this.f4362c = r10.f4362c;
        this.d = r10.d;
        this.f4364i = r10.f4364i;
        this.f4365j = r10.f4365j;
        this.f4366k = r10.f4366k;
        this.f4367l = r10.f4367l;
        this.f4369n = r10.f4368m;
        this.f4369n = r10.f4369n;
        int r12 = r11.length;
        int r5 = 0;
    L3:
        if (r5 >= r12) goto L5;
        int r13 = a(r11[r5], 1, "");
        int r14 = this.f4360a;
        int r15 = r13 * 10;
        int r16 = (r14 / r15) * r15;
        this.f4360a = (r14 % r13) + r16;
        r5 = r5 + 1;
        goto L3
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof c) == false) goto L18;
        c r10 = (c) r5;
        if (Intrinsics.areEqual(this.f4364i, r10.f4364i) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f4365j, r10.f4365j) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f4366k, r10.f4366k) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4367l, r10.f4367l) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f4368m, r10.f4368m) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f4369n, r10.f4369n) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r5 = this.f4364i;
        int r10 = 0;
        if (r5 == null) goto L5;
        int r11 = r5.hashCode();
    L6:
        int r12 = r11 * 31;
        String r13 = this.f4365j;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f4366k;
        if (r16 == null) goto L13;
        int r17 = r16.hashCode();
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.f4367l;
        if (r19 == null) goto L17;
        int r20 = r19.hashCode();
    L18:
        int r21 = (r18 + r20) * 31;
        String r22 = this.f4368m;
        if (r22 == null) goto L21;
        int r23 = r22.hashCode();
    L22:
        int r24 = (r21 + r23) * 31;
        String r25 = this.f4369n;
        if (r25 == null) goto L26;
        r10 = r25.hashCode();
    L26:
        return r24 + r10;
    L21:
        r23 = 0;
        goto L22
    L17:
        r20 = 0;
        goto L18
    L13:
        r17 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        if (StringsKt.isBlank(this.f4368m) == true) goto L5;
        String r5 = j0.p(new StringBuilder("pipelineError:"), this.f4368m, ' ');
    L7:
        if (StringsKt.isBlank(this.f4364i) == true) goto L10;
        r5 = j0.p(com.lynx.tasm.utils.j.d(r5, "memoryError:"), this.f4364i, ' ');
    L10:
        if (StringsKt.isBlank(this.f4365j) == true) goto L13;
        r5 = j0.p(com.lynx.tasm.utils.j.d(r5, "geckoError:"), this.f4365j, ' ');
    L13:
        if (StringsKt.isBlank(this.f4366k) == true) goto L16;
        r5 = j0.p(com.lynx.tasm.utils.j.d(r5, "builtinError:"), this.f4366k, ' ');
    L16:
        if (StringsKt.isBlank(this.f4367l) == true) goto L19;
        r5 = j0.p(com.lynx.tasm.utils.j.d(r5, "cdnError:"), this.f4367l, ' ');
    L19:
        if (StringsKt.isBlank(this.f4369n) == true) goto L22;
        StringBuilder r10 = com.lynx.tasm.utils.j.d(r5, "postProcessError:");
        r10.append(this.f4369n);
        return r10.toString();
    L22:
        return r5;
    L5:
        r5 = "";
        goto L7
    }
}
