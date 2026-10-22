package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.lark.lark_markdown_render_android.FfiCaret;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends View implements d {
    public final HandleType a;
    public final Paint b;
    public final float c;
    public final float d;
    public FfiCaret e;
    public boolean f;
    public HandleStyle g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.movable.selection.d
    public View getView() {
        return this;
    }

    @Override // com.ss.android.lark.movable.selection.d
    public final void onCleared() {
        this.e = null;
    }

    @Override // com.ss.android.lark.movable.selection.d
    /* JADX INFO: renamed from: getCaretId-pVg5ArA */
    public int mo1477getCaretIdpVg5ArA() {
        FfiCaret r0 = this.e;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getUuid-pVg5ArA();
    }

    @Override // com.ss.android.lark.movable.selection.d
    public Rect getVisibleInsets() {
        return new Rect(getView().getPaddingStart(), getView().getPaddingTop(), getView().getPaddingEnd(), getView().getPaddingBottom());
    }

    public HandleStyle getHandleStyle() {
        return this.g;
    }

    public final float a(int r3) {
        Resources r0 = getResources();
        return r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        if (this.f == false) goto L5;
        return;
    L5:
        super.onDraw(r13);
        float r0 = getWidth();
        float r1 = getHeight();
        float r9 = a(2);
        float r2 = this.c;
        float r4 = (r0 - r2) / 2.0f;
        r13.drawRoundRect(r4, getPaddingTop(), r4 + r2, r1 - getPaddingBottom(), r9, r9, this.b);
        float r3 = r0 / 2.0f;
        if (this.a != HandleType.START) goto L8;
        float r5 = this.d + getPaddingTop();
    L9:
        r13.drawCircle(r3, r5, this.d, this.b);
        return;
    L8:
        r5 = (r1 - this.d) - getPaddingBottom();
        goto L9
    }

    public void setHandleStyle(HandleStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    @Override // com.ss.android.lark.movable.selection.d
    public void setIsGhost(boolean r1) {
        this.f = r1;
    }

    public e(Context r2, HandleType r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "handleType");
        super(r2);
        this.a = r3;
        Paint r4 = new Paint(1);
        r4.setColor(UIUtils.getColor(r2, 2131105548));
        r4.setStyle(Paint.Style.FILL);
        this.b = r4;
        this.c = a(2);
        this.d = a(10) / 2;
        this.g = HandleStyle.LINE;
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        setMeasuredDimension((int) (((this.d * 2) + getPaddingStart()) + getPaddingEnd()), (View.MeasureSpec.getSize(r3) + getPaddingTop()) + getPaddingBottom());
    }

    @Override // com.ss.android.lark.movable.selection.d
    public final void g(FfiCaret r5, Point r6, Point r7) {
        Intrinsics.checkNotNullParameter(r5, "caretInfo");
        Intrinsics.checkNotNullParameter(r6, "offset");
        Intrinsics.checkNotNullParameter(r7, "containerOffset");
        this.e = r5;
        setX((((r5.getX() - this.d) - getPaddingStart()) - r6.x) + r7.x);
        if (r5.getDirection() == false) goto L5;
        float r0 = (r5.getY() - getPaddingTop()) - r6.y;
        int r8 = r7.y;
    L6:
        setY(r0 + r8);
        ViewGroup.LayoutParams r9 = getLayoutParams();
        if (r9 == null) goto L11;
        r9.height = (int) (r5.getHeight() + (this.d * 2));
        setLayoutParams(r9);
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getLayoutParams().height, 1073741824));
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L5:
        r0 = ((r5.getY() - (this.d * 2)) - getPaddingTop()) - r6.y;
        r8 = r7.y;
        goto L6
    }
}
