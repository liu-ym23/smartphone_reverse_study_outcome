package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/cb;", "", "", "openSwitch", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "setOpenSwitch", "(Ljava/lang/Boolean;)V", "", "time", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setTime", "(Ljava/lang/Integer;)V", "", "token", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class cb {

    @SerializedName("openSwitch")
    private Boolean openSwitch;

    @SerializedName("time")
    private Integer time;

    @SerializedName("token")
    private String token;

    public cb() {
    }

    public final Boolean a() {
        return this.openSwitch;
    }

    public final Integer b() {
        return this.time;
    }

    public final String c() {
        return this.token;
    }
}
