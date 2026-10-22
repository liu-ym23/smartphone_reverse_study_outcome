package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatDelegate {
    static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;

    @Deprecated
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;

    @Deprecated
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final String TAG = "AppCompatDelegate";
    private static final ArraySet<WeakReference<AppCompatDelegate>> sActivityDelegates = null;
    private static final Object sActivityDelegatesLock = null;
    private static final Object sAppLocalesStorageSyncLock = null;
    private static int sDefaultNightMode;
    private static Boolean sIsAutoStoreLocalesOptedIn;
    private static boolean sIsFrameworkSyncChecked;
    private static LocaleListCompat sRequestedAppLocales;
    static AppLocalesStorageHelper.SerialExecutor sSerialExecutorForLocalesStorage;
    private static LocaleListCompat sStoredAppLocales;

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static LocaleList localeListForLanguageTags(String r5) {
            return LocaleList.forLanguageTags(r5);
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static LocaleList localeManagerGetApplicationLocales(Object r5) {
            return ((LocaleManager) r5).getApplicationLocales();
        }

        @DoNotInline
        public static void localeManagerSetApplicationLocales(Object r5, LocaleList r10) {
            ((LocaleManager) r5).setApplicationLocales(r10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NightMode {
    }

    static {
        sSerialExecutorForLocalesStorage = new AppLocalesStorageHelper.SerialExecutor(new AppLocalesStorageHelper.ThreadPerTaskExecutor());
        sDefaultNightMode = -100;
        sRequestedAppLocales = null;
        sStoredAppLocales = null;
        sIsAutoStoreLocalesOptedIn = null;
        sIsFrameworkSyncChecked = false;
        sActivityDelegates = new ArraySet();
        sActivityDelegatesLock = new Object();
        sAppLocalesStorageSyncLock = new Object();
    }

    public AppCompatDelegate() {
    }

    public static /* synthetic */ void a(Context r5) {
        lambda$syncRequestedAndStoredLocales$1(r5);
    }

    public static void addActiveDelegate(@NonNull AppCompatDelegate r5) {
        Object r10 = sActivityDelegatesLock;
        monitor-enter(r10);
        removeDelegateFromActives(r5);     // Catch: Throwable -> L7
        sActivityDelegates.add(new WeakReference(r5));     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void applyDayNightToActiveDelegates() {
        Object r5 = sActivityDelegatesLock;
        monitor-enter(r5);
        Iterator<WeakReference<AppCompatDelegate>> r10 = sActivityDelegates.iterator();     // Catch: Throwable -> L10
    L6:
        if (r10.hasNext() == false) goto L12;
        AppCompatDelegate r11 = r10.next().get();     // Catch: Throwable -> L10
        if (r11 == null) goto L6;
        r11.applyDayNight();     // Catch: Throwable -> L10
        goto L6
    L12:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static void applyLocalesToActiveDelegates() {
        Iterator<WeakReference<AppCompatDelegate>> r5 = sActivityDelegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        AppCompatDelegate r10 = r5.next().get();
        if (r10 == null) goto L4;
        r10.applyAppLocales();
        goto L4
    }

    public static /* synthetic */ void b(Context r5) {
        lambda$asyncExecuteSyncRequestedAndStoredLocales$0(r5);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Activity r5, @Nullable AppCompatCallback r10) {
        return new AppCompatDelegateImpl(r5, r10);
    }

    @NonNull
    @AnyThread
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static LocaleListCompat getApplicationLocales() {
        if (BuildCompat.isAtLeastT() == false) goto L8;
        Object r5 = getLocaleManagerForApplication();
        if (r5 == null) goto L12;
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(r5));
    L12:
        return LocaleListCompat.getEmptyLocaleList();
    L8:
        LocaleListCompat r10 = sRequestedAppLocales;
        if (r10 == null) goto L12;
        return r10;
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    @RequiresApi(33)
    public static Object getLocaleManagerForApplication() {
        Iterator<WeakReference<AppCompatDelegate>> r5 = sActivityDelegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        AppCompatDelegate r10 = r5.next().get();
        if (r10 == null) goto L4;
        Context r11 = r10.getContextForDelegate();
        if (r11 == null) goto L4;
        return r11.getSystemService("locale");
    L11:
        return null;
    }

    @Nullable
    public static LocaleListCompat getRequestedAppLocales() {
        return sRequestedAppLocales;
    }

    @Nullable
    public static LocaleListCompat getStoredAppLocales() {
        return sStoredAppLocales;
    }

    public static boolean isAutoStorageOptedIn(Context r5) {
        if (sIsAutoStoreLocalesOptedIn != null) goto L10;
        Bundle r10 = AppLocalesMetadataHolderService.getServiceInfo(r5).metaData;     // Catch: PackageManager.NameNotFoundException -> L8
        if (r10 == null) goto L10;
        sIsAutoStoreLocalesOptedIn = Boolean.valueOf(r10.getBoolean("autoStoreLocales"));     // Catch: PackageManager.NameNotFoundException -> L8
    L8:
        Log.d(TAG, "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
        sIsAutoStoreLocalesOptedIn = Boolean.FALSE;
    L10:
        return sIsAutoStoreLocalesOptedIn.booleanValue();
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    private static /* synthetic */ void lambda$asyncExecuteSyncRequestedAndStoredLocales$0(Context r5) {
        syncRequestedAndStoredLocales(r5);
    }

    private static /* synthetic */ void lambda$syncRequestedAndStoredLocales$1(Context r5) {
        AppLocalesStorageHelper.syncLocalesToFramework(r5);
        sIsFrameworkSyncChecked = true;
    }

    public static void removeActivityDelegate(@NonNull AppCompatDelegate r5) {
        Object r10 = sActivityDelegatesLock;
        monitor-enter(r10);
        removeDelegateFromActives(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void removeDelegateFromActives(@NonNull AppCompatDelegate r5) {
        Object r10 = sActivityDelegatesLock;
        monitor-enter(r10);
        Iterator<WeakReference<AppCompatDelegate>> r11 = sActivityDelegates.iterator();     // Catch: Throwable -> L11
    L6:
        if (r11.hasNext() == false) goto L13;
        AppCompatDelegate r12 = r11.next().get();     // Catch: Throwable -> L11
        if (r12 == r5) goto L10;
        if (r12 != null) goto L6;
    L10:
        r11.remove();     // Catch: Throwable -> L11
        goto L6
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public static void resetStaticRequestedAndStoredLocales() {
        sRequestedAppLocales = null;
        sStoredAppLocales = null;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static void setApplicationLocales(@NonNull LocaleListCompat r5) {
        Objects.requireNonNull(r5);
        if (BuildCompat.isAtLeastT() == false) goto L8;
        Object r10 = getLocaleManagerForApplication();
        if (r10 == null) goto L17;
        Api33Impl.localeManagerSetApplicationLocales(r10, Api24Impl.localeListForLanguageTags(r5.toLanguageTags()));
        return;
    L17:
        return;
    L8:
        if (r5.equals(sRequestedAppLocales) == true) goto L21;
        Object r11 = sActivityDelegatesLock;
        monitor-enter(r11);
        sRequestedAppLocales = r5;     // Catch: Throwable -> L14
        applyLocalesToActiveDelegates();     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean r5) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(r5);
    }

    public static void setDefaultNightMode(int r5) {
        if (r5 == (-1)) goto L13;
        if (r5 == 0) goto L13;
        if (r5 == 1) goto L13;
        if (r5 == 2) goto L13;
        if (r5 == 3) goto L13;
        Log.d(TAG, "setDefaultNightMode() called with an unknown mode");
        return;
    L13:
        if (sDefaultNightMode == r5) goto L17;
        sDefaultNightMode = r5;
        applyDayNightToActiveDelegates();
        return;
    }

    @VisibleForTesting
    public static void setIsAutoStoreLocalesOptedIn(boolean r5) {
        sIsAutoStoreLocalesOptedIn = Boolean.valueOf(r5);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static void syncRequestedAndStoredLocales(Context r5) {
        if (isAutoStorageOptedIn(r5) == true) goto L6;
        return;
    L6:
        if (BuildCompat.isAtLeastT() == true) goto L8;
        Object r10 = sAppLocalesStorageSyncLock;
        monitor-enter(r10);
        LocaleListCompat r11 = sRequestedAppLocales;     // Catch: Throwable -> L17
        if (r11 != null) goto L25;
        if (sStoredAppLocales != null) goto L20;
        sStoredAppLocales = LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(r5));     // Catch: Throwable -> L17
    L20:
        if (sStoredAppLocales.isEmpty() == false) goto L23;
        monitor-exit(r10);     // Catch: Throwable -> L17
        return;
    L23:
        sRequestedAppLocales = sStoredAppLocales;     // Catch: Throwable -> L17
    L27:
        monitor-exit(r10);     // Catch: Throwable -> L17
        return;
    L25:
        if (r11.equals(sStoredAppLocales) == true) goto L27;
        LocaleListCompat r12 = sRequestedAppLocales;     // Catch: Throwable -> L17
        sStoredAppLocales = r12;     // Catch: Throwable -> L17
        AppLocalesStorageHelper.persistLocales(r5, r12.toLanguageTags());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L8:
        if (sIsFrameworkSyncChecked == true) goto L32;
        sSerialExecutorForLocalesStorage.execute(new a(r5, 0));
        return;
    }

    public abstract void addContentView(View r5, ViewGroup.LayoutParams r10);

    public boolean applyAppLocales() {
        return false;
    }

    public abstract boolean applyDayNight();

    public void asyncExecuteSyncRequestedAndStoredLocales(Context r5) {
        sSerialExecutorForLocalesStorage.execute(new a(r5, 1));
    }

    @Deprecated
    public void attachBaseContext(Context r5) {
    }

    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context r5) {
        attachBaseContext(r5);
        return r5;
    }

    public abstract View createView(@Nullable View r5, String r10, @NonNull Context r11, @NonNull AttributeSet r12);

    @Nullable
    public abstract <T extends View> T findViewById(@IdRes int r5);

    @Nullable
    public Context getContextForDelegate() {
        return null;
    }

    @Nullable
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    @Nullable
    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int r5);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration r5);

    public abstract void onCreate(Bundle r5);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle r5);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle r5);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int r5);

    public abstract void setContentView(@LayoutRes int r5);

    public abstract void setContentView(View r5);

    public abstract void setContentView(View r5, ViewGroup.LayoutParams r10);

    public abstract void setHandleNativeActionModesEnabled(boolean r5);

    @RequiresApi(17)
    public abstract void setLocalNightMode(int r5);

    @RequiresApi(33)
    @CallSuper
    public void setOnBackInvokedDispatcher(@Nullable OnBackInvokedDispatcher r5) {
    }

    public abstract void setSupportActionBar(@Nullable Toolbar r5);

    public void setTheme(@StyleRes int r5) {
    }

    public abstract void setTitle(@Nullable CharSequence r5);

    @Nullable
    public abstract ActionMode startSupportActionMode(@NonNull ActionMode.Callback r5);

    @NonNull
    public static AppCompatDelegate create(@NonNull Dialog r5, @Nullable AppCompatCallback r10) {
        return new AppCompatDelegateImpl(r5, r10);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context r5, @NonNull Window r10, @Nullable AppCompatCallback r11) {
        return new AppCompatDelegateImpl(r5, r10, r11);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context r5, @NonNull Activity r10, @Nullable AppCompatCallback r11) {
        return new AppCompatDelegateImpl(r5, r10, r11);
    }
}
