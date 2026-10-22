package com.bytedance.android.livesdk.chatroom.utils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend;
import com.bytedance.android.livesdk.floatview.NewVideoInnerFloatManager;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.model.LiveMoreEntranceFloatWindowModel;
import com.bytedance.android.livesdkapi.service.ILiveNewMultitabService;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.util.LiveMultiTabFloatWindowStore;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f1 implements ILiveNewMultitabService {
    public static final f1 a = null;

    public f1() {
    }

    static {
        a = new f1();
    }

    public final Integer getFloatWindowBottomMargin() {
        ILiveVideoFloatWindowService r0 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFloatWindowBottomMargin();
    }

    public final boolean isLiveMoreEntranceFloatWindowShowing() {
        Lazy r0 = LiveMultiTabHandler.a;
        if (LiveMultiTabHandler.g() == false) goto L7;
        com.bytedance.android.livesdk.floatview.q r1 = NewVideoInnerFloatManager.p;
        NewVideoInnerFloatManager.b.a().getClass();
        if (NewVideoInnerFloatManager.j() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r2) {
        ILiveVideoFloatWindowService r0 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.addVideoFloatManagerListener(r2);
        return;
    }

    public final void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r2) {
        ILiveVideoFloatWindowService r0 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.removeVideoFloatManagerListener(r2);
        return;
    }

    public final void setFloatWindowBottomMargin(int r2) {
        ILiveVideoFloatWindowService r0 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.setFloatWindowBottomMargin(r2);
        return;
    }

    public final void tryStopMultiTabFloatWindow(Activity r3) {
        Lazy r0 = LiveMultiTabHandler.a;
        if (r3 != null) goto L6;
        return;
    L6:
        if (LiveMultiTabHandler.g() == false) goto L11;
        ALogger.i("LiveMultiTabHandler", "tryStopMultiTabFloatWindow " + r3);
        ILiveVideoFloatWindowService r4 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r4 == null) goto L12;
        r4.stopShowFloatInNextLifecycle();
        return;
    L12:
        return;
    }

    public final void tryStopMultiTabFloatWindowForever(Activity r3) {
        Lazy r0 = LiveMultiTabHandler.a;
        if (r3 != null) goto L6;
        return;
    L6:
        if (LiveMultiTabHandler.g() == false) goto L11;
        ALogger.i("LiveMultiTabHandler", "tryStopMultiTabFloatWindowForever " + r3);
        LiveMultiTabFloatWindowStore.INSTANCE.resetBackRoomInfo();
        ILiveVideoFloatWindowService r4 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r4 == null) goto L12;
        r4.stopShowFloat();
        return;
    L12:
        return;
    }

    public final void tryShowMultiTabFloatWindow(Activity r12, HashMap<String, String> r13, HashMap<String, String> r14) {
        Lazy r0 = LiveMultiTabHandler.a;
        if (r12 == null) goto L69;
        LiveMoreEntranceFloatWindowModel r1 = LiveMultiTabFloatWindowStore.INSTANCE.getCurrentModel();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getConsumed() == true) goto L71;
        InnerContextEntity.InnerFloatExtra r2 = new InnerContextEntity.InnerFloatExtra();
        r2.setRequestPage("more_live");
        boolean r3 = true;
        r2.setMute(true);
        HashMap r4 = new HashMap();
        if (r13 == null) goto L14;
        r4.putAll(r13);
    L14:
        r4.put("enter_from", "tablive");
        r4.put("enter_from_merge", r1.getEnterFromMerge());
        r4.put("enter_method", r1.getEnterMethod());
        Unit r15 = Unit.INSTANCE;
        r2.setMobParams(r4);
        r2.setUseNormalMode(true);
        r2.setOuterRoom(r1.getRoom());
        r2.setEnterFromMerge(r1.getEnterFromMerge());
        r2.setEnterMethod(r1.getEnterMethod());
        r2.setBusinessLine(FloatWindowBusinessLine.MoreAnchor);
        r2.setEnableExtParams(true);
        HashMap r16 = new HashMap();
        IHostBusiness r5 = jc1.k.f(IHostBusiness.class);
        boolean r6 = false;
        if (r5 == null) goto L19;
        ILiveMultiTabDepend r7 = r5.getLiveMultiTabDepend();
        if (r7 == null) goto L19;
        boolean r8 = r7.canFixAudioConflict();
    L20:
        if (r8 == false) goto L22;
        r16.put("next_show_use_default_mute_config_scene", "more_live");
    L22:
        r2.setExtParams(r16);
        if (r14 != null) goto L25;
    L35:
        IHostBusiness r17 = jc1.k.f(IHostBusiness.class);
        if (r17 == null) goto L40;
        ILiveMultiTabDepend r18 = r17.getLiveMultiTabDepend();
        if (r18 == null) goto L40;
        boolean r19 = r18.canSkipCheckResumed();
    L41:
        r2.setSkipCheckResumed(r19);
        IHostBusiness r110 = jc1.k.f(IHostBusiness.class);
        if (r110 == null) goto L46;
        ILiveMultiTabDepend r111 = r110.getLiveMultiTabDepend();
        if (r111 == null) goto L46;
        r6 = r111.canForceNotSharedLiveClient();
    L46:
        r2.setForceNotSharedLiveClient(r6);
        IHostBusiness r112 = jc1.k.f(IHostBusiness.class);
        if (r112 == null) goto L51;
        ILiveMultiTabDepend r113 = r112.getLiveMultiTabDepend();
        if (r113 == null) goto L51;
        r3 = r113.whetherUnMuteClientWhenStop();
    L51:
        r2.setWhetherUnMuteWhenStop(r3);
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L54
        Object r115 = Result.constructor-impl(new JSONObject().put("float_view_enter_room_business_tag", "more_live").toString());     // Catch: Throwable -> L54
    L56:
        Bundle r9 = null;
        if (Result.isFailure-impl(r115) == false) goto L59;
        r115 = null;
    L59:
        String r10 = (String) r115;
        long[] r116 = r1.getRoomIdList();
        if (r116 == null) goto L62;
        r9 = new Bundle();
        r9.putLongArray("live.intent.extra.ENTER_ROOM_IDS", r116);
    L62:
        r2.setRoomEnterConfig(new InnerContextEntity.RoomEnterConfig(null, null, r10, null, r9, 11, null));
        ALogger.i("LiveMultiTabHandler", "showMultiTabFloatWindow " + r12);
        ILiveVideoFloatWindowService r117 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r117 == null) goto L65;
        r117.startShowFloat(r12, r2);
    L65:
        LiveMultiTabFloatWindowStore.INSTANCE.consumedCurrentModel();
        return;
    L54:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r115 = Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        r19 = false;
        goto L41
    L25:
        if ((!r14.isEmpty()) != true) goto L35;
        String r119 = r14.get("layout_right_margin_dp");
        int r11 = -1;
        if (r119 == null) goto L29;
        int r120 = CastIntegerProtector.parseInt(r119);
    L30:
        String r121 = r14.get("layout_bottom_margin_dp");
        if (r121 == null) goto L33;
        r11 = CastIntegerProtector.parseInt(r121);
    L33:
        if (r120 <= 0) goto L35;
        RelativeLayout.LayoutParams r122 = new RelativeLayout.LayoutParams(1, 1);
        r122.addRule(12);
        r122.addRule(11);
        r122.bottomMargin = (int) t6.a(r12, r11);
        r122.rightMargin = (int) t6.a(r12, r120);
        r2.setParams(r122);
        goto L35
    L29:
        r120 = -1;
    L19:
        r8 = false;
        goto L20
    L71:
        return;
    }
}
