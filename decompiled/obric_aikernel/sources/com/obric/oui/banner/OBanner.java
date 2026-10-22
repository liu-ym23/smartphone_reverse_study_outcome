package com.obric.oui.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0002WXB'\b\u0007\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u0012\b\b\u0002\u0010S\u001a\u00020\u0011¢\u0006\u0004\bT\u0010UJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001b\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u001eR\"\u0010)\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010(R\u0013\u0010+\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010\u001aR\u0013\u0010-\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\u001aR*\u00106\u001a\u00020.2\u0006\u0010/\u001a\u00020.8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001d\u0010;\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0015\u001a\u0004\b9\u0010:R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00110<8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R$\u0010E\u001a\u00020@2\u0006\u0010/\u001a\u00020@8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001d\u0010J\u001a\u00020F8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0015\u001a\u0004\bH\u0010IR$\u0010N\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010\u001a¨\u0006Y"}, d2 = {"Lcom/obric/oui/banner/OBanner;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Lk9/a;", "Lk9/b;", "listener", "", "setBannerItemClickListener", "", "Lcom/obric/oui/banner/a;", "dataSet", "setData", "Lcom/obric/oui/banner/BannerStyle;", "style", "setBannerStyle", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageChangeListener", "setOnPageChangeListener", "", "getCurrentRealPos", "Landroidx/viewpager2/widget/CompositePageTransformer;", "x", "Lkotlin/Lazy;", "getCompositePageTransformer", "()Landroidx/viewpager2/widget/CompositePageTransformer;", "compositePageTransformer", "getCurrentItem", "()I", "currentItem", "", "getAutoSwitchIntervalMs", "()J", "autoSwitchIntervalMs", "<set-?>", "p", "J", "getLastUserTouchTime", "lastUserTouchTime", "n", "getDelayAfterUserTouch", "setDelayAfterUserTouch", "(J)V", "delayAfterUserTouch", "getRealCount", "realCount", "getItemCount", "itemCount", "", EventBody.KEY_VALUE, "C", "F", "getProportion", "()F", "setProportion", "(F)V", "proportion", "Lcom/obric/oui/banner/BannerAdapter;", "r", "getAdapter", "()Lcom/obric/oui/banner/BannerAdapter;", "adapter", "Landroidx/lifecycle/LiveData;", "getSelectedPosition", "()Landroidx/lifecycle/LiveData;", "selectedPosition", "", "s", "()Z", "setInfiniteSwitchEnabled", "(Z)V", "isInfiniteSwitchEnabled", "Landroidx/viewpager2/widget/ViewPager2;", "o", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "z", "I", "getStartPosition", "startPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "BannerOnPageChangeCallback", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBanner extends RadiusLayout implements k9.a {
    public static final a D = null;
    private BannerStyle A;
    private boolean B;
    private float C;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f6226n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f6227o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f6228p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private k9.b f6229q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f6230r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Runnable f6231s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f6232t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f6233u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f6234v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private MutableLiveData<Integer> f6235w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f6236x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f6237y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f6238z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/banner/OBanner$BannerOnPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "positionOffset", "positionOffsetPixels", "", "onPageScrolled", "onPageSelected", "state", "onPageScrollStateChanged", "tempPosition", "I", "<init>", "(Lcom/obric/oui/banner/OBanner;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public final class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private int tempPosition;
        final /* synthetic */ OBanner this$0;

        public BannerOnPageChangeCallback(OBanner r10) {
            this.this$0 = r10;
            this.tempPosition = -1;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int r10) {
            if (r10 != 0) goto L30;
            if (this.tempPosition == (-1)) goto L30;
            if (d.f6242b[OBanner.j(this.this$0).ordinal()] != 1) goto L8;
            int r11 = this.tempPosition;
            if (r11 != 0) goto L21;
        L19:
            OBanner r12 = this.this$0;
            int r13 = r12.getStartPosition();
        L20:
            r12.u(r13, false);
            goto L30
        L21:
            if (r11 != 1) goto L24;
            r12 = this.this$0;
            r13 = r12.getStartPosition() + 1;
            goto L20
        L24:
            if (r11 != (this.this$0.getItemCount() - 1)) goto L27;
            r12 = this.this$0;
            r13 = r12.getStartPosition() - 1;
            goto L20
        L27:
            if (r11 != (this.this$0.getItemCount() - 2)) goto L30;
        L8:
            if (this.tempPosition == (-1)) goto L30;
            if (this.this$0.s() == false) goto L30;
            int r14 = this.tempPosition;
            if (r14 != 0) goto L15;
            r12 = this.this$0;
            r13 = r12.getRealCount();
            goto L20
        L15:
            if (r14 != (this.this$0.getItemCount() - 1)) goto L30;
            this.this$0.u(1, false);
        L30:
            if (OBanner.k(this.this$0) == null) goto L35;
            ViewPager2.OnPageChangeCallback r15 = OBanner.k(this.this$0);
            if (r15 == null) goto L36;
            r15.onPageScrollStateChanged(r10);
            return;
        L36:
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int r10, float r11, int r12) {
            int r13 = l9.a.f10916a.a(this.this$0.s(), r10, this.this$0.getRealCount());
            boolean r14 = false;
            if (d.f6241a[OBanner.j(this.this$0).ordinal()] == 1) goto L8;
            if (r13 != (this.this$0.getCurrentItem() - 1)) goto L11;
        L9:
            r14 = true;
        L11:
            if (OBanner.k(this.this$0) == null) goto L17;
            if (r14 == false) goto L18;
            ViewPager2.OnPageChangeCallback r15 = OBanner.k(this.this$0);
            if (r15 == null) goto L19;
            r15.onPageScrolled(r13, r11, r12);
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        L8:
            if (r13 != (((this.this$0.getCurrentItem() - 2) + this.this$0.getRealCount()) % this.this$0.getRealCount())) goto L11;
            goto L9
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int r10) {
            int r11 = l9.a.f10916a.a(this.this$0.s(), r10, this.this$0.getRealCount());
            this.tempPosition = r10;
            if (OBanner.k(this.this$0) == null) goto L7;
            ViewPager2.OnPageChangeCallback r12 = OBanner.k(this.this$0);
            if (r12 == null) goto L7;
            r12.onPageSelected(r11);
        L7:
            OBanner.o(this.this$0, false);
            OBanner.l(this.this$0).setValue(Integer.valueOf(r11));
            if (OBanner.h(this.this$0) == true) goto L11;
            ea.b.a("OBanner", "onPageSelected, position: " + r10 + ", realPosition: " + r11);
            q9.a.b(this.this$0.getContext(), 3);
            OBanner.n(this.this$0, true);
            return;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final BannerStyle a(int r10) {
            if (r10 == 0) goto L11;
            if (r10 == 1) goto L13;
            if (r10 != 2) goto L11;
            return BannerStyle.TRIPTYCH;
        L13:
            return BannerStyle.INDENT;
        L11:
            return BannerStyle.FILL;
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OBanner f6240c;

        b(OBanner r10) {
            this.f6240c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OBanner.f(this.f6240c);
        }
    }

    static {
        D = new a(null);
    }

    @JvmOverloads
    public OBanner(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OBanner(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OBanner(final Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f6226n = 5000;
        this.f6227o = LazyKt.lazy(new OBanner$viewPager2$2(r10));
        this.f6228p = -1;
        this.f6230r = LazyKt.lazy(new OBanner$adapter$2(this));
        this.f6231s = new b(this);
        this.f6235w = new MutableLiveData(0);
        this.f6236x = LazyKt.lazy(OBanner$compositePageTransformer$2.INSTANCE);
        this.A = BannerStyle.FILL;
        this.B = true;
        if (r11 == null) goto L6;
        TypedArray r13 = r10.obtainStyledAttributes(r11, l.OBanner);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…trs, R.styleable.OBanner)");
        this.A = D.a(r13.getInt(l.OBanner_oui_banner_style, 0));
        r13.getBoolean(l.OBanner_oui_banner_is_pad_grid_adapt_enable, false);
        setProportion(r13.getFloat(l.OBanner_oui_banner_proportion, 0.0f));
        this.f6234v = r13.getBoolean(l.OBanner_oui_banner_enableAutoSwitch, false);
        this.f6226n = r13.getInt(l.OBanner_oui_banner_autoSwitchInterval, (int) 5000);
        setInfiniteSwitchEnabled(r13.getBoolean(l.OBanner_oui_banner_enableInfiniteSwitch, true));
        r13.recycle();
        return;
    }

    public /* synthetic */ OBanner(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ void f(OBanner r10) {
        r10.p();
    }

    public static final /* synthetic */ BannerAdapter g(OBanner r10) {
        return r10.getAdapter();
    }

    private final BannerAdapter getAdapter() {
        return (BannerAdapter) this.f6230r.getValue();
    }

    private final CompositePageTransformer getCompositePageTransformer() {
        return (CompositePageTransformer) this.f6236x.getValue();
    }

    public static final /* synthetic */ boolean h(OBanner r10) {
        return r10.B;
    }

    public static final /* synthetic */ k9.b i(OBanner r10) {
        return r10.f6229q;
    }

    public static final /* synthetic */ BannerStyle j(OBanner r10) {
        return r10.A;
    }

    public static final /* synthetic */ ViewPager2.OnPageChangeCallback k(OBanner r10) {
        return r10.f6237y;
    }

    public static final /* synthetic */ MutableLiveData l(OBanner r10) {
        return r10.f6235w;
    }

    public static final /* synthetic */ void m(OBanner r10, com.obric.oui.banner.a r11, int r12) {
        r10.t(r11, r12);
    }

    public static final /* synthetic */ void n(OBanner r10, boolean r11) {
        r10.B = r11;
    }

    public static final /* synthetic */ void o(OBanner r10, boolean r11) {
        r10.f6233u = r11;
    }

    private final void p() {
        if (this.f6234v == true) goto L5;
    L26:
        String r10 = "检查换页：开关 false，不换页";
    L10:
        com.obric.oui.common.util.e.a(r10);
        return;
    L5:
        if (this.f6226n <= 0) goto L26;
        if (this.f6232t == false) goto L13;
        r10 = "检查换页：正在拖动，不换页";
        goto L10
    L13:
        if (isAttachedToWindow() == true) goto L15;
        r10 = "剥离window，不换页";
        goto L10
    L15:
        long r11 = SystemClock.uptimeMillis() - this.f6228p;
        if (r11 >= this.f6226n) goto L22;
        com.obric.oui.common.util.e.a("检查换页: 刚松手" + r11 + " ms，delay换页");
        Handler r12 = getHandler();
        if (r12 == null) goto L27;
        r12.postDelayed(this.f6231s, this.f6226n - r11);
        return;
    L27:
        return;
    L22:
        if (this.f6233u == false) goto L24;
        v();
        return;
    L24:
        com.obric.oui.common.util.e.a("检查换页：不是业务触发的，不换页");
    }

    private final void q() {
        Handler r10 = getHandler();
        if (r10 == null) goto L6;
        r10.removeCallbacks(this.f6231s);
        return;
    }

    private final void t(com.obric.oui.banner.a r10, int r11) {
        int r12 = l9.a.f10916a.a(s(), getCurrentItem(), getRealCount());
        if (getCurrentItem() != 2) goto L8;
        if (r11 != (getRealCount() - 1)) goto L8;
        u(1, true);
        return;
    L8:
        if (getCurrentItem() != (getItemCount() - 3)) goto L13;
        if (r11 != 0) goto L13;
        int r13 = getItemCount() - 2;
    L11:
        u(r13, true);
        return;
    L13:
        if (r12 != (getRealCount() - 1)) goto L16;
        if (r11 != 0) goto L16;
    L15:
        r13 = getCurrentItem() + 1;
    L16:
        if (r12 == 0) goto L18;
    L20:
        if (r12 <= r11) goto L22;
    L21:
        r13 = getCurrentItem() - 1;
        goto L11
    L22:
        if (r12 < r11) goto L15;
        k9.b r14 = this.f6229q;
        if (r14 == null) goto L30;
        r14.a(r10, r11);
        return;
    L30:
        return;
    L18:
        if (r11 != (getRealCount() - 1)) goto L20;
        goto L20
    }

    @Override // k9.a
    public void a() {
        this.f6233u = true;
        p();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L4;
        Integer r11 = Integer.valueOf(r10.getAction());
    L6:
        if (r11 != null) goto L9;
    L11:
        if (r11 == null) goto L17;
        if (r11.intValue() != 1) goto L17;
    L21:
        this.f6232t = false;
        this.f6228p = SystemClock.uptimeMillis();
        p();
    L23:
        return super.dispatchTouchEvent(r10);
    L17:
        if (r11 == null) goto L23;
        if (r11.intValue() != 3) goto L23;
    L9:
        if (r11.intValue() != 0) goto L11;
        this.f6232t = true;
        this.B = false;
        goto L23
    L4:
        r11 = null;
        goto L6
    }

    @Override // k9.a
    public long getAutoSwitchIntervalMs() {
        return this.f6226n;
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getCurrentRealPos() {
        return l9.a.f10916a.a(s(), getCurrentItem(), getRealCount());
    }

    public final long getDelayAfterUserTouch() {
        return this.f6226n;
    }

    public final int getItemCount() {
        return getAdapter().getItemCount();
    }

    public final long getLastUserTouchTime() {
        return this.f6228p;
    }

    public final float getProportion() {
        return this.C;
    }

    public final int getRealCount() {
        return getAdapter().getRealItemCount();
    }

    @Override // k9.a
    public LiveData<Integer> getSelectedPosition() {
        return this.f6235w;
    }

    public final int getStartPosition() {
        return this.f6238z;
    }

    public final ViewPager2 getViewPager2() {
        return (ViewPager2) this.f6227o.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        if (this.C > 0) goto L6;
        super.onMeasure(r10, r11);
        return;
    L6:
        int r12 = View.MeasureSpec.getSize(r10);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r12, 1073741824), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r12 / this.C), 1073741824));
    }

    public final void r() {
        q();
        this.f6234v = false;
    }

    public final boolean s() {
        return getAdapter().getUseInfiniteItemCount();
    }

    public final void setBannerItemClickListener(k9.b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.f6229q = r10;
    }

    public final void setBannerStyle(BannerStyle r10) {
        Intrinsics.checkNotNullParameter(r10, "style");
        this.A = r10;
    }

    public final void setData(List<? extends com.obric.oui.banner.a> r10) {
        Intrinsics.checkNotNullParameter(r10, "dataSet");
        getAdapter().setDataSet(r10);
        int r11 = 1;
        if (r10.size() != 1) goto L6;
        r();
        setInfiniteSwitchEnabled(false);
    L6:
        if (s() == false) goto L9;
        r11 = getRealCount() * 100;
    L11:
        this.f6238z = r11;
        u(r11, false);
        getViewPager2().requestTransform();
        return;
    L9:
        if (e.f6244b[this.A.ordinal()] == 1) goto L11;
        r11 = 0;
        goto L11
    }

    public final void setDelayAfterUserTouch(long r10) {
        this.f6226n = r10;
    }

    public final void setInfiniteSwitchEnabled(boolean r10) {
        getAdapter().setUseInfiniteItemCount(r10);
        getAdapter().notifyDataSetChanged();
    }

    public final void setOnPageChangeListener(ViewPager2.OnPageChangeCallback r10) {
        Intrinsics.checkNotNullParameter(r10, "onPageChangeListener");
        this.f6237y = r10;
    }

    public final void setProportion(float r10) {
        if (r10 >= 0) goto L5;
        this.C = 0.0f;
        return;
    L5:
        this.C = r10;
        invalidate();
    }

    public final OBanner u(int r10, boolean r11) {
        if (getViewPager2().getScrollState() == 0) goto L10;
        Log.w("OBanner", "viewPager2 scrollState: " + getViewPager2().getScrollState() + ", ban setCurrentItem");
    L9:
        return this;
    L10:
        getViewPager2().setCurrentItem(r10, r11);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.e("OBanner", "setCurrentItem error, msg: " + e.getMessage());
        goto L9
    }

    public final void v() {
        getViewPager2().setCurrentItem(getViewPager2().getCurrentItem() + 1, true);
    }
}
