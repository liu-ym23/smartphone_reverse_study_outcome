package com.bytedance.android.live.openplatform.impl.minigameanchor.applog;

import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.n;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qo0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J8\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bJ\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eJ8\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bR\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R.\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/applog/AnchorMiniGameAppLogContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "", "", "getCommonParams", "data", "", "addTaskEntranceInfo", "addInteractPanelGameInfo", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extra", "reportPreviewMgAppLog", "", "getPreviewMgCommonLogMap", "reportLiveRoomMgAppLog", "TAG", "Ljava/lang/String;", "Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "value", "microGameInfo", "Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "getMicroGameInfo", "()Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "setMicroGameInfo", "(Lcom/bytedance/android/live/broadcastgame/api/model/c0;)V", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorMiniGameAppLogContextService extends OpenPlatformContextService {
    private final String TAG;
    private c0 microGameInfo;

    private final Map<String, String> getCommonParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("_param_for_special", "micro_game");
        int r1 = n.a;
        n.d(getOpenPlatformContext().getRoom(), r0);
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r2 = AnchorMiniGameDataContext.a.a();
        if (r2 == null) goto L8;
        com.bytedance.live.datacontext.n<String> r3 = r2.getLiveType();
        if (r3 == null) goto L8;
        String r4 = (String) r3.getValue();
        if (r4 == null) goto L8;
    L15:
        r0.put("live_type", r4);
        r0.put("user_type", "anchor");
        Room r5 = getOpenPlatformContext().getRoom();
        if (r5 == null) goto L21;
        AnchorData r6 = r5.getAnchorData();
        if (r6 == null) goto L21;
        String r7 = r6.getFrameScale();
        if (r7 == null) goto L21;
    L22:
        r0.put("frame_scale", r7);
        return r0;
    L21:
        r7 = "";
    L8:
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, getOpenPlatformContext().getDataCenter(), 0, 2);
        if (r8 == null) goto L13;
        i r9 = r8.getLiveMode();
        if (r9 == null) goto L13;
        LiveMode r10 = (LiveMode) r9.getValue();
    L14:
        int r11 = h1.a;
        r4 = i1.a(r10);
    L13:
        r10 = null;
        goto L14
    }

    public final Map<String, String> getPreviewMgCommonLogMap() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(getCommonParams());
        addTaskEntranceInfo(r0);
        return r0;
    }

    public final c0 getMicroGameInfo() {
        return this.microGameInfo;
    }

    public AnchorMiniGameAppLogContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.TAG = "AnchorMiniGameAppLogContextService";
    }

    private final void addInteractPanelGameInfo(Map<String, String> r7) {
        c0 r0 = this.microGameInfo;
        String r2 = "";
        if (r0 == null) goto L38;
        String r3 = r0.gameId;
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r7.put("mp_id", r3);
        String r4 = r0.gameName;
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r7.put("mp_name", r4);
        String r5 = r0.gameType;
        if (r5 != null) goto L13;
        r5 = "micro_game";
    L13:
        r7.put("game_type", r5);
        String r6 = r0.gameId;
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r7.put("game_id", r6);
        String r8 = r0.gameName;
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r7.put("game_name", r8);
        r7.put("game_category", "micro_game");
        r7.put("user_type", "anchor");
        String r9 = r0.a;
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        r7.put("source", r9);
        String r10 = r0.taskId;
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        r7.put("task_id", r10);
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r11 = AnchorGameContext.a.a();
        if (r11 == null) goto L31;
        m r12 = r11.getSearchWord();
        if (r12 == null) goto L31;
        String r13 = (String) r12.getValue();
        if (r13 == null) goto L31;
    L32:
        r7.put("search_word", r13);
        Integer r1 = r0.bidType;
        if (r1 == null) goto L36;
        String r14 = String.valueOf(r1.intValue());
        if (r14 == null) goto L36;
    L37:
        r7.put("bid_type", r14);
    L36:
        r14 = "";
    L31:
        r13 = "";
    L38:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r15 = AnchorMiniGameDataContext.a.a();
        if (r15 == null) goto L43;
        com.bytedance.live.datacontext.n<Pair<String, String>> r16 = r15.getSourceFromDetailPage();
        if (r16 == null) goto L43;
        Pair r17 = (Pair) r16.getValue();
    L44:
        if (r17 == null) goto L53;
        String r18 = (String) r17.getFirst();
        if (r18 == null) goto L54;
        r7.put("source", r18);
        String r19 = (String) r17.getSecond();
        if (r19 == null) goto L51;
        r2 = r19;
    L51:
        r7.put("oe_source", r2);
        return;
    L54:
        return;
    L53:
        return;
    L43:
        r17 = null;
        goto L44
    }

    private final void addTaskEntranceInfo(Map<String, String> r5) {
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L31;
        com.bytedance.live.datacontext.n<OpenPlatformMgInfoModel> r1 = r0.getOpenPlatformMg();
        if (r1 == null) goto L32;
        OpenPlatformMgInfoModel r2 = (OpenPlatformMgInfoModel) r1.getValue();
        if (r2 == null) goto L33;
        String r3 = r2.getAppId();
        String r4 = "";
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r5.put("mp_id", r3);
        String r6 = r2.getAppName();
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r5.put("mp_name", r6);
        String r7 = r2.getGameType();
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        r5.put("game_type", r7);
        String r8 = r2.getTaskId();
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        r5.put("task_id", r8);
        String r9 = r2.getPanelFrom();
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        r5.put("panel_from", r9);
        Integer r10 = r2.getBidType();
        if (r10 == null) goto L29;
        String r11 = String.valueOf(r10.intValue());
        if (r11 == null) goto L29;
        r4 = r11;
    L29:
        r5.put("bid_type", r4);
        return;
    L33:
        return;
    L32:
        return;
    }

    public final void setMicroGameInfo(c0 r1) {
        if (r1 == null) goto L4;
        this.microGameInfo = r1;
        return;
    L4:
        this.microGameInfo = null;
    }

    public final void reportLiveRoomMgAppLog(String r5, HashMap<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = a.a;
        a.c(this.TAG, "live room event: " + r5 + ", extra:" + String.valueOf(r6));
        g r1 = u.l();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.putAll(getCommonParams());
        addTaskEntranceInfo(r2);
        addInteractPanelGameInfo(r2);
        if (r6 == null) goto L5;
        r2.putAll(r6);
    L5:
        Unit r7 = Unit.INSTANCE;
        r1.e(r5, r2, new Object[]{Room.class});
    }

    public final void reportPreviewMgAppLog(String r4, HashMap<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        int r0 = a.a;
        a.c(this.TAG, "preview event: " + r4 + ", extra:" + String.valueOf(r5));
        g r1 = u.l();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.putAll(getCommonParams());
        addTaskEntranceInfo(r2);
        if (r5 == null) goto L5;
        r2.putAll(r5);
    L5:
        Unit r6 = Unit.INSTANCE;
        r1.e(r4, r2, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportLiveRoomMgAppLog$default(AnchorMiniGameAppLogContextService r0, String r1, HashMap r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.reportLiveRoomMgAppLog(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportPreviewMgAppLog$default(AnchorMiniGameAppLogContextService r0, String r1, HashMap r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.reportPreviewMgAppLog(r1, r2);
    }
}
