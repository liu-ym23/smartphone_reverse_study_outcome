package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final Function1<NewProfileUser, Boolean> a;
    public final Function0<com.bytedance.android.live.profile.ui.base.g> b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L10;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Function1<NewProfileUser, Boolean> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Function0<com.bytedance.android.live.profile.ui.base.g> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ComponentLoadInfo(loadPredicate=" + this.a + ", generate=" + this.b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super NewProfileUser, Boolean> r2, Function0<? extends com.bytedance.android.live.profile.ui.base.g> r3) {
        Intrinsics.checkNotNullParameter(r2, "loadPredicate");
        Intrinsics.checkNotNullParameter(r3, "generate");
        this.a = r2;
        this.b = r3;
    }
}
