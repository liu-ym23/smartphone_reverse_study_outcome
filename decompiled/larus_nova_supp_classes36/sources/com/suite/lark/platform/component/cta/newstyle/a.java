package com.suite.lark.platform.component.cta.newstyle;

import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.image.api.SimpleTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends SimpleTarget<Drawable> {
    public final /* synthetic */ UDButton a;
    public final /* synthetic */ goc.b.d b;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r2) {
        super.onLoadFailed(r2);
        UDButton r3 = this.a;
        String r0 = this.b.b();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r3.setText(r0);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r4) {
        Drawable r5 = (Drawable) r4;
        if (r5 != null) goto L9;
        UDButton r6 = this.a;
        String r0 = this.b.b();
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        r6.setText(r0);
        return;
    L9:
        if (Intrinsics.areEqual(this.b.d(), "primary") == false) goto L11;
        int r1 = UIUtils.getColor(this.a.getContext(), 2131105560);
    L12:
        r5.mutate();
        r5.setTint(r1);
        int r2 = UIUtils.dp2px(this.a.getContext(), 17.0f);
        r5.setBounds(0, 0, r2, r2);
        UDButton r3 = this.a;
        final goc.b.d r7 = this.b;
        com.larksuite.component.universe_design.button.e.e(r3, r5, new CTADialogFragment$initFooterView$1$1$2$onResourceReady$1(r7));
        return;
    L11:
        r1 = UIUtils.getColor(this.a.getContext(), 2131105542);
        goto L12
    }

    public a(UDButton r1, goc.b.d r2) {
        this.a = r1;
        this.b = r2;
    }
}
