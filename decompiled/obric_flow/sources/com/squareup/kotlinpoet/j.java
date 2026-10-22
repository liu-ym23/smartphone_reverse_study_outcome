package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements x, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f15159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f15160c;
    public final e d;
    public final ArrayList e;
    public a0 f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f15161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f15162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f15163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f15164k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f15165l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f15166m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashMap f15167n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f15168o;

    public j(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.f15158a = r5;
        Set r10 = e.f15130c;
        this.f15159b = new d();
        e r11 = e.d;
        this.f15160c = r11;
        this.d = r11;
        this.e = new ArrayList();
        this.f15161h = CollectionsKt.emptyList();
        this.f15162i = new d();
        this.f15163j = new ArrayList();
        this.f15164k = new ArrayList();
        this.f15165l = new ArrayList();
        this.f15166m = new ArrayList();
        this.f15167n = new LinkedHashMap();
        this.f15168o = new ArrayList();
    }

    @Override // com.squareup.kotlinpoet.q
    public final ArrayList a() {
        return this.f15168o;
    }

    @Override // com.squareup.kotlinpoet.q
    public final q b(Element r5) {
        com.lynx.jsbridge.a.o(this, r5);
        return this;
    }

    @Override // com.squareup.kotlinpoet.x
    public final LinkedHashMap c() {
        return this.f15167n;
    }
}
