package com.ss.android.lark.quicklaunchbar.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import androidx.window.layout.WindowMetricsCalculator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.quicklaunchbar.databinding.QuickLaunchBarBinding;
import com.ss.android.lark.quicklaunchbar.databinding.QuickLaunchBarIconItemBinding;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 X2\u00020\u0001:\u0002XYB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0016\u0010$\u001a\u00020\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0&H\u0017J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\fH\u0017J \u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0016\u0010+\u001a\u00020\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0&H\u0017J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\fH\u0017J \u0010,\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u000fH\u0007J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u000fH\u0007J\u0010\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0011H\u0017J\u0010\u00102\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0011H\u0017J\u0010\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0018H\u0007J\u0018\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0007J\u0018\u00108\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u0007H\u0007J\u0006\u0010;\u001a\u00020\u0007J \u0010<\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0010\u0010?\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\fH\u0002J \u0010@\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\f2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000fH\u0002J\u0018\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020F2\u0006\u0010)\u001a\u00020\fH\u0002J\"\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020I2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J(\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0007H\u0002J\b\u0010O\u001a\u00020\u001fH\u0002J\b\u0010P\u001a\u00020\u001fH\u0002J\b\u0010Q\u001a\u00020\u0007H\u0002J\b\u0010R\u001a\u00020\u001fH\u0002J\b\u0010S\u001a\u00020\u001fH\u0002J\b\u0010T\u001a\u00020\u001fH\u0002J\u0012\u0010U\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010WH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/ss/android/lark/quicklaunchbar/widget/QuickLaunchBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rightItems", "", "Lcom/ss/android/lark/quicklaunchbar/model/QuickLaunchBarItem;", "leftItems", "isItemNameVisible", "", "leftItemClickListener", "Lcom/ss/android/lark/quicklaunchbar/widget/QuickLaunchBar$OnItemClickListener;", "rightItemClickListener", "viewBinding", "Lcom/ss/android/lark/quicklaunchbar/databinding/QuickLaunchBarBinding;", "isSkeletonVisible", "isLaunchBarShow", "scrollContentView", "Landroid/view/View;", "pageScrollY", "pageScrollJob", "Lkotlinx/coroutines/Job;", "cacheScrollY", "cacheOldScrollY", "onSizeChanged", "", "w", "h", "oldw", "oldh", "setLeftItems", "items", "", "updateLeftItem", "position", "item", "needCheckOverWidth", "setRightItems", "updateRightItem", "setSkeletonVisible", "visible", "setItemNameVisible", "setOnLeftItemClickListener", "listener", "setOnRightItemClickListener", "setScrollContentView", "view", "onPageScrollChange", "scrollY", "oldScrollY", "handlePageScrollDelay", "onPageScrolled", "dy", "getQuickLaunchBarHeight", "buildItemView", "isLeft", "index", "buildIconItemView", "buildButtonItemView", "buttonAttrs", "Lcom/ss/android/lark/quicklaunchbar/model/QuickLaunchBarItem$ButtonAttrs;", "isJustMeasure", "bindItemIcon", "ivIcon", "Landroid/widget/ImageView;", "bindBadge", "dotView", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "textView", "badge", "Lcom/ss/android/lark/quicklaunchbar/model/QuickLaunchBarItem$Badge;", "bindItemClick", "itemView", "updateItemMargin", "checkOverWidth", "getItemTotalMargin", "updateItemNameVisibility", "hideLaunchBar", "showLaunchBar", "getContainerWidth", "activityContext", "Landroid/app/Activity;", "Companion", "OnItemClickListener", "quick-launch-bar_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class QuickLaunchBar extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final List<j2c.a> a;
    public final List<j2c.a> b;
    public final boolean c;
    public final QuickLaunchBarBinding d;
    public boolean e;
    public int f;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ QuickLaunchBar a;

        public b(QuickLaunchBar r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            QuickLaunchBar r0 = this.a;     // Catch: Throwable -> L4
            int r1 = QuickLaunchBar.g;     // Catch: Throwable -> L4
            r0.f();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ QuickLaunchBar a;

        public c(QuickLaunchBar r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            ViewGroup.LayoutParams r0 = this.a.d.a.getLayoutParams();
            if (r0 == null) goto L5;
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
            r0.height = ((Integer) r4).intValue();
        L5:
            this.a.requestLayout();
        }
    }

    static {
    }

    public QuickLaunchBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public QuickLaunchBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getItemTotalMargin() {
        List r0 = CollectionsKt.plus(this.b, this.a);
        if (r0.size() == this.d.b.getChildCount()) goto L5;
        return 0;
    L5:
        UIHelper.dp2px(16.0f);
        Iterator r1 = r0.iterator();
        if (r1.hasNext() == true) goto L8;
        return 0;
    L8:
        j2c.a r2 = (j2c.a) r1.next();
        j2c.a r3 = (j2c.a) CollectionsKt.getOrNull(r0, -1);
        r2.getClass();
        throw null;
    }

    public final void f() {
        List r0 = CollectionsKt.plus(this.b, this.a);
        if (r0.size() == this.d.b.getChildCount()) goto L5;
        return;
    L5:
        List r1 = r0;
        boolean r2 = r1 instanceof Collection;
        if (r2 == true) goto L8;
    L10:
        Iterator r3 = r1.iterator();
        if (r3.hasNext() == false) goto L13;
        ((j2c.a) r3.next()).getClass();
        throw null;
    L13:
        if (0 > 0) goto L16;
        Log.i("QuickLaunchBar", "checkOverWidth, button item count is 0, ignore");
        return;
    L16:
        if (r2 == true) goto L18;
    L20:
        Iterator r4 = r1.iterator();
        if (r4.hasNext() == false) goto L23;
        ((j2c.a) r4.next()).getClass();
        throw null;
    L23:
        if (0 > 0) goto L27;
        Log.i("QuickLaunchBar", "checkOverWidth, icon item count is 0, ignore");
        return;
    L27:
        if (getWidth() <= 0) goto L29;
        int r5 = getWidth();
        Log.i("QuickLaunchBar", "checkOverWidth, parentWidth use view width: " + r5);
    L41:
        if (r5 > 0) goto L43;
        return;
    L43:
        Iterator r6 = r1.iterator();
    L45:
        if (r6.hasNext() == false) goto L51;
        Object r7 = null;
        ((j2c.a) r6.next()).getClass();
        if ((r7 instanceof j2c.a.e.C0155a) == false) goto L45;
        j2c.a.e.C0155a r8 = (j2c.a.e.C0155a) null;
        throw null;
    L51:
        Log.i("QuickLaunchBar", "checkOverWidth, button items total width is 0, ignore");
        return;
    L29:
        Activity r9 = ContextsKt.findActivity(getContext());
        if (Build.VERSION.SDK_INT < 29) goto L35;
        if (r9 == null) goto L35;
        int r10 = WindowMetricsCalculator.Companion.getOrCreate().computeCurrentWindowMetrics(r9).getBounds().width();
        if (r10 <= 0) goto L35;
    L36:
        StringBuilder r11 = new StringBuilder("checkOverWidth, parentWidth use window width: ");
        r11.append(r10);
        r11.append(" con:");
        if (r9 != null) goto L39;
        boolean r12 = true;
    L40:
        r11.append(r12);
        Log.i("QuickLaunchBar", r11.toString());
        r5 = r10;
        goto L41
    L39:
        r12 = false;
    L35:
        Object r13 = getContext().getSystemService("window");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics r14 = new DisplayMetrics();
        ((WindowManager) r13).getDefaultDisplay().getMetrics(r14);
        r10 = r14.widthPixels;
        goto L36
    L18:
        if (r1.isEmpty() == false) goto L20;
    L8:
        if (r1.isEmpty() == false) goto L10;
        goto L10
    }

    public final void g() {
        if (this.e == true) goto L6;
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{0, getQuickLaunchBarHeight()});
        r0.addUpdateListener(new c(this));
        r0.setDuration(300);
        r0.start();
        this.e = true;
        return;
    }

    public final int getQuickLaunchBarHeight() {
        if (this.c == false) goto L6;
        return getResources().getDimensionPixelSize(2131168092);
    L6:
        return getResources().getDimensionPixelSize(2131168091);
    }

    public final void h() {
        List r0 = CollectionsKt.plus(this.b, this.a);
        if (r0.size() == this.d.b.getChildCount()) goto L5;
        return;
    L5:
        int r1 = UIHelper.dp2px(16.0f);
        LinearLayout r2 = this.d.b;
        int r3 = r2.getChildCount();
        int r5 = 0;
        int r6 = -1;
    L6:
        if (r5 >= r3) goto L28;
        View r7 = r2.getChildAt(r5);
        j2c.a r8 = (j2c.a) ListProtector.get(r0, r5);
        j2c.a r9 = (j2c.a) CollectionsKt.getOrNull(r0, r6);
        ViewGroup.LayoutParams r10 = r7.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L11:
        if (r11 == null) goto L13;
        r11.leftMargin = 0;
    L13:
        if (r11 == null) goto L16;
        r11.rightMargin = 0;
    L16:
        if (r8.b() == false) goto L26;
        if (r11 == null) goto L20;
        r11.leftMargin = r1;
    L20:
        if (r5 != (this.d.b.getChildCount() - 1)) goto L25;
        if (r8.b() == false) goto L25;
        if (r11 == null) goto L25;
        r11.rightMargin = r1;
    L25:
        r6 = r5;
        r5 = r5 + 1;
        goto L6
    L26:
        r8.getClass();
        throw null;
    L10:
        r11 = null;
        goto L11
    L28:
        requestLayout();
    }

    public final View d(j2c.a r6) {
        int r3 = 0;
        QuickLaunchBarIconItemBinding r0 = QuickLaunchBarIconItemBinding.a(LayoutInflater.from(getContext()).inflate(2131564258, this.d.b, false));
        b(r0.d, r6);
        UDBadgeView r1 = r0.b;
        UDBadgeView r2 = r0.c;
        r6.getClass();
        a(r1, r2, null);
        TextView r4 = r0.e;
        r6.getClass();
        r4.setText(null);
        TextView r7 = r0.e;
        if (this.c == true) goto L6;
        r3 = 8;
    L6:
        r7.setVisibility(r3);
        return r0.a;
    }

    public static void b(ImageView r3, j2c.a r4) {
        int r0 = r4.a().a;
        Integer r1 = r4.a().b;
        r4.a().getClass();
        r4.a().getClass();
        r3.setImageResource(r0);
        if (r1 == null) goto L6;
        r3.setImageTintList(ColorStateList.valueOf(r1.intValue()));
        return;
    }

    public QuickLaunchBar(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        ArrayList r11 = new ArrayList();
        this.a = r11;
        ArrayList r0 = new ArrayList();
        this.b = r0;
        this.e = true;
        View r2 = LayoutInflater.from(r8).inflate(2131564256, this, false);
        addView(r2);
        int r3 = 2131375671;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131375671);
        if (r5 == null) goto L16;
        r3 = 2131386803;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131386803);
        if (r6 == null) goto L16;
        FrameLayout r4 = (FrameLayout) r2;
        this.d = new QuickLaunchBarBinding(r4, r5, r6);
        TypedArray r12 = r8.obtainStyledAttributes(r9, new int[]{2130970409});
        this.c = r12.getBoolean(0, false);
        r12.recycle();
        r4.getLayoutParams().height = getQuickLaunchBarHeight();
        r5.getLayoutParams().height = getQuickLaunchBarHeight();
        r6.getLayoutParams().height = getQuickLaunchBarHeight();
        List r13 = CollectionsKt.plus(r0, r11);
        int r14 = r5.getChildCount();
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L13;
        r5.getChildAt(r15);
        j2c.a r1 = (j2c.a) CollectionsKt.getOrNull(r13, r15);
        if (r1 != null) goto L11;
        r15 = r15 + 1;
        goto L7
    L11:
        r1.getClass();
        throw null;
    L13:
        requestLayout();
        return;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r3)));
    }

    public static void a(UDBadgeView r3, UDBadgeView r4, j2c.a.AbstractC0151a r5) {
        if ((r5 instanceof j2c.a.AbstractC0151a.C0152a) == false) goto L6;
        r3.setVisibility(0);
        r4.setVisibility(8);
        return;
    L6:
        if ((r5 instanceof j2c.a.AbstractC0151a.b) == false) goto L8;
        r3.setVisibility(8);
        r4.setVisibility(0);
        ((j2c.a.AbstractC0151a.b) r5).getClass();
        r4.setText(null);
        r4.a();
        return;
    L8:
        r3.setVisibility(8);
        r4.setVisibility(8);
    }

    public final View c(j2c.a r9, j2c.a.c r10, boolean r11) {
        View r0 = LayoutInflater.from(getContext()).inflate(2131564257, this.d.b, false);
        int r1 = 2131363832;
        UDBadgeView r2 = ViewBindings.findChildViewById(r0, 2131363832);
        if (r2 == null) goto L25;
        r1 = 2131363834;
        UDBadgeView r3 = ViewBindings.findChildViewById(r0, 2131363834);
        if (r3 == null) goto L25;
        r1 = 2131372655;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131372655);
        if (r4 == null) goto L25;
        r1 = 2131375915;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r0, 2131375915);
        if (r5 == null) goto L25;
        r1 = 2131390052;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r0, 2131390052);
        if (r6 == null) goto L25;
        LinearLayout r7 = (LinearLayout) r0;
        if (r11 == true) goto L18;
        Drawable r12 = r7.getBackground();
        if ((r12 instanceof GradientDrawable) == false) goto L17;
        GradientDrawable r13 = (GradientDrawable) r12;
        r13.mutate();
        r13.setColor(r10.c);
        r13.setStroke(r10.b, r10.a);
    L17:
        b(r5, r9);
    L18:
        Function1<ViewGroup, View> r14 = r10.d;
        if (r14 == null) goto L21;
        View r15 = (View) r14.invoke(r7);
        r4.removeAllViews();
        r4.addView(r15);
    L22:
        r9.getClass();
        a(r2, r3, null);
        return r7;
    L21:
        r9.getClass();
        r6.setText(null);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final View e(j2c.a r3, boolean r4, int r5) {
        Object r0 = null;
        r3.getClass();
        if ((r0 instanceof j2c.a.e.b) == false) goto L6;
        View r1 = d(r3);
    L10:
        r1.setOnClickListener(new com.ss.android.lark.quicklaunchbar.widget.a(r4, this, r3, r5));
        r1.setOnLongClickListener(new com.ss.android.lark.quicklaunchbar.widget.b(r4, this, r3, r5));
        return r1;
    L6:
        if ((r0 instanceof j2c.a.e.C0155a) == false) goto L15;
        Log.i("QuickLaunchBar", "buildItemView, isLeft: " + r4 + ", index: " + r5 + ", button show as icon: " + r3.a);
        if (r3.a == false) goto L12;
        r1 = d(r3);
        goto L10
    L12:
        r3.getClass();
        j2c.a.e.C0155a r6 = (j2c.a.e.C0155a) null;
        throw null;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ QuickLaunchBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L6;
        Log.i("QuickLaunchBar", "onWidthChanged, w: " + r1 + ", oldw: " + r3);
        post(new b(this));
        return;
    }
}
