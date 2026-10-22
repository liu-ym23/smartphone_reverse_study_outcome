package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.model;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdk.multilink.base.model.a0;
import com.bytedance.android.livesdk.multilink.base.model.q;
import com.bytedance.android.livesdk.multilink.base.model.z;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkMicRtsMessage;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/q;", "", "toString", "", "messageType", "I", "getMessageType", "()I", "setMessageType", "(I)V", "", "channelId", "J", "getChannelId", "()J", "setChannelId", "(J)V", "", "mockFilterUidList", "Ljava/util/List;", "getMockFilterUidList", "()Ljava/util/List;", "setMockFilterUidList", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsUpdateLinkStatusContent;", "updateLinkStatusContent", "Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsUpdateLinkStatusContent;", "getUpdateLinkStatusContent", "()Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsUpdateLinkStatusContent;", "setUpdateLinkStatusContent", "(Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsUpdateLinkStatusContent;)V", "Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsKickOutContent;", "kickOutContent", "Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsKickOutContent;", "getKickOutContent", "()Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsKickOutContent;", "setKickOutContent", "(Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsKickOutContent;)V", "<init>", "()V", "Companion", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public final class LinkMicRtsMessage extends FlexModelBase<q> implements q, h {
    public static final a Companion = null;
    public static final int MESSAGE_TYPE_KICK_OUT = 2;
    public static final int MESSAGE_TYPE_LINK_STATUS = 1;
    public static final int MESSAGE_TYPE_UNKNOWN = 0;

    @SerializedName("channel_id")
    protected long channelId;

    @SerializedName("kick_out_content")
    protected LinkmicRtsKickOutContent kickOutContent;

    @SerializedName("message_type")
    protected int messageType;

    @SerializedName("filter_uids")
    protected List<Long> mockFilterUidList;

    @SerializedName("update_link_status_content")
    protected LinkmicRtsUpdateLinkStatusContent updateLinkStatusContent;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LinkMicRtsMessage() {
        super(q.class);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("LinkMicRtsMessage{messageType=");
        r0.append(getMessageType());
        r0.append(", channelId=");
        r0.append(getChannelId());
        r0.append(", updateLinkStatusContent=");
        LinkmicRtsUpdateLinkStatusContent r1 = getUpdateLinkStatusContent();
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.toString();
        if (r3 == null) goto L6;
    L7:
        r0.append(r3);
        r0.append(", kickOutContent=");
        LinkmicRtsKickOutContent r4 = getKickOutContent();
        if (r4 == null) goto L13;
        String r5 = r4.toString();
        if (r5 == null) goto L13;
        r2 = r5;
    L13:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L6:
        r3 = "";
        goto L7
    }

    /* JADX INFO: renamed from: getKickOutContent, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ z m251getKickOutContent() {
        return getKickOutContent();
    }

    /* JADX INFO: renamed from: getUpdateLinkStatusContent, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ a0 m252getUpdateLinkStatusContent() {
        return getUpdateLinkStatusContent();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public List<Long> getMockFilterUidList() {
        return this.mockFilterUidList;
    }

    public LinkmicRtsKickOutContent getKickOutContent() {
        return this.kickOutContent;
    }

    public LinkmicRtsUpdateLinkStatusContent getUpdateLinkStatusContent() {
        return this.updateLinkStatusContent;
    }

    public LinkMicRtsMessage(g r6) {
        super(q.class);
        this.mockFilterUidList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.messageType = (int) r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.channelId = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.updateLinkStatusContent = new LinkmicRtsUpdateLinkStatusContent(r6);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.kickOutContent = new LinkmicRtsKickOutContent(r6);
        goto L3
    L14:
        if (r2 != 200) goto L15;
        this.mockFilterUidList.add(Long.valueOf(r6.j()));
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setChannelId(long r1) {
        this.channelId = r1;
    }

    public void setKickOutContent(LinkmicRtsKickOutContent r1) {
        this.kickOutContent = r1;
    }

    public void setMessageType(int r1) {
        this.messageType = r1;
    }

    public void setMockFilterUidList(List<Long> r1) {
        this.mockFilterUidList = r1;
    }

    public void setUpdateLinkStatusContent(LinkmicRtsUpdateLinkStatusContent r1) {
        this.updateLinkStatusContent = r1;
    }
}
