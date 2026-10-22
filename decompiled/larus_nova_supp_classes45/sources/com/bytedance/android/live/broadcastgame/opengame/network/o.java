package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.open.api.GetAPIConfigResponse.Data")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/o;", "", "", "", "banApiList", "Ljava/util/List;", "getBanApiList", "()Ljava/util/List;", "setBanApiList", "(Ljava/util/List;)V", "", "noUpdate", "Z", "getNoUpdate", "()Z", "setNoUpdate", "(Z)V", "hash", "Ljava/lang/String;", "getHash", "()Ljava/lang/String;", "setHash", "(Ljava/lang/String;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o implements vh7.h {

    @SerializedName("ban_api_list")
    protected List<String> banApiList;

    @SerializedName("hash")
    protected String hash;

    @SerializedName("no_update")
    protected boolean noUpdate;

    public o() {
        this.hash = "";
    }

    public o(am3.g r5) {
        this.banApiList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.banApiList.add(am3.h.c(r5));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.noUpdate = am3.h.a(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.hash = am3.h.c(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
        if (this.hash != null) goto L31;
        this.hash = "";
        return;
    }
}
