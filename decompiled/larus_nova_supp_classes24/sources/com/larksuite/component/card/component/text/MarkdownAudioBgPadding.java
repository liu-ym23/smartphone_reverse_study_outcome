package com.larksuite.component.card.component.text;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/card/component/text/MarkdownAudioBgPadding;", "", "top", "", "right", "bottom", "left", "<init>", "(IIII)V", "getTop", "()I", "setTop", "(I)V", "getRight", "setRight", "getBottom", "setBottom", "getLeft", "setLeft", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MarkdownAudioBgPadding {
    private int bottom;
    private int left;
    private int right;
    private int top;

    public MarkdownAudioBgPadding() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ MarkdownAudioBgPadding copy$default(MarkdownAudioBgPadding r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.top;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.right;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.bottom;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.left;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.top;
    }

    public final int component2() {
        return this.right;
    }

    public final int component3() {
        return this.bottom;
    }

    public final int component4() {
        return this.left;
    }

    public final MarkdownAudioBgPadding copy(int r2, int r3, int r4, int r5) {
        return new MarkdownAudioBgPadding(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MarkdownAudioBgPadding) == true) goto L8;
        return false;
    L8:
        MarkdownAudioBgPadding r6 = (MarkdownAudioBgPadding) r5;
        if (this.top == r6.top) goto L12;
        return false;
    L12:
        if (this.right == r6.right) goto L15;
        return false;
    L15:
        if (this.bottom == r6.bottom) goto L18;
        return false;
    L18:
        if (this.left == r6.left) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.top * 31) + this.right) * 31) + this.bottom) * 31) + this.left;
    }

    public String toString() {
        return "MarkdownAudioBgPadding(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ')';
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final void setBottom(int r1) {
        this.bottom = r1;
    }

    public final void setLeft(int r1) {
        this.left = r1;
    }

    public final void setRight(int r1) {
        this.right = r1;
    }

    public final void setTop(int r1) {
        this.top = r1;
    }

    public MarkdownAudioBgPadding(int r1, int r2, int r3, int r4) {
        this.top = r1;
        this.right = r2;
        this.bottom = r3;
        this.left = r4;
    }

    public /* synthetic */ MarkdownAudioBgPadding(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }
}
