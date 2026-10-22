package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.TrayEffectMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\t¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\t\u0010\b\u001a\u00020\u0005H\u0096\u0001J\t\u0010\t\u001a\u00020\u0005H\u0096\u0001J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0018\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0011\u0010\u0019\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u001bH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001bH\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001bH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u001bH\u0096\u0001J\t\u0010 \u001a\u00020\u001bH\u0096\u0001J\u0013\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0001J\u0011\u0010&\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010'\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010(\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010)\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010+\u001a\u00020#2\u0006\u0010*\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010,\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010-\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001bH\u0096\u0001J\u0011\u0010.\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001bH\u0096\u0001J\u0011\u00100\u001a\u00020#2\u0006\u0010/\u001a\u00020\u000bH\u0096\u0001J\u0019\u00101\u001a\u00020#2\u000e\u0010%\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0011\u00102\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005H\u0096\u0001J\u0011\u00104\u001a\u00020#2\u0006\u00103\u001a\u00020\u0005H\u0096\u0001J\u0011\u00105\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001bH\u0096\u0001J\u0019\u00106\u001a\u00020#2\u000e\u0010%\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0011\u00107\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005H\u0096\u0001R*\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001088\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010C\u001a\u0004\u0018\u00010>8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010H\u001a\u00020\u00058\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR/\u0010P\u001a\u0004\u0018\u00010\u00112\b\u0010I\u001a\u0004\u0018\u00010\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR/\u0010T\u001a\u0004\u0018\u00010\u00112\b\u0010I\u001a\u0004\u0018\u00010\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010K\u001a\u0004\bR\u0010M\"\u0004\bS\u0010OR/\u0010[\u001a\u0004\u0018\u00010U2\b\u0010I\u001a\u0004\u0018\u00010U8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010K\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR/\u0010b\u001a\u0004\u0018\u00010\\2\b\u0010I\u001a\u0004\u0018\u00010\\8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010K\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR/\u0010i\u001a\u0004\u0018\u00010c2\b\u0010I\u001a\u0004\u0018\u00010c8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010K\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR/\u0010p\u001a\u0004\u0018\u00010j2\b\u0010I\u001a\u0004\u0018\u00010j8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bk\u0010K\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oRG\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010q2\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010q8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\br\u0010K\u001a\u0004\bs\u0010:\"\u0004\bt\u0010<R/\u0010|\u001a\u0004\u0018\u00010v2\b\u0010I\u001a\u0004\u0018\u00010v8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bw\u0010K\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R1\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010I\u001a\u0004\u0018\u00010!8V@VX\u0096\u008e\u0002¢\u0006\u0014\n\u0004\b}\u0010K\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0084\u0001"}, d2 = {"Lcom/bytedance/android/live/base/model/message/ITrayEffectMessageFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/n5;", "Lcom/bytedance/android/live/base/model/message/d3;", "", "", "getConsumeTime", "getDecodeEndTime", "getDecodeStartTime", "getDelayDispatchMs", "getEnqueueDispatchTime", "", "getGeneralMessageType", "getHttpSendTime", "getIntType", "getMessageFrom", "getMessageId", "", "kotlin.jvm.PlatformType", "getMessageMethod", "getPriority", "getReceiveTime", "getRoomId", "getTimestamp", "getWRDSKey", "getWRDSSubKey", "getWRDSVersion", "", "isFromFirstRequest", "isGlobalMessage", "isTimeCostCanUse", "isWRDSMessage", "needMonitor", "Lcom/bytedance/android/live/base/model/message/m0;", "common", "", "setCommonMessageData", "p0", "setConsumeTime", "setDecodeEndTime", "setDecodeStartTime", "setEnqueueDispatchTime", "generalMessageType", "setGeneralMessageType", "setHttpSendTime", "setIsFromFirstRequest", "setIsInsert", "messageFrom", "setMessageFrom", "setMessageMethod", "setReceiveTime", "timestamp", "setTimestamp", "setWRDSMessage", "setWRDSSubKey", "setWRDSVersion", "", "getMessageExtra", "()Ljava/util/Map;", "setMessageExtra", "(Ljava/util/Map;)V", "messageExtra", "", "getRawPayload", "()[B", "setRawPayload", "([B)V", "rawPayload", "getShowTimestamp", "()J", "setShowTimestamp", "(J)V", "showTimestamp", "<set-?>", "scene$delegate", "Ljava/lang/Object;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "scene", "subScene$delegate", "getSubScene", "setSubScene", "subScene", "Lcom/bytedance/android/live/base/model/message/d;", "content$delegate", "getContent", "()Lcom/bytedance/android/live/base/model/message/d;", "setContent", "(Lcom/bytedance/android/live/base/model/message/d;)V", "content", "Lcom/bytedance/android/live/base/model/message/n5$a;", "background$delegate", "getBackground", "()Lcom/bytedance/android/live/base/model/message/n5$a;", "setBackground", "(Lcom/bytedance/android/live/base/model/message/n5$a;)V", KtvSubElement.BACKGROUND, "Lcom/bytedance/android/live/base/model/message/n5$e;", "dynamicConfig$delegate", "getDynamicConfig", "()Lcom/bytedance/android/live/base/model/message/n5$e;", "setDynamicConfig", "(Lcom/bytedance/android/live/base/model/message/n5$e;)V", "dynamicConfig", "Lcom/bytedance/android/live/base/model/message/n5$f;", "priorityConfig$delegate", "getPriorityConfig", "()Lcom/bytedance/android/live/base/model/message/n5$f;", "setPriorityConfig", "(Lcom/bytedance/android/live/base/model/message/n5$f;)V", "priorityConfig", "", "eventParams$delegate", "getEventParams", "setEventParams", "eventParams", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "highlightAreaPriorityConfig$delegate", "getHighlightAreaPriorityConfig", "()Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "setHighlightAreaPriorityConfig", "(Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;)V", "highlightAreaPriorityConfig", "common$delegate", "getCommon", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommon", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITrayEffectMessageFlexImpl extends FlexModelBase<n5> implements n5, d3, vh7.h {
    private final /* synthetic */ g6 $$delegate_0;
    private final /* synthetic */ p6 $$delegate_1;

    @SerializedName(KtvSubElement.BACKGROUND)
    protected n5.a _$$background;

    @SerializedName("common")
    protected m0 _$$common;

    @SerializedName("content")
    protected d _$$content;

    @SerializedName("dynamic_config")
    protected n5.e _$$dynamicConfig;

    @SerializedName("event_params")
    protected Map<String, String> _$$eventParams;

    @SerializedName("highlight_area_priority_config")
    protected HighlightAreaPriorityConfig _$$highlightAreaPriorityConfig;

    @SerializedName("priority_config")
    protected n5.f _$$priorityConfig;

    @SerializedName("scene")
    protected String _$$scene;

    @SerializedName("sub_scene")
    protected String _$$subScene;

    @Override // com.bytedance.android.live.base.model.message.n5
    public long getDelayDispatchMs() {
        return this.$$delegate_0.getDelayDispatchMs();
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public int getIntType() {
        this.$$delegate_0.getClass();
        return -1;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public long getMessageId() {
        return this.$$delegate_0.getMessageId();
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public int getPriority() {
        this.$$delegate_0.getClass();
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public long getRoomId() {
        return this.$$delegate_0.getRoomId();
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public String getWRDSKey() {
        return this.$$delegate_0.getWRDSKey();
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public boolean isGlobalMessage() {
        return this.$$delegate_0.isGlobalMessage();
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public boolean isTimeCostCanUse() {
        return this.$$delegate_0.isTimeCostCanUse();
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public boolean needMonitor() {
        return this.$$delegate_0.needMonitor();
    }

    public ITrayEffectMessageFlexImpl() {
        super(n5.class);
        this.$$delegate_0 = new g6();
        this.$$delegate_1 = new p6();
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public long getConsumeTime() {
        return this.$$delegate_0.m;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public long getDecodeEndTime() {
        return this.$$delegate_0.k;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public long getDecodeStartTime() {
        return this.$$delegate_0.j;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public long getEnqueueDispatchTime() {
        return this.$$delegate_0.l;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public int getGeneralMessageType() {
        return this.$$delegate_0.d;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public long getHttpSendTime() {
        return this.$$delegate_0.h;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public Map<String, String> getMessageExtra() {
        return this.$$delegate_0.r;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public int getMessageFrom() {
        return this.$$delegate_0.b;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public String getMessageMethod() {
        return this.$$delegate_0.c;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public byte[] getRawPayload() {
        return this.$$delegate_0.q;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public long getReceiveTime() {
        return this.$$delegate_0.i;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public long getShowTimestamp() {
        return this.$$delegate_1.a;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public long getTimestamp() {
        return this.$$delegate_0.e;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public String getWRDSSubKey() {
        return this.$$delegate_0.p;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public long getWRDSVersion() {
        return this.$$delegate_0.o;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public boolean isFromFirstRequest() {
        return this.$$delegate_0.g;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public boolean isWRDSMessage() {
        return this.$$delegate_0.n;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final n5.a getBackground() {
        return this._$$background;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.c3
    public final m0 getCommon() {
        return this._$$common;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final d getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final n5.e getDynamicConfig() {
        return this._$$dynamicConfig;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final Map<String, String> getEventParams() {
        return this._$$eventParams;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final HighlightAreaPriorityConfig getHighlightAreaPriorityConfig() {
        return this._$$highlightAreaPriorityConfig;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final n5.f getPriorityConfig() {
        return this._$$priorityConfig;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final String getScene() {
        return this._$$scene;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final String getSubScene() {
        return this._$$subScene;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.message.m0, java.lang.Object] */
    public ITrayEffectMessageFlexImpl(am3.g r11) {
        super(n5.class);
        this.$$delegate_0 = new g6();
        this.$$delegate_1 = new p6();
        this._$$eventParams = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L34;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 50) goto L7;
        long r6 = r11.c();
        String r3 = null;
        String r7 = null;
    L18:
        int r8 = r11.f();
        if (r8 == (-1)) goto L26;
        if (r8 != 1) goto L22;
        r3 = am3.h.c(r11);
        goto L18
    L22:
        if (r8 != 2) goto L23;
        r7 = am3.h.c(r11);
        goto L18
    L23:
        am3.h.e(r11);
        goto L18
    L26:
        r11.d(r6);
        Map<String, String> r4 = this._$$eventParams;
        if (r3 == null) goto L33;
        if (r7 == null) goto L31;
        r4.put(r3, r7);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L7:
        switch(r2) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        this._$$highlightAreaPriorityConfig = new HighlightAreaPriorityConfig(r11);
        goto L3
    L10:
        this._$$priorityConfig = new n5.f(r11);
        goto L3
    L11:
        this._$$dynamicConfig = new n5.e(r11);
        goto L3
    L12:
        this._$$background = new n5.a(r11);
        goto L3
    L13:
        this._$$content = new d(r11);
        goto L3
    L14:
        this._$$subScene = am3.h.c(r11);
        goto L3
    L15:
        this._$$scene = am3.h.c(r11);
        goto L3
    L16:
        this._$$common = vh7.f.a(r11, m0.class);
        goto L3
    L8:
        am3.h.d(r5, r11);
        goto L3
    L34:
        r11.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final void setBackground(n5.a r1) {
        this._$$background = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final void setCommon(m0 r1) {
        this._$$common = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public void setCommonMessageData(m0 r2) {
        this.$$delegate_0.a = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setConsumeTime(long r2) {
        this.$$delegate_0.m = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final void setContent(d r1) {
        this._$$content = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setDecodeEndTime(long r2) {
        this.$$delegate_0.k = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setDecodeStartTime(long r2) {
        this.$$delegate_0.j = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final void setDynamicConfig(n5.e r1) {
        this._$$dynamicConfig = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setEnqueueDispatchTime(long r2) {
        this.$$delegate_0.l = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final void setEventParams(Map<String, String> r1) {
        this._$$eventParams = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public void setGeneralMessageType(int r2) {
        this.$$delegate_0.d = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final void setHighlightAreaPriorityConfig(HighlightAreaPriorityConfig r1) {
        this._$$highlightAreaPriorityConfig = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setHttpSendTime(long r2) {
        this.$$delegate_0.h = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setIsFromFirstRequest(boolean r2) {
        this.$$delegate_0.g = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setIsInsert(boolean r2) {
        this.$$delegate_0.f = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public void setMessageExtra(Map<String, String> r2) {
        this.$$delegate_0.r = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public void setMessageFrom(int r2) {
        this.$$delegate_0.b = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setMessageMethod(String r2) {
        this.$$delegate_0.c = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final void setPriorityConfig(n5.f r1) {
        this._$$priorityConfig = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public void setRawPayload(byte[] r2) {
        this.$$delegate_0.q = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setReceiveTime(long r2) {
        this.$$delegate_0.i = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final void setScene(String r1) {
        this._$$scene = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setShowTimestamp(long r2) {
        this.$$delegate_1.a = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public final void setSubScene(String r1) {
        this._$$subScene = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.n5, com.bytedance.android.live.base.model.message.d3
    public void setTimestamp(long r2) {
        this.$$delegate_0.e = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setWRDSMessage(boolean r2) {
        this.$$delegate_0.n = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setWRDSSubKey(String r2) {
        this.$$delegate_0.p = r2;
    }

    @Override // com.bytedance.android.live.base.model.message.n5
    public void setWRDSVersion(long r2) {
        this.$$delegate_0.o = r2;
    }
}
