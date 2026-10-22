package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.android.material.drawable.DrawableUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ViewUtils {

    @RequiresApi(16)
    public static final int EDGE_TO_EDGE_FLAGS = 768;

    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r10, RelativePadding r11);
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int r5, int r10, int r11, int r12) {
            this.start = r5;
            this.top = r10;
            this.end = r11;
            this.bottom = r12;
        }

        public void applyToView(View r5) {
            ViewCompat.setPaddingRelative(r5, this.start, this.top, this.end, this.bottom);
        }

        public RelativePadding(@NonNull RelativePadding r5) {
            this.start = r5.start;
            this.top = r5.top;
            this.end = r5.end;
            this.bottom = r5.bottom;
        }
    }

    private ViewUtils() {
    }

    public static /* synthetic */ void a(View r5, boolean r10) {
        lambda$requestFocusAndShowKeyboard$0(r5, r10);
    }

    public static void addOnGlobalLayoutListener(@Nullable View r5, @NonNull ViewTreeObserver.OnGlobalLayoutListener r10) {
        if (r5 == null) goto L5;
        r5.getViewTreeObserver().addOnGlobalLayoutListener(r10);
        return;
    }

    @NonNull
    public static Rect calculateOffsetRectFromBounds(@NonNull View r5, @NonNull View r10) {
        int[] r11 = new int[2];
        r10.getLocationOnScreen(r11);
        int r12 = r11[0];
        int r13 = r11[1];
        int[] r14 = new int[2];
        r5.getLocationOnScreen(r14);
        int r15 = r14[0];
        int r16 = r12 - r15;
        int r17 = r13 - r14[1];
        return new Rect(r16, r17, r10.getWidth() + r16, r10.getHeight() + r17);
    }

    @NonNull
    public static Rect calculateRectFromBounds(@NonNull View r5) {
        return calculateRectFromBounds(r5, 0);
    }

    public static void doOnApplyWindowInsets(@NonNull View r5, @Nullable AttributeSet r10, int r11, int r12) {
        doOnApplyWindowInsets(r5, r10, r11, r12, null);
    }

    public static float dpToPx(@NonNull Context r5, @Dimension(unit = 0) int r10) {
        return TypedValue.applyDimension(1, r10, r5.getResources().getDisplayMetrics());
    }

    @Nullable
    public static Integer getBackgroundColor(@NonNull View r5) {
        ColorStateList r10 = DrawableUtils.getColorStateListOrNull(r5.getBackground());
        if (r10 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r10.getDefaultColor());
    }

    @NonNull
    public static List<View> getChildren(@Nullable View r5) {
        ArrayList r10 = new ArrayList();
        if ((r5 instanceof ViewGroup) == false) goto L8;
        ViewGroup r11 = (ViewGroup) r5;
        int r12 = 0;
    L6:
        if (r12 >= r11.getChildCount()) goto L8;
        r10.add(r11.getChildAt(r12));
        r12 = r12 + 1;
    L8:
        return r10;
    }

    @Nullable
    public static ViewGroup getContentView(@Nullable View r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        View r10 = r5.getRootView();
        ViewGroup r11 = (ViewGroup) r10.findViewById(R.id.content);
        if (r11 == null) goto L8;
        return r11;
    L8:
        if (r10 != r5) goto L10;
    L13:
        return null;
    L10:
        if ((r10 instanceof ViewGroup) == false) goto L13;
        return (ViewGroup) r10;
    }

    @Nullable
    public static ViewOverlayImpl getContentViewOverlay(@NonNull View r5) {
        return getOverlay(getContentView(r5));
    }

    @Nullable
    private static InputMethodManager getInputMethodManager(@NonNull View r5) {
        return (InputMethodManager) ContextCompat.getSystemService(r5.getContext(), InputMethodManager.class);
    }

    @Nullable
    public static ViewOverlayImpl getOverlay(@Nullable View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new ViewOverlayApi18(r5);
    }

    public static float getParentAbsoluteElevation(@NonNull View r5) {
        ViewParent r10 = r5.getParent();
        float r11 = 0.0f;
    L4:
        if ((r10 instanceof View) == false) goto L6;
        r11 = r11 + ViewCompat.getElevation((View) r10);
        r10 = r10.getParent();
        goto L4
    L6:
        return r11;
    }

    public static void hideKeyboard(@NonNull View r5) {
        hideKeyboard(r5, true);
    }

    public static boolean isLayoutRtl(View r5) {
        if (ViewCompat.getLayoutDirection(r5) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static /* synthetic */ void lambda$requestFocusAndShowKeyboard$0(View r5, boolean r10) {
        showKeyboard(r5, r10);
    }

    public static PorterDuff.Mode parseTintMode(int r5, PorterDuff.Mode r10) {
        if (r5 == 3) goto L21;
        if (r5 == 5) goto L19;
        if (r5 == 9) goto L17;
        switch(r5) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r10;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void removeOnGlobalLayoutListener(@Nullable View r5, @NonNull ViewTreeObserver.OnGlobalLayoutListener r10) {
        if (r5 == null) goto L5;
        removeOnGlobalLayoutListener(r5.getViewTreeObserver(), r10);
        return;
    }

    public static void requestApplyInsetsWhenAttached(@NonNull View r5) {
        if (ViewCompat.isAttachedToWindow(r5) == false) goto L5;
        ViewCompat.requestApplyInsets(r5);
        return;
    L5:
        r5.addOnAttachStateChangeListener(new AnonymousClass3());
    }

    public static void requestFocusAndShowKeyboard(@NonNull View r5) {
        requestFocusAndShowKeyboard(r5, true);
    }

    public static void setBoundsFromRect(@NonNull View r5, @NonNull Rect r10) {
        r5.setLeft(r10.left);
        r5.setTop(r10.top);
        r5.setRight(r10.right);
        r5.setBottom(r10.bottom);
    }

    public static void showKeyboard(@NonNull View r5) {
        showKeyboard(r5, true);
    }

    @NonNull
    public static Rect calculateRectFromBounds(@NonNull View r5, int r10) {
        return new Rect(r5.getLeft(), r5.getTop() + r10, r5.getRight(), r5.getBottom() + r10);
    }

    public static void doOnApplyWindowInsets(@NonNull View r5, @Nullable AttributeSet r10, int r11, int r12, @Nullable final OnApplyWindowInsetsListener r13) {
        TypedArray r14 = r5.getContext().obtainStyledAttributes(r10, com.google.android.material.R.styleable.Insets, r11, r12);
        final boolean r15 = r14.getBoolean(com.google.android.material.R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        final boolean r16 = r14.getBoolean(com.google.android.material.R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        final boolean r17 = r14.getBoolean(com.google.android.material.R.styleable.Insets_paddingRightSystemWindowInsets, false);
        r14.recycle();
        doOnApplyWindowInsets(r5, new AnonymousClass1(r15, r16, r17, r13));
    }

    public static void hideKeyboard(@NonNull View r5, boolean r10) {
        if (r10 == false) goto L7;
        WindowInsetsControllerCompat r11 = ViewCompat.getWindowInsetsController(r5);
        if (r11 == null) goto L7;
        r11.hide(WindowInsetsCompat.Type.ime());
        return;
    L7:
        InputMethodManager r12 = getInputMethodManager(r5);
        if (r12 == null) goto L11;
        r12.hideSoftInputFromWindow(r5.getWindowToken(), 0);
        return;
    }

    public static void removeOnGlobalLayoutListener(@NonNull ViewTreeObserver r5, @NonNull ViewTreeObserver.OnGlobalLayoutListener r10) {
        r5.removeOnGlobalLayoutListener(r10);
    }

    public static void requestFocusAndShowKeyboard(@NonNull View r5, boolean r10) {
        r5.requestFocus();
        r5.post(new b(r5, r10));
    }

    public static void showKeyboard(@NonNull View r5, boolean r10) {
        if (r10 == false) goto L7;
        WindowInsetsControllerCompat r11 = ViewCompat.getWindowInsetsController(r5);
        if (r11 == null) goto L7;
        r11.show(WindowInsetsCompat.Type.ime());
        return;
    L7:
        getInputMethodManager(r5).showSoftInput(r5, 1);
    }

    public static void doOnApplyWindowInsets(@NonNull View r5, @NonNull final OnApplyWindowInsetsListener r10) {
        final RelativePadding r11 = new RelativePadding(ViewCompat.getPaddingStart(r5), r5.getPaddingTop(), ViewCompat.getPaddingEnd(r5), r5.getPaddingBottom());
        ViewCompat.setOnApplyWindowInsetsListener(r5, new AnonymousClass2(r10, r11));
        requestApplyInsetsWhenAttached(r5);
    }
}
