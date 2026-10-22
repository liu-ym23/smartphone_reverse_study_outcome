package com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.live.revlink.link.biz.service.d;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b;
import com.bytedance.android.livesdk.revenue.service.room.c;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yz0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoublePKAudienceDataContextHolder implements d {
    public final String a;
    public final CompositeDisposable b;
    public final PkDoubleAudienceDataContext c;
    public final b d;
    public final c e;
    public final f f;
    public final com.bytedance.android.livesdk.revenue.service.message.d g;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        d51.c r0 = d51.c.A0;
        r0.getClass();
        if (((Boolean) d51.c.H.getValue(r0, d51.c.a[32])).booleanValue() == false) goto L6;
        this.c.attach();
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
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
        return this.d;
    }

    public DoublePKAudienceDataContextHolder(b r18, c r19, f r20, com.bytedance.android.livesdk.revenue.service.message.d r22) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "roomService");
        Intrinsics.checkNotNullParameter(r20, "messageService");
        Intrinsics.checkNotNullParameter(r22, "messageManagerService");
        this.d = r18;
        this.e = r19;
        this.f = r20;
        this.g = r22;
        this.a = "DoublePKAudienceDataContextHolder";
        CompositeDisposable r15 = new CompositeDisposable();
        this.b = r15;
        long r2 = getContext().G();
        Intrinsics.checkNotNullParameter(this, "$this$doubleGuestUID");
        i.l(this);
        com.bytedance.android.live.revlink.impl.control.launchcontext.d r5 = i.l(this);
        ld.a r6 = getContext().getLinkDataSet();
        wq2.f r7 = getContext().getRoomDataCenterService();
        b r9 = getContext();
        x11.a r12 = getContext().getInternalLinkService();
        b r13 = getContext();
        e r1 = getContext().Ig();
        if ((r1 instanceof PkBaseDataContext) == true) goto L5;
        r1 = null;
    L5:
        final PkDoubleAudienceDataContext r14 = new PkDoubleAudienceDataContext(r2, null, r5, r6, r7, r19, r9, r20, r22, r12, r13, (PkBaseDataContext) r1);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) com.bytedance.live.datacontext.d.a(new DoublePKAudienceDataContextHolder$doubleAudiencePKContext$1$1(r14)).getSecond(), r15);
        Unit r3 = Unit.INSTANCE;
        this.c = r14;
    }
}
