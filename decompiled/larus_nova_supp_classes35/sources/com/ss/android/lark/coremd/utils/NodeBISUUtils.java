package com.ss.android.lark.coremd.utils;

import android.text.Spanned;
import com.ss.android.lark.coremd.ext.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import v7b.b0;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NodeBISUUtils implements com.ss.android.lark.coremd.ext.f {
    public static final NodeBISUUtils c = null;
    public static final /* synthetic */ KProperty<Object>[] d = null;
    public static final com.ss.android.lark.coremd.ext.c e = null;

    static {
        KProperty<Object>[] r0 = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(NodeBISUUtils.class, "bisuFlags", "getBisuFlags(Lcom/ss/android/lark/commonmark/node/Node;)I", 0))};
        d = r0;
        NodeBISUUtils r1 = new NodeBISUUtils();
        c = r1;
        final int r2 = 0;
        Function1<j, Integer> r3 = new NodeBISUUtils$special$$inlined$extend$1(r2);
        Intrinsics.checkNotNullParameter(r3, "defaultProvider");
        KProperty<Object> r4 = r0[0];
        Intrinsics.checkNotNullParameter(r1, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r5 = com.ss.android.lark.coremd.ext.d.a;
        Intrinsics.checkNotNullParameter(r4, "kProperty");
        Intrinsics.checkNotNullParameter(r3, "value");
        com.ss.android.lark.coremd.ext.d.a.put(com.ss.android.lark.coremd.ext.e.a(r4), r3);
        e = new com.ss.android.lark.coremd.ext.c();
    }

    public NodeBISUUtils() {
    }

    public static void b(s r3, int r4) {
        e.setValue(r3, d[0], Integer.valueOf(r4));
    }

    public static List a(int r10, CharSequence r11, char[] r12) {
        boolean r1 = false;
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if ((r11 instanceof Spanned) == false) goto L12;
        ArrayList r2 = new ArrayList();
        StringBuilder r3 = new StringBuilder();
        int r4 = r11.length();
        int r5 = 0;
        int r6 = 0;
    L14:
        if (r5 >= r4) goto L20;
        int r8 = r6 + r10;
        if (r12[r5 + r10] == r12[r8]) goto L18;
        b0 r7 = new b0(r3.toString());
        b(r7, r12[r8]);
        r2.add(r7);
        StringsKt.clear(r3);
        r6 = r5;
    L18:
        r3.append(r11.charAt(r5));
        r5 = r5 + 1;
        goto L14
    L20:
        if (r3.length() <= 0) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L24;
        b0 r13 = new b0(r3.toString());
        b(r13, r12[r6 + r10]);
        r2.add(r13);
    L24:
        return r2;
    L12:
        return CollectionsKt.listOf(new b0(r11.toString()));
    L5:
        r0 = false;
        goto L6
    }
}
