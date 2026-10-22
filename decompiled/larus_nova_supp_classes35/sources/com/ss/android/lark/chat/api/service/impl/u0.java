package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u0 {
    public final PullUrlPreviewRequest a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof u0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((u0) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "PatchPreviewTask(request=" + this.a + ')';
    }

    public u0(PullUrlPreviewRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        this.a = r2;
    }
}
