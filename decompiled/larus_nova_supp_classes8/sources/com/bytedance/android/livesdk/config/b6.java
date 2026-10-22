package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/b6;", "", "", "enableEnterMsg", "I", "getEnableEnterMsg", "()I", "enableCardMsg", "getEnableCardMsg", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b6 {

    @SerializedName("enable_explain_card_message")
    private final int enableCardMsg;

    @SerializedName("enable_user_enter_message")
    private final int enableEnterMsg;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b6) == false) goto L10;
        b6 r4 = (b6) r3;
        if (this.enableEnterMsg == r4.enableEnterMsg) goto L8;
        return false;
    L8:
        if (this.enableCardMsg == r4.enableCardMsg) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.enableEnterMsg * 31) + this.enableCardMsg;
    }

    public final String toString() {
        return "GameDownloadMessageConfig(enableEnterMsg=" + this.enableEnterMsg + ", enableCardMsg=" + this.enableCardMsg + ")";
    }

    public b6() {
        this.enableEnterMsg = 0;
        this.enableCardMsg = 0;
    }
}
