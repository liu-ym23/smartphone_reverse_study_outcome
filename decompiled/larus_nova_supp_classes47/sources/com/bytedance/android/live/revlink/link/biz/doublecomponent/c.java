package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yz0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public final PkDoubleAnchorDataContext c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final f f;
    public final com.bytedance.android.livesdk.revenue.service.message.d g;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
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

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.d;
    }

    public c(g r20, com.bytedance.android.livesdk.revenue.service.room.c r22, f r23, com.bytedance.android.livesdk.revenue.service.message.d r24) {
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r22, "roomService");
        Intrinsics.checkNotNullParameter(r23, "messageService");
        Intrinsics.checkNotNullParameter(r24, "messageManagerService");
        this.d = r20;
        this.e = r22;
        this.f = r23;
        this.g = r24;
        this.a = "DoublePKAnchorDataContextHolder";
        CompositeDisposable r15 = new CompositeDisposable();
        this.b = r15;
        long r2 = getContext().G();
        com.bytedance.android.live.revlink.impl.control.launchcontext.c r1 = i.Q(this);
        if (r1 == null) goto L5;
        String r4 = r1.b;
    L6:
        com.bytedance.android.live.revlink.impl.control.launchcontext.c r5 = i.Q(this);
        ld.a r6 = getContext().getLinkDataSet();
        Intrinsics.checkNotNullParameter(this, "$this$roomDataCenter");
        wq2.f r7 = getContext().getRoomDataCenterService();
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r9 = getContext();
        x11.a r12 = getContext().getInternalLinkService();
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r16 = getContext();
        e r3 = getContext().Ig();
        if ((r3 instanceof PkBaseDataContext) == true) goto L9;
        r3 = null;
    L9:
        final PkDoubleAnchorDataContext r14 = new PkDoubleAnchorDataContext(r2, r4, r5, r6, r7, r22, r9, r23, r24, r12, r16, (PkBaseDataContext) r3);
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "init success", null, 4);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) com.bytedance.live.datacontext.d.a(new DoublePKAnchorDataContextHolder$doubleAnchorPkContext$1$1(r14)).getSecond(), r15);
        Unit r0 = Unit.INSTANCE;
        this.c = r14;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
