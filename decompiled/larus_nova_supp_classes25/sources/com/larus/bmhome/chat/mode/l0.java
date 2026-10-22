package com.larus.bmhome.chat.mode;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.auth.ConversationMode;
import com.larus.platform.service.z2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l0 extends FrameLayout {
    public int A;
    public int B;
    public final Function2<String, Boolean, Unit> a;
    public Function1<? super Float, Unit> b;
    public final float c;
    public final int d;
    public final View e;
    public final View f;
    public final ImageView g;
    public final TextView h;
    public final LinearLayout i;
    public final Typeface j;
    public final Typeface k;
    public List<ConversationMode> l;
    public final List<TextView> m;
    public final List<SimpleDraweeView> n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public boolean t;
    public boolean u;
    public int v;
    public ValueAnimator w;
    public final boolean x;
    public boolean y;
    public final ArgbEvaluator z;

    public static final class a {
    }

    static {
    }

    public final float e() {
        return RangesKt.coerceAtLeast(this.l.size() - 1, 0);
    }

    public final void a() {
        this.A = i(2130972079, 2131103136);
        this.B = i(2130972082, 2131103146);
        View r0 = this.f;
        float[] r3 = new float[8];
        int r2 = 0;
    L3:
        if (r2 >= 8) goto L5;
        r3[r2] = c(100, 1.0f);
        r2 = r2 + 1;
        goto L3
    L5:
        com.larus.common_ui.venus.a.a r1 = new com.larus.common_ui.venus.a.a(r3, i(2130970534, 2131102545), this.d, Color.argb((int) (255 * 0.04f), Color.red(-16777216), Color.green(-16777216), Color.blue(-16777216)), 1952);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "params");
        Drawable r4 = r0.getBackground();
        if (r4 != null) goto L8;
    L21:
        com.larus.common_ui.venus.b.a(r0, r1);
        return;
    L8:
        if ((r4 instanceof LayerDrawable) == false) goto L21;
        com.larus.common_ui.venus.a r5 = ((LayerDrawable) r4).getDrawable(0);     // Catch: Throwable -> L20
        com.larus.common_ui.venus.a.a r6 = null;
        if ((r5 instanceof com.larus.common_ui.venus.a) == false) goto L13;
        com.larus.common_ui.venus.a r7 = r5;     // Catch: Throwable -> L20
    L14:
        if (r7 == null) goto L17;
        r6 = r7.a;     // Catch: Throwable -> L20
    L17:
        if (Intrinsics.areEqual(r6, r1) == true) goto L26;
        com.larus.common_ui.venus.b.a(r0, r1);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L13:
        r7 = null;
    L20:
        com.larus.common_ui.venus.b.a(r0, r1);
    }

    public final View getContentView() {
        return this.e;
    }

    public final Function1<Float, Unit> getOnSlidePositionChanged() {
        return this.b;
    }

    public final float d(float r8) {
        float r9 = RangesKt.coerceIn(r8, 0.0f, e());
        int r0 = (int) r9;
        int r1 = RangesKt.coerceAtMost(r0 + 1, (int) e());
        float r10 = r9 - r0;
        View r2 = this.i.getChildAt(r0);
        View r3 = this.i.getChildAt(r1);
        int r4 = c(120, this.c);
        int r5 = 0;
        if (r2 == null) goto L5;
        int r6 = r2.getWidth();
    L6:
        if (r6 <= 0) goto L8;
        int r7 = (this.i.getLeft() + r2.getLeft()) - this.d;
    L9:
        if (r3 == null) goto L11;
        r5 = r3.getWidth();
    L11:
        if (r5 <= 0) goto L13;
        int r11 = (this.i.getLeft() + r3.getLeft()) - this.d;
    L15:
        return r7 + ((r11 - r7) * r10);
    L13:
        r11 = r1 * r4;
        goto L15
    L8:
        r7 = r0 * r4;
        goto L9
    L5:
        r6 = 0;
        goto L6
    }

    public final int h(float r9) {
        float r10 = RangesKt.coerceIn(r9, 0.0f, e());
        int r0 = (int) r10;
        int r1 = RangesKt.coerceAtMost(r0 + 1, (int) e());
        int r2 = c(120, this.c);
        View r3 = this.i.getChildAt(r0);
        Integer r4 = null;
        boolean r5 = false;
        if (r3 == null) goto L13;
        Integer r6 = Integer.valueOf(r3.getWidth());
        if (r6.intValue() <= 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L11;
        r6 = null;
    L11:
        if (r6 == null) goto L13;
        int r8 = r6.intValue();
    L14:
        View r11 = this.i.getChildAt(r1);
        if (r11 == null) goto L24;
        Integer r12 = Integer.valueOf(r11.getWidth());
        if (r12.intValue() <= 0) goto L19;
        r5 = true;
    L19:
        if (r5 == false) goto L21;
        r4 = r12;
    L21:
        if (r4 == null) goto L24;
        r2 = r4.intValue();
    L24:
        return (int) ((r8 + ((r2 - r8) * (r10 - r0))) + 0.5f);
    L7:
        r7 = false;
    L13:
        r8 = r2;
        goto L14
    }

    public final void j(float r7) {
        IntIterator r0 = CollectionsKt.getIndices(this.l).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        int r1 = r0.nextInt();
        Object r2 = this.z.evaluate(RangesKt.coerceIn(1.0f - Math.abs(r1 - r7), 0.0f, 1.0f), Integer.valueOf(this.B), Integer.valueOf(this.A));
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
        int r3 = ((Integer) r2).intValue();
        TextView r4 = (TextView) CollectionsKt.getOrNull(this.m, r1);
        if (r4 == null) goto L8;
        r4.setTextColor(r3);
    L8:
        SimpleDraweeView r5 = (SimpleDraweeView) CollectionsKt.getOrNull(this.n, r1);
        if (r5 == null) goto L4;
        GenericDraweeHierarchy r6 = r5.getHierarchy();
        if (r6 == null) goto L4;
        r6.setActualImageColorFilter(new PorterDuffColorFilter(r3, PorterDuff.Mode.SRC_IN));
        goto L4
    }

    public final void k(float r5) {
        int r6 = Math.round(r5);
        if (r6 != this.q) goto L5;
        return;
    L5:
        this.q = r6;
        IntIterator r0 = CollectionsKt.getIndices(this.l).iterator();
    L7:
        if (r0.hasNext() == false) goto L17;
        int r1 = r0.nextInt();
        if (r1 != r6) goto L11;
        boolean r2 = true;
    L12:
        TextView r3 = (TextView) ListProtector.get(this.m, r1);
        if (r2 == false) goto L15;
        Typeface r4 = this.j;
    L16:
        r3.setTypeface(r4);
        goto L7
    L15:
        r4 = this.k;
        goto L16
    L11:
        r2 = false;
        goto L12
    }

    public final void setOnSlidePositionChanged(Function1<? super Float, Unit> r1) {
        this.b = r1;
    }

    public final void setSelectedKey(String r5) {
        Iterator<ConversationMode> r0 = this.l.iterator();
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next().a(), r5) == true) goto L10;
        r2 = r2 + 1;
    L10:
        Integer r6 = Integer.valueOf(r2);
        if (r6.intValue() < 0) goto L13;
        r1 = true;
    L13:
        if (r1 == true) goto L16;
        r6 = null;
    L16:
        if (r6 == null) goto L24;
        int r7 = r6.intValue();
        this.p = r7;
        float r3 = r7;
        k(r3);
        j(r3);
        TextView r4 = this.h;
        String r8 = ((ConversationMode) ListProtector.get(this.l, r7)).g();
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        r4.setText(r8);
        return;
    L24:
        return;
    L9:
        r2 = -1;
        goto L10
    }

    public l0(Context r9, l r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "onModeSelected");
        super(r9);
        this.a = r10;
        Integer r11 = Integer.valueOf(getResources().getConfiguration().screenWidthDp);
        if (r11.intValue() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r11 = null;
    L10:
        if (r11 == null) goto L12;
        int r12 = r11.intValue();
    L13:
        float r13 = RangesKt.coerceAtMost(r12 / 390.0f, 1.0f);
        this.c = r13;
        this.d = c(3, r13);
        LayoutInflater.from(r9).inflate(2131562963, this);
        int r14 = 2131377344;
        if (((FrameLayout) ViewBindings.findChildViewById(this, 2131377344)) == null) goto L40;
        r14 = 2131377345;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(this, 2131377345);
        if (r15 == null) goto L40;
        r14 = 2131377346;
        View r1 = ViewBindings.findChildViewById(this, 2131377346);
        if (r1 == null) goto L40;
        r14 = 2131377347;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(this, 2131377347);
        if (r4 == null) goto L40;
        r14 = 2131377348;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(this, 2131377348);
        if (r5 == null) goto L40;
        r14 = 2131377349;
        TextView r6 = (TextView) ViewBindings.findChildViewById(this, 2131377349);
        if (r6 == null) goto L40;
        this.e = r15;
        this.f = r1;
        this.g = r5;
        this.h = r6;
        this.i = r4;
        int r16 = Build.VERSION.SDK_INT;
        if (r16 < 28) goto L28;
        Typeface r7 = Typeface.create(Typeface.create("sans-serif", 0), 500, false);
    L29:
        this.j = r7;
        if (r16 < 28) goto L32;
        Typeface r8 = Typeface.create(Typeface.create("sans-serif", 0), 400, false);
    L33:
        this.k = r8;
        this.l = CollectionsKt.emptyList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.q = -1;
        this.x = z2.a.enableModeSwitchTitleIcon();
        this.z = new ArgbEvaluator();
        r1.setStateListAnimator(null);
        if (r16 < 28) goto L36;
        Typeface r17 = Typeface.create(Typeface.create("sans-serif", 0), 600, false);
    L37:
        r6.setTypeface(r17);
        a();
        return;
    L36:
        r17 = Typeface.create("sans-serif", 1);
        goto L37
    L32:
        r8 = Typeface.create("sans-serif", 0);
        goto L33
    L28:
        r7 = Typeface.create("sans-serif-medium", 0);
    L40:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r14)));
    L12:
        r12 = 390;
        goto L13
    L5:
        r0 = false;
        goto L7
    }

    public final void b(float r5, Integer r6) {
        ViewGroup.LayoutParams r0 = this.f.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        int r2 = h(r5) + (this.d * 2);
        if (r1.width == r2) goto L5;
        r1.width = r2;
        this.f.setLayoutParams(r1);
    L5:
        this.f.setTranslationX(d(r5));
        if (r6 == null) goto L8;
        int r7 = r6.intValue();
    L14:
        l(r5, this.r, r7);
        j(r5);
        int r3 = this.r;
        int r8 = RangesKt.coerceIn(r7, 0, (int) e());
        float r9 = RangesKt.coerceIn(r5, 0.0f, e());
        if (r8 != r3) goto L24;
        float r10 = r3;
        if (r9 <= r10) goto L21;
        r8 = r3 + 1;
        goto L24
    L21:
        if (r9 >= r10) goto L23;
        r8 = r3 - 1;
        goto L24
    L23:
        r8 = r3;
    L24:
        int r11 = RangesKt.coerceIn(r8, 0, (int) e());
        float r12 = RangesKt.coerceIn(Math.abs(r9 - r3) / RangesKt.coerceAtLeast(Math.abs(r11 - r3), 1), 0.0f, 1.0f);
        if (r12 < 0.5f) goto L29;
        r3 = r11;
    L29:
        if (r3 == this.p) goto L35;
        this.p = r3;
        ConversationMode r13 = (ConversationMode) CollectionsKt.getOrNull(this.l, r3);
        if (r13 == null) goto L35;
        String r14 = r13.a();
        if (r14 == null) goto L35;
        this.a.invoke(r14, Boolean.valueOf(this.t));
    L35:
        Function1<? super Float, Unit> r15 = this.b;
        if (r15 == null) goto L39;
        r15.invoke(Float.valueOf(r12));
        return;
    L39:
        return;
    L8:
        r7 = this.r;
        if (r5 <= r7) goto L12;
        r7 = r7 + 1;
        goto L14
    L12:
        if (r5 >= r7) goto L14;
        r7 = r7 - 1;
        goto L14
    }

    public final int c(int r2, float r3) {
        float r4 = r2 * r3;
        Resources r5 = getResources();
        return (int) ((r4 * WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density) + 0.5f);
    }

    public final void f(int r6, boolean r7) {
        final int r0 = this.o;
        int r8 = RangesKt.coerceIn(r6, 0, (int) e());
        if (this.o != r8) goto L5;
        return;
    L5:
        this.t = r7;
        this.r = r0;
        this.o = r8;
        final float r9 = r8;
        int r10 = this.v + 1;
        this.v = r10;
        ValueAnimator r2 = this.w;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        this.u = true;
        final float r1 = this.s;
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r3.setDuration(150);
        r3.addUpdateListener(new i0(r1, r9, this, r0));
        r3.addListener(new m0(r10, this, r9));
        r3.start();
        this.w = r3;
    }

    public final void g(String r5, boolean r6) {
        Iterator<ConversationMode> r0 = this.l.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next().a(), r5) == true) goto L10;
        r2 = r2 + 1;
    L10:
        Integer r7 = Integer.valueOf(r2);
        if (r7.intValue() < 0) goto L13;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L18;
        r7 = null;
    L18:
        if (r7 == null) goto L33;
        int r8 = r7.intValue();
        if (r6 == true) goto L22;
    L24:
        if (r6 == false) goto L26;
        f(r8, false);
        return;
    L26:
        this.v++;
        ValueAnimator r9 = this.w;
        if (r9 == null) goto L29;
        r9.cancel();
    L29:
        this.u = false;
        this.o = r8;
        this.p = r8;
        this.r = r8;
        float r10 = r8;
        this.s = r10;
        this.t = false;
        b(r10, null);
        this.h.setAlpha(1.0f);
        return;
    L22:
        if (r8 != this.o) goto L24;
        return;
    L33:
        return;
    L13:
        r1 = false;
        goto L15
    L9:
        r2 = -1;
        goto L10
    }

    public final int i(int r2, int r3) {
        int r4 = v19.c.b(r2, getContext(), r3);
        return ContextCompat.getColor(getContext(), r4);
    }

    public final void l(float r5, int r6, int r7) {
        float r8 = RangesKt.coerceIn(Math.abs(r5 - r6) / RangesKt.coerceAtLeast(Math.abs(r7 - r6), 1), 0.0f, 1.0f);
        if (r8 >= 0.5f) goto L5;
        float r1 = 1.0f - (r8 / 0.5f);
    L6:
        this.g.setAlpha(r1);
        ImageView r9 = this.g;
        int r2 = 8;
        if (this.x == true) goto L9;
    L19:
        r9.setVisibility(r2);
        return;
    L9:
        if (this.y == false) goto L19;
        if (r1 <= 0.0f) goto L19;
        ConversationMode r10 = (ConversationMode) CollectionsKt.getOrNull(this.l, r6);
        if (r10 == null) goto L15;
        String r11 = r10.a();
    L17:
        if (Intrinsics.areEqual(r11, "office") == false) goto L19;
        r2 = 0;
        goto L19
    L15:
        r11 = null;
        goto L17
    L5:
        r1 = (r8 - 0.5f) / 0.5f;
        r6 = r7;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        ViewGroup.LayoutParams r6 = this.f.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        if (this.u == false) goto L5;
        float r8 = this.s;
    L6:
        int r9 = h(r8) + (this.d * 2);
        int r10 = RangesKt.coerceAtLeast(this.i.getHeight(), c(44, this.c)) + (this.d * 2);
        if (r7.width == r9) goto L9;
    L10:
        r7.width = r9;
        r7.height = r10;
        this.f.setLayoutParams(r7);
    L12:
        if (this.u == true) goto L15;
        this.f.setTranslationX(d(this.o));
        k(this.p);
        j(this.o);
        return;
    L15:
        return;
    L9:
        if (r7.height == r10) goto L12;
    L5:
        r8 = this.o;
        goto L6
    }
}
