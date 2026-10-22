package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a2\u0010 \u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010'\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010(\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010)\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010*\u001a\u00020+*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a\u0014\u0010,\u001a\u00020-*\u00020\u00022\b\b\u0002\u0010.\u001a\u00020/\u001a%\u00100\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\u000e\b\u0004\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04H\u0086\b\u001a \u00105\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04\u001a\u0017\u00106\u001a\u00020!*\u00020\u00022\b\b\u0001\u00107\u001a\u00020\u0013H\u0086\b\u001a7\u00108\u001a\u00020!\"\n\b\u0000\u00109\u0018\u0001*\u00020:*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b<H\u0087\b¢\u0006\u0002\b=\u001a&\u00108\u001a\u00020!*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b<H\u0086\b\u001a5\u0010>\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010?\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010A\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0086\b\u001a5\u0010C\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010D\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010E\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0086\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"*\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"*\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r\"*\u0010\u0010\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\"\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\"\u0016\u0010\u0018\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\"\u0016\u0010\u001a\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\"\u0016\u0010\u001c\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015\"\u0016\u0010\u001e\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015¨\u0006F"}, d2 = {"allViews", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "getAllViews", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "ancestors", "Landroid/view/ViewParent;", "getAncestors", "value", "", "isGone", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "marginBottom", "", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", "marginLeft", "getMarginLeft", "marginRight", "getMarginRight", "marginStart", "getMarginStart", "marginTop", "getMarginTop", "doOnAttach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnDetach", "doOnLayout", "doOnNextLayout", "doOnPreDraw", "Landroidx/core/view/OneShotPreDrawListener;", "drawToBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "setPadding", "size", "updateLayoutParams", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/ExtensionFunctionType;", "updateLayoutParamsTyped", "updatePadding", OpenPageMethod.ALIGN_LEFT, "top", "right", "bottom", "updatePaddingRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,414:1\n37#1:415\n53#1:416\n326#1,4:420\n43#2,3:417\n*S KotlinDebug\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n*L\n68#1:415\n68#1:416\n310#1:420,4\n232#1:417,3\n*E\n"})
public final class ViewKt {
    public static /* synthetic */ void a(Function0 r5) {
        postOnAnimationDelayed$lambda$1(r5);
    }

    public static final void doOnAttach(final View r5, final Function1<? super View, Unit> r10) {
        if (r5.isAttachedToWindow() == false) goto L5;
        r10.invoke(r5);
        return;
    L5:
        r5.addOnAttachStateChangeListener(new AnonymousClass1(r5, r10));
    }

    public static final void doOnDetach(final View r5, final Function1<? super View, Unit> r10) {
        if (r5.isAttachedToWindow() == true) goto L5;
        r10.invoke(r5);
        return;
    L5:
        r5.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC00791(r5, r10));
    }

    public static final void doOnLayout(View r5, final Function1<? super View, Unit> r10) {
        if (r5.isLaidOut() == true) goto L5;
    L7:
        r5.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(r10));
        return;
    L5:
        if (r5.isLayoutRequested() == true) goto L7;
        r10.invoke(r5);
    }

    public static final void doOnNextLayout(View r5, final Function1<? super View, Unit> r10) {
        r5.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC00801(r10));
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View r5, final Function1<? super View, Unit> r10) {
        return OneShotPreDrawListener.add(r5, new RunnableC00811(r10, r5));
    }

    public static final Bitmap drawToBitmap(View r5, Bitmap.Config r10) {
        if (r5.isLaidOut() == false) goto L7;
        Bitmap r11 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), r10);
        Canvas r12 = new Canvas(r11);
        r12.translate(-r5.getScrollX(), -r5.getScrollY());
        r5.draw(r12);
        return r11;
    L7:
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View r5, Bitmap.Config r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = Bitmap.Config.ARGB_8888;
    L6:
        return drawToBitmap(r5, r10);
    }

    public static final Sequence<View> getAllViews(View r5) {
        return SequencesKt.sequence(new ViewKt$allViews$1(r5, null));
    }

    public static final Sequence<ViewParent> getAncestors(View r5) {
        return SequencesKt.generateSequence(r5.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(View r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L6:
        if (r11 != null) goto L10;
        return 0;
    L10:
        return r11.bottomMargin;
    L5:
        r11 = null;
        goto L6
    }

    public static final int getMarginEnd(View r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return ((ViewGroup.MarginLayoutParams) r10).getMarginEnd();
    }

    public static final int getMarginLeft(View r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L6:
        if (r11 != null) goto L10;
        return 0;
    L10:
        return r11.leftMargin;
    L5:
        r11 = null;
        goto L6
    }

    public static final int getMarginRight(View r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L6:
        if (r11 != null) goto L10;
        return 0;
    L10:
        return r11.rightMargin;
    L5:
        r11 = null;
        goto L6
    }

    public static final int getMarginStart(View r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return ((ViewGroup.MarginLayoutParams) r10).getMarginStart();
    }

    public static final int getMarginTop(View r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L6:
        if (r11 != null) goto L10;
        return 0;
    L10:
        return r11.topMargin;
    L5:
        r11 = null;
        goto L6
    }

    public static final boolean isGone(View r5) {
        if (r5.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isInvisible(View r5) {
        if (r5.getVisibility() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isVisible(View r5) {
        if (r5.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Runnable postDelayed(View r5, long r10, final Function0<Unit> r11) {
        Runnable r12 = new ViewKt$postDelayed$runnable$1(r11);
        r5.postDelayed(r12, r10);
        return r12;
    }

    public static final Runnable postOnAnimationDelayed(View r5, long r10, Function0<Unit> r11) {
        g r12 = new g(r11, 1);
        r5.postOnAnimationDelayed(r12, r10);
        return r12;
    }

    private static final void postOnAnimationDelayed$lambda$1(Function0 r5) {
        r5.invoke();
    }

    public static final void setGone(View r5, boolean r10) {
        if (r10 == false) goto L4;
        int r11 = 8;
    L5:
        r5.setVisibility(r11);
        return;
    L4:
        r11 = 0;
        goto L5
    }

    public static final void setInvisible(View r5, boolean r10) {
        if (r10 == false) goto L4;
        int r11 = 4;
    L5:
        r5.setVisibility(r11);
        return;
    L4:
        r11 = 0;
        goto L5
    }

    public static final void setPadding(View r5, @Px int r10) {
        r5.setPadding(r10, r10, r10, r10);
    }

    public static final void setVisible(View r5, boolean r10) {
        if (r10 == false) goto L4;
        int r11 = 0;
    L5:
        r5.setVisibility(r11);
        return;
    L4:
        r11 = 8;
        goto L5
    }

    public static final void updateLayoutParams(View r5, Function1<? super ViewGroup.LayoutParams, Unit> r10) {
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        if (r11 == null) goto L7;
        r10.invoke(r11);
        r5.setLayoutParams(r11);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmName(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View r5, Function1<? super T, Unit> r10) {
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        r10.invoke(r11);
        r5.setLayoutParams(r11);
    }

    public static final void updatePadding(View r5, @Px int r10, @Px int r11, @Px int r12, @Px int r13) {
        r5.setPadding(r10, r11, r12, r13);
    }

    public static /* synthetic */ void updatePadding$default(View r5, int r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.getPaddingLeft();
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.getPaddingTop();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.getPaddingRight();
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = r5.getPaddingBottom();
    L14:
        r5.setPadding(r10, r11, r12, r13);
    }

    public static final void updatePaddingRelative(View r5, @Px int r10, @Px int r11, @Px int r12, @Px int r13) {
        r5.setPaddingRelative(r10, r11, r12, r13);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View r5, int r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.getPaddingStart();
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.getPaddingTop();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.getPaddingEnd();
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = r5.getPaddingBottom();
    L14:
        r5.setPaddingRelative(r10, r11, r12, r13);
    }
}
