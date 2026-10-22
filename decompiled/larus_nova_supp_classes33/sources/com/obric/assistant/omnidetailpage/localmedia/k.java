package com.obric.assistant.omnidetailpage.localmedia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.platform.service.z2;
import com.larus.utils.i0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k extends com.larus.gallery.api.t<ifa.c> {
    public View f;

    public final boolean n() {
        return false;
    }

    public final ViewGroup.LayoutParams q() {
        int r1 = i5.c0();
        i0.a.getClass();
        return new ViewGroup.LayoutParams(-1, r1 + i0.g());
    }

    public k() {
    }

    public final View p(ViewGroup r8) {
        if (r8 == null) goto L5;
        Context r9 = r8.getContext();
        if (r9 == null) goto L5;
    L7:
        if (r9 == null) goto L22;
        FrameLayout r0 = new FrameLayout(r9);
        r0.setBackgroundResource(2131243489);
        int r10 = d.a;
        boolean r1 = true;
        if (z2.a.getCreationDetailLayoutConfig().d() == 1) goto L12;
        r1 = false;
    L12:
        int r11 = r0.getContext().getResources().getIdentifier("larus_accessibility_icon_close", "string", r0.getContext().getPackageName());
        ImageView r2 = new ImageView(r0.getContext());
        r2.setImageResource(2131241388);
        r2.setPadding(i5.c(), i5.c(), i5.c(), i5.c());
        if (r1 == false) goto L15;
        r2.setBackgroundResource(2131244566);
    L15:
        if (r11 == 0) goto L17;
        r2.setContentDescription(r0.getContext().getString(r11));
    L17:
        r2.setOnClickListener(new i(this));
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(i5.c0(), i5.c0(), 8388691);
        r12.setMarginStart(i5.r0());
        Unit r4 = Unit.INSTANCE;
        r0.addView(r2, r12);
        if (r1 == false) goto L20;
        FrameLayout r13 = new FrameLayout(r0.getContext());
        r13.setBackgroundResource(2131244566);
        r13.setOnClickListener(new j(this));
        ImageView r3 = new ImageView(r13.getContext());
        r3.setImageResource(2131241752);
        r3.setColorFilter(-1);
        r3.setImportantForAccessibility(2);
        r13.addView(r3, new FrameLayout.LayoutParams(i5.A(), i5.A(), 17));
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(i5.c0(), i5.c0(), 8388693);
        r5.setMarginEnd(i5.h());
        r0.addView(r13, r5);
        this.f = r13;
    L20:
        return r0;
    L22:
        throw new IllegalStateException("context is null");
    L5:
        r9 = getContext();
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
