package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f6457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.oui.dialog.alert.view.a f6459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OAlertDialogBuilder.a f6460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f6461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f6462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @DrawableRes
    private int f6464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f6465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f6466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f6467k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.dialog.alert.b$b, reason: collision with other inner class name */
    public static final class C0128b extends FrameLayout {
        public C0128b(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            super(r10);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int r10, int r11) {
            super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r10) / 2, 1073741824));
        }
    }

    static {
        new a(null);
    }

    public b(Context r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f6466j = r10;
        this.f6467k = r11;
    }

    private final void c(Context r10, FrameLayout r11) {
        Integer r12 = this.f6462f;
        if (r12 == null) goto L5;
        Intrinsics.checkNotNull(r12);
        int r13 = r12.intValue();
    L6:
        Integer r14 = this.f6461e;
        if (r14 == null) goto L9;
        Intrinsics.checkNotNull(r14);
        int r15 = r14.intValue();
    L10:
        ViewGroup.LayoutParams r16 = new FrameLayout.LayoutParams(r13, r15);
        if (this.f6463g == false) goto L13;
        FrameLayout r17 = new FrameLayout(r10);
    L14:
        r17.addView(e(), new FrameLayout.LayoutParams(-1, -1));
        r11.addView(r17, r16);
        return;
    L13:
        r17 = new C0128b(r10);
        goto L14
    L9:
        r15 = -2;
        goto L10
    L5:
        r13 = -1;
        goto L6
    }

    private final void d(Context r10, FrameLayout r11) {
        Integer r12 = this.f6462f;
        int r13 = -2;
        if (r12 == null) goto L5;
        Intrinsics.checkNotNull(r12);
        int r14 = r12.intValue();
    L6:
        Integer r15 = this.f6461e;
        if (r15 == null) goto L9;
        Intrinsics.checkNotNull(r15);
        r13 = r15.intValue();
    L9:
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(r14, r13);
        r16.gravity = 1;
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        r16.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 28, r17.getDisplayMetrics()));
        r11.addView(e(), r16);
        return;
    L5:
        r14 = -2;
        goto L6
    }

    private final View e() {
        View r10 = this.f6465i;
        if (r10 == null) goto L5;
        return r10;
    L5:
        ImageView r11 = new ImageView(this.f6466j);
        r11.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r12 = this.f6457a;
        int r13 = this.f6464h;
        String r14 = this.f6458b;
        OAlertDialogBuilder.a r15 = this.f6460d;
        if (r15 == null) goto L9;
        if (r15 == null) goto L23;
        r15.a(r11);
    L23:
        return r11;
    L9:
        if (r12 == null) goto L11;
        r11.setImageDrawable(r12);
        goto L23
    L11:
        if (r13 == 0) goto L13;
        r11.setImageResource(r13);
        goto L23
    L13:
        if (r14 != null) goto L15;
    L18:
        boolean r16 = true;
    L19:
        if (r16 == true) goto L23;
        com.obric.oui.dialog.alert.view.a r17 = this.f6459c;
        if (r17 == null) goto L23;
        r17.a(r11, r14);
        goto L23
    L15:
        if (r14.length() == 0) goto L18;
        r16 = false;
        goto L19
    }

    @Override // com.obric.oui.dialog.alert.c
    public void a(Context r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "parent");
        if (this.f6467k != 0) goto L5;
        d(r10, r11);
        return;
    L5:
        c(r10, r11);
    }

    @Override // com.obric.oui.dialog.alert.c
    public void b(OAlertDialog r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
    }

    public final void f(Drawable r10) {
        Intrinsics.checkNotNullParameter(r10, "drawable");
        this.f6457a = r10;
    }

    public final void g(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        this.f6458b = r10;
    }

    public final void h(com.obric.oui.dialog.alert.view.a r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.f6459c = r10;
    }

    public final void i(Integer r10, Integer r11) {
        this.f6462f = r10;
        this.f6461e = r11;
        this.f6463g = true;
    }

    public final void j(OAlertDialogBuilder.a r10) {
        Intrinsics.checkNotNullParameter(r10, "loader");
        this.f6460d = r10;
    }
}
