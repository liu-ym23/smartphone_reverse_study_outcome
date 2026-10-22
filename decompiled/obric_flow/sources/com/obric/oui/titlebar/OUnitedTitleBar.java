package com.obric.oui.titlebar;

import ai.j0;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.i;
import com.obric.oui.button.OIconButton;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b*\u0018\u00002\u00020\u00012\u00020\u0002:\u0003p\u000eqB\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u0019J\r\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u0019J\r\u0010\u001d\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u0019J\r\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b\u001e\u0010\u0019J\u0013\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\"\u0010\u0019J\u000f\u0010#\u001a\u00020\u0017H\u0002¢\u0006\u0004\b#\u0010\u0019R$\u0010*\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b\u0014\u0010)R$\u0010-\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\"\u0004\b\u0016\u0010)R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00109\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R$\u0010?\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010\u0015R$\u0010G\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010O\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010S\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010J\u001a\u0004\bQ\u0010L\"\u0004\bR\u0010NR$\u0010W\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010;\u001a\u0004\bU\u0010=\"\u0004\bV\u0010\u0015R\"\u0010]\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010\u0019\"\u0004\b[\u0010\\R\"\u0010c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010\rR\"\u0010g\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010Y\u001a\u0004\be\u0010\u0019\"\u0004\bf\u0010\\R\u001a\u0010j\u001a\u00020\u00178\u0006X\u0086D¢\u0006\f\n\u0004\bh\u0010Y\u001a\u0004\bi\u0010\u0019R$\u0010k\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010\u0011¨\u0006r"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar;", "Landroid/widget/FrameLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "expanded", "", "setExpanded", "(Z)V", "Lcom/obric/oui/titlebar/c;", "onHeaderFlingUnConsumedListener", "setOnHeaderFlingUnConsumedListener", "(Lcom/obric/oui/titlebar/c;)V", "Landroid/view/View;", "view", "setLeftAction", "(Landroid/view/View;)V", "setRightAction", "", "getDownNestedScrollRange", "()I", "getUpNestedPreScrollRange", "getTopInset", "getPendingAction", "getTotalScrollRange", "getDownNestedPreScrollRange", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getBehavior", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getSnapRange", "getScrollRange", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "getLeftAction", "()Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "leftAction", "b", "getRightAction", "rightAction", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvTitle", "d", "getMTvSubTitle", "setMTvSubTitle", "mTvSubTitle", "e", "Landroid/view/View;", "getBottomAction", "()Landroid/view/View;", "setBottomAction", "bottomAction", "", "f", "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "titleText", "Landroid/graphics/drawable/Drawable;", "g", "Landroid/graphics/drawable/Drawable;", "getLeftActionSrc", "()Landroid/graphics/drawable/Drawable;", "setLeftActionSrc", "(Landroid/graphics/drawable/Drawable;)V", "leftActionSrc", "h", "getRightActionSrc", "setRightActionSrc", "rightActionSrc", "i", "getDivider", "setDivider", "divider", "j", "I", "getMCollapsePosition", "setMCollapsePosition", "(I)V", "mCollapsePosition", "m", "Z", "getInDebug", "()Z", "setInDebug", "inDebug", "n", "getTextInitPos", "setTextInitPos", "textInitPos", "o", "getINVALID_SCROLL_RANGE", "INVALID_SCROLL_RANGE", "mOnHeaderFlingUnConsumedListener", "Lcom/obric/oui/titlebar/c;", "getMOnHeaderFlingUnConsumedListener", "()Lcom/obric/oui/titlebar/c;", "setMOnHeaderFlingUnConsumedListener", "Behavior", "com/obric/oui/titlebar/d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OUnitedTitleBar extends FrameLayout implements CoordinatorLayout.AttachedBehavior {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f14820q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f14821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f14822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f14823c;
    public TextView d;
    public View e;
    public String f;
    public Drawable g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f14824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f14825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f14828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f14831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WindowInsetsCompat f14832p;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u001d\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$Behavior;", "Lcom/obric/oui/titlebar/behavior/HeaderBehavior;", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Behavior extends HeaderBehavior<OUnitedTitleBar> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ValueAnimator f14833j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f14834k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public WeakReference f14835l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f14836m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f14837n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f14838o;

        public Behavior() {
        }

        public final void a(CoordinatorLayout r10, OUnitedTitleBar r11) {
            int r5 = getTopAndBottomOffset();
            Intrinsics.checkNotNull(r11);
            int r12 = -OUnitedTitleBar.b(r11);
            if (r5 <= r12) goto L24;
            if (r5 < 0) goto L6;
            return;
        L6:
            if (r5 < (r12 / 2)) goto L9;
            r12 = 0;
        L9:
            int r13 = Math.abs(getTopAndBottomOffset() - r12);
            float r14 = Math.abs(0.0f);
            if (r14 <= 0.0f) goto L12;
            int r15 = Math.round((r13 / r14) * 1000);
        L13:
            int r16 = getTopAndBottomOffset();
            if (r16 != r12) goto L18;
            ValueAnimator r17 = this.f14833j;
            if (r17 == null) goto L18;
            Intrinsics.checkNotNull(r17);
            r17.cancel();
        L18:
            ValueAnimator r18 = this.f14833j;
            if (r18 != null) goto L21;
            ValueAnimator r19 = new ValueAnimator();
            this.f14833j = r19;
            Intrinsics.checkNotNull(r19);
            r19.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator r20 = this.f14833j;
            Intrinsics.checkNotNull(r20);
            r20.addUpdateListener(new i(this, r10, r11, 2));
        L22:
            ValueAnimator r21 = this.f14833j;
            Intrinsics.checkNotNull(r21);
            r21.setDuration(r15);
            ValueAnimator r22 = this.f14833j;
            Intrinsics.checkNotNull(r22);
            r22.setIntValues(new int[]{r16, r12});
            ValueAnimator r23 = this.f14833j;
            Intrinsics.checkNotNull(r23);
            r23.start();
            return;
        L21:
            Intrinsics.checkNotNull(r18);
            r18.cancel();
            goto L22
        L12:
            Intrinsics.checkNotNull(r11);
            r15 = (int) (((r13 / r11.getHeight()) + 1) * 150);
            goto L13
        }

        public final boolean b(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, float r13) {
            Intrinsics.checkNotNullParameter(r11, "layout");
            if (r13 >= 0.0f) goto L6;
            this.f14837n = true;
            this.f14838o = r12;
            r12 = Integer.MIN_VALUE;
            int r5 = Integer.MAX_VALUE;
        L8:
            return super.fling(r10, r11, r12, r5, r13);
        L6:
            r5 = 0;
            goto L8
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final boolean canDragView(View r5) {
            OUnitedTitleBar r10 = (OUnitedTitleBar) r5;
            WeakReference r11 = this.f14835l;
            if (r11 == null) goto L15;
            Intrinsics.checkNotNull(r11);
            View r12 = (View) r11.get();
            if (r12 != null) goto L7;
        L13:
            return false;
        L7:
            if (r12.isShown() == false) goto L13;
            if (ViewCompat.canScrollVertically(r12, -1) == true) goto L13;
            int r13 = getTopAndBottomOffset();
            Intrinsics.checkNotNull(r10);
            if (r13 <= (-OUnitedTitleBar.a(r10))) goto L13;
            return true;
        L15:
            return true;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final /* bridge */ /* synthetic */ boolean fling(CoordinatorLayout r5, View r10, int r11, int r12, float r13) {
            return b(r5, (OUnitedTitleBar) r10, r11, r13);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getMaxDragOffset(View r5) {
            OUnitedTitleBar r10 = (OUnitedTitleBar) r5;
            Intrinsics.checkNotNullParameter(r10, "view");
            return -OUnitedTitleBar.a(r10);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getScrollRangeForDragFling(View r5) {
            OUnitedTitleBar r10 = (OUnitedTitleBar) r5;
            Intrinsics.checkNotNullParameter(r10, "view");
            return OUnitedTitleBar.a(r10);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final void onFlingFinished(CoordinatorLayout r5, View r10) {
            this.f14837n = false;
            a(r5, (OUnitedTitleBar) r10);
        }

        @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onLayoutChild(CoordinatorLayout r5, View r10, int r11) {
            OUnitedTitleBar r12 = (OUnitedTitleBar) r10;
            Intrinsics.checkNotNullParameter(r5, "parent");
            Intrinsics.checkNotNullParameter(r12, "child");
            super.onLayoutChild(r5, r12, r11);
            int r13 = r12.f14827k;
            if (r13 != 0) goto L5;
        L10:
            r12.c(getTopAndBottomOffset());
            return true;
        L5:
            if ((r13 & 1) == 0) goto L8;
            setHeaderTopBottomOffset(r5, r12, -OUnitedTitleBar.a(r12));
            goto L10
        L8:
            if ((r13 & 16) == 0) goto L10;
            setHeaderTopBottomOffset(r5, r12, 0);
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onNestedFling(CoordinatorLayout r5, View r10, View r11, float r12, float r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r5, "coordinatorLayout");
            Intrinsics.checkNotNullParameter((OUnitedTitleBar) r10, "child");
            Intrinsics.checkNotNullParameter(r11, "target");
            this.f14836m = true;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onNestedPreFling(CoordinatorLayout r5, View r10, View r11, float r12, float r13) {
            OUnitedTitleBar r14 = (OUnitedTitleBar) r10;
            Intrinsics.checkNotNullParameter(r5, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r14, "child");
            Intrinsics.checkNotNullParameter(r11, "target");
            if (r13 > 0.0f) goto L5;
        L7:
            return false;
        L5:
            if (getTopAndBottomOffset() <= (-OUnitedTitleBar.a(r14))) goto L7;
            b(r5, r14, -OUnitedTitleBar.a(r14), -r13);
            this.f14836m = true;
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedPreScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int[] r15) {
            OUnitedTitleBar r5 = (OUnitedTitleBar) r11;
            Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r5, "child");
            Intrinsics.checkNotNullParameter(r12, "target");
            Intrinsics.checkNotNullParameter(r15, "consumed");
            if (r14 > 0) goto L5;
            return;
        L5:
            if (this.f14834k == true) goto L9;
            int r16 = -OUnitedTitleBar.a(r5);
            r15[1] = setHeaderTopBottomOffset(r10, r5, getTopBottomOffsetForScrollingSibling() - r14, r16, 0);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedScroll(CoordinatorLayout r5, View r10, View r11, int r12, int r13, int r14, int r15) {
            OUnitedTitleBar r16 = (OUnitedTitleBar) r10;
            Intrinsics.checkNotNullParameter(r5, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r16, "child");
            Intrinsics.checkNotNullParameter(r11, "target");
            if (r15 >= 0) goto L5;
            int r17 = -OUnitedTitleBar.a(r16);
            setHeaderTopBottomOffset(r5, r16, getTopBottomOffsetForScrollingSibling() - r15, r17, 0);
            boolean r18 = true;
        L6:
            this.f14834k = r18;
            return;
        L5:
            r18 = false;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onStartNestedScroll(CoordinatorLayout r5, View r10, View r11, View r12, int r13) {
            OUnitedTitleBar r14 = (OUnitedTitleBar) r10;
            Intrinsics.checkNotNullParameter(r5, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r14, "child");
            Intrinsics.checkNotNullParameter(r11, "directTargetChild");
            Intrinsics.checkNotNullParameter(r12, "target");
            if ((r13 & 2) > 0) goto L5;
        L9:
            boolean r15 = false;
        L10:
            if (r15 == false) goto L14;
            ValueAnimator r16 = this.f14833j;
            if (r16 == null) goto L14;
            Intrinsics.checkNotNull(r16);
            r16.cancel();
        L14:
            this.f14835l = null;
            this.f14836m = false;
            this.f14837n = false;
            OverScroller r17 = this.d;
            if (r17 == null) goto L17;
            r17.abortAnimation();
        L17:
            return r15;
        L5:
            if (OUnitedTitleBar.a(r14) <= 0) goto L9;
            if ((r5.getHeight() - r11.getHeight()) > r14.getHeight()) goto L9;
            r15 = true;
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onStopNestedScroll(CoordinatorLayout r5, View r10, View r11) {
            OUnitedTitleBar r12 = (OUnitedTitleBar) r10;
            Intrinsics.checkNotNullParameter(r5, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r12, "child");
            Intrinsics.checkNotNullParameter(r11, "target");
            if (this.f14836m == true) goto L5;
            a(r5, r12);
        L5:
            this.f14834k = false;
            this.f14835l = new WeakReference(r11);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int setHeaderTopBottomOffset(CoordinatorLayout r10, View r11, int r12, int r13, int r14) {
            OUnitedTitleBar r15 = (OUnitedTitleBar) r11;
            if (this.f14837n == false) goto L5;
            r13 = Math.max(this.f14838o, r13);
            r14 = Math.min(0, r14);
        L5:
            int r16 = super.setHeaderTopBottomOffset(r10, r15, r12, r13, r14);
            if (r15 == null) goto L10;
            r15.c(getTopAndBottomOffset());
        L10:
            if (this.f14837n == false) goto L14;
            if (r15 == null) goto L14;
            r15.getMOnHeaderFlingUnConsumedListener();
        L14:
            return r16;
        }

        public Behavior(Context r5, AttributeSet r10) {
            super(r5, r10);
        }
    }

    @JvmOverloads
    public OUnitedTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public static final /* synthetic */ int a(OUnitedTitleBar r5) {
        return r5.getScrollRange();
    }

    public static final /* synthetic */ int b(OUnitedTitleBar r5) {
        return r5.getSnapRange();
    }

    private final int getScrollRange() {
        return com.lynx.tasm.utils.a.B(184, this);
    }

    private final int getSnapRange() {
        return com.lynx.tasm.utils.a.B(56, this);
    }

    public final void c(int r12) {
        ArrayList r11 = this.f14828l;
        if (r11 == null) goto L79;
        Intrinsics.checkNotNull(r11);
        Iterator r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L85;
        OUnitedTitleBar r5 = ((d) r13.next()).f14865a;
        ViewGroup r10 = r5.getLeftAction();
        ViewGroup.MarginLayoutParams r14 = null;
        if (r10 != null) goto L10;
        ViewGroup.LayoutParams r15 = null;
    L12:
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
    L15:
        ViewGroup r17 = r5.getRightAction();
        if (r17 != null) goto L18;
        ViewGroup.LayoutParams r18 = null;
    L20:
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
    L23:
        TextView r20 = r5.getMTvTitle();
        if (r20 != null) goto L26;
        ViewGroup.LayoutParams r21 = null;
    L28:
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        r14 = (ViewGroup.MarginLayoutParams) r21;
    L30:
        int r22 = com.lynx.tasm.utils.a.B(12, r5);
        int r23 = com.lynx.tasm.utils.a.B(92, r5);
        int r24 = com.lynx.tasm.utils.a.B(17, r5);
        float r25 = (-r12) / r5.getTotalScrollRange();
        if (r5.getMCollapsePosition() != 1) goto L43;
        r24 = com.lynx.tasm.utils.a.B(14, r5);
        int[] r26 = new int[2];
        TextView r27 = r5.getMTvTitle();
        if (r27 == null) goto L36;
        r27.getLocationOnScreen(r26);
    L36:
        if (r12 != 0) goto L38;
        r5.setTextInitPos(r26[0]);
    L38:
        float r28 = (r5.getTextInitPos() + com.lynx.tasm.utils.a.B(18, r5)) * r25;
        if (r14 == null) goto L42;
        r14.leftMargin = -((int) r28);
    L42:
        float r29 = 20.0f;
    L45:
        if (r25 != 1.0f) goto L50;
        View r30 = r5.getDivider();
        if (r30 == null) goto L54;
        com.lynx.tasm.utils.d.t(r30);
    L54:
        if (r16 == null) goto L57;
        r16.topMargin = (-r12) + r22;
    L57:
        if (r19 == null) goto L60;
        r19.topMargin = (-r12) + r22;
    L60:
        int r31 = (int) (r23 - ((r23 - r24) * r25));
        float r32 = j0.b(r29, 40.0f, new AccelerateDecelerateInterpolator().getInterpolation(r25), 40.0f);
        TextView r33 = r5.getMTvTitle();
        if (r33 == null) goto L64;
        r33.setTextSize(2, r32);
    L64:
        if (r14 == null) goto L67;
        r14.bottomMargin = r31;
    L67:
        ViewGroup r34 = r5.getLeftAction();
        if (r34 == null) goto L71;
        r34.setLayoutParams(r16);
    L71:
        ViewGroup r35 = r5.getRightAction();
        if (r35 == null) goto L75;
        r35.setLayoutParams(r19);
    L75:
        TextView r36 = r5.getMTvTitle();
        if (r36 == null) goto L6;
        r36.setLayoutParams(r14);
        goto L6
    L50:
        View r37 = r5.getDivider();
        if (r37 == null) goto L54;
        com.lynx.tasm.utils.d.s(r37);
        goto L54
    L43:
        r29 = 16.0f;
        goto L45
    L26:
        r21 = r20.getLayoutParams();
        goto L28
    L22:
        r19 = null;
        goto L23
    L18:
        r18 = r17.getLayoutParams();
        goto L20
    L14:
        r16 = null;
        goto L15
    L10:
        r15 = r10.getLayoutParams();
        goto L12
    L85:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        BaseBehavior.LayoutParams r10 = new BaseBehavior.LayoutParams(r5);
        r10.f14847a = 1;
        return r10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<?> getBehavior() {
        return new BaseBehavior.Behavior();
    }

    public final View getBottomAction() {
        return this.e;
    }

    public final View getDivider() {
        return this.f14825i;
    }

    public final int getDownNestedPreScrollRange() {
        return 0;
    }

    public final int getDownNestedScrollRange() {
        return getTotalScrollRange();
    }

    public final int getINVALID_SCROLL_RANGE() {
        return this.f14831o;
    }

    public final boolean getInDebug() {
        return this.f14829m;
    }

    public final ViewGroup getLeftAction() {
        return this.f14821a;
    }

    public final Drawable getLeftActionSrc() {
        return this.g;
    }

    public final int getMCollapsePosition() {
        return this.f14826j;
    }

    public final c getMOnHeaderFlingUnConsumedListener() {
        return null;
    }

    public final TextView getMTvSubTitle() {
        return this.d;
    }

    public final TextView getMTvTitle() {
        return this.f14823c;
    }

    public final int getPendingAction() {
        return this.f14827k;
    }

    public final ViewGroup getRightAction() {
        return this.f14822b;
    }

    public final Drawable getRightActionSrc() {
        return this.f14824h;
    }

    public final int getTextInitPos() {
        return this.f14830n;
    }

    public final String getTitleText() {
        return this.f;
    }

    public final int getTopInset() {
        WindowInsetsCompat r5 = this.f14832p;
        if (r5 == null) goto L5;
        Intrinsics.checkNotNull(r5);
        return r5.getSystemWindowInsetTop();
    L5:
        return 0;
    }

    public final int getTotalScrollRange() {
        return com.lynx.tasm.utils.a.B(184, this);
    }

    public final int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void setBottomAction(View r5) {
        this.e = r5;
    }

    public final void setDivider(View r5) {
        this.f14825i = r5;
    }

    public final void setExpanded(boolean r5) {
        if (r5 == false) goto L4;
        int r10 = 16;
    L5:
        this.f14827k = r10;
        requestLayout();
        return;
    L4:
        r10 = 1;
        goto L5
    }

    public final void setInDebug(boolean r5) {
        this.f14829m = r5;
    }

    public final void setLeftAction(ViewGroup r5) {
        this.f14821a = r5;
    }

    public final void setLeftActionSrc(Drawable r5) {
        this.g = r5;
    }

    public final void setMCollapsePosition(int r5) {
        this.f14826j = r5;
    }

    public final void setMOnHeaderFlingUnConsumedListener(c r5) {
    }

    public final void setMTvSubTitle(TextView r5) {
        this.d = r5;
    }

    public final void setMTvTitle(TextView r5) {
        this.f14823c = r5;
    }

    public final void setOnHeaderFlingUnConsumedListener(c r5) {
        Intrinsics.checkNotNullParameter(r5, "onHeaderFlingUnConsumedListener");
    }

    public final void setRightAction(ViewGroup r5) {
        this.f14822b = r5;
    }

    public final void setRightActionSrc(Drawable r5) {
        this.f14824h = r5;
    }

    public final void setTextInitPos(int r5) {
        this.f14830n = r5;
    }

    public final void setTitleText(String r5) {
        this.f = r5;
    }

    @JvmOverloads
    public OUnitedTitleBar(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OUnitedTitleBar);
        this.f = r12.getString(R$styleable.OUnitedTitleBar_oui_united_title);
        this.f14826j = r12.getInt(R$styleable.OUnitedTitleBar_oui_title_collapse_position, 0);
        this.g = r12.getDrawable(R$styleable.OUnitedTitleBar_oui_left_action_src);
        this.f14824h = r12.getDrawable(R$styleable.OUnitedTitleBar_oui_right_action_src);
        r12.recycle();
        View.inflate(r10, R$layout.o_united_titlebar, this);
        this.f14821a = (ViewGroup) findViewById(R$id.fl_left_container);
        this.f14822b = (ViewGroup) findViewById(R$id.fl_right_container);
        this.f14823c = (TextView) findViewById(R$id.tv_title_container);
        this.d = (TextView) findViewById(R$id.tv_subtitle_container);
        this.e = findViewById(R$id.fl_bottom_container);
        this.f14825i = findViewById(R$id.divider);
        TextView r13 = this.f14823c;
        if (r13 == null) goto L6;
        r13.setText(this.f);
    L6:
        ViewCompat.setOnApplyWindowInsetsListener(this, new b(this, 0));
        if (this.g == null) goto L10;
        OIconButton r14 = new OIconButton(getContext(), null, 0, 0, 28);
        r14.setImageDrawable(getLeftActionSrc());
        setLeftAction(r14);
    L10:
        if (this.f14824h == null) goto L12;
        OIconButton r15 = new OIconButton(getContext(), null, 0, 0, 28);
        r15.setImageDrawable(getRightActionSrc());
        setRightAction(r15);
    L12:
        setBackgroundColor(getResources().getColor(R$color.Transparent));
        if (this.f14829m == false) goto L26;
        ViewGroup r16 = this.f14821a;
        if (r16 == null) goto L18;
        r16.setBackgroundColor(getResources().getColor(R$color.oui_blue_2));
    L18:
        ViewGroup r17 = this.f14822b;
        if (r17 == null) goto L22;
        r17.setBackgroundColor(getResources().getColor(R$color.oui_blue_2));
    L22:
        setBackgroundColor(getResources().getColor(R$color.oui_red_2));
        TextView r18 = this.f14823c;
        if (r18 == null) goto L26;
        r18.setBackgroundColor(getResources().getColor(R$color.oui_yellow_1));
    L26:
        d r19 = new d(this);
        if (this.f14828l != null) goto L29;
        this.f14828l = new ArrayList();
    L29:
        ArrayList r20 = this.f14828l;
        Intrinsics.checkNotNull(r20);
        if (r20.contains(r19) == true) goto L32;
        ArrayList r21 = this.f14828l;
        Intrinsics.checkNotNull(r21);
        r21.add(r19);
    L32:
        this.f14831o = -1;
    }

    public final void setLeftAction(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        ViewGroup r10 = this.f14821a;
        if (r10 == null) goto L6;
        r10.removeAllViews();
    L6:
        ViewGroup r11 = this.f14821a;
        if (r11 == null) goto L11;
        r11.addView(r5);
        return;
    }

    public final void setRightAction(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        ViewGroup r10 = this.f14822b;
        if (r10 == null) goto L6;
        r10.removeAllViews();
    L6:
        ViewGroup r11 = this.f14822b;
        if (r11 == null) goto L11;
        r11.addView(r5);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new BaseBehavior.LayoutParams(getContext(), r5);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new BaseBehavior.LayoutParams(getContext(), r5);
    }
}
