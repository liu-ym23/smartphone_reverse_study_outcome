package com.bytedance.android.livesdk.followtool.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/followtool/api/UserInfo;", "", "nickName", "", "avatarUrl", "openId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getNickName", "setNickName", "getOpenId", "setOpenId", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class UserInfo {

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("nick_name")
    private String nickName;

    @SerializedName("open_id")
    private String openId;

    public UserInfo() {
        this(null, null, null, 7, null);
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final void setAvatarUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.avatarUrl = r2;
    }

    public final void setNickName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.nickName = r2;
    }

    public final void setOpenId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.openId = r2;
    }

    public UserInfo(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "nickName");
        Intrinsics.checkNotNullParameter(r3, "avatarUrl");
        Intrinsics.checkNotNullParameter(r4, "openId");
        this.nickName = r2;
        this.avatarUrl = r3;
        this.openId = r4;
    }

    public /* synthetic */ UserInfo(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }
}
