package com.squareup.kotlinpoet;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import javax.lang.model.type.TypeMirror;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f15080a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f15081b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f15082c = null;
    public static final c d = null;
    public static final c e = null;
    public static final c f = null;
    public static final c g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f15083h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f15084i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f15085j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f15086k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f15087l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f15088m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f15089n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f15090o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c f15091p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c f15092q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c f15093r = null;
    public static final c s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final c f15094t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final c f15095u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c f15096v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c f15097w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final c f15098x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final g0 f15099y = null;

    static {
        c r5 = new c("kotlin", new String[]{"Any"});
        f15080a = r5;
        f15081b = new c("kotlin", new String[]{"Array"});
        f15082c = new c("kotlin", new String[]{"Unit"});
        d = new c("kotlin", new String[]{"Boolean"});
        e = new c("kotlin", new String[]{"Byte"});
        f = new c("kotlin", new String[]{"Short"});
        g = new c("kotlin", new String[]{"Int"});
        f15083h = new c("kotlin", new String[]{"Long"});
        f15084i = new c("kotlin", new String[]{"Char"});
        f15085j = new c("kotlin", new String[]{"Float"});
        f15086k = new c("kotlin", new String[]{"Double"});
        f15087l = new c("kotlin", new String[]{"String"});
        f15088m = new c("kotlin", new String[]{"CharSequence"});
        new c("kotlin", new String[]{"Comparable"});
        new c("kotlin", new String[]{"Throwable"});
        new c("kotlin", new String[]{"Annotation"});
        new c("kotlin", new String[]{"Nothing"});
        new c("kotlin", new String[]{"Number"});
        new c("kotlin.collections", new String[]{"Iterable"});
        new c("kotlin.collections", new String[]{"Collection"});
        f15089n = new c("kotlin.collections", new String[]{"List"});
        f15090o = new c("kotlin.collections", new String[]{"Set"});
        c r10 = new c("kotlin.collections", new String[]{"Map"});
        f15091p = r10;
        r10.f("Entry");
        new c("kotlin.collections", new String[]{"MutableIterable"});
        new c("kotlin.collections", new String[]{"MutableCollection"});
        new c("kotlin.collections", new String[]{"MutableList"});
        new c("kotlin.collections", new String[]{"MutableSet"});
        new c("kotlin.collections", new String[]{"MutableMap"}).f("Entry");
        new c("kotlin", new String[]{"BooleanArray"});
        f15092q = new c("kotlin", new String[]{"ByteArray"});
        f15093r = new c("kotlin", new String[]{"CharArray"});
        s = new c("kotlin", new String[]{"ShortArray"});
        f15094t = new c("kotlin", new String[]{"IntArray"});
        f15095u = new c("kotlin", new String[]{"LongArray"});
        f15096v = new c("kotlin", new String[]{"FloatArray"});
        f15097w = new c("kotlin", new String[]{"DoubleArray"});
        f15098x = new c("kotlin", new String[]{"Enum"});
        new c("kotlin", new String[]{"UByte"});
        new c("kotlin", new String[]{"UShort"});
        new c("kotlin", new String[]{"UInt"});
        new c("kotlin", new String[]{"ULong"});
        new c("kotlin", new String[]{"UByteArray"});
        new c("kotlin", new String[]{"UShortArray"});
        new c("kotlin", new String[]{"UIntArray"});
        new c("kotlin", new String[]{"ULongArray"});
        a0 r11 = a0.b(r5, true, null, 2);
        Intrinsics.checkNotNullParameter(r11, "outType");
        f15099y = new g0(CollectionsKt.listOf(r11), CollectionsKt.emptyList());
        int r12 = h.e;
    }

    public static final c a(KClass r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return mh.e.s(r5);
    }

    public static final a0 b(Type r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return z.a(r5, new LinkedHashMap());
    }

    public static final a0 c(TypeMirror r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return z.b(r5, new LinkedHashMap());
    }
}
