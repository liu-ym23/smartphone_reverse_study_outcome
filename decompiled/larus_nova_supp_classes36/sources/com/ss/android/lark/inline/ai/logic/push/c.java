package com.ss.android.lark.inline.ai.logic.push;

import androidx.collection.LruCache;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b.C0107b a;
    public final /* synthetic */ String b;

    public c(b.C0107b r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        obb.b r4 = (obb.b) r3;
        LruCache<String, obb.b> r0 = this.a.b;
        String r1 = this.b;
        Intrinsics.checkNotNull(r4);
        r0.put(r1, r4);
        this.a.a(this.b, r4);
    }
}
