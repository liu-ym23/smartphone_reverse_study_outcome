package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRealtimeIndicatorNode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "indicatorNodeName", "Ljava/lang/String;", "getIndicatorNodeName", "()Ljava/lang/String;", "ScrollShowDelayAvg", "ScrollDispatchAndShowDelayAvg", "FloatShowDelayAvg", "BindAvgConsume", "AsyncRendConsume", "MessageRendTextConsume", "MessageRendTextSuccessRate", "SelfMsgShowDelayAvg", "SelfCommentSendSuccessDelayAvg", "SelfCommentShowDelayAvg", "ChatMessageShowDelay", "GiftMessageShowDelay", "SystemMessageShowDelay", "OtherMessageShowDelay", "HighPriorityShowDelay", "NormalPriorityShowDelay", "LowPriorityShowDelay", "LandscapeDanmakuShowDelay", "LandscapeDanmakuDispatchAndShowDelay", "LandscapeChatDanmakuShowDelay", "LandscapeGiftDanmakuShowDelay", "PortraitDanmakuShowDelay", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRealtimeIndicatorNode extends Enum<PSRealtimeIndicatorNode> {
    public static final PSRealtimeIndicatorNode AsyncRendConsume = null;
    public static final PSRealtimeIndicatorNode BindAvgConsume = null;
    public static final PSRealtimeIndicatorNode ChatMessageShowDelay = null;
    public static final PSRealtimeIndicatorNode FloatShowDelayAvg = null;
    public static final PSRealtimeIndicatorNode GiftMessageShowDelay = null;
    public static final PSRealtimeIndicatorNode HighPriorityShowDelay = null;
    public static final PSRealtimeIndicatorNode LandscapeChatDanmakuShowDelay = null;
    public static final PSRealtimeIndicatorNode LandscapeDanmakuDispatchAndShowDelay = null;
    public static final PSRealtimeIndicatorNode LandscapeDanmakuShowDelay = null;
    public static final PSRealtimeIndicatorNode LandscapeGiftDanmakuShowDelay = null;
    public static final PSRealtimeIndicatorNode LowPriorityShowDelay = null;
    public static final PSRealtimeIndicatorNode MessageRendTextConsume = null;
    public static final PSRealtimeIndicatorNode MessageRendTextSuccessRate = null;
    public static final PSRealtimeIndicatorNode NormalPriorityShowDelay = null;
    public static final PSRealtimeIndicatorNode OtherMessageShowDelay = null;
    public static final PSRealtimeIndicatorNode PortraitDanmakuShowDelay = null;
    public static final PSRealtimeIndicatorNode ScrollDispatchAndShowDelayAvg = null;
    public static final PSRealtimeIndicatorNode ScrollShowDelayAvg = null;
    public static final PSRealtimeIndicatorNode SelfCommentSendSuccessDelayAvg = null;
    public static final PSRealtimeIndicatorNode SelfCommentShowDelayAvg = null;
    public static final PSRealtimeIndicatorNode SelfMsgShowDelayAvg = null;
    public static final PSRealtimeIndicatorNode SystemMessageShowDelay = null;
    public static final /* synthetic */ PSRealtimeIndicatorNode[] a = null;
    private final String indicatorNodeName;

    public static PSRealtimeIndicatorNode valueOf(String r1) {
        return (PSRealtimeIndicatorNode) a.a(PSRealtimeIndicatorNode.class, r1);
    }

    public static PSRealtimeIndicatorNode[] values() {
        return (PSRealtimeIndicatorNode[]) a.clone();
    }

    static {
        PSRealtimeIndicatorNode r1 = new PSRealtimeIndicatorNode("ScrollShowDelayAvg", 0, "scroll_show_delay_avg");
        ScrollShowDelayAvg = r1;
        PSRealtimeIndicatorNode r2 = new PSRealtimeIndicatorNode("ScrollDispatchAndShowDelayAvg", 1, "scroll_dispatch_and_show_delay_avy");
        ScrollDispatchAndShowDelayAvg = r2;
        PSRealtimeIndicatorNode r3 = new PSRealtimeIndicatorNode("FloatShowDelayAvg", 2, "float_show_delay_avg");
        FloatShowDelayAvg = r3;
        PSRealtimeIndicatorNode r4 = new PSRealtimeIndicatorNode("BindAvgConsume", 3, "message_bind_avg_consume");
        BindAvgConsume = r4;
        PSRealtimeIndicatorNode r5 = new PSRealtimeIndicatorNode("AsyncRendConsume", 4, "async_rend_consume");
        AsyncRendConsume = r5;
        PSRealtimeIndicatorNode r6 = new PSRealtimeIndicatorNode("MessageRendTextConsume", 5, "message_rend_text_consume");
        MessageRendTextConsume = r6;
        PSRealtimeIndicatorNode r7 = new PSRealtimeIndicatorNode("MessageRendTextSuccessRate", 6, "message_rend_text_success_rate");
        MessageRendTextSuccessRate = r7;
        PSRealtimeIndicatorNode r8 = new PSRealtimeIndicatorNode("SelfMsgShowDelayAvg", 7, "selfmsg_show_delay_avg");
        SelfMsgShowDelayAvg = r8;
        PSRealtimeIndicatorNode r9 = new PSRealtimeIndicatorNode("SelfCommentSendSuccessDelayAvg", 8, "self_comment_send_success_avg");
        SelfCommentSendSuccessDelayAvg = r9;
        PSRealtimeIndicatorNode r10 = new PSRealtimeIndicatorNode("SelfCommentShowDelayAvg", 9, "self_comment_show_delay_avg");
        SelfCommentShowDelayAvg = r10;
        PSRealtimeIndicatorNode r11 = new PSRealtimeIndicatorNode("ChatMessageShowDelay", 10, "chat_show_delay_avg");
        ChatMessageShowDelay = r11;
        PSRealtimeIndicatorNode r13 = new PSRealtimeIndicatorNode("GiftMessageShowDelay", 11, "gift_show_delay_avg");
        GiftMessageShowDelay = r13;
        PSRealtimeIndicatorNode r14 = new PSRealtimeIndicatorNode("SystemMessageShowDelay", 12, "system_show_delay_avg");
        SystemMessageShowDelay = r14;
        PSRealtimeIndicatorNode r15 = new PSRealtimeIndicatorNode("OtherMessageShowDelay", 13, "other_show_delay_avg");
        OtherMessageShowDelay = r15;
        PSRealtimeIndicatorNode r16 = new PSRealtimeIndicatorNode("HighPriorityShowDelay", 14, "high_priority_show_delay");
        HighPriorityShowDelay = r16;
        PSRealtimeIndicatorNode r17 = new PSRealtimeIndicatorNode("NormalPriorityShowDelay", 15, "normal_priority_show_delay");
        NormalPriorityShowDelay = r17;
        PSRealtimeIndicatorNode r18 = new PSRealtimeIndicatorNode("LowPriorityShowDelay", 16, "low_priority_show_delay");
        LowPriorityShowDelay = r18;
        PSRealtimeIndicatorNode r19 = new PSRealtimeIndicatorNode("LandscapeDanmakuShowDelay", 17, "landscape_danmaku_show_delay");
        LandscapeDanmakuShowDelay = r19;
        PSRealtimeIndicatorNode r20 = new PSRealtimeIndicatorNode("LandscapeDanmakuDispatchAndShowDelay", 18, "landscape_danmaku_dispatch_and_show_delay");
        LandscapeDanmakuDispatchAndShowDelay = r20;
        PSRealtimeIndicatorNode r21 = new PSRealtimeIndicatorNode("LandscapeChatDanmakuShowDelay", 19, "landscape_chat_danmaku_show_delay");
        LandscapeChatDanmakuShowDelay = r21;
        PSRealtimeIndicatorNode r23 = new PSRealtimeIndicatorNode("LandscapeGiftDanmakuShowDelay", 20, "landscape_gift_danmaku_show_delay");
        LandscapeGiftDanmakuShowDelay = r23;
        PSRealtimeIndicatorNode r24 = new PSRealtimeIndicatorNode("PortraitDanmakuShowDelay", 21, "portrait_danmaku_show_delay");
        PortraitDanmakuShowDelay = r24;
        a = new PSRealtimeIndicatorNode[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24};
    }

    public final String getIndicatorNodeName() {
        return this.indicatorNodeName;
    }

    public PSRealtimeIndicatorNode(String r1, int r2, String r3) {
        super(r1, r2);
        this.indicatorNodeName = r3;
    }
}
