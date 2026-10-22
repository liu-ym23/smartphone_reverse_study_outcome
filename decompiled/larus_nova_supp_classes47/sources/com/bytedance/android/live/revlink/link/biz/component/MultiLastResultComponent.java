package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiLastResultComponent implements com.bytedance.android.live.revlink.link.biz.service.e {
    public final String a;
    public final CompositeDisposable b;
    public final Map<String, Integer> c;
    public final List<com.bytedance.android.livesdk.link.model.p> d;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d e;
    public final MultiPKContextHolder f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiLastResultComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<PkBaseStateMachine.c, Unit> {
        public AnonymousClass1(MultiLastResultComponent r8) {
            super(1, r8, MultiLastResultComponent.class, "onPKStateChange", "onPKStateChange(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$State;)V", 0);
        }

        public final void invoke(PkBaseStateMachine.c r14) {
            MultiLastResultComponent r0 = (MultiLastResultComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r14 != null) goto L6;
            return;
        L6:
            if (r14.b() == false) goto L49;
            Map r1 = (Map) r0.a().m592getPkBaseResult().getValue();
            IBaseBattleSetting r4 = r0.a().getBattleSettings();
            boolean r5 = false;
            if (r4 != null) goto L10;
        L11:
            IBaseBattleSetting r6 = r0.a().getBattleSettings();
            if (r6 != null) goto L14;
        L47:
            if (r5 == false) goto L49;
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0), "show last result from pkStateObserver", null, 4);
            r0.a().getLastBattleResultVisible().setValue(Boolean.TRUE);
            return;
        L14:
            if (af2.d.c(r6) != true) goto L47;
        L16:
            if (r1 == null) goto L47;
            List<com.bytedance.android.livesdk.link.model.p> r7 = com.bytedance.android.live.revlink.link.biz.service.i.t(r0).a;
            ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r9 = ((CopyOnWriteArrayList) r7).iterator();
        L20:
            if (r9.hasNext() == false) goto L27;
            IBaseUser r10 = ((com.bytedance.android.livesdk.link.model.p) r9.next()).getUser();
            if (r10 == null) goto L25;
            String r12 = iz.a.a(r10);
            if (r12 == null) goto L25;
        L26:
            r8.add(r12);
        L25:
            r12 = "";
            goto L26
        L27:
            Map<String, Integer> r13 = r0.c;
            LinkedHashMap r15 = new LinkedHashMap();
            Iterator r16 = ((LinkedHashMap) r13).entrySet().iterator();
        L29:
            if (r16.hasNext() == false) goto L44;
            Map.Entry r17 = (Map.Entry) r16.next();
            String r18 = (String) r17.getKey();
            int r19 = ((Number) r17.getValue()).intValue();
            int r110 = h21.a.a;
            if (r19 == 3) goto L35;
            if (r19 == 4) goto L35;
            boolean r111 = false;
        L36:
            if (r111 == false) goto L38;
        L40:
            boolean r112 = false;
        L41:
            if (r112 == false) goto L29;
            r15.put(r17.getKey(), r17.getValue());
            goto L29
        L38:
            if (r8.contains(r18) == false) goto L40;
            r112 = true;
        L35:
            r111 = true;
            goto L36
        L44:
            if (r1.size() != r15.size()) goto L47;
            r5 = !r1.isEmpty();
            goto L47
        L10:
            if (r4.getBattleId() == 0) goto L16;
        L49:
            jy0.b.c("ttlive_anchor_link_multi_pk", "hide last result from pkStateObserver", null, 4);
            r0.a().getLastBattleResultVisible().setValue(Boolean.FALSE);
            if ((r14 instanceof PkBaseStateMachine.c.d) == false) goto L62;
            ((LinkedHashMap) r0.c).clear();
            r0.c.putAll(r0.f.c.getUserRoleMap());
            ((ArrayList) r0.d).clear();
            ((ArrayList) r0.d).addAll(com.bytedance.android.live.revlink.link.biz.service.i.t(r0).a);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((PkBaseStateMachine.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiLastResultComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<List<? extends com.bytedance.android.livesdk.link.model.p>, Integer, Unit> {
        public AnonymousClass2(MultiLastResultComponent r8) {
            super(2, r8, MultiLastResultComponent.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "p1");
            MultiLastResultComponent r12 = (MultiLastResultComponent) ((CallableReference) this).receiver;
            List<com.bytedance.android.livesdk.link.model.p> r0 = r12.d;
            boolean r1 = true;
            if (r9 == null) goto L34;
            ArrayList r2 = (ArrayList) r0;
            if (r2.size() != r9.size()) goto L34;
            Iterator r3 = r2.iterator();
        L9:
            boolean r4 = false;
            if (r3.hasNext() == false) goto L33;
            com.bytedance.android.livesdk.link.model.p r5 = (com.bytedance.android.livesdk.link.model.p) r3.next();
            List<? extends com.bytedance.android.livesdk.link.model.p> r6 = r9;
            if ((r6 instanceof Collection) == true) goto L14;
        L16:
            Iterator<T> r7 = r6.iterator();
        L18:
            if (r7.hasNext() == false) goto L30;
            IBaseUser r8 = ((com.bytedance.android.livesdk.link.model.p) r7.next()).getUser();
            if (r8 == null) goto L22;
            String r13 = iz.a.a(r8);
        L23:
            IBaseUser r14 = r5.getUser();
            if (r14 == null) goto L26;
            String r15 = iz.a.a(r14);
        L28:
            if (Intrinsics.areEqual(r13, r15) == false) goto L18;
        L31:
            if (r4 == false) goto L9;
        L26:
            r15 = null;
            goto L28
        L22:
            r13 = null;
        L30:
            r4 = true;
            goto L31
        L14:
            if (r6.isEmpty() == false) goto L16;
        L33:
            r1 = false;
        L34:
            if (r1 == true) goto L36;
            return;
        L36:
            if (Intrinsics.areEqual((Boolean) r12.a().getLastBattleResultVisible().getValue(), Boolean.TRUE) == false) goto L38;
            jy0.b.c("ttlive_anchor_link_multi_pk", "hide last result from onlineListChanged", null, 4);
        L38:
            r12.a().getLastBattleResultVisible().setValue(Boolean.FALSE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((List) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiLastResultComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass3(MultiLastResultComponent r8) {
            super(1, r8, MultiLastResultComponent.class, "onShowLastBattleResultChange", "onShowLastBattleResultChange(Ljava/lang/Boolean;)V", 0);
        }

        public final void invoke(Boolean r5) {
            MultiLastResultComponent r0 = (MultiLastResultComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r5 == null) goto L10;
            r5.booleanValue();
            if (r5.booleanValue() == true) goto L7;
            return;
        L7:
            if (com.bytedance.android.live.revlink.link.biz.service.i.o(r0).g() == true) goto L12;
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0), "show last result from showResultObserver", null, 4);
            r0.a().getLastBattleResultVisible().setValue(Boolean.TRUE);
            ((ArrayList) r0.d).clear();
            List<com.bytedance.android.livesdk.link.model.p> r6 = r0.d;
            ArrayList r7 = (ArrayList) r6;
            r7.addAll(com.bytedance.android.live.revlink.link.biz.service.i.t(r0).a);
            return;
        L12:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Boolean) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    public final PkBaseDataContext a() {
        return this.f.c.getBasePKContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(this.f.c.getBasePKContext().getPkBaseState(), new AnonymousClass1(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revlink.link.biz.service.i.t(this).m(new AnonymousClass2(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(this.f.c.m617getShowLastBattleResult(), new AnonymousClass3(this)), this.b);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.e;
    }

    public MultiLastResultComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, MultiPKContextHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pkContextHolder");
        this.e = r2;
        this.f = r3;
        this.a = "MultiLastResultComponent";
        this.b = new CompositeDisposable();
        this.c = new LinkedHashMap();
        this.d = new ArrayList();
    }
}
