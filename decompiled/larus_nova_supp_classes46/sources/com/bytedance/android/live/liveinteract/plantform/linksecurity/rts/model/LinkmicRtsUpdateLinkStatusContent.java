package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.model;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.a0;
import com.bytedance.android.livesdk.multilink.base.model.b0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR\"\u0010!\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\"\u0010$\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010(\u001a\u00020'8\u0016X\u0097D¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010\b¨\u00060"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsUpdateLinkStatusContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/a0;", "", "toString", "targetLinkMicIdStr", "Ljava/lang/String;", "getTargetLinkMicIdStr", "()Ljava/lang/String;", "setTargetLinkMicIdStr", "(Ljava/lang/String;)V", "", "linkType", "I", "getLinkType", "()I", "setLinkType", "(I)V", "silenceStatus", "getSilenceStatus", "setSilenceStatus", "", "isKtv", "Z", "()Z", "setKtv", "(Z)V", "needAck", "getNeedAck", "setNeedAck", "ackMessage", "getAckMessage", "setAckMessage", "forceResumeVideoStream", "getForceResumeVideoStream", "setForceResumeVideoStream", "forceResumeAudioStream", "getForceResumeAudioStream", "setForceResumeAudioStream", "", "targetAwemeUid", "J", "getTargetAwemeUid", "()J", "targetOpenId", "getTargetOpenId", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicRtsUpdateLinkStatusContent extends FlexModelBase<a0> implements a0, h {

    @SerializedName("ack_message")
    protected String ackMessage;

    @SerializedName("force_resume_audio_stream")
    protected boolean forceResumeAudioStream;

    @SerializedName("force_resume_video_stream")
    protected boolean forceResumeVideoStream;

    @SerializedName("is_ktv")
    protected boolean isKtv;

    @SerializedName("link_type")
    protected int linkType;

    @SerializedName("need_ack")
    protected boolean needAck;

    @SerializedName("silence_status")
    protected int silenceStatus;

    @SerializedName("target_user_id")
    protected long targetAwemeUid;

    @SerializedName("target_linkmic_id_str")
    protected String targetLinkMicIdStr;

    @SerializedName("target_open_id")
    protected String targetOpenId;

    public LinkmicRtsUpdateLinkStatusContent() {
        super(a0.class);
        this.targetLinkMicIdStr = "";
        this.linkType = 2;
        this.ackMessage = "";
        this.targetOpenId = "";
    }

    public String toString() {
        return "LinkmicRtsUpdateLinkStatusContent{targetLinkMicIdStr=" + getTargetLinkMicIdStr() + ", targetUid=" + b0.a(this) + ", linkType=" + getLinkType() + ", silenceStatus=" + getSilenceStatus() + ", isKtv=" + isKtv() + ", needAck=" + getNeedAck() + ", ackMessage=" + getAckMessage() + '}';
    }

    public String getAckMessage() {
        return this.ackMessage;
    }

    public boolean getForceResumeAudioStream() {
        return this.forceResumeAudioStream;
    }

    public boolean getForceResumeVideoStream() {
        return this.forceResumeVideoStream;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public boolean getNeedAck() {
        return this.needAck;
    }

    public int getSilenceStatus() {
        return this.silenceStatus;
    }

    public long getTargetAwemeUid() {
        return this.targetAwemeUid;
    }

    public String getTargetLinkMicIdStr() {
        return this.targetLinkMicIdStr;
    }

    public String getTargetOpenId() {
        return this.targetOpenId;
    }

    public boolean isKtv() {
        return this.isKtv;
    }

    public LinkmicRtsUpdateLinkStatusContent(g r7) {
        super(a0.class);
        boolean r0 = false;
        setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L19;
        g.a r4 = decodeExtensionFields(r3, r7);
        if (r3 != 5000) goto L7;
        this.targetOpenId = am3.h.c(r7);
        goto L3
    L7:
        switch(r3) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            default: goto L8;
        };
    L9:
        this.forceResumeAudioStream = am3.h.a(r7);
        goto L3
    L10:
        this.forceResumeVideoStream = am3.h.a(r7);
        goto L3
    L11:
        this.ackMessage = am3.h.c(r7);
        goto L3
    L12:
        this.needAck = am3.h.a(r7);
        goto L3
    L13:
        this.isKtv = am3.h.a(r7);
        goto L3
    L14:
        this.silenceStatus = r7.i();
        goto L3
    L15:
        this.linkType = r7.i();
        r0 = r0 | true;
        goto L3
    L16:
        this.targetAwemeUid = r7.j();
        goto L3
    L17:
        this.targetLinkMicIdStr = am3.h.c(r7);
        goto L3
    L8:
        am3.h.d(r4, r7);
        goto L3
    L19:
        r7.d(r1);
        setThreadSafe(true);
        if (this.targetLinkMicIdStr != null) goto L23;
        this.targetLinkMicIdStr = "";
    L23:
        if ((true & r0) == true) goto L26;
        this.linkType = 2;
    L26:
        if (this.ackMessage != null) goto L29;
        this.ackMessage = "";
    L29:
        if (this.targetOpenId != null) goto L57;
        this.targetOpenId = "";
        return;
    }

    public void setAckMessage(String r1) {
        this.ackMessage = r1;
    }

    public void setForceResumeAudioStream(boolean r1) {
        this.forceResumeAudioStream = r1;
    }

    public void setForceResumeVideoStream(boolean r1) {
        this.forceResumeVideoStream = r1;
    }

    public void setKtv(boolean r1) {
        this.isKtv = r1;
    }

    public void setLinkType(int r1) {
        this.linkType = r1;
    }

    public void setNeedAck(boolean r1) {
        this.needAck = r1;
    }

    public void setSilenceStatus(int r1) {
        this.silenceStatus = r1;
    }

    public void setTargetLinkMicIdStr(String r1) {
        this.targetLinkMicIdStr = r1;
    }
}
