package androidx.appcompat.app;

import ai.j0;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
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
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.e;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
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
import androidx.core.os.LocaleListCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
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
    private int mActivityHandlesConfigFlags;
    private boolean mActivityHandlesConfigFlagsChecked;
    final AppCompatCallback mAppCompatCallback;
    private AppCompatViewInflater mAppCompatViewInflater;
    private AppCompatWindowCallback mAppCompatWindowCallback;
    private AutoNightModeManager mAutoBatteryNightModeManager;
    private AutoNightModeManager mAutoTimeNightModeManager;
    private OnBackInvokedCallback mBackCallback;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    final Context mContext;
    private boolean mCreated;
    private DecorContentParent mDecorContentParent;
    boolean mDestroyed;
    private OnBackInvokedDispatcher mDispatcher;
    private Configuration mEffectiveConfiguration;
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

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ Thread.UncaughtExceptionHandler val$defHandler;

        public AnonymousClass1(Thread.UncaughtExceptionHandler r5) {
            this.val$defHandler = r5;
        }

        private boolean shouldWrapException(Throwable r5) {
            if ((r5 instanceof Resources.NotFoundException) == false) goto L12;
            String r10 = r5.getMessage();
            if (r10 != null) goto L7;
            return false;
        L7:
            if (r10.contains("drawable") == false) goto L9;
        L10:
            return true;
        L9:
            if (r10.contains("Drawable") == true) goto L10;
            return false;
        L12:
            return false;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread r5, @NonNull Throwable r10) {
            if (shouldWrapException(r10) == false) goto L5;
            Resources.NotFoundException r11 = new Resources.NotFoundException(r10.getMessage() + AppCompatDelegateImpl.EXCEPTION_HANDLER_MESSAGE_SUFFIX);
            r11.initCause(r10.getCause());
            r11.setStackTrace(r10.getStackTrace());
            this.val$defHandler.uncaughtException(r5, r11);
            return;
        L5:
            this.val$defHandler.uncaughtException(r5, r10);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements FitWindowsViewGroup.OnFitSystemWindowsListener {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public AnonymousClass4(AppCompatDelegateImpl r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
        public void onFitSystemWindows(Rect r5) {
            r5.top = this.this$0.updateStatusGuard(null, r5);
        }
    }

    public class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionBarDrawableToggleImpl(AppCompatDelegateImpl r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.this$0.getActionBarThemedContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TintTypedArray r5 = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[]{R.attr.homeAsUpIndicator});
            Drawable r10 = r5.getDrawable(0);
            r5.recycle();
            return r10;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            ActionBar r5 = this.this$0.getSupportActionBar();
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if ((r5.getDisplayOptions() & 4) == 0) goto L7;
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r5) {
            ActionBar r10 = this.this$0.getSupportActionBar();
            if (r10 == null) goto L6;
            r10.setHomeActionContentDescription(r5);
            return;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r5, int r10) {
            ActionBar r11 = this.this$0.getSupportActionBar();
            if (r11 == null) goto L6;
            r11.setHomeAsUpIndicator(r5);
            r11.setHomeActionContentDescription(r10);
            return;
        }
    }

    public interface ActionBarMenuCallback {
        @Nullable
        View onCreatePanelView(int r5);

        boolean onPreparePanel(int r5);
    }

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionMenuPresenterCallback(AppCompatDelegateImpl r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r5, boolean r10) {
            this.this$0.checkCloseActionMenu(r5);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r5) {
            Window.Callback r10 = this.this$0.getWindowCallback();
            if (r10 == null) goto L7;
            r10.onMenuOpened(108, r5);
            return true;
        L7:
            return true;
        }
    }

    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionModeCallbackWrapperV9(AppCompatDelegateImpl r5, ActionMode.Callback r10) {
            this.this$0 = r5;
            this.mWrapped = r10;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r5, MenuItem r10) {
            return this.mWrapped.onActionItemClicked(r5, r10);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r5, Menu r10) {
            return this.mWrapped.onCreateActionMode(r5, r10);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r5) {
            this.mWrapped.onDestroyActionMode(r5);
            AppCompatDelegateImpl r10 = this.this$0;
            if (r10.mActionModePopup == null) goto L5;
            r10.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
        L5:
            AppCompatDelegateImpl r11 = this.this$0;
            if (r11.mActionModeView == null) goto L8;
            r11.endOnGoingFadeAnimation();
            AppCompatDelegateImpl r12 = this.this$0;
            r12.mFadeAnim = ViewCompat.animate(r12.mActionModeView).alpha(0.0f);
            this.this$0.mFadeAnim.setListener(new AnonymousClass1(this));
        L8:
            AppCompatDelegateImpl r13 = this.this$0;
            AppCompatCallback r14 = r13.mAppCompatCallback;
            if (r14 == null) goto L11;
            r14.onSupportActionModeFinished(r13.mActionMode);
        L11:
            AppCompatDelegateImpl r15 = this.this$0;
            r15.mActionMode = null;
            ViewCompat.requestApplyInsets(r15.mSubDecor);
            this.this$0.updateBackInvokedCallbackState();
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r5, Menu r10) {
            ViewCompat.requestApplyInsets(this.this$0.mSubDecor);
            return this.mWrapped.onPrepareActionMode(r5, r10);
        }
    }

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        public static Context createConfigurationContext(@NonNull Context r5, @NonNull Configuration r10) {
            return r5.createConfigurationContext(r10);
        }

        public static void generateConfigDelta_densityDpi(@NonNull Configuration r5, @NonNull Configuration r10, @NonNull Configuration r11) {
            int r12 = r5.densityDpi;
            int r13 = r10.densityDpi;
            if (r12 == r13) goto L6;
            r11.densityDpi = r13;
            return;
        }

        @DoNotInline
        public static void setLayoutDirection(Configuration r5, Locale r10) {
            r5.setLayoutDirection(r10);
        }

        @DoNotInline
        public static void setLocale(Configuration r5, Locale r10) {
            r5.setLocale(r10);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean isPowerSaveMode(PowerManager r5) {
            return r5.isPowerSaveMode();
        }

        @DoNotInline
        public static String toLanguageTag(Locale r5) {
            return r5.toLanguageTag();
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void generateConfigDelta_locale(@NonNull Configuration r5, @NonNull Configuration r10, @NonNull Configuration r11) {
            LocaleList r12 = r5.getLocales();
            LocaleList r13 = r10.getLocales();
            if (r12.equals(r13) == true) goto L6;
            r11.setLocales(r13);
            r11.locale = r10.locale;
            return;
        }

        @DoNotInline
        public static LocaleListCompat getLocales(Configuration r5) {
            return LocaleListCompat.forLanguageTags(r5.getLocales().toLanguageTags());
        }

        @DoNotInline
        public static void setDefaultLocales(LocaleListCompat r5) {
            LocaleList.setDefault(LocaleList.forLanguageTags(r5.toLanguageTags()));
        }

        @DoNotInline
        public static void setLocales(Configuration r5, LocaleListCompat r10) {
            r5.setLocales(LocaleList.forLanguageTags(r10.toLanguageTags()));
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static void generateConfigDelta_colorMode(@NonNull Configuration r5, @NonNull Configuration r10, @NonNull Configuration r11) {
            int r12 = r5.colorMode & 3;
            int r13 = r10.colorMode;
            if (r12 == (r13 & 3)) goto L5;
            r11.colorMode |= r13 & 3;
        L5:
            int r14 = r5.colorMode & 12;
            int r15 = r10.colorMode;
            if (r14 == (r15 & 12)) goto L9;
            r11.colorMode |= r15 & 12;
            return;
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity r5) {
            return e.j(r5);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.window.OnBackInvokedCallback, androidx.appcompat.app.b] */
        @DoNotInline
        public static OnBackInvokedCallback registerOnBackPressedCallback(Object r5, final AppCompatDelegateImpl r10) {
            Objects.requireNonNull(r10);
            ?? r11 = new b(r10);
            e.u(e.m(r5), r11);
            return r11;
        }

        @DoNotInline
        public static void unregisterOnBackInvokedCallback(Object r5, Object r10) {
            OnBackInvokedCallback r11 = e.i(r10);
            e.t(e.m(r5), r11);
        }
    }

    public class AppCompatWindowCallback extends WindowCallbackWrapper {
        private ActionBarMenuCallback mActionBarCallback;
        private boolean mDispatchKeyEventBypassEnabled;
        private boolean mOnContentChangedBypassEnabled;
        private boolean mOnPanelClosedBypassEnabled;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public AppCompatWindowCallback(AppCompatDelegateImpl r5, Window.Callback r10) {
            this.this$0 = r5;
            super(r10);
        }

        public boolean bypassDispatchKeyEvent(Window.Callback r5, KeyEvent r10) {
            this.mDispatchKeyEventBypassEnabled = true;     // Catch: Throwable -> L6
            boolean r11 = r5.dispatchKeyEvent(r10);     // Catch: Throwable -> L6
            this.mDispatchKeyEventBypassEnabled = false;
            return r11;
        L6:
            th = move-exception;
            this.mDispatchKeyEventBypassEnabled = false;
            throw th;
        }

        public void bypassOnContentChanged(Window.Callback r5) {
            this.mOnContentChangedBypassEnabled = true;     // Catch: Throwable -> L6
            r5.onContentChanged();     // Catch: Throwable -> L6
            this.mOnContentChangedBypassEnabled = false;
            return;
        L6:
            th = move-exception;
            this.mOnContentChangedBypassEnabled = false;
            throw th;
        }

        public void bypassOnPanelClosed(Window.Callback r5, int r10, Menu r11) {
            this.mOnPanelClosedBypassEnabled = true;     // Catch: Throwable -> L6
            r5.onPanelClosed(r10, r11);     // Catch: Throwable -> L6
            this.mOnPanelClosedBypassEnabled = false;
            return;
        L6:
            th = move-exception;
            this.mOnPanelClosedBypassEnabled = false;
            throw th;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r5) {
            if (this.mDispatchKeyEventBypassEnabled == false) goto L7;
            return getWrapped().dispatchKeyEvent(r5);
        L7:
            if (this.this$0.dispatchKeyEvent(r5) == false) goto L9;
        L12:
            return true;
        L9:
            if (super.dispatchKeyEvent(r5) == true) goto L12;
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent r5) {
            if (super.dispatchKeyShortcutEvent(r5) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.this$0.onKeyShortcut(r5.getKeyCode(), r5) == true) goto L8;
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
            if (this.mOnContentChangedBypassEnabled == false) goto L6;
            getWrapped().onContentChanged();
            return;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int r5, Menu r10) {
            if (r5 != 0) goto L8;
            if ((r10 instanceof MenuBuilder) == true) goto L8;
            return false;
        L8:
            return super.onCreatePanelMenu(r5, r10);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int r5) {
            ActionBarMenuCallback r10 = this.mActionBarCallback;
            if (r10 == null) goto L8;
            View r11 = r10.onCreatePanelView(r5);
            if (r11 == null) goto L8;
            return r11;
        L8:
            return super.onCreatePanelView(r5);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int r5, Menu r10) {
            super.onMenuOpened(r5, r10);
            this.this$0.onMenuOpened(r5);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int r5, Menu r10) {
            if (this.mOnPanelClosedBypassEnabled == false) goto L6;
            getWrapped().onPanelClosed(r5, r10);
            return;
        L6:
            super.onPanelClosed(r5, r10);
            this.this$0.onPanelClosed(r5);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int r5, View r10, Menu r11) {
            if ((r11 instanceof MenuBuilder) == false) goto L5;
            MenuBuilder r12 = (MenuBuilder) r11;
        L7:
            if (r5 != 0) goto L10;
            if (r12 != null) goto L10;
            return false;
        L10:
            boolean r13 = true;
            if (r12 == null) goto L13;
            r12.setOverrideVisibleItems(true);
        L13:
            ActionBarMenuCallback r14 = this.mActionBarCallback;
            if (r14 != null) goto L16;
        L18:
            r13 = false;
        L19:
            if (r13 == true) goto L21;
            r13 = super.onPreparePanel(r5, r10, r11);
        L21:
            if (r12 == null) goto L23;
            r12.setOverrideVisibleItems(false);
        L23:
            return r13;
        L16:
            if (r14.onPreparePanel(r5) == false) goto L18;
        L5:
            r12 = null;
            goto L7
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r5, Menu r10, int r11) {
            PanelFeatureState r12 = this.this$0.getPanelState(0, true);
            if (r12 == null) goto L7;
            MenuBuilder r13 = r12.menu;
            if (r13 == null) goto L7;
            super.onProvideKeyboardShortcuts(r5, r13, r11);
            return;
        L7:
            super.onProvideKeyboardShortcuts(r5, r10, r11);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r5) {
            return null;
        }

        public void setActionBarCallback(@Nullable ActionBarMenuCallback r5) {
            this.mActionBarCallback = r5;
        }

        public final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback r5) {
            SupportActionModeWrapper.CallbackWrapper r10 = new SupportActionModeWrapper.CallbackWrapper(this.this$0.mContext, r5);
            ActionMode r11 = this.this$0.startSupportActionMode(r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            return r10.getActionModeWrapper(r11);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(23)
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r5, int r10) {
            if (this.this$0.isHandleNativeActionModesEnabled() == false) goto L9;
            if (r10 != 0) goto L9;
            return startAsSupportActionMode(r5);
        L9:
            return super.onWindowStartingActionMode(r5, r10);
        }
    }

    public class AutoBatteryNightModeManager extends AutoNightModeManager {
        private final PowerManager mPowerManager;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public AutoBatteryNightModeManager(@NonNull AppCompatDelegateImpl r5, Context r10) {
            this.this$0 = r5;
            super(r5);
            this.mPowerManager = (PowerManager) r10.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter r5 = new IntentFilter();
            r5.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return r5;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            if (Api21Impl.isPowerSaveMode(this.mPowerManager) == false) goto L5;
            return 2;
        L5:
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            this.this$0.applyDayNight();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public abstract class AutoNightModeManager {
        private BroadcastReceiver mReceiver;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public AutoNightModeManager(AppCompatDelegateImpl r5) {
            this.this$0 = r5;
        }

        public void cleanup() {
            BroadcastReceiver r5 = this.mReceiver;
            if (r5 == null) goto L10;
            this.this$0.mContext.unregisterReceiver(r5);     // Catch: IllegalArgumentException -> L7
        L5:
            this.mReceiver = null;
            return;
        }

        @Nullable
        public abstract IntentFilter createIntentFilterForBroadcastReceiver();

        public abstract int getApplyableNightMode();

        public boolean isListening() {
            if (this.mReceiver == null) goto L5;
            return true;
        L5:
            return false;
        }

        public abstract void onChange();

        public void setup() {
            cleanup();
            IntentFilter r5 = createIntentFilterForBroadcastReceiver();
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.countActions() != 0) goto L8;
            return;
        L8:
            if (this.mReceiver != null) goto L10;
            this.mReceiver = new AnonymousClass1(this);
        L10:
            this.this$0.mContext.registerReceiver(this.mReceiver, r5);
        }
    }

    public class AutoTimeNightModeManager extends AutoNightModeManager {
        private final TwilightManager mTwilightManager;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public AutoTimeNightModeManager(@NonNull AppCompatDelegateImpl r5, TwilightManager r10) {
            this.this$0 = r5;
            super(r5);
            this.mTwilightManager = r10;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter r5 = new IntentFilter();
            r5.addAction("android.intent.action.TIME_SET");
            r5.addAction("android.intent.action.TIMEZONE_CHANGED");
            r5.addAction("android.intent.action.TIME_TICK");
            return r5;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            if (this.mTwilightManager.isNight() == false) goto L5;
            return 2;
        L5:
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            this.this$0.applyDayNight();
        }
    }

    @RequiresApi(17)
    public static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        public static void applyOverrideConfiguration(ContextThemeWrapper r5, Configuration r10) {
            r5.applyOverrideConfiguration(r10);
        }
    }

    public class ListMenuDecorView extends ContentFrameLayout {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ListMenuDecorView(AppCompatDelegateImpl r5, Context r10) {
            this.this$0 = r5;
            super(r10);
        }

        private boolean isOutOfBounds(int r5, int r10) {
            if (r5 < (-5)) goto L11;
            if (r10 < (-5)) goto L11;
            if (r5 > (getWidth() + 5)) goto L11;
            if (r10 > (getHeight() + 5)) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent r5) {
            if (this.this$0.dispatchKeyEvent(r5) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.dispatchKeyEvent(r5) == true) goto L8;
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r5) {
            if (r5.getAction() != 0) goto L9;
            if (isOutOfBounds((int) r5.getX(), (int) r5.getY()) == false) goto L9;
            this.this$0.closePanel(0);
            return true;
        L9:
            return super.onInterceptTouchEvent(r5);
        }

        @Override // android.view.View
        public void setBackgroundResource(int r5) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), r5));
        }
    }

    public static final class PanelFeatureState {
        int background;
        View createdPanelView;
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        ListMenuPresenter listMenuPresenter;
        Context listPresenterContext;
        MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView;
        boolean refreshMenuContent;
        View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int f414x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int f415y;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            int featureId;
            boolean isOpen;
            Bundle menuState;

            static {
                CREATOR = new AnonymousClass1();
            }

            public SavedState() {
            }

            public static SavedState readFromParcel(Parcel r5, ClassLoader r10) {
                SavedState r11 = new SavedState();
                r11.featureId = r5.readInt();
                boolean r12 = true;
                if (r5.readInt() == 1) goto L6;
                r12 = false;
            L6:
                r11.isOpen = r12;
                if (r12 == false) goto L9;
                r11.menuState = r5.readBundle(r10);
            L9:
                return r11;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r5, int r10) {
                r5.writeInt(this.featureId);
                r5.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen == false) goto L6;
                r5.writeBundle(this.menuState);
                return;
            }
        }

        public PanelFeatureState(int r5) {
            this.featureId = r5;
            this.refreshDecorView = false;
        }

        public void applyFrozenState() {
            MenuBuilder r5 = this.menu;
            if (r5 == null) goto L8;
            Bundle r10 = this.frozenMenuState;
            if (r10 == null) goto L9;
            r5.restorePresenterStates(r10);
            this.frozenMenuState = null;
            return;
        L9:
            return;
        }

        public void clearMenuPresenters() {
            MenuBuilder r5 = this.menu;
            if (r5 == null) goto L5;
            r5.removeMenuPresenter(this.listMenuPresenter);
        L5:
            this.listMenuPresenter = null;
        }

        public MenuView getListMenuView(MenuPresenter.Callback r5) {
            if (this.menu != null) goto L7;
            return null;
        L7:
            if (this.listMenuPresenter != null) goto L10;
            ListMenuPresenter r10 = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
            this.listMenuPresenter = r10;
            r10.setCallback(r5);
            this.menu.addMenuPresenter(this.listMenuPresenter);
        L10:
            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        public boolean hasPanelItems() {
            if (this.shownPanelView != null) goto L6;
            return false;
        L6:
            if (this.createdPanelView == null) goto L9;
            return true;
        L9:
            if (this.listMenuPresenter.getAdapter().getCount() > 0) goto L11;
            return false;
        L11:
            return true;
        }

        public void onRestoreInstanceState(Parcelable r5) {
            SavedState r10 = (SavedState) r5;
            this.featureId = r10.featureId;
            this.wasLastOpen = r10.isOpen;
            this.frozenMenuState = r10.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        public Parcelable onSaveInstanceState() {
            SavedState r5 = new SavedState();
            r5.featureId = this.featureId;
            r5.isOpen = this.isOpen;
            if (this.menu == null) goto L5;
            Bundle r10 = new Bundle();
            r5.menuState = r10;
            this.menu.savePresenterStates(r10);
        L5:
            return r5;
        }

        public void setMenu(MenuBuilder r5) {
            MenuBuilder r10 = this.menu;
            if (r5 != r10) goto L5;
            return;
        L5:
            if (r10 == null) goto L7;
            r10.removeMenuPresenter(this.listMenuPresenter);
        L7:
            this.menu = r5;
            if (r5 == null) goto L13;
            ListMenuPresenter r11 = this.listMenuPresenter;
            if (r11 == null) goto L14;
            r5.addMenuPresenter(r11);
            return;
        L14:
            return;
        }

        public void setStyle(Context r5) {
            TypedValue r10 = new TypedValue();
            Resources.Theme r11 = r5.getResources().newTheme();
            r11.setTo(r5.getTheme());
            r11.resolveAttribute(R.attr.actionBarPopupTheme, r10, true);
            int r12 = r10.resourceId;
            if (r12 == 0) goto L5;
            r11.applyStyle(r12, true);
        L5:
            r11.resolveAttribute(R.attr.panelMenuListTheme, r10, true);
            int r13 = r10.resourceId;
            if (r13 == 0) goto L8;
            r11.applyStyle(r13, true);
        L9:
            androidx.appcompat.view.ContextThemeWrapper r14 = new androidx.appcompat.view.ContextThemeWrapper(r5, 0);
            r14.getTheme().setTo(r11);
            this.listPresenterContext = r14;
            TypedArray r15 = r14.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.background = r15.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = r15.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            r15.recycle();
            return;
        L8:
            r11.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            goto L9
        }
    }

    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public PanelMenuPresenterCallback(AppCompatDelegateImpl r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r5, boolean r10) {
            MenuBuilder r11 = r5.getRootMenu();
            if (r11 == r5) goto L5;
            boolean r12 = true;
        L6:
            AppCompatDelegateImpl r13 = this.this$0;
            if (r12 == false) goto L9;
            r5 = r11;
        L9:
            PanelFeatureState r14 = r13.findMenuPanel(r5);
            if (r14 == null) goto L15;
            if (r12 == false) goto L13;
            this.this$0.callOnPanelClosed(r14.featureId, r14, r11);
            this.this$0.closePanel(r14, true);
            return;
        L13:
            this.this$0.closePanel(r14, r10);
            return;
        L15:
            return;
        L5:
            r12 = false;
            goto L6
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r5) {
            if (r5 != r5.getRootMenu()) goto L13;
            AppCompatDelegateImpl r10 = this.this$0;
            if (r10.mHasActionBar == false) goto L14;
            Window.Callback r11 = r10.getWindowCallback();
            if (r11 != null) goto L9;
            return true;
        L9:
            if (this.this$0.mDestroyed == true) goto L16;
            r11.onMenuOpened(108, r5);
            return true;
        L16:
            return true;
        L14:
            return true;
        L13:
            return true;
        }
    }

    static {
        sLocalNightModes = new SimpleArrayMap();
        IS_PRE_LOLLIPOP = false;
        sWindowBackgroundStyleable = new int[]{android.R.attr.windowBackground};
        sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
        sCanApplyOverrideConfiguration = true;
    }

    public AppCompatDelegateImpl(Activity r5, AppCompatCallback r10) {
        this(r5, null, r10, r5);
    }

    private boolean applyApplicationSpecificConfig(boolean r5) {
        return applyApplicationSpecificConfig(r5, true);
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout r5 = (ContentFrameLayout) this.mSubDecor.findViewById(android.R.id.content);
        View r10 = this.mWindow.getDecorView();
        r5.setDecorPadding(r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), r10.getPaddingBottom());
        TypedArray r11 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        r11.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, r5.getMinWidthMajor());
        r11.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, r5.getMinWidthMinor());
        if (r11.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor) == false) goto L6;
        r11.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, r5.getFixedWidthMajor());
    L6:
        if (r11.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor) == false) goto L9;
        r11.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, r5.getFixedWidthMinor());
    L9:
        if (r11.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor) == false) goto L12;
        r11.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, r5.getFixedHeightMajor());
    L12:
        if (r11.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor) == false) goto L14;
        r11.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, r5.getFixedHeightMinor());
    L14:
        r11.recycle();
        r5.requestLayout();
    }

    private void attachToWindow(@NonNull Window r5) {
        if (this.mWindow != null) goto L18;
        Window.Callback r10 = r5.getCallback();
        if ((r10 instanceof AppCompatWindowCallback) == true) goto L16;
        AppCompatWindowCallback r11 = new AppCompatWindowCallback(this, r10);
        this.mAppCompatWindowCallback = r11;
        r5.setCallback(r11);
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
        Drawable r13 = r12.getDrawableIfKnown(0);
        if (r13 == null) goto L9;
        r5.setBackgroundDrawable(r13);
    L9:
        r12.recycle();
        this.mWindow = r5;
        if (Build.VERSION.SDK_INT >= 33) goto L12;
        return;
    L12:
        if (this.mDispatcher != null) goto L20;
        setOnBackInvokedDispatcher(null);
        return;
    L20:
        return;
    L16:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    L18:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private int calculateNightMode() {
        int r5 = this.mLocalNightMode;
        if (r5 == (-100)) goto L6;
        return r5;
    L6:
        return AppCompatDelegate.getDefaultNightMode();
    }

    private void cleanupAutoManagers() {
        AutoNightModeManager r5 = this.mAutoTimeNightModeManager;
        if (r5 == null) goto L5;
        r5.cleanup();
    L5:
        AutoNightModeManager r10 = this.mAutoBatteryNightModeManager;
        if (r10 == null) goto L9;
        r10.cleanup();
        return;
    }

    @NonNull
    private Configuration createOverrideAppConfiguration(@NonNull Context r5, int r10, @Nullable LocaleListCompat r11, @Nullable Configuration r12, boolean r13) {
        if (r10 != 1) goto L5;
        int r14 = 16;
    L11:
        Configuration r15 = new Configuration();
        r15.fontScale = 0.0f;
        if (r12 == null) goto L14;
        r15.setTo(r12);
    L14:
        r15.uiMode = r14 | (r15.uiMode & (-49));
        if (r11 == null) goto L17;
        setConfigurationLocales(r15, r11);
    L17:
        return r15;
    L5:
        if (r10 == 2) goto L9;
        if (r13 == false) goto L8;
        r14 = 0;
        goto L11
    L8:
        r14 = r5.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        goto L11
    L9:
        r14 = 32;
        goto L11
    }

    private ViewGroup createSubDecor() {
        TypedArray r5 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (r5.hasValue(R.styleable.AppCompatTheme_windowActionBar) == true) goto L5;
        r5.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    L5:
        if (r5.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false) == false) goto L8;
        requestWindowFeature(1);
    L11:
        if (r5.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false) == false) goto L14;
        requestWindowFeature(109);
    L14:
        if (r5.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false) == false) goto L16;
        requestWindowFeature(10);
    L16:
        this.mIsFloating = r5.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        r5.recycle();
        ensureWindow();
        this.mWindow.getDecorView();
        LayoutInflater r10 = LayoutInflater.from(this.mContext);
        if (this.mWindowNoTitle == true) goto L38;
        if (this.mIsFloating == false) goto L22;
        ViewGroup r11 = (ViewGroup) r10.inflate(R.layout.abc_dialog_title_material, null);
        this.mOverlayActionBar = false;
        this.mHasActionBar = false;
    L41:
        if (r11 == null) goto L55;
        ViewCompat.setOnApplyWindowInsetsListener(r11, new AnonymousClass3(this));
        if (this.mDecorContentParent != null) goto L45;
        this.mTitleView = (TextView) r11.findViewById(R.id.title);
    L45:
        ViewUtils.makeOptionalFitsSystemWindows(r11);
        ContentFrameLayout r12 = (ContentFrameLayout) r11.findViewById(R.id.action_bar_activity_content);
        ViewGroup r13 = (ViewGroup) this.mWindow.findViewById(android.R.id.content);
        if (r13 != null) goto L48;
    L53:
        this.mWindow.setContentView(r11);
        r12.setAttachListener(new AnonymousClass5(this));
        return r11;
    L48:
        if (r13.getChildCount() <= 0) goto L50;
        View r14 = r13.getChildAt(0);
        r13.removeViewAt(0);
        r12.addView(r14);
        goto L48
    L50:
        r13.setId(-1);
        r12.setId(android.R.id.content);
        if ((r13 instanceof FrameLayout) == false) goto L53;
        ((FrameLayout) r13).setForeground(null);
        goto L53
    L55:
        StringBuilder r15 = new StringBuilder("AppCompat does not support the current theme features: { windowActionBar: ");
        r15.append(this.mHasActionBar);
        r15.append(", windowActionBarOverlay: ");
        r15.append(this.mOverlayActionBar);
        r15.append(", android:windowIsFloating: ");
        r15.append(this.mIsFloating);
        r15.append(", windowActionModeOverlay: ");
        r15.append(this.mOverlayActionMode);
        r15.append(", windowNoTitle: ");
        throw new IllegalArgumentException(j0.r(r15, this.mWindowNoTitle, " }"));
    L22:
        if (this.mHasActionBar == false) goto L36;
        TypedValue r16 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, r16, true);
        if (r16.resourceId == 0) goto L26;
        Context r17 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, r16.resourceId);
    L27:
        r11 = (ViewGroup) LayoutInflater.from(r17).inflate(R.layout.abc_screen_toolbar, null);
        DecorContentParent r18 = (DecorContentParent) r11.findViewById(R.id.decor_content_parent);
        this.mDecorContentParent = r18;
        r18.setWindowCallback(getWindowCallback());
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
        r17 = this.mContext;
        goto L27
    L36:
        r11 = null;
        goto L41
    L38:
        if (this.mOverlayActionMode == false) goto L40;
        r11 = (ViewGroup) r10.inflate(R.layout.abc_screen_simple_overlay_action_mode, null);
        goto L41
    L40:
        r11 = (ViewGroup) r10.inflate(R.layout.abc_screen_simple, null);
        goto L41
    L8:
        if (r5.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false) == false) goto L11;
        requestWindowFeature(108);
        goto L11
    }

    private void ensureSubDecor() {
        if (this.mSubDecorInstalled == true) goto L22;
        this.mSubDecor = createSubDecor();
        CharSequence r5 = getTitle();
        if (TextUtils.isEmpty(r5) == true) goto L15;
        DecorContentParent r10 = this.mDecorContentParent;
        if (r10 == null) goto L10;
        r10.setWindowTitle(r5);
        goto L15
    L10:
        if (peekSupportActionBar() == null) goto L12;
        peekSupportActionBar().setWindowTitle(r5);
        goto L15
    L12:
        TextView r11 = this.mTitleView;
        if (r11 == null) goto L15;
        r11.setText(r5);
    L15:
        applyFixedSizeWindow();
        onSubDecorInstalled(this.mSubDecor);
        this.mSubDecorInstalled = true;
        PanelFeatureState r12 = getPanelState(0, false);
        if (this.mDestroyed == true) goto L23;
        if (r12 != null) goto L19;
    L20:
        invalidatePanelMenu(108);
        return;
    L19:
        if (r12.menu == null) goto L20;
        return;
    L23:
        return;
    }

    private void ensureWindow() {
        if (this.mWindow != null) goto L8;
        Object r5 = this.mHost;
        if ((r5 instanceof Activity) == false) goto L8;
        attachToWindow(((Activity) r5).getWindow());
    L8:
        if (this.mWindow == null) goto L11;
        return;
    L11:
        throw new IllegalStateException("We have not been given a Window");
    }

    @NonNull
    private static Configuration generateConfigDelta(@NonNull Configuration r5, @Nullable Configuration r10) {
        Configuration r11 = new Configuration();
        r11.fontScale = 0.0f;
        if (r10 != null) goto L5;
    L62:
        return r11;
    L5:
        if (r5.diff(r10) == 0) goto L62;
        float r12 = r5.fontScale;
        float r13 = r10.fontScale;
        if (r12 == r13) goto L10;
        r11.fontScale = r13;
    L10:
        int r14 = r5.mcc;
        int r15 = r10.mcc;
        if (r14 == r15) goto L13;
        r11.mcc = r15;
    L13:
        int r16 = r5.mnc;
        int r17 = r10.mnc;
        if (r16 == r17) goto L16;
        r11.mnc = r17;
    L16:
        Api24Impl.generateConfigDelta_locale(r5, r10, r11);
        int r18 = r5.touchscreen;
        int r19 = r10.touchscreen;
        if (r18 == r19) goto L19;
        r11.touchscreen = r19;
    L19:
        int r20 = r5.keyboard;
        int r21 = r10.keyboard;
        if (r20 == r21) goto L22;
        r11.keyboard = r21;
    L22:
        int r22 = r5.keyboardHidden;
        int r23 = r10.keyboardHidden;
        if (r22 == r23) goto L25;
        r11.keyboardHidden = r23;
    L25:
        int r24 = r5.navigation;
        int r25 = r10.navigation;
        if (r24 == r25) goto L28;
        r11.navigation = r25;
    L28:
        int r26 = r5.navigationHidden;
        int r27 = r10.navigationHidden;
        if (r26 == r27) goto L31;
        r11.navigationHidden = r27;
    L31:
        int r28 = r5.orientation;
        int r29 = r10.orientation;
        if (r28 == r29) goto L34;
        r11.orientation = r29;
    L34:
        int r30 = r5.screenLayout & 15;
        int r31 = r10.screenLayout;
        if (r30 == (r31 & 15)) goto L37;
        r11.screenLayout |= r31 & 15;
    L37:
        int r32 = r5.screenLayout & 192;
        int r33 = r10.screenLayout;
        if (r32 == (r33 & 192)) goto L40;
        r11.screenLayout |= r33 & 192;
    L40:
        int r34 = r5.screenLayout & 48;
        int r35 = r10.screenLayout;
        if (r34 == (r35 & 48)) goto L43;
        r11.screenLayout |= r35 & 48;
    L43:
        int r36 = r5.screenLayout & com.google.android.material.internal.ViewUtils.EDGE_TO_EDGE_FLAGS;
        int r37 = r10.screenLayout;
        if (r36 == (r37 & com.google.android.material.internal.ViewUtils.EDGE_TO_EDGE_FLAGS)) goto L46;
        r11.screenLayout |= r37 & com.google.android.material.internal.ViewUtils.EDGE_TO_EDGE_FLAGS;
    L46:
        Api26Impl.generateConfigDelta_colorMode(r5, r10, r11);
        int r38 = r5.uiMode & 15;
        int r39 = r10.uiMode;
        if (r38 == (r39 & 15)) goto L49;
        r11.uiMode |= r39 & 15;
    L49:
        int r40 = r5.uiMode & 48;
        int r41 = r10.uiMode;
        if (r40 == (r41 & 48)) goto L52;
        r11.uiMode |= r41 & 48;
    L52:
        int r42 = r5.screenWidthDp;
        int r43 = r10.screenWidthDp;
        if (r42 == r43) goto L55;
        r11.screenWidthDp = r43;
    L55:
        int r44 = r5.screenHeightDp;
        int r45 = r10.screenHeightDp;
        if (r44 == r45) goto L58;
        r11.screenHeightDp = r45;
    L58:
        int r46 = r5.smallestScreenWidthDp;
        int r47 = r10.smallestScreenWidthDp;
        if (r46 == r47) goto L61;
        r11.smallestScreenWidthDp = r47;
    L61:
        Api17Impl.generateConfigDelta_densityDpi(r5, r10, r11);
        goto L62
    }

    private int getActivityHandlesConfigChangesFlags(Context r5) {
        if (this.mActivityHandlesConfigFlagsChecked == false) goto L5;
    L15:
        this.mActivityHandlesConfigFlagsChecked = true;
        return this.mActivityHandlesConfigFlags;
    L5:
        if ((this.mHost instanceof Activity) == false) goto L15;
        PackageManager r10 = r5.getPackageManager();
        if (r10 != null) goto L17;
        return 0;
    L17:
        ActivityInfo r11 = r10.getActivityInfo(new ComponentName(r5, this.mHost.getClass()), 269221888);     // Catch: PackageManager.NameNotFoundException -> L13
        if (r11 == null) goto L15;
        this.mActivityHandlesConfigFlags = r11.configChanges;     // Catch: PackageManager.NameNotFoundException -> L13
    L13:
        e = move-exception;
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
        this.mActivityHandlesConfigFlags = 0;
        goto L15
    }

    private AutoNightModeManager getAutoBatteryNightModeManager(@NonNull Context r5) {
        if (this.mAutoBatteryNightModeManager != null) goto L6;
        this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(this, r5);
    L6:
        return this.mAutoBatteryNightModeManager;
    }

    private void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar == true) goto L5;
        return;
    L5:
        if (this.mActionBar != null) goto L19;
        Object r5 = this.mHost;
        if ((r5 instanceof Activity) == false) goto L11;
        this.mActionBar = new WindowDecorActionBar((Activity) this.mHost, this.mOverlayActionBar);
    L13:
        ActionBar r10 = this.mActionBar;
        if (r10 == null) goto L18;
        r10.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        return;
    L18:
        return;
    L11:
        if ((r5 instanceof Dialog) == false) goto L13;
        this.mActionBar = new WindowDecorActionBar((Dialog) this.mHost);
        goto L13
    }

    private boolean initializePanelContent(PanelFeatureState r5) {
        View r10 = r5.createdPanelView;
        if (r10 == null) goto L7;
        r5.shownPanelView = r10;
        return true;
    L7:
        if (r5.menu != null) goto L10;
        return false;
    L10:
        if (this.mPanelMenuPresenterCallback != null) goto L12;
        this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(this);
    L12:
        View r11 = (View) r5.getListMenuView(this.mPanelMenuPresenterCallback);
        r5.shownPanelView = r11;
        if (r11 == null) goto L16;
        return true;
    L16:
        return false;
    }

    private boolean initializePanelDecor(PanelFeatureState r5) {
        r5.setStyle(getActionBarThemedContext());
        r5.decorView = new ListMenuDecorView(this, r5.listPresenterContext);
        r5.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState r10) {
        Context r5 = this.mContext;
        int r11 = r10.featureId;
        if (r11 == 0) goto L7;
        if (r11 == 108) goto L7;
    L19:
        MenuBuilder r12 = new MenuBuilder(r5);
        r12.setCallback(this);
        r10.setMenu(r12);
        return true;
    L7:
        if (this.mDecorContentParent == null) goto L19;
        TypedValue r13 = new TypedValue();
        Resources.Theme r14 = r5.getTheme();
        r14.resolveAttribute(R.attr.actionBarTheme, r13, true);
        if (r13.resourceId == 0) goto L11;
        Resources.Theme r15 = r5.getResources().newTheme();
        r15.setTo(r14);
        r15.applyStyle(r13.resourceId, true);
        r15.resolveAttribute(R.attr.actionBarWidgetTheme, r13, true);
    L13:
        if (r13.resourceId == 0) goto L17;
        if (r15 != null) goto L16;
        r15 = r5.getResources().newTheme();
        r15.setTo(r14);
    L16:
        r15.applyStyle(r13.resourceId, true);
    L17:
        if (r15 == null) goto L19;
        androidx.appcompat.view.ContextThemeWrapper r16 = new androidx.appcompat.view.ContextThemeWrapper(r5, 0);
        r16.getTheme().setTo(r15);
        r5 = r16;
        goto L19
    L11:
        r14.resolveAttribute(R.attr.actionBarWidgetTheme, r13, true);
        r15 = null;
        goto L13
    }

    private void invalidatePanelMenu(int r5) {
        int r10 = 1 << r5;
        this.mInvalidatePanelMenuFeatures = r10 | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted == true) goto L6;
        ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
        return;
    }

    private boolean onKeyDownPanel(int r5, KeyEvent r10) {
        if (r10.getRepeatCount() != 0) goto L8;
        PanelFeatureState r11 = getPanelState(r5, true);
        if (r11.isOpen == false) goto L7;
        return false;
    L7:
        return preparePanel(r11, r10);
    L8:
        return false;
    }

    private boolean onKeyUpPanel(int r5, KeyEvent r10) {
        if (this.mActionMode == null) goto L5;
        return false;
    L5:
        boolean r11 = true;
        PanelFeatureState r12 = getPanelState(r5, true);
        if (r5 != 0) goto L21;
        DecorContentParent r13 = this.mDecorContentParent;
        if (r13 == null) goto L21;
        if (r13.canShowOverflowMenu() == false) goto L21;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L21;
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L16;
        r11 = this.mDecorContentParent.hideOverflowMenu();
    L36:
        if (r11 == false) goto L41;
        AudioManager r14 = (AudioManager) this.mContext.getApplicationContext().getSystemService("audio");
        if (r14 == null) goto L40;
        r14.playSoundEffect(0);
        goto L41
    L40:
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
    L41:
        return r11;
    L16:
        if (this.mDestroyed == false) goto L18;
    L34:
        r11 = false;
        goto L36
    L18:
        if (preparePanel(r12, r10) == false) goto L34;
        r11 = this.mDecorContentParent.showOverflowMenu();
    L21:
        boolean r15 = r12.isOpen;
        if (r15 == false) goto L24;
    L35:
        closePanel(r12, true);
        r11 = r15;
        goto L36
    L24:
        if (r12.isHandled == true) goto L35;
        if (r12.isPrepared == false) goto L34;
        if (r12.refreshMenuContent == false) goto L31;
        r12.isPrepared = false;
        boolean r16 = preparePanel(r12, r10);
    L32:
        if (r16 == false) goto L34;
        openPanel(r12, r10);
        goto L36
    L31:
        r16 = true;
        goto L32
    }

    private void openPanel(PanelFeatureState r12, KeyEvent r13) {
        if (r12.isOpen == false) goto L5;
        return;
    L5:
        if (this.mDestroyed == false) goto L8;
        return;
    L8:
        if (r12.featureId == 0) goto L10;
    L12:
        Window.Callback r5 = getWindowCallback();
        if (r5 != null) goto L15;
    L18:
        WindowManager r10 = (WindowManager) this.mContext.getSystemService("window");
        if (r10 != null) goto L22;
        return;
    L22:
        if (preparePanel(r12, r13) == true) goto L24;
        return;
    L24:
        ViewGroup r14 = r12.decorView;
        if (r14 != null) goto L27;
    L36:
        if (r14 != null) goto L43;
        if (initializePanelDecor(r12) == true) goto L40;
        return;
    L40:
        if (r12.decorView != null) goto L48;
        return;
    L48:
        if (initializePanelContent(r12) == true) goto L50;
    L66:
        r12.refreshDecorView = true;
        return;
    L50:
        if (r12.hasPanelItems() == false) goto L66;
        ViewGroup.LayoutParams r15 = r12.shownPanelView.getLayoutParams();
        if (r15 != null) goto L55;
        r15 = new ViewGroup.LayoutParams(-2, -2);
    L55:
        r12.decorView.setBackgroundResource(r12.background);
        ViewParent r11 = r12.shownPanelView.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L58;
        ((ViewGroup) r11).removeView(r12.shownPanelView);
    L58:
        r12.decorView.addView(r12.shownPanelView, r15);
        if (r12.shownPanelView.hasFocus() == true) goto L61;
        r12.shownPanelView.requestFocus();
    L61:
        int r16 = -2;
    L62:
        r12.isHandled = false;
        WindowManager.LayoutParams r17 = new WindowManager.LayoutParams(r16, -2, r12.f414x, r12.f415y, PointerIconCompat.TYPE_HAND, 8519680, -3);
        r17.gravity = r12.gravity;
        r17.windowAnimations = r12.windowAnimations;
        r10.addView(r12.decorView, r17);
        r12.isOpen = true;
        if (r12.featureId != 0) goto L69;
        updateBackInvokedCallbackState();
        return;
    L69:
        return;
    L43:
        if (r12.refreshDecorView == false) goto L48;
        if (r14.getChildCount() <= 0) goto L48;
        r12.decorView.removeAllViews();
        goto L48
    L27:
        if (r12.refreshDecorView == true) goto L36;
        View r18 = r12.createdPanelView;
        if (r18 == null) goto L61;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L61;
        if (r19.width != (-1)) goto L61;
        r16 = -1;
        goto L62
    L15:
        if (r5.onMenuOpened(r12.featureId, r12.menu) == true) goto L18;
        closePanel(r12, true);
        return;
    L10:
        if ((this.mContext.getResources().getConfiguration().screenLayout & 15) != 4) goto L12;
    }

    private boolean performPanelShortcut(PanelFeatureState r5, int r10, KeyEvent r11, int r12) {
        boolean r13 = false;
        if (r11.isSystem() == false) goto L6;
        return false;
    L6:
        if (r5.isPrepared == false) goto L8;
    L9:
        MenuBuilder r14 = r5.menu;
        if (r14 == null) goto L12;
        r13 = r14.performShortcut(r10, r11, r12);
    L12:
        if (r13 == true) goto L14;
    L18:
        return r13;
    L14:
        if ((r12 & 1) != 0) goto L18;
        if (this.mDecorContentParent != null) goto L18;
        closePanel(r5, true);
        goto L18
    L8:
        if (preparePanel(r5, r11) == false) goto L12;
        goto L9
    }

    private boolean preparePanel(PanelFeatureState r10, KeyEvent r11) {
        if (this.mDestroyed == false) goto L6;
        return false;
    L6:
        if (r10.isPrepared == false) goto L8;
        return true;
    L8:
        PanelFeatureState r5 = this.mPreparedPanel;
        if (r5 == null) goto L12;
        if (r5 == r10) goto L12;
        closePanel(r5, false);
    L12:
        Window.Callback r12 = getWindowCallback();
        if (r12 == null) goto L15;
        r10.createdPanelView = r12.onCreatePanelView(r10.featureId);
    L15:
        int r13 = r10.featureId;
        if (r13 != 0) goto L18;
    L21:
        boolean r14 = true;
    L22:
        if (r14 == false) goto L27;
        DecorContentParent r15 = this.mDecorContentParent;
        if (r15 == null) goto L27;
        r15.setMenuPrepared();
    L27:
        if (r10.createdPanelView != null) goto L76;
        if (r14 == true) goto L30;
    L31:
        MenuBuilder r16 = r10.menu;
        if (r16 != null) goto L34;
    L35:
        if (r16 == null) goto L37;
    L41:
        if (r14 == true) goto L43;
    L48:
        r10.menu.stopDispatchingItemsChanged();
        if (r12.onCreatePanelMenu(r10.featureId, r10.menu) == true) goto L56;
        r10.setMenu(null);
        if (r14 == false) goto L55;
        DecorContentParent r17 = this.mDecorContentParent;
        if (r17 == null) goto L55;
        r17.setMenu(null, this.mActionMenuPresenterCallback);
    L55:
        return false;
    L56:
        r10.refreshMenuContent = false;
    L57:
        r10.menu.stopDispatchingItemsChanged();
        Bundle r18 = r10.frozenActionViewState;
        if (r18 == null) goto L61;
        r10.menu.restoreActionViewStates(r18);
        r10.frozenActionViewState = null;
    L61:
        if (r12.onPreparePanel(0, r10.createdPanelView, r10.menu) == true) goto L68;
        if (r14 == false) goto L66;
        DecorContentParent r19 = this.mDecorContentParent;
        if (r19 == null) goto L66;
        r19.setMenu(null, this.mActionMenuPresenterCallback);
    L66:
        r10.menu.startDispatchingItemsChanged();
        return false;
    L68:
        if (r11 == null) goto L70;
        int r110 = r11.getDeviceId();
    L72:
        if (KeyCharacterMap.load(r110).getKeyboardType() == 1) goto L74;
        boolean r111 = true;
    L75:
        r10.qwertyMode = r111;
        r10.menu.setQwertyMode(r111);
        r10.menu.startDispatchingItemsChanged();
        goto L76
    L74:
        r111 = false;
        goto L75
    L70:
        r110 = -1;
        goto L72
    L43:
        if (this.mDecorContentParent == null) goto L48;
        if (this.mActionMenuPresenterCallback != null) goto L47;
        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback(this);
    L47:
        this.mDecorContentParent.setMenu(r10.menu, this.mActionMenuPresenterCallback);
        goto L48
    L37:
        if (initializePanelMenu(r10) == true) goto L39;
    L40:
        return false;
    L39:
        if (r10.menu != null) goto L41;
    L34:
        if (r10.refreshMenuContent == false) goto L57;
    L30:
        if ((peekSupportActionBar() instanceof ToolbarActionBar) == false) goto L31;
    L76:
        r10.isPrepared = true;
        r10.isHandled = false;
        this.mPreparedPanel = r10;
        return true;
    L18:
        if (r13 == 108) goto L21;
        r14 = false;
        goto L22
    }

    private void reopenMenu(boolean r10) {
        DecorContentParent r5 = this.mDecorContentParent;
        if (r5 != null) goto L5;
    L33:
        PanelFeatureState r11 = getPanelState(0, true);
        r11.refreshDecorView = true;
        closePanel(r11, false);
        openPanel(r11, null);
        return;
    L5:
        if (r5.canShowOverflowMenu() == false) goto L33;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L9;
    L10:
        Window.Callback r12 = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L17;
        if (r10 == false) goto L17;
        this.mDecorContentParent.hideOverflowMenu();
        if (this.mDestroyed == true) goto L35;
        r12.onPanelClosed(108, getPanelState(0, true).menu);
        return;
    L35:
        return;
    L17:
        if (r12 != null) goto L19;
        return;
    L19:
        if (this.mDestroyed == false) goto L21;
        return;
    L21:
        if (this.mInvalidatePanelMenuPosted == true) goto L23;
    L25:
        PanelFeatureState r13 = getPanelState(0, true);
        MenuBuilder r14 = r13.menu;
        if (r14 != null) goto L28;
        return;
    L28:
        if (r13.refreshMenuContent == false) goto L30;
        return;
    L30:
        if (r12.onPreparePanel(0, r13.createdPanelView, r14) == false) goto L41;
        r12.onMenuOpened(108, r13.menu);
        this.mDecorContentParent.showOverflowMenu();
        return;
    L41:
        return;
    L23:
        if ((this.mInvalidatePanelMenuFeatures & 1) == 0) goto L25;
        this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuRunnable.run();
        goto L25
    L9:
        if (this.mDecorContentParent.isOverflowMenuShowPending() == false) goto L33;
        goto L10
    }

    private int sanitizeWindowFeatureId(int r5) {
        if (r5 != 8) goto L7;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
        return 108;
    L7:
        if (r5 != 9) goto L10;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    L10:
        return r5;
    }

    private boolean shouldInheritContext(ViewParent r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        View r10 = this.mWindow.getDecorView();
    L6:
        if (r5 == null) goto L7;
        if (r5 == r10) goto L16;
        if ((r5 instanceof View) == false) goto L16;
        if (ViewCompat.isAttachedToWindow((View) r5) == true) goto L16;
        r5 = r5.getParent();
    L16:
        return false;
    L7:
        return true;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled == true) goto L6;
        return;
    L6:
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    @Nullable
    private AppCompatActivity tryUnwrapContext() {
        Context r5 = this.mContext;
    L4:
        if (r5 == null) goto L12;
        if ((r5 instanceof AppCompatActivity) == true) goto L8;
        if ((r5 instanceof ContextWrapper) == false) goto L12;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L4
    L8:
        return (AppCompatActivity) r5;
    L12:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateActivityConfiguration(Configuration r5) {
        Activity r10 = (Activity) this.mHost;
        if ((r10 instanceof LifecycleOwner) == false) goto L8;
        if (((LifecycleOwner) r10).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L13;
        r10.onConfigurationChanged(r5);
        return;
    L13:
        return;
    L8:
        if (this.mCreated == true) goto L10;
        return;
    L10:
        if (this.mDestroyed == true) goto L16;
        r10.onConfigurationChanged(r5);
        return;
    }

    private boolean updateAppConfiguration(int r10, @Nullable LocaleListCompat r11, boolean r12) {
        Configuration r5 = createOverrideAppConfiguration(this.mContext, r10, r11, null, false);
        int r13 = getActivityHandlesConfigChangesFlags(this.mContext);
        Configuration r14 = this.mEffectiveConfiguration;
        if (r14 != null) goto L5;
        r14 = this.mContext.getResources().getConfiguration();
    L5:
        int r15 = r14.uiMode & 48;
        int r16 = r5.uiMode & 48;
        LocaleListCompat r17 = getConfigurationLocales(r14);
        if (r11 != null) goto L8;
        LocaleListCompat r18 = null;
    L9:
        boolean r19 = false;
        if (r15 == r16) goto L12;
        int r20 = 512;
    L13:
        if (r18 != null) goto L15;
    L17:
        boolean r21 = true;
        if (((~r13) & r20) == 0) goto L31;
        if (r12 == false) goto L31;
        if (this.mBaseContextAttached == false) goto L31;
        if (sCanReturnDifferentContext == false) goto L25;
    L26:
        Object r110 = this.mHost;
        if ((r110 instanceof Activity) == false) goto L31;
        if (((Activity) r110).isChild() == true) goto L31;
        ActivityCompat.recreate((Activity) this.mHost);
        boolean r111 = true;
    L32:
        if (r111 == true) goto L38;
        if (r20 == 0) goto L38;
        if ((r20 & r13) != r20) goto L37;
        r19 = true;
    L37:
        updateResourcesConfiguration(r16, r18, r19, null);
    L39:
        if (r21 == false) goto L48;
        Object r112 = this.mHost;
        if ((r112 instanceof AppCompatActivity) == false) goto L48;
        if ((r20 & 512) == 0) goto L46;
        ((AppCompatActivity) r112).onNightModeChanged(r10);
    L46:
        if ((r20 & 4) == 0) goto L48;
        ((AppCompatActivity) this.mHost).onLocalesChanged(r11);
    L48:
        if (r21 == false) goto L51;
        if (r18 == null) goto L51;
        setDefaultLocalesForLocaleList(getConfigurationLocales(this.mContext.getResources().getConfiguration()));
    L51:
        return r21;
    L38:
        r21 = r111;
        goto L39
    L25:
        if (this.mCreated == true) goto L26;
    L31:
        r111 = false;
        goto L32
    L15:
        if (r17.equals(r18) == true) goto L17;
        r20 = r20 | 8196;
        goto L17
    L12:
        r20 = 0;
        goto L13
    L8:
        r18 = getConfigurationLocales(r5);
        goto L9
    }

    private void updateResourcesConfiguration(int r5, @Nullable LocaleListCompat r10, boolean r11, @Nullable Configuration r12) {
        Resources r13 = this.mContext.getResources();
        Configuration r14 = new Configuration(r13.getConfiguration());
        if (r12 == null) goto L5;
        r14.updateFrom(r12);
    L5:
        r14.uiMode = r5 | (r13.getConfiguration().uiMode & (-49));
        if (r10 == null) goto L8;
        setConfigurationLocales(r14, r10);
    L8:
        r13.updateConfiguration(r14, null);
        int r15 = this.mThemeResId;
        if (r15 == 0) goto L11;
        this.mContext.setTheme(r15);
        this.mContext.getTheme().applyStyle(this.mThemeResId, true);
    L11:
        if (r11 == true) goto L13;
        return;
    L13:
        if ((this.mHost instanceof Activity) == false) goto L17;
        updateActivityConfiguration(r14);
        return;
    }

    private void updateStatusGuardColor(View r5) {
        if ((ViewCompat.getWindowSystemUiVisibility(r5) & 8192) == 0) goto L5;
        int r10 = ContextCompat.getColor(this.mContext, R.color.abc_decor_view_status_guard_light);
    L6:
        r5.setBackgroundColor(r10);
        return;
    L5:
        r10 = ContextCompat.getColor(this.mContext, R.color.abc_decor_view_status_guard);
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View r5, ViewGroup.LayoutParams r10) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(android.R.id.content)).addView(r5, r10);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyAppLocales() {
        if (AppCompatDelegate.isAutoStorageOptedIn(this.mContext) == false) goto L10;
        if (AppCompatDelegate.getRequestedAppLocales() == null) goto L10;
        if (AppCompatDelegate.getRequestedAppLocales().equals(AppCompatDelegate.getStoredAppLocales()) == true) goto L10;
        asyncExecuteSyncRequestedAndStoredLocales(this.mContext);
    L10:
        return applyApplicationSpecificConfig(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        return applyApplicationSpecificConfig(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context r10) {
        this.mBaseContextAttached = true;
        int r5 = mapNightMode(r10, calculateNightMode());
        if (AppCompatDelegate.isAutoStorageOptedIn(r10) == false) goto L5;
        AppCompatDelegate.syncRequestedAndStoredLocales(r10);
    L5:
        LocaleListCompat r11 = calculateApplicationLocales(r10);
        if (sCanApplyOverrideConfiguration == false) goto L13;
        if ((r10 instanceof ContextThemeWrapper) == false) goto L13;
        ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((ContextThemeWrapper) r10, createOverrideAppConfiguration(r10, r5, r11, null, false));     // Catch: IllegalStateException -> L32
        return r10;
    L13:
        if ((r10 instanceof androidx.appcompat.view.ContextThemeWrapper) == false) goto L18;
        ((androidx.appcompat.view.ContextThemeWrapper) r10).applyOverrideConfiguration(createOverrideAppConfiguration(r10, r5, r11, null, false));     // Catch: IllegalStateException -> L33
        return r10;
    L18:
        if (sCanReturnDifferentContext == false) goto L20;
        Configuration r12 = new Configuration();
        r12.uiMode = -1;
        r12.fontScale = 0.0f;
        Configuration r13 = Api17Impl.createConfigurationContext(r10, r12).getResources().getConfiguration();
        Configuration r14 = r10.getResources().getConfiguration();
        r13.uiMode = r14.uiMode;
        if (r13.equals(r14) == true) goto L25;
        Configuration r15 = generateConfigDelta(r13, r14);
    L26:
        Configuration r16 = createOverrideAppConfiguration(r10, r5, r11, r15, true);
        androidx.appcompat.view.ContextThemeWrapper r17 = new androidx.appcompat.view.ContextThemeWrapper(r10, R.style.Theme_AppCompat_Empty);
        r17.applyOverrideConfiguration(r16);
        if (r10.getTheme() == null) goto L31;
        ResourcesCompat.ThemeCompat.rebase(r17.getTheme());
    L31:
        return super.attachBaseContext2(r17);
    L25:
        r15 = null;
        goto L26
    L20:
        return super.attachBaseContext2(r10);
    }

    @Nullable
    public LocaleListCompat calculateApplicationLocales(@NonNull Context r5) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        return null;
    L5:
        LocaleListCompat r10 = AppCompatDelegate.getRequestedAppLocales();
        if (r10 != null) goto L8;
        return null;
    L8:
        LocaleListCompat r11 = getConfigurationLocales(r5.getApplicationContext().getResources().getConfiguration());
        LocaleListCompat r12 = LocaleOverlayHelper.combineLocalesIfOverlayExists(r10, r11);
        if (r12.isEmpty() == false) goto L12;
        return r11;
    L12:
        return r12;
    }

    public void callOnPanelClosed(int r5, PanelFeatureState r10, Menu r11) {
        if (r11 != null) goto L10;
        if (r10 != null) goto L8;
        if (r5 < 0) goto L8;
        PanelFeatureState[] r12 = this.mPanels;
        if (r5 >= r12.length) goto L8;
        r10 = r12[r5];
    L8:
        if (r10 == null) goto L10;
        r11 = r10.menu;
    L10:
        if (r10 == null) goto L15;
        if (r10.isOpen == true) goto L15;
        return;
    L15:
        if (this.mDestroyed == true) goto L18;
        this.mAppCompatWindowCallback.bypassOnPanelClosed(this.mWindow.getCallback(), r5, r11);
        return;
    }

    public void checkCloseActionMenu(@NonNull MenuBuilder r5) {
        if (this.mClosingActionMenu == false) goto L5;
        return;
    L5:
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window.Callback r10 = getWindowCallback();
        if (r10 != null) goto L8;
    L10:
        this.mClosingActionMenu = false;
        return;
    L8:
        if (this.mDestroyed == true) goto L10;
        r10.onPanelClosed(108, r5);
        goto L10
    }

    public void closePanel(int r5) {
        closePanel(getPanelState(r5, true), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(View r11, String r12, @NonNull Context r13, @NonNull AttributeSet r14) {
        if (this.mAppCompatViewInflater != null) goto L11;
        String r5 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
        if (r5 != null) goto L28;
        this.mAppCompatViewInflater = new AppCompatViewInflater();
        goto L11
    L28:
        this.mAppCompatViewInflater = (AppCompatViewInflater) this.mContext.getClassLoader().loadClass(r5).getDeclaredConstructor(null).newInstance(null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + r5 + ". Falling back to default.", th);
        this.mAppCompatViewInflater = new AppCompatViewInflater();
    L11:
        boolean r10 = IS_PRE_LOLLIPOP;
        boolean r15 = false;
        if (r10 == true) goto L14;
    L25:
        boolean r16 = r15;
    L27:
        return this.mAppCompatViewInflater.createView(r11, r12, r13, r14, r16, r10, true, VectorEnabledTintResources.shouldBeUsed());
    L14:
        if (this.mLayoutIncludeDetector != null) goto L17;
        this.mLayoutIncludeDetector = new LayoutIncludeDetector();
    L17:
        if (this.mLayoutIncludeDetector.detect(r14) == false) goto L20;
        r16 = true;
        goto L27
    L20:
        if ((r14 instanceof XmlPullParser) == true) goto L22;
        r15 = shouldInheritContext((ViewParent) r11);
        goto L25
    L22:
        if (((XmlPullParser) r14).getDepth() <= 1) goto L25;
        r15 = true;
        goto L25
    }

    public void dismissPopups() {
        DecorContentParent r5 = this.mDecorContentParent;
        if (r5 == null) goto L6;
        r5.dismissPopups();
    L6:
        if (this.mActionModePopup == null) goto L11;
        this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
        if (this.mActionModePopup.isShowing() == true) goto L18;
    L10:
        this.mActionModePopup = null;
        goto L11
    L18:
        this.mActionModePopup.dismiss();     // Catch: IllegalArgumentException -> L17
    L11:
        endOnGoingFadeAnimation();
        PanelFeatureState r10 = getPanelState(0, false);
        if (r10 == null) goto L20;
        MenuBuilder r11 = r10.menu;
        if (r11 == null) goto L21;
        r11.close();
        return;
    L21:
        return;
    }

    public boolean dispatchKeyEvent(KeyEvent r5) {
        Object r10 = this.mHost;
        if ((r10 instanceof KeyEventDispatcher.Component) == false) goto L5;
    L6:
        View r11 = this.mWindow.getDecorView();
        if (r11 != null) goto L9;
    L12:
        if (r5.getKeyCode() == 82) goto L14;
    L16:
        int r12 = r5.getKeyCode();
        if (r5.getAction() != 0) goto L20;
        return onKeyDown(r12, r5);
    L20:
        return onKeyUp(r12, r5);
    L14:
        if (this.mAppCompatWindowCallback.bypassDispatchKeyEvent(this.mWindow.getCallback(), r5) == false) goto L16;
        return true;
    L9:
        if (KeyEventDispatcher.dispatchBeforeHierarchy(r11, r5) == false) goto L12;
        return true;
    L5:
        if ((r10 instanceof AppCompatDialog) == false) goto L12;
        goto L6
    }

    public void doInvalidatePanelMenu(int r5) {
        PanelFeatureState r10 = getPanelState(r5, true);
        if (r10.menu == null) goto L8;
        Bundle r11 = new Bundle();
        r10.menu.saveActionViewStates(r11);
        if (r11.size() <= 0) goto L7;
        r10.frozenActionViewState = r11;
    L7:
        r10.menu.stopDispatchingItemsChanged();
        r10.menu.clear();
    L8:
        r10.refreshMenuContent = true;
        r10.refreshDecorView = true;
        if (r5 == 108) goto L12;
        if (r5 == 0) goto L12;
        return;
    L12:
        if (this.mDecorContentParent == null) goto L18;
        PanelFeatureState r12 = getPanelState(0, false);
        if (r12 == null) goto L19;
        r12.isPrepared = false;
        preparePanel(r12, null);
        return;
    L19:
        return;
    }

    public void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat r5 = this.mFadeAnim;
        if (r5 == null) goto L6;
        r5.cancel();
        return;
    }

    public PanelFeatureState findMenuPanel(Menu r5) {
        PanelFeatureState[] r10 = this.mPanels;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.length;
    L6:
        if (r11 >= r12) goto L13;
        PanelFeatureState r13 = r10[r11];
        if (r13 == null) goto L12;
        if (r13.menu != r5) goto L12;
        return r13;
    L12:
        r11 = r11 + 1;
        goto L6
    L13:
        return null;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public <T extends View> T findViewById(@IdRes int r5) {
        ensureSubDecor();
        return (T) this.mWindow.findViewById(r5);
    }

    public final Context getActionBarThemedContext() {
        ActionBar r5 = getSupportActionBar();
        if (r5 == null) goto L5;
        Context r10 = r5.getThemedContext();
    L6:
        if (r10 == null) goto L8;
        return r10;
    L8:
        return this.mContext;
    L5:
        r10 = null;
        goto L6
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public final AutoNightModeManager getAutoTimeNightModeManager() {
        return getAutoTimeNightModeManager(this.mContext);
    }

    public LocaleListCompat getConfigurationLocales(Configuration r5) {
        return Api24Impl.getLocales(r5);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context getContextForDelegate() {
        return this.mContext;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl(this);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater != null) goto L10;
        initWindowDecorActionBar();
        ActionBar r5 = this.mActionBar;
        if (r5 == null) goto L7;
        Context r10 = r5.getThemedContext();
    L8:
        this.mMenuInflater = new SupportMenuInflater(r10);
        goto L10
    L7:
        r10 = this.mContext;
    L10:
        return this.mMenuInflater;
    }

    public PanelFeatureState getPanelState(int r5, boolean r10) {
        PanelFeatureState[] r11 = this.mPanels;
        if (r11 != null) goto L5;
    L6:
        PanelFeatureState[] r12 = new PanelFeatureState[r5 + 1];
        if (r11 == null) goto L9;
        System.arraycopy(r11, 0, r12, 0, r11.length);
    L9:
        this.mPanels = r12;
        r11 = r12;
    L10:
        PanelFeatureState r13 = r11[r5];
        if (r13 != null) goto L14;
        PanelFeatureState r14 = new PanelFeatureState(r5);
        r11[r5] = r14;
        return r14;
    L14:
        return r13;
    L5:
        if (r11.length > r5) goto L10;
        goto L6
    }

    public ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    public final CharSequence getTitle() {
        Object r5 = this.mHost;
        if ((r5 instanceof Activity) == false) goto L7;
        return ((Activity) r5).getTitle();
    L7:
        return this.mTitle;
    }

    public final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int r5) {
        int r10 = sanitizeWindowFeatureId(r5);
        if (r10 != 1) goto L5;
        boolean r11 = this.mWindowNoTitle;
    L21:
        if (r11 == false) goto L23;
        return true;
    L23:
        if (this.mWindow.hasFeature(r5) == false) goto L26;
        return true;
    L26:
        return false;
    L5:
        if (r10 != 2) goto L7;
        r11 = this.mFeatureProgress;
        goto L21
    L7:
        if (r10 != 5) goto L9;
        r11 = this.mFeatureIndeterminateProgress;
        goto L21
    L9:
        if (r10 != 10) goto L11;
        r11 = this.mOverlayActionMode;
        goto L21
    L11:
        if (r10 != 108) goto L13;
        r11 = this.mHasActionBar;
        goto L21
    L13:
        if (r10 == 109) goto L15;
        r11 = false;
        goto L21
    L15:
        r11 = this.mOverlayActionBar;
        goto L21
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater r5 = LayoutInflater.from(this.mContext);
        if (r5.getFactory() != null) goto L6;
        LayoutInflaterCompat.setFactory2(r5, this);
        return;
    L6:
        if ((r5.getFactory2() instanceof AppCompatDelegateImpl) == true) goto L10;
        Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        if (peekSupportActionBar() != null) goto L5;
        return;
    L5:
        if (getSupportActionBar().invalidateOptionsMenu() == true) goto L10;
        invalidatePanelMenu(0);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    public int mapNightMode(@NonNull Context r5, int r10) {
        if (r10 == (-100)) goto L22;
        if (r10 == (-1)) goto L21;
        if (r10 == 0) goto L17;
        if (r10 == 1) goto L21;
        if (r10 == 2) goto L21;
        if (r10 != 3) goto L15;
        return getAutoBatteryNightModeManager(r5).getApplyableNightMode();
    L15:
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    L17:
        if (((UiModeManager) r5.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) goto L20;
        return -1;
    L20:
        return getAutoTimeNightModeManager(r5).getApplyableNightMode();
    L21:
        return r10;
    L22:
        return -1;
    }

    public boolean onBackPressed() {
        boolean r5 = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState r10 = getPanelState(0, false);
        if (r10 != null) goto L5;
    L9:
        ActionMode r11 = this.mActionMode;
        if (r11 == null) goto L13;
        r11.finish();
        return true;
    L13:
        ActionBar r12 = getSupportActionBar();
        if (r12 != null) goto L16;
    L18:
        return false;
    L16:
        if (r12.collapseActionView() == false) goto L18;
        return true;
    L5:
        if (r10.isOpen == false) goto L9;
        if (r5 == true) goto L8;
        closePanel(r10, true);
    L8:
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration r5) {
        if (this.mHasActionBar == true) goto L5;
    L9:
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        applyApplicationSpecificConfig(false, false);
        return;
    L5:
        if (this.mSubDecorInstalled == false) goto L9;
        ActionBar r10 = getSupportActionBar();
        if (r10 == null) goto L9;
        r10.onConfigurationChanged(r5);
        goto L9
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle r5) {
        this.mBaseContextAttached = true;
        applyApplicationSpecificConfig(false);
        ensureWindow();
        Object r10 = this.mHost;
        if ((r10 instanceof Activity) == true) goto L15;
    L13:
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.mCreated = true;
        return;
    L15:
        String r11 = NavUtils.getParentActivityName((Activity) r10);     // Catch: IllegalArgumentException -> L6
    L7:
        if (r11 == null) goto L12;
        ActionBar r12 = peekSupportActionBar();
        if (r12 != null) goto L11;
        this.mEnableDefaultActionBarUp = true;
        goto L12
    L11:
        r12.setDefaultDisplayHomeAsUpEnabled(true);
    L12:
        AppCompatDelegate.addActiveDelegate(this);
    L6:
        r11 = null;
        goto L7
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r5, String r10, Context r11, AttributeSet r12) {
        return createView(r5, r10, r11, r12);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onDestroy() {
        if ((this.mHost instanceof Activity) == false) goto L6;
        AppCompatDelegate.removeActivityDelegate(this);
    L6:
        if (this.mInvalidatePanelMenuPosted == false) goto L8;
        this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
    L8:
        this.mDestroyed = true;
        if (this.mLocalNightMode == (-100)) goto L15;
        Object r5 = this.mHost;
        if ((r5 instanceof Activity) == false) goto L15;
        if (((Activity) r5).isChangingConfigurations() == false) goto L15;
        sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
    L16:
        ActionBar r10 = this.mActionBar;
        if (r10 == null) goto L19;
        r10.onDestroy();
    L19:
        cleanupAutoManagers();
        return;
    L15:
        sLocalNightModes.remove(this.mHost.getClass().getName());
        goto L16
    }

    public boolean onKeyDown(int r5, KeyEvent r10) {
        boolean r11 = true;
        if (r5 == 4) goto L10;
        if (r5 != 82) goto L14;
        onKeyDownPanel(0, r10);
        return true;
    L14:
        return false;
    L10:
        if ((r10.getFlags() & 128) != 0) goto L13;
        r11 = false;
    L13:
        this.mLongPressBackDown = r11;
        goto L14
    }

    public boolean onKeyShortcut(int r5, KeyEvent r10) {
        ActionBar r11 = getSupportActionBar();
        if (r11 != null) goto L5;
    L7:
        PanelFeatureState r12 = this.mPreparedPanel;
        if (r12 == null) goto L16;
        if (performPanelShortcut(r12, r10.getKeyCode(), r10, 1) == false) goto L16;
        PanelFeatureState r13 = this.mPreparedPanel;
        if (r13 == null) goto L14;
        r13.isHandled = true;
    L14:
        return true;
    L16:
        if (this.mPreparedPanel != null) goto L20;
        PanelFeatureState r14 = getPanelState(0, true);
        preparePanel(r14, r10);
        boolean r15 = performPanelShortcut(r14, r10.getKeyCode(), r10, 1);
        r14.isPrepared = false;
        if (r15 == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (r11.onKeyShortcut(r5, r10) == false) goto L7;
        return true;
    }

    public boolean onKeyUp(int r5, KeyEvent r10) {
        if (r5 == 4) goto L10;
        if (r5 != 82) goto L12;
        onKeyUpPanel(0, r10);
        return true;
    L12:
        return false;
    L10:
        if (onBackPressed() == false) goto L12;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder r5, @NonNull MenuItem r10) {
        Window.Callback r11 = getWindowCallback();
        if (r11 != null) goto L5;
        return false;
    L5:
        if (this.mDestroyed == true) goto L12;
        PanelFeatureState r12 = findMenuPanel(r5.getRootMenu());
        if (r12 != null) goto L9;
        return false;
    L9:
        return r11.onMenuItemSelected(r12.featureId, r10);
    L12:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(@NonNull MenuBuilder r5) {
        reopenMenu(true);
    }

    public void onMenuOpened(int r5) {
        if (r5 != 108) goto L8;
        ActionBar r10 = getSupportActionBar();
        if (r10 == null) goto L9;
        r10.dispatchMenuVisibilityChanged(true);
        return;
    L9:
        return;
    }

    public void onPanelClosed(int r5) {
        if (r5 != 108) goto L7;
        ActionBar r10 = getSupportActionBar();
        if (r10 == null) goto L12;
        r10.dispatchMenuVisibilityChanged(false);
        return;
    L12:
        return;
    L7:
        if (r5 != 0) goto L14;
        PanelFeatureState r11 = getPanelState(r5, true);
        if (r11.isOpen == false) goto L15;
        closePanel(r11, false);
        return;
    L15:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle r5) {
        ensureSubDecor();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        ActionBar r5 = getSupportActionBar();
        if (r5 == null) goto L6;
        r5.setShowHideAnimationEnabled(true);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle r5) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        applyApplicationSpecificConfig(true, false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        ActionBar r5 = getSupportActionBar();
        if (r5 == null) goto L6;
        r5.setShowHideAnimationEnabled(false);
        return;
    }

    public void onSubDecorInstalled(ViewGroup r5) {
    }

    public final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int r5) {
        int r10 = sanitizeWindowFeatureId(r5);
        if (this.mWindowNoTitle == false) goto L7;
        if (r10 != 108) goto L7;
        return false;
    L7:
        if (this.mHasActionBar == false) goto L10;
        if (r10 != 1) goto L10;
        this.mHasActionBar = false;
    L10:
        if (r10 != 1) goto L12;
        throwFeatureRequestIfSubDecorInstalled();
        this.mWindowNoTitle = true;
        return true;
    L12:
        if (r10 != 2) goto L14;
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureProgress = true;
        return true;
    L14:
        if (r10 != 5) goto L16;
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureIndeterminateProgress = true;
        return true;
    L16:
        if (r10 == 10) goto L26;
        if (r10 != 108) goto L19;
        throwFeatureRequestIfSubDecorInstalled();
        this.mHasActionBar = true;
        return true;
    L19:
        if (r10 != 109) goto L21;
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    L21:
        return this.mWindow.requestFeature(r10);
    L26:
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionMode = true;
        return true;
    }

    public void setConfigurationLocales(Configuration r5, @NonNull LocaleListCompat r10) {
        Api24Impl.setLocales(r5, r10);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View r5) {
        ensureSubDecor();
        ViewGroup r10 = (ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        r10.removeAllViews();
        r10.addView(r5);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    public void setDefaultLocalesForLocaleList(LocaleListCompat r5) {
        Api24Impl.setDefaultLocales(r5);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean r5) {
        this.mHandleNativeActionModes = r5;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @RequiresApi(17)
    public void setLocalNightMode(int r5) {
        if (this.mLocalNightMode == r5) goto L8;
        this.mLocalNightMode = r5;
        if (this.mBaseContextAttached == false) goto L9;
        applyDayNight();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @RequiresApi(33)
    public void setOnBackInvokedDispatcher(@Nullable OnBackInvokedDispatcher r5) {
        super.setOnBackInvokedDispatcher(r5);
        OnBackInvokedDispatcher r10 = this.mDispatcher;
        if (r10 == null) goto L7;
        OnBackInvokedCallback r11 = this.mBackCallback;
        if (r11 == null) goto L7;
        Api33Impl.unregisterOnBackInvokedCallback(r10, r11);
        this.mBackCallback = null;
    L7:
        if (r5 != null) goto L13;
        Object r12 = this.mHost;
        if ((r12 instanceof Activity) == false) goto L13;
        if (((Activity) r12).getWindow() == null) goto L13;
        this.mDispatcher = Api33Impl.getOnBackInvokedDispatcher((Activity) this.mHost);
    L14:
        updateBackInvokedCallbackState();
        return;
    L13:
        this.mDispatcher = r5;
        goto L14
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar r5) {
        if ((this.mHost instanceof Activity) == true) goto L5;
        return;
    L5:
        ActionBar r10 = getSupportActionBar();
        if ((r10 instanceof WindowDecorActionBar) == true) goto L17;
        this.mMenuInflater = null;
        if (r10 == null) goto L10;
        r10.onDestroy();
    L10:
        this.mActionBar = null;
        if (r5 == null) goto L13;
        ToolbarActionBar r11 = new ToolbarActionBar(r5, getTitle(), this.mAppCompatWindowCallback);
        this.mActionBar = r11;
        this.mAppCompatWindowCallback.setActionBarCallback(r11.mMenuCallback);
        r5.setBackInvokedCallbackEnabled(true);
    L14:
        invalidateOptionsMenu();
        return;
    L13:
        this.mAppCompatWindowCallback.setActionBarCallback(null);
        goto L14
    L17:
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTheme(@StyleRes int r5) {
        this.mThemeResId = r5;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence r5) {
        this.mTitle = r5;
        DecorContentParent r10 = this.mDecorContentParent;
        if (r10 == null) goto L6;
        r10.setWindowTitle(r5);
        return;
    L6:
        if (peekSupportActionBar() == null) goto L8;
        peekSupportActionBar().setWindowTitle(r5);
        return;
    L8:
        TextView r11 = this.mTitleView;
        if (r11 == null) goto L14;
        r11.setText(r5);
        return;
    }

    public final boolean shouldAnimateActionModeView() {
        if (this.mSubDecorInstalled == false) goto L9;
        ViewGroup r5 = this.mSubDecor;
        if (r5 == null) goto L9;
        if (ViewCompat.isLaidOut(r5) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean shouldRegisterBackInvokedCallback() {
        if (this.mDispatcher != null) goto L5;
        return false;
    L5:
        PanelFeatureState r5 = getPanelState(0, false);
        if (r5 == null) goto L11;
        if (r5.isOpen == false) goto L11;
        return true;
    L11:
        if (this.mActionMode == null) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback r5) {
        if (r5 == null) goto L19;
        ActionMode r10 = this.mActionMode;
        if (r10 == null) goto L6;
        r10.finish();
    L6:
        ActionModeCallbackWrapperV9 r11 = new ActionModeCallbackWrapperV9(this, r5);
        ActionBar r12 = getSupportActionBar();
        if (r12 == null) goto L14;
        ActionMode r13 = r12.startActionMode(r11);
        this.mActionMode = r13;
        if (r13 == null) goto L14;
        AppCompatCallback r14 = this.mAppCompatCallback;
        if (r14 == null) goto L14;
        r14.onSupportActionModeStarted(r13);
    L14:
        if (this.mActionMode != null) goto L16;
        this.mActionMode = startSupportActionModeFromWindow(r11);
    L16:
        updateBackInvokedCallbackState();
        return this.mActionMode;
    L19:
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public ActionMode startSupportActionModeFromWindow(@NonNull ActionMode.Callback r10) {
        endOnGoingFadeAnimation();
        ActionMode r5 = this.mActionMode;
        if (r5 == null) goto L6;
        r5.finish();
    L6:
        if ((r10 instanceof ActionModeCallbackWrapperV9) == true) goto L8;
        r10 = new ActionModeCallbackWrapperV9(this, r10);
    L8:
        AppCompatCallback r11 = this.mAppCompatCallback;
        if (r11 != null) goto L11;
    L14:
        ActionMode r12 = null;
    L15:
        if (r12 == null) goto L17;
        this.mActionMode = r12;
    L47:
        ActionMode r13 = this.mActionMode;
        if (r13 == null) goto L52;
        AppCompatCallback r14 = this.mAppCompatCallback;
        if (r14 == null) goto L52;
        r14.onSupportActionModeStarted(r13);
    L52:
        updateBackInvokedCallbackState();
        return this.mActionMode;
    L17:
        boolean r15 = true;
        if (this.mActionModeView != null) goto L30;
        if (this.mIsFloating == false) goto L26;
        TypedValue r16 = new TypedValue();
        Resources.Theme r17 = this.mContext.getTheme();
        r17.resolveAttribute(R.attr.actionBarTheme, r16, true);
        if (r16.resourceId == 0) goto L24;
        Resources.Theme r18 = this.mContext.getResources().newTheme();
        r18.setTo(r17);
        r18.applyStyle(r16.resourceId, true);
        Context r19 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, 0);
        r19.getTheme().setTo(r18);
    L25:
        this.mActionModeView = new ActionBarContextView(r19);
        PopupWindow r20 = new PopupWindow(r19, null, R.attr.actionModePopupWindowStyle);
        this.mActionModePopup = r20;
        PopupWindowCompat.setWindowLayoutType(r20, 2);
        this.mActionModePopup.setContentView(this.mActionModeView);
        this.mActionModePopup.setWidth(-1);
        r19.getTheme().resolveAttribute(R.attr.actionBarSize, r16, true);
        this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(r16.data, r19.getResources().getDisplayMetrics()));
        this.mActionModePopup.setHeight(-2);
        this.mShowActionModePopup = new AnonymousClass6(this);
        goto L30
    L24:
        r19 = this.mContext;
        goto L25
    L26:
        ViewStubCompat r21 = (ViewStubCompat) this.mSubDecor.findViewById(R.id.action_mode_bar_stub);
        if (r21 == null) goto L30;
        r21.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
        this.mActionModeView = (ActionBarContextView) r21.inflate();
    L30:
        if (this.mActionModeView == null) goto L47;
        endOnGoingFadeAnimation();
        this.mActionModeView.killMode();
        Context r22 = this.mActionModeView.getContext();
        ActionBarContextView r23 = this.mActionModeView;
        if (this.mActionModePopup == null) goto L35;
        r15 = false;
    L35:
        StandaloneActionMode r24 = new StandaloneActionMode(r22, r23, r10, r15);
        if (r10.onCreateActionMode(r24, r24.getMenu()) == false) goto L46;
        r24.invalidate();
        this.mActionModeView.initForMode(r24);
        this.mActionMode = r24;
        if (shouldAnimateActionModeView() == false) goto L40;
        this.mActionModeView.setAlpha(0.0f);
        ViewPropertyAnimatorCompat r25 = ViewCompat.animate(this.mActionModeView).alpha(1.0f);
        this.mFadeAnim = r25;
        r25.setListener(new AnonymousClass7(this));
    L44:
        if (this.mActionModePopup == null) goto L47;
        this.mWindow.getDecorView().post(this.mShowActionModePopup);
        goto L47
    L40:
        this.mActionModeView.setAlpha(1.0f);
        this.mActionModeView.setVisibility(0);
        if ((this.mActionModeView.getParent() instanceof View) == false) goto L44;
        ViewCompat.requestApplyInsets((View) this.mActionModeView.getParent());
        goto L44
    L46:
        this.mActionMode = null;
        goto L47
    L11:
        if (this.mDestroyed == true) goto L14;
        r12 = r11.onWindowStartingSupportActionMode(r10);     // Catch: AbstractMethodError -> L54
        goto L15
    }

    public void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT < 33) goto L14;
        boolean r5 = shouldRegisterBackInvokedCallback();
        if (r5 == true) goto L7;
    L9:
        if (r5 == true) goto L16;
        OnBackInvokedCallback r10 = this.mBackCallback;
        if (r10 == null) goto L17;
        Api33Impl.unregisterOnBackInvokedCallback(this.mDispatcher, r10);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (this.mBackCallback != null) goto L9;
        this.mBackCallback = Api33Impl.registerOnBackPressedCallback(this.mDispatcher, this);
        return;
    }

    public final int updateStatusGuard(@Nullable WindowInsetsCompat r11, @Nullable Rect r12) {
        int r5 = 0;
        if (r11 == null) goto L5;
        int r10 = r11.getSystemWindowInsetTop();
    L8:
        ActionBarContextView r13 = this.mActionModeView;
        if (r13 != null) goto L11;
    L69:
        boolean r14 = false;
    L70:
        View r15 = this.mStatusGuard;
        if (r15 == null) goto L76;
        if (r14 == true) goto L75;
        r5 = 8;
    L75:
        r15.setVisibility(r5);
    L76:
        return r10;
    L11:
        if ((r13.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L69;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
        boolean r17 = true;
        if (this.mActionModeView.isShown() == false) goto L64;
        if (this.mTempRect1 != null) goto L17;
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
    L17:
        Rect r18 = this.mTempRect1;
        Rect r19 = this.mTempRect2;
        if (r11 != null) goto L20;
        r18.set(r12);
    L21:
        ViewUtils.computeFitSystemWindows(this.mSubDecor, r18, r19);
        int r110 = r18.top;
        int r111 = r18.left;
        int r20 = r18.right;
        WindowInsetsCompat r21 = ViewCompat.getRootWindowInsets(this.mSubDecor);
        if (r21 != null) goto L24;
        int r22 = 0;
    L25:
        if (r21 != null) goto L27;
        int r23 = 0;
    L29:
        if (r16.topMargin == r110) goto L31;
    L36:
        r16.topMargin = r110;
        r16.leftMargin = r111;
        r16.rightMargin = r20;
        boolean r112 = true;
    L37:
        if (r110 > 0) goto L39;
    L41:
        View r113 = this.mStatusGuard;
        if (r113 == null) goto L50;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113.getLayoutParams();
        int r24 = r114.height;
        int r25 = r16.topMargin;
        if (r24 == r25) goto L46;
    L49:
        r114.height = r25;
        r114.leftMargin = r22;
        r114.rightMargin = r23;
        this.mStatusGuard.setLayoutParams(r114);
        goto L50
    L46:
        if (r114.leftMargin != r22) goto L49;
        if (r114.rightMargin != r23) goto L49;
    L50:
        View r115 = this.mStatusGuard;
        if (r115 != null) goto L54;
        r17 = false;
    L54:
        if (r17 == false) goto L59;
        if (r115.getVisibility() == 0) goto L59;
        updateStatusGuardColor(this.mStatusGuard);
    L59:
        if (this.mOverlayActionMode == true) goto L62;
        if (r17 == false) goto L62;
        r10 = 0;
    L62:
        r14 = r17;
        r17 = r112;
    L67:
        if (r17 == false) goto L70;
        this.mActionModeView.setLayoutParams(r16);
        goto L70
    L39:
        if (this.mStatusGuard != null) goto L41;
        View r116 = new View(this.mContext);
        this.mStatusGuard = r116;
        r116.setVisibility(8);
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-1, r16.topMargin, 51);
        r117.leftMargin = r22;
        r117.rightMargin = r23;
        this.mSubDecor.addView(this.mStatusGuard, -1, r117);
        goto L50
    L31:
        if (r16.leftMargin != r111) goto L36;
        if (r16.rightMargin != r20) goto L36;
        r112 = false;
        goto L37
    L27:
        r23 = r21.getSystemWindowInsetRight();
        goto L29
    L24:
        r22 = r21.getSystemWindowInsetLeft();
        goto L25
    L20:
        r18.set(r11.getSystemWindowInsetLeft(), r11.getSystemWindowInsetTop(), r11.getSystemWindowInsetRight(), r11.getSystemWindowInsetBottom());
        goto L21
    L64:
        if (r16.topMargin == 0) goto L66;
        r16.topMargin = 0;
        r14 = false;
        goto L67
    L66:
        r14 = false;
        r17 = false;
        goto L67
    L5:
        if (r12 == null) goto L7;
        r10 = r12.top;
        goto L8
    L7:
        r10 = 0;
        goto L8
    }

    public AppCompatDelegateImpl(Dialog r5, AppCompatCallback r10) {
        this(r5.getContext(), r5.getWindow(), r10, r5);
    }

    private boolean applyApplicationSpecificConfig(boolean r5, boolean r10) {
        if (this.mDestroyed == false) goto L6;
        return false;
    L6:
        int r11 = calculateNightMode();
        int r12 = mapNightMode(this.mContext, r11);
        if (Build.VERSION.SDK_INT >= 33) goto L9;
        LocaleListCompat r13 = calculateApplicationLocales(this.mContext);
    L10:
        if (r10 == true) goto L13;
        if (r13 == null) goto L13;
        r13 = getConfigurationLocales(this.mContext.getResources().getConfiguration());
    L13:
        boolean r14 = updateAppConfiguration(r12, r13, r5);
        if (r11 != 0) goto L16;
        getAutoTimeNightModeManager(this.mContext).setup();
    L20:
        if (r11 != 3) goto L22;
        getAutoBatteryNightModeManager(this.mContext).setup();
    L25:
        return r14;
    L22:
        AutoNightModeManager r15 = this.mAutoBatteryNightModeManager;
        if (r15 == null) goto L25;
        r15.cleanup();
        goto L25
    L16:
        AutoNightModeManager r16 = this.mAutoTimeNightModeManager;
        if (r16 == null) goto L20;
        r16.cleanup();
        goto L20
    L9:
        r13 = null;
        goto L10
    }

    private AutoNightModeManager getAutoTimeNightModeManager(@NonNull Context r5) {
        if (this.mAutoTimeNightModeManager != null) goto L6;
        this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(this, TwilightManager.getInstance(r5));
    L6:
        return this.mAutoTimeNightModeManager;
    }

    public void closePanel(PanelFeatureState r5, boolean r10) {
        if (r10 == true) goto L4;
    L11:
        WindowManager r11 = (WindowManager) this.mContext.getSystemService("window");
        if (r11 != null) goto L14;
    L20:
        r5.isPrepared = false;
        r5.isHandled = false;
        r5.isOpen = false;
        r5.shownPanelView = null;
        r5.refreshDecorView = true;
        if (this.mPreparedPanel != r5) goto L24;
        this.mPreparedPanel = null;
    L24:
        if (r5.featureId != 0) goto L27;
        updateBackInvokedCallbackState();
        return;
    L27:
        return;
    L14:
        if (r5.isOpen == false) goto L20;
        ViewGroup r12 = r5.decorView;
        if (r12 == null) goto L20;
        r11.removeView(r12);
        if (r10 == false) goto L20;
        callOnPanelClosed(r5.featureId, r5, null);
        goto L20
    L4:
        if (r5.featureId != 0) goto L11;
        DecorContentParent r13 = this.mDecorContentParent;
        if (r13 == null) goto L11;
        if (r13.isOverflowMenuShowing() == false) goto L11;
        checkCloseActionMenu(r5.menu);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r5, Context r10, AttributeSet r11) {
        return onCreateView(null, r5, r10, r11);
    }

    public AppCompatDelegateImpl(Context r5, Window r10, AppCompatCallback r11) {
        this(r5, r10, r11, r5);
    }

    public AppCompatDelegateImpl(Context r5, Activity r10, AppCompatCallback r11) {
        this(r5, null, r11, r10);
    }

    private AppCompatDelegateImpl(Context r5, Window r10, AppCompatCallback r11, Object r12) {
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        this.mLocalNightMode = -100;
        this.mInvalidatePanelMenuRunnable = new AnonymousClass2(this);
        this.mContext = r5;
        this.mAppCompatCallback = r11;
        this.mHost = r12;
        if (this.mLocalNightMode != (-100)) goto L10;
        if ((r12 instanceof Dialog) == false) goto L10;
        AppCompatActivity r13 = tryUnwrapContext();
        if (r13 == null) goto L10;
        this.mLocalNightMode = r13.getDelegate().getLocalNightMode();
    L10:
        if (this.mLocalNightMode != (-100)) goto L14;
        SimpleArrayMap<String, Integer> r14 = sLocalNightModes;
        Integer r15 = r14.get(r12.getClass().getName());
        if (r15 == null) goto L14;
        this.mLocalNightMode = r15.intValue();
        r14.remove(r12.getClass().getName());
    L14:
        if (r10 == null) goto L16;
        attachToWindow(r10);
    L16:
        AppCompatDrawableManager.preload();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int r5) {
        ensureSubDecor();
        ViewGroup r10 = (ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        r10.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(r5, r10);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View r5, ViewGroup.LayoutParams r10) {
        ensureSubDecor();
        ViewGroup r11 = (ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        r11.removeAllViews();
        r11.addView(r5, r10);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }
}
