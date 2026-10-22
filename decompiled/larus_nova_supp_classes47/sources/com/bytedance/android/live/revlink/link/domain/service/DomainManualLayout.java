package com.bytedance.android.live.revlink.link.domain.service;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.link.core.service.s;
import com.bytedance.android.live.revlink.link.domain.dependencyimpl.DynamicContextDependencyImpl;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.dynamicresource.client.DynamicLayoutClient;
import f31.i;
import f31.k;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o51.f;
import t51.e;
import t51.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DomainManualLayout implements com.bytedance.android.live.revlink.link.biz.service.b {
    public boolean a;
    public boolean b;
    public boolean c;
    public Disposable d;
    public final com.bytedance.android.live.revlink.link.domain.dependencyimpl.a e;
    public final DynamicContextDependencyImpl f;
    public final h g;
    public final s h;

    public final void b() {
        if (this.a == true) goto L5;
        return;
    L5:
        if (this.b == false) goto L7;
    L8:
        final f.n r0 = f.n.e;
        Disposable r1 = this.d;
        if (r1 == null) goto L11;
        r1.dispose();
    L11:
        s r2 = this.h;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "routerKey");
        DynamicLayoutClient<t51.f, g, f> r3 = r2.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "routerKey");
        Iterator r4 = ((ArrayList) r3.a.i).iterator();
    L13:
        if (r4.hasNext() == false) goto L20;
        Object r5 = ((com.bytedance.live.dynamicresource.producer.a) r4.next()).c(r0, r3.a);
        if (r5 == null) goto L13;
        Iterator r6 = ((ArrayList) r3.a.i).iterator();
    L18:
        if (r6.hasNext() == false) goto L21;
        ((com.bytedance.live.dynamicresource.producer.a) r6.next()).a(r0, r3.a, r5);
    L21:
        g r7 = (g) r5;
        if (r7 == null) goto L24;
        a(r0, r7);
        return;
    L24:
        s r8 = this.h;
        Function1<g, Unit> r9 = new DomainManualLayout$requestLayout$$inlined$run$lambda$1(this, r0);
        DomainManualLayout$requestLayout$2$2 r10 = DomainManualLayout$requestLayout$2$2.INSTANCE;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "routerKey");
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        Intrinsics.checkNotNullParameter(r10, "onFail");
        this.d = r8.a.c(r0, r9, r10);
        return;
    L20:
        r5 = null;
        goto L21
    L7:
        if (this.c == true) goto L8;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.b, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.b, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.b, com.bytedance.android.live.revlink.link.biz.service.j
    public h getContext() {
        return this.g;
    }

    public final void a(f r26, g r27) {
        jy0.b.c("DomainManualLayout", "doRequestLayout", null, 4);
        if ((r26 instanceof f.n) == false) goto L5;
        int r1 = AnchorHeightFixMode.OriginContainerHeight.ordinal();
    L9:
        int r4 = getContext().getContainerWidth();
        if (r1 != AnchorHeightFixMode.OriginContainerHeight.ordinal()) goto L13;
        int r2 = getContext().l();
    L17:
        List<e> r3 = r27.e().get(2);
        if (r3 != null) goto L22;
        jy0.b.c("DomainManualLayout", "return for no region", null, 4);
        return;
    L22:
        if (Intrinsics.areEqual(r26, f.n.e) == false) goto L32;
        ArrayList r5 = new ArrayList();
        if (this.b == false) goto L26;
        r5.addAll(CollectionsKt.listOf(new Integer[]{30000, 20001, 20002}));
    L28:
        if (this.c == false) goto L30;
        r5.addAll(CollectionsKt.listOf(new Integer[]{30001, 20003, 20004}));
    L38:
        if (r5 != null) goto L41;
        jy0.b.c("DomainManualLayout", "return for no validPositions", null, 4);
        return;
    L41:
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L43:
        if (r7.hasNext() == false) goto L59;
        int r12 = ((Number) r7.next()).intValue();
        Iterator<T> r13 = r3.iterator();
    L46:
        if (r13.hasNext() == false) goto L53;
        Object r14 = r13.next();
        if (((e) r14).b() != r12) goto L50;
        boolean r15 = true;
    L51:
        if (r15 == false) goto L46;
    L54:
        e r16 = (e) r14;
        if (r16 != null) goto L57;
        k r9 = null;
    L58:
        r6.add(r9);
        goto L43
    L57:
        float r10 = r4;
        float r17 = r2;
        r9 = new k(null, "", (int) (r16.e() * r10), (int) (r16.f() * r17), (int) (r10 * r16.d()), (int) (r17 * r16.a()), true, true, r16.getType(), r12);
        goto L58
    L50:
        r15 = false;
        goto L51
    L53:
        r14 = null;
        goto L54
    L59:
        List r8 = CollectionsKt.filterNotNull(r6);
        com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r18 = this.e;
        r18.a = null;
        r18.b = null;
        this.f.getWindowStatus().setValue(new i(r8, null, null, null, null, null, null, 112));
        Matrix r19 = o51.a.a(new RectF(0.0f, 0.0f, 1.0f, 1.0f), new RectF(0.0f, 0.0f, r4, r2));
        NextLiveData<o51.e> r20 = getContext().d.i;
        if (Intrinsics.areEqual(r26, f.n.e) == false) goto L63;
        Object r22 = new o51.e.i(this.b, this.c, getContext().d.k, "");
    L69:
        r20.setValue(r22);
        getContext().d.h.setValue(new f31.f(r8, o51.a.e(r8), o51.a.e(r8), r19, r26));
        jy0.b.c("DomainManualLayout", "update layoutStatus " + ((f31.f) getContext().d.h.getValue()), null, 4);
        return;
    L63:
        if (Intrinsics.areEqual(r26, f.l.e) == false) goto L65;
    L68:
        r22 = new o51.e.h(false);
        goto L69
    L65:
        if (Intrinsics.areEqual(r26, f.m.e) == true) goto L68;
        r22 = com.bytedance.android.live.revlink.link.core.service.c.a(getContext());
        goto L69
    L30:
        r5.add(1);
        goto L38
    L26:
        r5.add(0);
        goto L28
    L32:
        if (Intrinsics.areEqual(r26, f.l.e) == false) goto L34;
    L37:
        r5 = new ArrayList();
        r5.addAll(CollectionsKt.listOf(new Integer[]{0, 1, 10001}));
        goto L38
    L34:
        if (Intrinsics.areEqual(r26, f.m.e) == true) goto L37;
        r5 = null;
        goto L38
    L13:
        if (r1 != AnchorHeightFixMode.RationTransformHeight.ordinal()) goto L15;
        int r23 = getContext().getContainerWidth();
    L16:
        r2 = (int) ((((double) r23) / 9.0d) * 16.0d);
        goto L17
    L15:
        r23 = getContext().getContainerWidth();
        goto L16
    L5:
        t51.a r24 = r27.a(DeviceType.NORMAL_MOBILE, 2);
        if (r24 == null) goto L8;
        r1 = r24.d();
        goto L9
    L8:
        r1 = AnchorHeightFixMode.RationTransformHeight.ordinal();
        goto L9
    }

    public DomainManualLayout(com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r2, DynamicContextDependencyImpl r3, h r4, s r5) {
        Intrinsics.checkNotNullParameter(r2, "dynamicContextSeiDependencies");
        Intrinsics.checkNotNullParameter(r3, "dynamicContextDependencyImpl");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "dynamicLayoutClient");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
    }
}
