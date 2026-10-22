package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a2\u0010 \u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010'\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010(\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010)\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010*\u001a\u00020+*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a\u0014\u0010,\u001a\u00020-*\u00020\u00022\b\b\u0002\u0010.\u001a\u00020/\u001a%\u00100\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\u000e\b\u0004\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04H\u0086\b\u001a\"\u00105\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04H\u0007\u001a\u0017\u00106\u001a\u00020!*\u00020\u00022\b\b\u0001\u00107\u001a\u00020\u0013H\u0086\b\u001a7\u00108\u001a\u00020!\"\n\b\u0000\u00109\u0018\u0001*\u00020:*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b<H\u0087\b¢\u0006\u0002\b=\u001a&\u00108\u001a\u00020!*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b<H\u0086\b\u001a5\u0010>\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010?\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010A\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0086\b\u001a5\u0010C\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010D\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010E\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"*\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"*\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r\"*\u0010\u0010\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\"\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\"\u0016\u0010\u0018\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\"\u0016\u0010\u001a\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\"\u0016\u0010\u001c\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015\"\u0016\u0010\u001e\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015¨\u0006F"}, d2 = {"allViews", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "getAllViews", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "ancestors", "Landroid/view/ViewParent;", "getAncestors", EventBody.KEY_VALUE, "", "isGone", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "marginBottom", "", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", "marginLeft", "getMarginLeft", "marginRight", "getMarginRight", "marginStart", "getMarginStart", "marginTop", "getMarginTop", "doOnAttach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "view", "doOnDetach", "doOnLayout", "doOnNextLayout", "doOnPreDraw", "Landroidx/core/view/OneShotPreDrawListener;", "drawToBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "setPadding", "size", "updateLayoutParams", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/ExtensionFunctionType;", "updateLayoutParamsTyped", "updatePadding", "left", "top", "right", "bottom", "updatePaddingRelative", CommonConsts.APM_INNER_EVENT_COST_START, "end", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewKt {
    public static final void doOnAttach(final View r2, Function1<? super View, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isAttachedToWindow(r2) == false) goto L5;
        r4.invoke(r2);
        return;
    L5:
        r2.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, r4), View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
    }

    public static final void doOnDetach(final View r2, Function1<? super View, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isAttachedToWindow(r2) == true) goto L5;
        r4.invoke(r2);
        return;
    L5:
        r2.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(new ViewOnAttachStateChangeListenerC09261(r2, r4), View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
    }

    public static final void doOnLayout(View r2, Function1<? super View, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isLaidOut(r2) == true) goto L5;
    L7:
        r2.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(r4), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r2.isLayoutRequested() == true) goto L7;
        r4.invoke(r2);
    }

    public static final void doOnNextLayout(View r2, Function1<? super View, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        r2.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new ViewOnLayoutChangeListenerC09271(r4), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View r2, Function1<? super View, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        return OneShotPreDrawListener.add(r2, (Runnable) ZeusTransformUtils.preCheckCast(new RunnableC09281(r4, r2), Runnable.class, "com.obric.memorydata.plugin"));
    }

    public static final Bitmap drawToBitmap(View r3, Bitmap.Config r4) {
        if (ViewCompat.isLaidOut(r3) == false) goto L7;
        Bitmap r5 = Bitmap.createBitmap(r3.getWidth(), r3.getHeight(), r4);
        Canvas r0 = new Canvas(r5);
        r0.translate(-r3.getScrollX(), -r3.getScrollY());
        r3.draw(r0);
        return r5;
    L7:
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View r0, Bitmap.Config r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Bitmap.Config.ARGB_8888;
    L6:
        return drawToBitmap(r0, r1);
    }

    public static final Sequence<View> getAllViews(View r2) {
        return SequencesKt.sequence((Function2) ZeusTransformUtils.preCheckCast(new ViewKt$allViews$1(r2, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final Sequence<ViewParent> getAncestors(View r3) {
        return SequencesKt.generateSequence(r3.getParent(), (Function1) ZeusTransformUtils.preCheckCast(ViewKt$ancestors$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
    }

    public static final int getMarginBottom(View r2) {
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L10;
        return 0;
    L10:
        return r4.bottomMargin;
    L5:
        r4 = null;
        goto L6
    }

    public static final int getMarginEnd(View r2) {
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == true) goto L7;
        return 0;
    L7:
        return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    }

    public static final int getMarginLeft(View r2) {
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L10;
        return 0;
    L10:
        return r4.leftMargin;
    L5:
        r4 = null;
        goto L6
    }

    public static final int getMarginRight(View r2) {
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L10;
        return 0;
    L10:
        return r4.rightMargin;
    L5:
        r4 = null;
        goto L6
    }

    public static final int getMarginStart(View r2) {
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == true) goto L7;
        return 0;
    L7:
        return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    }

    public static final int getMarginTop(View r2) {
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L10;
        return 0;
    L10:
        return r4.topMargin;
    L5:
        r4 = null;
        goto L6
    }

    public static final boolean isGone(View r1) {
        if (r1.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isInvisible(View r1) {
        if (r1.getVisibility() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isVisible(View r0) {
        if (r0.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void lambda$3IvyLuEauArsUXsbd_efkmajCrs(Function0 r0) {
        postOnAnimationDelayed$lambda$1(r0);
    }

    public static final Runnable postDelayed(View r2, long r3, Function0<Unit> r5) {
        final Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.preCheckCast(new ViewKt$postDelayed$runnable$1(r6), Runnable.class, "com.obric.memorydata.plugin");
        r2.postDelayed(r7, r3);
        return r7;
    }

    public static final Runnable postOnAnimationDelayed(View r2, long r3, Function0<Unit> r5) {
        final Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Runnable r0 = new $$Lambda$ViewKt$3IvyLuEauArsUXsbd_efkmajCrs(r6);
        Api16Impl.postOnAnimationDelayed(r2, r0, r3);
        return r0;
    }

    private static final void postOnAnimationDelayed$lambda$1(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    public static final void setGone(View r0, boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 8;
    L5:
        r0.setVisibility(r2);
        return;
    L4:
        r2 = 0;
        goto L5
    }

    public static final void setInvisible(View r0, boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 4;
    L5:
        r0.setVisibility(r2);
        return;
    L4:
        r2 = 0;
        goto L5
    }

    public static final void setPadding(View r0, int r1) {
        r0.setPadding(r1, r1, r1, r1);
    }

    public static final void setVisible(View r0, boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        r0.setVisibility(r2);
        return;
    L4:
        r2 = 8;
        goto L5
    }

    public static final void updateLayoutParams(View r2, Function1<? super ViewGroup.LayoutParams, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r4.invoke(r0);
        r2.setLayoutParams(r0);
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View r4, Function1<? super T, Unit> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        r6.invoke(r1);
        r4.setLayoutParams(r1);
    }

    public static final void updatePadding(View r0, int r1, int r2, int r3, int r4) {
        r0.setPadding(r1, r2, r3, r4);
    }

    public static /* synthetic */ void updatePadding$default(View r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.getPaddingLeft();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.getPaddingTop();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.getPaddingRight();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = r0.getPaddingBottom();
    L14:
        r0.setPadding(r1, r2, r3, r4);
    }

    public static final void updatePaddingRelative(View r0, int r1, int r2, int r3, int r4) {
        r0.setPaddingRelative(r1, r2, r3, r4);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.getPaddingStart();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.getPaddingTop();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.getPaddingEnd();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = r0.getPaddingBottom();
    L14:
        r0.setPaddingRelative(r1, r2, r3, r4);
    }
}
