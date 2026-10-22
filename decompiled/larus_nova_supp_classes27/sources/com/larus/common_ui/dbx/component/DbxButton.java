package com.larus.common_ui.dbx.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 M2\u00020\u0001:\u0004JKLMB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010,\u001a\u00020-2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0017\u0010.\u001a\u00020-2\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010%J\u0010\u00100\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000102J\u0017\u00103\u001a\u00020-2\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010%J\u0010\u00104\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000102J\b\u00105\u001a\u00020-H\u0002J\b\u00106\u001a\u00020-H\u0002J\b\u00107\u001a\u00020-H\u0002J0\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H\u0014J\b\u0010>\u001a\u00020-H\u0002J\b\u0010?\u001a\u00020-H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020'H\u0016J\u0010\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020'H\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0012\u0010F\u001a\u00020\u00072\b\b\u0001\u0010G\u001a\u00020\u0007H\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR,\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010(\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020'@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006N"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "style", "Lcom/larus/common_ui/dbx/component/DbxButton$Style;", "size", "Lcom/larus/common_ui/dbx/component/DbxButton$Size;", "contentRow", "Landroid/widget/LinearLayout;", "leadingIconView", "Landroid/widget/ImageView;", "labelView", "Landroid/widget/TextView;", "trailingIconView", "loadingRing", "Lcom/larus/common_ui/dbx/component/DbxLoadingRingView;", "value", "", "title", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "accessibleLabel", "getAccessibleLabel", "setAccessibleLabel", "contentColor", "getContentColor", "()Ljava/lang/Integer;", "setContentColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "", "isLoading", "()Z", "setLoading", "(Z)V", "configure", "", "setLeadingIcon", "resId", "setLeadingIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setTrailingIcon", "setTrailingIconDrawable", "rebuildForSize", "updateContentLayout", "updateAccessibility", "onLayout", "changed", "left", "top", "right", "bottom", "updateLoadingState", "applyStyle", "pressedColor", "setPressed", "pressed", "setEnabled", "enabled", "dp", "color", "attrId", "paletteFor", "Lcom/larus/common_ui/dbx/component/DbxButton$Palette;", "Style", "Size", "Palette", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DbxButton extends FrameLayout {
    public Style a;
    public Size b;
    public final LinearLayout c;
    public final ImageView d;
    public final TextView e;
    public final ImageView f;
    public final com.larus.common_ui.dbx.component.b g;
    public CharSequence h;
    public CharSequence i;
    public Integer j;
    public boolean k;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxButton$Size;", "", "heightDp", "", "cornerRadiusDp", "iconSideDp", "contentInsetDp", "fontSizeSp", "<init>", "(Ljava/lang/String;IIIIII)V", "getHeightDp", "()I", "getCornerRadiusDp", "getIconSideDp", "getContentInsetDp", "getFontSizeSp", "XL", "L", "MD", "S", "XS", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Size extends Enum<Size> {
        public static final Size L = null;
        public static final Size MD = null;
        public static final Size S = null;
        public static final Size XL = null;
        public static final Size XS = null;
        public static final /* synthetic */ Size[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int contentInsetDp;
        private final int cornerRadiusDp;
        private final int fontSizeSp;
        private final int heightDp;
        private final int iconSideDp;

        public static EnumEntries<Size> getEntries() {
            return b;
        }

        static {
            Size r8 = new Size("XL", 0, 56, 16, 24, 16, 17);
            XL = r8;
            Size r0 = new Size("L", 1, 44, 12, 22, 11, 16);
            L = r0;
            Size r1 = new Size("MD", 2, 36, 8, 20, 8, 14);
            MD = r1;
            Size r2 = new Size("S", 3, 32, 8, 16, 8, 13);
            S = r2;
            Size r3 = new Size("XS", 4, 28, 8, 14, 7, 12);
            XS = r3;
            Size[] r4 = {r8, r0, r1, r2, r3};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
        }

        public static Size[] values() {
            return (Size[]) a.clone();
        }

        public final int getContentInsetDp() {
            return this.contentInsetDp;
        }

        public final int getCornerRadiusDp() {
            return this.cornerRadiusDp;
        }

        public final int getFontSizeSp() {
            return this.fontSizeSp;
        }

        public final int getHeightDp() {
            return this.heightDp;
        }

        public final int getIconSideDp() {
            return this.iconSideDp;
        }

        public static Size valueOf(String r1) {
            return (Size) r27.a.a(Size.class, r1);
        }

        public Size(String r1, int r2, int r3, int r4, int r5, int r6, int r7) {
            super(r1, r2);
            this.heightDp = r3;
            this.cornerRadiusDp = r4;
            this.iconSideDp = r5;
            this.contentInsetDp = r6;
            this.fontSizeSp = r7;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxButton$Style;", "", "<init>", "(Ljava/lang/String;I)V", "SOLID", "GRAY", "OUTLINE", "WHITE", "PLAIN", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style GRAY = null;
        public static final Style OUTLINE = null;
        public static final Style PLAIN = null;
        public static final Style SOLID = null;
        public static final Style WHITE = null;
        public static final /* synthetic */ Style[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Style> getEntries() {
            return b;
        }

        static {
            Style r0 = new Style("SOLID", 0);
            SOLID = r0;
            Style r1 = new Style("GRAY", 1);
            GRAY = r1;
            Style r3 = new Style("OUTLINE", 2);
            OUTLINE = r3;
            Style r5 = new Style("WHITE", 3);
            WHITE = r5;
            Style r7 = new Style("PLAIN", 4);
            PLAIN = r7;
            Style[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }

        public Style(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final Integer a;
        public final int b;
        public final Integer c;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.b) * 31;
            Integer r4 = this.c;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Palette(backgroundColorAttr=" + this.a + ", foregroundColorAttr=" + this.b + ", borderColorAttr=" + this.c + ')';
        }

        public b(Integer r1, int r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Style.values().length];
            r0[Style.SOLID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[Style.GRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[Style.WHITE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[Style.OUTLINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[Style.PLAIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public DbxButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DbxButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        Style r0 = this.a;
        int[] r1 = c.a;
        int r2 = r1[r0.ordinal()];
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L13;
        if (r2 == 3) goto L12;
        if (r2 == 4) goto L11;
        if (r2 != 5) goto L10;
        b r3 = new b(null, 2130971068, null);
    L16:
        if (isPressed() == true) goto L18;
    L22:
        boolean r8 = false;
    L23:
        GradientDrawable r10 = new GradientDrawable();
        r10.setCornerRadius(c(this.b.getCornerRadiusDp()));
        if (r8 == false) goto L39;
        int r4 = r1[this.a.ordinal()];
        if (r4 == 1) goto L37;
        if (r4 == 2) goto L36;
        if (r4 == 3) goto L35;
        if (r4 == 4) goto L34;
        if (r4 == 5) goto L34;
        throw new NoWhenBranchMatchedException();
    L34:
        int r5 = ColorUtils.setAlphaComponent(com.larus.common_ui.dbx.theme.a.b(getContext(), 2130971068), 20);
    L38:
        r10.setColor(r5);
    L43:
        Integer r6 = r3.c;
        if (r6 == null) goto L46;
        r10.setStroke(c(1), com.larus.common_ui.dbx.theme.a.b(getContext(), r6.intValue()));
    L46:
        setBackground(r10);
        Integer r7 = this.j;
        if (r7 == null) goto L49;
        int r9 = r7.intValue();
    L50:
        this.e.setTextColor(r9);
        this.d.setColorFilter(r9);
        this.f.setColorFilter(r9);
        this.g.setRingColor(r9);
        if (this.k == false) goto L54;
    L56:
        float r11 = 1.0f;
    L57:
        setAlpha(r11);
        return;
    L54:
        if (isEnabled() == true) goto L56;
        r11 = 0.3f;
        goto L57
    L49:
        r9 = com.larus.common_ui.dbx.theme.a.b(getContext(), r3.b);
        goto L50
    L35:
        r5 = -1315861;
        goto L38
    L36:
        r5 = -1842205;
        goto L38
    L37:
        r5 = -16752917;
        goto L38
    L39:
        Integer r12 = r3.a;
        if (r12 == null) goto L42;
        r10.setColor(com.larus.common_ui.dbx.theme.a.b(getContext(), r12.intValue()));
        goto L43
    L42:
        r10.setColor(0);
        goto L43
    L18:
        if (isEnabled() == false) goto L22;
        if (this.k == true) goto L22;
        r8 = true;
        goto L23
    L10:
        throw new NoWhenBranchMatchedException();
    L11:
        r3 = new b(null, 2130971068, 2130971032);
        goto L16
    L12:
        r3 = new b(2130971001, 2130971068, null);
        goto L16
    L13:
        r3 = new b(2130971009, 2130971068, null);
        goto L16
    L14:
        r3 = new b(2130971084, 2130971085, null);
        goto L16
    }

    public final void d() {
        CharSequence r0 = this.h;
        int r1 = 0;
        if (r0 != null) goto L5;
        boolean r2 = true;
    L6:
        this.e.setText(r0);
        TextView r3 = this.e;
        int r4 = 8;
        if (r2 == false) goto L9;
        int r5 = 8;
    L10:
        r3.setVisibility(r5);
        ImageView r6 = this.f;
        if (r2 == true) goto L14;
        r4 = r6.getVisibility();
    L14:
        r6.setVisibility(r4);
        ViewGroup.LayoutParams r7 = this.e.getLayoutParams();
        LinearLayout.LayoutParams r8 = null;
        if ((r7 instanceof LinearLayout.LayoutParams) == false) goto L17;
        LinearLayout.LayoutParams r9 = (LinearLayout.LayoutParams) r7;
    L19:
        if (r9 == null) goto L26;
        if (r2 == false) goto L22;
    L24:
        int r10 = 0;
    L25:
        r9.setMarginStart(r10);
        this.e.setLayoutParams(r9);
        goto L26
    L22:
        if (this.d.getVisibility() != 0) goto L24;
        r10 = c(4);
    L26:
        ViewGroup.LayoutParams r11 = this.f.getLayoutParams();
        if ((r11 instanceof LinearLayout.LayoutParams) == false) goto L29;
        r8 = (LinearLayout.LayoutParams) r11;
    L29:
        if (r8 == null) goto L35;
        if (r2 == false) goto L32;
    L34:
        r8.setMarginStart(r1);
        this.f.setLayoutParams(r8);
        goto L35
    L32:
        if (this.f.getVisibility() != 0) goto L34;
        r1 = c(4);
    L35:
        int r12 = c(this.b.getContentInsetDp());
        setPadding(r12, r12, r12, r12);
        CharSequence r13 = this.h;
        if (r13 != null) goto L38;
        r13 = this.i;
    L38:
        setContentDescription(r13);
        return;
    L17:
        r9 = null;
        goto L19
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public final CharSequence getAccessibleLabel() {
        return this.i;
    }

    public final Integer getContentColor() {
        return this.j;
    }

    public final CharSequence getTitle() {
        return this.h;
    }

    public final int c(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void setAccessibleLabel(CharSequence r2) {
        this.i = r2;
        CharSequence r0 = this.h;
        if (r0 == null) goto L6;
        r2 = r0;
    L6:
        setContentDescription(r2);
    }

    public final void setContentColor(Integer r1) {
        this.j = r1;
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        a();
    }

    public final void setLeadingIcon(Integer r4) {
        ImageView r0 = this.d;
        int r1 = 0;
        if (r4 == null) goto L5;
        int r2 = r4.intValue();
    L6:
        r0.setImageResource(r2);
        ImageView r3 = this.d;
        if (r4 != null) goto L9;
        r1 = 8;
    L9:
        r3.setVisibility(r1);
        d();
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void setLeadingIconDrawable(Drawable r2) {
        this.d.setImageDrawable(r2);
        ImageView r0 = this.d;
        if (r2 != null) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        d();
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void setLoading(boolean r4) {
        if (this.k != r4) goto L5;
        return;
    L5:
        this.k = r4;
        setEnabled(!r4);
        LinearLayout r5 = this.c;
        if (this.k == false) goto L8;
        int r1 = 4;
    L9:
        r5.setVisibility(r1);
        com.larus.common_ui.dbx.component.b r6 = this.g;
        if (this.k == false) goto L12;
        int r2 = 0;
    L13:
        r6.setVisibility(r2);
        if (this.k == false) goto L16;
        com.larus.common_ui.dbx.component.b r7 = this.g;
        r7.d = true;
        r7.a();
    L20:
        a();
        return;
    L16:
        com.larus.common_ui.dbx.component.b r8 = this.g;
        r8.d = false;
        ValueAnimator r0 = r8.c;
        if (r0 == null) goto L19;
        r0.cancel();
    L19:
        r8.c = null;
        goto L20
    L12:
        r2 = 8;
        goto L13
    L8:
        r1 = 0;
        goto L9
    }

    @Override // android.view.View
    public void setPressed(boolean r1) {
        super.setPressed(r1);
        a();
    }

    public final void setTitle(CharSequence r1) {
        this.h = r1;
        d();
        a();
    }

    public final void setTrailingIcon(Integer r4) {
        ImageView r0 = this.f;
        int r1 = 0;
        if (r4 == null) goto L5;
        int r2 = r4.intValue();
    L6:
        r0.setImageResource(r2);
        ImageView r3 = this.f;
        if (r4 != null) goto L9;
        r1 = 8;
    L9:
        r3.setVisibility(r1);
        d();
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void setTrailingIconDrawable(Drawable r2) {
        this.f.setImageDrawable(r2);
        ImageView r0 = this.f;
        if (r2 != null) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        d();
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void b(Style r3, Size r4) {
        Intrinsics.checkNotNullParameter(r3, "style");
        Intrinsics.checkNotNullParameter(r4, "size");
        this.a = r3;
        this.b = r4;
        setMinimumHeight(c(r4.getHeightDp()));
        int r5 = c(this.b.getIconSideDp());
        this.d.setLayoutParams(new LinearLayout.LayoutParams(r5, r5));
        this.f.setLayoutParams(new LinearLayout.LayoutParams(r5, r5));
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.e.setTextSize(2, this.b.getFontSizeSp());
        this.e.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.g.setLayoutParams(new FrameLayout.LayoutParams(r5, r5, 17));
        a();
        d();
    }

    public DbxButton(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.a = Style.SOLID;
        this.b = Size.MD;
        LinearLayout r9 = new LinearLayout(r6);
        this.c = r9;
        ImageView r10 = new ImageView(r6);
        this.d = r10;
        TextView r0 = new TextView(r6);
        this.e = r0;
        ImageView r1 = new ImageView(r6);
        this.f = r1;
        com.larus.common_ui.dbx.component.b r2 = new com.larus.common_ui.dbx.component.b(r6);
        this.g = r2;
        r9.setOrientation(0);
        r9.setGravity(17);
        r10.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r0.setGravity(17);
        r0.setMaxLines(1);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r9.addView(r10);
        r9.addView(r0);
        r9.addView(r1);
        addView(r9, new FrameLayout.LayoutParams(-2, -2, 17));
        r2.setVisibility(8);
        addView(r2, new FrameLayout.LayoutParams(c(this.b.getIconSideDp()), c(this.b.getIconSideDp()), 17));
        setClickable(true);
        setFocusable(true);
    }

    public /* synthetic */ DbxButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
