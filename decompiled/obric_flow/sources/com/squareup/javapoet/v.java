package com.squareup.javapoet;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends x {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final v f15020w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final e f15021x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f15022y;

    public v(e r5, List r10) {
        this(null, r5, r10, new ArrayList());
    }

    public static v n(e r5, x... r10) {
        return new v(r5, Arrays.asList(r10));
    }

    public static v o(ParameterizedType r5, LinkedHashMap r10) {
        e r11 = e.n((Class) r5.getRawType());
        if ((r5.getOwnerType() instanceof ParameterizedType) == true) goto L5;
    L7:
        ParameterizedType r12 = null;
    L8:
        ArrayList r13 = x.l(r5.getActualTypeArguments(), r10);
        if (r12 == null) goto L12;
        v r14 = o(r12, r10);
        String r15 = r11.f14961y;
        com.bytedance.android.anniex.base.service.f.s(r15, "name == null", new Object[0]);
        e r16 = r14.f15021x;
        return new v(r14, new e(r16.f14959w, r16, r15), r13, new ArrayList());
    L12:
        return new v(r11, r13);
    L5:
        if (Modifier.isStatic(((Class) r5.getRawType()).getModifiers()) == true) goto L7;
        r12 = (ParameterizedType) r5.getOwnerType();
        goto L8
    }

    @Override // com.squareup.javapoet.x
    public final k c(k r5) {
        e r10 = this.f15021x;
        v r11 = this.f15020w;
        if (r11 == null) goto L8;
        r11.c(r5);
        r5.e(".");
        if (i() == false) goto L7;
        r5.e(" ");
        d(r5);
    L7:
        r5.e(r10.f14961y);
    L9:
        List r12 = this.f15022y;
        if (r12.isEmpty() == true) goto L19;
        r5.e("<");
        Iterator r13 = r12.iterator();
        boolean r14 = true;
    L13:
        if (r13.hasNext() == false) goto L18;
        x r15 = (x) r13.next();
        if (r14 == true) goto L17;
        r5.e(", ");
    L17:
        r15.c(r5);
        r14 = false;
        goto L13
    L18:
        r5.e(">");
    L19:
        return r5;
    L8:
        r10.c(r5);
        goto L9
    }

    public v(v r10, e r11, List r12, ArrayList r13) {
        super(null, r13);
        com.bytedance.android.anniex.base.service.f.s(r11, "rawType == null", new Object[0]);
        ArrayList r5 = new ArrayList(r11.f15038b);
        r5.addAll(r13);
        this.f15021x = new e(r11.f14959w, r11.f14960x, r11.f14961y, r5);
        this.f15020w = r10;
        List r14 = com.bytedance.android.anniex.base.service.f.x(r12);
        this.f15022y = r14;
        if (r14.isEmpty() == false) goto L7;
        if (r10 != null) goto L7;
        boolean r15 = false;
    L8:
        com.bytedance.android.anniex.base.service.f.r(r15, "no type arguments: %s", new Object[]{r11});
        Iterator r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L18;
        x r17 = (x) r16.next();
        if (r17.k() == false) goto L14;
    L16:
        boolean r18 = false;
    L17:
        com.bytedance.android.anniex.base.service.f.r(r18, "invalid type parameter: %s", new Object[]{r17});
        goto L10
    L14:
        if (r17 == x.d) goto L16;
        r18 = true;
        goto L17
    L18:
        return;
    L7:
        r15 = true;
        goto L8
    }
}
