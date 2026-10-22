package com.larus.camera.impl.utils.eventbus;

import com.larus.camera.impl.ui.component.result.general.e2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements g {
    public final e2 a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ChangeSuggestedActionPosition(position=" + this.a + ')';
    }

    public d(e2 r2) {
        Intrinsics.checkNotNullParameter(r2, "position");
        this.a = r2;
    }
}
