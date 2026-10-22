package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.ToolbarPermissionAlertResponse.Alert")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/d;", "", "", "title", "Ljava/lang/String;", "content", "scheme", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements vh7.h {

    @SerializedName("content")
    public String content;

    @SerializedName("scheme")
    public String scheme;

    @SerializedName("title")
    public String title;

    public d() {
        this.title = "";
        this.content = "";
        this.scheme = "";
    }

    public d(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.title = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.content = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.scheme = am3.h.c(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
        if (this.title != null) goto L19;
        this.title = "";
    L19:
        if (this.content != null) goto L22;
        this.content = "";
    L22:
        if (this.scheme != null) goto L37;
        this.scheme = "";
        return;
    }
}
