package com.bytedance.android.live.room.navi.userinfo.cert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends d<AnchorTabLabel> {
    public boolean a;
    public View b;
    public final InterfaceC0211a c;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.userinfo.cert.a$a, reason: collision with other inner class name */
    public interface InterfaceC0211a {
        void a();

        ViewGroup getContainer();

        void onShow();

        void onUnload();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void b() {
        this.a = false;
        ViewGroup r0 = this.c.getContainer();
        if (r0 == null) goto L5;
        r0.removeAllViews();
        r0.setVisibility(8);
    L5:
        this.c.onUnload();
    }

    public final void c() {
        ViewGroup r0 = this.c.getContainer();
        if (r0 == null) goto L17;
        this.c.a();
        if (r0.getChildCount() <= 0) goto L7;
        r0.removeAllViews();
    L7:
        r0.setVisibility(8);
        ViewGroup r1 = this.c.getContainer();
        if (r1 == null) goto L12;
        Context r2 = r1.getContext();
        if (r2 == null) goto L12;
        Object r3 = r2.getSystemService("layout_inflater");
    L13:
        if (r3 == null) goto L16;
        View r4 = ((LayoutInflater) r3).inflate(2131567564, r0, false);
        this.b = r4;
        r0.addView(r4);
        this.a = false;
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    L12:
        r3 = null;
        goto L13
    }

    public a(com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.c = r2;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final /* bridge */ /* synthetic */ void a(AnchorTabLabel r1) {
        d(r1);
    }

    public final void d(AnchorTabLabel r9) {
        Intrinsics.checkNotNullParameter(r9, "tabLabel");
        if (this.a == false) goto L5;
        return;
    L5:
        ViewGroup r0 = this.c.getContainer();
        if (r0 == null) goto L39;
        this.a = true;
        View r2 = this.b;
        TextView r3 = null;
        if (r2 == null) goto L10;
        ImageView r4 = (ImageView) r2.findViewById(2131382637);
    L11:
        View r5 = this.b;
        if (r5 == null) goto L14;
        r3 = (TextView) r5.findViewById(2131382740);
    L14:
        k r6 = r9.getIcon();
        if (r6 == null) goto L26;
        if (r4 == null) goto L25;
        int r7 = r6.getWidth();
        int r8 = 10;
        if (r7 > 0) goto L21;
        r7 = 10;
    L21:
        int r10 = (int) UtilityKotlinExtentionsKt.h(r7);
        int r12 = r6.getHeight();
        if (r12 <= 0) goto L24;
        r8 = r12;
    L24:
        r4.setLayoutParams(new RelativeLayout.LayoutParams(r10, (int) UtilityKotlinExtentionsKt.h(r8)));
    L25:
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r6, new b(this, r4));
    L26:
        String r13 = r9.getContent();
        if (r13 == null) goto L37;
        RelativeLayout.LayoutParams r14 = new RelativeLayout.LayoutParams(-2, -2);
        if (r4 == null) goto L31;
        r14.addRule(1, r4.getId());
        r14.leftMargin = s1.f(2.8f);
    L31:
        if (r3 == null) goto L33;
        r3.setLayoutParams(r14);
    L33:
        if (r3 == null) goto L35;
        r3.setTextSize(1, 8.0f);
    L35:
        if (r3 == null) goto L37;
        r3.setText(r13);
    L37:
        r0.setVisibility(0);
        return;
    L10:
        r4 = null;
        goto L11
    }
}
