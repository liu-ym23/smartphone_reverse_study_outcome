package com.larksuite.arch.jack;

import com.ss.android.lark.chat.entity.preview.PullUrlPreviewChatterListResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m<T> extends a<T> {
    public final T a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof m) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((m) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        T r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "Success(value=" + this.a + ')';
    }

    @Override // com.larksuite.arch.jack.a
    public final T a() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(PullUrlPreviewChatterListResponse r1) {
        this.a = r1;
    }
}
