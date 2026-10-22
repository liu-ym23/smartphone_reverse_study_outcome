package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiDynamicManager;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.MultiDynamicContextImpl;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.biz.component.MultiMuteManager;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.domain.dependencyimpl.DynamicContextDependencyImpl;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.RevLinkBizContext;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class CoreContext {
    public static final /* synthetic */ int l = 0;
    public final CompositeDisposable a;
    public final PkBaseDataContext b;
    public final DynamicContextDependencyImpl c;
    public final com.bytedance.android.live.revlink.link.domain.dependencyimpl.a d;
    public final MultiDynamicContextImpl e;
    public final MultiDynamicManager f;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g g;
    public final com.bytedance.android.livesdk.revenue.service.room.c h;
    public final yz0.f i;
    public final com.bytedance.android.livesdk.revenue.service.message.d j;
    public final AnchorUILayoutManager k;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.e.n();
        this.f.o();
        this.g.d.d.b(4, "multi_anchor_link_widget_create");
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(this.g.d.g, new CoreContext$attach$1(this)), this.a);
        this.c.getChannelId().setValue(Long.valueOf(this.g.d.p));
        PublishSubject<com.bytedance.android.live.revlink.link.infra.lifecontrol.context.m> r0 = this.g.d.e;
        final CoreContext$attach$2 r1 = new CoreContext$attach$2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribe(new b(r1)), this.a);
        com.bytedance.android.live.revlink.impl.multianchor.service.g r2 = b();
        if (r2 == null) goto L10;
        NextLiveData<Boolean> r3 = r2.g();
        if (r3 == null) goto L11;
        Disposable r4 = UtilsKt.i(r3, new CoreContext$attach$3(this));
        if (r4 == null) goto L12;
        com.bytedance.revenue.platform.api.core.rx.f.a(r4, this.a);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.service.g b() {
        RevLinkWindowRegionContext r0 = this.g.P8();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r1 = r0.getPartnerService();
        if (r1 == null) goto L7;
        return (com.bytedance.android.live.revlink.impl.multianchor.service.g) r1.getValue();
    L7:
        return null;
    }

    public CoreContext(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r19, com.bytedance.android.livesdk.revenue.service.room.c r20, yz0.f r22, com.bytedance.android.livesdk.revenue.service.message.d r23, AnchorUILayoutManager r24, MultiMuteManager r25) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "revRoomService");
        Intrinsics.checkNotNullParameter(r22, "messageService");
        Intrinsics.checkNotNullParameter(r23, "messageManagerService");
        Intrinsics.checkNotNullParameter(r24, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r25, "muteManager");
        this.g = r19;
        this.h = r20;
        this.i = r22;
        this.j = r23;
        this.k = r24;
        CompositeDisposable r12 = new CompositeDisposable();
        this.a = r12;
        Function0<Integer> r2 = new CoreContext$pkContext$1(this);
        RevLinkBizContext r1 = r19.d;
        final PkBaseDataContext r13 = new PkBaseDataContext(r2, true, r1.y, r1.v, r20, r19, r22, r1.z, r19);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) com.bytedance.live.datacontext.d.a(new CoreContext$pkContext$2$1(r13)).getSecond(), r12);
        r19.T6(PkBaseDataContext.TAG, r13);
        jy0.b.c("xuzr_scope", "create pkContext and share", null, 4);
        this.b = r13;
        DynamicContextDependencyImpl r9 = new DynamicContextDependencyImpl();
        this.c = r9;
        com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r10 = new com.bytedance.android.live.revlink.link.domain.dependencyimpl.a();
        this.d = r10;
        Function0<Integer> r3 = new CoreContext$dynamicContext$1(this);
        RevLinkBizContext r4 = r19.d;
        MultiDynamicContextImpl r14 = new MultiDynamicContextImpl(r3, r4.y, r20, r19, r13, r9, r4.d, r9, r10, r25, r19.Zl(), 2048);
        this.e = r14;
        CoreContext$dynamicManager$1 r5 = CoreContext$dynamicManager$1.INSTANCE;
        x51.a r6 = r19.d.u;
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r7 = r14.h;
    L6:
        MultiDynamicManager r8 = new MultiDynamicManager(r5, r6, r20, r7, com.bytedance.android.live.revlink.impl.multianchor.dynamic.h.b.b);
        r14.c = r8;
        Unit r15 = Unit.INSTANCE;
        this.f = r8;
        return;
    L5:
        r7 = r14.g;
        goto L6
    }
}
