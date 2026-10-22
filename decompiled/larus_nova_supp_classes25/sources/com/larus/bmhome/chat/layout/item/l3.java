package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import com.larus.bmhome.chat.list.cell.prompt.WcbItemLinearLayout;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l3 {
    public static final PathInterpolator p = null;
    public final ViewGroup a;
    public final String b;
    public final Function0<Integer> c;
    public final Function1<View, String> d;
    public final Function1<View, String> e;
    public Animator f;
    public AnimatorSet g;
    public ValueAnimator h;
    public Integer i;
    public List<? extends Pair<? extends View, Integer>> j;
    public Integer k;
    public Rect l;
    public boolean m;
    public boolean n;
    public int o;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "DirectChildWidth(measuredWidth=" + this.a + ", marginWidth=" + this.b + ')';
        }

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
            this.c = r1 + r2;
        }
    }

    public static final class c {
        public final View a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "RefreshChildWidth(child=" + this.a + ", originalWidth=" + this.b + ", startWidth=" + this.c + ", targetWidth=" + this.d + ')';
        }

        public c(View r2, int r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "child");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        p = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
    }

    public final void b() {
        AnimatorSet r0 = this.g;
        ValueAnimator r1 = this.h;
        Animator r2 = this.f;
        if (r2 == null) goto L9;
        if (r0 != null) goto L6;
        boolean r5 = true;
    L7:
        if (r5 == false) goto L9;
    L10:
        this.o++;
        this.f = null;
        this.g = null;
        this.h = null;
        if (r2 == null) goto L13;
        r2.cancel();
    L13:
        if (r0 == null) goto L15;
        r0.cancel();
    L15:
        if (r0 != null) goto L18;
        if (r1 == null) goto L18;
        r1.cancel();
    L18:
        this.a.animate().cancel();
        this.a.setAlpha(1.0f);
        f(this.i);
        return;
    L6:
        r5 = false;
    L9:
        r2 = null;
        goto L10
    }

    public final Integer c() {
        if (this.n == false) goto L5;
        Integer r0 = this.k;
    L9:
        boolean r2 = true;
        if (r0 != null) goto L12;
    L20:
        int r1 = ((Number) this.c.invoke()).intValue();
    L21:
        Integer r3 = Integer.valueOf(r1);
        if (r3.intValue() <= 0) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == true) goto L28;
        r3 = null;
    L28:
        if (r3 == null) goto L56;
        int r5 = r3.intValue();
        int r6 = RangesKt.coerceAtLeast((r5 - this.a.getPaddingLeft()) - this.a.getPaddingRight(), 0);
        IntIterator r7 = RangesKt.until(0, this.a.getChildCount()).iterator();
        if (r7.hasNext() == true) goto L32;
        Integer r8 = null;
    L38:
        if (r8 == null) goto L40;
        int r9 = r8.intValue();
    L41:
        Integer r10 = Integer.valueOf((this.a.getPaddingLeft() + this.a.getPaddingRight()) + r9);
        if (r10.intValue() > 0) goto L45;
        r2 = false;
    L45:
        if (r2 == true) goto L48;
        r10 = null;
    L48:
        if (r10 != null) goto L50;
        return null;
    L50:
        return Integer.valueOf(RangesKt.coerceAtMost(r10.intValue(), r5));
    L40:
        r9 = 0;
        goto L41
    L32:
        IntIterator r11 = r7;
        r8 = Integer.valueOf(e(this.a.getChildAt(r11.nextInt()), r6).c);
    L34:
        if (r7.hasNext() == false) goto L38;
        Integer r12 = Integer.valueOf(e(this.a.getChildAt(r11.nextInt()), r6).c);
        if (r8.compareTo(r12) >= 0) goto L34;
        r8 = r12;
        goto L34
    L56:
        return null;
    L24:
        r4 = false;
        goto L25
    L12:
        if (r0.intValue() <= 0) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == true) goto L18;
        r0 = null;
    L18:
        if (r0 == null) goto L20;
        r1 = r0.intValue();
        goto L21
    L14:
        r13 = false;
        goto L15
    L5:
        ViewGroup.LayoutParams r14 = this.a.getLayoutParams();
        if (r14 == null) goto L8;
        r0 = Integer.valueOf(r14.width);
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    public final Map<String, Integer> d(int r11) {
        int r12 = RangesKt.coerceAtLeast((r11 - this.a.getPaddingLeft()) - this.a.getPaddingRight(), 0);
        LinkedHashMap r1 = new LinkedHashMap();
        LinkedHashSet r2 = new LinkedHashSet();
        int r3 = this.a.getChildCount();
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L29;
        View r5 = this.a.getChildAt(r4);
        Intrinsics.checkNotNull(r5);
        boolean r8 = true;
        if (r5.getVisibility() != 8) goto L7;
        boolean r6 = true;
    L8:
        String r7 = null;
        if (r6 == false) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L28;
        String r9 = (String) this.d.invoke(r5);
        if (r9 == null) goto L28;
        if (r9.length() > 0) goto L20;
        r8 = false;
    L20:
        if (r8 == false) goto L22;
        r7 = r9;
    L22:
        if (r7 == null) goto L28;
        if (r1.containsKey(r7) == false) goto L27;
        r2.add(r7);
        goto L28
    L27:
        r1.put(r7, Integer.valueOf(e(r5, r12).a));
    L28:
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = false;
        goto L8
    L29:
        Iterator r13 = r2.iterator();
    L31:
        if (r13.hasNext() == false) goto L33;
        r1.remove((String) r13.next());
        goto L31
    L33:
        return r1;
    }

    public final void f(Integer r7) {
        if (this.n == true) goto L10;
        if (r7 != null) goto L10;
        if (this.m == true) goto L10;
        if (this.j.isEmpty() == false) goto L10;
        return;
    L10:
        ViewGroup.LayoutParams r8 = this.a.getLayoutParams();
        boolean r0 = this.n;
        this.n = false;
        this.i = null;
        if (this.m == false) goto L13;
        this.a.setClipBounds(this.l);
        this.l = null;
        this.m = false;
    L13:
        Iterator<T> r1 = this.j.iterator();
    L15:
        if (r1.hasNext() == false) goto L19;
        Pair r3 = (Pair) r1.next();
        View r4 = (View) r3.component1();
        int r5 = ((Number) r3.component2()).intValue();
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        if (r6 == null) goto L15;
        r6.width = r5;
        r4.setLayoutParams(r6);
        goto L15
    L19:
        this.j = CollectionsKt.emptyList();
        if (r0 == true) goto L23;
        this.k = null;
        return;
    L23:
        if (r8 != null) goto L25;
        return;
    L25:
        Integer r2 = this.k;
        if (r2 == null) goto L28;
        int r9 = r2.intValue();
    L29:
        r8.width = r9;
        this.k = null;
        this.a.setLayoutParams(r8);
        return;
    L28:
        r9 = r8.width;
        goto L29
    }

    public final void h(int r3) {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.n == true) goto L8;
        this.k = Integer.valueOf(r0.width);
    L8:
        r0.width = r3;
        this.a.setLayoutParams(r0);
        this.n = true;
    }

    public static b e(View r3, int r4) {
        int r2 = 0;
        if (r3.getVisibility() != 8) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        r3.measure(View.MeasureSpec.makeMeasureSpec(r4, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
    L13:
        if (r6 == null) goto L16;
        r2 = r6.leftMargin + r6.rightMargin;
    L16:
        return new b(r3.getMeasuredWidth(), r2);
    L12:
        r6 = null;
        goto L13
    L8:
        return new b(0, 0);
    L5:
        r0 = false;
        goto L6
    }

    public static void g(View r1, int r2) {
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.width = r2;
        r1.setLayoutParams(r0);
        return;
    }

    public l3(ViewGroup r3, s2 r4, t2 r5, u2 r6) {
        Intrinsics.checkNotNullParameter(r3, "targetView");
        Intrinsics.checkNotNullParameter("WcbSugPromptSpan", "tag");
        Intrinsics.checkNotNullParameter(r4, "maxWidthProvider");
        Intrinsics.checkNotNullParameter(r5, "childKeyProvider");
        Intrinsics.checkNotNullParameter(r6, "childChangeKeyProvider");
        this.a = r3;
        this.b = "WcbSugPromptSpan";
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.j = CollectionsKt.emptyList();
    }

    public final void a(String r35, Set r36, Map r37, n2 r38) {
        final l3 r13 = this;
        Set r15 = r36;
        Map r12 = r37;
        Intrinsics.checkNotNullParameter(r12, "changedWcbItemStartKeys");
        Intrinsics.checkNotNullParameter(r38, "updateContent");
        b();
        Integer r16 = null;
        String r5 = "alpha";
        if (r15 != null) goto L5;
        Integer r0 = c();
        if (r0 != null) goto L200;
        r0 = Integer.valueOf(r13.a.getWidth());
        if (r0.intValue() <= 0) goto L186;
        boolean r7 = true;
    L187:
        if (r7 == true) goto L190;
        r0 = null;
    L190:
        if (r0 != null) goto L200;
        r0 = Integer.valueOf(r13.a.getMeasuredWidth());
        if (r0.intValue() <= 0) goto L195;
        boolean r8 = true;
    L196:
        if (r8 == true) goto L199;
        r0 = null;
    L199:
        if (r0 != null) goto L200;
        ViewGroup.LayoutParams r1 = r13.a.getLayoutParams();
        if (r1 == null) goto L209;
        r0 = Integer.valueOf(r1.width);
        if (r0.intValue() <= 0) goto L206;
        boolean r9 = true;
    L207:
        if (r9 == false) goto L209;
    L210:
        if (r0 != null) goto L200;
        int r10 = 0;
    L213:
        Map<String, Integer> r2 = r13.d(r10);
        if (r10 <= 0) goto L216;
        r13.h(r10);
    L216:
        final int r14 = r13.o + 1;
        r13.o = r14;
        Integer r3 = Integer.valueOf(r13.a.getHeight());
        if (r3.intValue() <= 0) goto L219;
        boolean r4 = true;
    L220:
        if (r4 == true) goto L223;
        r3 = null;
    L223:
        if (r3 != null) goto L233;
        r3 = Integer.valueOf(r13.a.getMeasuredHeight());
        if (r3.intValue() <= 0) goto L228;
        boolean r6 = true;
    L229:
        if (r6 == true) goto L232;
        r3 = null;
    L232:
        if (r3 != null) goto L233;
        int r11 = 0;
    L235:
        ViewParent r17 = r13.a.getParent();
        if ((r17 instanceof ViewGroup) == false) goto L238;
        final ViewGroup r18 = (ViewGroup) r17;
    L239:
        if (r18 == null) goto L250;
        if (r10 <= 0) goto L250;
        if (r11 <= 0) goto L250;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L244
        Bitmap r20 = Bitmap.createBitmap(r10, r11, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L244
        r13.a.draw(new Canvas(r20));     // Catch: Throwable -> L244
        ClipDrawable r21 = new ClipDrawable(new BitmapDrawable(r13.a.getResources(), r20), 8388611, 1);     // Catch: Throwable -> L244
        r21.setBounds(r13.a.getLeft(), r13.a.getTop(), r13.a.getLeft() + r10, r13.a.getTop() + r11);     // Catch: Throwable -> L244
        r21.setLevel(10000);     // Catch: Throwable -> L244
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L244
    L247:
        if (Result.isFailure-impl(r22) == false) goto L249;
        r22 = null;
    L249:
        final ClipDrawable r23 = (ClipDrawable) r22;
    L251:
        if (r23 == null) goto L256;
        if (r18 == null) goto L256;
        ViewGroupOverlay r24 = r18.getOverlay();
        if (r24 == null) goto L256;
        r24.add(r23);
        Unit r25 = Unit.INSTANCE;
    L256:
        if (r23 == null) goto L258;
        ValueAnimator r26 = ValueAnimator.ofInt(new int[]{255, 0});
        r26.setDuration(100);
        r26.setInterpolator(p);
        r26.addUpdateListener(new j3(r23, r18));
        r26.addListener(new o3(r13, r18, r23));
    L259:
        r13.f = r26;
        r38.invoke();
        Integer r27 = c();
        if (r13.n == false) goto L262;
        Integer r28 = r13.k;
    L266:
        if (r27 != null) goto L286;
        if (r28 != null) goto L270;
    L275:
        r28 = null;
    L276:
        if (r28 == null) goto L278;
        int r29 = r28.intValue();
    L287:
        final int r110 = r29;
        FLogger.a.i(r13.b, "refreshStartCombined contentKey=" + r35 + ", startWidth=" + r10 + ", targetWidth=" + r110);
        Map<String, Integer> r30 = r13.d(r110);
        if ((!r2.isEmpty()) == true) goto L292;
    L294:
        boolean r31 = false;
    L296:
        if (r30.isEmpty() == true) goto L311;
        Iterator r32 = ((LinkedHashMap) r30).entrySet().iterator();
    L300:
        if (r32.hasNext() == false) goto L311;
        Map.Entry r33 = (Map.Entry) r32.next();
        String r34 = (String) r33.getKey();
        int r39 = ((Number) r33.getValue()).intValue();
        Integer r40 = (Integer) ((LinkedHashMap) r2).get(r34);
        if (r40 == null) goto L308;
        int r41 = r40.intValue();
        if (r31 == false) goto L308;
        if (r41 <= r39) goto L308;
        if (r39 <= 0) goto L308;
        boolean r42 = true;
    L309:
        if (r42 == false) goto L300;
        boolean r43 = true;
    L312:
        if (r10 <= r110) goto L315;
        if (r110 <= 0) goto L315;
        boolean r44 = true;
    L316:
        r13.a.setAlpha(0.0f);
        if (r44 == true) goto L321;
        if (r43 == true) goto L321;
        boolean r45 = false;
    L322:
        ArrayList r46 = new ArrayList();
        if (r26 == null) goto L325;
        r46.add(r26);
    L325:
        if (r110 > 0) goto L327;
        r13.f(Integer.valueOf(r110));
        ArrayList r310 = r46;
    L470:
        ArrayList r311 = r310;
        int r111 = r14;
        final l3 r47 = r13;
        ValueAnimator r48 = null;
        float r112 = 0.0f;
        char r113 = 0;
    L516:
        ArrayList r49 = r311;
        if (r48 == null) goto L519;
        r49.add(r48);
    L519:
        ViewGroup r50 = r47.a;
        float[] r51 = new float[2];
        r51[r113] = r112;
        r51[1] = 1.0f;
        ObjectAnimator r52 = ObjectAnimator.ofFloat(r50, "alpha", r51);
        r52.setDuration(240);
        r52.setInterpolator(p);
        r49.add(r52);
        if (r49.isEmpty() == false) goto L522;
        r47.a.setAlpha(1.0f);
        return;
    L522:
        AnimatorSet r53 = new AnimatorSet();
        r53.playTogether(r49);
        r53.addListener(new q3(r47, r111, r35));
        r53.start();
        r47.g = r53;
        return;
    L327:
        Integer r54 = Integer.valueOf(r10);
        if (r54.intValue() <= 0) goto L330;
        boolean r55 = true;
    L331:
        if (r55 == true) goto L334;
        r54 = null;
    L334:
        if (r54 == null) goto L336;
        final int r56 = r54.intValue();
    L337:
        if (r56 >= r110) goto L339;
        final boolean r57 = true;
    L340:
        if (r56 == r110) goto L342;
        boolean r58 = true;
    L343:
        if (r58 == true) goto L345;
    L351:
        if (r31 == false) goto L355;
        if (r57 == true) goto L355;
        if (r58 == true) goto L355;
        boolean r59 = true;
    L356:
        if (r45 == false) goto L359;
        if (r58 == true) goto L359;
        boolean r60 = true;
    L360:
        int r61 = RangesKt.coerceAtLeast((r110 - r13.a.getPaddingLeft()) - r13.a.getPaddingRight(), 0);
        LinkedHashSet r114 = new LinkedHashSet();
        LinkedHashSet r115 = new LinkedHashSet();
        int r62 = r13.a.getChildCount();
        r310 = r46;
        int r63 = 0;
    L361:
        if (r63 >= r62) goto L386;
        View r116 = r13.a.getChildAt(r63);
        Intrinsics.checkNotNull(r116);
        int r312 = r62;
        if (r116.getVisibility() != 8) goto L365;
        boolean r64 = true;
    L366:
        if (r64 == true) goto L368;
        View r117 = r116;
    L369:
        if (r117 == null) goto L385;
        String r65 = (String) r13.d.invoke(r117);
        if (r65 == null) goto L385;
        if (r65.length() <= 0) goto L376;
        boolean r118 = true;
    L377:
        if (r118 == true) goto L380;
        r65 = null;
    L380:
        if (r65 == null) goto L385;
        if (r114.add(r65) == true) goto L385;
        r115.add(r65);
        goto L385
    L376:
        r118 = false;
    L385:
        r63 = r63 + 1;
        r62 = r312;
        goto L361
    L368:
        r117 = null;
        goto L369
    L365:
        r64 = false;
        goto L366
    L386:
        r114.removeAll(r115);
        IntRange r66 = RangesKt.until(0, r13.a.getChildCount());
        final ArrayList r119 = new ArrayList();
        Iterator r67 = r66.iterator();
    L388:
        if (r67.hasNext() == false) goto L446;
        View r68 = r13.a.getChildAt(((IntIterator) r67).nextInt());
        Intrinsics.checkNotNull(r68);
        Iterator r313 = r67;
        if (r68.getVisibility() != 8) goto L392;
        boolean r69 = true;
    L393:
        if (r69 == false) goto L396;
        r68 = null;
    L396:
        if (r68 != null) goto L398;
    L397:
        LinkedHashSet r120 = r114;
        c r121 = null;
    L443:
        if (r121 == null) goto L445;
        r119.add(r121);
    L445:
        r67 = r313;
        r23 = r23;
        r114 = r120;
        goto L388
    L398:
        ViewGroup.LayoutParams r70 = r68.getLayoutParams();
        if (r70 == null) goto L397;
        int r71 = r70.width;
        Integer r122 = Integer.valueOf(e(r68, r61).a);
        if (r122.intValue() <= 0) goto L404;
        boolean r123 = true;
    L405:
        if (r123 == true) goto L408;
        r122 = null;
    L408:
        if (r122 == null) goto L397;
        int r124 = RangesKt.coerceAtMost(r122.intValue(), r61);
        String r72 = (String) r13.d.invoke(r68);
        if (r72 != null) goto L412;
    L417:
        r72 = null;
    L418:
        if (r72 != null) goto L420;
    L432:
        r120 = r114;
    L433:
        Integer r73 = null;
    L434:
        if (r60 == false) goto L437;
        if (r73 == null) goto L440;
        int r74 = RangesKt.coerceAtLeast(r73.intValue(), r124);
    L441:
        r121 = new c(r68, r71, r74, r124);
    L440:
        r74 = r124;
        goto L441
    L437:
        if (r59 == false) goto L440;
        if (r73 == null) goto L440;
        r74 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r73.intValue(), r61), r124);
        goto L441
    L420:
        if (r114.contains(r72) == true) goto L423;
        r72 = null;
    L423:
        if (r72 == null) goto L432;
        r120 = r114;
        r73 = (Integer) ((LinkedHashMap) r2).get(r72);
        if (r73 == null) goto L433;
        if (r73.intValue() <= 0) goto L429;
        boolean r125 = true;
    L430:
        if (r125 == false) goto L433;
    L429:
        r125 = false;
        goto L430
    L412:
        if (r72.length() <= 0) goto L414;
        boolean r126 = true;
    L415:
        if (r126 == false) goto L417;
    L414:
        r126 = false;
        goto L415
    L404:
        r123 = false;
        goto L405
    L392:
        r69 = false;
        goto L393
    L446:
        final ClipDrawable r127 = r23;
        ArrayList r75 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r76 = r119.iterator();
    L448:
        if (r76.hasNext() == false) goto L450;
        c r77 = (c) r76.next();
        r75.add(TuplesKt.to(r77.a, Integer.valueOf(r77.b)));
        goto L448
    L450:
        r13.j = r75;
        Iterator r78 = r119.iterator();
    L452:
        if (r78.hasNext() == false) goto L455;
        c r79 = (c) r78.next();
        g(r79.a, r79.c);
        goto L452
    L455:
        if (r119.isEmpty() == true) goto L466;
        Iterator r80 = r119.iterator();
    L459:
        if (r80.hasNext() == false) goto L466;
        c r81 = (c) r80.next();
        if (r81.c == r81.d) goto L463;
        boolean r82 = true;
    L464:
        if (r82 == false) goto L459;
        boolean r83 = true;
    L467:
        if (r56 != r110) goto L471;
        if (r83 == true) goto L471;
        r13.f(Integer.valueOf(r110));
    L471:
        r13.i = Integer.valueOf(r110);
        if (r57 == false) goto L474;
        int r84 = r110;
    L475:
        r13.h(r84);
        final LinkedHashMap r128 = new LinkedHashMap();
        final ArrayList r85 = new ArrayList();
        Resources r86 = r13.a.getResources();
        final int r129 = RangesKt.coerceAtLeast(MathKt.roundToInt(WindowDisplayMetricsOverride.apply(r86, r86.getDisplayMetrics()).density), 1);
        if (r57 == false) goto L493;
        if (r58 == false) goto L493;
        int r87 = r13.a.getChildCount();
        int r88 = 0;
    L479:
        if (r88 >= r87) goto L493;
        View r89 = r13.a.getChildAt(r88);
        Intrinsics.checkNotNull(r89);
        if (r89.getVisibility() != 8) goto L483;
        boolean r90 = true;
    L484:
        if (r90 == false) goto L487;
        r89 = null;
    L487:
        if (r89 == null) goto L492;
        if (r89.getBackground() == null) goto L492;
        r85.add(r89);
    L492:
        r88 = r88 + 1;
        goto L479
    L483:
        r90 = false;
    L493:
        if (r58 == false) goto L515;
        Integer r91 = Integer.valueOf(r13.a.getHeight());
        if (r91.intValue() <= 0) goto L497;
        boolean r92 = true;
    L498:
        if (r92 == true) goto L501;
        r91 = null;
    L501:
        if (r91 != null) goto L511;
        Integer r93 = Integer.valueOf(r13.a.getMeasuredHeight());
        if (r93.intValue() <= 0) goto L506;
        boolean r94 = true;
    L507:
        if (r94 == false) goto L509;
        r16 = r93;
    L509:
        if (r16 == null) goto L512;
        r91 = r16;
        goto L511
    L512:
        int r95 = Integer.MAX_VALUE;
    L513:
        r13.a.setClipBounds(new Rect(0, 0, r56, r95));
        goto L515
    L506:
        r94 = false;
    L511:
        r95 = r91.intValue();
        goto L513
    L497:
        r92 = false;
    L515:
        ValueAnimator r96 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r96.setDuration(240);
        r96.setInterpolator(p);
        r47 = this;
        r311 = r310;
        final boolean r97 = r58;
        r112 = 0.0f;
        r113 = 0;
        r111 = r14;
        r48 = r96;
        r48.addUpdateListener(new k3(r14, r47, r56, r110, r97, r57, r85, r127, r119, r128, r129));
        r48.addListener(new p3(r128, r111, r47, r110));
        r47.h = r48;
        goto L516
    L474:
        r84 = r56;
        goto L475
    L463:
        r82 = false;
    L466:
        r83 = false;
    L359:
        r60 = false;
    L355:
        r59 = false;
        goto L356
    L345:
        if (r13.m == true) goto L351;
        Rect r99 = r13.a.getClipBounds();
        if (r99 == null) goto L349;
        Rect r100 = new Rect(r99);
    L350:
        r13.l = r100;
        r13.m = true;
        goto L351
    L349:
        r100 = null;
        goto L350
    L342:
        r58 = false;
        goto L343
    L339:
        r57 = false;
        goto L340
    L336:
        r56 = r110;
        goto L337
    L330:
        r55 = false;
    L321:
        r45 = true;
    L315:
        r44 = false;
    L308:
        r42 = false;
    L311:
        r43 = false;
        goto L312
    L292:
        if ((!r30.isEmpty()) == false) goto L294;
        r31 = true;
        goto L296
    L278:
        r27 = Integer.valueOf(r13.a.getMeasuredWidth());
        if (r27.intValue() <= 0) goto L281;
        boolean r101 = true;
    L282:
        if (r101 == true) goto L285;
        r27 = null;
    L285:
        if (r27 != null) goto L286;
        r29 = ((Number) r13.c.invoke()).intValue();
        goto L287
    L281:
        r101 = false;
        goto L282
    L270:
        if (r28.intValue() <= 0) goto L272;
        boolean r102 = true;
    L273:
        if (r102 == false) goto L275;
    L272:
        r102 = false;
    L286:
        r29 = r27.intValue();
        goto L287
    L262:
        ViewGroup.LayoutParams r103 = r13.a.getLayoutParams();
        if (r103 == null) goto L265;
        r28 = Integer.valueOf(r103.width);
        goto L266
    L265:
        r28 = null;
        goto L266
    L258:
        r26 = null;
    L244:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
    L250:
        r23 = null;
        goto L251
    L238:
        r18 = null;
        goto L239
    L228:
        r6 = false;
    L233:
        r11 = r3.intValue();
        goto L235
    L219:
        r4 = false;
        goto L220
    L206:
        r9 = false;
    L209:
        r0 = null;
        goto L210
    L195:
        r8 = false;
        goto L196
    L186:
        r7 = false;
    L200:
        r10 = r0.intValue();
        goto L213
    L5:
        if (r36.isEmpty() == false) goto L8;
        r38.invoke();
        return;
    L8:
        int r130 = r13.o + 1;
        r13.o = r130;
        LinkedHashMap r105 = new LinkedHashMap();
        LinkedHashMap r131 = new LinkedHashMap();
        int r106 = r13.a.getChildCount();
        int r132 = 0;
    L9:
        if (r132 >= r106) goto L72;
        View r107 = r13.a.getChildAt(r132);
        if ((r107 instanceof WcbItemLinearLayout) == false) goto L13;
        WcbItemLinearLayout r108 = (WcbItemLinearLayout) r107;
    L14:
        if (r108 != null) goto L16;
    L15:
        int r314 = r106;
    L71:
        r132 = r132 + 1;
        r106 = r314;
        goto L9
    L16:
        String r109 = (String) r13.e.invoke(r108);
        if (r109 == null) goto L15;
        if (r15.contains(r109) == false) goto L15;
        Integer r210 = Integer.valueOf(r108.getWidth());
        if (r210.intValue() <= 0) goto L24;
        boolean r211 = true;
    L25:
        if (r211 == true) goto L28;
        r210 = null;
    L28:
        if (r210 != null) goto L38;
        r210 = Integer.valueOf(r108.getMeasuredWidth());
        if (r210.intValue() <= 0) goto L33;
        boolean r212 = true;
    L34:
        if (r212 == true) goto L37;
        r210 = null;
    L37:
        if (r210 == null) goto L15;
    L33:
        r212 = false;
    L38:
        int r133 = r210.intValue();
        Integer r213 = Integer.valueOf(r108.getHeight());
        if (r213.intValue() <= 0) goto L41;
        boolean r214 = true;
    L42:
        if (r214 == true) goto L45;
        r213 = null;
    L45:
        if (r213 != null) goto L55;
        r213 = Integer.valueOf(r108.getMeasuredHeight());
        if (r213.intValue() <= 0) goto L50;
        boolean r215 = true;
    L51:
        if (r215 == true) goto L54;
        r213 = null;
    L54:
        if (r213 == null) goto L15;
    L50:
        r215 = false;
    L55:
        int r134 = r213.intValue();
        Result.Companion r216 = Result.Companion;     // Catch: Throwable -> L62
        Bitmap r135 = Bitmap.createBitmap(r133, r134, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L62
        r108.draw(new Canvas(r135));     // Catch: Throwable -> L62
        r314 = r106;
        ClipDrawable r136 = new ClipDrawable(new BitmapDrawable(r13.a.getResources(), r135), 8388611, 1);     // Catch: Throwable -> L60
        r136.setBounds(r108.getLeft(), r108.getTop(), r108.getLeft() + r133, r108.getTop() + r134);     // Catch: Throwable -> L60
        r136.setLevel(10000);     // Catch: Throwable -> L60
        Object r137 = Result.constructor-impl(r136);     // Catch: Throwable -> L60
    L66:
        if (Result.isFailure-impl(r137) == false) goto L68;
        r137 = null;
    L68:
        ClipDrawable r138 = (ClipDrawable) r137;
        if (r138 == null) goto L71;
        r105.put(r109, r138);
        r131.put(r109, Integer.valueOf(r133));
        r13.a.getOverlay().add(r138);
        Unit r139 = Unit.INSTANCE;
    L60:
        th = th;
    L64:
        Result.Companion r140 = Result.Companion;
        r137 = Result.constructor-impl(ResultKt.createFailure(th));
    L62:
        th = th;
        r314 = r106;
        goto L64
    L41:
        r214 = false;
        goto L42
    L24:
        r211 = false;
        goto L25
    L13:
        r108 = null;
        goto L14
    L72:
        r38.invoke();
        int r141 = RangesKt.coerceAtLeast((((Number) r13.c.invoke()).intValue() - r13.a.getPaddingLeft()) - r13.a.getPaddingRight(), 0);
        ArrayList r142 = new ArrayList();
        Iterator r143 = r105.entrySet().iterator();
    L74:
        if (r143.hasNext() == false) goto L76;
        final ClipDrawable r144 = (ClipDrawable) ((Map.Entry) r143.next()).getValue();
        ValueAnimator r145 = ValueAnimator.ofInt(new int[]{255, 0});
        r145.setDuration(240);
        r145.setInterpolator(p);
        r145.addUpdateListener(new h3(r144, r13));
        r145.addListener(new m3(r13, r144));
        r142.add(r145);
        goto L74
    L76:
        ArrayList r146 = new ArrayList();
        ArrayList r147 = new ArrayList();
        final LinkedHashMap r148 = new LinkedHashMap();
        Resources r149 = r13.a.getResources();
        int r150 = RangesKt.coerceAtLeast(MathKt.roundToInt(WindowDisplayMetricsOverride.apply(r149, r149.getDisplayMetrics()).density), 1);
        int r151 = r13.a.getChildCount();
        int r152 = 0;
    L77:
        if (r152 >= r151) goto L174;
        View r153 = r13.a.getChildAt(r152);
        int r217 = r152;
        if ((r153 instanceof WcbItemLinearLayout) == false) goto L81;
        WcbItemLinearLayout r154 = (WcbItemLinearLayout) r153;
    L82:
        if (r154 != null) goto L84;
    L83:
        r141 = r141;
        final LinkedHashMap r218 = r105;
        r5 = r5;
        final int r155 = r150;
        r148 = r148;
        ArrayList r219 = r147;
        ArrayList r315 = r146;
        r131 = r131;
        r217 = r217;
        int r220 = r151;
    L172:
        ArrayList r156 = r142;
    L173:
        r152 = r217 + 1;
        r13 = this;
        r15 = r36;
        r12 = r37;
        r150 = r155;
        r142 = r156;
        r131 = r131;
        r5 = r5;
        r151 = r220;
        r148 = r148;
        r147 = r219;
        r105 = r218;
        r146 = r315;
        r130 = r130;
        r141 = r141;
        goto L77
    L84:
        String r157 = (String) r13.e.invoke(r154);
        if (r157 == null) goto L83;
        if (r15.contains(r157) == false) goto L83;
        int r316 = r151;
        ViewGroup.LayoutParams r158 = r154.getLayoutParams();
        if (r158 != null) goto L92;
        r218 = r105;
    L170:
        r155 = r150;
        r219 = r147;
        r315 = r146;
    L171:
        r220 = r316;
        goto L172
    L92:
        int r159 = r158.width;
        r218 = r105;
        Integer r160 = Integer.valueOf(e(r154, r141).a);
        if (r160.intValue() <= 0) goto L95;
        boolean r221 = true;
    L96:
        if (r221 == true) goto L99;
        r160 = null;
    L99:
        if (r160 == null) goto L170;
        final int r161 = RangesKt.coerceAtMost(r160.intValue(), r141);
        Integer r222 = (Integer) r131.get(r157);
        if (r222 != null) goto L103;
    L111:
        r141 = r141;
        String r162 = (String) r12.get(r157);
        if (r162 == null) goto L121;
        Integer r163 = (Integer) r131.get(r162);
        if (r163 == null) goto L121;
        if (r163.intValue() <= 0) goto L118;
        boolean r223 = true;
    L119:
        if (r223 == false) goto L121;
    L122:
        if (r163 == null) goto L124;
        int r164 = r163.intValue();
    L125:
        r146.add(TuplesKt.to(r154, Integer.valueOf(r159)));
        r154.setAlpha(0.0f);
        if (r164 >= r161) goto L128;
        boolean r224 = true;
    L129:
        Integer r165 = Integer.valueOf(r154.getHeight());
        if (r165.intValue() <= 0) goto L132;
        boolean r225 = true;
    L133:
        if (r225 == true) goto L136;
        r165 = null;
    L136:
        if (r165 != null) goto L144;
        r165 = Integer.valueOf(r154.getMeasuredHeight());
        if (r165.intValue() <= 0) goto L140;
        boolean r226 = true;
    L141:
        if (r226 == true) goto L144;
        Integer r227 = null;
    L145:
        if (r224 == false) goto L164;
        g(r154, r161);
        if (r227 == null) goto L162;
        int r166 = r227.intValue();
        String r228 = r157;
        Rect r167 = r154.getClipBounds();
        ArrayList r229 = r146;
        if (r167 == null) goto L151;
        Rect r168 = new Rect(r167);
    L152:
        r147.add(TuplesKt.to(r154, r168));
        r154.setClipBounds(new Rect(0, 0, r164, r166));
        Drawable r169 = r154.getBackground();
        if (r169 == null) goto L165;
        Drawable.ConstantState r170 = r169.getConstantState();
        if (r170 == null) goto L165;
        Drawable r171 = r170.newDrawable();
        if (r171 == null) goto L165;
        Drawable r172 = r171.mutate();
        if (r172 == null) goto L165;
        r150 = r150;
        int r173 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r150, r161), 1);
        Bitmap r174 = Bitmap.createBitmap(r173, r166, Bitmap.Config.ARGB_8888);
        r147 = r147;
        Canvas r175 = new Canvas(r174);
        r175.translate(-(r161 - r173), 0.0f);
        r172.setBounds(0, 0, r161, r166);
        r172.draw(r175);
        BitmapDrawable r176 = new BitmapDrawable(r13.a.getResources(), r174);
        r176.setBounds(RangesKt.coerceAtLeast(r164 - r173, 0), 0, r164, r166);
        r176.setAlpha(0);
        r154.getOverlay().add(r176);
        r148.put(r154, r176);
    L165:
        ObjectAnimator r177 = ObjectAnimator.ofFloat(r154, r5, new float[]{0.0f, 1.0f});
        r177.setDuration(240);
        PathInterpolator r178 = p;
        r177.setInterpolator(r178);
        r142.add(r177);
        if (r164 == r161) goto L168;
        ValueAnimator r179 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r179.setDuration(240);
        r179.setInterpolator(r178);
        final String r180 = r228;
        final WcbItemLinearLayout r230 = r154;
        r217 = r217;
        final int r181 = r130;
        r220 = r316;
        String r182 = r5;
        final int r183 = r164;
        r5 = r182;
        r155 = r150;
        r148 = r148;
        final boolean r184 = r224;
        r219 = r147;
        final Integer r185 = r227;
        r130 = r130;
        r156 = r142;
        r131 = r131;
        r315 = r229;
        r179.addUpdateListener(new i3(r181, this, r230, r183, r161, r184, r185, r148, r218, r180, r155));
        r156.add(r179);
        goto L173
    L168:
        r315 = r229;
        r155 = r150;
        r219 = r147;
        goto L171
    L151:
        r168 = null;
        goto L152
    L162:
        r228 = r157;
        r229 = r146;
        goto L165
    L164:
        r228 = r157;
        r150 = r150;
        r147 = r147;
        r229 = r146;
        g(r154, r164);
        Unit r186 = Unit.INSTANCE;
        goto L165
    L140:
        r226 = false;
    L144:
        r227 = r165;
        goto L145
    L132:
        r225 = false;
        goto L133
    L128:
        r224 = false;
        goto L129
    L124:
        r164 = r161;
        goto L125
    L118:
        r223 = false;
    L121:
        r163 = null;
        goto L122
    L103:
        if (r222.intValue() <= 0) goto L105;
        boolean r231 = true;
    L106:
        if (r231 == true) goto L109;
        r222 = null;
    L109:
        if (r222 == null) goto L111;
        r141 = r141;
        r164 = r222.intValue();
        goto L125
    L105:
        r231 = false;
        goto L106
    L95:
        r221 = false;
        goto L96
    L81:
        r154 = null;
        goto L82
    L174:
        LinkedHashMap r232 = r148;
        ArrayList r233 = r147;
        ArrayList r187 = r146;
        int r317 = r130;
        ArrayList r188 = r142;
        r13.j = r187;
        if (r188.isEmpty() == false) goto L178;
        r13.f(r13.i);
        return;
    L178:
        AnimatorSet r189 = new AnimatorSet();
        r189.playTogether(r188);
        r189.addListener(new n3(this, r232, r233, r187, r317));
        r189.start();
        r13.g = r189;
    }
}
