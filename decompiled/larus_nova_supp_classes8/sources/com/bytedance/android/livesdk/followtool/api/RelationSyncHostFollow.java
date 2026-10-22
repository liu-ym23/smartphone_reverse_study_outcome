package com.bytedance.android.livesdk.followtool.api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/followtool/api/RelationSyncHostFollow;", "", "needFollowPopup", "", "userFollowScope", "userFollowSwitch", "userInfos", "", "Lcom/bytedance/android/livesdk/followtool/api/UserInfo;", "(ZZZLjava/util/List;)V", "getNeedFollowPopup", "()Z", "setNeedFollowPopup", "(Z)V", "getUserFollowScope", "setUserFollowScope", "getUserFollowSwitch", "setUserFollowSwitch", "getUserInfos", "()Ljava/util/List;", "setUserInfos", "(Ljava/util/List;)V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class RelationSyncHostFollow {

    @SerializedName("need_follow_popup")
    private boolean needFollowPopup;

    @SerializedName("user_follow_scope")
    private boolean userFollowScope;

    @SerializedName("user_follow_switch")
    private boolean userFollowSwitch;

    @SerializedName("user_infos")
    private List<UserInfo> userInfos;

    public RelationSyncHostFollow() {
        this(false, false, false, null, 15, null);
    }

    public final boolean getNeedFollowPopup() {
        return this.needFollowPopup;
    }

    public final boolean getUserFollowScope() {
        return this.userFollowScope;
    }

    public final boolean getUserFollowSwitch() {
        return this.userFollowSwitch;
    }

    public final List<UserInfo> getUserInfos() {
        return this.userInfos;
    }

    public final void setNeedFollowPopup(boolean r1) {
        this.needFollowPopup = r1;
    }

    public final void setUserFollowScope(boolean r1) {
        this.userFollowScope = r1;
    }

    public final void setUserFollowSwitch(boolean r1) {
        this.userFollowSwitch = r1;
    }

    public final void setUserInfos(List<UserInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userInfos = r2;
    }

    public RelationSyncHostFollow(boolean r2, boolean r3, boolean r4, List<UserInfo> r5) {
        Intrinsics.checkNotNullParameter(r5, "userInfos");
        this.needFollowPopup = r2;
        this.userFollowScope = r3;
        this.userFollowSwitch = r4;
        this.userInfos = r5;
    }

    public /* synthetic */ RelationSyncHostFollow(boolean r2, boolean r3, boolean r4, List r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = new ArrayList();
    L14:
        this(r2, r3, r4, r5);
    }
}
