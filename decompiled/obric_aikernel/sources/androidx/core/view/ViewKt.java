package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,432:1\n40#1:433\n56#1:434\n329#1,4:438\n43#2,3:435\n*S KotlinDebug\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n*L\n71#1:433\n71#1:434\n315#1:438,4\n238#1:435,3\n*E\n"})
public final class ViewKt {
    public static /* synthetic */ void a(Function0 r10) {
        postOnAnimationDelayed$lambda$1(r10);
    }

    public static final void doOnAttach(final View r10, final Function1<? super View, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        if (ViewCompat.isAttachedToWindow(r10) == false) goto L5;
        r11.invoke(r10);
        return;
    L5:
        r10.addOnAttachStateChangeListener(new AnonymousClass1(r10, r11));
    }

    public static final void doOnDetach(final View r10, final Function1<? super View, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        if (ViewCompat.isAttachedToWindow(r10) == true) goto L5;
        r11.invoke(r10);
        return;
    L5:
        r10.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC03331(r10, r11));
    }

    public static final void doOnLayout(View r10, final Function1<? super View, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        if (ViewCompat.isLaidOut(r10) == true) goto L5;
    L7:
        r10.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(r11));
        return;
    L5:
        if (r10.isLayoutRequested() == true) goto L7;
        r11.invoke(r10);
    }

    public static final void doOnNextLayout(View r10, final Function1<? super View, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        r10.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC03341(r11));
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View r10, final Function1<? super View, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        OneShotPreDrawListener r12 = OneShotPreDrawListener.add(r10, new RunnableC03351(r11, r10));
        Intrinsics.checkNotNullExpressionValue(r12, "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        return r12;
    }

    public static final Bitmap drawToBitmap(View r10, Bitmap.Config r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "config");
        if (ViewCompat.isLaidOut(r10) == false) goto L7;
        Bitmap r12 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), r11);
        Intrinsics.checkNotNullExpressionValue(r12, "createBitmap(width, height, config)");
        Canvas r13 = new Canvas(r12);
        r13.translate(-r10.getScrollX(), -r10.getScrollY());
        r10.draw(r13);
        return r12;
    L7:
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View r10, Bitmap.Config r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = Bitmap.Config.ARGB_8888;
    L6:
        return drawToBitmap(r10, r11);
    }

    public static final Sequence<View> getAllViews(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.sequence(new ViewKt$allViews$1(r10, null));
    }

    public static final Sequence<ViewParent> getAncestors(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.generateSequence(r10.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        if (r12 != null) goto L10;
        return 0;
    L10:
        return r12.bottomMargin;
    L5:
        r12 = null;
        goto L6
    }

    public static final int getMarginEnd(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r11);
    }

    public static final int getMarginLeft(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        if (r12 != null) goto L10;
        return 0;
    L10:
        return r12.leftMargin;
    L5:
        r12 = null;
        goto L6
    }

    public static final int getMarginRight(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        if (r12 != null) goto L10;
        return 0;
    L10:
        return r12.rightMargin;
    L5:
        r12 = null;
        goto L6
    }

    public static final int getMarginStart(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r11);
    }

    public static final int getMarginTop(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        if (r12 != null) goto L10;
        return 0;
    L10:
        return r12.topMargin;
    L5:
        r12 = null;
        goto L6
    }

    public static final boolean isGone(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isInvisible(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getVisibility() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isVisible(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Runnable postDelayed(View r10, long r11, final Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        Runnable r13 = new ViewKt$postDelayed$runnable$1(r12);
        r10.postDelayed(r13, r11);
        return r13;
    }

    @RequiresApi(16)
    public static final Runnable postOnAnimationDelayed(View r10, long r11, final Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        Runnable r13 = new h(r12);
        Api16Impl.postOnAnimationDelayed(r10, r13, r11);
        return r13;
    }

    private static final void postOnAnimationDelayed$lambda$1(Function0 r10) {
        Intrinsics.checkNotNullParameter(r10, "$action");
        r10.invoke();
    }

    public static final void setGone(View r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 == false) goto L5;
        int r12 = 8;
    L6:
        r10.setVisibility(r12);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public static final void setInvisible(View r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 == false) goto L5;
        int r12 = 4;
    L6:
        r10.setVisibility(r12);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public static final void setPadding(View r10, @Px int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setPadding(r11, r11, r11, r11);
    }

    public static final void setVisible(View r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 == false) goto L5;
        int r12 = 0;
    L6:
        r10.setVisibility(r12);
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public static final void updateLayoutParams(View r10, Function1<? super ViewGroup.LayoutParams, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r11.invoke(r12);
        r10.setLayoutParams(r12);
    }

    @JvmName(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View r10, Function1<? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, "T");
        r11.invoke(r12);
        r10.setLayoutParams(r12);
    }

    public static final void updatePadding(View r10, @Px int r11, @Px int r12, @Px int r13, @Px int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setPadding(r11, r12, r13, r14);
    }

    public static /* synthetic */ void updatePadding$default(View r10, int r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.getPaddingLeft();
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.getPaddingTop();
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.getPaddingRight();
    L12:
        if ((r15 & 8) == 0) goto L14;
        r14 = r10.getPaddingBottom();
    L14:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setPadding(r11, r12, r13, r14);
    }

    @RequiresApi(17)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void updatePaddingRelative(View r10, @Px int r11, @Px int r12, @Px int r13, @Px int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setPaddingRelative(r11, r12, r13, r14);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View r10, int r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.getPaddingStart();
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.getPaddingTop();
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.getPaddingEnd();
    L12:
        if ((r15 & 8) == 0) goto L14;
        r14 = r10.getPaddingBottom();
    L14:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setPaddingRelative(r11, r12, r13, r14);
    }
}
