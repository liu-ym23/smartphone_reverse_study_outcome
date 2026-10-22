package com.bytedance.android.live.effect.composer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p {
    public Float a;
    public final String b;

    public final String toString() {
        return "LiveComposerTagNode(tag='" + this.b + "', value=" + this.a;
    }

    public final Float a() {
        return this.a;
    }

    public p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.b = r2;
    }
}
