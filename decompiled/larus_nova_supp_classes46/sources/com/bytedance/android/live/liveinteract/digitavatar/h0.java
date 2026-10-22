package com.bytedance.android.live.liveinteract.digitavatar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 {
    public final AvatarGender a;
    public final String b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h0) == false) goto L10;
        h0 r4 = (h0) r3;
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
        AvatarGender r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateAvatarParams(gender=" + this.a + ", avatarModel=" + this.b + ")";
    }

    public h0(AvatarGender r3) {
        Intrinsics.checkNotNullParameter(r3, "gender");
        Intrinsics.checkNotNullParameter("", "avatarModel");
        this.a = r3;
        this.b = "";
    }
}
