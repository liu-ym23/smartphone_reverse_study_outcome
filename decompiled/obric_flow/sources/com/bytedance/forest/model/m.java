package com.bytedance.forest.model;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4391c;

    public m(String r5, String r10, String r11) {
        this.f4389a = r5;
        this.f4390b = r10;
        this.f4391c = r11;
    }

    public final boolean a() {
        if (StringsKt.isBlank(this.f4390b) == false) goto L5;
        return true;
    L5:
        if (StringsKt.isBlank(this.f4391c) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r10 = (m) r5;
        if (Intrinsics.areEqual(this.f4389a, r10.f4389a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4390b, r10.f4390b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f4391c, r10.f4391c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f4389a.hashCode() * 31;
        int r10 = kk.a.b(this.f4390b, r5, 31);
        return this.f4391c.hashCode() + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("GeckoModel(accessKey=");
        r5.append(this.f4389a);
        r5.append(", channel=");
        r5.append(this.f4390b);
        r5.append(", bundle=");
        return j0.q(r5, this.f4391c, ")");
    }
}
