package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class AppCompatDelegateImpl extends AppCompatDelegate implements LayoutInflater.Factory2, MenuBuilder.Callback {
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

        ActionBarDrawableToggleImpl(AppCompatDelegateImpl r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getActionBarThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TintTypedArray r4 = TintTypedArray.obtainStyledAttributes((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActionBarThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null, new int[]{ZeusTransformUtils.mapRes(R.attr.homeAsUpIndicator, "attr", "homeAsUpIndicator")});
            Drawable r0 = r4.getDrawable(0);
            r4.recycle();
            return r0;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            ActionBar r0 = this.this$0.getSupportActionBar();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if ((r0.getDisplayOptions() & 4) == 0) goto L7;
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r1) {
            ActionBar r0 = this.this$0.getSupportActionBar();
            if (r0 == null) goto L6;
            r0.setHomeActionContentDescription(r1);
            return;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r1, int r2) {
            ActionBar r0 = this.this$0.getSupportActionBar();
            if (r0 == null) goto L6;
            r0.setHomeAsUpIndicator(r1);
            r0.setHomeActionContentDescription(r2);
            return;
        }
    }

    interface ActionBarMenuCallback {
        View onCreatePanelView(int r1);

        boolean onPreparePanel(int r1);
    }

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        ActionMenuPresenterCallback(AppCompatDelegateImpl r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r1, boolean r2) {
            this.this$0.checkCloseActionMenu(r1);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r2) {
            Window.Callback r1 = this.this$0.getWindowCallback();
            if (r1 == null) goto L7;
            r1.onMenuOpened(108, r2);
            return true;
        L7:
            return true;
        }
    }

    class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionModeCallbackWrapperV9(AppCompatDelegateImpl r3, ActionMode.Callback r4) {
            ActionMode.Callback r5 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r4, ActionMode.Callback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mWrapped = r5;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r3, MenuItem r4) {
            MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
            return this.mWrapped.onActionItemClicked(r3, r5);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            return this.mWrapped.onCreateActionMode(r3, r5);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r3) {
            this.mWrapped.onDestroyActionMode(r3);
            if (this.this$0.mActionModePopup == null) goto L6;
            this.this$0.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
        L6:
            if (this.this$0.mActionModeView == null) goto L9;
            this.this$0.endOnGoingFadeAnimation();
            AppCompatDelegateImpl r4 = this.this$0;
            r4.mFadeAnim = ViewCompat.animate(r4.mActionModeView).alpha(0.0f);
            this.this$0.mFadeAnim.setListener(new AnonymousClass1(this));
        L9:
            if (this.this$0.mAppCompatCallback == null) goto L11;
            this.this$0.mAppCompatCallback.onSupportActionModeFinished(this.this$0.mActionMode);
        L11:
            this.this$0.mActionMode = null;
            ViewCompat.requestApplyInsets(this.this$0.mSubDecor);
            this.this$0.updateBackInvokedCallbackState();
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            ViewCompat.requestApplyInsets(this.this$0.mSubDecor);
            return this.mWrapped.onPrepareActionMode(r3, r5);
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Context createConfigurationContext(Context r2, Configuration r3) {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).createConfigurationContext(r3), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        }

        static void generateConfigDelta_densityDpi(Configuration r1, Configuration r2, Configuration r3) {
            if (r1.densityDpi == r2.densityDpi) goto L6;
            r3.densityDpi = r2.densityDpi;
            return;
        }

        static void setLayoutDirection(Configuration r0, Locale r1) {
            r0.setLayoutDirection(r1);
        }

        static void setLocale(Configuration r0, Locale r1) {
            r0.setLocale(r1);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean isPowerSaveMode(PowerManager r0) {
            return r0.isPowerSaveMode();
        }

        static String toLanguageTag(Locale r0) {
            return r0.toLanguageTag();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void generateConfigDelta_locale(Configuration r1, Configuration r2, Configuration r3) {
            LocaleList r4 = r1.getLocales();
            LocaleList r0 = r2.getLocales();
            if (r4.equals(r0) == true) goto L6;
            r3.setLocales(r0);
            r3.locale = r2.locale;
            return;
        }

        static LocaleListCompat getLocales(Configuration r0) {
            return LocaleListCompat.forLanguageTags(r0.getLocales().toLanguageTags());
        }

        public static void setDefaultLocales(LocaleListCompat r0) {
            LocaleList.setDefault(LocaleList.forLanguageTags(r0.toLanguageTags()));
        }

        static void setLocales(Configuration r0, LocaleListCompat r1) {
            r0.setLocales(LocaleList.forLanguageTags(r1.toLanguageTags()));
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void generateConfigDelta_colorMode(Configuration r2, Configuration r3, Configuration r4) {
            if ((r2.colorMode & 3) == (r3.colorMode & 3)) goto L6;
            r4.colorMode |= r3.colorMode & 3;
        L6:
            if ((r2.colorMode & 12) == (r3.colorMode & 12)) goto L9;
            r4.colorMode |= r3.colorMode & 12;
            return;
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity r2) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback registerOnBackPressedCallback(Object r2, final AppCompatDelegateImpl r3) {
            Objects.requireNonNull(r3);
            OnBackInvokedCallback r0 = new $$Lambda$KohrZ7UvY8rXg9JPBZsbvgnAMyM(r3);
            ((OnBackInvokedDispatcher) ZeusTransformUtils.preCheckCast(r2, OnBackInvokedDispatcher.class, "com.obric.memorydata.plugin")).registerOnBackInvokedCallback(1000000, r0);
            return r0;
        }

        static void unregisterOnBackInvokedCallback(Object r2, Object r3) {
            OnBackInvokedCallback r4 = (OnBackInvokedCallback) ZeusTransformUtils.preCheckCast(r3, OnBackInvokedCallback.class, "com.obric.memorydata.plugin");
            ((OnBackInvokedDispatcher) ZeusTransformUtils.preCheckCast(r2, OnBackInvokedDispatcher.class, "com.obric.memorydata.plugin")).unregisterOnBackInvokedCallback(r4);
        }
    }

    class AppCompatWindowCallback extends WindowCallbackWrapper {
        private ActionBarMenuCallback mActionBarCallback;
        private boolean mDispatchKeyEventBypassEnabled;
        private boolean mOnContentChangedBypassEnabled;
        private boolean mOnPanelClosedBypassEnabled;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        AppCompatWindowCallback(AppCompatDelegateImpl r3, Window.Callback r4) {
            Window.Callback r5 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r4, Window.Callback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        public boolean bypassDispatchKeyEvent(Window.Callback r3, KeyEvent r4) {
            Window.Callback r5 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.memorydata.plugin");
            this.mDispatchKeyEventBypassEnabled = true;     // Catch: Throwable -> L6
            boolean r6 = r5.dispatchKeyEvent(r4);     // Catch: Throwable -> L6
            this.mDispatchKeyEventBypassEnabled = false;
            return r6;
        L6:
            th = move-exception;
            this.mDispatchKeyEventBypassEnabled = false;
            throw th;
        }

        public void bypassOnContentChanged(Window.Callback r3) {
            Window.Callback r4 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.memorydata.plugin");
            this.mOnContentChangedBypassEnabled = true;     // Catch: Throwable -> L6
            r4.onContentChanged();     // Catch: Throwable -> L6
            this.mOnContentChangedBypassEnabled = false;
            return;
        L6:
            th = move-exception;
            this.mOnContentChangedBypassEnabled = false;
            throw th;
        }

        public void bypassOnPanelClosed(Window.Callback r3, int r4, Menu r5) {
            Window.Callback r6 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.memorydata.plugin");
            Menu r7 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.memorydata.plugin");
            this.mOnPanelClosedBypassEnabled = true;     // Catch: Throwable -> L6
            r6.onPanelClosed(r4, r7);     // Catch: Throwable -> L6
            this.mOnPanelClosedBypassEnabled = false;
            return;
        L6:
            th = move-exception;
            this.mOnPanelClosedBypassEnabled = false;
            throw th;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r2) {
            if (this.mDispatchKeyEventBypassEnabled == false) goto L7;
            return getWrapped().dispatchKeyEvent(r2);
        L7:
            if (this.this$0.dispatchKeyEvent(r2) == false) goto L9;
        L12:
            return true;
        L9:
            if (super.dispatchKeyEvent(r2) == true) goto L12;
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
            if (super.dispatchKeyShortcutEvent(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.this$0.onKeyShortcut(r2.getKeyCode(), r2) == true) goto L8;
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
            if (this.mOnContentChangedBypassEnabled == false) goto L6;
            getWrapped().onContentChanged();
            return;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            if (r3 != 0) goto L9;
            if (ZeusTransformUtils.instanceOf(r5, MenuBuilder.class) == true) goto L9;
            return false;
        L9:
            return super.onCreatePanelMenu(r3, r5);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int r2) {
            ActionBarMenuCallback r0 = this.mActionBarCallback;
            if (r0 == null) goto L8;
            View r1 = r0.onCreatePanelView(r2);
            if (r1 == null) goto L8;
            return r1;
        L8:
            return super.onCreatePanelView(r2);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int r3, Menu r4) {
            super.onMenuOpened(r3, (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin"));
            this.this$0.onMenuOpened(r3);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            if (this.mOnPanelClosedBypassEnabled == false) goto L6;
            getWrapped().onPanelClosed(r3, r5);
            return;
        L6:
            super.onPanelClosed(r3, r5);
            this.this$0.onPanelClosed(r3);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int r5, View r6, Menu r7) {
            Menu r8 = (Menu) ZeusTransformUtils.wrapperContextForParams(r7, Menu.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, MenuBuilder.class) == false) goto L5;
            MenuBuilder r0 = (MenuBuilder) ZeusTransformUtils.preCheckCast(r8, MenuBuilder.class, "com.obric.memorydata.plugin");
        L7:
            if (r5 != 0) goto L10;
            if (r0 != null) goto L10;
            return false;
        L10:
            boolean r2 = true;
            if (r0 == null) goto L13;
            r0.setOverrideVisibleItems(true);
        L13:
            ActionBarMenuCallback r3 = this.mActionBarCallback;
            if (r3 != null) goto L16;
        L18:
            r2 = false;
        L19:
            if (r2 == true) goto L21;
            r2 = super.onPreparePanel(r5, r6, r8);
        L21:
            if (r0 == null) goto L23;
            r0.setOverrideVisibleItems(false);
        L23:
            return r2;
        L16:
            if (r3.onPreparePanel(r5) == false) goto L18;
        L5:
            r0 = null;
            goto L7
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r4, Menu r5, int r6) {
            List<KeyboardShortcutGroup> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Menu r8 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.memorydata.plugin");
            PanelFeatureState r0 = this.this$0.getPanelState(0, true);
            if (r0 != null) goto L5;
        L7:
            super.onProvideKeyboardShortcuts(r7, r8, r6);
            return;
        L5:
            if (r0.menu == null) goto L7;
            r8 = r0.menu;
            goto L7
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r3) {
            android.view.ActionMode.Callback r4 = (android.view.ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, android.view.ActionMode.Callback.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 23) goto L7;
            return null;
        L7:
            if (this.this$0.isHandleNativeActionModesEnabled() == false) goto L11;
            return startAsSupportActionMode(r4);
        L11:
            return super.onWindowStartingActionMode(r4);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r3, int r4) {
            android.view.ActionMode.Callback r5 = (android.view.ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, android.view.ActionMode.Callback.class, "com.obric.memorydata.plugin");
            if (this.this$0.isHandleNativeActionModesEnabled() == false) goto L9;
            if (r4 != 0) goto L9;
            return startAsSupportActionMode(r5);
        L9:
            return super.onWindowStartingActionMode(r5, r4);
        }

        void setActionBarCallback(ActionBarMenuCallback r3) {
            this.mActionBarCallback = (ActionBarMenuCallback) ZeusTransformUtils.wrapperContextForParams(r3, ActionBarMenuCallback.class, "com.obric.memorydata.plugin");
        }

        final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback r3) {
            android.view.ActionMode.Callback r4 = (android.view.ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, android.view.ActionMode.Callback.class, "com.obric.memorydata.plugin");
            SupportActionModeWrapper.CallbackWrapper r0 = new SupportActionModeWrapper.CallbackWrapper(this.this$0.mContext, r4);
            ActionMode r2 = this.this$0.startSupportActionMode(r0);
            if (r2 != null) goto L5;
            return null;
        L5:
            return r0.getActionModeWrapper(r2);
        }
    }

    private class AutoBatteryNightModeManager extends AutoNightModeManager {
        private final PowerManager mPowerManager;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        AutoBatteryNightModeManager(AppCompatDelegateImpl r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r3);
            this.mPowerManager = (PowerManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter createIntentFilterForBroadcastReceiver() {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            IntentFilter r1 = new IntentFilter();
            r1.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return r1;
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

    abstract class AutoNightModeManager {
        private PluginBroadcastReceiver mReceiver;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        AutoNightModeManager(AppCompatDelegateImpl r1) {
            this.this$0 = r1;
        }

        void cleanup() {
            if (this.mReceiver == null) goto L10;
            ZeusTransformUtils.unregisterReceiver(this.this$0.mContext, this.mReceiver, "com.obric.memorydata.plugin");     // Catch: IllegalArgumentException -> L7
        L5:
            this.mReceiver = null;
            return;
        }

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
            IntentFilter r0 = createIntentFilterForBroadcastReceiver();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.countActions() != 0) goto L8;
            return;
        L8:
            if (this.mReceiver != null) goto L10;
            this.mReceiver = new AnonymousClass1(this);
        L10:
            ZeusTransformUtils.registerReceiver(this.this$0.mContext, this.mReceiver, r0, "com.obric.memorydata.plugin");
        }
    }

    private class AutoTimeNightModeManager extends AutoNightModeManager {
        private final TwilightManager mTwilightManager;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        AutoTimeNightModeManager(AppCompatDelegateImpl r1, TwilightManager r2) {
            this.this$0 = r1;
            super(r1);
            this.mTwilightManager = r2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter r1 = new IntentFilter();
            r1.addAction("android.intent.action.TIME_SET");
            r1.addAction("android.intent.action.TIMEZONE_CHANGED");
            r1.addAction("android.intent.action.TIME_TICK");
            return r1;
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

    private static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        static void applyOverrideConfiguration(ContextThemeWrapper r2, Configuration r3) {
            ((ContextThemeWrapper) ZeusTransformUtils.wrapperContextForParams(r2, ContextThemeWrapper.class, "com.obric.memorydata.plugin")).applyOverrideConfiguration(r3);
        }
    }

    private class ListMenuDecorView extends ContentFrameLayout {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ListMenuDecorView(AppCompatDelegateImpl r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        private boolean isOutOfBounds(int r2, int r3) {
            if (r2 < (-5)) goto L11;
            if (r3 < (-5)) goto L11;
            if (r2 > (getWidth() + 5)) goto L11;
            if (r3 > (getHeight() + 5)) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent r2) {
            if (this.this$0.dispatchKeyEvent(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.dispatchKeyEvent(r2) == true) goto L8;
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r3) {
            if (r3.getAction() != 0) goto L9;
            if (isOutOfBounds((int) r3.getX(), (int) r3.getY()) == false) goto L9;
            this.this$0.closePanel(0);
            return true;
        L9:
            return super.onInterceptTouchEvent(r3);
        }

        @Override // android.view.View
        public void setBackgroundResource(int r4) {
            setBackgroundDrawable(AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
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
        int x;
        int y;

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

            static SavedState readFromParcel(Parcel r3, ClassLoader r4) {
                SavedState r0 = new SavedState();
                r0.featureId = r3.readInt();
                boolean r2 = true;
                if (r3.readInt() == 1) goto L6;
                r2 = false;
            L6:
                r0.isOpen = r2;
                if (r2 == false) goto L9;
                r0.menuState = r3.readBundle(r4);
            L9:
                return r0;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r1, int r2) {
                r1.writeInt(this.featureId);
                r1.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen == false) goto L6;
                r1.writeBundle(this.menuState);
                return;
            }
        }

        PanelFeatureState(int r1) {
            this.featureId = r1;
            this.refreshDecorView = false;
        }

        void applyFrozenState() {
            MenuBuilder r0 = this.menu;
            if (r0 == null) goto L8;
            Bundle r1 = this.frozenMenuState;
            if (r1 == null) goto L9;
            r0.restorePresenterStates(r1);
            this.frozenMenuState = null;
            return;
        L9:
            return;
        }

        public void clearMenuPresenters() {
            MenuBuilder r0 = this.menu;
            if (r0 == null) goto L5;
            r0.removeMenuPresenter(this.listMenuPresenter);
        L5:
            this.listMenuPresenter = null;
        }

        MenuView getListMenuView(MenuPresenter.Callback r6) {
            MenuPresenter.Callback r7 = (MenuPresenter.Callback) ZeusTransformUtils.wrapperContextForParams(r6, MenuPresenter.Callback.class, "com.obric.memorydata.plugin");
            if (this.menu != null) goto L7;
            return null;
        L7:
            if (this.listMenuPresenter != null) goto L10;
            ListMenuPresenter r0 = new ListMenuPresenter(this.listPresenterContext, ZeusTransformUtils.mapRes(R.layout.abc_list_menu_item_layout, "layout", "abc_list_menu_item_layout"));
            this.listMenuPresenter = r0;
            r0.setCallback(r7);
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

        void onRestoreInstanceState(Parcelable r3) {
            SavedState r4 = (SavedState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"), SavedState.class, "com.obric.memorydata.plugin");
            this.featureId = r4.featureId;
            this.wasLastOpen = r4.isOpen;
            this.frozenMenuState = r4.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        Parcelable onSaveInstanceState() {
            SavedState r0 = new SavedState();
            r0.featureId = this.featureId;
            r0.isOpen = this.isOpen;
            if (this.menu == null) goto L5;
            r0.menuState = new Bundle();
            this.menu.savePresenterStates(r0.menuState);
        L5:
            return r0;
        }

        void setMenu(MenuBuilder r3) {
            MenuBuilder r0 = this.menu;
            if (r3 != r0) goto L5;
            return;
        L5:
            if (r0 == null) goto L7;
            r0.removeMenuPresenter(this.listMenuPresenter);
        L7:
            this.menu = r3;
            if (r3 == null) goto L13;
            ListMenuPresenter r2 = this.listMenuPresenter;
            if (r2 == null) goto L14;
            r3.addMenuPresenter(r2);
            return;
        L14:
            return;
        }

        void setStyle(Context r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            TypedValue r0 = new TypedValue();
            Resources.Theme r2 = ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin").newTheme();
            r2.setTo(r9.getTheme());
            r2.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarPopupTheme, "attr", "actionBarPopupTheme"), r0, true);
            if (r0.resourceId == 0) goto L5;
            r2.applyStyle(r0.resourceId, true);
        L5:
            r2.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.panelMenuListTheme, "attr", "panelMenuListTheme"), r0, true);
            if (r0.resourceId == 0) goto L8;
            int r1 = r0.resourceId;
        L9:
            r2.applyStyle(r1, true);
            androidx.appcompat.view.ContextThemeWrapper r3 = new androidx.appcompat.view.ContextThemeWrapper(r9, 0);
            r3.getTheme().setTo(r2);
            this.listPresenterContext = ZeusTransformUtils.wrapperContext(r3, "com.obric.memorydata.plugin");
            TypedArray r10 = r3.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.background = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_panelBackground, "styleable", "AppCompatTheme_panelBackground"), 0);
            this.windowAnimations = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_android_windowAnimationStyle, "styleable", "AppCompatTheme_android_windowAnimationStyle"), 0);
            r10.recycle();
            return;
        L8:
            r1 = ZeusTransformUtils.mapRes(R.style.Theme_AppCompat_CompactMenu, "style", "Theme_AppCompat_CompactMenu");
            goto L9
        }
    }

    private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        PanelMenuPresenterCallback(AppCompatDelegateImpl r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r5, boolean r6) {
            MenuBuilder r0 = r5.getRootMenu();
            if (r0 == r5) goto L5;
            boolean r2 = true;
        L6:
            AppCompatDelegateImpl r3 = this.this$0;
            if (r2 == false) goto L9;
            r5 = r0;
        L9:
            PanelFeatureState r7 = r3.findMenuPanel(r5);
            if (r7 == null) goto L15;
            if (r2 == false) goto L13;
            this.this$0.callOnPanelClosed(r7.featureId, r7, r0);
            this.this$0.closePanel(r7, true);
            return;
        L13:
            this.this$0.closePanel(r7, r6);
            return;
        L15:
            return;
        L5:
            r2 = false;
            goto L6
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r2) {
            if (r2 == r2.getRootMenu()) goto L5;
            return true;
        L5:
            if (this.this$0.mHasActionBar == false) goto L14;
            Window.Callback r0 = this.this$0.getWindowCallback();
            if (r0 != null) goto L9;
            return true;
        L9:
            if (this.this$0.mDestroyed == true) goto L16;
            r0.onMenuOpened(108, r2);
            return true;
        L16:
            return true;
        L14:
            return true;
        }
    }

    static {
        sLocalNightModes = new SimpleArrayMap();
        boolean r1 = false;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        boolean r0 = true;
    L6:
        IS_PRE_LOLLIPOP = r0;
        sWindowBackgroundStyleable = new int[]{android.R.attr.windowBackground};
        sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
        if (Build.VERSION.SDK_INT < 17) goto L9;
        r1 = true;
    L9:
        sCanApplyOverrideConfiguration = r1;
        if (r0 == true) goto L12;
        return;
    L12:
        if (sInstalledExceptionHandler == true) goto L16;
        final Thread.UncaughtExceptionHandler r2 = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new AnonymousClass1(r2));
        sInstalledExceptionHandler = true;
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    AppCompatDelegateImpl(Activity r3, AppCompatCallback r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this(r5, null, (AppCompatCallback) ZeusTransformUtils.wrapperContextForParams(r4, AppCompatCallback.class, "com.obric.memorydata.plugin"), r5);
    }

    AppCompatDelegateImpl(Dialog r4, AppCompatCallback r5) {
        AppCompatCallback r6 = (AppCompatCallback) ZeusTransformUtils.wrapperContextForParams(r5, AppCompatCallback.class, "com.obric.memorydata.plugin");
        this((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4.getWindow(), r6, r4);
    }

    AppCompatDelegateImpl(Context r3, Activity r4, AppCompatCallback r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        this(r6, null, (AppCompatCallback) ZeusTransformUtils.wrapperContextForParams(r5, AppCompatCallback.class, "com.obric.memorydata.plugin"), r7);
    }

    AppCompatDelegateImpl(Context r3, Window r4, AppCompatCallback r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this(r6, r4, (AppCompatCallback) ZeusTransformUtils.wrapperContextForParams(r5, AppCompatCallback.class, "com.obric.memorydata.plugin"), r6);
    }

    private AppCompatDelegateImpl(Context r4, Window r5, AppCompatCallback r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AppCompatCallback r9 = (AppCompatCallback) ZeusTransformUtils.wrapperContextForParams(r6, AppCompatCallback.class, "com.obric.memorydata.plugin");
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        this.mLocalNightMode = -100;
        this.mInvalidatePanelMenuRunnable = new AnonymousClass2(this);
        this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.mAppCompatCallback = r9;
        this.mHost = r7;
        if (this.mLocalNightMode != (-100)) goto L10;
        if (ZeusTransformUtils.instanceOf(r7, Dialog.class) == false) goto L10;
        AppCompatActivity r10 = (AppCompatActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(tryUnwrapContext(), "com.obric.memorydata.plugin"), AppCompatActivity.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L10;
        this.mLocalNightMode = r10.getDelegate().getLocalNightMode();
    L10:
        if (this.mLocalNightMode != (-100)) goto L14;
        SimpleArrayMap<String, Integer> r11 = sLocalNightModes;
        Integer r12 = (Integer) ZeusTransformUtils.preCheckCast(r11.get(r7.getClass().getName()), Integer.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L14;
        this.mLocalNightMode = r12.intValue();
        r11.remove(r7.getClass().getName());
    L14:
        if (r5 == null) goto L16;
        attachToWindow(r5);
    L16:
        AppCompatDrawableManager.preload();
    }

    private boolean applyApplicationSpecificConfig(boolean r2) {
        return applyApplicationSpecificConfig(r2, true);
    }

    private boolean applyApplicationSpecificConfig(boolean r6, boolean r7) {
        if (this.mDestroyed == false) goto L6;
        return false;
    L6:
        int r0 = calculateNightMode();
        int r1 = mapNightMode(this.mContext, r0);
        LocaleListCompat r2 = null;
        if (Build.VERSION.SDK_INT >= 33) goto L9;
        r2 = calculateApplicationLocales(this.mContext);
    L9:
        if (r7 == true) goto L12;
        if (r2 == null) goto L12;
        r2 = getConfigurationLocales(ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getConfiguration());
    L12:
        boolean r8 = updateAppConfiguration(r1, r2, r6);
        if (r0 != 0) goto L15;
        getAutoTimeNightModeManager(this.mContext).setup();
    L19:
        if (r0 != 3) goto L21;
        getAutoBatteryNightModeManager(this.mContext).setup();
    L24:
        return r8;
    L21:
        AutoNightModeManager r5 = this.mAutoBatteryNightModeManager;
        if (r5 == null) goto L24;
        r5.cleanup();
        goto L24
    L15:
        AutoNightModeManager r9 = this.mAutoTimeNightModeManager;
        if (r9 == null) goto L19;
        r9.cleanup();
        goto L19
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout r0 = (ContentFrameLayout) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(android.R.id.content), ContentFrameLayout.class, "com.obric.memorydata.plugin");
        View r1 = this.mWindow.getDecorView();
        r0.setDecorPadding(r1.getPaddingLeft(), r1.getPaddingTop(), r1.getPaddingRight(), r1.getPaddingBottom());
        TypedArray r5 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowMinWidthMajor, "styleable", "AppCompatTheme_windowMinWidthMajor"), r0.getMinWidthMajor());
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowMinWidthMinor, "styleable", "AppCompatTheme_windowMinWidthMinor"), r0.getMinWidthMinor());
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedWidthMajor, "styleable", "AppCompatTheme_windowFixedWidthMajor")) == false) goto L6;
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedWidthMajor, "styleable", "AppCompatTheme_windowFixedWidthMajor"), r0.getFixedWidthMajor());
    L6:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedWidthMinor, "styleable", "AppCompatTheme_windowFixedWidthMinor")) == false) goto L9;
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedWidthMinor, "styleable", "AppCompatTheme_windowFixedWidthMinor"), r0.getFixedWidthMinor());
    L9:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedHeightMajor, "styleable", "AppCompatTheme_windowFixedHeightMajor")) == false) goto L12;
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedHeightMajor, "styleable", "AppCompatTheme_windowFixedHeightMajor"), r0.getFixedHeightMajor());
    L12:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedHeightMinor, "styleable", "AppCompatTheme_windowFixedHeightMinor")) == false) goto L14;
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedHeightMinor, "styleable", "AppCompatTheme_windowFixedHeightMinor"), r0.getFixedHeightMinor());
    L14:
        r5.recycle();
        r0.requestLayout();
    }

    private void attachToWindow(Window r4) {
        if (this.mWindow != null) goto L18;
        Window.Callback r0 = r4.getCallback();
        if (ZeusTransformUtils.instanceOf(r0, AppCompatWindowCallback.class) == true) goto L16;
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
        int r1 = this.mLocalNightMode;
        if (r1 == (-100)) goto L6;
        return r1;
    L6:
        return getDefaultNightMode();
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

    private Configuration createOverrideAppConfiguration(Context r3, int r4, LocaleListCompat r5, Configuration r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != 1) goto L5;
        int r9 = 16;
    L11:
        Configuration r10 = new Configuration();
        r10.fontScale = 0.0f;
        if (r6 == null) goto L14;
        r10.setTo(r6);
    L14:
        r10.uiMode = r9 | (r10.uiMode & (-49));
        if (r5 == null) goto L17;
        setConfigurationLocales(r10, r5);
    L17:
        return r10;
    L5:
        if (r4 == 2) goto L9;
        if (r7 == false) goto L8;
        r9 = 0;
        goto L11
    L8:
        r9 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().uiMode & 48;
        goto L11
    L9:
        r9 = 32;
        goto L11
    }

    private ViewGroup createSubDecor() {
        TypedArray r0 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (r0.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowActionBar, "styleable", "AppCompatTheme_windowActionBar")) == true) goto L5;
        r0.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    L5:
        if (r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowNoTitle, "styleable", "AppCompatTheme_windowNoTitle"), false) == false) goto L8;
        requestWindowFeature(1);
    L11:
        if (r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowActionBarOverlay, "styleable", "AppCompatTheme_windowActionBarOverlay"), false) == false) goto L14;
        requestWindowFeature(109);
    L14:
        if (r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowActionModeOverlay, "styleable", "AppCompatTheme_windowActionModeOverlay"), false) == false) goto L16;
        requestWindowFeature(10);
    L16:
        this.mIsFloating = r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_android_windowIsFloating, "styleable", "AppCompatTheme_android_windowIsFloating"), false);
        r0.recycle();
        ensureWindow();
        this.mWindow.getDecorView();
        LayoutInflater r1 = LayoutInflater.from(this.mContext);
        if (this.mWindowNoTitle == true) goto L38;
        if (this.mIsFloating == false) goto L22;
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r1, ZeusTransformUtils.mapRes(R.layout.abc_dialog_title_material, "layout", "abc_dialog_title_material"), null, "com.obric.memorydata.plugin"), ViewGroup.class, "com.obric.memorydata.plugin");
        this.mOverlayActionBar = false;
        this.mHasActionBar = false;
    L42:
        if (r2 == null) goto L63;
        if (Build.VERSION.SDK_INT < 21) goto L47;
        ViewCompat.setOnApplyWindowInsetsListener(r2, new AnonymousClass3(this));
    L50:
        if (this.mDecorContentParent != null) goto L52;
        this.mTitleView = (TextView) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title")), TextView.class, "com.obric.memorydata.plugin");
    L52:
        ViewUtils.makeOptionalFitsSystemWindows(r2);
        ContentFrameLayout r3 = (ContentFrameLayout) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_activity_content, OaidModel.KEY_ID, "action_bar_activity_content")), ContentFrameLayout.class, "com.obric.memorydata.plugin");
        ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mWindow.findViewById(android.R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L55;
    L60:
        this.mWindow.setContentView(r2);
        r3.setAttachListener(new AnonymousClass5(this));
        return r2;
    L55:
        if (r4.getChildCount() <= 0) goto L57;
        View r5 = r4.getChildAt(0);
        r4.removeViewAt(0);
        r3.addView(r5);
        goto L55
    L57:
        r4.setId(-1);
        r3.setId(android.R.id.content);
        if (ZeusTransformUtils.instanceOf(r4, FrameLayout.class) == false) goto L60;
        ((FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.memorydata.plugin")).setForeground(null);
        goto L60
    L47:
        if (ZeusTransformUtils.instanceOf(r2, FitWindowsViewGroup.class) == false) goto L50;
        ((FitWindowsViewGroup) ZeusTransformUtils.preCheckCast(r2, FitWindowsViewGroup.class, "com.obric.memorydata.plugin")).setOnFitSystemWindowsListener(new AnonymousClass4(this));
        goto L50
    L63:
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
    L22:
        if (this.mHasActionBar == false) goto L36;
        TypedValue r6 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarTheme, "attr", "actionBarTheme"), r6, true);
        if (r6.resourceId == 0) goto L26;
        Context r7 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, r6.resourceId);
    L27:
        r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(R.layout.abc_screen_toolbar, "layout", "abc_screen_toolbar"), null, "com.obric.memorydata.plugin"), ViewGroup.class, "com.obric.memorydata.plugin");
        DecorContentParent r8 = (DecorContentParent) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.decor_content_parent, OaidModel.KEY_ID, "decor_content_parent")), DecorContentParent.class, "com.obric.memorydata.plugin");
        this.mDecorContentParent = r8;
        r8.setWindowCallback(getWindowCallback());
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
        r7 = this.mContext;
        goto L27
    L36:
        r2 = null;
        goto L42
    L38:
        if (this.mOverlayActionMode == false) goto L40;
        int r9 = R.layout.abc_screen_simple_overlay_action_mode;
        String r10 = "abc_screen_simple_overlay_action_mode";
    L41:
        r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r1, ZeusTransformUtils.mapRes(r9, "layout", r10), null, "com.obric.memorydata.plugin"), ViewGroup.class, "com.obric.memorydata.plugin");
        goto L42
    L40:
        r9 = R.layout.abc_screen_simple;
        r10 = "abc_screen_simple";
        goto L41
    L8:
        if (r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowActionBar, "styleable", "AppCompatTheme_windowActionBar"), false) == false) goto L11;
        requestWindowFeature(108);
        goto L11
    }

    private void ensureSubDecor() {
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
        if (this.mDestroyed == true) goto L23;
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

    private void ensureWindow() {
        if (this.mWindow != null) goto L8;
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L8;
        attachToWindow(ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin"));
    L8:
        if (this.mWindow == null) goto L11;
        return;
    L11:
        throw new IllegalStateException("We have not been given a Window");
    }

    private static Configuration generateConfigDelta(Configuration r3, Configuration r4) {
        Configuration r0 = new Configuration();
        r0.fontScale = 0.0f;
        if (r4 != null) goto L5;
    L73:
        return r0;
    L5:
        if (r3.diff(r4) == 0) goto L73;
        if (r3.fontScale == r4.fontScale) goto L11;
        r0.fontScale = r4.fontScale;
    L11:
        if (r3.mcc == r4.mcc) goto L14;
        r0.mcc = r4.mcc;
    L14:
        if (r3.mnc == r4.mnc) goto L17;
        r0.mnc = r4.mnc;
    L17:
        if (Build.VERSION.SDK_INT < 24) goto L20;
        Api24Impl.generateConfigDelta_locale(r3, r4, r0);
    L23:
        if (r3.touchscreen == r4.touchscreen) goto L26;
        r0.touchscreen = r4.touchscreen;
    L26:
        if (r3.keyboard == r4.keyboard) goto L29;
        r0.keyboard = r4.keyboard;
    L29:
        if (r3.keyboardHidden == r4.keyboardHidden) goto L32;
        r0.keyboardHidden = r4.keyboardHidden;
    L32:
        if (r3.navigation == r4.navigation) goto L35;
        r0.navigation = r4.navigation;
    L35:
        if (r3.navigationHidden == r4.navigationHidden) goto L38;
        r0.navigationHidden = r4.navigationHidden;
    L38:
        if (r3.orientation == r4.orientation) goto L41;
        r0.orientation = r4.orientation;
    L41:
        if ((r3.screenLayout & 15) == (r4.screenLayout & 15)) goto L44;
        r0.screenLayout |= r4.screenLayout & 15;
    L44:
        if ((r3.screenLayout & 192) == (r4.screenLayout & 192)) goto L47;
        r0.screenLayout |= r4.screenLayout & 192;
    L47:
        if ((r3.screenLayout & 48) == (r4.screenLayout & 48)) goto L50;
        r0.screenLayout |= r4.screenLayout & 48;
    L50:
        if ((r3.screenLayout & 768) == (r4.screenLayout & 768)) goto L53;
        r0.screenLayout |= r4.screenLayout & 768;
    L53:
        if (Build.VERSION.SDK_INT < 26) goto L56;
        Api26Impl.generateConfigDelta_colorMode(r3, r4, r0);
    L56:
        if ((r3.uiMode & 15) == (r4.uiMode & 15)) goto L59;
        r0.uiMode |= r4.uiMode & 15;
    L59:
        if ((r3.uiMode & 48) == (r4.uiMode & 48)) goto L62;
        r0.uiMode |= r4.uiMode & 48;
    L62:
        if (r3.screenWidthDp == r4.screenWidthDp) goto L65;
        r0.screenWidthDp = r4.screenWidthDp;
    L65:
        if (r3.screenHeightDp == r4.screenHeightDp) goto L68;
        r0.screenHeightDp = r4.screenHeightDp;
    L68:
        if (r3.smallestScreenWidthDp == r4.smallestScreenWidthDp) goto L71;
        r0.smallestScreenWidthDp = r4.smallestScreenWidthDp;
    L71:
        if (Build.VERSION.SDK_INT < 17) goto L73;
        Api17Impl.generateConfigDelta_densityDpi(r3, r4, r0);
        goto L73
    L20:
        if (ObjectsCompat.equals(r3.locale, r4.locale) == true) goto L23;
        r0.locale = r4.locale;
        goto L23
    }

    private int getActivityHandlesConfigChangesFlags(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (this.mActivityHandlesConfigFlagsChecked == false) goto L5;
    L22:
        this.mActivityHandlesConfigFlagsChecked = true;
        return this.mActivityHandlesConfigFlags;
    L5:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L22;
        PackageManager r0 = r7.getPackageManager();
        if (r0 != null) goto L24;
        return 0;
    L24:
    L20:
        e = move-exception;
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
        this.mActivityHandlesConfigFlags = 0;
        goto L22
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L13;
        int r2 = 269221888;
    L16:
        ActivityInfo r8 = r0.getActivityInfo(new ComponentName(r7, this.mHost.getClass()), r2);     // Catch: PackageManager.NameNotFoundException -> L20
        if (r8 == null) goto L22;
        this.mActivityHandlesConfigFlags = r8.configChanges;     // Catch: PackageManager.NameNotFoundException -> L20
        goto L22
    L13:
        if (Build.VERSION.SDK_INT < 24) goto L15;
        r2 = 786432;
        goto L16
    L15:
        r2 = 0;
        goto L16
    }

    private AutoNightModeManager getAutoBatteryNightModeManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.mAutoBatteryNightModeManager != null) goto L6;
        this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(this, r4);
    L6:
        return this.mAutoBatteryNightModeManager;
    }

    private AutoNightModeManager getAutoTimeNightModeManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.mAutoTimeNightModeManager != null) goto L6;
        this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(this, TwilightManager.getInstance(r4));
    L6:
        return this.mAutoTimeNightModeManager;
    }

    private void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar == true) goto L5;
        return;
    L5:
        if (this.mActionBar == null) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L12;
        WindowDecorActionBar r0 = new WindowDecorActionBar((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.memorydata.plugin"), this.mOverlayActionBar);
    L10:
        this.mActionBar = r0;
    L14:
        ActionBar r1 = this.mActionBar;
        if (r1 == null) goto L19;
        r1.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        return;
    L19:
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(this.mHost, Dialog.class) == false) goto L14;
        r0 = new WindowDecorActionBar((Dialog) ZeusTransformUtils.preCheckCast(this.mHost, Dialog.class, "com.obric.memorydata.plugin"));
        goto L10
    }

    private boolean initializePanelContent(PanelFeatureState r5) {
        if (r5.createdPanelView == null) goto L7;
        r5.shownPanelView = r5.createdPanelView;
        return true;
    L7:
        if (r5.menu != null) goto L10;
        return false;
    L10:
        if (this.mPanelMenuPresenterCallback != null) goto L12;
        this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(this);
    L12:
        r5.shownPanelView = (View) ZeusTransformUtils.preCheckCast(r5.getListMenuView(this.mPanelMenuPresenterCallback), View.class, "com.obric.memorydata.plugin");
        if (r5.shownPanelView == null) goto L16;
        return true;
    L16:
        return false;
    }

    private boolean initializePanelDecor(PanelFeatureState r4) {
        r4.setStyle((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActionBarThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r4.decorView = new ListMenuDecorView(this, r4.listPresenterContext);
        r4.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState r10) {
        Context r0 = this.mContext;
        if (r10.featureId == 0) goto L7;
        if (r10.featureId == 108) goto L7;
    L19:
        MenuBuilder r1 = new MenuBuilder(r0);
        r1.setCallback(this);
        r10.setMenu(r1);
        return true;
    L7:
        if (this.mDecorContentParent == null) goto L19;
        TypedValue r2 = new TypedValue();
        Resources.Theme r3 = r0.getTheme();
        r3.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarTheme, "attr", "actionBarTheme"), r2, true);
        Resources.Theme r4 = null;
        if (r2.resourceId == 0) goto L11;
        r4 = ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin").newTheme();
        r4.setTo(r3);
        r4.applyStyle(r2.resourceId, true);
        r4.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarWidgetTheme, "attr", "actionBarWidgetTheme"), r2, true);
    L13:
        if (r2.resourceId == 0) goto L17;
        if (r4 != null) goto L16;
        r4 = ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin").newTheme();
        r4.setTo(r3);
    L16:
        r4.applyStyle(r2.resourceId, true);
    L17:
        if (r4 == null) goto L19;
        androidx.appcompat.view.ContextThemeWrapper r5 = new androidx.appcompat.view.ContextThemeWrapper(r0, 0);
        r5.getTheme().setTo(r4);
        r0 = r5;
        goto L19
    L11:
        r3.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarWidgetTheme, "attr", "actionBarWidgetTheme"), r2, true);
        goto L13
    }

    private void invalidatePanelMenu(int r3) {
        int r4 = 1 << r3;
        this.mInvalidatePanelMenuFeatures = r4 | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted == true) goto L6;
        ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
        return;
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

    private boolean onKeyUpPanel(int r4, KeyEvent r5) {
        if (this.mActionMode == null) goto L5;
        return false;
    L5:
        boolean r0 = true;
        PanelFeatureState r2 = getPanelState(r4, true);
        if (r4 != 0) goto L22;
        DecorContentParent r6 = this.mDecorContentParent;
        if (r6 == null) goto L22;
        if (r6.canShowOverflowMenu() == false) goto L22;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L22;
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L16;
        r0 = this.mDecorContentParent.hideOverflowMenu();
    L36:
        if (r0 == false) goto L41;
        AudioManager r3 = (AudioManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContext.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("audio"), AudioManager.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L40;
        r3.playSoundEffect(0);
        goto L41
    L40:
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
    L41:
        return r0;
    L16:
        if (this.mDestroyed == false) goto L18;
    L34:
        r0 = false;
        goto L36
    L18:
        if (preparePanel(r2, r5) == false) goto L34;
        r0 = this.mDecorContentParent.showOverflowMenu();
    L22:
        if (r2.isOpen == false) goto L24;
    L35:
        boolean r7 = r2.isOpen;
        closePanel(r2, true);
        r0 = r7;
        goto L36
    L24:
        if (r2.isHandled == true) goto L35;
        if (r2.isPrepared == false) goto L34;
        if (r2.refreshMenuContent == false) goto L31;
        r2.isPrepared = false;
        boolean r8 = preparePanel(r2, r5);
    L32:
        if (r8 == false) goto L34;
        openPanel(r2, r5);
        goto L36
    L31:
        r8 = true;
        goto L32
    }

    private void openPanel(PanelFeatureState r18, KeyEvent r19) {
        if (r18.isOpen == false) goto L5;
        return;
    L5:
        if (this.mDestroyed == false) goto L8;
        return;
    L8:
        if (r18.featureId == 0) goto L10;
    L15:
        Window.Callback r2 = getWindowCallback();
        if (r2 != null) goto L18;
    L21:
        WindowManager r3 = (WindowManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L25;
        return;
    L25:
        if (preparePanel(r18, r19) == true) goto L28;
        return;
    L28:
        if (r18.decorView == null) goto L40;
        if (r18.refreshDecorView == true) goto L40;
        if (r18.createdPanelView == null) goto L65;
        ViewGroup.LayoutParams r4 = r18.createdPanelView.getLayoutParams();
        if (r4 == null) goto L65;
        if (r4.width != (-1)) goto L65;
        int r10 = -1;
    L66:
        r18.isHandled = false;
        WindowManager.LayoutParams r5 = new WindowManager.LayoutParams(r10, -2, r18.x, r18.y, 1002, 8519680, -3);
        r5.gravity = r18.gravity;
        r5.windowAnimations = r18.windowAnimations;
        r3.addView(r18.decorView, r5);
        r18.isOpen = true;
        if (r18.featureId != 0) goto L73;
        updateBackInvokedCallbackState();
        return;
    L73:
        return;
    L65:
        r10 = -2;
    L40:
        if (r18.decorView != null) goto L47;
        if (initializePanelDecor(r18) == true) goto L44;
        return;
    L44:
        if (r18.decorView != null) goto L52;
        return;
    L52:
        if (initializePanelContent(r18) == true) goto L54;
    L70:
        r18.refreshDecorView = true;
        return;
    L54:
        if (r18.hasPanelItems() == false) goto L70;
        ViewGroup.LayoutParams r6 = r18.shownPanelView.getLayoutParams();
        if (r6 != null) goto L59;
        r6 = new ViewGroup.LayoutParams(-2, -2);
    L59:
        r18.decorView.setBackgroundResource(r18.background);
        ViewParent r7 = r18.shownPanelView.getParent();
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L62;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(r18.shownPanelView);
    L62:
        r18.decorView.addView(r18.shownPanelView, r6);
        if (r18.shownPanelView.hasFocus() == true) goto L65;
        r18.shownPanelView.requestFocus();
        goto L65
    L47:
        if (r18.refreshDecorView == false) goto L52;
        if (r18.decorView.getChildCount() <= 0) goto L52;
        r18.decorView.removeAllViews();
        goto L52
    L18:
        if (r2.onMenuOpened(r18.featureId, r18.menu) == true) goto L21;
        closePanel(r18, true);
        return;
    L10:
        if ((ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getConfiguration().screenLayout & 15) != 4) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        return;
    L12:
        r8 = false;
        goto L13
    }

    private boolean performPanelShortcut(PanelFeatureState r3, int r4, KeyEvent r5, int r6) {
        boolean r1 = false;
        if (r5.isSystem() == false) goto L6;
        return false;
    L6:
        if (r3.isPrepared == true) goto L10;
        if (preparePanel(r3, r5) == true) goto L10;
    L12:
        if (r1 == true) goto L14;
    L18:
        return r1;
    L14:
        if ((r6 & 1) != 0) goto L18;
        if (this.mDecorContentParent != null) goto L18;
        closePanel(r3, true);
    L10:
        if (r3.menu == null) goto L12;
        r1 = r3.menu.performShortcut(r4, r5, r6);
        goto L12
    }

    private boolean preparePanel(PanelFeatureState r9, KeyEvent r10) {
        if (this.mDestroyed == false) goto L6;
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
        if (r1 == null) goto L16;
        r9.createdPanelView = r1.onCreatePanelView(r9.featureId);
    L16:
        if (r9.featureId != 0) goto L18;
    L21:
        boolean r3 = true;
    L22:
        if (r3 == false) goto L27;
        DecorContentParent r4 = this.mDecorContentParent;
        if (r4 == null) goto L27;
        r4.setMenuPrepared();
    L27:
        if (r9.createdPanelView != null) goto L77;
        if (r3 == false) goto L32;
        if (ZeusTransformUtils.instanceOf(peekSupportActionBar(), ToolbarActionBar.class) == true) goto L77;
    L32:
        if (r9.menu == null) goto L36;
        if (r9.refreshMenuContent == true) goto L36;
    L58:
        r9.menu.stopDispatchingItemsChanged();
        if (r9.frozenActionViewState == null) goto L62;
        r9.menu.restoreActionViewStates(r9.frozenActionViewState);
        r9.frozenActionViewState = null;
    L62:
        if (r1.onPreparePanel(0, r9.createdPanelView, r9.menu) == true) goto L69;
        if (r3 == false) goto L67;
        DecorContentParent r11 = this.mDecorContentParent;
        if (r11 == null) goto L67;
        r11.setMenu(null, this.mActionMenuPresenterCallback);
    L67:
        r9.menu.startDispatchingItemsChanged();
        return false;
    L69:
        if (r10 == null) goto L71;
        int r12 = r10.getDeviceId();
    L73:
        if (KeyCharacterMap.load(r12).getKeyboardType() == 1) goto L75;
        boolean r13 = true;
    L76:
        r9.qwertyMode = r13;
        r9.menu.setQwertyMode(r9.qwertyMode);
        r9.menu.startDispatchingItemsChanged();
        goto L77
    L75:
        r13 = false;
        goto L76
    L71:
        r12 = -1;
    L36:
        if (r9.menu == null) goto L38;
    L42:
        if (r3 == true) goto L44;
    L49:
        r9.menu.stopDispatchingItemsChanged();
        if (r1.onCreatePanelMenu(r9.featureId, r9.menu) == true) goto L57;
        r9.setMenu(null);
        if (r3 == false) goto L56;
        DecorContentParent r14 = this.mDecorContentParent;
        if (r14 == null) goto L56;
        r14.setMenu(null, this.mActionMenuPresenterCallback);
    L56:
        return false;
    L57:
        r9.refreshMenuContent = false;
        goto L58
    L44:
        if (this.mDecorContentParent == null) goto L49;
        if (this.mActionMenuPresenterCallback != null) goto L48;
        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback(this);
    L48:
        this.mDecorContentParent.setMenu(r9.menu, this.mActionMenuPresenterCallback);
        goto L49
    L38:
        if (initializePanelMenu(r9) == true) goto L40;
    L41:
        return false;
    L40:
        if (r9.menu != null) goto L42;
    L77:
        r9.isPrepared = true;
        r9.isHandled = false;
        this.mPreparedPanel = r9;
        return true;
    L18:
        if (r9.featureId == 108) goto L21;
        r3 = false;
        goto L22
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
        if (this.mDestroyed == true) goto L35;
        r1.onPanelClosed(108, getPanelState(0, true).menu);
        return;
    L35:
        return;
    L17:
        if (r1 != null) goto L19;
        return;
    L19:
        if (this.mDestroyed == false) goto L21;
        return;
    L21:
        if (this.mInvalidatePanelMenuPosted == true) goto L23;
    L25:
        PanelFeatureState r8 = getPanelState(0, true);
        if (r8.menu != null) goto L28;
        return;
    L28:
        if (r8.refreshMenuContent == false) goto L30;
        return;
    L30:
        if (r1.onPreparePanel(0, r8.createdPanelView, r8.menu) == false) goto L41;
        r1.onMenuOpened(108, r8.menu);
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

    private int sanitizeWindowFeatureId(int r2) {
        if (r2 != 8) goto L7;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
        return 108;
    L7:
        if (r2 != 9) goto L10;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    L10:
        return r2;
    }

    private boolean shouldInheritContext(ViewParent r4) {
        ViewParent r5 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r4, ViewParent.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        View r3 = this.mWindow.getDecorView();
    L6:
        if (r5 == null) goto L7;
        if (r5 == r3) goto L16;
        if (ZeusTransformUtils.instanceOf(r5, View.class) == false) goto L16;
        if (ViewCompat.isAttachedToWindow((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin")) == true) goto L16;
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

    private AppCompatActivity tryUnwrapContext() {
        Context r3 = this.mContext;
    L4:
        if (r3 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, AppCompatActivity.class) == true) goto L8;
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == false) goto L12;
        r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        goto L4
    L8:
        return (AppCompatActivity) ZeusTransformUtils.preCheckCast(r3, AppCompatActivity.class, "com.obric.memorydata.plugin");
    L12:
        return null;
    }

    private void updateActivityConfiguration(Configuration r4) {
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, LifecycleOwner.class) == false) goto L8;
        if (((LifecycleOwner) ZeusTransformUtils.preCheckCast(r0, LifecycleOwner.class, "com.obric.memorydata.plugin")).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L13;
    L11:
        r0.onConfigurationChanged(r4);
        return;
    L13:
        return;
    L8:
        if (this.mCreated == true) goto L10;
        return;
    L10:
        if (this.mDestroyed == false) goto L11;
    }

    private boolean updateAppConfiguration(int r10, LocaleListCompat r11, boolean r12) {
        Configuration r0 = createOverrideAppConfiguration(this.mContext, r10, r11, null, false);
        int r1 = getActivityHandlesConfigChangesFlags(this.mContext);
        Configuration r2 = this.mEffectiveConfiguration;
        if (r2 != null) goto L5;
        r2 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getConfiguration();
    L5:
        int r4 = r2.uiMode & 48;
        int r5 = r0.uiMode & 48;
        LocaleListCompat r3 = getConfigurationLocales(r2);
        if (r11 != null) goto L8;
        LocaleListCompat r6 = null;
    L9:
        boolean r7 = false;
        if (r4 == r5) goto L12;
        int r8 = 512;
    L13:
        if (r6 != null) goto L15;
    L19:
        boolean r9 = true;
        if (((~r1) & r8) == 0) goto L33;
        if (r12 == false) goto L33;
        if (this.mBaseContextAttached == false) goto L33;
        if (sCanReturnDifferentContext == true) goto L29;
        if (this.mCreated == false) goto L33;
    L29:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L33;
        if (((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.memorydata.plugin")).isChild() == true) goto L33;
        ActivityCompat.recreate((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.memorydata.plugin"));
        boolean r13 = true;
    L34:
        if (r13 == true) goto L40;
        if (r8 == 0) goto L40;
        if ((r8 & r1) != r8) goto L39;
        r7 = true;
    L39:
        updateResourcesConfiguration(r5, r6, r7, null);
    L41:
        if (r9 == true) goto L43;
    L50:
        if (r9 == false) goto L53;
        if (r6 == null) goto L53;
        setDefaultLocalesForLocaleList(getConfigurationLocales(ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getConfiguration()));
    L53:
        return r9;
    L43:
        if (ZeusTransformUtils.instanceOf(this.mHost, AppCompatActivity.class) == false) goto L50;
        if ((r8 & 512) == 0) goto L48;
        ((AppCompatActivity) ZeusTransformUtils.preCheckCast(this.mHost, AppCompatActivity.class, "com.obric.memorydata.plugin")).onNightModeChanged(r10);
    L48:
        if ((r8 & 4) == 0) goto L50;
        ((AppCompatActivity) ZeusTransformUtils.preCheckCast(this.mHost, AppCompatActivity.class, "com.obric.memorydata.plugin")).onLocalesChanged(r11);
    L40:
        r9 = r13;
    L33:
        r13 = false;
        goto L34
    L15:
        if (r3.equals(r6) == true) goto L19;
        r8 = r8 | 4;
        if (Build.VERSION.SDK_INT < 17) goto L19;
        r8 = r8 | 8192;
        goto L19
    L12:
        r8 = 0;
        goto L13
    L8:
        r6 = getConfigurationLocales(r0);
        goto L9
    }

    private void updateResourcesConfiguration(int r4, LocaleListCompat r5, boolean r6, Configuration r7) {
        Resources r0 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin");
        Configuration r1 = new Configuration(r0.getConfiguration());
        if (r7 == null) goto L5;
        r1.updateFrom(r7);
    L5:
        r1.uiMode = r4 | (r0.getConfiguration().uiMode & (-49));
        if (r5 == null) goto L8;
        setConfigurationLocales(r1, r5);
    L8:
        r0.updateConfiguration(r1, null);
        if (Build.VERSION.SDK_INT >= 26) goto L11;
        ResourcesFlusher.flush(r0);
    L11:
        int r8 = this.mThemeResId;
        if (r8 == 0) goto L16;
        this.mContext.setTheme(r8);
        if (Build.VERSION.SDK_INT < 23) goto L16;
        this.mContext.getTheme().applyStyle(this.mThemeResId, true);
    L16:
        if (r6 == true) goto L18;
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L22;
        updateActivityConfiguration(r1);
        return;
    }

    private void updateStatusGuardColor(View r4) {
        if ((ViewCompat.getWindowSystemUiVisibility(r4) & 8192) == 0) goto L5;
        boolean r0 = true;
    L6:
        Context r3 = this.mContext;
        if (r0 == false) goto L9;
        int r1 = R.color.abc_decor_view_status_guard_light;
        String r2 = "abc_decor_view_status_guard_light";
    L10:
        r4.setBackgroundColor(ContextCompat.getColor(r3, ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_COLOR, r2)));
        return;
    L9:
        r1 = R.color.abc_decor_view_status_guard;
        r2 = "abc_decor_view_status_guard";
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View r4, ViewGroup.LayoutParams r5) {
        ensureSubDecor();
        ((ViewGroup) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(android.R.id.content), ViewGroup.class, "com.obric.memorydata.plugin")).addView(r4, r5);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    boolean applyAppLocales() {
        if (isAutoStorageOptedIn(this.mContext) == false) goto L10;
        if (getRequestedAppLocales() == null) goto L10;
        if (getRequestedAppLocales().equals(getStoredAppLocales()) == true) goto L10;
        asyncExecuteSyncRequestedAndStoredLocales(this.mContext);
    L10:
        return applyApplicationSpecificConfig(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        return applyApplicationSpecificConfig(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context attachBaseContext2(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        boolean r0 = true;
        this.mBaseContextAttached = true;
        int r8 = mapNightMode(r12, calculateNightMode());
        if (isAutoStorageOptedIn(r12) == false) goto L5;
        syncRequestedAndStoredLocales(r12);
    L5:
        LocaleListCompat r9 = calculateApplicationLocales(r12);
        if (sCanApplyOverrideConfiguration == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r12, ContextThemeWrapper.class) == false) goto L13;
        ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((ContextThemeWrapper) ZeusTransformUtils.preCheckCast(r12, ContextThemeWrapper.class, "com.obric.memorydata.plugin"), createOverrideAppConfiguration(r12, r8, r9, null, false));     // Catch: IllegalStateException -> L36
        return r12;
    L13:
        if (ZeusTransformUtils.instanceOf(r12, androidx.appcompat.view.ContextThemeWrapper.class) == false) goto L18;
        ((androidx.appcompat.view.ContextThemeWrapper) ZeusTransformUtils.preCheckCast(r12, androidx.appcompat.view.ContextThemeWrapper.class, "com.obric.memorydata.plugin")).applyOverrideConfiguration(createOverrideAppConfiguration(r12, r8, r9, null, false));     // Catch: IllegalStateException -> L37
        return r12;
    L18:
        if (sCanReturnDifferentContext == true) goto L22;
        Context r10 = super.attachBaseContext2(r12);
    L21:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L22:
        Configuration r2 = null;
        if (Build.VERSION.SDK_INT < 17) goto L27;
        Configuration r3 = new Configuration();
        r3.uiMode = -1;
        r3.fontScale = 0.0f;
        Configuration r4 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Api17Impl.createConfigurationContext(r12, r3), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration();
        Configuration r5 = ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getConfiguration();
        r4.uiMode = r5.uiMode;
        if (r4.equals(r5) == true) goto L27;
        r2 = generateConfigDelta(r4, r5);
    L27:
        Configuration r6 = createOverrideAppConfiguration(r12, r8, r9, r2, true);
        androidx.appcompat.view.ContextThemeWrapper r7 = new androidx.appcompat.view.ContextThemeWrapper(r12, ZeusTransformUtils.mapRes(R.style.Theme_AppCompat_Empty, "style", "Theme_AppCompat_Empty"));
        r7.applyOverrideConfiguration(r6);
        boolean r13 = false;
        if (r12.getTheme() != null) goto L32;
        r0 = false;
    L32:
        r13 = r0;
    L33:
        if (r13 == false) goto L35;
        ResourcesCompat.ThemeCompat.rebase(r7.getTheme());
    L35:
        r10 = super.attachBaseContext2(r7);
        goto L21
    }

    LocaleListCompat calculateApplicationLocales(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 33) goto L5;
        return null;
    L5:
        LocaleListCompat r0 = getRequestedAppLocales();
        if (r0 != null) goto L8;
        return null;
    L8:
        LocaleListCompat r4 = getConfigurationLocales(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration());
        if (Build.VERSION.SDK_INT < 24) goto L12;
        LocaleListCompat r7 = LocaleOverlayHelper.combineLocalesIfOverlayExists(r0, r4);
    L16:
        if (r7.isEmpty() == false) goto L19;
        return r4;
    L19:
        return r7;
    L12:
        if (r0.isEmpty() == false) goto L14;
        r7 = LocaleListCompat.getEmptyLocaleList();
        goto L16
    L14:
        r7 = LocaleListCompat.forLanguageTags(r0.get(0).toString());
        goto L16
    }

    void callOnPanelClosed(int r3, PanelFeatureState r4, Menu r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L11;
        if (r4 != null) goto L9;
        if (r3 < 0) goto L9;
        PanelFeatureState[] r0 = this.mPanels;
        if (r3 >= r0.length) goto L9;
        r4 = r0[r3];
    L9:
        if (r4 == null) goto L11;
        r6 = r4.menu;
    L11:
        if (r4 == null) goto L16;
        if (r4.isOpen == true) goto L16;
        return;
    L16:
        if (this.mDestroyed == true) goto L19;
        this.mAppCompatWindowCallback.bypassOnPanelClosed(this.mWindow.getCallback(), r3, r6);
        return;
    }

    void checkCloseActionMenu(MenuBuilder r3) {
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
        if (this.mDestroyed == true) goto L10;
        r0.onPanelClosed(108, r3);
        goto L10
    }

    void closePanel(int r2) {
        closePanel(getPanelState(r2, true), true);
    }

    void closePanel(PanelFeatureState r4, boolean r5) {
        if (r5 == true) goto L4;
    L11:
        WindowManager r0 = (WindowManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L14;
    L20:
        r4.isPrepared = false;
        r4.isHandled = false;
        r4.isOpen = false;
        r4.shownPanelView = null;
        r4.refreshDecorView = true;
        if (this.mPreparedPanel != r4) goto L24;
        this.mPreparedPanel = null;
    L24:
        if (r4.featureId != 0) goto L27;
        updateBackInvokedCallbackState();
        return;
    L27:
        return;
    L14:
        if (r4.isOpen == false) goto L20;
        if (r4.decorView == null) goto L20;
        r0.removeView(r4.decorView);
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

    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(View r12, String r13, Context r14, AttributeSet r15) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r15, AttributeSet.class, "com.obric.memorydata.plugin");
        boolean r16 = false;
        if (this.mAppCompatViewInflater != null) goto L12;
        String r17 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_viewInflaterClass, "styleable", "AppCompatTheme_viewInflaterClass"));
        if (r17 != null) goto L29;
        AppCompatViewInflater r18 = new AppCompatViewInflater();
    L7:
        this.mAppCompatViewInflater = r18;
        goto L12
    L29:
        this.mAppCompatViewInflater = (AppCompatViewInflater) ZeusTransformUtils.preCheckCast(this.mContext.getClassLoader().loadClass(r17).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), AppCompatViewInflater.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + r17 + ". Falling back to default.", th);
        r18 = new AppCompatViewInflater();
    L12:
        boolean r8 = IS_PRE_LOLLIPOP;
        if (r8 == true) goto L15;
    L26:
        boolean r7 = r16;
    L28:
        return this.mAppCompatViewInflater.createView(r12, r13, r5, r6, r7, r8, true, VectorEnabledTintResources.shouldBeUsed());
    L15:
        if (this.mLayoutIncludeDetector != null) goto L18;
        this.mLayoutIncludeDetector = new LayoutIncludeDetector();
    L18:
        if (this.mLayoutIncludeDetector.detect(r6) == false) goto L21;
        r7 = true;
        goto L28
    L21:
        if (ZeusTransformUtils.instanceOf(r6, XmlPullParser.class) == true) goto L23;
        r16 = shouldInheritContext((ViewParent) ZeusTransformUtils.preCheckCast(r12, ViewParent.class, "com.obric.memorydata.plugin"));
        goto L26
    L23:
        if (((XmlPullParser) ZeusTransformUtils.preCheckCast(r6, XmlPullParser.class, "com.obric.memorydata.plugin")).getDepth() <= 1) goto L26;
        r16 = true;
        goto L26
    }

    void dismissPopups() {
        DecorContentParent r0 = this.mDecorContentParent;
        if (r0 == null) goto L6;
        r0.dismissPopups();
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
        PanelFeatureState r2 = getPanelState(0, false);
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.menu == null) goto L21;
        r2.menu.close();
        return;
    }

    boolean dispatchKeyEvent(KeyEvent r4) {
        boolean r1 = true;
        if (ZeusTransformUtils.instanceOf(this.mHost, KeyEventDispatcher.Component.class) == false) goto L5;
    L6:
        View r0 = this.mWindow.getDecorView();
        if (r0 != null) goto L9;
    L12:
        if (r4.getKeyCode() == 82) goto L14;
    L16:
        int r2 = r4.getKeyCode();
        if (r4.getAction() == 0) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L23;
        return onKeyDown(r2, r4);
    L23:
        return onKeyUp(r2, r4);
    L14:
        if (this.mAppCompatWindowCallback.bypassDispatchKeyEvent(this.mWindow.getCallback(), r4) == false) goto L16;
        return true;
    L9:
        if (KeyEventDispatcher.dispatchBeforeHierarchy(r0, r4) == false) goto L12;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(this.mHost, AppCompatDialog.class) == false) goto L12;
        goto L6
    }

    void doInvalidatePanelMenu(int r5) {
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

    void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat r0 = this.mFadeAnim;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    PanelFeatureState findMenuPanel(Menu r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.memorydata.plugin");
        PanelFeatureState[] r4 = this.mPanels;
        int r0 = 0;
        if (r4 == null) goto L5;
        int r1 = r4.length;
    L6:
        if (r0 >= r1) goto L13;
        PanelFeatureState r2 = r4[r0];
        if (r2 == null) goto L12;
        if (r2.menu != r6) goto L12;
        return r2;
    L12:
        r0 = r0 + 1;
        goto L6
    L13:
        return null;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public <T extends View> T findViewById(int r1) {
        ensureSubDecor();
        return (T) this.mWindow.findViewById(r1);
    }

    final Context getActionBarThemedContext() {
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L5;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return this.mContext;
    L5:
        r1 = null;
        goto L6
    }

    final AutoNightModeManager getAutoTimeNightModeManager() {
        return getAutoTimeNightModeManager(this.mContext);
    }

    LocaleListCompat getConfigurationLocales(Configuration r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.getLocales(r2);
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        return LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(r2.locale));
    L11:
        return LocaleListCompat.create(new Locale[]{r2.locale});
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
        ActionBar r1 = this.mActionBar;
        if (r1 == null) goto L7;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L8:
        this.mMenuInflater = new SupportMenuInflater(r2);
        goto L10
    L7:
        r2 = this.mContext;
    L10:
        return this.mMenuInflater;
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
        PanelFeatureState r3 = r6[r4];
        if (r3 != null) goto L14;
        PanelFeatureState r7 = new PanelFeatureState(r4);
        r6[r4] = r7;
        return r7;
    L14:
        return r3;
    L5:
        if (r6.length > r4) goto L10;
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
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L7;
        return ((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.memorydata.plugin")).getTitle();
    L7:
        return this.mTitle;
    }

    final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int r5) {
        int r0 = sanitizeWindowFeatureId(r5);
        if (r0 != 1) goto L5;
        boolean r1 = this.mWindowNoTitle;
    L21:
        if (r1 == false) goto L23;
        return true;
    L23:
        if (this.mWindow.hasFeature(r5) == false) goto L26;
        return true;
    L26:
        return false;
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

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater r0 = LayoutInflater.from(this.mContext);
        if (r0.getFactory() != null) goto L6;
        LayoutInflaterCompat.setFactory2(r0, this);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0.getFactory2(), AppCompatDelegateImpl.class) == true) goto L10;
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

    int mapNightMode(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 == (-100)) goto L24;
        if (r5 == (-1)) goto L23;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L23;
        if (r5 != 3) goto L16;
        AutoNightModeManager r3 = getAutoBatteryNightModeManager(r6);
    L14:
        return r3.getApplyableNightMode();
    L16:
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    L18:
        if (Build.VERSION.SDK_INT >= 23) goto L20;
    L22:
        r3 = getAutoTimeNightModeManager(r6);
        goto L14
    L20:
        if (((UiModeManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("uimode"), UiModeManager.class, "com.obric.memorydata.plugin")).getNightMode() != 0) goto L22;
        return -1;
    L23:
        return r5;
    L24:
        return -1;
    }

    boolean onBackPressed() {
        boolean r0 = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState r2 = getPanelState(0, false);
        if (r2 != null) goto L5;
    L9:
        ActionMode r1 = this.mActionMode;
        if (r1 == null) goto L13;
        r1.finish();
        return true;
    L13:
        ActionBar r5 = getSupportActionBar();
        if (r5 != null) goto L16;
    L18:
        return false;
    L16:
        if (r5.collapseActionView() == false) goto L18;
        return true;
    L5:
        if (r2.isOpen == false) goto L9;
        if (r0 == true) goto L8;
        closePanel(r2, true);
    L8:
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration r3) {
        if (this.mHasActionBar == true) goto L5;
    L9:
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        this.mEffectiveConfiguration = new Configuration(ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getConfiguration());
        applyApplicationSpecificConfig(false, false);
        return;
    L5:
        if (this.mSubDecorInstalled == false) goto L9;
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L9;
        r0.onConfigurationChanged(r3);
        goto L9
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle r5) {
        this.mBaseContextAttached = true;
        applyApplicationSpecificConfig(false);
        ensureWindow();
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L12;
        String r0 = null;
        r0 = NavUtils.getParentActivityName((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.memorydata.plugin"));     // Catch: IllegalArgumentException -> L14
    L6:
        if (r0 == null) goto L11;
        ActionBar r1 = peekSupportActionBar();
        if (r1 != null) goto L10;
        this.mEnableDefaultActionBarUp = true;
        goto L11
    L10:
        r1.setDefaultDisplayHomeAsUpEnabled(true);
    L11:
        addActiveDelegate(this);
    L12:
        this.mEffectiveConfiguration = new Configuration(ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getConfiguration());
        this.mCreated = true;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r3, String r4, Context r5, AttributeSet r6) {
        return createView(r3, r4, (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r3, Context r4, AttributeSet r5) {
        return onCreateView(null, r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onDestroy() {
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L6;
        removeActivityDelegate(this);
    L6:
        if (this.mInvalidatePanelMenuPosted == false) goto L8;
        this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
    L8:
        this.mDestroyed = true;
        if (this.mLocalNightMode != (-100)) goto L11;
    L15:
        sLocalNightModes.remove(this.mHost.getClass().getName());
    L16:
        ActionBar r0 = this.mActionBar;
        if (r0 == null) goto L19;
        r0.onDestroy();
    L19:
        cleanupAutoManagers();
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L15;
        if (((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.memorydata.plugin")).isChangingConfigurations() == false) goto L15;
        sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
        goto L16
    }

    boolean onKeyDown(int r4, KeyEvent r5) {
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

    boolean onKeyShortcut(int r4, KeyEvent r5) {
        ActionBar r0 = getSupportActionBar();
        if (r0 != null) goto L5;
    L7:
        PanelFeatureState r6 = this.mPreparedPanel;
        if (r6 == null) goto L16;
        if (performPanelShortcut(r6, r5.getKeyCode(), r5, 1) == false) goto L16;
        PanelFeatureState r3 = this.mPreparedPanel;
        if (r3 == null) goto L14;
        r3.isHandled = true;
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
    L5:
        if (r0.onKeyShortcut(r4, r5) == false) goto L7;
        return true;
    }

    boolean onKeyUp(int r4, KeyEvent r5) {
        if (r4 == 4) goto L10;
        if (r4 != 82) goto L12;
        onKeyUpPanel(0, r5);
        return true;
    L12:
        return false;
    L10:
        if (onBackPressed() == false) goto L12;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
        Window.Callback r0 = getWindowCallback();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.mDestroyed == true) goto L12;
        PanelFeatureState r2 = findMenuPanel(r3.getRootMenu());
        if (r2 != null) goto L9;
        return false;
    L9:
        return r0.onMenuItemSelected(r2.featureId, r5);
    L12:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder r1) {
        reopenMenu(true);
    }

    void onMenuOpened(int r2) {
        if (r2 != 108) goto L8;
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L9;
        r1.dispatchMenuVisibilityChanged(true);
        return;
    L9:
        return;
    }

    void onPanelClosed(int r3) {
        if (r3 != 108) goto L7;
        ActionBar r2 = getSupportActionBar();
        if (r2 == null) goto L12;
        r2.dispatchMenuVisibilityChanged(false);
        return;
    L12:
        return;
    L7:
        if (r3 != 0) goto L14;
        PanelFeatureState r4 = getPanelState(r3, true);
        if (r4.isOpen == false) goto L15;
        closePanel(r4, false);
        return;
    L15:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle r1) {
        ensureSubDecor();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L6;
        r1.setShowHideAnimationEnabled(true);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle r1) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        applyApplicationSpecificConfig(true, false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L6;
        r1.setShowHideAnimationEnabled(false);
        return;
    }

    void onSubDecorInstalled(ViewGroup r1) {
    }

    final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
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

    void setConfigurationLocales(Configuration r3, LocaleListCompat r4) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.setLocales(r3, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L8;
        Api17Impl.setLocale(r3, r4.get(0));
        Api17Impl.setLayoutDirection(r3, r4.get(0));
        return;
    L8:
        r3.locale = r4.get(0);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int r4) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(android.R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
        r0.removeAllViews();
        ZeusTransformUtils.inflate(LayoutInflater.from(this.mContext), r4, r0, "com.obric.memorydata.plugin");
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View r4) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(android.R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
        r0.removeAllViews();
        r0.addView(r4);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View r4, ViewGroup.LayoutParams r5) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(android.R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
        r0.removeAllViews();
        r0.addView(r4, r5);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    void setDefaultLocalesForLocaleList(LocaleListCompat r2) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Api24Impl.setDefaultLocales(r2);
        return;
    L5:
        Locale.setDefault(r2.get(0));
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean r1) {
        this.mHandleNativeActionModes = r1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setLocalNightMode(int r2) {
        if (this.mLocalNightMode == r2) goto L8;
        this.mLocalNightMode = r2;
        if (this.mBaseContextAttached == false) goto L9;
        applyDayNight();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher r4) {
        OnBackInvokedDispatcher r5 = (OnBackInvokedDispatcher) ZeusTransformUtils.wrapperContextForParams(r4, OnBackInvokedDispatcher.class, "com.obric.memorydata.plugin");
        super.setOnBackInvokedDispatcher(r5);
        OnBackInvokedDispatcher r0 = this.mDispatcher;
        if (r0 == null) goto L7;
        OnBackInvokedCallback r2 = this.mBackCallback;
        if (r2 == null) goto L7;
        Api33Impl.unregisterOnBackInvokedCallback(r0, r2);
        this.mBackCallback = null;
    L7:
        if (r5 == null) goto L9;
    L13:
        this.mDispatcher = r5;
        updateBackInvokedCallbackState();
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L13;
        if (ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin") == null) goto L13;
        r5 = Api33Impl.getOnBackInvokedDispatcher((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.memorydata.plugin"));
        goto L13
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar r4) {
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == true) goto L5;
        return;
    L5:
        ActionBar r0 = getSupportActionBar();
        if (ZeusTransformUtils.instanceOf(r0, WindowDecorActionBar.class) == true) goto L17;
        this.mMenuInflater = null;
        if (r0 == null) goto L10;
        r0.onDestroy();
    L10:
        this.mActionBar = null;
        if (r4 == null) goto L13;
        ToolbarActionBar r1 = new ToolbarActionBar(r4, getTitle(), this.mAppCompatWindowCallback);
        this.mActionBar = r1;
        this.mAppCompatWindowCallback.setActionBarCallback(r1.mMenuCallback);
        r4.setBackInvokedCallbackEnabled(true);
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
    public void setTheme(int r1) {
        this.mThemeResId = r1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mTitle = r4;
        DecorContentParent r0 = this.mDecorContentParent;
        if (r0 == null) goto L6;
        r0.setWindowTitle(r4);
        return;
    L6:
        if (peekSupportActionBar() == null) goto L8;
        peekSupportActionBar().setWindowTitle(r4);
        return;
    L8:
        TextView r2 = this.mTitleView;
        if (r2 == null) goto L14;
        r2.setText(r4);
        return;
    }

    final boolean shouldAnimateActionModeView() {
        if (this.mSubDecorInstalled == false) goto L9;
        ViewGroup r1 = this.mSubDecor;
        if (r1 == null) goto L9;
        if (ViewCompat.isLaidOut(r1) == false) goto L9;
        return true;
    L9:
        return false;
    }

    boolean shouldRegisterBackInvokedCallback() {
        if (this.mDispatcher != null) goto L5;
        return false;
    L5:
        PanelFeatureState r0 = getPanelState(0, false);
        if (r0 == null) goto L11;
        if (r0.isOpen == false) goto L11;
        return true;
    L11:
        if (this.mActionMode == null) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionMode startSupportActionMode(ActionMode.Callback r3) {
        ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L20;
        ActionMode r0 = this.mActionMode;
        if (r0 == null) goto L7;
        r0.finish();
    L7:
        ActionModeCallbackWrapperV9 r1 = new ActionModeCallbackWrapperV9(this, r4);
        ActionBar r5 = getSupportActionBar();
        if (r5 == null) goto L15;
        ActionMode r6 = r5.startActionMode(r1);
        this.mActionMode = r6;
        if (r6 == null) goto L15;
        AppCompatCallback r2 = this.mAppCompatCallback;
        if (r2 == null) goto L15;
        r2.onSupportActionModeStarted(r6);
    L15:
        if (this.mActionMode != null) goto L17;
        this.mActionMode = startSupportActionModeFromWindow(r1);
    L17:
        updateBackInvokedCallbackState();
        return this.mActionMode;
    L20:
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    ActionMode startSupportActionModeFromWindow(ActionMode.Callback r11) {
        ActionMode.Callback r12 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r11, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        endOnGoingFadeAnimation();
        ActionMode r0 = this.mActionMode;
        if (r0 == null) goto L6;
        r0.finish();
    L6:
        if (ZeusTransformUtils.instanceOf(r12, ActionModeCallbackWrapperV9.class) == true) goto L8;
        r12 = new ActionModeCallbackWrapperV9(this, r12);
    L8:
        AppCompatCallback r1 = this.mAppCompatCallback;
        if (r1 != null) goto L11;
    L14:
        ActionMode r2 = null;
    L15:
        if (r2 == null) goto L17;
        this.mActionMode = r2;
    L47:
        ActionMode r13 = this.mActionMode;
        if (r13 == null) goto L52;
        AppCompatCallback r3 = this.mAppCompatCallback;
        if (r3 == null) goto L52;
        r3.onSupportActionModeStarted(r13);
    L52:
        updateBackInvokedCallbackState();
        return this.mActionMode;
    L17:
        boolean r4 = true;
        if (this.mActionModeView != null) goto L30;
        if (this.mIsFloating == false) goto L26;
        TypedValue r5 = new TypedValue();
        Resources.Theme r6 = this.mContext.getTheme();
        r6.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarTheme, "attr", "actionBarTheme"), r5, true);
        if (r5.resourceId == 0) goto L24;
        Resources.Theme r7 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").newTheme();
        r7.setTo(r6);
        r7.applyStyle(r5.resourceId, true);
        Context r8 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, 0);
        r8.getTheme().setTo(r7);
    L25:
        this.mActionModeView = new ActionBarContextView(r8);
        PopupWindow r9 = new PopupWindow(r8, null, ZeusTransformUtils.mapRes(R.attr.actionModePopupWindowStyle, "attr", "actionModePopupWindowStyle"));
        this.mActionModePopup = r9;
        PopupWindowCompat.setWindowLayoutType(r9, 2);
        this.mActionModePopup.setContentView(this.mActionModeView);
        this.mActionModePopup.setWidth(-1);
        r8.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarSize, "attr", "actionBarSize"), r5, true);
        this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(r5.data, ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getDisplayMetrics()));
        this.mActionModePopup.setHeight(-2);
        this.mShowActionModePopup = new AnonymousClass6(this);
        goto L30
    L24:
        r8 = this.mContext;
        goto L25
    L26:
        ViewStubCompat r10 = (ViewStubCompat) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(ZeusTransformUtils.mapRes(R.id.action_mode_bar_stub, OaidModel.KEY_ID, "action_mode_bar_stub")), ViewStubCompat.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L30;
        r10.setLayoutInflater(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActionBarThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
        this.mActionModeView = (ActionBarContextView) ZeusTransformUtils.preCheckCast(r10.inflate(), ActionBarContextView.class, "com.obric.memorydata.plugin");
    L30:
        if (this.mActionModeView == null) goto L47;
        endOnGoingFadeAnimation();
        this.mActionModeView.killMode();
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mActionModeView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        ActionBarContextView r15 = this.mActionModeView;
        if (this.mActionModePopup == null) goto L35;
        r4 = false;
    L35:
        StandaloneActionMode r16 = new StandaloneActionMode(r14, r15, r12, r4);
        if (r12.onCreateActionMode(r16, r16.getMenu()) == false) goto L46;
        r16.invalidate();
        this.mActionModeView.initForMode(r16);
        this.mActionMode = r16;
        if (shouldAnimateActionModeView() == false) goto L40;
        this.mActionModeView.setAlpha(0.0f);
        ViewPropertyAnimatorCompat r17 = ViewCompat.animate(this.mActionModeView).alpha(1.0f);
        this.mFadeAnim = r17;
        r17.setListener(new AnonymousClass7(this));
    L44:
        if (this.mActionModePopup == null) goto L47;
        this.mWindow.getDecorView().post(this.mShowActionModePopup);
        goto L47
    L40:
        this.mActionModeView.setAlpha(1.0f);
        this.mActionModeView.setVisibility(0);
        if (ZeusTransformUtils.instanceOf(this.mActionModeView.getParent(), View.class) == false) goto L44;
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(this.mActionModeView.getParent(), View.class, "com.obric.memorydata.plugin"));
        goto L44
    L46:
        this.mActionMode = null;
        goto L47
    L11:
        if (this.mDestroyed == true) goto L14;
        r2 = r1.onWindowStartingSupportActionMode(r12);     // Catch: AbstractMethodError -> L54
        goto L15
    }

    void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT < 33) goto L14;
        boolean r0 = shouldRegisterBackInvokedCallback();
        if (r0 == true) goto L7;
    L9:
        if (r0 == true) goto L16;
        OnBackInvokedCallback r1 = this.mBackCallback;
        if (r1 == null) goto L17;
        Api33Impl.unregisterOnBackInvokedCallback(this.mDispatcher, r1);
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

    final int updateStatusGuard(WindowInsetsCompat r11, Rect r12) {
        int r0 = 0;
        if (r11 == null) goto L5;
        int r1 = r11.getSystemWindowInsetTop();
    L8:
        ActionBarContextView r2 = this.mActionModeView;
        if (r2 != null) goto L11;
    L69:
        boolean r13 = false;
    L70:
        View r10 = this.mStatusGuard;
        if (r10 == null) goto L76;
        if (r13 == true) goto L75;
        r0 = 8;
    L75:
        r10.setVisibility(r0);
    L76:
        return r1;
    L11:
        if (ZeusTransformUtils.instanceOf(r2.getLayoutParams(), ViewGroup.MarginLayoutParams.class) == false) goto L69;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.mActionModeView.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        boolean r6 = true;
        if (this.mActionModeView.isShown() == false) goto L64;
        if (this.mTempRect1 != null) goto L17;
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
    L17:
        Rect r4 = this.mTempRect1;
        Rect r7 = this.mTempRect2;
        if (r11 != null) goto L20;
        r4.set(r12);
    L21:
        ViewUtils.computeFitSystemWindows(this.mSubDecor, r4, r7);
        int r14 = r4.top;
        int r15 = r4.left;
        int r5 = r4.right;
        WindowInsetsCompat r8 = ViewCompat.getRootWindowInsets(this.mSubDecor);
        if (r8 != null) goto L24;
        int r9 = 0;
    L25:
        if (r8 != null) goto L27;
        int r16 = 0;
    L29:
        if (r3.topMargin == r14) goto L31;
    L36:
        r3.topMargin = r14;
        r3.leftMargin = r15;
        r3.rightMargin = r5;
        boolean r17 = true;
    L37:
        if (r14 > 0) goto L39;
    L41:
        View r18 = this.mStatusGuard;
        if (r18 == null) goto L50;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r18.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r19.height == r3.topMargin) goto L46;
    L49:
        r19.height = r3.topMargin;
        r19.leftMargin = r9;
        r19.rightMargin = r16;
        this.mStatusGuard.setLayoutParams(r19);
        goto L50
    L46:
        if (r19.leftMargin != r9) goto L49;
        if (r19.rightMargin != r16) goto L49;
    L50:
        View r110 = this.mStatusGuard;
        if (r110 != null) goto L54;
        r6 = false;
    L54:
        if (r6 == false) goto L59;
        if (r110.getVisibility() == 0) goto L59;
        updateStatusGuardColor(this.mStatusGuard);
    L59:
        if (this.mOverlayActionMode == true) goto L62;
        if (r6 == false) goto L62;
        r1 = 0;
    L62:
        r13 = r6;
        r6 = r17;
    L67:
        if (r6 == false) goto L70;
        this.mActionModeView.setLayoutParams(r3);
        goto L70
    L39:
        if (this.mStatusGuard != null) goto L41;
        View r111 = new View(this.mContext);
        this.mStatusGuard = r111;
        r111.setVisibility(8);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-1, r3.topMargin, 51);
        r112.leftMargin = r9;
        r112.rightMargin = r16;
        this.mSubDecor.addView(this.mStatusGuard, -1, r112);
        goto L50
    L31:
        if (r3.leftMargin != r15) goto L36;
        if (r3.rightMargin != r5) goto L36;
        r17 = false;
        goto L37
    L27:
        r16 = r8.getSystemWindowInsetRight();
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
        r6 = false;
        goto L67
    L5:
        if (r12 == null) goto L7;
        r1 = r12.top;
        goto L8
    L7:
        r1 = 0;
        goto L8
    }
}
