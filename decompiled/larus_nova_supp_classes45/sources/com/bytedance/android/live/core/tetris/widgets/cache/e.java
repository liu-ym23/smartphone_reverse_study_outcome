package com.bytedance.android.live.core.tetris.widgets.cache;

import kotlin.collections.ArrayDeque;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends h {
    public final ArrayDeque<String> b;

    public e() {
        this(0);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.cache.h
    public final void a() {
        super.a();
        this.b.clear();
    }

    public e(int r1) {
        this.b = new ArrayDeque();
    }
}
