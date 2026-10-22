package com.larus.dora.obric.device_management.device_bind;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.larus.dora.impl.resource.DoraDrawableDensity;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.j0;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButton;
import com.obric.oui.image.OImage;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public final Context a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;
    public final Function1<String, Unit> d;
    public OImage e;
    public OTextView f;
    public OTextView g;
    public OTextView h;
    public OButton i;
    public OButton j;
    public OUILinearLayout k;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final int c;
        public final String d;
        public final String e;
        public final boolean f;
        public final String g;
        public final String h;
        public final boolean i;
        public final boolean j;
        public final int k;
        public final int l;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
            String r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.e.hashCode()) * 31;
            int r5 = 1231;
            if (this.f == false) goto L9;
            int r6 = 1231;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.g;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.h;
            if (r11 == null) goto L18;
            r2 = r11.hashCode();
        L18:
            int r12 = (r10 + r2) * 31;
            if (this.i == false) goto L21;
            int r13 = 1231;
        L22:
            int r14 = (r12 + r13) * 31;
            if (this.j == true) goto L27;
            r5 = 1237;
        L27:
            return ((((r14 + r5) * 31) + this.k) * 31) + this.l;
        L21:
            r13 = 1237;
            goto L22
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = 1237;
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Content(title=" + this.a + ", desc=" + this.b + ", imageResId=" + this.c + ", imageResourceName=" + this.d + ", primaryText=" + this.e + ", primaryEnabled=" + this.f + ", buyText=" + this.g + ", buyUrl=" + this.h + ", showBuy=" + this.i + ", reserveBuySpace=" + this.j + ", bottomMarginAttrResId=" + this.k + ", bottomMarginResId=" + this.l + ')';
        }

        public b(String r3, String r4, int r5, String r6, String r7, boolean r8, String r9, String r10, boolean r11, int r12) {
            if ((r12 & 8) == 0) goto L6;
            r6 = null;
        L6:
            if ((r12 & 64) == 0) goto L9;
            r9 = null;
        L9:
            if ((r12 & 128) == 0) goto L11;
            r10 = null;
        L11:
            boolean r0 = false;
            if ((r12 & 256) == 0) goto L15;
            if (r10 == null) goto L15;
            r0 = true;
        L15:
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r4, "desc");
            Intrinsics.checkNotNullParameter(r7, "primaryText");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r0;
            this.j = r11;
            this.k = 2130971546;
            this.l = 2131167462;
        }
    }

    static {
    }

    public final ConstraintLayout b() {
        OFloatingTitleBar r1 = new OFloatingTitleBar(this.a, null, 6, 0);
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        r1.setBackgroundColor(v19.c.a(2130970531, this.a, 2131102535));
        r1.R(false);
        View r2 = OFloatingTitleBar.k(r1, null, 6);
        r2.setOnClickListener(new e(this));
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        r1.post(new com.larus.dora.obric.utils.b(r1, r2));
        r1.setId(View.generateViewId());
        OUILinearLayout r3 = new OUILinearLayout(this.a, null, 0, 14);
        r3.setOrientation(1);
        r3.setGravity(1);
        OUILinearLayout r9 = new OUILinearLayout(this.a, null, 0, 14);
        r9.setOrientation(1);
        r9.setGravity(1);
        r9.setPadding(c(2130971390, 2131167150), c(2130971299, 2131166968), c(2130971390, 2131167150), c(2130971299, 2131166968));
        OTextView r4 = new OTextView(this.a, null, 0, 14);
        r4.setGravity(17);
        r4.setIncludeFontPadding(false);
        r4.setTextColor(v19.c.a(2130972081, this.a, 2131103143));
        r4.setTextSize(2, 17.0f);
        TextViewCompat.setLineHeight(r4, f(24.0f));
        e(r4, 500);
        r4.setVisibility(8);
        this.h = r4;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-1, -2);
        r13.bottomMargin = c(2130971163, 2131166696);
        Unit r6 = Unit.INSTANCE;
        r9.addView(r4, r13);
        OTextView r5 = new OTextView(this.a, null, 0, 14);
        r5.setGravity(17);
        r5.setIncludeFontPadding(false);
        r5.setTextColor(ContextCompat.getColor(this.a, 2131104350));
        r5.setTextSize(2, 24.0f);
        TextViewCompat.setLineHeight(r5, f(31.0f));
        e(r5, 600);
        this.f = r5;
        r9.addView(r5, new LinearLayout.LayoutParams(-1, -2));
        OTextView r7 = new OTextView(this.a, null, 0, 14);
        r7.setGravity(17);
        r7.setIncludeFontPadding(false);
        r7.setTextColor(ContextCompat.getColor(this.a, 2131104359));
        r7.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r7, f(20.0f));
        e(r7, 400);
        this.g = r7;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-1, -2);
        r8.topMargin = c(2130971480, 2131167331);
        r9.addView(r7, r8);
        r3.addView(r9, new LinearLayout.LayoutParams(-1, -2));
        OButton r10 = (OButton) vma.e.a(this.a, 2131952832, new com.larus.dora.obric.device_management.device_bind.a());
        a(r10);
        r10.setVisibility(4);
        r10.setEnabled(false);
        e1.d(r10, new com.larus.dora.obric.device_management.device_bind.b(this));
        this.i = r10;
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-1, -2);
        r11.setMarginStart(c(2130971255, 2131166880));
        r11.setMarginEnd(c(2130971255, 2131166880));
        r11.topMargin = c(2130971208, 2131166786);
        r11.bottomMargin = c(2130971208, 2131166786);
        r3.addView(r10, r11);
        final OButton r12 = (OButton) vma.e.a(this.a, 2131952831, new c());
        a(r12);
        r12.setVisibility(4);
        r12.setEnabled(false);
        e1.d(r12, new d(r12, this));
        this.j = r12;
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-1, -2);
        r14.setMarginStart(c(2130971255, 2131166880));
        r14.setMarginEnd(c(2130971255, 2131166880));
        r14.bottomMargin = c(2130971546, 2131167462);
        r3.addView(r12, r14);
        this.k = r3;
        r3.setId(View.generateViewId());
        OImage r15 = LayoutInflater.from(this.a).inflate(2131562232, null, false);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.obric.oui.image.OImage");
        OImage r16 = r15;
        this.e = r16;
        r16.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r16.setBackgroundColor(0);
        r16.setId(View.generateViewId());
        ConstraintLayout r17 = new ConstraintLayout(this.a);
        r17.setBackgroundColor(v19.c.a(2130970531, this.a, 2131102535));
        ConstraintLayout.LayoutParams r18 = new ConstraintLayout.LayoutParams(0, -2);
        r18.startToStart = 0;
        r18.endToEnd = 0;
        r18.topToTop = 0;
        i0.a.getClass();
        ((ViewGroup.MarginLayoutParams) r18).topMargin = i0.g();
        r17.addView(r1, r18);
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(0, -2);
        r20.startToStart = 0;
        r20.endToEnd = 0;
        r20.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r20).bottomMargin = c(2130971481, 2131167332);
        r17.addView(r3, r20);
        ViewGroup.LayoutParams r21 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r21).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r21).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r21).topToBottom = r1.getId();
        ((ConstraintLayout.LayoutParams) r21).bottomToTop = r3.getId();
        r17.addView(r16, r21);
        return r17;
    }

    public final void a(OButton r3) {
        r3.setGravity(17);
        r3.setMinHeight(c(2130971497, 2131167363));
        r3.setAllCaps(false);
        r3.setIncludeFontPadding(false);
        r3.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r3, f(24.0f));
        e(r3, 500);
    }

    public final void d(b r9) {
        Intrinsics.checkNotNullParameter(r9, "content");
        OImage r0 = this.e;
        ConstraintLayout.LayoutParams r1 = null;
        if (r0 == null) goto L14;
        String r5 = r9.d;
        if (r5 == null) goto L7;
        Drawable r2 = j0.f(j0.a, r0.getContext(), DoraResourceDeviceType.G2, r5, DoraDrawableDensity.XXHDPI, 8);
    L8:
        if (r2 == null) goto L10;
        r0.setImageDrawable(r2);
        goto L14
    L10:
        int r3 = r9.c;
        if (r3 == 0) goto L13;
        r0.setImageResource(r3);
        goto L14
    L13:
        r0.setImageDrawable(null);
        goto L14
    L7:
        r2 = null;
    L14:
        OTextView r4 = this.f;
        if (r4 == null) goto L17;
        r4.setText(r9.a);
    L17:
        OTextView r6 = this.g;
        if (r6 == null) goto L20;
        r6.setText(r9.b);
    L20:
        g(r9.e, r9.f);
        String r7 = r9.g;
        String r8 = r9.h;
        boolean r10 = r9.i;
        boolean r11 = r9.j;
        OButton r12 = this.j;
        if (r12 == null) goto L31;
        if (r7 != null) goto L24;
        r7 = "";
    L24:
        r12.setText(r7);
        r12.setTag(r8);
        if (r10 == false) goto L27;
        int r13 = 0;
    L30:
        r12.setVisibility(r13);
        r12.setEnabled(r10);
        goto L31
    L27:
        if (r11 == false) goto L29;
        r13 = 4;
        goto L30
    L29:
        r13 = 8;
    L31:
        int r14 = r9.k;
        int r15 = r9.l;
        OUILinearLayout r16 = this.k;
        if (r16 == null) goto L34;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
    L36:
        if ((r17 instanceof ConstraintLayout.LayoutParams) == false) goto L38;
        r1 = (ConstraintLayout.LayoutParams) r17;
    L38:
        if (r1 == null) goto L43;
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = c(r14, r15);
        OUILinearLayout r18 = this.k;
        if (r18 == null) goto L44;
        r18.setLayoutParams(r1);
        return;
    L44:
        return;
    L43:
        return;
    L34:
        r17 = null;
        goto L36
    }

    public final int f(float r3) {
        Resources r0 = this.a.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).scaledDensity) + 0.5f);
    }

    public static void e(TextView r4, int r5) {
        Typeface r0 = Typeface.create("sans-serif", 0);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r0 = Typeface.create(r0, r5, false);
    L5:
        r4.setTypeface(r0);
    }

    public final int c(int r3, int r4) {
        return this.a.getResources().getDimensionPixelSize(v19.c.b(r3, this.a, r4));
    }

    public final void g(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "text");
        OButton r0 = this.i;
        if (r0 == null) goto L26;
        r0.setText(r5);
        boolean r2 = true;
        if (r5.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        int r3 = 4;
    L11:
        r0.setVisibility(r3);
        if (r6 == true) goto L14;
    L19:
        r2 = false;
    L20:
        r0.setEnabled(r2);
        if (r0.isEnabled() == false) goto L23;
        float r7 = 1.0f;
    L24:
        r0.setAlpha(r7);
        return;
    L23:
        r7 = 0.56f;
        goto L24
    L14:
        if (r5.length() <= 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
    L16:
        r8 = false;
        goto L17
    L10:
        r3 = 0;
        goto L11
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Context r2, Function0<Unit> r3, Function0<Unit> r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onBackClick");
        Intrinsics.checkNotNullParameter(r4, "onPrimaryClick");
        Intrinsics.checkNotNullParameter(r5, "onBuyClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
