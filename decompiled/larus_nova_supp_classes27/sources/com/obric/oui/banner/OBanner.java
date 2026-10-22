package com.obric.oui.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002VWB'\b\u0007\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u0012\b\b\u0002\u0010S\u001a\u00020\u0011¢\u0006\u0004\bT\u0010UJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u0017R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010-R$\u00103\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R*\u0010<\u001a\u0002042\u0006\u00105\u001a\u0002048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010B\u001a\u00020=2\u0006\u00105\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0011\u0010D\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bC\u00102R\u0011\u0010F\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bE\u00102R\u0011\u0010H\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bG\u00102R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00110I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0017¨\u0006X"}, d2 = {"Lcom/obric/oui/banner/OBanner;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Lkla/a;", "Lkla/b;", "listener", "", "setBannerItemClickListener", "", "Lcom/obric/oui/banner/b;", "dataSet", "setData", "Lcom/obric/oui/banner/BannerStyle;", "style", "setBannerStyle", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageChangeListener", "setOnPageChangeListener", "", "getCurrentRealPos", "", "m", "J", "getDelayAfterUserTouch", "()J", "setDelayAfterUserTouch", "(J)V", "delayAfterUserTouch", "Landroidx/viewpager2/widget/ViewPager2;", "n", "Lkotlin/Lazy;", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "<set-?>", "o", "getLastUserTouchTime", "lastUserTouchTime", "Lcom/obric/oui/banner/BannerAdapter;", "q", "getAdapter", "()Lcom/obric/oui/banner/BannerAdapter;", "adapter", "Landroidx/viewpager2/widget/CompositePageTransformer;", "w", "getCompositePageTransformer", "()Landroidx/viewpager2/widget/CompositePageTransformer;", "compositePageTransformer", "x", "I", "getStartPosition", "()I", "startPosition", "", "value", "z", "F", "getProportion", "()F", "setProportion", "(F)V", "proportion", "", "f", "()Z", "setInfiniteSwitchEnabled", "(Z)V", "isInfiniteSwitchEnabled", "getRealCount", "realCount", "getCurrentItem", "currentItem", "getItemCount", "itemCount", "Landroidx/lifecycle/LiveData;", "getSelectedPosition", "()Landroidx/lifecycle/LiveData;", "selectedPosition", "getAutoSwitchIntervalMs", "autoSwitchIntervalMs", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BannerOnPageChangeCallback", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBanner extends RadiusLayout implements kla.a {
    public static final /* synthetic */ int A = 0;
    public long m;
    public final Lazy n;
    public long o;
    public kla.b p;
    public final Lazy q;
    public final f r;
    public boolean s;
    public boolean t;
    public boolean u;
    public final MutableLiveData<Integer> v;
    public final Lazy w;
    public int x;
    public BannerStyle y;
    public float z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/banner/OBanner$BannerOnPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public final class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        public final void onPageScrollStateChanged(int r2) {
            if (r2 != 0) goto L5;
            throw null;
        L5:
            throw null;
        }

        public final void onPageSelected(int r1) {
            int r2 = lla.a.a;
            throw null;
        }

        public final void onPageScrolled(int r1, float r2, int r3) {
            int r4 = lla.a.a;
            throw null;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BannerStyle.values().length];
            r0[BannerStyle.TRIPTYCH.ordinal()] = 1;
            r0[BannerStyle.FILL.ordinal()] = 2;
            r0[BannerStyle.INDENT.ordinal()] = 3;
            a = r0;
        }
    }

    static {
    }

    public OBanner(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OBanner(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // kla.a
    public final void a() {
        this.t = true;
        e();
    }

    public final void setOnPageChangeListener(ViewPager2.OnPageChangeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "onPageChangeListener");
    }

    private final BannerAdapter getAdapter() {
        return (BannerAdapter) this.q.getValue();
    }

    private final CompositePageTransformer getCompositePageTransformer() {
        return (CompositePageTransformer) this.w.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        if (this.u == true) goto L5;
    L27:
        pla.c.a("检查换页：开关 false，不换页");
        return;
    L5:
        if (this.m <= 0) goto L27;
        if (this.s == false) goto L12;
        pla.c.a("检查换页：正在拖动，不换页");
        return;
    L12:
        if (isAttachedToWindow() == true) goto L15;
        pla.c.a("剥离window，不换页");
        return;
    L15:
        long r0 = SystemClock.uptimeMillis() - this.o;
        if (r0 >= this.m) goto L23;
        pla.c.a("检查换页: 刚松手" + r0 + " ms，delay换页");
        Handler r2 = getHandler();
        if (r2 == null) goto L29;
        r2.postDelayed(this.r, this.m - r0);
        return;
    L29:
        return;
    L23:
        if (this.t == false) goto L25;
        getViewPager2().setCurrentItem(getViewPager2().getCurrentItem() + 1, true);
        return;
    L25:
        pla.c.a("检查换页：不是业务触发的，不换页");
    }

    public final int getCurrentRealPos() {
        int r0 = lla.a.a;
        boolean r1 = f();
        int r2 = getCurrentItem();
        int r3 = getRealCount();
        if (r1 == false) goto L10;
        if (r3 > 0) goto L9;
        r3 = 1;
    L9:
        return r2 % r3;
    L10:
        return r2;
    }

    public final ViewPager2 getViewPager2() {
        return (ViewPager2) this.n.getValue();
    }

    public final boolean f() {
        return getAdapter().g;
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getItemCount() {
        return getAdapter().getItemCount();
    }

    public final int getRealCount() {
        return getAdapter().f.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        e();
    }

    public long getAutoSwitchIntervalMs() {
        return this.m;
    }

    public final long getDelayAfterUserTouch() {
        return this.m;
    }

    public final long getLastUserTouchTime() {
        return this.o;
    }

    public final float getProportion() {
        return this.z;
    }

    @Override // kla.a
    public LiveData<Integer> getSelectedPosition() {
        return this.v;
    }

    public final int getStartPosition() {
        return this.x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 != null) goto L4;
        Integer r0 = null;
    L5:
        boolean r1 = true;
        if (r0 == null) goto L12;
        if (r0.intValue() != 0) goto L12;
        this.s = true;
    L26:
        return super/*android.widget.FrameLayout*/.dispatchTouchEvent(r5);
    L12:
        if (r0 != null) goto L15;
    L17:
        if (r0 != null) goto L20;
    L22:
        r1 = false;
    L23:
        if (r1 == false) goto L26;
        this.s = false;
        this.o = SystemClock.uptimeMillis();
        e();
        goto L26
    L20:
        if (r0.intValue() != 3) goto L22;
    L15:
        if (r0.intValue() != 1) goto L17;
    L4:
        r0 = Integer.valueOf(r5.getAction());
        goto L5
    }

    public final void setBannerItemClickListener(kla.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.p = r2;
    }

    public final void setBannerStyle(BannerStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        this.y = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setData(List<? extends com.obric.oui.banner.b> r4) {
        Intrinsics.checkNotNullParameter(r4, "dataSet");
        BannerAdapter r0 = getAdapter();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "value");
        r0.f = r4;
        r0.notifyDataSetChanged();
        int r1 = 1;
        if (r4.size() != 1) goto L10;
        Handler r5 = getHandler();
        if (r5 == null) goto L8;
        r5.removeCallbacks(this.r);
    L8:
        this.u = false;
        setInfiniteSwitchEnabled(false);
    L10:
        if (f() == false) goto L12;
        r1 = getRealCount() * 100;
    L16:
        this.x = r1;
        g(r1, false);
        getViewPager2().requestTransform();
        return;
    L12:
        BannerStyle r6 = this.y;
        if (b.a[r6.ordinal()] == 1) goto L16;
        r1 = 0;
        goto L16
    }

    public final void setDelayAfterUserTouch(long r1) {
        this.m = r1;
    }

    public final void setInfiniteSwitchEnabled(boolean r2) {
        getAdapter().g = r2;
        getAdapter().notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setProportion(float r3) {
        if (r3 >= 0.0f) goto L5;
        this.z = 0.0f;
        return;
    L5:
        this.z = r3;
        invalidate();
    }

    public final void g(int r2, boolean r3) {
        if (getViewPager2().getScrollState() == 0) goto L10;
        getViewPager2().getScrollState();
        return;
    L10:
        getViewPager2().setCurrentItem(r2, r3);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Intrinsics.stringPlus("setCurrentItem error, msg: ", e.getMessage());
    }

    public final void onMeasure(int r3, int r4) {
        if (this.z > 0.0f) goto L6;
        super.onMeasure(r3, r4);
        return;
    L6:
        int r5 = View.MeasureSpec.getSize(r3);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r5 / this.z), 1073741824));
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [com.obric.oui.banner.f] */
    public OBanner(final Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.m = 5000;
        this.n = LazyKt.lazy(new OBanner$viewPager2$2(r4));
        this.o = -1;
        this.q = LazyKt.lazy(new OBanner$adapter$2(this));
        this.r = new f(this);
        this.v = new MutableLiveData(0);
        this.w = LazyKt.lazy(OBanner$compositePageTransformer$2.INSTANCE);
        BannerStyle r7 = BannerStyle.FILL;
        this.y = r7;
        if (r5 == null) goto L13;
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{2130973044, 2130973045, 2130973046, 2130973047, 2130973048, 2130973049});
        int r9 = r8.getInt(5, 0);
        if (r9 == 0) goto L11;
        if (r9 == 1) goto L10;
        if (r9 != 2) goto L11;
        r7 = BannerStyle.TRIPTYCH;
        goto L11
    L10:
        r7 = BannerStyle.INDENT;
    L11:
        this.y = r7;
        r8.getBoolean(3, false);
        setProportion(r8.getFloat(4, 0.0f));
        this.u = r8.getBoolean(1, false);
        this.m = r8.getInt(0, 5000);
        setInfiniteSwitchEnabled(r8.getBoolean(2, true));
        r8.recycle();
        return;
    }

    public /* synthetic */ OBanner(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
