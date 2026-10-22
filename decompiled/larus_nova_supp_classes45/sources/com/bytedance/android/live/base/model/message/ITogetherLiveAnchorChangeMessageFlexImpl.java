package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
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
@ProtoMessage("webcast.im.TogetherLiveChangeMemberMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bf\u0010gJ\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0004H\u0096\u0001J\t\u0010\b\u001a\u00020\u0004H\u0096\u0001J\t\u0010\t\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\u0004H\u0096\u0001J\t\u0010\r\u001a\u00020\nH\u0096\u0001J\t\u0010\u000e\u001a\u00020\nH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\t\u0010\u0013\u001a\u00020\nH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0017\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0011\u0010\u0018\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u001aH\u0096\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 H\u0096\u0001J\u0011\u0010%\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010&\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010'\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010(\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010*\u001a\u00020\"2\u0006\u0010)\u001a\u00020\nH\u0096\u0001J\u0011\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010,\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010-\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010/\u001a\u00020\"2\u0006\u0010.\u001a\u00020\nH\u0096\u0001J\u0019\u00100\u001a\u00020\"2\u000e\u0010$\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0011\u00101\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u00103\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0004H\u0096\u0001J\u0011\u00104\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aH\u0096\u0001J\u0019\u00105\u001a\u00020\"2\u000e\u0010$\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0011\u00106\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001R*\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010B\u001a\u0004\u0018\u00010=8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR+\u0010J\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR+\u0010N\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010E\u001a\u0004\bL\u0010G\"\u0004\bM\u0010IR;\u0010V\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010O2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010O8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010E\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR/\u0010\\\u001a\u0004\u0018\u00010\u00102\b\u0010C\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010E\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R/\u0010`\u001a\u0004\u0018\u00010\u00102\b\u0010C\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010E\u001a\u0004\b^\u0010Y\"\u0004\b_\u0010[R/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010C\u001a\u0004\u0018\u00010 8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\ba\u0010E\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006h"}, d2 = {"Lcom/bytedance/android/live/base/model/message/ITogetherLiveAnchorChangeMessageFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/j5;", "Lcom/bytedance/android/live/base/model/message/d3;", "", "getConsumeTime", "getDecodeEndTime", "getDecodeStartTime", "getDelayDispatchMs", "getEnqueueDispatchTime", "", "getGeneralMessageType", "getHttpSendTime", "getIntType", "getMessageFrom", "getMessageId", "", "kotlin.jvm.PlatformType", "getMessageMethod", "getPriority", "getReceiveTime", "getRoomId", "getTimestamp", "getWRDSKey", "getWRDSSubKey", "getWRDSVersion", "", "isFromFirstRequest", "isGlobalMessage", "isTimeCostCanUse", "isWRDSMessage", "needMonitor", "Lcom/bytedance/android/live/base/model/message/m0;", "common", "", "setCommonMessageData", "p0", "setConsumeTime", "setDecodeEndTime", "setDecodeStartTime", "setEnqueueDispatchTime", "generalMessageType", "setGeneralMessageType", "setHttpSendTime", "setIsFromFirstRequest", "setIsInsert", "messageFrom", "setMessageFrom", "setMessageMethod", "setReceiveTime", "timestamp", "setTimestamp", "setWRDSMessage", "setWRDSSubKey", "setWRDSVersion", "", "getMessageExtra", "()Ljava/util/Map;", "setMessageExtra", "(Ljava/util/Map;)V", "messageExtra", "", "getRawPayload", "()[B", "setRawPayload", "([B)V", "rawPayload", "<set-?>", "liveTogetherStatus$delegate", "Ljava/lang/Object;", "getLiveTogetherStatus", "()J", "setLiveTogetherStatus", "(J)V", "liveTogetherStatus", "entranceScene$delegate", "getEntranceScene", "setEntranceScene", "entranceScene", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "togetherAnchor$delegate", "getTogetherAnchor", "()Ljava/util/List;", "setTogetherAnchor", "(Ljava/util/List;)V", "togetherAnchor", "avatarTitle$delegate", "getAvatarTitle", "()Ljava/lang/String;", "setAvatarTitle", "(Ljava/lang/String;)V", "avatarTitle", "schemaUrl$delegate", "getSchemaUrl", "setSchemaUrl", "schemaUrl", "common$delegate", "getCommon", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommon", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITogetherLiveAnchorChangeMessageFlexImpl extends FlexModelBase<j5> implements j5, d3, vh7.h {
    private final /* synthetic */ g6 $$delegate_0;

    @SerializedName("title")
    protected String _$$avatarTitle;

    @SerializedName("common")
    protected m0 _$$common;

    @SerializedName("scene")
    protected long _$$entranceScene;

    @SerializedName("is_together_live")
    protected long _$$liveTogetherStatus;

    @SerializedName("schema_url")
    protected String _$$schemaUrl;

    @SerializedName("user_list")
    protected List<IBaseUser> _$$togetherAnchor;

    @Override // com.bytedance.android.live.base.model.message.j5
    public long getDelayDispatchMs() {
        return this.$$delegate_0.getDelayDispatchMs();
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public int getIntType() {
        this.$$delegate_0.getClass();
        return -1;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public long getMessageId() {
        return this.$$delegate_0.getMessageId();
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public int getPriority() {
        this.$$delegate_0.getClass();
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public long getRoomId() {
        return this.$$delegate_0.getRoomId();
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public String getWRDSKey() {
        return this.$$delegate_0.getWRDSKey();
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public boolean isGlobalMessage() {
        return this.$$delegate_0.isGlobalMessage();
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public boolean isTimeCostCanUse() {
        return this.$$delegate_0.isTimeCostCanUse();
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public boolean needMonitor() {
        return this.$$delegate_0.needMonitor();
    }

    public ITogetherLiveAnchorChangeMessageFlexImpl() {
        super(j5.class);
        this.$$delegate_0 = new g6();
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public long getConsumeTime() {
        return this.$$delegate_0.m;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public long getDecodeEndTime() {
        return this.$$delegate_0.k;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public long getDecodeStartTime() {
        return this.$$delegate_0.j;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public long getEnqueueDispatchTime() {
        return this.$$delegate_0.l;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public int getGeneralMessageType() {
        return this.$$delegate_0.d;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public long getHttpSendTime() {
        return this.$$delegate_0.h;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public Map<String, String> getMessageExtra() {
        return this.$$delegate_0.r;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public int getMessageFrom() {
        return this.$$delegate_0.b;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public String getMessageMethod() {
        return this.$$delegate_0.c;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public byte[] getRawPayload() {
        return this.$$delegate_0.q;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public long getReceiveTime() {
        return this.$$delegate_0.i;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public long getTimestamp() {
        return this.$$delegate_0.e;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public String getWRDSSubKey() {
        return this.$$delegate_0.p;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public long getWRDSVersion() {
        return this.$$delegate_0.o;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public boolean isFromFirstRequest() {
        return this.$$delegate_0.g;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public boolean isWRDSMessage() {
        return this.$$delegate_0.n;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final String getAvatarTitle() {
        return this._$$avatarTitle;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.c3
    public final m0 getCommon() {
        return this._$$common;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final long getEntranceScene() {
        return this._$$entranceScene;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final long getLiveTogetherStatus() {
        return this._$$liveTogetherStatus;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final String getSchemaUrl() {
        return this._$$schemaUrl;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final List<IBaseUser> getTogetherAnchor() {
        return this._$$togetherAnchor;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.message.m0, java.lang.Object] */
    public ITogetherLiveAnchorChangeMessageFlexImpl(am3.g r5) {
        super(j5.class);
        this.$$delegate_0 = new g6();
        this._$$togetherAnchor = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$entranceScene = r5.j();
        goto L3
    L9:
        this._$$schemaUrl = am3.h.c(r5);
        goto L3
    L10:
        this._$$avatarTitle = am3.h.c(r5);
        goto L3
    L11:
        this._$$togetherAnchor.add((IBaseUser) vh7.f.a(r5, IBaseUser.class));
        goto L3
    L12:
        this._$$liveTogetherStatus = r5.j();
        goto L3
    L13:
        this._$$common = vh7.f.a(r5, m0.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final void setAvatarTitle(String r1) {
        this._$$avatarTitle = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final void setCommon(m0 r1) {
        this._$$common = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public void setCommonMessageData(m0 r2) {
        this.$$delegate_0.a = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setConsumeTime(long r2) {
        this.$$delegate_0.m = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setDecodeEndTime(long r2) {
        this.$$delegate_0.k = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setDecodeStartTime(long r2) {
        this.$$delegate_0.j = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setEnqueueDispatchTime(long r2) {
        this.$$delegate_0.l = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final void setEntranceScene(long r1) {
        this._$$entranceScene = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public void setGeneralMessageType(int r2) {
        this.$$delegate_0.d = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setHttpSendTime(long r2) {
        this.$$delegate_0.h = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setIsFromFirstRequest(boolean r2) {
        this.$$delegate_0.g = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setIsInsert(boolean r2) {
        this.$$delegate_0.f = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final void setLiveTogetherStatus(long r1) {
        this._$$liveTogetherStatus = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public void setMessageExtra(Map<String, String> r2) {
        this.$$delegate_0.r = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public void setMessageFrom(int r2) {
        this.$$delegate_0.b = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setMessageMethod(String r2) {
        this.$$delegate_0.c = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public void setRawPayload(byte[] r2) {
        this.$$delegate_0.q = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setReceiveTime(long r2) {
        this.$$delegate_0.i = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final void setSchemaUrl(String r1) {
        this._$$schemaUrl = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.j5, com.bytedance.android.live.base.model.message.d3
    public void setTimestamp(long r2) {
        this.$$delegate_0.e = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public final void setTogetherAnchor(List<IBaseUser> r1) {
        this._$$togetherAnchor = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setWRDSMessage(boolean r2) {
        this.$$delegate_0.n = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setWRDSSubKey(String r2) {
        this.$$delegate_0.p = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.j5
    public void setWRDSVersion(long r2) {
        this.$$delegate_0.o = r2;
    }
}
