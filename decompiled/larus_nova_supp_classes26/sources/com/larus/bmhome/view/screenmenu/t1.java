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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t1 implements ot8.b {
    public t1() {
    }

    @Override // ot8.b
    public void update(ot8.a r6, View r7) {
        Intrinsics.checkNotNullParameter(r6, "item");
        LinearLayout r0 = null;
        if (r7 == null) goto L5;
        Context r1 = r7.getContext();
    L7:
        if ((r6 instanceof o1) == false) goto L138;
        if (r7 == null) goto L139;
        if (r1 == null) goto L143;
        o1 r8 = (o1) r6;
        if ((r8.c instanceof l0) == true) goto L14;
        return;
    L14:
        if ((r8.d instanceof l0) == true) goto L16;
        return;
    L16:
        if ((r8.e instanceof l0) == false) goto L144;
        View r2 = r7.findViewById(2131377799);
        if ((r2 instanceof TextView) == false) goto L21;
        TextView r3 = (TextView) r2;
    L22:
        if (r3 == null) goto L24;
        r3.setText(u1.a(r1, (l0) r8.c));
    L24:
        View r4 = r7.findViewById(2131377815);
        if ((r4 instanceof ImageView) == false) goto L27;
        ImageView r5 = (ImageView) r4;
    L28:
        ot8.a r9 = r8.c;
        if (((l0) r9).j == false) goto L33;
        if (r5 == null) goto L42;
        r5.clearColorFilter();
    L42:
        ot8.a r10 = r8.c;
        if ((r10 instanceof l0) == false) goto L45;
        l0 r11 = (l0) r10;
    L46:
        if (r11 == null) goto L52;
        Integer r12 = r11.m;
        if (r12 == null) goto L52;
        int r13 = r12.intValue();
        if (r5 == null) goto L52;
        r5.setImageResource(r13);
    L52:
        View r14 = r7.findViewById(2131377798);
        if ((r14 instanceof LinearLayout) == false) goto L55;
        LinearLayout r15 = (LinearLayout) r14;
    L56:
        if (r15 == null) goto L58;
        r15.setSelected(((l0) r8.c).j);
    L58:
        View r16 = r7.findViewById(2131380085);
        if ((r16 instanceof TextView) == false) goto L61;
        TextView r17 = (TextView) r16;
    L62:
        if (r17 == null) goto L64;
        r17.setText(u1.a(r1, (l0) r8.d));
    L64:
        View r18 = r7.findViewById(2131380088);
        if ((r18 instanceof ImageView) == false) goto L67;
        ImageView r19 = (ImageView) r18;
    L68:
        ot8.a r20 = r8.d;
        if (((l0) r20).j == false) goto L73;
        if (r19 == null) goto L82;
        r19.clearColorFilter();
    L82:
        ot8.a r21 = r8.d;
        if ((r21 instanceof l0) == false) goto L85;
        l0 r22 = (l0) r21;
    L86:
        if (r22 == null) goto L92;
        Integer r23 = r22.m;
        if (r23 == null) goto L92;
        int r24 = r23.intValue();
        if (r19 == null) goto L92;
        r19.setImageResource(r24);
    L92:
        View r25 = r7.findViewById(2131380084);
        if ((r25 instanceof LinearLayout) == false) goto L95;
        LinearLayout r26 = (LinearLayout) r25;
    L96:
        if (r26 == null) goto L98;
        r26.setSelected(((l0) r8.d).j);
    L98:
        View r27 = r7.findViewById(2131384610);
        if ((r27 instanceof TextView) == false) goto L101;
        TextView r28 = (TextView) r27;
    L102:
        if (r28 == null) goto L104;
        r28.setText(u1.a(r1, (l0) r8.e));
    L104:
        View r29 = r7.findViewById(2131384633);
        if ((r29 instanceof ImageView) == false) goto L107;
        ImageView r30 = (ImageView) r29;
    L108:
        ot8.a r31 = r8.e;
        if (((l0) r31).j == false) goto L113;
        if (r30 == null) goto L122;
        r30.clearColorFilter();
    L122:
        ot8.a r32 = r8.e;
        if ((r32 instanceof l0) == false) goto L125;
        l0 r33 = (l0) r32;
    L126:
        if (r33 == null) goto L132;
        Integer r34 = r33.m;
        if (r34 == null) goto L132;
        int r35 = r34.intValue();
        if (r30 == null) goto L132;
        r30.setImageResource(r35);
    L132:
        View r36 = r7.findViewById(2131384609);
        if ((r36 instanceof LinearLayout) == false) goto L135;
        r0 = (LinearLayout) r36;
    L135:
        if (r0 == null) goto L142;
        r0.setSelected(((l0) r8.e).j);
        return;
    L142:
        return;
    L125:
        r33 = null;
        goto L126
    L113:
        if ((r31 instanceof l0) == false) goto L115;
        l0 r37 = (l0) r31;
    L116:
        if (r37 == null) goto L122;
        Integer r38 = r37.f;
        if (r38 == null) goto L122;
        int r39 = r38.intValue();
        if (r30 == null) goto L122;
        r30.setColorFilter(ContextCompat.getColor(r1, r39));
        goto L122
    L115:
        r37 = null;
        goto L116
    L107:
        r30 = null;
        goto L108
    L101:
        r28 = null;
        goto L102
    L95:
        r26 = null;
        goto L96
    L85:
        r22 = null;
        goto L86
    L73:
        if ((r20 instanceof l0) == false) goto L75;
        l0 r40 = (l0) r20;
    L76:
        if (r40 == null) goto L82;
        Integer r41 = r40.f;
        if (r41 == null) goto L82;
        int r42 = r41.intValue();
        if (r19 == null) goto L82;
        r19.setColorFilter(ContextCompat.getColor(r1, r42));
        goto L82
    L75:
        r40 = null;
        goto L76
    L67:
        r19 = null;
        goto L68
    L61:
        r17 = null;
        goto L62
    L55:
        r15 = null;
        goto L56
    L45:
        r11 = null;
        goto L46
    L33:
        if ((r9 instanceof l0) == false) goto L35;
        l0 r43 = (l0) r9;
    L36:
        if (r43 == null) goto L42;
        Integer r44 = r43.f;
        if (r44 == null) goto L42;
        int r45 = r44.intValue();
        if (r5 == null) goto L42;
        r5.setColorFilter(ContextCompat.getColor(r1, r45));
        goto L42
    L35:
        r43 = null;
        goto L36
    L27:
        r5 = null;
        goto L28
    L21:
        r3 = null;
        goto L22
    L144:
        return;
    L143:
        return;
    L139:
        return;
    L138:
        return;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ot8.b
    public final View a(CommonMenu r10, int r11, int r12, ot8.a r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "item");
        l0 r14 = null;
        if ((r13 instanceof o1) == true) goto L5;
        return null;
    L5:
        o1 r15 = (o1) r13;
        if ((r15.c instanceof l0) == true) goto L8;
    L82:
        return null;
    L8:
        if ((r15.d instanceof l0) == false) goto L82;
        if ((r15.e instanceof l0) == false) goto L82;
        FrameLayout r16 = new FrameLayout(r10.getContext());
        r16.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, i5.m0()));
        final View r0 = LayoutInflater.from(r10.getContext()).inflate(2131563107, r16, true);
        LinearLayout r2 = (LinearLayout) r0.findViewById(2131377798);
        if (r2 == null) goto L15;
        r2.setBackground(r10.getContext().getDrawable(v19.c.b(2130970718, r10.getContext(), 2131239268)));
    L15:
        LinearLayout r3 = (LinearLayout) r0.findViewById(2131380084);
        if (r3 == null) goto L18;
        r3.setBackground(r10.getContext().getDrawable(v19.c.b(2130970621, r10.getContext(), 2131238859)));
    L18:
        LinearLayout r4 = (LinearLayout) r0.findViewById(2131384609);
        if (r4 == null) goto L21;
        r4.setBackground(r10.getContext().getDrawable(v19.c.b(2130970721, r10.getContext(), 2131239277)));
    L21:
        TextView r5 = (TextView) r0.findViewById(2131377799);
        if (r5 == null) goto L24;
        r5.setText(u1.a(r10.getContext(), (l0) r15.c));
    L24:
        TextView r6 = (TextView) r0.findViewById(2131380085);
        if (r6 == null) goto L27;
        r6.setText(u1.a(r10.getContext(), (l0) r15.d));
    L27:
        TextView r7 = (TextView) r0.findViewById(2131384610);
        if (r7 == null) goto L30;
        r7.setText(u1.a(r10.getContext(), (l0) r15.e));
    L30:
        TextView r17 = (TextView) r0.findViewById(2131384610);
        if (r17 == null) goto L33;
        r17.post(new p1(r0));
    L33:
        ot8.a r18 = r15.c;
        if ((r18 instanceof l0) == false) goto L36;
        l0 r19 = (l0) r18;
    L38:
        if (r19 == null) goto L47;
        Integer r110 = r19.m;
        if (r110 == null) goto L47;
        int r111 = r110.intValue();
        ImageView r8 = (ImageView) r0.findViewById(2131377815);
        if (r8 == null) goto L44;
        r8.setVisibility(0);
    L44:
        ImageView r9 = (ImageView) r0.findViewById(2131377815);
        if (r9 == null) goto L47;
        r9.setBackgroundResource(r111);
    L47:
        ot8.a r112 = r15.d;
        if ((r112 instanceof l0) == false) goto L50;
        l0 r113 = (l0) r112;
    L51:
        if (r113 == null) goto L60;
        Integer r114 = r113.m;
        if (r114 == null) goto L60;
        int r115 = r114.intValue();
        ImageView r20 = (ImageView) r0.findViewById(2131380088);
        if (r20 == null) goto L57;
        r20.setVisibility(0);
    L57:
        ImageView r21 = (ImageView) r0.findViewById(2131380088);
        if (r21 == null) goto L60;
        r21.setBackgroundResource(r115);
    L60:
        ot8.a r116 = r15.e;
        if ((r116 instanceof l0) == false) goto L63;
        r14 = (l0) r116;
    L63:
        if (r14 == null) goto L72;
        Integer r117 = r14.m;
        if (r117 == null) goto L72;
        int r118 = r117.intValue();
        ImageView r22 = (ImageView) r0.findViewById(2131384633);
        if (r22 == null) goto L69;
        r22.setVisibility(0);
    L69:
        ImageView r119 = (ImageView) r0.findViewById(2131384633);
        if (r119 == null) goto L72;
        r119.setBackgroundResource(r118);
    L72:
        LinearLayout r120 = (LinearLayout) r0.findViewById(2131377798);
        if (r120 == null) goto L75;
        r120.setSelected(((l0) r15.c).j);
    L75:
        LinearLayout r121 = (LinearLayout) r0.findViewById(2131380084);
        if (r121 == null) goto L78;
        r121.setSelected(((l0) r15.d).j);
    L78:
        LinearLayout r122 = (LinearLayout) r0.findViewById(2131384609);
        if (r122 == null) goto L81;
        r122.setSelected(((l0) r15.e).j);
    L81:
        return r16;
    L50:
        r113 = null;
        goto L51
    L36:
        r19 = null;
        goto L38
    }

    @Override // ot8.b
    public final void b(CommonMenu r2, final ot8.a r3, View r4, final Function1<? super ot8.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if ((r3 instanceof o1) == false) goto L16;
        if (r4 == null) goto L18;
        LinearLayout r6 = (LinearLayout) r4.findViewById(2131377798);
        if (r6 == null) goto L9;
        r6.setOnClickListener(new q1(r5, r3));
    L9:
        LinearLayout r7 = (LinearLayout) r4.findViewById(2131380084);
        if (r7 == null) goto L12;
        r7.setOnClickListener(new r1(r5, r3));
    L12:
        LinearLayout r8 = (LinearLayout) r4.findViewById(2131384609);
        if (r8 == null) goto L17;
        r8.setOnClickListener(new s1(r5, r3));
        return;
    L17:
        return;
    L18:
        return;
    }
}
