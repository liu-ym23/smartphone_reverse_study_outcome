package com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.perf.f;
import com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.biz.service.d;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.model.o0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.scope.m;
import cy0.e;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleAudienceOtherComponent implements d {
    public final CompositeDisposable a;
    public long b;
    public final String c;
    public long d;
    public long e;
    public final b f;
    public final DoubleAudienceBizDataContext g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ DoubleAudienceOtherComponent a;

        public a(DoubleAudienceOtherComponent r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            DoubleAudienceOtherComponent r0 = this.a;
            r0.onEvent((Integer) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudienceOtherComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(DoubleAudienceOtherComponent r8) {
            super(0, r8, DoubleAudienceOtherComponent.class, "onUserClose", "onUserClose()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m906invoke() {
            ((DoubleAudienceOtherComponent) ((CallableReference) this).receiver).getContext().getCommonService().f();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m906invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudienceOtherComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass3(DoubleAudienceOtherComponent r8) {
            super(0, r8, DoubleAudienceOtherComponent.class, "onResume", "onResume()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m907invoke() {
            DoubleAudienceOtherComponent r0 = (DoubleAudienceOtherComponent) ((CallableReference) this).receiver;
            if (r0.d <= 0) goto L6;
            long r1 = r0.e;
            i97.a r5 = i97.a.a;
            r0.e = r1 + (System.currentTimeMillis() - r0.d);
            r0.d = 0;
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m907invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudienceOtherComponent$attach$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass4(DoubleAudienceOtherComponent r8) {
            super(0, r8, DoubleAudienceOtherComponent.class, "onPause", "onPause()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m908invoke() {
            DoubleAudienceOtherComponent r0 = (DoubleAudienceOtherComponent) ((CallableReference) this).receiver;
            r0.getClass();
            i97.a r1 = i97.a.a;
            r0.d = System.currentTimeMillis();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m908invoke();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        w31.a r0 = i.j(this);
        if (r0.a == false) goto L5;
        r0.b = r0.c;
        r0.c = 0;
    L6:
        r0.d = 2;
        Intrinsics.checkNotNullParameter(this, "$this$livePkLogger");
        h41.d r1 = i.getContext(this).hb();
        r1.getClass();
        i97.a r2 = i97.a.a;
        System.currentTimeMillis();
        c r3 = r1.b;
        w31.c r4 = null;
        if (r3 == null) goto L9;
        LinkCrossRoomDataHolder r5 = r3.getLinkCrossRoomDataHolder();
    L10:
        c r6 = r1.b;
        if (r6 == null) goto L13;
        r4 = r6.getPkLinkUtils();
    L13:
        if (r4 == null) goto L15;
        r4.a();
    L15:
        if (r5 == null) goto L17;
        r5.i();
    L17:
        PkScopeProviderService r7 = i.W(this).a;
        if (r7 == null) goto L20;
        r7.c();
    L20:
        this.b = System.currentTimeMillis();
        boolean r8 = false;
        getContext().getRoomDataCenterService().n4(false);
        f.c("pk");
        getContext().getRoomDataCenterService().B4("7");
        t41.a r9 = t41.a.m;
        r9.getClass();
        o0 r10 = (o0) t41.a.g.getValue(r9, t41.a.a[5]);
        Intrinsics.checkNotNullParameter(r10, "$this$isOpenSmoothClose");
        if (r10.getTotalSwitch() == true) goto L23;
    L25:
        if (r8 == false) goto L27;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.h(getContext().getLinkDataSet().F1(), new AnonymousClass1(this)), this.a);
    L27:
        e.a.getClass();
        j r12 = e.a.a;
        m.e.getClass();
        Object r13 = m.b(r12).b(IRevBroadcastService.class);
        Intrinsics.checkNotNull(r13);
        Observable r14 = ((com.bytedance.live.kmp.core.c) r13).W5();
        if (r14 == null) goto L32;
        Disposable r15 = r14.subscribe(new a(this));
        if (r15 == null) goto L32;
        com.bytedance.revenue.platform.api.core.rx.f.a(r15, this.a);
    L32:
        com.bytedance.android.live.revlink.impl.service.internal.a r16 = i.p(this);
        if (r16 != null) goto L35;
    L37:
        getContext().x7(new AnonymousClass3(this), new AnonymousClass4(this));
        com.bytedance.android.live.revlink.impl.pk.scope.service.b.a();
        return;
    L35:
        if (r16.dc() != true) goto L37;
        this.d = System.currentTimeMillis();
        goto L37
    L23:
        if (r10.S4() == false) goto L25;
        r8 = true;
        goto L25
    L9:
        r5 = null;
        goto L10
    L5:
        i97.a r17 = i97.a.a;
        r0.b = System.currentTimeMillis();
        r0.e = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        com.bytedance.android.live.revlink.impl.pk.scope.service.a r2 = null;
        jy0.b.f(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "LinkCrossRoomAudienceWidget onDestroy", null, 4);
        Disposable r0 = this.g.b.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        PkScopeProviderService r1 = i.W(this).a;
        if (r1 == null) goto L28;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3 = r1.a();
        if (r3 == null) goto L12;
        LiveData<PkBaseStateMachine.c> r4 = r3.getPkBaseState();
        if (r4 == null) goto L12;
        r4.removeObserver(r1.e);
    L12:
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r5 = r1.i.getPkUtils().g();
        if (r5 == null) goto L17;
        LiveData<IBaseUser> r6 = r5.getGuestUser();
        if (r6 == null) goto L17;
        r6.removeObserver(r1.f);
    L17:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r7 = r1.a();
        if (r7 == null) goto L22;
        LiveData<Long> r8 = r7.getBaseTimeLeft();
        if (r8 == null) goto L22;
        r8.removeObserver(r1.g);
    L22:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r9 = r1.a();
        if (r9 == null) goto L27;
        LiveData<String> r10 = r9.getBattleEffectInfo();
        if (r10 == null) goto L27;
        r10.removeObserver(r1.h);
    L27:
        r1.a.postValue(q11.b.a.b);
        r1.b.postValue(null);
    L28:
        this.a.clear();
        i.j(this).getClass();
        if (this.d <= 0) goto L31;
        long r12 = this.e;
        i97.a r13 = i97.a.a;
        this.e = r12 + (System.currentTimeMillis() - this.d);
        this.d = 0;
    L31:
        long r14 = this.e;
        if (i.j(this).b <= 0) goto L34;
        long r15 = i.j(this).b;
    L36:
        if (r15 == 0) goto L55;
        LinkedHashMap r16 = new LinkedHashMap();
        i97.a r17 = i97.a.a;
        long r18 = System.currentTimeMillis() - r15;
        if (r18 <= r14) goto L41;
        r18 = r18 - r14;
    L41:
        if (r18 <= i.j(this).e) goto L43;
        r18 = r18 - i.j(this).e;
    L43:
        long r19 = WebcastRedirectException.UNKNOWN;
        if (r18 >= r19) goto L46;
        r16.put("watch_connection_duration", String.valueOf(r18 / 1000.0f));
    L47:
        r16.put("connection_type", "anchor");
        r16.put("anchor_cnt", "2");
        r16.put("anchor_connect_status", "2");
        r16.put("linkmic_scene", String.valueOf(1));
        i.F(this).h(r16);
        r16.put("user_id", String.valueOf(i.Y(this).e()));
        r16.put("channel_id", String.valueOf(getContext().G()));
        b r20 = getContext();
        if (r20 == null) goto L53;
        com.bytedance.android.live.revlink.impl.pk.service.f r22 = r20.Aa();
        if (r22 == null) goto L53;
        String r23 = r22.getConnectSource();
        if (r23 == null) goto L53;
    L54:
        r16.put("live_source", r23);
        n r24 = new n();
        Map<String, String> r25 = r24.a;
        Intrinsics.checkNotNullParameter(r25, "map");
        Intrinsics.checkNotNullParameter(r16, "map");
        r25.putAll(r16);
        mz0.m r26 = new mz0.m();
        i.m(this).m(r26);
        r26.b(LogCommon.ROOM);
        r26.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r24.b).addAll(r26.a);
        e.a.getClass();
        j r27 = e.a.a;
        m.e.getClass();
        Object r28 = m.b(r27).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r28);
        ((mz0.i) ((f80.a) r28)).w3("livesdk_connection_watch_duration", r24.a, r24.b);
    L53:
        r23 = "";
        goto L54
    L46:
        r16.put("watch_connection_duration", String.valueOf(r18 / r19));
    L55:
        w31.a r29 = i.j(this);
        i.j(this).getClass();
        r29.b = 0;
        r29.e = 0;
        r29.a = false;
        getContext().getRoomDataCenterService().n4(true);
        getContext().getRoomDataCenterService().z7();
        getContext().getLinkDataSet().h4().setValue("");
        getContext().getLinkDataSet().Cb().setValue(Boolean.FALSE);
        getContext().getRoomDataCenterService().bj(false);
        RevLinkWindowRegionContext r30 = i.c0(this);
        if (r30 == null) goto L58;
        r30.onLinkDestroy();
    L58:
        Intrinsics.checkNotNullParameter(this, "$this$pkAudienceLoadService");
        IPkAudienceLoadService r32 = i.getContext(this).Ik();
        if (r32 == null) goto L61;
        r32.reset();
    L61:
        f.c("default");
        m r33 = m.e;
        r33.getClass();
        cy0.f r34 = r33.a(m.d, cy0.f.class);
        if (r34 == null) goto L64;
        r2 = (com.bytedance.android.live.revlink.impl.pk.scope.service.a) r33.d(r34, com.bytedance.android.live.revlink.impl.pk.scope.service.a.class);
    L64:
        if (r2 == null) goto L71;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r35 = r2.a;
        if (r35 == null) goto L72;
        LiveData<List<cf2.a>> r36 = r35.getBaseScoreState();
        if (r36 == null) goto L73;
        r36.removeObserver(r2.e);
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L34:
        r15 = this.b;
        goto L36
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.c;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public b getContext() {
        return this.f;
    }

    public final void onEvent(Integer r4) {
        if (r4 == null) goto L10;
        r4.intValue();
        if (r4.intValue() != 30) goto L7;
        Intrinsics.checkNotNullParameter(this, "$this$linkCrossRoomLogger");
        i.getContext(this).Nl().getClass();
        h41.a.a("background");
        getContext().im().a(getContext().eg(), false);
        return;
    L7:
        if (r4.intValue() != 31) goto L12;
        Intrinsics.checkNotNullParameter(this, "$this$linkCrossRoomLogger");
        i.getContext(this).Nl().getClass();
        h41.a.a("suspend");
        getContext().im().a(getContext().eg(), true);
        return;
    L12:
        return;
    }

    public DoubleAudienceOtherComponent(b r2, DoubleAudienceBizDataContext r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bizDataContext");
        this.f = r2;
        this.g = r3;
        this.a = new CompositeDisposable();
        this.c = "DoubleAudienceOtherComponent";
    }
}
