package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J6\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0014R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\""}, d2 = {"Lcom/obric/oui/forms/OFormEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "leftFading", "topFading", "rightFading", "bottomFading", "", "fadingLength", "", "setTextFading", "", "getLeftFadingEdgeStrength", "getRightFadingEdgeStrength", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "isLeftFading", "Z", "()Z", "setLeftFading", "(Z)V", "isTopFading", "setTopFading", "isRightFading", "setRightFading", "isBottomFading", "setBottomFading", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OFormEditText extends AppCompatEditText {
    private boolean isBottomFading;
    private boolean isLeftFading;
    private boolean isRightFading;
    private boolean isTopFading;

    @JvmOverloads
    public OFormEditText(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OFormEditText(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OFormEditText(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ OFormEditText(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static /* synthetic */ void setTextFading$default(OFormEditText r10, boolean r11, boolean r12, boolean r13, boolean r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        boolean r18 = false;
    L7:
        if ((r16 & 2) == 0) goto L9;
        boolean r19 = false;
    L11:
        if ((r16 & 4) == 0) goto L13;
        boolean r20 = false;
    L15:
        if ((r16 & 8) == 0) goto L17;
        boolean r21 = false;
    L18:
        r10.setTextFading(r18, r19, r20, r21, r15);
        return;
    L17:
        r21 = r14;
        goto L18
    L13:
        r20 = r13;
        goto L15
    L9:
        r19 = r12;
        goto L11
    L5:
        r18 = r11;
        goto L7
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (this.isBottomFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    protected float getLeftFadingEdgeStrength() {
        if (this.isLeftFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    protected float getRightFadingEdgeStrength() {
        if (this.isRightFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (this.isTopFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    public final boolean isBottomFading() {
        return this.isBottomFading;
    }

    public final boolean isLeftFading() {
        return this.isLeftFading;
    }

    public final boolean isRightFading() {
        return this.isRightFading;
    }

    public final boolean isTopFading() {
        return this.isTopFading;
    }

    public final void setBottomFading(boolean r10) {
        this.isBottomFading = r10;
    }

    public final void setLeftFading(boolean r10) {
        this.isLeftFading = r10;
    }

    public final void setRightFading(boolean r10) {
        this.isRightFading = r10;
    }

    public final void setTextFading(boolean r10, boolean r11, boolean r12, boolean r13, int r14) {
        setFadingEdgeLength(r14);
        this.isLeftFading = r10;
        this.isTopFading = r11;
        this.isRightFading = r12;
        this.isBottomFading = r13;
        boolean r15 = false;
        if (r10 == true) goto L7;
        if (r12 == true) goto L7;
        boolean r16 = false;
    L8:
        setHorizontalFadingEdgeEnabled(r16);
        if (this.isTopFading == false) goto L11;
    L12:
        r15 = true;
    L13:
        setVerticalFadingEdgeEnabled(r15);
        return;
    L11:
        if (this.isBottomFading == false) goto L13;
    L7:
        r16 = true;
        goto L8
    }

    public final void setTopFading(boolean r10) {
        this.isTopFading = r10;
    }
}
