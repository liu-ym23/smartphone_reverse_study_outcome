package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/f0;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "", "rank", "I", "getRank", "()I", "", "curUserHot", "J", "getCurUserHot", "()J", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f0 implements vh7.h {

    @SerializedName("hot")
    protected long curUserHot;

    @SerializedName("rank")
    protected int rank;

    @SerializedName("user")
    protected IBaseUser user;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof f0) == false) goto L12;
        f0 r6 = (f0) r5;
        if (Intrinsics.areEqual(this.user, r6.user) == true) goto L8;
        return false;
    L8:
        if (this.rank == r6.rank) goto L10;
        return false;
    L10:
        if (this.curUserHot == r6.curUserHot) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        IBaseUser r0 = this.user;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = ((r1 * 31) + this.rank) * 31;
        long r3 = this.curUserHot;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "ListUser(user=" + this.user + ", rank=" + this.rank + ", curUserHot=" + this.curUserHot + ")";
    }

    public f0() {
        this.user = null;
        this.rank = 0;
        this.curUserHot = 0;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public f0(am3.g r8) {
        long r0 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L14;
        if (r4 != 1) goto L7;
        this.user = vh7.f.a(r8, IBaseUser.class);
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this.curUserHot = r8.j();
        r3 = r3 | 2;
        goto L3
    L9:
        if (r4 != 3) goto L10;
        this.rank = (int) r8.j();
        r3 = r3 | 1;
        goto L3
    L10:
        am3.h.e(r8);
        goto L3
    L14:
        r8.d(r0);
        if (this.user != null) goto L18;
        this.user = null;
    L18:
        if ((r3 & 1) != 0) goto L21;
        this.rank = 0;
    L21:
        if ((r3 & 2) != 0) goto L36;
        this.curUserHot = 0;
        return;
    }
}
