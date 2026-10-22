package com.ss.android.lark.inline.ai.logic;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import slb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements com.larksuite.arch.jack.j {
    public final InlineAIStatus a;
    public String b;
    public final List<m> c;
    public final List<h> d;
    public final int e;
    public final j f;
    public final Boolean g;

    public f() {
        this(null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        if (this.e == r6.e) goto L24;
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
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31;
        Boolean r1 = this.g;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "InlineAIState(status=" + this.a + ", conversationId=" + this.b + ", promptGroups=" + this.c + ", taskHistory=" + this.d + ", currentTaskIndex=" + this.e + ", userInputText=" + this.f + ", showKeyboard=" + this.g + ')';
    }

    public /* synthetic */ f(InlineAIStatus r9, int r10) {
        if ((r10 & 1) == 0) goto L5;
        r9 = InlineAIStatus.Init;
    L5:
        InlineAIStatus r1 = r9;
        if ((r10 & 2) == 0) goto L8;
        String r11 = "";
    L10:
        if ((r10 & 4) == 0) goto L12;
        List r3 = CollectionsKt.emptyList();
    L14:
        if ((r10 & 8) == 0) goto L16;
        ArrayList r4 = new ArrayList();
    L18:
        if ((r10 & 16) == 0) goto L20;
        int r5 = -1;
    L22:
        if ((r10 & 32) == 0) goto L24;
        j.a r6 = new j.a("");
    L25:
        this(r1, r11, r3, r4, r5, r6, null);
        return;
    L24:
        r6 = null;
        goto L25
    L20:
        r5 = 0;
        goto L22
    L16:
        r4 = null;
        goto L18
    L12:
        r3 = null;
        goto L14
    L8:
        r11 = null;
        goto L10
    }

    public f(InlineAIStatus r2, String r3, List<m> r4, List<h> r5, int r6, j r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "promptGroups");
        Intrinsics.checkNotNullParameter(r5, "taskHistory");
        Intrinsics.checkNotNullParameter(r7, "userInputText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public static f a(f r8, InlineAIStatus r9, List r10, List r11, int r12, j r13, Boolean r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r9 = r8.a;
    L5:
        InlineAIStatus r1 = r9;
        if ((r15 & 2) == 0) goto L8;
        String r16 = r8.b;
    L9:
        String r2 = r16;
        if ((r15 & 4) == 0) goto L12;
        r10 = r8.c;
    L12:
        List r3 = r10;
        if ((r15 & 8) == 0) goto L15;
        r11 = r8.d;
    L15:
        List r4 = r11;
        if ((r15 & 16) == 0) goto L18;
        r12 = r8.e;
    L18:
        int r5 = r12;
        if ((r15 & 32) == 0) goto L21;
        r13 = r8.f;
    L21:
        j r6 = r13;
        if ((r15 & 64) == 0) goto L24;
        r14 = r8.g;
    L24:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "status");
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "promptGroups");
        Intrinsics.checkNotNullParameter(r4, "taskHistory");
        Intrinsics.checkNotNullParameter(r6, "userInputText");
        return new f(r1, r2, r3, r4, r5, r6, r14);
    L8:
        r16 = null;
        goto L9
    }
}
