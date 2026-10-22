package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/p;", "", "", "count", "J", "a", "()J", "", "Lcom/bytedance/android/live/ktv/common/model/api/r;", "group_users", "Ljava/util/List;", "b", "()Ljava/util/List;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class p implements vh7.h {

    @SerializedName("count")
    protected long count;

    @SerializedName("group_user")
    protected List<r> group_users;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof p) == false) goto L10;
        p r7 = (p) r6;
        if (this.count == r7.count) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.group_users, r7.group_users) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.count;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        List<r> r2 = this.group_users;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "GroupData(count=" + this.count + ", group_users=" + this.group_users + ")";
    }

    public p() {
        this.count = 0;
        this.group_users = null;
    }

    public final long a() {
        return this.count;
    }

    public final List<r> b() {
        return this.group_users;
    }

    public p(am3.g r7) {
        this.group_users = new ArrayList();
        long r0 = r7.c();
        boolean r2 = false;
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L11;
        if (r3 != 1) goto L7;
        this.count = r7.j();
        r2 = r2 | true;
        goto L3
    L7:
        if (r3 != 2) goto L8;
        this.group_users.add(new r(r7));
        goto L3
    L8:
        am3.h.e(r7);
        goto L3
    L11:
        r7.d(r0);
        if ((r2 & true) == true) goto L15;
        this.count = 0;
    L15:
        if (this.group_users.isEmpty() == false) goto L27;
        this.group_users = null;
        return;
    }
}
