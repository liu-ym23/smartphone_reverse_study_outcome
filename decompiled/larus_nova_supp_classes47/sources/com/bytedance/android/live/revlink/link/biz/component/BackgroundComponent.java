package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.t6;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.v9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BackgroundComponent implements com.bytedance.android.live.revlink.link.biz.service.e {
    public final String a;
    public final CompositeDisposable b;
    public v9 c;
    public boolean d;
    public final BackgroundComponent$onPartnerEnableObserver$1 e;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf31/f;", "p1", "", "invoke", "(Lf31/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<f31.f, Unit> {
        public AnonymousClass1(BackgroundComponent r8) {
            super(1, r8, BackgroundComponent.class, "onLayoutStatusChange", "onLayoutStatusChange(Lcom/bytedance/android/live/revlink/impl/multianchor/model/LayoutStatus;)V", 0);
        }

        public final void invoke(f31.f r2) {
            BackgroundComponent r0 = (BackgroundComponent) ((CallableReference) this).receiver;
            if (r2 != null) goto L5;
            r0.getClass();
            return;
        L5:
            r0.getContext().getCommonService().j(r2);
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

    public final void c() {
        if (this.d == true) goto L6;
        getContext().getCommonService().g();
    L6:
        if (getContext().r9() == false) goto L8;
    L11:
        Function0 r0 = new BackgroundComponent$refreshBg$refreshBgFn$1(this);
    L12:
        r0.invoke();
        return;
    L8:
        if (this.d == true) goto L11;
        r0 = new BackgroundComponent$refreshBg$refreshBgFn$2(this);
        goto L12
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().hh(), new AnonymousClass1(this)), this.b);
        RevLinkWindowRegionContext r0 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r1 = r0.getPartnerService();
        if (r1 == null) goto L7;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r2 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r1.getValue();
    L8:
        if (r2 == null) goto L12;
        NextLiveData<Boolean> r3 = r2.g();
        if (r3 == null) goto L12;
        r3.observeForever(this.e);
    L12:
        c();
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.b b() {
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r0 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        if (r0 == null) goto L8;
        v9 r1 = r0.getBattleBgImage();
        if (r1 == null) goto L8;
        v9 r2 = r1;
    L9:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r3 == null) goto L14;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r4 = r3.getPkSkinConfig();
        if (r4 == null) goto L14;
        x2 r5 = r4.b;
    L15:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r6 == null) goto L20;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r7 = r6.getPkSkinConfig();
        if (r7 == null) goto L20;
        Long r8 = Long.valueOf(r7.a);
    L21:
        t6 r9 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).k;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "parseBgConfig with battleBgImage: " + r2 + ", skinConfig: " + r5 + ", skinType: " + r8 + ", linkMicUIConfig: " + r9, null, 4);
        if (r2 == null) goto L28;
        String r10 = r2.a;
        if (r10 == null) goto L28;
        if ((!StringsKt.isBlank(r10)) != true) goto L28;
        Pair r12 = TuplesKt.to(r2.c, r2.a);
    L61:
        if (r12 == null) goto L65;
        Boolean r13 = (Boolean) r12.getFirst();
        if (r13 == null) goto L65;
        boolean r14 = r13.booleanValue();
    L66:
        if (r14 == false) goto L72;
        if (r12 == null) goto L69;
        String r15 = (String) r12.getSecond();
    L70:
        if (r15 == null) goto L72;
        boolean r16 = true;
    L73:
        if (r12 == null) goto L76;
        String r17 = (String) r12.getSecond();
        if (r17 == null) goto L76;
    L77:
        String r18 = r17;
        if (r2 == null) goto L84;
        String r19 = r2.b;
        if (r19 == null) goto L84;
        if ((!StringsKt.isBlank(r19)) != true) goto L84;
        Pair r20 = TuplesKt.to(r2.c, r2.b);
    L119:
        if (r20 == null) goto L123;
        Boolean r22 = (Boolean) r20.getFirst();
        if (r22 == null) goto L123;
        boolean r23 = r22.booleanValue();
    L124:
        if (r23 == false) goto L130;
        if (r20 == null) goto L127;
        String r24 = (String) r20.getSecond();
    L128:
        if (r24 == null) goto L130;
        boolean r110 = true;
    L131:
        if (r20 == null) goto L134;
        String r25 = (String) r20.getSecond();
        if (r25 == null) goto L134;
    L135:
        String r111 = r25;
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == false) goto L142;
        b03.a r26 = b03.a.a;
        if (b03.a.b() == false) goto L142;
        if (getContext().r9() == true) goto L142;
        boolean r112 = true;
    L143:
        com.bytedance.android.live.revlink.link.domain.anchorimpl.b r27 = new com.bytedance.android.live.revlink.link.domain.anchorimpl.b(r18, r111, r16, r110, r112, r112);
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "parseBgConfig done with " + r27, null, 4);
        return r27;
    L142:
        r112 = false;
    L134:
        r25 = d51.c.A0.j();
        goto L135
    L127:
        r24 = null;
    L130:
        r110 = false;
    L123:
        r23 = false;
    L84:
        if (r5 == null) goto L86;
        py.k r28 = r5.getRoomBgBottomImage();
    L87:
        if (r28 == null) goto L92;
        py.k r29 = r5.getRoomBgBottomImage();
        if (r29 == null) goto L114;
        r20 = a(r29);
    L114:
        r20 = null;
        goto L119
    L92:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == false) goto L104;
        d51.c r30 = d51.c.A0;
        r41.d r32 = r30.p().get(r8);
        if (r32 == null) goto L96;
        String r33 = r32.a();
    L97:
        if (r33 == null) goto L104;
        Boolean r34 = Boolean.FALSE;
        r41.d r35 = r30.p().get(r8);
        if (r35 == null) goto L101;
        String r36 = r35.a();
    L102:
        r20 = TuplesKt.to(r34, r36);
        goto L119
    L101:
        r36 = null;
        goto L102
    L96:
        r33 = null;
    L104:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == true) goto L116;
        if (r9 == null) goto L107;
        py.k r37 = r9.getRoomBgBottomImage();
    L108:
        if (r37 == null) goto L116;
        if (y41.f.N.g() == false) goto L116;
        py.k r38 = r9.getRoomBgBottomImage();
        if (r38 == null) goto L114;
        r20 = a(r38);
        goto L119
    L107:
        r37 = null;
    L116:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == false) goto L118;
        r20 = TuplesKt.to(Boolean.FALSE, d51.c.A0.j());
        goto L119
    L118:
        r20 = TuplesKt.to(Boolean.FALSE, d51.c.A0.j());
        goto L119
    L86:
        r28 = null;
    L76:
        r17 = d51.c.A0.k();
        goto L77
    L69:
        r15 = null;
    L72:
        r16 = false;
    L65:
        r14 = false;
    L28:
        if (r5 == null) goto L30;
        py.k r39 = r5.getRoomBgTopImage();
    L31:
        if (r39 == null) goto L36;
        py.k r40 = r5.getRoomBgTopImage();
        if (r40 == null) goto L58;
        r12 = a(r40);
    L58:
        r12 = null;
        goto L61
    L36:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == false) goto L48;
        d51.c r42 = d51.c.A0;
        r41.d r43 = r42.p().get(r8);
        if (r43 == null) goto L40;
        String r44 = r43.b();
    L41:
        if (r44 == null) goto L48;
        Boolean r45 = Boolean.FALSE;
        r41.d r46 = r42.p().get(r8);
        if (r46 == null) goto L45;
        String r47 = r46.b();
    L46:
        r12 = TuplesKt.to(r45, r47);
        goto L61
    L45:
        r47 = null;
        goto L46
    L40:
        r44 = null;
    L48:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == true) goto L59;
        if (r9 == null) goto L51;
        py.k r48 = r9.getRoomBgTopImage();
    L52:
        if (r48 == null) goto L59;
        if (y41.f.N.g() == false) goto L59;
        py.k r49 = r9.getRoomBgTopImage();
        if (r49 == null) goto L58;
        r12 = a(r49);
        goto L61
    L51:
        r48 = null;
    L59:
        r12 = TuplesKt.to(Boolean.FALSE, d51.c.A0.k());
        goto L61
    L30:
        r39 = null;
    L20:
        r8 = null;
    L14:
        r5 = null;
    L8:
        r2 = this.c;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        RevLinkWindowRegionContext r0 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r1 = r0.getPartnerService();
        if (r1 == null) goto L7;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r2 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r1.getValue();
    L8:
        if (r2 == null) goto L12;
        NextLiveData<Boolean> r3 = r2.g();
        if (r3 == null) goto L12;
        r3.removeObserver(this.e);
    L12:
        this.b.clear();
        return;
    L7:
        r2 = null;
        goto L8
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
        return this.f;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent$onPartnerEnableObserver$1] */
    public BackgroundComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.f = r2;
        this.a = "BackgroundComponent";
        this.b = new CompositeDisposable();
        this.e = new BackgroundComponent$onPartnerEnableObserver$1(this);
    }

    public static Pair a(py.k r3) {
        Iterator r0 = r3.getUrls().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((!StringsKt.isBlank((String) r1)) == false) goto L4;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        return TuplesKt.to(Boolean.valueOf(r3.isAnimated()), r2);
    L8:
        r1 = null;
        goto L9
    }
}
