package com.obric.oui.checkbox;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.common.util.k;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.e;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0003LMNB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\bG\u0010HB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\bG\u0010IB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bG\u0010JJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001f\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001eJ\u0012\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\tH\u0014J0\u0010)\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0014R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010+R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010+R\u0018\u00102\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010+R\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00100R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R0\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0004\b>\u0010+\u0012\u0004\bC\u0010D\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010+R\u0016\u0010F\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u00100¨\u0006O"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "syncDrawableStyle", "syncButtonCheckState", "createColorFilter", TypedValues.Custom.S_COLOR, "setPrimaryColor", "", "light", "setAlwaysLight", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "isChecked", "toggle", "performClick", "checked", "setChecked", "Lcom/obric/oui/checkbox/OCheckBox$c;", "listener", "setOnCheckedStateChangedListener", "Lcom/obric/oui/checkbox/OCheckBox$b;", "setOnCheckedChangeListener", "extraSpace", "", "onCreateDrawableState", "onAttachedToWindow", "changed", "left", "top", "right", "bottom", "onLayout", "colorChecked", "I", "onCheckedChangeListener", "Lcom/obric/oui/checkbox/OCheckBox$b;", "iconSize", "adaptForCSR", "Z", "colorPrimary", "onCheckedStateChangedListener", "Lcom/obric/oui/checkbox/OCheckBox$c;", "colorStyle", "broadcasting", "Landroid/graphics/drawable/Drawable;", "buttonDrawable", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/ColorFilter;", "checkedColorFilter", "Landroid/graphics/ColorFilter;", "uncheckedColorFilter", EventBody.KEY_VALUE, "checkedState", "getCheckedState", "()I", "setCheckedState", "(I)V", "getCheckedState$annotations", "()V", "colorUnchecked", "alwaysLight", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OCheckBox extends AppCompatImageView implements Checkable {
    private static final int[] CHECKED_STATE_SET = null;
    public static final int COLOR_DEFAULT = 0;
    public static final int COLOR_ON_IMAGE = 1;
    public static final a Companion = null;
    private static final int[] INDETERMINATE_STATE_SET = null;
    public static final int STATE_CHECKED = 1;
    public static final int STATE_INDETERMINATE = 2;
    public static final int STATE_UNCHECKED = 0;
    private boolean adaptForCSR;
    private boolean alwaysLight;
    private boolean broadcasting;
    private Drawable buttonDrawable;
    private ColorFilter checkedColorFilter;
    private int checkedState;
    private int colorChecked;
    private int colorPrimary;
    private int colorStyle;
    private int colorUnchecked;
    private int iconSize;
    private b onCheckedChangeListener;
    private c onCheckedStateChangedListener;
    private ColorFilter uncheckedColorFilter;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface b {
        void a(OCheckBox r10, boolean r11);
    }

    public interface c {
        void a(OCheckBox r10, int r11);
    }

    static {
        Companion = new a(null);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        INDETERMINATE_STATE_SET = new int[]{u8.b.oui_state_indeterminate};
    }

    public OCheckBox(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        this.iconSize = MathKt.roundToInt(TypedValue.applyDimension(1, 18, r11.getDisplayMetrics()));
        this.colorPrimary = -1;
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init$default(this, r10, null, 0, 4, null);
    }

    public OCheckBox(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "attrs");
        super(r10, r11);
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        this.iconSize = MathKt.roundToInt(TypedValue.applyDimension(1, 18, r12.getDisplayMetrics()));
        this.colorPrimary = -1;
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init$default(this, r10, r11, 0, 4, null);
    }

    public OCheckBox(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "attrs");
        super(r10, r11, r12);
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        this.iconSize = MathKt.roundToInt(TypedValue.applyDimension(1, 18, r13.getDisplayMetrics()));
        this.colorPrimary = -1;
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init(r10, r11, r12);
    }

    /* JADX INFO: renamed from: access$mergeDrawableStates$s-1588574979, reason: not valid java name */
    public static final /* synthetic */ int[] m26access$mergeDrawableStates$s1588574979(int[] r10, int[] r11) {
        return ImageView.mergeDrawableStates(r10, r11);
    }

    public static final /* synthetic */ int[] access$mergeDrawableStates$s2666181(int[] r10, int[] r11) {
        return View.mergeDrawableStates(r10, r11);
    }

    private final void createColorFilter() {
        int r10 = this.colorChecked;
        if (r10 == (-1)) goto L6;
        this.checkedColorFilter = com.obric.oui.common.util.b.a(r10);
    L6:
        if (this.colorUnchecked == (-1)) goto L9;
        this.uncheckedColorFilter = new PorterDuffColorFilter(this.colorUnchecked, PorterDuff.Mode.SRC_IN);
        return;
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    private final void init(Context r10, AttributeSet r11, int r12) {
        TypedArray r13 = r10.obtainStyledAttributes(r11, l.OCheckBox, r12, 0);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…heckBox, defStyleAttr, 0)");
        this.colorStyle = r13.getInt(l.OCheckBox_oui_checkBoxColorStyle, 0);
        this.adaptForCSR = r13.getBoolean(l.ORadio_oui_adapt_for_csr, true);
        this.colorPrimary = r13.getColor(l.OCheckBox_oui_checkBoxPrimaryColor, -1);
        this.colorChecked = r13.getColor(l.OCheckBox_oui_checkBoxCheckedColor, -1);
        this.colorUnchecked = r13.getColor(l.OCheckBox_oui_checkBoxUncheckedColor, -1);
        Drawable r14 = r13.getDrawable(l.OCheckBox_oui_checkBoxButton);
        if (r14 != null) goto L6;
        r14 = null;
    L6:
        this.buttonDrawable = r14;
        this.alwaysLight = r13.getBoolean(l.OCheckBox_oui_checkBoxAlwaysLight, false);
        int r15 = l.OCheckBox_oui_checkedState;
        if (r13.hasValue(r15) == false) goto L9;
        setCheckedState(r13.getInt(r15, 0));
    L9:
        r13.recycle();
        createColorFilter();
        Drawable r16 = this.buttonDrawable;
        if (r16 != null) goto L12;
        syncDrawableStyle();
    L13:
        setBackground(null);
        syncButtonCheckState();
        setClickable(true);
        return;
    L12:
        setImageDrawable(r16);
        goto L13
    }

    static /* synthetic */ void init$default(OCheckBox r10, Context r11, AttributeSet r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L6;
        r13 = u8.b.OCheckBoxStyle;
    L6:
        r10.init(r11, r12, r13);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }

    private final void syncButtonCheckState() {
        Drawable r10 = getDrawable();
        if (r10 == null) goto L5;
        r10.clearColorFilter();
    L5:
        createColorFilter();
        Drawable r11 = getDrawable();
        if (r11 != null) goto L8;
        return;
    L8:
        if (isChecked() == false) goto L10;
        ColorFilter r12 = this.checkedColorFilter;
    L11:
        r11.setColorFilter(r12);
        return;
    L10:
        r12 = this.uncheckedColorFilter;
        goto L11
    }

    private final void syncDrawableStyle() {
        boolean r10 = this.alwaysLight;
        if (r10 == false) goto L6;
        Resources r11 = getResources();
        int r12 = e.o_checkbox_circle_always_light;
    L5:
        Drawable r13 = r11.getDrawable(r12, null);
        this.buttonDrawable = r13;
        int r14 = this.colorPrimary;
        if (r14 != (-1)) goto L15;
    L19:
        setImageDrawable(this.buttonDrawable);
        return;
    L15:
        if ((r13 instanceof StateListDrawable) == false) goto L19;
        if (Build.VERSION.SDK_INT < 29) goto L19;
        da.e r15 = da.e.f8521a;
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.graphics.drawable.StateListDrawable");
        r15.c((StateListDrawable) r13, "primary_shape", r14);
        goto L19
    L6:
        if (r10 == false) goto L8;
    L11:
        r11 = getResources();
        r12 = e.o_checkbox_circle;
        goto L5
    L8:
        if (this.colorStyle != 1) goto L11;
        r11 = getResources();
        r12 = e.o_checkbox_circle_on_image;
        goto L5
    }

    public final int getCheckedState() {
        return this.checkedState;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        if (this.checkedState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.adaptForCSR == false) goto L6;
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        k.a(this, MathKt.roundToInt(TypedValue.applyDimension(1, 44, r10.getDisplayMetrics())));
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 2);
        if (this.checkedState != 2) goto L6;
        m26access$mergeDrawableStates$s1588574979(r11, INDETERMINATE_STATE_SET);
    L6:
        if (isChecked() == false) goto L8;
        access$mergeDrawableStates$s2666181(r11, CHECKED_STATE_SET);
    L8:
        return r11;
    }

    @Override // android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.makeMeasureSpec(this.iconSize, 1073741824);
        super.onMeasure(r12, r12);
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        boolean r10 = super.performClick();
        if (r10 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        q9.a.b(getContext(), 1);
    L8:
        return r10;
    }

    public final void setAlwaysLight(boolean r10) {
        this.alwaysLight = r10;
        syncDrawableStyle();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        setCheckedState(r10 ? 1 : 0);
    }

    public final void setCheckedState(int r10) {
        if (this.checkedState == r10) goto L17;
        this.checkedState = r10;
        syncButtonCheckState();
        refreshDrawableState();
        if (this.broadcasting == false) goto L7;
        return;
    L7:
        this.broadcasting = true;
        c r11 = this.onCheckedStateChangedListener;
        if (r11 == null) goto L11;
        r11.a(this, this.checkedState);
    L11:
        if (this.checkedState == 2) goto L15;
        b r12 = this.onCheckedChangeListener;
        if (r12 == null) goto L15;
        r12.a(this, isChecked());
    L15:
        this.broadcasting = false;
        return;
    }

    public final void setOnCheckedChangeListener(b r10) {
        this.onCheckedChangeListener = r10;
    }

    public final void setOnCheckedStateChangedListener(c r10) {
        this.onCheckedStateChangedListener = r10;
    }

    public final void setPrimaryColor(@ColorInt int r10) {
        this.colorPrimary = r10;
        syncDrawableStyle();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
