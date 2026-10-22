package com.bytedance.android.livesdk.chatroom.ui.framework;

import am2.x;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.setting.j2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.RoomDataType;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.ui.framework.anchor.AnchorInteractionRoomControllerManager;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.CompatComponentScheduler;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionComponentManager;
import com.bytedance.android.livesdk.chatroom.ui.framework.log.InteractionSlardarUtils;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q;
import com.bytedance.android.livesdk.config.n41;
import com.bytedance.android.livesdk.config.o51;
import com.bytedance.android.livesdk.config.wg;
import com.bytedance.android.livesdk.floatview.p;
import com.bytedance.android.livesdk.lifecycle.ILifeCycleAware;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.performance.LivePerformanceManager;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdk.x5;
import com.bytedance.android.livesdkapi.IPicturePresentationWidgetAbility;
import com.bytedance.android.livesdkapi.depend.chat.OnBackPressedListener;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zg1.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/NewAnchorInteractionFragment;", "Landroidx/fragment/app/DialogFragment;", "Ltw2/b;", "Lfo1/i;", "", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewAnchorInteractionFragment extends DialogFragment implements tw2.b, fo1.i, OnBackPressedListener {
    public final eo1.b d;
    public final com.bytedance.android.livesdk.chatroom.ui.framework.base.o e;
    public final InteractionComponentManager f;
    public final AnchorInteractionRoomControllerManager g;
    public final List<com.bytedance.android.livesdk.chatroom.ui.framework.base.i> h;
    public h i;
    public final io1.b j;

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
        r0.put("is_Anchor", Boolean.TRUE);
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
        ALogger.i("ttlive_anchor_swallow_back", "AnchorInteractionFragmentDestroy");
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroy#" + hashCode());
        this.d.getClass();
        ILifeCycleAware r0 = jc1.k.f(ILifeCycleAware.class);
        if (r0 == null) goto L5;
        r0.onInteractionFragmentDestroy(this.d.c().getIdStr());
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Iterator<T> r1 = this.h.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r1.next()).onDestroy();
        goto L7
    L9:
        e0 r2 = this.d.d;
        if (r2 == null) goto L12;
        ho1.a.q(r2, c.class);
    L12:
        eo1.b r3 = this.d;
        r3.k = null;
        ((ArrayList) r3.l).clear();
        r3.m = null;
        ((ArrayList) r3.w).clear();
        ((ArrayList) r3.x).clear();
        r3.v = null;
        boolean r4 = p.a;
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroy end");
    }

    public final void onDestroyView() {
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroyView#" + hashCode());
        eo1.b r0 = this.d;
        r0.e = false;
        r0.j = null;
        Iterator<T> r1 = this.h.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r1.next()).l();
        goto L4
    L6:
        super.onDestroyView();
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroyView end");
    }

    public NewAnchorInteractionFragment() {
        ArrayList r0 = new ArrayList();
        this.h = r0;
        io1.b r1 = new io1.b();
        this.j = r1;
        eo1.b r2 = new eo1.b(this);
        r2.o = r1;
        Unit r3 = Unit.INSTANCE;
        this.d = r2;
        r0.add(new eo1.c());
        com.bytedance.android.livesdk.chatroom.ui.framework.base.o r4 = new com.bytedance.android.livesdk.chatroom.ui.framework.base.o();
        r0.add(r4);
        this.e = r4;
        InteractionComponentManager r5 = new InteractionComponentManager();
        r0.add(r5);
        this.f = r5;
        AnchorInteractionRoomControllerManager r6 = new AnchorInteractionRoomControllerManager();
        r0.add(r6);
        this.g = r6;
        Iterator r7 = r0.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.i r8 = (com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r7.next();
        eo1.b r9 = this.d;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.a = r9;
        goto L4
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        com.bytedance.android.live.core.tetris.widgets.d.g("onPause#" + hashCode());
        this.d.f = false;
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r0.next()).m();
        goto L4
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        com.bytedance.android.live.core.tetris.widgets.d.g("onResume#" + hashCode());
        this.d.f = true;
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r0.next()).n();
        goto L4
    L6:
        int r1 = io1.d.a;
        eo1.b r2 = this.d;
        Intrinsics.checkNotNullParameter(r2, "interactionContext");
        if (((o51) j2.a.getValue()).liveLogDeleteOpt == false) goto L10;
        return;
    L10:
        if (r2.n == true) goto L22;
        Bundle r3 = r2.a();
        if (r3 == null) goto L23;
        long r4 = r3.getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME");
        if (r4 <= 0) goto L24;
        r2.n = true;
        long r5 = System.currentTimeMillis() - r4;
        HashMap r6 = new HashMap();
        String r7 = LivePerformanceManager.convertRoomType(LiveMode.Companion.valueOf(r3.getInt("live.intent.extra.STREAM_TYPE", 0)));
        r6.put("duration", String.valueOf(r5));
        r6.put("room_type", r7);
        r6.put("is_anchor", "1");
        u.l().sendLog("livesdk_interaction_load_duration", r6, new Object[]{Room.class, x.class});
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        com.bytedance.android.live.core.tetris.widgets.d.g("onStart#" + hashCode());
        Iterator r0 = ((ArrayList) this.h).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r0.next()).p();
        goto L4
    }

    public final void onStop() {
        super.onStop();
        if (lo2.a.d() == false) goto L8;
        lo2.a.e().getClass();
        if (lo2.a.d() == false) goto L8;
        lo2.a.k.dismiss();
    L8:
        com.bytedance.android.live.core.tetris.widgets.d.g("onStop#" + hashCode());
        Iterator r0 = ((ArrayList) this.h).iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r0.next()).q();
        goto L10
    }

    public final void onActivityCreated(Bundle r8) {
        io1.b.C0393b r0 = this.j.a;
        if (r0 == null) goto L5;
        r0.a = System.currentTimeMillis();
    L5:
        super.onActivityCreated(r8);
        com.bytedance.android.live.core.tetris.widgets.d.g("onActivityCreated#" + hashCode());
        if (getView() != null) goto L9;
        String r9 = "view_null";
    L15:
        if (r9 == null) goto L18;
        com.bytedance.android.live.core.tetris.widgets.d.g("onActivityCreated checkInteractionValid failed, reason is ".concat(r9));
        int r1 = InteractionSlardarUtils.a;
        InteractionSlardarUtils.c(this.d, "create", r9);
        return;
    L18:
        Iterator r10 = ((ArrayList) this.h).iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r10.next()).f();
        goto L20
    L22:
        this.f.x();
        InteractionComponentManager r11 = this.f;
        DataCenter r2 = this.d.b();
        if (fh1.c.b(r2, null, 2) == true) goto L25;
    L27:
        boolean r3 = false;
    L28:
        eo1.a r4 = new eo1.a(r3, r2);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r4, "descriptorList");
        r11.d = r4;
        InteractionComponentManager r12 = this.f;
        IComponentScheduler.LoadMode r5 = IComponentScheduler.LoadMode.DIRECT;
        if (ComponentManagerABHelper.INSTANCE.enableRoomSceneScheduler() == true) goto L31;
    L33:
        IComponentScheduler.SchedulerType r6 = IComponentScheduler.SchedulerType.LOAD_TASK_SCHEDULER;
    L34:
        r12.v(new CompatComponentScheduler(r5, r6, false));
        S90("load_base_component", new AnonymousClass2(this));
        S90("load_room_context", new AnonymousClass3(this));
        S90("loadPreloadComponent", new AnonymousClass4(this));
        S90("load_fs_component", new AnonymousClass5(this));
        S90("load_batch_component", new AnonymousClass6(this));
        S90("load_revenue_context", new AnonymousClass7(this));
        S90("load_room_controller", new AnonymousClass8(this));
        int r13 = io1.d.a;
        eo1.b r14 = this.d;
        Intrinsics.checkNotNullParameter(r14, "interactionContext");
        wg r7 = wg.a;
        if (r7.getValue().a() == false) goto L37;
        ((ObservableSubscribeProxy) Observable.interval(r7.getValue().b(), r7.getValue().c(), TimeUnit.SECONDS).take(r7.getValue().e()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r14.q))).subscribe(new io1.c(r14));
    L37:
        IPerformanceManager r15 = jc1.k.f(IPerformanceManager.class);
        HashMap r16 = new HashMap();
        r16.put("stage", "anchor_first_ui_load_perf");
        r16.put("step", "first_frame_did_start_load");
        if (r15 == null) goto L40;
        r16.put("fps", String.valueOf(r15.getFps()));
        r16.put("mem_pss_total", String.valueOf(r15.getPssTotal()));
        r16.put("cpu_rate", String.valueOf(r15.getCpuRate()));
        r16.put("gpu_usage", String.valueOf(r15.getGpuUsed()));
    L40:
        u.l().sendLog("livesdk_anchor_perf_monitor", r16, new Object[0]);
        this.d.e(getView());
        com.bytedance.android.live.core.tetris.widgets.d.g("oldOnViewCreated end");
        NewBroadcastMonitor.f("ttlive_interaction_create");
        io1.b.C0393b r17 = this.j.a;
        if (r17 == null) goto L45;
        r17.b = System.currentTimeMillis() - r17.a;
        return;
    L45:
        return;
    L31:
        if (this.f.z() == false) goto L33;
        r6 = IComponentScheduler.SchedulerType.COMPONENT_X_SCHEDULER;
        goto L34
    L25:
        if (this.d.a == false) goto L27;
        r3 = true;
        goto L28
    L9:
        if (this.d.d().isCleared() == false) goto L12;
        r9 = "room_context_cleared";
        goto L15
    L12:
        if (this.d.e == true) goto L14;
        r9 = "view_invalid";
        goto L15
    L14:
        r9 = null;
        goto L15
    }

    public final void onAttachFragment(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "childFragment");
        super/*androidx.fragment.app.Fragment*/.onAttachFragment(r3);
        if (Intrinsics.areEqual("live_short_video_host_fragment", r3.getTag()) == false) goto L6;
        this.d.b().put("cmd_set_up_component_for_short_video_fragment", Boolean.TRUE);
        return;
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        com.bytedance.android.live.core.tetris.widgets.d.g("onCreate#" + hashCode());
        eo1.b r7 = this.d;
        DataCenter r0 = r7.b();
        Bundle r1 = r7.q.getArguments();
        String r2 = "";
        if (r1 == null) goto L8;
        String r3 = r1.getString("live.intent.extra.ENTER_LIVE_SOURCE", "");
        if (r3 == null) goto L8;
        r2 = r3;
    L8:
        r0.put("log_enter_live_source", r2);
        FragmentActivity r4 = r7.q.getActivity();
        if (r4 == null) goto L13;
        SharedPreferences r5 = r4.getSharedPreferences("feed_live_span", 0);
        if (r5 == null) goto L13;
        int r8 = r5.getInt("span_count", 0);
    L15:
        if (r8 <= 1) goto L17;
        String r9 = "live_small_picture";
    L18:
        r7.b().put("log_live_feed_layout", r9);
        r7.b().put("log_streaming_type", r7.i.getLogStreamingType());
        Bundle r10 = r7.q.getArguments();
        n0 r11 = null;
        if (r10 == null) goto L30;
        com.bytedance.android.livesdk.log.g r12 = u.l();
        if (r12 == null) goto L23;
        com.bytedance.android.livesdk.log.filter.o r13 = r12.c(am2.f.class);
    L25:
        if ((r13 instanceof com.bytedance.android.livesdk.log.filter.i) == true) goto L27;
        r13 = null;
    L27:
        com.bytedance.android.livesdk.log.filter.i r14 = (com.bytedance.android.livesdk.log.filter.i) r13;
        if (r14 == null) goto L30;
        r14.J(r10);
        goto L30
    L23:
        r13 = null;
    L30:
        Bundle r15 = r7.a();
        if (r15 == null) goto L33;
        boolean r16 = r15.getBoolean("data_live_has_continue_room_data", false);
    L34:
        r7.y = r16;
        n0 r17 = u.l().c(x.class);
        if ((r17 instanceof n0) == false) goto L38;
        r11 = r17;
    L38:
        n0 r18 = r11;
        if (r18 == null) goto L41;
        r18.x = r7.y;
    L41:
        boolean r19 = y50.c.a;
        y50.c.a = r7.y;
        Iterator r20 = ((ArrayList) this.h).iterator();
    L43:
        if (r20.hasNext() == false) goto L45;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r20.next()).h();
        goto L43
    L45:
        hd0.c.f().k(0);
        xs2.b.a().post(new t0(this.d.c()));
        ILiveUxTracer r21 = jc1.k.f(ILiveUxTracer.class);
        if (r21 == null) goto L50;
        r21.recordSingleTimeStamp("interaction_create");
        return;
    L50:
        return;
    L33:
        r16 = false;
        goto L34
    L17:
        r9 = "live_big_picture";
    L13:
        r8 = 0;
        goto L15
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

    public final void S90(String r4, Function0<Unit> r5) {
        io1.b.C0393b r0 = this.j.a;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r4, "process");
        r0.c.put(r4, Long.valueOf(System.currentTimeMillis()));
    L5:
        r5.invoke();
        io1.b.C0393b r6 = this.j.a;
        if (r6 == null) goto L9;
        r6.a(r4);
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        com.bytedance.android.live.core.tetris.widgets.d.g("onViewCreated#" + hashCode());
        eo1.b r0 = this.d;
        r0.e = true;
        DataCenter r1 = r0.b();
        r1.put("data_room", r0.c());
        r1.put("data_room_id", Long.valueOf(r0.c().id));
        r1.put("data_is_portrait", Boolean.valueOf(r0.a));
        r1.put("data_live_mode", r0.i);
        r1.put("data_user_center", TTLiveSDKContext.getHostService().h());
        com.bytedance.android.livesdk.log.filter.o r2 = u.l().c(n0.class);
        if (r2 == null) goto L8;
        Map r3 = r2.getMap();
        if (r3 == null) goto L8;
        String r4 = (String) r3.get("source");
        if (r4 == null) goto L8;
    L9:
        r1.put("data_enter_source", r4);
        Boolean r5 = Boolean.TRUE;
        r1.put("data_is_anchor", r5);
        r1.put("enable_rxjava_async", Boolean.valueOf(((n41) x5.a.getValue()).d()));
        r0.d().getRoom().setValue(r0.c());
        r0.d().isUsingEnterRoom().setValue(r5);
        r0.d().getInteractionDataPrepared().setValue(r0.c());
        r0.d().getFullRoom().setValue(r0.c());
        r0.d().getRoomDataType().setValue(RoomDataType.FULL);
        r0.d().isAnchor().d(r5);
        ILinkServiceExternal r8 = jc1.k.f(ILinkServiceExternal.class);
        if (r8 == null) goto L12;
        r8.updateLiveMode(r0.i);
    L12:
        ILinkServiceExternal r9 = jc1.k.f(ILinkServiceExternal.class);
        if (r9 == null) goto L15;
        r9.updatePortrait(r0.a);
    L15:
        this.d.d = this.f.s();
        eo1.b r10 = this.d;
        e0 r11 = r10.d;
        if (r11 == null) goto L18;
        ho1.a.p(r11, c.class, new g(r10));
    L18:
        Iterator<T> r12 = this.h.iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r12.next()).r(r6, r7);
        goto L20
    L22:
        return;
    L8:
        r4 = "";
        goto L9
    }

    public final void showNow(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L7:
        super.showNow(r3, r4);     // Catch: Exception -> L9
        return;
    L25:
        return;
    L9:
        e = move-exception;
        ALogger.e("NewAnchorInteractionFragment", e);
        if (r3.findFragmentByTag(r4) != null) goto L17;
        FragmentTransaction r5 = r3.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == true) goto L16;
        r5 = r5.add(this, r4);
    L16:
        r5.commitNowAllowingStateLoss();
        return;
    L17:
        ALogger.e("NewAnchorInteractionFragment", "fragment NewAnchorInteractionFragment is already added");
    }

    public final void onActivityResult(int r7, int r8, Intent r9) {
        yh0.c r0 = ho1.a.m(this.d.d);
        e0 r1 = this.d.d;
        IPicturePresentationWidgetAbility r2 = null;
        if (r1 == null) goto L7;
        IAbilityCenter r3 = r1.m;
        if (r3 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.f r4 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.f) r3.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.f.class);
    L8:
        gd0.f r5 = ho1.a.b(this.d.d);
        if (r5 != null) goto L11;
    L13:
        if (r0 != null) goto L15;
    L17:
        if (r4 == null) goto L19;
        r4.onActivityResult(r7, r8, r9);
    L19:
        e0 r6 = this.d.d;
        if (r6 == null) goto L24;
        IAbilityCenter r10 = r6.m;
        if (r10 == null) goto L24;
        r2 = (IPicturePresentationWidgetAbility) r10.getAbility(IPicturePresentationWidgetAbility.class);
    L24:
        if (r2 != null) goto L26;
        return;
    L26:
        if (r2.isPickingImage() != true) goto L30;
        r2.onActivityResult(r7, r8, r9);
        return;
    L30:
        return;
    L15:
        if (r0.isPickingImage() != true) goto L17;
        r0.onActivityResult(r7, r8, r9);
        goto L19
    L11:
        if (r5.isPickingImage() != true) goto L13;
        r5.onActivityResult(r7, r8, r9);
    L7:
        r4 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return this.e.s(r1, r2);
    }
}
