package com.obric.oui.sheet.v2;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RadiusLayout f14511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f14512c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final ViewGroup f;
    public final View g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OSheet$HeightMode f14515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f14517l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OSheetTitleBar f14518m;

    public m(Context r5, e r10, RadiusLayout r11, FrameLayout r12, FrameLayout r13, FrameLayout r14, ViewGroup r15, View r16) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "sheet");
        Intrinsics.checkNotNullParameter(r11, "rootContainer");
        Intrinsics.checkNotNullParameter(r12, "headerContainer");
        Intrinsics.checkNotNullParameter(r13, "bodyContainer");
        Intrinsics.checkNotNullParameter(r14, "footerContainer");
        Intrinsics.checkNotNullParameter(r15, "scaffoldContainer");
        Intrinsics.checkNotNullParameter(r16, "dimView");
        this.f14510a = r5;
        this.f14511b = r11;
        this.f14512c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.f14515j = OSheet$HeightMode.WRAP_HEIGHT;
        this.f14517l = r11.getPaddingBottom();
    }

    public static void c(View r5, FrameLayout r10) {
        if (r5 == null) goto L12;
        if (r10 == null) goto L6;
        com.lynx.tasm.utils.d.t(r10);
    L6:
        if (r10 == null) goto L9;
        r10.removeAllViews();
    L9:
        if (r10 == null) goto L20;
        r10.addView(r5);
        return;
    L20:
        return;
    L12:
        if (r10 == null) goto L15;
        r10.removeAllViews();
    L15:
        if (r10 == null) goto L21;
        com.lynx.tasm.utils.d.s(r10);
        return;
    }

    public final void a() {
        int r5 = (this.f14513h - this.f14512c.getHeight()) - this.e.getHeight();
        RadiusLayout r10 = this.f14511b;
        this.f14514i = (r5 - r10.getPaddingTop()) - r10.getPaddingBottom();
    }

    public final void b(Size r5) {
        Intrinsics.checkNotNullParameter(r5, "fullWindowSize");
        d(r5);
        f();
        RadiusLayout r10 = this.f14511b;
        Intrinsics.checkNotNullParameter(r10, "container");
        int r11 = com.lynx.tasm.utils.a.B(10, r10);
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13.topMargin >= r11) goto L7;
        r13.topMargin = r11;
    L7:
        r10.setLayoutParams(r12);
        a();
        r10.requestLayout();
    }

    public final void d(Size r5) {
        Intrinsics.checkNotNullParameter(r5, "fullWindowSize");
        if (r5.getWidth() <= r5.getHeight()) goto L5;
        this.f14513h = (int) (r5.getHeight() * 0.84f);
        return;
    L5:
        this.f14513h = (int) (r5.getHeight() * 0.93f);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void e() {
        int r5 = this.f14513h;
        RadiusLayout r10 = this.f14511b;
        r10.setMaxHeight(r5);
        int r11 = l.f14509a[this.f14515j.ordinal()];
        boolean r12 = false;
        ViewGroup r13 = this.f;
        FrameLayout r14 = this.d;
        if (r11 != 1) goto L5;
        int r15 = this.f14513h;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.getLayoutParams().height = r15;
        r10.requestLayout();
        if ((r13 instanceof LinearLayout) == false) goto L27;
        ViewGroup.LayoutParams r16 = r14.getLayoutParams();
        if (r16 == null) goto L26;
        LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r16;
        r17.weight = 1.0f;
        r17.height = 0;
        r14.setLayoutParams(r17);
    L30:
        r13.getLayoutParams().height = -1;
    L32:
        if (this.f14515j != OSheet$HeightMode.WRAP_HEIGHT) goto L34;
        r12 = true;
    L34:
        r10.setMeasureHeightUnspecified(r12);
        ViewGroup.LayoutParams r18 = r10.getLayoutParams();
        if (r18 == null) goto L39;
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r18;
        r19.gravity = 81;
        r10.setLayoutParams(r19);
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L27:
        ViewGroup.LayoutParams r20 = r14.getLayoutParams();
        if (r20 == null) goto L41;
        r20.height = -1;
        r14.setLayoutParams(r20);
        goto L30
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L5:
        if (r11 != 2) goto L32;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.getLayoutParams().height = -2;
        r10.requestLayout();
        if ((r13 instanceof LinearLayout) == false) goto L14;
        ViewGroup.LayoutParams r21 = r14.getLayoutParams();
        if (r21 == null) goto L13;
        LinearLayout.LayoutParams r22 = (LinearLayout.LayoutParams) r21;
        r22.weight = 0.0f;
        r22.height = -2;
        r14.setLayoutParams(r22);
    L17:
        r13.getLayoutParams().height = -2;
        goto L32
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L14:
        ViewGroup.LayoutParams r23 = r14.getLayoutParams();
        if (r23 == null) goto L19;
        r23.height = -2;
        r14.setLayoutParams(r23);
        goto L17
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void f() {
        Context r5 = this.f14510a;
        int r10 = r5.getResources().getDisplayMetrics().widthPixels;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r5.getResources().getConfiguration().orientation != 2) goto L9;
        r10 = RangesKt.coerceAtMost(r10, com.lynx.tasm.utils.a.p(480, r5));
    L9:
        RadiusLayout r11 = this.f14511b;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        r11.getLayoutParams().width = r10;
        r11.requestLayout();
        float r12 = com.lynx.tasm.utils.a.r(36, r5);
        r11.a(r12, r12, 0.0f, 0.0f);
        e();
        return;
    L7:
        e = move-exception;
        ps.a.b(e, "ResourceUtils", "isLandscape error");
        goto L9
    }
}
