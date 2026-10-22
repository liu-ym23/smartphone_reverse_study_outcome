package com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.utils.v;
import com.bytedance.android.live.revlink.link.biz.service.d;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.revenue.platform.api.core.rx.f;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import mz0.m;
import mz0.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleAudiencePKComponent implements d {
    public final String a;
    public final CompositeDisposable b;
    public final CompositeDisposable c;
    public boolean d;
    public final v e;
    public final boolean f;
    public final boolean g;
    public boolean h;
    public final b i;
    public final c j;
    public final DoubleAudienceBizDataContext k;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ DoubleAudiencePKComponent a;

        public a(DoubleAudiencePKComponent r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            this.a.d = false;
            DoubleAudiencePKComponent.b(false);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudiencePKComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass1(DoubleAudiencePKComponent r8) {
            super(1, r8, DoubleAudiencePKComponent.class, "onPKTimeLeftChange", "onPKTimeLeftChange(Ljava/lang/Long;)V", 0);
        }

        public final void invoke(Long r18) {
            DoubleAudiencePKComponent r1 = (DoubleAudiencePKComponent) ((CallableReference) this).receiver;
            r1.getClass();
            if (r18 == null) goto L30;
            r18.longValue();
            if (r1.h == true) goto L31;
            r1.h = true;
            long r3 = r18.longValue() * ((long) WebcastRedirectException.UNKNOWN);
            r1.c.clear();
            if (r3 <= 0) goto L32;
            s41.a r5 = s41.a.e;
            if (r5.a().K6() == false) goto L11;
            List<Long> r6 = r5.a().A();
        L12:
            List<Long> r7 = r6;
            Iterator<T> r8 = r7.iterator();
        L14:
            if (r8.hasNext() == false) goto L21;
            long r9 = ((Number) r8.next()).longValue();
            if (1 > r9) goto L14;
            if (r3 <= r9) goto L14;
            l r10 = l.a;
            Observable r12 = Observable.just(1);
            long r13 = r3 - r9;
            int r14 = p.a;
            Scheduler r15 = Schedulers.computation();
            f.a(r12.delay(r13, TimeUnit.MILLISECONDS, r15, false).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.a(r1)), r1.c);
            goto L14
        L21:
            v r2 = r1.e;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r6, "delayTimeInMills");
            JSONObject r4 = new JSONObject();
            int r16 = y50.b.a;
            y50.b.a.c(r4, "time_left", r3);
            r4.put("delay_time", CollectionsKt.toList(r7));
            r2.b("delay_sync", r4);
            return;
        L11:
            r6 = ((ys1.b) s41.a.b.getValue(r5, s41.a.a[0])).A();
            goto L12
        L32:
            return;
        L31:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Long) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudiencePKComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PkBaseStateMachine.c, Unit> {
        public AnonymousClass2(DoubleAudiencePKComponent r8) {
            super(1, r8, DoubleAudiencePKComponent.class, "onPKStateChange", "onPKStateChange(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$State;)V", 0);
        }

        public final void invoke(PkBaseStateMachine.c r6) {
            DoubleAudiencePKComponent r0 = (DoubleAudiencePKComponent) ((CallableReference) this).receiver;
            if (r6 != null) goto L5;
            r0.getClass();
            return;
        L5:
            DoubleAudienceBizDataContext r1 = r0.k;
            boolean r2 = r6 instanceof PkBaseStateMachine.c.C0130c;
            if (r2 == false) goto L15;
            e r3 = i.S(r0);
            if (r3 == null) goto L10;
            aa r4 = r3.getVoteSetting();
        L11:
            r1.a = r4;
            e r5 = i.S(r0);
            if (r5 == null) goto L18;
            r5.isOnceMoreBattle();
        L18:
            if (r0.f == false) goto L30;
            if (r2 == false) goto L22;
            r0.c.clear();
            r0.h = false;
            r0.d = false;
            goto L30
        L22:
            if (r0.g == false) goto L30;
            if (r0.d == false) goto L30;
            if ((r6 instanceof PkBaseStateMachine.c.b) == false) goto L28;
        L29:
            r0.a(1000, "finish_or_penal");
            goto L30
        L28:
            if ((r6 instanceof PkBaseStateMachine.c.d) == true) goto L29;
        L30:
            LinkedHashMap r7 = new LinkedHashMap();
            if (r2 == false) goto L41;
            r7.put("pk_status", DataType.TRUE);
            e r8 = i.S(r0);
            if (r8 == null) goto L38;
            LiveData<Long> r9 = r8.getBaseTimeLeft();
            if (r9 == null) goto L38;
            Long r10 = (Long) r9.getValue();
            if (r10 == null) goto L38;
        L39:
            r7.put("pkleft_time", String.valueOf(r10.longValue()));
        L45:
            n r12 = new n();
            Map<String, String> r13 = r12.a;
            Intrinsics.checkNotNullParameter(r13, "map");
            Intrinsics.checkNotNullParameter(r7, "map");
            r13.putAll(r7);
            m r14 = new m();
            r14.b(LogCommon.ROOM);
            List<Object> r15 = r12.b;
            ArrayList r16 = (ArrayList) r15;
            r16.addAll(r14.a);
            cy0.e.a.getClass();
            j r17 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r18);
            ((mz0.i) ((f80.a) r18)).w3("livesdk_transfer_pk_context", r12.a, r12.b);
            if ((r6 instanceof PkBaseStateMachine.c.a) == true) goto L54;
            i.l(r0);
            if (IPkAudienceLoadService.LoadType.MessageLoad == null) goto L55;
            Intrinsics.checkNotNullParameter(r0, "$this$pkAudienceDataService");
            com.bytedance.android.live.revlink.impl.pk.service.f r19 = i.getContext(r0).Aa();
            if (r19 == null) goto L56;
            r19.reportUiFirstLoad();
            return;
        L56:
            return;
        L55:
            return;
        L54:
            return;
        L38:
            r10 = -1L;
            goto L39
        L41:
            if ((r6 instanceof PkBaseStateMachine.c.b) == false) goto L43;
        L44:
            r7.put("pk_status", DataType.FALSE);
            goto L45
        L43:
            if ((r6 instanceof PkBaseStateMachine.c.d) == false) goto L45;
        L10:
            r4 = null;
            goto L11
        L15:
            if ((r6 instanceof PkBaseStateMachine.c.b) == false) goto L18;
            r1.getClass();
            goto L18
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((PkBaseStateMachine.c) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        Intrinsics.checkNotNullParameter(this, "$this$pkEnterRoomTracer");
        i.getContext(this).getPkEnterRoomTracer().getClass();
        i97.a r1 = i97.a.a;
        System.currentTimeMillis();
        if (this.f == false) goto L11;
        e r2 = i.S(this);
        if (r2 == null) goto L11;
        LiveData<Long> r3 = r2.getBaseTimeLeft();
        if (r3 == null) goto L11;
        Disposable r4 = UtilsKt.d(r3, new AnonymousClass1(this));
        if (r4 == null) goto L11;
        f.a(r4, this.b);
    L11:
        e r5 = i.S(this);
        if (r5 == null) goto L18;
        LiveData<PkBaseStateMachine.c> r6 = r5.getPkBaseState();
        if (r6 == null) goto L18;
        Disposable r7 = UtilsKt.d(r6, new AnonymousClass2(this));
        if (r7 == null) goto L18;
        f.a(r7, this.b);
    L18:
        getContext().md().b();
        Intrinsics.checkNotNullParameter(this, "$this$pkEnterRoomTracer");
        i.getContext(this).getPkEnterRoomTracer().getClass();
        System.currentTimeMillis();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
        getContext().md().a();
        this.h = false;
        if (this.g == true) goto L5;
    L7:
        this.c.dispose();
        return;
    L5:
        if (this.d == false) goto L7;
        a(0, "widget_destroy");
        goto L7
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
    public b getContext() {
        return this.i;
    }

    public static void b(boolean r3) {
        if (s41.a.e.a().K6() == false) goto L9;
        JSONObject r0 = new JSONObject();
        if (r3 == false) goto L7;
        String r4 = "livesdk_pk_start";
    L8:
        r0.put("trigger_name", r4);
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r5 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r5);
        ((com.bytedance.live.kmp.core.c) r5).triggerGiftAsyncSort(r0);
        return;
    L7:
        r4 = "livesdk_pk_end";
        goto L8
    L9:
        cy0.e.a.getClass();
        j r2 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r2).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r6);
        ((com.bytedance.live.kmp.core.c) r6).qi();
    }

    public final void a(long r8, String r10) {
        this.c.clear();
        if (r8 <= 0) goto L5;
        l r0 = l.a;
        Observable r1 = Observable.just(1);
        int r2 = p.a;
        Scheduler r5 = Schedulers.computation();
        f.a(r1.delay(r8, TimeUnit.MILLISECONDS, r5, false).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), this.c);
    L6:
        v r9 = this.e;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "reason");
        JSONObject r3 = new JSONObject();
        int r4 = y50.b.a;
        y50.b.a.d(r3, "reason", r10);
        r9.b("reset_gift_to_broadcast", r3);
        return;
    L5:
        this.d = false;
        b(false);
        goto L6
    }

    public DoubleAudiencePKComponent(b r6, c r7, DoubleAudienceBizDataContext r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "roomService");
        Intrinsics.checkNotNullParameter(r8, "bizDataContext");
        this.i = r6;
        this.j = r7;
        this.k = r8;
        this.a = "DoubleAudiencePKComponent";
        this.b = new CompositeDisposable();
        this.c = new CompositeDisposable();
        this.e = new v(r7, getContext());
        s41.a r9 = s41.a.e;
        r9.getClass();
        ReadOnlyProperty r10 = s41.a.b;
        KProperty[] r12 = s41.a.a;
        boolean r0 = false;
        ys1.b r1 = (ys1.b) r10.getValue(r9, r12[0]);
        Intrinsics.checkNotNullParameter(r1, "$this$isPkFeatureEnable");
        if (r1.Q7() != true) goto L9;
        List r2 = r1.A();
        if (r2 == null) goto L9;
        if (r2.isEmpty() == true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
    L15:
        boolean r4 = true;
    L16:
        this.f = r4;
        ys1.b r13 = (ys1.b) r10.getValue(r9, r12[0]);
        Intrinsics.checkNotNullParameter(r13, "$this$isResetGiftAfterPk");
        Intrinsics.checkNotNullParameter(r13, "$this$isPkFeatureEnable");
        if (r13.Q7() != true) goto L23;
        List r14 = r13.A();
        if (r14 == null) goto L23;
        if (r14.isEmpty() == true) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == true) goto L26;
    L28:
        boolean r16 = false;
    L29:
        if (r16 == false) goto L31;
    L34:
        r0 = true;
    L35:
        this.g = r0;
        return;
    L31:
        if (r9.a().K6() == false) goto L35;
        if (r9.a().u3() == false) goto L35;
    L26:
        if (r13.o6() != true) goto L28;
        r16 = true;
    L23:
        r15 = false;
        goto L24
    L12:
        if (r9.a().K6() == true) goto L15;
        r4 = false;
    L9:
        r3 = false;
        goto L10
    }
}
