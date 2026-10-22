package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import android.graphics.RectF;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.core.service.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RenderControl implements com.bytedance.android.live.revlink.link.biz.service.j {
    public final Lazy a;
    public final f b;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a c;

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.c;
    }

    public RenderControl(f r2, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r3) {
        Intrinsics.checkNotNullParameter(r2, "frameRenderService");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.b = r2;
        this.c = r3;
        this.a = LazyKt.lazy(new RenderControl$selfDefaultRenderState$2(this));
    }

    public final void a(List<? extends s51.b> r23, com.bytedance.android.live.revlink.link.core.service.p r24) {
        Intrinsics.checkNotNullParameter(r23, "mics");
        Intrinsics.checkNotNullParameter(r24, "layoutFrame");
        o51.e r3 = r24.f;
        b03.a r4 = b03.a.a;
        if (b03.a.a() == false) goto L9;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<T> r7 = r23.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r5.add(((s51.b) r7.next()).d());
        goto L6
    L8:
        RectF r6 = o51.a.b(r5);
    L11:
        if (r6.width() != 0.0f) goto L13;
        return;
    L13:
        if (r6.height() == 0.0f) goto L72;
        int r8 = ((ArrayList) r23).size();
        com.bytedance.android.live.revlink.impl.global.c r9 = com.bytedance.android.live.revlink.link.biz.service.i.q(this).c;
        if (r9 == null) goto L18;
        RevLinkWindowRegionContext r10 = r9.P8();
    L19:
        if (r10 == null) goto L21;
        r10.clearStreamRegion();
    L21:
        com.bytedance.android.live.revlink.link.core.service.g r2 = r24.h;
        if (r2 == null) goto L24;
        int r12 = r2.b;
    L25:
        if (r2 == null) goto L27;
        int r13 = r2.a;
    L28:
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r1 = r23.iterator();
    L30:
        if (r1.hasNext() == false) goto L60;
        s51.b r15 = (s51.b) r1.next();
        String r16 = r15.d().a;
        q r17 = r15.d();
        Intrinsics.checkNotNullParameter(r17, "$this$rectF");
        int r18 = r17.b;
        int r19 = r17.c;
        Iterator r20 = r1;
        RectF r110 = new RectF(r18, r19, r18 + r17.d, r19 + r17.e);
        float r111 = r12;
        int r22 = r13;
        RectF r25 = new RectF(((r110.left - r6.left) - r13) / r6.width(), ((r110.top - r6.top) - r111) / r6.height(), (r110.right - r6.left) / r6.width(), ((r110.bottom - r6.top) - r111) / r6.height());
        if (Intrinsics.areEqual(r16, getContext().Zl()) == false) goto L34;
        String r26 = com.bytedance.android.live.revlink.link.biz.service.i.q(this).a();
    L35:
        com.bytedance.android.live.revlink.impl.pk.utils.h r27 = com.bytedance.android.live.revlink.link.biz.service.i.q(this);
        r27.getClass();
        Intrinsics.checkNotNullParameter(r26, "key");
        Intrinsics.checkNotNullParameter(r25, "rectF");
        com.bytedance.android.live.revlink.impl.global.c r28 = r27.c;
        if (r28 == null) goto L38;
        RevLinkWindowRegionContext r29 = r28.P8();
    L39:
        if (r29 == null) goto L41;
        r29.updateStreamRegion(r26, r25);
    L41:
        WindowClickImpl r30 = new WindowClickImpl(r15, getContext(), r8);
        RevLinkWindowRegionContext r32 = getContext().P8();
        if (r32 == null) goto L46;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r33 = r32.getPartnerService();
        if (r33 == null) goto L46;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r34 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r33.getValue();
    L47:
        if (r34 == null) goto L51;
        if (r34.n() != true) goto L51;
    L52:
        boolean r112 = true;
    L54:
        boolean r35 = r15.d().i;
        int r36 = r15.d().g;
        if (r112 == false) goto L57;
        RenderControl$updateRender$renderStates$1$1 r113 = null;
    L58:
        r14.add(new p(r16, r35, r110, r25, r36, r113));
        r1 = r20;
        r13 = r22;
        goto L30
    L57:
        r113 = new RenderControl$updateRender$renderStates$1$1(r30);
    L51:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.b() == true) goto L52;
        r112 = false;
    L46:
        r34 = null;
        goto L47
    L38:
        r29 = null;
        goto L39
    L34:
        r26 = r16;
        goto L35
    L60:
        if (r14.size() > 1) goto L62;
        this.b.a(CollectionsKt.listOf((p) this.a.getValue()), false);
    L62:
        this.b.a(r14, r3 instanceof o51.e.C0283e);
        RevLinkWindowRegionContext r37 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this);
        if (r37 == null) goto L71;
        r37.notifyStreamRegionUpdate();
        return;
    L71:
        return;
    L27:
        r13 = 0;
        goto L28
    L24:
        r12 = 0;
        goto L25
    L18:
        r10 = null;
        goto L19
    L72:
        return;
    L9:
        Pair<Integer, Integer> r38 = com.bytedance.android.live.revlink.link.biz.service.i.q(this).b(r3);
        r6 = new RectF(0.0f, 0.0f, ((Number) r38.component1()).intValue(), ((Number) r38.component2()).intValue());
        goto L11
    }
}
