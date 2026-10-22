package com.bytedance.android.live.profit.redpacket;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\u000b\u001a\u00060\tj\u0002`\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00060\tj\u0002`\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/a;", "", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "iconUrl", "getIconUrl", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "giftId", "J", "getGiftId", "()J", "number", "getNumber", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("gift_id")
    private final long giftId;

    @SerializedName("url")
    private final String iconUrl;

    @SerializedName("number")
    private final long number;

    @SerializedName("text")
    private final String text;

    public a(String r1, String r2, long r3, long r5) {
        this.text = r1;
        this.iconUrl = r2;
        this.giftId = r3;
        this.number = r5;
    }
}
