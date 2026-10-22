package com.ss.android.lark.feed.app.tablayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedTabIndicator extends d {
    public static final /* synthetic */ int I = 0;
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public float F;
    public int G;
    public int H;
    public final RefactoredFeedTabLayout n;
    public int o;
    public final int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public Drawable u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static final class a {
    }

    static {
    }

    public FeedTabIndicator(RefactoredFeedTabLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "tabLayout");
        this.n = r3;
        this.p = 4;
        this.s = true;
        this.t = 1;
        this.v = -2;
        this.C = -1;
        this.D = -1;
        this.E = true;
        setCallback(r3);
        this.G = -1;
        this.H = -1;
    }

    public final int d(int r3) {
        int r0 = this.y;
        if (r0 != (-2)) goto L5;
        View r4 = (View) CollectionsKt.getOrNull(this.n.getFeedSelector().c, r3);
        if (r4 == null) goto L18;
        View r1 = f(r4);
        if (r1 == null) goto L15;
        int r5 = c.a(r1);
    L16:
        r0 = r5;
        goto L18
    L15:
        r5 = c.a(r4);
    L18:
        return r0 + this.z;
    L5:
        if (r0 != (-1)) goto L18;
        View r6 = (View) CollectionsKt.getOrNull(this.n.getFeedSelector().c, r3);
        if (r6 == null) goto L18;
        r0 = r6.getMeasuredHeight();
        goto L18
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r22) {
        Intrinsics.checkNotNullParameter(r22, "canvas");
        if (isVisible() == true) goto L5;
        return;
    L5:
        if ((this.o & (-4097)) != 0) goto L7;
        return;
    L7:
        if (this.u == null) goto L122;
        Intrinsics.checkNotNullParameter(r22, "canvas");
        int r11 = ((ArrayList) this.n.getFeedSelector().c).size();
        int r0 = this.G;
        int r1 = this.H;
        if (r1 < 0) goto L13;
        if (r1 >= r11) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L16;
        r0 = Math.max(0, r0);
    L16:
        if (r0 < 0) goto L19;
        if (r0 >= r11) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L123;
        int r4 = c(r0, 4);
        int r5 = e(r0);
        int r14 = d(r0);
        int r6 = (r4 - (r5 / 2)) + this.A;
        int r7 = c(this.H, 4);
        int r15 = e(this.H);
        int r16 = (r7 - (r15 / 2)) + this.A;
        int r8 = this.H;
        if (r8 < 0) goto L26;
        if (r8 >= r11) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L58;
        if (r8 == r0) goto L58;
        int r10 = d(r8);
        if (this.r == false) goto L33;
        float r12 = this.F;
        int r13 = (int) (r5 * (1 - r12));
        int r17 = (int) (r15 * r12);
        int r18 = (r4 - (r13 / 2)) + this.A;
        int r19 = r10;
        int r110 = r11;
    L57:
        int r111 = (int) ((r19 - r14) * this.F);
        int r20 = r13;
        int r112 = r17;
        int r21 = r18;
    L59:
        int r23 = this.o & (-4097);
        if (r23 != 1) goto L62;
        boolean r113 = false;
        int r114 = this.B + 0;
    L96:
        Drawable r24 = this.u;
        if (r24 != null) goto L99;
        return;
    L99:
        if (this.r == true) goto L101;
        a(r24, r22, r21, r114, r21 + r20, (r14 + r114) + r111, 1 - this.F);
        return;
    L101:
        if (this.s == false) goto L103;
        Drawable r115 = r24;
        b(r24, r22, r6, r114, r6 + r5, (r114 + r14) + r111, r20, 1 - this.F);
    L104:
        int r25 = this.H;
        if (r25 >= 0) goto L107;
    L109:
        if (r113 == true) goto L111;
        return;
    L111:
        if (this.s == false) goto L113;
        b(r115, r22, r16, r114, r16 + r15, (r14 + r114) + r111, r112, this.F);
        return;
    L113:
        a(r115, r22, r16, r114, r16 + r112, (r14 + r114) + r111, this.F);
        return;
    L107:
        if (r25 >= r110) goto L109;
        r113 = true;
        goto L109
    L103:
        r115 = r24;
        a(r115, r22, r21, r114, r21 + r20, (r114 + r14) + r111, 1 - this.F);
        goto L104
    L62:
        if (r23 == 2) goto L89;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r26 = b.a(this);
        if (r26 == null) goto L66;
        int r27 = r26.getPaddingTop();
    L67:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r28 = b.a(this);
        if (r28 == null) goto L70;
        int r29 = r28.getMeasuredHeight();
    L71:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r116 = b.a(this);
        if (r116 == null) goto L74;
        int r117 = r116.getPaddingTop();
    L75:
        int r30 = r29 - r117;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r31 = b.a(this);
        if (r31 == null) goto L78;
        int r32 = r31.getPaddingBottom();
    L79:
        int r33 = (((r27 + ((r30 - r32) / 2)) - (r14 / 2)) + this.B) - r111;
        int r34 = this.n.get_maxConvexHeight();
        if ((b.a(this) instanceof ViewGroup) == false) goto L87;
        View r35 = b.a(this);
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup.LayoutParams r36 = ((ViewGroup) r35).getChildAt(r0).getLayoutParams();
        if ((r36 instanceof RefactoredFeedTabLayout.LayoutParams) == false) goto L84;
        RefactoredFeedTabLayout.LayoutParams r37 = (RefactoredFeedTabLayout.LayoutParams) r36;
    L85:
        if (r37 == null) goto L87;
        int r38 = r37.a;
    L88:
        int r39 = r33 + ((r34 - r38) / 2);
    L94:
        r114 = r39;
        r113 = false;
        goto L96
    L84:
        r37 = null;
    L87:
        r38 = 0;
        goto L88
    L78:
        r32 = 0;
        goto L79
    L74:
        r117 = 0;
        goto L75
    L70:
        r29 = 0;
        goto L71
    L66:
        r27 = 0;
        goto L67
    L89:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r40 = b.a(this);
        if (r40 == null) goto L92;
        int r41 = r40.getMeasuredHeight();
    L93:
        r39 = (r41 - r14) - this.B;
        goto L94
    L92:
        r41 = 0;
        goto L93
    L33:
        if (this.q == true) goto L35;
    L52:
        r19 = r10;
        r110 = r11;
        if (this.H <= r0) goto L55;
        float r42 = r6 + ((r16 - r6) * this.F);
    L56:
        r18 = (int) r42;
        r13 = (int) (r5 + ((r15 - r5) * this.F));
        r17 = r15;
        goto L57
    L55:
        r42 = r6 - ((r6 - r16) * this.F);
        goto L56
    L35:
        if (Math.abs(this.H - r0) > this.t) goto L52;
        if (this.H <= r0) goto L42;
        int r43 = r16 - r6;
        int r44 = r43 + r15;
        double r118 = this.F;
        if (r118 < 0.5d) goto L41;
        r110 = r11;
        r19 = r10;
        int r45 = (int) (((double) r6) + ((((double) r43) * (r118 - 0.5d)) / ((double) 0.5f)));
    L46:
        int r46 = r45;
    L47:
        float r47 = this.F;
        double r119 = r47;
        if (r119 < 0.5d) goto L50;
        int r48 = (int) (((double) r44) - ((((double) (r44 - r15)) * (r119 - 0.5d)) / ((double) 0.5f)));
    L51:
        r13 = r48;
        r17 = r15;
        r18 = r46;
        goto L57
    L50:
        r48 = (int) (r5 + (((r44 - r5) * r47) / 0.5f));
        goto L51
    L41:
        r19 = r10;
        r110 = r11;
        r46 = r6;
        goto L47
    L42:
        r19 = r10;
        r110 = r11;
        int r49 = r6 - r16;
        r44 = r49 + r5;
        float r50 = this.F;
        if (r50 < 0.5d) goto L45;
        r46 = r16;
        goto L47
    L45:
        r45 = (int) (r6 - ((r49 * r50) / 0.5f));
    L58:
        r110 = r11;
        r20 = r5;
        r21 = r6;
        r112 = r15;
        r111 = 0;
    L26:
        r9 = false;
        goto L27
    L123:
        return;
    L19:
        r3 = false;
    L13:
        r2 = false;
        goto L14
    }

    public final int e(int r3) {
        int r0 = this.w;
        if (r0 != (-2)) goto L5;
        View r4 = (View) CollectionsKt.getOrNull(this.n.getFeedSelector().c, r3);
        if (r4 == null) goto L18;
        View r1 = f(r4);
        if (r1 == null) goto L15;
        int r5 = c.b(r1);
    L16:
        r0 = r5;
        goto L18
    L15:
        r5 = c.b(r4);
    L18:
        return r0 + this.x;
    L5:
        if (r0 != (-1)) goto L18;
        View r6 = (View) CollectionsKt.getOrNull(this.n.getFeedSelector().c, r3);
        if (r6 == null) goto L18;
        r0 = r6.getMeasuredWidth();
        goto L18
    }

    public final View f(View r4) {
        Intrinsics.checkNotNullParameter(r4, "childView");
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.feed.app.tablayout.RefactoredFeedTabLayout.LayoutParams");
        RefactoredFeedTabLayout.LayoutParams r1 = (RefactoredFeedTabLayout.LayoutParams) r0;
        int r2 = r1.c;
        if (r2 != (-1)) goto L6;
        r2 = this.D;
    L6:
        if (r2 != (-1)) goto L8;
        int r3 = r1.b;
        if (r3 >= 0) goto L13;
        r3 = this.C;
    L13:
        if (r3 >= 0) goto L15;
    L23:
        return null;
    L15:
        if ((r4 instanceof ViewGroup) == false) goto L23;
        if (r3 >= 0) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == false) goto L23;
        return ((ViewGroup) r4).getChildAt(r3);
    L18:
        if (r3 >= ((ViewGroup) r4).getChildCount()) goto L20;
        r5 = true;
        goto L21
    L8:
        return r4.findViewById(r2);
    }

    public final void h(Drawable r3) {
        int r0 = this.v;
        if (r3 != null) goto L5;
    L8:
        this.u = r3;
        return;
    L5:
        if (r0 == (-2)) goto L8;
        r3 = DrawableCompat.wrap(r3).mutate();
        DrawableCompat.setTint(r3, r0);
        goto L8
    }

    public final int c(int r3, final int r4) {
        final Ref.IntRef r0 = new Ref.IntRef();
        if (r3 <= 0) goto L5;
        int r1 = this.n.getMaxWidth();
    L6:
        r0.element = r1;
        Function2<View, View, Unit> r2 = new FeedTabIndicator$getChildTargetX$1(r0, r4);
        Intrinsics.checkNotNullParameter(r2, "onChildView");
        View r5 = (View) CollectionsKt.getOrNull(this.n.getFeedSelector().c, r3);
        if (r5 == null) goto L10;
        r2.invoke(r5, f(r5));
    L10:
        return r0.element;
    L5:
        r1 = 0;
        goto L6
    }

    public final void g(Context r14, AttributeSet r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        TypedArray r16 = r14.obtainStyledAttributes(r15, new int[]{2130970478, 2130970479, 2130974387, 2130974391, 2130974395, 2130974396, 2130974397, 2130974398, 2130974404, 2130974405, 2130974406, 2130974407, 2130974408, 2130974409, 2130974410, 2130974411, 2130974412, 2130974413, 2130974414, 2130974415, 2130974416, 2130974417, 2130974419, 2130974420, 2130974421, 2130974422, 2130974423, 2130974424, 2130974425, 2130974426, 2130974428, 2130974429, 2130974430, 2130974431, 2130974432, 2130974439, 2130974441, 2130974456});
        h(r16.getDrawable(14));
        this.v = r16.getColor(9, this.v);
        h(this.u);
        int r2 = r16.getInt(29, 2);
        this.o = r2;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 <= 0) goto L8;
        if ((r2 & 9) != 9) goto L8;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        this.w = r16.getLayoutDimension(1, -1);
        this.y = r16.getLayoutDimension(0, -1);
        this.A = r16.getDimensionPixelOffset(31, this.A);
        this.B = r16.getDimensionPixelOffset(32, this.B);
    L13:
        this.t = r16.getInt(18, this.t);
        this.q = r16.getBoolean(17, this.q);
        this.r = r16.getBoolean(15, this.r);
        this.s = r16.getBoolean(16, this.s);
        this.x = r16.getDimensionPixelOffset(30, this.x);
        this.z = r16.getDimensionPixelOffset(22, this.z);
        this.C = r16.getInt(11, this.C);
        this.D = r16.getResourceId(10, this.D);
        this.E = r16.getBoolean(8, this.E);
        this.a = r16.getInt(25, this.a);
        this.b = r16.getColor(26, this.b);
        this.c = r16.getColor(27, this.c);
        this.d = r16.getDimensionPixelOffset(28, this.d);
        this.e = r16.getDimensionPixelOffset(13, (int) this.e);
        this.f = r16.getDimensionPixelOffset(12, (int) this.f);
        int r5 = r16.getDimensionPixelOffset(24, 0);
        if (r5 <= 0) goto L16;
        Arrays.fill(this.g, r5);
    L31:
        String r7 = r16.getString(19);
        if (r7 != null) goto L34;
    L37:
        boolean r4 = true;
    L39:
        if (r4 == false) goto L44;
        int r6 = r16.getColor(21, 0);
        int r8 = r16.getColor(20, 0);
        if (r6 == r8) goto L43;
        int[] r1 = {r6, r8};
    L62:
        this.h = r1;
        r16.recycle();
        if (this.u == null) goto L65;
        return;
    L65:
        if (this.b == 0) goto L67;
    L72:
        if (r3 == false) goto L98;
        Drawable r17 = this.m;
        if (r17 != null) goto L77;
        GradientDrawable r18 = new GradientDrawable();
    L80:
        if (r18 == null) goto L91;
        r18.setBounds(getBounds());
        r18.setShape(this.a);
        r18.setStroke(this.d, this.c, this.e, this.f);
        r18.setColor(this.b);
        r18.setCornerRadii(this.g);
        if (this.h == null) goto L90;
        int r9 = Build.VERSION.SDK_INT;
        if (r9 < 24) goto L86;
        r18.setGradientCenter(this.i, this.j);
    L86:
        r18.setGradientRadius(this.k);
        r18.setGradientType(0);
        r18.setOrientation(this.l);
        if (r9 < 29) goto L89;
        r18.setColors(this.h, null);
        goto L90
    L89:
        r18.setColors(this.h);
    L90:
        this.m = r18;
        r18.invalidateSelf();
    L91:
        h(this.m);
        return;
    L77:
        if ((r17 instanceof GradientDrawable) == false) goto L79;
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        r18 = (GradientDrawable) r17;
        goto L80
    L79:
        r18 = null;
        goto L80
    L98:
        return;
    L67:
        if (this.c != 0) goto L72;
        if (this.h != null) goto L72;
        r3 = false;
        goto L72
    L43:
        r1 = this.h;
        goto L62
    L44:
        if (r7 != null) goto L46;
    L49:
        boolean r10 = true;
    L50:
        if (r10 == false) goto L52;
        r1 = null;
    L60:
        if (r1 != null) goto L62;
        r1 = this.h;
        goto L62
    L52:
        List r11 = StringsKt.split$default(r7, new String[]{","}, false, 0, 6, null);
        int r12 = r11.size();
        int[] r13 = new int[r12];
        int r19 = 0;
    L53:
        if (r19 >= r12) goto L59;
        String r20 = (String) ListProtector.get(r11, r19);
        if (StringsKt.startsWith$default(r20, "#", false, 2, null) == false) goto L57;
        int r21 = ColorProtector.parseColor(r20);
    L58:
        r13[r19] = r21;
        r19 = r19 + 1;
        goto L53
    L57:
        r21 = CastIntegerProtector.parseInt(r20);
        goto L58
    L59:
        r1 = r13;
        goto L60
    L46:
        if (r7.length() == 0) goto L49;
        r10 = false;
        goto L50
    L34:
        if (r7.length() == 0) goto L37;
        r4 = false;
        goto L39
    L16:
        String r22 = r16.getString(23);
        if (r22 == null) goto L31;
        float[] r23 = this.g;
        Intrinsics.checkNotNullParameter(r23, "array");
        if (r22.length() != 0) goto L21;
        boolean r24 = true;
    L22:
        if (r24 == true) goto L31;
        List r25 = StringsKt.split$default(r22, new String[]{","}, false, 0, 6, null);
        if (r25.size() != 8) goto L30;
        int r26 = com.larksuite.framework.utils.autoscale.a.a;
        Resources r27 = Resources.getSystem();
        float r28 = WindowDisplayMetricsOverride.apply(r27, r27.getDisplayMetrics()).density;
        int r29 = r25.size();
        int r30 = 0;
    L27:
        if (r30 >= r29) goto L31;
        r23[r30] = CastFloatProtector.parseFloat((String) ListProtector.get(r25, r30)) * r28;
        r30 = r30 + 1;
        goto L27
    L30:
        throw new IllegalArgumentException("radii need 8 values.");
    L21:
        r24 = false;
        goto L22
    L12:
        this.w = r16.getLayoutDimension(1, -1);
        int r31 = com.larksuite.framework.utils.autoscale.a.a;
        Resources r32 = Resources.getSystem();
        this.y = r16.getLayoutDimension(0, ((int) WindowDisplayMetricsOverride.apply(r32, r32.getDisplayMetrics()).density) * 3);
        this.A = r16.getDimensionPixelOffset(31, 0);
        Resources r33 = Resources.getSystem();
        this.B = r16.getDimensionPixelOffset(32, ((int) WindowDisplayMetricsOverride.apply(r33, r33.getDisplayMetrics()).density) * 2);
    L8:
        r0 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Drawable r1, Canvas r2, int r3, int r4, int r5, int r6, float r7) {
        Intrinsics.checkNotNullParameter(r1, "indicator");
        Intrinsics.checkNotNullParameter(r2, "canvas");
        r1.setBounds(r3, r4, r5, r6);
        if ((r1 instanceof g) == false) goto L5;
        ((g) r1).a();
        return;
    L5:
        r1.draw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Drawable r1, Canvas r2, int r3, int r4, int r5, int r6, int r7, float r8) {
        Intrinsics.checkNotNullParameter(r1, "indicator");
        Intrinsics.checkNotNullParameter(r2, "canvas");
        r2.save();
        int r9 = ((r5 - r3) - r7) / 2;
        r2.clipRect(r3 + r9, r4, r5 - r9, r6);
        r1.setBounds(r3, r4, r5, r6);
        if ((r1 instanceof g) == false) goto L5;
        ((g) r1).a();
    L6:
        r2.restore();
        return;
    L5:
        r1.draw(r2);
        goto L6
    }
}
