package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f5987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f5988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CacheType f5989c;

    public f(Uri r5, Uri r10, CacheType r11) {
        Intrinsics.checkNotNullParameter(r5, "originSchema");
        Intrinsics.checkNotNullParameter(r10, "uniqueSchema");
        Intrinsics.checkNotNullParameter(r11, "cacheType");
        this.f5987a = r5;
        this.f5988b = r10;
        this.f5989c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        Uri r11 = r10.f5987a;
        if (Intrinsics.areEqual(this.f5987a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5988b, r10.f5988b) == true) goto L15;
        return false;
    L15:
        if (this.f5989c == r10.f5989c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f5987a.hashCode() * 31;
        int r10 = (this.f5988b.hashCode() + r5) * 31;
        return this.f5989c.hashCode() + r10;
    }

    public final String toString() {
        return "Event(originSchema=" + this.f5987a + ", uniqueSchema=" + this.f5988b + ", cacheType=" + this.f5989c + ')';
    }
}
