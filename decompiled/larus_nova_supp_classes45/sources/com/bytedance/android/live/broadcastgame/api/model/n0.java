package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.stamp.GroupProperty.Selector")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/n0;", "", "", "", "categoryKeyList", "Ljava/util/List;", "defaultKey", "Ljava/lang/String;", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n0 implements vh7.h {
    public transient String a;

    @SerializedName("category_key_list")
    public List<String> categoryKeyList;

    @SerializedName("default_key")
    public String defaultKey;

    public n0() {
        this.a = this.defaultKey;
        this.categoryKeyList = new ArrayList();
        this.defaultKey = "";
    }

    public n0(am3.g r5) {
        this.categoryKeyList = new ArrayList();
        this.a = this.defaultKey;
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.categoryKeyList.add(am3.h.c(r5));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.defaultKey = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.categoryKeyList.isEmpty() == false) goto L16;
        this.categoryKeyList = new ArrayList();
    L16:
        if (this.defaultKey != null) goto L28;
        this.defaultKey = "";
        return;
    }
}
