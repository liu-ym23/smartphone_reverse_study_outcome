package com.bytedance.android.livesdk.chatroom.utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.live.base.model.moreliveentrance.LiveTabForceRefreshStyle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.z9;
import com.bytedance.android.livesdk.floatview.NewVideoInnerFloatManager;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.model.LiveMoreEntranceFloatWindowModel;
import com.bytedance.android.livesdkapi.util.LiveMultiTabFloatWindowStore;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveMultiTabHandler implements com.bytedance.android.live.room.utils.a {
    public static final Lazy a = null;
    public static final LiveMultiTabHandler b = null;

    public LiveMultiTabHandler() {
    }

    static {
        b = new LiveMultiTabHandler();
        a = LazyKt.lazy(LiveMultiTabHandler$floatEnterParamsFix$2.INSTANCE);
    }

    public static boolean d() {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L7;
        ILiveMultiTabDepend r1 = r0.getLiveMultiTabDepend();
        if (r1 == null) goto L7;
        return r1.canStackRoom();
    L7:
        return false;
    }

    public static boolean g() {
        com.bytedance.android.livesdk.floatview.q r0 = NewVideoInnerFloatManager.p;
        InnerContextEntity.InnerFloatExtra r1 = NewVideoInnerFloatManager.b.a().j;
        if (r1 == null) goto L7;
        FloatWindowBusinessLine r2 = r1.getBusinessLine();
        if (r2 == null) goto L7;
        String r3 = r2.getValue();
    L9:
        return Intrinsics.areEqual(r3, "MoreAnchor");
    L7:
        r3 = null;
        goto L9
    }

    public final int a() {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L7;
        ILiveMultiTabDepend r1 = r0.getLiveMultiTabDepend();
        if (r1 == null) goto L7;
        return r1.maxSingleRequestTime();
    L7:
        return 1;
    }

    public final boolean enableMoreEntranceMarqueeType() {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L7;
        ILiveMultiTabDepend r1 = r0.getLiveMultiTabDepend();
        if (r1 == null) goto L7;
        return r1.enableMoreEntranceMarqueeType();
    L7:
        return false;
    }

    public final String getMoreEntranceTitle() {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L7;
        ILiveMultiTabDepend r1 = r0.getLiveMultiTabDepend();
        if (r1 == null) goto L7;
        return r1.getMoreEntranceTitle();
    L7:
        return null;
    }

    public final boolean interceptLeftSlideOpenDrawer() {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L7;
        ILiveMultiTabDepend r1 = r0.getLiveMultiTabDepend();
        if (r1 == null) goto L7;
        return r1.interceptLeftSlideOpenDrawer();
    L7:
        return false;
    }

    public final long marqueeDelayTime() {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L7;
        ILiveMultiTabDepend r1 = r0.getLiveMultiTabDepend();
        if (r1 == null) goto L7;
        return r1.marqueeDelayTime();
    L7:
        return -1;
    }

    public final long marqueeSingleInternalDuration() {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L7;
        ILiveMultiTabDepend r1 = r0.getLiveMultiTabDepend();
        if (r1 == null) goto L7;
        return r1.marqueeSingleInternalDuration();
    L7:
        return -1;
    }

    public final boolean useNewShowStrategy() {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L7;
        ILiveMultiTabDepend r1 = r0.getLiveMultiTabDepend();
        if (r1 == null) goto L7;
        return r1.useNewShowStrategy();
    L7:
        return false;
    }

    public static String e() {
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r0 == null) goto L8;
        Map r1 = r0.getMap();
        if (r1 == null) goto L8;
        String r2 = (String) r1.get("enter_from_merge");
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public static boolean f(Activity r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r3.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivity") == false) goto L8;
    L9:
        return true;
    L8:
        if (Intrinsics.areEqual(r3.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivityV2") == true) goto L9;
        return false;
    }

    public final boolean b(RoomContext r7) {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        Long r1 = null;
        if (r0 == null) goto L5;
        ILiveMultiTabDepend r2 = r0.getLiveMultiTabDepend();
    L6:
        boolean r3 = false;
        if (r2 != null) goto L9;
    L34:
        return r3;
    L9:
        if (r7 != null) goto L11;
    L13:
        if (r7 != null) goto L15;
    L17:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L29;
        StringBuilder r5 = new StringBuilder("canShowLeftMoreEntrance interceptRoomType ");
        if (r7 == null) goto L27;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L27;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L27;
        r1 = Long.valueOf(r9.id);
    L27:
        r5.append(r1);
        ALogger.i("LiveMultiTabHandler", r5.toString());
        return false;
    L29:
        boolean r10 = r2.canBackMultiTab();
        boolean r6 = r2.hasLiveMultiTab();
        if (r10 == false) goto L33;
        if (r6 == false) goto L33;
        r3 = true;
    L33:
        ALogger.i("LiveMultiTabHandler", "canShowLeftMoreEntrance serverSwitch:" + r10 + ", hasTab:" + r6);
        goto L34
    L15:
        if (r7.isMediaRoom() != true) goto L17;
    L12:
        r4 = true;
        goto L19
    L11:
        if (r7.isVSRoom() != true) goto L13;
    L5:
        r2 = null;
        goto L6
    }

    public final void c(DataCenter r24, Activity r25, Room r26, com.bytedance.android.live.base.model.moreliveentrance.b r27, boolean r28) {
        com.bytedance.android.live.base.model.moreliveentrance.b r0 = r27;
        if (r25 != null) goto L5;
        return;
    L5:
        if (r26 != null) goto L7;
        return;
    L7:
        boolean r2 = d();
        if (r2 == false) goto L10;
    L11:
        xs2.b r3 = xs2.b.a();
        zg1.b0 r4 = new zg1.b0();
        r4.a = r2;
        r4.b = ((Boolean) a.getValue()).booleanValue();
        Unit r5 = Unit.INSTANCE;
        r3.post(r4);
    L12:
        int r6 = r25.hashCode();
        IHostBusiness r7 = jc1.k.f(IHostBusiness.class);
        if (r7 == null) goto L17;
        ILiveMultiTabDepend r8 = r7.getLiveMultiTabDepend();
        if (r8 == null) goto L17;
        boolean r9 = r8.canShowFloatWindow();
    L19:
        if (r9 == false) goto L41;
        String r10 = e();
        com.bytedance.android.livesdk.log.filter.o r11 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r11 == null) goto L28;
        Map r12 = r11.getMap();
        if (r12 == null) goto L28;
        String r13 = (String) r12.get("enter_method");
        if (r13 == null) goto L28;
        String r14 = r13;
    L30:
        if (r26.getStreamType() == LiveMode.AUDIO) goto L38;
        StreamUrl r15 = r26.getStreamUrl();
        if (r15 != null) goto L34;
    L36:
        float r16 = UIUtils.dip2Px(r25, 110.0f);
    L37:
        float r17 = (int) r16;
        float r18 = r17 * (r26.getStreamUrlExtraSafely().getHeight() / r26.getStreamUrlExtraSafely().getWidth());
    L39:
        LiveMultiTabFloatWindowStore.INSTANCE.setCurrentModel(new LiveMoreEntranceFloatWindowModel(r6, r10, r14, r26, SystemClock.elapsedRealtime(), (int) r18, null, null, 192, null));
        goto L41
    L34:
        if (r15.getStreamOrientation() != 2) goto L36;
        r16 = UIUtils.dip2Px(r25, 210.0f);
        goto L37
    L38:
        r18 = UIUtils.dip2Px(r25, 110.0f);
    L28:
        r14 = "";
    L41:
        z9 r19 = z9.a;
        String r110 = "tablive_drawer_guide_entrance_type";
        String r111 = "boot_preload_tab_event";
        if (r19.getValue().getEnable() == true) goto L72;
        IHostBusiness r20 = jc1.k.f(IHostBusiness.class);
        if (r20 == null) goto L72;
        ILiveMultiTabDepend r21 = r20.getLiveMultiTabDepend();
        if (r21 == null) goto L72;
        Bundle r22 = new Bundle();
        r22.putString("live_tab_enter_method", "more_live");
        if (r0 == null) goto L71;
        if (r27.j() <= 0) goto L52;
        boolean r1 = true;
    L53:
        if (r1 == false) goto L55;
        com.bytedance.android.live.base.model.moreliveentrance.b r23 = r0;
    L56:
        if (r23 == null) goto L71;
        r22.putInt("boot_preload_tab_id", r23.j());
        String r29 = r23.k();
        if (r29 != null) goto L60;
        r29 = "";
    L60:
        r22.putString("boot_preload_tab_name", r29);
        String r30 = r23.i();
        if (r30 != null) goto L63;
        r30 = "";
    L63:
        r22.putString("boot_preload_tab_event", r30);
        r22.putInt("tablive_drawer_guide_entrance_type", r23.a());
        r22.putLong("tablive_entrance_room_id", r26.getRoomId());
        r22.putString("tablive_entrance_anchor_id", r26.getAnchorId());
        r22.putLong("short_topic_id", r23.h());
        String r112 = r23.g();
        if (r112 != null) goto L66;
        r112 = "";
    L66:
        r22.putString("short_topic_content", r112);
        r22.putLong("topic_id", r23.n());
        String r31 = r23.m();
        if (r31 != null) goto L69;
        r31 = "";
    L69:
        r22.putString("topic_content", r31);
        goto L71
    L55:
        r23 = null;
        goto L56
    L52:
        r1 = false;
    L71:
        Unit r32 = Unit.INSTANCE;
        r21.tryBootPreload("more_live", r22);
    L73:
        RoomContext r33 = RoomContext.a.c(RoomContext.Companion, r24, 0, 2);
        IHostBusiness r34 = jc1.k.f(IHostBusiness.class);
        if (r34 == null) goto L78;
        ILiveMultiTabDepend r35 = r34.getLiveMultiTabDepend();
        if (r35 == null) goto L78;
        boolean r36 = r35.useNewStop();
    L79:
        if (r36 == false) goto L86;
        if (r33 == null) goto L93;
        com.bytedance.live.datacontext.j r37 = r33.getStopRoomTrigger();
        if (r37 == null) goto L93;
        Function1 r38 = (Function1) r37.getValue();
        if (r38 == null) goto L93;
        r38.invoke("finalCleanUp");
    L93:
        if (enableMoreEntranceMarqueeType() == false) goto L99;
        IHostBusiness r39 = jc1.k.f(IHostBusiness.class);
        if (r39 == null) goto L99;
        ILiveMultiTabDepend r40 = r39.getLiveMultiTabDepend();
        if (r40 == null) goto L99;
        r40.dispatchMoreLiveEntranceItem(r0);
    L99:
        ALogger.i("LiveMultiTabHandler", "goLiveMultiTab called, useNewStop:" + r36 + ", liveEntranceInfo:" + r0);
        if (r19.getValue().getEnable() == true) goto L102;
        IHostAction r41 = jc1.k.f(IHostAction.class);
        if (r41 == null) goto L171;
        LinkedHashMap r42 = new LinkedHashMap();
        r42.put("enter_method", "more_live");
        r42.put("tab_id", "homepage_tablive");
        Unit r43 = Unit.INSTANCE;
        r41.gotoXtabChannel("homepage_tablive", r25, r42);
        return;
    L171:
        return;
    L102:
        if ((!Intrinsics.areEqual(e(), "homepage_tablive")) == true) goto L106;
        if (r28 == true) goto L106;
        boolean r44 = false;
    L107:
        IHostBusiness r45 = jc1.k.f(IHostBusiness.class);
        if (r45 == null) goto L170;
        LinkedHashMap r46 = new LinkedHashMap();
        r46.put("enter_method", "more_live");
        Unit r47 = Unit.INSTANCE;
        Bundle r113 = new Bundle();
        if (r0 != null) goto L112;
    L147:
        LiveTabForceRefreshStyle r48 = LiveTabForceRefreshStyle.NO_OP;
        if (r44 == false) goto L164;
        IHostBusiness r49 = jc1.k.f(IHostBusiness.class);
        if (r49 == null) goto L154;
        ILiveMultiTabDepend r50 = r49.getLiveMultiTabDepend();
        if (r50 == null) goto L154;
        int r114 = r50.moreLiveTabRefreshStyle();
    L155:
        if (r114 != 0) goto L157;
        r48 = LiveTabForceRefreshStyle.REFRESH_FULL;
        goto L164
    L157:
        if (r114 != 1) goto L159;
        r48 = LiveTabForceRefreshStyle.REFRESH_REVISIT_ONLY;
        goto L164
    L159:
        if (r114 != 2) goto L164;
        r48 = LiveTabForceRefreshStyle.REFRESH_FEED_ONLY;
    L154:
        r114 = 0;
    L164:
        r45.enterLiveChannel(r25, r46, "more_live", r113, true, true, r48);
        return;
    L112:
        if (r27.j() <= 0) goto L114;
        boolean r115 = true;
    L115:
        if (r115 == true) goto L118;
        r0 = null;
    L118:
        if (r0 == null) goto L147;
        r113.putInt("boot_preload_tab_id", r0.j());
        String r116 = r0.k();
        if (r116 != null) goto L122;
        r116 = "";
    L122:
        r113.putString("boot_preload_tab_name", r116);
        String r117 = r0.i();
        if (r117 != null) goto L125;
        r117 = "";
    L125:
        r113.putString(r111, r117);
        r113.putInt(r110, r0.a());
        int r51 = r0.a();
        if (r51 != 7) goto L128;
    L139:
        String r52 = "unfold";
    L140:
        r113.putString("force_fold_operation", r52);
        r113.putLong("tablive_entrance_room_id", r26.getRoomId());
        r113.putString("tablive_entrance_anchor_id", r26.getAnchorId());
        r113.putLong("short_topic_id", r0.h());
        String r53 = r0.g();
        if (r53 != null) goto L143;
        r53 = "";
    L143:
        r113.putString("short_topic_content", r53);
        r113.putLong("topic_id", r0.n());
        String r54 = r0.m();
        if (r54 != null) goto L146;
        r54 = "";
    L146:
        r113.putString("topic_content", r54);
        goto L147
    L128:
        if (r51 == 8) goto L139;
        if (r51 == 9) goto L139;
        if (r51 == 10) goto L139;
        if (r51 == 11) goto L139;
        if (r51 == 12) goto L139;
        r52 = "fold";
        goto L140
    L114:
        r115 = false;
        goto L115
    L170:
        return;
    L106:
        r44 = true;
        goto L107
    L86:
        if (r33 == null) goto L93;
        com.bytedance.live.datacontext.n r55 = r33.getRoomEngine();
        if (r55 == null) goto L93;
        is2.d r56 = (is2.d) r55.getValue();
        if (r56 == null) goto L93;
        r56.endRoomV2(EndReason.FINAL_CLEANUP.INSTANCE);
    L78:
        r36 = false;
    L72:
        r19 = r19;
        r110 = "tablive_drawer_guide_entrance_type";
        r111 = "boot_preload_tab_event";
    L17:
        r9 = false;
        goto L19
    L10:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L12;
        goto L11
    }
}
