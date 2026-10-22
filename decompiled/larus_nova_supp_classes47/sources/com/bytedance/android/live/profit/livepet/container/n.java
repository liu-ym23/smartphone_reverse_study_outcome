package com.bytedance.android.live.profit.livepet.container;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements a {
    public int a;
    public int b;

    public n() {
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getLeft() {
        return 0;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final a getRoot() {
        return this;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getTop() {
        return 0;
    }

    public final String toString() {
        return "RootRegion(width=" + this.a + ", height=" + this.b + ')';
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getBottom() {
        return this.b;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getRight() {
        return this.a;
    }
}
