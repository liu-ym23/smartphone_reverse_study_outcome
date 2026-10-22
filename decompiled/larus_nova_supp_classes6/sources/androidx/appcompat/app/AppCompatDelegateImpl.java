package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean IS_PRE_LOLLIPOP = false;
    private static final boolean sCanApplyOverrideConfiguration = false;
    private static final boolean sCanReturnDifferentContext = false;
    private static boolean sInstalledExceptionHandler;
    private static final SimpleArrayMap<String, Integer> sLocalNightModes = null;
    private static final int[] sWindowBackgroundStyleable = null;
    ActionBar mActionBar;
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private boolean mActivityHandlesUiMode;
    private boolean mActivityHandlesUiModeChecked;
    final AppCompatCallback mAppCompatCallback;
    private AppCompatViewInflater mAppCompatViewInflater;
    private AppCompatWindowCallback mAppCompatWindowCallback;
    private AutoNightModeManager mAutoBatteryNightModeManager;
    private AutoNightModeManager mAutoTimeNightModeManager;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    final Context mContext;
    private boolean mCreated;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    ViewPropertyAnimatorCompat mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes;
    boolean mHasActionBar;
    final Object mHost;
    int mInvalidatePanelMenuFeatures;
    boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable;
    boolean mIsDestroyed;
    boolean mIsFloating;
    private LayoutIncludeDetector mLayoutIncludeDetector;
    private int mLocalNightMode;
    private boolean mLongPressBackDown;
    MenuInflater mMenuInflater;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private boolean mStarted;
    private View mStatusGuard;
    ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private int mThemeResId;
    private CharSequence mTitle;
    private TextView mTitleView;
    Window mWindow;
    boolean mWindowNoTitle;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private void ensureSubDecor() {
        androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_ContentFrameLayoutNPE_ensureSubDecorInsert(this);
    }

    private int sanitizeWindowFeatureId(int r2) {
        if (r2 != 8) goto L7;
        return 108;
    L7:
        if (r2 != 9) goto L10;
        return 109;
    L10:
        return r2;
    }

    public boolean applyDayNight() {
        return applyDayNight(true);
    }

    public void onSaveInstanceState(Bundle r1) {
    }

    public void onStart() {
        this.mStarted = true;
        applyDayNight();
    }

    public void onStop() {
        this.mStarted = false;
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L6;
        r1.setShowHideAnimationEnabled(false);
        return;
    }

    public void onSubDecorInstalled(ViewGroup r1) {
    }

    static {
        sLocalNightModes = new SimpleArrayMap();
        IS_PRE_LOLLIPOP = false;
        sWindowBackgroundStyleable = new int[]{R.attr.windowBackground};
        sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
        sCanApplyOverrideConfiguration = true;
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout r0 = this.mSubDecor.findViewById(R.id.content);
        View r1 = INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow);
        r0.setDecorPadding(r1.getPaddingLeft(), r1.getPaddingTop(), r1.getPaddingRight(), r1.getPaddingBottom());
        TypedArray r2 = this.mContext.obtainStyledAttributes(new int[]{R.attr.windowIsFloating, R.attr.windowAnimationStyle, 2130968710, 2130968711, 2130968712, 2130968713, 2130968714, 2130968715, 2130968716, 2130968717, 2130968718, 2130968719, 2130968720, 2130968721, 2130968722, 2130968724, 2130968725, 2130968726, 2130968727, 2130968728, 2130968729, 2130968730, 2130968731, 2130968732, 2130968733, 2130968734, 2130968735, 2130968736, 2130968737, 2130968738, 2130968739, 2130968740, 2130968741, 2130968742, 2130968747, 2130968767, 2130968768, 2130968769, 2130968770, 2130968871, 2130969037, 2130969098, 2130969099, 2130969100, 2130969101, 2130969102, 2130969107, 2130969108, 2130969183, 2130969189, 2130969561, 2130969562, 2130969563, 2130969564, 2130969565, 2130969566, 2130969567, 2130969568, 2130969569, 2130969571, 2130969637, 2130969751, 2130969752, 2130969753, 2130969764, 2130969772, 2130969843, 2130969844, 2130969937, 2130969938, 2130969939, 2130970261, 2130970320, 2130972554, 2130972556, 2130972558, 2130972559, 2130972562, 2130972563, 2130972564, 2130972565, 2130972566, 2130972567, 2130972568, 2130972569, 2130972570, 2130973434, 2130973435, 2130973436, 2130973584, 2130973586, 2130973710, 2130973725, 2130973726, 2130973727, 2130973954, 2130973996, 2130974008, 2130974009, 2130974125, 2130974126, 2130974350, 2130974508, 2130974509, 2130974510, 2130974511, 2130974513, 2130974514, 2130974515, 2130974516, 2130974526, 2130974528, 2130974605, 2130974606, 2130974611, 2130974612, 2130975037, 2130975145, 2130975146, 2130975147, 2130975148, 2130975149, 2130975150, 2130975151, 2130975152, 2130975153, 2130975154});
        r2.getValue(124, r0.getMinWidthMajor());
        r2.getValue(125, r0.getMinWidthMinor());
        if (r2.hasValue(122) == false) goto L6;
        r2.getValue(122, r0.getFixedWidthMajor());
    L6:
        if (r2.hasValue(123) == false) goto L9;
        r2.getValue(123, r0.getFixedWidthMinor());
    L9:
        if (r2.hasValue(120) == false) goto L12;
        r2.getValue(120, r0.getFixedHeightMajor());
    L12:
        if (r2.hasValue(121) == false) goto L14;
        r2.getValue(121, r0.getFixedHeightMinor());
    L14:
        r2.recycle();
        r0.requestLayout();
    }

    private int calculateNightMode() {
        int r0 = this.mLocalNightMode;
        if (r0 == (-100)) goto L6;
        return r0;
    L6:
        return AppCompatDelegate.getDefaultNightMode();
    }

    private void cleanupAutoManagers() {
        AutoNightModeManager r0 = this.mAutoTimeNightModeManager;
        if (r0 == null) goto L5;
        r0.cleanup();
    L5:
        AutoNightModeManager r1 = this.mAutoBatteryNightModeManager;
        if (r1 == null) goto L9;
        r1.cleanup();
        return;
    }

    private ViewGroup createSubDecor() {
        TypedArray r0 = this.mContext.obtainStyledAttributes(new int[]{R.attr.windowIsFloating, R.attr.windowAnimationStyle, 2130968710, 2130968711, 2130968712, 2130968713, 2130968714, 2130968715, 2130968716, 2130968717, 2130968718, 2130968719, 2130968720, 2130968721, 2130968722, 2130968724, 2130968725, 2130968726, 2130968727, 2130968728, 2130968729, 2130968730, 2130968731, 2130968732, 2130968733, 2130968734, 2130968735, 2130968736, 2130968737, 2130968738, 2130968739, 2130968740, 2130968741, 2130968742, 2130968747, 2130968767, 2130968768, 2130968769, 2130968770, 2130968871, 2130969037, 2130969098, 2130969099, 2130969100, 2130969101, 2130969102, 2130969107, 2130969108, 2130969183, 2130969189, 2130969561, 2130969562, 2130969563, 2130969564, 2130969565, 2130969566, 2130969567, 2130969568, 2130969569, 2130969571, 2130969637, 2130969751, 2130969752, 2130969753, 2130969764, 2130969772, 2130969843, 2130969844, 2130969937, 2130969938, 2130969939, 2130970261, 2130970320, 2130972554, 2130972556, 2130972558, 2130972559, 2130972562, 2130972563, 2130972564, 2130972565, 2130972566, 2130972567, 2130972568, 2130972569, 2130972570, 2130973434, 2130973435, 2130973436, 2130973584, 2130973586, 2130973710, 2130973725, 2130973726, 2130973727, 2130973954, 2130973996, 2130974008, 2130974009, 2130974125, 2130974126, 2130974350, 2130974508, 2130974509, 2130974510, 2130974511, 2130974513, 2130974514, 2130974515, 2130974516, 2130974526, 2130974528, 2130974605, 2130974606, 2130974611, 2130974612, 2130975037, 2130975145, 2130975146, 2130975147, 2130975148, 2130975149, 2130975150, 2130975151, 2130975152, 2130975153, 2130975154});
        if (r0.hasValue(117) == true) goto L5;
        r0.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    L5:
        if (r0.getBoolean(126, false) == false) goto L8;
        requestWindowFeature(1);
    L11:
        if (r0.getBoolean(118, false) == false) goto L14;
        requestWindowFeature(109);
    L14:
        if (r0.getBoolean(119, false) == false) goto L16;
        requestWindowFeature(10);
    L16:
        this.mIsFloating = r0.getBoolean(0, false);
        r0.recycle();
        ensureWindow();
        INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow);
        LayoutInflater r1 = LayoutInflater.from(this.mContext);
        if (this.mWindowNoTitle == true) goto L38;
        if (this.mIsFloating == false) goto L22;
        ViewGroup r2 = (ViewGroup) r1.inflate(2131558418, null);
        this.mOverlayActionBar = false;
        this.mHasActionBar = false;
    L41:
        if (r2 == null) goto L56;
        ViewCompat.setOnApplyWindowInsetsListener(r2, new 3(this));
        if (this.mDecorContentParent != null) goto L45;
        this.mTitleView = (TextView) r2.findViewById(2131388772);
    L45:
        ViewUtils.makeOptionalFitsSystemWindows(r2);
        ContentFrameLayout r3 = r2.findViewById(2131362042);
        ViewGroup r4 = (ViewGroup) this.mWindow.findViewById(R.id.content);
        if (r4 != null) goto L48;
    L53:
        this.mWindow.setContentView(r2);
        r3.setAttachListener(new 5(this));
        return r2;
    L48:
        if (r4.getChildCount() <= 0) goto L50;
        View r6 = r4.getChildAt(0);
        r4.removeViewAt(0);
        r3.addView(r6);
        goto L48
    L50:
        r4.setId(-1);
        r3.setId(R.id.content);
        if ((r4 instanceof FrameLayout) == false) goto L53;
        ((FrameLayout) r4).setForeground(null);
        goto L53
    L56:
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
    L22:
        if (this.mHasActionBar == false) goto L36;
        TypedValue r5 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(2130968719, r5, true);
        if (r5.resourceId == 0) goto L26;
        ContextThemeWrapper r7 = new ContextThemeWrapper(this.mContext, r5.resourceId);
    L27:
        r2 = (ViewGroup) LayoutInflater.from(r7).inflate(2131558429, null);
        DecorContentParent r8 = r2.findViewById(2131368631);
        this.mDecorContentParent = r8;
        r8.setWindowCallback(getWindowCallback());
        if (this.mOverlayActionBar == false) goto L31;
        this.mDecorContentParent.initFeature(109);
    L31:
        if (this.mFeatureProgress == false) goto L34;
        this.mDecorContentParent.initFeature(2);
    L34:
        if (this.mFeatureIndeterminateProgress == false) goto L41;
        this.mDecorContentParent.initFeature(5);
        goto L41
    L26:
        r7 = this.mContext;
        goto L27
    L36:
        r2 = null;
        goto L41
    L38:
        if (this.mOverlayActionMode == false) goto L40;
        r2 = (ViewGroup) r1.inflate(2131558428, null);
        goto L41
    L40:
        r2 = (ViewGroup) r1.inflate(2131558427, null);
        goto L41
    L8:
        if (r0.getBoolean(117, false) == false) goto L11;
        requestWindowFeature(108);
        goto L11
    }

    private void ensureWindow() {
        if (this.mWindow != null) goto L8;
        Object r0 = this.mHost;
        if ((r0 instanceof Activity) == false) goto L8;
        attachToWindow(((Activity) r0).getWindow());
    L8:
        if (this.mWindow == null) goto L11;
        return;
    L11:
        throw new IllegalStateException("We have not been given a Window");
    }

    private boolean isActivityManifestHandlingUiMode() {
        if (this.mActivityHandlesUiModeChecked == false) goto L5;
    L25:
        this.mActivityHandlesUiModeChecked = true;
        return this.mActivityHandlesUiMode;
    L5:
        if ((this.mHost instanceof Activity) == false) goto L25;
        PackageManager r0 = this.mContext.getPackageManager();
        if (r0 != null) goto L27;
        return false;
    L27:
        int r3 = Build.VERSION.SDK_INT;     // Catch: PackageManager.NameNotFoundException -> L24
        if (r3 < 29) goto L13;
        int r4 = 269221888;
    L16:
        ActivityInfo r1 = r0.getActivityInfo(new ComponentName(this.mContext, this.mHost.getClass()), r4);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r1 != null) goto L19;
    L21:
        boolean r2 = false;
    L22:
        this.mActivityHandlesUiMode = r2;     // Catch: PackageManager.NameNotFoundException -> L24
        goto L25
    L19:
        if ((r1.configChanges & ISmModel.VERSION_0200) == 0) goto L21;
        r2 = true;
        goto L22
    L13:
        if (r3 < 24) goto L15;
        r4 = 786432;
        goto L16
    L15:
        r4 = 0;
    L24:
        this.mActivityHandlesUiMode = false;
        goto L25
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled == true) goto L6;
        return;
    L6:
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    private AppCompatActivity tryUnwrapContext() {
        Context r0 = this.mContext;
    L4:
        if (r0 == null) goto L12;
        if ((r0 instanceof AppCompatActivity) == true) goto L8;
        if ((r0 instanceof ContextWrapper) == false) goto L12;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L8:
        return (AppCompatActivity) r0;
    L12:
        return null;
    }

    public void androidx_appcompat_app_AppCompatDelegateImpl__ensureSubDecor$___twin___() {
        if (this.mSubDecorInstalled == true) goto L22;
        this.mSubDecor = createSubDecor();
        CharSequence r0 = getTitle();
        if (TextUtils.isEmpty(r0) == true) goto L15;
        DecorContentParent r1 = this.mDecorContentParent;
        if (r1 == null) goto L10;
        r1.setWindowTitle(r0);
        goto L15
    L10:
        if (peekSupportActionBar() == null) goto L12;
        peekSupportActionBar().setWindowTitle(r0);
        goto L15
    L12:
        TextView r2 = this.mTitleView;
        if (r2 == null) goto L15;
        r2.setText(r0);
    L15:
        applyFixedSizeWindow();
        onSubDecorInstalled(this.mSubDecor);
        this.mSubDecorInstalled = true;
        PanelFeatureState r3 = getPanelState(0, false);
        if (this.mIsDestroyed == true) goto L23;
        if (r3 != null) goto L19;
    L20:
        invalidatePanelMenu(108);
        return;
    L19:
        if (r3.menu == null) goto L20;
        return;
    L23:
        return;
    }

    public void dismissPopups() {
        DecorContentParent r0 = this.mDecorContentParent;
        if (r0 == null) goto L6;
        r0.dismissPopups();
    L6:
        if (this.mActionModePopup == null) goto L11;
        INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow).removeCallbacks(this.mShowActionModePopup);
        if (this.mActionModePopup.isShowing() == true) goto L18;
    L10:
        this.mActionModePopup = null;
        goto L11
    L18:
        INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this.mActionModePopup);     // Catch: IllegalArgumentException -> L17
    L11:
        endOnGoingFadeAnimation();
        PanelFeatureState r1 = getPanelState(0, false);
        if (r1 == null) goto L20;
        MenuBuilder r2 = r1.menu;
        if (r2 == null) goto L21;
        r2.close();
        return;
    L21:
        return;
    }

    public void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat r0 = this.mFadeAnim;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public final AutoNightModeManager getAutoTimeNightModeManager() {
        return getAutoTimeNightModeManager(this.mContext);
    }

    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl(this);
    }

    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater != null) goto L10;
        initWindowDecorActionBar();
        ActionBar r1 = this.mActionBar;
        if (r1 == null) goto L7;
        Context r2 = r1.getThemedContext();
    L8:
        this.mMenuInflater = new SupportMenuInflater(r2);
        goto L10
    L7:
        r2 = this.mContext;
    L10:
        return this.mMenuInflater;
    }

    public final CharSequence getTitle() {
        Object r0 = this.mHost;
        if ((r0 instanceof Activity) == false) goto L7;
        return ((Activity) r0).getTitle();
    L7:
        return this.mTitle;
    }

    public final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    public void installViewFactory() {
        LayoutInflater r0 = LayoutInflater.from(this.mContext);
        if (r0.getFactory() != null) goto L5;
        LayoutInflaterCompat.setFactory2(r0, this);
        return;
    L5:
        boolean r1 = r0.getFactory2() instanceof AppCompatDelegateImpl;
    }

    public boolean onBackPressed() {
        ActionMode r0 = this.mActionMode;
        if (r0 == null) goto L6;
        r0.finish();
        return true;
    L6:
        ActionBar r1 = getSupportActionBar();
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.collapseActionView() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public void onDestroy() {
        if ((this.mHost instanceof Activity) == false) goto L6;
        AppCompatDelegate.removeActivityDelegate(this);
    L6:
        if (this.mInvalidatePanelMenuPosted == false) goto L8;
        INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow).removeCallbacks(this.mInvalidatePanelMenuRunnable);
    L8:
        this.mStarted = false;
        this.mIsDestroyed = true;
        if (this.mLocalNightMode == (-100)) goto L15;
        Object r0 = this.mHost;
        if ((r0 instanceof Activity) == false) goto L15;
        if (((Activity) r0).isChangingConfigurations() == false) goto L15;
        sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
    L16:
        ActionBar r1 = this.mActionBar;
        if (r1 == null) goto L19;
        r1.onDestroy();
    L19:
        cleanupAutoManagers();
        return;
    L15:
        sLocalNightModes.remove(this.mHost.getClass().getName());
        goto L16
    }

    public final boolean shouldAnimateActionModeView() {
        if (this.mSubDecorInstalled == false) goto L9;
        ViewGroup r0 = this.mSubDecor;
        if (r0 == null) goto L9;
        if (ViewCompat.isLaidOut(r0) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar == true) goto L5;
        return;
    L5:
        if (this.mActionBar != null) goto L19;
        Object r0 = this.mHost;
        if ((r0 instanceof Activity) == false) goto L11;
        this.mActionBar = new WindowDecorActionBar((Activity) this.mHost, this.mOverlayActionBar);
    L13:
        ActionBar r1 = this.mActionBar;
        if (r1 == null) goto L18;
        r1.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        return;
    L18:
        return;
    L11:
        if ((r0 instanceof Dialog) == false) goto L13;
        this.mActionBar = new WindowDecorActionBar((Dialog) this.mHost);
        goto L13
    }

    public final Context getActionBarThemedContext() {
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L5;
        Context r1 = r0.getThemedContext();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return this.mContext;
    L5:
        r1 = null;
        goto L6
    }

    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    public void invalidateOptionsMenu() {
        ActionBar r0 = getSupportActionBar();
        if (r0 != null) goto L5;
    L7:
        invalidatePanelMenu(0);
        return;
    L5:
        if (r0.invalidateOptionsMenu() == false) goto L7;
    }

    public void onPostResume() {
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L6;
        r0.setShowHideAnimationEnabled(true);
        return;
    }

    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    public ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    public final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static View INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static void androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_ContentFrameLayoutNPE_ensureSubDecorInsert(AppCompatDelegateImpl r3) {
        FLogger.a.i("ContentFrameLayoutNPE", "ensureSubDecorInsert");
        monitor-enter(r3);
        r3.androidx_appcompat_app_AppCompatDelegateImpl__ensureSubDecor$___twin___();     // Catch: Throwable -> L7
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r3);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean applyDayNight(boolean r3) {
        if (this.mIsDestroyed == false) goto L6;
        return false;
    L6:
        int r0 = calculateNightMode();
        boolean r4 = updateForNightMode(mapNightMode(this.mContext, r0), r3);
        if (r0 != 0) goto L9;
        getAutoTimeNightModeManager(this.mContext).setup();
    L13:
        if (r0 != 3) goto L15;
        getAutoBatteryNightModeManager(this.mContext).setup();
    L18:
        return r4;
    L15:
        AutoNightModeManager r1 = this.mAutoBatteryNightModeManager;
        if (r1 == null) goto L18;
        r1.cleanup();
        goto L18
    L9:
        AutoNightModeManager r2 = this.mAutoTimeNightModeManager;
        if (r2 == null) goto L13;
        r2.cleanup();
        goto L13
    }

    private void attachToWindow(Window r4) {
        if (this.mWindow != null) goto L14;
        Window.Callback r0 = r4.getCallback();
        if ((r0 instanceof AppCompatWindowCallback) == true) goto L12;
        AppCompatWindowCallback r1 = new AppCompatWindowCallback(this, r0);
        this.mAppCompatWindowCallback = r1;
        r4.setCallback(r1);
        TintTypedArray r2 = TintTypedArray.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
        Drawable r3 = r2.getDrawableIfKnown(0);
        if (r3 == null) goto L9;
        r4.setBackgroundDrawable(r3);
    L9:
        r2.recycle();
        this.mWindow = r4;
        return;
    L12:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    L14:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private AutoNightModeManager getAutoBatteryNightModeManager(Context r2) {
        if (this.mAutoBatteryNightModeManager != null) goto L6;
        this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(this, r2);
    L6:
        return this.mAutoBatteryNightModeManager;
    }

    private AutoNightModeManager getAutoTimeNightModeManager(Context r2) {
        if (this.mAutoTimeNightModeManager != null) goto L6;
        this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(this, TwilightManager.getInstance(r2));
    L6:
        return this.mAutoTimeNightModeManager;
    }

    private boolean initializePanelContent(PanelFeatureState r4) {
        View r0 = r4.createdPanelView;
        if (r0 == null) goto L7;
        r4.shownPanelView = r0;
        return true;
    L7:
        if (r4.menu != null) goto L10;
        return false;
    L10:
        if (this.mPanelMenuPresenterCallback != null) goto L12;
        this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(this);
    L12:
        View r1 = r4.getListMenuView(this.mPanelMenuPresenterCallback);
        r4.shownPanelView = r1;
        if (r1 != null) goto L17;
        return false;
    L17:
        return true;
    }

    private boolean initializePanelDecor(PanelFeatureState r3) {
        r3.setStyle(getActionBarThemedContext());
        r3.decorView = new ListMenuDecorView(this, r3.listPresenterContext);
        r3.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState r8) {
        Context r0 = this.mContext;
        int r1 = r8.featureId;
        if (r1 == 0) goto L7;
        if (r1 == 108) goto L7;
    L19:
        MenuBuilder r2 = new MenuBuilder(r0);
        r2.setCallback(this);
        r8.setMenu(r2);
        return true;
    L7:
        if (this.mDecorContentParent == null) goto L19;
        TypedValue r3 = new TypedValue();
        Resources.Theme r4 = r0.getTheme();
        r4.resolveAttribute(2130968719, r3, true);
        if (r3.resourceId == 0) goto L11;
        Resources.Theme r5 = r0.getResources().newTheme();
        r5.setTo(r4);
        r5.applyStyle(r3.resourceId, true);
        r5.resolveAttribute(2130968720, r3, true);
    L13:
        if (r3.resourceId == 0) goto L17;
        if (r5 != null) goto L16;
        r5 = r0.getResources().newTheme();
        r5.setTo(r4);
    L16:
        r5.applyStyle(r3.resourceId, true);
    L17:
        if (r5 == null) goto L19;
        Context r6 = new ContextThemeWrapper(r0, 0);
        r6.getTheme().setTo(r5);
        r0 = r6;
        goto L19
    L11:
        r4.resolveAttribute(2130968720, r3, true);
        r5 = null;
        goto L13
    }

    private void invalidatePanelMenu(int r3) {
        int r4 = 1 << r3;
        this.mInvalidatePanelMenuFeatures = r4 | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted == true) goto L6;
        ViewCompat.postOnAnimation(INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow), this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
        return;
    }

    private void reopenMenu(boolean r6) {
        DecorContentParent r0 = this.mDecorContentParent;
        if (r0 != null) goto L5;
    L33:
        PanelFeatureState r7 = getPanelState(0, true);
        r7.refreshDecorView = true;
        closePanel(r7, false);
        openPanel(r7, null);
        return;
    L5:
        if (r0.canShowOverflowMenu() == false) goto L33;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L9;
    L10:
        Window.Callback r1 = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L17;
        if (r6 == false) goto L17;
        this.mDecorContentParent.hideOverflowMenu();
        if (this.mIsDestroyed == true) goto L35;
        r1.onPanelClosed(108, getPanelState(0, true).menu);
        return;
    L35:
        return;
    L17:
        if (r1 != null) goto L19;
        return;
    L19:
        if (this.mIsDestroyed == false) goto L21;
        return;
    L21:
        if (this.mInvalidatePanelMenuPosted == true) goto L23;
    L25:
        PanelFeatureState r8 = getPanelState(0, true);
        MenuBuilder r2 = r8.menu;
        if (r2 != null) goto L28;
        return;
    L28:
        if (r8.refreshMenuContent == false) goto L30;
        return;
    L30:
        if (r1.onPreparePanel(0, r8.createdPanelView, r2) == false) goto L41;
        r1.onMenuOpened(108, r8.menu);
        this.mDecorContentParent.showOverflowMenu();
        return;
    L41:
        return;
    L23:
        if ((this.mInvalidatePanelMenuFeatures & 1) == 0) goto L25;
        INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow).removeCallbacks(this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuRunnable.run();
        goto L25
    L9:
        if (this.mDecorContentParent.isOverflowMenuShowPending() == false) goto L33;
        goto L10
    }

    private boolean shouldInheritContext(ViewParent r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        View r1 = INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow);
    L6:
        if (r4 == null) goto L7;
        if (r4 == r1) goto L16;
        if ((r4 instanceof View) == false) goto L16;
        if (ViewCompat.isAttachedToWindow((View) r4) == true) goto L16;
        r4 = r4.getParent();
    L16:
        return false;
    L7:
        return true;
    }

    private void updateStatusGuardColor(View r3) {
        if ((ViewCompat.getWindowSystemUiVisibility(r3) & 8192) == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        int r1 = ContextCompat.getColor(this.mContext, 2131100082);
    L9:
        r3.setBackgroundColor(r1);
        return;
    L8:
        r1 = ContextCompat.getColor(this.mContext, 2131100081);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public Context attachBaseContext2(Context r7) {
        boolean r0 = true;
        this.mBaseContextAttached = true;
        int r1 = mapNightMode(r7, calculateNightMode());
        Configuration r3 = null;
        if (sCanApplyOverrideConfiguration == false) goto L11;
        if ((r7 instanceof android.view.ContextThemeWrapper) == false) goto L11;
        ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((android.view.ContextThemeWrapper) r7, createOverrideConfigurationForDayNight(r7, r1, null));     // Catch: IllegalStateException -> L9
        return r7;
    L11:
        if ((r7 instanceof ContextThemeWrapper) == false) goto L17;
        ((ContextThemeWrapper) r7).applyOverrideConfiguration(createOverrideConfigurationForDayNight(r7, r1, null));     // Catch: IllegalStateException -> L15
        return r7;
    L17:
        if (sCanReturnDifferentContext == false) goto L19;
        Configuration r2 = new Configuration();
        r2.uiMode = -1;
        r2.fontScale = 0.0f;
        Configuration r4 = Api17Impl.createConfigurationContext(r7, r2).getResources().getConfiguration();
        Configuration r5 = r7.getResources().getConfiguration();
        r4.uiMode = r5.uiMode;
        if (r4.equals(r5) == true) goto L23;
        r3 = generateConfigDelta(r4, r5);
    L23:
        Configuration r6 = createOverrideConfigurationForDayNight(r7, r1, r3);
        ContextThemeWrapper r8 = new ContextThemeWrapper(r7, 2131953635);
        r8.applyOverrideConfiguration(r6);
        boolean r9 = false;
        if (r7.getTheme() != null) goto L28;
        r0 = false;
    L28:
        r9 = r0;
    L30:
        if (r9 == false) goto L33;
        ResourcesCompat.ThemeCompat.rebase(r8.getTheme());
    L33:
        return super.attachBaseContext2(r8);
    L19:
        return super.attachBaseContext2(r7);
    }

    public void checkCloseActionMenu(MenuBuilder r3) {
        if (this.mClosingActionMenu == false) goto L5;
        return;
    L5:
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window.Callback r0 = getWindowCallback();
        if (r0 != null) goto L8;
    L10:
        this.mClosingActionMenu = false;
        return;
    L8:
        if (this.mIsDestroyed == true) goto L10;
        r0.onPanelClosed(108, r3);
        goto L10
    }

    public void closePanel(int r2) {
        closePanel(getPanelState(r2, true), true);
    }

    public boolean dispatchKeyEvent(KeyEvent r4) {
        Object r0 = this.mHost;
        boolean r2 = true;
        if ((r0 instanceof KeyEventDispatcher.Component) == false) goto L5;
    L6:
        View r1 = INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow);
        if (r1 != null) goto L9;
    L12:
        if (r4.getKeyCode() == 82) goto L14;
    L16:
        int r3 = r4.getKeyCode();
        if (r4.getAction() == 0) goto L20;
        r2 = false;
    L20:
        if (r2 == false) goto L23;
        return onKeyDown(r3, r4);
    L23:
        return onKeyUp(r3, r4);
    L14:
        if (this.mAppCompatWindowCallback.getWrapped().dispatchKeyEvent(r4) == false) goto L16;
        return true;
    L9:
        if (KeyEventDispatcher.dispatchBeforeHierarchy(r1, r4) == false) goto L12;
        return true;
    L5:
        if ((r0 instanceof AppCompatDialog) == false) goto L12;
        goto L6
    }

    public void doInvalidatePanelMenu(int r5) {
        PanelFeatureState r1 = getPanelState(r5, true);
        if (r1.menu == null) goto L8;
        Bundle r2 = new Bundle();
        r1.menu.saveActionViewStates(r2);
        if (r2.size() <= 0) goto L7;
        r1.frozenActionViewState = r2;
    L7:
        r1.menu.stopDispatchingItemsChanged();
        r1.menu.clear();
    L8:
        r1.refreshMenuContent = true;
        r1.refreshDecorView = true;
        if (r5 == 108) goto L12;
        if (r5 == 0) goto L12;
        return;
    L12:
        if (this.mDecorContentParent == null) goto L18;
        PanelFeatureState r0 = getPanelState(0, false);
        if (r0 == null) goto L19;
        r0.isPrepared = false;
        preparePanel(r0, null);
        return;
    L19:
        return;
    }

    public PanelFeatureState findMenuPanel(Menu r6) {
        PanelFeatureState[] r0 = this.mPanels;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.length;
    L6:
        if (r1 >= r2) goto L13;
        PanelFeatureState r3 = r0[r1];
        if (r3 == null) goto L12;
        if (r3.menu != r6) goto L12;
        return r3;
    L12:
        r1 = r1 + 1;
        goto L6
    L13:
        return null;
    L5:
        r2 = 0;
        goto L6
    }

    public <T extends View> T findViewById(int r2) {
        ensureSubDecor();
        return (T) this.mWindow.findViewById(r2);
    }

    public boolean hasWindowFeature(int r5) {
        int r0 = sanitizeWindowFeatureId(r5);
        if (r0 != 1) goto L5;
        boolean r1 = this.mWindowNoTitle;
    L21:
        if (r1 == false) goto L23;
        return true;
    L23:
        if (this.mWindow.hasFeature(r5) == true) goto L28;
        return false;
    L28:
        return true;
    L5:
        if (r0 != 2) goto L7;
        r1 = this.mFeatureProgress;
        goto L21
    L7:
        if (r0 != 5) goto L9;
        r1 = this.mFeatureIndeterminateProgress;
        goto L21
    L9:
        if (r0 != 10) goto L11;
        r1 = this.mOverlayActionMode;
        goto L21
    L11:
        if (r0 != 108) goto L13;
        r1 = this.mHasActionBar;
        goto L21
    L13:
        if (r0 == 109) goto L15;
        r1 = false;
        goto L21
    L15:
        r1 = this.mOverlayActionBar;
        goto L21
    }

    public void onConfigurationChanged(Configuration r2) {
        if (this.mHasActionBar == true) goto L5;
    L9:
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        applyDayNight(false);
        return;
    L5:
        if (this.mSubDecorInstalled == false) goto L9;
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L9;
        r0.onConfigurationChanged(r2);
        goto L9
    }

    public void onCreate(Bundle r3) {
        this.mBaseContextAttached = true;
        applyDayNight(false);
        ensureWindow();
        Object r0 = this.mHost;
        if ((r0 instanceof Activity) == true) goto L15;
    L13:
        this.mCreated = true;
        return;
    L15:
        String r1 = NavUtils.getParentActivityName((Activity) r0);     // Catch: IllegalArgumentException -> L6
    L7:
        if (r1 == null) goto L12;
        ActionBar r2 = peekSupportActionBar();
        if (r2 != null) goto L11;
        this.mEnableDefaultActionBarUp = true;
        goto L12
    L11:
        r2.setDefaultDisplayHomeAsUpEnabled(true);
    L12:
        AppCompatDelegate.addActiveDelegate(this);
    L6:
        r1 = null;
        goto L7
    }

    public void onMenuModeChange(MenuBuilder r1) {
        reopenMenu(true);
    }

    public void onMenuOpened(int r2) {
        if (r2 != 108) goto L8;
        ActionBar r3 = getSupportActionBar();
        if (r3 == null) goto L9;
        r3.dispatchMenuVisibilityChanged(true);
        return;
    L9:
        return;
    }

    public void onPanelClosed(int r3) {
        if (r3 != 108) goto L7;
        ActionBar r4 = getSupportActionBar();
        if (r4 == null) goto L12;
        r4.dispatchMenuVisibilityChanged(false);
        return;
    L12:
        return;
    L7:
        if (r3 != 0) goto L14;
        PanelFeatureState r5 = getPanelState(r3, true);
        if (r5.isOpen == false) goto L15;
        closePanel(r5, false);
        return;
    L15:
        return;
    }

    public void onPostCreate(Bundle r1) {
        ensureSubDecor();
    }

    public boolean requestWindowFeature(int r5) {
        int r6 = sanitizeWindowFeatureId(r5);
        if (this.mWindowNoTitle == false) goto L7;
        if (r6 != 108) goto L7;
        return false;
    L7:
        if (this.mHasActionBar == false) goto L10;
        if (r6 != 1) goto L10;
        this.mHasActionBar = false;
    L10:
        if (r6 != 1) goto L12;
        throwFeatureRequestIfSubDecorInstalled();
        this.mWindowNoTitle = true;
        return true;
    L12:
        if (r6 != 2) goto L14;
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureProgress = true;
        return true;
    L14:
        if (r6 != 5) goto L16;
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureIndeterminateProgress = true;
        return true;
    L16:
        if (r6 == 10) goto L26;
        if (r6 != 108) goto L19;
        throwFeatureRequestIfSubDecorInstalled();
        this.mHasActionBar = true;
        return true;
    L19:
        if (r6 != 109) goto L21;
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    L21:
        return this.mWindow.requestFeature(r6);
    L26:
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionMode = true;
        return true;
    }

    public void setContentView(int r3) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        r0.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(r3, r0);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public void setHandleNativeActionModesEnabled(boolean r1) {
        this.mHandleNativeActionModes = r1;
    }

    public void setLocalNightMode(int r2) {
        if (this.mLocalNightMode == r2) goto L8;
        this.mLocalNightMode = r2;
        if (this.mBaseContextAttached == false) goto L9;
        applyDayNight();
        return;
    L9:
        return;
    }

    public void setSupportActionBar(Toolbar r4) {
        if ((this.mHost instanceof Activity) == true) goto L5;
        return;
    L5:
        ActionBar r0 = getSupportActionBar();
        if ((r0 instanceof WindowDecorActionBar) == true) goto L16;
        this.mMenuInflater = null;
        if (r0 == null) goto L10;
        r0.onDestroy();
    L10:
        if (r4 == null) goto L12;
        ToolbarActionBar r1 = new ToolbarActionBar(r4, getTitle(), this.mAppCompatWindowCallback);
        this.mActionBar = r1;
        this.mWindow.setCallback(r1.getWrappedWindowCallback());
    L13:
        invalidateOptionsMenu();
        return;
    L12:
        this.mActionBar = null;
        this.mWindow.setCallback(this.mAppCompatWindowCallback);
        goto L13
    L16:
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    public void setTheme(int r1) {
        this.mThemeResId = r1;
    }

    public final void setTitle(CharSequence r2) {
        this.mTitle = r2;
        DecorContentParent r0 = this.mDecorContentParent;
        if (r0 == null) goto L6;
        r0.setWindowTitle(r2);
        return;
    L6:
        if (peekSupportActionBar() == null) goto L8;
        peekSupportActionBar().setWindowTitle(r2);
        return;
    L8:
        TextView r1 = this.mTitleView;
        if (r1 == null) goto L14;
        r1.setText(r2);
        return;
    }

    public ActionMode startSupportActionMode(ActionMode.Callback r3) {
        if (r3 == null) goto L19;
        ActionMode r0 = this.mActionMode;
        if (r0 == null) goto L6;
        r0.finish();
    L6:
        ActionModeCallbackWrapperV9 r1 = new ActionModeCallbackWrapperV9(this, r3);
        ActionBar r4 = getSupportActionBar();
        if (r4 == null) goto L14;
        ActionMode r5 = r4.startActionMode(r1);
        this.mActionMode = r5;
        if (r5 == null) goto L14;
        AppCompatCallback r2 = this.mAppCompatCallback;
        if (r2 == null) goto L14;
        r2.onSupportActionModeStarted(r5);
    L14:
        if (this.mActionMode != null) goto L17;
        this.mActionMode = startSupportActionModeFromWindow(r1);
    L17:
        return this.mActionMode;
    L19:
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public ActionMode startSupportActionModeFromWindow(ActionMode.Callback r8) {
        endOnGoingFadeAnimation();
        ActionMode r0 = this.mActionMode;
        if (r0 == null) goto L6;
        r0.finish();
    L6:
        if ((r8 instanceof ActionModeCallbackWrapperV9) == true) goto L8;
        r8 = new ActionModeCallbackWrapperV9(this, r8);
    L8:
        AppCompatCallback r1 = this.mAppCompatCallback;
        if (r1 != null) goto L11;
    L15:
        ActionMode r2 = null;
    L16:
        if (r2 == null) goto L18;
        this.mActionMode = r2;
    L48:
        ActionMode r9 = this.mActionMode;
        if (r9 == null) goto L54;
        AppCompatCallback r3 = this.mAppCompatCallback;
        if (r3 == null) goto L54;
        r3.onSupportActionModeStarted(r9);
    L54:
        return this.mActionMode;
    L18:
        boolean r4 = true;
        if (this.mActionModeView != null) goto L31;
        if (this.mIsFloating == false) goto L27;
        TypedValue r5 = new TypedValue();
        Resources.Theme r6 = this.mContext.getTheme();
        r6.resolveAttribute(2130968719, r5, true);
        if (r5.resourceId == 0) goto L25;
        Resources.Theme r7 = this.mContext.getResources().newTheme();
        r7.setTo(r6);
        r7.applyStyle(r5.resourceId, true);
        ContextThemeWrapper r10 = new ContextThemeWrapper(this.mContext, 0);
        r10.getTheme().setTo(r7);
    L26:
        this.mActionModeView = new ActionBarContextView(r10);
        PopupWindow r11 = new PopupWindow(r10, null, 2130968734);
        this.mActionModePopup = r11;
        PopupWindowCompat.setWindowLayoutType(r11, 2);
        this.mActionModePopup.setContentView(this.mActionModeView);
        this.mActionModePopup.setWidth(-1);
        r10.getTheme().resolveAttribute(2130968713, r5, true);
        this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(r5.data, INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r10.getResources())));
        this.mActionModePopup.setHeight(-2);
        this.mShowActionModePopup = new 6(this);
        goto L31
    L25:
        r10 = this.mContext;
        goto L26
    L27:
        ViewStubCompat r12 = this.mSubDecor.findViewById(2131362116);
        if (r12 == null) goto L31;
        r12.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
        this.mActionModeView = r12.inflate();
    L31:
        if (this.mActionModeView == null) goto L48;
        endOnGoingFadeAnimation();
        this.mActionModeView.killMode();
        Context r13 = this.mActionModeView.getContext();
        ActionBarContextView r14 = this.mActionModeView;
        if (this.mActionModePopup == null) goto L36;
        r4 = false;
    L36:
        StandaloneActionMode r15 = new StandaloneActionMode(r13, r14, r8, r4);
        if (r8.onCreateActionMode(r15, r15.getMenu()) == false) goto L47;
        r15.invalidate();
        this.mActionModeView.initForMode(r15);
        this.mActionMode = r15;
        if (shouldAnimateActionModeView() == false) goto L41;
        this.mActionModeView.setAlpha(0.0f);
        ViewPropertyAnimatorCompat r16 = ViewCompat.animate(this.mActionModeView).alpha(1.0f);
        this.mFadeAnim = r16;
        r16.setListener(new 7(this));
    L45:
        if (this.mActionModePopup == null) goto L48;
        INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow).post(this.mShowActionModePopup);
        goto L48
    L41:
        this.mActionModeView.setAlpha(1.0f);
        this.mActionModeView.setVisibility(0);
        this.mActionModeView.sendAccessibilityEvent(32);
        if ((this.mActionModeView.getParent() instanceof View) == false) goto L45;
        ViewCompat.requestApplyInsets((View) this.mActionModeView.getParent());
        goto L45
    L47:
        this.mActionMode = null;
        goto L48
    L11:
        if (this.mIsDestroyed == true) goto L15;
        r2 = r1.onWindowStartingSupportActionMode(r8);     // Catch: AbstractMethodError -> L14
        goto L16
    }

    public void setContentView(View r3) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        r0.removeAllViews();
        r0.addView(r3);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public AppCompatDelegateImpl(Dialog r3, AppCompatCallback r4) {
        this(r3.getContext(), r3.getWindow(), r4, r3);
    }

    private static Configuration generateConfigDelta(Configuration r5, Configuration r6) {
        Configuration r0 = new Configuration();
        r0.fontScale = 0.0f;
        if (r6 != null) goto L5;
    L71:
        return r0;
    L5:
        if (r5.diff(r6) == 0) goto L71;
        float r1 = r5.fontScale;
        float r2 = r6.fontScale;
        if (r1 == r2) goto L10;
        r0.fontScale = r2;
    L10:
        int r3 = r5.mcc;
        int r4 = r6.mcc;
        if (r3 == r4) goto L13;
        r0.mcc = r4;
    L13:
        int r7 = r5.mnc;
        int r8 = r6.mnc;
        if (r7 == r8) goto L16;
        r0.mnc = r8;
    L16:
        int r9 = Build.VERSION.SDK_INT;
        if (r9 < 24) goto L20;
        Api24Impl.generateConfigDelta_locale(r5, r6, r0);
    L22:
        int r10 = r5.touchscreen;
        int r11 = r6.touchscreen;
        if (r10 == r11) goto L25;
        r0.touchscreen = r11;
    L25:
        int r12 = r5.keyboard;
        int r13 = r6.keyboard;
        if (r12 == r13) goto L28;
        r0.keyboard = r13;
    L28:
        int r14 = r5.keyboardHidden;
        int r15 = r6.keyboardHidden;
        if (r14 == r15) goto L31;
        r0.keyboardHidden = r15;
    L31:
        int r16 = r5.navigation;
        int r17 = r6.navigation;
        if (r16 == r17) goto L34;
        r0.navigation = r17;
    L34:
        int r18 = r5.navigationHidden;
        int r19 = r6.navigationHidden;
        if (r18 == r19) goto L37;
        r0.navigationHidden = r19;
    L37:
        int r20 = r5.orientation;
        int r21 = r6.orientation;
        if (r20 == r21) goto L40;
        r0.orientation = r21;
    L40:
        int r22 = r5.screenLayout & 15;
        int r23 = r6.screenLayout;
        if (r22 == (r23 & 15)) goto L43;
        r0.screenLayout |= r23 & 15;
    L43:
        int r24 = r5.screenLayout & 192;
        int r25 = r6.screenLayout;
        if (r24 == (r25 & 192)) goto L46;
        r0.screenLayout |= r25 & 192;
    L46:
        int r26 = r5.screenLayout & 48;
        int r27 = r6.screenLayout;
        if (r26 == (r27 & 48)) goto L49;
        r0.screenLayout |= r27 & 48;
    L49:
        int r28 = r5.screenLayout & ISmModel.VERSION_0300;
        int r29 = r6.screenLayout;
        if (r28 == (r29 & ISmModel.VERSION_0300)) goto L53;
        r0.screenLayout |= r29 & ISmModel.VERSION_0300;
    L53:
        if (r9 < 26) goto L55;
        Api26Impl.generateConfigDelta_colorMode(r5, r6, r0);
    L55:
        int r30 = r5.uiMode & 15;
        int r31 = r6.uiMode;
        if (r30 == (r31 & 15)) goto L58;
        r0.uiMode |= r31 & 15;
    L58:
        int r32 = r5.uiMode & 48;
        int r33 = r6.uiMode;
        if (r32 == (r33 & 48)) goto L61;
        r0.uiMode |= r33 & 48;
    L61:
        int r34 = r5.screenWidthDp;
        int r35 = r6.screenWidthDp;
        if (r34 == r35) goto L64;
        r0.screenWidthDp = r35;
    L64:
        int r36 = r5.screenHeightDp;
        int r37 = r6.screenHeightDp;
        if (r36 == r37) goto L67;
        r0.screenHeightDp = r37;
    L67:
        int r38 = r5.smallestScreenWidthDp;
        int r39 = r6.smallestScreenWidthDp;
        if (r38 == r39) goto L70;
        r0.smallestScreenWidthDp = r39;
    L70:
        Api17Impl.generateConfigDelta_densityDpi(r5, r6, r0);
        goto L71
    L20:
        if (ObjectsCompat.equals(r5.locale, r6.locale) == true) goto L22;
        r0.locale = r6.locale;
        goto L22
    }

    private boolean onKeyDownPanel(int r2, KeyEvent r3) {
        if (r3.getRepeatCount() != 0) goto L8;
        PanelFeatureState r4 = getPanelState(r2, true);
        if (r4.isOpen == false) goto L7;
        return false;
    L7:
        return preparePanel(r4, r3);
    L8:
        return false;
    }

    private boolean onKeyUpPanel(int r5, KeyEvent r6) {
        if (this.mActionMode == null) goto L5;
        return false;
    L5:
        boolean r0 = true;
        PanelFeatureState r2 = getPanelState(r5, true);
        if (r5 != 0) goto L21;
        DecorContentParent r7 = this.mDecorContentParent;
        if (r7 == null) goto L21;
        if (r7.canShowOverflowMenu() == false) goto L21;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L21;
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L16;
        r0 = this.mDecorContentParent.hideOverflowMenu();
    L36:
        if (r0 == false) goto L40;
        AudioManager r8 = (AudioManager) this.mContext.getApplicationContext().getSystemService("audio");
        if (r8 == null) goto L40;
        r8.playSoundEffect(0);
    L40:
        return r0;
    L16:
        if (this.mIsDestroyed == false) goto L18;
    L34:
        r0 = false;
        goto L36
    L18:
        if (preparePanel(r2, r6) == false) goto L34;
        r0 = this.mDecorContentParent.showOverflowMenu();
    L21:
        boolean r9 = r2.isOpen;
        if (r9 == false) goto L24;
    L35:
        closePanel(r2, true);
        r0 = r9;
        goto L36
    L24:
        if (r2.isHandled == true) goto L35;
        if (r2.isPrepared == false) goto L34;
        if (r2.refreshMenuContent == false) goto L31;
        r2.isPrepared = false;
        boolean r10 = preparePanel(r2, r6);
    L32:
        if (r10 == false) goto L34;
        openPanel(r2, r6);
        goto L36
    L31:
        r10 = true;
        goto L32
    }

    private void openPanel(PanelFeatureState r13, KeyEvent r14) {
        if (r13.isOpen == false) goto L5;
        return;
    L5:
        if (this.mIsDestroyed == false) goto L8;
        return;
    L8:
        if (r13.featureId == 0) goto L10;
    L15:
        Window.Callback r0 = getWindowCallback();
        if (r0 != null) goto L18;
    L21:
        WindowManager r1 = (WindowManager) this.mContext.getSystemService("window");
        if (r1 != null) goto L25;
        return;
    L25:
        if (preparePanel(r13, r14) == true) goto L27;
        return;
    L27:
        ViewGroup r15 = r13.decorView;
        if (r15 != null) goto L30;
    L39:
        if (r15 != null) goto L46;
        if (initializePanelDecor(r13) == true) goto L43;
        return;
    L43:
        if (r13.decorView != null) goto L51;
        return;
    L51:
        if (initializePanelContent(r13) == true) goto L53;
    L67:
        r13.refreshDecorView = true;
        return;
    L53:
        if (r13.hasPanelItems() == false) goto L67;
        ViewGroup.LayoutParams r16 = r13.shownPanelView.getLayoutParams();
        if (r16 != null) goto L58;
        r16 = new ViewGroup.LayoutParams(-2, -2);
    L58:
        int r4 = r13.background;
        r13.decorView.setBackgroundResource(r4);
        ViewParent r5 = r13.shownPanelView.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L61;
        ((ViewGroup) r5).removeView(r13.shownPanelView);
    L61:
        r13.decorView.addView(r13.shownPanelView, r16);
        if (r13.shownPanelView.hasFocus() == true) goto L64;
        r13.shownPanelView.requestFocus();
    L64:
        int r6 = -2;
    L65:
        r13.isHandled = false;
        WindowManager.LayoutParams r17 = new WindowManager.LayoutParams(r6, -2, r13.x, r13.y, 1002, 8519680, -3);
        r17.gravity = r13.gravity;
        r17.windowAnimations = r13.windowAnimations;
        INVOKEINTERFACE_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(r1, r13.decorView, r17);
        r13.isOpen = true;
        return;
    L46:
        if (r13.refreshDecorView == false) goto L51;
        if (r15.getChildCount() <= 0) goto L51;
        r13.decorView.removeAllViews();
        goto L51
    L30:
        if (r13.refreshDecorView == true) goto L39;
        View r18 = r13.createdPanelView;
        if (r18 == null) goto L64;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L64;
        if (r19.width != (-1)) goto L64;
        r6 = -1;
        goto L65
    L18:
        if (r0.onMenuOpened(r13.featureId, r13.menu) == true) goto L21;
        closePanel(r13, true);
        return;
    L10:
        if ((this.mContext.getResources().getConfiguration().screenLayout & 15) != 4) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        return;
    L12:
        r2 = false;
        goto L13
    }

    private boolean preparePanel(PanelFeatureState r9, KeyEvent r10) {
        if (this.mIsDestroyed == false) goto L6;
        return false;
    L6:
        if (r9.isPrepared == false) goto L8;
        return true;
    L8:
        PanelFeatureState r0 = this.mPreparedPanel;
        if (r0 == null) goto L12;
        if (r0 == r9) goto L12;
        closePanel(r0, false);
    L12:
        Window.Callback r1 = getWindowCallback();
        if (r1 == null) goto L15;
        r9.createdPanelView = r1.onCreatePanelView(r9.featureId);
    L15:
        int r3 = r9.featureId;
        if (r3 != 0) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L27;
        DecorContentParent r5 = this.mDecorContentParent;
        if (r5 == null) goto L27;
        r5.setMenuPrepared();
    L27:
        if (r9.createdPanelView != null) goto L76;
        if (r4 == true) goto L30;
    L31:
        MenuBuilder r6 = r9.menu;
        if (r6 != null) goto L34;
    L35:
        if (r6 == null) goto L37;
    L41:
        if (r4 == true) goto L43;
    L48:
        r9.menu.stopDispatchingItemsChanged();
        if (r1.onCreatePanelMenu(r9.featureId, r9.menu) == true) goto L56;
        r9.setMenu(null);
        if (r4 == false) goto L55;
        DecorContentParent r11 = this.mDecorContentParent;
        if (r11 == null) goto L55;
        r11.setMenu(null, this.mActionMenuPresenterCallback);
    L55:
        return false;
    L56:
        r9.refreshMenuContent = false;
    L57:
        r9.menu.stopDispatchingItemsChanged();
        Bundle r7 = r9.frozenActionViewState;
        if (r7 == null) goto L61;
        r9.menu.restoreActionViewStates(r7);
        r9.frozenActionViewState = null;
    L61:
        if (r1.onPreparePanel(0, r9.createdPanelView, r9.menu) == true) goto L68;
        if (r4 == false) goto L66;
        DecorContentParent r12 = this.mDecorContentParent;
        if (r12 == null) goto L66;
        r12.setMenu(null, this.mActionMenuPresenterCallback);
    L66:
        r9.menu.startDispatchingItemsChanged();
        return false;
    L68:
        if (r10 == null) goto L70;
        int r13 = r10.getDeviceId();
    L72:
        if (KeyCharacterMap.load(r13).getKeyboardType() == 1) goto L74;
        boolean r14 = true;
    L75:
        r9.qwertyMode = r14;
        r9.menu.setQwertyMode(r14);
        r9.menu.startDispatchingItemsChanged();
        goto L76
    L74:
        r14 = false;
        goto L75
    L70:
        r13 = -1;
        goto L72
    L43:
        if (this.mDecorContentParent == null) goto L48;
        if (this.mActionMenuPresenterCallback != null) goto L47;
        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback(this);
    L47:
        this.mDecorContentParent.setMenu(r9.menu, this.mActionMenuPresenterCallback);
        goto L48
    L37:
        if (initializePanelMenu(r9) == true) goto L39;
    L40:
        return false;
    L39:
        if (r9.menu != null) goto L41;
    L34:
        if (r9.refreshMenuContent == false) goto L57;
    L30:
        if ((peekSupportActionBar() instanceof ToolbarActionBar) == false) goto L31;
    L76:
        r9.isPrepared = true;
        r9.isHandled = false;
        this.mPreparedPanel = r9;
        return true;
    L18:
        if (r3 == 108) goto L21;
        r4 = false;
        goto L22
    }

    private boolean updateForNightMode(int r7, boolean r8) {
        Configuration r0 = createOverrideConfigurationForDayNight(this.mContext, r7, null);
        boolean r2 = isActivityManifestHandlingUiMode();
        int r3 = this.mContext.getResources().getConfiguration().uiMode & 48;
        int r1 = r0.uiMode & 48;
        boolean r4 = true;
        if (r3 == r1) goto L17;
        if (r8 == false) goto L17;
        if (r2 == true) goto L17;
        if (this.mBaseContextAttached == false) goto L17;
        if (sCanReturnDifferentContext == false) goto L11;
    L12:
        Object r9 = this.mHost;
        if ((r9 instanceof Activity) == false) goto L17;
        if (((Activity) r9).isChild() == true) goto L17;
        ActivityCompat.recreate((Activity) this.mHost);
        boolean r10 = true;
    L18:
        if (r10 == true) goto L21;
        if (r3 == r1) goto L21;
        updateResourcesConfigurationForNightMode(r1, r2, null);
    L22:
        if (r4 == false) goto L26;
        Object r11 = this.mHost;
        if ((r11 instanceof AppCompatActivity) == false) goto L26;
        ((AppCompatActivity) r11).onNightModeChanged(r7);
    L26:
        return r4;
    L21:
        r4 = r10;
        goto L22
    L11:
        if (this.mCreated == true) goto L12;
    L17:
        r10 = false;
        goto L18
    }

    public void addContentView(View r3, ViewGroup.LayoutParams r4) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(R.id.content)).addView(r3, r4);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public void closePanel(PanelFeatureState r4, boolean r5) {
        if (r5 == true) goto L4;
    L11:
        WindowManager r0 = (WindowManager) this.mContext.getSystemService("window");
        if (r0 != null) goto L14;
    L20:
        r4.isPrepared = false;
        r4.isHandled = false;
        r4.isOpen = false;
        r4.shownPanelView = null;
        r4.refreshDecorView = true;
        if (this.mPreparedPanel != r4) goto L24;
        this.mPreparedPanel = null;
        return;
    L24:
        return;
    L14:
        if (r4.isOpen == false) goto L20;
        ViewGroup r2 = r4.decorView;
        if (r2 == null) goto L20;
        r0.removeView(r2);
        if (r5 == false) goto L20;
        callOnPanelClosed(r4.featureId, r4, null);
        goto L20
    L4:
        if (r4.featureId != 0) goto L11;
        DecorContentParent r1 = this.mDecorContentParent;
        if (r1 == null) goto L11;
        if (r1.isOverflowMenuShowing() == false) goto L11;
        checkCloseActionMenu(r4.menu);
    }

    public PanelFeatureState getPanelState(int r4, boolean r5) {
        PanelFeatureState[] r6 = this.mPanels;
        if (r6 != null) goto L5;
    L6:
        PanelFeatureState[] r0 = new PanelFeatureState[r4 + 1];
        if (r6 == null) goto L9;
        System.arraycopy(r6, 0, r0, 0, r6.length);
    L9:
        this.mPanels = r0;
        r6 = r0;
    L10:
        PanelFeatureState r1 = r6[r4];
        if (r1 != null) goto L14;
        PanelFeatureState r2 = new PanelFeatureState(r4);
        r6[r4] = r2;
        return r2;
    L14:
        return r1;
    L5:
        if (r6.length > r4) goto L10;
        goto L6
    }

    public int mapNightMode(Context r3, int r4) {
        if (r4 == (-100)) goto L24;
        if (r4 == (-1)) goto L23;
        if (r4 == 0) goto L17;
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L23;
        if (r4 != 3) goto L15;
        return getAutoBatteryNightModeManager(r3).getApplyableNightMode();
    L15:
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    L17:
        if (Build.VERSION.SDK_INT < 23) goto L22;
        if (((UiModeManager) r3.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) goto L22;
        return -1;
    L22:
        return getAutoTimeNightModeManager(r3).getApplyableNightMode();
    L23:
        return r4;
    L24:
        return -1;
    }

    public boolean onKeyDown(int r4, KeyEvent r5) {
        boolean r1 = true;
        if (r4 == 4) goto L10;
        if (r4 != 82) goto L14;
        onKeyDownPanel(0, r5);
        return true;
    L14:
        return false;
    L10:
        if ((r5.getFlags() & 128) != 0) goto L13;
        r1 = false;
    L13:
        this.mLongPressBackDown = r1;
        goto L14
    }

    public boolean onKeyShortcut(int r4, KeyEvent r5) {
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L8;
        if (r0.onKeyShortcut(r4, r5) == false) goto L8;
        return true;
    L8:
        if (this.mPreparedPanel == null) goto L16;
        if (performPanelShortcut(this.mPreparedPanel, r5.getKeyCode(), r5, 1) == false) goto L16;
        PanelFeatureState r6 = this.mPreparedPanel;
        if (r6 == null) goto L14;
        r6.isHandled = true;
    L14:
        return true;
    L16:
        if (this.mPreparedPanel != null) goto L20;
        PanelFeatureState r7 = getPanelState(0, true);
        preparePanel(r7, r5);
        boolean r8 = performPanelShortcut(r7, r5.getKeyCode(), r5, 1);
        r7.isPrepared = false;
        if (r8 == false) goto L20;
        return true;
    L20:
        return false;
    }

    public boolean onKeyUp(int r4, KeyEvent r5) {
        if (r4 != 4) goto L5;
        boolean r6 = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState r7 = getPanelState(0, false);
        if (r7 == null) goto L17;
        if (r7.isOpen == false) goto L17;
        if (r6 == true) goto L15;
        closePanel(r7, true);
    L15:
        return true;
    L17:
        if (onBackPressed() == false) goto L19;
        return true;
    L19:
        return false;
    L5:
        if (r4 != 82) goto L19;
        onKeyUpPanel(0, r5);
        return true;
    }

    public boolean onMenuItemSelected(MenuBuilder r3, MenuItem r4) {
        Window.Callback r0 = getWindowCallback();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.mIsDestroyed == true) goto L12;
        PanelFeatureState r5 = findMenuPanel(r3.getRootMenu());
        if (r5 != null) goto L9;
        return false;
    L9:
        return r0.onMenuItemSelected(r5.featureId, r4);
    L12:
        return false;
    }

    public void setContentView(View r3, ViewGroup.LayoutParams r4) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        r0.removeAllViews();
        r0.addView(r3, r4);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public final int updateStatusGuard(WindowInsetsCompat r11, Rect r12) {
        int r0 = 0;
        if (r11 == null) goto L5;
        int r1 = r11.getSystemWindowInsetTop();
    L8:
        ActionBarContextView r2 = this.mActionModeView;
        if (r2 != null) goto L11;
    L69:
        boolean r13 = false;
    L70:
        View r14 = this.mStatusGuard;
        if (r14 == null) goto L76;
        if (r13 == true) goto L75;
        r0 = 8;
    L75:
        r14.setVisibility(r0);
    L76:
        return r1;
    L11:
        if ((r2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L69;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
        boolean r5 = true;
        if (this.mActionModeView.isShown() == false) goto L64;
        if (this.mTempRect1 != null) goto L17;
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
    L17:
        Rect r4 = this.mTempRect1;
        Rect r6 = this.mTempRect2;
        if (r11 != null) goto L20;
        r4.set(r12);
    L21:
        ViewUtils.computeFitSystemWindows(this.mSubDecor, r4, r6);
        int r15 = r4.top;
        int r16 = r4.left;
        int r7 = r4.right;
        WindowInsetsCompat r8 = ViewCompat.getRootWindowInsets(this.mSubDecor);
        if (r8 != null) goto L24;
        int r9 = 0;
    L25:
        if (r8 != null) goto L27;
        int r10 = 0;
    L29:
        if (r3.topMargin == r15) goto L31;
    L36:
        r3.topMargin = r15;
        r3.leftMargin = r16;
        r3.rightMargin = r7;
        boolean r17 = true;
    L37:
        if (r15 > 0) goto L39;
    L41:
        View r18 = this.mStatusGuard;
        if (r18 == null) goto L50;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18.getLayoutParams();
        int r20 = r19.height;
        int r21 = r3.topMargin;
        if (r20 == r21) goto L46;
    L49:
        r19.height = r21;
        r19.leftMargin = r9;
        r19.rightMargin = r10;
        this.mStatusGuard.setLayoutParams(r19);
        goto L50
    L46:
        if (r19.leftMargin != r9) goto L49;
        if (r19.rightMargin != r10) goto L49;
    L50:
        View r110 = this.mStatusGuard;
        if (r110 != null) goto L54;
        r5 = false;
    L54:
        if (r5 == false) goto L59;
        if (r110.getVisibility() == 0) goto L59;
        updateStatusGuardColor(this.mStatusGuard);
    L59:
        if (this.mOverlayActionMode == true) goto L62;
        if (r5 == false) goto L62;
        r1 = 0;
    L62:
        r13 = r5;
        r5 = r17;
    L67:
        if (r5 == false) goto L70;
        this.mActionModeView.setLayoutParams(r3);
        goto L70
    L39:
        if (this.mStatusGuard != null) goto L41;
        View r111 = new View(this.mContext);
        this.mStatusGuard = r111;
        r111.setVisibility(8);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-1, r3.topMargin, 51);
        r112.leftMargin = r9;
        r112.rightMargin = r10;
        this.mSubDecor.addView(this.mStatusGuard, -1, r112);
        goto L50
    L31:
        if (r3.leftMargin != r16) goto L36;
        if (r3.rightMargin != r7) goto L36;
        r17 = false;
        goto L37
    L27:
        r10 = r8.getSystemWindowInsetRight();
        goto L29
    L24:
        r9 = r8.getSystemWindowInsetLeft();
        goto L25
    L20:
        r4.set(r11.getSystemWindowInsetLeft(), r11.getSystemWindowInsetTop(), r11.getSystemWindowInsetRight(), r11.getSystemWindowInsetBottom());
        goto L21
    L64:
        if (r3.topMargin == 0) goto L66;
        r3.topMargin = 0;
        r13 = false;
        goto L67
    L66:
        r13 = false;
        r5 = false;
        goto L67
    L5:
        if (r12 == null) goto L7;
        r1 = r12.top;
        goto L8
    L7:
        r1 = 0;
        goto L8
    }

    public AppCompatDelegateImpl(Activity r2, AppCompatCallback r3) {
        this(r2, null, r3, r2);
    }

    public AppCompatDelegateImpl(Context r2, Activity r3, AppCompatCallback r4) {
        this(r2, null, r4, r3);
    }

    public static void INVOKEINTERFACE_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r0, View r1, ViewGroup.LayoutParams r2) {
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r1, r2);
        r0.addView(r1, r2);
    }

    private Configuration createOverrideConfigurationForDayNight(Context r2, int r3, Configuration r4) {
        if (r3 != 1) goto L5;
        int r5 = 16;
    L9:
        Configuration r6 = new Configuration();
        r6.fontScale = 0.0f;
        if (r4 == null) goto L12;
        r6.setTo(r4);
    L12:
        r6.uiMode = r5 | (r6.uiMode & (-49));
        return r6;
    L5:
        if (r3 == 2) goto L7;
        r5 = r2.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        goto L9
    L7:
        r5 = 32;
        goto L9
    }

    private void updateResourcesConfigurationForNightMode(int r4, boolean r5, Configuration r6) {
        Resources r0 = this.mContext.getResources();
        Configuration r1 = new Configuration(r0.getConfiguration());
        if (r6 == null) goto L5;
        r1.updateFrom(r6);
    L5:
        r1.uiMode = r4 | (r0.getConfiguration().uiMode & (-49));
        r0.updateConfiguration(r1, null);
        int r7 = Build.VERSION.SDK_INT;
        if (r7 >= 26) goto L8;
        ResourcesFlusher.flush(r0);
    L8:
        int r8 = this.mThemeResId;
        if (r8 == 0) goto L13;
        this.mContext.setTheme(r8);
        if (r7 < 23) goto L13;
        this.mContext.getTheme().applyStyle(this.mThemeResId, true);
    L13:
        if (r5 == false) goto L25;
        Object r9 = this.mHost;
        if ((r9 instanceof Activity) == false) goto L26;
        LifecycleOwner r10 = (Activity) r9;
        if ((r10 instanceof LifecycleOwner) == false) goto L22;
        if (r10.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L27;
        r10.onConfigurationChanged(r1);
        return;
    L27:
        return;
    L22:
        if (this.mStarted == false) goto L29;
        r10.onConfigurationChanged(r1);
        return;
    L29:
        return;
    L26:
        return;
    }

    public void callOnPanelClosed(int r3, PanelFeatureState r4, Menu r5) {
        if (r5 != null) goto L10;
        if (r4 != null) goto L8;
        if (r3 < 0) goto L8;
        PanelFeatureState[] r0 = this.mPanels;
        if (r3 >= r0.length) goto L8;
        r4 = r0[r3];
    L8:
        if (r4 == null) goto L10;
        r5 = r4.menu;
    L10:
        if (r4 == null) goto L15;
        if (r4.isOpen == true) goto L15;
        return;
    L15:
        if (this.mIsDestroyed == true) goto L18;
        this.mAppCompatWindowCallback.getWrapped().onPanelClosed(r3, r5);
        return;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r2, Context r3, AttributeSet r4) {
        return onCreateView(null, r2, r3, r4);
    }

    public AppCompatDelegateImpl(Context r1, Window r2, AppCompatCallback r3) {
        this(r1, r2, r3, r1);
    }

    private AppCompatDelegateImpl(Context r3, Window r4, AppCompatCallback r5, Object r6) {
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        this.mLocalNightMode = -100;
        this.mInvalidatePanelMenuRunnable = new 2(this);
        this.mContext = r3;
        this.mAppCompatCallback = r5;
        this.mHost = r6;
        if (this.mLocalNightMode != (-100)) goto L10;
        if ((r6 instanceof Dialog) == false) goto L10;
        AppCompatActivity r7 = tryUnwrapContext();
        if (r7 == null) goto L10;
        this.mLocalNightMode = r7.getDelegate().getLocalNightMode();
    L10:
        if (this.mLocalNightMode != (-100)) goto L14;
        SimpleArrayMap<String, Integer> r8 = sLocalNightModes;
        Integer r9 = (Integer) r8.get(r6.getClass().getName());
        if (r9 == null) goto L14;
        this.mLocalNightMode = r9.intValue();
        r8.remove(r6.getClass().getName());
    L14:
        if (r4 == null) goto L16;
        attachToWindow(r4);
    L16:
        AppCompatDrawableManager.preload();
    }

    private boolean performPanelShortcut(PanelFeatureState r3, int r4, KeyEvent r5, int r6) {
        boolean r1 = false;
        if (r5.isSystem() == false) goto L6;
        return false;
    L6:
        if (r3.isPrepared == false) goto L8;
    L9:
        MenuBuilder r0 = r3.menu;
        if (r0 == null) goto L12;
        r1 = r0.performShortcut(r4, r5, r6);
    L12:
        if (r1 == true) goto L14;
    L18:
        return r1;
    L14:
        if ((r6 & 1) != 0) goto L18;
        if (this.mDecorContentParent != null) goto L18;
        closePanel(r3, true);
        goto L18
    L8:
        if (preparePanel(r3, r5) == false) goto L12;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View createView(View r12, String r13, Context r14, AttributeSet r15) {
        boolean r1 = false;
        if (this.mAppCompatViewInflater != null) goto L11;
        String r0 = this.mContext.obtainStyledAttributes(new int[]{R.attr.windowIsFloating, R.attr.windowAnimationStyle, 2130968710, 2130968711, 2130968712, 2130968713, 2130968714, 2130968715, 2130968716, 2130968717, 2130968718, 2130968719, 2130968720, 2130968721, 2130968722, 2130968724, 2130968725, 2130968726, 2130968727, 2130968728, 2130968729, 2130968730, 2130968731, 2130968732, 2130968733, 2130968734, 2130968735, 2130968736, 2130968737, 2130968738, 2130968739, 2130968740, 2130968741, 2130968742, 2130968747, 2130968767, 2130968768, 2130968769, 2130968770, 2130968871, 2130969037, 2130969098, 2130969099, 2130969100, 2130969101, 2130969102, 2130969107, 2130969108, 2130969183, 2130969189, 2130969561, 2130969562, 2130969563, 2130969564, 2130969565, 2130969566, 2130969567, 2130969568, 2130969569, 2130969571, 2130969637, 2130969751, 2130969752, 2130969753, 2130969764, 2130969772, 2130969843, 2130969844, 2130969937, 2130969938, 2130969939, 2130970261, 2130970320, 2130972554, 2130972556, 2130972558, 2130972559, 2130972562, 2130972563, 2130972564, 2130972565, 2130972566, 2130972567, 2130972568, 2130972569, 2130972570, 2130973434, 2130973435, 2130973436, 2130973584, 2130973586, 2130973710, 2130973725, 2130973726, 2130973727, 2130973954, 2130973996, 2130974008, 2130974009, 2130974125, 2130974126, 2130974350, 2130974508, 2130974509, 2130974510, 2130974511, 2130974513, 2130974514, 2130974515, 2130974516, 2130974526, 2130974528, 2130974605, 2130974606, 2130974611, 2130974612, 2130975037, 2130975145, 2130975146, 2130975147, 2130975148, 2130975149, 2130975150, 2130975151, 2130975152, 2130975153, 2130975154}).getString(116);
        if (r0 != null) goto L28;
        this.mAppCompatViewInflater = new AppCompatViewInflater();
        goto L11
    L28:
        this.mAppCompatViewInflater = (AppCompatViewInflater) INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r0).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L9
    L9:
        this.mAppCompatViewInflater = new AppCompatViewInflater();
    L11:
        if (IS_PRE_LOLLIPOP == true) goto L13;
        boolean r7 = false;
    L27:
        return this.mAppCompatViewInflater.createView(r12, r13, r14, r15, r7, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
    L13:
        if (this.mLayoutIncludeDetector != null) goto L16;
        this.mLayoutIncludeDetector = new LayoutIncludeDetector();
    L16:
        if (this.mLayoutIncludeDetector.detect(r15) == false) goto L19;
        r7 = true;
        goto L27
    L19:
        if ((r15 instanceof XmlPullParser) == true) goto L21;
        r1 = shouldInheritContext((ViewParent) r12);
    L24:
        r7 = r1;
        goto L27
    L21:
        if (((XmlPullParser) r15).getDepth() <= 1) goto L24;
        r1 = true;
        goto L24
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r1, String r2, Context r3, AttributeSet r4) {
        return createView(r1, r2, r3, r4);
    }
}
