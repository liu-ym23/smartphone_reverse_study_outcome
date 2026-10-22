package com.bytedance.android.livesdk.chatroom.ui.framework;

import am2.x;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.j2;
import com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.room.w;
import com.bytedance.android.livehostapi.business.IHostLiveByteCast;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastPlayInfo;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.chatroom.ui.framework.audience.AudienceInteractionRoomControllerManager;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.CompatComponentScheduler;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionComponentManager;
import com.bytedance.android.livesdk.chatroom.ui.framework.log.InteractionSlardarUtils;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.GameCastScreenUtils;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.widget.g2;
import com.bytedance.android.livesdk.config.n41;
import com.bytedance.android.livesdk.config.o51;
import com.bytedance.android.livesdk.config.oq0;
import com.bytedance.android.livesdk.config.u90;
import com.bytedance.android.livesdk.floatview.p;
import com.bytedance.android.livesdk.lifecycle.ILifeCycleAware;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.performance.LivePerformanceManager;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdk.x5;
import com.bytedance.android.livesdkapi.depend.chat.OnBackPressedListener;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.IRoomPreloadTaskManager;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.framework.LiveInteractionFrameworkOptHelper;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadOpt;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/NewAudienceInteractionFragment;", "Landroidx/fragment/app/DialogFragment;", "Ltw2/b;", "Lfo1/i;", "", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewAudienceInteractionFragment extends DialogFragment implements tw2.b, fo1.i, OnBackPressedListener {
    public static final /* synthetic */ int l = 0;
    public final fo1.b d;
    public final com.bytedance.android.livesdk.chatroom.ui.framework.base.o e;
    public final InteractionComponentManager f;
    public final AudienceInteractionRoomControllerManager g;
    public final List<com.bytedance.android.livesdk.chatroom.ui.framework.base.i> h;
    public n i;
    public i j;
    public final io1.b k;

    public static final class a {
    }

    static {
    }

    public final Map<String, Object> getEnvData() {
        return null;
    }

    public final String getSpm() {
        return "a100.a100";
    }

    public final boolean isIgnored() {
        return true;
    }

    public final Map<String, Object> getPropertyParams() {
        HashMap r0 = new HashMap();
        r0.put("room_id", Long.valueOf(this.d.c().id));
        r0.put("is_Anchor", Boolean.FALSE);
        return r0;
    }

    public final boolean onBackPressed() {
        q r0 = ho1.a.f(this.d.d);
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.onBackPressed();
    }

    public final void onDestroy() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.e r0 = this.d.p;
        if (r0 == null) goto L5;
        r0.report("fragment_destroy", null);
    L5:
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroy#" + hashCode());
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#onDestroy" + hashCode());
        this.d.getClass();
        ILifeCycleAware r1 = jc1.k.f(ILifeCycleAware.class);
        if (r1 == null) goto L8;
        r1.onInteractionFragmentDestroy(this.d.c().getIdStr());
    L8:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        fo1.b r2 = this.d;
        boolean r3 = true;
        if ((!r2.a) == false) goto L14;
        r2.b();
        this.d.c();
        long r4 = com.bytedance.android.livesdk.castscreen.utils.f.d();
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L13;
        r5.setLandscapeDuration(r4);
    L13:
        com.bytedance.android.livesdk.castscreen.utils.f.a = 0;
        this.d.d().getFromPortrait().setValue(Boolean.FALSE);
    L14:
        Iterator r6 = ((ArrayList) this.h).iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r6.next()).onDestroy();
        goto L16
    L18:
        fo1.b r7 = this.d;
        r7.k = null;
        ((ArrayList) r7.l).clear();
        r7.m = null;
        ((ArrayList) r7.w).clear();
        r7.x = null;
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L30;
        RoomContext r8 = r7.d();
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.n r9 = r8.isRoomVisible();
        if (r9 == null) goto L25;
        Boolean r10 = (Boolean) r9.getValue();
    L27:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == true) goto L30;
        r3 = false;
    L25:
        r10 = null;
    L30:
        if (r3 == false) goto L32;
        boolean r11 = p.a;
        com.bytedance.android.livesdk.floatview.inner.b.c = null;
    L32:
        IInteractService r12 = jc1.k.f(IInteractService.class);
        if (r12 == null) goto L38;
        com.bytedance.android.live.liveinteract.service.g r13 = r12.getInteractFloatWindowService();
        if (r13 == null) goto L38;
        r13.c(null);
    L38:
        if (LiveInteractionFrameworkOptHelper.INSTANCE.fragmentAbilityOpt() == false) goto L42;
        e0 r14 = this.d.d;
        if (r14 == null) goto L42;
        ho1.a.q(r14, c.class);
    L42:
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroy end");
    }

    public final void onDestroyView() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.e r0 = this.d.p;
        if (r0 == null) goto L5;
        r0.report("fragment_destroy_view", null);
    L5:
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroyView#" + hashCode());
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#onDestroyView" + hashCode());
        fo1.b r1 = this.d;
        r1.e = false;
        r1.y = false;
        r1.j = null;
        Iterator r2 = ((ArrayList) this.h).iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r2.next()).l();
        goto L7
    L9:
        super.onDestroyView();
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroyView end");
    }

    public final void stopInteractionLoad() {
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#stopInteractionLoad" + hashCode());
        if (LiveInteractionFrameworkOptHelper.INSTANCE.fragmentRemoveStateOpt() == false) goto L5;
        this.d.C = true;
    L5:
        IComponentScheduler r0 = this.f.f;
        if (r0 == null) goto L9;
        r0.i();
        return;
    }

    public NewAudienceInteractionFragment() {
        ArrayList r0 = new ArrayList();
        this.h = r0;
        io1.b r1 = new io1.b();
        this.k = r1;
        new AsyncTaskManager();
        fo1.b r2 = new fo1.b(this);
        r2.o = r1;
        r2.p = new com.bytedance.android.livesdk.chatroom.ui.framework.utils.a(r2);
        Unit r3 = Unit.INSTANCE;
        this.d = r2;
        r0.add(new fo1.d());
        com.bytedance.android.livesdk.chatroom.ui.framework.base.o r4 = new com.bytedance.android.livesdk.chatroom.ui.framework.base.o();
        r0.add(r4);
        this.e = r4;
        InteractionComponentManager r5 = new InteractionComponentManager();
        r0.add(r5);
        this.f = r5;
        AudienceInteractionRoomControllerManager r6 = new AudienceInteractionRoomControllerManager();
        r0.add(r6);
        this.g = r6;
        Iterator r7 = r0.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.i r8 = (com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r7.next();
        fo1.b r9 = this.d;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.a = r9;
        goto L4
    }

    public final String T90() {
        if (getView() != null) goto L7;
        return "view_null";
    L7:
        if (this.d.d().isCleared() == false) goto L10;
        return "room_context_cleared";
    L10:
        fo1.b r0 = this.d;
        if (r0.e == true) goto L15;
        return "view_invalid";
    L15:
        if (r0.C == false) goto L18;
        return "fragment_remove";
    L18:
        return null;
    }

    public final IComponentScheduler V90() {
        if (com.bytedance.android.live.core.tetris.widgets.d.b() == true) goto L5;
    L7:
        IComponentScheduler.LoadMode r0 = IComponentScheduler.LoadMode.DIRECT;
    L9:
        if (ComponentManagerABHelper.INSTANCE.enableRoomSceneScheduler() == true) goto L11;
    L13:
        IComponentScheduler.SchedulerType r1 = IComponentScheduler.SchedulerType.LOAD_TASK_SCHEDULER;
    L15:
        return new CompatComponentScheduler(r0, r1, in1.b.a.getEnableRoomWidgetOpt());
    L11:
        if (this.f.z() == false) goto L13;
        r1 = IComponentScheduler.SchedulerType.COMPONENT_X_SCHEDULER;
        goto L15
    L5:
        if (((Boolean) this.d.b().get("cmd_interact_is_part_show", Boolean.FALSE)).booleanValue() == false) goto L7;
        r0 = IComponentScheduler.LoadMode.PREVIEW;
        goto L9
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        com.bytedance.android.live.core.tetris.widgets.d.g("onPause#" + hashCode());
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#onPause" + hashCode());
        fo1.b r0 = this.d;
        r0.f = false;
        if ((!r0.a) == false) goto L5;
        fo1.b r1 = r0;
    L6:
        if (r1 == null) goto L8;
        com.bytedance.android.livesdk.castscreen.utils.f.a(r0.b(), this.d.c());
    L8:
        Iterator r2 = ((ArrayList) this.h).iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r2.next()).m();
        goto L10
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ILiveUxTracer r0 = jc1.k.f(ILiveUxTracer.class);
        if (r0 == null) goto L5;
        r0.recordTimeStamp("interaction_resume", "start");
    L5:
        com.bytedance.android.live.core.tetris.widgets.d.g("onResume#" + hashCode());
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#onResume" + hashCode());
        fo1.b r1 = this.d;
        r1.f = true;
        if ((!r1.a) == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L11;
        r1.z = System.currentTimeMillis();
    L11:
        Iterator r2 = ((ArrayList) this.h).iterator();
    L13:
        if (r2.hasNext() == false) goto L15;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r2.next()).n();
        goto L13
    L15:
        int r3 = io1.d.a;
        fo1.b r4 = this.d;
        Intrinsics.checkNotNullParameter(r4, "interactionContext");
        if (((o51) j2.a.getValue()).disable_interaction_load_duration == false) goto L19;
    L28:
        Runnable r5 = this.d.x;
        if (r5 == null) goto L31;
        com.bytedance.android.live.core.tetris.widgets.d.g("continue room enter on resume" + hashCode());
        r5.run();
        this.d.x = null;
    L31:
        p0 r6 = (p0) this.d.b().get("zygote_event_hub", null);
        if (r6 == null) goto L36;
        MutableLiveData r7 = r6.getInteractionResume();
        if (r7 == null) goto L36;
        r7.postValue(Boolean.TRUE);
    L36:
        ILiveUxTracer r8 = jc1.k.f(ILiveUxTracer.class);
        if (r8 == null) goto L39;
        r8.recordTimeStamp("interaction_resume", "end");
        r8.recordTimeStamp("enter_room", "end");
        r8.markDurationForReport("enter_room_ux_response", "enter_room", "start", "interaction_resume", "end");
    L39:
        boolean r9 = p.a;
        p.i(getActivity());
        return;
    L19:
        if (r4.n == true) goto L28;
        Bundle r10 = r4.a();
        if (r10 == null) goto L28;
        long r11 = r10.getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME");
        if (r11 <= 0) goto L28;
        r4.n = true;
        long r12 = System.currentTimeMillis() - r11;
        String r13 = LivePerformanceManager.convertRoomType(LiveMode.Companion.valueOf(r10.getInt("live.intent.extra.STREAM_TYPE", 0)));
        HashMap r14 = new HashMap();
        r14.put("duration", String.valueOf(r12));
        r14.put("room_type", r13);
        r14.put("is_anchor", "0");
        u.l().sendLog("livesdk_interaction_load_duration", r14, new Object[]{Room.class, x.class});
        com.bytedance.android.live.core.tetris.widgets.d.g("livesdk_interaction_load_duration:  duration: " + r12);
        goto L28
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#onStart" + hashCode());
        com.bytedance.android.live.core.tetris.widgets.d.g("onStart#" + hashCode());
        fo1.b r0 = this.d;
        if ((!r0.a) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        int r1 = com.bytedance.android.livesdk.castscreen.utils.f.c;
        com.bytedance.android.livesdk.castscreen.utils.f.a = System.currentTimeMillis();
    L8:
        Iterator r2 = ((ArrayList) this.h).iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r2.next()).p();
        goto L10
    }

    public final void onStop() {
        super.onStop();
        com.bytedance.android.live.core.tetris.widgets.d.g("onStop#" + hashCode());
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#onStop" + hashCode());
        fo1.b r0 = this.d;
        if ((!r0.a) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L12;
        int r1 = io1.d.a;
        Intrinsics.checkNotNullParameter(r0, "interactionContext");
        HashMap r2 = new HashMap();
        long r3 = System.currentTimeMillis() - r0.z;
        long r5 = BubbleId.PadCast;
        r2.put("time", String.valueOf(r3 / r5));
        r2.put("duration", String.valueOf((System.currentTimeMillis() - r0.z) / r5));
        if (r0.a == false) goto L10;
        String r4 = "0";
    L11:
        r2.put("room_orientation", r4);
        com.bytedance.android.livesdk.log.g r6 = u.l();
        x r7 = new x();
        r7.a = "live";
        r7.e = "other";
        r7.b = "live_detail";
        r6.sendLog("transverse_screen_duration", r2, new Object[]{r7, Room.class});
        goto L12
    L10:
        r4 = "1";
    L12:
        Iterator<T> r8 = this.h.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r8.next()).q();
        goto L14
    }

    public final com.bytedance.android.livesdk.chatroom.ui.framework.base.f U90(DataCenter r17) {
        int r1 = fh1.c.a;
        if (fh1.c.b(this.d.b(), null, 2) == true) goto L5;
    L7:
        boolean r9 = false;
    L8:
        fo1.b r2 = this.d;
        if ((!r2.a) == true) goto L11;
        boolean r7 = MultiRoomConfig.INSTANCE.enableComponentPreload(r2.c(), this.d.b());
        boolean r8 = MultiLinkLoadWidgetUtils.g();
        boolean r10 = g2.a(this.d.c(), this.d.b());
        int r11 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.g.a(r9);
        Lazy r3 = GameCastScreenUtils.a;
        RoomContext r4 = this.d.d();
        if (u90.a.getValue().booleanValue() == true) goto L15;
    L17:
        if (r4 == null) goto L22;
        if (r4.isVSRoom() != true) goto L22;
    L20:
        int r12 = 0;
    L65:
        return new fo1.g(r7, r8, r9, r10, r11, r12, r17);
    L22:
        if (oq0.a.getValue().booleanValue() == false) goto L63;
        CastScreenViewModel.a r6 = CastScreenViewModel.Companion;
        if (r4 == null) goto L28;
        com.bytedance.live.datacontext.n r13 = r4.getDataCenter();
        if (r13 == null) goto L28;
        DataCenter r14 = (DataCenter) r13.getValue();
    L29:
        r6.getClass();
        CastScreenViewModel r15 = CastScreenViewModel.a.b(r14);
        if (r15 == null) goto L35;
        com.bytedance.live.datacontext.m r16 = r15.getCastOrMirrorScreenMode();
        if (r16 == null) goto L35;
        if (((Boolean) r16.getValue()).booleanValue() != true) goto L35;
    L62:
        r12 = 1;
    L35:
        Lazy r18 = GameCastScreenUtils.a;
        IHostLiveByteCast r19 = (IHostLiveByteCast) r18.getValue();
        if (r19 == null) goto L38;
        LiveCastPlayInfo r110 = r19.getCastingPlayInfo();
    L39:
        if (r110 != null) goto L41;
    L60:
        boolean r5 = false;
    L61:
        if (r5 == false) goto L63;
    L41:
        if (r110.getSceneId() != 104) goto L60;
        String r20 = r110.getVideoId();
        if (r20 == null) goto L45;
        Long r21 = StringsKt.toLongOrNull(r20);
    L46:
        IHostLiveByteCast r22 = (IHostLiveByteCast) r18.getValue();
        if (r22 == null) goto L60;
        if (r22.isCasting() != true) goto L60;
        if (r4 == null) goto L56;
        com.bytedance.live.datacontext.m r23 = r4.getRoom();
        if (r23 == null) goto L56;
        Room r24 = (Room) r23.getValue();
        if (r24 == null) goto L56;
        Long r25 = Long.valueOf(r24.id);
    L58:
        if (Intrinsics.areEqual(r21, r25) == false) goto L60;
        r5 = true;
    L56:
        r25 = null;
        goto L58
    L45:
        r21 = null;
        goto L46
    L38:
        r110 = null;
    L28:
        r14 = null;
    L63:
        r12 = 2;
        goto L65
    L15:
        if (com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.d.c() != true) goto L17;
    L11:
        return new fo1.e(r9, r17);
    L5:
        if (this.d.a == false) goto L7;
        r9 = true;
        goto L8
    }

    public final void onActivityCreated(Bundle r12) {
        io1.b.C0393b r0 = this.k.a;
        if (r0 == null) goto L5;
        r0.a = System.currentTimeMillis();
    L5:
        super.onActivityCreated(r12);
        ILiveUxTracer r13 = jc1.k.f(ILiveUxTracer.class);
        if (r13 == null) goto L8;
        r13.recordTimeStamp("interaction_activity_create", "start");
    L8:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.e r14 = this.d.p;
        if (r14 == null) goto L11;
        r14.report("fragment_activity_created", null);
    L11:
        com.bytedance.android.live.core.tetris.widgets.d.g("onActivityCreated#" + hashCode());
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#onActivityCreated" + hashCode());
        String r15 = T90();
        if (r15 == null) goto L16;
        com.bytedance.android.live.core.tetris.widgets.d.g("onActivityCreated checkInteractionValid failed, reason is ".concat(r15));
        int r1 = InteractionSlardarUtils.a;
        InteractionSlardarUtils.c(this.d, "create", r15);
        return;
    L16:
        if (MultiRoomConfig.INSTANCE.enableComponentPreload(this.d.c(), this.d.b()) == true) goto L45;
        Iterator r16 = ((ArrayList) this.h).iterator();
    L19:
        if (r16.hasNext() == false) goto L21;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r16.next()).f();
        goto L19
    L21:
        int r17 = com.bytedance.android.live.core.tetris.componentx.schedule.a.a;
        e0 r18 = this.d.d;
        if (r18 != null) goto L24;
    L26:
        boolean r19 = false;
    L28:
        if (com.bytedance.android.live.core.tetris.componentx.schedule.a.a(false, true, r19) == true) goto L30;
    L40:
        this.f.x();
        InteractionComponentManager r110 = this.f;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r2 = U90(this.d.b());
        r110.getClass();
        Intrinsics.checkNotNullParameter(r2, "descriptorList");
        r110.d = r2;
        this.f.v((CompatComponentScheduler) V90());
        W90("load_base_component", new NewAudienceInteractionFragment$startLoadInteractionFragment$6(this));
        W90("load_room_context", new NewAudienceInteractionFragment$startLoadInteractionFragment$7(this));
        W90("load_fs_component", new NewAudienceInteractionFragment$startLoadInteractionFragment$8(this));
        W90("load_batch_component", new NewAudienceInteractionFragment$startLoadInteractionFragment$9(this));
        W90("load_revenue_context", new NewAudienceInteractionFragment$startLoadInteractionFragment$10(this));
        W90("load_room_controller", new NewAudienceInteractionFragment$startLoadInteractionFragment$11(this));
    L41:
        int r111 = io1.d.a;
        io1.d.a(this.d);
        this.d.e(getView());
        Iterator r112 = ((ArrayList) this.d.w).iterator();
    L43:
        if (r112.hasNext() == false) goto L45;
        ((is2.f) r112.next()).LJ(this.d.c());
        goto L43
    L30:
        if (ComponentManagerABHelper.INSTANCE.enableRoomSceneScheduler() == false) goto L40;
        if (this.f.z() == false) goto L40;
        this.f.x();
        InteractionComponentManager r113 = this.f;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r5 = U90(this.d.b());
        r113.getClass();
        Intrinsics.checkNotNullParameter(r5, "descriptorList");
        r113.d = r5;
        this.f.v((CompatComponentScheduler) V90());
        RoomContext r114 = this.d.d();
        e0 r4 = this.d.d;
        if (r4 != null) goto L36;
    L38:
        boolean r6 = false;
    L39:
        r114.setEnableSchedulerAsyncTask(com.bytedance.android.live.core.tetris.componentx.schedule.a.a(false, true, r6));
        this.f.y();
        com.bytedance.android.live.core.tetris.widgets.d.g("asyncTaskManager.startAsync");
        AsyncTaskManager r115 = new AsyncTaskManager();
        r115.b(new Pair[]{TuplesKt.to("initSchedulerIntance", new NewAudienceInteractionFragment$startLoadInteractionFragment$1(this, null)), TuplesKt.to("handleBaseComponentAndFs", new NewAudienceInteractionFragment$startLoadInteractionFragment$2(this, null)), TuplesKt.to("startStateMachine", new NewAudienceInteractionFragment$startLoadInteractionFragment$3(this, null)), TuplesKt.to("notifyRevenueInstanceLoadWidget", new NewAudienceInteractionFragment$startLoadInteractionFragment$4(this, null)), TuplesKt.to("onInteractionReady", new NewAudienceInteractionFragment$startLoadInteractionFragment$5(this, null))});
        r115.e(new Pair[]{TuplesKt.to("startStateMachine", CollectionsKt.listOf("initSchedulerIntance"))});
        r115.f();
        r115.c("handleBaseComponentAndFs");
        r115.c("startStateMachine");
        r115.c("notifyRevenueInstanceLoadWidget");
        r115.c("onInteractionReady");
        goto L41
    L36:
        if (d90.c.h(r4) != true) goto L38;
        r6 = true;
        goto L39
    L24:
        if (d90.c.h(r18) != true) goto L26;
        r19 = true;
    L45:
        fo1.b r116 = this.d;
        if (r116 == null) goto L48;
        r116.y = true;
    L48:
        Iterator r117 = ((ArrayList) r116.w).iterator();
    L50:
        if (r117.hasNext() == false) goto L52;
        ((is2.f) r117.next()).onActivityCreated();
        goto L50
    L52:
        com.bytedance.android.live.core.tetris.widgets.d.g("oldOnViewCreated end");
        ILiveUxTracer r118 = jc1.k.f(ILiveUxTracer.class);
        if (r118 == null) goto L55;
        r118.recordTimeStamp("interaction_activity_create", "end");
    L55:
        io1.b.C0393b r119 = this.k.a;
        if (r119 == null) goto L62;
        r119.b = System.currentTimeMillis() - r119.a;
        return;
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r3);
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r0.next()).g(r3);
        goto L4
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        fo1.b r6 = this.d;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.e r0 = r6.p;
        if (r0 != null) goto L5;
    L9:
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#onCreate" + hashCode());
        com.bytedance.android.live.core.tetris.widgets.d.g("onCreate#" + hashCode());
        fo1.b r7 = this.d;
        DataCenter r1 = r7.b();
        Bundle r2 = r7.q.getArguments();
        String r3 = "";
        if (r2 == null) goto L15;
        String r4 = r2.getString("live.intent.extra.ENTER_LIVE_SOURCE", "");
        if (r4 == null) goto L15;
        r3 = r4;
    L15:
        r1.put("log_enter_live_source", r3);
        FragmentActivity r8 = r7.q.getActivity();
        if (r8 == null) goto L20;
        SharedPreferences r9 = r8.getSharedPreferences("feed_live_span", 0);
        if (r9 == null) goto L20;
        int r10 = r9.getInt("span_count", 0);
    L22:
        if (r10 <= 1) goto L24;
        String r11 = "live_small_picture";
    L25:
        r7.b().put("log_live_feed_layout", r11);
        r7.b().put("log_streaming_type", r7.i.getLogStreamingType());
        Bundle r12 = r7.q.getArguments();
        if (r12 == null) goto L38;
        com.bytedance.android.livesdk.log.g r13 = u.l();
        com.bytedance.android.livesdk.log.filter.o r14 = null;
        if (r13 == null) goto L30;
        com.bytedance.android.livesdk.log.filter.o r15 = r13.c(am2.f.class);
    L32:
        if ((r15 instanceof com.bytedance.android.livesdk.log.filter.i) == false) goto L35;
        r14 = r15;
    L35:
        com.bytedance.android.livesdk.log.filter.i r16 = (com.bytedance.android.livesdk.log.filter.i) r14;
        if (r16 == null) goto L38;
        r16.J(r12);
        goto L38
    L30:
        r15 = null;
    L38:
        Iterator r17 = ((ArrayList) this.h).iterator();
    L40:
        if (r17.hasNext() == false) goto L42;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r17.next()).h();
        goto L40
    L42:
        hd0.c.f().k(0);
        xs2.b.a().post(new t0(this.d.c()));
        ILiveUxTracer r18 = jc1.k.f(ILiveUxTracer.class);
        if (r18 == null) goto L47;
        r18.recordSingleTimeStamp("interaction_create");
        return;
    L47:
        return;
    L24:
        r11 = "live_big_picture";
    L20:
        r10 = 0;
        goto L22
    L5:
        if (r6.a == false) goto L7;
        String r19 = "Portrait";
    L8:
        r0.report("fragment_create", r19);
        goto L9
    L7:
        r19 = "Landscape";
        goto L8
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r0.next()).i(r4);
        goto L4
    L6:
        return r4;
    }

    public static final Object S90(final NewAudienceInteractionFragment r5, Continuation r6) {
        r5.getClass();
        if ((r6 instanceof NewAudienceInteractionFragment$startStateMachine$1) == false) goto L7;
        NewAudienceInteractionFragment$startStateMachine$1 r0 = (NewAudienceInteractionFragment$startStateMachine$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r7);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = (NewAudienceInteractionFragment) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L19:
        r0.L$0 = null;
        r0.label = 2;
        r5.getClass();
        r5.W90("load_start_scheduling", new NewAudienceInteractionFragment$startStateMachineLoading$2(r5));
        if (Unit.INSTANCE != r2) goto L23;
        return r2;
    L16:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = r5;
        r0.label = 1;
        r5.W90("load_start_observer", new NewAudienceInteractionFragment$startObserveBatchLoad$2(r5));
        if (Unit.INSTANCE != r2) goto L19;
        return r2;
    L7:
        r0 = new NewAudienceInteractionFragment$startStateMachine$1(r5, r6);
        goto L8
    }

    public final void T4(Room r10, w r11) {
        Intrinsics.checkNotNullParameter(r10, "room");
        Intrinsics.checkNotNullParameter(r11, "params");
        if (MultiRoomConfig.INSTANCE.enableComponentPreload(this.d.c(), this.d.b()) == true) goto L5;
        return;
    L5:
        String r12 = T90();
        if (r12 == null) goto L9;
        com.bytedance.android.live.core.tetris.widgets.d.g("executeHighPriorityTask checkInteractionValid failed, reason is ".concat(r12));
        int r13 = InteractionSlardarUtils.a;
        InteractionSlardarUtils.c(this.d, "executeHighPriorityTask", r12);
        return;
    L9:
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#executeHighPriorityTask" + hashCode());
        int r14 = com.bytedance.android.live.core.tetris.componentx.schedule.a.a;
        e0 r15 = this.d.d;
        if (r15 != null) goto L12;
    L14:
        boolean r16 = false;
    L16:
        if (com.bytedance.android.live.core.tetris.componentx.schedule.a.a(false, true, r16) == true) goto L18;
    L31:
        W90("load_room_context", new NewAudienceInteractionFragment$executeHighPriorityTask$7(this));
        W90("load_fs_component", new NewAudienceInteractionFragment$executeHighPriorityTask$8(this));
        W90("load_batch_component", new NewAudienceInteractionFragment$executeHighPriorityTask$9(this));
        W90("load_revenue_context", new NewAudienceInteractionFragment$executeHighPriorityTask$10(this));
        W90("load_room_controller", new NewAudienceInteractionFragment$executeHighPriorityTask$11(this));
        int r17 = io1.d.a;
        io1.d.a(this.d);
        this.d.e(getView());
        Iterator r18 = ((ArrayList) this.d.w).iterator();
    L33:
        if (r18.hasNext() == false) goto L38;
        ((is2.f) r18.next()).LJ(this.d.c());
        goto L33
    L38:
        return;
    L18:
        if (ComponentManagerABHelper.INSTANCE.enableRoomSceneScheduler() == false) goto L31;
        if (this.f.z() == false) goto L31;
        RoomContext r19 = this.d.d();
        e0 r1 = this.d.d;
        if (r1 != null) goto L24;
    L26:
        boolean r2 = false;
    L27:
        r19.setEnableSchedulerAsyncTask(com.bytedance.android.live.core.tetris.componentx.schedule.a.a(false, true, r2));
        this.f.y();
        com.bytedance.android.live.core.tetris.widgets.d.g("asyncTaskManager.startAsync");
        AsyncTaskManager r110 = new AsyncTaskManager();
        r110.b(new Pair[]{TuplesKt.to("initSchedulerIntance", new NewAudienceInteractionFragment$executeHighPriorityTask$1(this, null)), TuplesKt.to("loadFsComponent", new NewAudienceInteractionFragment$executeHighPriorityTask$2(this, null)), TuplesKt.to("startStateMachine", new NewAudienceInteractionFragment$executeHighPriorityTask$3(this, null)), TuplesKt.to("notifyRevenueInstanceLoadWidget", new NewAudienceInteractionFragment$executeHighPriorityTask$4(this, null)), TuplesKt.to("onInteractionReady", new NewAudienceInteractionFragment$executeHighPriorityTask$5(this, null))});
        r110.e(new Pair[]{TuplesKt.to("startStateMachine", CollectionsKt.listOf("initSchedulerIntance"))});
        r110.f();
        r110.c("loadFsComponent");
        r110.c("startStateMachine");
        r110.c("notifyRevenueInstanceLoadWidget");
        r110.c("onInteractionReady");
        int r111 = io1.d.a;
        io1.d.a(this.d);
        this.d.e(getView());
        Iterator r112 = ((ArrayList) this.d.w).iterator();
    L29:
        if (r112.hasNext() == false) goto L35;
        ((is2.f) r112.next()).LJ(this.d.c());
        goto L29
    L35:
        return;
    L24:
        if (d90.c.h(r1) != true) goto L26;
        r2 = true;
        goto L27
    L12:
        if (d90.c.h(r15) != true) goto L14;
        r16 = true;
        goto L16
    }

    public final void W90(String r4, Function0<Unit> r5) {
        io1.b.C0393b r0 = this.k.a;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r4, "process");
        r0.c.put(r4, Long.valueOf(System.currentTimeMillis()));
    L5:
        r5.invoke();
        io1.b.C0393b r6 = this.k.a;
        if (r6 == null) goto L9;
        r6.a(r4);
        return;
    }

    public final void X90(Runnable r7, String r8) {
        MultiRoomConfig r0 = MultiRoomConfig.INSTANCE;
        if (r0.isPostPreloadTask() == false) goto L25;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, this.d.b(), 0, 2);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.n r2 = r1.isRoomVisible();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
    L11:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L25;
        PreloadOpt r4 = r0.getPreloadOpt();
        if (r4 != null) goto L15;
    L24:
        i0.j(c50.b.b(this.d.b()), r7, r0.postDelayTime());
        return;
    L15:
        if (r4.getPostRoomInnerTask() != true) goto L24;
        fo1.b r5 = this.d;
        if (r5 == null) goto L23;
        wh1.a r6 = r5.A;
        if (r6 == null) goto L23;
        IRoomPreloadTaskManager r9 = r6.e;
        if (r9 == null) goto L23;
        r9.postTask(r7, r0.postDelayTime(), r8);
        return;
    L23:
        r7.run();
        return;
    L9:
        r3 = null;
    L25:
        r7.run();
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#onViewCreated" + hashCode());
        com.bytedance.android.live.core.tetris.widgets.d.g("onViewCreated#" + hashCode());
        fo1.b r0 = this.d;
        r0.e = true;
        r0.g();
        r0.b().put("enable_rxjava_async", Boolean.valueOf(((n41) x5.a.getValue()).d()));
        this.d.d = this.f.s();
        fo1.b r1 = this.d;
        e0 r2 = r1.d;
        if (r2 == null) goto L8;
        i r3 = this.j;
        if (r3 != null) goto L7;
        r3 = new i(r1);
        this.j = r3;
    L7:
        ho1.a.p(r2, c.class, r3);
    L8:
        Iterator r4 = ((ArrayList) this.h).iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r4.next()).r(r5, r6);
        goto L10
    }

    public final void onActivityResult(int r6, int r7, Intent r8) {
        yh0.c r0 = ho1.a.m(this.d.d);
        e0 r1 = this.d.d;
        if (r1 == null) goto L7;
        IAbilityCenter r2 = r1.m;
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.f r3 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.f) r2.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.f.class);
    L8:
        gd0.f r4 = ho1.a.b(this.d.d);
        if (r4 != null) goto L11;
    L13:
        if (r0 != null) goto L15;
    L17:
        if (r3 == null) goto L22;
        r3.onActivityResult(r6, r7, r8);
        return;
    L22:
        return;
    L15:
        if (r0.isPickingImage() != true) goto L17;
        r0.onActivityResult(r6, r7, r8);
        return;
    L11:
        if (r4.isPickingImage() != true) goto L13;
        r4.onActivityResult(r6, r7, r8);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#onCreateView" + hashCode());
        return this.e.s(r2, r3);
    }
}
