package com.bytedance.forest.utils;

import ai.j0;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4604c;

    public a(String r5, String r10, String r11) {
        this.f4602a = r5;
        this.f4603b = r10;
        this.f4604c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r10 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(a.class, r10) == true) goto L11;
        return false;
    L11:
        if (r5 == null) goto L23;
        a r11 = (a) r5;
        if (Intrinsics.areEqual(this.f4602a, r11.f4602a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f4603b, r11.f4603b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f4604c, r11.f4604c) == true) goto L21;
        return false;
    L21:
        return true;
    L23:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.utils.CacheIdentifier");
    L7:
        r10 = null;
        goto L9
    }

    public final int hashCode() {
        int r5 = this.f4602a.hashCode() * 31;
        int r10 = kk.a.b(this.f4603b, r5, 31);
        return this.f4604c.hashCode() + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("CacheIdentifier(baseUrl='");
        r5.append(this.f4602a);
        r5.append("', queryString='");
        r5.append(this.f4603b);
        r5.append("', userAgent='");
        return j0.q(r5, this.f4604c, "')");
    }
}
