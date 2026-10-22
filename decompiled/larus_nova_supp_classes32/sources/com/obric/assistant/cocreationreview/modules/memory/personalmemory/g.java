package com.obric.assistant.cocreationreview.modules.memory.personalmemory;

import com.obric.assistant.cocreationreview.ModuleKey;
import hda.e1;
import hda.f1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g extends com.obric.assistant.cocreationreview.a {
    public final String a;
    public final ModuleKey b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final e1 j;
    public final String k;
    public final String l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((((((r7 + r9) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        String r11 = this.l;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PersonalMemoryUsageRecord(id=" + this.a + ", module=" + this.b + ", visualGroupKey=" + this.c + ", profileChangedAt=" + this.d + ", profileDomain=" + this.e + ", profilePrimaryCategory=" + this.f + ", profileSecondaryCategory=" + this.g + ", profileTitle=" + this.h + ", profileSummary=" + this.i + ", uiModel=" + this.j + ", payload=" + this.k + ", traceJson=" + this.l + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.b;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String c() {
        return this.c;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final com.obric.assistant.cocreationreview.a d(List<? extends com.obric.assistant.cocreationreview.a> r26) {
        Intrinsics.checkNotNullParameter(r26, "records");
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r26.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if ((r3 instanceof g) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        g r6 = (g) r5.next();
        CollectionsKt.addAll(r4, CollectionsKt.plus(CollectionsKt.listOf(r6.j), r6.j.r));
        goto L10
    L12:
        HashSet r7 = new HashSet();
        ArrayList r8 = new ArrayList();
        Iterator r9 = r4.iterator();
    L14:
        if (r9.hasNext() == false) goto L18;
        Object r10 = r9.next();
        if (r7.add(((e1) r10).a) == false) goto L14;
        r8.add(r10);
        goto L14
    L18:
        List<e1> r11 = f1.d(r8);
        if (r11.size() > 1) goto L21;
        return this;
    L21:
        e1 r12 = e1.a(this.j, null, null, null, r11, 917503);
        String r13 = this.a;
        ModuleKey r14 = this.b;
        String r15 = this.c;
        String r16 = this.d;
        String r17 = this.e;
        String r18 = this.f;
        String r19 = this.g;
        String r20 = this.h;
        String r21 = this.i;
        String r22 = this.k;
        String r23 = this.l;
        Intrinsics.checkNotNullParameter(r13, "id");
        Intrinsics.checkNotNullParameter(r14, "module");
        Intrinsics.checkNotNullParameter(r16, "profileChangedAt");
        Intrinsics.checkNotNullParameter(r17, "profileDomain");
        Intrinsics.checkNotNullParameter(r20, "profileTitle");
        Intrinsics.checkNotNullParameter(r21, "profileSummary");
        Intrinsics.checkNotNullParameter(r12, "uiModel");
        Intrinsics.checkNotNullParameter(r22, "payload");
        return new g(r13, r14, r15, r16, r17, r18, r19, r20, r21, r12, r22, r23);
    }

    public g(String r2, ModuleKey r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, e1 r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r5, "profileChangedAt");
        Intrinsics.checkNotNullParameter(r6, "profileDomain");
        Intrinsics.checkNotNullParameter(r9, "profileTitle");
        Intrinsics.checkNotNullParameter(r10, "profileSummary");
        Intrinsics.checkNotNullParameter(r11, "uiModel");
        Intrinsics.checkNotNullParameter(r12, "payload");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
