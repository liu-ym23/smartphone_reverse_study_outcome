package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/e;", "", "", "hot", "J", "b", "()J", "rank", "c", "", "rankType", "I", "d", "()I", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "g", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "songId", "e", "", "songTitle", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "contributorCount", "a", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e implements vh7.h {

    @SerializedName("contributor_count")
    protected long contributorCount;

    @SerializedName("hot")
    protected long hot;

    @SerializedName("rank")
    protected long rank;

    @SerializedName("rank_type")
    protected int rankType;

    @SerializedName("song_id")
    protected long songId;

    @SerializedName("song_title")
    protected String songTitle;

    @SerializedName("user")
    protected IBaseUser user;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L20;
        e r7 = (e) r6;
        if (this.hot == r7.hot) goto L8;
        return false;
    L8:
        if (this.rank == r7.rank) goto L10;
        return false;
    L10:
        if (this.rankType == r7.rankType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.user, r7.user) == true) goto L14;
        return false;
    L14:
        if (this.songId == r7.songId) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.songTitle, r7.songTitle) == true) goto L18;
        return false;
    L18:
        if (this.contributorCount == r7.contributorCount) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r0 = this.hot;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.rank;
        int r2 = (((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.rankType) * 31;
        IBaseUser r4 = this.user;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        long r7 = this.songId;
        int r8 = (((r2 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.songTitle;
        if (r9 == null) goto L9;
        r5 = r9.hashCode();
    L9:
        int r11 = (r8 + r5) * 31;
        long r12 = this.contributorCount;
        return r11 + ((int) (r12 ^ (r12 >>> 32)));
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "GetKtvSingingHotResultResponse(hot=" + this.hot + ", rank=" + this.rank + ", rankType=" + this.rankType + ", user=" + this.user + ", songId=" + this.songId + ", songTitle=" + this.songTitle + ", contributorCount=" + this.contributorCount + ")";
    }

    public e() {
        this.hot = 0;
        this.rank = 0;
        this.rankType = 0;
        this.user = null;
        this.songId = 0;
        this.songTitle = "";
        this.contributorCount = 0;
    }

    public final long a() {
        return this.contributorCount;
    }

    public final long b() {
        return this.hot;
    }

    public final long c() {
        return this.rank;
    }

    public final int d() {
        return this.rankType;
    }

    public final long e() {
        return this.songId;
    }

    public final String f() {
        return this.songTitle;
    }

    public final IBaseUser g() {
        return this.user;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public e(am3.g r7) {
        long r0 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L14;
        switch(r4) {
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.contributorCount = r7.j();
        r3 = r3 | 16;
        goto L3
    L8:
        this.songTitle = am3.h.c(r7);
        goto L3
    L9:
        this.songId = r7.j();
        r3 = r3 | 8;
        goto L3
    L10:
        this.user = vh7.f.a(r7, IBaseUser.class);
        goto L3
    L11:
        this.rankType = r7.i();
        r3 = r3 | 4;
        goto L3
    L12:
        this.rank = r7.j();
        r3 = r3 | 2;
        goto L3
    L13:
        this.hot = r7.j();
        r3 = r3 | 1;
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L14:
        r7.d(r0);
        if ((r3 & 1) != 0) goto L18;
        this.hot = 0;
    L18:
        if ((r3 & 2) != 0) goto L21;
        this.rank = 0;
    L21:
        if ((r3 & 4) != 0) goto L24;
        this.rankType = 0;
    L24:
        if (this.user != null) goto L27;
        this.user = null;
    L27:
        if ((r3 & 8) != 0) goto L30;
        this.songId = 0;
    L30:
        if (this.songTitle != null) goto L33;
        this.songTitle = "";
    L33:
        if ((r3 & 16) != 0) goto L54;
        this.contributorCount = 0;
        return;
    }
}
