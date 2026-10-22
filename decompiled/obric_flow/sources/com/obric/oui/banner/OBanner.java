package com.obric.oui.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.lynx.tasm.ui.image.f0;
import com.obric.common.oui.R$styleable;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001YB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010,\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u00100\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b.\u0010!\u001a\u0004\b/\u0010#R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u00104R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010)\u001a\u0004\b8\u00109R$\u0010>\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u001eR*\u0010G\u001a\u00020?2\u0006\u0010@\u001a\u00020?8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010I\u001a\u00020H2\u0006\u0010@\u001a\u00020H8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0011\u0010N\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bM\u0010\u001eR\u0011\u0010P\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bO\u0010\u001eR\u0011\u0010R\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bQ\u0010\u001eR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00070S8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010#¨\u0006Z"}, d2 = {"Lcom/obric/oui/banner/OBanner;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Lwq/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lwq/b;", "listener", "", "setBannerItemClickListener", "(Lwq/b;)V", "", "Lcom/obric/oui/banner/d;", "dataSet", "setData", "(Ljava/util/List;)V", "Lcom/obric/oui/banner/BannerStyle;", "style", "setBannerStyle", "(Lcom/obric/oui/banner/BannerStyle;)V", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageChangeListener", "setOnPageChangeListener", "(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)V", "getCurrentRealPos", "()I", "", "m", "J", "getDelayAfterUserTouch", "()J", "setDelayAfterUserTouch", "(J)V", "delayAfterUserTouch", "Landroidx/viewpager2/widget/ViewPager2;", "n", "Lkotlin/Lazy;", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "<set-?>", "o", "getLastUserTouchTime", "lastUserTouchTime", "Lcom/obric/oui/banner/BannerAdapter;", "q", "getAdapter", "()Lcom/obric/oui/banner/BannerAdapter;", "adapter", "Landroidx/viewpager2/widget/CompositePageTransformer;", "w", "getCompositePageTransformer", "()Landroidx/viewpager2/widget/CompositePageTransformer;", "compositePageTransformer", "x", "I", "getStartPosition", "startPosition", "", "value", "z", "F", "getProportion", "()F", "setProportion", "(F)V", "proportion", "", "isInfiniteSwitchEnabled", "()Z", "setInfiniteSwitchEnabled", "(Z)V", "getRealCount", "realCount", "getCurrentItem", "currentItem", "getItemCount", "itemCount", "Landroidx/lifecycle/LiveData;", "getSelectedPosition", "()Landroidx/lifecycle/LiveData;", "selectedPosition", "getAutoSwitchIntervalMs", "autoSwitchIntervalMs", "BannerOnPageChangeCallback", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBanner extends RadiusLayout implements wq.a {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f12006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f12007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f12008o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public wq.b f12009p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f12010q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.fragment.app.d f12011r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12012t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12013u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final MutableLiveData f12014v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f12015w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12016x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BannerStyle f12017y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f12018z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/banner/OBanner$BannerOnPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrollStateChanged(int r5) {
            if (r5 != 0) goto L5;
            throw null;
        L5:
            throw null;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrolled(int r5, float r10, int r11) {
            throw null;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageSelected(int r5) {
            throw null;
        }
    }

    @JvmOverloads
    public OBanner(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static final void d(OBanner r5, d r10, int r11) {
        boolean r12 = r5.getAdapter().g;
        int r13 = r5.getCurrentItem();
        int r14 = r5.getRealCount();
        if (r12 == false) goto L10;
        if (r14 > 0) goto L8;
        r14 = 1;
    L8:
        r13 = r13 % r14;
    L10:
        if (r5.getCurrentItem() != 2) goto L15;
        if (r11 != (r5.getRealCount() - 1)) goto L15;
        r5.f(1, true);
        return;
    L15:
        if (r5.getCurrentItem() != (r5.getItemCount() - 3)) goto L19;
        if (r11 != 0) goto L19;
        r5.f(r5.getItemCount() - 2, true);
        return;
    L19:
        if (r13 != (r5.getRealCount() - 1)) goto L22;
        if (r11 != 0) goto L22;
        r5.f(r5.getCurrentItem() + 1, true);
        return;
    L22:
        if (r13 == 0) goto L24;
    L26:
        if (r13 <= r11) goto L28;
        r5.f(r5.getCurrentItem() - 1, true);
        return;
    L28:
        if (r13 >= r11) goto L30;
        r5.f(r5.getCurrentItem() + 1, true);
        return;
    L30:
        wq.b r15 = r5.f12009p;
        if (r15 == null) goto L41;
        ((android.support.v4.media.c) r15).h(r10, r11);
        return;
    L41:
        return;
    L24:
        if (r11 != (r5.getRealCount() - 1)) goto L26;
        r5.f(r5.getCurrentItem() - 1, true);
    }

    private final BannerAdapter getAdapter() {
        return (BannerAdapter) this.f12010q.getValue();
    }

    private final CompositePageTransformer getCompositePageTransformer() {
        return (CompositePageTransformer) this.f12015w.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 != null) goto L4;
        Integer r10 = null;
    L6:
        if (r10 != null) goto L9;
    L11:
        if (r10 != null) goto L14;
    L16:
        if (r10 != null) goto L19;
    L22:
        return super.dispatchTouchEvent(r5);
    L19:
        if (r10.intValue() != 3) goto L22;
    L20:
        this.s = false;
        this.f12008o = SystemClock.uptimeMillis();
        e();
        goto L22
    L14:
        if (r10.intValue() != 1) goto L16;
    L9:
        if (r10.intValue() != 0) goto L11;
        this.s = true;
        goto L22
    L4:
        r10 = Integer.valueOf(r5.getAction());
        goto L6
    }

    public final void e() {
        if (this.f12013u == true) goto L5;
    L27:
        f0.r("检查换页：开关 false，不换页");
        return;
    L5:
        if (this.f12006m <= 0) goto L27;
        if (this.s == false) goto L12;
        f0.r("检查换页：正在拖动，不换页");
        return;
    L12:
        if (isAttachedToWindow() == true) goto L15;
        f0.r("剥离window，不换页");
        return;
    L15:
        long r5 = SystemClock.uptimeMillis() - this.f12008o;
        if (r5 >= this.f12006m) goto L23;
        f0.r("检查换页: 刚松手" + r5 + " ms，delay换页");
        Handler r10 = getHandler();
        if (r10 == null) goto L29;
        r10.postDelayed(this.f12011r, this.f12006m - r5);
        return;
    L29:
        return;
    L23:
        if (this.f12012t == false) goto L25;
        getViewPager2().setCurrentItem(getViewPager2().getCurrentItem() + 1, true);
        return;
    L25:
        f0.r("检查换页：不是业务触发的，不换页");
    }

    public final void f(int r5, boolean r10) {
        if (getViewPager2().getScrollState() == 0) goto L10;
        Log.w("OBanner", "viewPager2 scrollState: " + getViewPager2().getScrollState() + ", ban setCurrentItem");
        return;
    L10:
        getViewPager2().setCurrentItem(r5, r10);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.e("OBanner", Intrinsics.stringPlus("setCurrentItem error, msg: ", e.getMessage()));
    }

    public long getAutoSwitchIntervalMs() {
        return this.f12006m;
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getCurrentRealPos() {
        boolean r5 = getAdapter().g;
        int r10 = getCurrentItem();
        int r11 = getRealCount();
        if (r5 == false) goto L10;
        if (r11 > 0) goto L9;
        r11 = 1;
    L9:
        return r10 % r11;
    L10:
        return r10;
    }

    public final long getDelayAfterUserTouch() {
        return this.f12006m;
    }

    public final int getItemCount() {
        return getAdapter().getItemCount();
    }

    public final long getLastUserTouchTime() {
        return this.f12008o;
    }

    public final float getProportion() {
        return this.f12018z;
    }

    public final int getRealCount() {
        return getAdapter().f.size();
    }

    @Override // wq.a
    public LiveData<Integer> getSelectedPosition() {
        return this.f12014v;
    }

    public final int getStartPosition() {
        return this.f12016x;
    }

    public final ViewPager2 getViewPager2() {
        return (ViewPager2) this.f12007n.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        if (this.f12018z > 0.0f) goto L6;
        super.onMeasure(r5, r10);
        return;
    L6:
        int r11 = View.MeasureSpec.getSize(r5);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r11, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r11 / this.f12018z), BasicMeasure.EXACTLY));
    }

    public final void setBannerItemClickListener(wq.b r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.f12009p = r5;
    }

    public final void setBannerStyle(BannerStyle r5) {
        Intrinsics.checkNotNullParameter(r5, "style");
        this.f12017y = r5;
    }

    public final void setData(List<? extends d> r5) {
        Intrinsics.checkNotNullParameter(r5, "dataSet");
        BannerAdapter r10 = getAdapter();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "value");
        r10.f = r5;
        r10.notifyDataSetChanged();
        int r11 = 1;
        if (r5.size() != 1) goto L10;
        Handler r12 = getHandler();
        if (r12 == null) goto L8;
        r12.removeCallbacks(this.f12011r);
    L8:
        this.f12013u = false;
        setInfiniteSwitchEnabled(false);
    L10:
        if (getAdapter().g == false) goto L13;
        r11 = getRealCount() * 100;
    L16:
        this.f12016x = r11;
        f(r11, false);
        getViewPager2().requestTransform();
        return;
    L13:
        if (b.f12021a[this.f12017y.ordinal()] == 1) goto L16;
        r11 = 0;
        goto L16
    }

    public final void setDelayAfterUserTouch(long r5) {
        this.f12006m = r5;
    }

    public final void setInfiniteSwitchEnabled(boolean r5) {
        getAdapter().g = r5;
        getAdapter().notifyDataSetChanged();
    }

    public final void setOnPageChangeListener(ViewPager2.OnPageChangeCallback r5) {
        Intrinsics.checkNotNullParameter(r5, "onPageChangeListener");
    }

    public final void setProportion(float r5) {
        if (r5 >= 0.0f) goto L5;
        this.f12018z = 0.0f;
        return;
    L5:
        this.f12018z = r5;
        invalidate();
    }

    @JvmOverloads
    public OBanner(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OBanner(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OBanner(final Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f12006m = 5000;
        this.f12007n = LazyKt.lazy(new OBanner$viewPager2$2(r5));
        this.f12008o = -1;
        this.f12010q = LazyKt.lazy(new OBanner$adapter$2(this));
        this.f12011r = new androidx.fragment.app.d(this, 28);
        this.f12014v = new MutableLiveData(0);
        this.f12015w = LazyKt.lazy(OBanner$compositePageTransformer$2.INSTANCE);
        BannerStyle r12 = BannerStyle.FILL;
        this.f12017y = r12;
        if (r10 == null) goto L14;
        TypedArray r13 = r5.obtainStyledAttributes(r10, R$styleable.OBanner);
        int r14 = r13.getInt(R$styleable.OBanner_oui_banner_style, 0);
        if (r14 == 0) goto L12;
        if (r14 != 1) goto L8;
        r12 = BannerStyle.INDENT;
        goto L12
    L8:
        if (r14 != 2) goto L12;
        r12 = BannerStyle.TRIPTYCH;
    L12:
        this.f12017y = r12;
        r13.getBoolean(R$styleable.OBanner_oui_banner_is_pad_grid_adapt_enable, false);
        setProportion(r13.getFloat(R$styleable.OBanner_oui_banner_proportion, 0.0f));
        this.f12013u = r13.getBoolean(R$styleable.OBanner_oui_banner_enableAutoSwitch, false);
        this.f12006m = r13.getInt(R$styleable.OBanner_oui_banner_autoSwitchInterval, 5000);
        setInfiniteSwitchEnabled(r13.getBoolean(R$styleable.OBanner_oui_banner_enableInfiniteSwitch, true));
        r13.recycle();
        return;
    }
}
