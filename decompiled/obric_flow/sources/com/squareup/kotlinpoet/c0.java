package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.lang.model.element.Element;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements x, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeSpec$Kind f15100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f15102c;
    public a0 d;
    public final d e;
    public final int f;
    public final LinkedHashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f15103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set f15104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f15105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f15106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f15107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f15108m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f15109n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f15110o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f15111p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f15112q;

    public c0(TypeSpec$Kind r5, String r10, KModifier... r11) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r11, "modifiers");
        this.f15100a = r5;
        this.f15101b = r10;
        Set r12 = e.f15130c;
        this.f15102c = new d();
        this.d = b0.f15080a;
        this.e = new d();
        this.f = -1;
        this.g = new LinkedHashMap();
        this.f15103h = new ArrayList();
        this.f15104i = SetsKt.mutableSetOf(Arrays.copyOf(r11, r11.length));
        this.f15105j = new LinkedHashMap();
        this.f15106k = new LinkedHashMap();
        this.f15107l = new ArrayList();
        this.f15108m = new ArrayList();
        this.f15109n = new ArrayList();
        this.f15110o = new ArrayList();
        this.f15111p = new ArrayList();
        this.f15112q = new ArrayList();
    }

    @Override // com.squareup.kotlinpoet.q
    public final ArrayList a() {
        return this.f15103h;
    }

    @Override // com.squareup.kotlinpoet.q
    public final q b(Element r5) {
        com.lynx.jsbridge.a.o(this, r5);
        return this;
    }

    @Override // com.squareup.kotlinpoet.x
    public final LinkedHashMap c() {
        return this.g;
    }

    public final void d() {
        if (h() == true) goto L10;
        TypeSpec$Kind r5 = TypeSpec$Kind.OBJECT;
        TypeSpec$Kind r10 = this.f15100a;
        if (r10 == r5) goto L10;
        throw new IllegalStateException(("only classes can have super classes, not " + r10).toString());
    L10:
        if (g() == true) goto L13;
        return;
    L13:
        throw new IllegalStateException("value/inline classes cannot have super classes");
    }

    public final boolean e() {
        if (this.f15100a == TypeSpec$Kind.CLASS) goto L5;
    L7:
        return false;
    L5:
        if (this.f15104i.contains(KModifier.ANNOTATION) == false) goto L7;
        return true;
    }

    public final boolean f() {
        if (this.f15100a == TypeSpec$Kind.CLASS) goto L5;
    L7:
        return false;
    L5:
        if (this.f15104i.contains(KModifier.ENUM) == false) goto L7;
        return true;
    }

    public final boolean g() {
        if (this.f15100a != TypeSpec$Kind.CLASS) goto L9;
        KModifier r5 = KModifier.INLINE;
        Set r10 = this.f15104i;
        if (r10.contains(r5) == false) goto L7;
    L8:
        return true;
    L7:
        if (r10.contains(KModifier.VALUE) == true) goto L8;
    L9:
        return false;
    }

    public final boolean h() {
        if (this.f15100a == TypeSpec$Kind.CLASS) goto L5;
    L9:
        return false;
    L5:
        if (f() == true) goto L9;
        if (e() == true) goto L9;
        return true;
    }
}
