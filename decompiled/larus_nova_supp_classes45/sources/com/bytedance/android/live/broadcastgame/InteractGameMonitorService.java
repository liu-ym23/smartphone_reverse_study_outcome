package com.bytedance.android.live.broadcastgame;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0003J0\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J*\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0003J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J(\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003JD\u0010\u0017\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0003JD\u0010\u001a\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0003J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\"\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010#\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0016J\u001a\u0010$\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010%\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010&\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010)\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010(\u001a\u00020'H\u0016J4\u0010,\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010*\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\u0002H\u0016J4\u0010-\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010*\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\u0002H\u0016J:\u00102\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0002H\u0016J\u0016\u00105\u001a\u00020\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001303H\u0016J6\u00106\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u0013032\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0002H\u0016R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/bytedance/android/live/broadcastgame/InteractGameMonitorService;", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/IInteractGameMonitorService;", "", "generateCurrentGameIdentifier", "Lorg/json/JSONObject;", "data", "category", "", "adapterDataFormat", "service", "", "status", "metric", "extra", "monitor", "", "duration", "monitorStatus", "monitorStatusAndDuration", "Lcom/bytedance/android/live/broadcastgame/api/model/u;", "gameItem", "", "throwable", "logService", "Lcom/bytedance/android/live/broadcastgame/api/model/r;", "gameExtra", "logServiceWithGameExtra", "gameIdentifier", "recordGameIdentifier", "getCurrentGameIdentifier", "logFetchInteractItemList", "logInteractGameItemClick", "failedCode", "switchId", "switchName", "logInteractGamePreCheck", "logGameIntroShow", "logGameIntroClick", "logGameStartupResult", "", "isCutShort", "logGameStop", "playId", "logId", "logGameStatusStart", "logGameStatusStop", "tryCount", "startLoadTime", "errorCode", "errorMsg", "logEffectGameResourceLoad", "", "games", "logEffectBatchLoadStart", "logEffectBatchLoadEnd", "mCurrentGameIdentifier", "Ljava/lang/String;", "mStartGameTime", "J", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InteractGameMonitorService implements IInteractGameMonitorService {
    private String mCurrentGameIdentifier;
    private long mStartGameTime;

    private final void monitor(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5) {
    }

    private final String generateCurrentGameIdentifier() {
        return "game_" + System.currentTimeMillis();
    }

    public InteractGameMonitorService() {
        this.mCurrentGameIdentifier = "";
        jc1.k.l(IInteractGameMonitorService.class, this);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public String getCurrentGameIdentifier() {
        return this.mCurrentGameIdentifier;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logEffectBatchLoadStart(List<com.bytedance.android.live.broadcastgame.api.model.u> r4) {
        Intrinsics.checkNotNullParameter(r4, "games");
        List<com.bytedance.android.live.broadcastgame.api.model.u> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        com.bytedance.android.live.broadcastgame.api.model.r r1 = ((com.bytedance.android.live.broadcastgame.api.model.u) r6.next()).c();
        if (r1 == null) goto L8;
        long r2 = r1.p();
    L9:
        r0.add(Long.valueOf(r2));
        goto L4
    L8:
        r2 = 0;
        goto L9
    L10:
        JSONObject r7 = new JSONObject();
        BaseMonitor.add(r7, "game_id_arr", r0.toString());
        BaseMonitor.add(r7, "download_count", r0.size());
        monitorStatus(IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_START, 0, r7);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void recordGameIdentifier(String r2) {
        Intrinsics.checkNotNullParameter(r2, "gameIdentifier");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.mCurrentGameIdentifier = generateCurrentGameIdentifier();
        return;
    L8:
        this.mCurrentGameIdentifier = r2;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Deprecated(message = "这只是一种成本比较低的迁移方案")
    private final void adapterDataFormat(JSONObject r5, JSONObject r6) {
        Iterator<String> r0 = r5.keys();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next().toString();
        String r2 = r5.get(r1).toString();
        Set<String> r3 = com.bytedance.android.live.broadcastgame.api.interactgame.l.a;
        if (com.bytedance.android.live.broadcastgame.api.interactgame.l.a.contains(r1) == false) goto L4;
        BaseMonitor.add(r6, r1, r2);
        goto L4
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameIntroClick(int r11, com.bytedance.android.live.broadcastgame.api.model.u r12) {
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_INTRO_CLICK_ALL, r11, r12, null, 0, null, 56, null);
        if (r11 != 1) goto L6;
        this.mCurrentGameIdentifier = "";
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameIntroShow(int r11, com.bytedance.android.live.broadcastgame.api.model.u r12) {
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_INTRO_SHOW_ALL, r11, r12, null, 0, null, 56, null);
    }

    @Deprecated(message = "后续不要使用这个上报了")
    private final void monitorStatus(String r9, int r11, JSONObject r12) {
        monitor$default(this, r9, r11, r12, 0, 8, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logFetchInteractItemList(int r8, long r9, Throwable r11) {
        JSONObject r6 = new JSONObject();
        monitorStatusAndDuration(IInteractGameMonitorService.SERVICE_FETCH_INTERACT_GAME_LIST_ALL, r8, r9, r6);
        if (r8 != 1) goto L6;
        com.bytedance.android.live.broadcastgame.api.interactgame.i.a(r6, r11);
        monitorStatusAndDuration(IInteractGameMonitorService.SERVICE_FETCH_INTERACT_GAME_LIST_ERROR, r8, r9, r6);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameStartupResult(int r13, com.bytedance.android.live.broadcastgame.api.model.u r14, JSONObject r15) {
        this.mStartGameTime = System.currentTimeMillis();
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_START_ALL, r13, r14, r15, 0, null, 48, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameStop(int r13, com.bytedance.android.live.broadcastgame.api.model.u r14, boolean r15) {
        JSONObject r4 = new JSONObject();
        BaseMonitor.add(r4, "current_game_identifer", this.mCurrentGameIdentifier);
        if (r15 == false) goto L5;
        BaseMonitor.add(r4, "is_cut_short", 1);
    L7:
        if (this.mStartGameTime != 0) goto L9;
        long r5 = 0;
    L10:
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_EXIT_ALL, r13, r14, r4, r5, null, 32, null);
        this.mCurrentGameIdentifier = "";
        this.mStartGameTime = 0;
        return;
    L9:
        r5 = System.currentTimeMillis() - this.mStartGameTime;
        goto L10
    L5:
        BaseMonitor.add(r4, "is_cut_short", 0);
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logInteractGameItemClick(int r12, com.bytedance.android.live.broadcastgame.api.model.u r13, JSONObject r14) {
        this.mCurrentGameIdentifier = generateCurrentGameIdentifier();
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_ICON_CLICK_ALL, r12, r13, r14, 0, null, 48, null);
    }

    @Deprecated(message = "后续不要使用这个上报了")
    private final void monitor(String r11, int r12, JSONObject r13, long r14) {
        JSONObject r3 = new JSONObject();
        adapterDataFormat(r13, r3);
        JSONObject r4 = new JSONObject();
        if (r14 == (-1)) goto L5;
        BaseMonitor.add(r4, "duration", r14);
    L5:
        int r15 = com.bytedance.android.live.broadcastgame.api.interactgame.i.a;
        Intrinsics.checkNotNullParameter(r13, "extra");
        Intrinsics.checkNotNullParameter(r3, "category");
        RoomContext.a r16 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r16, null, 0, 3);
        if (r5 == null) goto L10;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L10;
        Room r7 = (Room) r6.getValue();
    L11:
        String r8 = "-1";
        if (r7 == null) goto L15;
        String r9 = r7.getIdStr();
        if (r9 == null) goto L15;
    L16:
        BaseMonitor.add(r13, "room_id", r9);
        if (r7 == null) goto L22;
        String r17 = r7.getOwnerUserIdString();
        if (r17 == null) goto L22;
        r8 = r17;
    L22:
        BaseMonitor.add(r13, "anchor_id", r8);
        if (r7 == null) goto L25;
        LiveMode r18 = r7.getStreamType();
    L26:
        int r19 = h1.a;
        BaseMonitor.add(r3, "live_type", i1.a(r18));
        RoomContext r110 = RoomContext.a.c(r16, null, 0, 3);
        if (r110 == null) goto L33;
        com.bytedance.live.datacontext.i r111 = r110.isAnchor();
        if (r111 == null) goto L33;
        if (((Boolean) r111.getValue()).booleanValue() != true) goto L33;
        String r112 = "0";
    L34:
        BaseMonitor.add(r3, "is_anchor", r112);
        BaseMonitor.add(r3, "status", r12);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L37;
        ALogger.d("OpenPlatformMonitor", "\n Service: " + r11 + " status: " + r12 + " metric: " + r4 + " \n category: " + r3 + "  \n extra: " + r13);
    L37:
        LiveTracingMonitor.e(r11, LiveTracingMonitor.EventModule.OPEN_PLATFORM, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r3, r4, r13);
        return;
    L33:
        r112 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        goto L34
    L25:
        r18 = null;
    L15:
        r9 = "-1";
    L10:
        r7 = null;
        goto L11
    }

    @Deprecated(message = "后续不要使用这个上报了")
    private final void monitorStatusAndDuration(String r7, int r8, long r9, JSONObject r11) {
        monitor(r7, r8, r11, r9);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logEffectBatchLoadEnd(int r9, List<com.bytedance.android.live.broadcastgame.api.model.u> r11, long r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "games");
        Intrinsics.checkNotNullParameter(r14, "errorMsg");
        List<com.bytedance.android.live.broadcastgame.api.model.u> r15 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L10;
        com.bytedance.android.live.broadcastgame.api.model.r r1 = ((com.bytedance.android.live.broadcastgame.api.model.u) r16.next()).c();
        if (r1 == null) goto L8;
        long r2 = r1.p();
    L9:
        r0.add(Long.valueOf(r2));
        goto L4
    L8:
        r2 = 0;
        goto L9
    L10:
        JSONObject r17 = new JSONObject();
        long r18 = System.currentTimeMillis() - r12;
        BaseMonitor.add(r17, "game_id_arr", r0.toString());
        BaseMonitor.add(r17, "downloaded_count", r0.size());
        if (r9 != 0) goto L13;
        monitorStatusAndDuration(IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_ALL, 0, r18, r17);
        return;
    L13:
        BaseMonitor.add(r17, LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r13);
        BaseMonitor.add(r17, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r14);
        monitorStatusAndDuration(IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_ALL, 1, r18, r17);
        monitorStatusAndDuration(IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_ERROR, 1, r18, r17);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameStatusStart(int r13, com.bytedance.android.live.broadcastgame.api.model.u r14, long r15, Throwable r17, String r18) {
        Intrinsics.checkNotNullParameter(r18, "logId");
        JSONObject r1 = new JSONObject();
        BaseMonitor.add(r1, "log_id", r18);
        BaseMonitor.add(r1, "play_id", String.valueOf(r15));
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_STATUS_START_ALL, r13, r14, r1, 0, null, 48, null);
        if (r13 != 1) goto L6;
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_STATUS_START_ERROR, r13, r14, r1, 0, r17, 16, null);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameStatusStop(int r13, com.bytedance.android.live.broadcastgame.api.model.u r14, long r15, Throwable r17, String r18) {
        Intrinsics.checkNotNullParameter(r18, "logId");
        JSONObject r1 = new JSONObject();
        BaseMonitor.add(r1, "play_id", String.valueOf(r15));
        BaseMonitor.add(r1, "log_id", r18);
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_STATUS_STOP_ALL, r13, r14, r1, 0, null, 48, null);
        if (r13 != 1) goto L6;
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_STATUS_STOP_ERROR, r13, r14, r1, 0, r17, 16, null);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logInteractGamePreCheck(int r12, com.bytedance.android.live.broadcastgame.api.model.u r13, String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r14, "failedCode");
        Intrinsics.checkNotNullParameter(r15, "switchId");
        Intrinsics.checkNotNullParameter(r16, "switchName");
        if (Intrinsics.areEqual(this.mCurrentGameIdentifier, "") == false) goto L5;
        this.mCurrentGameIdentifier = generateCurrentGameIdentifier();
    L5:
        if (r12 != 0) goto L7;
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_CHECK_ALL, r12, r13, null, 0, null, 56, null);
        return;
    L7:
        JSONObject r4 = new JSONObject();
        r4.put("status_code", r14);
        boolean r3 = true;
        if (r15.length() <= 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L13;
    L18:
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_CHECK_ALL, r12, r13, r4, 0, null, 48, null);
        return;
    L13:
        if (r16.length() > 0) goto L16;
        r3 = false;
    L16:
        if (r3 == false) goto L18;
        r4.put("switch_game_id", r15);
        r4.put("switch_game_name", r16);
        goto L18
    L10:
        r0 = false;
        goto L11
    }

    @Deprecated(message = "后续不要使用这个上报了")
    private final void logService(String r7, int r8, com.bytedance.android.live.broadcastgame.api.model.u r9, JSONObject r11, long r12, Throwable r13) {
        if (r11 != null) goto L4;
        r11 = new JSONObject();
    L4:
        JSONObject r5 = r11;
        int r14 = com.bytedance.android.live.broadcastgame.api.interactgame.i.a;
        Intrinsics.checkNotNullParameter(r5, "extra");
        if (r9 == null) goto L7;
        BaseMonitor.add(r5, "game_name", r9.name);
        com.bytedance.android.live.broadcastgame.api.interactgame.i.b(r5, r9.c(), true);
    L10:
        com.bytedance.android.live.broadcastgame.api.interactgame.i.a(r5, r13);
        BaseMonitor.add(r5, "current_game_identifer", this.mCurrentGameIdentifier);
        if (r12 == (-1)) goto L13;
        monitorStatusAndDuration(r7, r8, r12, r5);
        return;
    L13:
        monitorStatus(r7, r8, r5);
        return;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        BaseMonitor.add(r5, "tip", "game_item is null");
        goto L10
    }

    @Deprecated(message = "后续不要使用这个上报了")
    private final void logServiceWithGameExtra(String r7, int r8, com.bytedance.android.live.broadcastgame.api.model.r r9, JSONObject r11, long r12, Throwable r13) {
        if (r11 != null) goto L4;
        r11 = new JSONObject();
    L4:
        JSONObject r5 = r11;
        com.bytedance.android.live.broadcastgame.api.interactgame.i.b(r5, r9, false);
        com.bytedance.android.live.broadcastgame.api.interactgame.i.a(r5, r13);
        BaseMonitor.add(r5, "current_game_identifer", this.mCurrentGameIdentifier);
        if (r12 == (-1)) goto L7;
        monitorStatusAndDuration(r7, r8, r12, r5);
        return;
    L7:
        monitorStatus(r7, r8, r5);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logEffectGameResourceLoad(int r14, com.bytedance.android.live.broadcastgame.api.model.u r15, int r16, long r17, int r19, String r21) {
        Intrinsics.checkNotNullParameter(r21, "errorMsg");
        JSONObject r1 = new JSONObject();
        BaseMonitor.add(r1, "try_count", r16);
        if (r14 != 1) goto L5;
        BaseMonitor.add(r1, LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r19);
        BaseMonitor.add(r1, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r21);
        logService$default(this, IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_LOAD_ERROR, r14, r15, r1, System.currentTimeMillis() - r17, null, 32, null);
    L5:
        logService$default(this, IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_LOAD_ALL, r14, r15, r1, System.currentTimeMillis() - r17, null, 32, null);
    }

    public static /* synthetic */ void monitor$default(InteractGameMonitorService r6, String r7, int r8, JSONObject r9, long r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 8) == 0) goto L6;
        r11 = -1;
    L6:
        r6.monitor(r7, r8, r9, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitor");
    }

    public static /* synthetic */ void logService$default(InteractGameMonitorService r11, String r12, int r13, com.bytedance.android.live.broadcastgame.api.model.u r14, JSONObject r15, long r16, Throwable r17, int r18, Object r19) {
        if (r19 != null) goto L18;
        if ((r18 & 8) == 0) goto L6;
        JSONObject r6 = null;
    L8:
        if ((r18 & 16) == 0) goto L10;
        long r7 = -1;
    L12:
        if ((r18 & 32) == 0) goto L14;
        Throwable r9 = null;
    L15:
        r11.logService(r12, r13, r14, r6, r7, r9);
        return;
    L14:
        r9 = r17;
        goto L15
    L10:
        r7 = r16;
        goto L12
    L6:
        r6 = r15;
        goto L8
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logService");
    }

    public static /* synthetic */ void logServiceWithGameExtra$default(InteractGameMonitorService r11, String r12, int r13, com.bytedance.android.live.broadcastgame.api.model.r r14, JSONObject r15, long r16, Throwable r17, int r18, Object r19) {
        if (r19 != null) goto L18;
        if ((r18 & 8) == 0) goto L6;
        JSONObject r6 = null;
    L8:
        if ((r18 & 16) == 0) goto L10;
        long r7 = -1;
    L12:
        if ((r18 & 32) == 0) goto L14;
        Throwable r9 = null;
    L15:
        r11.logServiceWithGameExtra(r12, r13, r14, r6, r7, r9);
        return;
    L14:
        r9 = r17;
        goto L15
    L10:
        r7 = r16;
        goto L12
    L6:
        r6 = r15;
        goto L8
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logServiceWithGameExtra");
    }
}
