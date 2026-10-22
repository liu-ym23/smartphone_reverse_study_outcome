package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.n;
import com.bytedance.android.live.core.utils.b0;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revenuelink.h;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkAudienceOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.impl.pk.scope.service.MultiPkScopeProviderService;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKContextHolder;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage;
import com.bytedance.android.livesdk.link.model.g6;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import or2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiAudienceOtherComponent implements com.bytedance.android.live.revlink.link.biz.service.d {
    public final String a;
    public final CompositeDisposable b;
    public int c;
    public boolean d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b j;
    public final yz0.f k;
    public final MultiAnchorLinkContext l;
    public final ld.a m;
    public final com.bytedance.android.live.revlink.impl.pk.scope.service.a n;
    public final MultiPkScopeProviderService o;
    public final c p;
    public final MultiPKContextHolder q;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MultiAudienceOtherComponent a;

        public a(MultiAudienceOtherComponent r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MultiAudienceOtherComponent r0 = this.a;
            r0.onEvent((Integer) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceOtherComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<List<? extends p>, Integer, Unit> {
        public AnonymousClass1(MultiAudienceOtherComponent r8) {
            super(2, r8, MultiAudienceOtherComponent.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends p> r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "p1");
            MultiAudienceOtherComponent r12 = (MultiAudienceOtherComponent) ((CallableReference) this).receiver;
            r12.getClass();
            r12.c = r9.size();
            i.j(r12).d = r12.c;
            if (r12.d == false) goto L72;
            m<String> r13 = r12.l.getConnectionSource();
            w31.a r0 = i.j(r12);
            com.bytedance.android.live.revlink.impl.control.launchcontext.b r1 = i.E(r12);
            if (r1 == null) goto L7;
            com.bytedance.android.live.revlink.impl.audience.c r2 = r1.b;
        L8:
            if (r2 == null) goto L54;
            com.bytedance.android.live.revlink.impl.global.c r3 = r0.f;
            if (r3 == null) goto L12;
            LinkRevInternalServiceContext r4 = r3.Cj();
        L13:
            if (r4 == null) goto L17;
            j<AnchorLinkUserCenterV2> r5 = r4.getLinkUserCenter();
            if (r5 == null) goto L17;
            AnchorLinkUserCenterV2 r6 = (AnchorLinkUserCenterV2) r5.getValue();
        L18:
            ArrayList r7 = new ArrayList();
            if (r6 == null) goto L29;
            List<p> r8 = r6.a;
            if (r8 == null) goto L29;
            Iterator r14 = ((CopyOnWriteArrayList) r8).iterator();
        L24:
            if (r14.hasNext() == false) goto L29;
            IBaseUser r15 = ((p) r14.next()).getUser();
            if (r15 == null) goto L24;
            r7.add(Long.valueOf(n.a(r15)));
        L29:
            if ((r2 instanceof com.bytedance.android.live.revlink.impl.audience.c.a) == false) goto L31;
            String r16 = "transform";
        L56:
            r13.setValue(r16);
            i.j(r12).getClass();
            i.j(r12).a((String) r12.l.getConnectionSource().getValue(), null);
            r12.d = false;
            return;
        L31:
            Iterator r17 = r7.iterator();
        L33:
            if (r17.hasNext() == false) goto L55;
            long r18 = ((Number) r17.next()).longValue();
            if (r18 <= 0) goto L33;
            com.bytedance.android.live.revlink.impl.global.c r19 = r0.f;
            if (r19 == null) goto L39;
            s r20 = r19.getRevLinkCommonUtil();
        L40:
            if (r20 == null) goto L43;
            if (r18 == r20.d()) goto L33;
        L43:
            String r22 = String.valueOf(r18);
            mz0.e<?> r23 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
            if ((r23 instanceof mz0.f) == true) goto L46;
            r23 = null;
        L46:
            mz0.f r24 = (mz0.f) r23;
            if (r24 == null) goto L50;
            String r25 = r24.b();
            if (r25 == null) goto L50;
        L52:
            if (Intrinsics.areEqual(r22, r25) == false) goto L33;
            r16 = "link_guide";
        L50:
            r25 = "";
            goto L52
        L39:
            r20 = null;
        L55:
            r16 = DataType.Normal;
        L17:
            r6 = null;
            goto L18
        L12:
            r4 = null;
            goto L13
        L54:
            r0.getClass();
            goto L55
        L7:
            r2 = null;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((List) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceOtherComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PkBaseStateMachine.c, Unit> {
        public AnonymousClass2(MultiAudienceOtherComponent r8) {
            super(1, r8, MultiAudienceOtherComponent.class, "onPkStateChange", "onPkStateChange(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$State;)V", 0);
        }

        public final void invoke(PkBaseStateMachine.c r5) {
            MultiAudienceOtherComponent r0 = (MultiAudienceOtherComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r5 == null) goto L18;
            LinkedHashMap r1 = new LinkedHashMap();
            if ((r5 instanceof PkBaseStateMachine.c.C0130c) == false) goto L15;
            r1.put("pk_status", DataType.TRUE);
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = i.S(r0);
            if (r6 == null) goto L13;
            LiveData<Long> r7 = r6.getBaseTimeLeft();
            if (r7 == null) goto L13;
            Long r8 = (Long) r7.getValue();
            if (r8 == null) goto L13;
        L14:
            r1.put("pkleft_time", String.valueOf(r8.longValue()));
        L16:
            mz0.n r9 = new mz0.n();
            Map<String, String> r2 = r9.a;
            Intrinsics.checkNotNullParameter(r2, "map");
            Intrinsics.checkNotNullParameter(r1, "map");
            r2.putAll(r1);
            mz0.m r3 = new mz0.m();
            r3.b(LogCommon.ROOM);
            List<Object> r4 = r9.b;
            ArrayList r10 = (ArrayList) r4;
            r10.addAll(r3.a);
            cy0.e.a.getClass();
            cy0.j r12 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r13);
            ((mz0.i) ((f80.a) r13)).w3("livesdk_transfer_pk_context", r9.a, r9.b);
            return;
        L13:
            r8 = -1L;
            goto L14
        L15:
            r1.put("pk_status", DataType.FALSE);
            goto L16
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((PkBaseStateMachine.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceOtherComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass3(MultiAudienceOtherComponent r8) {
            super(0, r8, MultiAudienceOtherComponent.class, "onChannelIDChange", "onChannelIDChange()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m865invoke() {
            MultiAudienceOtherComponent r0 = (MultiAudienceOtherComponent) ((CallableReference) this).receiver;
            r0.getClass();
            com.bytedance.android.live.revlink.impl.service.internal.a r1 = i.p(r0);
            if (r1 != null) goto L5;
        L9:
            r0.a(r0.g, "2");
            i.j(r0).a((String) r0.l.getConnectionSource().getValue(), Long.valueOf(r0.getContext().G()));
            w31.a r2 = i.j(r0);
            i97.a r5 = i97.a.a;
            r2.c = System.currentTimeMillis();
            r0.g = 0;
            r0.f = 0;
            com.bytedance.android.live.revlink.impl.service.internal.a r3 = i.p(r0);
            if (r3 != null) goto L12;
            return;
        L12:
            if (r3.dc() != true) goto L16;
            r0.f = System.currentTimeMillis();
            return;
        L16:
            return;
        L5:
            if (r1.dc() != true) goto L9;
            if (r0.f <= 0) goto L9;
            long r6 = r0.g;
            i97.a r4 = i97.a.a;
            r0.g = r6 + (System.currentTimeMillis() - r0.f);
            r0.f = 0;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m865invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceOtherComponent$attach$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass4(MultiAudienceOtherComponent r8) {
            super(0, r8, MultiAudienceOtherComponent.class, "onResume", "onResume()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m866invoke() {
            MultiAudienceOtherComponent r0 = (MultiAudienceOtherComponent) ((CallableReference) this).receiver;
            if (r0.f <= 0) goto L5;
            long r1 = r0.g;
            i97.a r5 = i97.a.a;
            r0.g = r1 + (System.currentTimeMillis() - r0.f);
            r0.f = 0;
        L5:
            r0.q.c.getBasePKContext().onResume();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m866invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceOtherComponent$attach$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass5(MultiAudienceOtherComponent r8) {
            super(0, r8, MultiAudienceOtherComponent.class, "onPause", "onPause()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m867invoke() {
            MultiAudienceOtherComponent r0 = (MultiAudienceOtherComponent) ((CallableReference) this).receiver;
            if (IRoomKtKt.getStreamType(r0.getContext().getRoom()) == LiveMode.SCREEN_RECORD) goto L7;
            i97.a r1 = i97.a.a;
            r0.f = System.currentTimeMillis();
            r0.q.c.getBasePKContext().onPause();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m867invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceOtherComponent$detach$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/vm/a;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/multianchor/vm/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class C03701 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.revlink.impl.multianchor.vm.a, Unit> {
        public C03701(MultiAudienceOtherComponent r8) {
            super(1, r8, MultiAudienceOtherComponent.class, "onAnchorLeave", "onAnchorLeave(Lcom/bytedance/android/live/revlink/impl/multianchor/vm/AnchorLeaveEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.live.revlink.impl.multianchor.vm.a r4) {
            Intrinsics.checkNotNullParameter(r4, "p1");
            MultiAudienceOtherComponent r0 = (MultiAudienceOtherComponent) ((CallableReference) this).receiver;
            r0.getClass();
            IBaseUser r1 = r4.a.getUser();
            if (r1 != null) goto L5;
            return;
        L5:
            if (r0.q.c.getBasePKContext().getCurPKBaseState().b() == false) goto L12;
            g6 r5 = r4.b;
            if (r5 != null) goto L9;
        L11:
            int r6 = ToastUtil.a;
            com.bytedance.live.kmp.util.c r7 = com.bytedance.live.kmp.util.c.a;
            int r8 = w11.a.a;
            ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131914785, new Object[]{r1.getNickName()}), 0);
            return;
        L9:
            if (r5.getLeaveSource() != 1) goto L11;
            return;
        L12:
            r0.q.c.handleUserLeave(r1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.revlink.impl.multianchor.vm.a) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.i = false;
        this.b.clear();
        getContext().getRoomDataCenterService().P1(true);
        PublishSubject r1 = this.l.getAnchorLeave().onEvent();
        final C03701 r2 = new C03701(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r1.subscribe(new b(r2)), this.b);
        jy0.b.f("ttlive_anchor_link", "MultiLinkAudienceWidget onDestroy", null, 4);
        if (i.j(this).a == false) goto L5;
    L8:
        Disposable r3 = this.p.b.b;
        if (r3 == null) goto L11;
        r3.dispose();
    L11:
        w31.a r4 = i.j(this);
        boolean r5 = i.j(this).a;
        long r7 = this.g;
        if (r5 == true) goto L14;
        r4.c = 0;
        r4.e = 0;
    L15:
        r4.getClass();
        MultiEnterRoomTracer r6 = i.F(this);
        r6.getClass();
        jy0.b.f("MultiEnterRoomTracer", "reset source=" + r6.a, null, 4);
        r6.a = null;
        r6.f = 0;
        r6.g = 0;
        r6.h = 0;
        r6.j = 0;
        r6.k = 0;
        r6.z = false;
        r6.A = Boolean.FALSE;
        r6.i = 0;
        r6.l = 0;
        r6.m = 0;
        r6.n = 0;
        r6.o = 0;
        r6.x = 0;
        r6.r = false;
        r6.s = false;
        r6.w = MultiEnterRoomTracer.FirstSeiType.Empty;
        r6.u = false;
        r6.e = 0;
        r6.y = 0;
        r6.v = null;
        r6.b = 0;
        r6.c = 0;
        r6.d = 0;
        r6.p = 0;
        r6.q = 0;
        this.o.Ek();
        com.bytedance.android.live.revlink.impl.perf.f.c("default");
        com.bytedance.android.live.revlink.impl.pk.scope.service.a r0 = this.n;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r8 = r0.c;
        if (r8 == null) goto L20;
        LiveData<List<af2.b>> r9 = r8.getScoreState();
        if (r9 == null) goto L20;
        r9.removeObserver(r0.d);
    L20:
        RevLinkWindowRegionContext r10 = i.c0(this);
        if (r10 == null) goto L23;
        r10.onLinkDestroy();
    L23:
        i.A(this).a();
        return;
    L14:
        r4.e += r7;
        goto L15
    L5:
        if (this.f <= 0) goto L7;
        long r12 = this.g;
        i97.a r13 = i97.a.a;
        this.g = r12 + (System.currentTimeMillis() - this.f);
        this.f = 0;
    L7:
        a(this.g, null);
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        this.i = true;
        MultiEnterRoomTracer r2 = i.F(this);
        r2.getClass();
        i97.a r3 = i97.a.a;
        r2.g = System.currentTimeMillis();
        StringBuilder r4 = new StringBuilder("multiLinkLoaded source=");
        r4.append(r2.a);
        r4.append(' ');
        com.bytedance.android.live.revlink.impl.global.c r5 = r2.C;
        if (r5 == null) goto L5;
        AnchorLinkAudienceOptUtils r6 = r5.a3();
    L6:
        if (r6 == null) goto L8;
        StringBuilder r7 = new StringBuilder("EnterRoomOpt: switch=");
        r7.append(((Boolean) r6.a.getValue()).booleanValue());
        r7.append(' ');
        r11.a r8 = (r11.a) r6.b.getValue();
        Intrinsics.checkNotNullParameter(r8, "$this$formatString");
        StringBuilder r9 = new StringBuilder("AnchorLinkEnterRoomOptConfig{");
        r9.append("sync_load=" + r8.Y5() + ',');
        r9.append("preload_list=" + r8.q5() + ',');
        StringBuilder r10 = new StringBuilder("delay_load_widget=");
        r10.append(r8.v4());
        r9.append(r10.toString());
        r9.append("}");
        r7.append(r9.toString());
        String r12 = r7.toString();
    L9:
        r4.append(r12);
        jy0.b.f("MultiEnterRoomTracer", r4.toString(), null, 4);
        r2.r = false;
        w31.a r13 = i.j(this);
        r13.getClass();
        r13.c = System.currentTimeMillis();
        long r14 = 0;
        r13.e = 0;
        StringBuilder r15 = new StringBuilder("MultiLinkAudienceWidget onCreate channelId:");
        com.bytedance.android.live.revlink.impl.control.launchcontext.b r16 = i.E(this);
        if (r16 == null) goto L12;
        long r17 = r16.a;
    L13:
        r15.append(r17);
        r15.append(" sei: ");
        jy0.b.c("ttlive_anchor_link", r15.toString(), null, 4);
        com.bytedance.revenue.platform.api.core.rx.f.a(i.t(this).m(new AnonymousClass1(this)), this.b);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r18 = i.S(this);
        if (r18 == null) goto L20;
        LiveData<PkBaseStateMachine.c> r19 = r18.getPkBaseState();
        if (r19 == null) goto L20;
        Disposable r20 = UtilsKt.d(r19, new AnonymousClass2(this));
        if (r20 == null) goto L20;
        com.bytedance.revenue.platform.api.core.rx.f.a(r20, this.b);
    L20:
        this.e = System.currentTimeMillis();
        getContext().getRoomDataCenterService().P1(false);
        ld.a r22 = this.m;
        MultiEnterRoomTracer r23 = i.F(this);
        Long r110 = (Long) r22.Cn().getValue();
        Long r111 = 0L;
        if (r110 != null) goto L23;
        r110 = r111;
    L23:
        r23.b = r110.longValue();
        MultiEnterRoomTracer r24 = i.F(this);
        Long r112 = (Long) r22.Md().getValue();
        if (r112 != null) goto L26;
        r112 = r111;
    L26:
        r24.c = r112.longValue();
        MultiEnterRoomTracer r25 = i.F(this);
        Long r26 = (Long) r22.u3().getValue();
        if (r26 == null) goto L30;
        r111 = r26;
    L30:
        r25.d = r111.longValue();
        MultiEnterRoomTracer r27 = i.F(this);
        r27.getClass();
        r27.h = System.currentTimeMillis();
        jy0.b.f("MultiEnterRoomTracer", "multiLinkCreated source=" + r27.a, null, 4);
        r27.g();
        com.bytedance.android.live.revlink.impl.perf.f.c("multi_linker");
        com.bytedance.android.live.revlink.impl.pk.scope.service.a r28 = this.n;
        r28.a = r28.g.Ig();
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r29 = r28.g.Q1();
        r28.c = r29;
        if (r29 == null) goto L35;
        LiveData<List<af2.b>> r30 = r29.getScoreState();
        if (r30 == null) goto L35;
        r30.observeForever(r28.d);
    L35:
        com.bytedance.android.live.revlink.impl.service.internal.a r32 = i.p(this);
        if (r32 != null) goto L38;
    L40:
        this.o.a();
        getContext().getRoomDataCenterService().B4("8");
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.h(getContext().bo(), new AnonymousClass3(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(getContext().x7(new AnonymousClass4(this), new AnonymousClass5(this)), this.b);
        cy0.e.a.getClass();
        cy0.j r33 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r34 = com.bytedance.android.scope.m.b(r33).b(IRevBroadcastService.class);
        Intrinsics.checkNotNull(r34);
        Observable r35 = ((com.bytedance.live.kmp.core.c) r34).W5();
        if (r35 == null) goto L45;
        Disposable r36 = r35.subscribe(new a(this));
        if (r36 == null) goto L45;
        com.bytedance.revenue.platform.api.core.rx.f.a(r36, this.b);
    L45:
        com.bytedance.android.live.revlink.impl.control.launchcontext.b r37 = i.E(this);
        if (r37 == null) goto L48;
        com.bytedance.android.live.revlink.impl.audience.c r38 = r37.b;
    L49:
        com.bytedance.android.live.revlink.impl.settings.live.c r39 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r39.getClass();
        long r40 = ((Number) com.bytedance.android.live.revlink.impl.settings.live.c.r.getValue(r39, com.bytedance.android.live.revlink.impl.settings.live.c.a[16])).longValue();
        final String r42 = (String) this.m.h4().getValue();
        if (r42 != null) goto L53;
        r42 = "";
    L53:
        if (r42.length() <= 0) goto L55;
        boolean r113 = true;
    L56:
        if (r113 == false) goto L59;
        MultiEnterRoomTracer r114 = i.F(this);
        r114.getClass();
        r114.w = MultiEnterRoomTracer.FirstSeiType.InnerSei;
    L59:
        if (r40 != 0) goto L61;
    L100:
        p0.a(0, false, true, new AnonymousClass7(this, r42), 3);
        m<Boolean> r1 = this.l.getChangeScreenEvent();
        b03.a r43 = b03.a.a;
        r1.setValue(Boolean.valueOf(b03.a.c()));
        getContext().getLinkDataSet().h4().setValue("");
        b0.a(this.l.getChangeScreenEvent(), new AnonymousClass8(this));
        getContext().getRoomDataCenterService().z7();
        return;
    L61:
        if ((r38 instanceof com.bytedance.android.live.revlink.impl.audience.c.b) == false) goto L100;
        if (StringsKt.contains$default(r42, "app_data", false, 2, null) == true) goto L100;
        Object r44 = com.bytedance.android.scope.m.b(r33).b(or2.d.class);
        Intrinsics.checkNotNull(r44);
        k r45 = ((com.bytedance.live.kmp.core.c) r44).v5();
        if (r45 != null) goto L68;
        i.F(this).y = 10002;
        goto L100
    L68:
        long r115 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r45, "$this$tsLong");
        String r116 = r45.a;
        if (r116 == null) goto L74;
        Long r117 = StringsKt.toLongOrNull(r116);
        if (r117 == null) goto L74;
        r14 = r117.longValue();
    L74:
        if ((r115 - r14) < r40) goto L76;
        i.F(this).y = 10001;
        goto L100
    L76:
        RevSeiFrame r46 = (RevSeiFrame) getContext().lb().getValue();
        if (r46 == null) goto L79;
        com.bytedance.android.livesdk.model.p0 r47 = r46.b();
    L80:
        if (r47 == null) goto L82;
        i.F(this).s = true;
    L82:
        String r48 = r45.b;
        if (r48 != null) goto L85;
    L87:
        MultiEnterRoomTracer r49 = i.F(this);
        if (r48 != null) goto L90;
        r49.v = "";
        r49.y = 10005;
        goto L100
    L90:
        r49.v = r48;
        if (StringsKt.contains$default(r48, "TTLiveSDK_Android", false, 2, null) == false) goto L93;
    L98:
        long r50 = 10003;
    L99:
        r49.y = r50;
        goto L100
    L93:
        if (StringsKt.contains$default(r48, "TTLiveSDK_IOS", false, 2, null) == true) goto L98;
        if (StringsKt.contains$default(r48, "TTLiveSDK_Windows", false, 2, null) == true) goto L98;
        r50 = 10004;
        goto L99
    L85:
        if (StringsKt.contains$default(r48, "app_data", false, 2, null) != true) goto L87;
        MultiEnterRoomTracer r52 = i.F(this);
        r52.getClass();
        r52.w = MultiEnterRoomTracer.FirstSeiType.PlayerSei;
        r42 = r48;
        goto L100
    L79:
        r47 = null;
        goto L80
    L55:
        r113 = false;
        goto L56
    L48:
        r38 = null;
        goto L49
    L38:
        if (r32.dc() != true) goto L40;
        this.f = System.currentTimeMillis();
        goto L40
    L12:
        r17 = 0;
        goto L13
    L8:
        r12 = null;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    public final void b() {
        if (this.h == 0) goto L24;
        LinkedHashMap r0 = new LinkedHashMap();
        i97.a r1 = i97.a.a;
        r0.put("link_game_name_duration_landscape", String.valueOf((System.currentTimeMillis() - this.h) / ((long) WebcastRedirectException.UNKNOWN)));
        r0.put("connection_type", "anchor");
        r0.put("anchor_cnt", String.valueOf(this.c));
        r0.put("anchor_connect_status", "2");
        r0.put("from_multi_anchor", DataType.TRUE);
        r0.put("linkmic_scene", String.valueOf(7));
        i.F(this).h(r0);
        String r2 = ((h) this.l.getAudienceUnloadSource().getValue()).toString();
        String r4 = "";
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r0.put("unload_source", r2);
        r0.put("user_id", String.valueOf(i.Y(this).e()));
        String r3 = String.valueOf(((Number) this.l.getChannelId().getValue()).longValue());
        if (r3 == null) goto L11;
        r4 = r3;
    L11:
        r0.put("channel_id", r4);
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r5 = getContext();
        if (r5 == null) goto L23;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r6 = r5.U7();
        if (r6 == null) goto L23;
        Map<String, String> r7 = r6.getCurrentTrackInfo();
        if (r7 == null) goto L23;
        if ((!r7.isEmpty()) == false) goto L23;
        Iterator<T> r8 = r7.keySet().iterator();
    L21:
        if (r8.hasNext() == false) goto L23;
        String r9 = (String) r8.next();
        r0.put(r9, String.valueOf(r7.get(r9)));
    L23:
        mz0.n r10 = new mz0.n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r12.putAll(r0);
        mz0.m r13 = new mz0.m();
        i.m(this).m(r13);
        r13.b(LogCommon.ROOM);
        r13.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r10.b).addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_cg_pk_game_landscape_duration", r10.a, r10.b);
    L24:
        this.h = 0;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b getContext() {
        return this.j;
    }

    public final void onEvent(Integer r10) {
        if (r10 == null) goto L18;
        r10.intValue();
        String r3 = "";
        if (r10.intValue() != 30) goto L11;
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("interact_function", "anchor_connect");
        r12.put("anchor_status", "background");
        mz0.n r0 = new mz0.n();
        Map<String, String> r2 = r0.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r12, "map");
        r2.putAll(r12);
        mz0.m r13 = new mz0.m();
        r13.b(LogCommon.PAGE_SOURCE_LOG);
        r13.b(LogCommon.ROOM);
        List<Object> r4 = r0.b;
        ArrayList r5 = (ArrayList) r4;
        r5.addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_anchor_suspend_reminder_show", r0.a, r0.b);
        com.bytedance.android.live.revlink.link.domain.anchorimpl.m r16 = getContext().im();
        String r1 = getContext().eg();
        Intrinsics.checkNotNullParameter(r1, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r1, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r1, "$this$linkerID");
        String r6 = com.bytedance.android.live.revlink.link.biz.service.j.a.a(this, r1);
        if (r6 == null) goto L9;
        r3 = r6;
    L9:
        r16.a(r3, false);
        return;
    L11:
        if (r10.intValue() != 31) goto L20;
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("interact_function", "anchor_connect");
        r17.put("anchor_status", "suspend");
        mz0.n r7 = new mz0.n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r17, "map");
        r8.putAll(r17);
        mz0.m r18 = new mz0.m();
        r18.b(LogCommon.PAGE_SOURCE_LOG);
        r18.b(LogCommon.ROOM);
        List<Object> r9 = r7.b;
        ArrayList r19 = (ArrayList) r9;
        r19.addAll(r18.a);
        cy0.e.a.getClass();
        cy0.j r110 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r111 = com.bytedance.android.scope.m.b(r110).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r111);
        ((mz0.i) ((f80.a) r111)).w3("livesdk_anchor_suspend_reminder_show", r7.a, r7.b);
        com.bytedance.android.live.revlink.link.domain.anchorimpl.m r112 = getContext().im();
        String r20 = getContext().eg();
        Intrinsics.checkNotNullParameter(r20, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r20, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r20, "$this$linkerID");
        String r22 = com.bytedance.android.live.revlink.link.biz.service.j.a.a(this, r20);
        if (r22 == null) goto L16;
        r3 = r22;
    L16:
        r112.a(r3, true);
        return;
    L20:
        return;
    }

    public final void a(long r6, String r8) {
        if (i.j(this).c <= 0) goto L5;
        long r0 = i.j(this).c;
    L7:
        if (r0 == 0) goto L53;
        LinkedHashMap r2 = new LinkedHashMap();
        i97.a r3 = i97.a.a;
        long r4 = System.currentTimeMillis() - r0;
        if (r4 <= r6) goto L12;
        r4 = r4 - r6;
    L12:
        if (r4 <= i.j(this).e) goto L14;
        r4 = r4 - i.j(this).e;
    L14:
        long r7 = WebcastRedirectException.UNKNOWN;
        if (r4 >= r7) goto L17;
        r2.put("watch_connection_duration", String.valueOf(r4 / 1000.0f));
    L18:
        r2.put("connection_type", "anchor");
        r2.put("anchor_cnt", String.valueOf(this.c));
        if (r8 != null) goto L24;
        int r9 = this.c;
        if (r9 > 1) goto L23;
        r8 = "2";
        goto L24
    L23:
        r8 = String.valueOf(r9);
    L24:
        r2.put("anchor_connect_status", r8);
        r2.put("from_multi_anchor", DataType.TRUE);
        r2.put("linkmic_scene", String.valueOf(7));
        i.F(this).h(r2);
        String r10 = ((h) this.l.getAudienceUnloadSource().getValue()).toString();
        String r12 = "";
        if (r10 != null) goto L27;
        r10 = "";
    L27:
        r2.put("unload_source", r10);
        r2.put("user_id", String.valueOf(i.Y(this).e()));
        String r13 = String.valueOf(((Number) this.l.getChannelId().getValue()).longValue());
        if (r13 == null) goto L31;
        r12 = r13;
    L31:
        r2.put("channel_id", r12);
        b();
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r14 = getContext();
        if (r14 == null) goto L50;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r15 = r14.U7();
        if (r15 == null) goto L50;
        Map<String, String> r16 = r15.getCurrentTrackInfo();
        if (r16 == null) goto L50;
        if ((true ^ r16.isEmpty()) == false) goto L43;
        Iterator<T> r17 = r16.keySet().iterator();
    L41:
        if (r17.hasNext() == false) goto L43;
        String r18 = (String) r17.next();
        r2.put(r18, String.valueOf(r16.get(r18)));
    L43:
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r19 = getContext();
        if (r19 == null) goto L50;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r20 = r19.U7();
        if (r20 == null) goto L50;
        if (r20.getCurrentGameStatus() != IProfitGameStatusMessage.GameStatus.BizEnd.ordinal()) goto L50;
        r16.clear();
    L50:
        mz0.n r22 = new mz0.n();
        Map<String, String> r23 = r22.a;
        Intrinsics.checkNotNullParameter(r23, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r23.putAll(r2);
        mz0.m r24 = new mz0.m();
        i.m(this).m(r24);
        r24.b(LogCommon.ROOM);
        r24.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r22.b).addAll(r24.a);
        cy0.e.a.getClass();
        cy0.j r25 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r26 = com.bytedance.android.scope.m.b(r25).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r26);
        ((mz0.i) ((f80.a) r26)).w3("livesdk_connection_watch_duration", r22.a, r22.b);
        return;
    L17:
        r2.put("watch_connection_duration", String.valueOf(r4 / r7));
        goto L18
    L53:
        return;
    L5:
        r0 = this.e;
        goto L7
    }

    public MultiAudienceOtherComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r2, yz0.f r3, MultiAnchorLinkContext r4, ld.a r5, com.bytedance.android.live.revlink.impl.pk.scope.service.a r6, MultiPkScopeProviderService r7, c r8, MultiPKContextHolder r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "linkContext");
        Intrinsics.checkNotNullParameter(r5, "linkDataSet");
        Intrinsics.checkNotNullParameter(r6, "pkProfitReportService");
        Intrinsics.checkNotNullParameter(r7, "multiPkScopeService");
        Intrinsics.checkNotNullParameter(r8, "bizDataContext");
        Intrinsics.checkNotNullParameter(r9, "pkContextHolder");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
        this.o = r7;
        this.p = r8;
        this.q = r9;
        this.a = "MultiAudienceOtherComponent";
        this.b = new CompositeDisposable();
        this.c = 1;
        this.d = true;
    }
}
