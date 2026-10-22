package com.bytedance.android.livesdk.feedback.condition.trigger.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/base/TriggerId;", "", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "LIVE_END", "RECEIVE_FEEDBACK_MSG", "FANS_CLUB", "TOTAL_WATCH_TIME_SECTION", "FOLLOW", "REPORT", "PURCHASE", "COMMENT", "DIGG", "SEND_GIFT", "BOTTOM_RIGHT_CARD_SHOW", "RECEIVE_LIVE_ROOM_FEEDBACK_MSG", "Pcu", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TriggerId extends Enum<TriggerId> {
    public static final TriggerId BOTTOM_RIGHT_CARD_SHOW = null;
    public static final TriggerId COMMENT = null;
    public static final TriggerId DIGG = null;
    public static final TriggerId FANS_CLUB = null;
    public static final TriggerId FOLLOW = null;
    public static final TriggerId LIVE_END = null;
    public static final TriggerId PURCHASE = null;
    public static final TriggerId Pcu = null;
    public static final TriggerId RECEIVE_FEEDBACK_MSG = null;
    public static final TriggerId RECEIVE_LIVE_ROOM_FEEDBACK_MSG = null;
    public static final TriggerId REPORT = null;
    public static final TriggerId SEND_GIFT = null;
    public static final TriggerId TOTAL_WATCH_TIME_SECTION = null;
    public static final /* synthetic */ TriggerId[] a = null;
    private final String desc;

    public static TriggerId valueOf(String r1) {
        return (TriggerId) a.a(TriggerId.class, r1);
    }

    public static TriggerId[] values() {
        return (TriggerId[]) a.clone();
    }

    static {
        TriggerId r1 = new TriggerId("LIVE_END", 0, "直播结束");
        LIVE_END = r1;
        TriggerId r2 = new TriggerId("RECEIVE_FEEDBACK_MSG", 1, "监听服务端feedback消息，目前没有用，都是客户端本地触发的");
        RECEIVE_FEEDBACK_MSG = r2;
        TriggerId r3 = new TriggerId("FANS_CLUB", 2, "加入粉丝团");
        FANS_CLUB = r3;
        TriggerId r4 = new TriggerId("TOTAL_WATCH_TIME_SECTION", 3, "直播间累计看播时长在[x,y]内问卷可以展示，去除后台时间");
        TOTAL_WATCH_TIME_SECTION = r4;
        TriggerId r5 = new TriggerId("FOLLOW", 4, "关注、取关");
        FOLLOW = r5;
        TriggerId r6 = new TriggerId("REPORT", 5, "举报");
        REPORT = r6;
        TriggerId r7 = new TriggerId("PURCHASE", 6, "加购");
        PURCHASE = r7;
        TriggerId r8 = new TriggerId("COMMENT", 7, "评论");
        COMMENT = r8;
        TriggerId r9 = new TriggerId("DIGG", 8, "点赞");
        DIGG = r9;
        TriggerId r10 = new TriggerId("SEND_GIFT", 9, "送礼");
        SEND_GIFT = r10;
        TriggerId r11 = new TriggerId("BOTTOM_RIGHT_CARD_SHOW", 10, "直播间右下角讲解卡位置有元素要展示");
        BOTTOM_RIGHT_CARD_SHOW = r11;
        TriggerId r12 = new TriggerId("RECEIVE_LIVE_ROOM_FEEDBACK_MSG", 11, "监听服务端房间feedback消息");
        RECEIVE_LIVE_ROOM_FEEDBACK_MSG = r12;
        TriggerId r13 = new TriggerId("Pcu", 12, "直播间pcu人数");
        Pcu = r13;
        a = new TriggerId[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13};
    }

    public final String getDesc() {
        return this.desc;
    }

    public TriggerId(String r1, int r2, String r3) {
        super(r1, r2);
        this.desc = r3;
    }
}
