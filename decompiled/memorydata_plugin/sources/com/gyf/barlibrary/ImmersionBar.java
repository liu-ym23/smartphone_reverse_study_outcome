package com.gyf.barlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.database.ContentObserver;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ImmersionBar {
    private static final int BOUNDARY_COLOR = -4539718;
    private static final int FLAG_FITS_DEFAULT = 0;
    private static final int FLAG_FITS_STATUS = 3;
    private static final int FLAG_FITS_SYSTEM_WINDOWS = 4;
    private static final int FLAG_FITS_TITLE = 1;
    private static final int FLAG_FITS_TITLE_MARGIN_TOP = 2;
    private static final int IMMERSION_NAVIGATION_BAR_VIEW = 0;
    private static final int IMMERSION_STATUS_BAR_VIEW = 0;
    private static final String MIUI_NAVIGATION_BAR_DARK = "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE";
    private static final String MIUI_STATUS_BAR_DARK = "EXTRA_FLAG_STATUS_BAR_DARK_MODE";
    private static final String NAVIGATIONBAR_IS_MIN = "navigationbar_is_min";
    private static Map<String, ImmersionBar> mImmersionBarMap;
    private Activity mActivity;
    private a mBarConfig;
    private b mBarParams;
    private ViewGroup mContentView;
    private ViewGroup mDecorView;
    private Dialog mDialog;
    private c mFitsKeyboard;
    private int mFitsStatusBarType;
    private Fragment mFragment;
    private boolean mHasNavigationBarColor;
    private String mImmersionBarName;
    private boolean mIsFitsLayoutOverlap;
    private boolean mIsFitsNotch;
    private boolean mIsFragment;
    private int mNavigationBarHeight;
    private int mNavigationBarWidth;
    private ContentObserver mNavigationObserver;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private Map<String, b> mTagMap;
    private Window mWindow;

    /* JADX INFO: renamed from: com.gyf.barlibrary.ImmersionBar$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5123a = null;

        static {
            int[] r0 = new int[BarHide.values().length];
            f5123a = r0;
            r0[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f5123a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f5123a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f5123a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        IMMERSION_STATUS_BAR_VIEW = ZeusTransformUtils.mapRes(R.id.immersion_status_bar_view, OaidModel.KEY_ID, "immersion_status_bar_view");
        IMMERSION_NAVIGATION_BAR_VIEW = ZeusTransformUtils.mapRes(R.id.immersion_navigation_bar_view, OaidModel.KEY_ID, "immersion_navigation_bar_view");
        mImmersionBarMap = new HashMap();
    }

    private ImmersionBar(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        Activity r6 = ZeusTransformUtils.wrapperContext2Activity(r5, "com.obric.memorydata.plugin");
        this.mActivity = r6;
        this.mWindow = ZeusTransformUtils.getWindow(r6, "com.obric.memorydata.plugin");
        this.mImmersionBarName = this.mActivity.toString();
        this.mBarParams = new b();
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mWindow.getDecorView(), ViewGroup.class, "com.obric.memorydata.plugin");
        this.mDecorView = r7;
        this.mContentView = (ViewGroup) ZeusTransformUtils.preCheckCast(r7.findViewById(android.R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
    }

    private ImmersionBar(Activity r3, Dialog r4) {
        this((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"), r4, "");
    }

    private ImmersionBar(Activity r4, Dialog r5, String r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        Activity r0 = ZeusTransformUtils.wrapperContext2Activity(r7, "com.obric.memorydata.plugin");
        this.mActivity = r0;
        this.mDialog = r5;
        if (r0 == null) goto L14;
        if (r5 == null) goto L12;
        if (mImmersionBarMap.get(r0.toString()) == null) goto L10;
        this.mWindow = this.mDialog.getWindow();
        this.mImmersionBarName = r7.toString() + r5.toString() + r6;
        initParams();
        return;
    L10:
        throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
    L12:
        throw new IllegalArgumentException("dialog cannot be null");
    L14:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    private ImmersionBar(Activity r4, Fragment r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        Activity r0 = ZeusTransformUtils.wrapperContext2Activity(r6, "com.obric.memorydata.plugin");
        this.mActivity = r0;
        this.mFragment = r5;
        if (r0 == null) goto L11;
        if (mImmersionBarMap.get(r0.toString()) == null) goto L9;
        this.mIsFragment = true;
        this.mWindow = ZeusTransformUtils.getWindow(this.mActivity, "com.obric.memorydata.plugin");
        this.mImmersionBarName = r6.toString() + r5.toString();
        initParams();
        return;
    L9:
        throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
    L11:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    private ImmersionBar(DialogFragment r2) {
        this(r2, r2.getDialog());
    }

    private ImmersionBar(DialogFragment r4, Dialog r5) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        Activity r0 = ZeusTransformUtils.wrapperContext2Activity((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mActivity = r0;
        this.mFragment = r4;
        this.mDialog = r5;
        if (r0 == null) goto L14;
        if (r5 == null) goto L12;
        if (mImmersionBarMap.get(r0.toString()) == null) goto L10;
        this.mWindow = this.mDialog.getWindow();
        this.mImmersionBarName = this.mActivity.toString() + r4.toString();
        initParams();
        return;
    L10:
        throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
    L12:
        throw new IllegalArgumentException("dialog in DialogFragment cannot be null");
    L14:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    private ImmersionBar(Fragment r4) {
        this((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ a access$000(ImmersionBar r0) {
        return r0.mBarConfig;
    }

    static /* synthetic */ a access$002(ImmersionBar r0, a r1) {
        r0.mBarConfig = r1;
        return r1;
    }

    static /* synthetic */ Activity access$100(ImmersionBar r0) {
        return r0.mActivity;
    }

    static /* synthetic */ ViewGroup access$200(ImmersionBar r0) {
        return r0.mContentView;
    }

    static /* synthetic */ ViewGroup access$300(ImmersionBar r0) {
        return r0.mDecorView;
    }

    static /* synthetic */ int access$400(ImmersionBar r0) {
        return r0.mNavigationBarHeight;
    }

    static /* synthetic */ int access$402(ImmersionBar r0, int r1) {
        r0.mNavigationBarHeight = r1;
        return r1;
    }

    static /* synthetic */ int access$500(ImmersionBar r0) {
        return r0.mNavigationBarWidth;
    }

    static /* synthetic */ int access$502(ImmersionBar r0, int r1) {
        r0.mNavigationBarWidth = r1;
        return r1;
    }

    static /* synthetic */ b access$600(ImmersionBar r0) {
        return r0.mBarParams;
    }

    static /* synthetic */ void access$700(ImmersionBar r0, int r1, int r2, int r3, int r4) {
        r0.setPadding(r1, r2, r3, r4);
    }

    private void adjustDarkModeParams() {
        boolean r1 = true;
        if (this.mBarParams.l == false) goto L12;
        if (this.mBarParams.f5126a != 0) goto L7;
    L9:
        boolean r0 = false;
    L10:
        statusBarDarkFont(r0, this.mBarParams.n);
        goto L12
    L7:
        if (this.mBarParams.f5126a <= BOUNDARY_COLOR) goto L9;
        r0 = true;
    L12:
        if (this.mBarParams.m == true) goto L14;
        return;
    L14:
        if (this.mBarParams.f5127b != 0) goto L16;
    L18:
        r1 = false;
    L19:
        navigationBarDarkIcon(r1, this.mBarParams.o);
        return;
    L16:
        if (this.mBarParams.f5127b <= BOUNDARY_COLOR) goto L18;
        goto L18
    }

    private void cancelListener() {
        Activity r0 = this.mActivity;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mNavigationObserver == null) goto L7;
        ZeusProviderTransform.unregisterContentObserver(r0.getContentResolver(), this.mNavigationObserver, "com.obric.memorydata.plugin");
        this.mNavigationObserver = null;
    L7:
        c r1 = this.mFitsKeyboard;
        if (r1 == null) goto L12;
        r1.b();
        this.mFitsKeyboard = null;
        return;
    }

    public static boolean checkFitsSystemWindows(View r6) {
        if (r6.getFitsSystemWindows() == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L18;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin");
        int r0 = r7.getChildCount();
        int r3 = 0;
    L8:
        if (r3 >= r0) goto L18;
        View r4 = r7.getChildAt(r3);
        if (ZeusTransformUtils.instanceOf(r4, DrawerLayout.class) == false) goto L15;
        if (checkFitsSystemWindows(r4) == false) goto L15;
        return true;
    L15:
        if (r4.getFitsSystemWindows() == true) goto L16;
        r3 = r3 + 1;
        goto L8
    L16:
        return true;
    L18:
        return false;
    }

    private void checkNavigationBarFlag() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (this.mBarParams.c == false) goto L13;
        b r0 = this.mBarParams;
        if ((this.mWindow.getDecorView().getSystemUiVisibility() & 16) == 0) goto L9;
        boolean r2 = true;
    L10:
        r0.k = r2;
        return;
    L9:
        r2 = false;
        goto L10
    }

    private void checkNavigationBarInitialized() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return;
    L5:
        if (this.mBarParams.c == false) goto L9;
        this.mBarParams.f5127b = this.mWindow.getNavigationBarColor();
        return;
    }

    private void fitsKeyboard() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (this.mIsFragment == false) goto L7;
        ImmersionBar this = (ImmersionBar) ZeusTransformUtils.preCheckCast(mImmersionBarMap.get(this.mActivity.toString()), ImmersionBar.class, "com.obric.memorydata.plugin");
        if (this != null) goto L19;
        return;
    L19:
        if (this.mBarParams.C == true) goto L21;
        c r3 = this.mFitsKeyboard;
        if (r3 == null) goto L31;
    L15:
        r3.a();
        return;
    L31:
        return;
    L21:
        if (this.mFitsKeyboard == null) goto L22;
    L12:
        this.mFitsKeyboard.a(this.mBarParams.D);
        return;
    L22:
        c r0 = new c(this, this.mActivity, this.mWindow);
    L11:
        this.mFitsKeyboard = r0;
        goto L12
    L7:
        if (this.mBarParams.C == true) goto L9;
        r3 = this.mFitsKeyboard;
        if (r3 != null) goto L15;
        return;
    L9:
        if (this.mFitsKeyboard != null) goto L12;
        r0 = new c(this, this.mActivity, this.mWindow);
        goto L11
    }

    private void fitsLayoutOverlap() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (this.mIsFitsLayoutOverlap == true) goto L19;
        int r0 = this.mFitsStatusBarType;
        if (r0 != 1) goto L9;
        setTitleBar(this.mActivity, this.mBarParams.y);
    L16:
        this.mIsFitsLayoutOverlap = true;
        return;
    L9:
        if (r0 != 2) goto L11;
        setTitleBarMarginTop(this.mActivity, this.mBarParams.y);
        goto L16
    L11:
        if (r0 != 3) goto L20;
        setStatusBarView(this.mActivity, this.mBarParams.z);
        goto L16
    L20:
        return;
    }

    private void fitsNotchScreen() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return;
    L5:
        if (this.mIsFitsNotch == true) goto L9;
        WindowManager.LayoutParams r0 = this.mWindow.getAttributes();
        r0.layoutInDisplayCutoutMode = 1;
        this.mWindow.setAttributes(r0);
        this.mIsFitsNotch = true;
        return;
    }

    private void fitsWindows() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        fitsWindowsBelowLOLLIPOP();
        if (this.mIsFragment == false) goto L10;
        return;
    L10:
        if (h.h() == false) goto L15;
        fitsWindowsEMUI();
        return;
    L15:
        return;
    L5:
        if (h.h() == true) goto L7;
        fitsWindowsAboveLOLLIPOP();
    }

    private void fitsWindowsAboveLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content)) == false) goto L9;
        if (this.mBarParams.B == false) goto L19;
        setPadding(0, this.mBarConfig.c(), 0, 0);
        return;
    L19:
        return;
    L9:
        if (this.mBarParams.x == true) goto L11;
    L13:
        int r0 = 0;
    L15:
        if (this.mBarParams.B == false) goto L17;
        r0 = this.mBarConfig.b() + this.mBarConfig.c();
    L17:
        setPadding(0, r0, 0, 0);
        return;
    L11:
        if (this.mFitsStatusBarType != 4) goto L13;
        r0 = this.mBarConfig.b();
        goto L15
    }

    private void fitsWindowsBelowLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content)) == false) goto L9;
        if (this.mBarParams.B == false) goto L42;
        setPadding(0, this.mBarConfig.c(), 0, 0);
        return;
    L42:
        return;
    L9:
        if (this.mBarParams.x == true) goto L11;
    L13:
        int r0 = 0;
    L15:
        if (this.mBarParams.B == false) goto L18;
        r0 = this.mBarConfig.b() + this.mBarConfig.c();
    L18:
        if (this.mBarConfig.d() == true) goto L20;
    L39:
        int r2 = 0;
        int r3 = 0;
    L40:
        setPadding(0, r0, r2, r3);
        return;
    L20:
        if (this.mBarParams.E == false) goto L39;
        if (this.mBarParams.F == false) goto L39;
        if (this.mBarParams.g == false) goto L26;
        r2 = 0;
        r3 = 0;
    L31:
        if (this.mBarParams.h == false) goto L37;
        if (this.mBarConfig.a() == false) goto L35;
        r3 = 0;
        goto L40
    L35:
        r2 = 0;
        goto L40
    L37:
        if (this.mBarConfig.a() == true) goto L40;
        r2 = this.mBarConfig.f();
        goto L40
    L26:
        if (this.mBarConfig.a() == false) goto L28;
        r3 = this.mBarConfig.e();
        r2 = 0;
        goto L31
    L28:
        r2 = this.mBarConfig.f();
        r3 = 0;
        goto L31
    L11:
        if (this.mFitsStatusBarType != 4) goto L13;
        r0 = this.mBarConfig.b();
        goto L15
    }

    private void fitsWindowsEMUI() {
        final View r0 = this.mDecorView.findViewById(IMMERSION_NAVIGATION_BAR_VIEW);
        if (this.mBarParams.E == true) goto L5;
    L16:
        r0.setVisibility(8);
        return;
    L5:
        if (this.mBarParams.F == false) goto L16;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.mNavigationObserver != null) goto L19;
        final Handler r2 = new Handler();
        this.mNavigationObserver = new AnonymousClass1(this, r2, r0);
        Activity r1 = this.mActivity;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.getContentResolver() != null) goto L14;
        return;
    L14:
        if (this.mNavigationObserver == null) goto L22;
        ZeusProviderTransform.registerContentObserver(this.mActivity.getContentResolver(), Settings.System.getUriFor(NAVIGATIONBAR_IS_MIN), true, this.mNavigationObserver, "com.obric.memorydata.plugin");
        return;
    L22:
        return;
    }

    public static int getActionBarHeight(Activity r2) {
        return new a((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).c();
    }

    public static int getNavigationBarHeight(Activity r2) {
        return new a((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).e();
    }

    public static int getNavigationBarWidth(Activity r2) {
        return new a((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).f();
    }

    public static int getStatusBarHeight(Activity r2) {
        return new a((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).b();
    }

    public static boolean hasNavigationBar(Activity r2) {
        return new a((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).d();
    }

    public static boolean hasNotchScreen(Activity r2) {
        return new a((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).g();
    }

    public static boolean hasNotchScreen(View r0) {
        return g.a(r0);
    }

    private int hideBar(int r3) {
        if (Build.VERSION.SDK_INT < 16) goto L18;
        int r2 = AnonymousClass3.f5123a[this.mBarParams.i.ordinal()];
        if (r2 != 1) goto L7;
        r3 = r3 | 518;
        goto L18
    L7:
        if (r2 != 2) goto L9;
        r3 = r3 | 1028;
        goto L18
    L9:
        if (r2 != 3) goto L11;
        r3 = r3 | 514;
        goto L18
    L11:
        if (r2 != 4) goto L18;
        r3 = r3 | 0;
    L18:
        return r3 | 4096;
    }

    public static void hideStatusBar(Window r1) {
        r1.setFlags(1024, 1024);
    }

    private int initBarAboveLOLLIPOP(int r5) {
        if (this.mHasNavigationBarColor == true) goto L5;
        b r0 = this.mBarParams;
        r0.d = this.mWindow.getNavigationBarColor();
        this.mHasNavigationBarColor = true;
    L5:
        int r6 = r5 | 1024;
        if (this.mBarParams.g == true) goto L8;
    L10:
        this.mWindow.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        if (this.mBarConfig.d() == false) goto L13;
        this.mWindow.clearFlags(134217728);
    L13:
        this.mWindow.addFlags(Integer.MIN_VALUE);
        if (this.mBarParams.p == false) goto L16;
        Window r1 = this.mWindow;
        int r2 = this.mBarParams.f5126a;
        int r3 = this.mBarParams.q;
    L17:
        r1.setStatusBarColor(ColorUtils.blendARGB(r2, r3, this.mBarParams.e));
        if (this.mBarParams.E == false) goto L20;
        Window r4 = this.mWindow;
        int r7 = ColorUtils.blendARGB(this.mBarParams.f5127b, this.mBarParams.r, this.mBarParams.f);
    L21:
        r4.setNavigationBarColor(r7);
        return r6;
    L20:
        r4 = this.mWindow;
        r7 = this.mBarParams.d;
        goto L21
    L16:
        r1 = this.mWindow;
        r2 = this.mBarParams.f5126a;
        r3 = 0;
        goto L17
    L8:
        if (this.mBarParams.E == false) goto L10;
        r6 = r6 | 512;
        goto L10
    }

    private void initBarBelowLOLLIPOP() {
        this.mWindow.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        setupStatusBarView();
        if (this.mBarConfig.d() == true) goto L7;
        if (h.h() == true) goto L7;
        return;
    L7:
        if (this.mBarParams.E == true) goto L9;
    L11:
        this.mWindow.clearFlags(134217728);
    L13:
        if (this.mNavigationBarHeight != 0) goto L16;
        this.mNavigationBarHeight = this.mBarConfig.e();
    L16:
        if (this.mNavigationBarWidth != 0) goto L18;
        this.mNavigationBarWidth = this.mBarConfig.f();
    L18:
        setupNavBarView();
        return;
    L9:
        if (this.mBarParams.F == false) goto L11;
        this.mWindow.addFlags(134217728);
        goto L13
    }

    private void initParams() {
        this.mBarParams = new b();
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mWindow.getDecorView(), ViewGroup.class, "com.obric.memorydata.plugin");
        this.mDecorView = r0;
        this.mContentView = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.findViewById(android.R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
    }

    private static boolean isEmpty(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.trim().length() == 0) goto L7;
        return false;
    }

    public static boolean isNavigationAtBottom(Activity r2) {
        return new a((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).a();
    }

    public static boolean isSupportNavigationIconDark() {
        if (h.b() == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L8;
        return false;
    }

    public static boolean isSupportStatusBarDarkFont() {
        if (h.b() == false) goto L5;
    L10:
        return true;
    L5:
        if (h.j() == true) goto L10;
        if (Build.VERSION.SDK_INT >= 23) goto L10;
        return false;
    }

    private void setBar() {
        checkNavigationBarInitialized();
        if (Build.VERSION.SDK_INT < 19) goto L12;
        int r0 = 256;
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L9:
        initBarBelowLOLLIPOP();
    L10:
        int r1 = hideBar(r0);
        fitsWindows();
        this.mDecorView.setSystemUiVisibility(r1);
        goto L12
    L7:
        if (h.h() == true) goto L9;
        fitsNotchScreen();
        int r2 = setStatusBarDarkFont(initBarAboveLOLLIPOP(256));
        checkNavigationBarFlag();
        r0 = setNavigationIconDark(r2);
    L12:
        if (h.b() == false) goto L17;
        setMIUIBarDark(this.mWindow, MIUI_STATUS_BAR_DARK, this.mBarParams.j);
        if (this.mBarParams.E == false) goto L17;
        setMIUIBarDark(this.mWindow, MIUI_NAVIGATION_BAR_DARK, this.mBarParams.k);
    L17:
        if (h.j() == true) goto L19;
        return;
    L19:
        if (this.mBarParams.A == 0) goto L21;
        d.a(this.mActivity, this.mBarParams.A);
        return;
    L21:
        d.a(this.mActivity, this.mBarParams.j);
    }

    public static void setFitsSystemWindows(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        ViewGroup r8 = (ViewGroup) ZeusTransformUtils.preCheckCast(r7.findViewById(android.R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        int r2 = r8.getChildCount();
    L6:
        if (r0 >= r2) goto L14;
        View r3 = r8.getChildAt(r0);
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, DrawerLayout.class) == true) goto L13;
        r3.setFitsSystemWindows(true);
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin")).setClipToPadding(true);
    L13:
        r0 = r0 + 1;
        goto L6
    }

    private void setMIUIBarDark(Window r7, String r8, boolean r9) {
        if (r7 == null) goto L13;
        Class<?> r6 = r7.getClass();
        Class r0 = ZeusTransformUtils.forName("android.view.MiuiWindowManager$LayoutParams", "com.obric.memorydata.plugin");     // Catch: Exception -> L9
        int r10 = r0.getField(r8).getInt(r0);     // Catch: Exception -> L9
        Method r11 = r6.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L9
        if (r9 == false) goto L7;
        r11.invoke(r7, new Object[]{Integer.valueOf(r10), Integer.valueOf(r10)});     // Catch: Exception -> L9
    L10:
        return;
    L7:
        r11.invoke(r7, new Object[]{0, Integer.valueOf(r10)});     // Catch: Exception -> L9
    L14:
        return;
    }

    private int setNavigationIconDark(int r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L8:
        return r3;
    L5:
        if (this.mBarParams.k == false) goto L8;
        return r3 | 16;
    }

    private void setPadding(int r2, int r3, int r4, int r5) {
        ViewGroup r0 = this.mContentView;
        if (r0 == null) goto L5;
        r0.setPadding(r2, r3, r4, r5);
    L5:
        this.mPaddingLeft = r2;
        this.mPaddingTop = r3;
        this.mPaddingRight = r4;
        this.mPaddingBottom = r5;
    }

    private int setStatusBarDarkFont(int r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L8:
        return r3;
    L5:
        if (this.mBarParams.j == false) goto L8;
        return r3 | 8192;
    }

    public static void setStatusBarView(Activity r2, View r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 19) goto L11;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        r0.height = getStatusBarHeight(r4);
        r3.setLayoutParams(r0);
        return;
    }

    public static void setTitleBar(Activity r3, final View r4) {
        final Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 19) goto L17;
        final ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0.height != (-2)) goto L12;
    L15:
        r4.post(new AnonymousClass2(r0, r4, r5));
        return;
    L12:
        if (r0.height == (-1)) goto L15;
        r0.height += getStatusBarHeight(r5);
        r4.setPadding(r4.getPaddingLeft(), r4.getPaddingTop() + getStatusBarHeight(r5), r4.getPaddingRight(), r4.getPaddingBottom());
        return;
    }

    public static void setTitleBarMarginTop(Activity r3, View r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 19) goto L11;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r6.setMargins(r6.leftMargin, r6.topMargin + getStatusBarHeight(r5), r6.rightMargin, r6.bottomMargin);
        return;
    }

    private void setupNavBarView() {
        ViewGroup r0 = this.mDecorView;
        int r1 = IMMERSION_NAVIGATION_BAR_VIEW;
        View r2 = r0.findViewById(r1);
        if (r2 != null) goto L6;
        r2 = new View(this.mActivity);
        r2.setId(r1);
        this.mDecorView.addView(r2);
    L6:
        if (this.mBarConfig.a() == false) goto L8;
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, this.mBarConfig.e());
        int r4 = 80;
    L9:
        r3.gravity = r4;
        r2.setLayoutParams(r3);
        r2.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.f5127b, this.mBarParams.r, this.mBarParams.f));
        if (this.mBarParams.E == true) goto L12;
    L16:
        int r5 = 8;
    L17:
        r2.setVisibility(r5);
        return;
    L12:
        if (this.mBarParams.F == false) goto L16;
        if (this.mBarParams.h == true) goto L16;
        r5 = 0;
        goto L17
    L8:
        r3 = new FrameLayout.LayoutParams(this.mBarConfig.f(), -1);
        r4 = GravityCompat.END;
        goto L9
    }

    private void setupStatusBarView() {
        ViewGroup r0 = this.mDecorView;
        int r1 = IMMERSION_STATUS_BAR_VIEW;
        View r2 = r0.findViewById(r1);
        int r3 = 0;
        if (r2 != null) goto L6;
        r2 = new View(this.mActivity);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, this.mBarConfig.b());
        r4.gravity = 48;
        r2.setLayoutParams(r4);
        r2.setVisibility(0);
        r2.setId(r1);
        this.mDecorView.addView(r2);
    L6:
        if (this.mBarParams.p == false) goto L8;
        int r5 = this.mBarParams.f5126a;
        r3 = this.mBarParams.q;
    L9:
        r2.setBackgroundColor(ColorUtils.blendARGB(r5, r3, this.mBarParams.e));
        return;
    L8:
        r5 = this.mBarParams.f5126a;
        goto L9
    }

    private void transformView() {
        if (this.mBarParams.s.size() == 0) goto L17;
        Iterator<Map.Entry<View, Map<Integer, Integer>>> r0 = this.mBarParams.s.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L24;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1.getKey(), View.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r1.getValue(), Map.class, "com.obric.memorydata.plugin");
        Integer r4 = Integer.valueOf(this.mBarParams.f5126a);
        Integer r5 = Integer.valueOf(this.mBarParams.q);
        Iterator r6 = r3.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r7.getKey(), Integer.class, "com.obric.memorydata.plugin");
        r5 = (Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin");
        r4 = r8;
        goto L9
    L11:
        if (r2 == null) goto L6;
        if (Math.abs(this.mBarParams.t - 0.0f) != 0.0f) goto L15;
        int r9 = r4.intValue();
        int r10 = r5.intValue();
        float r11 = this.mBarParams.e;
    L16:
        r2.setBackgroundColor(ColorUtils.blendARGB(r9, r10, r11));
        goto L6
    L15:
        r9 = r4.intValue();
        r10 = r5.intValue();
        r11 = this.mBarParams.t;
        goto L16
    L24:
        return;
    }

    private void updateBarParams() {
        adjustDarkModeParams();
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (h.h() == true) goto L7;
    L9:
        this.mBarConfig = new a(this.mActivity);
        if (this.mIsFragment == false) goto L16;
        ImmersionBar r0 = (ImmersionBar) ZeusTransformUtils.preCheckCast(mImmersionBarMap.get(this.mActivity.toString()), ImmersionBar.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L17;
        r0.mBarParams = this.mBarParams;
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (this.mBarParams.F == false) goto L9;
        b r1 = this.mBarParams;
        r1.F = r1.G;
        goto L9
    }

    public static ImmersionBar with(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        ImmersionBar r0 = (ImmersionBar) ZeusTransformUtils.preCheckCast(mImmersionBarMap.get(r4.toString()), ImmersionBar.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ImmersionBar r1 = new ImmersionBar(r4);
        mImmersionBarMap.put(r4.toString(), r1);
        return r1;
    L6:
        return r0;
    }

    public static ImmersionBar with(Activity r4, Dialog r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        ImmersionBar r0 = (ImmersionBar) ZeusTransformUtils.preCheckCast(mImmersionBarMap.get(r6.toString() + r5.toString()), ImmersionBar.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ImmersionBar r1 = new ImmersionBar(r6, r5);
        mImmersionBarMap.put(r6.toString() + r5.toString(), r1);
        return r1;
    L6:
        return r0;
    }

    @Deprecated
    public static ImmersionBar with(Activity r4, Dialog r5, String r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        ImmersionBar r0 = (ImmersionBar) ZeusTransformUtils.preCheckCast(mImmersionBarMap.get(r7.toString() + r5.toString() + r6), ImmersionBar.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ImmersionBar r1 = new ImmersionBar(r7, r5, r6);
        mImmersionBarMap.put(r7.toString() + r5.toString() + r6, r1);
        return r1;
    L6:
        return r0;
    }

    public static ImmersionBar with(Activity r4, Fragment r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        ImmersionBar r0 = (ImmersionBar) ZeusTransformUtils.preCheckCast(mImmersionBarMap.get(r6.toString() + r5.toString()), ImmersionBar.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ImmersionBar r1 = new ImmersionBar(r6, r5);
        mImmersionBarMap.put(r6.toString() + r5.toString(), r1);
        return r1;
    L6:
        return r0;
    }

    public static ImmersionBar with(DialogFragment r6) {
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")) == null) goto L9;
        ImmersionBar r0 = (ImmersionBar) ZeusTransformUtils.preCheckCast(mImmersionBarMap.get(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).toString() + r6.toString()), ImmersionBar.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        ImmersionBar r1 = new ImmersionBar(r6);
        mImmersionBarMap.put(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).toString() + r6.toString(), r1);
        return r1;
    L10:
        return r0;
    L9:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    @Deprecated
    public static ImmersionBar with(DialogFragment r5, Dialog r6) {
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")) == null) goto L9;
        ImmersionBar r0 = (ImmersionBar) ZeusTransformUtils.preCheckCast(mImmersionBarMap.get(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).toString() + r5.toString()), ImmersionBar.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        ImmersionBar r1 = new ImmersionBar(r5, r6);
        mImmersionBarMap.put(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).toString() + r5.toString(), r1);
        return r1;
    L10:
        return r0;
    L9:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    public static ImmersionBar with(Fragment r6) {
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")) == null) goto L9;
        ImmersionBar r0 = (ImmersionBar) ZeusTransformUtils.preCheckCast(mImmersionBarMap.get(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).toString() + r6.toString()), ImmersionBar.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        ImmersionBar r1 = new ImmersionBar(r6);
        mImmersionBarMap.put(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).toString() + r6.toString(), r1);
        return r1;
    L10:
        return r0;
    L9:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    public ImmersionBar addTag(String r3) {
        if (isEmpty(r3) == true) goto L7;
        b r0 = this.mBarParams.a();
        this.mTagMap.put(r3, r0);
        return this;
    L7:
        throw new IllegalArgumentException("tag cannot be null");
    }

    public ImmersionBar addViewSupportTransformColor(View r2) {
        return addViewSupportTransformColorInt(r2, this.mBarParams.q);
    }

    public ImmersionBar addViewSupportTransformColor(View r2, int r3) {
        return addViewSupportTransformColorInt(r2, ContextCompat.getColor(this.mActivity, r3));
    }

    public ImmersionBar addViewSupportTransformColor(View r2, int r3, int r4) {
        return addViewSupportTransformColorInt(r2, ContextCompat.getColor(this.mActivity, r3), ContextCompat.getColor(this.mActivity, r4));
    }

    public ImmersionBar addViewSupportTransformColor(View r1, String r2) {
        return addViewSupportTransformColorInt(r1, Color.parseColor(r2));
    }

    public ImmersionBar addViewSupportTransformColor(View r1, String r2, String r3) {
        return addViewSupportTransformColorInt(r1, Color.parseColor(r2), Color.parseColor(r3));
    }

    public ImmersionBar addViewSupportTransformColorInt(View r3, int r4) {
        if (r3 == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put(Integer.valueOf(this.mBarParams.f5126a), Integer.valueOf(r4));
        this.mBarParams.s.put(r3, r0);
        return this;
    L6:
        throw new IllegalArgumentException("view cannot be null");
    }

    public ImmersionBar addViewSupportTransformColorInt(View r2, int r3, int r4) {
        if (r2 == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put(Integer.valueOf(r3), Integer.valueOf(r4));
        this.mBarParams.s.put(r2, r0);
        return this;
    L6:
        throw new IllegalArgumentException("view cannot be null");
    }

    public ImmersionBar autoDarkModeEnable(boolean r2) {
        return autoDarkModeEnable(r2, 0.2f);
    }

    public ImmersionBar autoDarkModeEnable(boolean r2, float r3) {
        this.mBarParams.l = r2;
        this.mBarParams.n = r3;
        this.mBarParams.m = r2;
        this.mBarParams.o = r3;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean r2) {
        return autoNavigationBarDarkModeEnable(r2, 0.2f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean r2, float r3) {
        this.mBarParams.m = r2;
        this.mBarParams.o = r3;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean r2) {
        return autoStatusBarDarkModeEnable(r2, 0.2f);
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean r2, float r3) {
        this.mBarParams.l = r2;
        this.mBarParams.n = r3;
        return this;
    }

    public ImmersionBar barAlpha(float r2) {
        this.mBarParams.e = r2;
        this.mBarParams.f = r2;
        return this;
    }

    public ImmersionBar barColor(int r2) {
        return barColorInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar barColor(int r1, float r2) {
        return barColorInt(ContextCompat.getColor(this.mActivity, r1), r1);
    }

    public ImmersionBar barColor(int r2, int r3, float r4) {
        return barColorInt(ContextCompat.getColor(this.mActivity, r2), ContextCompat.getColor(this.mActivity, r3), r4);
    }

    public ImmersionBar barColor(String r1) {
        return barColorInt(Color.parseColor(r1));
    }

    public ImmersionBar barColor(String r1, float r2) {
        return barColorInt(Color.parseColor(r1), r2);
    }

    public ImmersionBar barColor(String r1, String r2, float r3) {
        return barColorInt(Color.parseColor(r1), Color.parseColor(r2), r3);
    }

    public ImmersionBar barColorInt(int r2) {
        this.mBarParams.f5126a = r2;
        this.mBarParams.f5127b = r2;
        this.mBarParams.c = false;
        return this;
    }

    public ImmersionBar barColorInt(int r2, float r3) {
        this.mBarParams.f5126a = r2;
        this.mBarParams.f5127b = r2;
        this.mBarParams.c = false;
        this.mBarParams.e = r3;
        this.mBarParams.f = r3;
        return this;
    }

    public ImmersionBar barColorInt(int r2, int r3, float r4) {
        this.mBarParams.f5126a = r2;
        this.mBarParams.f5127b = r2;
        this.mBarParams.c = false;
        this.mBarParams.q = r3;
        this.mBarParams.r = r3;
        this.mBarParams.e = r4;
        this.mBarParams.f = r4;
        return this;
    }

    public ImmersionBar barColorTransform(int r2) {
        return barColorTransformInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar barColorTransform(String r1) {
        return barColorTransformInt(Color.parseColor(r1));
    }

    public ImmersionBar barColorTransformInt(int r2) {
        this.mBarParams.q = r2;
        this.mBarParams.r = r2;
        return this;
    }

    public void destroy() {
        cancelListener();
        Iterator<Map.Entry<String, ImmersionBar>> r0 = mImmersionBarMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin")).contains(this.mImmersionBarName) == true) goto L9;
        if (((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin")).equals(this.mImmersionBarName) == false) goto L4;
    L9:
        r0.remove();
        goto L4
    }

    public ImmersionBar fitsSystemWindows(boolean r2) {
        this.mBarParams.x = r2;
        if (this.mBarParams.x == true) goto L5;
        int r3 = 0;
    L8:
        this.mFitsStatusBarType = r3;
    L9:
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L9;
        r3 = 4;
        goto L8
    }

    public ImmersionBar fitsSystemWindows(boolean r2, int r3) {
        return fitsSystemWindowsInt(r2, ContextCompat.getColor(this.mActivity, r3));
    }

    public ImmersionBar fitsSystemWindows(boolean r2, int r3, int r4, float r5) {
        return fitsSystemWindowsInt(r2, ContextCompat.getColor(this.mActivity, r3), ContextCompat.getColor(this.mActivity, r4), r5);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean r3, int r4) {
        return fitsSystemWindowsInt(r3, r4, ViewCompat.MEASURED_STATE_MASK, 0.0f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean r2, int r3, int r4, float r5) {
        this.mBarParams.x = r2;
        this.mBarParams.u = r3;
        this.mBarParams.v = r4;
        this.mBarParams.w = r5;
        if (this.mBarParams.x == true) goto L5;
        int r6 = 0;
    L8:
        this.mFitsStatusBarType = r6;
    L9:
        this.mContentView.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.u, this.mBarParams.v, this.mBarParams.w));
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L9;
        r6 = 4;
        goto L8
    }

    @Deprecated
    public ImmersionBar fixMarginAtBottom(boolean r2) {
        this.mBarParams.H = r2;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(int r3) {
        b r0 = this.mBarParams;
        r0.A = ContextCompat.getColor(this.mActivity, r3);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(String r2) {
        b r0 = this.mBarParams;
        r0.A = Color.parseColor(r2);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int r2) {
        this.mBarParams.A = r2;
        return this;
    }

    public ImmersionBar fullScreen(boolean r2) {
        this.mBarParams.g = r2;
        return this;
    }

    public b getBarParams() {
        return this.mBarParams;
    }

    int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    int getPaddingRight() {
        return this.mPaddingRight;
    }

    int getPaddingTop() {
        return this.mPaddingTop;
    }

    public ImmersionBar getTag(String r3) {
        if (isEmpty(r3) == true) goto L9;
        b r4 = (b) ZeusTransformUtils.preCheckCast(this.mTagMap.get(r3), b.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.mBarParams = r4.a();
    L7:
        return this;
    L9:
        throw new IllegalArgumentException("tag cannot be null");
    }

    public ImmersionBar hideBar(BarHide r3) {
        this.mBarParams.i = r3;
        if (Build.VERSION.SDK_INT != 19) goto L5;
    L6:
        boolean r0 = false;
        this.mBarParams.c = false;
        if (this.mBarParams.i != BarHide.FLAG_HIDE_NAVIGATION_BAR) goto L9;
    L12:
        b r4 = this.mBarParams;
        r0 = true;
    L13:
        r4.h = r0;
    L14:
        return this;
    L9:
        if (this.mBarParams.i == BarHide.FLAG_HIDE_BAR) goto L12;
        r4 = this.mBarParams;
        goto L13
    L5:
        if (h.h() == false) goto L14;
        goto L6
    }

    public void init() {
        updateBarParams();
        setBar();
        fitsLayoutOverlap();
        fitsKeyboard();
        transformView();
    }

    public ImmersionBar keyboardEnable(boolean r2) {
        return keyboardEnable(r2, this.mBarParams.D);
    }

    public ImmersionBar keyboardEnable(boolean r2, int r3) {
        this.mBarParams.C = r2;
        this.mBarParams.D = r3;
        return this;
    }

    public ImmersionBar keyboardMode(int r2) {
        this.mBarParams.D = r2;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float r2) {
        this.mBarParams.f = r2;
        return this;
    }

    public ImmersionBar navigationBarColor(int r2) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar navigationBarColor(int r2, float r3) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, r2), r3);
    }

    public ImmersionBar navigationBarColor(int r2, int r3, float r4) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, r2), ContextCompat.getColor(this.mActivity, r3), r4);
    }

    public ImmersionBar navigationBarColor(String r1) {
        return navigationBarColorInt(Color.parseColor(r1));
    }

    public ImmersionBar navigationBarColor(String r1, float r2) {
        return navigationBarColorInt(Color.parseColor(r1), r2);
    }

    public ImmersionBar navigationBarColor(String r1, String r2, float r3) {
        return navigationBarColorInt(Color.parseColor(r1), Color.parseColor(r2), r3);
    }

    public ImmersionBar navigationBarColorInt(int r2) {
        this.mBarParams.f5127b = r2;
        this.mBarParams.c = false;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int r2, float r3) {
        this.mBarParams.f5127b = r2;
        this.mBarParams.c = false;
        this.mBarParams.f = r3;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int r2, int r3, float r4) {
        this.mBarParams.f5127b = r2;
        this.mBarParams.c = false;
        this.mBarParams.r = r3;
        this.mBarParams.f = r4;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int r2) {
        return navigationBarColorTransformInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar navigationBarColorTransform(String r1) {
        return navigationBarColorTransformInt(Color.parseColor(r1));
    }

    public ImmersionBar navigationBarColorTransformInt(int r2) {
        this.mBarParams.r = r2;
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean r2) {
        return navigationBarDarkIcon(r2, 0.2f);
    }

    public ImmersionBar navigationBarDarkIcon(boolean r2, float r3) {
        this.mBarParams.k = r2;
        if (r2 == true) goto L5;
    L7:
        b r4 = this.mBarParams;
        r3 = 0.0f;
    L8:
        r4.f = r3;
        return this;
    L5:
        if (isSupportNavigationIconDark() == true) goto L7;
        r4 = this.mBarParams;
        goto L8
    }

    public ImmersionBar navigationBarEnable(boolean r2) {
        this.mBarParams.E = r2;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean r2) {
        this.mBarParams.G = r2;
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean r2) {
        this.mBarParams.F = r2;
        return this;
    }

    public ImmersionBar removeSupportAllView() {
        if (this.mBarParams.s.size() == 0) goto L5;
        this.mBarParams.s.clear();
    L5:
        return this;
    }

    public ImmersionBar removeSupportView(View r4) {
        if (r4 == null) goto L10;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.mBarParams.s.get(r4), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
    L8:
        return this;
    L6:
        if (r0.size() == 0) goto L8;
        this.mBarParams.s.remove(r4);
        goto L8
    L10:
        throw new IllegalArgumentException("view cannot be null");
    }

    public ImmersionBar reset() {
        this.mBarParams = new b();
        this.mFitsStatusBarType = 0;
        return this;
    }

    public ImmersionBar setOnKeyboardListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        if (this.mBarParams.I != null) goto L5;
        this.mBarParams.I = r4;
    L5:
        return this;
    }

    public ImmersionBar statusBarAlpha(float r2) {
        this.mBarParams.e = r2;
        return this;
    }

    public ImmersionBar statusBarColor(int r2) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar statusBarColor(int r2, float r3) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, r2), r3);
    }

    public ImmersionBar statusBarColor(int r2, int r3, float r4) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, r2), ContextCompat.getColor(this.mActivity, r3), r4);
    }

    public ImmersionBar statusBarColor(String r1) {
        return statusBarColorInt(Color.parseColor(r1));
    }

    public ImmersionBar statusBarColor(String r1, float r2) {
        return statusBarColorInt(Color.parseColor(r1), r2);
    }

    public ImmersionBar statusBarColor(String r1, String r2, float r3) {
        return statusBarColorInt(Color.parseColor(r1), Color.parseColor(r2), r3);
    }

    public ImmersionBar statusBarColorInt(int r2) {
        this.mBarParams.f5126a = r2;
        return this;
    }

    public ImmersionBar statusBarColorInt(int r2, float r3) {
        this.mBarParams.f5126a = r2;
        this.mBarParams.e = r3;
        return this;
    }

    public ImmersionBar statusBarColorInt(int r2, int r3, float r4) {
        this.mBarParams.f5126a = r2;
        this.mBarParams.q = r3;
        this.mBarParams.e = r4;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int r2) {
        return statusBarColorTransformInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar statusBarColorTransform(String r1) {
        return statusBarColorTransformInt(Color.parseColor(r1));
    }

    public ImmersionBar statusBarColorTransformEnable(boolean r2) {
        this.mBarParams.p = r2;
        return this;
    }

    public ImmersionBar statusBarColorTransformInt(int r2) {
        this.mBarParams.q = r2;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean r2) {
        return statusBarDarkFont(r2, 0.2f);
    }

    public ImmersionBar statusBarDarkFont(boolean r2, float r3) {
        this.mBarParams.j = r2;
        if (r2 == true) goto L5;
    L7:
        this.mBarParams.A = 0;
        b r4 = this.mBarParams;
        r3 = 0.0f;
    L8:
        r4.e = r3;
        return this;
    L5:
        if (isSupportStatusBarDarkFont() == true) goto L7;
        r4 = this.mBarParams;
        goto L8
    }

    public ImmersionBar statusBarView(int r2) {
        return statusBarView(this.mActivity.findViewById(r2));
    }

    public ImmersionBar statusBarView(int r1, View r2) {
        return statusBarView(r2.findViewById(r1));
    }

    public ImmersionBar statusBarView(View r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        this.mBarParams.z = r2;
        if (this.mFitsStatusBarType != 0) goto L7;
        this.mFitsStatusBarType = 3;
    L7:
        return this;
    }

    public ImmersionBar supportActionBar(boolean r2) {
        this.mBarParams.B = r2;
        return this;
    }

    public ImmersionBar titleBar(int r2) {
        return titleBar(r2, true);
    }

    public ImmersionBar titleBar(int r1, View r2) {
        return titleBar(r2.findViewById(r1), true);
    }

    public ImmersionBar titleBar(int r1, View r2, boolean r3) {
        return titleBar(r2.findViewById(r1), r3);
    }

    public ImmersionBar titleBar(int r2, boolean r3) {
        Fragment r0 = this.mFragment;
        if (r0 != null) goto L5;
    L9:
        View r4 = this.mActivity.findViewById(r2);
    L8:
        return titleBar(r4, r3);
    L5:
        if (r0.getView() == null) goto L9;
        r4 = this.mFragment.getView().findViewById(r2);
        goto L8
    }

    public ImmersionBar titleBar(View r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        return titleBar(r2, true);
    }

    public ImmersionBar titleBar(View r2, boolean r3) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L7;
        this.mFitsStatusBarType = 1;
    L7:
        this.mBarParams.y = r2;
        this.mBarParams.p = r3;
        return this;
    }

    public ImmersionBar titleBarMarginTop(int r2) {
        Fragment r0 = this.mFragment;
        if (r0 != null) goto L5;
    L9:
        View r3 = this.mActivity.findViewById(r2);
    L8:
        return titleBarMarginTop(r3);
    L5:
        if (r0.getView() == null) goto L9;
        r3 = this.mFragment.getView().findViewById(r2);
        goto L8
    }

    public ImmersionBar titleBarMarginTop(int r1, View r2) {
        return titleBarMarginTop(r2.findViewById(r1));
    }

    public ImmersionBar titleBarMarginTop(View r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L7;
        this.mFitsStatusBarType = 2;
    L7:
        this.mBarParams.y = r2;
        return this;
    }

    public ImmersionBar transparentBar() {
        this.mBarParams.f5126a = 0;
        this.mBarParams.f5127b = 0;
        this.mBarParams.c = false;
        this.mBarParams.g = true;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        this.mBarParams.f5127b = 0;
        this.mBarParams.c = false;
        this.mBarParams.g = true;
        return this;
    }

    public ImmersionBar transparentStatusBar() {
        this.mBarParams.f5126a = 0;
        return this;
    }

    public ImmersionBar viewAlpha(float r2) {
        this.mBarParams.t = r2;
        return this;
    }
}
