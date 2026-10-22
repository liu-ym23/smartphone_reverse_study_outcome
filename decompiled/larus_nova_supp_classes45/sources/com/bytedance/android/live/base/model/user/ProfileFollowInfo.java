package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0005\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R,\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\nR$\u0010'\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0006\u001a\u0004\b.\u0010\b\"\u0004\b/\u0010\nR\"\u00100\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R$\u00103\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b3\u0010(\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R$\u00106\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b6\u0010(\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,¨\u0006;"}, d2 = {"Lcom/bytedance/android/live/base/model/user/ProfileFollowInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/c0;", "", "getPushStatus", "followingCount", "J", "getFollowingCount", "()J", "setFollowingCount", "(J)V", "followerCount", "getFollowerCount", "setFollowerCount", "followStatus", "getFollowStatus", "setFollowStatus", "", "followerCountEnable", "Z", "getFollowerCountEnable", "()Z", "setFollowerCountEnable", "(Z)V", "jumpFollowerListEnable", "getJumpFollowerListEnable", "setJumpFollowerListEnable", "", "Lcom/bytedance/android/live/base/model/user/IMutualFollowUser;", "accounts", "Ljava/util/List;", "getAccounts", "()Ljava/util/List;", "setAccounts", "(Ljava/util/List;)V", "mutualFollowCount", "getMutualFollowCount", "setMutualFollowCount", "", "remarkName", "Ljava/lang/String;", "getRemarkName", "()Ljava/lang/String;", "setRemarkName", "(Ljava/lang/String;)V", "_pushStatus", "get_pushStatus", "set_pushStatus", "invalidFollowStatus", "getInvalidFollowStatus", "setInvalidFollowStatus", "followerCountStr", "getFollowerCountStr", "setFollowerCountStr", "followingCountStr", "getFollowingCountStr", "setFollowingCountStr", "<init>", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileFollowInfo extends FlexModelBase<c0> implements c0, vh7.h {

    @IgnoreProtoFieldCheck
    @SerializedName("push_status")
    private long _pushStatus;

    @SerializedName("accounts")
    protected List<? extends IMutualFollowUser> accounts;

    @SerializedName("follow_status")
    protected long followStatus;

    @SerializedName("follower_count")
    protected long followerCount;

    @SerializedName("follower_count_enable")
    protected boolean followerCountEnable;

    @SerializedName("follower_count_str")
    protected String followerCountStr;

    @SerializedName("following_count")
    protected long followingCount;

    @SerializedName("following_count_str")
    protected String followingCountStr;

    @SerializedName("invalid_follow_status")
    protected boolean invalidFollowStatus;

    @SerializedName("follower_list_enable")
    protected boolean jumpFollowerListEnable;

    @SerializedName("mutual_follow_count")
    protected long mutualFollowCount;

    @IgnoreProtoFieldCheck
    @SerializedName("remark_name")
    protected String remarkName;

    public ProfileFollowInfo() {
        super(c0.class);
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public List<IMutualFollowUser> getAccounts() {
        return this.accounts;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public long getFollowStatus() {
        return this.followStatus;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public long getFollowerCount() {
        return this.followerCount;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public boolean getFollowerCountEnable() {
        return this.followerCountEnable;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public String getFollowerCountStr() {
        return this.followerCountStr;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public long getFollowingCount() {
        return this.followingCount;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public String getFollowingCountStr() {
        return this.followingCountStr;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public boolean getInvalidFollowStatus() {
        return this.invalidFollowStatus;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public boolean getJumpFollowerListEnable() {
        return this.jumpFollowerListEnable;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public long getMutualFollowCount() {
        return this.mutualFollowCount;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public long getPushStatus() {
        return this._pushStatus;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public String getRemarkName() {
        return this.remarkName;
    }

    public final long get_pushStatus() {
        return this._pushStatus;
    }

    public ProfileFollowInfo(am3.g r5) {
        super(c0.class);
        this.accounts = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L19;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L18;
            case 2: goto L7;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
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
        this.mutualFollowCount = r5.j();
        goto L3
    L13:
        this.accounts.add(vh7.f.a(r5, IMutualFollowUser.class));
        goto L3
    L14:
        this.followStatus = r5.j();
        goto L3
    L15:
        this.jumpFollowerListEnable = am3.h.a(r5);
        goto L3
    L16:
        this.followerCountEnable = am3.h.a(r5);
        goto L3
    L17:
        this.followerCount = r5.j();
        goto L3
    L18:
        this.followingCount = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L19:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setAccounts(List<? extends IMutualFollowUser> r1) {
        this.accounts = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setFollowStatus(long r1) {
        this.followStatus = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setFollowerCount(long r1) {
        this.followerCount = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setFollowerCountEnable(boolean r1) {
        this.followerCountEnable = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setFollowerCountStr(String r1) {
        this.followerCountStr = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setFollowingCount(long r1) {
        this.followingCount = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setFollowingCountStr(String r1) {
        this.followingCountStr = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setInvalidFollowStatus(boolean r1) {
        this.invalidFollowStatus = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setJumpFollowerListEnable(boolean r1) {
        this.jumpFollowerListEnable = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setMutualFollowCount(long r1) {
        this.mutualFollowCount = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.c0
    public void setRemarkName(String r1) {
        this.remarkName = r1;
    }

    public final void set_pushStatus(long r1) {
        this._pushStatus = r1;
    }
}
