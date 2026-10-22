package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkmulti.PkMultiDataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiPKContextHolder implements com.bytedance.android.live.revlink.link.biz.service.e {
    public final String a;
    public final CompositeDisposable b;
    public final PkMultiDataContext c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final yz0.f f;
    public final com.bytedance.android.livesdk.revenue.service.message.d g;
    public final BackgroundComponent h;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
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
        return this.d;
    }

    public MultiPKContextHolder(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r18, com.bytedance.android.livesdk.revenue.service.room.c r19, yz0.f r20, com.bytedance.android.livesdk.revenue.service.message.d r22, BackgroundComponent r23) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "revRoomService");
        Intrinsics.checkNotNullParameter(r20, "messageService");
        Intrinsics.checkNotNullParameter(r22, "messageManagerService");
        this.d = r18;
        this.e = r19;
        this.f = r20;
        this.g = r22;
        this.h = r23;
        this.a = "MultiPKContextHolder";
        CompositeDisposable r14 = new CompositeDisposable();
        this.b = r14;
        com.bytedance.android.livesdk.revenue.room.a r2 = r19.getRoomContext();
        com.bytedance.android.live.revlink.link.biz.service.g r1 = com.bytedance.android.live.revlink.link.biz.service.i.b(this);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.live.revlink.impl.control.launchcontext.b r4 = com.bytedance.android.live.revlink.link.biz.service.i.E(r1);
    L6:
        ld.a r5 = getContext().getLinkDataSet();
        wq2.f r7 = getContext().getRoomDataCenterService();
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r10 = getContext();
        x11.a r12 = getContext().getInternalLinkService();
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r13 = getContext();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = getContext().Ig();
        if ((r6 instanceof PkBaseDataContext) == false) goto L10;
        r3 = r6;
    L10:
        final PkMultiDataContext r15 = new PkMultiDataContext(r2, r4, r5, r7, r19, r10, r20, r22, r12, r13, (PkBaseDataContext) r3, new MultiPKContextHolder$multiPkContext$1(this));
        r15.attach();
        int r8 = com.bytedance.revenue.platform.api.core.rx.h.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.revenue.platform.api.core.rx.h.a(new MultiPKContextHolder$multiPkContext$2$1(r15)), r14);
        Unit r9 = Unit.INSTANCE;
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) com.bytedance.live.datacontext.d.a(new MultiPKContextHolder$multiPkContext$3$1(r15)).getSecond(), r14);
        this.c = r15;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
