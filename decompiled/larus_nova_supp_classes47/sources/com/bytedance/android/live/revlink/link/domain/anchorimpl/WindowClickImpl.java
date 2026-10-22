package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class WindowClickImpl {
    public final s51.b a;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a b;
    public final int c;

    public final void a() {
        if (this.a.e() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        p21.b r3 = this.b.ne();
        this.b.getScene();
        com.bytedance.android.live.revlink.impl.global.c r4 = r3.a;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r5 = null;
        if (r4 == null) goto L11;
        com.bytedance.android.live.revlink.impl.multianchor.utils.a r6 = r4.km();
    L12:
        if (r6 != null) goto L14;
    L15:
        w r7 = r3.e();
        if (r7 == null) goto L18;
        UILayout r8 = r7.b();
    L20:
        if (r8 == UILayout.FULL) goto L44;
        com.bytedance.android.live.revlink.impl.global.c r9 = r3.a;
        if (r9 == null) goto L29;
        RevLinkWindowRegionContext r10 = r9.P8();
        if (r10 == null) goto L29;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r12 = r10.getPartnerService();
        if (r12 == null) goto L29;
        r5 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r12.getValue();
    L29:
        if (r5 != null) goto L31;
    L33:
        w r13 = r3.e();
        if (r13 == null) goto L36;
        int r14 = r13.i();
    L37:
        y41.d r15 = y41.d.j;
        r15.getClass();
        Integer[] r16 = (Integer[]) y41.d.c.getValue(r15, y41.d.a[1]);
        int r17 = r16.length;
        int r18 = 0;
    L38:
        if (r18 >= r17) goto L46;
        if (r16[r18].intValue() != r14) goto L42;
        boolean r19 = true;
    L43:
        if (r19 == true) goto L44;
        r18 = r18 + 1;
        goto L38
    L42:
        r19 = false;
        goto L43
    L46:
        boolean r20 = false;
    L47:
        if (r0 == true) goto L50;
        if (r20 == true) goto L50;
        return;
    L50:
        boolean r22 = this.b.getUiLayout().getValue() instanceof o51.e.C0283e;
        if (r22 == false) goto L56;
        if (this.a.a() == false) goto L56;
        int r23 = ToastUtil.a;
        int r24 = w11.a.a;
        ToastUtil.a(2131922355, 0);
    L56:
        if (this.a.a() == false) goto L73;
        if (r22 == false) goto L59;
        return;
    L59:
        if (r0 == true) goto L61;
        return;
    L61:
        RevLinkWindowRegionContext r1 = this.b.P8();
        if (r1 == null) goto L71;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r2 = r1.getPartnerService();
        if (r2 == null) goto L71;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r25 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r2.getValue();
        if (r25 == null) goto L71;
        if (r25.n() != true) goto L71;
        this.b.ko().showUserProfile(this.a.getUid());
        return;
    L71:
        k r26 = this.b.ko();
        String r27 = this.a.getUid();
        String r28 = this.a.f();
        this.a.g();
        r26.a(r27, r28);
        return;
    L73:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(this.b) == false) goto L75;
        this.b.ko().e(this.a.getUid(), this.a.f(), this.a.g(), new WindowClickImpl$onWindowClick$1(this));
        return;
    L75:
        this.b.ko().g(this.a.getUid(), this.a.f(), this.a.g(), this.c);
        return;
    L36:
        r14 = 0;
        goto L37
    L31:
        if (r5.n() != true) goto L33;
    L44:
        r20 = true;
        goto L47
    L18:
        r8 = null;
        goto L20
    L14:
        if (r6.a() == true) goto L44;
    L11:
        r6 = null;
        goto L12
    L5:
        if (this.b.ne().a(this.b.getScene()) == false) goto L7;
        r0 = true;
        goto L8
    }

    public WindowClickImpl(s51.b r2, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "mic");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
