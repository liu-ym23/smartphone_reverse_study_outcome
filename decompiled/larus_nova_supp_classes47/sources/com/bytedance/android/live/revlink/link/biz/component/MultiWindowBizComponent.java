package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
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
public final class MultiWindowBizComponent implements com.bytedance.android.live.revlink.link.biz.service.e {
    public final CompositeDisposable a;
    public final String b;
    public List<s> c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i f;
    public final RevLinkDomainAnchorService g;
    public final AnchorUILayoutManager h;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiWindowBizComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf31/f;", "p1", "", "invoke", "(Lf31/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<f31.f, Unit> {
        public AnonymousClass1(MultiWindowBizComponent r8) {
            super(1, r8, MultiWindowBizComponent.class, "refreshWindowBizImpl", "refreshWindowBizImpl(Lcom/bytedance/android/live/revlink/impl/multianchor/model/LayoutStatus;)V", 0);
        }

        public final void invoke(f31.f r12) {
            MultiWindowBizComponent r0 = (MultiWindowBizComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r12 == null) goto L58;
            List<f31.k> r13 = r12.a;
            if (r13 == null) goto L59;
            List<s> r1 = r0.c;
            LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
            Iterator<T> r3 = r1.iterator();
        L9:
            if (r3.hasNext() == false) goto L11;
            Object r4 = r3.next();
            s r5 = (s) r4;
            r2.put(r4, Boolean.FALSE);
            goto L9
        L11:
            Map r6 = MapsKt.toMutableMap(r2);
            ArrayList r7 = new ArrayList();
            Iterator<T> r14 = r13.iterator();
        L13:
            if (r14.hasNext() == false) goto L30;
            String r8 = ((f31.k) r14.next()).a;
            if (r8 == null) goto L18;
            Intrinsics.checkNotNullParameter(r8, "$this$uid");
            Intrinsics.checkNotNullParameter(r8, "$this$uid");
            String r9 = com.bytedance.android.live.revlink.link.biz.service.j.a.b(r0, r8);
            if (r9 == null) goto L18;
        L19:
            String r10 = r9;
            Iterator<T> r15 = r0.c.iterator();
        L21:
            if (r15.hasNext() == false) goto L25;
            Object r16 = r15.next();
            if (Intrinsics.areEqual(((s) r16).i, r10) == false) goto L21;
        L26:
            s r17 = (s) r16;
            if (r17 != null) goto L28;
            s r18 = new s(r0.getContext(), r10, r0.e, r0.f, r0.g, r0.h);
            r18.attach();
            r7.add(r18);
            goto L13
        L28:
            r6.put(r17, Boolean.TRUE);
            r7.add(r17);
            goto L13
        L25:
            r16 = null;
        L18:
            r9 = "";
            goto L19
        L30:
            List<s> r19 = r0.c;
            ArrayList r20 = new ArrayList();
            Iterator<T> r110 = r19.iterator();
        L32:
            if (r110.hasNext() == false) goto L36;
            Object r22 = r110.next();
            if ((!Intrinsics.areEqual((Boolean) r6.get((s) r22), Boolean.TRUE)) == false) goto L32;
            r20.add(r22);
            goto L32
        L36:
            Iterator r111 = r20.iterator();
        L38:
            if (r111.hasNext() == false) goto L40;
            ((s) r111.next()).detach();
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
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.a.clear();
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((s) r0.next()).detach();
        goto L4
    L6:
        this.c = CollectionsKt.emptyList();
        getContext().getCommonService().h().c();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().hh(), new AnonymousClass1(this)), this.a);
        getContext().getCommonService().h().a();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.d;
    }

    public MultiWindowBizComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, com.bytedance.android.livesdk.revenue.service.room.c r3, com.bytedance.android.live.revlink.link.domain.service.a r4, RevLinkDomainAnchorService r5, AnchorUILayoutManager r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "muteManager");
        Intrinsics.checkNotNullParameter(r5, "domainService");
        Intrinsics.checkNotNullParameter(r6, "uiLayoutManager");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.a = new CompositeDisposable();
        this.b = "MultiWindowBizComponent";
        this.c = CollectionsKt.emptyList();
    }
}
