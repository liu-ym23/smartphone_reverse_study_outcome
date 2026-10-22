package com.larus.business.debug.base.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewGroupKt;
import androidx.viewpager.widget.ViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.business.debug.base.register.EntrancePage;
import cw8.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.c6;
import v19.i5;
import zv8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u000e\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001b\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\"\u0010\u001f\u001a\u00020\u00142\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0011H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0010\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010(R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/larus/business/debug/base/view/DebugEntrancePageTagListView;", "Landroid/widget/HorizontalScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "container", "Landroid/widget/LinearLayout;", "textColorStateList", "Landroid/content/res/ColorStateList;", "kotlin.jvm.PlatformType", "clickListener", "com/larus/business/debug/base/view/DebugEntrancePageTagListView$clickListener$1", "Lcom/larus/business/debug/base/view/DebugEntrancePageTagListView$clickListener$1;", "performClick", "Lkotlin/Function2;", "", "", "", "scrollAnimator", "Landroid/animation/ObjectAnimator;", "value", "current", "setCurrent", "(I)V", "bindData", "list", "", "Lcom/larus/business/debug/base/register/EntrancePage;", "onItemClick", "click", "createItemView", "Landroid/widget/TextView;", "data", "select", "index", "setupWithViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebugEntrancePageTagListView extends HorizontalScrollView {
    public static final /* synthetic */ int g = 0;
    public final LinearLayout a;
    public final ColorStateList b;
    public final a c;
    public Function2<? super Integer, ? super String, Unit> d;
    public ObjectAnimator e;
    public int f;

    public static final class a extends c6 {
        public final /* synthetic */ DebugEntrancePageTagListView c;

        public a(DebugEntrancePageTagListView r1) {
            this.c = r1;
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            Object r4 = r3.getTag();
            if ((r4 instanceof Integer) == false) goto L5;
            Integer r5 = (Integer) r4;
        L6:
            if (r5 == null) goto L11;
            DebugEntrancePageTagListView r0 = this.c;
            int r6 = r5.intValue();
            DebugEntrancePageTagListView.a(r0, r6);
            Function2<? super Integer, ? super String, Unit> r1 = r0.d;
            if (r1 == null) goto L12;
            r1.invoke(Integer.valueOf(r6), "");
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ DebugEntrancePageTagListView b;

        public b(View r1, DebugEntrancePageTagListView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            int r0 = ((this.a.getLeft() + (this.a.getWidth() / 2)) - (this.b.getWidth() / 2)) + i5.g();
            ObjectAnimator r1 = this.b.e;
            if (r1 == null) goto L5;
            r1.cancel();
        L5:
            DebugEntrancePageTagListView r2 = this.b;
            ObjectAnimator r3 = ObjectAnimator.ofInt(r2, "scrollX", new int[]{r2.getScrollX(), r0});
            r3.setDuration(200);
            r3.start();
            r2.e = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DebugEntrancePageTagListView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setCurrent(int r2) {
        if (this.f != r2) goto L5;
        return;
    L5:
        this.f = r2;
        b(r2);
    }

    public final void b(int r7) {
        if (r7 >= 0) goto L4;
        return;
    L4:
        if (r7 >= this.a.getChildCount()) goto L21;
        View r8 = ViewGroupKt.get(this.a, r7);
        LinearLayout r0 = this.a;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L15;
        View r3 = r0.getChildAt(r2);
        r3.setSelected(Intrinsics.areEqual(r3, r8));
        if ((r3 instanceof TextView) == false) goto L11;
        TextView r4 = (TextView) r3;
    L12:
        if (r4 == null) goto L14;
        r4.setTypeface(Typeface.DEFAULT, Intrinsics.areEqual(r3, r8) ? 1 : 0);
    L14:
        r2 = r2 + 1;
        goto L7
    L11:
        r4 = null;
        goto L12
    L15:
        postDelayed(new b(r8, this), 100);
        return;
    }

    public final void setupWithViewPager(final ViewPager r10) {
        int r0 = 0;
        setCurrent(0);
        this.d = new c(r10);
        k.a.getClass();
        List<EntrancePage> r1 = k.d;
        this.a.removeAllViews();
        Iterator<T> r2 = r1.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        Object r4 = r2.next();
        int r6 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CharSequence r5 = ((EntrancePage) r4).getDes();
        TextView r7 = new TextView(getContext());
        r7.setText(r5);
        r7.setTextSize(1, 16.0f);
        r7.setTextColor(this.b);
        r7.setBackground(AppCompatResources.getDrawable(r7.getContext(), 2131240275));
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        r8.setMarginStart(i5.e0());
        r8.setMarginEnd(i5.e0());
        r7.setLayoutParams(r8);
        r7.setTag(Integer.valueOf(r3));
        r7.setOnClickListener(this.c);
        r7.setClickable(true);
        this.a.addView(r7);
        r3 = r6;
        goto L4
    L10:
        if ((!r1.isEmpty()) == true) goto L13;
        r0 = 8;
    L13:
        setVisibility(r0);
        b(this.f);
        if (r10 == null) goto L20;
        r10.setOnPageChangeListener(new AnonymousClass2(this));
        return;
    }

    public DebugEntrancePageTagListView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        LinearLayout r5 = new LinearLayout(r3);
        this.a = r5;
        this.b = AppCompatResources.getColorStateList(r3, 2131103020);
        this.c = new a(this);
        this.f = -1;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        r0.bottomMargin = i5.c();
        r5.setOrientation(0);
        addView(r5, r0);
        setHorizontalScrollBarEnabled(false);
    }

    public static final /* synthetic */ void a(DebugEntrancePageTagListView r0, int r1) {
        r0.setCurrent(r1);
    }
}
