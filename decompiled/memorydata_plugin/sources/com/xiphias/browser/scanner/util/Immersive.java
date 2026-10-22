package com.xiphias.browser.scanner.util;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u000234B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010,\u001a\u00020-J\u0018\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u001aH\u0016J\u000e\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0 8F¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u001d\u0010&\u001a\u0004\u0018\u00010'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)¨\u00065"}, d2 = {"Lcom/xiphias/browser/scanner/util/Immersive;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "decorFitsSystemWindow", "", "getDecorFitsSystemWindow", "()Z", "setDecorFitsSystemWindow", "(Z)V", "systemBarColor", "", "getSystemBarColor", "()I", "setSystemBarColor", "(I)V", "isLightStatusBar", "setLightStatusBar", "typeMask", "getTypeMask", "setTypeMask", "currInsets", "Landroidx/core/view/WindowInsetsCompat;", "callback", "Lcom/xiphias/browser/scanner/util/ImmersiveCallback;", "_statusBarHeight", "Landroidx/lifecycle/MutableLiveData;", "statusBarHeight", "Landroidx/lifecycle/LiveData;", "getStatusBarHeight", "()Landroidx/lifecycle/LiveData;", "_navigationBarHeight", "navigationBarHeight", "getNavigationBarHeight", "rootContent", "Landroid/view/View;", "getRootContent", "()Landroid/view/View;", "rootContent$delegate", "Lkotlin/Lazy;", "setup", "", "onApplyWindowInsets", BaseSwitches.V, "insets", "isVisible", "type", "DummyLiveData", "Companion", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Immersive implements OnApplyWindowInsetsListener {
    public static final a Companion = null;
    private static final Immersive DEFAULT = null;
    private static final DummyLiveData DUMMY_DATA = null;
    private final MutableLiveData<Integer> _navigationBarHeight;
    private final MutableLiveData<Integer> _statusBarHeight;
    private final Activity activity;
    private final com.xiphias.browser.scanner.util.a callback;
    private WindowInsetsCompat currInsets;
    private boolean decorFitsSystemWindow;
    private boolean isLightStatusBar;
    private final Lazy rootContent$delegate;
    private int systemBarColor;
    private int typeMask;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/xiphias/browser/scanner/util/Immersive$DummyLiveData;", "Landroidx/lifecycle/LiveData;", "", "<init>", "()V", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "observeForever", "removeObserver", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class DummyLiveData extends LiveData<Integer> {
        public DummyLiveData() {
        }

        @Override // androidx.lifecycle.LiveData
        public void observe(LifecycleOwner r2, Observer<? super Integer> r3) {
            LifecycleOwner r1 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r2, LifecycleOwner.class, "com.obric.memorydata.plugin");
            Observer r4 = (Observer) ZeusTransformUtils.wrapperContextForParams(r3, Observer.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "owner");
            Intrinsics.checkNotNullParameter(r4, "observer");
        }

        @Override // androidx.lifecycle.LiveData
        public void observeForever(Observer<? super Integer> r2) {
            Intrinsics.checkNotNullParameter((Observer) ZeusTransformUtils.wrapperContextForParams(r2, Observer.class, "com.obric.memorydata.plugin"), "observer");
        }

        @Override // androidx.lifecycle.LiveData
        public void removeObserver(Observer<? super Integer> r2) {
            Intrinsics.checkNotNullParameter((Observer) ZeusTransformUtils.wrapperContextForParams(r2, Observer.class, "com.obric.memorydata.plugin"), "observer");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/xiphias/browser/scanner/util/Immersive$Companion;", "", "<init>", "()V", "DEFAULT", "Lcom/xiphias/browser/scanner/util/Immersive;", "DUMMY_DATA", "Lcom/xiphias/browser/scanner/util/Immersive$DummyLiveData;", "getImmersive", "activity", "Landroid/app/Activity;", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
        DEFAULT = new Immersive(null);
        DUMMY_DATA = new DummyLiveData();
    }

    public Immersive(Activity r4) {
        Activity r5 = ZeusTransformUtils.wrapperContext2Activity((Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.activity = r5;
        this.isLightStatusBar = true;
        this.typeMask = WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout();
        if (ZeusTransformUtils.instanceOf(r5, com.xiphias.browser.scanner.util.a.class) == false) goto L5;
        com.xiphias.browser.scanner.util.a r6 = (com.xiphias.browser.scanner.util.a) ZeusTransformUtils.preCheckCast(r5, com.xiphias.browser.scanner.util.a.class, "com.obric.memorydata.plugin");
    L6:
        this.callback = r6;
        this._statusBarHeight = new MutableLiveData();
        this._navigationBarHeight = new MutableLiveData();
        this.rootContent$delegate = LazyKt.lazy(new $$Lambda$Immersive$DyI_nizD1omwPb3gvPp2iDBmFOU(this));
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static final /* synthetic */ Immersive access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public static /* synthetic */ View lambda$DyI_nizD1omwPb3gvPp2iDBmFOU(Immersive r0) {
        return rootContent_delegate$lambda$0(r0);
    }

    private static final View rootContent_delegate$lambda$0(Immersive r3) {
        Activity r4 = r3.activity;
        if (r4 == null) goto L5;
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4.findViewById(R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == true) goto L10;
        r5 = null;
    L10:
        if (r5 != null) goto L12;
        return null;
    L12:
        return r5.getChildAt(0);
    L5:
        r5 = null;
        goto L7
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final boolean getDecorFitsSystemWindow() {
        return this.decorFitsSystemWindow;
    }

    public final LiveData<Integer> getNavigationBarHeight() {
        if (this.activity != null) goto L5;
        Object r2 = DUMMY_DATA;
    L7:
        return (LiveData) ZeusTransformUtils.preCheckCast(r2, LiveData.class, "com.obric.memorydata.plugin");
    L5:
        r2 = this._navigationBarHeight;
        goto L7
    }

    public final View getRootContent() {
        return (View) ZeusTransformUtils.preCheckCast(this.rootContent$delegate.getValue(), View.class, "com.obric.memorydata.plugin");
    }

    public final LiveData<Integer> getStatusBarHeight() {
        if (this.activity != null) goto L5;
        Object r2 = DUMMY_DATA;
    L7:
        return (LiveData) ZeusTransformUtils.preCheckCast(r2, LiveData.class, "com.obric.memorydata.plugin");
    L5:
        r2 = this._statusBarHeight;
        goto L7
    }

    public final int getSystemBarColor() {
        return this.systemBarColor;
    }

    public final int getTypeMask() {
        return this.typeMask;
    }

    public final boolean isLightStatusBar() {
        return this.isLightStatusBar;
    }

    public final boolean isVisible(int r1) {
        WindowInsetsCompat r0 = this.currInsets;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isVisible(r1);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
        Intrinsics.checkNotNullParameter(r4, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r5, "insets");
        this.currInsets = r5;
        Insets r6 = r5.getInsets(this.typeMask);
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this._statusBarHeight.getValue(), Integer.class, "com.obric.memorydata.plugin");
        int r1 = r6.top;
        if (r0 != null) goto L6;
    L7:
        com.xiphias.browser.scanner.util.a r2 = this.callback;
        if (r2 == null) goto L10;
        r2.a(r6.top);
    L10:
        this._statusBarHeight.setValue(Integer.valueOf(r6.top));
    L11:
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(this._navigationBarHeight.getValue(), Integer.class, "com.obric.memorydata.plugin");
        int r7 = r6.bottom;
        if (r3 != null) goto L15;
    L16:
        com.xiphias.browser.scanner.util.a r8 = this.callback;
        if (r8 == null) goto L19;
        r8.b(r6.bottom);
    L19:
        this._navigationBarHeight.setValue(Integer.valueOf(r6.bottom));
    L20:
        this.currInsets = null;
        return r5;
    L15:
        if (r3.intValue() == r7) goto L20;
    L6:
        if (r0.intValue() == r1) goto L11;
        goto L7
    }

    public final void setDecorFitsSystemWindow(boolean r1) {
        this.decorFitsSystemWindow = r1;
    }

    public final void setLightStatusBar(boolean r1) {
        this.isLightStatusBar = r1;
    }

    public final void setSystemBarColor(int r1) {
        this.systemBarColor = r1;
    }

    public final void setTypeMask(int r1) {
        this.typeMask = r1;
    }

    public final void setup() {
        Activity r0 = this.activity;
        if (r0 != null) goto L5;
        return;
    L5:
        Window r1 = ZeusTransformUtils.getWindow(r0, "com.obric.memorydata.plugin");
        if ((ZeusTransformUtils.getResources(this.activity, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) == 32) goto L8;
        boolean r2 = true;
    L9:
        this.isLightStatusBar = r2;
        if (this.decorFitsSystemWindow == true) goto L12;
        WindowCompat.setDecorFitsSystemWindows(r1, false);
    L12:
        r1.addFlags(Integer.MIN_VALUE);
        r1.setNavigationBarContrastEnforced(false);
        int r3 = this.systemBarColor;
        if (r3 == 0) goto L15;
        r1.setStatusBarColor(r3);
        r1.setNavigationBarColor(this.systemBarColor);
    L16:
        WindowInsetsControllerCompat r4 = WindowCompat.getInsetsController(r1, r1.getDecorView());
        if (r4 == null) goto L19;
        r4.setAppearanceLightStatusBars(this.isLightStatusBar);
    L19:
        if (r4 == null) goto L22;
        r4.setAppearanceLightNavigationBars(this.isLightStatusBar);
    L22:
        if (this.decorFitsSystemWindow == true) goto L27;
        View r5 = this.activity.findViewById(R.id.content);
        if (r5 == null) goto L28;
        ViewCompat.setOnApplyWindowInsetsListener(r5, (OnApplyWindowInsetsListener) ZeusTransformUtils.preCheckCast(this, OnApplyWindowInsetsListener.class, "com.obric.memorydata.plugin"));
        return;
    L28:
        return;
    L27:
        return;
    L15:
        r1.setStatusBarColor(0);
        r1.setNavigationBarColor(0);
        goto L16
    L8:
        r2 = false;
        goto L9
    }
}
