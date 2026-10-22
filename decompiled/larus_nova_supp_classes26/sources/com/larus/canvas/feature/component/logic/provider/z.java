package com.larus.canvas.feature.component.logic.provider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.gallery.impl.databinding.LarusGalleryChatTitleBinding;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z extends com.larus.gallery.api.t<ky8.a> {
    public LarusGalleryChatTitleBinding f;

    public final boolean n() {
        return false;
    }

    public final ViewGroup.LayoutParams q() {
        int r1 = i5.c0();
        i0.a.getClass();
        return new ViewGroup.LayoutParams(-1, r1 + i0.g());
    }

    public z(j r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
    }

    public final View p(ViewGroup r2) {
        LarusGalleryChatTitleBinding r3 = LarusGalleryChatTitleBinding.a(LayoutInflater.from(getContext()), r2);
        this.f = r3;
        ImageView r4 = r3.b;
        if (r4 == null) goto L5;
        r4.setOnClickListener(new x(this));
    L5:
        LarusGalleryChatTitleBinding r5 = this.f;
        if (r5 == null) goto L10;
        ConstraintLayout r6 = r5.e;
        if (r6 == null) goto L10;
        r6.setOnClickListener(new y(this));
    L10:
        LarusGalleryChatTitleBinding r7 = this.f;
        if (r7 != null) goto L15;
        return null;
    L15:
        return r7.a;
    }

    public final void w(Object r3, int r4) {
        ky8.a r5 = (ky8.a) r3;
        Intrinsics.checkNotNullParameter(r5, "data");
        ((com.larus.gallery.api.t) this).d = r5;
        if (Intrinsics.areEqual(r5.a, "origin") == false) goto L9;
        LarusGalleryChatTitleBinding r6 = this.f;
        if (r6 == null) goto L23;
        TextView r7 = r6.g;
        if (r7 == null) goto L23;
        e1.o(r7);
    L23:
        ky8.a r8 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        if (r8 == null) goto L43;
        String r9 = r8.n;
        if (r9 == null) goto L43;
        Unit r0 = null;
        if (o0.d(r9) == true) goto L31;
        r9 = null;
    L31:
        if (r9 == null) goto L43;
        LarusGalleryChatTitleBinding r10 = this.f;
        if (r10 == null) goto L37;
        TextView r11 = r10.f;
        if (r11 == null) goto L37;
        r11.setText(r9);
    L37:
        LarusGalleryChatTitleBinding r12 = this.f;
        if (r12 == null) goto L42;
        TextView r13 = r12.f;
        if (r13 == null) goto L42;
        e1.x(r13);
        r0 = Unit.INSTANCE;
    L42:
        if (r0 == null) goto L43;
        return;
    L43:
        LarusGalleryChatTitleBinding r14 = this.f;
        if (r14 == null) goto L50;
        TextView r15 = r14.f;
        if (r15 == null) goto L51;
        e1.o(r15);
        Unit r16 = Unit.INSTANCE;
        return;
    L51:
        return;
    L50:
        return;
    L9:
        LarusGalleryChatTitleBinding r17 = this.f;
        if (r17 == null) goto L14;
        TextView r18 = r17.g;
        if (r18 == null) goto L14;
        e1.x(r18);
    L14:
        ky8.a r19 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        if (r19 == null) goto L23;
        Long r20 = r19.m;
        if (r20 == null) goto L23;
        long r21 = r20.longValue();
        LarusGalleryChatTitleBinding r1 = this.f;
        if (r1 == null) goto L23;
        TextView r2 = r1.g;
        if (r2 == null) goto L23;
        r2.setText(oo8.b.a(r21, false));
        goto L23
    }
}
