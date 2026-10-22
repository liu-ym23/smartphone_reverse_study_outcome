package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.privilege.ScreenChatSettingGetResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/ScreenChatSettingGetResponse;", "", "Lcom/bytedance/android/live/broadcast/api/model/c0;", "data", "Lcom/bytedance/android/live/broadcast/api/model/c0;", "getData", "()Lcom/bytedance/android/live/broadcast/api/model/c0;", "setData", "(Lcom/bytedance/android/live/broadcast/api/model/c0;)V", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScreenChatSettingGetResponse implements vh7.h {

    @SerializedName("setting")
    protected c0 data;

    public ScreenChatSettingGetResponse() {
    }

    public ScreenChatSettingGetResponse(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.data = new c0(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final c0 getData() {
        return this.data;
    }

    public final void setData(c0 r1) {
        this.data = r1;
    }
}
