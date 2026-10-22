package com.obric.oui.bouncelayout;

import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f12116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f12117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Field f12118c;
    public final Field d;
    public final Field e;

    public e(Field r5, Field r10, Field r11, Field r12, Field r13) {
        this.f12116a = r5;
        this.f12117b = r10;
        this.f12118c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r10 = (e) r5;
        Field r11 = r10.f12116a;
        if (Intrinsics.areEqual(this.f12116a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f12117b, r10.f12117b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f12118c, r10.f12118c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        Field r10 = this.f12116a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Field r13 = this.f12117b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Field r16 = this.f12118c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        Field r19 = this.d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Field r22 = this.e;
        if (r22 == null) goto L23;
        r5 = r22.hashCode();
    L23:
        return r21 + r5;
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReflectionFields(edgeFieldTop=" + this.f12116a + ", edgeFieldBottom=" + this.f12117b + ", scrollerField=" + this.f12118c + ", flingRunnableField=" + this.d + ", flingRunnableScrollerField=" + this.e + ')';
    }
}
