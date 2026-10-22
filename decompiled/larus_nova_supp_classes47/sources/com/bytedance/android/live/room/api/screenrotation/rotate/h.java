package com.bytedance.android.live.room.api.screenrotation.rotate;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class h<T> {
    public final String a;
    public final i b;
    public final T c;

    public h(f r2, String r3, i r4, T r5) {
        Intrinsics.checkNotNullParameter(r2, "orientation");
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "rotateType");
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
