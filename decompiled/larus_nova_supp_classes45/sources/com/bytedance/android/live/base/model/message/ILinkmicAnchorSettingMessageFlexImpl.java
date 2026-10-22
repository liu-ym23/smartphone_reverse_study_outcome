package com.bytedance.android.live.base.model.message;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.LinkmicAnchorSettingMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bR\u0010SJ\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0004H\u0096\u0001J\t\u0010\b\u001a\u00020\u0004H\u0096\u0001J\t\u0010\t\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\u0004H\u0096\u0001J\t\u0010\r\u001a\u00020\nH\u0096\u0001J\t\u0010\u000e\u001a\u00020\nH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\t\u0010\u0013\u001a\u00020\nH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0017\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0011\u0010\u0018\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u001aH\u0096\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 H\u0096\u0001J\u0011\u0010%\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010&\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010'\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010(\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010*\u001a\u00020\"2\u0006\u0010)\u001a\u00020\nH\u0096\u0001J\u0011\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010,\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010-\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010/\u001a\u00020\"2\u0006\u0010.\u001a\u00020\nH\u0096\u0001J\u0019\u00100\u001a\u00020\"2\u000e\u0010$\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0011\u00101\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u00103\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0004H\u0096\u0001J\u0011\u00104\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aH\u0096\u0001J\u0019\u00105\u001a\u00020\"2\u000e\u0010$\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0011\u00106\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001R*\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010B\u001a\u0004\u0018\u00010=8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR7\u0010L\u001a\b\u0012\u0004\u0012\u00020D0C2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010E\u001a\u0004\u0018\u00010 8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010G\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006T"}, d2 = {"Lcom/bytedance/android/live/base/model/message/ILinkmicAnchorSettingMessageFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/ILinkmicAnchorSettingMessage;", "Lcom/bytedance/android/live/base/model/message/d3;", "", "getConsumeTime", "getDecodeEndTime", "getDecodeStartTime", "getDelayDispatchMs", "getEnqueueDispatchTime", "", "getGeneralMessageType", "getHttpSendTime", "getIntType", "getMessageFrom", "getMessageId", "", "kotlin.jvm.PlatformType", "getMessageMethod", "getPriority", "getReceiveTime", "getRoomId", "getTimestamp", "getWRDSKey", "getWRDSSubKey", "getWRDSVersion", "", "isFromFirstRequest", "isGlobalMessage", "isTimeCostCanUse", "isWRDSMessage", "needMonitor", "Lcom/bytedance/android/live/base/model/message/m0;", "common", "", "setCommonMessageData", "p0", "setConsumeTime", "setDecodeEndTime", "setDecodeStartTime", "setEnqueueDispatchTime", "generalMessageType", "setGeneralMessageType", "setHttpSendTime", "setIsFromFirstRequest", "setIsInsert", "messageFrom", "setMessageFrom", "setMessageMethod", "setReceiveTime", "timestamp", "setTimestamp", "setWRDSMessage", "setWRDSSubKey", "setWRDSVersion", "", "getMessageExtra", "()Ljava/util/Map;", "setMessageExtra", "(Ljava/util/Map;)V", "messageExtra", "", "getRawPayload", "()[B", "setRawPayload", "([B)V", "rawPayload", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/y;", "<set-?>", "setting$delegate", "Ljava/lang/Object;", "getSetting", "()Ljava/util/List;", "setSetting", "(Ljava/util/List;)V", "setting", "common$delegate", "getCommon", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommon", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicAnchorSettingMessageFlexImpl extends FlexModelBase<ILinkmicAnchorSettingMessage> implements ILinkmicAnchorSettingMessage, d3, vh7.h {
    private final /* synthetic */ g6 $$delegate_0;

    @SerializedName("common")
    protected m0 _$$common;

    @SerializedName("settings")
    protected List<? extends com.bytedance.android.livesdk.chatroom.interact.model.y> _$$setting;

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public long getDelayDispatchMs() {
        return this.$$delegate_0.getDelayDispatchMs();
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public int getIntType() {
        this.$$delegate_0.getClass();
        return -1;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public long getMessageId() {
        return this.$$delegate_0.getMessageId();
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public int getPriority() {
        this.$$delegate_0.getClass();
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public long getRoomId() {
        return this.$$delegate_0.getRoomId();
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public String getWRDSKey() {
        return this.$$delegate_0.getWRDSKey();
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public boolean isGlobalMessage() {
        return this.$$delegate_0.isGlobalMessage();
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public boolean isTimeCostCanUse() {
        return this.$$delegate_0.isTimeCostCanUse();
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public boolean needMonitor() {
        return this.$$delegate_0.needMonitor();
    }

    public ILinkmicAnchorSettingMessageFlexImpl() {
        super(ILinkmicAnchorSettingMessage.class);
        this.$$delegate_0 = new g6();
        this._$$setting = $defaultValue_setting$();
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public long getConsumeTime() {
        return this.$$delegate_0.m;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public long getDecodeEndTime() {
        return this.$$delegate_0.k;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public long getDecodeStartTime() {
        return this.$$delegate_0.j;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public long getEnqueueDispatchTime() {
        return this.$$delegate_0.l;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public int getGeneralMessageType() {
        return this.$$delegate_0.d;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public long getHttpSendTime() {
        return this.$$delegate_0.h;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public Map<String, String> getMessageExtra() {
        return this.$$delegate_0.r;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public int getMessageFrom() {
        return this.$$delegate_0.b;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public String getMessageMethod() {
        return this.$$delegate_0.c;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public byte[] getRawPayload() {
        return this.$$delegate_0.q;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public long getReceiveTime() {
        return this.$$delegate_0.i;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public long getTimestamp() {
        return this.$$delegate_0.e;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public String getWRDSSubKey() {
        return this.$$delegate_0.p;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public long getWRDSVersion() {
        return this.$$delegate_0.o;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public boolean isFromFirstRequest() {
        return this.$$delegate_0.g;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public boolean isWRDSMessage() {
        return this.$$delegate_0.n;
    }

    public final List<com.bytedance.android.livesdk.chatroom.interact.model.y> $defaultValue_setting$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.c3
    public final m0 getCommon() {
        return this._$$common;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public final List<com.bytedance.android.livesdk.chatroom.interact.model.y> getSetting() {
        return this._$$setting;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.message.m0, java.lang.Object] */
    public ILinkmicAnchorSettingMessageFlexImpl(am3.g r6) {
        super(ILinkmicAnchorSettingMessage.class);
        this.$$delegate_0 = new g6();
        this._$$setting = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$common = vh7.f.a(r6, m0.class);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$setting.add(vh7.f.a(r6, com.bytedance.android.livesdk.chatroom.interact.model.y.class));
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$setting.isEmpty() == false) goto L25;
        this._$$setting = $defaultValue_setting$();
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public final void setCommon(m0 r1) {
        this._$$common = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public void setCommonMessageData(m0 r2) {
        this.$$delegate_0.a = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setConsumeTime(long r2) {
        this.$$delegate_0.m = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setDecodeEndTime(long r2) {
        this.$$delegate_0.k = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setDecodeStartTime(long r2) {
        this.$$delegate_0.j = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setEnqueueDispatchTime(long r2) {
        this.$$delegate_0.l = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public void setGeneralMessageType(int r2) {
        this.$$delegate_0.d = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setHttpSendTime(long r2) {
        this.$$delegate_0.h = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setIsFromFirstRequest(boolean r2) {
        this.$$delegate_0.g = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setIsInsert(boolean r2) {
        this.$$delegate_0.f = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public void setMessageExtra(Map<String, String> r2) {
        this.$$delegate_0.r = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public void setMessageFrom(int r2) {
        this.$$delegate_0.b = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setMessageMethod(String r2) {
        this.$$delegate_0.c = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public void setRawPayload(byte[] r2) {
        this.$$delegate_0.q = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setReceiveTime(long r2) {
        this.$$delegate_0.i = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public final void setSetting(List<? extends com.bytedance.android.livesdk.chatroom.interact.model.y> r1) {
        this._$$setting = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage, com.bytedance.android.live.base.model.message.d3
    public void setTimestamp(long r2) {
        this.$$delegate_0.e = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setWRDSMessage(boolean r2) {
        this.$$delegate_0.n = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setWRDSSubKey(String r2) {
        this.$$delegate_0.p = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.ILinkmicAnchorSettingMessage
    public void setWRDSVersion(long r2) {
        this.$$delegate_0.o = r2;
    }
}
