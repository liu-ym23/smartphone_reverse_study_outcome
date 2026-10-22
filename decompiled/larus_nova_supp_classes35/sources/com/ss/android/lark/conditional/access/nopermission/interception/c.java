package com.ss.android.lark.conditional.access.nopermission.interception;

import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final NoPermissionType a;
    public final InternalSecurityAction b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "RestoredInterception(noPermissionType=" + this.a + ", action=" + this.b + ')';
    }

    public c(NoPermissionType r2, InternalSecurityAction r3) {
        Intrinsics.checkNotNullParameter(r2, "noPermissionType");
        Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
        this.a = r2;
        this.b = r3;
    }
}
