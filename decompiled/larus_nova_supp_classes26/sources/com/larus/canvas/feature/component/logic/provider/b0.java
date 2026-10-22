package com.larus.canvas.feature.component.logic.provider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.canvas.impl.databinding.LarusLayoutCanvasGenerateTopProviderBinding;
import com.larus.utils.e1;
import com.larus.utils.i0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 extends com.larus.gallery.api.t<ky8.a> {
    public final j f;
    public LarusLayoutCanvasGenerateTopProviderBinding g;

    public final boolean n() {
        return false;
    }

    public b0(j r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        this.f = r2;
    }

    public final View p(ViewGroup r5) {
        View r6 = LayoutInflater.from(getContext()).inflate(2131562772, r5, false);
        int r0 = 2131363762;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r6, 2131363762);
        if (r1 == null) goto L39;
        r0 = 2131363806;
        if (((ImageView) ViewBindings.findChildViewById(r6, 2131363806)) == null) goto L39;
        r0 = 2131375226;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r6, 2131375226);
        if (r2 == null) goto L39;
        r0 = 2131388775;
        if (ViewBindings.findChildViewById(r6, 2131388775) == null) goto L39;
        this.g = new LarusLayoutCanvasGenerateTopProviderBinding((FrameLayout) r6, r1, r2);
        ViewGroup.LayoutParams r7 = r1.getLayoutParams();
        if (r7 == null) goto L37;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        i0 r3 = i0.a;
        r3.getClass();
        r8.topMargin = i0.g();
        r1.setLayoutParams(r8);
        LarusLayoutCanvasGenerateTopProviderBinding r9 = this.g;
        if (r9 == null) goto L21;
        TextView r10 = r9.c;
        if (r10 == null) goto L21;
        ViewGroup.LayoutParams r4 = r10.getLayoutParams();
        if (r4 == null) goto L20;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r4;
        r3.getClass();
        r11.topMargin = i0.g();
        r10.setLayoutParams(r11);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L21:
        LarusLayoutCanvasGenerateTopProviderBinding r12 = this.g;
        if (r12 == null) goto L24;
        ImageView r13 = r12.b;
    L25:
        e1.d(r13, new a0(this));
        if (this.f.b <= 1) goto L32;
        LarusLayoutCanvasGenerateTopProviderBinding r14 = this.g;
        if (r14 == null) goto L32;
        TextView r15 = r14.c;
        if (r15 == null) goto L32;
        StringBuilder r16 = new StringBuilder();
        r16.append(this.f.a + 1);
        r16.append('/');
        r16.append(this.f.b);
        r15.setText(r16.toString());
    L32:
        LarusLayoutCanvasGenerateTopProviderBinding r17 = this.g;
        if (r17 != null) goto L35;
        return null;
    L35:
        return r17.a;
    L24:
        r13 = null;
        goto L25
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }

    public final void w(Object r3, int r4) {
        ky8.a r5 = (ky8.a) r3;
        Intrinsics.checkNotNullParameter(r5, "data");
        ((com.larus.gallery.api.t) this).d = r5;
        if (this.f.b <= 1) goto L10;
        LarusLayoutCanvasGenerateTopProviderBinding r6 = this.g;
        if (r6 == null) goto L11;
        TextView r7 = r6.c;
        if (r7 == null) goto L12;
        StringBuilder r1 = new StringBuilder();
        r1.append(r4 + 1);
        r1.append('/');
        r1.append(this.f.b);
        r7.setText(r1.toString());
        return;
    L12:
        return;
    L11:
        return;
    }
}
