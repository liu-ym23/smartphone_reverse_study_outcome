package com.bytedance.android.live.liveinteract.api.trace;

import com.bytedance.android.live.network.annotation.PbRequest;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"com/bytedance/android/live/liveinteract/api/trace/MultiTraceData$TraceBusiness", "", "Lcom/bytedance/android/live/liveinteract/api/trace/MultiTraceData$TraceBusiness;", "", "busName", "Ljava/lang/String;", "getBusName", "()Ljava/lang/String;", "busDes", "getBusDes", "BackupSei", "MultiLink", "ChatRoom", "KTV", "MultiRevenue", "GameAvatar", "InteractXplay", "RTChorus", "AILyricsRecognize", "CONCERT", "GuestLink", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiTraceData$TraceBusiness extends Enum<MultiTraceData$TraceBusiness> {
    public static final MultiTraceData$TraceBusiness AILyricsRecognize = null;
    public static final MultiTraceData$TraceBusiness BackupSei = null;
    public static final MultiTraceData$TraceBusiness CONCERT = null;
    public static final MultiTraceData$TraceBusiness ChatRoom = null;
    public static final MultiTraceData$TraceBusiness GameAvatar = null;
    public static final MultiTraceData$TraceBusiness GuestLink = null;
    public static final MultiTraceData$TraceBusiness InteractXplay = null;
    public static final MultiTraceData$TraceBusiness KTV = null;
    public static final MultiTraceData$TraceBusiness MultiLink = null;
    public static final MultiTraceData$TraceBusiness MultiRevenue = null;
    public static final MultiTraceData$TraceBusiness RTChorus = null;
    public static final /* synthetic */ MultiTraceData$TraceBusiness[] a = null;
    private final String busDes;
    private final String busName;

    public static MultiTraceData$TraceBusiness valueOf(String r1) {
        return (MultiTraceData$TraceBusiness) a.a(MultiTraceData$TraceBusiness.class, r1);
    }

    public static MultiTraceData$TraceBusiness[] values() {
        return (MultiTraceData$TraceBusiness[]) a.clone();
    }

    static {
        MultiTraceData$TraceBusiness r1 = new MultiTraceData$TraceBusiness("BackupSei", 0, "backup_sei", "备份SEI通路");
        BackupSei = r1;
        MultiTraceData$TraceBusiness r2 = new MultiTraceData$TraceBusiness("MultiLink", 1, PbRequest.SwitchType.MULTI_LINK, "基础连线");
        MultiLink = r2;
        MultiTraceData$TraceBusiness r3 = new MultiTraceData$TraceBusiness("ChatRoom", 2, "chat_room", "聊天室");
        ChatRoom = r3;
        MultiTraceData$TraceBusiness r4 = new MultiTraceData$TraceBusiness("KTV", 3, "ktv", "ktv");
        KTV = r4;
        MultiTraceData$TraceBusiness r5 = new MultiTraceData$TraceBusiness("MultiRevenue", 4, "multi_revenue", "基础营收");
        MultiRevenue = r5;
        MultiTraceData$TraceBusiness r6 = new MultiTraceData$TraceBusiness("GameAvatar", 5, "game_avatar", "云游戏HamletAvatar");
        GameAvatar = r6;
        MultiTraceData$TraceBusiness r7 = new MultiTraceData$TraceBusiness("InteractXplay", 6, "interact_xplay", "云游戏基础组件");
        InteractXplay = r7;
        MultiTraceData$TraceBusiness r8 = new MultiTraceData$TraceBusiness("RTChorus", 7, "ktv_chorus", "合唱派对");
        RTChorus = r8;
        MultiTraceData$TraceBusiness r9 = new MultiTraceData$TraceBusiness("AILyricsRecognize", 8, "lyrics_recognize", "AI歌词识别");
        AILyricsRecognize = r9;
        MultiTraceData$TraceBusiness r10 = new MultiTraceData$TraceBusiness("CONCERT", 9, "ktv_chorus_concert", "演唱会");
        CONCERT = r10;
        MultiTraceData$TraceBusiness r11 = new MultiTraceData$TraceBusiness("GuestLink", 10, "guest_link", "嘉宾连线");
        GuestLink = r11;
        a = new MultiTraceData$TraceBusiness[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }

    public final String getBusDes() {
        return this.busDes;
    }

    public final String getBusName() {
        return this.busName;
    }

    public MultiTraceData$TraceBusiness(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.busName = r3;
        this.busDes = r4;
    }
}
