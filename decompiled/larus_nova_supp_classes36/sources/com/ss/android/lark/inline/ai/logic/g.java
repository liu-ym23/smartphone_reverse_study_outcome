package com.ss.android.lark.inline.ai.logic;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public static final h a(f r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (h) CollectionsKt.getOrNull(r1.d, r1.e);
    }

    public static final String b(f r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        h r2 = (h) CollectionsKt.getOrNull(r1.d, r1.e);
        if (r2 == null) goto L6;
        String r3 = r2.a;
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }

    public static final String c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return "InlineAIState(status=" + r2.a + ", conversationId='" + r2.b + "', promptGroups=" + r2.c + ", taskHistory=" + r2.d + ", currentTaskIndex=" + r2.e + ", userInputText=" + r2.f + ", showKeyboard=" + r2.g + ')';
    }

    public static final String d(j r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof j.a) == false) goto L6;
        return ((j.a) r1).a;
    L6:
        if ((r1 instanceof j.b) == false) goto L10;
        return ((j.b) r1).c;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
