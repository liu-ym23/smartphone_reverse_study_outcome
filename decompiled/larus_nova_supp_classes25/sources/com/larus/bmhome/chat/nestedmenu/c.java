package com.larus.bmhome.chat.nestedmenu;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.t0;
import di8.d0;
import di8.f0;
import di8.n0;
import di8.p0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public final NestedMenuScene a;
    public final String b;
    public final LinkedHashMap<String, List<d0>> c;
    public final d0 d;
    public final Integer e;
    public ReplyOption f;
    public String g;

    public c() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        Integer r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ReplyOption r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.g;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "NestedMenuClickResult(scene=" + this.a + ", sectionName=" + this.b + ", sections=" + this.c + ", model=" + this.d + ", legacyMenuId=" + this.e + ", queryOption=" + this.f + ", conversationForkTaskParam=" + this.g + ')';
    }

    public final b a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sectionName");
        ReplyOption r0 = this.f;
        if (r0 != null) goto L5;
        return null;
    L5:
        List<d0> r2 = this.c.get(r4);
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        d0 r5 = b(r4, r0, r2);
        if (r5 == null) goto L21;
        f0 r6 = r5.c();
        if (r6 != null) goto L13;
        return null;
    L13:
        if ((r6 instanceof b) == false) goto L17;
        b r7 = (b) r6;
    L23:
        return r7;
    L17:
        if ((r6 instanceof p0) == false) goto L24;
        f0 r8 = ((p0) r6).a;
        if ((r8 instanceof b) == false) goto L25;
        r7 = (b) r8;
        goto L23
    L25:
        return null;
    L24:
        return null;
    L21:
        return null;
    }

    public static final d0 b(String r4, ReplyOption r5, List<? extends d0> r6) {
        Iterator<T> r7 = r6.iterator();
    L3:
        ModelItemIdentity r1 = null;
        if (r7.hasNext() == false) goto L44;
        d0 r0 = (d0) r7.next();
        f0 r2 = r0.c();
        if ((r2 instanceof b) == false) goto L9;
        b r3 = (b) r2;
    L15:
        if (Intrinsics.areEqual(r4, "mode") == false) goto L24;
        if (r3 == null) goto L22;
        b.a r8 = r3.c;
        if (r8 == null) goto L22;
        t0 r9 = r8.a;
        if (r9 == null) goto L22;
        r1 = r9.a;
    L22:
        boolean r10 = Intrinsics.areEqual(r1, r5.getModeId());
    L31:
        if (r10 == true) goto L32;
        n0 r11 = r0.getSubMenu();
        if (r11 == null) goto L3;
        Map<String, List<d0>> r12 = r11.a;
        if (r12 == null) goto L3;
        Collection<List<d0>> r13 = r12.values();
        if (r13 == null) goto L3;
        Iterator<T> r14 = r13.iterator();
    L41:
        if (r14.hasNext() == false) goto L3;
        r1 = b(r4, r5, (List) r14.next());
        if (r1 == null) goto L41;
    L32:
        return r0;
    L24:
        if (Intrinsics.areEqual(r4, "model") == false) goto L30;
        if (r3 == null) goto L29;
        b.C0068b r15 = r3.a;
        if (r15 == null) goto L29;
        r1 = r15.b;
    L29:
        r10 = Intrinsics.areEqual(r1, r5.getModel());
        goto L31
    L30:
        r10 = false;
        goto L31
    L9:
        if ((r2 instanceof p0) == false) goto L13;
        f0 r16 = ((p0) r2).a;
        if ((r16 instanceof b) == false) goto L13;
        r3 = (b) r16;
    L13:
        r3 = null;
    L44:
        return r1;
    }

    public c(NestedMenuScene r2, String r3, LinkedHashMap r4, d0 r5, Integer r6, int r7) {
        if ((r7 & 16) == 0) goto L5;
        r6 = null;
    L5:
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "sectionName");
        Intrinsics.checkNotNullParameter(r4, "sections");
        Intrinsics.checkNotNullParameter(r5, "model");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = null;
        this.g = null;
    }
}
