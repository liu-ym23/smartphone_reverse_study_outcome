package com.bytedance.android.live.liveinteract.api.trace;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b+\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u0006."}, d2 = {"com/bytedance/android/live/liveinteract/api/trace/MultiTraceData$TraceEvent", "", "Lcom/bytedance/android/live/liveinteract/api/trace/MultiTraceData$TraceEvent;", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "eventDes", "getEventDes", "OPEN_LINKED_PANEL", "InviteAudienceLink", "AudienceApplyLink", "CloseLink", "RtcLinkError", "LinkMedia", "LinkPipeline", "OpenChatRoom", "SwitchScene", "EnterRoomStatistics", "OpenEnlargeGuest", "OPEN_ORDER_SONG_PANEL", "AddSongChain", "SongControl", "SingFlow", "MusicPlayFlow", "KtvFeatureSwitch", "MultiLinkDynamic", "AdventureCall", "AnimRenderPlatform", "AnchorCloudGame", "GuestCloudGame", "GameAvatarStart", "GameAvatarEnd", "InteractXplay", "ChorusInfoUpdate", "JoinChorus", "LeaveChorus", "ChorusFlow", "ChorusCDNStream", "ChorusCaptureStream", "LyricsRecognize", "GuestLinkerLink", "GuestLinkerMedia", "BackupSei", "LinkmicPanelOpen", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiTraceData$TraceEvent extends Enum<MultiTraceData$TraceEvent> {
    public static final MultiTraceData$TraceEvent AddSongChain = null;
    public static final MultiTraceData$TraceEvent AdventureCall = null;
    public static final MultiTraceData$TraceEvent AnchorCloudGame = null;
    public static final MultiTraceData$TraceEvent AnimRenderPlatform = null;
    public static final MultiTraceData$TraceEvent AudienceApplyLink = null;
    public static final MultiTraceData$TraceEvent BackupSei = null;
    public static final MultiTraceData$TraceEvent ChorusCDNStream = null;
    public static final MultiTraceData$TraceEvent ChorusCaptureStream = null;
    public static final MultiTraceData$TraceEvent ChorusFlow = null;
    public static final MultiTraceData$TraceEvent ChorusInfoUpdate = null;
    public static final MultiTraceData$TraceEvent CloseLink = null;
    public static final MultiTraceData$TraceEvent EnterRoomStatistics = null;
    public static final MultiTraceData$TraceEvent GameAvatarEnd = null;
    public static final MultiTraceData$TraceEvent GameAvatarStart = null;
    public static final MultiTraceData$TraceEvent GuestCloudGame = null;
    public static final MultiTraceData$TraceEvent GuestLinkerLink = null;
    public static final MultiTraceData$TraceEvent GuestLinkerMedia = null;
    public static final MultiTraceData$TraceEvent InteractXplay = null;
    public static final MultiTraceData$TraceEvent InviteAudienceLink = null;
    public static final MultiTraceData$TraceEvent JoinChorus = null;
    public static final MultiTraceData$TraceEvent KtvFeatureSwitch = null;
    public static final MultiTraceData$TraceEvent LeaveChorus = null;
    public static final MultiTraceData$TraceEvent LinkMedia = null;
    public static final MultiTraceData$TraceEvent LinkPipeline = null;
    public static final MultiTraceData$TraceEvent LinkmicPanelOpen = null;
    public static final MultiTraceData$TraceEvent LyricsRecognize = null;
    public static final MultiTraceData$TraceEvent MultiLinkDynamic = null;
    public static final MultiTraceData$TraceEvent MusicPlayFlow = null;
    public static final MultiTraceData$TraceEvent OPEN_LINKED_PANEL = null;
    public static final MultiTraceData$TraceEvent OPEN_ORDER_SONG_PANEL = null;
    public static final MultiTraceData$TraceEvent OpenChatRoom = null;
    public static final MultiTraceData$TraceEvent OpenEnlargeGuest = null;
    public static final MultiTraceData$TraceEvent RtcLinkError = null;
    public static final MultiTraceData$TraceEvent SingFlow = null;
    public static final MultiTraceData$TraceEvent SongControl = null;
    public static final MultiTraceData$TraceEvent SwitchScene = null;
    public static final /* synthetic */ MultiTraceData$TraceEvent[] a = null;
    private final String eventDes;
    private final String eventName;

    public static MultiTraceData$TraceEvent valueOf(String r1) {
        return (MultiTraceData$TraceEvent) a.a(MultiTraceData$TraceEvent.class, r1);
    }

    public static MultiTraceData$TraceEvent[] values() {
        return (MultiTraceData$TraceEvent[]) a.clone();
    }

    static {
        MultiTraceData$TraceEvent r1 = new MultiTraceData$TraceEvent("OPEN_LINKED_PANEL", 0, "open_linked_panel", "开启连线面板");
        OPEN_LINKED_PANEL = r1;
        MultiTraceData$TraceEvent r2 = new MultiTraceData$TraceEvent("InviteAudienceLink", 1, "InviteAudienceLink", "邀请观众连线");
        InviteAudienceLink = r2;
        MultiTraceData$TraceEvent r3 = new MultiTraceData$TraceEvent("AudienceApplyLink", 2, "AudienceApplyLink", "观众申请连线");
        AudienceApplyLink = r3;
        MultiTraceData$TraceEvent r4 = new MultiTraceData$TraceEvent("CloseLink", 3, "CloseLink", "断开连线");
        CloseLink = r4;
        MultiTraceData$TraceEvent r5 = new MultiTraceData$TraceEvent("RtcLinkError", 4, "RtcLinkError", "Rtc连线异常");
        RtcLinkError = r5;
        MultiTraceData$TraceEvent r6 = new MultiTraceData$TraceEvent("LinkMedia", 5, "LinkMedia", "连线音视频");
        LinkMedia = r6;
        MultiTraceData$TraceEvent r7 = new MultiTraceData$TraceEvent("LinkPipeline", 6, "LinkPipeline", "连线流程");
        LinkPipeline = r7;
        MultiTraceData$TraceEvent r8 = new MultiTraceData$TraceEvent("OpenChatRoom", 7, "OpenChatRoom", "主播开启聊天室");
        OpenChatRoom = r8;
        MultiTraceData$TraceEvent r9 = new MultiTraceData$TraceEvent("SwitchScene", 8, "SwitchScene", "主播切换布局");
        SwitchScene = r9;
        MultiTraceData$TraceEvent r10 = new MultiTraceData$TraceEvent("EnterRoomStatistics", 9, "EnterRoomStatistics", "看播进房耗时");
        EnterRoomStatistics = r10;
        MultiTraceData$TraceEvent r11 = new MultiTraceData$TraceEvent("OpenEnlargeGuest", 10, "OpenEnlargeGuest", "开启主咖");
        OpenEnlargeGuest = r11;
        MultiTraceData$TraceEvent r12 = new MultiTraceData$TraceEvent("OPEN_ORDER_SONG_PANEL", 11, "open_order_song_panel", "开启点歌面板");
        OPEN_ORDER_SONG_PANEL = r12;
        MultiTraceData$TraceEvent r13 = new MultiTraceData$TraceEvent("AddSongChain", 12, "AddSongChain", "点歌链路");
        AddSongChain = r13;
        MultiTraceData$TraceEvent r14 = new MultiTraceData$TraceEvent("SongControl", 13, "SongControl", "歌曲控制");
        SongControl = r14;
        MultiTraceData$TraceEvent r15 = new MultiTraceData$TraceEvent("SingFlow", 14, "SingFlow", "开唱流程");
        SingFlow = r15;
        MultiTraceData$TraceEvent r16 = new MultiTraceData$TraceEvent("MusicPlayFlow", 15, "MusicPlayFlow", "播放流程");
        MusicPlayFlow = r16;
        MultiTraceData$TraceEvent r17 = new MultiTraceData$TraceEvent("KtvFeatureSwitch", 16, "KtvFeatureSwitch", "功能开关");
        KtvFeatureSwitch = r17;
        MultiTraceData$TraceEvent r18 = new MultiTraceData$TraceEvent("MultiLinkDynamic", 17, "MultiLinkDynamic", "动态化框架");
        MultiLinkDynamic = r18;
        MultiTraceData$TraceEvent r19 = new MultiTraceData$TraceEvent("AdventureCall", 18, "AdventureCall", "奇遇连连通话流程");
        AdventureCall = r19;
        MultiTraceData$TraceEvent r20 = new MultiTraceData$TraceEvent("AnimRenderPlatform", 19, "AnimRenderPlatform", "动效渲染框架加载");
        AnimRenderPlatform = r20;
        MultiTraceData$TraceEvent r21 = new MultiTraceData$TraceEvent("AnchorCloudGame", 20, "AnchorXplayLoad", "主播云游戏链路");
        AnchorCloudGame = r21;
        MultiTraceData$TraceEvent r22 = new MultiTraceData$TraceEvent("GuestCloudGame", 21, "GuestXplayLoad", "嘉宾云游戏链路");
        GuestCloudGame = r22;
        MultiTraceData$TraceEvent r23 = new MultiTraceData$TraceEvent("GameAvatarStart", 22, "GameAvatarStart", "云游戏HamletAvatar开启链路");
        GameAvatarStart = r23;
        MultiTraceData$TraceEvent r24 = new MultiTraceData$TraceEvent("GameAvatarEnd", 23, "GameAvatarEnd", "云游戏HamletAvatar关闭链路");
        GameAvatarEnd = r24;
        MultiTraceData$TraceEvent r25 = new MultiTraceData$TraceEvent("InteractXplay", 24, "InteractXplayLoad", "云游戏开启链路");
        InteractXplay = r25;
        MultiTraceData$TraceEvent r26 = new MultiTraceData$TraceEvent("ChorusInfoUpdate", 25, "ChorusInfoUpdate", "合唱状态变更");
        ChorusInfoUpdate = r26;
        MultiTraceData$TraceEvent r27 = new MultiTraceData$TraceEvent("JoinChorus", 26, "JoinChorus", "加入合唱流程");
        JoinChorus = r27;
        MultiTraceData$TraceEvent r28 = new MultiTraceData$TraceEvent("LeaveChorus", 27, "LeaveChorus", "离开合唱流程");
        LeaveChorus = r28;
        MultiTraceData$TraceEvent r29 = new MultiTraceData$TraceEvent("ChorusFlow", 28, "ChorusFlow", "合唱中流程");
        ChorusFlow = r29;
        MultiTraceData$TraceEvent r30 = new MultiTraceData$TraceEvent("ChorusCDNStream", 29, "chorusCdnStreamPush", "合唱推流链路");
        ChorusCDNStream = r30;
        MultiTraceData$TraceEvent r31 = new MultiTraceData$TraceEvent("ChorusCaptureStream", 30, "chorusCapture", "合唱采集链路");
        ChorusCaptureStream = r31;
        MultiTraceData$TraceEvent r32 = new MultiTraceData$TraceEvent("LyricsRecognize", 31, "LyricsRecognize", "歌词识别流程");
        LyricsRecognize = r32;
        MultiTraceData$TraceEvent r33 = new MultiTraceData$TraceEvent("GuestLinkerLink", 32, "GuestLinkerLink", "嘉宾奇遇连线流程");
        GuestLinkerLink = r33;
        MultiTraceData$TraceEvent r34 = new MultiTraceData$TraceEvent("GuestLinkerMedia", 33, "GuestLinkerMedia", "嘉宾奇遇音视频链路");
        GuestLinkerMedia = r34;
        MultiTraceData$TraceEvent r35 = new MultiTraceData$TraceEvent("BackupSei", 34, "BackupSei", "备份SEI");
        BackupSei = r35;
        MultiTraceData$TraceEvent r36 = new MultiTraceData$TraceEvent("LinkmicPanelOpen", 35, "ttlive_linkmic_panel_open", "动态化面板");
        LinkmicPanelOpen = r36;
        a = new MultiTraceData$TraceEvent[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36};
    }

    public final String getEventDes() {
        return this.eventDes;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public MultiTraceData$TraceEvent(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.eventName = r3;
        this.eventDes = r4;
    }
}
