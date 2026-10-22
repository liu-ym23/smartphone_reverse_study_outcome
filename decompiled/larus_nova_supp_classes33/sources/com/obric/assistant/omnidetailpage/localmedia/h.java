package com.obric.assistant.omnidetailpage.localmedia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.platform.service.z2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h extends com.larus.gallery.api.t<ifa.c> {
    public View f;

    public h() {
    }

    public final View p(ViewGroup r9) {
        if (r9 == null) goto L5;
        Context r10 = r9.getContext();
        if (r10 == null) goto L5;
    L7:
        if (r10 == null) goto L18;
        FrameLayout r0 = new FrameLayout(r10);
        r0.setPadding(0, i5.z(), i5.r0(), 0);
        int r11 = d.a;
        if (z2.a.getCreationDetailLayoutConfig().d() != 1) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == false) goto L15;
        r0.setVisibility(8);
        return r0;
    L15:
        LinearLayout r13 = new LinearLayout(r0.getContext());
        r13.setOrientation(1);
        r13.setGravity(17);
        r13.setOnClickListener(new g(this));
        ImageView r4 = new ImageView(r13.getContext());
        r4.setImageResource(2131241757);
        r4.setImportantForAccessibility(2);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(i5.Q(), i5.Q());
        r5.gravity = 1;
        Unit r6 = Unit.INSTANCE;
        r13.addView(r4, r5);
        TextView r7 = new TextView(r13.getContext());
        r7.setText(r7.getContext().getString(2131901248));
        r7.setTextSize(0, i5.c());
        r7.setGravity(17);
        r7.setTextColor(-1);
        r7.setShadowLayer(2.0f, 0.0f, 0.0f, -16777216);
        r7.setLayerType(1, null);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2);
        r2.gravity = 1;
        r13.addView(r7, r2);
        this.f = r13;
        r0.addView(r13, new FrameLayout.LayoutParams(i5.c0(), i5.i0(), 8388661));
        return r0;
    L11:
        r12 = false;
        goto L12
    L18:
        throw new IllegalStateException("context is null");
    L5:
        r10 = getContext();
        goto L7
    }

    public final void w(Object r1, int r2) {
        ifa.c r3 = (ifa.c) r1;
        Intrinsics.checkNotNullParameter(r3, "data");
        ((com.larus.gallery.api.t) this).d = r3;
        View r4 = this.f;
        if (r4 == null) goto L6;
        r4.setVisibility(0);
        return;
    }
}
