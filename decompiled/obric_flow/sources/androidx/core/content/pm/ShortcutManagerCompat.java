package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutManagerCompat {

    @VisibleForTesting
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;

    @VisibleForTesting
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    /* JADX INFO: renamed from: androidx.core.content.pm.ShortcutManagerCompat$1, reason: invalid class name */
    public class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ IntentSender val$callback;

        public AnonymousClass1(IntentSender r5) {
            this.val$callback = r5;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            this.val$callback.sendIntent(r10, 0, null, null, null);     // Catch: IntentSender.SendIntentException -> L4
            return;
        }
    }

    @RequiresApi(25)
    public static class Api25Impl {
        private Api25Impl() {
        }

        public static String getShortcutInfoWithLowestRank(@NonNull List<ShortcutInfo> r5) {
            Iterator<ShortcutInfo> r10 = r5.iterator();
            int r11 = -1;
            String r12 = null;
        L4:
            if (r10.hasNext() == false) goto L8;
            ShortcutInfo r13 = r10.next();
            if (r13.getRank() <= r11) goto L4;
            String r14 = r13.getId();
            r12 = r14;
            r11 = r13.getRank();
            goto L4
        L8:
            return r12;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ShortcutMatchFlags {
    }

    private ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(@NonNull Context r5, @NonNull List<ShortcutInfoCompat> r10) {
        List<ShortcutInfoCompat> r11 = removeShortcutsExcludedFromSurface(r10, 1);
        ArrayList r12 = new ArrayList();
        Iterator<ShortcutInfoCompat> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        r12.add(r13.next().toShortcutInfo());
        goto L4
    L7:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).addDynamicShortcuts(r12) == true) goto L10;
        return false;
    L10:
        getShortcutInfoSaverInstance(r5).addShortcuts(r11);
        Iterator<ShortcutInfoChangeListener> r14 = getShortcutInfoListeners(r5).iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        r14.next().onShortcutAdded(r10);
        goto L12
    L14:
        return true;
    }

    @VisibleForTesting
    public static boolean convertUriIconToBitmapIcon(@NonNull Context r10, @NonNull ShortcutInfoCompat r11) {
        IconCompat r5 = r11.mIcon;
        if (r5 != null) goto L5;
        return false;
    L5:
        int r12 = r5.mType;
        if (r12 != 6) goto L8;
    L10:
        InputStream r13 = r5.getUriInputStream(r10);
        if (r13 != null) goto L13;
        return false;
    L13:
        Bitmap r14 = BitmapFactory.decodeStream(r13);
        if (r14 != null) goto L16;
        return false;
    L16:
        if (r12 != 6) goto L18;
        IconCompat r15 = IconCompat.createWithAdaptiveBitmap(r14);
    L19:
        r11.mIcon = r15;
        return true;
    L18:
        r15 = IconCompat.createWithBitmap(r14);
        goto L19
    L8:
        if (r12 == 4) goto L10;
        return true;
    }

    @VisibleForTesting
    public static void convertUriIconsToBitmapIcons(@NonNull Context r5, @NonNull List<ShortcutInfoCompat> r10) {
        Iterator r11 = new ArrayList(r10).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ShortcutInfoCompat r12 = (ShortcutInfoCompat) r11.next();
        if (convertUriIconToBitmapIcon(r5, r12) == true) goto L4;
        r10.remove(r12);
        goto L4
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context r5, @NonNull ShortcutInfoCompat r10) {
        Intent r11 = ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).createShortcutResultIntent(r10.toShortcutInfo());
        if (r11 != null) goto L6;
        r11 = new Intent();
    L6:
        return r10.addToIntent(r11);
    }

    public static void disableShortcuts(@NonNull Context r5, @NonNull List<String> r10, @Nullable CharSequence r11) {
        ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).disableShortcuts(r10, r11);
        getShortcutInfoSaverInstance(r5).removeShortcuts(r10);
        Iterator<ShortcutInfoChangeListener> r12 = getShortcutInfoListeners(r5).iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().onShortcutRemoved(r10);
        goto L4
    }

    public static void enableShortcuts(@NonNull Context r5, @NonNull List<ShortcutInfoCompat> r10) {
        List<ShortcutInfoCompat> r11 = removeShortcutsExcludedFromSurface(r10, 1);
        ArrayList r12 = new ArrayList(r10.size());
        Iterator<ShortcutInfoCompat> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(r13.next().mId);
        goto L4
    L6:
        ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).enableShortcuts(r12);
        getShortcutInfoSaverInstance(r5).addShortcuts(r11);
        Iterator<ShortcutInfoChangeListener> r14 = getShortcutInfoListeners(r5).iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r14.next().onShortcutAdded(r10);
        goto L8
    }

    @NonNull
    public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context r5) {
        List<ShortcutInfo> r10 = ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<ShortcutInfo> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(new ShortcutInfoCompat.Builder(r5, r12.next()).build());
        goto L4
    L6:
        return r11;
    }

    private static int getIconDimensionInternal(@NonNull Context r5, boolean r10) {
        ActivityManager r11 = (ActivityManager) r5.getSystemService("activity");
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        int r13 = 48;
    L12:
        int r14 = Math.max(1, r13);
        DisplayMetrics r15 = r5.getResources().getDisplayMetrics();
        if (r10 == false) goto L15;
        float r16 = r15.xdpi;
    L17:
        return (int) (r14 * (r16 / 160.0f));
    L15:
        r16 = r15.ydpi;
        goto L17
    L11:
        r13 = 96;
        goto L12
    L5:
        if (r11.isLowRamDevice() == true) goto L8;
        r12 = false;
        goto L9
    }

    public static int getIconMaxHeight(@NonNull Context r5) {
        Preconditions.checkNotNull(r5);
        return ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).getIconMaxHeight();
    }

    public static int getIconMaxWidth(@NonNull Context r5) {
        Preconditions.checkNotNull(r5);
        return ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).getIconMaxWidth();
    }

    public static int getMaxShortcutCountPerActivity(@NonNull Context r5) {
        Preconditions.checkNotNull(r5);
        return ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    @VisibleForTesting
    public static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static String getShortcutInfoCompatWithLowestRank(@NonNull List<ShortcutInfoCompat> r5) {
        Iterator<ShortcutInfoCompat> r10 = r5.iterator();
        int r11 = -1;
        String r12 = null;
    L4:
        if (r10.hasNext() == false) goto L8;
        ShortcutInfoCompat r13 = r10.next();
        if (r13.getRank() <= r11) goto L4;
        String r14 = r13.getId();
        r12 = r14;
        r11 = r13.getRank();
        goto L4
    L8:
        return r12;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context r5) {
        if (sShortcutInfoChangeListeners != null) goto L22;
        ArrayList r10 = new ArrayList();
        PackageManager r11 = r5.getPackageManager();
        Intent r12 = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
        r12.setPackage(r5.getPackageName());
        Iterator<ResolveInfo> r13 = r11.queryIntentActivities(r12, 128).iterator();
    L6:
        if (r13.hasNext() == false) goto L19;
        ActivityInfo r14 = r13.next().activityInfo;
        if (r14 == null) goto L6;
        Bundle r15 = r14.metaData;
        if (r15 == null) goto L6;
        String r16 = r15.getString(SHORTCUT_LISTENER_META_DATA_KEY);
        if (r16 == null) goto L6;
        r10.add((ShortcutInfoChangeListener) Class.forName(r16, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r5}));     // Catch: Exception -> L23
        goto L6
    L19:
        if (sShortcutInfoChangeListeners != null) goto L22;
        sShortcutInfoChangeListeners = r10;
    L22:
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context r5) {
        if (sShortcutInfoCompatSaver != null) goto L9;
        sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r5});     // Catch: Exception -> L10
    L6:
        if (sShortcutInfoCompatSaver != null) goto L9;
        sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
    L9:
        return sShortcutInfoCompatSaver;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getShortcuts(@NonNull Context r5, int r10) {
        return ShortcutInfoCompat.fromShortcuts(r5, ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).getShortcuts(r10));
    }

    public static boolean isRateLimitingActive(@NonNull Context r5) {
        Preconditions.checkNotNull(r5);
        return ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).isRateLimitingActive();
    }

    public static boolean isRequestPinShortcutSupported(@NonNull Context r5) {
        return ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    }

    public static boolean pushDynamicShortcut(@NonNull Context r10, @NonNull ShortcutInfoCompat r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
    L11:
        int r5 = getMaxShortcutCountPerActivity(r10);
        if (r5 != 0) goto L14;
        return false;
    L14:
        ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).pushDynamicShortcut(r11.toShortcutInfo());
        ShortcutInfoCompatSaver<?> r12 = getShortcutInfoSaverInstance(r10);
        List<ShortcutInfoCompat> r13 = r12.getShortcuts();     // Catch: Throwable -> L18 Exception -> L33
        if (r13.size() < r5) goto L20;
        r12.removeShortcuts(Arrays.asList(new String[]{getShortcutInfoCompatWithLowestRank(r13)}));     // Catch: Throwable -> L18 Exception -> L33
    L20:
        r12.addShortcuts(Arrays.asList(new ShortcutInfoCompat[]{r11}));     // Catch: Throwable -> L18 Exception -> L33
        Iterator<ShortcutInfoChangeListener> r14 = getShortcutInfoListeners(r10).iterator();
    L23:
        if (r14.hasNext() == false) goto L25;
        r14.next().onShortcutAdded(Collections.singletonList(r11));
        goto L23
    L25:
        reportShortcutUsed(r10, r11.getId());
        return true;
    L33:
        Iterator<ShortcutInfoChangeListener> r15 = getShortcutInfoListeners(r10).iterator();
    L35:
        if (r15.hasNext() == false) goto L37;
        r15.next().onShortcutAdded(Collections.singletonList(r11));
        goto L35
    L37:
        reportShortcutUsed(r10, r11.getId());
        return false;
    L18:
        th = move-exception;
        Iterator<ShortcutInfoChangeListener> r16 = getShortcutInfoListeners(r10).iterator();
    L29:
        if (r16.hasNext() == false) goto L31;
        r16.next().onShortcutAdded(Collections.singletonList(r11));
        goto L29
    L31:
        reportShortcutUsed(r10, r11.getId());
        throw th;
    L5:
        if (r11.isExcludedFromSurfaces(1) == false) goto L11;
        Iterator<ShortcutInfoChangeListener> r17 = getShortcutInfoListeners(r10).iterator();
    L8:
        if (r17.hasNext() == false) goto L10;
        r17.next().onShortcutAdded(Collections.singletonList(r11));
        goto L8
    L10:
        return true;
    }

    public static void removeAllDynamicShortcuts(@NonNull Context r5) {
        ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        getShortcutInfoSaverInstance(r5).removeAllShortcuts();
        Iterator<ShortcutInfoChangeListener> r10 = getShortcutInfoListeners(r5).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onAllShortcutsRemoved();
        goto L4
    }

    public static void removeDynamicShortcuts(@NonNull Context r5, @NonNull List<String> r10) {
        ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(r10);
        getShortcutInfoSaverInstance(r5).removeShortcuts(r10);
        Iterator<ShortcutInfoChangeListener> r11 = getShortcutInfoListeners(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onShortcutRemoved(r10);
        goto L4
    }

    public static void removeLongLivedShortcuts(@NonNull Context r5, @NonNull List<String> r10) {
        ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(r10);
        getShortcutInfoSaverInstance(r5).removeShortcuts(r10);
        Iterator<ShortcutInfoChangeListener> r11 = getShortcutInfoListeners(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onShortcutRemoved(r10);
        goto L4
    }

    @NonNull
    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(@NonNull List<ShortcutInfoCompat> r5, int r10) {
        Objects.requireNonNull(r5);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
        return r5;
    L5:
        ArrayList r11 = new ArrayList(r5);
        Iterator<ShortcutInfoCompat> r12 = r5.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        ShortcutInfoCompat r13 = r12.next();
        if (r13.isExcludedFromSurfaces(r10) == false) goto L7;
        r11.remove(r13);
        goto L7
    L11:
        return r11;
    }

    public static void reportShortcutUsed(@NonNull Context r5, @NonNull String r10) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r10);
        ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).reportShortcutUsed(r10);
        Iterator<ShortcutInfoChangeListener> r11 = getShortcutInfoListeners(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onShortcutUsageReported(Collections.singletonList(r10));
        goto L4
    }

    public static boolean requestPinShortcut(@NonNull Context r5, @NonNull ShortcutInfoCompat r10, @Nullable IntentSender r11) {
        if (Build.VERSION.SDK_INT > 32) goto L9;
        if (r10.isExcludedFromSurfaces(1) == false) goto L9;
        return false;
    L9:
        return ((ShortcutManager) r5.getSystemService(ShortcutManager.class)).requestPinShortcut(r10.toShortcutInfo(), r11);
    }

    public static boolean setDynamicShortcuts(@NonNull Context r5, @NonNull List<ShortcutInfoCompat> r10) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r10);
        List<ShortcutInfoCompat> r11 = removeShortcutsExcludedFromSurface(r10, 1);
        ArrayList r12 = new ArrayList(r11.size());
        Iterator<ShortcutInfoCompat> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        r12.add(r13.next().toShortcutInfo());
        goto L4
    L7:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).setDynamicShortcuts(r12) == true) goto L10;
        return false;
    L10:
        getShortcutInfoSaverInstance(r5).removeAllShortcuts();
        getShortcutInfoSaverInstance(r5).addShortcuts(r11);
        Iterator<ShortcutInfoChangeListener> r14 = getShortcutInfoListeners(r5).iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        ShortcutInfoChangeListener r15 = r14.next();
        r15.onAllShortcutsRemoved();
        r15.onShortcutAdded(r10);
        goto L12
    L14:
        return true;
    }

    @VisibleForTesting
    public static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> r5) {
        sShortcutInfoChangeListeners = r5;
    }

    @VisibleForTesting
    public static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> r5) {
        sShortcutInfoCompatSaver = r5;
    }

    public static boolean updateShortcuts(@NonNull Context r5, @NonNull List<ShortcutInfoCompat> r10) {
        List<ShortcutInfoCompat> r11 = removeShortcutsExcludedFromSurface(r10, 1);
        ArrayList r12 = new ArrayList();
        Iterator<ShortcutInfoCompat> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        r12.add(r13.next().toShortcutInfo());
        goto L4
    L7:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).updateShortcuts(r12) == true) goto L10;
        return false;
    L10:
        getShortcutInfoSaverInstance(r5).addShortcuts(r11);
        Iterator<ShortcutInfoChangeListener> r14 = getShortcutInfoListeners(r5).iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        r14.next().onShortcutUpdated(r10);
        goto L12
    L14:
        return true;
    }
}
