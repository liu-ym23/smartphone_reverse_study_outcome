package com.obric.oui.selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.lisitem.OListItemGeneral;
import da.c;
import ea.b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheetItemView;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "Landroid/view/View;", "getCheckMark", "Lcom/obric/oui/selection/OSelectionSheetItemView$Companion$CheckStyle;", "style", "", "setCheckStyle", "", "str", "setTitle", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "", "checked", "setChecked", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OSelectionSheetItemView extends OListItemGeneral {

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheetItemView$Companion$CheckStyle;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ICON", "CHECKBOX", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum CheckStyle extends Enum<CheckStyle> {
            private static final /* synthetic */ CheckStyle[] $VALUES = null;
            public static final CheckStyle CHECKBOX = null;
            public static final CheckStyle ICON = null;
            public static final CheckStyle NONE = null;

            static {
                CheckStyle r10 = new CheckStyle("NONE", 0);
                NONE = r10;
                CheckStyle r11 = new CheckStyle("ICON", 1);
                ICON = r11;
                CheckStyle r12 = new CheckStyle("CHECKBOX", 2);
                CHECKBOX = r12;
                $VALUES = new CheckStyle[]{r10, r11, r12};
            }

            private CheckStyle(String r10, int r11) {
                super(r10, r11);
            }

            public static CheckStyle valueOf(String r10) {
                return (CheckStyle) Enum.valueOf(CheckStyle.class, r10);
            }

            public static CheckStyle[] values() {
                return (CheckStyle[]) $VALUES.clone();
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new Companion(null);
    }

    public OSelectionSheetItemView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setCheckStyle(Companion.CheckStyle.NONE);
        setShowDivider(true);
        setShowBackground(false);
        setBackground(null);
    }

    private final View getCheckMark() {
        c r10 = c.f8520a;
        View r11 = getMTrailingElement().getChildAt(0);
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        ViewGroup r12 = (ViewGroup) r11;
        if (r12 != null) goto L10;
        return null;
    L10:
        return r12.getChildAt(0);
    L6:
        if ((r11 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    private final FrameLayout j() {
        FrameLayout r10 = new FrameLayout(getContext());
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, 32, r11.getDisplayMetrics()));
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        r10.setLayoutParams(new FrameLayout.LayoutParams(r12, MathKt.roundToInt(TypedValue.applyDimension(1, 24, r13.getDisplayMetrics()))));
        return r10;
    }

    public final void setCheckStyle(Companion.CheckStyle r10) {
        Intrinsics.checkNotNullParameter(r10, "style");
        int r11 = a.f7366a[r10.ordinal()];
        View r12 = null;
        if (r11 != 1) goto L5;
        ImageView r13 = new ImageView(getContext());
        Context r14 = r13.getContext();
        Intrinsics.checkNotNullExpressionValue(r14, "context");
        r13.setImageDrawable(ResourcesCompat.getDrawable(r14.getResources(), e.o_ic_radio_tick_checked, null));
        r12 = r13;
    L13:
        if (r12 == null) goto L15;
        FrameLayout r15 = j();
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-2, -2);
        r16.gravity = 17;
        r15.addView(r12, r16);
        setTrailingView(r15);
        return;
    L15:
        getMTrailingElement().setVisibility(8);
        return;
    L5:
        if (r11 != 2) goto L7;
        Context r17 = getContext();
        Intrinsics.checkNotNullExpressionValue(r17, "context");
        r12 = new OCheckBox(r17);
        goto L13
    L7:
        if (r11 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    public final void setChecked(boolean r10) {
        View r11 = getCheckMark();
        if ((r11 instanceof OCheckBox) == false) goto L6;
        ((OCheckBox) r11).setChecked(r10);
        return;
    L6:
        if ((r11 instanceof ImageView) == false) goto L12;
        ImageView r12 = (ImageView) r11;
        if (r10 == false) goto L10;
        int r13 = 0;
    L11:
        r12.setVisibility(r13);
        return;
    L10:
        r13 = 4;
        goto L11
    L12:
        b.a("OSelectionSheetItemView", "checkMark is not OCheckBox or ImageView");
    }

    public final void setIcon(Drawable r10) {
        setContentImage(r10);
    }

    public final void setTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "str");
        setTitleString(r10);
    }
}
