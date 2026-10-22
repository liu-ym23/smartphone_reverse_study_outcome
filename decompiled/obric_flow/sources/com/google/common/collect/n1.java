package com.google.common.collect;

import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collector f9084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Collector f9085b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Collector f9086c = null;

    static {
        f9084a = Collector.of(new i1(3), new f1(0), new e1(2), new h(5), new Collector.Characteristics[0]);
        f9085b = Collector.of(new i1(4), new f1(1), new e1(3), new h(6), new Collector.Characteristics[0]);
        f9086c = Collector.of(new i1(5), new f1(2), new e1(1), new h(4), new Collector.Characteristics[0]);
    }

    public static Collector a(Function r5, ToIntFunction r10) {
        r5.getClass();
        r10.getClass();
        return Collector.of(new i1(6), new j1(0, r5, r10), new e1(5), new h(8), new Collector.Characteristics[0]);
    }
}
