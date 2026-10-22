package com.ss.android.lark.forseti.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import cib.f;
import com.ss.android.lark.api.bean.config.ForsetiMarginType;
import com.ss.android.lark.api.ui.NavigationMode;
import com.ss.android.lark.base.embedded.LKSplitController;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainHelper;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.forsetiutils.WindowInsetsJitterFixListener;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.insets.AndroidQInsetsDispatchCompat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00013B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'J\b\u0010)\u001a\u00020\u001fH\u0014J2\u0010*\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0014J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020,H\u0002R\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u00064"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainViewGroupCompat;", "Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "systemBottomBarHeight", "setSystemBottomBarHeight", "(I)V", "systemStatusBarHeight", "setSystemStatusBarHeight", "systemBarLeft", "setSystemBarLeft", "systemBarRight", "setSystemBarRight", "isEmbedded", "", "()Z", "mainTabMarginTop", "", "getMainTabMarginTop", "()F", "mainTabMarginBottom", "getMainTabMarginBottom", "()I", "setForsetiDraggingHelper", "", "forsetiColumnsDraggingHelper", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "setForsetiChainHelper", "forsetiChainHelper", "Lcom/ss/android/lark/forseti/chain/ForsetiChainHelper;", "setForsetiChainConfig", "forsetiChainConfig", "Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;", "refreshForsetiChainConfig", "layoutFrameLayout", "measureChildWithMargins", "child", "Landroid/view/View;", "parentWidthMeasureSpec", "widthUsed", "parentHeightMeasureSpec", "heightUsed", "consumeWindowInsetsForFirstNode", "firstChild", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiNormalChainViewGroupCompat extends ForsetiNormalChainViewGroup {
    public int v;
    public int w;
    public int x;
    public int y;

    public static final class a implements OnApplyWindowInsetsListener {
        public final /* synthetic */ ForsetiNormalChainViewGroupCompat a;

        public a(ForsetiNormalChainViewGroupCompat r1) {
            this.a = r1;
        }

        public final WindowInsetsCompat onApplyWindowInsets(View r3, WindowInsetsCompat r4) {
            Intrinsics.checkNotNullParameter(r3, "<unused var>");
            Intrinsics.checkNotNullParameter(r4, "insets");
            Insets r5 = r4.getInsets(WindowInsetsCompat.Type.systemBars());
            ForsetiNormalChainViewGroupCompat.f(this.a, r5.bottom);
            ForsetiNormalChainViewGroupCompat.g(this.a, r5.top);
            int r0 = fib.a.a;
            if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.window_insets_disabled") == true) goto L5;
            ForsetiNormalChainViewGroupCompat.d(this.a, r5.left);
            ForsetiNormalChainViewGroupCompat.e(this.a, r5.right);
        L5:
            return r4;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ForsetiMarginType.values().length];
            r0[ForsetiMarginType.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ForsetiMarginType.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ForsetiMarginType.CUSTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public ForsetiNormalChainViewGroupCompat(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ForsetiNormalChainViewGroupCompat(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup
    public final void a() {
        StringBuilder r0 = new StringBuilder("layoutFrameLayout isEmbedded:");
        LKSplitController r1 = LKSplitController.b;
        r0.append(LKSplitController.a.a().d(ContextsKt.requireActivity(getContext())));
        Log.d("FST_ChainViewGroupCompat", r0.toString());
        if (LKSplitController.a.a().d(ContextsKt.requireActivity(getContext())) == false) goto L23;
        int r2 = getChildCount();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L28;
        View r4 = getChildAt(r3);
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        ViewGroup.MarginLayoutParams r6 = null;
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r5;
    L10:
        if (r7 == null) goto L12;
        int r8 = r7.leftMargin;
    L13:
        ViewGroup.LayoutParams r9 = r4.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r6 = (ViewGroup.MarginLayoutParams) r9;
    L16:
        if (r6 == null) goto L18;
        int r10 = r6.topMargin;
    L19:
        if (r3 != 0) goto L21;
        r4.layout(r8, r10, r4.getMeasuredWidth() + r8, r4.getMeasuredHeight() + r10);
    L22:
        r3 = r3 + 1;
        goto L5
    L21:
        r4.layout(getMeasuredWidth(), r10, getMeasuredWidth() + r4.getMeasuredWidth(), r4.getMeasuredHeight() + r10);
        goto L22
    L18:
        r10 = 0;
        goto L19
    L12:
        r8 = 0;
        goto L13
    L9:
        r7 = null;
        goto L10
    L28:
        return;
    L23:
        super.a();
    }

    private final int getMainTabMarginBottom() {
        return f.a(getContext(), 66.0f) + this.v;
    }

    private final float getMainTabMarginTop() {
        return a08.b.a(f.a(getContext(), 60.0f), getContext()) + this.w;
    }

    private final void setSystemBarLeft(int r2) {
        if (this.x == r2) goto L6;
        this.x = r2;
        requestLayout();
        return;
    }

    private final void setSystemBarRight(int r2) {
        if (this.y == r2) goto L6;
        this.y = r2;
        requestLayout();
        return;
    }

    private final void setSystemBottomBarHeight(int r2) {
        if (this.v == r2) goto L6;
        this.v = r2;
        requestLayout();
        return;
    }

    private final void setSystemStatusBarHeight(int r2) {
        if (this.w == r2) goto L6;
        this.w = r2;
        requestLayout();
        return;
    }

    public final void setForsetiChainConfig(com.ss.android.lark.api.bean.config.a r2) {
        Intrinsics.checkNotNullParameter(r2, "forsetiChainConfig");
        setChainConfig(r2);
    }

    public final void setForsetiChainHelper(ForsetiChainHelper r2) {
        Intrinsics.checkNotNullParameter(r2, "forsetiChainHelper");
        setChainHelper(r2);
    }

    public final void setForsetiDraggingHelper(ForsetiColumnsDraggingHelper r2) {
        Intrinsics.checkNotNullParameter(r2, "forsetiColumnsDraggingHelper");
        setDraggingHelper(r2);
    }

    public static final /* synthetic */ void d(ForsetiNormalChainViewGroupCompat r0, int r1) {
        r0.setSystemBarLeft(r1);
    }

    public static final /* synthetic */ void e(ForsetiNormalChainViewGroupCompat r0, int r1) {
        r0.setSystemBarRight(r1);
    }

    public static final /* synthetic */ void f(ForsetiNormalChainViewGroupCompat r0, int r1) {
        r0.setSystemBottomBarHeight(r1);
    }

    public static final /* synthetic */ void g(ForsetiNormalChainViewGroupCompat r0, int r1) {
        r0.setSystemStatusBarHeight(r1);
    }

    public ForsetiNormalChainViewGroupCompat(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a r5 = new a(this);
        int r6 = AndroidQInsetsDispatchCompat.a;
        Intrinsics.checkNotNullParameter(this, "viewGroup");
        Intrinsics.checkNotNullParameter(r5, "origin");
        OnApplyWindowInsetsListener r7 = r5;
        if (Build.VERSION.SDK_INT > 29) goto L6;
        r7 = new com.ss.android.lark.insets.a(r5, this);
    L6:
        ViewCompat.setOnApplyWindowInsetsListener(this, new WindowInsetsJitterFixListener(r7));
    }

    public /* synthetic */ ForsetiNormalChainViewGroupCompat(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View r9, int r10, int r11, int r12, int r13) {
        if (r9 != null) goto L4;
    L60:
        super.measureChildWithMargins(r9, r10, r11, r12, r13);
        return;
    L4:
        if (indexOfChild(r9) != 0) goto L60;
        int r0 = (int) getMainTabMarginTop();
        if (getLastNavMode() == NavigationMode.BOTTOM_MODE) goto L8;
        int r1 = this.v;
    L9:
        com.ss.android.lark.api.bean.config.a r2 = getChainConfig();
        ViewGroup.MarginLayoutParams r3 = null;
        if (r2 == null) goto L14;
        com.ss.android.lark.api.bean.config.c r4 = r2.a;
        if (r4 == null) goto L14;
        ForsetiMarginType r5 = r4.getType();
    L15:
        int r6 = -1;
        if (r5 != null) goto L18;
        int r7 = -1;
    L20:
        if (r7 == 2) goto L31;
        if (r7 != 3) goto L32;
        com.ss.android.lark.api.bean.config.a r8 = getChainConfig();
        if (r8 == null) goto L30;
        com.ss.android.lark.api.bean.config.c r14 = r8.a;
        if (r14 == null) goto L30;
        Integer r15 = r14.b;
        if (r15 == null) goto L30;
        r0 = r15.intValue();
    L30:
        r0 = 0;
    L32:
        com.ss.android.lark.api.bean.config.a r16 = getChainConfig();
        if (r16 == null) goto L37;
        com.ss.android.lark.api.bean.config.c r17 = r16.b;
        if (r17 == null) goto L37;
        ForsetiMarginType r18 = r17.getType();
    L38:
        if (r18 == null) goto L41;
        r6 = c.a[r18.ordinal()];
    L41:
        if (r6 == 2) goto L52;
        if (r6 != 3) goto L53;
        com.ss.android.lark.api.bean.config.a r19 = getChainConfig();
        if (r19 == null) goto L51;
        com.ss.android.lark.api.bean.config.c r20 = r19.b;
        if (r20 == null) goto L51;
        Integer r21 = r20.b;
        if (r21 == null) goto L51;
        r1 = r21.intValue();
    L51:
        r1 = 0;
    L53:
        ViewGroup.LayoutParams r22 = r9.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L56;
        r3 = (ViewGroup.MarginLayoutParams) r22;
    L56:
        if (r3 == null) goto L60;
        r3.topMargin = r0;
        r3.bottomMargin = r1;
        int r23 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.window_insets_disabled") == true) goto L60;
        r3.leftMargin = this.x;
        r3.rightMargin = this.y;
        goto L60
    L52:
        r1 = this.v;
    L37:
        r18 = null;
        goto L38
    L31:
        r0 = this.w;
        goto L32
    L18:
        r7 = c.a[r5.ordinal()];
    L14:
        r5 = null;
        goto L15
    L8:
        r1 = getMainTabMarginBottom();
        goto L9
    }
}
