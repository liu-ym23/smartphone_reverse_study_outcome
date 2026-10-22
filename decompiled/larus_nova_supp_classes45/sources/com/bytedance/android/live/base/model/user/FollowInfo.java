package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b&\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0007¢\u0006\u0004\b2\u00103J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0010\u001a\u00020\u0006R\"\u0010\u0011\u001a\u00020\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R$\u0010,\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b,\u0010$\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R$\u0010/\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b/\u0010$\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(¨\u00064"}, d2 = {"Lcom/bytedance/android/live/base/model/user/FollowInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/j;", "Ljava/io/Serializable;", "", "o", "", "equals", "", "hashCode", "", "toString", "intFollowStatus", "isFollowing", "", "getFollowStatusKmp", "isFollowed", "followingCount", "J", "getFollowingCount", "()J", "setFollowingCount", "(J)V", "followerCount", "getFollowerCount", "setFollowerCount", "followStatus", "getFollowStatus", "setFollowStatus", "invalidFollowStatus", "Z", "getInvalidFollowStatus", "()Z", "setInvalidFollowStatus", "(Z)V", "remarkName", "Ljava/lang/String;", "getRemarkName", "()Ljava/lang/String;", "setRemarkName", "(Ljava/lang/String;)V", "pushStatus", "getPushStatus", "setPushStatus", "followerCountStr", "getFollowerCountStr", "setFollowerCountStr", "followingCountStr", "getFollowingCountStr", "setFollowingCountStr", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FollowInfo extends FlexModelBase<py.j> implements py.j, vh7.h {

    @SerializedName("follow_status")
    protected long followStatus;

    @SerializedName("follower_count")
    protected long followerCount;

    @SerializedName("follower_count_str")
    protected String followerCountStr;

    @SerializedName("following_count")
    protected long followingCount;

    @SerializedName("following_count_str")
    protected String followingCountStr;

    @SerializedName("invalid_follow_status")
    protected boolean invalidFollowStatus;

    @IgnoreProtoFieldCheck
    @SerializedName("push_status")
    protected long pushStatus;

    @IgnoreProtoFieldCheck
    @SerializedName("remark_name")
    protected String remarkName;

    public FollowInfo() {
        super(py.j.class);
    }

    public String toString() {
        return "FollowInfo{followingCount=" + getFollowingCount() + ", followerCount='" + getFollowerCount() + "', followStatus=" + getFollowStatus() + ", remarkName=" + getRemarkName() + ", pushStatus=" + getPushStatus() + ", followerCountStr=" + getFollowerCountStr() + ", followingCountStr=" + getFollowingCountStr() + '}';
    }

    @Override // py.j
    public long getFollowStatusKmp() {
        return getFollowStatus();
    }

    public int hashCode() {
        return (((((int) (getFollowingCount() ^ (getFollowingCount() >>> 32))) * 31) + ((int) (getFollowerCount() ^ (getFollowerCount() >>> 32)))) * 31) + ((int) (getFollowStatus() ^ (getFollowStatus() >>> 32)));
    }

    public final int intFollowStatus() {
        return (int) getFollowStatus();
    }

    public final boolean isFollowed() {
        if (getFollowStatus() != 2) goto L5;
    L8:
        return true;
    L5:
        if (getFollowStatus() == 3) goto L8;
        return false;
    }

    @Override // py.j
    public boolean isFollowing() {
        if (getFollowStatus() != 2) goto L5;
    L8:
        return true;
    L5:
        if (getFollowStatus() == 1) goto L8;
        return false;
    }

    @Override // py.j
    public long getFollowStatus() {
        return this.followStatus;
    }

    @Override // py.j
    public long getFollowerCount() {
        return this.followerCount;
    }

    @Override // py.j
    public String getFollowerCountStr() {
        return this.followerCountStr;
    }

    @Override // py.j
    public long getFollowingCount() {
        return this.followingCount;
    }

    @Override // py.j
    public String getFollowingCountStr() {
        return this.followingCountStr;
    }

    @Override // py.j
    public boolean getInvalidFollowStatus() {
        return this.invalidFollowStatus;
    }

    @Override // py.j
    public long getPushStatus() {
        return this.pushStatus;
    }

    @Override // py.j
    public String getRemarkName() {
        return this.remarkName;
    }

    public FollowInfo(am3.g r5) {
        super(py.j.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this.invalidFollowStatus = am3.h.a(r5);
        goto L3
    L9:
        this.followingCountStr = am3.h.c(r5);
        goto L3
    L10:
        this.followerCountStr = am3.h.c(r5);
        goto L3
    L11:
        this.remarkName = am3.h.c(r5);
        goto L3
    L12:
        this.pushStatus = r5.j();
        goto L3
    L13:
        this.followStatus = r5.j();
        goto L3
    L14:
        this.followerCount = r5.j();
        goto L3
    L15:
        this.followingCount = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L16:
        r5.d(r0);
        setThreadSafe(true);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L21:
        return false;
    L8:
        if ((!Intrinsics.areEqual(FollowInfo.class, r8.getClass())) == true) goto L21;
        FollowInfo r9 = (FollowInfo) r8;
        if (getFollowingCount() == r9.getFollowingCount()) goto L14;
        return false;
    L14:
        if (getFollowerCount() == r9.getFollowerCount()) goto L17;
        return false;
    L17:
        if (getFollowStatus() == r9.getFollowStatus()) goto L22;
        return false;
    L22:
        return true;
    }

    public void setFollowStatus(long r1) {
        this.followStatus = r1;
    }

    public void setFollowerCount(long r1) {
        this.followerCount = r1;
    }

    @Override // py.j
    public void setFollowerCountStr(String r1) {
        this.followerCountStr = r1;
    }

    public void setFollowingCount(long r1) {
        this.followingCount = r1;
    }

    @Override // py.j
    public void setFollowingCountStr(String r1) {
        this.followingCountStr = r1;
    }

    @Override // py.j
    public void setInvalidFollowStatus(boolean r1) {
        this.invalidFollowStatus = r1;
    }

    @Override // py.j
    public void setPushStatus(long r1) {
        this.pushStatus = r1;
    }

    @Override // py.j
    public void setRemarkName(String r1) {
        this.remarkName = r1;
    }
}
