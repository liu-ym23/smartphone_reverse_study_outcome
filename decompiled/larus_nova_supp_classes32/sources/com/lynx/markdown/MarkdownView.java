package com.lynx.markdown;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class MarkdownView extends ViewGroup implements IMarkdownViewHandle {
    @Override // com.lynx.markdown.IMarkdownViewHandle
    public int getVerticalAlign() {
        return 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public long getPosition() {
        return i.a(getLeft(), getTop());
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public long getSize() {
        return i.a(getWidth(), getHeight());
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void requestAlign() {
        requestLayout();
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void requestDraw() {
        invalidate();
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void requestMeasure() {
        requestLayout();
    }

    public MarkdownView(Context r1) {
        super(r1);
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void setVisibility(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        super.setVisibility(r2);
        return;
    L4:
        r2 = 4;
        goto L5
    }

    public MarkdownView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public static int getMeasureSpec(int r1, int r2) {
        if (r2 != 1) goto L5;
        int r3 = 1073741824;
    L10:
        return View.MeasureSpec.makeMeasureSpec(r1, r3);
    L5:
        if (r2 == 2) goto L7;
        r3 = 0;
        goto L10
    L7:
        r3 = Integer.MIN_VALUE;
        goto L10
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void align(int r3, int r4) {
        int r0 = getMeasuredWidth();
        layout(r3, r4, r0 + r3, getMeasuredHeight() + r4);
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        setMeasuredDimension(ViewGroup.resolveSize(0, r2), ViewGroup.resolveSize(0, r3));
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void setPosition(int r3, int r4) {
        int r0 = getWidth();
        int r1 = getHeight();
        setLeft(r3);
        setTop(r4);
        setRight(r3 + r0);
        setBottom(r4 + r1);
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void setSize(int r2, int r3) {
        setRight(getLeft() + r2);
        setBottom(getTop() + r3);
    }

    public MarkdownView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public long measure(int r6, int r7, int r8, int r9) {
        int r0 = 0;
        if (r7 == 1) goto L7;
        if (r7 == 2) goto L6;
        int r10 = 0;
    L8:
        int r11 = getMeasureSpec(r6, r10);
        if (r9 == 1) goto L13;
        if (r9 != 2) goto L14;
        r0 = Integer.MIN_VALUE;
    L14:
        measure(r11, getMeasureSpec(r8, r0));
        int r12 = getMeasuredWidth();
        int r13 = getMeasuredHeight();
        int r14 = getBaseline();
        if (r14 >= 0) goto L18;
        r14 = r13;
    L18:
        return i.b(r12, r13, r14);
    L13:
        r0 = 1073741824;
        goto L14
    L6:
        r10 = Integer.MIN_VALUE;
        goto L8
    L7:
        r10 = 1073741824;
        goto L8
    }
}
