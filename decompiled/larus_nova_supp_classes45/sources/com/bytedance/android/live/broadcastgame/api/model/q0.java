package com.bytedance.android.live.broadcastgame.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/q0;", "", "", "gameId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "channel", "b", "", "gameDirection", "I", "getGameDirection", "()I", "height", "d", "width", "e", "h5Url", "getH5Url", "mobileH5Url", "getMobileH5Url", "", "isSupportMultiPlayer", "Z", "f", "()Z", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q0 {

    @SerializedName("channel")
    private final String channel;

    @SerializedName("game_direction")
    private final int gameDirection;

    @SerializedName("game_id")
    private final String gameId;

    @SerializedName("h5_url")
    private final String h5Url;

    @SerializedName("height")
    private final int height;

    @SerializedName("support_guide_enabled")
    private final boolean isSupportMultiPlayer;

    @SerializedName("mobile_h5_url")
    private final String mobileH5Url;

    @SerializedName("width")
    private final int width;

    public q0() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof q0) == false) goto L22;
        q0 r4 = (q0) r3;
        if (Intrinsics.areEqual(this.gameId, r4.gameId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.channel, r4.channel) == true) goto L10;
        return false;
    L10:
        if (this.gameDirection == r4.gameDirection) goto L12;
        return false;
    L12:
        if (this.height == r4.height) goto L14;
        return false;
    L14:
        if (this.width == r4.width) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.h5Url, r4.h5Url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mobileH5Url, r4.mobileH5Url) == true) goto L20;
        return false;
    L20:
        if (this.isSupportMultiPlayer == r4.isSupportMultiPlayer) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r0 = this.gameId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.channel;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((((((r3 + r5) * 31) + this.gameDirection) * 31) + this.height) * 31) + this.width) * 31;
        String r7 = this.h5Url;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.mobileH5Url;
        if (r11 == null) goto L17;
        r1 = r11.hashCode();
    L17:
        int r12 = (r9 + r1) * 31;
        boolean r13 = this.isSupportMultiPlayer;
        ?? r14 = r13;
        if (r13 == false) goto L21;
        r14 = 1;
    L21:
        return r12 + r14;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "XplayInfo(gameId=" + this.gameId + ", channel=" + this.channel + ", gameDirection=" + this.gameDirection + ", height=" + this.height + ", width=" + this.width + ", h5Url=" + this.h5Url + ", mobileH5Url=" + this.mobileH5Url + ", isSupportMultiPlayer=" + this.isSupportMultiPlayer + ")";
    }

    public final String b() {
        return this.channel;
    }

    public final String c() {
        return this.gameId;
    }

    public final int d() {
        return this.height;
    }

    public final int e() {
        return this.width;
    }

    public final boolean f() {
        return this.isSupportMultiPlayer;
    }

    public /* synthetic */ q0(int r11) {
        this("", "", 0, 0, 0, "", "", false);
    }

    public static q0 a(q0 r9, String r11) {
        int r3 = r9.gameDirection;
        String r6 = r9.h5Url;
        String r7 = r9.mobileH5Url;
        boolean r8 = r9.isSupportMultiPlayer;
        Intrinsics.checkNotNullParameter(r11, "gameId");
        Intrinsics.checkNotNullParameter("", "channel");
        Intrinsics.checkNotNullParameter(r6, "h5Url");
        Intrinsics.checkNotNullParameter(r7, "mobileH5Url");
        return new q0(r11, "", r3, 4, 3, r6, r7, r8);
    }

    public q0(String r2, String r3, int r4, int r5, int r6, String r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "gameId");
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r7, "h5Url");
        Intrinsics.checkNotNullParameter(r8, "mobileH5Url");
        this.gameId = r2;
        this.channel = r3;
        this.gameDirection = r4;
        this.height = r5;
        this.width = r6;
        this.h5Url = r7;
        this.mobileH5Url = r8;
        this.isSupportMultiPlayer = r9;
    }
}
