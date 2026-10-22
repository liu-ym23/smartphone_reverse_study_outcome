package com.ss.android.lark.feed.export.feedcard;

import com.larksuite.component.ui.avatar.AvatarModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final AvatarModel a;
    public final String b;
    public final boolean c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        int r4 = 1231;
        if (this.c == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.d == true) goto L15;
        r4 = 1237;
    L15:
        return r6 + r4;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "FeedAvatar(avatarModel=" + this.a + ", medalKey=" + this.b + ", isUrgent=" + this.c + ", isShowBadge=" + this.d + ')';
    }

    public /* synthetic */ b(AvatarModel r3, boolean r4, int r5) {
        boolean r1 = false;
        if ((r5 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r1 = true;
    L8:
        this(r3, null, r4, r1);
    }

    public b(AvatarModel r2, String r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "avatarModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
