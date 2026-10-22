package com.larus.bot.impl.common.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import zp9.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bot/impl/common/view/CommonTagListView;", "Lcom/larus/bot/impl/common/view/AbsCommonTagListView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "scrollAnimator", "Landroid/animation/ObjectAnimator;", "textColorStateList", "Landroid/content/res/ColorStateList;", "kotlin.jvm.PlatformType", "bindData", "", "list", "", "Lcom/larus/platform/api/creation/TabTag;", "createItemView", "Landroid/widget/TextView;", "data", "", "createPlaceHolder", "Landroid/view/View;", "select", "index", "", "scrollable", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonTagListView extends AbsCommonTagListView {
    public ObjectAnimator f;
    public final ColorStateList g;

    public static final class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ CommonTagListView b;

        public a(View r1, CommonTagListView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            int r0 = ((this.a.getLeft() + (this.a.getWidth() / 2)) - (this.b.getWidth() / 2)) + i5.g();
            ObjectAnimator r1 = this.b.f;
            if (r1 == null) goto L5;
            r1.cancel();
        L5:
            CommonTagListView r2 = this.b;
            ObjectAnimator r3 = ObjectAnimator.ofInt(r2, "scrollX", new int[]{r2.getScrollX(), r0});
            r3.setDuration(200);
            r3.start();
            r2.f = r3;
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

    public CommonTagListView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void d(List<w> r11) {
        Intrinsics.checkNotNullParameter(r11, "list");
        getContainer().removeAllViews();
        Iterator<T> r0 = r11.iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L17;
        Object r3 = r0.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        w r4 = (w) r3;
        if (r4.a() == false) goto L11;
        View r6 = new View(getContext());
        GradientDrawable r7 = new GradientDrawable();
        r7.setCornerRadius(i5.h());
        r7.setColor(ContextCompat.getColor(r6.getContext(), 2131103162));
        r6.setBackground(r7);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(i5.q0(), i5.W());
        r8.setMarginStart(i5.e0());
        r8.setMarginEnd(i5.e0());
        r6.setLayoutParams(r8);
    L15:
        r6.setTag(Integer.valueOf(r2));
        r6.setOnClickListener(getClickListener());
        r6.setClickable(!r4.a());
        getContainer().addView(r6);
        r2 = r5;
        goto L4
    L11:
        String r9 = r4.b;
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        TextView r10 = new TextView(getContext());
        r10.setText(r9);
        r10.setTextSize(1, 16.0f);
        r10.setTextColor(this.g);
        r10.setBackground(AppCompatResources.getDrawable(r10.getContext(), 2131243597));
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, -2);
        r12.setMarginStart(i5.e0());
        r12.setMarginEnd(i5.e0());
        r10.setLayoutParams(r12);
        r6 = r10;
        goto L15
    L17:
        if ((!r11.isEmpty()) == true) goto L20;
        r1 = 8;
    L20:
        setVisibility(r1);
        b(getCurrent(), true);
    }

    public CommonTagListView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.g = AppCompatResources.getColorStateList(r2, 2131102607);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -2);
        r4.bottomMargin = i5.c();
        getContainer().setOrientation(0);
        addView(getContainer(), r4);
        setHorizontalScrollBarEnabled(false);
    }

    public final void b(int r6, boolean r7) {
        if (r6 >= 0) goto L4;
        return;
    L4:
        if (r6 >= getContainer().getChildCount()) goto L21;
        setInnerCurrent(r6);
        View r8 = ViewGroupKt.get(getContainer(), r6);
        LinearLayout r9 = getContainer();
        int r0 = r9.getChildCount();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L15;
        View r2 = r9.getChildAt(r1);
        r2.setSelected(Intrinsics.areEqual(r2, r8));
        if ((r2 instanceof TextView) == false) goto L11;
        TextView r3 = (TextView) r2;
    L12:
        if (r3 == null) goto L14;
        r3.setTypeface(Typeface.DEFAULT, Intrinsics.areEqual(r2, r8) ? 1 : 0);
    L14:
        r1 = r1 + 1;
        goto L7
    L11:
        r3 = null;
        goto L12
    L15:
        postDelayed(new a(r8, this), 100);
        return;
    }
}
