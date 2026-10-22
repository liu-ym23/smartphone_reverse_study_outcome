package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revlink.link.biz.component.MultiPKContextHolder;
import com.bytedance.android.live.revlink.link.biz.service.j;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import f31.k;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiAudienceWindowBizComponent implements com.bytedance.android.live.revlink.link.biz.service.d {
    public final String a;
    public final CompositeDisposable b;
    public List<a> c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b d;
    public final MultiPKContextHolder e;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceWindowBizComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf31/f;", "p1", "", "invoke", "(Lf31/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<f31.f, Unit> {
        public AnonymousClass1(MultiAudienceWindowBizComponent r8) {
            super(1, r8, MultiAudienceWindowBizComponent.class, "refreshWindowBizImpl", "refreshWindowBizImpl(Lcom/bytedance/android/live/revlink/impl/multianchor/model/LayoutStatus;)V", 0);
        }

        public final void invoke(f31.f r8) {
            MultiAudienceWindowBizComponent r0 = (MultiAudienceWindowBizComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r8 == null) goto L58;
            List<k> r9 = r8.a;
            if (r9 == null) goto L59;
            List<a> r1 = r0.c;
            LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
            Iterator<T> r3 = r1.iterator();
        L9:
            if (r3.hasNext() == false) goto L11;
            Object r4 = r3.next();
            a r5 = (a) r4;
            r2.put(r4, Boolean.FALSE);
            goto L9
        L11:
            Map r6 = MapsKt.toMutableMap(r2);
            ArrayList r7 = new ArrayList();
            Iterator<T> r10 = r9.iterator();
        L13:
            if (r10.hasNext() == false) goto L30;
            String r12 = ((k) r10.next()).a;
            if (r12 == null) goto L18;
            Intrinsics.checkNotNullParameter(r12, "$this$uid");
            Intrinsics.checkNotNullParameter(r12, "$this$uid");
            Intrinsics.checkNotNullParameter(r12, "$this$uid");
            String r13 = j.a.b(r0, r12);
            if (r13 == null) goto L18;
        L19:
            Iterator<T> r14 = r0.c.iterator();
        L21:
            if (r14.hasNext() == false) goto L25;
            Object r15 = r14.next();
            if (Intrinsics.areEqual(((a) r15).d, r13) == false) goto L21;
        L26:
            a r16 = (a) r15;
            if (r16 != null) goto L28;
            r7.add(new a(r0.getContext(), r13, r0.e));
            goto L13
        L28:
            r6.put(r16, Boolean.TRUE);
            r7.add(r16);
            goto L13
        L25:
            r15 = null;
        L18:
            r13 = "";
            goto L19
        L30:
            List<a> r17 = r0.c;
            ArrayList r18 = new ArrayList();
            Iterator<T> r19 = r17.iterator();
        L32:
            if (r19.hasNext() == false) goto L36;
            Object r20 = r19.next();
            if ((!Intrinsics.areEqual((Boolean) r6.get((a) r20), Boolean.TRUE)) == false) goto L32;
            r18.add(r20);
            goto L32
        L36:
            Iterator r22 = r18.iterator();
        L38:
            if (r22.hasNext() == false) goto L40;
            ((a) r22.next()).getClass();
            goto L38
        L40:
            r0.c = r7;
            return;
        L59:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((f31.f) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
        getContext().getCommonService().h().c();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().hh(), new AnonymousClass1(this)), this.b);
        getContext().getCommonService().h().a();
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
        return this.d;
    }

    public MultiAudienceWindowBizComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r2, MultiPKContextHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pkContextHolder");
        this.d = r2;
        this.e = r3;
        this.a = "MultiAudienceWindowBizComponent";
        this.b = new CompositeDisposable();
        this.c = CollectionsKt.emptyList();
    }
}
