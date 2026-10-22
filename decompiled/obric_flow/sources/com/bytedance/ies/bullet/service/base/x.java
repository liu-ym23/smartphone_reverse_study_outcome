package com.bytedance.ies.bullet.service.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements com.squareup.kotlinpoet.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6024c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f6025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Serializable f6026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f6027j;

    public x(String r5) {
        Boolean r10 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r5, "eventName");
        this.f6022a = r5;
        this.f6023b = null;
        this.f6024c = null;
        this.e = null;
        this.f = null;
        this.f6026i = r10;
        this.g = null;
        this.f6025h = null;
    }

    @Override // com.squareup.kotlinpoet.x
    public LinkedHashMap c() {
        return (LinkedHashMap) this.f;
    }

    public x(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, "name");
        this.f6022a = r5;
        this.f6023b = r10;
        Set r11 = com.squareup.kotlinpoet.e.f15130c;
        this.d = new com.squareup.kotlinpoet.d();
        this.e = SetsKt.sortedSetOf(new com.squareup.kotlinpoet.l[0]);
        this.f6024c = "  ";
        this.f = new LinkedHashMap();
        this.g = new LinkedHashSet();
        this.f6025h = new ArrayList();
        this.f6026i = new ArrayList();
        this.f6027j = new com.squareup.kotlinpoet.d();
    }
}
