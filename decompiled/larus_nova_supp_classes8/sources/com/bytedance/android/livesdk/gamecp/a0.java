package com.bytedance.android.livesdk.gamecp;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.x8;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.depend.model.live.IOptions;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveFloatViewService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 implements ILiveFloatViewService {

    public static final class a {
    }

    static {
    }

    public a0() {
    }

    public static ILivePlayerClient a() {
        Long r2 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        Room r3 = (Room) r1.getValue();
        if (r3 == null) goto L9;
        r2 = Long.valueOf(r3.getRoomId());
    L9:
        if (r2 == null) goto L15;
        if (r2.longValue() == 0) goto L15;
        return LivePlatformPlayerManager.a(r2.longValue(), false);
    L15:
        return LivePlatformPlayerManager.f();
    }

    public final boolean isFloatViewShowing() {
        return jc1.k.n(ILiveVideoFloatWindowService.class).isFloatWindowShowing();
    }

    public final void stopFloatView() {
        jc1.k.n(ILiveVideoFloatWindowService.class).stopShowFloat();
    }

    public final String getCurResolution() {
        ILivePlayerClient r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentResolution();
    }

    public final void pauseLiveStream() {
        ILivePlayerClient r0 = a();
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    public final void stopLiveStream() {
        ILivePlayerClient r0 = a();
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    public final void addFloatViewStatusObserver(IVideoFloatManager.VideoFloatManagerListener r2) {
        jc1.k.n(ILiveVideoFloatWindowService.class).addVideoFloatManagerListener(r2);
    }

    public final void markFullPanel(boolean r2) {
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 == null) goto L6;
        r0.setGameFullPanelIsShowing(r2);
        return;
    }

    public final void pullAudioStream(boolean r6) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L24
        ILivePlayerClient r2 = a();     // Catch: Throwable -> L24
        if (r2 != null) goto L7;
        r2 = null;
    L22:
        Result.constructor-impl(r2);     // Catch: Throwable -> L24
        return;
    L7:
        if (r6 == false) goto L9;
    L10:
        ALogger.i("LiveFloatViewService", "pullAudioStream ->>> player has been released, need to reStream");     // Catch: Throwable -> L24
        LiveRequest r7 = r2.getLiveRequest();     // Catch: Throwable -> L24
        if (r7 == null) goto L13;
        ALogger.i("LiveFloatViewService", "liveRequest is valid, do streaming.");     // Catch: Throwable -> L24
        r2.stream(r7, null);     // Catch: Throwable -> L24
    L13:
        r2.resume();     // Catch: Throwable -> L24
        r2.ignoreLossAudioFocus(true);     // Catch: Throwable -> L24
        if ((true ^ Intrinsics.areEqual(r2.getCurrentResolution(), "ao")) == true) goto L16;
    L20:
        r2.unmute("LiveFloatViewService.pullAudioStream");     // Catch: Throwable -> L24
        goto L22
    L16:
        if (JSONObjectProtectorUtils.getJSONObject(new JSONObject(r2.getPullStreamData()), "data").has("ao") == false) goto L20;
        ALogger.i("LiveFloatViewService", "switch ao");     // Catch: Throwable -> L24
        ILivePlayerClient r8 = a();     // Catch: Throwable -> L24
        if (r8 == null) goto L20;
        r8.switchResolution("ao");     // Catch: Throwable -> L24
        goto L20
    L9:
        if (r2.hasRealPlayer() == true) goto L13;
    L24:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void removeFloatViewStatusObserver(IVideoFloatManager.VideoFloatManagerListener r2) {
        jc1.k.n(ILiveVideoFloatWindowService.class).removeVideoFloatManagerListener(r2);
    }

    public final void setResolution(String r7) {
        Intrinsics.checkNotNullParameter(r7, "resolution");
        ILivePlayerClient r2 = a();     // Catch: Throwable -> L24
        boolean r3 = false;
        if (r2 == null) goto L6;
        r2.ignoreLossAudioFocus(false);     // Catch: Throwable -> L24
    L6:
        ILivePlayerClient r4 = a();     // Catch: Throwable -> L24
        if (r4 == null) goto L9;
        String r5 = r4.getCurrentResolution();     // Catch: Throwable -> L24
    L11:
        if (r7.length() != 0) goto L13;
        r3 = true;
    L13:
        if (r3 == false) goto L15;
        return;
    L15:
        if ((!Intrinsics.areEqual(r5, r7)) == false) goto L30;
        ILivePlayerClient r6 = a();     // Catch: Throwable -> L24
        if (r6 == null) goto L19;
        r6.switchResolution(r7);     // Catch: Throwable -> L24
    L19:
        xs2.b.a().post(new h1(42));     // Catch: Throwable -> L24
        ILivePlayerClient r8 = a();     // Catch: Throwable -> L24
        if (r8 == null) goto L22;
        r8.unmute("LiveFloatViewService.setResolution");     // Catch: Throwable -> L24
    L22:
        ALogger.i("LiveFloatViewService", "switchResolution ".concat(r7));     // Catch: Throwable -> L24
        return;
    L30:
        return;
    L9:
        r5 = null;
    L24:
        th = move-exception;
        ALogger.e("LiveFloatViewService", "resetResolutionIfNeed error", th);
    }

    public final void toggleLiveAudio(boolean r2) {
        ILiveVideoFloatWindowService r0 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.toggleLiveAudio(r2);
        return;
    }

    public final void showFloatViewNow(Context r4, Long r5, boolean r6, boolean r7, HashMap<String, String> r8, HashMap<String, String> r9) {
        Activity r10 = x8.c(r4);
        if (r10 != null) goto L5;
        r10 = com.bytedance.android.live.core.utils.a.d();
    L5:
        if (r10 == null) goto L10;
        ILiveVideoFloatWindowService r0 = jc1.k.n(ILiveVideoFloatWindowService.class);
        InnerContextEntity.InnerFloatExtra r1 = new InnerContextEntity.InnerFloatExtra();
        r1.setRequestPage("gamecp_game_detail");
        r1.setMobParams(r8);
        r1.setMute(r7);
        r1.setFinishOnClick(r6);
        r1.setEnterRoomId(r5);
        r1.setBusinessLine(FloatWindowBusinessLine.Game);
        r1.setExtParams(r9);
        Unit r11 = Unit.INSTANCE;
        r0.startShowFloat(r10, r1);
        ILiveVideoFloatWindowService r12 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r12 == null) goto L11;
        r12.stopShowFloatInNextLifecycle();
        return;
    L11:
        return;
    }

    public final void showFloatViewNow(DialogFragment r4, FrameLayout r5, Long r6, boolean r7, boolean r8, HashMap<String, String> r9, HashMap<String, String> r10) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        ILiveVideoFloatWindowService r0 = jc1.k.n(ILiveVideoFloatWindowService.class);
        InnerContextEntity.InnerFloatExtra r1 = new InnerContextEntity.InnerFloatExtra();
        r1.setRequestPage("gamecp_game_detail");
        r1.setMobParams(r9);
        r1.setMute(r8);
        r1.setFinishOnClick(r7);
        r1.setEnterRoomId(r6);
        r1.setBusinessLine(FloatWindowBusinessLine.Game);
        r1.setExtParams(r10);
        Unit r11 = Unit.INSTANCE;
        r0.startShowFloat(r4, r5, r1);
        ILiveVideoFloatWindowService r12 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r12 == null) goto L6;
        r12.stopShowFloatInNextLifecycle();
        return;
    }

    public final void showFloatView(Context r13, String r14, boolean r15, long r16, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, RelativeLayout.LayoutParams r23) {
        Intrinsics.checkNotNullParameter(r13, "ctx");
        Intrinsics.checkNotNullParameter(r14, "requestPage");
        ILiveVideoFloatWindowService r1 = jc1.k.n(ILiveVideoFloatWindowService.class);
        Activity r2 = (Activity) r13;
        InnerContextEntity.InnerFloatExtra r3 = new InnerContextEntity.InnerFloatExtra();
        r3.setRequestPage("live_cloud_game");
        r3.setFinishOnClick(false);
        r3.setEnterRoomId(Long.valueOf(r16));
        r3.setSkipCheckResumed(r22);
        if (r18 == false) goto L64;
        Object r6 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L56
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, r16, 1);     // Catch: Throwable -> L56
        if (r4 == null) goto L64;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();     // Catch: Throwable -> L56
        if (r5 == null) goto L64;
        Room r7 = (Room) r5.getValue();     // Catch: Throwable -> L56
        if (r7 == null) goto L64;
        StreamUrl r8 = r7.getStreamUrl();     // Catch: Throwable -> L56
        if (r8 == null) goto L24;
        LiveCoreSDKData r9 = r8.getLiveCoreSDKData();     // Catch: Throwable -> L56
        if (r9 == null) goto L24;
        LiveCoreSDKData.PullData r10 = r9.pullData;     // Catch: Throwable -> L56
        if (r10 == null) goto L24;
        IOptions r11 = r10.getOptions();     // Catch: Throwable -> L56
        if (r11 == null) goto L24;
        if (r11.getVPassDefault() != true) goto L24;
        String r12 = ResolutionManager.getMultiStreamDefaultQualitySdkKey$default(ResolutionManager.INSTANCE, r7, false, true, 2, null);     // Catch: Throwable -> L56
    L54:
        Object r17 = Result.constructor-impl(r12);     // Catch: Throwable -> L56
    L59:
        if (Result.isFailure-impl(r17) == true) goto L62;
        r6 = r17;
    L62:
        String r24 = (String) r6;
        if (r24 == null) goto L64;
    L65:
        r3.setResolution(r24);
        r3.setForceNotSharedLiveClient(true);
        r3.setInBackGroud(false);
        r3.setMute(r21);
        r3.setParams(r23);
        r3.setEnableChangePosition(true);
        r3.setBusinessLine(FloatWindowBusinessLine.Game);
        Unit r25 = Unit.INSTANCE;
        r1.startShowFloat(r2, r3);
        return;
    L24:
        StreamUrl r26 = r7.getStreamUrl();     // Catch: Throwable -> L56
        if (r26 == null) goto L42;
        List r27 = r26.getQualityList();     // Catch: Throwable -> L56
        if (r27 == null) goto L42;
        ArrayList r28 = new ArrayList();     // Catch: Throwable -> L56
        Iterator r29 = r27.iterator();     // Catch: Throwable -> L56
    L30:
        if (r29.hasNext() == false) goto L39;
        Object r30 = r29.next();     // Catch: Throwable -> L56
        IQuality r110 = (IQuality) r30;     // Catch: Throwable -> L56
        if (r110.isEnable() == true) goto L34;
    L36:
        boolean r111 = false;
    L37:
        if (r111 == false) goto L30;
        r28.add(r30);     // Catch: Throwable -> L56
        goto L30
    L34:
        if (r110.getDisable() > 0) goto L36;
        r111 = true;
        goto L37
    L39:
        List r31 = CollectionsKt.sortedWith(r28, new z());     // Catch: Throwable -> L56
        if (r31 == null) goto L42;
        IQuality r32 = (IQuality) CollectionsKt.getOrNull(r31, 0);     // Catch: Throwable -> L56
    L43:
        StringBuilder r33 = new StringBuilder();     // Catch: Throwable -> L56
        r33.append("floatView getFloatViewResolution ");     // Catch: Throwable -> L56
        if (r32 == null) goto L46;
        String r112 = r32.getName();     // Catch: Throwable -> L56
    L47:
        r33.append(r112);     // Catch: Throwable -> L56
        ALogger.i("CloudGame", r33.toString());     // Catch: Throwable -> L56
        if (r32 == null) goto L53;
        String r34 = r32.getSdkKey();     // Catch: Throwable -> L56
        if (r34 == null) goto L53;
        r12 = r34;
    L53:
        r12 = ResolutionManager.getMultiStreamDefaultQualitySdkKey$default(ResolutionManager.INSTANCE, r7, false, true, 2, null);     // Catch: Throwable -> L56
        goto L54
    L46:
        r112 = null;
    L42:
        r32 = null;
    L56:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L64:
        r24 = "";
        goto L65
    }
}
