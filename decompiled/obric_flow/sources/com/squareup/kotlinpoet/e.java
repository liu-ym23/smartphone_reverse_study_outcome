package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f15130c = null;
    public static final e d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f15131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f15132b;

    static {
        new Regex("%([\\w_]+):([\\w]).*");
        new Regex("[a-z]+[\\w_]*");
        f15130c = SetsKt.setOf(new String[]{"⇥", "⇤", "«", "»"});
        d = new e(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public e(List r5, List r10) {
        this.f15131a = r5;
        this.f15132b = r10;
    }

    public final boolean a() {
        return !this.f15131a.isEmpty();
    }

    public final d b() {
        d r5 = new d();
        CollectionsKt.a(r5.f15113a, this.f15131a);
        r5.f15114b.addAll(this.f15132b);
        return r5;
    }

    public final e c() {
        List r5 = this.f15131a;
        int r10 = r5.size();
        int r11 = 0;
    L3:
        Set r12 = f15130c;
        if (r11 >= r10) goto L8;
        if (r12.contains(r5.get(r11)) == false) goto L8;
        r11 = r11 + 1;
    L8:
        if (r11 >= r10) goto L12;
        if (r12.contains(r5.get(r10 - 1)) == false) goto L12;
        r10 = r10 - 1;
    L12:
        if (r11 > 0) goto L16;
        if (r10 < r5.size()) goto L16;
        return this;
    L16:
        return new e(r5.subList(r11, r10), this.f15132b);
    }

    public final e d(e r12) {
        Intrinsics.checkNotNullParameter(r12, "prefix");
        List r5 = this.f15131a;
        if (r5.size() >= r12.f15131a.size()) goto L5;
        return null;
    L5:
        List r11 = this.f15132b;
        int r10 = r11.size();
        List r13 = r12.f15132b;
        if (r10 >= r13.size()) goto L8;
        return null;
    L8:
        List r14 = r12.f15131a;
        Iterator r15 = r14.iterator();
        int r16 = 0;
        String r17 = null;
        int r18 = 0;
    L10:
        if (r15.hasNext() == false) goto L32;
        Object r19 = r15.next();
        int r20 = r16 + 1;
        if (r16 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        String r21 = (String) r19;
        if (Intrinsics.areEqual(r5.get(r16), r21) == true) goto L23;
        if (r16 != (r14.size() - 1)) goto L21;
        if (StringsKt.P((String) r5.get(r16), r21) == false) goto L21;
        r17 = ((String) r5.get(r16)).substring(r21.length());
    L21:
        return null;
    L23:
        if (StringsKt.P(r21, "%") == false) goto L31;
        if (r21.charAt(1) == '%') goto L31;
        if (Intrinsics.areEqual(r11.get(r18), r13.get(r18)) == false) goto L29;
        r18 = r18 + 1;
        goto L31
    L29:
        return null;
    L31:
        r16 = r20;
        goto L10
    L32:
        ArrayList r22 = new ArrayList();
        if (r17 == null) goto L35;
        r22.add(r17);
    L35:
        int r110 = r14.size();
        int r23 = r5.size();
    L36:
        if (r110 >= r23) goto L38;
        r22.add(r5.get(r110));
        r110 = r110 + 1;
        goto L36
    L38:
        ArrayList r111 = new ArrayList();
        int r24 = r13.size();
        int r25 = r11.size();
    L39:
        if (r24 >= r25) goto L42;
        r111.add(r11.get(r24));
        r24 = r24 + 1;
        goto L39
    L42:
        return new e(r22, r111);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(e.class, r5.getClass()) == true) goto L12;
        return false;
    L12:
        return Intrinsics.areEqual(toString(), r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder r10 = new StringBuilder();
        f r11 = new f(r10, null, null, null, null, Integer.MAX_VALUE, 30);
        f.g(r11, this, false, false, 6);     // Catch: Throwable -> L6
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r11, null);
        return r10.toString();
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }
}
