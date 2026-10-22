package com.bytedance.android.live.search.impl.search.viewmodel;

import com.bytedance.android.live.base.model.user.User;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final List<User> a;
    public long b;
    public boolean c;

    public a() {
        this(null, 0, true);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L12;
        a r7 = (a) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        List<User> r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.b;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        boolean r4 = this.c;
        ?? r5 = r4;
        if (r4 == false) goto L10;
        r5 = 1;
    L10:
        return r3 + r5;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveSearchUserResultCacheItem(userList=" + this.a + ", cursor=" + this.b + ", hasMore=" + this.c + ")";
    }

    public a(List<User> r1, long r2, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
