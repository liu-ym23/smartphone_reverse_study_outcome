package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.multianchorwindow.AnchorPauseView;
import com.bytedance.android.live.revlink.impl.multianchor.multianchorwindow.AnchorWaitingView;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.livesdk.link.model.p;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public final AnchorPauseView a;
    public final AnchorWaitingView b;
    public final FrameLayout c;

    public final void a(f31.k r6) {
        Intrinsics.checkNotNullParameter(r6, "status");
        if (this.a.getParent() != null) goto L6;
        this.c.addView(this.a, new FrameLayout.LayoutParams(r6.e, r6.f));
    L6:
        if (this.b.getParent() != null) goto L8;
        this.c.addView(this.b, new FrameLayout.LayoutParams(r6.e, r6.f));
    L8:
        RevLinkWindowRegionContext r0 = com.bytedance.android.live.revlink.impl.global.b.f0();
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r2 = r0.getPartnerService();
        if (r2 == null) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r3 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r2.getValue();
    L15:
        if (r3 == null) goto L17;
        boolean r4 = r3.n();
    L18:
        i11.b r5 = y.a();
        if (r5 == null) goto L23;
        p r7 = r5.getGuestInfo(u.c(), null);
        if (r7 == null) goto L23;
        r7.getInteractId();
    L23:
        Objects.toString(r6);
        if (r4 == false) goto L42;
        i11.b r8 = y.a();
        if (r8 == null) goto L30;
        p r9 = r8.getGuestInfo(u.c(), null);
        if (r9 == null) goto L30;
        String r10 = r9.getLinkMicIdStr();
    L32:
        if (Intrinsics.areEqual(r6.a, r10) == false) goto L42;
        ViewGroup.LayoutParams r12 = this.a.getLayoutParams();
        if ((r12 instanceof FrameLayout.LayoutParams) == false) goto L37;
        r1 = r12;
    L37:
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r1;
        if (r13 != null) goto L40;
        r13 = new FrameLayout.LayoutParams(-1, -1);
    L40:
        r13.width = -1;
        r13.height = -1;
        r13.leftMargin = 0;
        r13.topMargin = 0;
        this.a.setLayoutParams(r13);
        return;
    L30:
        r10 = null;
    L42:
        ViewGroup.LayoutParams r14 = this.a.getLayoutParams();
        if ((r14 instanceof FrameLayout.LayoutParams) == true) goto L45;
        r14 = null;
    L45:
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14;
        if (r15 != null) goto L48;
        r15 = new FrameLayout.LayoutParams(r6.e, r6.f);
    L48:
        r15.width = r6.e;
        r15.height = r6.f;
        r15.leftMargin = r6.c;
        r15.topMargin = r6.d;
        this.a.setLayoutParams(r15);
        ViewGroup.LayoutParams r16 = this.b.getLayoutParams();
        if ((r16 instanceof FrameLayout.LayoutParams) == false) goto L52;
        r1 = r16;
    L52:
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r1;
        if (r17 != null) goto L55;
        r17 = new FrameLayout.LayoutParams(r6.e, r6.f);
    L55:
        r17.width = r6.e;
        r17.height = r6.f;
        r17.leftMargin = r6.c;
        r17.topMargin = r6.d;
        this.b.setLayoutParams(r17);
        return;
    L17:
        r4 = false;
    L13:
        r3 = null;
        goto L15
    }

    public k(Context r4, FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "container");
        this.c = r5;
        AnchorPauseView r6 = new AnchorPauseView(r4);
        ViewUtilsKt.g(r6, false);
        r6.setBackground(s1.m(2131249836));
        Unit r2 = Unit.INSTANCE;
        this.a = r6;
        AnchorWaitingView r7 = new AnchorWaitingView(r4);
        ViewUtilsKt.g(r7, false);
        r7.setBackground(s1.m(2131249836));
        this.b = r7;
    }
}
