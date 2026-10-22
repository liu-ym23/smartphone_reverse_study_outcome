package com.bytedance.android.livesdk.gamecp.impl;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.x8;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.depend.model.live.IOptions;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.ILiveFloatViewService;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements ILiveFloatViewService {
    public k() {
    }

    public final String getCurResolution() {
        return null;
    }

    public final void markFullPanel(boolean r1) {
    }

    public final void pullAudioStream(boolean r1) {
    }

    public final void setResolution(String r2) {
        Intrinsics.checkNotNullParameter(r2, "resolution");
    }

    public final void stopLiveStream() {
    }

    public final boolean isFloatViewShowing() {
        return jc1.k.n(ILiveVideoFloatWindowService.class).isFloatWindowShowing();
    }

    public final void stopFloatView() {
        jc1.k.n(ILiveVideoFloatWindowService.class).stopShowFloat();
    }

    public final void pauseLiveStream() {
        xs2.b.a().post(new h1(32));
    }

    public final void addFloatViewStatusObserver(IVideoFloatManager.VideoFloatManagerListener r2) {
        jc1.k.n(ILiveVideoFloatWindowService.class).addVideoFloatManagerListener(r2);
    }

    public final void removeFloatViewStatusObserver(IVideoFloatManager.VideoFloatManagerListener r2) {
        jc1.k.n(ILiveVideoFloatWindowService.class).removeVideoFloatManagerListener(r2);
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
        if (r18 == false) goto L62;
        Object r5 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L54
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, r16, 1);     // Catch: Throwable -> L54
        if (r7 == null) goto L62;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();     // Catch: Throwable -> L54
        if (r8 == null) goto L62;
        Room r9 = (Room) r8.getValue();     // Catch: Throwable -> L54
        if (r9 == null) goto L62;
        StreamUrl r10 = r9.getStreamUrl();     // Catch: Throwable -> L54
        if (r10 == null) goto L24;
        LiveCoreSDKData r11 = r10.getLiveCoreSDKData();     // Catch: Throwable -> L54
        if (r11 == null) goto L24;
        LiveCoreSDKData.PullData r12 = r11.pullData;     // Catch: Throwable -> L54
        if (r12 == null) goto L24;
        IOptions r17 = r12.getOptions();     // Catch: Throwable -> L54
        if (r17 == null) goto L24;
        if (r17.getVPassDefault() != true) goto L24;
        String r0 = ResolutionManager.getMultiStreamDefaultQualitySdkKey$default(ResolutionManager.INSTANCE, r9, false, false, 6, null);     // Catch: Throwable -> L54
    L52:
        Object r4 = Result.constructor-impl(r0);     // Catch: Throwable -> L54
    L57:
        if (Result.isFailure-impl(r4) == true) goto L60;
        r5 = r4;
    L60:
        String r24 = (String) r5;
        if (r24 == null) goto L62;
    L63:
        r3.setResolution(r24);
        r3.setForceNotSharedLiveClient(true);
        r3.setInBackGroud(!((Boolean) LiveSettingKeys.LIVE_CLOUD_GAME_INDIVIDUAL_CONTROL_AUDIO.getValue()).booleanValue());
        r3.setInBackGroud(true);
        r3.setMute(r21);
        r3.setParams(r23);
        r3.setEnableChangePosition(true);
        r3.setBusinessLine(FloatWindowBusinessLine.Game);
        Unit r25 = Unit.INSTANCE;
        r1.startShowFloat(r2, r3);
        return;
    L24:
        StreamUrl r26 = r9.getStreamUrl();     // Catch: Throwable -> L54
        if (r26 == null) goto L42;
        List r27 = r26.getQualityList();     // Catch: Throwable -> L54
        if (r27 == null) goto L42;
        ArrayList r28 = new ArrayList();     // Catch: Throwable -> L54
        Iterator r29 = r27.iterator();     // Catch: Throwable -> L54
    L30:
        if (r29.hasNext() == false) goto L39;
        Object r30 = r29.next();     // Catch: Throwable -> L54
        IQuality r110 = (IQuality) r30;     // Catch: Throwable -> L54
        if (r110.isEnable() == true) goto L34;
    L36:
        boolean r111 = false;
    L37:
        if (r111 == false) goto L30;
        r28.add(r30);     // Catch: Throwable -> L54
        goto L30
    L34:
        if (r110.getDisable() > 0) goto L36;
        r111 = true;
        goto L37
    L39:
        List r31 = CollectionsKt.sortedWith(r28, new j());     // Catch: Throwable -> L54
        if (r31 == null) goto L42;
        IQuality r32 = (IQuality) CollectionsKt.getOrNull(r31, 0);     // Catch: Throwable -> L54
    L43:
        StringBuilder r33 = new StringBuilder();     // Catch: Throwable -> L54
        r33.append("floatView getFloatViewResolution ");     // Catch: Throwable -> L54
        if (r32 == null) goto L46;
        String r34 = r32.getName();     // Catch: Throwable -> L54
    L47:
        r33.append(r34);     // Catch: Throwable -> L54
        ALogger.i("CloudGame", r33.toString());     // Catch: Throwable -> L54
        if (r32 == null) goto L51;
        r0 = r32.getSdkKey();     // Catch: Throwable -> L54
        if (r0 != null) goto L52;
    L51:
        r0 = ResolutionManager.getMultiStreamDefaultQualitySdkKey$default(ResolutionManager.INSTANCE, r9, false, false, 6, null);     // Catch: Throwable -> L54
        goto L52
    L46:
        r34 = null;
    L42:
        r32 = null;
    L54:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L62:
        r24 = "";
        goto L63
    }
}
