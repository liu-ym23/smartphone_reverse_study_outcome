package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import ps.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/button/OButtonGroup;", "Lcom/obric/oui/button/OShadowFrame;", "", "minWidth", "", "setWidthMin", "(I)V", "getItemCount", "()I", "", "enabled", "setEnabled", "(Z)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OButtonGroup extends OShadowFrame {
    public LinearLayout A;
    public final int B;
    public final int C;
    public final int D;
    public View E;
    public boolean F;

    @JvmOverloads
    public OButtonGroup(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        boolean r5 = false;
        if (getItemCount() != 1) goto L5;
        boolean r11 = true;
    L6:
        boolean r12 = super.dispatchTouchEvent(r10);
        if (r11 == false) goto L28;
        int r13 = r10.getActionMasked();
        if (r13 == 0) goto L27;
        if (r13 != 1) goto L12;
    L26:
        getContentView().setPressed(false);
        goto L28
    L12:
        if (r13 == 2) goto L17;
        if (r13 == 3) goto L26;
    L17:
        if (r10.getX() >= 0.0f) goto L19;
    L25:
        getContentView().setPressed(r5);
        goto L28
    L19:
        if (r10.getX() >= getWidth()) goto L25;
        if (r10.getY() < 0.0f) goto L25;
        if (r10.getY() >= getHeight()) goto L25;
        r5 = true;
        goto L25
    L27:
        getContentView().setPressed(true);
    L28:
        return r12;
    L5:
        r11 = false;
        goto L6
    }

    public final int getItemCount() {
        LinearLayout r5 = this.A;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.getChildCount();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void p(Context r5, OUIFrameLayout r10, TypedArray r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "contentView");
        r10.removeAllViews();
        setChangeAlphaWhenPress(false);
        getContentView().setDuplicateParentStateEnabled(false);
        LinearLayout r12 = new LinearLayout(r5);
        r12.setOrientation(0);
        r12.setGravity(17);
        this.A = r12;
        r10.addView(r12);
        int r13 = this.C;
        setWidthMin(r13);
        getContentView().setWidthMin(r13);
        x();
        if (getItemCount() != 0) goto L5;
        setVisibility(8);
    L7:
        if (getEnableMaterial() == false) goto L10;
        q(r5, r11);
        return;
    L10:
        return;
    L5:
        setVisibility(0);
        goto L7
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        LinearLayout r10 = this.A;
        if (r10 == null) goto L9;
        r10.setEnabled(r5);
        Iterator<View> r11 = ViewGroupKt.getChildren(r10).iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().setEnabled(r5);
    L9:
        x();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public void setWidthMin(int r5) {
        getLayoutHelper().setWidthMin(r5);
    }

    public final void v(OUIFrameLayout r10, ViewGroup.MarginLayoutParams r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "itemView");
        Intrinsics.checkNotNullParameter(r11, "layoutParams");
        LinearLayout r5 = this.A;
        if (r5 != null) goto L6;
        a.c("OButtonGroup", "itemContainer is null");
        return;
    L6:
        Intrinsics.checkNotNull(r5);
        int r13 = r5.getChildCount();
        int r14 = this.D;
        if (r13 < r14) goto L10;
        a.g("OButtonGroup", Intrinsics.stringPlus("itemContainer is full, capacity: ", Integer.valueOf(r14)));
        return;
    L10:
        if (r12 < 0) goto L13;
        LinearLayout r15 = this.A;
        Intrinsics.checkNotNull(r15);
        if (r12 > r15.getChildCount()) goto L13;
    L14:
        LinearLayout r16 = this.A;
        Intrinsics.checkNotNull(r16);
        if (r16.getChildCount() <= 0) goto L26;
        int r17 = this.B;
        if (r12 <= 0) goto L19;
        r11.setMarginStart(r17);
    L27:
        LinearLayout r18 = this.A;
        Intrinsics.checkNotNull(r18);
        r18.addView(r10, r12, r11);
        x();
        if (getItemCount() != 0) goto L30;
        setVisibility(8);
        return;
    L30:
        setVisibility(0);
        return;
    L19:
        r11.setMarginStart(0);
        LinearLayout r19 = this.A;
        Intrinsics.checkNotNull(r19);
        View r20 = r19.getChildAt(0);
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
    L23:
        if (r22 == null) goto L27;
        r22.setMarginStart(r17);
        r20.setLayoutParams(r22);
        goto L27
    L22:
        r22 = null;
        goto L23
    L26:
        r11.setMarginStart(0);
    L13:
        LinearLayout r23 = this.A;
        Intrinsics.checkNotNull(r23);
        r12 = r23.getChildCount();
        goto L14
    }

    public final void w() {
        KeyEvent.Callback r5 = this.E;
        if (r5 != null) goto L5;
    L13:
        this.E = null;
        this.F = false;
        return;
    L5:
        if (this.F == false) goto L13;
        if ((r5 instanceof com.obric.oui.common.style.a) == false) goto L9;
        com.obric.oui.common.style.a r10 = (com.obric.oui.common.style.a) r5;
    L10:
        if (r10 == null) goto L13;
        r10.setChangeAlphaWhenPress(true);
        goto L13
    L9:
        r10 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        LinearLayout r5 = this.A;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.getChildCount() != 1) goto L18;
        View r10 = r5.getChildAt(0);
        if (this.E == r10) goto L11;
        w();
        this.E = r10;
    L11:
        if ((r10 instanceof com.obric.oui.common.style.a) == false) goto L13;
        com.obric.oui.common.style.a r11 = (com.obric.oui.common.style.a) r10;
    L14:
        if (r11 == null) goto L17;
        r11.setChangeAlphaWhenPress(false);
        this.F = true;
    L17:
        getContentView().setChangeAlphaWhenPress(isEnabled());
        return;
    L13:
        r11 = null;
        goto L14
    L18:
        getContentView().setChangeAlphaWhenPress(false);
        w();
    }

    @JvmOverloads
    public OButtonGroup(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 12);
    }

    @JvmOverloads
    public OButtonGroup(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public OButtonGroup(Context r10, AttributeSet r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        int r5 = 0;
    L9:
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r5, 8, 0);
        this.D = 5;
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.OButtonGroup, 0, 0);
        this.C = r14.getDimensionPixelSize(R$styleable.OButtonGroup_oui_widgetMinWidth, 0);
        this.B = r14.getDimensionPixelSize(R$styleable.OButtonGroup_oui_widgetInnerItemMargin, 0);
        this.D = r14.getDimensionPixelSize(R$styleable.OButtonGroup_oui_OButtonGroupCapacity, 5);
        r14.recycle();
        return;
    L8:
        r5 = r12;
        goto L9
    }
}
