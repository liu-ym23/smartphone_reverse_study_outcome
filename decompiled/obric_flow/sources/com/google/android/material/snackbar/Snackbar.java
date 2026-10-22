package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR = null;
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS = null;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        public Callback() {
        }

        /* JADX INFO: renamed from: onDismissed, reason: avoid collision after fix types in other method */
        public void onDismissed2(Snackbar r5, int r10) {
        }

        /* JADX INFO: renamed from: onShown, reason: avoid collision after fix types in other method */
        public void onShown2(Snackbar r5) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public /* bridge */ /* synthetic */ void onDismissed(Snackbar r5, int r10) {
            onDismissed2(r5, r10);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public /* bridge */ /* synthetic */ void onShown(Snackbar r5) {
            onShown2(r5);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context r5) {
            super(r5);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            int r12 = getChildCount();
            int r13 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int r5 = 0;
        L3:
            if (r5 >= r12) goto L8;
            View r14 = getChildAt(r5);
            if (r14.getLayoutParams().width != (-1)) goto L7;
            r14.measure(View.MeasureSpec.makeMeasureSpec(r13, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r14.getMeasuredHeight(), BasicMeasure.EXACTLY));
        L7:
            r5 = r5 + 1;
            goto L3
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable r5) {
            super.setBackground(r5);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable r5) {
            super.setBackgroundDrawable(r5);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList r5) {
            super.setBackgroundTintList(r5);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
            super.setBackgroundTintMode(r5);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams r5) {
            super.setLayoutParams(r5);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener r5) {
            super.setOnClickListener(r5);
        }

        public SnackbarLayout(Context r5, AttributeSet r10) {
            super(r5, r10);
        }
    }

    static {
        int r5 = R.attr.snackbarButtonStyle;
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{r5};
        SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{r5, R.attr.snackbarTextViewStyle};
    }

    private Snackbar(@NonNull Context r5, @NonNull ViewGroup r10, @NonNull View r11, @NonNull ContentViewCallback r12) {
        super(r5, r10, r11, r12);
        this.accessibilityManager = (AccessibilityManager) r10.getContext().getSystemService("accessibility");
    }

    public static /* synthetic */ void a(Snackbar r5, View.OnClickListener r10, View r11) {
        r5.lambda$setAction$0(r10, r11);
    }

    @Nullable
    private static ViewGroup findSuitableParent(View r5) {
        ViewGroup r10 = null;
    L4:
        if ((r5 instanceof CoordinatorLayout) == true) goto L6;
        if ((r5 instanceof FrameLayout) == true) goto L10;
    L14:
        if (r5 == null) goto L19;
        Object r11 = r5.getParent();
        if ((r11 instanceof View) == false) goto L18;
        r5 = (View) r11;
        goto L19
    L18:
        r5 = null;
    L19:
        if (r5 != null) goto L4;
        return r10;
    L10:
        if (r5.getId() == 16908290) goto L12;
        r10 = (ViewGroup) r5;
        goto L14
    L12:
        return (ViewGroup) r5;
    L6:
        return (ViewGroup) r5;
    }

    private Button getActionView() {
        return getContentLayout().getActionView();
    }

    private SnackbarContentLayout getContentLayout() {
        return (SnackbarContentLayout) this.view.getChildAt(0);
    }

    private TextView getMessageView() {
        return getContentLayout().getMessageView();
    }

    @Deprecated
    public static boolean hasSnackbarButtonStyleAttr(@NonNull Context r5) {
        TypedArray r10 = r5.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int r11 = r10.getResourceId(0, -1);
        r10.recycle();
        if (r11 == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean hasSnackbarContentStyleAttrs(@NonNull Context r5) {
        TypedArray r10 = r5.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int r11 = r10.getResourceId(0, -1);
        int r12 = r10.getResourceId(1, -1);
        r10.recycle();
        if (r11 == (-1)) goto L7;
        if (r12 != (-1)) goto L6;
        return false;
    L6:
        return true;
    L7:
        return false;
    }

    private /* synthetic */ void lambda$setAction$0(View.OnClickListener r5, View r10) {
        r5.onClick(r10);
        dispatchDismiss(1);
    }

    @NonNull
    public static Snackbar make(@NonNull View r5, @NonNull CharSequence r10, int r11) {
        return makeInternal(null, r5, r10, r11);
    }

    @NonNull
    private static Snackbar makeInternal(@Nullable Context r5, @NonNull View r10, @NonNull CharSequence r11, int r12) {
        ViewGroup r13 = findSuitableParent(r10);
        if (r13 == null) goto L13;
        if (r5 != null) goto L6;
        r5 = r13.getContext();
    L6:
        LayoutInflater r14 = LayoutInflater.from(r5);
        if (hasSnackbarContentStyleAttrs(r5) == false) goto L9;
        int r15 = R.layout.mtrl_layout_snackbar_include;
    L10:
        SnackbarContentLayout r16 = (SnackbarContentLayout) r14.inflate(r15, r13, false);
        Snackbar r17 = new Snackbar(r5, r13, r16, r16);
        r17.setText(r11);
        r17.setDuration(r12);
        return r17;
    L9:
        r15 = R.layout.design_layout_snackbar_include;
        goto L10
    L13:
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        int r5 = super.getDuration();
        if (r5 != (-2)) goto L6;
        return -2;
    L6:
        if (this.hasAction == false) goto L8;
        int r10 = 4;
    L10:
        return this.accessibilityManager.getRecommendedTimeoutMillis(r5, r10 | 3);
    L8:
        r10 = 0;
        goto L10
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    @NonNull
    public Snackbar setAction(@StringRes int r5, View.OnClickListener r10) {
        return setAction(getContext().getText(r5), r10);
    }

    @NonNull
    public Snackbar setActionTextColor(ColorStateList r5) {
        getActionView().setTextColor(r5);
        return this;
    }

    @NonNull
    public Snackbar setBackgroundTint(@ColorInt int r5) {
        return setBackgroundTintList(ColorStateList.valueOf(r5));
    }

    @NonNull
    public Snackbar setBackgroundTintList(@Nullable ColorStateList r5) {
        this.view.setBackgroundTintList(r5);
        return this;
    }

    @NonNull
    public Snackbar setBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
        this.view.setBackgroundTintMode(r5);
        return this;
    }

    @NonNull
    @Deprecated
    public Snackbar setCallback(@Nullable Callback r5) {
        BaseTransientBottomBar.BaseCallback<Snackbar> r10 = this.callback;
        if (r10 == null) goto L5;
        removeCallback(r10);
    L5:
        if (r5 == null) goto L7;
        addCallback(r5);
    L7:
        this.callback = r5;
        return this;
    }

    @NonNull
    public Snackbar setMaxInlineActionWidth(@Dimension int r5) {
        getContentLayout().setMaxInlineActionWidth(r5);
        return this;
    }

    @NonNull
    public Snackbar setText(@NonNull CharSequence r5) {
        getMessageView().setText(r5);
        return this;
    }

    @NonNull
    public Snackbar setTextColor(ColorStateList r5) {
        getMessageView().setTextColor(r5);
        return this;
    }

    @NonNull
    public Snackbar setTextMaxLines(int r5) {
        getMessageView().setMaxLines(r5);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }

    @NonNull
    public static Snackbar make(@NonNull Context r5, @NonNull View r10, @NonNull CharSequence r11, int r12) {
        return makeInternal(r5, r10, r11, r12);
    }

    @NonNull
    public Snackbar setAction(@Nullable CharSequence r5, @Nullable View.OnClickListener r10) {
        Button r11 = getActionView();
        if (TextUtils.isEmpty(r5) == true) goto L7;
        if (r10 == null) goto L7;
        this.hasAction = true;
        r11.setVisibility(0);
        r11.setText(r5);
        r11.setOnClickListener(new a(0, this, r10));
    L8:
        return this;
    L7:
        r11.setVisibility(8);
        r11.setOnClickListener(null);
        this.hasAction = false;
        goto L8
    }

    @NonNull
    public Snackbar setActionTextColor(@ColorInt int r5) {
        getActionView().setTextColor(r5);
        return this;
    }

    @NonNull
    public Snackbar setText(@StringRes int r5) {
        return setText(getContext().getText(r5));
    }

    @NonNull
    public Snackbar setTextColor(@ColorInt int r5) {
        getMessageView().setTextColor(r5);
        return this;
    }

    @NonNull
    public static Snackbar make(@NonNull View r5, @StringRes int r10, int r11) {
        return make(r5, r5.getResources().getText(r10), r11);
    }
}
