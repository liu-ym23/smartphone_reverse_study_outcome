package com.larus.business.debug.base.register.favorite.network.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/business/debug/base/register/favorite/network/bean/FavoriteEntranceUpdateRequestBean;", "", "uid", "", "platform", "data", "Lorg/json/JSONArray;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;)V", "getUid", "()Ljava/lang/String;", "getPlatform", "getData", "()Lorg/json/JSONArray;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FavoriteEntranceUpdateRequestBean {

    @SerializedName("data")
    private final JSONArray data;

    @SerializedName("platform")
    private final String platform;

    @SerializedName("uid")
    private final String uid;

    public FavoriteEntranceUpdateRequestBean() {
        this(null, null, null, 7, null);
    }

    public final JSONArray getData() {
        return this.data;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getUid() {
        return this.uid;
    }

    public FavoriteEntranceUpdateRequestBean(String r1, String r2, JSONArray r3) {
        this.uid = r1;
        this.platform = r2;
        this.data = r3;
    }

    public /* synthetic */ FavoriteEntranceUpdateRequestBean(String r2, String r3, JSONArray r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = new JSONArray();
    L11:
        this(r2, r3, r4);
    }
}
