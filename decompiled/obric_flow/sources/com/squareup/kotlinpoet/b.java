package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f15078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f15079b;

    public b(a r5) {
        com.lynx.tasm.p.g(r5);
        this.f15078a = r5.f15072a;
        this.f15079b = f0.i(r5.f15073b);
    }

    public final void a(f r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "codeWriter");
        if (r15 == true) goto L5;
        r13.b("@", false);
    L5:
        r13.e("%T", new Object[]{this.f15078a});
        List r12 = this.f15079b;
        if (r12.isEmpty() == false) goto L10;
        if (r15 == true) goto L10;
        return;
    L10:
        if (r14 == false) goto L12;
        String r5 = "";
    L13:
        if (r14 == false) goto L15;
        String r10 = ", ";
    L17:
        if (r14 == false) goto L19;
    L21:
        String r11 = "";
    L22:
        r13.b("(", false);
        if (r12.size() <= 1) goto L25;
        r13.b(r5, false);
        r13.f++;
    L25:
        ArrayList r16 = new ArrayList(CollectionsKt.h(r12));
        Iterator r17 = r12.iterator();
    L27:
        if (r17.hasNext() == false) goto L36;
        e r18 = (e) r17.next();
        if (r14 == false) goto L35;
        r18.getClass();
        Intrinsics.checkNotNullParameter("[⇥|⇤]", "oldValue");
        Intrinsics.checkNotNullParameter("", "newValue");
        List r19 = r18.f15131a;
        ArrayList r20 = new ArrayList(CollectionsKt.h(r19));
        Iterator r110 = r19.iterator();
    L32:
        if (r110.hasNext() == false) goto L34;
        r20.add(StringsKt.F((String) r110.next(), "[⇥|⇤]", ""));
        goto L32
    L34:
        r18 = new e(r20, r18.f15132b);
    L35:
        r16.add(r18);
        goto L27
    L36:
        f.g(r13, com.bytedance.ies.bullet.base.utils.b.q(r16, r10, null, r11, 2), true, false, 4);
        if (r12.size() <= 1) goto L39;
        r13.K(1);
        r13.b(r5, false);
    L39:
        r13.b(")", false);
        return;
    L19:
        if (r12.size() <= 1) goto L21;
        r11 = ",";
        goto L22
    L15:
        r10 = ",\n";
        goto L17
    L12:
        r5 = "\n";
        goto L13
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(b.class, r5.getClass()) == true) goto L12;
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
        a(r11, true, false);     // Catch: Throwable -> L6
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
