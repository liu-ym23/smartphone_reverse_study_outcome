package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.g0;
import com.bytedance.android.live.core.setting.h0;
import com.bytedance.android.live.core.setting.p2;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.chatroom.viewmodule.EndWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.FirstScreenEndWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.P0EndWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.P1EndWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.P2EndWidget;
import com.bytedance.android.livesdk.config.o91;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdk.widget.schedule.v2.AbsLiveWidgetLoadTaskScheduler;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdk.widgetdescriptor.showstrategy.LiveComponentShowDelegate;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.FirstCompShowConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMockStrategyDescriptorLoadConfig;
import com.bytedance.bpea.cert.token.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class CompatComponentScheduler implements IComponentScheduler {
    public com.bytedance.android.livesdk.chatroom.ui.framework.base.f a;
    public mg2.d b;
    public RecyclableWidgetManager c;
    public e0 d;
    public DataCenter e;
    public RoomContext f;
    public LifecycleOwner g;
    public boolean h;
    public long i;
    public boolean j;
    public Bundle k;
    public h l;
    public IComponentScheduler.a m;
    public boolean n;
    public boolean o;
    public final CompositeDisposable p;
    public EndWidget q;
    public final IComponentScheduler.LoadMode r;
    public final IComponentScheduler.SchedulerType s;
    public final boolean t;

    public final class StrategyHelperLoader implements h, com.bytedance.android.livesdk.widget.schedule.v2.b {
        public final AbsLiveWidgetLoadTaskScheduler a;
        public final com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d b;
        public final /* synthetic */ CompatComponentScheduler c;

        public static final class a implements Runnable {
            public final /* synthetic */ StrategyHelperLoader a;

            public a(StrategyHelperLoader r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CompatComponentScheduler.t(this.a.c);     // Catch: Throwable -> L7
                this.a.c.L(false);     // Catch: Throwable -> L7
                IComponentScheduler.a r0 = this.a.c.m;     // Catch: Throwable -> L7
                if (r0 == null) goto L5;
                r0.e(IComponentScheduler.LoadBatch.POTHER);     // Catch: Throwable -> L7
            L5:
                com.bytedance.android.livesdk.widget.schedule.v2.f.b("load other widget end all");     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ StrategyHelperLoader a;

            public b(StrategyHelperLoader r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CompatComponentScheduler.q(this.a.c);     // Catch: Throwable -> L7
                CompatComponentScheduler.z(this.a.c);     // Catch: Throwable -> L7
                IComponentScheduler.a r0 = this.a.c.m;     // Catch: Throwable -> L7
                if (r0 == null) goto L5;
                r0.e(IComponentScheduler.LoadBatch.P0);     // Catch: Throwable -> L7
            L5:
                com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p0 widget end all");     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public static final class c implements Runnable {
            public final /* synthetic */ StrategyHelperLoader a;

            public c(StrategyHelperLoader r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CompatComponentScheduler.r(this.a.c);     // Catch: Throwable -> L7
                CompatComponentScheduler.A(this.a.c);     // Catch: Throwable -> L7
                IComponentScheduler.a r0 = this.a.c.m;     // Catch: Throwable -> L7
                if (r0 == null) goto L5;
                r0.e(IComponentScheduler.LoadBatch.P1);     // Catch: Throwable -> L7
            L5:
                com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p1 widget end all");     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public static final class d implements Runnable {
            public final /* synthetic */ StrategyHelperLoader a;

            public d(StrategyHelperLoader r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CompatComponentScheduler.s(this.a.c);     // Catch: Throwable -> L7
                CompatComponentScheduler.B(this.a.c);     // Catch: Throwable -> L7
                IComponentScheduler.a r0 = this.a.c.m;     // Catch: Throwable -> L7
                if (r0 == null) goto L5;
                r0.e(IComponentScheduler.LoadBatch.P2);     // Catch: Throwable -> L7
            L5:
                com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p2 widget end all");     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public static final class e<T> implements h80.d {
            public final /* synthetic */ StrategyHelperLoader a;

            public e(StrategyHelperLoader r1) {
                this.a = r1;
            }

            public final Object get() {
                return new com.bytedance.android.livesdk.widget.schedule.v2.c((IRoom) CompatComponentScheduler.p(this.a.c).getRoom().getValue(), ((Boolean) CompatComponentScheduler.p(this.a.c).isUsingEnterRoom().getValue()).booleanValue());
            }
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void j() {
        }

        public final boolean S8() {
            return this.c.E(IComponentScheduler.LoadBatch.P0);
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void a() {
            this.a.M();
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final com.bytedance.android.livesdk.widgetdescriptor.priority.c b() {
            return this.b.b;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void c() {
            this.a.F();
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void e() {
            this.a.I();
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void f() {
            this.a.x();
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void g() {
            this.a.G();
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void h() {
            this.a.K();
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void k() {
            this.a.E();
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void stop() {
            this.a.onDestroy();
            this.b.a.onDestroy();
            CompatComponentScheduler.m(this.c).C8();
        }

        public StrategyHelperLoader(CompatComponentScheduler r11) {
            this.c = r11;
            com.bytedance.android.livesdk.chatroom.ui.framework.base.f r0 = r11.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
        L5:
            com.bytedance.android.livesdk.widgetdescriptor.m r2 = r0.g();
            DataCenter r3 = r11.e;
            if (r3 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
        L8:
            e0 r4 = r11.d;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("componentContext");
        L11:
            com.bytedance.android.livesdk.chatroom.ui.framework.base.f r1 = r11.a;
            if (r1 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
        L14:
            boolean r5 = r1.g().l;
            com.bytedance.android.livesdk.chatroom.ui.framework.base.f r6 = r11.a;
            if (r6 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
        L17:
            lw2.a r7 = new lw2.a(r2, r3, r4, r5, r6.g().m);
            mg2.d r8 = r11.b;
            if (r8 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        L20:
            Intrinsics.checkNotNullParameter(r8, "componentManager");
            com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d r9 = new com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d(r7.b, r7.e, r8);
            final AbsLiveWidgetLoadTaskScheduler r10 = r7.a(this, new e(this));
            DataCenter r12 = r11.e;
            if (r12 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
        L23:
            r10.g = r12;
            e0 r13 = r11.d;
            if (r13 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("componentContext");
        L26:
            DataCenter r14 = r11.e;
            if (r14 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
        L29:
            LifecycleOwner r15 = r11.g;
            if (r15 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        L32:
            Intrinsics.checkNotNullParameter(r13, "layerContext");
            LiveComponentShowDelegate r16 = new LiveComponentShowDelegate(r7.d, r13, r14);
            if (r15 == null) goto L37;
            Lifecycle r17 = r15.getLifecycle();
            if (r17 == null) goto L37;
            r17.addObserver(r16);
        L37:
            RoomContext r18 = r11.f;
            if (r18 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("roomContext");
        L40:
            r18.getWidgetLoadTaskScheduler().c(new AnonymousClass1(r10));
            this.a = r10;
            this.b = r9;
        }

        public final void CM(IRoom r2) {
            Intrinsics.checkNotNullParameter(r2, "room");
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child immediately p1 widget start");
            CompatComponentScheduler.y(this.c);
        }

        public final void XZ(IRoom r2) {
            Intrinsics.checkNotNullParameter(r2, "room");
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("update p0 Wigdet");
        }

        public final void bL(IRoom r3) {
            Intrinsics.checkNotNullParameter(r3, "room");
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child other widget start");
            IComponentScheduler.a r4 = this.c.m;
            if (r4 == null) goto L5;
            r4.d(IComponentScheduler.LoadBatch.POTHER, null);
        L5:
            CompatComponentScheduler.x(this.c);
            this.b.a(new a(this));
        }

        public final void mf(IRoom r3) {
            Intrinsics.checkNotNullParameter(r3, "room");
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child p2 widget start");
            IComponentScheduler.a r4 = this.c.m;
            if (r4 == null) goto L5;
            r4.d(IComponentScheduler.LoadBatch.P2, null);
        L5:
            CompatComponentScheduler.w(this.c);
            this.b.d(new d(this));
        }

        public final void pr(IRoom r2) {
            Intrinsics.checkNotNullParameter(r2, "room");
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("onRoomEnterSuccess");
        }

        public final void uF(IRoom r3) {
            Intrinsics.checkNotNullParameter(r3, "room");
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child p1 widget start");
            IComponentScheduler.a r4 = this.c.m;
            if (r4 == null) goto L5;
            r4.d(IComponentScheduler.LoadBatch.P1, null);
        L5:
            CompatComponentScheduler.v(this.c);
            this.b.c(new c(this));
        }

        public final void qx(IRoom r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "room");
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child p0 widget start");
            IComponentScheduler.a r4 = this.c.m;
            if (r4 == null) goto L5;
            r4.d(IComponentScheduler.LoadBatch.P0, null);
        L5:
            CompatComponentScheduler.u(this.c);
            this.b.b(new b(this));
        }
    }

    public static final class a {
    }

    public final class b implements h, com.bytedance.android.live.core.tetris.componentx.schedule.q {
        public final com.bytedance.android.live.core.tetris.componentx.schedule.j a;
        public final LinkedHashMap<f70.b, LayerDescriptorList> b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public final /* synthetic */ CompatComponentScheduler g;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CompatComponentScheduler.m(this.a.g).e();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void a() {
            this.c = false;
            this.d = false;
            mg2.d r2 = CompatComponentScheduler.m(this.g);
            com.bytedance.android.live.core.tetris.componentx.schedule.c r3 = new com.bytedance.android.live.core.tetris.componentx.schedule.c(false, this.g.F());
            ComponentSchedulingManager.ScenInfo r4 = m();
            LinkedHashMap<f70.b, LayerDescriptorList> r5 = this.b;
            e0 r6 = this.g.d;
            if (r6 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("componentContext");
        L5:
            r2.g(r3, r4, r5, r6, this.a, this);
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final /* synthetic */ com.bytedance.android.livesdk.widgetdescriptor.priority.c b() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final /* synthetic */ void c() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void e() {
            this.c = true;
            this.d = false;
            mg2.d r2 = CompatComponentScheduler.m(this.g);
            com.bytedance.android.live.core.tetris.componentx.schedule.c r3 = new com.bytedance.android.live.core.tetris.componentx.schedule.c(true, this.g.F());
            ComponentSchedulingManager.ScenInfo r4 = m();
            LinkedHashMap<f70.b, LayerDescriptorList> r5 = this.b;
            e0 r6 = this.g.d;
            if (r6 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("componentContext");
        L5:
            r2.g(r3, r4, r5, r6, this.a, this);
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final /* synthetic */ void f() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final /* synthetic */ void g() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void h() {
            this.d = true;
            n("loadContinue");
            MainThreadPostUtils.b(new a(this));
        }

        public final void i() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final /* synthetic */ void k() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void j() {
            ALogger.i("AsyncTaskManager", "start startBatchLoading");
            CompatComponentScheduler r1 = this.g;
            if (r1.r == IComponentScheduler.LoadMode.DIRECT) goto L5;
        L7:
            boolean r2 = true;
        L8:
            mg2.d r3 = r1.b;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("componentManager");
        L11:
            r3.c5(new com.bytedance.android.live.core.tetris.componentx.schedule.c(r2, this.g.F()), this);
            ALogger.i("AsyncTaskManager", "end startBatchLoading");
            return;
        L5:
            if (r1.t == true) goto L7;
            r2 = false;
            goto L8
        }

        public final ComponentSchedulingManager.ScenInfo m() {
            if (((Boolean) CompatComponentScheduler.p(this.g).isAnchor().getValue()).booleanValue() == false) goto L6;
            return ComponentSchedulingManager.ScenInfo.ANCHOR;
        L6:
            if (((Boolean) CompatComponentScheduler.p(this.g).isPortraitInteraction().getValue()).booleanValue() == true) goto L9;
            return ComponentSchedulingManager.ScenInfo.AUDIENCE_LANDSCAPE;
        L9:
            return ComponentSchedulingManager.ScenInfo.AUDIENCE_PORTRAIT;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.h
        public final void stop() {
            CompatComponentScheduler.m(this.g).C8();
        }

        public b(CompatComponentScheduler r11) {
            this.g = r11;
            IDynamicStrategyContext r0 = (IDynamicStrategyContext) CompatComponentScheduler.p(r11).getDynamicStrategy().getValue();
            if (r0 == null) goto L9;
            PropertyOwner<ju1.n> r1 = r0.getStrategy("live_component_strategy");
            if (r1 == null) goto L9;
            ju1.n r2 = (ju1.n) r1.a;
            if (r2 == null) goto L9;
            int r3 = r2.b(0);
        L10:
            ALogger.d("CompatComponentScheduler", "本次命中的策略是: " + r3);
            p2 r4 = p2.a;
            if (((LiveMockStrategyDescriptorLoadConfig) r4.getValue()).getEnable() == true) goto L13;
        L22:
            Map r5 = null;
            if (((Boolean) g0.a.getValue()).booleanValue() == false) goto L42;
            if (r3 != 0) goto L42;
            if (CompatComponentScheduler.p(r11).isVSRoom() == true) goto L42;
            if (CompatComponentScheduler.p(r11).isMediaRoom() == true) goto L42;
            if (((Boolean) CompatComponentScheduler.p(r11).isAnchor().getValue()).booleanValue() == true) goto L42;
            DataCenter r6 = CompatComponentScheduler.n(r11);
            if (r6 == null) goto L34;
            String r7 = (String) r6.get("log_action_type", "");
        L36:
            if (Intrinsics.areEqual(r7, LiveActionType.CLICK.getValue()) == false) goto L39;
            r3 = 81;
        L41:
            ALogger.d("CompatComponentScheduler", "atcionType = " + r7 + " strategyResult = " + r3 + ' ');
            goto L42
        L39:
            if (Intrinsics.areEqual(r7, LiveActionType.DRAW.getValue()) == false) goto L41;
            r3 = 75;
            goto L41
        L34:
            r7 = null;
        L42:
            ALogger.i("CompatComponentScheduler", "最终执行的策略是 " + r3);
            com.bytedance.android.live.core.tetris.componentx.schedule.j r8 = new com.bytedance.android.live.core.tetris.componentx.schedule.j();
            h0 r9 = h0.a;
            if (r9.getValue() == null) goto L55;
            Map r10 = (Map) r9.getValue();
            if (r10 == null) goto L47;
            com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.g r12 = (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.g) r10.get(String.valueOf(r3));
        L48:
            if (r12 == null) goto L50;
            o91 r13 = r12.b();
        L51:
            if (r12 == null) goto L53;
            r5 = r12.a();
        L53:
            if (r13 == null) goto L55;
            LinkedHashMap r14 = new LinkedHashMap();
            r14.put(0, Long.valueOf(r13.b()));
            r14.put(1, Long.valueOf(r13.c()));
            r14.put(2, Long.valueOf(r13.d()));
            r14.put(3, Long.valueOf(r13.a()));
            r8.b = r14;
            r8.c = r5;
            r8.a = r3;
            ALogger.d("CompatComponentScheduler", "p0_delay: " + r13.b() + "   p1_delay: " + r13.c() + ' ');
            goto L55
        L50:
            r13 = null;
            goto L51
        L47:
            r12 = null;
        L55:
            this.a = r8;
            com.bytedance.android.livesdk.chatroom.ui.framework.base.f r15 = r11.a;
            if (r15 != null) goto L58;
            Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
        L58:
            this.b = r15.l();
            return;
        L13:
            if (((Boolean) CompatComponentScheduler.p(r11).isPortraitInteraction().getValue()).booleanValue() == false) goto L18;
            if (((LiveMockStrategyDescriptorLoadConfig) r4.getValue()).getMockPortrait() == 0) goto L18;
            r3 = ((LiveMockStrategyDescriptorLoadConfig) r4.getValue()).getMockPortrait();
        L18:
            if (((Boolean) CompatComponentScheduler.p(r11).isPortraitInteraction().getValue()).booleanValue() == true) goto L22;
            if (((LiveMockStrategyDescriptorLoadConfig) r4.getValue()).getMockLandscape() == 0) goto L22;
            r3 = ((LiveMockStrategyDescriptorLoadConfig) r4.getValue()).getMockLandscape();
        L9:
            r3 = 0;
            goto L10
        }

        public final void n(String r4) {
            if (this.g.o == false) goto L5;
        L14:
            boolean r0 = false;
        L15:
            if (r0 == false) goto L18;
            com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("load ImmediatelyP1, source is ".concat(r4));
            this.f = true;
            CompatComponentScheduler.y(this.g);
            return;
        L18:
            return;
        L5:
            if (this.f == true) goto L14;
            boolean r1 = this.c;
            if (r1 == true) goto L9;
        L12:
            if (r1 == true) goto L14;
        L13:
            r0 = true;
            goto L15
        L9:
            if (this.d == false) goto L12;
            if (this.e == true) goto L13;
            goto L12
        }

        public final void d(f70.b r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "batchKey");
            StringBuilder r0 = new StringBuilder("layerType = ");
            if (r3 == null) goto L5;
            String r5 = r3.a;
        L6:
            r0.append(r5);
            r0.append("  batchKey = ");
            r0.append(r4);
            ALogger.i("CompatComponentScheduler", r0.toString());
            if (TextUtils.equals(r4, "0") == false) goto L13;
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child p0 widget start");
            IComponentScheduler.a r6 = this.g.m;
            if (r6 == null) goto L11;
            r6.d(IComponentScheduler.LoadBatch.P0, null);
        L11:
            CompatComponentScheduler.u(this.g);
            return;
        L13:
            if (TextUtils.equals(r4, "1") == false) goto L19;
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child p1 widget start");
            IComponentScheduler.a r7 = this.g.m;
            if (r7 == null) goto L17;
            r7.d(IComponentScheduler.LoadBatch.P1, null);
        L17:
            CompatComponentScheduler.v(this.g);
            return;
        L19:
            if (TextUtils.equals(r4, "2") == false) goto L25;
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child p2 widget start");
            IComponentScheduler.a r8 = this.g.m;
            if (r8 == null) goto L23;
            r8.d(IComponentScheduler.LoadBatch.P2, null);
        L23:
            CompatComponentScheduler.w(this.g);
            return;
        L25:
            if (TextUtils.equals(r4, "3") == false) goto L34;
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child p3 widget start");
            IComponentScheduler.a r9 = this.g.m;
            if (r9 == null) goto L29;
            r9.d(IComponentScheduler.LoadBatch.POTHER, null);
        L29:
            CompatComponentScheduler.x(this.g);
            return;
        L34:
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void l(f70.b r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "batchKey");
            StringBuilder r0 = new StringBuilder("layerType = ");
            if (r3 == null) goto L5;
            String r5 = r3.a;
        L6:
            r0.append(r5);
            r0.append("  batchKey = ");
            r0.append(r4);
            ALogger.i("CompatComponentScheduler", r0.toString());
            if (TextUtils.equals(r4, "0") == false) goto L13;
            CompatComponentScheduler.q(this.g);
            CompatComponentScheduler.z(this.g);
            IComponentScheduler.a r6 = this.g.m;
            if (r6 == null) goto L11;
            r6.e(IComponentScheduler.LoadBatch.P0);
        L11:
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p0 widget end all");
            this.e = true;
            n("endLoadBatch");
            return;
        L13:
            if (TextUtils.equals(r4, "1") == false) goto L18;
            CompatComponentScheduler.r(this.g);
            CompatComponentScheduler.A(this.g);
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p1 widget end all");
            IComponentScheduler.a r7 = this.g.m;
            if (r7 == null) goto L29;
            r7.e(IComponentScheduler.LoadBatch.P1);
            return;
        L29:
            return;
        L18:
            if (TextUtils.equals(r4, "2") == false) goto L23;
            CompatComponentScheduler.s(this.g);
            CompatComponentScheduler.B(this.g);
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p2 widget end all");
            IComponentScheduler.a r8 = this.g.m;
            if (r8 == null) goto L31;
            r8.e(IComponentScheduler.LoadBatch.P2);
            return;
        L31:
            return;
        L23:
            if (TextUtils.equals(r4, "3") == false) goto L33;
            CompatComponentScheduler.t(this.g);
            this.g.L(false);
            com.bytedance.android.livesdk.widget.schedule.v2.f.b("load other widget end all");
            IComponentScheduler.a r9 = this.g.m;
            if (r9 == null) goto L34;
            r9.e(IComponentScheduler.LoadBatch.POTHER);
            return;
        L34:
            return;
        L33:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CompatComponentScheduler a;

        public c(CompatComponentScheduler r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclableWidgetManager r0 = this.a.c;     // Catch: Throwable -> L7
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("widgetManager");     // Catch: Throwable -> L7
        L5:
            r0.load(2131371661, this.a.q);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ CompatComponentScheduler a;
        public final /* synthetic */ Observer b;

        public d(CompatComponentScheduler r1, e r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            CompatComponentScheduler.n(this.a).removeObserver(this.b);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ CompatComponentScheduler a;

        public e(CompatComponentScheduler r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            KVData r9 = (KVData) r8;
            if (this.a.o == true) goto L74;
            Long r0 = null;
            if (r9 == null) goto L8;
            String r1 = r9.getKey();
        L9:
            if (r1 != null) goto L12;
            return;
        L12:
            switch(r1.hashCode()) {
                case -1836833765: goto L52;
                case -1575056762: goto L46;
                case -67504953: goto L40;
                case 748530103: goto L21;
                case 1440046856: goto L15;
                default: goto L76;
            };
        L76:
            return;
        L15:
            if (r1.equals("cmd_p2_widget_loaded") == false) goto L60;
            IComponentScheduler.a r10 = this.a.m;
            if (r10 == null) goto L19;
            r10.b(IComponentScheduler.LoadBatch.P2);
        L19:
            CompatComponentScheduler.C(this.a, "load batched, call onP2Loaded");
            CompatComponentScheduler.o(this.a).k();
            return;
        L60:
            return;
        L21:
            if (r1.equals("cmd_userinfo_widget_show") == false) goto L62;
            boolean r2 = TextUtils.equals("click", (CharSequence) CompatComponentScheduler.n(this.a).get("log_action_type", ""));
            if (FirstCompShowConfig.INSTANCE.isPreloadInPlay() == false) goto L25;
            return;
        L25:
            if (this.a.i <= 0) goto L64;
            if (r2 == false) goto L65;
            Boolean r3 = Boolean.FALSE;
            Boolean r11 = (Boolean) r9.getData(r3);
            if (r11 == null) goto L32;
            r3 = r11;
        L32:
            if (r3.booleanValue() == false) goto L66;
            com.bytedance.live.datacontext.m r12 = CompatComponentScheduler.p(this.a).getRoom();
            if (r12 == null) goto L38;
            Room r13 = (Room) r12.getValue();
            if (r13 == null) goto L38;
            r0 = Long.valueOf(r13.getRoomId());
        L38:
            long r4 = r0.longValue();
            boolean r14 = fh1.e.a;
            fh1.e.e(r4, String.valueOf(System.currentTimeMillis() - this.a.i));
            return;
        L66:
            return;
        L65:
            return;
        L64:
            return;
        L62:
            return;
        L40:
            if (r1.equals("cmd_p1_widget_loaded") == false) goto L68;
            IComponentScheduler.a r15 = this.a.m;
            if (r15 == null) goto L44;
            r15.b(IComponentScheduler.LoadBatch.P1);
        L44:
            CompatComponentScheduler.C(this.a, "load batched, call onP1Loaded");
            CompatComponentScheduler.o(this.a).g();
            return;
        L68:
            return;
        L46:
            if (r1.equals("cmd_p0_widget_loaded") == false) goto L70;
            IComponentScheduler.a r16 = this.a.m;
            if (r16 == null) goto L50;
            r16.b(IComponentScheduler.LoadBatch.P0);
        L50:
            CompatComponentScheduler.C(this.a, "load batched, call onP0Loaded");
            CompatComponentScheduler.o(this.a).f();
            return;
        L70:
            return;
        L52:
            if (r1.equals("cmd_widget_loaded") == true) goto L54;
            return;
        L54:
            if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r9) == false) goto L73;
            IComponentScheduler.a r17 = this.a.m;
            if (r17 == null) goto L58;
            r17.b(IComponentScheduler.LoadBatch.POTHER);
        L58:
            CompatComponentScheduler.C(this.a, "load batched, call onAllLoaded");
            CompatComponentScheduler.o(this.a).c();
            return;
        L73:
            return;
        L8:
            r1 = null;
            goto L9
        }
    }

    public static final class f<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ CompatComponentScheduler a;

        public f(CompatComponentScheduler r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            CompatComponentScheduler.C(this.a, "load batched, call loadContinue");
            CompatComponentScheduler.o(this.a).h();
        }
    }

    public static final class g implements Action {
        public final /* synthetic */ CompatComponentScheduler a;
        public final /* synthetic */ CompatComponentScheduler$tryLoadEndWidget$listener$1 b;

        public g(CompatComponentScheduler r1, CompatComponentScheduler$tryLoadEndWidget$listener$1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            CompatComponentScheduler.n(this.a).removeObserver(this.b);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.base.CompatComponentScheduler$release$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(CompatComponentScheduler r7) {
            super(r7, CompatComponentScheduler.class, "realScheduler", "getRealScheduler()Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/IComponentLoader;", 0);
        }

        public Object get() {
            return CompatComponentScheduler.o((CompatComponentScheduler) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            h r3 = (h) r2;
            ((CompatComponentScheduler) ((CallableReference) this).receiver).l = r3;
        }
    }

    static {
    }

    public final boolean F() {
        int r0 = com.bytedance.android.live.core.tetris.componentx.schedule.a.a;
        RoomContext r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("roomContext");
    L5:
        boolean r2 = ((Boolean) r1.isAnchor().getValue()).booleanValue();
        if (this.s != IComponentScheduler.SchedulerType.COMPONENT_X_SCHEDULER) goto L8;
        boolean r3 = true;
    L9:
        RoomContext r4 = this.f;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("roomContext");
    L13:
        return com.bytedance.android.live.core.tetris.componentx.schedule.a.a(r2, r3, r4.isVSOrMedia());
    L8:
        r3 = false;
        goto L9
    }

    public final boolean G() {
        if (E(IComponentScheduler.LoadBatch.P0) == true) goto L6;
        return true;
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("load batched components, schedulerType is " + this.s + ", loadMode is " + this.r);
        if (this.s != IComponentScheduler.SchedulerType.COMPONENT_X_SCHEDULER) goto L9;
        h r0 = new b(this);
    L10:
        this.l = r0;
        return false;
    L9:
        r0 = new StrategyHelperLoader(this);
        goto L10
    }

    public final void H() {
        if (this.j == true) goto L12;
        RecyclableWidgetManager r0 = this.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L7:
        DataCenter r2 = this.e;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L10:
        r0.load(new FirstScreenEndWidget(lu2.c.f(r2).getId(), this.i, this.k));
        this.j = true;
        return;
    }

    public final void I() {
        e r0 = new e(this);
        DataCenter r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        r1.observeForever("cmd_p0_widget_loaded", r0);
        DataCenter r2 = this.e;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L8:
        r2.observeForever("cmd_userinfo_widget_show", r0);
        DataCenter r3 = this.e;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L11:
        r3.observeForever("cmd_p1_widget_loaded", r0);
        DataCenter r4 = this.e;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L14:
        r4.observeForever("cmd_p2_widget_loaded", r0);
        DataCenter r5 = this.e;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L17:
        r5.observeForever("cmd_widget_loaded", r0);
        this.p.add(Disposables.fromAction(new d(this, r0)));
    }

    public final void J() {
        DataCenter r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        p0 r1 = (p0) r0.get("zygote_event_hub", null);
        if (r1 == null) goto L14;
        MutableLiveData r2 = r1.getP0WidgetLoaded();
        if (r2 == null) goto L15;
        LifecycleOwner r3 = this.g;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
    L12:
        r2.observe(r3, new f(this));
        return;
    L15:
        return;
    }

    public final void K() {
        IComponentScheduler.LoadMode r0 = this.r;
        int r1 = com.bytedance.android.livesdk.chatroom.ui.framework.base.b.b[r0.ordinal()];
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L33;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("load batched, call loadPartly");
        h r2 = this.l;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("realScheduler");
    L10:
        r2.e();
        if (this.n == false) goto L29;
        h r3 = this.l;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("realScheduler");
    L15:
        r3.h();
        return;
    L29:
        return;
    L33:
        return;
    L17:
        if (this.t == false) goto L24;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("load batched, call loadPartly");
        h r4 = this.l;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("realScheduler");
    L21:
        r4.e();
        if (F() == true) goto L31;
        J();
        return;
    L31:
        return;
    L24:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("load batched, call loadDirectly");
        h r5 = this.l;
        if (r5 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("realScheduler");
    L27:
        r5.a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void a() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("startLoadPreloadComponents");
        IComponentScheduler.LoadBatch r0 = IComponentScheduler.LoadBatch.PRELOAD;
        if (E(r0) == false) goto L36;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r1 = this.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L8:
        LayerDescriptorList r2 = r1.getPreload();
        StringBuilder r3 = new StringBuilder("load preload components, size is ");
        if (r2 == null) goto L11;
        Integer r4 = Integer.valueOf(r2.size());
    L12:
        r3.append(r4);
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b(r3.toString());
        IComponentScheduler.a r5 = this.m;
        if (r5 == null) goto L16;
        r5.d(r0, r2);
    L16:
        if (r2 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L29;
        mg2.d r7 = this.b;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L26:
        mg2.b.a(r7, r2, true, true, 8);
        H();
        IComponentScheduler.a r8 = this.m;
        if (r8 == null) goto L33;
        r8.e(r0);
        return;
    L33:
        return;
    L29:
        IComponentScheduler.a r9 = this.m;
        if (r9 == null) goto L35;
        r9.e(r0);
        return;
    L35:
        return;
    L18:
        if (r2.isEmpty() == true) goto L21;
        r6 = false;
        goto L22
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final com.bytedance.android.livesdk.widgetdescriptor.priority.c b() {
        h r0 = this.l;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("realScheduler");
    L6:
        return r0.b();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void c() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("startStateMachineLoading");
        h r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realScheduler");
    L5:
        r0.j();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void d() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("startLoadBaseComponents");
        IComponentScheduler.LoadBatch r0 = IComponentScheduler.LoadBatch.BASE;
        if (E(r0) == false) goto L35;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r1 = this.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L8:
        LayerDescriptorList r2 = r1.a();
        StringBuilder r3 = new StringBuilder("load base components, size is ");
        if (r2 == null) goto L11;
        Integer r4 = Integer.valueOf(r2.size());
    L12:
        r3.append(r4);
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b(r3.toString());
        IComponentScheduler.a r5 = this.m;
        if (r5 == null) goto L16;
        r5.d(r0, r2);
    L16:
        if (r2 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L27;
        mg2.d r7 = this.b;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L26:
        r7.L3(r2, false, false, false);
    L27:
        IComponentScheduler.a r8 = this.m;
        if (r8 == null) goto L30;
        r8.e(r0);
    L30:
        IComponentScheduler.a r9 = this.m;
        if (r9 == null) goto L34;
        r9.b(r0);
        return;
    L34:
        return;
    L18:
        if (r2.isEmpty() == true) goto L21;
        r6 = false;
        goto L22
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void e() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("startLoadFirstScreenComponents");
        IComponentScheduler.LoadBatch r0 = IComponentScheduler.LoadBatch.FIRST_SCREEN;
        if (E(r0) == false) goto L42;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r1 = this.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L8:
        LayerDescriptorList r2 = r1.h();
        StringBuilder r3 = new StringBuilder("load first screen components, size is ");
        if (r2 == null) goto L11;
        Integer r4 = Integer.valueOf(r2.size());
    L12:
        r3.append(r4);
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b(r3.toString());
        IComponentScheduler.a r5 = this.m;
        if (r5 == null) goto L16;
        r5.d(r0, r2);
    L16:
        if (r2 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L32;
        com.bytedance.android.livesdk.chatroom.ui.framework.base.d r7 = new com.bytedance.android.livesdk.chatroom.ui.framework.base.d(this);
        DataCenter r8 = this.e;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L26:
        r8.observeForever("cmd_fs_widget_loaded", r7);
        this.p.add(Disposables.fromAction(new com.bytedance.android.livesdk.chatroom.ui.framework.base.c(this, r7)));
        mg2.d r9 = this.b;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L29:
        mg2.b.a(r9, r2, true, true, 8);
        H();
        IComponentScheduler.a r10 = this.m;
        if (r10 == null) goto L39;
        r10.e(r0);
        return;
    L39:
        return;
    L32:
        IComponentScheduler.a r11 = this.m;
        if (r11 == null) goto L35;
        r11.e(r0);
    L35:
        IComponentScheduler.a r12 = this.m;
        if (r12 == null) goto L41;
        r12.b(r0);
        return;
    L41:
        return;
    L18:
        if (r2.isEmpty() == true) goto L21;
        r6 = false;
        goto L22
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void g() {
        RecyclableWidgetManager r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L5:
        r0.unload(this.q);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void i() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("stopLoadComponents");
        this.o = true;
        h r0 = this.l;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("realScheduler");
    L6:
        r0.stop();
    L7:
        this.p.dispose();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void j() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("startObserveBatchLoad");
        IComponentScheduler.LoadMode r0 = this.r;
        if (com.bytedance.android.livesdk.chatroom.ui.framework.base.b.a[r0.ordinal()] == 1) goto L6;
    L8:
        I();
        return;
    L6:
        if (this.t == false) goto L8;
        J();
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void k() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("startLoadBatchComponents");
        if (F() == false) goto L9;
        if (G() == true) goto L14;
        K();
        ALogger.i("AsyncTaskManager", "end tryLoadBatchesComponentWithSyncScheduler");
        return;
    L14:
        return;
    L9:
        if (G() == true) goto L15;
        I();
        K();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void l() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("continueLoadBatchComponents");
        if (this.r == IComponentScheduler.LoadMode.PREVIEW) goto L5;
        return;
    L5:
        if (this.l == null) goto L10;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("load batched, call loadContinue");
        h r0 = this.l;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("realScheduler");
    L9:
        r0.h();
        return;
    L10:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("load batched, call loadContinue but realScheduler not init");
        this.n = true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void release() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b(BuildConfig.BUILD_TYPE);
        this.o = true;
        h r0 = this.l;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("realScheduler");
    L6:
        r0.stop();
    L7:
        this.p.dispose();
    }

    public static final void A(CompatComponentScheduler r2) {
        r2.getClass();
        ALogger.d("CompatComponentScheduler", "loadP1EndWidget");
        RecyclableWidgetManager r3 = r2.c;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L5:
        r3.load(2131371661, new P1EndWidget());
    }

    public static final void B(CompatComponentScheduler r2) {
        r2.getClass();
        ALogger.d("CompatComponentScheduler", "loadP2EndWidget");
        RecyclableWidgetManager r3 = r2.c;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L5:
        r3.load(2131371661, new P2EndWidget());
    }

    public static final /* synthetic */ mg2.d m(CompatComponentScheduler r1) {
        mg2.d r2 = r1.b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L5:
        return r2;
    }

    public static final /* synthetic */ DataCenter n(CompatComponentScheduler r1) {
        DataCenter r2 = r1.e;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        return r2;
    }

    public static final /* synthetic */ h o(CompatComponentScheduler r1) {
        h r2 = r1.l;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realScheduler");
    L5:
        return r2;
    }

    public static final /* synthetic */ RoomContext p(CompatComponentScheduler r1) {
        RoomContext r2 = r1.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("roomContext");
    L5:
        return r2;
    }

    public static final void q(CompatComponentScheduler r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r0 = r3.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L5:
        LayerDescriptorList r1 = r0.c();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L18;
        mg2.d r4 = r3.b;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L16:
        mg2.b.a(r4, r1, false, false, 14);
        return;
    L18:
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public static final void r(CompatComponentScheduler r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r0 = r3.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L5:
        LayerDescriptorList r1 = r0.d();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L18;
        mg2.d r4 = r3.b;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L16:
        mg2.b.a(r4, r1, false, false, 14);
        return;
    L18:
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public static final void s(CompatComponentScheduler r1) {
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r2 = r1.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L5:
        r2.e();
    }

    public static final void t(CompatComponentScheduler r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r0 = r3.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L5:
        LayerDescriptorList r1 = r0.b();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L18;
        mg2.d r4 = r3.b;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L16:
        mg2.b.a(r4, r1, false, false, 14);
        return;
    L18:
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public static final void u(CompatComponentScheduler r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r0 = r3.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L5:
        LayerDescriptorList r1 = r0.k();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L18;
        mg2.d r4 = r3.b;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L16:
        mg2.b.a(r4, r1, false, false, 14);
        return;
    L18:
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public static final void v(CompatComponentScheduler r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r0 = r3.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L5:
        LayerDescriptorList r1 = r0.j();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L18;
        mg2.d r4 = r3.b;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L16:
        mg2.b.a(r4, r1, false, false, 14);
        return;
    L18:
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public static final void w(CompatComponentScheduler r1) {
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r2 = r1.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L5:
        r2.i();
    }

    public static final void x(CompatComponentScheduler r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r0 = r3.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L5:
        LayerDescriptorList r1 = r0.m();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L18;
        mg2.d r4 = r3.b;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L16:
        mg2.b.a(r4, r1, false, false, 14);
        return;
    L18:
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public static final void y(CompatComponentScheduler r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r0 = r3.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descriptorList");
    L5:
        LayerDescriptorList r1 = r0.f();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L18;
        mg2.d r4 = r3.b;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("componentManager");
    L16:
        mg2.b.a(r4, r1, false, false, 14);
        return;
    L18:
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public static final void z(CompatComponentScheduler r3) {
        r3.getClass();
        ALogger.d("CompatComponentScheduler", "loadP0EndWidget");
        RecyclableWidgetManager r4 = r3.c;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L5:
        r4.load(2131371661, new P0EndWidget(), false);
    }

    public final boolean E(IComponentScheduler.LoadBatch r5) {
        if (this.o == false) goto L6;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("loadBatch[" + r5 + "] checkCanLoad failed, reason is hasStoped.");
        return false;
    L6:
        RoomContext r0 = this.f;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("roomContext");
    L10:
        if (r0.isCleared() == false) goto L13;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("loadBatch[" + r5 + "] checkCanLoad failed, reason is roomContext.isCleared.");
        return false;
    L13:
        return true;
    }

    public final void L(boolean r6) {
        if (this.h == false) goto L17;
        nm1.r r0 = pm1.f.o();
        if (r0 == null) goto L17;
        r0.a();
        MultiTabManagerImpl r1 = MultiTabManagerImpl.e;
        DataCenter r3 = this.e;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L9:
        boolean r2 = r1.h(r3);
        boolean r4 = true;
        if (r2 != true) goto L17;
        DataCenter r5 = this.e;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L14:
        Boolean r7 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r5.get("match_tab_all_loaded", r7), r7) == false) goto L17;
    L18:
        if (r4 == false) goto L23;
        androidx.lifecycle.Observer r8 = new CompatComponentScheduler$tryLoadEndWidget$listener$1(this);
        DataCenter r9 = this.e;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L22:
        r9.observe("match_tab_all_loaded", r8);
        this.p.add(Disposables.fromAction(new g(this, r8)));
        return;
    L23:
        h(r6);
        return;
    L17:
        r4 = false;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void f(InteractionComponentManager r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.m = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler
    public final void h(boolean r3) {
        ALogger.d("CompatComponentScheduler", "loadEndWidget");
        EndWidget r0 = new EndWidget();
        this.q = r0;
        r0.a = r3;
        if (k60.b.e() == false) goto L8;
        RecyclableWidgetManager r4 = this.c;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L7:
        r4.g.b = new c(this);
        return;
    L8:
        RecyclableWidgetManager r5 = this.c;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L11:
        r5.load(2131371661, this.q);
    }

    public static final void C(CompatComponentScheduler r0, String r1) {
        r0.getClass();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b(r1);
    }

    public CompatComponentScheduler(IComponentScheduler.LoadMode r2, IComponentScheduler.SchedulerType r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "loadMode");
        Intrinsics.checkNotNullParameter(r3, "schedulerType");
        this.r = r2;
        this.s = r3;
        this.t = r4;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("CompatComponentScheduler init, LoadMode is 【" + r2 + "】, schedulerType is 【" + r3 + 12305);
        this.i = -1;
        this.p = new CompositeDisposable();
    }

    public final void D(com.bytedance.android.livesdk.chatroom.ui.framework.base.a r3, com.bytedance.android.livesdk.chatroom.ui.framework.base.f r4, RecyclableWidgetManager r5, mg2.d r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "descriptorList");
        Intrinsics.checkNotNullParameter(r5, "widgetManager");
        Intrinsics.checkNotNullParameter(r6, "componentManager");
        e0 r0 = r3.d;
        if (r0 == null) goto L23;
        this.d = r0;
        DataCenter r1 = r3.b();
        if (r1 == null) goto L21;
        this.e = r1;
        RoomContext r2 = r3.d();
        if (r2 == null) goto L19;
        this.f = r2;
        Fragment r7 = r3.q;
        if (r7 == null) goto L17;
        this.g = r7;
        this.h = r3.a;
        this.k = r3.a();
        Bundle r8 = r3.a();
        if (r8 == null) goto L13;
        long r9 = r8.getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME");
    L14:
        this.i = r9;
        this.a = r4;
        this.b = r6;
        this.c = r5;
        return;
    L13:
        r9 = -1;
        goto L14
    L17:
        throw new RuntimeException("CompatComponentScheduler params is null!!!!");
    L19:
        throw new RuntimeException("CompatComponentScheduler params is null!!!!");
    L21:
        throw new RuntimeException("CompatComponentScheduler params is null!!!!");
    L23:
        throw new RuntimeException("CompatComponentScheduler params is null!!!!");
    }
}
