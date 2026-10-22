package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public final boolean a;
    public final List<IKnowledgeAIScopeItemInfo> b;

    public f() {
        this(0);
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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "KnowledgeAIMeetingInfoModel(isVcMeetingNote=" + this.a + ", scopeItemInfos=" + this.b + ')';
    }

    public /* synthetic */ f(int r2) {
        this(false, CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(boolean r2, List<? extends IKnowledgeAIScopeItemInfo> r3) {
        Intrinsics.checkNotNullParameter(r3, "scopeItemInfos");
        this.a = r2;
        this.b = r3;
    }
}
