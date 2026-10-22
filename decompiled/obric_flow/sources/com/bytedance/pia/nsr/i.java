package com.bytedance.pia.nsr;

import java.util.Iterator;
import java.util.TreeSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TreeSet f7196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f7197c;
    public String d;

    public i(String r5, TreeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "fullPath");
        Intrinsics.checkNotNullParameter(r10, "queries");
        this.f7195a = r5;
        this.f7196b = r10;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof String) == false) goto L7;
        return equals(com.lynx.tasm.base.a.c((String) r5));
    L7:
        if ((r5 instanceof i) == true) goto L9;
        return false;
    L9:
        if (hashCode() != r5.hashCode()) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        if (this.f7197c != null) goto L9;
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f7195a);
        TreeSet r10 = this.f7196b;
        CollectionsKt.toSortedSet(r10);
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r5.append((String) r11.next());
        goto L6
    L8:
        this.f7197c = Integer.valueOf(r5.toString().hashCode());
    L9:
        Integer r12 = this.f7197c;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Int");
        return r12.intValue();
    }

    public final String toString() {
        if (this.d != null) goto L18;
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f7195a);
        TreeSet r10 = this.f7196b;
        if (r10.isEmpty() == true) goto L7;
        r5.append('?');
    L7:
        CollectionsKt.toSortedSet(r10);
        Iterator r11 = r10.iterator();
        int r12 = 0;
    L9:
        if (r11.hasNext() == false) goto L17;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        r5.append((String) r13);
        if (r12 >= (r10.size() - 1)) goto L16;
        r5.append(Typography.amp);
    L16:
        r12 = r14;
        goto L9
    L17:
        this.d = r5.toString();
    L18:
        String r15 = this.d;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.String");
        return r15;
    }
}
