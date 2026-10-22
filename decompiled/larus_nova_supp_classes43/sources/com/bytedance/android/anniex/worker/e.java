package com.bytedance.android.anniex.worker;

import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Deprecated(message = "仅用于告知JSB环境这是全局的端智能Worker")
public final class e {
    public final String a;

    public e() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((e) r10).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "AnnieXWorkerTag(tag=" + this.a + ')';
    }

    public e(int r10) {
        Intrinsics.checkNotNullParameter("AnnieXJSWorker", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        this.a = "AnnieXJSWorker";
    }
}
