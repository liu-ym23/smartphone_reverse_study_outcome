package com.bytedance.android.live.cloudgrouplive.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.anchor.GetCloudCollaborateInfoResp.Data")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/model/d;", "", "", "collaborateStatus", "Ljava/lang/Integer;", "getCollaborateStatus", "()Ljava/lang/Integer;", "", "Lcom/bytedance/android/live/cloudgrouplive/model/c;", "userInfos", "Ljava/util/List;", "getUserInfos", "()Ljava/util/List;", "", "startTime", "Ljava/lang/Long;", "getStartTime", "()Ljava/lang/Long;", "", "extra", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d implements h {

    @SerializedName("collaborate_status")
    protected Integer collaborateStatus;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("start_time")
    protected Long startTime;

    @SerializedName("user_infos")
    protected List<c> userInfos;

    public d() {
    }

    public d(g r5) {
        this.userInfos = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.collaborateStatus = Integer.valueOf((int) r5.j());
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.userInfos.add(new c(r5));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.startTime = Long.valueOf(r5.j());
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.extra = am3.h.c(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }
}
