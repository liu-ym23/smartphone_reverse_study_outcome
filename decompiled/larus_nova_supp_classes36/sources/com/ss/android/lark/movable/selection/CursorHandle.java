package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.lark.lark_markdown_render_android.FfiCaret;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0014J \u0010 \u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u000f\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\b\u0010(\u001a\u00020\u001aH\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020+H\u0016J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\bJ\u0010\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00060"}, d2 = {"Lcom/ss/android/lark/movable/selection/CursorHandle;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/ss/android/lark/movable/selection/IHandle;", "context", "Landroid/content/Context;", "handleType", "Lcom/ss/android/lark/movable/selection/HandleType;", "handleColor", "", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/movable/selection/HandleType;I)V", "caretInfo", "Lcom/bytedance/lark/lark_markdown_render_android/FfiCaret;", "isGhost", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "handleStyle", "Lcom/ss/android/lark/movable/selection/HandleStyle;", "getHandleStyle", "()Lcom/ss/android/lark/movable/selection/HandleStyle;", "setHandleStyle", "(Lcom/ss/android/lark/movable/selection/HandleStyle;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updatePositionAndSize", "offset", "Landroid/graphics/Point;", "containerOffset", "getCaretId", "Lkotlin/UInt;", "getCaretId-pVg5ArA", "()I", "onCleared", "setIsGhost", "getVisibleInsets", "Landroid/graphics/Rect;", "setHandleColor", "color", "dpToPx", "dp", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CursorHandle extends AppCompatImageView implements d {
    public final HandleType a;
    public FfiCaret b;
    public boolean c;
    public HandleStyle d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.movable.selection.d
    public View getView() {
        return this;
    }

    @Override // com.ss.android.lark.movable.selection.d
    public final void onCleared() {
        this.b = null;
    }

    @Override // com.ss.android.lark.movable.selection.d
    /* JADX INFO: renamed from: getCaretId-pVg5ArA, reason: not valid java name */
    public int mo1477getCaretIdpVg5ArA() {
        FfiCaret r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getUuid-pVg5ArA();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.movable.selection.d
    public Rect getVisibleInsets() {
        return new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    public HandleStyle getHandleStyle() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int j(int r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.c == false) goto L5;
        return;
    L5:
        super/*android.widget.ImageView*/.onDraw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setHandleColor(int r3) {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L7;
        Drawable r1 = r0.mutate();
        if (r1 == null) goto L7;
        r1.setTint(r3);
    L7:
        setImageDrawable(r0);
    }

    public void setHandleStyle(HandleStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    @Override // com.ss.android.lark.movable.selection.d
    public void setIsGhost(boolean r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r3, int r4) {
        Drawable r5 = getDrawable();
        int r6 = 0;
        if (r5 == null) goto L5;
        int r0 = r5.getIntrinsicWidth();
    L6:
        int r1 = (r0 + getPaddingLeft()) + getPaddingRight();
        if (r5 == null) goto L9;
        r6 = r5.getIntrinsicHeight();
    L9:
        setMeasuredDimension(r1, (r6 + getPaddingTop()) + getPaddingBottom());
        return;
    L5:
        r0 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CursorHandle(Context r4, HandleType r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "handleType");
        super(r4);
        this.a = r5;
        this.d = HandleStyle.NORMAL;
        HandleType r0 = HandleType.START;
        if (r5 != r0) goto L5;
        int r1 = 2131244009;
    L6:
        Drawable r7 = ContextCompat.getDrawable(r4, r1);
        if (r7 == null) goto L11;
        Drawable r2 = r7.mutate();
        if (r2 == null) goto L11;
        r2.setTint(r6);
    L11:
        setImageDrawable(r7);
        int r8 = j(2);
        int r9 = j(10);
        int r3 = j(4);
        int r10 = j(12);
        if (r5 != r0) goto L14;
        setPadding(r9, r3, r8, r10);
    L15:
        setHasTransientState(true);
        return;
    L14:
        setPadding(r8, r3, r9, r10);
        goto L15
    L5:
        r1 = 2131244010;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.movable.selection.d
    public final void g(FfiCaret r4, Point r5, Point r6) {
        Intrinsics.checkNotNullParameter(r4, "caretInfo");
        Intrinsics.checkNotNullParameter(r5, "offset");
        Intrinsics.checkNotNullParameter(r6, "containerOffset");
        this.b = r4;
        if (getMeasuredWidth() != 0) goto L5;
    L6:
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L7:
        float r0 = r4.getX();
        float r1 = r4.getY() + (r4.getHeight() / 2.0f);
        if (this.a != HandleType.START) goto L10;
        int r7 = getMeasuredWidth() - getPaddingRight();
    L11:
        float r2 = getPaddingTop();
        setX(((r0 - r7) - r5.x) + r6.x);
        setY(((r1 - r2) - r5.y) + r6.y);
        ViewGroup.LayoutParams r8 = getLayoutParams();
        if (r8 == null) goto L16;
        r8.width = getMeasuredWidth();
        r8.height = getMeasuredHeight();
        setLayoutParams(r8);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L10:
        r7 = getPaddingLeft();
        goto L11
    L5:
        if (getMeasuredHeight() != 0) goto L7;
        goto L6
    }
}
