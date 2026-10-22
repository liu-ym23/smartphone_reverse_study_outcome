package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.dy0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k5 implements com.bytedance.android.live.base.model.user.q {
    public final /* synthetic */ e5 a;

    public k5(e5 r1) {
        this.a = r1;
    }

    public final void a(List<com.bytedance.android.live.base.model.user.f> r9) {
        if (((ArrayList) r9).isEmpty() == true) goto L16;
        com.bytedance.android.live.base.model.user.f r1 = (com.bytedance.android.live.base.model.user.f) ListProtector.get(r9, 0);
        ((com.bytedance.android.live.base.model.user.f) ListProtector.get(r9, 0)).getClass();
        py.k r10 = (ImageModel) com.bytedance.android.live.base.model.m.b(null, ImageModel.class);
        e5 r2 = this.a;
        r2.v = true;
        View r4 = r2.u;
        if (r4 != null) goto L7;
    L12:
        int r11 = dy0.a.getValue().intValue();
        View r0 = this.a.h;
        if (r0 == null) goto L17;
        r0.postDelayed(new j5(this), r11);
        return;
    L17:
        return;
    L7:
        if (r2.w == null) goto L12;
        if (r4.getParent() == null) goto L11;
        UtilityKotlinExtentionsKt.q(this.a.u);
    L11:
        e5 r3 = this.a;
        ((ViewGroup) r3.h).addView(r3.u);
        this.a.u.setVisibility(8);
        ViewGroup.LayoutParams r5 = this.a.u.getLayoutParams();
        r5.width = com.bytedance.android.live.core.utils.s1.f(38.0f);
        r5.height = com.bytedance.android.live.core.utils.s1.f(38.0f);
        this.a.u.setLayoutParams(r5);
        r1.getClass();
        RelativeLayout.LayoutParams r6 = (RelativeLayout.LayoutParams) this.a.w.getLayoutParams();
        r6.addRule(14, -1);
        r6.setMargins(com.bytedance.android.live.core.utils.s1.f(3.0f), com.bytedance.android.live.core.utils.s1.f(4.0f), com.bytedance.android.live.core.utils.s1.f(3.0f), com.bytedance.android.live.core.utils.s1.f(5.0f));
        r6.width = com.bytedance.android.live.core.utils.s1.f(31.0f);
        r6.height = com.bytedance.android.live.core.utils.s1.f(29.0f);
        r6.topMargin = com.bytedance.android.live.core.utils.s1.f(4.0f);
        this.a.w.setLayoutParams(r6);
        e5 r7 = this.a;
        r7.d(r10, r7.w, null);
        this.a.w.setShareType(1);
        goto L12
    }
}
