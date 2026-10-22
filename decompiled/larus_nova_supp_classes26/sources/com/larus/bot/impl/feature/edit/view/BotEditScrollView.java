package com.larus.bot.impl.feature.edit.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.common_ui.utils.ViewExtKt;
import fv8.b;
import fv8.c;
import fv8.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001'B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0014J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J(\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012H\u0014J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0012J\b\u0010&\u001a\u00020\u0012H\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/bot/impl/feature/edit/view/BotEditScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "touchEnabled", "", "getTouchEnabled", "()Z", "setTouchEnabled", "(Z)V", "inTouch", "touchScrolled", "imeAnimationEnd", "extraMargin", "", "onAttachedToWindow", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "computeScrollDeltaToGetChildRectOnScreen", "rect", "Landroid/graphics/Rect;", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onScrollChanged", "l", "t", "oldl", "oldt", "setExtraImeBottomMargin", "marginPx", "getNavigationHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEditScrollView extends ScrollView {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;

    public static final class a {
    }

    static {
    }

    private final int getNavigationHeight() {
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(this);
        if (r0 == null) goto L8;
        Insets r1 = r0.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.bottom;
    L8:
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewExtKt.m(this, new b(this), new c(this), new d(this));
    }

    public final boolean getTouchEnabled() {
        return this.a;
    }

    public BotEditScrollView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static void a(BotEditScrollView r3) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 == null) goto L13;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L8:
        if (r1 == null) goto L10;
        r1.bottomMargin = r3.getNavigationHeight();
    L10:
        r3.setLayoutParams(r0);
        return;
    L7:
        r1 = null;
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.widget.ScrollView
    public final int computeScrollDeltaToGetChildRectOnScreen(Rect r4) {
        if (r4 == null) goto L4;
        int r0 = r4.bottom;
    L6:
        if (r0 <= ((getScrollY() + getHeight()) - this.e)) goto L10;
        return super.computeScrollDeltaToGetChildRectOnScreen(r4) + this.e;
    L10:
        return super.computeScrollDeltaToGetChildRectOnScreen(r4);
    L4:
        r0 = 0;
        goto L6
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r2) == false) goto L7;
        return true;
    }

    @Override // android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        if (this.a == true) goto L5;
        return false;
    L5:
        boolean r2 = true;
        if (this.b == true) goto L8;
        this.b = true;
        this.c = false;
    L8:
        boolean r0 = super.onTouchEvent(r6);
        if (r6 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L21;
        if (r6 != null) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == true) goto L21;
    L25:
        if (r6 != null) goto L27;
    L29:
        r2 = false;
    L30:
        if (r2 == true) goto L32;
    L34:
        return r0;
    L32:
        if (getChildCount() <= 0) goto L34;
        Object r7 = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r7).hideSoftInputFromWindow(getWindowToken(), 0);
        goto L34
    L27:
        if (r6.getActionMasked() != 2) goto L29;
    L17:
        if (r6.getActionMasked() != 3) goto L19;
        r4 = true;
    L21:
        this.b = false;
        if (this.c == true) goto L24;
        ViewExtKt.g(this);
    L24:
        this.c = false;
        goto L25
    L11:
        if (r6.getActionMasked() != 1) goto L13;
        r3 = true;
        goto L14
    }

    public final void setExtraImeBottomMargin(int r2) {
        this.e += r2;
    }

    public final void setTouchEnabled(boolean r1) {
        this.a = r1;
    }

    public BotEditScrollView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = true;
        this.e = c7.b(32);
    }

    public static Unit b(BotEditScrollView r3, Insets r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 == null) goto L19;
        ViewGroup.MarginLayoutParams r2 = null;
        if (ViewExtKt.h(r3) == true) goto L12;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r2 = (ViewGroup.MarginLayoutParams) r0;
    L9:
        if (r2 == null) goto L16;
        r2.bottomMargin = r3.getNavigationHeight();
    L16:
        r3.setLayoutParams(r0);
        return Unit.INSTANCE;
    L12:
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        r2 = (ViewGroup.MarginLayoutParams) r0;
    L14:
        if (r2 == null) goto L16;
        r2.bottomMargin = r4.bottom;
        goto L16
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        ViewGroup.LayoutParams r3 = getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L6:
        if (r4 == null) goto L8;
        int r5 = r4.bottomMargin;
    L10:
        if (this.d == true) goto L12;
        return;
    L12:
        if (ViewExtKt.h(this) == false) goto L14;
        return;
    L14:
        if (r5 == getNavigationHeight()) goto L19;
        post(new fv8.a(this));
        return;
    L19:
        return;
    L8:
        r5 = getNavigationHeight();
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        if (this.b == false) goto L6;
        this.c = true;
        return;
    }
}
