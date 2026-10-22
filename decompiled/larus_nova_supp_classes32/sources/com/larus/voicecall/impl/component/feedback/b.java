package com.larus.voicecall.impl.component.feedback;

import com.larus.bmhome.auth.FeedbackMeta;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final boolean a;
    public final List<FeedbackMeta> b;
    public final String c;

    public b() {
        this(7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        String r2 = this.c;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DislikeFeedbackData(isSubmit=" + this.a + ", selectedTags=" + this.b + ", content=" + this.c + ')';
    }

    public /* synthetic */ b(int r3) {
        if ((r3 & 2) == 0) goto L5;
        List r4 = CollectionsKt.emptyList();
    L6:
        this(false, r4, null);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public b(boolean r2, List<FeedbackMeta> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "selectedTags");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
