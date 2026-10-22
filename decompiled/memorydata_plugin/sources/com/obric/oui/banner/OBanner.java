package com.obric.oui.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u0002:\u0004\u008b\u0001\u008c\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020?2\u0006\u0010Z\u001a\u00020&H\u0002J \u0010[\u001a\u00020X2\u0006\u0010Y\u001a\u00020?2\u0006\u0010\\\u001a\u00020\b2\u0006\u0010Z\u001a\u00020&H\u0002J\b\u0010]\u001a\u00020XH\u0002J\b\u0010^\u001a\u00020XH\u0002J\u0010\u0010_\u001a\u00020X2\u0006\u0010Y\u001a\u00020?H\u0003J\b\u0010`\u001a\u00020XH\u0016J\u0006\u0010a\u001a\u00020XJ\u0012\u0010b\u001a\u00020&2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\u0006\u0010e\u001a\u00020XJ\u000e\u0010f\u001a\u00020X2\u0006\u0010g\u001a\u00020&J\u0006\u0010h\u001a\u00020\bJ\u001e\u0010i\u001a\u00020X2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bJ\u0006\u0010m\u001a\u00020XJ\b\u0010n\u001a\u00020XH\u0014J\b\u0010o\u001a\u00020XH\u0014J\u0018\u0010p\u001a\u00020X2\u0006\u0010q\u001a\u00020\b2\u0006\u0010r\u001a\u00020\bH\u0014J\u0018\u0010s\u001a\u00020X2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\bH\u0002J\u000e\u0010w\u001a\u00020X2\u0006\u0010x\u001a\u00020yJ\u0006\u0010z\u001a\u00020XJ\u000e\u0010{\u001a\u00020X2\u0006\u0010|\u001a\u000205J\u000e\u0010}\u001a\u00020X2\u0006\u0010~\u001a\u000207J\u0017\u0010\u007f\u001a\u00020\u00002\u0006\u0010v\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020&J\u0017\u0010\u0081\u0001\u001a\u00020X2\u000e\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u00020u0\u0083\u0001J\u0010\u0010\u0084\u0001\u001a\u00020X2\u0007\u0010\u0085\u0001\u001a\u00020:J\u001b\u0010\u0086\u0001\u001a\u00020X2\u0007\u0010\u0087\u0001\u001a\u00020\b2\u0007\u0010\u0088\u0001\u001a\u00020\bH\u0002J\u0007\u0010\u0089\u0001\u001a\u00020XJ\u0007\u0010\u008a\u0001\u001a\u00020XR\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\b0\b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010)\u001a\u00020&2\u0006\u0010(\u001a\u00020&8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b0\u0010 R\u001e\u00102\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0016R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0018\u00010<R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010D\u001a\u00020C2\u0006\u0010(\u001a\u00020C@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0011\u0010I\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bJ\u0010 R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0L8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u001e\u0010O\u001a\u00020\b2\u0006\u00101\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bP\u0010 R\u000e\u0010Q\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010R\u001a\u00020S8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0012\u001a\u0004\bT\u0010U¨\u0006\u008d\u0001"}, d2 = {"Lcom/obric/oui/banner/OBanner;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Lcom/obric/oui/banner/interfaces/BannerOperator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_selectedPosition", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "adapter", "Lcom/obric/oui/banner/BannerAdapter;", "getAdapter", "()Lcom/obric/oui/banner/BannerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "autoSwitchIntervalMs", "", "getAutoSwitchIntervalMs", "()J", "checkAutoPlayRunnable", "Ljava/lang/Runnable;", "compositePageTransformer", "Landroidx/viewpager2/widget/CompositePageTransformer;", "getCompositePageTransformer", "()Landroidx/viewpager2/widget/CompositePageTransformer;", "compositePageTransformer$delegate", "currentItem", "getCurrentItem", "()I", "delayAfterUserTouch", "getDelayAfterUserTouch", "setDelayAfterUserTouch", "(J)V", "haveVibratedAfterUserDragging", "", "isAutoSwitchEnabled", EventBody.KEY_VALUE, "isInfiniteSwitchEnabled", "()Z", "setInfiniteSwitchEnabled", "(Z)V", "isPadGridAdaptEnable", "isUserDragging", "itemCount", "getItemCount", "<set-?>", "lastUserTouchTime", "getLastUserTouchTime", "mBannerItemClickListener", "Lcom/obric/oui/banner/interfaces/OnBannerItemClickListener;", "mBannerStyle", "Lcom/obric/oui/banner/BannerStyle;", "mLastWindowWidth", "mOnPageChangeListener", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "mPageChangeCallback", "Lcom/obric/oui/banner/OBanner$BannerOnPageChangeCallback;", "mWindowGridConfigObserver", "Landroidx/lifecycle/Observer;", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "marginPageTransformer", "Landroidx/viewpager2/widget/MarginPageTransformer;", "pageInvalid", "", "proportion", "getProportion", "()F", "setProportion", "(F)V", "realCount", "getRealCount", "selectedPosition", "Landroidx/lifecycle/LiveData;", "getSelectedPosition", "()Landroidx/lifecycle/LiveData;", "startPosition", "getStartPosition", "triptychBannerRatio", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2$delegate", "adjustBannerForWindowConfigChange", "", "windowSizeWithPageSize", "isFromInit", "adjustBannerParam", "newBannerWidth", "checkAndSwitchPage", "clearCheckTask", "configBanner", "currentItemPlayDone", "disableAutoSwitch", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "enableAutoSwitch", "enablePadGridAdapt", "enable", "getCurrentRealPos", "initTriptychBanner", "bannerWidth", "windowWidth", "bannerPaddingDp", "initViewPager2", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTriptychBannerItemClick", "data", "Lcom/obric/oui/banner/BannerData;", "position", "registerViewHolder", "factory", "Lcom/obric/oui/banner/IBannerViewHolderFactory;", "release", "setBannerItemClickListener", "listener", "setBannerStyle", "style", "setCurrentItem", "smoothScroll", "setData", "dataSet", "", "setOnPageChangeListener", "onPageChangeListener", "setRecyclerViewPadding", "leftItemPadding", "rightItemPadding", "switchNext", "switchPrevious", "BannerOnPageChangeCallback", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBanner extends RadiusLayout implements com.obric.oui.banner.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13333a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f13334b;
    private final Lazy c;
    private long d;
    private com.obric.oui.banner.b.b e;
    private final Lazy f;
    private final Runnable g;
    private boolean h;
    private boolean i;
    private boolean j;
    private MutableLiveData<Integer> k;
    private final Lazy l;
    private ViewPager2.OnPageChangeCallback m;
    private BannerOnPageChangeCallback n;
    private int o;
    private BannerStyle p;
    private boolean q;
    private float r;
    private int s;
    private boolean t;
    private float u;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/banner/OBanner$BannerOnPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "(Lcom/obric/oui/banner/OBanner;)V", "tempPosition", "", "onPageScrollStateChanged", "", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private int tempPosition;
        final /* synthetic */ OBanner this$0;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f13335a = null;

            static {
                int[] r0 = new int[BannerStyle.values().length];
                r0[BannerStyle.TRIPTYCH.ordinal()] = 1;
                f13335a = r0;
            }
        }

        public BannerOnPageChangeCallback(OBanner r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.tempPosition = -1;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int r5) {
            if (r5 != 0) goto L30;
            if (this.tempPosition == (-1)) goto L30;
            if (a.f13335a[OBanner.b(this.this$0).ordinal()] != 1) goto L20;
            int r0 = this.tempPosition;
            if (r0 != 0) goto L11;
        L9:
            OBanner r1 = this.this$0;
            int r2 = r1.getStartPosition();
        L10:
            r1.a(r2, false);
            goto L30
        L11:
            if (r0 != 1) goto L14;
            r1 = this.this$0;
            r2 = r1.getStartPosition() + 1;
            goto L10
        L14:
            if (r0 != (this.this$0.getItemCount() - 1)) goto L17;
            r1 = this.this$0;
            r2 = r1.getStartPosition() - 1;
            goto L10
        L17:
            if (r0 != (this.this$0.getItemCount() - 2)) goto L30;
        L20:
            if (this.tempPosition == (-1)) goto L30;
            if (this.this$0.a() == false) goto L30;
            int r3 = this.tempPosition;
            if (r3 != 0) goto L27;
            r1 = this.this$0;
            r2 = r1.getRealCount();
            goto L10
        L27:
            if (r3 != (this.this$0.getItemCount() - 1)) goto L30;
            this.this$0.a(1, false);
        L30:
            if (OBanner.c(this.this$0) == null) goto L36;
            ViewPager2.OnPageChangeCallback r4 = OBanner.c(this.this$0);
            if (r4 == null) goto L37;
            r4.onPageScrollStateChanged(r5);
            return;
        L37:
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int r5, float r6, int r7) {
            int r8 = com.obric.oui.banner.c.a.f13339a.a(this.this$0.a(), r5, this.this$0.getRealCount());
            boolean r1 = false;
            if (a.f13335a[OBanner.b(this.this$0).ordinal()] != 1) goto L8;
            if (r8 != (((this.this$0.getCurrentItem() - 2) + this.this$0.getRealCount()) % this.this$0.getRealCount())) goto L11;
        L9:
            r1 = true;
        L11:
            if (OBanner.c(this.this$0) == null) goto L18;
            if (r1 == false) goto L19;
            ViewPager2.OnPageChangeCallback r4 = OBanner.c(this.this$0);
            if (r4 == null) goto L20;
            r4.onPageScrolled(r8, r6, r7);
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        L8:
            if (r8 != (this.this$0.getCurrentItem() - 1)) goto L11;
            goto L9
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int r4) {
            int r0 = com.obric.oui.banner.c.a.f13339a.a(this.this$0.a(), r4, this.this$0.getRealCount());
            this.tempPosition = r4;
            if (OBanner.c(this.this$0) == null) goto L8;
            ViewPager2.OnPageChangeCallback r1 = OBanner.c(this.this$0);
            if (r1 == null) goto L8;
            r1.onPageSelected(r0);
        L8:
            OBanner.a(this.this$0, false);
            OBanner.d(this.this$0).setValue(Integer.valueOf(r0));
            if (OBanner.e(this.this$0) == true) goto L12;
            com.obric.oui.c.a.b.b("OBanner", "onPageSelected, position: " + r4 + ", realPosition: " + r0);
            com.obric.oui.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 3);
            OBanner.b(this.this$0, true);
            return;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/banner/OBanner$Companion;", "", "()V", "DEFAULT_AUTO_SWITCH_INTERVAL_MS", "", "DEFAULT_TRIPTYCH_BANNER_RATIO", "", "INVALID_VALUE", "", "TAG", "", "getBannerStyle", "Lcom/obric/oui/banner/BannerStyle;", "style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final BannerStyle a(int r1) {
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L11;
            return BannerStyle.TRIPTYCH;
        L13:
            return BannerStyle.INDENT;
        L11:
            return BannerStyle.FILL;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13338a = null;

        static {
            int[] r0 = new int[BannerStyle.values().length];
            r0[BannerStyle.TRIPTYCH.ordinal()] = 1;
            r0[BannerStyle.FILL.ordinal()] = 2;
            r0[BannerStyle.INDENT.ordinal()] = 3;
            f13338a = r0;
        }
    }

    static {
        f13333a = new a(null);
    }

    public OBanner(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBanner(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OBanner(Context r5, AttributeSet r6, int r7) {
        final Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r7);
        this.f13334b = 5000;
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OBanner$viewPager2$2(r8), Function0.class, "com.obric.memorydata.plugin"));
        this.d = -1;
        this.f = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OBanner$adapter$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.g = new $$Lambda$OBanner$fLudO7_a_t5ZyEPodGWGsR9Mt8(this);
        this.k = new MutableLiveData(0);
        this.l = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(OBanner$compositePageTransformer$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.p = BannerStyle.FILL;
        this.r = 0.5625f;
        this.s = -1;
        this.t = true;
        if (r9 == null) goto L6;
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.OBanner);
        Intrinsics.checkNotNullExpressionValue(r10, "context.obtainStyledAttr…trs, R.styleable.OBanner)");
        this.p = f13333a.a(r10.getInt(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_style, "styleable", "OBanner_oui_banner_style"), 0));
        this.q = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_is_pad_grid_adapt_enable, "styleable", "OBanner_oui_banner_is_pad_grid_adapt_enable"), false);
        setProportion(r10.getFloat(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_proportion, "styleable", "OBanner_oui_banner_proportion"), 0.0f));
        this.j = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_enableAutoSwitch, "styleable", "OBanner_oui_banner_enableAutoSwitch"), false);
        this.f13334b = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_autoSwitchInterval, "styleable", "OBanner_oui_banner_autoSwitchInterval"), 5000);
        setInfiniteSwitchEnabled(r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBanner_oui_banner_enableInfiniteSwitch, "styleable", "OBanner_oui_banner_enableInfiniteSwitch"), true));
        r10.recycle();
        return;
    }

    public /* synthetic */ OBanner(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ BannerAdapter a(OBanner r0) {
        return r0.getAdapter();
    }

    public static final /* synthetic */ void a(OBanner r2, com.obric.oui.banner.a r3, int r4) {
        r2.a((com.obric.oui.banner.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.a.class, "com.obric.memorydata.plugin"), r4);
    }

    public static final /* synthetic */ void a(OBanner r0, boolean r1) {
        r0.i = r1;
    }

    private final void a(com.obric.oui.banner.a r6, int r7) {
        com.obric.oui.banner.a r8 = (com.obric.oui.banner.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.oui.banner.a.class, "com.obric.memorydata.plugin");
        int r0 = com.obric.oui.banner.c.a.f13339a.a(a(), getCurrentItem(), getRealCount());
        if (getCurrentItem() != 2) goto L8;
        if (r7 != (getRealCount() - 1)) goto L8;
        a(1, true);
        return;
    L8:
        if (getCurrentItem() != (getItemCount() - 3)) goto L13;
        if (r7 != 0) goto L13;
        int r9 = getItemCount() - 2;
    L11:
        a(r9, true);
        return;
    L13:
        if (r0 != (getRealCount() - 1)) goto L16;
        if (r7 != 0) goto L16;
    L15:
        r9 = getCurrentItem() + 1;
    L16:
        if (r0 == 0) goto L18;
    L20:
        if (r0 <= r7) goto L22;
    L21:
        r9 = getCurrentItem() - 1;
        goto L11
    L22:
        if (r0 < r7) goto L15;
        com.obric.oui.banner.b.b r5 = this.e;
        if (r5 == null) goto L31;
        r5.a(r8, r7);
        return;
    L31:
        return;
    L18:
        if (r7 != (getRealCount() - 1)) goto L20;
        goto L20
    }

    public static final /* synthetic */ BannerStyle b(OBanner r0) {
        return r0.p;
    }

    public static final /* synthetic */ void b(OBanner r0, boolean r1) {
        r0.t = r1;
    }

    public static final /* synthetic */ ViewPager2.OnPageChangeCallback c(OBanner r0) {
        return r0.m;
    }

    public static final /* synthetic */ MutableLiveData d(OBanner r0) {
        return r0.k;
    }

    public static final /* synthetic */ boolean e(OBanner r0) {
        return r0.t;
    }

    public static final /* synthetic */ com.obric.oui.banner.b.b f(OBanner r0) {
        return r0.e;
    }

    private final void f() {
        if (this.j == true) goto L5;
    L27:
        String r6 = "检查换页：开关 false，不换页";
    L10:
        g.a(r6);
        return;
    L5:
        if (this.f13334b <= 0) goto L27;
        if (this.h == false) goto L13;
        r6 = "检查换页：正在拖动，不换页";
        goto L10
    L13:
        if (isAttachedToWindow() == true) goto L15;
        r6 = "剥离window，不换页";
        goto L10
    L15:
        long r0 = SystemClock.uptimeMillis() - this.d;
        if (r0 >= this.f13334b) goto L23;
        g.a("检查换页: 刚松手" + r0 + " ms，delay换页");
        Handler r2 = getHandler();
        if (r2 == null) goto L28;
        r2.postDelayed(this.g, this.f13334b - r0);
        return;
    L28:
        return;
    L23:
        if (this.i == false) goto L25;
        d();
        return;
    L25:
        g.a("检查换页：不是业务触发的，不换页");
    }

    private final void g() {
        Handler r0 = getHandler();
        if (r0 == null) goto L7;
        r0.removeCallbacks(this.g);
        return;
    }

    private static final void g(OBanner r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f();
    }

    private final BannerAdapter getAdapter() {
        return (BannerAdapter) ZeusTransformUtils.preCheckCast(this.f.getValue(), BannerAdapter.class, "com.obric.memorydata.plugin");
    }

    private final CompositePageTransformer getCompositePageTransformer() {
        return (CompositePageTransformer) ZeusTransformUtils.preCheckCast(this.l.getValue(), CompositePageTransformer.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$fLudO7_a-_t5ZyEPodGWGsR9Mt8, reason: not valid java name */
    public static /* synthetic */ void m1257lambda$fLudO7_a_t5ZyEPodGWGsR9Mt8(OBanner r0) {
        g(r0);
    }

    public final OBanner a(int r3, boolean r4) {
        if (getViewPager2().getScrollState() == 0) goto L10;
        Log.w("OBanner", "viewPager2 scrollState: " + getViewPager2().getScrollState() + ", ban setCurrentItem");
    L9:
        return this;
    L10:
        getViewPager2().setCurrentItem(r3, r4);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.e("OBanner", Intrinsics.stringPlus("setCurrentItem error, msg: ", e.getMessage()));
        goto L9
    }

    public final void a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "factory");
        getAdapter().registerViewHolder(r4);
    }

    public final boolean a() {
        return getAdapter().getUseInfiniteItemCount();
    }

    public final void b() {
        addView((View) ZeusTransformUtils.preCheckCast(getViewPager2(), View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        getViewPager2().setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(getAdapter(), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        getViewPager2().setPageTransformer((ViewPager2.PageTransformer) ZeusTransformUtils.preCheckCast(getCompositePageTransformer(), ViewPager2.PageTransformer.class, "com.obric.memorydata.plugin"));
        BannerOnPageChangeCallback r0 = new BannerOnPageChangeCallback(this);
        getViewPager2().registerOnPageChangeCallback((ViewPager2.OnPageChangeCallback) ZeusTransformUtils.preCheckCast(r0, ViewPager2.OnPageChangeCallback.class, "com.obric.memorydata.plugin"));
        this.n = r0;
        ViewCompat.setAccessibilityDelegate((View) ZeusTransformUtils.preCheckCast(getViewPager2(), View.class, "com.obric.memorydata.plugin"), (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(new OBanner$initViewPager2$2(this), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin"));
    }

    public final void c() {
        g();
        this.j = false;
    }

    public final void d() {
        getViewPager2().setCurrentItem(getViewPager2().getCurrentItem() + 1, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 != null) goto L4;
        Integer r0 = null;
    L5:
        boolean r2 = true;
        if (r0 != null) goto L9;
    L11:
        if (r0 == null) goto L17;
        if (r0.intValue() != 1) goto L17;
    L23:
        if (r2 == false) goto L26;
        this.h = false;
        this.d = SystemClock.uptimeMillis();
        f();
    L26:
        return super.dispatchTouchEvent(r5);
    L17:
        if (r0 != null) goto L20;
    L22:
        r2 = false;
        goto L23
    L20:
        if (r0.intValue() != 3) goto L22;
    L9:
        if (r0.intValue() != 0) goto L11;
        this.h = true;
        this.t = false;
        goto L26
    L4:
        r0 = Integer.valueOf(r5.getAction());
        goto L5
    }

    @Override // com.obric.oui.banner.b.a
    public void e() {
        this.i = true;
        f();
    }

    @Override // com.obric.oui.banner.b.a
    public long getAutoSwitchIntervalMs() {
        return this.f13334b;
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getCurrentRealPos() {
        return com.obric.oui.banner.c.a.f13339a.a(a(), getCurrentItem(), getRealCount());
    }

    public final long getDelayAfterUserTouch() {
        return this.f13334b;
    }

    public final int getItemCount() {
        return getAdapter().getItemCount();
    }

    public final long getLastUserTouchTime() {
        return this.d;
    }

    public final float getProportion() {
        return this.u;
    }

    public final int getRealCount() {
        return getAdapter().getRealItemCount();
    }

    @Override // com.obric.oui.banner.b.a
    public LiveData<Integer> getSelectedPosition() {
        return (LiveData) ZeusTransformUtils.preCheckCast(this.k, LiveData.class, "com.obric.memorydata.plugin");
    }

    public final int getStartPosition() {
        return this.o;
    }

    public final ViewPager2 getViewPager2() {
        return (ViewPager2) ZeusTransformUtils.preCheckCast(this.c.getValue(), ViewPager2.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r3, int r4) {
        if (this.u > 0.0f) goto L6;
        super.onMeasure(r3, r4);
        return;
    L6:
        int r5 = View.MeasureSpec.getSize(r3);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r5 / this.u), 1073741824));
    }

    public final void setBannerItemClickListener(com.obric.oui.banner.b.b r3) {
        com.obric.oui.banner.b.b r4 = (com.obric.oui.banner.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.b.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.e = r4;
    }

    public final void setBannerStyle(BannerStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        this.p = r2;
    }

    public final void setData(List<? extends com.obric.oui.banner.a> r4) {
        List<? extends com.obric.oui.banner.a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dataSet");
        getAdapter().setDataSet(r5);
        int r1 = 1;
        if (r5.size() != 1) goto L6;
        c();
        setInfiniteSwitchEnabled(false);
    L6:
        if (a() == false) goto L9;
        r1 = getRealCount() * 100;
    L12:
        this.o = r1;
        a(r1, false);
        getViewPager2().requestTransform();
        return;
    L9:
        if (b.f13338a[this.p.ordinal()] == 1) goto L12;
        r1 = 0;
        goto L12
    }

    public final void setDelayAfterUserTouch(long r1) {
        this.f13334b = r1;
    }

    public final void setInfiniteSwitchEnabled(boolean r2) {
        getAdapter().setUseInfiniteItemCount(r2);
        getAdapter().notifyDataSetChanged();
    }

    public final void setOnPageChangeListener(ViewPager2.OnPageChangeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "onPageChangeListener");
        this.m = r2;
    }

    public final void setProportion(float r3) {
        if (r3 >= 0.0f) goto L5;
        this.u = 0.0f;
        return;
    L5:
        this.u = r3;
        invalidate();
    }
}
