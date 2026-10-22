package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.GetObsAuditStatusResponse.AuditStatus")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/t0;", "", "", "mObsAuditStatus", "J", "getMObsAuditStatus", "()J", "setMObsAuditStatus", "(J)V", "", "mApplyUrl", "Ljava/lang/String;", "getMApplyUrl", "()Ljava/lang/String;", "setMApplyUrl", "(Ljava/lang/String;)V", "mHoverText", "getMHoverText", "setMHoverText", "mObsDownloadUri", "getMObsDownloadUri", "setMObsDownloadUri", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t0 implements vh7.h {

    @SerializedName("obs_apply_uri")
    protected String mApplyUrl;

    @SerializedName("obs_hover_text")
    protected String mHoverText;

    @SerializedName("obs_audit_status")
    protected long mObsAuditStatus;

    @SerializedName("live_partner_download_uri")
    protected String mObsDownloadUri;

    public t0() {
    }

    public t0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.mObsAuditStatus = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.mApplyUrl = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.mHoverText = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.mObsDownloadUri = am3.h.c(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }
}
