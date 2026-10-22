package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.larus.common_res.common_ui.databinding.LarusScreenTinyMenuLayoutBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c0 implements ot8.b {
    public c0() {
    }

    @Override // ot8.b
    public void update(ot8.a r6, View r7) {
        Intrinsics.checkNotNullParameter(r6, "item");
        LinearLayout r0 = null;
        if (r7 == null) goto L5;
        Context r1 = r7.getContext();
    L7:
        if ((r6 instanceof y) == false) goto L76;
        if (r7 == null) goto L77;
        if (r1 == null) goto L80;
        y r8 = (y) r6;
        if ((r8.c instanceof l0) == true) goto L14;
        return;
    L14:
        if ((r8.d instanceof l0) == false) goto L81;
        View r2 = r7.findViewById(2131377799);
        if ((r2 instanceof TextView) == false) goto L19;
        TextView r3 = (TextView) r2;
    L20:
        if (r3 == null) goto L22;
        r3.setText(d0.a(r1, (l0) r8.c));
    L22:
        View r4 = r7.findViewById(2131377815);
        if ((r4 instanceof ImageView) == false) goto L25;
        ImageView r5 = (ImageView) r4;
    L26:
        ot8.a r9 = r8.c;
        if (((l0) r9).j == false) goto L30;
        if (r5 == null) goto L35;
        r5.clearColorFilter();
    L35:
        Integer r10 = ((l0) r8.c).m;
        if (r10 == null) goto L40;
        int r11 = r10.intValue();
        if (r5 == null) goto L40;
        r5.setImageResource(r11);
    L40:
        View r12 = r7.findViewById(2131377798);
        if ((r12 instanceof LinearLayout) == false) goto L43;
        LinearLayout r13 = (LinearLayout) r12;
    L44:
        if (r13 == null) goto L46;
        r13.setSelected(((l0) r8.c).j);
    L46:
        View r14 = r7.findViewById(2131384610);
        if ((r14 instanceof TextView) == false) goto L49;
        TextView r15 = (TextView) r14;
    L50:
        if (r15 == null) goto L52;
        r15.setText(d0.a(r1, (l0) r8.d));
    L52:
        View r16 = r7.findViewById(2131384633);
        if ((r16 instanceof ImageView) == false) goto L55;
        ImageView r17 = (ImageView) r16;
    L56:
        ot8.a r18 = r8.d;
        if (((l0) r18).j == false) goto L60;
        if (r17 == null) goto L65;
        r17.clearColorFilter();
    L65:
        Integer r19 = ((l0) r8.d).m;
        if (r19 == null) goto L70;
        int r20 = r19.intValue();
        if (r17 == null) goto L70;
        r17.setImageResource(r20);
    L70:
        View r21 = r7.findViewById(2131384609);
        if ((r21 instanceof LinearLayout) == false) goto L73;
        r0 = (LinearLayout) r21;
    L73:
        if (r0 == null) goto L79;
        r0.setSelected(((l0) r8.d).j);
        return;
    L79:
        return;
    L60:
        Integer r22 = ((l0) r18).f;
        if (r22 == null) goto L65;
        int r23 = r22.intValue();
        if (r17 == null) goto L65;
        r17.setColorFilter(ContextCompat.getColor(r1, r23));
        goto L65
    L55:
        r17 = null;
        goto L56
    L49:
        r15 = null;
        goto L50
    L43:
        r13 = null;
        goto L44
    L30:
        Integer r24 = ((l0) r9).f;
        if (r24 == null) goto L35;
        int r25 = r24.intValue();
        if (r5 == null) goto L35;
        r5.setColorFilter(ContextCompat.getColor(r1, r25));
        goto L35
    L25:
        r5 = null;
        goto L26
    L19:
        r3 = null;
        goto L20
    L81:
        return;
    L80:
        return;
    L77:
        return;
    L76:
        return;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ot8.b
    public final View a(CommonMenu r6, int r7, int r8, ot8.a r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r9, "item");
        if ((r9 instanceof y) == true) goto L5;
        return null;
    L5:
        y r10 = (y) r9;
        if ((r10.c instanceof l0) == true) goto L8;
    L18:
        return null;
    L8:
        if ((r10.d instanceof l0) == false) goto L18;
        FrameLayout r11 = new FrameLayout(r6.getContext());
        r11.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, i5.m0()));
        LayoutInflater.from(r6.getContext()).inflate(2131563106, r11);
        final LarusScreenTinyMenuLayoutBinding r12 = LarusScreenTinyMenuLayoutBinding.a(r11);
        r12.c.setBackground(r6.getContext().getDrawable(v19.c.b(2130970718, r6.getContext(), 2131239268)));
        r12.g.setBackground(r6.getContext().getDrawable(v19.c.b(2130970721, r6.getContext(), 2131239277)));
        r12.d.setText(d0.a(r6.getContext(), (l0) r10.c));
        r12.h.setText(d0.a(r6.getContext(), (l0) r10.d));
        r12.h.post(new b0(r12));
        Integer r13 = ((l0) r10.c).m;
        if (r13 == null) goto L13;
        int r14 = r13.intValue();
        com.larus.utils.e1.x(r12.e);
        r12.e.setBackgroundResource(r14);
    L13:
        Integer r15 = ((l0) r10.d).m;
        if (r15 == null) goto L16;
        int r16 = r15.intValue();
        com.larus.utils.e1.x(r12.i);
        r12.i.setBackgroundResource(r16);
    L16:
        r12.c.setSelected(((l0) r10.c).j);
        r12.g.setSelected(((l0) r10.d).j);
        return r11;
    }

    @Override // ot8.b
    public final void b(CommonMenu r3, final ot8.a r4, View r5, final Function1<? super ot8.a, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r6, "listener");
        if ((r4 instanceof y) == false) goto L18;
        if (r5 == null) goto L20;
        View r7 = r5.findViewById(2131377798);
        LinearLayout r1 = null;
        if ((r7 instanceof LinearLayout) == false) goto L9;
        LinearLayout r8 = (LinearLayout) r7;
    L10:
        if (r8 == null) goto L12;
        r8.setOnClickListener(new z(r6, r4));
    L12:
        View r9 = r5.findViewById(2131384609);
        if ((r9 instanceof LinearLayout) == false) goto L15;
        r1 = (LinearLayout) r9;
    L15:
        if (r1 == null) goto L19;
        r1.setOnClickListener(new a0(r6, r4));
        return;
    L19:
        return;
    L9:
        r8 = null;
        goto L10
    L20:
        return;
    }
}
