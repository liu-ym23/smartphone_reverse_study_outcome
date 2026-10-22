package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.d6;
import com.bytedance.android.live.core.tetris.ComponentManagerFactory;
import com.bytedance.android.live.core.tetris.componentx.ComponentManager;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.helper.RoomContextInitHelper;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.model.z3;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.chatroom.tetris.filter.RoomModeElementFilter;
import com.bytedance.android.livesdk.chatroom.ui.InteractionContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.InteractionComponentInfos;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import com.bytedance.android.livesdk.chatroom.ui.framework.log.InteractionSlardarUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.widget.i2;
import com.bytedance.android.livesdk.config.ai;
import com.bytedance.android.livesdk.config.i91;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.vscore_api.multicamera.IMultiCameraView;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.t;
import com.bytedance.android.livesdk.widgetdescriptor.InteractionDelegateConfig;
import com.bytedance.android.livesdk.widgetdescriptor.delegate.Portrait5thDelegate;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdk.widgetdescriptor.template.LiveTemplateContext;
import com.bytedance.android.livesdk.widgetdescriptor.template.delegate.TemplateDelegateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.android.livesdkapi.service.ILiveBroadcastSDKService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import nm1.y;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class InteractionComponentManager extends i implements com.bytedance.android.livesdk.chatroom.ui.framework.a, IMultiCameraView, IComponentScheduler.a {
    public RecyclableWidgetManager b;
    public mg2.a c;
    public f d;
    public boolean e;
    public IComponentScheduler f;
    public jm1.a g;
    public final ah1.b h;
    public final ah1.c i;
    public final ah1.a j;
    public final z3 k;
    public final PropertyOwner<LoadState> l;
    public final PropertyOwner<h80.c<com.bytedance.android.livesdk.chatroom.ui.framework.o>> m;
    public final PropertyOwner<h80.c<com.bytedance.android.livesdk.chatroom.ui.framework.o>> n;
    public long o;
    public final Boolean p;
    public final CompositeDisposable q;

    public static final class a implements Runnable {
        public final /* synthetic */ InteractionComponentManager a;

        public a(InteractionComponentManager r1) {
            this.a = r1;
        }

        public final void a() {
            Object r1 = null;
            InteractionContext r0 = (InteractionContext) com.bytedance.live.datacontext.d.b(this.a.getContext().q, null).a(InteractionContext.class);
            Object r2 = r0.getRoomPlaceHolders().getValue();
            if (TypeIntrinsics.isMutableMap(r2) == false) goto L6;
            r1 = r2;
        L6:
            Map r3 = (Map) r1;
            if (r3 == null) goto L9;
            r3.clear();
        L9:
            ALogger.i("interactionContext", "clear interactionContext hashcode=" + r0.hashCode());
            IComponentScheduler r4 = this.a.f;
            if (r4 == null) goto L13;
            r4.g();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements jm1.a.a {
        public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> a;
        public final /* synthetic */ InteractionComponentManager b;

        public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> a() {
            IComponentScheduler r0 = this.b.f;
            if (r0 == null) goto L9;
            com.bytedance.android.livesdk.widgetdescriptor.priority.c r1 = r0.b();
            if (r1 == null) goto L9;
            TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r2 = r1.a();
            if (r2 == null) goto L9;
            return r2;
        L9:
            return this.a;
        }

        public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> b() {
            IComponentScheduler r0 = this.b.f;
            if (r0 == null) goto L9;
            com.bytedance.android.livesdk.widgetdescriptor.priority.c r1 = r0.b();
            if (r1 == null) goto L9;
            TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r2 = r1.b();
            if (r2 == null) goto L9;
            return r2;
        L9:
            return this.a;
        }

        public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> c() {
            IComponentScheduler r0 = this.b.f;
            if (r0 == null) goto L9;
            com.bytedance.android.livesdk.widgetdescriptor.priority.c r1 = r0.b();
            if (r1 == null) goto L9;
            TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r2 = r1.c();
            if (r2 == null) goto L9;
            return r2;
        L9:
            return this.a;
        }

        public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> d() {
            IComponentScheduler r0 = this.b.f;
            if (r0 == null) goto L9;
            com.bytedance.android.livesdk.widgetdescriptor.priority.c r1 = r0.b();
            if (r1 == null) goto L9;
            TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r2 = r1.d();
            if (r2 == null) goto L9;
            return r2;
        L9:
            return this.a;
        }

        public final z3 e() {
            return this.b.k;
        }

        public b(InteractionComponentManager r1) {
            this.b = r1;
            this.a = new TreeMap();
        }
    }

    public static final class c<T> implements h80.d {
        public final /* synthetic */ InteractionComponentManager a;

        public c(InteractionComponentManager r1) {
            this.a = r1;
        }

        public final Object get() {
            Fragment r1 = this.a.getContext().q;
            FragmentActivity r2 = this.a.getContext().q.getActivity();
            if (r2 == null) goto L5;
            FragmentManager r3 = r2.getSupportFragmentManager();
        L7:
            return new Pair(r1, r3);
        L5:
            r3 = null;
            goto L7
        }
    }

    public static final class d<T> implements h80.d {
        public final /* synthetic */ InteractionComponentManager a;

        public d(InteractionComponentManager r1) {
            this.a = r1;
        }

        public final Object get() {
            InteractionComponentManager r0 = this.a;
            e0 r1 = r0.getContext().d;
            if (r1 == null) goto L10;
            DataCenter r2 = r0.getContext().b();
            RoomContext r3 = r0.getContext().d();
            Fragment r4 = r0.getContext().q;
            com.bytedance.android.live.core.tetris.layer.view.a r5 = new com.bytedance.android.live.core.tetris.layer.view.a();
            Intrinsics.checkNotNullParameter(r1, "layerContext");
            r5.c = r1;
            InteractionDelegateConfig r6 = new InteractionDelegateConfig();
            Intrinsics.checkNotNullParameter(r6, "config");
            r5.a = r6;
            LayerEventDispatcher r7 = o70.c.a(Integer.valueOf(r2.hashCode()));
            Intrinsics.checkNotNull(r7);
            Intrinsics.checkNotNullParameter(r7, "layerEventDispatcher");
            r5.d = r7;
            Set r8 = SetsKt.mutableSetOf(new p70.a[]{r0.h, r0.i, r0.j});
            Intrinsics.checkNotNullParameter(r8, "chains");
            r5.l.a = r8;
            ViewModelProvider r9 = ViewModelProviders.of(r4);
            Intrinsics.checkNotNullParameter(r9, "viewModelProvider");
            r5.j = r9;
            ElementBuilderMap r10 = new ElementBuilderMap();
            RecyclableWidgetManager r11 = r0.b;
            Intrinsics.checkNotNull(r11);
            r10.put(j70.o.class, new com.bytedance.android.live.core.tetris.layer.core.element.widget.a(r11));
            Unit r12 = Unit.INSTANCE;
            Intrinsics.checkNotNullParameter(r10, "map");
            r5.b = r10;
            Object r13 = r3.getTemplateDelegateHolder().getValue();
            if ((r13 instanceof b80.a) == true) goto L7;
            r13 = null;
        L7:
            b80.a r14 = (b80.a) r13;
            r5.i = r5.i;
            com.bytedance.android.livesdk.chatroom.tetris.filter.a r15 = new com.bytedance.android.livesdk.chatroom.tetris.filter.a();
            Intrinsics.checkNotNullParameter(r15, "blockElementFilter");
            r5.f = r15;
            RoomModeElementFilter r16 = new RoomModeElementFilter(r2, r1);
            Intrinsics.checkNotNullParameter(r16, "roomModeElementFilter");
            r5.g = r16;
            return r5;
        L10:
            throw new RuntimeException("componentContext is null!!!");
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ InteractionComponentManager a;

        public e(InteractionComponentManager r1) {
            this.a = r1;
        }

        public final void a() {
            ALogger.i("WidgetLoadProperty", "camera load end");
            IComponentScheduler r0 = this.a.f;
            if (r0 == null) goto L5;
            r0.h(true);
        L5:
            RecyclableWidgetManager r1 = this.a.b;
            if (r1 != null) goto L8;
            return;
        L8:
            if (r1.g.a.isEmpty() != true) goto L12;
            this.a.getContext().b().put("cmd_camera_switch_widget_loaded", Boolean.TRUE);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void h() {
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void onDestroy() {
        this.e = true;
        WidgetService.getInstance().creatorMap.clear();
        IComponentScheduler r0 = this.f;
        if (r0 == null) goto L5;
        r0.i();
    L5:
        IComponentScheduler r1 = this.f;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        jm1.a r2 = this.g;
        if (r2 == null) goto L11;
        r2.onDestroy();
    L11:
        this.q.dispose();
        e0 r3 = getContext().d;
        if (r3 == null) goto L14;
        ho1.a.q(r3, com.bytedance.android.livesdk.chatroom.ui.framework.a.class);
    L14:
        this.c = null;
        this.b = null;
    }

    public final void C() {
        if (this.e == false) goto L6;
        return;
    L6:
        if (this.o <= 0) goto L16;
        boolean r0 = fh1.e.a;
        long r1 = getContext().c().getRoomId();
        String r5 = String.valueOf(System.currentTimeMillis() - this.o);
        Intrinsics.checkNotNullParameter(r5, "duration");
        if (fh1.e.a == false) goto L16;
        if (TextUtils.isEmpty(r5) == true) goto L16;
        Map r6 = fh1.e.b;
        LinkedHashMap r8 = (LinkedHashMap) r6;
        HashMap r7 = (HashMap) r8.get(Long.valueOf(r1));
        if (r7 != null) goto L15;
        r7 = new HashMap();
        r6.put(Long.valueOf(r1), r7);
    L15:
        r7.put("base_load_start_duration", r5);
    L16:
        IComponentScheduler r2 = this.f;
        if (r2 == null) goto L20;
        r2.d();
    L20:
        if (this.o <= 0) goto L31;
        boolean r3 = fh1.e.a;
        long r4 = getContext().c().getRoomId();
        String r9 = String.valueOf(System.currentTimeMillis() - this.o);
        Intrinsics.checkNotNullParameter(r9, "duration");
        if (fh1.e.a == true) goto L24;
        return;
    L24:
        if (TextUtils.isEmpty(r9) == true) goto L33;
        Map r10 = fh1.e.b;
        LinkedHashMap r11 = (LinkedHashMap) r10;
        HashMap r12 = (HashMap) r11.get(Long.valueOf(r4));
        if (r12 != null) goto L29;
        r12 = new HashMap();
        r10.put(Long.valueOf(r4), r12);
    L29:
        r12.put("base_load_finish_duration", r9);
        return;
    L33:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final ViewLayerDelegate<? extends h70.b> E8() {
        mg2.a r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o4(mg2.e.e, LayerIndex.INDEX_6);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final ViewLayerDelegate<? extends h70.b> Ni() {
        mg2.a r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o4(mg2.e.e, LayerIndex.INDEX_3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final ViewLayerDelegate<? extends h70.b> hk() {
        mg2.a r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o4(mg2.e.c, LayerIndex.INDEX_2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void l() {
        IComponentScheduler r0 = this.f;
        if (r0 == null) goto L6;
        r0.i();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void o() {
        RecyclableWidgetManager r0 = this.b;
        if (r0 == null) goto L6;
        r0.C60();
        return;
    }

    public final q81.c t() {
        IRoomModuleService r0 = jc1.k.f(IRoomModuleService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveMkMetricHelper();
    }

    public final jm1.a u() {
        if (this.g != null) goto L15;
        y r0 = pm1.f.r();
        if (r0 != null) goto L7;
        return null;
    L7:
        e0 r2 = getContext().d;
        if (r2 != null) goto L10;
        return null;
    L10:
        mg2.a r3 = this.c;
        if (r3 != null) goto L13;
        return null;
    L13:
        this.g = r0.h(r2, r3, new b(this));
    L15:
        return this.g;
    }

    public final boolean z() {
        if (this.c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public InteractionComponentManager() {
        this.h = new ah1.b();
        this.i = new ah1.c();
        this.j = new ah1.a();
        this.k = new z3();
        this.l = new PropertyOwner(LoadState.NONE, InteractionComponentManager$loadState$1.INSTANCE);
        h80.c r1 = h80.c.b;
        this.m = new PropertyOwner(r1, InteractionComponentManager$reloadEvent$1.INSTANCE);
        this.n = new PropertyOwner(r1, InteractionComponentManager$hideEvent$1.INSTANCE);
        this.o = -1;
        this.p = (Boolean) LiveInfraSettingKeys.LIVE_INTERACTION_FRAMEWORK_WIDGET_COMPONENT_CONTEXT_ENABLE.getValue();
        this.q = new CompositeDisposable();
    }

    public final void A() {
        com.bytedance.android.live.revenue.core.b r0 = (com.bytedance.android.live.revenue.core.b) getContext().d().getRevenueInstance().getValue();
        if (r0 == null) goto L6;
        yz0.p.a(r0, InteractionComponentManager$notifyRevenueInstanceLoadWidget$1.INSTANCE);
        return;
    }

    public final Lifecycle Qy() {
        return getContext().q.getLifecycle();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void f() {
        Bundle r0 = getContext().a();
        long r1 = -1;
        if (r0 == null) goto L5;
        r1 = r0.getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", -1);
    L5:
        this.o = r1;
        if (r1 <= 0) goto L9;
        boolean r2 = fh1.e.a;
        fh1.e.b(getContext().c().getRoomId(), String.valueOf(System.currentTimeMillis() - this.o));
        return;
    }

    public final e0 s() {
        Fragment r0 = getContext().q;
        Context r1 = getContext().q.getContext();
        if (r1 == null) goto L20;
        DataCenter r2 = getContext().b();
        RoomContext r3 = getContext().d();
        Room r4 = getContext().c();
        com.bytedance.android.livesdk.chatroom.ui.framework.base.a r5 = getContext();
        if ((r5 instanceof fo1.b) == true) goto L7;
        r5 = null;
    L7:
        fo1.b r6 = (fo1.b) r5;
        if (r6 == null) goto L13;
        com.bytedance.android.livesdk.room.b r7 = r6.t;
        if (r7 == null) goto L13;
        AbilityCenter r8 = ((ls2.c) r7).b;
        if (r8 == null) goto L13;
    L14:
        e0 r9 = new e0(r1, r2, r8);
        ((d90.d) r9).e = r3;
        ((d90.d) r9).g = jc1.k.f(IRoomContextService.class);
        ((d90.d) r9).d = true;
        InteractionContext r10 = (InteractionContext) com.bytedance.live.datacontext.d.b(r0, null).a(InteractionContext.class);
        ALogger.i("interactionContext", "abs create hashcode=" + r10.hashCode());
        InteractionContext.Companion.getClass();
        String r11 = InteractionContext.b.b(r2);
        Intrinsics.checkNotNullParameter(r10, "self");
        com.bytedance.live.datacontext.b.a(r10, r11);
        Intrinsics.checkNotNullParameter(r10, "self");
        com.bytedance.live.datacontext.b.a(r10, InteractionContext.TAG);
        Unit r12 = Unit.INSTANCE;
        r9.k = r10;
        r2.put("data_room_template_SNAPSHOT", r4);
        if (com.bytedance.android.livesdk.widgetdescriptor.template.utils.a.b(r4) == false) goto L17;
        com.bytedance.live.datacontext.n r13 = r3.getTemplateContext();
        LiveTemplateContext r14 = new LiveTemplateContext(r2, r4, r9);
        ((h70.b) r9).a = r14;
        r13.setValue(r14);
        com.bytedance.live.datacontext.n r15 = r3.getTemplateDelegateHolder();
        TemplateDelegateHolder r16 = new TemplateDelegateHolder();
        ViewModelProvider r17 = ViewModelProviders.of(r0);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.b = r17;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r16.a = r9;
        r15.setValue(r16);
        z70.c.a("use template and init template context success");
    L18:
        return r9;
    L17:
        r3.getTemplateContext().setValue(null);
        r3.getTemplateDelegateHolder().setValue(null);
    L13:
        r8 = new AbilityCenter();
        goto L14
    L20:
        throw new RuntimeException("context is null!!!");
    }

    public final void w() {
        Context r0 = getContext().q.getContext();
        if (r0 == null) goto L10;
        y50.c r1 = y50.c.d;
        r1.b("room_context_init");
        RoomContextInitHelper.b(getContext().d(), r0, getContext().b(), !getContext().r);
        r1.a("room_context_init");
        if (this.o <= 0) goto L7;
        boolean r2 = fh1.e.a;
        fh1.e.g(getContext().c().getRoomId(), String.valueOf(System.currentTimeMillis() - this.o));
    L7:
        com.bytedance.android.live.core.tetris.widgets.d.g("RoomContextInitHelper init");
        return;
    L10:
        throw new RuntimeException("context is null!!!");
    }

    public final void x() {
        RoomContext r0 = getContext().d();
        DataCenter r1 = getContext().b();
        r0.getFragmentInfoGetter().setValue(new c(this));
        r0.getWidgetManager().setValue(this.b);
        nm1.r r2 = pm1.f.o();
        if (r2 == null) goto L8;
        r2.a();
        if (MultiTabManagerImpl.e.i(r1) != true) goto L8;
        r0.getLayerConfigGetter().setValue(new d(this));
    L8:
        if (PadConfigUtils.c() == false) goto L14;
        com.bytedance.live.datacontext.n r3 = r0.getPadOrientation();
        if (e5.n() == false) goto L12;
        PadOrientation r4 = PadOrientation.LANDSCAPE;
    L13:
        r3.setValue(r4);
        goto L14
    L12:
        r4 = PadOrientation.PORTRAIT;
    L14:
        r0.getNewRoomAuthViewModel().e(InteractionComponentManager$initRoomContextPartly$3.INSTANCE);
        r0.getWidgetLoadedProperty().setValue(this.k);
    }

    public final void y() {
        Context r0 = getContext().q.getContext();
        if (r0 == null) goto L7;
        RoomContextInitHelper.e(getContext().d(), getContext().b(), r0);
        return;
    L7:
        throw new RuntimeException("context is null!!!");
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final RecyclableWidgetManager Ao() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final ah1.c E9() {
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final PropertyOwner Na() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final PropertyOwner getLoadState() {
        return this.l;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final PropertyOwner i8() {
        return this.n;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final ah1.b xb() {
        return this.h;
    }

    public final void B(Widget r2) {
        if (this.p.booleanValue() == true) goto L8;
        if ((r2 instanceof RadioWidget) == true) goto L8;
        return;
    L8:
        if ((r2 instanceof d70.a) == true) goto L10;
        Widget r0 = null;
    L12:
        if (((d70.a) r0) == null) goto L15;
        ((d70.a) r2).setComponentContext(getContext().d);
        return;
    L15:
        return;
    L10:
        r0 = r2;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final void Og(j70.f r4) {
        Intrinsics.checkNotNullParameter(r4, "elementType");
        Map<j70.f, com.bytedance.android.livesdk.chatroom.ui.framework.base.e> r1 = InteractionComponentInfos.a;
        if ((!getContext().r) == false) goto L6;
        SceneType r2 = SceneType.ANCHOR_PORTRAIT;
    L11:
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        Intrinsics.checkNotNullParameter(r4, "elementType");
        com.bytedance.android.livesdk.chatroom.ui.framework.base.e r5 = InteractionComponentInfos.a.get(r4);
        if (r5 == null) goto L16;
        Function1<SceneType, j70.h<? extends h70.b>> r6 = r5.a;
        if (r6 == null) goto L16;
        j70.h r7 = (j70.h) r6.invoke(r2);
    L17:
        if (r7 == null) goto L22;
        mg2.a r0 = this.c;
        if (r0 == null) goto L23;
        r0.k(r7);
        return;
    L23:
        return;
    L22:
        return;
    L16:
        r7 = null;
        goto L17
    L6:
        if (getContext().r == true) goto L8;
    L10:
        r2 = SceneType.AUDIENCE_PORTRAIT;
        goto L11
    L8:
        if ((!getContext().a) == false) goto L10;
        r2 = SceneType.AUDIENCE_LANDSCAPE;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final void Uj(Widget r5) {
        if (this.p.booleanValue() == true) goto L8;
        if ((r5 instanceof RadioWidget) == true) goto L8;
    L16:
        RecyclableWidgetManager r0 = this.b;
        if (r0 == null) goto L20;
        r0.unload(r5);
        return;
    L20:
        return;
    L8:
        if ((r5 instanceof d70.a) == true) goto L10;
        Widget r1 = null;
    L12:
        if (((d70.a) r1) == null) goto L16;
        d70.a r2 = (d70.a) r5;
        if (Intrinsics.areEqual(r2.getComponentContext(), getContext().d) == false) goto L16;
        r2.setComponentContext(null);
        goto L16
    L10:
        r1 = r5;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler.a
    public final void b(IComponentScheduler.LoadBatch r15) {
        Intrinsics.checkNotNullParameter(r15, "loadBatch");
        int r16 = j.c[r15.ordinal()];
        if (r16 != 1) goto L5;
        q81.c r17 = t();
        if (r17 == null) goto L84;
        r17.i(getContext().c().id, getContext().a());
    L84:
        WidgetService.getInstance().onWidgetLoadEnd(0);
        p0 r18 = (p0) getContext().b().get("zygote_event_hub", null);
        if (r18 == null) goto L89;
        MutableLiveData r19 = r18.getP0WidgetLoaded();
        if (r19 == null) goto L89;
        r19.postValue(Boolean.TRUE);
    L89:
        this.k.a.b.a(Boolean.TRUE);
        this.l.a(LoadState.P0_REAL_END);
        if (ai.a.getValue().booleanValue() == false) goto L103;
        xs2.b.a().post(new tz.a());
        return;
    L103:
        return;
    L5:
        if (r16 != 2) goto L7;
        q81.c r110 = t();
        if (r110 == null) goto L75;
        r110.g(getContext().c().id, getContext().a());
    L75:
        WidgetService.getInstance().onWidgetLoadEnd(1);
        p0 r111 = (p0) getContext().b().get("zygote_event_hub", null);
        if (r111 == null) goto L80;
        MutableLiveData r112 = r111.getP1WidgetLoaded();
        if (r112 == null) goto L80;
        r112.postValue(Boolean.TRUE);
    L80:
        this.k.b.b.a(Boolean.TRUE);
        this.l.a(LoadState.P1_REAL_END);
        return;
    L7:
        if (r16 != 3) goto L9;
        q81.c r113 = t();
        if (r113 == null) goto L66;
        r113.e(getContext().c().id, getContext().a());
    L66:
        WidgetService.getInstance().onWidgetLoadEnd(2);
        p0 r114 = (p0) getContext().b().get("zygote_event_hub", null);
        if (r114 == null) goto L71;
        MutableLiveData r115 = r114.getP2WidgetLoaded();
        if (r115 == null) goto L71;
        r115.postValue(Boolean.TRUE);
    L71:
        this.k.c.b.a(Boolean.TRUE);
        this.l.a(LoadState.P2_REAL_END);
        return;
    L9:
        if (r16 != 4) goto L104;
        ALogger.i("WidgetLoadProperty", "all widget loaded");
        q81.c r116 = t();
        if (r116 == null) goto L15;
        r116.h(getContext().c().id, getContext().a());
    L15:
        if ((!getContext().r) == true) goto L17;
    L22:
        fh1.d.a();
        WidgetService.getInstance().onWidgetLoadEnd(3);
        p0 r117 = (p0) getContext().b().get("zygote_event_hub", null);
        if (r117 == null) goto L25;
        MutableLiveData r0 = r117.getAllWidgetLoaded();
        Boolean r4 = Boolean.TRUE;
        r0.postValue(r4);
        r117.getAllWidgetLoadedV2().postValue(r4);
    L25:
        io1.b r118 = getContext().o;
        if (r118 == null) goto L62;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.a r1 = getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        io1.b.C0393b r5 = r118.a;
        if (r5 == null) goto L38;
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r5.b <= 0) goto L38;
        if (r5.d.size() != 6) goto L38;
        int r7 = InteractionSlardarUtils.a;
        long r8 = r5.b;
        Map<String, Long> r6 = r5.d;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r6, "processCost");
        LiveMonitor.a r9 = InteractionSlardarUtils.b(InteractionSlardarUtils.Event.INTERACTION_CORE_PROCESS_COST);
        InteractionSlardarUtils.a(r9, r1);
        r9.h(r8);
        Iterator r10 = ((LinkedHashMap) r6).entrySet().iterator();
    L35:
        if (r10.hasNext() == false) goto L37;
        Map.Entry r11 = (Map.Entry) r10.next();
        r9.g(((String) r11.getKey()) + "_cost", ((Number) r11.getValue()).longValue());
        goto L35
    L37:
        r9.a().report();
    L38:
        io1.b.a r119 = r118.b;
        if (r119 == null) goto L62;
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r119.b.isEmpty() == true) goto L62;
        Map<String, Long> r12 = r119.b;
        ArrayList r13 = new ArrayList();
        Iterator r14 = ((LinkedHashMap) r12).entrySet().iterator();
    L45:
        if (r14.hasNext() == false) goto L52;
        Map.Entry r20 = (Map.Entry) r14.next();
        if (((Number) r20.getValue()).longValue() > r119.c.getReportMinCostTime()) goto L50;
        r20 = null;
    L50:
        if (r20 == null) goto L45;
        r13.add(r20);
        goto L45
    L52:
        List r2 = CollectionsKt.sortedWith(r13, new io1.a());
        if (r2.isEmpty() == true) goto L62;
        List r120 = r2.subList(0, RangesKt.coerceAtMost(r2.size(), r119.c.getReportElementSize()));
        if ((!r120.isEmpty()) == false) goto L62;
        int r3 = InteractionSlardarUtils.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r120, "widgetCost");
        LiveMonitor.a r21 = InteractionSlardarUtils.b(InteractionSlardarUtils.Event.INTERACTION_CORE_WIDGET_COST);
        InteractionSlardarUtils.a(r21, r1);
        Iterator r121 = r120.iterator();
    L59:
        if (r121.hasNext() == false) goto L61;
        Map.Entry r22 = (Map.Entry) r121.next();
        r21.g(((String) r22.getKey()) + "_cost", ((Number) r22.getValue()).longValue());
        goto L59
    L61:
        r21.a().report();
    L62:
        this.k.d.b.a(Boolean.TRUE);
        this.l.a(LoadState.P3_REAL_END);
        getContext().e(getContext().q.getView());
        return;
    L17:
        if (com.bytedance.android.livesdk.config.setting.a.a() == false) goto L22;
        q81.c r122 = t();
        if (r122 == null) goto L21;
        r122.m(getContext().c().id);
    L21:
        y50.c r123 = y50.c.d;
        y50.c.d();
        r123.a("inter_load_total");
        y50.c.e();
        goto L22
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler.a
    public final void e(IComponentScheduler.LoadBatch r4) {
        Intrinsics.checkNotNullParameter(r4, "loadBatch");
        int r5 = j.b[r4.ordinal()];
        if (r5 != 1) goto L5;
        this.l.a(LoadState.FS_END);
        return;
    L5:
        if (r5 != 2) goto L7;
        y50.c.d.a("fragment_load_p0");
        this.l.a(LoadState.P0_END);
        return;
    L7:
        if (r5 != 3) goto L9;
        this.l.a(LoadState.P1_END);
        return;
    L9:
        if (r5 != 4) goto L11;
        this.l.a(LoadState.P2_END);
        return;
    L11:
        if (r5 != 5) goto L42;
        this.l.a(LoadState.P3_END);
        if (getContext().r == true) goto L16;
    L18:
        Context r6 = getContext().q.getContext();
        mg2.a r0 = this.c;
        if (r0 == null) goto L21;
        ViewLayerDelegate r1 = r0.o4(mg2.e.e, LayerIndex.INDEX_5);
    L22:
        if (r6 == null) goto L27;
        if ((r1 instanceof Portrait5thDelegate) == false) goto L27;
        Portrait5thDelegate r2 = (Portrait5thDelegate) r1;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        r2.t = r6;
    L27:
        if (getContext().r == true) goto L29;
        return;
    L29:
        if (getContext().a == false) goto L37;
        getContext().d().getFromPortrait().setValue(Boolean.TRUE);
        return;
    L37:
        return;
    L21:
        r1 = null;
        goto L22
    L16:
        if (getContext().a == false) goto L18;
        int r7 = d6.a;
        goto L18
    }

    public final void v(CompatComponentScheduler r5) {
        Intrinsics.checkNotNullParameter(r5, "componentScheduler");
        if (this.e == false) goto L5;
        return;
    L5:
        this.f = r5;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.a r0 = getContext();
        f r1 = this.d;
        Intrinsics.checkNotNull(r1);
        RecyclableWidgetManager r2 = this.b;
        Intrinsics.checkNotNull(r2);
        mg2.a r3 = this.c;
        Intrinsics.checkNotNull(r3);
        r5.D(r0, r1, r2, r3);
        IComponentScheduler r6 = this.f;
        if (r6 == null) goto L9;
        r6.f(this);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final void vi(j70.f r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        mg2.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.m(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final Element<?> w8(j70.f r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        mg2.a r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler.a
    public final void d(IComponentScheduler.LoadBatch r8, LayerDescriptorList r9) {
        Intrinsics.checkNotNullParameter(r8, "loadBatch");
        int r10 = j.a[r8.ordinal()];
        boolean r0 = false;
        if (r10 == 1) goto L83;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.a r2 = null;
        if (r10 != 2) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.e r11 = getContext().p;
        if (r11 == null) goto L41;
        r11.report("widget_load_p0_begin", null);
    L41:
        y50.c.d.b("fragment_load_p0");
        q81.c r12 = t();
        if (r12 == null) goto L44;
        r12.c(getContext().c().id, getContext().a());
    L44:
        getContext().b().put("cmd_p0_widget_start_load", Boolean.TRUE);
        this.k.a.a = true;
        this.l.a(LoadState.P0_BEGIN);
        if (getContext().r == false) goto L48;
        long r3 = System.currentTimeMillis();
        getContext().b().put("data_live_interaction_load_p0_ts", Long.valueOf(r3));
        getContext().b().put("data_prepare_room", getContext().c());
        int r13 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(getContext().b(), (CompositeDisposable) getContext().d().getCompositeDisposable().getValue(), "InteractionComponentManager#updateLoad0Ts", new k(r3));
        getContext().d().getPrepareRoom().setValue(getContext().c());
    L48:
        if (getContext().r == true) goto L50;
    L58:
        com.bytedance.android.livesdk.chatroom.ui.framework.base.a r14 = getContext();
        if ((r14 instanceof eo1.b) == false) goto L62;
        r2 = r14;
    L62:
        eo1.b r4 = (eo1.b) r2;
        if (r4 == null) goto L99;
        ALogger.i("AnchorInteractionContext", "loadLiveStreamData-start");
        com.bytedance.android.live.pushstream.d r5 = r4.t;
        if (r5 == null) goto L102;
        d0 r6 = r5.getLiveCore();
        if (r6 == null) goto L103;
        InteractionContext.b r7 = InteractionContext.Companion;
        DataCenter r15 = r4.b();
        r7.getClass();
        InteractionContext r16 = InteractionContext.b.a(r15);
        if (r16 == null) goto L75;
        com.bytedance.live.datacontext.j<d0> r17 = r16.getLiveCore();
        if (r17 == null) goto L75;
        r17.d(r6);
    L75:
        r4.d().getLiveStream().d(r5);
        DataCenter r18 = r4.b();
        com.bytedance.android.live.liveinteract.plantform.utils.d0.a r19 = new com.bytedance.android.live.liveinteract.plantform.utils.d0.a();
        boolean r20 = com.bytedance.android.live.liveinteract.plantform.utils.d0.b;
        if ((2 & vm2.h.f0().getType()) <= 0) goto L78;
        boolean r21 = true;
    L79:
        r19.b(r21);
        if ((vm2.h.f0().getType() & 1) <= 0) goto L82;
        r0 = true;
    L82:
        r19.c(r0, r5);
        r18.put("live_stream_info_sender_manager", r19.a());
        ALogger.i("AnchorInteractionContext", "loadLiveStreamData-end");
        return;
    L78:
        r21 = false;
        goto L79
    L103:
        return;
    L102:
        return;
    L99:
        return;
    L50:
        if (getContext().a == false) goto L58;
        Lazy r22 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(getContext().b(), "loadChildP0Widgets", "call");
        int r23 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r24 = getContext().b();
        Room r25 = getContext().c();
        if (r25 == null) goto L54;
        Long r26 = Long.valueOf(r25.id);
    L55:
        MultiSceneEnterRoomStatisticsUtils r27 = MultiSceneEnterRoomStatisticsUtils.a.a(r24, Long.valueOf(r26.longValue()));
        if (r27 == null) goto L58;
        r27.recordSubElementShow("p0_widget", System.currentTimeMillis());
        goto L58
    L54:
        r26 = null;
        goto L55
    L7:
        if (r10 != 3) goto L9;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.e r28 = getContext().p;
        if (r28 == null) goto L30;
        r28.report("widget_load_p1_begin", null);
    L30:
        q81.c r29 = t();
        if (r29 == null) goto L33;
        r29.a(getContext().c().id, getContext().a());
    L33:
        getContext().b().put("cmd_p1_widget_start_load", Boolean.TRUE);
        this.k.b.a = true;
        this.l.a(LoadState.P1_BEGIN);
        ToolbarLoadTimeStatsVM.a r30 = ToolbarLoadTimeStatsVM.Companion;
        RoomContext r31 = getContext().d();
        r30.getClass();
        ToolbarLoadTimeStatsVM.a.b(r31).recordTime(ToolbarLoadTimeStatsVM.ROOM_P1_LOAD_START);
        if ((!getContext().r) == false) goto L96;
        long r32 = System.currentTimeMillis();
        getContext().b().put("data_live_interaction_load_p1_ts", Long.valueOf(r32));
        ILinkServiceExternal r1 = jc1.k.f(ILinkServiceExternal.class);
        if (r1 == null) goto L97;
        r1.updateLoad1Ts(r32);
        return;
    L97:
        return;
    L96:
        return;
    L9:
        if (r10 != 4) goto L11;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.e r33 = getContext().p;
        if (r33 == null) goto L23;
        r33.report("widget_load_p2_begin", null);
    L23:
        q81.c r34 = t();
        if (r34 == null) goto L26;
        r34.n(getContext().c().id, getContext().a());
    L26:
        getContext().b().put("cmd_p2_widget_start_load", Boolean.TRUE);
        this.k.c.a = true;
        this.l.a(LoadState.P2_BEGIN);
        return;
    L11:
        if (r10 != 5) goto L101;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.e r35 = getContext().p;
        if (r35 == null) goto L16;
        r35.report("widget_load_p3_begin", null);
    L16:
        q81.c r36 = t();
        if (r36 == null) goto L19;
        r36.b(getContext().c().id, getContext().a());
    L19:
        getContext().b().put("cmd_all_widget_start_load", Boolean.TRUE);
        this.k.d.a = true;
        this.l.a(LoadState.P3_BEGIN);
        int r37 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(getContext().b(), (CompositeDisposable) getContext().d().getCompositeDisposable().getValue(), "InteractionComponentManager#setEnterRoomTime", new l(this));
        return;
    L101:
        return;
    L83:
        if (r9 != null) goto L85;
    L86:
        r0 = true;
    L87:
        getContext().b().put("cmd_fs_widget_start_load", Boolean.TRUE);
        if (r0 == false) goto L90;
    L92:
        this.l.a(LoadState.FS_BEGIN);
        return;
    L90:
        if (this.o < 0) goto L92;
        boolean r38 = fh1.e.a;
        fh1.e.d(getContext().c().getRoomId(), String.valueOf(System.currentTimeMillis() - this.o) + "");
        goto L92
    L85:
        if (r9.isEmpty() == false) goto L87;
        goto L86
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void r(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        this.e = false;
        Fragment r2 = getContext().q;
        Context r0 = getContext().q.getContext();
        if (r0 == null) goto L63;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r14 = ho1.a.i(getContext().d);
        if (r14 == null) goto L61;
        View r15 = r14.getRootView();
        if (r15 == null) goto L61;
        DataCenter r4 = getContext().b();
        RoomContext r1 = getContext().d();
        e0 r3 = getContext().d;
        if (r3 == null) goto L59;
        RecyclableWidgetManager r16 = RecyclableWidgetManager.ga0(r2, r15);
        r16.d = com.bytedance.android.live.core.tetris.widgets.h.c();
        r16.setDataCenter(r4);
        r16.setWidgetConfigHandler(new i2(r1, r4));
        if (getContext().r == false) goto L17;
        IVSPlayerService r5 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r5 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r6 = r5.provideVSPlayerViewControlService(r4);
        if (r6 == null) goto L17;
        r6.i(r16);
    L17:
        this.b = r16;
        com.bytedance.android.live.core.tetris.layer.view.a r7 = new com.bytedance.android.live.core.tetris.layer.view.a();
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r7.c = r3;
        InteractionDelegateConfig r8 = new InteractionDelegateConfig();
        Intrinsics.checkNotNullParameter(r8, "config");
        r7.a = r8;
        LayerEventDispatcher r9 = o70.c.a(Integer.valueOf(r4.hashCode()));
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNullParameter(r9, "layerEventDispatcher");
        r7.d = r9;
        Set r10 = SetsKt.mutableSetOf(new p70.a[]{this.h, this.i, this.j});
        Intrinsics.checkNotNullParameter(r10, "chains");
        r7.l.a = r10;
        ViewModelProvider r11 = ViewModelProviders.of(r2);
        Intrinsics.checkNotNullParameter(r11, "viewModelProvider");
        r7.j = r11;
        ElementBuilderMap r17 = new ElementBuilderMap();
        r17.put(j70.o.class, new com.bytedance.android.live.core.tetris.layer.core.element.widget.a(r16));
        Unit r18 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r17, "map");
        r7.b = r17;
        Object r19 = r1.getTemplateDelegateHolder().getValue();
        if ((r19 instanceof b80.a) == true) goto L20;
        r19 = null;
    L20:
        b80.a r20 = (b80.a) r19;
        r7.i = r7.i;
        com.bytedance.android.livesdk.chatroom.tetris.filter.a r21 = new com.bytedance.android.livesdk.chatroom.tetris.filter.a();
        Intrinsics.checkNotNullParameter(r21, "blockElementFilter");
        r7.f = r21;
        RoomModeElementFilter r22 = new RoomModeElementFilter(r4, r3);
        Intrinsics.checkNotNullParameter(r22, "roomModeElementFilter");
        r7.g = r22;
        nm1.r r23 = pm1.f.o();
        if (r23 == null) goto L23;
        r23.a();
        MultiTabManagerImpl r24 = MultiTabManagerImpl.e;
    L24:
        if (r24 == null) goto L29;
        if (r24.i(r4) != true) goto L29;
        com.bytedance.android.livesdk.vscore_impl.component.tabs.s r25 = t.b.a(r2);
        Intrinsics.checkNotNullParameter(ru2.a.class, "pendingClass");
        Intrinsics.checkNotNullParameter(r25, "handler");
        r7.h.put(ru2.a.class, r25);
        this.q.add(Disposables.fromAction(new m(r24, r2)));
    L29:
        if ((!getContext().r) == true) goto L31;
    L37:
        n r26 = new n(this);
        io1.b r27 = getContext().o;
        if (r27 == null) goto L42;
        io1.b.a r28 = r27.b;
        if (r28 == null) goto L42;
        ArrayList r29 = new ArrayList();
        r29.add(r28);
    L43:
        com.bytedance.android.live.core.tetris.a r30 = com.bytedance.android.live.core.tetris.a.a;
        ComponentManagerFactory.config.1 r31 = com.bytedance.android.live.core.tetris.a.a(r0, r26, r2, r7, r4, "room", r29);
        Intrinsics.checkNotNullParameter(r31, "config");
        this.c = new mg2.a(new ComponentManager(r31));
        if (com.bytedance.android.live.core.tetris.widgets.g.a() == false) goto L51;
        i91 r32 = com.bytedance.android.live.core.tetris.widgets.g.c();
        if (r32 == null) goto L48;
        boolean r33 = r32.h();
    L49:
        if (r33 == false) goto L51;
        boolean r34 = true;
    L52:
        if (r34 == false) goto L54;
        com.bytedance.android.livesdk.widget.monitor.l r35 = new com.bytedance.android.livesdk.widget.monitor.l(getContext().b());
        r16.ia0(r35);
        getContext().b().put("data_live_widget_lifecycle_observers", CollectionsKt.arrayListOf(new com.bytedance.android.livesdk.widget.monitor.l[]{r35}));
    L54:
        e0 r110 = getContext().d;
        if (r110 == null) goto L64;
        ho1.a.p(r110, com.bytedance.android.livesdk.chatroom.ui.framework.a.class, this);
        return;
    L64:
        return;
    L48:
        r33 = false;
    L51:
        r34 = false;
    L42:
        r29 = null;
        goto L43
    L31:
        if (z.h(r4) == false) goto L37;
        ILiveBroadcastSDKService r36 = jc1.k.f(ILiveBroadcastSDKService.class);
        if (r36 == null) goto L37;
        r70.b r37 = r36.getBroadcastMediaElementFilter();
        if (r37 == null) goto L37;
        Intrinsics.checkNotNullParameter(r37, "elementFilter");
        r7.e = r37;
        goto L37
    L23:
        r24 = null;
        goto L24
    L59:
        throw new RuntimeException("componentContext is null!!!");
    L61:
        throw new RuntimeException("rootView is null!!!");
    L63:
        throw new RuntimeException("context is null!!!");
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final <T extends LiveRecyclableWidget> void Cd(Class<T> r2, boolean r3, boolean r4) {
        RecyclableWidgetManager r0 = this.b;
        if (r0 == null) goto L6;
        r0.ea0(r2, r3, r4);
        return;
    }

    public final void Ma(boolean r8, boolean r9, IMultiCameraView.Source r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        jm1.a r0 = u();
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("multi camera, hide widget");
        ComponentManagerABHelper r1 = ComponentManagerABHelper.INSTANCE;
        if (r1.enableRoomSceneScheduler() == true) goto L8;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == true) goto L15;
    L17:
        r0.b(getContext().a, r8, r9, r10, null);
    L18:
        r0.c(new a(this));
        this.n.a(new h80.c(new com.bytedance.android.livesdk.chatroom.ui.framework.o(r8, r9)));
        return;
    L15:
        if (((Boolean) this.k.d.b.a).booleanValue() == true) goto L17;
        r0.b(getContext().a, r8, r9, r10, this.c);
        goto L18
    L8:
        if (r1.enableRoomSceneMerge() == false) goto L12;
        if (this.c == null) goto L12;
        r2 = true;
        goto L13
    }

    public final void X5(boolean r3, boolean r4, IMultiCameraView.Source r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        jm1.a r0 = u();
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("multi camera, reload widget");
        r0.a(getContext().a, r3, r4, r5);
        r0.c(new e(this));
        this.m.a(new h80.c(new com.bytedance.android.livesdk.chatroom.ui.framework.o(r3, r4)));
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final void Zj(Widget r3, boolean r4, boolean r5) {
        RecyclableWidgetManager r0 = this.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (((WidgetManager) r0).widgets.contains(r3) == true) goto L9;
        B(r3);
        r0.load(r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.a
    public final void Ro(int r3, Widget r4, boolean r5, boolean r6) {
        RecyclableWidgetManager r0 = this.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (((WidgetManager) r0).widgets.contains(r4) == true) goto L9;
        B(r4);
        r0.ba0(r3, r4, r5, r6);
        return;
    }
}
