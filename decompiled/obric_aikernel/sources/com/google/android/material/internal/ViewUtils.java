package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ViewUtils {

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3368c;

        a(View r10) {
            this.f3368c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f3368c.getContext().getSystemService("input_method")).showSoftInput(this.f3368c, 1);
        }
    }

    class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f3370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f3372d;

        b(boolean r10, boolean r11, boolean r12, d r13) {
            this.f3369a = r10;
            this.f3370b = r11;
            this.f3371c = r12;
            this.f3372d = r13;
        }

        @Override // com.google.android.material.internal.ViewUtils.d
        @NonNull
        public WindowInsetsCompat a(View r10, @NonNull WindowInsetsCompat r11, @NonNull e r12) {
            if (this.f3369a == false) goto L5;
            r12.f3376d += r11.getSystemWindowInsetBottom();
        L5:
            boolean r13 = ViewUtils.i(r10);
            if (this.f3370b == false) goto L11;
            if (r13 == false) goto L9;
            r12.f3375c += r11.getSystemWindowInsetLeft();
            goto L11
        L9:
            r12.f3373a += r11.getSystemWindowInsetLeft();
        L11:
            if (this.f3371c == false) goto L15;
            if (r13 == false) goto L14;
            r12.f3373a += r11.getSystemWindowInsetRight();
            goto L15
        L14:
            r12.f3375c += r11.getSystemWindowInsetRight();
        L15:
            r12.a(r10);
            d r14 = this.f3372d;
            if (r14 != null) goto L18;
            return r11;
        L18:
            return r14.a(r10, r11, r12);
        }
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View r10) {
            r10.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(r10);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
        }
    }

    public interface d {
        WindowInsetsCompat a(View r10, WindowInsetsCompat r11, e r12);
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3376d;

        public e(int r10, int r11, int r12, int r13) {
            this.f3373a = r10;
            this.f3374b = r11;
            this.f3375c = r12;
            this.f3376d = r13;
        }

        public e(@NonNull e r10) {
            this.f3373a = r10.f3373a;
            this.f3374b = r10.f3374b;
            this.f3375c = r10.f3375c;
            this.f3376d = r10.f3376d;
        }

        public void a(View r10) {
            ViewCompat.setPaddingRelative(r10, this.f3373a, this.f3374b, this.f3375c, this.f3376d);
        }
    }

    public static void a(@NonNull View r10, @Nullable AttributeSet r11, int r12, int r13, @Nullable d r14) {
        TypedArray r15 = r10.getContext().obtainStyledAttributes(r11, q5.l.Insets, r12, r13);
        boolean r16 = r15.getBoolean(q5.l.Insets_paddingBottomSystemWindowInsets, false);
        boolean r17 = r15.getBoolean(q5.l.Insets_paddingLeftSystemWindowInsets, false);
        boolean r18 = r15.getBoolean(q5.l.Insets_paddingRightSystemWindowInsets, false);
        r15.recycle();
        b(r10, new b(r16, r17, r18, r14));
    }

    public static void b(@NonNull View r10, @NonNull final d r11) {
        final e r12 = new e(ViewCompat.getPaddingStart(r10), r10.getPaddingTop(), ViewCompat.getPaddingEnd(r10), r10.getPaddingBottom());
        ViewCompat.setOnApplyWindowInsetsListener(r10, new AnonymousClass3(r11, r12));
        k(r10);
    }

    public static float c(@NonNull Context r10, @Dimension(unit = 0) int r11) {
        return TypedValue.applyDimension(1, r11, r10.getResources().getDisplayMetrics());
    }

    @Nullable
    public static Integer d(@NonNull View r10) {
        if ((r10.getBackground() instanceof ColorDrawable) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(((ColorDrawable) r10.getBackground()).getColor());
    }

    @Nullable
    public static ViewGroup e(@Nullable View r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        View r11 = r10.getRootView();
        ViewGroup r12 = (ViewGroup) r11.findViewById(R.id.content);
        if (r12 == null) goto L8;
        return r12;
    L8:
        if (r11 != r10) goto L10;
    L13:
        return null;
    L10:
        if ((r11 instanceof ViewGroup) == false) goto L13;
        return (ViewGroup) r11;
    }

    @Nullable
    public static p f(@NonNull View r10) {
        return g(e(r10));
    }

    @Nullable
    public static p g(@Nullable View r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 18) goto L10;
        return new o(r10);
    L10:
        return n.a(r10);
    }

    public static float h(@NonNull View r10) {
        ViewParent r11 = r10.getParent();
        float r12 = 0.0f;
    L4:
        if ((r11 instanceof View) == false) goto L6;
        r12 = r12 + ViewCompat.getElevation((View) r11);
        r11 = r11.getParent();
        goto L4
    L6:
        return r12;
    }

    public static boolean i(View r10) {
        if (ViewCompat.getLayoutDirection(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static PorterDuff.Mode j(int r10, PorterDuff.Mode r11) {
        if (r10 == 3) goto L21;
        if (r10 == 5) goto L19;
        if (r10 == 9) goto L17;
        switch(r10) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r11;
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

    public static void k(@NonNull View r10) {
        if (ViewCompat.isAttachedToWindow(r10) == false) goto L5;
        ViewCompat.requestApplyInsets(r10);
        return;
    L5:
        r10.addOnAttachStateChangeListener(new c());
    }

    public static void l(@NonNull View r10) {
        r10.requestFocus();
        r10.post(new a(r10));
    }
}
