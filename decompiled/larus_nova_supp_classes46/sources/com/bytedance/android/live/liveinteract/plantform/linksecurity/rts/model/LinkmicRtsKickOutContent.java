package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.model;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.z;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0016\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\n¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsKickOutContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/z;", "", "toString", "linkMicIdStr", "Ljava/lang/String;", "getLinkMicIdStr", "()Ljava/lang/String;", "setLinkMicIdStr", "(Ljava/lang/String;)V", "", "userId", "J", "getUserId", "()J", "setUserId", "(J)V", "toastStr", "getToastStr", "setToastStr", "", "needAck", "Z", "getNeedAck", "()Z", "setNeedAck", "(Z)V", "ackMessage", "getAckMessage", "setAckMessage", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicRtsKickOutContent extends FlexModelBase<z> implements z, h {

    @SerializedName("ack_message")
    protected String ackMessage;

    @SerializedName("linkmic_id_str")
    protected String linkMicIdStr;

    @SerializedName("need_ack")
    protected boolean needAck;

    @SerializedName("toast")
    protected String toastStr;
    private long userId;

    public LinkmicRtsKickOutContent() {
        super(z.class);
        this.linkMicIdStr = "";
        this.toastStr = "";
        this.ackMessage = "";
    }

    public String toString() {
        return "LinkmicRtsKickOutContent{linkMicIdStr=" + getLinkMicIdStr() + ", userId=" + getUserId() + ", toastStr=" + getToastStr() + ", needAck=" + getNeedAck() + ", ackMessage=" + getAckMessage() + '}';
    }

    public String getAckMessage() {
        return this.ackMessage;
    }

    public String getLinkMicIdStr() {
        return this.linkMicIdStr;
    }

    public boolean getNeedAck() {
        return this.needAck;
    }

    public String getToastStr() {
        return this.toastStr;
    }

    public long getUserId() {
        return this.userId;
    }

    public LinkmicRtsKickOutContent(g r6) {
        super(z.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.linkMicIdStr = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this.toastStr = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 4) goto L12;
        this.needAck = am3.h.a(r6);
        goto L3
    L12:
        if (r2 != 5) goto L13;
        this.ackMessage = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this.linkMicIdStr != null) goto L22;
        this.linkMicIdStr = "";
    L22:
        if (this.toastStr != null) goto L25;
        this.toastStr = "";
    L25:
        if (this.ackMessage != null) goto L43;
        this.ackMessage = "";
        return;
    }

    public void setAckMessage(String r1) {
        this.ackMessage = r1;
    }

    public void setLinkMicIdStr(String r1) {
        this.linkMicIdStr = r1;
    }

    public void setNeedAck(boolean r1) {
        this.needAck = r1;
    }

    public void setToastStr(String r1) {
        this.toastStr = r1;
    }

    public void setUserId(long r1) {
        this.userId = r1;
    }
}
