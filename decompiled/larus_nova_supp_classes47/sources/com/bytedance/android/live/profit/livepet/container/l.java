package com.bytedance.android.live.profit.livepet.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements a {
    public int a;
    public int b;
    public int c;
    public int d;
    public final a e;

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getLeft() {
        return this.e.getLeft() + this.a;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final a getRoot() {
        return this.e.getRoot();
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getTop() {
        return this.e.getTop() + this.b;
    }

    public final String toString() {
        return "RectRegion(x=" + this.a + ", y=" + this.b + ", width=" + this.c + ", height=" + this.d + ')';
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getBottom() {
        return getTop() + this.d;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getRight() {
        return getLeft() + this.c;
    }

    public l(a r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        this.e = r2;
    }
}
