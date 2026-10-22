package com.lynx.markdown;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a extends MarkdownView {
    long mDrawable;
    protected h mResourceManager;

    @Override // com.lynx.markdown.MarkdownView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    public long getDrawable() {
        return this.mDrawable;
    }

    public a(Context r3) {
        super(r3);
        this.mDrawable = 0;
        this.mResourceManager = null;
        setWillNotDraw(false);
    }

    public void attachDrawable(long r1) {
        this.mDrawable = r1;
    }

    @Override // android.view.View
    public void onDraw(Canvas r4) {
        super.onDraw(r4);
        CustomDrawable.a(this.mDrawable, r4, this.mResourceManager);
    }

    @Override // com.lynx.markdown.MarkdownView, com.lynx.markdown.IMarkdownViewHandle
    public void align(int r4, int r5) {
        super.align(r4, r5);
        long r6 = this.mDrawable;
        if (r6 == 0) goto L6;
        CustomDrawable.align(r6, getLeft(), getTop());
        return;
    }

    @Override // com.lynx.markdown.MarkdownView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r0 = View.MeasureSpec.getSize(r10);
        int r12 = View.MeasureSpec.getMode(r10);
        int r1 = View.MeasureSpec.getSize(r11);
        int r13 = View.MeasureSpec.getMode(r11);
        long r2 = this.mDrawable;
        float r4 = r0;
        int r7 = 2;
        if (r12 == Integer.MIN_VALUE) goto L7;
        if (r12 == 1073741824) goto L6;
        int r14 = 0;
    L8:
        float r3 = r1;
        if (r13 == Integer.MIN_VALUE) goto L13;
        if (r13 == 1073741824) goto L12;
        r7 = 0;
        goto L13
    L12:
        r7 = 1;
    L13:
        long r15 = CustomDrawable.measure(r2, r4, r14, r3, r7);
        setMeasuredDimension((int) (r15 >>> 32), (int) (r15 & 4294967295L));
        invalidate();
        return;
    L6:
        r14 = 1;
        goto L8
    L7:
        r14 = 2;
        goto L8
    }
}
