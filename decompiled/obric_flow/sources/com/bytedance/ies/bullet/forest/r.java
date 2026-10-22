package com.bytedance.ies.bullet.forest;

import ai.j0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f5416c;
    public final String d;

    public r(String r5, ArrayList r10) {
        Intrinsics.checkNotNullParameter(r10, "chunks");
        Intrinsics.checkNotNullParameter(r5, "hydrateUrl");
        this.f5414a = r10;
        this.f5415b = r5;
        Iterator r11 = r10.iterator();
    L3:
        Object r12 = null;
        if (r11.hasNext() == false) goto L8;
        Object r13 = r11.next();
        if (((s) r13).f5417a != 1) goto L3;
    L9:
        s r14 = (s) r13;
        if (r14 == null) goto L30;
        this.f5416c = r14.f5418b;
        Iterator r15 = this.f5414a.iterator();
    L13:
        if (r15.hasNext() == false) goto L17;
        Object r16 = r15.next();
        if (((s) r16).f5417a != 2) goto L13;
        r12 = r16;
    L17:
        s r17 = (s) r12;
        if (r17 == null) goto L24;
        String r18 = StringsKt.decodeToString(r17.f5418b);
        if (r18 == null) goto L24;
        this.d = r18;
        return;
    L24:
        StringBuilder r19 = new StringBuilder("can not find chunk type 2, all types:");
        ArrayList r20 = this.f5414a;
        ArrayList r21 = new ArrayList(CollectionsKt.h(r20));
        Iterator r22 = r20.iterator();
    L26:
        if (r22.hasNext() == false) goto L28;
        r21.add(Integer.valueOf(((s) r22.next()).f5417a));
        goto L26
    L28:
        r19.append(r21);
        throw new IllegalStateException(r19.toString());
    L30:
        StringBuilder r23 = new StringBuilder("can not find chunk type 1, all types:");
        ArrayList r24 = this.f5414a;
        ArrayList r25 = new ArrayList(CollectionsKt.h(r24));
        Iterator r26 = r24.iterator();
    L32:
        if (r26.hasNext() == false) goto L34;
        r25.add(Integer.valueOf(((s) r26.next()).f5417a));
        goto L32
    L34:
        r23.append(r25);
        throw new IllegalStateException(r23.toString());
    L8:
        r13 = null;
        goto L9
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r10 = (r) r5;
        ArrayList r11 = r10.f5414a;
        if (Intrinsics.areEqual(this.f5414a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5415b, r10.f5415b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f5414a.hashCode() * 31;
        return this.f5415b.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("LynxSSRData(chunks=");
        r5.append(this.f5414a);
        r5.append(", hydrateUrl=");
        return j0.p(r5, this.f5415b, ')');
    }
}
