package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f15072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f15073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f15074c;

    public a(c r5) {
        Intrinsics.checkNotNullParameter(r5, "typeName");
        this.f15072a = r5;
        this.f15073b = new ArrayList();
        this.f15074c = new LinkedHashMap();
    }

    @Override // com.squareup.kotlinpoet.x
    public final LinkedHashMap c() {
        return this.f15074c;
    }
}
