package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.BroadcastInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/b;", "", "", "type", "I", "", "content", "Ljava/lang/String;", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName("content")
    public String content;

    @SerializedName("type")
    public int type;

    public b() {
        this.type = 0;
        this.content = "";
    }

    public b(am3.g r8) {
        long r0 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L11;
        if (r4 != 1) goto L7;
        this.type = r8.i();
        r3 = r3 | true;
        goto L3
    L7:
        if (r4 != 2) goto L8;
        this.content = am3.h.c(r8);
        goto L3
    L8:
        am3.h.e(r8);
        goto L3
    L11:
        r8.d(r0);
        if ((r3 & true) == true) goto L15;
        this.type = 0;
    L15:
        if (this.content != null) goto L27;
        this.content = "";
        return;
    }
}
