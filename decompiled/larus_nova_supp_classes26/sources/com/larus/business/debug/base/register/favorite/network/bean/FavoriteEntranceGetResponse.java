package com.larus.business.debug.base.register.favorite.network.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/business/debug/base/register/favorite/network/bean/FavoriteEntranceGetResponse;", "", "success", "", "message", "", "data", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getMessage", "()Ljava/lang/String;", "getData", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FavoriteEntranceGetResponse {

    @SerializedName("data")
    private final String data;

    @SerializedName("message")
    private final String message;

    @SerializedName("success")
    private final boolean success;

    public FavoriteEntranceGetResponse() {
        this(false, null, null, 7, null);
    }

    public final String getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public FavoriteEntranceGetResponse(boolean r1, String r2, String r3) {
        this.success = r1;
        this.message = r2;
        this.data = r3;
    }

    public /* synthetic */ FavoriteEntranceGetResponse(boolean r1, String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = "";
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }
}
