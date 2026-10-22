package com.bytedance.android.live.broadcast.api.model.component;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.TabConfig")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/component/c;", "", "", "tabKey", "I", "", "tabText", "Ljava/lang/String;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("tab_key")
    public int tabKey;

    @SerializedName("tab_text")
    public String tabText;

    public c() {
        this.tabKey = -1;
        this.tabText = "";
    }

    public c(g r7) {
        long r0 = r7.c();
        boolean r2 = false;
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L11;
        if (r3 != 1) goto L7;
        this.tabKey = r7.i();
        r2 = r2 | true;
        goto L3
    L7:
        if (r3 != 2) goto L8;
        this.tabText = am3.h.c(r7);
        goto L3
    L8:
        am3.h.e(r7);
        goto L3
    L11:
        r7.d(r0);
        if ((r2 & true) == true) goto L15;
        this.tabKey = -1;
    L15:
        if (this.tabText != null) goto L27;
        this.tabText = "";
        return;
    }
}
