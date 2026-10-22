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
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList localeListForLanguageTags(String r10) {
            return LocaleList.forLanguageTags(r10);
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static LocaleList localeManagerGetApplicationLocales(Object r10) {
            return ((LocaleManager) r10).getApplicationLocales();
        }

        @DoNotInline
        static void localeManagerSetApplicationLocales(Object r10, LocaleList r11) {
            ((LocaleManager) r10).setApplicationLocales(r11);
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

    AppCompatDelegate() {
    }

    public static /* synthetic */ void a(Context r10) {
        lambda$syncRequestedAndStoredLocales$1(r10);
    }

    static void addActiveDelegate(@NonNull AppCompatDelegate r10) {
        Object r11 = sActivityDelegatesLock;
        monitor-enter(r11);
        removeDelegateFromActives(r10);     // Catch: Throwable -> L7
        sActivityDelegates.add(new WeakReference(r10));     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void applyDayNightToActiveDelegates() {
        Object r10 = sActivityDelegatesLock;
        monitor-enter(r10);
        Iterator<WeakReference<AppCompatDelegate>> r11 = sActivityDelegates.iterator();     // Catch: Throwable -> L12
    L6:
        if (r11.hasNext() == false) goto L10;
        AppCompatDelegate r12 = r11.next().get();     // Catch: Throwable -> L12
        if (r12 == null) goto L6;
        r12.applyDayNight();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static void applyLocalesToActiveDelegates() {
        Iterator<WeakReference<AppCompatDelegate>> r10 = sActivityDelegates.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        AppCompatDelegate r11 = r10.next().get();
        if (r11 == null) goto L4;
        r11.applyAppLocales();
        goto L4
    }

    public static /* synthetic */ void b(Context r10) {
        lambda$asyncExecuteSyncRequestedAndStoredLocales$0(r10);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Activity r10, @Nullable AppCompatCallback r11) {
        return new AppCompatDelegateImpl(r10, r11);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Dialog r10, @Nullable AppCompatCallback r11) {
        return new AppCompatDelegateImpl(r10, r11);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context r10, @NonNull Activity r11, @Nullable AppCompatCallback r12) {
        return new AppCompatDelegateImpl(r10, r11, r12);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context r10, @NonNull Window r11, @Nullable AppCompatCallback r12) {
        return new AppCompatDelegateImpl(r10, r11, r12);
    }

    @NonNull
    @AnyThread
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static LocaleListCompat getApplicationLocales() {
        if (BuildCompat.isAtLeastT() == false) goto L8;
        Object r10 = getLocaleManagerForApplication();
        if (r10 == null) goto L12;
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(r10));
    L12:
        return LocaleListCompat.getEmptyLocaleList();
    L8:
        LocaleListCompat r11 = sRequestedAppLocales;
        if (r11 == null) goto L12;
        return r11;
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    @RequiresApi(33)
    static Object getLocaleManagerForApplication() {
        Iterator<WeakReference<AppCompatDelegate>> r10 = sActivityDelegates.iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        AppCompatDelegate r11 = r10.next().get();
        if (r11 == null) goto L4;
        Context r12 = r11.getContextForDelegate();
        if (r12 == null) goto L4;
        return r12.getSystemService("locale");
    L11:
        return null;
    }

    @Nullable
    static LocaleListCompat getRequestedAppLocales() {
        return sRequestedAppLocales;
    }

    @Nullable
    static LocaleListCompat getStoredAppLocales() {
        return sStoredAppLocales;
    }

    static boolean isAutoStorageOptedIn(Context r10) {
        if (sIsAutoStoreLocalesOptedIn != null) goto L10;
        Bundle r11 = AppLocalesMetadataHolderService.getServiceInfo(r10).metaData;     // Catch: PackageManager.NameNotFoundException -> L8
        if (r11 == null) goto L10;
        sIsAutoStoreLocalesOptedIn = Boolean.valueOf(r11.getBoolean("autoStoreLocales"));     // Catch: PackageManager.NameNotFoundException -> L8
    L8:
        Log.d(TAG, "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
        sIsAutoStoreLocalesOptedIn = Boolean.FALSE;
    L10:
        return sIsAutoStoreLocalesOptedIn.booleanValue();
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    private static /* synthetic */ void lambda$asyncExecuteSyncRequestedAndStoredLocales$0(Context r10) {
        syncRequestedAndStoredLocales(r10);
    }

    private static /* synthetic */ void lambda$syncRequestedAndStoredLocales$1(Context r10) {
        AppLocalesStorageHelper.syncLocalesToFramework(r10);
        sIsFrameworkSyncChecked = true;
    }

    static void removeActivityDelegate(@NonNull AppCompatDelegate r10) {
        Object r11 = sActivityDelegatesLock;
        monitor-enter(r11);
        removeDelegateFromActives(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void removeDelegateFromActives(@NonNull AppCompatDelegate r10) {
        Object r11 = sActivityDelegatesLock;
        monitor-enter(r11);
        Iterator<WeakReference<AppCompatDelegate>> r12 = sActivityDelegates.iterator();     // Catch: Throwable -> L13
    L6:
        if (r12.hasNext() == false) goto L11;
        AppCompatDelegate r13 = r12.next().get();     // Catch: Throwable -> L13
        if (r13 == r10) goto L10;
        if (r13 != null) goto L6;
    L10:
        r12.remove();     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    static void resetStaticRequestedAndStoredLocales() {
        sRequestedAppLocales = null;
        sStoredAppLocales = null;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static void setApplicationLocales(@NonNull LocaleListCompat r10) {
        Objects.requireNonNull(r10);
        if (BuildCompat.isAtLeastT() == false) goto L8;
        Object r11 = getLocaleManagerForApplication();
        if (r11 == null) goto L17;
        Api33Impl.localeManagerSetApplicationLocales(r11, Api24Impl.localeListForLanguageTags(r10.toLanguageTags()));
        return;
    L17:
        return;
    L8:
        if (r10.equals(sRequestedAppLocales) == true) goto L21;
        Object r12 = sActivityDelegatesLock;
        monitor-enter(r12);
        sRequestedAppLocales = r10;     // Catch: Throwable -> L14
        applyLocalesToActiveDelegates();     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean r10) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(r10);
    }

    public static void setDefaultNightMode(int r10) {
        if (r10 == (-1)) goto L13;
        if (r10 == 0) goto L13;
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L13;
        Log.d(TAG, "setDefaultNightMode() called with an unknown mode");
        return;
    L13:
        if (sDefaultNightMode == r10) goto L17;
        sDefaultNightMode = r10;
        applyDayNightToActiveDelegates();
        return;
    }

    @VisibleForTesting
    static void setIsAutoStoreLocalesOptedIn(boolean r10) {
        sIsAutoStoreLocalesOptedIn = Boolean.valueOf(r10);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    static void syncRequestedAndStoredLocales(final Context r10) {
        if (isAutoStorageOptedIn(r10) == true) goto L6;
        return;
    L6:
        if (BuildCompat.isAtLeastT() == true) goto L8;
        Object r11 = sAppLocalesStorageSyncLock;
        monitor-enter(r11);
        LocaleListCompat r12 = sRequestedAppLocales;     // Catch: Throwable -> L27
        if (r12 != null) goto L23;
        if (sStoredAppLocales != null) goto L18;
        sStoredAppLocales = LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(r10));     // Catch: Throwable -> L27
    L18:
        if (sStoredAppLocales.isEmpty() == false) goto L21;
        monitor-exit(r11);     // Catch: Throwable -> L27
        return;
    L21:
        sRequestedAppLocales = sStoredAppLocales;     // Catch: Throwable -> L27
    L25:
        monitor-exit(r11);     // Catch: Throwable -> L27
        return;
    L23:
        if (r12.equals(sStoredAppLocales) == true) goto L25;
        LocaleListCompat r13 = sRequestedAppLocales;     // Catch: Throwable -> L27
        sStoredAppLocales = r13;     // Catch: Throwable -> L27
        AppLocalesStorageHelper.persistLocales(r10, r13.toLanguageTags());     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L8:
        if (sIsFrameworkSyncChecked == true) goto L31;
        sSerialExecutorForLocalesStorage.execute(new a(r10));
        return;
    }

    public abstract void addContentView(View r10, ViewGroup.LayoutParams r11);

    boolean applyAppLocales() {
        return false;
    }

    public abstract boolean applyDayNight();

    void asyncExecuteSyncRequestedAndStoredLocales(final Context r10) {
        sSerialExecutorForLocalesStorage.execute(new b(r10));
    }

    @Deprecated
    public void attachBaseContext(Context r10) {
    }

    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context r10) {
        attachBaseContext(r10);
        return r10;
    }

    public abstract View createView(@Nullable View r10, String r11, @NonNull Context r12, @NonNull AttributeSet r13);

    @Nullable
    public abstract <T extends View> T findViewById(@IdRes int r10);

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

    public abstract boolean hasWindowFeature(int r10);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration r10);

    public abstract void onCreate(Bundle r10);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle r10);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle r10);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int r10);

    public abstract void setContentView(@LayoutRes int r10);

    public abstract void setContentView(View r10);

    public abstract void setContentView(View r10, ViewGroup.LayoutParams r11);

    public abstract void setHandleNativeActionModesEnabled(boolean r10);

    @RequiresApi(17)
    public abstract void setLocalNightMode(int r10);

    @RequiresApi(33)
    @CallSuper
    public void setOnBackInvokedDispatcher(@Nullable OnBackInvokedDispatcher r10) {
    }

    public abstract void setSupportActionBar(@Nullable Toolbar r10);

    public void setTheme(@StyleRes int r10) {
    }

    public abstract void setTitle(@Nullable CharSequence r10);

    @Nullable
    public abstract ActionMode startSupportActionMode(@NonNull ActionMode.Callback r10);
}
