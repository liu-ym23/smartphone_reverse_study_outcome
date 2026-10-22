package com.ss.android.lark.inline.ai.logic;

import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import slb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public final String a;
    public final j b;
    public FeedBackChoice c;
    public String d;
    public final boolean e;
    public final slb.j f;
    public final l g;
    public List<? extends slb.h> h;
    public String i;
    public String j;
    public int k;
    public HashMap<String, Object> l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        j r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((r4 + r5) * 31) + this.f.hashCode()) * 31;
        l r7 = this.g;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<? extends slb.h> r10 = this.h;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((((((r9 + r11) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k) * 31;
        HashMap<String, Object> r13 = this.l;
        if (r13 == null) goto L23;
        r2 = r13.hashCode();
    L23:
        return r12 + r2;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "InlineAITask(taskID='" + this.a + "', userInputText=" + this.b + ", feedBackChoice=" + this.c + ", fullContent.length='" + this.d.length() + "', prompt=" + this.f + ", promptConfirmOptions=" + this.g + ", operateButtons=" + this.h + ", taskStatus='" + this.i + "', aiMessageId='" + this.j + "', finishType='" + this.k + "')";
    }

    public static h a(h r13) {
        String r1 = r13.a;
        j r2 = r13.b;
        FeedBackChoice r3 = r13.c;
        String r4 = r13.d;
        boolean r5 = r13.e;
        slb.j r6 = r13.f;
        l r7 = r13.g;
        List<? extends slb.h> r8 = r13.h;
        String r9 = r13.i;
        String r10 = r13.j;
        int r11 = r13.k;
        HashMap<String, Object> r12 = r13.l;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r1, "taskID");
        Intrinsics.checkNotNullParameter(r3, "feedBackChoice");
        Intrinsics.checkNotNullParameter(r4, "fullContent");
        Intrinsics.checkNotNullParameter(r6, "prompt");
        Intrinsics.checkNotNullParameter(r9, "taskStatus");
        Intrinsics.checkNotNullParameter(r10, "aiMessageId");
        return new h(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public /* synthetic */ h(String r14, j r15, FeedBackChoice r16, boolean r17, slb.j r18, l r19) {
        this(r14, r15, r16, "", r17, r18, r19, null, "", "", 0, null);
    }

    public h(String r2, j r3, FeedBackChoice r4, String r5, boolean r6, slb.j r7, l r8, List<? extends slb.h> r9, String r10, String r11, int r12, HashMap<String, Object> r13) {
        Intrinsics.checkNotNullParameter(r2, "taskID");
        Intrinsics.checkNotNullParameter(r4, "feedBackChoice");
        Intrinsics.checkNotNullParameter(r5, "fullContent");
        Intrinsics.checkNotNullParameter(r7, "prompt");
        Intrinsics.checkNotNullParameter(r10, "taskStatus");
        Intrinsics.checkNotNullParameter(r11, "aiMessageId");
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
