package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Target({ElementType.TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015BB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000bR\u000f\u0010\b\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\b\u0010\u000eR\u000f\u0010\f\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\f\u0010\u000fR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0010R\u000f\u0010\n\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\n\u0010\u000fR\u000f\u0010\r\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0011R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl;", "", "key", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$KEY;", "type", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Type;", "style", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Style;", "attachMarginDp", "", "needDynamicControl", "", "ignoreLock", "reverse", "()F", "()Z", "()Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$KEY;", "()Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Style;", "()Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Type;", "KEY", "Style", "Type", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface PlayerViewControl {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\bP\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQ¨\u0006R"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$KEY;", "", "", "describe", "Ljava/lang/String;", "getDescribe", "()Ljava/lang/String;", "LandScapeEpisodeInfo", "LandScapeAnchorInfo", "CastScreenEntry", "MultiDeviceEntry", "ActivityBannerWidget", "VSShortTermIndicatorWidget", "TopRightWidget", "LandscapeTopToolBar", "VSLandscapeStatusBar", "TopLineToolBar", "VSPortraitTopToolBar", "BrightnessView", "VolumeView", "PlayerShadowTop", "PlayerShadow", "MatchRoomBack", "LandscapeRoomTitle", "LandscapeAnchorInfo", "MatchRoomCount", "PortraitRowOne", "PortraitRowTow", "WatchCount", "FirstShowHint", "FirstShowHintAlpha", "VideoPlayControl", "LivePlayControl", "PlayTip", "ProgressBar", "LandscapeBottomToolBar", "LandscapeBottomLeftToolBar", "PortraitVideoDanmakuSend", "LandscapeDanmakuSend", "PlayerShadowBottom", "VerticalPlayerShadow", "PortraitBottomToolBar", "PortraitBottomFollow", "PortraitBottomComment", "PortraitTopClose", "PortraitCamera", "VerticalVersion", "PortraitTopContent", "VerticalShowPlayInfo", "VerticalTopFollow", "VerticalSelectionEntry", "VerticalDanmakuInput", "PortraitTopAnchor", "PortraitLock", "TextMessage", "ChatChannel", "RightBottomBanner", "KtvCard", "RightCard", "GiftTray", "MoreLiveEntry", "Digg", "DiggSelf", "ECProduct", "PaidLiveTempWatch", "PaidTempCardContainer", "LandscapeDrawer", "LandscapeResetPlayerView", "LandscapeBlockComment", "InteractiveWidget", "LandscapeInteractiveWidget", "BottomRightBanner", "CastScreenLoading", "PlayerViewLock", "LiveOrientationControl", "VideoOrientationControl", "XTab_Test", "LandscapeWatchCountInfo", "QuickShotRecordControl", "QuickShotShotControl", "LandscapeRefresh", "LandscapePhoneInfo", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum KEY extends Enum<KEY> {
        public static final KEY ActivityBannerWidget = null;
        public static final KEY BottomRightBanner = null;
        public static final KEY BrightnessView = null;
        public static final KEY CastScreenEntry = null;
        public static final KEY CastScreenLoading = null;
        public static final KEY ChatChannel = null;
        public static final KEY Digg = null;
        public static final KEY DiggSelf = null;
        public static final KEY ECProduct = null;
        public static final KEY FirstShowHint = null;
        public static final KEY FirstShowHintAlpha = null;
        public static final KEY GiftTray = null;
        public static final KEY InteractiveWidget = null;
        public static final KEY KtvCard = null;
        public static final KEY LandScapeAnchorInfo = null;
        public static final KEY LandScapeEpisodeInfo = null;
        public static final KEY LandscapeAnchorInfo = null;
        public static final KEY LandscapeBlockComment = null;
        public static final KEY LandscapeBottomLeftToolBar = null;
        public static final KEY LandscapeBottomToolBar = null;
        public static final KEY LandscapeDanmakuSend = null;
        public static final KEY LandscapeDrawer = null;
        public static final KEY LandscapeInteractiveWidget = null;
        public static final KEY LandscapePhoneInfo = null;
        public static final KEY LandscapeRefresh = null;
        public static final KEY LandscapeResetPlayerView = null;
        public static final KEY LandscapeRoomTitle = null;
        public static final KEY LandscapeTopToolBar = null;
        public static final KEY LandscapeWatchCountInfo = null;
        public static final KEY LiveOrientationControl = null;
        public static final KEY LivePlayControl = null;
        public static final KEY MatchRoomBack = null;
        public static final KEY MatchRoomCount = null;
        public static final KEY MoreLiveEntry = null;
        public static final KEY MultiDeviceEntry = null;
        public static final KEY PaidLiveTempWatch = null;
        public static final KEY PaidTempCardContainer = null;
        public static final KEY PlayTip = null;
        public static final KEY PlayerShadow = null;
        public static final KEY PlayerShadowBottom = null;
        public static final KEY PlayerShadowTop = null;
        public static final KEY PlayerViewLock = null;
        public static final KEY PortraitBottomComment = null;
        public static final KEY PortraitBottomFollow = null;
        public static final KEY PortraitBottomToolBar = null;
        public static final KEY PortraitCamera = null;
        public static final KEY PortraitLock = null;
        public static final KEY PortraitRowOne = null;
        public static final KEY PortraitRowTow = null;
        public static final KEY PortraitTopAnchor = null;
        public static final KEY PortraitTopClose = null;
        public static final KEY PortraitTopContent = null;
        public static final KEY PortraitVideoDanmakuSend = null;
        public static final KEY ProgressBar = null;
        public static final KEY QuickShotRecordControl = null;
        public static final KEY QuickShotShotControl = null;
        public static final KEY RightBottomBanner = null;
        public static final KEY RightCard = null;
        public static final KEY TextMessage = null;
        public static final KEY TopLineToolBar = null;
        public static final KEY TopRightWidget = null;
        public static final KEY VSLandscapeStatusBar = null;
        public static final KEY VSPortraitTopToolBar = null;
        public static final KEY VSShortTermIndicatorWidget = null;
        public static final KEY VerticalDanmakuInput = null;
        public static final KEY VerticalPlayerShadow = null;
        public static final KEY VerticalSelectionEntry = null;
        public static final KEY VerticalShowPlayInfo = null;
        public static final KEY VerticalTopFollow = null;
        public static final KEY VerticalVersion = null;
        public static final KEY VideoOrientationControl = null;
        public static final KEY VideoPlayControl = null;
        public static final KEY VolumeView = null;
        public static final KEY WatchCount = null;
        public static final KEY XTab_Test = null;
        public static final /* synthetic */ KEY[] a = null;
        private final String describe;

        public static KEY valueOf(String r1) {
            return (KEY) r27.a.a(KEY.class, r1);
        }

        public static KEY[] values() {
            return (KEY[]) a.clone();
        }

        static {
            KEY r1 = new KEY("LandScapeEpisodeInfo", 0, "横屏顶部信息");
            LandScapeEpisodeInfo = r1;
            KEY r2 = new KEY("LandScapeAnchorInfo", 1, "横屏顶部主播信息");
            LandScapeAnchorInfo = r2;
            KEY r3 = new KEY("CastScreenEntry", 2, "投屏入口");
            CastScreenEntry = r3;
            KEY r4 = new KEY("MultiDeviceEntry", 3, "电脑/Pad打开");
            MultiDeviceEntry = r4;
            KEY r5 = new KEY("ActivityBannerWidget", 4, "活动Banner");
            ActivityBannerWidget = r5;
            KEY r6 = new KEY("VSShortTermIndicatorWidget", 5, "短触区");
            VSShortTermIndicatorWidget = r6;
            KEY r7 = new KEY("TopRightWidget", 6, "心愿单");
            TopRightWidget = r7;
            KEY r8 = new KEY("LandscapeTopToolBar", 7, "横屏顶部ToolBar");
            LandscapeTopToolBar = r8;
            KEY r9 = new KEY("VSLandscapeStatusBar", 8, "横屏顶部自定义状态栏");
            VSLandscapeStatusBar = r9;
            KEY r10 = new KEY("TopLineToolBar", 9, "流区域顶部ToolBar");
            TopLineToolBar = r10;
            KEY r11 = new KEY("VSPortraitTopToolBar", 10, "VS横流竖屏顶部ToolBar");
            VSPortraitTopToolBar = r11;
            KEY r12 = new KEY("BrightnessView", 11, "手势亮度");
            BrightnessView = r12;
            KEY r13 = new KEY("VolumeView", 12, "手势音量");
            VolumeView = r13;
            KEY r14 = new KEY("PlayerShadowTop", 13, "播放器顶部阴影");
            PlayerShadowTop = r14;
            KEY r15 = new KEY("PlayerShadow", 14, "播放器阴影");
            PlayerShadow = r15;
            KEY r16 = new KEY("MatchRoomBack", 15, "赛事直播间横屏返回");
            MatchRoomBack = r16;
            KEY r17 = new KEY("LandscapeRoomTitle", 16, "直播间横屏标题栏");
            LandscapeRoomTitle = r17;
            KEY r18 = new KEY("LandscapeAnchorInfo", 17, "直播间横屏主播信息");
            LandscapeAnchorInfo = r18;
            KEY r19 = new KEY("MatchRoomCount", 18, "赛事直播间横屏在线人数");
            MatchRoomCount = r19;
            KEY r20 = new KEY("PortraitRowOne", 19, "竖屏第一行");
            PortraitRowOne = r20;
            KEY r21 = new KEY("PortraitRowTow", 20, "竖屏第二行");
            PortraitRowTow = r21;
            KEY r22 = new KEY("WatchCount", 21, "观看人数");
            WatchCount = r22;
            KEY r23 = new KEY("FirstShowHint", 22, "首播非实时内容提示");
            FirstShowHint = r23;
            KEY r24 = new KEY("FirstShowHintAlpha", 23, "首播非实时内容提示 竖版");
            FirstShowHintAlpha = r24;
            KEY r25 = new KEY("VideoPlayControl", 24, "录播播放控制");
            VideoPlayControl = r25;
            KEY r26 = new KEY("LivePlayControl", 25, "首播播放控制");
            LivePlayControl = r26;
            KEY r27 = new KEY("PlayTip", 26, "播放提示");
            PlayTip = r27;
            KEY r28 = new KEY("ProgressBar", 27, "进度条");
            ProgressBar = r28;
            KEY r29 = new KEY("LandscapeBottomToolBar", 28, "横屏底部ToolBar");
            LandscapeBottomToolBar = r29;
            KEY r30 = new KEY("LandscapeBottomLeftToolBar", 29, "横屏底部左侧Toolbar");
            LandscapeBottomLeftToolBar = r30;
            KEY r31 = new KEY("PortraitVideoDanmakuSend", 30, "竖屏录播弹幕发送");
            PortraitVideoDanmakuSend = r31;
            KEY r32 = new KEY("LandscapeDanmakuSend", 31, "横屏弹幕发送");
            LandscapeDanmakuSend = r32;
            KEY r33 = new KEY("PlayerShadowBottom", 32, "播放器底部阴影");
            PlayerShadowBottom = r33;
            KEY r34 = new KEY("VerticalPlayerShadow", 33, "竖屏流播放器阴影");
            VerticalPlayerShadow = r34;
            KEY r35 = new KEY("PortraitBottomToolBar", 34, "竖屏底部ToolBar");
            PortraitBottomToolBar = r35;
            KEY r36 = new KEY("PortraitBottomFollow", 35, "竖屏底部关注");
            PortraitBottomFollow = r36;
            KEY r37 = new KEY("PortraitBottomComment", 36, "竖屏底部评论框");
            PortraitBottomComment = r37;
            KEY r38 = new KEY("PortraitTopClose", 37, "竖屏顶部关闭");
            PortraitTopClose = r38;
            KEY r39 = new KEY("PortraitCamera", 38, "竖屏多机位");
            PortraitCamera = r39;
            KEY r40 = new KEY("VerticalVersion", 39, "竖屏视频多机位");
            VerticalVersion = r40;
            KEY r41 = new KEY("PortraitTopContent", 40, "竖屏顶部信息区");
            PortraitTopContent = r41;
            KEY r42 = new KEY("VerticalShowPlayInfo", 41, "综艺观看信息");
            VerticalShowPlayInfo = r42;
            KEY r43 = new KEY("VerticalTopFollow", 42, "竖屏顶部关注按钮");
            VerticalTopFollow = r43;
            KEY r44 = new KEY("VerticalSelectionEntry", 43, "选集入口");
            VerticalSelectionEntry = r44;
            KEY r45 = new KEY("VerticalDanmakuInput", 44, "竖屏输入框");
            VerticalDanmakuInput = r45;
            KEY r46 = new KEY("PortraitTopAnchor", 45, "竖屏顶部主播信息");
            PortraitTopAnchor = r46;
            KEY r47 = new KEY("PortraitLock", 46, "竖屏时的锁屏");
            PortraitLock = r47;
            KEY r48 = new KEY("TextMessage", 47, "公屏区");
            TextMessage = r48;
            KEY r49 = new KEY("ChatChannel", 48, "边看边聊");
            ChatChannel = r49;
            KEY r50 = new KEY("RightBottomBanner", 49, "右下角banner");
            RightBottomBanner = r50;
            KEY r51 = new KEY("KtvCard", 50, "ktv卡片");
            KtvCard = r51;
            KEY r52 = new KEY("RightCard", 51, "电商卡片");
            RightCard = r52;
            KEY r53 = new KEY("GiftTray", 52, "礼物托盘");
            GiftTray = r53;
            KEY r54 = new KEY("MoreLiveEntry", 53, "锁链多机位入口");
            MoreLiveEntry = r54;
            KEY r55 = new KEY("Digg", 54, "点赞");
            Digg = r55;
            KEY r56 = new KEY("DiggSelf", 55, "自己点赞");
            DiggSelf = r56;
            KEY r57 = new KEY("ECProduct", 56, "电商商品卡");
            ECProduct = r57;
            KEY r58 = new KEY("PaidLiveTempWatch", 57, "付费直播试看组件");
            PaidLiveTempWatch = r58;
            KEY r59 = new KEY("PaidTempCardContainer", 58, "付费直播试看组件-新");
            PaidTempCardContainer = r59;
            KEY r60 = new KEY("LandscapeDrawer", 59, "横屏抽屉");
            LandscapeDrawer = r60;
            KEY r61 = new KEY("LandscapeResetPlayerView", 60, "横屏重置播放器画面按钮");
            LandscapeResetPlayerView = r61;
            KEY r62 = new KEY("LandscapeBlockComment", 61, "媒体节目融合直播间屏蔽按钮");
            LandscapeBlockComment = r62;
            KEY r63 = new KEY("InteractiveWidget", 62, "互动组件");
            InteractiveWidget = r63;
            KEY r64 = new KEY("LandscapeInteractiveWidget", 63, "横屏互动组件");
            LandscapeInteractiveWidget = r64;
            KEY r65 = new KEY("BottomRightBanner", 64, "右下角banner");
            BottomRightBanner = r65;
            KEY r66 = new KEY("CastScreenLoading", 65, "投屏loading");
            CastScreenLoading = r66;
            KEY r67 = new KEY("PlayerViewLock", 66, "播放器锁屏");
            PlayerViewLock = r67;
            KEY r68 = new KEY("LiveOrientationControl", 67, "直播横竖屏控制");
            LiveOrientationControl = r68;
            KEY r69 = new KEY("VideoOrientationControl", 68, "录播横竖屏控制");
            VideoOrientationControl = r69;
            KEY r70 = new KEY("XTab_Test", 69, "横屏Xtab测试入口");
            XTab_Test = r70;
            KEY r71 = new KEY("LandscapeWatchCountInfo", 70, "回放横屏观看人次");
            LandscapeWatchCountInfo = r71;
            KEY r72 = new KEY("QuickShotRecordControl", 71, "赛事直播录屏");
            QuickShotRecordControl = r72;
            KEY r73 = new KEY("QuickShotShotControl", 72, "赛事直播截屏");
            QuickShotShotControl = r73;
            KEY r75 = new KEY("LandscapeRefresh", 73, "横屏刷新组件");
            LandscapeRefresh = r75;
            KEY r76 = new KEY("LandscapePhoneInfo", 74, "横屏顶部设备信息栏");
            LandscapePhoneInfo = r76;
            a = new KEY[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r75, r76};
        }

        public final String getDescribe() {
            return this.describe;
        }

        public KEY(String r1, int r2, String r3) {
            super(r1, r2);
            this.describe = r3;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Style;", "", "HIDE", "ATTACH", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Style extends Enum<Style> {
        public static final Style ATTACH = null;
        public static final Style HIDE = null;
        public static final /* synthetic */ Style[] a = null;

        static {
            Style r1 = new Style("HIDE", 0);
            HIDE = r1;
            Style r2 = new Style("ATTACH", 1);
            ATTACH = r2;
            a = new Style[]{r1, r2};
        }

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public Style(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/PlayerViewControl$Type;", "", "TOP", "BOTTOM", "LEFT", "RIGHT", "NONE", "ALPHA", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type ALPHA = null;
        public static final Type BOTTOM = null;
        public static final Type LEFT = null;
        public static final Type NONE = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r1 = new Type("TOP", 0);
            TOP = r1;
            Type r2 = new Type("BOTTOM", 1);
            BOTTOM = r2;
            Type r3 = new Type("LEFT", 2);
            LEFT = r3;
            Type r4 = new Type("RIGHT", 3);
            RIGHT = r4;
            Type r5 = new Type("NONE", 4);
            NONE = r5;
            Type r6 = new Type("ALPHA", 5);
            ALPHA = r6;
            a = new Type[]{r1, r2, r3, r4, r5, r6};
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    float attachMarginDp() default 0.0f;

    boolean ignoreLock() default false;

    KEY key();

    boolean needDynamicControl() default false;

    boolean reverse() default false;

    Style style() default Style.HIDE;

    Type type();
}
