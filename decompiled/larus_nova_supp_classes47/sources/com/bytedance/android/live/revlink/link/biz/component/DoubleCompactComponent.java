package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleCompactComponent implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public oq2.d c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final MultiBizLifeControlComponent f;
    public final PkBaseDataContext g;
    public final MultiPKLauncher h;
    public final h i;

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

    public final void a(Integer r5) {
        if (this.e.getRoomContext().getCommonRoom().isLiveTypeAudio() == true) goto L5;
    L8:
        com.bytedance.android.live.revlink.impl.multianchor.service.c r0 = com.bytedance.android.live.revlink.link.biz.service.i.D(this);
        if (r0 != null) goto L11;
        return;
    L11:
        if (r5 == null) goto L13;
        int r6 = r5.intValue();
    L14:
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r0, r6, 0, null, 6);
        return;
    L13:
        r6 = 0;
        goto L14
    L5:
        if (d51.c.A0.d() == true) goto L8;
        getContext().ko().m(new DoubleCompactComponent$showFinishDialog$1(this));
    }

    public DoubleCompactComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, com.bytedance.android.livesdk.revenue.service.room.c r3, MultiBizLifeControlComponent r4, PkBaseDataContext r5, MultiPKLauncher r6, h r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "bizLifeControlComponent");
        Intrinsics.checkNotNullParameter(r5, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r6, "multiPKLauncher");
        Intrinsics.checkNotNullParameter(r7, "bizDataContext");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.a = "DoubleLaunchDataCompactComponent";
        this.b = new CompositeDisposable();
    }
}
