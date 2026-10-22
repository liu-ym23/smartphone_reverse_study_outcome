package com.ss.android.lark.forseti.global;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements yua.a {
    public final List<yua.c> a;
    public final yua.c b;
    public final yua.c c;

    public final List<yua.c> a() {
        return this.a;
    }

    public final yua.c b() {
        return this.c;
    }

    public d(List<? extends yua.c> r2, yua.c r3) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
        this.a = r2;
        this.b = r3;
        this.c = r3;
    }
}
