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
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.c.g;
import com.obric.oui.common.util.d;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u001f\b\u0016\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0003MNOB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020)H\u0002J,\u0010-\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u00020)H\u0014J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\nH\u0016J0\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nH\u0014J\u0018\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\nH\u0014J\b\u0010<\u001a\u00020\u000fH\u0016J\u000e\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u000fJ\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\u000fH\u0016J\u000e\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020\u000fJ\u0010\u0010C\u001a\u00020)2\b\u0010D\u001a\u0004\u0018\u00010$J\u0010\u0010E\u001a\u00020)2\b\u0010D\u001a\u0004\u0018\u00010&J\u0010\u0010F\u001a\u00020)2\b\b\u0001\u0010G\u001a\u00020\nJ\u0010\u0010H\u001a\u00020)2\b\b\u0001\u0010I\u001a\u00020\nJ\b\u0010J\u001a\u00020)H\u0002J\b\u0010K\u001a\u00020)H\u0002J\b\u0010L\u001a\u00020)H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adaptForCSR", "", "alwaysLight", "broadcasting", "buttonDrawable", "Landroid/graphics/drawable/Drawable;", "checkedColorFilter", "Landroid/graphics/ColorFilter;", EventBody.KEY_VALUE, "checkedState", "getCheckedState$annotations", "()V", "getCheckedState", "()I", "setCheckedState", "(I)V", "colorChecked", "colorPrimary", "colorStyle", "colorUnchecked", "iconSize", "onCheckedChangeListener", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "onCheckedStateChangedListener", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "uncheckedColorFilter", "applyAppearanceAttributes", "", "array", "Landroid/content/res/TypedArray;", "createColorFilter", CommonConsts.APM_INNER_EVENT_COST_INIT, "isChecked", "onAttachedToWindow", "onCreateDrawableState", "", "extraSpace", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "performClick", "setAlwaysLight", "light", "setChecked", "checked", "setEnableExpandTouchRect", "enableExpand", "setOnCheckedChangeListener", "listener", "setOnCheckedStateChangedListener", "setPrimaryColor", TypedValues.Custom.S_COLOR, "setStyle", "styleRes", "syncButtonCheckState", "syncDrawableStyle", "toggle", "Companion", "OnCheckedChangeListener", "OnCheckedStateChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$Companion;", "", "()V", "CHECKED_STATE_SET", "", "COLOR_DEFAULT", "", "COLOR_ON_IMAGE", "INDETERMINATE_STATE_SET", "STATE_CHECKED", "STATE_INDETERMINATE", "STATE_UNCHECKED", "CheckedState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "", "onCheckedChanged", "", "buttonView", "Lcom/obric/oui/checkbox/OCheckBox;", "isChecked", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void onCheckedChanged(OCheckBox r1, boolean r2);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "", "onCheckedStateChangedListener", "", "buttonView", "Lcom/obric/oui/checkbox/OCheckBox;", "state", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a(OCheckBox r1, int r2);
    }

    static {
        Companion = new a(null);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        INDETERMINATE_STATE_SET = new int[]{ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.oui_state_indeterminate, "attr", "oui_state_indeterminate")};
    }

    public OCheckBox(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null);
    }

    public OCheckBox(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        this(r6, r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.OCheckBoxStyle, "attr", "OCheckBoxStyle"));
    }

    public OCheckBox(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        this(r7, r8, r6, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.style.OStyleV2_OCheckBox_DayNight, "style", "OStyleV2_OCheckBox_DayNight"));
    }

    public OCheckBox(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r5);
        this.iconSize = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 18);
        this.colorPrimary = -1;
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init(r7, r8, r5, r6);
    }

    private final void applyAppearanceAttributes(TypedArray r6) {
        this.colorStyle = r6.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OCheckBox_oui_checkBoxColorStyle, "styleable", "OCheckBox_oui_checkBoxColorStyle"), 0);
        this.colorPrimary = r6.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OCheckBox_oui_checkBoxPrimaryColor, "styleable", "OCheckBox_oui_checkBoxPrimaryColor"), -1);
        this.colorChecked = r6.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OCheckBox_oui_checkBoxCheckedColor, "styleable", "OCheckBox_oui_checkBoxCheckedColor"), -1);
        this.colorUnchecked = r6.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OCheckBox_oui_checkBoxUncheckedColor, "styleable", "OCheckBox_oui_checkBoxUncheckedColor"), -1);
        Drawable r0 = r6.getDrawable(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OCheckBox_oui_checkBoxButton, "styleable", "OCheckBox_oui_checkBoxButton"));
        if (r0 != null) goto L5;
        r0 = null;
    L5:
        this.buttonDrawable = r0;
        this.alwaysLight = r6.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OCheckBox_oui_checkBoxAlwaysLight, "styleable", "OCheckBox_oui_checkBoxAlwaysLight"), false);
    }

    private final void createColorFilter() {
        int r0 = this.colorChecked;
        if (r0 == (-1)) goto L6;
        this.checkedColorFilter = (ColorFilter) ZeusTransformUtils.preCheckCast(d.a(r0), ColorFilter.class, "com.obric.memorydata.plugin");
    L6:
        if (this.colorUnchecked == (-1)) goto L9;
        this.uncheckedColorFilter = (ColorFilter) ZeusTransformUtils.preCheckCast(new PorterDuffColorFilter(this.colorUnchecked, PorterDuff.Mode.SRC_IN), ColorFilter.class, "com.obric.memorydata.plugin");
        return;
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    private final void init(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        int[] r0 = com.obric.memorydata.plugin.R.styleable.OCheckBox;
        Intrinsics.checkNotNullExpressionValue(r0, "OCheckBox");
        TypedArray r9 = r7.obtainStyledAttributes(r8, r0, r5, r6);
        Intrinsics.checkNotNullExpressionValue(r9, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        applyAppearanceAttributes(r9);
        this.adaptForCSR = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.ORadio_oui_adapt_for_csr, "styleable", "ORadio_oui_adapt_for_csr"), true);
        if (r9.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OCheckBox_oui_checkedState, "styleable", "OCheckBox_oui_checkedState")) == false) goto L5;
        setCheckedState(r9.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OCheckBox_oui_checkedState, "styleable", "OCheckBox_oui_checkedState"), 0));
    L5:
        r9.recycle();
        createColorFilter();
        syncDrawableStyle();
        setBackground(null);
        syncButtonCheckState();
        setClickable(true);
    }

    private final void syncButtonCheckState() {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L6;
        r0.clearColorFilter();
    L6:
        createColorFilter();
        Drawable r1 = getDrawable();
        if (r1 != null) goto L10;
        return;
    L10:
        if (isChecked() == false) goto L12;
        ColorFilter r2 = this.checkedColorFilter;
    L13:
        r1.setColorFilter(r2);
        return;
    L12:
        r2 = this.uncheckedColorFilter;
        goto L13
    }

    private final void syncDrawableStyle() {
        if (this.alwaysLight == false) goto L7;
        Resources r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        int r4 = com.obric.memorydata.plugin.R.drawable.o_checkbox_circle_always_light;
        String r5 = "o_checkbox_circle_always_light";
    L5:
        Drawable r1 = r0.getDrawable(ZeusTransformUtils.mapRes(r4, "drawable", r5), null);
    L14:
        if (this.colorPrimary != (-1)) goto L16;
    L20:
        setImageDrawable(r1);
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r1, StateListDrawable.class) == false) goto L20;
        if (Build.VERSION.SDK_INT < 29) goto L20;
        g.f13407a.a((StateListDrawable) ZeusTransformUtils.preCheckCast(r1, StateListDrawable.class, "com.obric.memorydata.plugin"), "primary_shape", this.colorPrimary);
        goto L20
    L7:
        if (this.colorStyle != 1) goto L9;
        r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        r4 = com.obric.memorydata.plugin.R.drawable.o_checkbox_circle_on_image;
        r5 = "o_checkbox_circle_on_image";
        goto L5
    L9:
        r1 = this.buttonDrawable;
        if (r1 != null) goto L14;
        r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        r4 = com.obric.memorydata.plugin.R.drawable.o_checkbox_circle;
        r5 = "o_checkbox_circle";
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
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.adaptForCSR == false) goto L6;
        o.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 44));
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r3) {
        int[] r4 = super.onCreateDrawableState(r3 + 2);
        if (this.checkedState != 2) goto L6;
        AppCompatImageView.mergeDrawableStates(r4, INDETERMINATE_STATE_SET);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r4, CHECKED_STATE_SET);
    L8:
        return r4;
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.makeMeasureSpec(this.iconSize, 1073741824);
        super.onMeasure(r3, r3);
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        boolean r0 = super.performClick();
        if (r0 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        com.obric.oui.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1);
    L8:
        return r0;
    }

    public final void setAlwaysLight(boolean r1) {
        this.alwaysLight = r1;
        syncDrawableStyle();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        setCheckedState(r1 ? 1 : 0);
    }

    public final void setCheckedState(int r2) {
        if (this.checkedState == r2) goto L19;
        this.checkedState = r2;
        syncButtonCheckState();
        refreshDrawableState();
        if (this.broadcasting == false) goto L7;
        return;
    L7:
        this.broadcasting = true;
        c r3 = this.onCheckedStateChangedListener;
        if (r3 == null) goto L12;
        r3.a(this, this.checkedState);
    L12:
        if (this.checkedState == 2) goto L17;
        b r4 = this.onCheckedChangeListener;
        if (r4 == null) goto L17;
        r4.onCheckedChanged(this, isChecked());
    L17:
        this.broadcasting = false;
        return;
    }

    public final void setEnableExpandTouchRect(boolean r1) {
        this.adaptForCSR = r1;
    }

    public final void setOnCheckedChangeListener(b r3) {
        this.onCheckedChangeListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final void setOnCheckedStateChangedListener(c r3) {
        this.onCheckedStateChangedListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public final void setPrimaryColor(int r1) {
        this.colorPrimary = r1;
        syncDrawableStyle();
        invalidate();
    }

    public final void setStyle(int r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        int[] r1 = com.obric.memorydata.plugin.R.styleable.OCheckBox;
        Intrinsics.checkNotNullExpressionValue(r1, "OCheckBox");
        TypedArray r6 = r0.obtainStyledAttributes(null, r1, 0, r5);
        Intrinsics.checkNotNullExpressionValue(r6, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        applyAppearanceAttributes(r6);
        r6.recycle();
        createColorFilter();
        syncDrawableStyle();
        syncButtonCheckState();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
