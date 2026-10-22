package com.bytedance.android.live.room.api.messagewindow.identity;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/identity/CardTypeAndPriority;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "priority", "I", "getPriority", "()I", "desc", "Test", "Unknown", "LightFeedback", "AnchorPkFeedback", "LiveAppWidgetGuide", "Banner", "DrawAndGuess", "WatchVideo", "AudienceLink", "VideoTalk", "VSEpisodeInteract", "MicRoomFollowCard", "KtvOrder", "PaidProfile", "LiveMiniApp", "AssembledIntroduceCard", "WelfareProject", "PaidLiveInteract", "PaidLiveTicketSale", "PaidLiveShareTicket", "PaidLiveTrialPayGuide", "BottomBannerReadPackage", "GiftLynxCard", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardTypeAndPriority extends Enum<CardTypeAndPriority> {
    public static final CardTypeAndPriority AnchorPkFeedback = null;
    public static final CardTypeAndPriority AssembledIntroduceCard = null;
    public static final CardTypeAndPriority AudienceLink = null;
    public static final CardTypeAndPriority Banner = null;
    public static final CardTypeAndPriority BottomBannerReadPackage = null;
    public static final CardTypeAndPriority DrawAndGuess = null;
    public static final CardTypeAndPriority GiftLynxCard = null;
    public static final CardTypeAndPriority KtvOrder = null;
    public static final CardTypeAndPriority LightFeedback = null;
    public static final CardTypeAndPriority LiveAppWidgetGuide = null;
    public static final CardTypeAndPriority LiveMiniApp = null;
    public static final CardTypeAndPriority MicRoomFollowCard = null;
    public static final CardTypeAndPriority PaidLiveInteract = null;
    public static final CardTypeAndPriority PaidLiveShareTicket = null;
    public static final CardTypeAndPriority PaidLiveTicketSale = null;
    public static final CardTypeAndPriority PaidLiveTrialPayGuide = null;
    public static final CardTypeAndPriority PaidProfile = null;
    public static final CardTypeAndPriority Test = null;
    public static final CardTypeAndPriority Unknown = null;
    public static final CardTypeAndPriority VSEpisodeInteract = null;
    public static final CardTypeAndPriority VideoTalk = null;
    public static final CardTypeAndPriority WatchVideo = null;
    public static final CardTypeAndPriority WelfareProject = null;
    public static final /* synthetic */ CardTypeAndPriority[] a = null;
    private final String desc;
    private final int priority;
    private final String type;

    public static CardTypeAndPriority valueOf(String r1) {
        return (CardTypeAndPriority) a.a(CardTypeAndPriority.class, r1);
    }

    public static CardTypeAndPriority[] values() {
        return (CardTypeAndPriority[]) a.clone();
    }

    static {
        CardTypeAndPriority r7 = new CardTypeAndPriority("Test", 0, "Test", 9999, "测试卡片");
        Test = r7;
        CardTypeAndPriority r1 = new CardTypeAndPriority("Unknown", 1, "Unknown", 0, "未知卡片");
        Unknown = r1;
        CardTypeAndPriority r2 = new CardTypeAndPriority("LightFeedback", 2, "FeedbackBanner", WebcastRedirectException.UNKNOWN, "满意度反馈");
        LightFeedback = r2;
        CardTypeAndPriority r3 = new CardTypeAndPriority("AnchorPkFeedback", 3, "FeedbackBanner", WebcastRedirectException.UNKNOWN, "主播pk反馈");
        AnchorPkFeedback = r3;
        CardTypeAndPriority r4 = new CardTypeAndPriority("LiveAppWidgetGuide", 4, "LiveAppWidgetGuide", WebcastRedirectException.UNKNOWN, "直播桌面组件引导");
        LiveAppWidgetGuide = r4;
        CardTypeAndPriority r5 = new CardTypeAndPriority("Banner", 5, "Banner", 1100, "右下角banner");
        Banner = r5;
        CardTypeAndPriority r6 = new CardTypeAndPriority("DrawAndGuess", 6, "GamePlayerWindow", 1200, "你画我猜");
        DrawAndGuess = r6;
        CardTypeAndPriority r8 = new CardTypeAndPriority("WatchVideo", 7, "AnchorVideoPlay", 1200, "主播看视频");
        WatchVideo = r8;
        CardTypeAndPriority r9 = new CardTypeAndPriority("AudienceLink", 8, "StrongReminder", 1200, "观众连线（两个人，右下角有小窗");
        AudienceLink = r9;
        CardTypeAndPriority r10 = new CardTypeAndPriority("VideoTalk", 9, "BigPartyLinkMic", 1200, "聊天室，在右边的那种");
        VideoTalk = r10;
        CardTypeAndPriority r12 = new CardTypeAndPriority("VSEpisodeInteract", 10, "VSEpisodeInteract", 1300, "节目互动组件");
        VSEpisodeInteract = r12;
        CardTypeAndPriority r13 = new CardTypeAndPriority("MicRoomFollowCard", 11, "MicRoomFollowCard", 1300, "麦序房关注卡片");
        MicRoomFollowCard = r13;
        CardTypeAndPriority r14 = new CardTypeAndPriority("KtvOrder", 12, "KTVOrderSongEntrance", 1400, "ktv点歌单");
        KtvOrder = r14;
        CardTypeAndPriority r15 = new CardTypeAndPriority("PaidProfile", 13, "PaidProfile", 1500, "付费连线讲解卡");
        PaidProfile = r15;
        CardTypeAndPriority r16 = new CardTypeAndPriority("LiveMiniApp", 14, "LiveMiniApp", 1600, "直播小程序卡");
        LiveMiniApp = r16;
        CardTypeAndPriority r17 = new CardTypeAndPriority("AssembledIntroduceCard", 15, "AssembledIntroduceCard", 1600, "聚合讲解卡，电商、游戏、团购、小程序、小风车、本地生活……，通过RightCardPlaceHolder实现的都是这个卡");
        AssembledIntroduceCard = r17;
        CardTypeAndPriority r18 = new CardTypeAndPriority("WelfareProject", 16, "WelfareProject", 1600, "公益组件卡");
        WelfareProject = r18;
        CardTypeAndPriority r19 = new CardTypeAndPriority("PaidLiveInteract", 17, "PaywallVoteView", 1700, "付费互动组件");
        PaidLiveInteract = r19;
        CardTypeAndPriority r20 = new CardTypeAndPriority("PaidLiveTicketSale", 18, "PaywallTicketCard", 1800, "付费直播售票讲解卡");
        PaidLiveTicketSale = r20;
        CardTypeAndPriority r22 = new CardTypeAndPriority("PaidLiveShareTicket", 19, "PaidLiveShareTicket", 1900, "付费金主感知赠票卡（助力票）");
        PaidLiveShareTicket = r22;
        CardTypeAndPriority r23 = new CardTypeAndPriority("PaidLiveTrialPayGuide", 20, "PaidLiveTrialPayGuide", 2000, "付费试看引导");
        PaidLiveTrialPayGuide = r23;
        CardTypeAndPriority r24 = new CardTypeAndPriority("BottomBannerReadPackage", 21, "bottomBannerReadPackage", 3000, "右下角banner红包优先级");
        BottomBannerReadPackage = r24;
        CardTypeAndPriority r25 = new CardTypeAndPriority("GiftLynxCard", 22, "GiftLynxCard", 4000, "礼物lynx卡片");
        GiftLynxCard = r25;
        a = new CardTypeAndPriority[]{r7, r1, r2, r3, r4, r5, r6, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25};
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getType() {
        return this.type;
    }

    public CardTypeAndPriority(String r1, int r2, String r3, int r4, String r5) {
        super(r1, r2);
        this.type = r3;
        this.priority = r4;
        this.desc = r5;
    }
}
