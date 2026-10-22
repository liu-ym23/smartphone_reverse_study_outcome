package com.obric.assistant.cocreationreview;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j5 {
    public final Context a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof j5) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((j5) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ModuleCardBuildContext(context=" + this.a + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j5(CocreationReviewActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
