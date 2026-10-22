package com.larksuite.component.universe_design.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.tab.databinding.UdTabItemLayoutBinding;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends LinearLayout implements a {
    public b a;
    public int b;
    public int c;
    public float d;
    public final UdTabItemLayoutBinding e;

    @Override // com.larksuite.component.universe_design.tab.a
    public int getContentViewLeft() {
        ImageView r0 = this.e.b;
        if (r0.getVisibility() != 0) goto L7;
        int r1 = r0.getLeft();
        int r2 = getLeft();
    L6:
        return r1 + r2;
    L7:
        FrameLayout r3 = this.e.c;
        if (r3.getVisibility() != 0) goto L10;
        r1 = r3.getLeft();
        r2 = getLeft();
        goto L6
    L10:
        return 0;
    }

    @Override // com.larksuite.component.universe_design.tab.a
    public int getContentViewRight() {
        FrameLayout r0 = this.e.c;
        if (r0.getVisibility() != 0) goto L7;
        int r1 = r0.getRight();
        int r2 = getLeft();
    L6:
        return r1 + r2;
    L7:
        ImageView r3 = this.e.b;
        if (r3.getVisibility() != 0) goto L10;
        r1 = r3.getRight();
        r2 = getLeft();
        goto L6
    L10:
        return 0;
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean r0 = super.performClick();
        b r1 = this.a;
        if (r1 == null) goto L9;
        UDTabLayout r2 = r1.b;
        if (r2 == null) goto L7;
        r2.selectTab(r1);
    L7:
        return true;
    L9:
        return r0;
    }

    public final int getMaxWidth$universe_ui_tab_release() {
        return this.b;
    }

    public final int getMultiLineTitleTextSize$universe_ui_tab_release() {
        return this.c;
    }

    public final float getSingleLineTitleTextSize$universe_ui_tab_release() {
        return this.d;
    }

    public final b getTab$universe_ui_tab_release() {
        return this.a;
    }

    public f(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.b = -1;
        this.c = -1;
        this.d = -1.0f;
        LayoutInflater.from(r4).inflate(2131568097, this);
        int r0 = 2131391820;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(this, 2131391820);
        if (r1 == null) goto L16;
        r0 = 2131391821;
        if (((TextView) ViewBindings.findChildViewById(this, 2131391821)) == null) goto L16;
        r0 = 2131391822;
        if (((TextView) ViewBindings.findChildViewById(this, 2131391822)) == null) goto L16;
        r0 = 2131391823;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(this, 2131391823);
        if (r2 == null) goto L16;
        this.e = new UdTabItemLayoutBinding(this, r1, r2);
        float r3 = r4.getResources().getConfiguration().fontScale;
        if (r3 > 0.0f) goto L13;
        r3 = 1.0f;
    L13:
        setLayoutParams(new LinearLayout.LayoutParams(-2, MathKt.roundToInt(h18.d.d(r4, 2131169400) * r3)));
        setGravity(17);
        setOrientation(0);
        setClickable(true);
        setFocusable(true);
        return;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public final void setMaxWidth$universe_ui_tab_release(int r1) {
        this.b = r1;
    }

    public final void setMultiLineTitleTextSize$universe_ui_tab_release(int r1) {
        this.c = r1;
    }

    public final void setSingleLineTitleTextSize$universe_ui_tab_release(float r1) {
        this.d = r1;
    }

    public final void setTab$universe_ui_tab_release(b r1) {
        this.a = r1;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r7, int r8) {
        if (this.b <= 0) goto L12;
        int r0 = View.MeasureSpec.getSize(r7);
        int r1 = View.MeasureSpec.getMode(r7);
        if (r1 != 0) goto L7;
        int r2 = View.MeasureSpec.makeMeasureSpec(this.b, LKBaseResponseModel.DEFAULT_ERROR_CODE);
    L13:
        super.onMeasure(r2, r8);
        b r3 = this.a;
        if (r3 != null) goto L16;
        return;
    L16:
        TextView r4 = r3.a();
        if (r4 != null) goto L19;
        return;
    L19:
        boolean r5 = true;
        if (r4.getLineCount() > 1) goto L22;
        float r6 = r4.getTextSize();
        float r9 = this.d;
        if (r6 != r9) goto L32;
        boolean r10 = true;
    L33:
        if (r10 == true) goto L48;
        r4.setTextSize(0, r9);
        super.onMeasure(r7, r8);
        if (r4.getLineCount() > 1) goto L37;
        return;
    L37:
        if (this.c <= 0) goto L50;
        float r11 = r4.getTextSize();
        int r12 = this.c;
        if (r11 == r12) goto L42;
        r5 = false;
    L42:
        if (r5 == true) goto L51;
        r4.setTextSize(0, r12);
        super.onMeasure(r7, r8);
        return;
    L51:
        return;
    L50:
        return;
    L48:
        return;
    L32:
        r10 = false;
        goto L33
    L22:
        if (this.c <= 0) goto L45;
        float r13 = r4.getTextSize();
        int r14 = this.c;
        if (r13 == r14) goto L27;
        r5 = false;
    L27:
        if (r5 == true) goto L46;
        r4.setTextSize(0, r14);
        super.onMeasure(r7, r8);
        return;
    L46:
        return;
    L45:
        return;
    L7:
        int r15 = this.b;
        if (r0 <= r15) goto L12;
        if (r1 == 1073741824) goto L12;
        r2 = View.MeasureSpec.makeMeasureSpec(r15, LKBaseResponseModel.DEFAULT_ERROR_CODE);
    L12:
        r2 = r7;
        goto L13
    }
}
