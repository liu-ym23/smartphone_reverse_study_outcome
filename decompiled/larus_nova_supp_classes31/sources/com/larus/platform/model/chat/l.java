package com.larus.platform.model.chat;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final List<String> d;
    public final int e;
    public final boolean f;
    public final List<String> g;
    public final List<String> h;

    public l() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (((((r4 + r5) * 31) + this.d.hashCode()) * 31) + this.e) * 31;
        if (this.f == true) goto L19;
        r1 = 1237;
    L19:
        return ((((r6 + r1) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatSendPreviewConfig(enablePreview=" + this.a + ", enableInput=" + this.b + ", enableAiEdit=" + this.c + ", aiEditFilterScene=" + this.d + ", prefetchSize=" + this.e + ", enableFindSimilar=" + this.f + ", findSimilarActionBarInstructionTypeList=" + this.g + ", findSimilarLlmIntentionDetailList=" + this.h + ')';
    }

    public /* synthetic */ l(int r10) {
        this(false, false, false, CollectionsKt.emptyList(), 0, false, CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public l(boolean r2, boolean r3, boolean r4, List<String> r5, int r6, boolean r7, List<String> r8, List<String> r9) {
        Intrinsics.checkNotNullParameter(r5, "aiEditFilterScene");
        Intrinsics.checkNotNullParameter(r8, "findSimilarActionBarInstructionTypeList");
        Intrinsics.checkNotNullParameter(r9, "findSimilarLlmIntentionDetailList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
