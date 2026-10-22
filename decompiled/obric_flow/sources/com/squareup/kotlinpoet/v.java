package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.lang.model.element.Element;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements x, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f15197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15198c;
    public final d d;
    public e e;
    public final ArrayList f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f15199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f15200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f15201j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f15202k;

    public v(String r5, a0 r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        this.f15196a = r5;
        this.f15197b = r10;
        Set r11 = e.f15130c;
        this.d = new d();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.f15199h = new ArrayList();
        this.f15200i = new ArrayList();
        this.f15201j = new LinkedHashMap();
        this.f15202k = new ArrayList();
    }

    @Override // com.squareup.kotlinpoet.q
    public final ArrayList a() {
        return this.f15202k;
    }

    @Override // com.squareup.kotlinpoet.q
    public final q b(Element r5) {
        com.lynx.jsbridge.a.o(this, r5);
        return this;
    }

    @Override // com.squareup.kotlinpoet.x
    public final LinkedHashMap c() {
        return this.f15201j;
    }
}
