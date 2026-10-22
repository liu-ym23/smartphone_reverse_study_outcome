package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.profile.ui.base.ComponentType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> a;
    public final Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> b;
    public final List<com.bytedance.android.live.profile.ui.base.g> c;
    public final Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> d;

    public e() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L14;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<com.bytedance.android.live.profile.ui.base.g> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("CompareResult(\nresult=");
        r0.append(a(this.a));
        r0.append(", \nadd=");
        r0.append(a(this.b));
        r0.append(", \nremove=");
        List<com.bytedance.android.live.profile.ui.base.g> r1 = this.c;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        com.bytedance.android.live.profile.ui.base.g r4 = (com.bytedance.android.live.profile.ui.base.g) r3.next();
        r2.add(r4.getComponentType().getClass().getSimpleName() + "@" + r4.hashCode());
        goto L4
    L6:
        r0.append(r2);
        r0.append(", \nupdate=");
        r0.append(a(this.d));
        return r0.toString();
    }

    public e(Object r5) {
        LinkedHashMap r6 = new LinkedHashMap();
        LinkedHashMap r0 = new LinkedHashMap();
        ArrayList r1 = new ArrayList();
        LinkedHashMap r2 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r6, "result");
        Intrinsics.checkNotNullParameter(r0, "add");
        Intrinsics.checkNotNullParameter(r1, "remove");
        Intrinsics.checkNotNullParameter(r2, "update");
        this.a = r6;
        this.b = r0;
        this.c = r1;
        this.d = r2;
    }

    public static String a(Map r6) {
        Iterator r7 = r6.entrySet().iterator();
        String r0 = "{";
    L4:
        if (r7.hasNext() == false) goto L20;
        Map.Entry r1 = (Map.Entry) r7.next();
        String r2 = r0 + ((com.bytedance.android.live.profile.ui.base.g) r1.getKey()).getComponentType().getClass().getSimpleName() + "@" + r1.getKey().hashCode() + "=";
        StringBuilder r3 = new StringBuilder();
        r3.append(r2);
        if (r1.getValue() == null) goto L17;
        StringBuilder r4 = new StringBuilder();
        com.bytedance.android.live.profile.ui.base.f r5 = (com.bytedance.android.live.profile.ui.base.f) r1.getValue();
        Integer r8 = null;
        if (r5 == null) goto L12;
        ComponentType r9 = r5.getComponentType();
        if (r9 == null) goto L12;
        String r10 = r9.getClass().getSimpleName();
    L13:
        r4.append(r10);
        r4.append("@");
        com.bytedance.android.live.profile.ui.base.f r12 = (com.bytedance.android.live.profile.ui.base.f) r1.getValue();
        if (r12 == null) goto L16;
        r8 = Integer.valueOf(r12.hashCode());
    L16:
        r4.append(r8);
        String r13 = r4.toString();
    L18:
        r3.append(r13);
        r0 = r3.toString() + ",";
    L12:
        r10 = null;
        goto L13
    L17:
        r13 = "null";
        goto L18
    L20:
        return r0 + "}";
    }
}
