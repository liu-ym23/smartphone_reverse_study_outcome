package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.ToolbarPermissionAlertResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/s1;", "", "", "hasPermission", "Ljava/lang/Boolean;", "Lcom/bytedance/android/live/broadcast/api/model/d;", "alert", "Lcom/bytedance/android/live/broadcast/api/model/d;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s1 implements vh7.h {

    @SerializedName("alert")
    public d alert;

    @SerializedName("has_permission")
    public Boolean hasPermission;

    public s1() {
        this.hasPermission = Boolean.FALSE;
    }

    public s1(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.hasPermission = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.alert = new d(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.hasPermission != null) goto L25;
        this.hasPermission = Boolean.FALSE;
        return;
    }
}
