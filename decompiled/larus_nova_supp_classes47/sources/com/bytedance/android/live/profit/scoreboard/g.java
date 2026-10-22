package com.bytedance.android.live.profit.scoreboard;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/g;", "", "", "index", "I", "getIndex", "()I", "", "giftName", "Ljava/lang/String;", "getGiftName", "()Ljava/lang/String;", "icon", "getIcon", "value", "getValue", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g {

    @SerializedName("gift_name")
    private final String giftName;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("index")
    private final int index;

    @SerializedName("value")
    private final int value;

    public g() {
        this(0, "", "", 0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L14;
        g r4 = (g) r3;
        if (this.index == r4.index) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.giftName, r4.giftName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L12;
        return false;
    L12:
        if (this.value == r4.value) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r0 = this.index * 31;
        String r1 = this.giftName;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.icon;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return ((r4 + r2) * 31) + this.value;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "Gift(index=" + this.index + ", giftName=" + this.giftName + ", icon=" + this.icon + ", value=" + this.value + ")";
    }

    public g(int r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "giftName");
        Intrinsics.checkNotNullParameter(r4, "icon");
        this.index = r2;
        this.giftName = r3;
        this.icon = r4;
        this.value = r5;
    }
}
