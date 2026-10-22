package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiLinkContextComponent implements com.bytedance.android.live.revlink.link.biz.service.e {
    public final String a;
    public final MultiAnchorLinkContext b;
    public final CompositeDisposable c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        Pair r0 = com.bytedance.live.datacontext.d.a(new MultiLinkContextComponent$attach$pair$1(this));
        com.bytedance.android.live.revlink.impl.control.launchcontext.b r2 = null;
        u r3 = null;
        if (getContext().r9() == false) goto L16;
        com.bytedance.android.live.revlink.link.biz.service.f r1 = com.bytedance.android.live.revlink.link.biz.service.i.a(this);
        if (r1 == null) goto L7;
        com.bytedance.android.live.revlink.impl.control.launchcontext.a r4 = com.bytedance.android.live.revlink.link.biz.service.i.x(r1);
    L8:
        com.bytedance.live.datacontext.n<f21.a> r5 = this.b.getConnectionContext();
        if (r4 == null) goto L11;
        f21.a r6 = r4.b;
    L12:
        r5.setValue(r6);
        MultiAnchorLinkContext r7 = this.b;
        if (r4 == null) goto L15;
        r3 = r4.a;
    L15:
        r7.setAnchorLaunchParameters(r3);
        this.b.setLaunchContext(r4);
    L24:
        getContext().T6(Reflection.getOrCreateKotlinClass(MultiAnchorLinkContext.class), (DataContext) r0.getFirst());
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r0.getSecond(), this.c);
        return;
    L11:
        r6 = null;
        goto L12
    L7:
        r4 = null;
        goto L8
    L16:
        com.bytedance.android.live.revlink.link.biz.service.g r8 = com.bytedance.android.live.revlink.link.biz.service.i.b(this);
        if (r8 == null) goto L19;
        r2 = com.bytedance.android.live.revlink.link.biz.service.i.E(r8);
    L19:
        MultiAnchorLinkContext r9 = this.b;
        if (r2 == null) goto L22;
        long r10 = r2.a;
    L23:
        r9.setAudienceChannelId(r10);
        this.b.getAudienceLaunchContext().d(r2);
        goto L24
    L22:
        r10 = 0;
        goto L23
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.c.clear();
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

    public MultiLinkContextComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, com.bytedance.android.livesdk.revenue.service.room.c r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        this.d = r2;
        this.e = r3;
        this.a = "MultiLinkContextComponent";
        this.b = new MultiAnchorLinkContext(r3, getContext());
        this.c = new CompositeDisposable();
    }
}
