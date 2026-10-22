package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.impl.multianchor.ui.q {
    public final String a;
    public final CompositeDisposable b;
    public final g31.a c;
    public final b d;
    public boolean e;
    public boolean f;
    public final d21.b g;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d h;
    public final String i;
    public final com.bytedance.android.livesdk.revenue.service.room.c j;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i k;
    public final RevLinkDomainAnchorService l;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void a() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(this.k.d(this), this.b);
        g31.a r0 = this.c;
        r0.d = com.bytedance.android.live.revlink.link.biz.service.i.t(this).getGuestInfo(this.i, null);
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
        return this.h;
    }

    public final void e(boolean r13) {
        RevLinkDomainAnchorService r0 = this.l;
        String r3 = null;
        com.bytedance.android.livesdk.link.model.p r1 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).getGuestInfo(this.i, null);
        String r2 = "";
        if (r1 == null) goto L6;
        String r4 = r1.getLinkMicIdStr();
        if (r4 == null) goto L6;
    L8:
        if (r0.c(r4) == false) goto L19;
        d21.b r14 = this.g;
        com.bytedance.android.livesdk.link.model.p r5 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).getGuestInfo(this.i, null);
        if (r5 == null) goto L17;
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L17;
        String r7 = r6.getNickName();
        if (r7 == null) goto L17;
        r2 = r7;
    L17:
        r14.getClass();
        String r15 = d21.b.a(r2);
        int r8 = ToastUtil.a;
        com.bytedance.live.kmp.util.c r9 = com.bytedance.live.kmp.util.c.a;
        int r10 = w11.a.a;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131921811, new Object[]{r15}), 0);
        return;
    L19:
        g31.a r12 = this.c;
        boolean r16 = this.e;
        boolean r17 = this.f;
        if (r12.a == false) goto L47;
        if (r16 == true) goto L23;
        boolean r18 = r12.b;
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.b() == true) goto L37;
        com.bytedance.android.live.revlink.link.biz.service.i.B(r12).B(r18);
    L37:
        if (r12.a == false) goto L61;
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r19 = r12.h;
        if (r19 == null) goto L59;
        com.bytedance.android.livesdk.link.model.p r20 = r12.d;
        if (r20 == null) goto L46;
        IBaseUser r22 = r20.getUser();
        if (r22 == null) goto L46;
        r3 = iz.a.a(r22);
    L46:
        r19.f(r3, null, !r18, com.bytedance.android.live.revlink.impl.multianchor.ui.r.a.a, r13);
        return;
    L59:
        return;
    L61:
        return;
    L23:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.b() == true) goto L25;
        com.bytedance.android.live.revlink.link.biz.service.i.B(r12).B(r12.c);
    L25:
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r23 = r12.h;
        if (r23 == null) goto L57;
        com.bytedance.android.livesdk.link.model.p r110 = r12.d;
        if (r110 == null) goto L32;
        IBaseUser r111 = r110.getUser();
        if (r111 == null) goto L32;
        r3 = iz.a.a(r111);
    L32:
        r23.l(r3, !r12.c, false, r12.b, r17);
        return;
    L57:
        return;
    L47:
        d21.b r112 = r12.e;
        com.bytedance.android.livesdk.link.model.p r24 = r12.d;
        if (r24 == null) goto L55;
        IBaseUser r25 = r24.getUser();
        if (r25 == null) goto L55;
        String r26 = r25.getNickName();
        if (r26 == null) goto L55;
        r2 = r26;
    L55:
        r112.getClass();
        String r113 = d21.b.a(r2);
        int r27 = ToastUtil.a;
        com.bytedance.live.kmp.util.c r28 = com.bytedance.live.kmp.util.c.a;
        int r29 = w11.a.a;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131917486, new Object[]{r113}), 0);
        return;
    L6:
        r4 = "";
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void b(boolean r1, boolean r2) {
        this.e = r1;
        this.f = r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void d(String r4, boolean r5, com.bytedance.android.live.revlink.impl.multianchor.ui.r.b r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        if ((!Intrinsics.areEqual(r4, this.i)) == false) goto L5;
        return;
    L5:
        g31.a r7 = this.c;
        com.bytedance.android.livesdk.link.model.p r8 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).getGuestInfo(r4, null);
        if (r8 == null) goto L10;
        IBaseUser r9 = r8.getUser();
        if (r9 == null) goto L10;
        r9.getNickName();
    L10:
        if (r5 == false) goto L12;
        r7.b = true;
        return;
    L12:
        r7.b = false;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.q
    public final void c(String r3, String r4, boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "interactID");
        if ((!Intrinsics.areEqual(r3, this.i)) == false) goto L5;
        return;
    L5:
        g31.a r8 = this.c;
        if (r8.c == r5) goto L54;
        r8.c = r5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = com.bytedance.android.live.revlink.link.biz.service.i.S(r8);
        if (r0 == null) goto L18;
        com.bytedance.android.livesdk.link.model.p r1 = r8.d;
        if (r1 == null) goto L14;
        String r2 = r1.getLinkMicIdStr();
        if (r2 == null) goto L14;
    L16:
        if (r0.isInAudioPunish(r2) != true) goto L18;
        String r9 = "2";
    L27:
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r10 = com.bytedance.android.live.revlink.link.biz.service.i.U(r8);
        if (r10 == null) goto L31;
        r10.b("double_mute_status", r9);
    L31:
        if (r7 == true) goto L35;
        if (r6 == true) goto L47;
        int r12 = ToastUtil.a;
        int r13 = w11.a.a;
        ToastUtil.a(2131921403, 0);
        return;
    L47:
        return;
    L35:
        if (r5 == false) goto L41;
        if (r6 == false) goto L41;
        if (((Number) l51.a.N.getValue(null, l51.a.a[40])).intValue() > 1) goto L40;
        int r14 = ToastUtil.a;
        int r15 = w11.a.a;
        ToastUtil.a(2131921400, 0);
        return;
    L40:
        int r16 = ToastUtil.a;
        int r17 = w11.a.a;
        ToastUtil.a(2131921402, 0);
        return;
    L41:
        if (r5 == false) goto L51;
        if (r6 == false) goto L44;
        return;
    L44:
        if (((Number) l51.a.R.getValue(null, l51.a.a[46])).intValue() > 3) goto L53;
        int r18 = ToastUtil.a;
        int r19 = w11.a.a;
        ToastUtil.a(2131921401, 0);
        return;
    L53:
        return;
    L51:
        return;
    L14:
        r2 = "";
    L18:
        if (r7 == true) goto L24;
        if (r5 == false) goto L22;
    L26:
        r9 = DataType.FALSE;
        goto L27
    L22:
        if (r8.b == false) goto L26;
    L25:
        r9 = DataType.TRUE;
        goto L27
    L24:
        if (r5 == false) goto L26;
    }

    public s(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, String r3, com.bytedance.android.livesdk.revenue.service.room.c r4, com.bytedance.android.live.revlink.impl.multianchor.ui.i r5, RevLinkDomainAnchorService r6, AnchorUILayoutManager r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r4, "roomService");
        Intrinsics.checkNotNullParameter(r5, "muteManager");
        Intrinsics.checkNotNullParameter(r6, "domainService");
        Intrinsics.checkNotNullParameter(r7, "uiLayoutManager");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.a = "WindowBizImpl";
        this.b = new CompositeDisposable();
        this.c = new g31.a(r4, getContext(), r5);
        this.d = new b(getContext(), r7);
        this.g = new d21.b();
    }
}
