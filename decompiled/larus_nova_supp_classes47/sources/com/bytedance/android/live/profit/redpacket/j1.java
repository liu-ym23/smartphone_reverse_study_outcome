package com.bytedance.android.live.profit.redpacket;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/j1;", "", "", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "nickName", "getNickName", "secUserId", "getSecUserId", "avtarUrl", "getAvtarUrl", "riskyAvtarUrl", "getRiskyAvtarUrl", "", "isRiskyOwner", "Z", "()Z", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class j1 {

    @SerializedName("avtar_url")
    private final String avtarUrl;

    @SerializedName("is_risky_owner")
    private final boolean isRiskyOwner;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("risky_avtar_url")
    private final String riskyAvtarUrl;

    @SerializedName("sec_user_id")
    private final String secUserId;

    @SerializedName("user_id")
    private final String userId;

    public j1(String r2, String r3, String r4, String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "nickName");
        Intrinsics.checkNotNullParameter(r4, "secUserId");
        Intrinsics.checkNotNullParameter(r5, "avtarUrl");
        Intrinsics.checkNotNullParameter(r6, "riskyAvtarUrl");
        this.userId = r2;
        this.nickName = r3;
        this.secUserId = r4;
        this.avtarUrl = r5;
        this.riskyAvtarUrl = r6;
        this.isRiskyOwner = r7;
    }
}
