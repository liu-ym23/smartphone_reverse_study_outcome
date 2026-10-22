package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiMuteManager implements com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.impl.multianchor.ui.i {
    public final String a;
    public final List<com.bytedance.android.live.revlink.impl.multianchor.ui.q> b;
    public final HashSet<String> c;
    public final boolean d;
    public final CompositeDisposable e;
    public final CompositeDisposable f;
    public final d21.b g;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a h;
    public final RevLinkDomainAnchorService i;
    public final com.bytedance.android.live.revenuelink.rtc.i j;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiMuteManager$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Ls51/c;", "p1", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<List<? extends s51.c>, Unit> {
        public AnonymousClass2(MultiMuteManager r8) {
            super(1, r8, MultiMuteManager.class, "refreshMuteStateSubscribe", "refreshMuteStateSubscribe(Ljava/util/List;)V", 0);
        }

        public final void invoke(List<s51.c> r6) {
            final MultiMuteManager r0 = (MultiMuteManager) ((CallableReference) this).receiver;
            r0.f.clear();
            if (r6 == null) goto L8;
            Iterator<T> r7 = r6.iterator();
        L6:
            if (r7.hasNext() == false) goto L10;
            final s51.c r1 = (s51.c) r7.next();
            jy0.b.a(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0), "add mic muteState subscribe for uid: " + r1.d);
            com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.e(r1.i.b, false, new MultiMuteManager$refreshMuteStateSubscribe$$inlined$forEach$lambda$1(r1, r0)), r0.f);
            goto L6
        L10:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((List) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void a() {
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.live.revlink.impl.multianchor.ui.q) r0.next()).a();
        goto L4
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        List r0 = (List) this.i.d.getValue();
        if (r0 == null) goto L10;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        s51.b r2 = (s51.b) r1.next();
        if (com.bytedance.android.live.revlink.link.domain.mic.component.m.a(r2) == false) goto L6;
        this.c.add(r2.c());
    L10:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(this.i.e, new AnonymousClass2(this)), this.e);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.e.clear();
        this.f.clear();
        ((ArrayList) this.b).clear();
        this.c.clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean h() {
        List r0 = (List) this.i.e.getValue();
        List r1 = r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        List r3 = r0;
        if ((r3 instanceof Collection) == true) goto L14;
    L16:
        Iterator r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L32;
        s51.c r5 = (s51.c) r4.next();
        String r6 = r5.f();
        boolean r7 = !Intrinsics.areEqual(r5.d, this.i.r.getRoomContext().getCommonUser().getIdString());
        if (r7 == false) goto L22;
        boolean r8 = this.i.c(r6);
    L24:
        if (com.bytedance.android.live.revlink.link.domain.mic.component.m.a(r5) == true) goto L29;
        if (r8 == true) goto L29;
        if (r7 == false) goto L29;
        boolean r9 = false;
    L30:
        if (r9 == true) goto L18;
        return false;
    L29:
        r9 = true;
        goto L30
    L22:
        r8 = false;
    L32:
        return true;
    L14:
        if (r3.isEmpty() == false) goto L16;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
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
        return this.h;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void b(String r2) {
        HashSet<String> r0 = this.c;
        if (r0 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r0).remove(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final Disposable d(final com.bytedance.android.live.revlink.impl.multianchor.ui.q r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        g(r2);
        int r0 = com.bytedance.revenue.platform.api.core.rx.h.a;
        return com.bytedance.revenue.platform.api.core.rx.h.a(new MultiMuteManager$subscribeMuteStateChange$1(this, r2));
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "linkMicId");
        return this.c.contains(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void g(com.bytedance.android.live.revlink.impl.multianchor.ui.q r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.b).contains(r2) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.b).add(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void k(com.bytedance.android.live.revlink.impl.multianchor.ui.q r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.b).remove(r2);
    }

    public final void m(boolean r13) {
        if (h() != r13) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
        List r0 = (List) this.i.e.getValue();
        if (r0 == null) goto L66;
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L66;
        s51.c r3 = (s51.c) r1.next();
        String r4 = r3.f();
        String r5 = r3.d;
        boolean r6 = !Intrinsics.areEqual(r5, this.i.r.getRoomContext().getCommonUser().getIdString());
        if (r6 == false) goto L13;
        boolean r7 = this.i.c(r4);
    L14:
        if (r7 == true) goto L9;
        if (r6 == false) goto L9;
        if (r13 == false) goto L18;
        this.c.add(r4);
    L19:
        String r8 = "";
        if (this.d == false) goto L52;
        com.bytedance.android.livesdk.link.model.p r9 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).getGuestInfo(r5, r4);
        if (r9 == null) goto L52;
        com.bytedance.android.livesdk.link.model.bridge.j r10 = com.bytedance.android.livesdk.link.model.q.b(r9);
        if (r10 == null) goto L52;
        if (Intrinsics.areEqual(r4, r10.getMainLinkMicId()) == false) goto L35;
        com.bytedance.android.live.revenuelink.rtc.i r12 = this.j;
        String r14 = r10.getBackupLinkMicId();
        if (r14 != null) goto L30;
        r14 = "";
    L30:
        r12.h(r14, r13, "syncMainToBack");
        String r15 = r10.getBackupLinkMicId();
        if (r15 != null) goto L33;
        r15 = "";
    L33:
        Intrinsics.checkNotNullParameter(r15, "linkMicId");
        r3.i.g(r15, r13);
    L35:
        if (Intrinsics.areEqual(r4, r10.getBackupLinkMicId()) == false) goto L43;
        com.bytedance.android.live.revenuelink.rtc.i r16 = this.j;
        String r17 = r10.getMainLinkMicId();
        if (r17 != null) goto L39;
        r17 = "";
    L39:
        r16.h(r17, r13, "syncBackToMain");
        String r18 = r10.getMainLinkMicId();
        if (r18 != null) goto L42;
        r18 = "";
    L42:
        Intrinsics.checkNotNullParameter(r18, "linkMicId");
        r3.i.g(r18, r13);
    L43:
        if (r13 == false) goto L51;
        HashSet<String> r19 = this.c;
        String r20 = r10.getMainLinkMicId();
        if (r20 != null) goto L47;
        r20 = "";
    L47:
        r19.add(r20);
        HashSet<String> r22 = this.c;
        String r23 = r10.getBackupLinkMicId();
        if (r23 != null) goto L50;
        r23 = "";
    L50:
        r22.add(r23);
        goto L52
    L51:
        this.c.remove(r10.getMainLinkMicId());
        this.c.remove(r10.getBackupLinkMicId());
    L52:
        com.bytedance.android.live.revlink.link.domain.mic.component.l r24 = r3.i;
        if (Intrinsics.areEqual((Boolean) r24.b.getValue(), Boolean.valueOf(r13)) == true) goto L9;
        com.bytedance.android.live.revenuelink.rtc.i r25 = r24.g;
        if (r25 == null) goto L61;
        String r26 = r24.e;
        if (r26 != null) goto L60;
        r26 = "";
    L60:
        r25.h(r26, r13, "MuteComponent_allmute");
    L61:
        String r27 = r24.e;
        if (r27 == null) goto L65;
        r8 = r27;
    L65:
        r24.g(r8, r13);
        r24.b.setValue(Boolean.valueOf(r13));
        goto L9
    L18:
        this.c.remove(r4);
        goto L19
    L13:
        r7 = false;
    L66:
        if (r13 == false) goto L72;
        r31.a r28 = getContext().getLinkNetwork();
        long r29 = getContext().getRoomID();
        long r30 = com.bytedance.android.live.revlink.link.biz.service.i.A(this).a();
        int r2 = t11.a.a;
        if (r13 == false) goto L70;
        int r32 = 1;
    L71:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r28.M(r29, 7, r30, r32, true, "")).subscribe(i.a, j.a), this.e);
        goto L72
    L70:
        r32 = 2;
    L72:
        if (r13 == false) goto L74;
        int r110 = ToastUtil.a;
        com.bytedance.live.kmp.util.c r111 = com.bytedance.live.kmp.util.c.a;
        int r112 = w11.a.a;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131920556, new Object[0]), 0);
        return;
    L74:
        int r113 = ToastUtil.a;
        com.bytedance.live.kmp.util.c r114 = com.bytedance.live.kmp.util.c.a;
        int r115 = w11.a.a;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131920564, new Object[0]), 0);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void c(boolean r3, boolean r4) {
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.live.revlink.impl.multianchor.ui.q) r0.next()).b(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean j(String r4, String r5) {
        s51.c r6 = this.i.d(r4, r5);
        String r7 = "";
        if (r6 == null) goto L6;
        String r0 = r6.f();
        if (r0 == null) goto L6;
    L7:
        if (r6 == null) goto L13;
        String r1 = r6.d;
        if (r1 == null) goto L13;
        r7 = r1;
    L13:
        if ((!Intrinsics.areEqual(r7, this.i.r.getRoomContext().getCommonUser().getIdString())) == false) goto L15;
        boolean r8 = this.i.c(r0);
    L16:
        if (r6 != null) goto L18;
    L19:
        if (r8 == true) goto L24;
        return false;
    L24:
        return true;
    L18:
        if (com.bytedance.android.live.revlink.link.domain.mic.component.m.a(r6) != true) goto L19;
        return true;
    L15:
        r8 = false;
    L6:
        r0 = "";
        goto L7
    }

    public MultiMuteManager(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r2, RevLinkDomainAnchorService r3, com.bytedance.android.live.revenuelink.rtc.i r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "domainService");
        Intrinsics.checkNotNullParameter(r4, "rtcManager");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.a = "MultiMuteManager";
        this.b = new ArrayList();
        this.c = new HashSet();
        this.d = !y41.a.c.a();
        this.e = new CompositeDisposable();
        this.f = new CompositeDisposable();
        this.g = new d21.b();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void i(final boolean r4, final com.bytedance.android.live.revlink.impl.multianchor.ui.r.c r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (r4 == true) goto L5;
    L8:
        m(r4);
        return;
    L5:
        if (((Boolean) l51.a.T.getValue(null, l51.a.a[48])).booleanValue() == false) goto L8;
        if (r6 == true) goto L8;
        getContext().ko().i(new MultiMuteManager$setAllMuteState$1(this, r4, r5));
    }

    public final void n(String r20, String r22, boolean r23) {
        s51.c r2 = this.i.d(r20, r22);
        String r3 = "";
        if (r2 == null) goto L6;
        String r4 = r2.f();
        if (r4 == null) goto L6;
    L7:
        if (r2 == null) goto L10;
        String r5 = r2.d;
        if (r5 == null) goto L10;
    L11:
        if (r23 == false) goto L13;
        this.c.add(r4);
    L14:
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
        if (this.d == false) goto L52;
        com.bytedance.android.livesdk.link.model.p r6 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).getGuestInfo(r5, r4);
        if (r6 == null) goto L52;
        com.bytedance.android.livesdk.link.model.bridge.j r7 = com.bytedance.android.livesdk.link.model.q.b(r6);
        if (r7 == null) goto L52;
        if (Intrinsics.areEqual(r4, r7.getMainLinkMicId()) == false) goto L32;
        com.bytedance.android.live.revenuelink.rtc.i r8 = this.j;
        String r9 = r7.getBackupLinkMicId();
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        r8.h(r9, r23, "syncMainToBack");
        if (r2 == null) goto L32;
        String r10 = r7.getBackupLinkMicId();
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        Intrinsics.checkNotNullParameter(r10, "linkMicId");
        r2.i.g(r10, r23);
    L32:
        if (Intrinsics.areEqual(r4, r7.getBackupLinkMicId()) == false) goto L42;
        com.bytedance.android.live.revenuelink.rtc.i r12 = this.j;
        String r13 = r7.getMainLinkMicId();
        if (r13 != null) goto L36;
        r13 = "";
    L36:
        r12.h(r13, r23, "syncBackToMain");
        if (r2 == null) goto L42;
        String r14 = r7.getMainLinkMicId();
        if (r14 != null) goto L41;
        r14 = "";
    L41:
        Intrinsics.checkNotNullParameter(r14, "linkMicId");
        r2.i.g(r14, r23);
    L42:
        if (r23 == false) goto L50;
        HashSet<String> r15 = this.c;
        String r16 = r7.getMainLinkMicId();
        if (r16 != null) goto L46;
        r16 = "";
    L46:
        r15.add(r16);
        HashSet<String> r17 = this.c;
        String r18 = r7.getBackupLinkMicId();
        if (r18 != null) goto L49;
        r18 = "";
    L49:
        r17.add(r18);
        goto L52
    L50:
        this.c.remove(r7.getMainLinkMicId());
        this.c.remove(r7.getBackupLinkMicId());
    L52:
        if (r2 == null) goto L80;
        com.bytedance.android.live.revlink.link.domain.mic.component.l r19 = r2.i;
        if (Intrinsics.areEqual((Boolean) r19.b.getValue(), Boolean.valueOf(r23)) == true) goto L80;
        com.bytedance.android.live.revenuelink.rtc.i r24 = r19.g;
        if (r24 == null) goto L62;
        String r25 = r19.e;
        if (r25 != null) goto L61;
        r25 = "";
    L61:
        r24.h(r25, r23, "MuteComponent_mute");
    L62:
        String r26 = r19.e;
        if (r26 != null) goto L65;
        r26 = "";
    L65:
        r19.g(r26, r23);
        r19.b.setValue(Boolean.valueOf(r23));
        y41.e r27 = y41.e.o;
        r27.getClass();
        if (((Boolean) y41.e.m.getValue(r27, y41.e.a[11])).booleanValue() == false) goto L78;
        com.bytedance.android.livesdk.link.model.p r28 = r19.f.getGuestInfo(r19.d, null);
        if (r28 == null) goto L72;
        IBaseUser r29 = r28.getUser();
        if (r29 == null) goto L72;
        long r30 = com.bytedance.android.live.base.model.user.n.a(r29);
    L73:
        long r110 = r30;
        r31.a r32 = r19.c.getLinkNetwork();
        long r111 = r19.c.getRoomID();
        int r112 = r19.c.getScene();
        String r113 = r19.d;
        long r114 = r19.c.G();
        int r33 = t11.a.a;
        if (r23 == false) goto L76;
        int r115 = 1;
    L77:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r32.p(r111, r112, r113, r114, r110, r115)).subscribe(com.bytedance.android.live.revlink.link.domain.mic.component.h.a, com.bytedance.android.live.revlink.link.domain.mic.component.i.a), r19.a);
        goto L80
    L76:
        r115 = 2;
    L72:
        r30 = 0;
        goto L73
    L78:
        if (r23 == false) goto L80;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r19.c.getLinkNetwork().mute(r19.c.getRoomID(), r19.c.getScene(), r19.d, r19.c.G())).subscribe(com.bytedance.android.live.revlink.link.domain.mic.component.j.a, com.bytedance.android.live.revlink.link.domain.mic.component.k.a), r19.a);
    L80:
        if (r23 == false) goto L93;
        int r1 = ToastUtil.a;
        com.bytedance.live.kmp.util.c r34 = com.bytedance.live.kmp.util.c.a;
        int r35 = w11.a.a;
        Object[] r36 = new Object[1];
        if (r2 == null) goto L91;
        com.bytedance.android.livesdk.link.model.p r37 = r2.f.getGuestInfo(r2.d, null);
        if (r37 == null) goto L91;
        IBaseUser r38 = r37.getUser();
        if (r38 == null) goto L91;
        String r39 = r38.getNickName();
        if (r39 == null) goto L91;
        r3 = r39;
    L91:
        r36[0] = r3;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131917485, r36), 0);
        return;
    L93:
        return;
    L13:
        this.c.remove(r4);
    L10:
        r5 = "";
    L6:
        r4 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void f(final String r9, final String r10, final boolean r12, final com.bytedance.android.live.revlink.impl.multianchor.ui.r r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "source");
        if (r12 == true) goto L5;
    L20:
        n(r9, r10, r12);
        return;
    L5:
        if (l51.a.h() == false) goto L20;
        if (r14 == true) goto L20;
        s51.c r15 = this.i.d(r9, r10);
        d21.b r0 = this.g;
        if (r15 == null) goto L15;
        com.bytedance.android.livesdk.link.model.p r16 = r15.f.getGuestInfo(r15.d, null);
        if (r16 == null) goto L15;
        IBaseUser r17 = r16.getUser();
        if (r17 == null) goto L15;
        String r18 = r17.getNickName();
        if (r18 == null) goto L15;
    L16:
        r0.getClass();
        String r19 = d21.b.a(r18);
        if (r19 != null) goto L19;
        com.bytedance.live.kmp.util.c r110 = com.bytedance.live.kmp.util.c.a;
        int r111 = w11.a.a;
        r19 = com.bytedance.live.kmp.util.c.a(2131917698, new Object[0]);
    L19:
        final String r6 = r19;
        getContext().ko().i(new MultiMuteManager$setMuteState$1(this, r9, r10, r12, r13, r6));
        return;
    L15:
        r18 = "";
        goto L16
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void l(String r18, boolean r19, boolean r20, boolean r22, boolean r23) {
        s51.c r8 = this.i.d(r18, null);
        if (r8 == null) goto L6;
        String r1 = r8.f();
        if (r1 == null) goto L6;
    L7:
        String r9 = r1;
        int r2 = 0;
        if (r20 == false) goto L22;
        com.bytedance.android.live.revenuelink.rtc.i r3 = this.j;
        if (r19 == false) goto L12;
        boolean r4 = false;
    L13:
        r3.h(r9, r4, "syncChorusState");
        if (r19 == true) goto L22;
        this.j.b0(r9, 100, "multiChorusAutoUnMute");
        if (r22 == false) goto L22;
        r31.a r10 = getContext().getLinkNetwork();
        long r12 = getContext().getRoomID();
        if (r8 == null) goto L20;
        String r14 = r8.d;
    L21:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r10.mute(r12, 7, r14, com.bytedance.android.live.revlink.link.biz.service.i.A(this).a())).subscribe(k.a, l.a), this.e);
        goto L22
    L20:
        r14 = null;
        goto L21
    L12:
        r4 = r22;
    L22:
        if (r23 == false) goto L28;
        com.bytedance.android.live.revenuelink.rtc.i r5 = this.j;
        if (r19 == true) goto L27;
        r2 = 100;
    L27:
        r5.b0(r9, r2, "multiChorus");
    L28:
        if (r19 == false) goto L32;
        if (r20 == true) goto L32;
        if (r23 == false) goto L32;
        com.bytedance.tools.kcp.spongepreference.runtime.a r6 = l51.a.R;
        KProperty[] r7 = l51.a.a;
        r6.setValue(null, r7[46], Integer.valueOf(((Number) r6.getValue(null, r7[46])).intValue() + 1));
    L32:
        Iterator r13 = ((ArrayList) this.b).iterator();
    L34:
        if (r13.hasNext() == false) goto L40;
        com.bytedance.android.live.revlink.impl.multianchor.ui.q r15 = (com.bytedance.android.live.revlink.impl.multianchor.ui.q) r13.next();
        if (r8 == null) goto L38;
        String r16 = r8.d;
    L39:
        r15.c(r16, r9, r19, r20, r23);
        goto L34
    L38:
        r16 = null;
        goto L39
    L40:
        return;
    L6:
        r1 = "";
        goto L7
    }
}
