package com.bytedance.android.live.revlink.link.biz.component;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.MultiBreakThroughBarImpl;
import com.bytedance.android.livesdk.link.model.n3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiNativeComponent implements com.bytedance.android.live.revlink.link.biz.service.e {
    public final String a;
    public MultiBreakThroughBarImpl b;
    public final BreakThroughBarUIOperation c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d d;
    public final PkBaseDataContext e;
    public final com.bytedance.android.livesdk.revenue.service.room.c f;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        this.c.attach();
    }

    public final void b() {
        MultiBreakThroughBarImpl r0 = this.b;
        if (r0 == null) goto L13;
        r0.n.getBaseTimeLeft().removeObserver(r0.j);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a r2 = r0.n.getBreakThroughService();
        if (r2 == null) goto L9;
        LiveData<n3> r3 = r2.getBreakthroughInfo();
        if (r3 == null) goto L9;
        r3.removeObserver(r0.k);
    L9:
        r0.m.getPlayState().removeObserver(r0.l);
        r0.m.resetState();
        r0.h.clear();
        zy0.b r4 = r0.c;
        if (r4 == null) goto L12;
        r4.dispose();
    L12:
        r0.c = null;
        r0.f = false;
        r0.d.clear();
    L13:
        this.b = null;
        this.c.h();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        b();
        this.c.detach();
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
        return this.d;
    }

    public final void a(com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a r10) {
        Intrinsics.checkNotNullParameter(r10, "breakThroughViewModel");
        b();
        MultiBreakThroughBarImpl r0 = new MultiBreakThroughBarImpl(r10, this.e, this.f, getContext(), getContext().getLinkDataSet(), new MultiNativeComponent$loadBreakThroughBar$1(this.c), this.c);
        this.b = r0;
        r0.d();
    }

    public MultiNativeComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, PkBaseDataContext r3, com.bytedance.android.livesdk.revenue.service.room.c r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r4, "roomService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = "MultiNativeComponent";
        this.c = new BreakThroughBarUIOperation(getContext());
    }
}
