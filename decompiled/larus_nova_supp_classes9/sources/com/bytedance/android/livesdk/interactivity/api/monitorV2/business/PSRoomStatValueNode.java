package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRoomStatValueNode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "valueNodeName", "Ljava/lang/String;", "getValueNodeName", "()Ljava/lang/String;", "TotalMsgCount", "TotalEnqueueCount", "TotalShowCount", "TotalScrollCount", "TotalFoldCount", "TotalFloatCount", "TotalOvertimeDrop", "TotalOverlimitDrop", "HistoryMessageFetchCostTime", "ReceiveHistoryMsgCostTime", "ReceiveRealtimeMsgCostTime", "ReceiveBackendTopMsgCostTime", "ChatMessageReceiveCount", "ChatMessageShowCount", "GiftMessageReceiveCount", "GiftMessageShowCount", "SystemMessageReceiveCount", "SystemMessageShowCount", "LandscapeDanmakuReceiveCount", "LandscapeDanmakuShowCount", "PortraitDanmakuReceiveCount", "PortraitDanmakuShowCount", "PaidDanmakuReceiveCount", "PaidDanmakuShowCount", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRoomStatValueNode extends Enum<PSRoomStatValueNode> {
    public static final PSRoomStatValueNode ChatMessageReceiveCount = null;
    public static final PSRoomStatValueNode ChatMessageShowCount = null;
    public static final PSRoomStatValueNode GiftMessageReceiveCount = null;
    public static final PSRoomStatValueNode GiftMessageShowCount = null;
    public static final PSRoomStatValueNode HistoryMessageFetchCostTime = null;
    public static final PSRoomStatValueNode LandscapeDanmakuReceiveCount = null;
    public static final PSRoomStatValueNode LandscapeDanmakuShowCount = null;
    public static final PSRoomStatValueNode PaidDanmakuReceiveCount = null;
    public static final PSRoomStatValueNode PaidDanmakuShowCount = null;
    public static final PSRoomStatValueNode PortraitDanmakuReceiveCount = null;
    public static final PSRoomStatValueNode PortraitDanmakuShowCount = null;
    public static final PSRoomStatValueNode ReceiveBackendTopMsgCostTime = null;
    public static final PSRoomStatValueNode ReceiveHistoryMsgCostTime = null;
    public static final PSRoomStatValueNode ReceiveRealtimeMsgCostTime = null;
    public static final PSRoomStatValueNode SystemMessageReceiveCount = null;
    public static final PSRoomStatValueNode SystemMessageShowCount = null;
    public static final PSRoomStatValueNode TotalEnqueueCount = null;
    public static final PSRoomStatValueNode TotalFloatCount = null;
    public static final PSRoomStatValueNode TotalFoldCount = null;
    public static final PSRoomStatValueNode TotalMsgCount = null;
    public static final PSRoomStatValueNode TotalOverlimitDrop = null;
    public static final PSRoomStatValueNode TotalOvertimeDrop = null;
    public static final PSRoomStatValueNode TotalScrollCount = null;
    public static final PSRoomStatValueNode TotalShowCount = null;
    public static final /* synthetic */ PSRoomStatValueNode[] a = null;
    private final String valueNodeName;

    public static PSRoomStatValueNode valueOf(String r1) {
        return (PSRoomStatValueNode) a.a(PSRoomStatValueNode.class, r1);
    }

    public static PSRoomStatValueNode[] values() {
        return (PSRoomStatValueNode[]) a.clone();
    }

    static {
        PSRoomStatValueNode r1 = new PSRoomStatValueNode("TotalMsgCount", 0, "total_msg_count");
        TotalMsgCount = r1;
        PSRoomStatValueNode r2 = new PSRoomStatValueNode("TotalEnqueueCount", 1, "total_enqueue_count");
        TotalEnqueueCount = r2;
        PSRoomStatValueNode r3 = new PSRoomStatValueNode("TotalShowCount", 2, "total_show_count");
        TotalShowCount = r3;
        PSRoomStatValueNode r4 = new PSRoomStatValueNode("TotalScrollCount", 3, "total_scroll_count");
        TotalScrollCount = r4;
        PSRoomStatValueNode r5 = new PSRoomStatValueNode("TotalFoldCount", 4, "total_fold_count");
        TotalFoldCount = r5;
        PSRoomStatValueNode r6 = new PSRoomStatValueNode("TotalFloatCount", 5, "total_float_count");
        TotalFloatCount = r6;
        PSRoomStatValueNode r7 = new PSRoomStatValueNode("TotalOvertimeDrop", 6, "total_overtime_drop");
        TotalOvertimeDrop = r7;
        PSRoomStatValueNode r8 = new PSRoomStatValueNode("TotalOverlimitDrop", 7, "total_overlimit_drop");
        TotalOverlimitDrop = r8;
        PSRoomStatValueNode r9 = new PSRoomStatValueNode("HistoryMessageFetchCostTime", 8, "history_message_fetch_cost_time");
        HistoryMessageFetchCostTime = r9;
        PSRoomStatValueNode r10 = new PSRoomStatValueNode("ReceiveHistoryMsgCostTime", 9, "receive_history_msg_cost_time");
        ReceiveHistoryMsgCostTime = r10;
        PSRoomStatValueNode r11 = new PSRoomStatValueNode("ReceiveRealtimeMsgCostTime", 10, "receive_realtime_msg_cost_time");
        ReceiveRealtimeMsgCostTime = r11;
        PSRoomStatValueNode r13 = new PSRoomStatValueNode("ReceiveBackendTopMsgCostTime", 11, "receive_backend_top_msg_cost_time");
        ReceiveBackendTopMsgCostTime = r13;
        PSRoomStatValueNode r14 = new PSRoomStatValueNode("ChatMessageReceiveCount", 12, "chat_receive_count");
        ChatMessageReceiveCount = r14;
        PSRoomStatValueNode r15 = new PSRoomStatValueNode("ChatMessageShowCount", 13, "chat_show_count");
        ChatMessageShowCount = r15;
        PSRoomStatValueNode r16 = new PSRoomStatValueNode("GiftMessageReceiveCount", 14, "gift_receive_count");
        GiftMessageReceiveCount = r16;
        PSRoomStatValueNode r17 = new PSRoomStatValueNode("GiftMessageShowCount", 15, "gift_show_count");
        GiftMessageShowCount = r17;
        PSRoomStatValueNode r18 = new PSRoomStatValueNode("SystemMessageReceiveCount", 16, "system_receive_count");
        SystemMessageReceiveCount = r18;
        PSRoomStatValueNode r19 = new PSRoomStatValueNode("SystemMessageShowCount", 17, "system_show_count");
        SystemMessageShowCount = r19;
        PSRoomStatValueNode r20 = new PSRoomStatValueNode("LandscapeDanmakuReceiveCount", 18, "landscape_danmaku_receive_count");
        LandscapeDanmakuReceiveCount = r20;
        PSRoomStatValueNode r21 = new PSRoomStatValueNode("LandscapeDanmakuShowCount", 19, "landscape_danmaku_show_count");
        LandscapeDanmakuShowCount = r21;
        PSRoomStatValueNode r23 = new PSRoomStatValueNode("PortraitDanmakuReceiveCount", 20, "portrait_danmaku_receive_count");
        PortraitDanmakuReceiveCount = r23;
        PSRoomStatValueNode r24 = new PSRoomStatValueNode("PortraitDanmakuShowCount", 21, "portrait_danmaku_show_count");
        PortraitDanmakuShowCount = r24;
        PSRoomStatValueNode r25 = new PSRoomStatValueNode("PaidDanmakuReceiveCount", 22, "privilege_danmaku_receive_count");
        PaidDanmakuReceiveCount = r25;
        PSRoomStatValueNode r26 = new PSRoomStatValueNode("PaidDanmakuShowCount", 23, "privilege_danmaku_show_count");
        PaidDanmakuShowCount = r26;
        a = new PSRoomStatValueNode[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26};
    }

    public final String getValueNodeName() {
        return this.valueNodeName;
    }

    public PSRoomStatValueNode(String r1, int r2, String r3) {
        super(r1, r2);
        this.valueNodeName = r3;
    }
}
