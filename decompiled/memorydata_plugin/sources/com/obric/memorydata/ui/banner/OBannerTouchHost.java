package com.obric.memorydata.ui.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.banner.OBanner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001-B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u001aH\u0014J\b\u0010#\u001a\u00020\u001aH\u0014J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001fH\u0002J\n\u0010)\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020\u001aH\u0002R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/memorydata/ui/banner/OBannerTouchHost;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", EventBody.KEY_VALUE, "Lcom/obric/oui/banner/OBanner;", "oBanner", "getOBanner", "()Lcom/obric/oui/banner/OBanner;", "touchSlop", "downX", "", "downY", "touchDirection", "isTouchingOBanner", "", "releasedToParent", "registeredParent", "Lcom/obric/memorydata/ui/banner/BannerFriendlyFrameLayout;", "setupOBanner", "", "banner", "attachToHost", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "onAttachedToWindow", "onDetachedFromWindow", "resolveTouchDirection", "isTouchInChild", "child", "Landroid/view/View;", "cancelOBannerTouch", "findBannerTouchChildAwareParent", "requestParentsDisallowIntercept", "disallowIntercept", "resetTouchState", "Companion", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class OBannerTouchHost extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OBanner f12989b;
    private final int c;
    private float d;
    private float e;
    private int f;
    private boolean g;
    private boolean h;
    private BannerFriendlyFrameLayout i;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/ui/banner/OBannerTouchHost$Companion;", "", "<init>", "()V", "TOUCH_DIRECTION_UNDECIDED", "", "TOUCH_DIRECTION_HORIZONTAL", "TOUCH_DIRECTION_VERTICAL", "VERTICAL_SCROLL_TRIGGER_RATIO", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12988a = new a(null);
    }

    public OBannerTouchHost(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBannerTouchHost(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OBannerTouchHost(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.c = ViewConfiguration.get(r6).getScaledTouchSlop();
    }

    public /* synthetic */ OBannerTouchHost(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final int a(MotionEvent r4) {
        int r0 = this.f;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        float r1 = Math.abs(r4.getX() - this.d);
        float r5 = Math.abs(r4.getY() - this.e);
        int r2 = this.c;
        if (r1 > r2) goto L12;
        if (r5 > r2) goto L12;
        return 0;
    L12:
        if (r5 < (r1 * 2.0f)) goto L14;
        int r6 = 2;
    L15:
        this.f = r6;
        return r6;
    L14:
        r6 = 1;
        goto L15
    }

    private final BannerFriendlyFrameLayout a() {
        ViewParent r2 = getParent();
    L4:
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, BannerFriendlyFrameLayout.class) == true) goto L8;
        r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin")).getParent();
        goto L4
    L8:
        return (BannerFriendlyFrameLayout) ZeusTransformUtils.preCheckCast(r2, BannerFriendlyFrameLayout.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    }

    public static /* synthetic */ void a(OBannerTouchHost r0, OBanner r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        r0.a(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupOBanner");
    }

    private final void a(boolean r3) {
        ViewParent r2 = getParent();
    L4:
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L6;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin")).requestDisallowInterceptTouchEvent(r3);
        r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin")).getParent();
        goto L4
    }

    private final boolean a(View r7, MotionEvent r8) {
        int[] r1 = new int[2];
        r7.getLocationOnScreen(r1);
        int[] r0 = new int[2];
        getLocationOnScreen(r0);
        float r6 = r8.getRawX() - r0[0];
        float r9 = r8.getRawY() - r0[1];
        int r4 = r1[0] - r0[0];
        int r2 = r1[1] - r0[1];
        if (r6 >= r4) goto L5;
        return false;
    L5:
        if (r6 <= (r4 + r7.getWidth())) goto L7;
        return false;
    L7:
        if (r9 >= r2) goto L9;
        return false;
    L9:
        if (r9 <= (r2 + r7.getHeight())) goto L11;
        return false;
    L11:
        return true;
    }

    private final void b() {
        a(false);
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0;
        this.g = false;
        this.h = false;
    }

    private final void b(MotionEvent r2) {
        MotionEvent r3 = MotionEvent.obtain(r2);
        r3.setAction(3);
        getOBanner().dispatchTouchEvent(r3);
        r3.recycle();
    }

    public final void a(OBanner r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "banner");
        this.f12989b = r4;
        if (r5 == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4.getParent(), this) == true) goto L15;
        ViewParent r6 = r4.getParent();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L9;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin");
    L10:
        if (r7 == null) goto L12;
        r7.removeView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
    L12:
        addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        r7 = null;
        goto L10
    }

    public final OBanner getOBanner() {
        OBanner r0 = this.f12989b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("oBanner");
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        BannerFriendlyFrameLayout r0 = a();
        if (r0 == null) goto L5;
        r0.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L6:
        this.i = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        BannerFriendlyFrameLayout r0 = this.i;
        if (r0 == null) goto L5;
        r0.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L5:
        this.i = null;
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (this.f12989b == null) goto L5;
        int r0 = r5.getActionMasked();
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L19;
        return super.onInterceptTouchEvent(r5);
    L19:
        return this.g;
    L15:
        this.d = r5.getX();
        this.e = r5.getY();
        this.f = 0;
        this.h = false;
        boolean r6 = a((View) ZeusTransformUtils.preCheckCast(getOBanner(), View.class, "com.obric.memorydata.plugin"), r5);
        this.g = r6;
        if (r6 == false) goto L19;
        a(true);
        goto L19
    L5:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.f12989b == null) goto L35;
        if (this.g == false) goto L35;
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L10;
        a(true);
        getOBanner().dispatchTouchEvent(r5);
        return true;
    L10:
        if (r0 == 1) goto L28;
        if (r0 != 2) goto L14;
        int r1 = a(r5);
        if (r1 == 1) goto L25;
        if (r1 != 2) goto L25;
        if (this.h == true) goto L36;
        this.h = true;
        a(false);
        b(r5);
        return true;
    L36:
        return true;
    L25:
        a(true);
    L38:
        return getOBanner().dispatchTouchEvent(r5);
    L14:
        if (r0 == 3) goto L28;
        if (this.h == false) goto L38;
        return true;
    L28:
        if (this.h == false) goto L30;
        a(false);
    L31:
        b();
        return true;
    L30:
        getOBanner().dispatchTouchEvent(r5);
    L35:
        return super.onTouchEvent(r5);
    }
}
