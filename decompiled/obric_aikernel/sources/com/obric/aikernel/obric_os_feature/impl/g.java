package com.obric.aikernel.obric_os_feature.impl;

import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f4748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4751e;

    public g(String r10, Object r11, int r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        this.f4747a = r10;
        this.f4748b = r11;
        this.f4749c = r12;
        this.f4750d = r13;
        this.f4751e = r14;
    }

    public /* synthetic */ g(String r10, Object r11, int r12, String r13, String r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 4) == 0) goto L5;
        r12 = AppContext.INSTANCE.getPid();
    L5:
        int r17 = r12;
        if ((r15 & 8) == 0) goto L8;
        String r18 = null;
    L10:
        if ((r15 & 16) == 0) goto L12;
        String r19 = null;
    L13:
        this(r10, r11, r17, r18, r19);
        return;
    L12:
        r19 = r14;
        goto L13
    L8:
        r18 = r13;
        goto L10
    }

    public final String a() {
        return this.f4747a;
    }

    public final int b() {
        return this.f4749c;
    }

    public final String c() {
        return this.f4750d;
    }

    public final String d() {
        return this.f4751e;
    }

    public final Object e() {
        return this.f4748b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (Intrinsics.areEqual(this.f4747a, r11.f4747a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4748b, r11.f4748b) == true) goto L15;
        return false;
    L15:
        if (this.f4749c == r11.f4749c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f4750d, r11.f4750d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f4751e, r11.f4751e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r10 = ((((this.f4747a.hashCode() * 31) + this.f4748b.hashCode()) * 31) + Integer.hashCode(this.f4749c)) * 31;
        String r11 = this.f4750d;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.f4751e;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public String toString() {
        return "ReportParam(key=" + this.f4747a + ", value=" + this.f4748b + ", pid=" + this.f4749c + ", threadNames=" + this.f4750d + ", tids=" + this.f4751e + ')';
    }
}
