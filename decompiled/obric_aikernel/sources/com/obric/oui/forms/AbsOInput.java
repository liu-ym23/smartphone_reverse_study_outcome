package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ6\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u000bH$J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006 "}, d2 = {"Lcom/obric/oui/forms/AbsOInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "leftFading", "topFading", "rightFading", "bottomFading", "", "fadingLength", "", "setTextFading", "Landroid/widget/EditText;", "getInterEditText", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "", "lastScrollY", "F", "isInScrollView", "Z", "()Z", "setInScrollView", "(Z)V", "lastScrollX", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsOInput extends ConstraintLayout {
    private boolean isInScrollView;
    private float lastScrollX;
    private float lastScrollY;

    @JvmOverloads
    public AbsOInput(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public AbsOInput(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public AbsOInput(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ AbsOInput(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static /* synthetic */ void setTextFading$default(AbsOInput r10, boolean r11, boolean r12, boolean r13, boolean r14, int r15, int r16, Object r17) {
        if (r17 != null) goto L22;
        if ((r16 & 1) == 0) goto L6;
        boolean r18 = false;
    L8:
        if ((r16 & 2) == 0) goto L10;
        boolean r19 = false;
    L12:
        if ((r16 & 4) == 0) goto L14;
        boolean r20 = false;
    L16:
        if ((r16 & 8) == 0) goto L18;
        boolean r21 = false;
    L19:
        r10.setTextFading(r18, r19, r20, r21, r15);
        return;
    L18:
        r21 = r14;
        goto L19
    L14:
        r20 = r13;
        goto L16
    L10:
        r19 = r12;
        goto L12
    L6:
        r18 = r11;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTextFading");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L36;
        if (this.isInScrollView == false) goto L36;
        float r11 = r10.getX();
        float r12 = r10.getY();
        int r13 = r10.getAction();
        if (r13 != 0) goto L8;
        this.lastScrollY = r11;
    L34:
        this.lastScrollY = r12;
        goto L36
    L8:
        if (r13 != 1) goto L10;
    L32:
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r13 != 2) goto L12;
        EditText r14 = getInterEditText();
        if (r11 <= this.lastScrollX) goto L19;
        if (r14.canScrollHorizontally(-1) == false) goto L19;
    L30:
        super.requestDisallowInterceptTouchEvent(true);
    L31:
        this.lastScrollX = r11;
    L19:
        if (r11 >= this.lastScrollX) goto L23;
        if (r14.canScrollHorizontally(1) == true) goto L30;
    L23:
        if (r12 >= this.lastScrollY) goto L27;
        if (r14.canScrollVertically(1) == true) goto L30;
    L27:
        if (r12 <= this.lastScrollY) goto L31;
        if (r14.canScrollVertically(-1) == false) goto L31;
    L12:
        if (r13 == 3) goto L32;
    L36:
        return super.dispatchTouchEvent(r10);
    }

    protected abstract EditText getInterEditText();

    public final boolean isInScrollView() {
        return this.isInScrollView;
    }

    public final void setInScrollView(boolean r10) {
        this.isInScrollView = r10;
    }

    public final void setTextFading(boolean r10, boolean r11, boolean r12, boolean r13, int r14) {
        EditText r15 = getInterEditText();
        if ((r15 instanceof OEditText) == false) goto L5;
        ((OEditText) r15).setTextFading(r10, r11, r12, r13, r14);
        return;
    L5:
        r15.setFadingEdgeLength(r14);
        boolean r16 = false;
        if (r10 == true) goto L10;
        if (r12 == true) goto L10;
        boolean r17 = false;
    L11:
        r15.setHorizontalFadingEdgeEnabled(r17);
        if (r11 == true) goto L14;
        if (r13 == true) goto L14;
    L15:
        r15.setVerticalFadingEdgeEnabled(r16);
        return;
    L14:
        r16 = true;
    L10:
        r17 = true;
        goto L11
    }
}
