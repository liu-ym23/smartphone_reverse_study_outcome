package com.bytedance.android.live.broadcast.api.model.component;

import am3.g;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.BottomToolBarComponent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/component/BottomToolBarComponent;", "", "()V", "base", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "bottomDescText", "Lcom/bytedance/android/livesdkapi/message/Text;", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomToolBarComponent implements h {

    @SerializedName("base")
    public BaseComponentModel base;

    @SerializedName("full_create_page_desc")
    public Text bottomDescText;

    public BottomToolBarComponent() {
    }

    public BottomToolBarComponent(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.base = new BaseComponentModel(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.bottomDescText = _Text_ProtoDecoder.decodeStatic(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }
}
