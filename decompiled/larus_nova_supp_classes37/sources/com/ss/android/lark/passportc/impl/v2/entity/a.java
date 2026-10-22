package com.ss.android.lark.passportc.impl.v2.entity;

import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final int a;
    public final BehaviorSubject<c> b;
    public final com.ss.android.lark.passportc.api.d c;
    public final lzb.a d;
    public final List<BehaviorSubject<c>> e;
    public final List<b> f;
    public final List<b> g;

    public a() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "{reqId:" + this.a + ", foreground:\n  " + CollectionsKt.joinToString$default(this.f, "\n", null, null, 0, null, null, 62, null) + "\nbackground: [\n  " + CollectionsKt.joinToString$default(this.g, "\n  ", null, null, 0, null, null, 62, null) + "\n]}";
    }

    public a(int r4, BehaviorSubject r5, com.ss.android.lark.passportc.api.d r6, lzb.a r7, List r8) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Intrinsics.checkNotNullParameter(r5, "subject");
        Intrinsics.checkNotNullParameter(r6, "executeMode");
        Intrinsics.checkNotNullParameter(r7, "actionContext");
        Intrinsics.checkNotNullParameter(r8, "mergedSubject");
        Intrinsics.checkNotNullParameter(r0, "foregroundTransitions");
        Intrinsics.checkNotNullParameter(r1, "backgroundTransitions");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r0;
        this.g = r1;
    }
}
