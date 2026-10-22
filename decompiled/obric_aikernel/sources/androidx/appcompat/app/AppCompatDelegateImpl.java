package androidx.appcompat.app;

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
import androidx.core.util.ObjectsCompat;
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

    private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        ActionBarDrawableToggleImpl(AppCompatDelegateImpl r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.this$0.getActionBarThemedContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TintTypedArray r10 = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[]{R.attr.homeAsUpIndicator});
            Drawable r11 = r10.getDrawable(0);
            r10.recycle();
            return r11;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            ActionBar r10 = this.this$0.getSupportActionBar();
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if ((r10.getDisplayOptions() & 4) == 0) goto L7;
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r10) {
            ActionBar r11 = this.this$0.getSupportActionBar();
            if (r11 == null) goto L6;
            r11.setHomeActionContentDescription(r10);
            return;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r10, int r11) {
            ActionBar r12 = this.this$0.getSupportActionBar();
            if (r12 == null) goto L6;
            r12.setHomeAsUpIndicator(r10);
            r12.setHomeActionContentDescription(r11);
            return;
        }
    }

    interface ActionBarMenuCallback {
        @Nullable
        View onCreatePanelView(int r10);

        boolean onPreparePanel(int r10);
    }

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        ActionMenuPresenterCallback(AppCompatDelegateImpl r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r10, boolean r11) {
            this.this$0.checkCloseActionMenu(r10);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r10) {
            Window.Callback r11 = this.this$0.getWindowCallback();
            if (r11 == null) goto L7;
            r11.onMenuOpened(108, r10);
            return true;
        L7:
            return true;
        }
    }

    class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionModeCallbackWrapperV9(AppCompatDelegateImpl r10, ActionMode.Callback r11) {
            this.this$0 = r10;
            this.mWrapped = r11;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r10, MenuItem r11) {
            return this.mWrapped.onActionItemClicked(r10, r11);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r10, Menu r11) {
            return this.mWrapped.onCreateActionMode(r10, r11);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r10) {
            this.mWrapped.onDestroyActionMode(r10);
            AppCompatDelegateImpl r11 = this.this$0;
            if (r11.mActionModePopup == null) goto L5;
            r11.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
        L5:
            AppCompatDelegateImpl r12 = this.this$0;
            if (r12.mActionModeView == null) goto L8;
            r12.endOnGoingFadeAnimation();
            AppCompatDelegateImpl r13 = this.this$0;
            r13.mFadeAnim = ViewCompat.animate(r13.mActionModeView).alpha(0.0f);
            this.this$0.mFadeAnim.setListener(new AnonymousClass1(this));
        L8:
            AppCompatDelegateImpl r14 = this.this$0;
            AppCompatCallback r15 = r14.mAppCompatCallback;
            if (r15 == null) goto L11;
            r15.onSupportActionModeFinished(r14.mActionMode);
        L11:
            AppCompatDelegateImpl r16 = this.this$0;
            r16.mActionMode = null;
            ViewCompat.requestApplyInsets(r16.mSubDecor);
            this.this$0.updateBackInvokedCallbackState();
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r10, Menu r11) {
            ViewCompat.requestApplyInsets(this.this$0.mSubDecor);
            return this.mWrapped.onPrepareActionMode(r10, r11);
        }
    }

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        static Context createConfigurationContext(@NonNull Context r10, @NonNull Configuration r11) {
            return r10.createConfigurationContext(r11);
        }

        static void generateConfigDelta_densityDpi(@NonNull Configuration r10, @NonNull Configuration r11, @NonNull Configuration r12) {
            int r13 = r10.densityDpi;
            int r14 = r11.densityDpi;
            if (r13 == r14) goto L6;
            r12.densityDpi = r14;
            return;
        }

        @DoNotInline
        static void setLayoutDirection(Configuration r10, Locale r11) {
            r10.setLayoutDirection(r11);
        }

        @DoNotInline
        static void setLocale(Configuration r10, Locale r11) {
            r10.setLocale(r11);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean isPowerSaveMode(PowerManager r10) {
            return r10.isPowerSaveMode();
        }

        @DoNotInline
        static String toLanguageTag(Locale r10) {
            return r10.toLanguageTag();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void generateConfigDelta_locale(@NonNull Configuration r10, @NonNull Configuration r11, @NonNull Configuration r12) {
            LocaleList r13 = r10.getLocales();
            LocaleList r14 = r11.getLocales();
            if (r13.equals(r14) == true) goto L6;
            r12.setLocales(r14);
            r12.locale = r11.locale;
            return;
        }

        @DoNotInline
        static LocaleListCompat getLocales(Configuration r10) {
            return LocaleListCompat.forLanguageTags(r10.getLocales().toLanguageTags());
        }

        @DoNotInline
        public static void setDefaultLocales(LocaleListCompat r10) {
            LocaleList.setDefault(LocaleList.forLanguageTags(r10.toLanguageTags()));
        }

        @DoNotInline
        static void setLocales(Configuration r10, LocaleListCompat r11) {
            r10.setLocales(LocaleList.forLanguageTags(r11.toLanguageTags()));
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        static void generateConfigDelta_colorMode(@NonNull Configuration r10, @NonNull Configuration r11, @NonNull Configuration r12) {
            int r13 = r10.colorMode & 3;
            int r14 = r11.colorMode;
            if (r13 == (r14 & 3)) goto L5;
            r12.colorMode |= r14 & 3;
        L5:
            int r15 = r10.colorMode & 12;
            int r16 = r11.colorMode;
            if (r15 == (r16 & 12)) goto L9;
            r12.colorMode |= r16 & 12;
            return;
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity r10) {
            return r10.getOnBackInvokedDispatcher();
        }

        @DoNotInline
        static OnBackInvokedCallback registerOnBackPressedCallback(Object r10, final AppCompatDelegateImpl r11) {
            Objects.requireNonNull(r11);
            OnBackInvokedCallback r12 = new c(r11);
            ((OnBackInvokedDispatcher) r10).registerOnBackInvokedCallback(1000000, r12);
            return r12;
        }

        @DoNotInline
        static void unregisterOnBackInvokedCallback(Object r10, Object r11) {
            OnBackInvokedDispatcher r12 = (OnBackInvokedDispatcher) r10;
            r12.unregisterOnBackInvokedCallback((OnBackInvokedCallback) r11);
        }
    }

    class AppCompatWindowCallback extends WindowCallbackWrapper {
        private ActionBarMenuCallback mActionBarCallback;
        private boolean mDispatchKeyEventBypassEnabled;
        private boolean mOnContentChangedBypassEnabled;
        private boolean mOnPanelClosedBypassEnabled;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        AppCompatWindowCallback(AppCompatDelegateImpl r10, Window.Callback r11) {
            this.this$0 = r10;
            super(r11);
        }

        public boolean bypassDispatchKeyEvent(Window.Callback r10, KeyEvent r11) {
            this.mDispatchKeyEventBypassEnabled = true;     // Catch: Throwable -> L6
            boolean r12 = r10.dispatchKeyEvent(r11);     // Catch: Throwable -> L6
            this.mDispatchKeyEventBypassEnabled = false;
            return r12;
        L6:
            th = move-exception;
            this.mDispatchKeyEventBypassEnabled = false;
            throw th;
        }

        public void bypassOnContentChanged(Window.Callback r10) {
            this.mOnContentChangedBypassEnabled = true;     // Catch: Throwable -> L6
            r10.onContentChanged();     // Catch: Throwable -> L6
            this.mOnContentChangedBypassEnabled = false;
            return;
        L6:
            th = move-exception;
            this.mOnContentChangedBypassEnabled = false;
            throw th;
        }

        public void bypassOnPanelClosed(Window.Callback r10, int r11, Menu r12) {
            this.mOnPanelClosedBypassEnabled = true;     // Catch: Throwable -> L6
            r10.onPanelClosed(r11, r12);     // Catch: Throwable -> L6
            this.mOnPanelClosedBypassEnabled = false;
            return;
        L6:
            th = move-exception;
            this.mOnPanelClosedBypassEnabled = false;
            throw th;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r10) {
            if (this.mDispatchKeyEventBypassEnabled == false) goto L7;
            return getWrapped().dispatchKeyEvent(r10);
        L7:
            if (this.this$0.dispatchKeyEvent(r10) == false) goto L9;
        L12:
            return true;
        L9:
            if (super.dispatchKeyEvent(r10) == true) goto L12;
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent r10) {
            if (super.dispatchKeyShortcutEvent(r10) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.this$0.onKeyShortcut(r10.getKeyCode(), r10) == true) goto L8;
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
            if (this.mOnContentChangedBypassEnabled == false) goto L6;
            getWrapped().onContentChanged();
            return;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int r10, Menu r11) {
            if (r10 != 0) goto L8;
            if ((r11 instanceof MenuBuilder) == true) goto L8;
            return false;
        L8:
            return super.onCreatePanelMenu(r10, r11);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int r10) {
            ActionBarMenuCallback r11 = this.mActionBarCallback;
            if (r11 == null) goto L8;
            View r12 = r11.onCreatePanelView(r10);
            if (r12 == null) goto L8;
            return r12;
        L8:
            return super.onCreatePanelView(r10);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int r10, Menu r11) {
            super.onMenuOpened(r10, r11);
            this.this$0.onMenuOpened(r10);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int r10, Menu r11) {
            if (this.mOnPanelClosedBypassEnabled == false) goto L6;
            getWrapped().onPanelClosed(r10, r11);
            return;
        L6:
            super.onPanelClosed(r10, r11);
            this.this$0.onPanelClosed(r10);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int r10, View r11, Menu r12) {
            if ((r12 instanceof MenuBuilder) == false) goto L5;
            MenuBuilder r13 = (MenuBuilder) r12;
        L7:
            if (r10 != 0) goto L10;
            if (r13 != null) goto L10;
            return false;
        L10:
            boolean r14 = true;
            if (r13 == null) goto L13;
            r13.setOverrideVisibleItems(true);
        L13:
            ActionBarMenuCallback r15 = this.mActionBarCallback;
            if (r15 != null) goto L16;
        L18:
            r14 = false;
        L19:
            if (r14 == true) goto L21;
            r14 = super.onPreparePanel(r10, r11, r12);
        L21:
            if (r13 == null) goto L23;
            r13.setOverrideVisibleItems(false);
        L23:
            return r14;
        L16:
            if (r15.onPreparePanel(r10) == false) goto L18;
        L5:
            r13 = null;
            goto L7
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r10, Menu r11, int r12) {
            PanelFeatureState r13 = this.this$0.getPanelState(0, true);
            if (r13 == null) goto L7;
            MenuBuilder r14 = r13.menu;
            if (r14 == null) goto L7;
            super.onProvideKeyboardShortcuts(r10, r14, r12);
            return;
        L7:
            super.onProvideKeyboardShortcuts(r10, r11, r12);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r10) {
            if (Build.VERSION.SDK_INT < 23) goto L7;
            return null;
        L7:
            if (this.this$0.isHandleNativeActionModesEnabled() == false) goto L11;
            return startAsSupportActionMode(r10);
        L11:
            return super.onWindowStartingActionMode(r10);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(23)
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r10, int r11) {
            if (this.this$0.isHandleNativeActionModesEnabled() == false) goto L9;
            if (r11 != 0) goto L9;
            return startAsSupportActionMode(r10);
        L9:
            return super.onWindowStartingActionMode(r10, r11);
        }

        void setActionBarCallback(@Nullable ActionBarMenuCallback r10) {
            this.mActionBarCallback = r10;
        }

        final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback r10) {
            SupportActionModeWrapper.CallbackWrapper r11 = new SupportActionModeWrapper.CallbackWrapper(this.this$0.mContext, r10);
            ActionMode r12 = this.this$0.startSupportActionMode(r11);
            if (r12 != null) goto L5;
            return null;
        L5:
            return r11.getActionModeWrapper(r12);
        }
    }

    private class AutoBatteryNightModeManager extends AutoNightModeManager {
        private final PowerManager mPowerManager;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        AutoBatteryNightModeManager(@NonNull AppCompatDelegateImpl r10, Context r11) {
            this.this$0 = r10;
            super(r10);
            this.mPowerManager = (PowerManager) r11.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter createIntentFilterForBroadcastReceiver() {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            IntentFilter r10 = new IntentFilter();
            r10.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return r10;
        L6:
            return null;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return 1;
        L5:
            if (Api21Impl.isPowerSaveMode(this.mPowerManager) == false) goto L9;
            return 2;
        L9:
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            this.this$0.applyDayNight();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    abstract class AutoNightModeManager {
        private BroadcastReceiver mReceiver;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        AutoNightModeManager(AppCompatDelegateImpl r10) {
            this.this$0 = r10;
        }

        void cleanup() {
            BroadcastReceiver r10 = this.mReceiver;
            if (r10 == null) goto L10;
            this.this$0.mContext.unregisterReceiver(r10);     // Catch: IllegalArgumentException -> L7
        L5:
            this.mReceiver = null;
            return;
        }

        @Nullable
        abstract IntentFilter createIntentFilterForBroadcastReceiver();

        abstract int getApplyableNightMode();

        boolean isListening() {
            if (this.mReceiver == null) goto L5;
            return true;
        L5:
            return false;
        }

        abstract void onChange();

        void setup() {
            cleanup();
            IntentFilter r10 = createIntentFilterForBroadcastReceiver();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.countActions() != 0) goto L8;
            return;
        L8:
            if (this.mReceiver != null) goto L10;
            this.mReceiver = new AnonymousClass1(this);
        L10:
            this.this$0.mContext.registerReceiver(this.mReceiver, r10);
        }
    }

    private class AutoTimeNightModeManager extends AutoNightModeManager {
        private final TwilightManager mTwilightManager;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        AutoTimeNightModeManager(@NonNull AppCompatDelegateImpl r10, TwilightManager r11) {
            this.this$0 = r10;
            super(r10);
            this.mTwilightManager = r11;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter r10 = new IntentFilter();
            r10.addAction("android.intent.action.TIME_SET");
            r10.addAction("android.intent.action.TIMEZONE_CHANGED");
            r10.addAction("android.intent.action.TIME_TICK");
            return r10;
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
    private static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        static void applyOverrideConfiguration(ContextThemeWrapper r10, Configuration r11) {
            r10.applyOverrideConfiguration(r11);
        }
    }

    private class ListMenuDecorView extends ContentFrameLayout {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ListMenuDecorView(AppCompatDelegateImpl r10, Context r11) {
            this.this$0 = r10;
            super(r11);
        }

        private boolean isOutOfBounds(int r10, int r11) {
            if (r10 < (-5)) goto L11;
            if (r11 < (-5)) goto L11;
            if (r10 > (getWidth() + 5)) goto L11;
            if (r11 > (getHeight() + 5)) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent r10) {
            if (this.this$0.dispatchKeyEvent(r10) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.dispatchKeyEvent(r10) == true) goto L8;
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r10) {
            if (r10.getAction() != 0) goto L9;
            if (isOutOfBounds((int) r10.getX(), (int) r10.getY()) == false) goto L9;
            this.this$0.closePanel(0);
            return true;
        L9:
            return super.onInterceptTouchEvent(r10);
        }

        @Override // android.view.View
        public void setBackgroundResource(int r10) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), r10));
        }
    }

    protected static final class PanelFeatureState {
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
        int f220x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int f221y;

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            int featureId;
            boolean isOpen;
            Bundle menuState;

            static {
                CREATOR = new AnonymousClass1();
            }

            SavedState() {
            }

            static SavedState readFromParcel(Parcel r10, ClassLoader r11) {
                SavedState r12 = new SavedState();
                r12.featureId = r10.readInt();
                boolean r13 = true;
                if (r10.readInt() == 1) goto L6;
                r13 = false;
            L6:
                r12.isOpen = r13;
                if (r13 == false) goto L9;
                r12.menuState = r10.readBundle(r11);
            L9:
                return r12;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r10, int r11) {
                r10.writeInt(this.featureId);
                r10.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen == false) goto L6;
                r10.writeBundle(this.menuState);
                return;
            }
        }

        PanelFeatureState(int r10) {
            this.featureId = r10;
            this.refreshDecorView = false;
        }

        void applyFrozenState() {
            MenuBuilder r10 = this.menu;
            if (r10 == null) goto L8;
            Bundle r11 = this.frozenMenuState;
            if (r11 == null) goto L9;
            r10.restorePresenterStates(r11);
            this.frozenMenuState = null;
            return;
        L9:
            return;
        }

        public void clearMenuPresenters() {
            MenuBuilder r10 = this.menu;
            if (r10 == null) goto L5;
            r10.removeMenuPresenter(this.listMenuPresenter);
        L5:
            this.listMenuPresenter = null;
        }

        MenuView getListMenuView(MenuPresenter.Callback r10) {
            if (this.menu != null) goto L7;
            return null;
        L7:
            if (this.listMenuPresenter != null) goto L10;
            ListMenuPresenter r11 = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
            this.listMenuPresenter = r11;
            r11.setCallback(r10);
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

        void onRestoreInstanceState(Parcelable r10) {
            SavedState r11 = (SavedState) r10;
            this.featureId = r11.featureId;
            this.wasLastOpen = r11.isOpen;
            this.frozenMenuState = r11.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        Parcelable onSaveInstanceState() {
            SavedState r10 = new SavedState();
            r10.featureId = this.featureId;
            r10.isOpen = this.isOpen;
            if (this.menu == null) goto L5;
            Bundle r11 = new Bundle();
            r10.menuState = r11;
            this.menu.savePresenterStates(r11);
        L5:
            return r10;
        }

        void setMenu(MenuBuilder r10) {
            MenuBuilder r11 = this.menu;
            if (r10 != r11) goto L5;
            return;
        L5:
            if (r11 == null) goto L7;
            r11.removeMenuPresenter(this.listMenuPresenter);
        L7:
            this.menu = r10;
            if (r10 == null) goto L13;
            ListMenuPresenter r12 = this.listMenuPresenter;
            if (r12 == null) goto L14;
            r10.addMenuPresenter(r12);
            return;
        L14:
            return;
        }

        void setStyle(Context r10) {
            TypedValue r11 = new TypedValue();
            Resources.Theme r12 = r10.getResources().newTheme();
            r12.setTo(r10.getTheme());
            r12.resolveAttribute(R.attr.actionBarPopupTheme, r11, true);
            int r13 = r11.resourceId;
            if (r13 == 0) goto L5;
            r12.applyStyle(r13, true);
        L5:
            r12.resolveAttribute(R.attr.panelMenuListTheme, r11, true);
            int r14 = r11.resourceId;
            if (r14 != 0) goto L9;
            r14 = R.style.Theme_AppCompat_CompactMenu;
        L9:
            r12.applyStyle(r14, true);
            androidx.appcompat.view.ContextThemeWrapper r15 = new androidx.appcompat.view.ContextThemeWrapper(r10, 0);
            r15.getTheme().setTo(r12);
            this.listPresenterContext = r15;
            TypedArray r16 = r15.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.background = r16.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = r16.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            r16.recycle();
        }
    }

    private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        PanelMenuPresenterCallback(AppCompatDelegateImpl r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r10, boolean r11) {
            MenuBuilder r12 = r10.getRootMenu();
            if (r12 == r10) goto L5;
            boolean r13 = true;
        L6:
            AppCompatDelegateImpl r14 = this.this$0;
            if (r13 == false) goto L9;
            r10 = r12;
        L9:
            PanelFeatureState r15 = r14.findMenuPanel(r10);
            if (r15 == null) goto L15;
            if (r13 == false) goto L13;
            this.this$0.callOnPanelClosed(r15.featureId, r15, r12);
            this.this$0.closePanel(r15, true);
            return;
        L13:
            this.this$0.closePanel(r15, r11);
            return;
        L15:
            return;
        L5:
            r13 = false;
            goto L6
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r10) {
            if (r10 != r10.getRootMenu()) goto L13;
            AppCompatDelegateImpl r11 = this.this$0;
            if (r11.mHasActionBar == false) goto L14;
            Window.Callback r12 = r11.getWindowCallback();
            if (r12 != null) goto L9;
            return true;
        L9:
            if (this.this$0.mDestroyed == true) goto L16;
            r12.onMenuOpened(108, r10);
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
        int r10 = Build.VERSION.SDK_INT;
        boolean r11 = false;
        if (r10 >= 21) goto L5;
        boolean r12 = true;
    L6:
        IS_PRE_LOLLIPOP = r12;
        sWindowBackgroundStyleable = new int[]{android.R.attr.windowBackground};
        sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
        if (r10 < 17) goto L9;
        r11 = true;
    L9:
        sCanApplyOverrideConfiguration = r11;
        if (r12 == true) goto L12;
        return;
    L12:
        if (sInstalledExceptionHandler == true) goto L16;
        final Thread.UncaughtExceptionHandler r13 = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new AnonymousClass1(r13));
        sInstalledExceptionHandler = true;
        return;
    L16:
        return;
    L5:
        r12 = false;
        goto L6
    }

    AppCompatDelegateImpl(Activity r10, AppCompatCallback r11) {
        this(r10, null, r11, r10);
    }

    AppCompatDelegateImpl(Dialog r10, AppCompatCallback r11) {
        this(r10.getContext(), r10.getWindow(), r11, r10);
    }

    AppCompatDelegateImpl(Context r10, Activity r11, AppCompatCallback r12) {
        this(r10, null, r12, r11);
    }

    AppCompatDelegateImpl(Context r10, Window r11, AppCompatCallback r12) {
        this(r10, r11, r12, r10);
    }

    private AppCompatDelegateImpl(Context r10, Window r11, AppCompatCallback r12, Object r13) {
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        this.mLocalNightMode = -100;
        this.mInvalidatePanelMenuRunnable = new AnonymousClass2(this);
        this.mContext = r10;
        this.mAppCompatCallback = r12;
        this.mHost = r13;
        if (this.mLocalNightMode != (-100)) goto L10;
        if ((r13 instanceof Dialog) == false) goto L10;
        AppCompatActivity r14 = tryUnwrapContext();
        if (r14 == null) goto L10;
        this.mLocalNightMode = r14.getDelegate().getLocalNightMode();
    L10:
        if (this.mLocalNightMode != (-100)) goto L14;
        SimpleArrayMap<String, Integer> r15 = sLocalNightModes;
        Integer r16 = r15.get(r13.getClass().getName());
        if (r16 == null) goto L14;
        this.mLocalNightMode = r16.intValue();
        r15.remove(r13.getClass().getName());
    L14:
        if (r11 == null) goto L16;
        attachToWindow(r11);
    L16:
        AppCompatDrawableManager.preload();
    }

    private boolean applyApplicationSpecificConfig(boolean r10) {
        return applyApplicationSpecificConfig(r10, true);
    }

    private boolean applyApplicationSpecificConfig(boolean r10, boolean r11) {
        if (this.mDestroyed == false) goto L6;
        return false;
    L6:
        int r12 = calculateNightMode();
        int r13 = mapNightMode(this.mContext, r12);
        LocaleListCompat r14 = null;
        if (Build.VERSION.SDK_INT >= 33) goto L9;
        r14 = calculateApplicationLocales(this.mContext);
    L9:
        if (r11 == true) goto L12;
        if (r14 == null) goto L12;
        r14 = getConfigurationLocales(this.mContext.getResources().getConfiguration());
    L12:
        boolean r15 = updateAppConfiguration(r13, r14, r10);
        if (r12 != 0) goto L15;
        getAutoTimeNightModeManager(this.mContext).setup();
    L19:
        if (r12 != 3) goto L21;
        getAutoBatteryNightModeManager(this.mContext).setup();
    L24:
        return r15;
    L21:
        AutoNightModeManager r16 = this.mAutoBatteryNightModeManager;
        if (r16 == null) goto L24;
        r16.cleanup();
        goto L24
    L15:
        AutoNightModeManager r17 = this.mAutoTimeNightModeManager;
        if (r17 == null) goto L19;
        r17.cleanup();
        goto L19
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout r10 = (ContentFrameLayout) this.mSubDecor.findViewById(android.R.id.content);
        View r11 = this.mWindow.getDecorView();
        r10.setDecorPadding(r11.getPaddingLeft(), r11.getPaddingTop(), r11.getPaddingRight(), r11.getPaddingBottom());
        TypedArray r12 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        r12.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, r10.getMinWidthMajor());
        r12.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, r10.getMinWidthMinor());
        int r13 = R.styleable.AppCompatTheme_windowFixedWidthMajor;
        if (r12.hasValue(r13) == false) goto L5;
        r12.getValue(r13, r10.getFixedWidthMajor());
    L5:
        int r14 = R.styleable.AppCompatTheme_windowFixedWidthMinor;
        if (r12.hasValue(r14) == false) goto L8;
        r12.getValue(r14, r10.getFixedWidthMinor());
    L8:
        int r15 = R.styleable.AppCompatTheme_windowFixedHeightMajor;
        if (r12.hasValue(r15) == false) goto L11;
        r12.getValue(r15, r10.getFixedHeightMajor());
    L11:
        int r16 = R.styleable.AppCompatTheme_windowFixedHeightMinor;
        if (r12.hasValue(r16) == false) goto L14;
        r12.getValue(r16, r10.getFixedHeightMinor());
    L14:
        r12.recycle();
        r10.requestLayout();
    }

    private void attachToWindow(@NonNull Window r10) {
        if (this.mWindow != null) goto L18;
        Window.Callback r11 = r10.getCallback();
        if ((r11 instanceof AppCompatWindowCallback) == true) goto L16;
        AppCompatWindowCallback r12 = new AppCompatWindowCallback(this, r11);
        this.mAppCompatWindowCallback = r12;
        r10.setCallback(r12);
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
        Drawable r14 = r13.getDrawableIfKnown(0);
        if (r14 == null) goto L9;
        r10.setBackgroundDrawable(r14);
    L9:
        r13.recycle();
        this.mWindow = r10;
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
        int r10 = this.mLocalNightMode;
        if (r10 == (-100)) goto L6;
        return r10;
    L6:
        return AppCompatDelegate.getDefaultNightMode();
    }

    private void cleanupAutoManagers() {
        AutoNightModeManager r10 = this.mAutoTimeNightModeManager;
        if (r10 == null) goto L5;
        r10.cleanup();
    L5:
        AutoNightModeManager r11 = this.mAutoBatteryNightModeManager;
        if (r11 == null) goto L9;
        r11.cleanup();
        return;
    }

    @NonNull
    private Configuration createOverrideAppConfiguration(@NonNull Context r10, int r11, @Nullable LocaleListCompat r12, @Nullable Configuration r13, boolean r14) {
        if (r11 != 1) goto L5;
        int r15 = 16;
    L11:
        Configuration r16 = new Configuration();
        r16.fontScale = 0.0f;
        if (r13 == null) goto L14;
        r16.setTo(r13);
    L14:
        r16.uiMode = r15 | (r16.uiMode & (-49));
        if (r12 == null) goto L17;
        setConfigurationLocales(r16, r12);
    L17:
        return r16;
    L5:
        if (r11 == 2) goto L9;
        if (r14 == false) goto L8;
        r15 = 0;
        goto L11
    L8:
        r15 = r10.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        goto L11
    L9:
        r15 = 32;
        goto L11
    }

    private ViewGroup createSubDecor() {
        TypedArray r10 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        int r11 = R.styleable.AppCompatTheme_windowActionBar;
        if (r10.hasValue(r11) == true) goto L5;
        r10.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    L5:
        if (r10.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false) == false) goto L8;
        requestWindowFeature(1);
    L11:
        if (r10.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false) == false) goto L14;
        requestWindowFeature(109);
    L14:
        if (r10.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false) == false) goto L16;
        requestWindowFeature(10);
    L16:
        this.mIsFloating = r10.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        r10.recycle();
        ensureWindow();
        this.mWindow.getDecorView();
        LayoutInflater r12 = LayoutInflater.from(this.mContext);
        if (this.mWindowNoTitle == true) goto L38;
        if (this.mIsFloating == false) goto L22;
        ViewGroup r13 = (ViewGroup) r12.inflate(R.layout.abc_dialog_title_material, null);
        this.mOverlayActionBar = false;
        this.mHasActionBar = false;
    L42:
        if (r13 == null) goto L63;
        if (Build.VERSION.SDK_INT < 21) goto L47;
        ViewCompat.setOnApplyWindowInsetsListener(r13, new AnonymousClass3(this));
    L50:
        if (this.mDecorContentParent != null) goto L52;
        this.mTitleView = (TextView) r13.findViewById(R.id.title);
    L52:
        ViewUtils.makeOptionalFitsSystemWindows(r13);
        ContentFrameLayout r14 = (ContentFrameLayout) r13.findViewById(R.id.action_bar_activity_content);
        ViewGroup r15 = (ViewGroup) this.mWindow.findViewById(android.R.id.content);
        if (r15 != null) goto L55;
    L60:
        this.mWindow.setContentView(r13);
        r14.setAttachListener(new AnonymousClass5(this));
        return r13;
    L55:
        if (r15.getChildCount() <= 0) goto L57;
        View r16 = r15.getChildAt(0);
        r15.removeViewAt(0);
        r14.addView(r16);
        goto L55
    L57:
        r15.setId(-1);
        r14.setId(android.R.id.content);
        if ((r15 instanceof FrameLayout) == false) goto L60;
        ((FrameLayout) r15).setForeground(null);
        goto L60
    L47:
        if ((r13 instanceof FitWindowsViewGroup) == false) goto L50;
        ((FitWindowsViewGroup) r13).setOnFitSystemWindowsListener(new AnonymousClass4(this));
        goto L50
    L63:
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
    L22:
        if (this.mHasActionBar == false) goto L36;
        TypedValue r17 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, r17, true);
        if (r17.resourceId == 0) goto L26;
        Context r18 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, r17.resourceId);
    L27:
        r13 = (ViewGroup) LayoutInflater.from(r18).inflate(R.layout.abc_screen_toolbar, null);
        DecorContentParent r19 = (DecorContentParent) r13.findViewById(R.id.decor_content_parent);
        this.mDecorContentParent = r19;
        r19.setWindowCallback(getWindowCallback());
        if (this.mOverlayActionBar == false) goto L31;
        this.mDecorContentParent.initFeature(109);
    L31:
        if (this.mFeatureProgress == false) goto L34;
        this.mDecorContentParent.initFeature(2);
    L34:
        if (this.mFeatureIndeterminateProgress == false) goto L42;
        this.mDecorContentParent.initFeature(5);
        goto L42
    L26:
        r18 = this.mContext;
        goto L27
    L36:
        r13 = null;
        goto L42
    L38:
        if (this.mOverlayActionMode == false) goto L40;
        int r20 = R.layout.abc_screen_simple_overlay_action_mode;
    L41:
        r13 = (ViewGroup) r12.inflate(r20, null);
        goto L42
    L40:
        r20 = R.layout.abc_screen_simple;
        goto L41
    L8:
        if (r10.getBoolean(r11, false) == false) goto L11;
        requestWindowFeature(108);
        goto L11
    }

    private void ensureSubDecor() {
        if (this.mSubDecorInstalled == true) goto L22;
        this.mSubDecor = createSubDecor();
        CharSequence r10 = getTitle();
        if (TextUtils.isEmpty(r10) == true) goto L15;
        DecorContentParent r11 = this.mDecorContentParent;
        if (r11 == null) goto L10;
        r11.setWindowTitle(r10);
        goto L15
    L10:
        if (peekSupportActionBar() == null) goto L12;
        peekSupportActionBar().setWindowTitle(r10);
        goto L15
    L12:
        TextView r12 = this.mTitleView;
        if (r12 == null) goto L15;
        r12.setText(r10);
    L15:
        applyFixedSizeWindow();
        onSubDecorInstalled(this.mSubDecor);
        this.mSubDecorInstalled = true;
        PanelFeatureState r13 = getPanelState(0, false);
        if (this.mDestroyed == true) goto L23;
        if (r13 != null) goto L19;
    L20:
        invalidatePanelMenu(108);
        return;
    L19:
        if (r13.menu == null) goto L20;
        return;
    L23:
        return;
    }

    private void ensureWindow() {
        if (this.mWindow != null) goto L8;
        Object r10 = this.mHost;
        if ((r10 instanceof Activity) == false) goto L8;
        attachToWindow(((Activity) r10).getWindow());
    L8:
        if (this.mWindow == null) goto L11;
        return;
    L11:
        throw new IllegalStateException("We have not been given a Window");
    }

    @NonNull
    private static Configuration generateConfigDelta(@NonNull Configuration r10, @Nullable Configuration r11) {
        Configuration r12 = new Configuration();
        r12.fontScale = 0.0f;
        if (r11 != null) goto L5;
    L73:
        return r12;
    L5:
        if (r10.diff(r11) == 0) goto L73;
        float r13 = r10.fontScale;
        float r14 = r11.fontScale;
        if (r13 == r14) goto L10;
        r12.fontScale = r14;
    L10:
        int r15 = r10.mcc;
        int r16 = r11.mcc;
        if (r15 == r16) goto L13;
        r12.mcc = r16;
    L13:
        int r17 = r10.mnc;
        int r18 = r11.mnc;
        if (r17 == r18) goto L16;
        r12.mnc = r18;
    L16:
        int r19 = Build.VERSION.SDK_INT;
        if (r19 < 24) goto L20;
        Api24Impl.generateConfigDelta_locale(r10, r11, r12);
    L22:
        int r20 = r10.touchscreen;
        int r21 = r11.touchscreen;
        if (r20 == r21) goto L25;
        r12.touchscreen = r21;
    L25:
        int r22 = r10.keyboard;
        int r23 = r11.keyboard;
        if (r22 == r23) goto L28;
        r12.keyboard = r23;
    L28:
        int r24 = r10.keyboardHidden;
        int r25 = r11.keyboardHidden;
        if (r24 == r25) goto L31;
        r12.keyboardHidden = r25;
    L31:
        int r26 = r10.navigation;
        int r27 = r11.navigation;
        if (r26 == r27) goto L34;
        r12.navigation = r27;
    L34:
        int r28 = r10.navigationHidden;
        int r29 = r11.navigationHidden;
        if (r28 == r29) goto L37;
        r12.navigationHidden = r29;
    L37:
        int r30 = r10.orientation;
        int r31 = r11.orientation;
        if (r30 == r31) goto L40;
        r12.orientation = r31;
    L40:
        int r32 = r10.screenLayout & 15;
        int r33 = r11.screenLayout;
        if (r32 == (r33 & 15)) goto L43;
        r12.screenLayout |= r33 & 15;
    L43:
        int r34 = r10.screenLayout & 192;
        int r35 = r11.screenLayout;
        if (r34 == (r35 & 192)) goto L46;
        r12.screenLayout |= r35 & 192;
    L46:
        int r36 = r10.screenLayout & 48;
        int r37 = r11.screenLayout;
        if (r36 == (r37 & 48)) goto L49;
        r12.screenLayout |= r37 & 48;
    L49:
        int r38 = r10.screenLayout & 768;
        int r39 = r11.screenLayout;
        if (r38 == (r39 & 768)) goto L53;
        r12.screenLayout |= r39 & 768;
    L53:
        if (r19 < 26) goto L55;
        Api26Impl.generateConfigDelta_colorMode(r10, r11, r12);
    L55:
        int r40 = r10.uiMode & 15;
        int r41 = r11.uiMode;
        if (r40 == (r41 & 15)) goto L58;
        r12.uiMode |= r41 & 15;
    L58:
        int r42 = r10.uiMode & 48;
        int r43 = r11.uiMode;
        if (r42 == (r43 & 48)) goto L61;
        r12.uiMode |= r43 & 48;
    L61:
        int r44 = r10.screenWidthDp;
        int r45 = r11.screenWidthDp;
        if (r44 == r45) goto L64;
        r12.screenWidthDp = r45;
    L64:
        int r46 = r10.screenHeightDp;
        int r47 = r11.screenHeightDp;
        if (r46 == r47) goto L67;
        r12.screenHeightDp = r47;
    L67:
        int r48 = r10.smallestScreenWidthDp;
        int r49 = r11.smallestScreenWidthDp;
        if (r48 == r49) goto L71;
        r12.smallestScreenWidthDp = r49;
    L71:
        if (r19 < 17) goto L73;
        Api17Impl.generateConfigDelta_densityDpi(r10, r11, r12);
        goto L73
    L20:
        if (ObjectsCompat.equals(r10.locale, r11.locale) == true) goto L22;
        r12.locale = r11.locale;
        goto L22
    }

    private int getActivityHandlesConfigChangesFlags(Context r10) {
        if (this.mActivityHandlesConfigFlagsChecked == false) goto L5;
    L22:
        this.mActivityHandlesConfigFlagsChecked = true;
        return this.mActivityHandlesConfigFlags;
    L5:
        if ((this.mHost instanceof Activity) == false) goto L22;
        PackageManager r11 = r10.getPackageManager();
        if (r11 != null) goto L24;
        return 0;
    L24:
        int r12 = Build.VERSION.SDK_INT;     // Catch: PackageManager.NameNotFoundException -> L20
        if (r12 < 29) goto L13;
        int r13 = 269221888;
    L16:
        ActivityInfo r14 = r11.getActivityInfo(new ComponentName(r10, this.mHost.getClass()), r13);     // Catch: PackageManager.NameNotFoundException -> L20
        if (r14 == null) goto L22;
        this.mActivityHandlesConfigFlags = r14.configChanges;     // Catch: PackageManager.NameNotFoundException -> L20
        goto L22
    L13:
        if (r12 < 24) goto L15;
        r13 = 786432;
        goto L16
    L15:
        r13 = 0;
    L20:
        e = move-exception;
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
        this.mActivityHandlesConfigFlags = 0;
        goto L22
    }

    private AutoNightModeManager getAutoBatteryNightModeManager(@NonNull Context r10) {
        if (this.mAutoBatteryNightModeManager != null) goto L6;
        this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(this, r10);
    L6:
        return this.mAutoBatteryNightModeManager;
    }

    private AutoNightModeManager getAutoTimeNightModeManager(@NonNull Context r10) {
        if (this.mAutoTimeNightModeManager != null) goto L6;
        this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(this, TwilightManager.getInstance(r10));
    L6:
        return this.mAutoTimeNightModeManager;
    }

    private void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar == true) goto L5;
        return;
    L5:
        if (this.mActionBar != null) goto L20;
        Object r10 = this.mHost;
        if ((r10 instanceof Activity) == false) goto L12;
        WindowDecorActionBar r11 = new WindowDecorActionBar((Activity) this.mHost, this.mOverlayActionBar);
    L10:
        this.mActionBar = r11;
    L14:
        ActionBar r12 = this.mActionBar;
        if (r12 == null) goto L19;
        r12.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        return;
    L19:
        return;
    L12:
        if ((r10 instanceof Dialog) == false) goto L14;
        r11 = new WindowDecorActionBar((Dialog) this.mHost);
        goto L10
    }

    private boolean initializePanelContent(PanelFeatureState r10) {
        View r11 = r10.createdPanelView;
        if (r11 == null) goto L7;
        r10.shownPanelView = r11;
        return true;
    L7:
        if (r10.menu != null) goto L10;
        return false;
    L10:
        if (this.mPanelMenuPresenterCallback != null) goto L12;
        this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(this);
    L12:
        View r12 = (View) r10.getListMenuView(this.mPanelMenuPresenterCallback);
        r10.shownPanelView = r12;
        if (r12 == null) goto L16;
        return true;
    L16:
        return false;
    }

    private boolean initializePanelDecor(PanelFeatureState r10) {
        r10.setStyle(getActionBarThemedContext());
        r10.decorView = new ListMenuDecorView(this, r10.listPresenterContext);
        r10.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState r10) {
        Context r11 = this.mContext;
        int r12 = r10.featureId;
        if (r12 == 0) goto L7;
        if (r12 == 108) goto L7;
    L19:
        MenuBuilder r13 = new MenuBuilder(r11);
        r13.setCallback(this);
        r10.setMenu(r13);
        return true;
    L7:
        if (this.mDecorContentParent == null) goto L19;
        TypedValue r14 = new TypedValue();
        Resources.Theme r15 = r11.getTheme();
        r15.resolveAttribute(R.attr.actionBarTheme, r14, true);
        Resources.Theme r16 = null;
        if (r14.resourceId == 0) goto L11;
        r16 = r11.getResources().newTheme();
        r16.setTo(r15);
        r16.applyStyle(r14.resourceId, true);
        r16.resolveAttribute(R.attr.actionBarWidgetTheme, r14, true);
    L13:
        if (r14.resourceId == 0) goto L17;
        if (r16 != null) goto L16;
        r16 = r11.getResources().newTheme();
        r16.setTo(r15);
    L16:
        r16.applyStyle(r14.resourceId, true);
    L17:
        if (r16 == null) goto L19;
        androidx.appcompat.view.ContextThemeWrapper r17 = new androidx.appcompat.view.ContextThemeWrapper(r11, 0);
        r17.getTheme().setTo(r16);
        r11 = r17;
        goto L19
    L11:
        r15.resolveAttribute(R.attr.actionBarWidgetTheme, r14, true);
        goto L13
    }

    private void invalidatePanelMenu(int r10) {
        int r11 = 1 << r10;
        this.mInvalidatePanelMenuFeatures = r11 | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted == true) goto L6;
        ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
        return;
    }

    private boolean onKeyDownPanel(int r10, KeyEvent r11) {
        if (r11.getRepeatCount() != 0) goto L8;
        PanelFeatureState r12 = getPanelState(r10, true);
        if (r12.isOpen == false) goto L7;
        return false;
    L7:
        return preparePanel(r12, r11);
    L8:
        return false;
    }

    private boolean onKeyUpPanel(int r10, KeyEvent r11) {
        if (this.mActionMode == null) goto L5;
        return false;
    L5:
        boolean r12 = true;
        PanelFeatureState r13 = getPanelState(r10, true);
        if (r10 != 0) goto L21;
        DecorContentParent r14 = this.mDecorContentParent;
        if (r14 == null) goto L21;
        if (r14.canShowOverflowMenu() == false) goto L21;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L21;
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L16;
        r12 = this.mDecorContentParent.hideOverflowMenu();
    L36:
        if (r12 == false) goto L41;
        AudioManager r15 = (AudioManager) this.mContext.getApplicationContext().getSystemService("audio");
        if (r15 == null) goto L40;
        r15.playSoundEffect(0);
        goto L41
    L40:
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
    L41:
        return r12;
    L16:
        if (this.mDestroyed == false) goto L18;
    L34:
        r12 = false;
        goto L36
    L18:
        if (preparePanel(r13, r11) == false) goto L34;
        r12 = this.mDecorContentParent.showOverflowMenu();
    L21:
        boolean r16 = r13.isOpen;
        if (r16 == false) goto L24;
    L35:
        closePanel(r13, true);
        r12 = r16;
        goto L36
    L24:
        if (r13.isHandled == true) goto L35;
        if (r13.isPrepared == false) goto L34;
        if (r13.refreshMenuContent == false) goto L31;
        r13.isPrepared = false;
        boolean r17 = preparePanel(r13, r11);
    L32:
        if (r17 == false) goto L34;
        openPanel(r13, r11);
        goto L36
    L31:
        r17 = true;
        goto L32
    }

    private void openPanel(PanelFeatureState r14, KeyEvent r15) {
        if (r14.isOpen == false) goto L5;
        return;
    L5:
        if (this.mDestroyed == false) goto L8;
        return;
    L8:
        if (r14.featureId == 0) goto L10;
    L15:
        Window.Callback r10 = getWindowCallback();
        if (r10 != null) goto L18;
    L21:
        WindowManager r11 = (WindowManager) this.mContext.getSystemService("window");
        if (r11 != null) goto L25;
        return;
    L25:
        if (preparePanel(r14, r15) == true) goto L27;
        return;
    L27:
        ViewGroup r16 = r14.decorView;
        if (r16 != null) goto L30;
    L39:
        if (r16 != null) goto L46;
        if (initializePanelDecor(r14) == true) goto L43;
        return;
    L43:
        if (r14.decorView != null) goto L51;
        return;
    L51:
        if (initializePanelContent(r14) == true) goto L53;
    L69:
        r14.refreshDecorView = true;
        return;
    L53:
        if (r14.hasPanelItems() == false) goto L69;
        ViewGroup.LayoutParams r17 = r14.shownPanelView.getLayoutParams();
        if (r17 != null) goto L58;
        r17 = new ViewGroup.LayoutParams(-2, -2);
    L58:
        r14.decorView.setBackgroundResource(r14.background);
        ViewParent r12 = r14.shownPanelView.getParent();
        if ((r12 instanceof ViewGroup) == false) goto L61;
        ((ViewGroup) r12).removeView(r14.shownPanelView);
    L61:
        r14.decorView.addView(r14.shownPanelView, r17);
        if (r14.shownPanelView.hasFocus() == true) goto L64;
        r14.shownPanelView.requestFocus();
    L64:
        int r13 = -2;
    L65:
        r14.isHandled = false;
        WindowManager.LayoutParams r18 = new WindowManager.LayoutParams(r13, -2, r14.f220x, r14.f221y, PointerIconCompat.TYPE_HAND, 8519680, -3);
        r18.gravity = r14.gravity;
        r18.windowAnimations = r14.windowAnimations;
        r11.addView(r14.decorView, r18);
        r14.isOpen = true;
        if (r14.featureId != 0) goto L72;
        updateBackInvokedCallbackState();
        return;
    L72:
        return;
    L46:
        if (r14.refreshDecorView == false) goto L51;
        if (r16.getChildCount() <= 0) goto L51;
        r14.decorView.removeAllViews();
        goto L51
    L30:
        if (r14.refreshDecorView == true) goto L39;
        View r19 = r14.createdPanelView;
        if (r19 == null) goto L64;
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
        if (r110 == null) goto L64;
        if (r110.width != (-1)) goto L64;
        r13 = -1;
        goto L65
    L18:
        if (r10.onMenuOpened(r14.featureId, r14.menu) == true) goto L21;
        closePanel(r14, true);
        return;
    L10:
        if ((this.mContext.getResources().getConfiguration().screenLayout & 15) != 4) goto L12;
        boolean r20 = true;
    L13:
        if (r20 == false) goto L15;
        return;
    L12:
        r20 = false;
        goto L13
    }

    private boolean performPanelShortcut(PanelFeatureState r10, int r11, KeyEvent r12, int r13) {
        boolean r14 = false;
        if (r12.isSystem() == false) goto L6;
        return false;
    L6:
        if (r10.isPrepared == false) goto L8;
    L9:
        MenuBuilder r15 = r10.menu;
        if (r15 == null) goto L12;
        r14 = r15.performShortcut(r11, r12, r13);
    L12:
        if (r14 == true) goto L14;
    L18:
        return r14;
    L14:
        if ((r13 & 1) != 0) goto L18;
        if (this.mDecorContentParent != null) goto L18;
        closePanel(r10, true);
        goto L18
    L8:
        if (preparePanel(r10, r12) == false) goto L12;
        goto L9
    }

    private boolean preparePanel(PanelFeatureState r10, KeyEvent r11) {
        if (this.mDestroyed == false) goto L6;
        return false;
    L6:
        if (r10.isPrepared == false) goto L8;
        return true;
    L8:
        PanelFeatureState r12 = this.mPreparedPanel;
        if (r12 == null) goto L12;
        if (r12 == r10) goto L12;
        closePanel(r12, false);
    L12:
        Window.Callback r13 = getWindowCallback();
        if (r13 == null) goto L15;
        r10.createdPanelView = r13.onCreatePanelView(r10.featureId);
    L15:
        int r14 = r10.featureId;
        if (r14 != 0) goto L18;
    L21:
        boolean r15 = true;
    L22:
        if (r15 == false) goto L27;
        DecorContentParent r16 = this.mDecorContentParent;
        if (r16 == null) goto L27;
        r16.setMenuPrepared();
    L27:
        if (r10.createdPanelView != null) goto L76;
        if (r15 == true) goto L30;
    L31:
        MenuBuilder r17 = r10.menu;
        if (r17 != null) goto L34;
    L35:
        if (r17 == null) goto L37;
    L41:
        if (r15 == true) goto L43;
    L48:
        r10.menu.stopDispatchingItemsChanged();
        if (r13.onCreatePanelMenu(r10.featureId, r10.menu) == true) goto L56;
        r10.setMenu(null);
        if (r15 == false) goto L55;
        DecorContentParent r18 = this.mDecorContentParent;
        if (r18 == null) goto L55;
        r18.setMenu(null, this.mActionMenuPresenterCallback);
    L55:
        return false;
    L56:
        r10.refreshMenuContent = false;
    L57:
        r10.menu.stopDispatchingItemsChanged();
        Bundle r19 = r10.frozenActionViewState;
        if (r19 == null) goto L61;
        r10.menu.restoreActionViewStates(r19);
        r10.frozenActionViewState = null;
    L61:
        if (r13.onPreparePanel(0, r10.createdPanelView, r10.menu) == true) goto L68;
        if (r15 == false) goto L66;
        DecorContentParent r110 = this.mDecorContentParent;
        if (r110 == null) goto L66;
        r110.setMenu(null, this.mActionMenuPresenterCallback);
    L66:
        r10.menu.startDispatchingItemsChanged();
        return false;
    L68:
        if (r11 == null) goto L70;
        int r111 = r11.getDeviceId();
    L72:
        if (KeyCharacterMap.load(r111).getKeyboardType() == 1) goto L74;
        boolean r112 = true;
    L75:
        r10.qwertyMode = r112;
        r10.menu.setQwertyMode(r112);
        r10.menu.startDispatchingItemsChanged();
        goto L76
    L74:
        r112 = false;
        goto L75
    L70:
        r111 = -1;
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
        if (r14 == 108) goto L21;
        r15 = false;
        goto L22
    }

    private void reopenMenu(boolean r10) {
        DecorContentParent r11 = this.mDecorContentParent;
        if (r11 != null) goto L5;
    L33:
        PanelFeatureState r12 = getPanelState(0, true);
        r12.refreshDecorView = true;
        closePanel(r12, false);
        openPanel(r12, null);
        return;
    L5:
        if (r11.canShowOverflowMenu() == false) goto L33;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L9;
    L10:
        Window.Callback r13 = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L17;
        if (r10 == false) goto L17;
        this.mDecorContentParent.hideOverflowMenu();
        if (this.mDestroyed == true) goto L35;
        r13.onPanelClosed(108, getPanelState(0, true).menu);
        return;
    L35:
        return;
    L17:
        if (r13 != null) goto L19;
        return;
    L19:
        if (this.mDestroyed == false) goto L21;
        return;
    L21:
        if (this.mInvalidatePanelMenuPosted == true) goto L23;
    L25:
        PanelFeatureState r14 = getPanelState(0, true);
        MenuBuilder r15 = r14.menu;
        if (r15 != null) goto L28;
        return;
    L28:
        if (r14.refreshMenuContent == false) goto L30;
        return;
    L30:
        if (r13.onPreparePanel(0, r14.createdPanelView, r15) == false) goto L41;
        r13.onMenuOpened(108, r14.menu);
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

    private int sanitizeWindowFeatureId(int r10) {
        if (r10 != 8) goto L7;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
        return 108;
    L7:
        if (r10 != 9) goto L10;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    L10:
        return r10;
    }

    private boolean shouldInheritContext(ViewParent r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        View r11 = this.mWindow.getDecorView();
    L6:
        if (r10 == null) goto L7;
        if (r10 == r11) goto L16;
        if ((r10 instanceof View) == false) goto L16;
        if (ViewCompat.isAttachedToWindow((View) r10) == true) goto L16;
        r10 = r10.getParent();
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
        Context r10 = this.mContext;
    L4:
        if (r10 == null) goto L12;
        if ((r10 instanceof AppCompatActivity) == true) goto L8;
        if ((r10 instanceof ContextWrapper) == false) goto L12;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L4
    L8:
        return (AppCompatActivity) r10;
    L12:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateActivityConfiguration(Configuration r10) {
        Activity r11 = (Activity) this.mHost;
        if ((r11 instanceof LifecycleOwner) == false) goto L8;
        if (((LifecycleOwner) r11).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L13;
    L11:
        r11.onConfigurationChanged(r10);
        return;
    L13:
        return;
    L8:
        if (this.mCreated == true) goto L10;
        return;
    L10:
        if (this.mDestroyed == false) goto L11;
    }

    private boolean updateAppConfiguration(int r10, @Nullable LocaleListCompat r11, boolean r12) {
        Configuration r13 = createOverrideAppConfiguration(this.mContext, r10, r11, null, false);
        int r14 = getActivityHandlesConfigChangesFlags(this.mContext);
        Configuration r15 = this.mEffectiveConfiguration;
        if (r15 != null) goto L5;
        r15 = this.mContext.getResources().getConfiguration();
    L5:
        int r16 = r15.uiMode & 48;
        int r17 = r13.uiMode & 48;
        LocaleListCompat r18 = getConfigurationLocales(r15);
        if (r11 != null) goto L8;
        LocaleListCompat r19 = null;
    L9:
        boolean r20 = false;
        if (r16 == r17) goto L12;
        int r21 = 512;
    L13:
        if (r19 != null) goto L15;
    L19:
        boolean r22 = true;
        if (((~r14) & r21) == 0) goto L33;
        if (r12 == false) goto L33;
        if (this.mBaseContextAttached == false) goto L33;
        if (sCanReturnDifferentContext == false) goto L27;
    L28:
        Object r110 = this.mHost;
        if ((r110 instanceof Activity) == false) goto L33;
        if (((Activity) r110).isChild() == true) goto L33;
        ActivityCompat.recreate((Activity) this.mHost);
        boolean r111 = true;
    L34:
        if (r111 == true) goto L40;
        if (r21 == 0) goto L40;
        if ((r21 & r14) != r21) goto L39;
        r20 = true;
    L39:
        updateResourcesConfiguration(r17, r19, r20, null);
    L41:
        if (r22 == false) goto L50;
        Object r112 = this.mHost;
        if ((r112 instanceof AppCompatActivity) == false) goto L50;
        if ((r21 & 512) == 0) goto L48;
        ((AppCompatActivity) r112).onNightModeChanged(r10);
    L48:
        if ((r21 & 4) == 0) goto L50;
        ((AppCompatActivity) this.mHost).onLocalesChanged(r11);
    L50:
        if (r22 == false) goto L53;
        if (r19 == null) goto L53;
        setDefaultLocalesForLocaleList(getConfigurationLocales(this.mContext.getResources().getConfiguration()));
    L53:
        return r22;
    L40:
        r22 = r111;
        goto L41
    L27:
        if (this.mCreated == true) goto L28;
    L33:
        r111 = false;
        goto L34
    L15:
        if (r18.equals(r19) == true) goto L19;
        r21 = r21 | 4;
        if (Build.VERSION.SDK_INT < 17) goto L19;
        r21 = r21 | 8192;
        goto L19
    L12:
        r21 = 0;
        goto L13
    L8:
        r19 = getConfigurationLocales(r13);
        goto L9
    }

    private void updateResourcesConfiguration(int r10, @Nullable LocaleListCompat r11, boolean r12, @Nullable Configuration r13) {
        Resources r14 = this.mContext.getResources();
        Configuration r15 = new Configuration(r14.getConfiguration());
        if (r13 == null) goto L5;
        r15.updateFrom(r13);
    L5:
        r15.uiMode = r10 | (r14.getConfiguration().uiMode & (-49));
        if (r11 == null) goto L8;
        setConfigurationLocales(r15, r11);
    L8:
        r14.updateConfiguration(r15, null);
        int r16 = Build.VERSION.SDK_INT;
        if (r16 >= 26) goto L11;
        ResourcesFlusher.flush(r14);
    L11:
        int r17 = this.mThemeResId;
        if (r17 == 0) goto L16;
        this.mContext.setTheme(r17);
        if (r16 < 23) goto L16;
        this.mContext.getTheme().applyStyle(this.mThemeResId, true);
    L16:
        if (r12 == true) goto L18;
        return;
    L18:
        if ((this.mHost instanceof Activity) == false) goto L22;
        updateActivityConfiguration(r15);
        return;
    }

    private void updateStatusGuardColor(View r10) {
        if ((ViewCompat.getWindowSystemUiVisibility(r10) & 8192) == 0) goto L5;
        boolean r11 = true;
    L6:
        Context r12 = this.mContext;
        if (r11 == false) goto L9;
        int r13 = R.color.abc_decor_view_status_guard_light;
    L10:
        r10.setBackgroundColor(ContextCompat.getColor(r12, r13));
        return;
    L9:
        r13 = R.color.abc_decor_view_status_guard;
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View r10, ViewGroup.LayoutParams r11) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(android.R.id.content)).addView(r10, r11);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    boolean applyAppLocales() {
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
        boolean r11 = true;
        this.mBaseContextAttached = true;
        int r12 = mapNightMode(r10, calculateNightMode());
        if (AppCompatDelegate.isAutoStorageOptedIn(r10) == false) goto L5;
        AppCompatDelegate.syncRequestedAndStoredLocales(r10);
    L5:
        LocaleListCompat r13 = calculateApplicationLocales(r10);
        if (sCanApplyOverrideConfiguration == false) goto L13;
        if ((r10 instanceof ContextThemeWrapper) == false) goto L13;
        ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((ContextThemeWrapper) r10, createOverrideAppConfiguration(r10, r12, r13, null, false));     // Catch: IllegalStateException -> L36
        return r10;
    L13:
        if ((r10 instanceof androidx.appcompat.view.ContextThemeWrapper) == false) goto L18;
        ((androidx.appcompat.view.ContextThemeWrapper) r10).applyOverrideConfiguration(createOverrideAppConfiguration(r10, r12, r13, null, false));     // Catch: IllegalStateException -> L37
        return r10;
    L18:
        if (sCanReturnDifferentContext == false) goto L20;
        Configuration r14 = null;
        if (Build.VERSION.SDK_INT < 17) goto L26;
        Configuration r15 = new Configuration();
        r15.uiMode = -1;
        r15.fontScale = 0.0f;
        Configuration r16 = Api17Impl.createConfigurationContext(r10, r15).getResources().getConfiguration();
        Configuration r17 = r10.getResources().getConfiguration();
        r16.uiMode = r17.uiMode;
        if (r16.equals(r17) == true) goto L26;
        r14 = generateConfigDelta(r16, r17);
    L26:
        Configuration r18 = createOverrideAppConfiguration(r10, r12, r13, r14, true);
        androidx.appcompat.view.ContextThemeWrapper r19 = new androidx.appcompat.view.ContextThemeWrapper(r10, R.style.Theme_AppCompat_Empty);
        r19.applyOverrideConfiguration(r18);
        boolean r20 = false;
        if (r10.getTheme() != null) goto L31;
        r11 = false;
    L31:
        r20 = r11;
    L32:
        if (r20 == false) goto L35;
        ResourcesCompat.ThemeCompat.rebase(r19.getTheme());
    L35:
        return super.attachBaseContext2(r19);
    L20:
        return super.attachBaseContext2(r10);
    }

    @Nullable
    LocaleListCompat calculateApplicationLocales(@NonNull Context r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 33) goto L5;
        return null;
    L5:
        LocaleListCompat r12 = AppCompatDelegate.getRequestedAppLocales();
        if (r12 != null) goto L8;
        return null;
    L8:
        LocaleListCompat r13 = getConfigurationLocales(r10.getApplicationContext().getResources().getConfiguration());
        if (r11 < 24) goto L12;
        LocaleListCompat r14 = LocaleOverlayHelper.combineLocalesIfOverlayExists(r12, r13);
    L16:
        if (r14.isEmpty() == false) goto L19;
        return r13;
    L19:
        return r14;
    L12:
        if (r12.isEmpty() == false) goto L14;
        r14 = LocaleListCompat.getEmptyLocaleList();
        goto L16
    L14:
        r14 = LocaleListCompat.forLanguageTags(r12.get(0).toString());
        goto L16
    }

    void callOnPanelClosed(int r10, PanelFeatureState r11, Menu r12) {
        if (r12 != null) goto L10;
        if (r11 != null) goto L8;
        if (r10 < 0) goto L8;
        PanelFeatureState[] r13 = this.mPanels;
        if (r10 >= r13.length) goto L8;
        r11 = r13[r10];
    L8:
        if (r11 == null) goto L10;
        r12 = r11.menu;
    L10:
        if (r11 == null) goto L15;
        if (r11.isOpen == true) goto L15;
        return;
    L15:
        if (this.mDestroyed == true) goto L18;
        this.mAppCompatWindowCallback.bypassOnPanelClosed(this.mWindow.getCallback(), r10, r12);
        return;
    }

    void checkCloseActionMenu(@NonNull MenuBuilder r10) {
        if (this.mClosingActionMenu == false) goto L5;
        return;
    L5:
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window.Callback r11 = getWindowCallback();
        if (r11 != null) goto L8;
    L10:
        this.mClosingActionMenu = false;
        return;
    L8:
        if (this.mDestroyed == true) goto L10;
        r11.onPanelClosed(108, r10);
        goto L10
    }

    void closePanel(int r10) {
        closePanel(getPanelState(r10, true), true);
    }

    void closePanel(PanelFeatureState r10, boolean r11) {
        if (r11 == true) goto L4;
    L11:
        WindowManager r12 = (WindowManager) this.mContext.getSystemService("window");
        if (r12 != null) goto L14;
    L20:
        r10.isPrepared = false;
        r10.isHandled = false;
        r10.isOpen = false;
        r10.shownPanelView = null;
        r10.refreshDecorView = true;
        if (this.mPreparedPanel != r10) goto L24;
        this.mPreparedPanel = null;
    L24:
        if (r10.featureId != 0) goto L27;
        updateBackInvokedCallbackState();
        return;
    L27:
        return;
    L14:
        if (r10.isOpen == false) goto L20;
        ViewGroup r13 = r10.decorView;
        if (r13 == null) goto L20;
        r12.removeView(r13);
        if (r11 == false) goto L20;
        callOnPanelClosed(r10.featureId, r10, null);
        goto L20
    L4:
        if (r10.featureId != 0) goto L11;
        DecorContentParent r14 = this.mDecorContentParent;
        if (r14 == null) goto L11;
        if (r14.isOverflowMenuShowing() == false) goto L11;
        checkCloseActionMenu(r10.menu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(View r12, String r13, @NonNull Context r14, @NonNull AttributeSet r15) {
        boolean r10 = false;
        if (this.mAppCompatViewInflater != null) goto L12;
        String r11 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
        if (r11 != null) goto L30;
        AppCompatViewInflater r16 = new AppCompatViewInflater();
    L7:
        this.mAppCompatViewInflater = r16;
        goto L12
    L30:
        this.mAppCompatViewInflater = (AppCompatViewInflater) this.mContext.getClassLoader().loadClass(r11).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + r11 + ". Falling back to default.", th);
        r16 = new AppCompatViewInflater();
    L12:
        boolean r17 = IS_PRE_LOLLIPOP;
        boolean r18 = true;
        if (r17 == true) goto L15;
    L27:
        boolean r19 = r10;
    L29:
        return this.mAppCompatViewInflater.createView(r12, r13, r14, r15, r19, r17, true, VectorEnabledTintResources.shouldBeUsed());
    L15:
        if (this.mLayoutIncludeDetector != null) goto L18;
        this.mLayoutIncludeDetector = new LayoutIncludeDetector();
    L18:
        if (this.mLayoutIncludeDetector.detect(r15) == false) goto L21;
        r19 = true;
        goto L29
    L21:
        if ((r15 instanceof XmlPullParser) == true) goto L23;
        r18 = shouldInheritContext((ViewParent) r12);
    L26:
        r10 = r18;
        goto L27
    L23:
        if (((XmlPullParser) r15).getDepth() <= 1) goto L27;
        goto L27
    }

    void dismissPopups() {
        DecorContentParent r10 = this.mDecorContentParent;
        if (r10 == null) goto L6;
        r10.dismissPopups();
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
        PanelFeatureState r11 = getPanelState(0, false);
        if (r11 == null) goto L20;
        MenuBuilder r12 = r11.menu;
        if (r12 == null) goto L21;
        r12.close();
        return;
    L21:
        return;
    }

    boolean dispatchKeyEvent(KeyEvent r10) {
        Object r11 = this.mHost;
        boolean r12 = true;
        if ((r11 instanceof KeyEventDispatcher.Component) == false) goto L5;
    L6:
        View r13 = this.mWindow.getDecorView();
        if (r13 != null) goto L9;
    L12:
        if (r10.getKeyCode() == 82) goto L14;
    L16:
        int r14 = r10.getKeyCode();
        if (r10.getAction() == 0) goto L20;
        r12 = false;
    L20:
        if (r12 == false) goto L23;
        return onKeyDown(r14, r10);
    L23:
        return onKeyUp(r14, r10);
    L14:
        if (this.mAppCompatWindowCallback.bypassDispatchKeyEvent(this.mWindow.getCallback(), r10) == false) goto L16;
        return true;
    L9:
        if (KeyEventDispatcher.dispatchBeforeHierarchy(r13, r10) == false) goto L12;
        return true;
    L5:
        if ((r11 instanceof AppCompatDialog) == false) goto L12;
        goto L6
    }

    void doInvalidatePanelMenu(int r10) {
        PanelFeatureState r11 = getPanelState(r10, true);
        if (r11.menu == null) goto L8;
        Bundle r12 = new Bundle();
        r11.menu.saveActionViewStates(r12);
        if (r12.size() <= 0) goto L7;
        r11.frozenActionViewState = r12;
    L7:
        r11.menu.stopDispatchingItemsChanged();
        r11.menu.clear();
    L8:
        r11.refreshMenuContent = true;
        r11.refreshDecorView = true;
        if (r10 == 108) goto L12;
        if (r10 == 0) goto L12;
        return;
    L12:
        if (this.mDecorContentParent == null) goto L18;
        PanelFeatureState r13 = getPanelState(0, false);
        if (r13 == null) goto L19;
        r13.isPrepared = false;
        preparePanel(r13, null);
        return;
    L19:
        return;
    }

    void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat r10 = this.mFadeAnim;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    PanelFeatureState findMenuPanel(Menu r10) {
        PanelFeatureState[] r11 = this.mPanels;
        int r12 = 0;
        if (r11 == null) goto L5;
        int r13 = r11.length;
    L6:
        if (r12 >= r13) goto L13;
        PanelFeatureState r14 = r11[r12];
        if (r14 == null) goto L12;
        if (r14.menu != r10) goto L12;
        return r14;
    L12:
        r12 = r12 + 1;
        goto L6
    L13:
        return null;
    L5:
        r13 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public <T extends View> T findViewById(@IdRes int r10) {
        ensureSubDecor();
        return (T) this.mWindow.findViewById(r10);
    }

    final Context getActionBarThemedContext() {
        ActionBar r10 = getSupportActionBar();
        if (r10 == null) goto L5;
        Context r11 = r10.getThemedContext();
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return this.mContext;
    L5:
        r11 = null;
        goto L6
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    final AutoNightModeManager getAutoTimeNightModeManager() {
        return getAutoTimeNightModeManager(this.mContext);
    }

    LocaleListCompat getConfigurationLocales(Configuration r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 24) goto L7;
        return Api24Impl.getLocales(r10);
    L7:
        if (r11 < 21) goto L11;
        return LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(r10.locale));
    L11:
        return LocaleListCompat.create(new Locale[]{r10.locale});
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
        ActionBar r10 = this.mActionBar;
        if (r10 == null) goto L7;
        Context r11 = r10.getThemedContext();
    L8:
        this.mMenuInflater = new SupportMenuInflater(r11);
        goto L10
    L7:
        r11 = this.mContext;
    L10:
        return this.mMenuInflater;
    }

    protected PanelFeatureState getPanelState(int r10, boolean r11) {
        PanelFeatureState[] r12 = this.mPanels;
        if (r12 != null) goto L5;
    L6:
        PanelFeatureState[] r13 = new PanelFeatureState[r10 + 1];
        if (r12 == null) goto L9;
        System.arraycopy(r12, 0, r13, 0, r12.length);
    L9:
        this.mPanels = r13;
        r12 = r13;
    L10:
        PanelFeatureState r14 = r12[r10];
        if (r14 != null) goto L14;
        PanelFeatureState r15 = new PanelFeatureState(r10);
        r12[r10] = r15;
        return r15;
    L14:
        return r14;
    L5:
        if (r12.length > r10) goto L10;
        goto L6
    }

    ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    final CharSequence getTitle() {
        Object r10 = this.mHost;
        if ((r10 instanceof Activity) == false) goto L7;
        return ((Activity) r10).getTitle();
    L7:
        return this.mTitle;
    }

    final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int r10) {
        int r11 = sanitizeWindowFeatureId(r10);
        if (r11 != 1) goto L5;
        boolean r12 = this.mWindowNoTitle;
    L21:
        if (r12 == false) goto L23;
        return true;
    L23:
        if (this.mWindow.hasFeature(r10) == false) goto L26;
        return true;
    L26:
        return false;
    L5:
        if (r11 != 2) goto L7;
        r12 = this.mFeatureProgress;
        goto L21
    L7:
        if (r11 != 5) goto L9;
        r12 = this.mFeatureIndeterminateProgress;
        goto L21
    L9:
        if (r11 != 10) goto L11;
        r12 = this.mOverlayActionMode;
        goto L21
    L11:
        if (r11 != 108) goto L13;
        r12 = this.mHasActionBar;
        goto L21
    L13:
        if (r11 == 109) goto L15;
        r12 = false;
        goto L21
    L15:
        r12 = this.mOverlayActionBar;
        goto L21
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater r10 = LayoutInflater.from(this.mContext);
        if (r10.getFactory() != null) goto L6;
        LayoutInflaterCompat.setFactory2(r10, this);
        return;
    L6:
        if ((r10.getFactory2() instanceof AppCompatDelegateImpl) == true) goto L10;
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

    int mapNightMode(@NonNull Context r10, int r11) {
        if (r11 == (-100)) goto L24;
        if (r11 == (-1)) goto L23;
        if (r11 == 0) goto L18;
        if (r11 == 1) goto L23;
        if (r11 == 2) goto L23;
        if (r11 != 3) goto L16;
        AutoNightModeManager r12 = getAutoBatteryNightModeManager(r10);
    L14:
        return r12.getApplyableNightMode();
    L16:
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    L18:
        if (Build.VERSION.SDK_INT >= 23) goto L20;
    L22:
        r12 = getAutoTimeNightModeManager(r10);
        goto L14
    L20:
        if (((UiModeManager) r10.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) goto L22;
        return -1;
    L23:
        return r11;
    L24:
        return -1;
    }

    boolean onBackPressed() {
        boolean r10 = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState r11 = getPanelState(0, false);
        if (r11 != null) goto L5;
    L9:
        ActionMode r12 = this.mActionMode;
        if (r12 == null) goto L13;
        r12.finish();
        return true;
    L13:
        ActionBar r13 = getSupportActionBar();
        if (r13 != null) goto L16;
    L18:
        return false;
    L16:
        if (r13.collapseActionView() == false) goto L18;
        return true;
    L5:
        if (r11.isOpen == false) goto L9;
        if (r10 == true) goto L8;
        closePanel(r11, true);
    L8:
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration r10) {
        if (this.mHasActionBar == true) goto L5;
    L9:
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        applyApplicationSpecificConfig(false, false);
        return;
    L5:
        if (this.mSubDecorInstalled == false) goto L9;
        ActionBar r11 = getSupportActionBar();
        if (r11 == null) goto L9;
        r11.onConfigurationChanged(r10);
        goto L9
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle r10) {
        this.mBaseContextAttached = true;
        applyApplicationSpecificConfig(false);
        ensureWindow();
        Object r11 = this.mHost;
        if ((r11 instanceof Activity) == false) goto L12;
        String r12 = null;
        r12 = NavUtils.getParentActivityName((Activity) r11);     // Catch: IllegalArgumentException -> L14
    L6:
        if (r12 == null) goto L11;
        ActionBar r13 = peekSupportActionBar();
        if (r13 != null) goto L10;
        this.mEnableDefaultActionBarUp = true;
        goto L11
    L10:
        r13.setDefaultDisplayHomeAsUpEnabled(true);
    L11:
        AppCompatDelegate.addActiveDelegate(this);
    L12:
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.mCreated = true;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r10, String r11, Context r12, AttributeSet r13) {
        return createView(r10, r11, r12, r13);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r10, Context r11, AttributeSet r12) {
        return onCreateView(null, r10, r11, r12);
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
        Object r10 = this.mHost;
        if ((r10 instanceof Activity) == false) goto L15;
        if (((Activity) r10).isChangingConfigurations() == false) goto L15;
        sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
    L16:
        ActionBar r11 = this.mActionBar;
        if (r11 == null) goto L19;
        r11.onDestroy();
    L19:
        cleanupAutoManagers();
        return;
    L15:
        sLocalNightModes.remove(this.mHost.getClass().getName());
        goto L16
    }

    boolean onKeyDown(int r10, KeyEvent r11) {
        boolean r12 = true;
        if (r10 == 4) goto L10;
        if (r10 != 82) goto L14;
        onKeyDownPanel(0, r11);
        return true;
    L14:
        return false;
    L10:
        if ((r11.getFlags() & 128) != 0) goto L13;
        r12 = false;
    L13:
        this.mLongPressBackDown = r12;
        goto L14
    }

    boolean onKeyShortcut(int r10, KeyEvent r11) {
        ActionBar r12 = getSupportActionBar();
        if (r12 != null) goto L5;
    L7:
        PanelFeatureState r13 = this.mPreparedPanel;
        if (r13 == null) goto L16;
        if (performPanelShortcut(r13, r11.getKeyCode(), r11, 1) == false) goto L16;
        PanelFeatureState r14 = this.mPreparedPanel;
        if (r14 == null) goto L14;
        r14.isHandled = true;
    L14:
        return true;
    L16:
        if (this.mPreparedPanel != null) goto L20;
        PanelFeatureState r15 = getPanelState(0, true);
        preparePanel(r15, r11);
        boolean r16 = performPanelShortcut(r15, r11.getKeyCode(), r11, 1);
        r15.isPrepared = false;
        if (r16 == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (r12.onKeyShortcut(r10, r11) == false) goto L7;
        return true;
    }

    boolean onKeyUp(int r10, KeyEvent r11) {
        if (r10 == 4) goto L10;
        if (r10 != 82) goto L12;
        onKeyUpPanel(0, r11);
        return true;
    L12:
        return false;
    L10:
        if (onBackPressed() == false) goto L12;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder r10, @NonNull MenuItem r11) {
        Window.Callback r12 = getWindowCallback();
        if (r12 != null) goto L5;
        return false;
    L5:
        if (this.mDestroyed == true) goto L12;
        PanelFeatureState r13 = findMenuPanel(r10.getRootMenu());
        if (r13 != null) goto L9;
        return false;
    L9:
        return r12.onMenuItemSelected(r13.featureId, r11);
    L12:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(@NonNull MenuBuilder r10) {
        reopenMenu(true);
    }

    void onMenuOpened(int r10) {
        if (r10 != 108) goto L8;
        ActionBar r11 = getSupportActionBar();
        if (r11 == null) goto L9;
        r11.dispatchMenuVisibilityChanged(true);
        return;
    L9:
        return;
    }

    void onPanelClosed(int r10) {
        if (r10 != 108) goto L7;
        ActionBar r11 = getSupportActionBar();
        if (r11 == null) goto L12;
        r11.dispatchMenuVisibilityChanged(false);
        return;
    L12:
        return;
    L7:
        if (r10 != 0) goto L14;
        PanelFeatureState r12 = getPanelState(r10, true);
        if (r12.isOpen == false) goto L15;
        closePanel(r12, false);
        return;
    L15:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle r10) {
        ensureSubDecor();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        ActionBar r10 = getSupportActionBar();
        if (r10 == null) goto L6;
        r10.setShowHideAnimationEnabled(true);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle r10) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        applyApplicationSpecificConfig(true, false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        ActionBar r10 = getSupportActionBar();
        if (r10 == null) goto L6;
        r10.setShowHideAnimationEnabled(false);
        return;
    }

    void onSubDecorInstalled(ViewGroup r10) {
    }

    final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int r10) {
        int r11 = sanitizeWindowFeatureId(r10);
        if (this.mWindowNoTitle == false) goto L7;
        if (r11 != 108) goto L7;
        return false;
    L7:
        if (this.mHasActionBar == false) goto L10;
        if (r11 != 1) goto L10;
        this.mHasActionBar = false;
    L10:
        if (r11 != 1) goto L12;
        throwFeatureRequestIfSubDecorInstalled();
        this.mWindowNoTitle = true;
        return true;
    L12:
        if (r11 != 2) goto L14;
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureProgress = true;
        return true;
    L14:
        if (r11 != 5) goto L16;
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureIndeterminateProgress = true;
        return true;
    L16:
        if (r11 == 10) goto L26;
        if (r11 != 108) goto L19;
        throwFeatureRequestIfSubDecorInstalled();
        this.mHasActionBar = true;
        return true;
    L19:
        if (r11 != 109) goto L21;
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    L21:
        return this.mWindow.requestFeature(r11);
    L26:
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionMode = true;
        return true;
    }

    void setConfigurationLocales(Configuration r10, @NonNull LocaleListCompat r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 24) goto L6;
        Api24Impl.setLocales(r10, r11);
        return;
    L6:
        if (r12 < 17) goto L8;
        Api17Impl.setLocale(r10, r11.get(0));
        Api17Impl.setLayoutDirection(r10, r11.get(0));
        return;
    L8:
        r10.locale = r11.get(0);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int r10) {
        ensureSubDecor();
        ViewGroup r11 = (ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        r11.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(r10, r11);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View r10) {
        ensureSubDecor();
        ViewGroup r11 = (ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        r11.removeAllViews();
        r11.addView(r10);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View r10, ViewGroup.LayoutParams r11) {
        ensureSubDecor();
        ViewGroup r12 = (ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        r12.removeAllViews();
        r12.addView(r10, r11);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    void setDefaultLocalesForLocaleList(LocaleListCompat r10) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Api24Impl.setDefaultLocales(r10);
        return;
    L5:
        Locale.setDefault(r10.get(0));
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean r10) {
        this.mHandleNativeActionModes = r10;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @RequiresApi(17)
    public void setLocalNightMode(int r10) {
        if (this.mLocalNightMode == r10) goto L8;
        this.mLocalNightMode = r10;
        if (this.mBaseContextAttached == false) goto L9;
        applyDayNight();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @RequiresApi(33)
    public void setOnBackInvokedDispatcher(@Nullable OnBackInvokedDispatcher r10) {
        super.setOnBackInvokedDispatcher(r10);
        OnBackInvokedDispatcher r11 = this.mDispatcher;
        if (r11 == null) goto L7;
        OnBackInvokedCallback r12 = this.mBackCallback;
        if (r12 == null) goto L7;
        Api33Impl.unregisterOnBackInvokedCallback(r11, r12);
        this.mBackCallback = null;
    L7:
        if (r10 != null) goto L13;
        Object r13 = this.mHost;
        if ((r13 instanceof Activity) == false) goto L13;
        if (((Activity) r13).getWindow() == null) goto L13;
        r10 = Api33Impl.getOnBackInvokedDispatcher((Activity) this.mHost);
    L13:
        this.mDispatcher = r10;
        updateBackInvokedCallbackState();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar r10) {
        if ((this.mHost instanceof Activity) == true) goto L5;
        return;
    L5:
        ActionBar r11 = getSupportActionBar();
        if ((r11 instanceof WindowDecorActionBar) == true) goto L17;
        this.mMenuInflater = null;
        if (r11 == null) goto L10;
        r11.onDestroy();
    L10:
        this.mActionBar = null;
        if (r10 == null) goto L13;
        ToolbarActionBar r12 = new ToolbarActionBar(r10, getTitle(), this.mAppCompatWindowCallback);
        this.mActionBar = r12;
        this.mAppCompatWindowCallback.setActionBarCallback(r12.mMenuCallback);
        r10.setBackInvokedCallbackEnabled(true);
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
    public void setTheme(@StyleRes int r10) {
        this.mThemeResId = r10;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence r10) {
        this.mTitle = r10;
        DecorContentParent r11 = this.mDecorContentParent;
        if (r11 == null) goto L6;
        r11.setWindowTitle(r10);
        return;
    L6:
        if (peekSupportActionBar() == null) goto L8;
        peekSupportActionBar().setWindowTitle(r10);
        return;
    L8:
        TextView r12 = this.mTitleView;
        if (r12 == null) goto L14;
        r12.setText(r10);
        return;
    }

    final boolean shouldAnimateActionModeView() {
        if (this.mSubDecorInstalled == false) goto L9;
        ViewGroup r10 = this.mSubDecor;
        if (r10 == null) goto L9;
        if (ViewCompat.isLaidOut(r10) == false) goto L9;
        return true;
    L9:
        return false;
    }

    boolean shouldRegisterBackInvokedCallback() {
        if (this.mDispatcher != null) goto L5;
        return false;
    L5:
        PanelFeatureState r10 = getPanelState(0, false);
        if (r10 == null) goto L11;
        if (r10.isOpen == false) goto L11;
        return true;
    L11:
        if (this.mActionMode == null) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback r10) {
        if (r10 == null) goto L19;
        ActionMode r11 = this.mActionMode;
        if (r11 == null) goto L6;
        r11.finish();
    L6:
        ActionModeCallbackWrapperV9 r12 = new ActionModeCallbackWrapperV9(this, r10);
        ActionBar r13 = getSupportActionBar();
        if (r13 == null) goto L14;
        ActionMode r14 = r13.startActionMode(r12);
        this.mActionMode = r14;
        if (r14 == null) goto L14;
        AppCompatCallback r15 = this.mAppCompatCallback;
        if (r15 == null) goto L14;
        r15.onSupportActionModeStarted(r14);
    L14:
        if (this.mActionMode != null) goto L16;
        this.mActionMode = startSupportActionModeFromWindow(r12);
    L16:
        updateBackInvokedCallbackState();
        return this.mActionMode;
    L19:
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    ActionMode startSupportActionModeFromWindow(@NonNull ActionMode.Callback r10) {
        endOnGoingFadeAnimation();
        ActionMode r11 = this.mActionMode;
        if (r11 == null) goto L6;
        r11.finish();
    L6:
        if ((r10 instanceof ActionModeCallbackWrapperV9) == true) goto L8;
        r10 = new ActionModeCallbackWrapperV9(this, r10);
    L8:
        AppCompatCallback r12 = this.mAppCompatCallback;
        if (r12 != null) goto L11;
    L14:
        ActionMode r13 = null;
    L15:
        if (r13 == null) goto L17;
        this.mActionMode = r13;
    L47:
        ActionMode r14 = this.mActionMode;
        if (r14 == null) goto L52;
        AppCompatCallback r15 = this.mAppCompatCallback;
        if (r15 == null) goto L52;
        r15.onSupportActionModeStarted(r14);
    L52:
        updateBackInvokedCallbackState();
        return this.mActionMode;
    L17:
        boolean r16 = true;
        if (this.mActionModeView != null) goto L30;
        if (this.mIsFloating == false) goto L26;
        TypedValue r17 = new TypedValue();
        Resources.Theme r18 = this.mContext.getTheme();
        r18.resolveAttribute(R.attr.actionBarTheme, r17, true);
        if (r17.resourceId == 0) goto L24;
        Resources.Theme r19 = this.mContext.getResources().newTheme();
        r19.setTo(r18);
        r19.applyStyle(r17.resourceId, true);
        Context r20 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, 0);
        r20.getTheme().setTo(r19);
    L25:
        this.mActionModeView = new ActionBarContextView(r20);
        PopupWindow r21 = new PopupWindow(r20, null, R.attr.actionModePopupWindowStyle);
        this.mActionModePopup = r21;
        PopupWindowCompat.setWindowLayoutType(r21, 2);
        this.mActionModePopup.setContentView(this.mActionModeView);
        this.mActionModePopup.setWidth(-1);
        r20.getTheme().resolveAttribute(R.attr.actionBarSize, r17, true);
        this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(r17.data, r20.getResources().getDisplayMetrics()));
        this.mActionModePopup.setHeight(-2);
        this.mShowActionModePopup = new AnonymousClass6(this);
        goto L30
    L24:
        r20 = this.mContext;
        goto L25
    L26:
        ViewStubCompat r22 = (ViewStubCompat) this.mSubDecor.findViewById(R.id.action_mode_bar_stub);
        if (r22 == null) goto L30;
        r22.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
        this.mActionModeView = (ActionBarContextView) r22.inflate();
    L30:
        if (this.mActionModeView == null) goto L47;
        endOnGoingFadeAnimation();
        this.mActionModeView.killMode();
        Context r23 = this.mActionModeView.getContext();
        ActionBarContextView r24 = this.mActionModeView;
        if (this.mActionModePopup == null) goto L35;
        r16 = false;
    L35:
        StandaloneActionMode r25 = new StandaloneActionMode(r23, r24, r10, r16);
        if (r10.onCreateActionMode(r25, r25.getMenu()) == false) goto L46;
        r25.invalidate();
        this.mActionModeView.initForMode(r25);
        this.mActionMode = r25;
        if (shouldAnimateActionModeView() == false) goto L40;
        this.mActionModeView.setAlpha(0.0f);
        ViewPropertyAnimatorCompat r26 = ViewCompat.animate(this.mActionModeView).alpha(1.0f);
        this.mFadeAnim = r26;
        r26.setListener(new AnonymousClass7(this));
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
        r13 = r12.onWindowStartingSupportActionMode(r10);     // Catch: AbstractMethodError -> L54
        goto L15
    }

    void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT < 33) goto L14;
        boolean r10 = shouldRegisterBackInvokedCallback();
        if (r10 == true) goto L7;
    L9:
        if (r10 == true) goto L16;
        OnBackInvokedCallback r11 = this.mBackCallback;
        if (r11 == null) goto L17;
        Api33Impl.unregisterOnBackInvokedCallback(this.mDispatcher, r11);
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

    final int updateStatusGuard(@Nullable WindowInsetsCompat r11, @Nullable Rect r12) {
        int r10 = 0;
        if (r11 == null) goto L5;
        int r13 = r11.getSystemWindowInsetTop();
    L8:
        ActionBarContextView r14 = this.mActionModeView;
        if (r14 != null) goto L11;
    L69:
        boolean r15 = false;
    L70:
        View r16 = this.mStatusGuard;
        if (r16 == null) goto L76;
        if (r15 == true) goto L75;
        r10 = 8;
    L75:
        r16.setVisibility(r10);
    L76:
        return r13;
    L11:
        if ((r14.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L69;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
        boolean r18 = true;
        if (this.mActionModeView.isShown() == false) goto L64;
        if (this.mTempRect1 != null) goto L17;
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
    L17:
        Rect r19 = this.mTempRect1;
        Rect r20 = this.mTempRect2;
        if (r11 != null) goto L20;
        r19.set(r12);
    L21:
        ViewUtils.computeFitSystemWindows(this.mSubDecor, r19, r20);
        int r110 = r19.top;
        int r111 = r19.left;
        int r21 = r19.right;
        WindowInsetsCompat r22 = ViewCompat.getRootWindowInsets(this.mSubDecor);
        if (r22 != null) goto L24;
        int r23 = 0;
    L25:
        if (r22 != null) goto L27;
        int r24 = 0;
    L29:
        if (r17.topMargin == r110) goto L31;
    L36:
        r17.topMargin = r110;
        r17.leftMargin = r111;
        r17.rightMargin = r21;
        boolean r112 = true;
    L37:
        if (r110 > 0) goto L39;
    L41:
        View r113 = this.mStatusGuard;
        if (r113 == null) goto L50;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113.getLayoutParams();
        int r25 = r114.height;
        int r26 = r17.topMargin;
        if (r25 == r26) goto L46;
    L49:
        r114.height = r26;
        r114.leftMargin = r23;
        r114.rightMargin = r24;
        this.mStatusGuard.setLayoutParams(r114);
        goto L50
    L46:
        if (r114.leftMargin != r23) goto L49;
        if (r114.rightMargin != r24) goto L49;
    L50:
        View r115 = this.mStatusGuard;
        if (r115 != null) goto L54;
        r18 = false;
    L54:
        if (r18 == false) goto L59;
        if (r115.getVisibility() == 0) goto L59;
        updateStatusGuardColor(this.mStatusGuard);
    L59:
        if (this.mOverlayActionMode == true) goto L62;
        if (r18 == false) goto L62;
        r13 = 0;
    L62:
        r15 = r18;
        r18 = r112;
    L67:
        if (r18 == false) goto L70;
        this.mActionModeView.setLayoutParams(r17);
        goto L70
    L39:
        if (this.mStatusGuard != null) goto L41;
        View r116 = new View(this.mContext);
        this.mStatusGuard = r116;
        r116.setVisibility(8);
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-1, r17.topMargin, 51);
        r117.leftMargin = r23;
        r117.rightMargin = r24;
        this.mSubDecor.addView(this.mStatusGuard, -1, r117);
        goto L50
    L31:
        if (r17.leftMargin != r111) goto L36;
        if (r17.rightMargin != r21) goto L36;
        r112 = false;
        goto L37
    L27:
        r24 = r22.getSystemWindowInsetRight();
        goto L29
    L24:
        r23 = r22.getSystemWindowInsetLeft();
        goto L25
    L20:
        r19.set(r11.getSystemWindowInsetLeft(), r11.getSystemWindowInsetTop(), r11.getSystemWindowInsetRight(), r11.getSystemWindowInsetBottom());
        goto L21
    L64:
        if (r17.topMargin == 0) goto L66;
        r17.topMargin = 0;
        r15 = false;
        goto L67
    L66:
        r15 = false;
        r18 = false;
        goto L67
    L5:
        if (r12 == null) goto L7;
        r13 = r12.top;
        goto L8
    L7:
        r13 = 0;
        goto L8
    }
}
