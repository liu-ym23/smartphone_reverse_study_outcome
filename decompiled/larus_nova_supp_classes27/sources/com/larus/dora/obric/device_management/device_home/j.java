package com.larus.dora.obric.device_management.device_home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraItemObricDeviceHomeDeviceCardBinding;
import com.larus.dora.impl.resource.DoraDrawableDensity;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.obric.oui.button.OButton;
import com.obric.oui.image.OImage;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.tag.OTextTag;
import com.obric.oui.text.OTextView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j extends com.obric.oui.orecyclerview.widget.w<q, b> {
    public final Function1<String, Unit> d;
    public final Function1<String, Unit> e;
    public final Function1<String, Unit> f;
    public final Function1<String, Unit> g;
    public boolean h;
    public int i;

    public static final class a extends com.obric.oui.orecyclerview.widget.q.e<q> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean a(Object r2, Object r3) {
            q r4 = (q) r2;
            q r5 = (q) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean b(Object r2, Object r3) {
            q r4 = (q) r2;
            q r5 = (q) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4.a, r5.a);
        }
    }

    public final class b extends RecyclerView.y {
        public final LarusDoraItemObricDeviceHomeDeviceCardBinding u;
        public String v;
        public final /* synthetic */ j w;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[DoraObricDeviceHomeDeviceCardType.values().length];
                r0[DoraObricDeviceHomeDeviceCardType.GLASSES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[DoraObricDeviceHomeDeviceCardType.EARBUDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public final void p(boolean r11) {
            RecyclerView.LayoutParams r0 = this.u.a.getLayoutParams();
            int r1 = -1;
            if (r0 != null) goto L5;
            r0 = new RecyclerView.LayoutParams(-1, -2);
        L5:
            Integer r3 = Integer.valueOf(this.w.i);
            if (r3.intValue() <= 0) goto L8;
            boolean r4 = true;
        L9:
            Integer r6 = null;
            if (r4 == true) goto L13;
            r3 = null;
        L13:
            if (r3 == null) goto L15;
            int r5 = r3.intValue();
        L24:
            Context r7 = this.u.a.getContext();
            int r8 = h.a;
            Intrinsics.checkNotNull(r7);
            int r9 = h.a(r7);
            Intrinsics.checkNotNullParameter(r7, "context");
            int r10 = r7.getResources().getDimensionPixelSize(v19.c.b(2130971546, r7, 2131167462));
            if (r11 == false) goto L29;
            if (r5 <= 0) goto L29;
            r1 = RangesKt.coerceAtLeast((r5 - (r9 * 2)) - r10, 0);
        L29:
            if (((ViewGroup.LayoutParams) r0).width == r1) goto L31;
        L33:
            ((ViewGroup.LayoutParams) r0).width = r1;
            ((ViewGroup.LayoutParams) r0).height = -2;
            this.u.a.setLayoutParams(r0);
            if (r11 == false) goto L38;
            if (r5 != 0) goto L39;
            this.u.a.post(new p(this));
            return;
        L39:
            return;
        L38:
            return;
        L31:
            if (((ViewGroup.LayoutParams) r0).height != (-2)) goto L33;
            return;
        L15:
            ViewParent r12 = this.u.a.getParent();
            if ((r12 instanceof ViewGroup) == false) goto L18;
            ViewGroup r13 = (ViewGroup) r12;
        L19:
            if (r13 == null) goto L21;
            r6 = Integer.valueOf(r13.getWidth());
        L21:
            if (r6 == null) goto L23;
            r5 = r6.intValue();
            goto L24
        L23:
            r5 = 0;
            goto L24
        L18:
            r13 = null;
            goto L19
        L8:
            r4 = false;
            goto L9
        }

        public b(j r2, LarusDoraItemObricDeviceHomeDeviceCardBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.w = r2;
            super(r3.a);
            this.u = r3;
        }
    }

    public final void c(RecyclerView.y r23, int r24) {
        b r1 = (b) r23;
        Intrinsics.checkNotNullParameter(r1, "holder");
        final q r2 = (q) ListProtector.get(((com.obric.oui.orecyclerview.widget.w) this).c.f, r24);
        boolean r3 = this.h;
        Intrinsics.checkNotNullParameter(r2, "item");
        r1.p(r3);
        r r4 = r2.b;
        int r5 = c.a;
        com.larus.dora.obric.device_management.device_home.b r6 = c.a(r2.c, r2.d);
        r1.u.a.setContentDescription(r4.b);
        r1.u.l.setText(r4.b);
        String r7 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Object[]{r4.i, r4.g, r4.h, Integer.valueOf(r4.f)}), null, null, null, 0, null, null, 63, null);
        if (Intrinsics.areEqual(r1.v, r7) == true) goto L25;
        DoraResourceDeviceType r8 = r4.i;
        if (r8 == null) goto L13;
        String r14 = r4.g;
        if (r14 == null) goto L10;
        Drawable r11 = com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, r1.u.a.getContext(), r8, r14, DoraDrawableDensity.XXHDPI, 8);
        if (r11 == null) goto L10;
    L14:
        if (r11 == null) goto L16;
        r1.u.j.setImageDrawable(r11);
    L20:
        LarusDoraItemObricDeviceHomeDeviceCardBinding r9 = r1.u;
        OImage r12 = r9.r;
        DoraResourceDeviceType r15 = r4.i;
        if (r15 == null) goto L23;
        Drawable r10 = com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, r9.a.getContext(), r15, "larus_dora_obric_device_home_ic_glasses", DoraDrawableDensity.XXHDPI, 8);
    L24:
        r12.setImageDrawable(r10);
        r1.v = r7;
        goto L25
    L23:
        r10 = null;
        goto L24
    L16:
        int r13 = r4.f;
        if (r13 == 0) goto L19;
        r1.u.j.setImageResource(r13);
        goto L20
    L19:
        r1.u.j.setImageDrawable(null);
    L10:
        String r16 = r4.h;
        if (r16 == null) goto L13;
        r11 = com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, r1.u.a.getContext(), r8, r16, DoraDrawableDensity.XXHDPI, 8);
    L13:
        r11 = null;
    L25:
        r1.u.h.setText(r4.c);
        if (r6.c == true) goto L28;
    L35:
        com.larus.utils.e1.o(r1.u.k);
    L37:
        if (r4.d == false) goto L59;
        com.larus.utils.e1.o(r1.u.g);
        com.larus.utils.e1.o(r1.u.w);
        com.larus.utils.e1.o(r1.u.x);
        com.larus.utils.e1.o(r1.u.f);
        int r17 = b.a.a[r4.getType().ordinal()];
        if (r17 == 1) goto L55;
        if (r17 != 2) goto L54;
        com.larus.utils.e1.o(r1.u.b);
        com.larus.utils.e1.x(r1.u.o);
        r1.u.t.setText(r4.m);
        r1.u.y.setText(r4.o);
        r1.u.d.setText(r4.q);
        OImage r18 = r1.u.u;
        if (r4.n == false) goto L44;
        com.larus.utils.e1.x(r18);
    L45:
        OImage r20 = r1.u.z;
        if (r4.p == false) goto L48;
        com.larus.utils.e1.x(r20);
    L49:
        OImage r21 = r1.u.e;
        if (r4.r == false) goto L52;
        com.larus.utils.e1.x(r21);
    L63:
        DoraObricDeviceModeEntryView r22 = r1.u.v;
        final j r25 = r1.w;
        r22.a(r2.c, r2.d);
        r22.setOnModeClickListener(new o(r25, r2));
        if (r6.d == false) goto L66;
        com.larus.utils.e1.x(r1.u.B);
    L68:
        if (r6.e == false) goto L70;
        com.larus.utils.e1.x(r1.u.n);
    L71:
        int r26 = e.a;
        LarusDoraItemObricDeviceHomeDeviceCardBinding r27 = r1.u;
        e.a(r27.a, r27.j, r27.m, r27.b, r27.o, r27.g, r27.k, r27.n, r27.B, r27.v, r6.a);
        LarusDoraItemObricDeviceHomeDeviceCardBinding r28 = r1.u;
        OUILinearLayout r30 = r28.A;
        OButton r31 = r28.p;
        OTextView r32 = r28.s;
        final j r33 = r1.w;
        e.b(r30, r31, r32, r6, new k(r33, r2));
        r1.u.i.setOnClickListener(null);
        r1.u.i.setClickable(false);
        r1.u.i.setFocusable(false);
        View r34 = r1.u.x;
        final j r35 = r1.w;
        r34.setOnClickListener(new l(r35, r2));
        OImage r36 = r1.u.n;
        final j r37 = r1.w;
        r36.setOnClickListener(new m(r37, r2));
        OImage r38 = r1.u.B;
        final j r40 = r1.w;
        r38.setOnClickListener(new n(r40, r2));
        return;
    L70:
        com.larus.utils.e1.o(r1.u.n);
        goto L71
    L66:
        com.larus.utils.e1.o(r1.u.B);
        goto L68
    L52:
        com.larus.utils.e1.o(r21);
        goto L63
    L48:
        com.larus.utils.e1.o(r20);
        goto L49
    L44:
        com.larus.utils.e1.o(r18);
        goto L45
    L54:
        throw new NoWhenBranchMatchedException();
    L55:
        com.larus.utils.e1.x(r1.u.b);
        com.larus.utils.e1.o(r1.u.o);
        r1.u.c.setText(r4.k);
        OImage r41 = r1.u.q;
        if (r4.l == false) goto L58;
        com.larus.utils.e1.x(r41);
        goto L63
    L58:
        com.larus.utils.e1.o(r41);
        goto L63
    L59:
        com.larus.utils.e1.o(r1.u.b);
        com.larus.utils.e1.o(r1.u.o);
        com.larus.utils.e1.x(r1.u.g);
        com.larus.utils.e1.o(r1.u.h);
        if (r4.e == false) goto L62;
        com.larus.utils.e1.o(r1.u.w);
        com.larus.utils.e1.o(r1.u.x);
        com.larus.utils.e1.x(r1.u.f);
        goto L63
    L62:
        com.larus.utils.e1.x(r1.u.w);
        com.larus.utils.e1.x(r1.u.x);
        com.larus.utils.e1.o(r1.u.f);
        goto L63
    L28:
        if (r4.d == false) goto L35;
        if (r4.j.length() <= 0) goto L32;
        boolean r42 = true;
    L33:
        if (r42 == false) goto L35;
        r1.u.k.setText(r4.j);
        com.larus.utils.e1.x(r1.u.k);
        goto L37
    L32:
        r42 = false;
        goto L33
    }

    public final RecyclerView.y d(RecyclerView r33, int r34) {
        Intrinsics.checkNotNullParameter(r33, "parent");
        OUICardConstraintLayout r0 = LayoutInflater.from(r33.getContext()).inflate(2131562219, r33, false);
        int r1 = 2131369774;
        OUILinearLayout r5 = ViewBindings.findChildViewById(r0, 2131369774);
        if (r5 == null) goto L61;
        r1 = 2131369775;
        OTextView r6 = ViewBindings.findChildViewById(r0, 2131369775);
        if (r6 == null) goto L61;
        r1 = 2131369777;
        OTextView r7 = ViewBindings.findChildViewById(r0, 2131369777);
        if (r7 == null) goto L61;
        r1 = 2131369778;
        OImage r8 = ViewBindings.findChildViewById(r0, 2131369778);
        if (r8 == null) goto L61;
        r1 = 2131369780;
        OTextView r9 = ViewBindings.findChildViewById(r0, 2131369780);
        if (r9 == null) goto L61;
        r1 = 2131369781;
        if (ViewBindings.findChildViewById(r0, 2131369781) == null) goto L61;
        r1 = 2131369782;
        OUIFrameLayout r10 = ViewBindings.findChildViewById(r0, 2131369782);
        if (r10 == null) goto L61;
        r1 = 2131369783;
        OTextView r11 = ViewBindings.findChildViewById(r0, 2131369783);
        if (r11 == null) goto L61;
        OUICardConstraintLayout r4 = r0;
        r1 = 2131369787;
        OUIFrameLayout r12 = ViewBindings.findChildViewById(r0, 2131369787);
        if (r12 == null) goto L61;
        r1 = 2131369788;
        OImage r13 = ViewBindings.findChildViewById(r0, 2131369788);
        if (r13 == null) goto L61;
        r1 = 2131369789;
        OTextTag r14 = ViewBindings.findChildViewById(r0, 2131369789);
        if (r14 == null) goto L61;
        r1 = 2131369790;
        OTextView r15 = ViewBindings.findChildViewById(r0, 2131369790);
        if (r15 == null) goto L61;
        r1 = 2131369791;
        OUILinearLayout r16 = ViewBindings.findChildViewById(r0, 2131369791);
        if (r16 == null) goto L61;
        r1 = 2131369792;
        OImage r17 = ViewBindings.findChildViewById(r0, 2131369792);
        if (r17 == null) goto L61;
        r1 = 2131369795;
        OUILinearLayout r18 = ViewBindings.findChildViewById(r0, 2131369795);
        if (r18 == null) goto L61;
        r1 = 2131369803;
        OButton r110 = ViewBindings.findChildViewById(r0, 2131369803);
        if (r110 == null) goto L61;
        r1 = 2131369804;
        OImage r20 = ViewBindings.findChildViewById(r0, 2131369804);
        if (r20 == null) goto L61;
        r1 = 2131369805;
        OImage r21 = ViewBindings.findChildViewById(r0, 2131369805);
        if (r21 == null) goto L61;
        r1 = 2131369807;
        OTextView r22 = ViewBindings.findChildViewById(r0, 2131369807);
        if (r22 == null) goto L61;
        r1 = 2131369808;
        OTextView r23 = ViewBindings.findChildViewById(r0, 2131369808);
        if (r23 == null) goto L61;
        r1 = 2131369809;
        OImage r24 = ViewBindings.findChildViewById(r0, 2131369809);
        if (r24 == null) goto L61;
        r1 = 2131369810;
        DoraObricDeviceModeEntryView r25 = (DoraObricDeviceModeEntryView) ViewBindings.findChildViewById(r0, 2131369810);
        if (r25 == null) goto L61;
        r1 = 2131369818;
        OTextView r26 = ViewBindings.findChildViewById(r0, 2131369818);
        if (r26 == null) goto L61;
        r1 = 2131369819;
        View r27 = ViewBindings.findChildViewById(r0, 2131369819);
        if (r27 == null) goto L61;
        r1 = 2131369820;
        OTextView r28 = ViewBindings.findChildViewById(r0, 2131369820);
        if (r28 == null) goto L61;
        r1 = 2131369821;
        OImage r210 = ViewBindings.findChildViewById(r0, 2131369821);
        if (r210 == null) goto L61;
        r1 = 2131369823;
        OUILinearLayout r30 = ViewBindings.findChildViewById(r0, 2131369823);
        if (r30 == null) goto L61;
        r1 = 2131369825;
        OImage r31 = ViewBindings.findChildViewById(r0, 2131369825);
        if (r31 == null) goto L61;
        return new b(this, new LarusDoraItemObricDeviceHomeDeviceCardBinding(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r210, r30, r31));
    L61:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super String, Unit> r2, Function1<? super String, Unit> r3, Function1<? super String, Unit> r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "onCardClick");
        Intrinsics.checkNotNullParameter(r3, "onReconnectClick");
        Intrinsics.checkNotNullParameter(r4, "onModeClick");
        Intrinsics.checkNotNullParameter(r5, "onEnvironmentMemoryClick");
        super(a.a);
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
    }
}
