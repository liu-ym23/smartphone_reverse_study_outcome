package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.anchor.CreateLiveIdeaInfoResponse.Data")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/y0;", "", "Lcom/bytedance/android/live/broadcast/api/model/c;", "aiBrokerComponent", "Lcom/bytedance/android/live/broadcast/api/model/c;", "Lcom/bytedance/android/live/broadcast/api/model/r1;", "templateListComponent", "Lcom/bytedance/android/live/broadcast/api/model/r1;", "Lcom/bytedance/android/live/broadcast/api/model/x;", "createIdeaButtonComponent", "Lcom/bytedance/android/live/broadcast/api/model/x;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y0 implements vh7.h {

    @SerializedName("ai_broker_component")
    public c aiBrokerComponent;

    @SerializedName("create_idea_button_component")
    public x createIdeaButtonComponent;

    @SerializedName("template_list_component")
    public r1 templateListComponent;

    public y0() {
    }

    public y0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.aiBrokerComponent = new c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.templateListComponent = new r1(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.createIdeaButtonComponent = new x(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
