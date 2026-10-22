package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements ju1.h {
    public final String a;
    public final Object b;
    public final List<String> c;
    public final List<String> d;
    public final a0 e;

    @Override // ju1.h
    public final String d() {
        return "ASTRuleStrategy";
    }

    @Override // ju1.h
    public final boolean f() {
        return true;
    }

    @Override // ju1.h
    public final Object a() {
        return this.b;
    }

    @Override // ju1.h
    public final String b() {
        return this.a;
    }

    @Override // ju1.h
    public final List<String> c() {
        return this.d;
    }

    @Override // ju1.h
    public final List<String> e() {
        return this.c;
    }

    public b(a0 r4) {
        Intrinsics.checkNotNullParameter(r4, "rule");
        this.e = r4;
        String r0 = r4.strategyName;
        if (r0 != null) goto L5;
        r0 = "default_strategy_name";
    L5:
        this.a = r0;
        i r1 = r4.defaultResult;
        if (r1 == null) goto L36;
        int r2 = r1.resultType;
        if (r2 != 1) goto L11;
        Object r3 = Long.valueOf(r1.defaultLongValue);
    L35:
        if (r3 == null) goto L36;
    L37:
        this.b = r3;
        List<m> r5 = r4.features;
        if (r5 == null) goto L47;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L41:
        if (r7.hasNext() == false) goto L45;
        String r8 = ((m) r7.next()).name;
        if (r8 == null) goto L41;
        r6.add(r8);
        goto L41
    L45:
        List<String> r9 = CollectionsKt.toList(r6);
        if (r9 == null) goto L47;
    L48:
        this.c = r9;
        this.d = CollectionsKt.emptyList();
        return;
    L47:
        r9 = CollectionsKt.emptyList();
        goto L48
    L11:
        if (r2 != 2) goto L14;
        r3 = Double.valueOf(r1.defaultDoubleValue);
        goto L35
    L14:
        if (r2 != 3) goto L17;
        r3 = r1.defaultStringValue;
        goto L35
    L17:
        if (r2 != 4) goto L20;
        r3 = Boolean.valueOf(r1.defaultBooleanValue);
        goto L35
    L20:
        if (r2 != 5) goto L23;
        r3 = r1.defaultMapValue;
        goto L35
    L23:
        if (r2 != 6) goto L26;
        r3 = r1.defaultLongArrayValue;
        goto L35
    L26:
        if (r2 != 7) goto L29;
        r3 = r1.defaultStringArrayValue;
        goto L35
    L29:
        if (r2 != 8) goto L32;
        r3 = r1.defaultBooleanArrayValue;
        goto L35
    L32:
        if (r2 != 9) goto L34;
        r3 = r1.defaultDoubleArrayValue;
        goto L35
    L34:
        r3 = null;
    L36:
        r3 = 0;
        goto L37
    }
}
