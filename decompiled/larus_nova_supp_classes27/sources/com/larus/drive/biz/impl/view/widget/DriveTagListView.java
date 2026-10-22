package com.larus.drive.biz.impl.view.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p79.b;
import p79.d;
import v19.c;
import v19.i5;
import zp9.u;
import zp9.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020#H\u0016J\u0016\u0010-\u001a\u00020 2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0016J\"\u00101\u001a\u00020 2\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eH\u0016J\u0016\u0010!\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0012\u00104\u001a\u00020#2\b\u00105\u001a\u0004\u0018\u000106H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0018\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001b\u0010\u0014R\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010)¨\u00067"}, d2 = {"Lcom/larus/drive/biz/impl/view/widget/DriveTagListView;", "Landroid/widget/HorizontalScrollView;", "Lcom/larus/platform/api/creation/ITabListLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "root", "Landroid/widget/FrameLayout;", "container", "Landroid/widget/LinearLayout;", "indicator", "Landroid/view/View;", "scrollAnimator", "Landroid/animation/ObjectAnimator;", "selectedColor", "", "getSelectedColor", "()I", "selectedColor$delegate", "Lkotlin/Lazy;", "unSelectedColor", "getUnSelectedColor", "unSelectedColor$delegate", "indicatorColor", "getIndicatorColor", "indicatorColor$delegate", "performClick", "Lkotlin/Function2;", "", "", "canScroll", "Lkotlin/Function0;", "", "innerCurrent", "value", "current", "getCurrent", "setCurrent", "(I)V", "select", "index", "scrollable", "bindData", "list", "", "Lcom/larus/platform/api/creation/TabTag;", "onItemClick", "click", "scroll", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveTagListView extends HorizontalScrollView implements u {
    public static final /* synthetic */ int k = 0;
    public final FrameLayout a;
    public final LinearLayout b;
    public final View c;
    public ObjectAnimator d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public Function2<? super Integer, ? super String, Unit> h;
    public Function0<Boolean> i;
    public int j;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ DriveTagListView b;
        public final /* synthetic */ boolean c;

        public a(View r1, DriveTagListView r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            if (this.a.getWidth() > 0) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(this.a.getParent(), this.b.b) == false) goto L17;
            int r10 = ((this.a.getLeft() + (this.a.getWidth() / 2)) - (this.b.getWidth() / 2)) + i5.g();
            ViewGroup.LayoutParams r11 = this.b.c.getLayoutParams();
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11;
            r12.width = this.a.getWidth();
            r12.leftMargin = this.a.getLeft();
            r12.topMargin = this.b.b.getBottom() + i5.j0();
            this.b.c.setLayoutParams(r12);
            if (this.c == true) goto L10;
            this.b.scrollTo(r10, 0);
            return;
        L10:
            ObjectAnimator r13 = this.b.d;
            if (r13 == null) goto L13;
            r13.cancel();
        L13:
            DriveTagListView r14 = this.b;
            ObjectAnimator r15 = ObjectAnimator.ofInt(r14, "scrollX", new int[]{r14.getScrollX(), r10});
            r15.setDuration(200);
            r15.start();
            r14.d = r15;
            return;
        }
    }

    private final int getIndicatorColor() {
        return ((Number) this.g.getValue()).intValue();
    }

    private final int getSelectedColor() {
        return ((Number) this.e.getValue()).intValue();
    }

    private final int getUnSelectedColor() {
        return ((Number) this.f.getValue()).intValue();
    }

    public int getCurrent() {
        return this.j;
    }

    public DriveTagListView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void a(Function2<? super Integer, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "click");
        this.h = r2;
    }

    public final void c(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "scroll");
        this.i = r2;
    }

    public final void d(List<w> r13) {
        Intrinsics.checkNotNullParameter(r13, "list");
        this.b.removeAllViews();
        ArrayList r1 = new ArrayList();
        Iterator<T> r0 = r13.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r2 = r0.next();
        if ((true ^ ((w) r2).a()) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        Iterator r3 = r1.iterator();
        int r4 = 0;
        final int r5 = 0;
    L10:
        if (r3.hasNext() == false) goto L28;
        Object r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final w r8 = (w) r6;
        TextView r9 = new TextView(getContext());
        String r10 = r8.b;
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        r9.setText(r10);
        r9.setTextSize(0, r9.getResources().getDimension(c.b(2130972275, null, 2131167620)));
        r9.setTypeface(Typeface.DEFAULT, 1);
        r9.setTextColor(getUnSelectedColor());
        r9.setIncludeFontPadding(true);
        r9.setGravity(16);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -2);
        if (r5 != 0) goto L21;
        int r12 = i5.q();
    L22:
        r11.setMarginStart(r12);
        if (r5 != (r1.size() - 1)) goto L25;
        int r14 = i5.q();
    L26:
        r11.setMarginEnd(r14);
        r9.setLayoutParams(r11);
        r9.setClickable(true);
        r9.setOnClickListener(new d(this, r5, r8));
        this.b.addView(r9);
        r5 = r7;
        goto L10
    L25:
        r14 = i5.h();
        goto L26
    L21:
        r12 = i5.h();
        goto L22
    L28:
        if ((!r13.isEmpty()) == true) goto L31;
        r4 = 8;
    L31:
        setVisibility(r4);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        Function0<Boolean> r0 = this.i;
        if (r0 == null) goto L5;
        boolean r1 = ((Boolean) r0.invoke()).booleanValue();
    L6:
        if (r1 == true) goto L8;
    L10:
        return false;
    L8:
        if (super.onTouchEvent(r3) == false) goto L10;
        return true;
    L5:
        r1 = true;
        goto L6
    }

    public void setCurrent(int r2) {
        if (this.j != r2) goto L5;
        return;
    L5:
        this.j = r2;
        b(getCurrent(), true);
    }

    public DriveTagListView(final Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        FrameLayout r7 = new FrameLayout(r5);
        this.a = r7;
        LinearLayout r0 = new LinearLayout(r5);
        this.b = r0;
        View r1 = new View(r5);
        this.c = r1;
        this.e = LazyKt.lazy(new p79.a(r5));
        this.f = LazyKt.lazy(new b(r5));
        this.g = LazyKt.lazy(new p79.c(r5));
        this.j = -1;
        addView(r7, new FrameLayout.LayoutParams(-1, -2));
        setHorizontalScrollBarEnabled(false);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r2.topMargin = i5.c();
        r2.bottomMargin = i5.z();
        r0.setOrientation(0);
        r7.addView(r0, r2);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(0, i5.z());
        r1.setBackgroundColor(getIndicatorColor());
        r7.addView(r1, r3);
    }

    public final void b(int r7, boolean r8) {
        if (r7 >= 0) goto L4;
        return;
    L4:
        if (r7 >= this.b.getChildCount()) goto L44;
        this.j = r7;
        View r9 = ViewGroupKt.get(this.b, r7);
        LinearLayout r0 = this.b;
        int r1 = r0.getChildCount();
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L19;
        View r4 = r0.getChildAt(r3);
        r4.setSelected(Intrinsics.areEqual(r4, r9));
        if ((r4 instanceof TextView) == false) goto L11;
        TextView r5 = (TextView) r4;
    L12:
        if (r5 == null) goto L17;
        if (Intrinsics.areEqual(r4, r9) == false) goto L16;
        r5.setTextColor(getSelectedColor());
        goto L17
    L16:
        r5.setTextColor(getUnSelectedColor());
    L17:
        r3 = r3 + 1;
        goto L7
    L11:
        r5 = null;
        goto L12
    L19:
        if (isLaidOut() == true) goto L21;
    L34:
        addOnLayoutChangeListener(new a(r9, this, r8));
        return;
    L21:
        if (isLayoutRequested() == true) goto L34;
        if (r9.getWidth() > 0) goto L25;
        return;
    L25:
        if (Intrinsics.areEqual(r9.getParent(), this.b) == false) goto L45;
        int r2 = ((r9.getLeft() + (r9.getWidth() / 2)) - (getWidth() / 2)) + i5.g();
        ViewGroup.LayoutParams r6 = this.c.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r6;
        r10.width = r9.getWidth();
        r10.leftMargin = r9.getLeft();
        r10.topMargin = this.b.getBottom() + i5.j0();
        this.c.setLayoutParams(r10);
        if (r8 == true) goto L30;
        scrollTo(r2, 0);
        return;
    L30:
        ObjectAnimator r11 = this.d;
        if (r11 == null) goto L33;
        r11.cancel();
    L33:
        ObjectAnimator r12 = ObjectAnimator.ofInt(this, "scrollX", new int[]{getScrollX(), r2});
        r12.setDuration(200);
        r12.start();
        this.d = r12;
        return;
    L45:
        return;
    }
}
