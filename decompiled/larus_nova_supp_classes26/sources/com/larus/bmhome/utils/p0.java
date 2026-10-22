package com.larus.bmhome.utils;

import androidx.collection.ArrayMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p0 {
    public final String a;
    public long b;
    public long c;
    public final ArrayMap<String, Integer> d;
    public final ArrayMap<String, Integer> e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public static final class a {
    }

    static {
    }

    public p0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.a = r2;
        this.d = new ArrayMap();
        this.e = new ArrayMap();
        this.f = LazyKt.lazy(new m0());
        this.g = LazyKt.lazy(new n0());
        this.h = LazyKt.lazy(new o0());
        this.i = "CREATE_VH_DEFAULT";
        this.j = "BIND_VH_DEFAULT";
        this.k = "CREATE_VH_COUNT_DEFAULT";
        this.l = "BIND_VH_COUNT_DEFAULT";
    }
}
