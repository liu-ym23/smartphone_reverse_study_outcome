package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J,\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\r2\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001bJ\u0010\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/button/OIconButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "applyDynamicTheme", "", "themeStyle", "initContent", "contentView", "Landroid/widget/FrameLayout;", "typedArray", "Landroid/content/res/TypedArray;", "setIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableResId", "setIconBgColor", TypedValues.Custom.S_COLOR, "setIconTintColor", "Landroid/content/res/ColorStateList;", "updateUIOnEnableChanged", "enabled", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OIconButtonFloating extends OShadowFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppCompatImageView f13393a;

    public OIconButtonFloating(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OIconButtonFloating(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OIconButtonFloating(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public OIconButtonFloating(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r5, r6);
    }

    public /* synthetic */ OIconButtonFloating(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r8, r9, r4, r5);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void a(int r1) {
        super.a(r1);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void a(Context r7, FrameLayout r8, AttributeSet r9, TypedArray r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r8, "contentView");
        if (r10 != null) goto L5;
        return;
    L5:
        ColorStateList r13 = r10.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetTintColor, "styleable", "OShadowFrame_oui_widgetTintColor"));
        Drawable r0 = r10.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetIcon, "styleable", "OShadowFrame_oui_widgetIcon"));
        AppCompatImageView r2 = new AppCompatImageView(r11);
        this.f13393a = r2;
        AppCompatImageView r3 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r2 = null;
    L8:
        r2.setDuplicateParentStateEnabled(true);
        if (r0 == null) goto L19;
        AppCompatImageView r4 = this.f13393a;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r4 = null;
    L13:
        r4.setImageDrawable(r0);
        if (r13 == null) goto L19;
        AppCompatImageView r1 = this.f13393a;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r1 = null;
    L18:
        r1.setImageTintList(r13);
    L19:
        AppCompatImageView r14 = this.f13393a;
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L23:
        View r15 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, -1);
        r5.gravity = 17;
        Unit r6 = Unit.INSTANCE;
        r8.addView(r15, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        if (getEnableMaterial() == false) goto L27;
        a(r11, r10);
        return;
    L27:
        return;
    L22:
        r3 = r14;
        goto L23
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void a(boolean r3) {
        super.a(r3);
        AppCompatImageView r0 = null;
        AppCompatImageView r2 = this.f13393a;
        if (r3 == false) goto L8;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L7:
        float r4 = 1.0f;
    L12:
        r0.setAlpha(r4);
        return;
    L6:
        r0 = r2;
        goto L7
    L8:
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L11:
        r4 = 0.3f;
        goto L12
    L10:
        r0 = r2;
        goto L11
    }

    public final void setIcon(int r1) {
        AppCompatImageView r0 = this.f13393a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        r0.setImageResource(r1);
    }

    public final void setIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        AppCompatImageView r1 = this.f13393a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r1 = null;
    L5:
        r1.setImageDrawable(r2);
    }

    public final void setIconBgColor(int r1) {
        setBgColor(r1);
    }

    public final void setIconTintColor(int r1) {
        AppCompatImageView r0 = this.f13393a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        r0.setColorFilter(r1);
    }

    public final void setIconTintColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, TypedValues.Custom.S_COLOR);
        AppCompatImageView r1 = this.f13393a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r1 = null;
    L5:
        r1.setImageTintList(r2);
    }
}
