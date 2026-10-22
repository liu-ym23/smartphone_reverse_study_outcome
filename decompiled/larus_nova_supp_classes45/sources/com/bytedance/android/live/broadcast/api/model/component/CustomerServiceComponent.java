package com.bytedance.android.live.broadcast.api.model.component;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.CustomerServiceComponent")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/component/CustomerServiceComponent;", "", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "base", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "", "entranceType", "Ljava/lang/Integer;", "Lcom/bytedance/android/live/broadcast/api/model/component/a;", "agentEntranceInfo", "Lcom/bytedance/android/live/broadcast/api/model/component/a;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomerServiceComponent implements h {

    @SerializedName("agent_entrance_info")
    public a agentEntranceInfo;

    @SerializedName("base")
    public BaseComponentModel base;

    @SerializedName("entrance_type")
    public Integer entranceType;

    public CustomerServiceComponent() {
    }

    public CustomerServiceComponent(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.base = new BaseComponentModel(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.entranceType = Integer.valueOf(r5.i());
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.agentEntranceInfo = new a(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
