package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\u0013¢\u0006\u0004\b8\u00109J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR*\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R*\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010.\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R*\u00102\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\t\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\r¨\u0006;"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/banner/SimpleCarouselIndicator;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/banner/SimpleCarouselViewPager;", "viewPager", "", "setViewPager", "", "value", "b", "F", "getDotsSize", "()F", "setDotsSize", "(F)V", "dotsSize", "c", "getDotsSpacing", "setDotsSpacing", "dotsSpacing", "", "d", "I", "getDotsColor", "()I", "setDotsColor", "(I)V", "dotsColor", "e", "getSelectedDotColor", "setSelectedDotColor", "selectedDotColor", "f", "getDotsCornerRadius", "setDotsCornerRadius", "dotsCornerRadius", "", "g", "Z", "getDotsClickable", "()Z", "setDotsClickable", "(Z)V", "dotsClickable", "h", "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeColor", "i", "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsStrokeWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleCarouselIndicator extends LinearLayout {
    public static final /* synthetic */ int k = 0;
    public final ArrayList<View> a;
    public float b;
    public float c;
    public int d;
    public int e;
    public float f;
    public boolean g;
    public int h;
    public float i;
    public d j;

    public interface a {
        void a(int r1);

        int getCount();
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SimpleCarouselIndicator a;

        public b(SimpleCarouselIndicator r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselIndicator$setViewPager$2$addOnPageChangeListener$1, java.lang.Object] */
        public final void a() {
            d r0 = this.a.j;
            if (r0 != null) goto L5;
        L7:
            SimpleCarouselIndicator r1 = this.a;
            d r2 = r1.j;
            if (r2 != null) goto L11;
        L18:
            this.a.c();
            this.a.d();
            final d r3 = this.a.j;
            if (r3 != null) goto L22;
            return;
        L22:
            if (r3.getCount() <= 0) goto L31;
            SimpleCarouselIndicator$setViewPager$2$addOnPageChangeListener$1 r4 = r3.a;
            if (r4 == null) goto L28;
            SimpleCarouselViewPager r5 = r3.c;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r4, "listener");
            SimpleCarouselViewPager.a r6 = (SimpleCarouselViewPager.a) ((LinkedHashMap) r5.f).get(r4);
            if (r6 == null) goto L28;
            r5.e.removeOnPageChangeListener(r6);
            SimpleCarouselViewPager.a r7 = r5.f.remove(r4);
        L28:
            ?? r8 = new SimpleCarouselIndicator$setViewPager$2$addOnPageChangeListener$1(r3);
            r3.a = r8;
            SimpleCarouselViewPager r9 = r3.c;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r8, "listener");
            SimpleCarouselViewPager.a r10 = new SimpleCarouselViewPager.a(r9, r8);
            r9.e.addOnPageChangeListener(r10);
            r9.f.put((ViewPager.OnPageChangeListener) r8, r10);
            return;
        L31:
            return;
        L11:
            if (r1.a.size() >= r2.getCount()) goto L14;
            r1.a(r2.getCount() - r1.a.size());
            goto L18
        L14:
            if (r1.a.size() <= r2.getCount()) goto L18;
            int r11 = r1.a.size() - r2.getCount();
            int r12 = 0;
        L16:
            if (r12 >= r11) goto L18;
            r1.removeViewAt(r1.getChildCount() - 1);
            ArrayList<View> r13 = r1.a;
            ListProtector.remove(r13, r13.size() - 1);
            r12 = r12 + 1;
            goto L16
        L5:
            if (r0.getCount() != 1) goto L7;
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

    public static final class c extends DataSetObserver {
        public final /* synthetic */ SimpleCarouselIndicator a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.a.b();
        }

        public c(SimpleCarouselIndicator r1) {
            this.a = r1;
        }
    }

    public static final class d implements a {
        public SimpleCarouselIndicator$setViewPager$2$addOnPageChangeListener$1 a;
        public final /* synthetic */ SimpleCarouselIndicator b;
        public final /* synthetic */ SimpleCarouselViewPager c;

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselIndicator.a
        public final int getCount() {
            return this.c.getCount();
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselIndicator.a
        public final void a(int r5) {
            SimpleCarouselViewPager r0 = this.c;
            int r1 = r0.getCount();
            if (r5 < 0) goto L7;
            if (r1 <= r5) goto L7;
            boolean r2 = true;
        L8:
            if (r2 == false) goto L12;
            int r3 = r0.e.getCurrentItem();
            int r4 = r0.getCurrentItem();
            r0.e.setCurrentItem(r3 + (r5 - r4), true);
            return;
        L12:
            return;
        L7:
            r2 = false;
            goto L8
        }

        public d(SimpleCarouselIndicator r1, SimpleCarouselViewPager r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public SimpleCarouselIndicator(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SimpleCarouselIndicator(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        if (this.j != null) goto L5;
        return;
    L5:
        post(new b(this));
    }

    public final void c() {
        int r0 = this.a.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L22;
        View r3 = (View) ListProtector.get(this.a, r2);
        Drawable r4 = r3.getBackground();
        if ((r4 instanceof GradientDrawable) == true) goto L7;
        r4 = null;
    L7:
        GradientDrawable r5 = (GradientDrawable) r4;
        if (r5 == null) goto L15;
        d r6 = this.j;
        if (r6 != null) goto L12;
    L14:
        r5.setColor(this.d);
        goto L15
    L12:
        if (r2 != r6.c.getCurrentItem()) goto L14;
        r5.setColor(this.e);
    L15:
        if (r5 == null) goto L17;
        r5.setCornerRadius(this.f);
    L17:
        float r7 = this.i;
        if (r7 <= 0) goto L21;
        if (r5 == null) goto L21;
        r5.setStroke((int) r7, this.h);
    L21:
        r3.setBackground(r5);
        r3.invalidate();
        r2 = r2 + 1;
        goto L3
    }

    public final void d() {
        d r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.c.getCurrentItem();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        View r3 = (View) ListProtector.get(this.a, r2);
        int r4 = (int) this.b;
        Intrinsics.checkNotNullParameter(r3, "$this$setWidth");
        r3.getLayoutParams().width = r4;
        r3.requestLayout();
        r2 = r2 + 1;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    public final boolean getDotsClickable() {
        return this.g;
    }

    public final int getDotsColor() {
        return this.d;
    }

    public final float getDotsCornerRadius() {
        return this.f;
    }

    public final float getDotsSize() {
        return this.b;
    }

    public final float getDotsSpacing() {
        return this.c;
    }

    public final int getDotsStrokeColor() {
        return this.h;
    }

    public final float getDotsStrokeWidth() {
        return this.i;
    }

    public final int getSelectedDotColor() {
        return this.e;
    }

    public final void a(int r8) {
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L23;
        d r2 = this.j;
        if (r2 == null) goto L22;
        ImageView r3 = new ImageView(getContext());
        int r5 = (int) this.b;
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(r5, r5);
        int r6 = (int) this.c;
        r4.setMargins(r6, 0, r6, 0);
        Unit r7 = Unit.INSTANCE;
        r3.setLayoutParams(r4);
        GradientDrawable r9 = new GradientDrawable();
        r9.setCornerRadius(this.f);
        if (isInEditMode() == false) goto L14;
        if (r1 != 0) goto L11;
        int r10 = this.e;
    L12:
        r9.setColor(r10);
    L18:
        float r11 = this.i;
        if (r11 <= 0) goto L21;
        r9.setStroke((int) r11, this.h);
    L21:
        r3.setBackground(r9);
        r3.setOnClickListener(new hp0.a(this, r1, r2));
        this.a.add(r3);
        addView(r3);
        goto L22
    L11:
        r10 = this.d;
        goto L12
    L14:
        if (r1 != r2.c.getCurrentItem()) goto L16;
        int r12 = this.e;
    L17:
        r9.setColor(r12);
        goto L18
    L16:
        r12 = this.d;
    L22:
        r1 = r1 + 1;
        goto L3
    }

    public final void setDotsClickable(boolean r1) {
        this.g = r1;
    }

    public final void setDotsColor(int r2) {
        if (this.d == r2) goto L6;
        this.d = r2;
        c();
        return;
    }

    public final void setDotsCornerRadius(float r2) {
        if (this.f == r2) goto L6;
        this.f = r2;
        c();
        return;
    }

    public final void setDotsSize(float r2) {
        if (this.b == r2) goto L6;
        this.b = r2;
        d();
        return;
    }

    public final void setDotsSpacing(float r6) {
        if (this.c == r6) goto L16;
        this.c = r6;
        d r7 = this.j;
        if (r7 == null) goto L20;
        int r8 = r7.c.getCurrentItem();
        int r0 = 0;
    L8:
        if (r0 >= r8) goto L21;
        View r1 = (View) ListProtector.get(this.a, r0);
        int r2 = (int) this.c;
        Intrinsics.checkNotNullParameter(r1, "$this$setHorizontalMargin");
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if ((r3 instanceof FrameLayout.LayoutParams) == true) goto L12;
        r3 = null;
    L12:
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        if (r4 == null) goto L15;
        r4.leftMargin = r2;
        r4.rightMargin = r2;
        r1.requestLayout();
    L15:
        r0 = r0 + 1;
        goto L8
    L21:
        return;
    L20:
        return;
    }

    public final void setDotsStrokeColor(int r2) {
        if (this.h == r2) goto L6;
        this.h = r2;
        c();
        return;
    }

    public final void setDotsStrokeWidth(float r2) {
        if (this.i == r2) goto L6;
        this.i = r2;
        c();
        return;
    }

    public final void setSelectedDotColor(int r2) {
        if (this.e == r2) goto L6;
        this.e = r2;
        c();
        return;
    }

    public final void setViewPager(SimpleCarouselViewPager r3) {
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        PagerAdapter r0 = r3.getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerDataSetObserver(new c(this));
        this.j = new d(this, r3);
        b();
    }

    public SimpleCarouselIndicator(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
        this.b = UtilityKotlinExtentionsKt.h(6);
        this.c = UtilityKotlinExtentionsKt.h(3);
        this.d = ColorProtector.parseColor("#56FFFFFF");
        this.e = ColorProtector.parseColor("#BFFFFFFF");
        this.f = this.b / 2;
        this.g = true;
        this.h = ColorProtector.parseColor("#0F161823");
        this.i = UtilityKotlinExtentionsKt.h(0.5f);
        setOrientation(0);
        if (isInEditMode() == false) goto L6;
        a(5);
        b();
        return;
    }

    public /* synthetic */ SimpleCarouselIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
