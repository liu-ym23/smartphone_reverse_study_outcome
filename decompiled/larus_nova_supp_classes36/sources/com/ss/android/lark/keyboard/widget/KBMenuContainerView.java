package com.ss.android.lark.keyboard.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001<B3\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J0\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0014J\b\u00102\u001a\u00020\"H\u0002J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0002J\b\u00106\u001a\u00020)H\u0004J\b\u00107\u001a\u00020\u0007H\u0002J\u0016\u00108\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u0012\u00109\u001a\u00020)2\b\u0010:\u001a\u0004\u0018\u00010;H\u0014R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0007X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0007X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/ss/android/lark/keyboard/widget/KBMenuContainerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "menuLayoutManager", "Lcom/ss/android/lark/keyboard/keyboard2/IMenuLayoutManager;", "getMenuLayoutManager", "()Lcom/ss/android/lark/keyboard/keyboard2/IMenuLayoutManager;", "setMenuLayoutManager", "(Lcom/ss/android/lark/keyboard/keyboard2/IMenuLayoutManager;)V", "verticalPadding", "getVerticalPadding", "()I", "setVerticalPadding", "(I)V", "horizontalPadding", "getHorizontalPadding", "setHorizontalPadding", "iconWidth", "getIconWidth", "setIconWidth", "sendWrapperWidth", "getSendWrapperWidth", "setSendWrapperWidth", "density", "", "isFolderSuitEnable", "", "lastLayoutChildrenHash", "lastMeasuredWidth", "resetChildrenMargin", "forceUpdate", "containerWidthMeasured", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "l", "t", "r", "b", "resetChildrenMarginAndPaddingIfNeed", "getVisibleChildren", "", "Landroid/view/View;", "setupChildrenMargin", "computeCurrentLayoutChildrenHash", "updatePluginPadding", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class KBMenuContainerView extends LinearLayout {
    public com.ss.android.lark.keyboard.keyboard2.f a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final float f;
    public final boolean g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;

    public static final class a {
    }

    static {
    }

    public KBMenuContainerView(Context r4) {
        this(r4, null, 0, 14);
    }

    public KBMenuContainerView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public KBMenuContainerView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    private final List<View> getVisibleChildren() {
        ArrayList r0 = new ArrayList();
        int r1 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        View r3 = getChildAt(r2);
        if (r3.getVisibility() == 8) goto L7;
        Intrinsics.checkNotNull(r3);
        r0.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    public final int a() {
        Iterator<T> r0 = getVisibleChildren().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        View r2 = (View) r0.next();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        r1 = (((((r1 * 31) + r2.hashCode()) * 31) + r4.leftMargin) * 31) + r4.rightMargin;
        goto L4
    L6:
        return r1;
    }

    public int getHorizontalPadding() {
        return this.c;
    }

    public int getIconWidth() {
        return this.d;
    }

    public com.ss.android.lark.keyboard.keyboard2.f getMenuLayoutManager() {
        return this.a;
    }

    public int getSendWrapperWidth() {
        return this.e;
    }

    public int getVerticalPadding() {
        return this.b;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.k = true;
    }

    public void setHorizontalPadding(int r1) {
        this.c = r1;
    }

    public void setIconWidth(int r1) {
        this.d = r1;
    }

    public void setMenuLayoutManager(com.ss.android.lark.keyboard.keyboard2.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public void setSendWrapperWidth(int r1) {
        this.e = r1;
    }

    public void setVerticalPadding(int r1) {
        this.b = r1;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r12, int r13) {
        int r0 = View.MeasureSpec.getSize(r12);
        this.l = r0;
        boolean r1 = this.j;
        boolean r4 = false;
        if (a() == this.h) goto L5;
    L9:
        this.k = false;
        List<View> r2 = getVisibleChildren();
        if (r2.isEmpty() == true) goto L40;
        int r3 = r0 - (r2.size() * getIconWidth());
        int r5 = MathKt.roundToInt(getVerticalPadding() / this.f);
        int r6 = MathKt.roundToInt(getHorizontalPadding() / this.f);
        if (r2.size() <= 1) goto L15;
        int r7 = ((r5 + r6) * (r2.size() - 1)) + r6;
    L16:
        float r8 = r3 / r7;
        float r9 = r5 * r8;
        float r10 = r6 * r8;
        int r11 = getIconWidth() + getHorizontalPadding();
        int r14 = (r2.size() - 1) * ((getVerticalPadding() + getIconWidth()) + getHorizontalPadding());
        if (r2.size() <= 1) goto L19;
        r11 = r11 + r14;
    L19:
        if (r11 <= r0) goto L21;
        boolean r15 = true;
    L23:
        if (this.g == true) goto L25;
        int r16 = getVerticalPadding();
        int r17 = getHorizontalPadding();
    L28:
        int r18 = r2.size();
        int r19 = 0;
    L29:
        if (r19 >= r18) goto L39;
        View r20 = (View) ListProtector.get(r2, r19);
        if (r19 != 0) goto L33;
        r20.setPadding(0, getVerticalPadding(), r17, getVerticalPadding());
    L34:
        Intrinsics.checkNotNullParameter(r20, "<this>");
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        r22.rightMargin = 0;
        r22.leftMargin = 0;
        r20.requestLayout();
    L38:
        r19 = r19 + 1;
        goto L29
    L33:
        r20.setPadding(r16, getVerticalPadding(), r17, getVerticalPadding());
        goto L34
    L39:
        r4 = true;
        goto L40
    L25:
        if (r15 == false) goto L27;
        r16 = (int) r9;
        r17 = (int) r10;
        goto L28
    L27:
        r16 = getVerticalPadding();
        r17 = getHorizontalPadding();
        goto L28
    L21:
        r15 = false;
        goto L23
    L15:
        r7 = r6;
    L40:
        this.j = r1 | r4;
        super.onMeasure(r12, r13);
        return;
    L5:
        if (this.k == true) goto L9;
        if (this.l != this.i) goto L9;
        goto L9
    }

    public KBMenuContainerView(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        super(r2, r3, r4, 0);
        this.a = com.ss.android.lark.keyboard.keyboard2.f.a;
        this.b = UIUtils.getDimens(r2, 2131166602);
        this.c = UIUtils.getDimens(r2, 2131166599);
        this.d = UIHelper.dp2px(24.0f);
        this.e = UIHelper.dp2px(33.0f);
        if (r2 == null) goto L15;
        Resources r6 = r2.getResources();
        if (r6 == null) goto L15;
        DisplayMetrics r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());
        if (r7 == null) goto L15;
        float r8 = r7.density;
    L16:
        this.f = r8;
        int r9 = com.ss.android.lark.keyboard.edittext2.utils.d.a;
        Intrinsics.checkNotNullParameter("im.messenger.fold.support", TabAppInfo.IMAGE_JSON_KEY);
        this.g = KeyboardBaseModule.a().isFeatureGatingCurrentEnable("im.messenger.fold.support");
        setOrientation(0);
        setGravity(16);
        return;
    L15:
        r8 = 1.0f;
        goto L16
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        if (this.j == false) goto L8;
        this.j = false;
        List<View> r0 = getVisibleChildren();
        if (r0.isEmpty() == true) goto L8;
        this.h = a();
        getMenuLayoutManager().a(this, r0);
    L8:
        this.i = getMeasuredWidth();
        super.onLayout(r3, r4, r5, r6, r7);
    }
}
