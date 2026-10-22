package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKSearchFragment;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.widget.LinkNoScrollViewPager;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ AnchorInteractContainerFragment a;

    public k(AnchorInteractContainerFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        AnchorInteractContainerFragment r10 = this.a;
        int r0 = AnchorInteractContainerFragment.S;
        if (r10.d == null) goto L24;
        String r1 = "";
        if (r10.ha0() == true) goto L19;
        LinkNoScrollViewPager r12 = this.a.ba0(2131392847);
        if (r12 == null) goto L11;
        int r13 = r12.getCurrentItem();
        KProperty[] r2 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        if (r13 == 1) goto L19;
    L11:
        AnchorInteractContainerFragment r14 = this.a;
        AnchorLinkUserListFragment r3 = r14.s;
        if (r3 == null) goto L17;
        String r4 = r3.o;
        if (r4 == null) goto L17;
        String r5 = r4;
    L18:
        AnchorInteractContainerFragment.da0(r14, false);
        AnchorInteractContainerFragment r15 = this.a;
        com.bytedance.android.live.revlink.impl.control.dialog.r r6 = r15.d;
        int r7 = InteractPKSearchFragment.n;
        r6.zD(InteractPKSearchFragment.a.a(r6, r15.p, r5, false, false, new com.bytedance.android.live.revlink.impl.pk.utils.u(SearchSourceFlag.MAIN_LINK, "link_banner")));
        return;
    L17:
        r5 = "";
    L19:
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d r16 = this.a.q;
        if (r16 == null) goto L22;
        r1 = r16.ZP();
    L22:
        String r8 = r1;
        AnchorInteractContainerFragment.da0(this.a, true);
        AnchorInteractContainerFragment r17 = this.a;
        com.bytedance.android.live.revlink.impl.control.dialog.r r18 = r17.d;
        int r19 = InteractPKSearchFragment.n;
        r18.zD(InteractPKSearchFragment.a.a(r18, r17.p, r8, false, false, new com.bytedance.android.live.revlink.impl.pk.utils.u(SearchSourceFlag.UNDEFINE, "pk_banner")));
        return;
    }
}
