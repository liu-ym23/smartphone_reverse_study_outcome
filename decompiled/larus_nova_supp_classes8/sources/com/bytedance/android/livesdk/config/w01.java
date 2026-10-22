package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/w01;", "", "", "reserveBtnText", "Ljava/lang/String;", "getReserveBtnText", "()Ljava/lang/String;", "setReserveBtnText", "(Ljava/lang/String;)V", "reserveCancelBtnText", "getReserveCancelBtnText", "setReserveCancelBtnText", "matchBtnText", "getMatchBtnText", "setMatchBtnText", "matchCancelBtnText", "getMatchCancelBtnText", "setMatchCancelBtnText", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w01 {

    @SerializedName("match")
    private String matchBtnText;

    @SerializedName("cancel_match")
    private String matchCancelBtnText;

    @SerializedName("reserve")
    private String reserveBtnText;

    @SerializedName("cancel_reserve")
    private String reserveCancelBtnText;

    public w01() {
        this.reserveBtnText = com.bytedance.android.live.core.utils.s1.B(2131918762);
        this.reserveCancelBtnText = com.bytedance.android.live.core.utils.s1.B(2131918761);
        this.matchBtnText = com.bytedance.android.live.core.utils.s1.B(2131918759);
        this.matchCancelBtnText = com.bytedance.android.live.core.utils.s1.B(2131918758);
    }
}
