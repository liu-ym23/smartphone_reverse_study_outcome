package com.obric.assistant.cocreationreview.modules.searchqa;

import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Integer g;
    public final List<String> h;
    public final List<r> i;
    public final String j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((r10 + r12) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        String r14 = this.j;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
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
        return "SearchQaLocalReference(title=" + this.a + ", description=" + this.b + ", sourceType=" + this.c + ", entityType=" + this.d + ", entityId=" + this.e + ", entityPackageName=" + this.f + ", index=" + this.g + ", imageUris=" + this.h + ", images=" + this.i + ", url=" + this.j + ')';
    }

    public /* synthetic */ s(String r12, String r13, String r14, String r15, String r16, Integer r17, List r18, List r19, String r20, int r21) {
        if ((r21 & 8) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r21 & 16) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r21 & 32) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r21 & 64) == 0) goto L17;
        Integer r7 = null;
    L19:
        if ((r21 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L21;
        List r8 = CollectionsKt.emptyList();
    L23:
        if ((r21 & 256) == 0) goto L25;
        List r9 = CollectionsKt.emptyList();
    L27:
        if ((r21 & 512) == 0) goto L29;
        String r10 = null;
    L30:
        this(r12, NameKeys.UnloadStrategy_No_Strategy, r13, r4, r5, r6, r7, r8, r9, r10);
        return;
    L29:
        r10 = r20;
        goto L30
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public s(String r2, String r3, String r4, String r5, String r6, String r7, Integer r8, List<String> r9, List<r> r10, String r11) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "description");
        Intrinsics.checkNotNullParameter(r4, "sourceType");
        Intrinsics.checkNotNullParameter(r9, "imageUris");
        Intrinsics.checkNotNullParameter(r10, "images");
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
    }
}
