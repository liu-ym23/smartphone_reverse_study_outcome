package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.HotChatMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B\t¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0004H\u0096\u0001J\t\u0010\b\u001a\u00020\u0004H\u0096\u0001J\t\u0010\t\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\u0004H\u0096\u0001J\t\u0010\r\u001a\u00020\nH\u0096\u0001J\t\u0010\u000e\u001a\u00020\nH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\t\u0010\u0013\u001a\u00020\nH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0017\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0011\u0010\u0018\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u001aH\u0096\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 H\u0096\u0001J\u0011\u0010%\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010&\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010'\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010(\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010*\u001a\u00020\"2\u0006\u0010)\u001a\u00020\nH\u0096\u0001J\u0011\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010,\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010-\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010/\u001a\u00020\"2\u0006\u0010.\u001a\u00020\nH\u0096\u0001J\u0019\u00100\u001a\u00020\"2\u000e\u0010$\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0011\u00101\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u00103\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0004H\u0096\u0001J\u0011\u00104\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aH\u0096\u0001J\u0019\u00105\u001a\u00020\"2\u000e\u0010$\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0011\u00106\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001R*\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010B\u001a\u0004\u0018\u00010=8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR/\u0010J\u001a\u0004\u0018\u00010\u00102\b\u0010C\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR/\u0010N\u001a\u0004\u0018\u00010\u00102\b\u0010C\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010E\u001a\u0004\bL\u0010G\"\u0004\bM\u0010IR;\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010O2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010O8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010E\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR+\u0010[\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010E\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR;\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010O2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010O8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010E\u001a\u0004\b]\u0010R\"\u0004\b^\u0010TR+\u0010c\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010E\u001a\u0004\ba\u0010X\"\u0004\bb\u0010ZR;\u0010g\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010O2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010O8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010E\u001a\u0004\be\u0010R\"\u0004\bf\u0010TR/\u0010n\u001a\u0004\u0018\u00010h2\b\u0010C\u001a\u0004\u0018\u00010h8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bi\u0010E\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR+\u0010r\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bo\u0010E\u001a\u0004\bp\u0010X\"\u0004\bq\u0010ZRG\u0010w\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010s2\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010s8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bt\u0010E\u001a\u0004\bu\u00109\"\u0004\bv\u0010;R/\u0010~\u001a\u0004\u0018\u00010x2\b\u0010C\u001a\u0004\u0018\u00010x8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\by\u0010E\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R3\u0010!\u001a\u0004\u0018\u00010 2\b\u0010C\u001a\u0004\u0018\u00010 8V@VX\u0096\u008e\u0002¢\u0006\u0016\n\u0004\b\u007f\u0010E\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0086\u0001"}, d2 = {"Lcom/bytedance/android/live/base/model/message/IHotGatherMessageFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/f1;", "Lcom/bytedance/android/live/base/model/message/d3;", "", "getConsumeTime", "getDecodeEndTime", "getDecodeStartTime", "getDelayDispatchMs", "getEnqueueDispatchTime", "", "getGeneralMessageType", "getHttpSendTime", "getIntType", "getMessageFrom", "getMessageId", "", "kotlin.jvm.PlatformType", "getMessageMethod", "getPriority", "getReceiveTime", "getRoomId", "getTimestamp", "getWRDSKey", "getWRDSSubKey", "getWRDSVersion", "", "isFromFirstRequest", "isGlobalMessage", "isTimeCostCanUse", "isWRDSMessage", "needMonitor", "Lcom/bytedance/android/live/base/model/message/m0;", "common", "", "setCommonMessageData", "p0", "setConsumeTime", "setDecodeEndTime", "setDecodeStartTime", "setEnqueueDispatchTime", "generalMessageType", "setGeneralMessageType", "setHttpSendTime", "setIsFromFirstRequest", "setIsInsert", "messageFrom", "setMessageFrom", "setMessageMethod", "setReceiveTime", "timestamp", "setTimestamp", "setWRDSMessage", "setWRDSSubKey", "setWRDSVersion", "", "getMessageExtra", "()Ljava/util/Map;", "setMessageExtra", "(Ljava/util/Map;)V", "messageExtra", "", "getRawPayload", "()[B", "setRawPayload", "([B)V", "rawPayload", "<set-?>", "title$delegate", "Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "content$delegate", "getContent", "setContent", "content", "", "num$delegate", "getNum", "()Ljava/util/List;", "setNum", "(Ljava/util/List;)V", "num", "duration$delegate", "getDuration", "()J", "setDuration", "(J)V", "duration", "showDuration$delegate", "getShowDuration", "setShowDuration", "showDuration", "sequenceId$delegate", "getSequenceId", "setSequenceId", "sequenceId", "hotList$delegate", "getHotList", "setHotList", "hotList", "Lcom/bytedance/android/live/base/model/message/a5;", "rtfContent$delegate", "getRtfContent", "()Lcom/bytedance/android/live/base/model/message/a5;", "setRtfContent", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "rtfContent", "chatContentType$delegate", "getChatContentType", "setChatContentType", "chatContentType", "", "extra$delegate", "getExtra", "setExtra", "extra", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "highlightAreaPriorityConfig$delegate", "getHighlightAreaPriorityConfig", "()Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "setHighlightAreaPriorityConfig", "(Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;)V", "highlightAreaPriorityConfig", "common$delegate", "getCommon", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommon", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IHotGatherMessageFlexImpl extends FlexModelBase<f1> implements f1, d3, vh7.h {
    private final /* synthetic */ g6 $$delegate_0;

    @SerializedName("chat_content_type")
    protected long _$$chatContentType;

    @SerializedName("common")
    protected m0 _$$common;

    @SerializedName("content")
    protected String _$$content;

    @SerializedName("duration")
    protected long _$$duration;

    @SerializedName("extra")
    protected Map<String, String> _$$extra;

    @SerializedName("highlight_area_priority_config")
    protected HighlightAreaPriorityConfig _$$highlightAreaPriorityConfig;

    @SerializedName("hot_list")
    protected List<String> _$$hotList;

    @SerializedName("num")
    protected List<Long> _$$num;

    @SerializedName("rtf_content")
    protected a5 _$$rtfContent;

    @SerializedName("sequence_id")
    protected long _$$sequenceId;

    @SerializedName("show_duration")
    protected List<Long> _$$showDuration;

    @SerializedName("title")
    protected String _$$title;

    @Override // com.bytedance.android.live.base.model.message.f1
    public long getDelayDispatchMs() {
        return this.$$delegate_0.getDelayDispatchMs();
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public int getIntType() {
        this.$$delegate_0.getClass();
        return -1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public long getMessageId() {
        return this.$$delegate_0.getMessageId();
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public int getPriority() {
        this.$$delegate_0.getClass();
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public long getRoomId() {
        return this.$$delegate_0.getRoomId();
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public String getWRDSKey() {
        return this.$$delegate_0.getWRDSKey();
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public boolean isGlobalMessage() {
        return this.$$delegate_0.isGlobalMessage();
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public boolean isTimeCostCanUse() {
        return this.$$delegate_0.isTimeCostCanUse();
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public boolean needMonitor() {
        return this.$$delegate_0.needMonitor();
    }

    public IHotGatherMessageFlexImpl() {
        super(f1.class);
        this.$$delegate_0 = new g6();
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public long getConsumeTime() {
        return this.$$delegate_0.m;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public long getDecodeEndTime() {
        return this.$$delegate_0.k;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public long getDecodeStartTime() {
        return this.$$delegate_0.j;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public long getEnqueueDispatchTime() {
        return this.$$delegate_0.l;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public int getGeneralMessageType() {
        return this.$$delegate_0.d;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public long getHttpSendTime() {
        return this.$$delegate_0.h;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public Map<String, String> getMessageExtra() {
        return this.$$delegate_0.r;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public int getMessageFrom() {
        return this.$$delegate_0.b;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public String getMessageMethod() {
        return this.$$delegate_0.c;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public byte[] getRawPayload() {
        return this.$$delegate_0.q;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public long getReceiveTime() {
        return this.$$delegate_0.i;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public long getTimestamp() {
        return this.$$delegate_0.e;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public String getWRDSSubKey() {
        return this.$$delegate_0.p;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public long getWRDSVersion() {
        return this.$$delegate_0.o;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public boolean isFromFirstRequest() {
        return this.$$delegate_0.g;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public boolean isWRDSMessage() {
        return this.$$delegate_0.n;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final long getChatContentType() {
        return this._$$chatContentType;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.c3
    public final m0 getCommon() {
        return this._$$common;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final String getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final long getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final Map<String, String> getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final HighlightAreaPriorityConfig getHighlightAreaPriorityConfig() {
        return this._$$highlightAreaPriorityConfig;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final List<String> getHotList() {
        return this._$$hotList;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final List<Long> getNum() {
        return this._$$num;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final a5 getRtfContent() {
        return this._$$rtfContent;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final long getSequenceId() {
        return this._$$sequenceId;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final List<Long> getShowDuration() {
        return this._$$showDuration;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final String getTitle() {
        return this._$$title;
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.message.m0, java.lang.Object] */
    public IHotGatherMessageFlexImpl(am3.g r11) {
        super(f1.class);
        this.$$delegate_0 = new g6();
        this._$$num = new ArrayList();
        this._$$showDuration = new ArrayList();
        this._$$hotList = new ArrayList();
        this._$$extra = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L39;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 200) goto L7;
        long r6 = r11.c();
        String r3 = null;
        String r7 = null;
    L23:
        int r8 = r11.f();
        if (r8 == (-1)) goto L31;
        if (r8 != 1) goto L27;
        r3 = am3.h.c(r11);
        goto L23
    L27:
        if (r8 != 2) goto L28;
        r7 = am3.h.c(r11);
        goto L23
    L28:
        am3.h.e(r11);
        goto L23
    L31:
        r11.d(r6);
        Map<String, String> r4 = this._$$extra;
        if (r3 == null) goto L38;
        if (r7 == null) goto L36;
        r4.put(r3, r7);
        goto L3
    L36:
        throw new IllegalStateException("Value must not be null");
    L38:
        throw new IllegalStateException("Key must not be null");
    L7:
        switch(r2) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            default: goto L8;
        };
    L9:
        this._$$highlightAreaPriorityConfig = new HighlightAreaPriorityConfig(r11);
        goto L3
    L10:
        this._$$chatContentType = r11.j();
        goto L3
    L11:
        this._$$rtfContent = vh7.f.a(r11, a5.class);
        goto L3
    L12:
        List r9 = this._$$hotList;
        Object r12 = am3.h.c(r11);
    L18:
        r9.add(r12);
        goto L3
    L13:
        this._$$sequenceId = r11.j();
        goto L3
    L14:
        r9 = this._$$showDuration;
    L17:
        r12 = Long.valueOf(r11.j());
        goto L18
    L15:
        this._$$duration = r11.j();
        goto L3
    L16:
        r9 = this._$$num;
        goto L17
    L19:
        this._$$content = am3.h.c(r11);
        goto L3
    L20:
        this._$$title = am3.h.c(r11);
        goto L3
    L21:
        this._$$common = vh7.f.a(r11, m0.class);
        goto L3
    L8:
        am3.h.d(r5, r11);
        goto L3
    L39:
        r11.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setChatContentType(long r1) {
        this._$$chatContentType = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setCommon(m0 r1) {
        this._$$common = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public void setCommonMessageData(m0 r2) {
        this.$$delegate_0.a = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setConsumeTime(long r2) {
        this.$$delegate_0.m = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setContent(String r1) {
        this._$$content = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setDecodeEndTime(long r2) {
        this.$$delegate_0.k = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setDecodeStartTime(long r2) {
        this.$$delegate_0.j = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setDuration(long r1) {
        this._$$duration = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setEnqueueDispatchTime(long r2) {
        this.$$delegate_0.l = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setExtra(Map<String, String> r1) {
        this._$$extra = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public void setGeneralMessageType(int r2) {
        this.$$delegate_0.d = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setHighlightAreaPriorityConfig(HighlightAreaPriorityConfig r1) {
        this._$$highlightAreaPriorityConfig = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setHotList(List<String> r1) {
        this._$$hotList = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setHttpSendTime(long r2) {
        this.$$delegate_0.h = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setIsFromFirstRequest(boolean r2) {
        this.$$delegate_0.g = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setIsInsert(boolean r2) {
        this.$$delegate_0.f = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public void setMessageExtra(Map<String, String> r2) {
        this.$$delegate_0.r = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public void setMessageFrom(int r2) {
        this.$$delegate_0.b = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setMessageMethod(String r2) {
        this.$$delegate_0.c = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setNum(List<Long> r1) {
        this._$$num = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public void setRawPayload(byte[] r2) {
        this.$$delegate_0.q = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setReceiveTime(long r2) {
        this.$$delegate_0.i = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setRtfContent(a5 r1) {
        this._$$rtfContent = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setSequenceId(long r1) {
        this._$$sequenceId = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setShowDuration(List<Long> r1) {
        this._$$showDuration = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1, com.bytedance.android.live.base.model.message.d3
    public void setTimestamp(long r2) {
        this.$$delegate_0.e = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public final void setTitle(String r1) {
        this._$$title = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setWRDSMessage(boolean r2) {
        this.$$delegate_0.n = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setWRDSSubKey(String r2) {
        this.$$delegate_0.p = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.f1
    public void setWRDSVersion(long r2) {
        this.$$delegate_0.o = r2;
    }
}
