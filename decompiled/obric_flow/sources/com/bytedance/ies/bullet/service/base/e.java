package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f5984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f5985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BulletContainerView f5986c;

    public e(Uri r5, Uri r10, BulletContainerView r11) {
        CacheType r12 = CacheType.f5916a;
        Intrinsics.checkNotNullParameter(r5, "originSchema");
        Intrinsics.checkNotNullParameter(r10, "uniqueSchema");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "cacheType");
        this.f5984a = r5;
        this.f5985b = r10;
        this.f5986c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r10 = (e) r5;
        Uri r11 = r10.f5984a;
        if (Intrinsics.areEqual(this.f5984a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5985b, r10.f5985b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f5986c, r10.f5986c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f5984a.hashCode() * 31;
        int r10 = (this.f5985b.hashCode() + r5) * 31;
        int r11 = (this.f5986c.hashCode() + r10) * 31;
        return CacheType.f5916a.hashCode() + r11;
    }

    public final String toString() {
        return "CacheItem(originSchema=" + this.f5984a + ", uniqueSchema=" + this.f5985b + ", view=" + this.f5986c + ", cacheType=" + CacheType.f5916a + ')';
    }
}
