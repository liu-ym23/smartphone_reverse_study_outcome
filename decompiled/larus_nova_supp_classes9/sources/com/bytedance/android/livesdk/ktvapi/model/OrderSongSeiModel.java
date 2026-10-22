package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/OrderSongSeiModel;", BuildConfig.FLAVOR, "userId", BuildConfig.FLAVOR, "userIdStr", BuildConfig.FLAVOR, "avatarThumb", "nickName", "songTitle", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarThumb", "()Ljava/lang/String;", "setAvatarThumb", "(Ljava/lang/String;)V", "getNickName", "setNickName", "getSongTitle", "setSongTitle", "getUserId", "()J", "setUserId", "(J)V", "getUserIdStr", "setUserIdStr", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OrderSongSeiModel {

    @SerializedName("avatar_thumb")
    private String avatarThumb;

    @SerializedName("nick_name")
    private String nickName;

    @SerializedName("song_title")
    private String songTitle;

    @SerializedName("user_id")
    private long userId;

    @SerializedName("user_id_str")
    private String userIdStr;

    public OrderSongSeiModel() {
        this(0, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OrderSongSeiModel copy$default(OrderSongSeiModel r7, long r8, String r10, String r11, String r13, String r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L5;
        r8 = r7.userId;
    L5:
        long r1 = r8;
        if ((r15 & 2) == 0) goto L8;
        r10 = r7.userIdStr;
    L8:
        String r3 = r10;
        if ((r15 & 4) == 0) goto L11;
        r11 = r7.avatarThumb;
    L11:
        String r4 = r11;
        if ((r15 & 8) == 0) goto L14;
        r13 = r7.nickName;
    L14:
        String r5 = r13;
        if ((r15 & 16) == 0) goto L18;
        r14 = r7.songTitle;
    L18:
        return r7.copy(r1, r3, r4, r5, r14);
    }

    public final long component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userIdStr;
    }

    public final String component3() {
        return this.avatarThumb;
    }

    public final String component4() {
        return this.nickName;
    }

    public final String component5() {
        return this.songTitle;
    }

    public final OrderSongSeiModel copy(long r9, String r11, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "userIdStr");
        Intrinsics.checkNotNullParameter(r14, "nickName");
        Intrinsics.checkNotNullParameter(r15, "songTitle");
        return new OrderSongSeiModel(r9, r11, r13, r14, r15);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof OrderSongSeiModel) == false) goto L16;
        OrderSongSeiModel r7 = (OrderSongSeiModel) r6;
        if (this.userId == r7.userId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userIdStr, r7.userIdStr) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.avatarThumb, r7.avatarThumb) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nickName, r7.nickName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.songTitle, r7.songTitle) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        long r0 = this.userId;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.userIdStr;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.avatarThumb;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.nickName;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        String r13 = this.songTitle;
        if (r13 == null) goto L18;
        r3 = r13.hashCode();
    L18:
        return r11 + r3;
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public String toString() {
        return "OrderSongSeiModel(userId=" + this.userId + ", userIdStr=" + this.userIdStr + ", avatarThumb=" + this.avatarThumb + ", nickName=" + this.nickName + ", songTitle=" + this.songTitle + ")";
    }

    public final String getAvatarThumb() {
        return this.avatarThumb;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getSongTitle() {
        return this.songTitle;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUserIdStr() {
        return this.userIdStr;
    }

    public final void setAvatarThumb(String r1) {
        this.avatarThumb = r1;
    }

    public final void setNickName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.nickName = r2;
    }

    public final void setSongTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.songTitle = r2;
    }

    public final void setUserId(long r1) {
        this.userId = r1;
    }

    public final void setUserIdStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userIdStr = r2;
    }

    public OrderSongSeiModel(long r2, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "userIdStr");
        Intrinsics.checkNotNullParameter(r6, "nickName");
        Intrinsics.checkNotNullParameter(r7, "songTitle");
        this.userId = r2;
        this.userIdStr = r4;
        this.avatarThumb = r5;
        this.nickName = r6;
        this.songTitle = r7;
    }

    public /* synthetic */ OrderSongSeiModel(long r8, String r10, String r11, String r13, String r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        r8 = 0;
    L5:
        long r1 = r8;
        if ((r15 & 2) == 0) goto L8;
        String r3 = BuildConfig.FLAVOR;
    L10:
        if ((r15 & 4) == 0) goto L12;
        r11 = null;
    L12:
        String r4 = r11;
        if ((r15 & 8) == 0) goto L15;
        String r5 = BuildConfig.FLAVOR;
    L17:
        if ((r15 & 16) == 0) goto L19;
        String r6 = BuildConfig.FLAVOR;
    L20:
        this(r1, r3, r4, r5, r6);
        return;
    L19:
        r6 = r14;
        goto L20
    L15:
        r5 = r13;
        goto L17
    L8:
        r3 = r10;
        goto L10
    }
}
