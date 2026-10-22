package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f15193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f15194c;
    public final Set d;
    public final a0 e;

    public s(ug.d r5) {
        com.lynx.tasm.p.g(r5);
        this.f15192a = (String) r5.f22357b;
        this.f15193b = ((d) r5.d).d();
        this.f15194c = f0.i((ArrayList) r5.e);
        ArrayList r10 = (ArrayList) r5.f;
        LinkedHashSet r11 = new LinkedHashSet(r10);
        Set r12 = t.f15195a;
        r11.removeAll(r12);
        if (r11.isEmpty() == false) goto L7;
        this.d = f0.j(r10);
        this.e = (a0) r5.f22358c;
        return;
    L7:
        throw new IllegalArgumentException("Modifiers " + r11 + " are not allowed on Kotlin parameters. Allowed modifiers: " + r12);
    }

    public static void a(s r5, f r10, boolean r11, boolean r12, int r13) {
        boolean r14 = true;
        if ((r13 & 2) == 0) goto L6;
        r11 = true;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        if ((r13 & 8) != 0) goto L12;
        r14 = false;
    L12:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "codeWriter");
        if (r12 == false) goto L15;
        r10.n(f0.d(r5.f15193b));
    L15:
        r10.d(r5.f15194c, r14);
        r10.p(r5.d, SetsKt.emptySet());
        String r15 = r5.f15192a;
        if (r15.length() <= 0) goto L19;
        r10.e("%N", new Object[]{r5});
    L19:
        if (r15.length() <= 0) goto L22;
        if (r11 == false) goto L22;
        r10.f(":·");
    L22:
        if (r11 == false) goto L24;
        r10.e("%T", new Object[]{r5.e});
    L24:
        Intrinsics.checkNotNullParameter(r10, "codeWriter");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(s.class, r5.getClass()) == true) goto L12;
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
        a(this, r11, false, false, 14);     // Catch: Throwable -> L6
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
