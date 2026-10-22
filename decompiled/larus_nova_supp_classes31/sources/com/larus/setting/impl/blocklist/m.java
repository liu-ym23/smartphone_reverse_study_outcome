package com.larus.setting.impl.blocklist;

import com.larus.home.api.block.BlockUserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m {
    public final BlockUserInfo a;
    public final boolean b;
    public final int c;
    public int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        BlockUserInfo r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L11:
        return ((((r2 + r3) * 31) + this.c) * 31) + this.d;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BlockUserItem(blockUserInfo=" + this.a + ", block=" + this.b + ", type=" + this.c + ", loadMoreStatus=" + this.d + ')';
    }

    public final int getType() {
        return this.c;
    }

    public m(BlockUserInfo r3, boolean r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L5;
        r4 = true;
    L5:
        int r1 = 0;
        if ((r6 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r1 = 2;
    L11:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r1;
    }
}
