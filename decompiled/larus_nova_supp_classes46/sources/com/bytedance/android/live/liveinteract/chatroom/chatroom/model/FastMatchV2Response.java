package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import am3.g;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/FastMatchV2Response;", "", "()V", "requestId", "", "resultItem", "", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/FastMatchV2ResultItem;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FastMatchV2Response implements h {

    @SerializedName("req_id")
    public String requestId;

    @SerializedName("result_item")
    public List<FastMatchV2ResultItem> resultItem;

    public FastMatchV2Response() {
    }

    public FastMatchV2Response(g r5) {
        this.resultItem = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.resultItem.add(new FastMatchV2ResultItem(r5));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.requestId = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }
}
