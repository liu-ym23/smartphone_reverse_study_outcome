package com.bytedance.android.livesdk.dsl.recyclerview;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import yt1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements f {
    public final HashMap<Integer, o> a;

    public d() {
        this.a = new HashMap();
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.f
    public final o a(int r2) {
        return this.a.get(Integer.valueOf(r2));
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.f
    public final void b(int r2, o r3) {
        Intrinsics.checkNotNullParameter(r3, "element");
        this.a.put(Integer.valueOf(r2), r3);
    }
}
