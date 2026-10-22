package androidx.core.content.pm;

import android.app.ActivityManager;
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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
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

    @RequiresApi(25)
    private static class Api25Impl {
        private Api25Impl() {
        }

        static String getShortcutInfoWithLowestRank(@NonNull List<ShortcutInfo> r10) {
            Iterator<ShortcutInfo> r11 = r10.iterator();
            int r12 = -1;
            String r13 = null;
        L4:
            if (r11.hasNext() == false) goto L8;
            ShortcutInfo r14 = r11.next();
            if (r14.getRank() <= r12) goto L4;
            String r15 = r14.getId();
            r13 = r15;
            r12 = r14.getRank();
            goto L4
        L8:
            return r13;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ShortcutMatchFlags {
    }

    static {
    }

    private ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(@NonNull Context r10, @NonNull List<ShortcutInfoCompat> r11) {
        List<ShortcutInfoCompat> r12 = removeShortcutsExcludedFromSurface(r11, 1);
        int r13 = Build.VERSION.SDK_INT;
        if (r13 > 29) goto L6;
        convertUriIconsToBitmapIcons(r10, r12);
    L6:
        if (r13 < 25) goto L15;
        ArrayList r14 = new ArrayList();
        Iterator<ShortcutInfoCompat> r15 = r12.iterator();
    L9:
        if (r15.hasNext() == false) goto L12;
        r14.add(r15.next().toShortcutInfo());
        goto L9
    L12:
        if (((ShortcutManager) r10.getSystemService(ShortcutManager.class)).addDynamicShortcuts(r14) == true) goto L15;
        return false;
    L15:
        getShortcutInfoSaverInstance(r10).addShortcuts(r12);
        Iterator<ShortcutInfoChangeListener> r16 = getShortcutInfoListeners(r10).iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        r16.next().onShortcutAdded(r11);
        goto L17
    L19:
        return true;
    }

    @VisibleForTesting
    static boolean convertUriIconToBitmapIcon(@NonNull Context r10, @NonNull ShortcutInfoCompat r11) {
        IconCompat r12 = r11.mIcon;
        if (r12 != null) goto L5;
        return false;
    L5:
        int r13 = r12.mType;
        if (r13 != 6) goto L8;
    L10:
        InputStream r14 = r12.getUriInputStream(r10);
        if (r14 != null) goto L13;
        return false;
    L13:
        Bitmap r15 = BitmapFactory.decodeStream(r14);
        if (r15 != null) goto L16;
        return false;
    L16:
        if (r13 != 6) goto L18;
        IconCompat r16 = IconCompat.createWithAdaptiveBitmap(r15);
    L19:
        r11.mIcon = r16;
        return true;
    L18:
        r16 = IconCompat.createWithBitmap(r15);
        goto L19
    L8:
        if (r13 == 4) goto L10;
        return true;
    }

    @VisibleForTesting
    static void convertUriIconsToBitmapIcons(@NonNull Context r10, @NonNull List<ShortcutInfoCompat> r11) {
        Iterator r12 = new ArrayList(r11).iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ShortcutInfoCompat r13 = (ShortcutInfoCompat) r12.next();
        if (convertUriIconToBitmapIcon(r10, r13) == true) goto L4;
        r11.remove(r13);
        goto L4
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context r10, @NonNull ShortcutInfoCompat r11) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Intent r12 = ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).createShortcutResultIntent(r11.toShortcutInfo());
    L6:
        if (r12 != null) goto L9;
        r12 = new Intent();
    L9:
        return r11.addToIntent(r12);
    L5:
        r12 = null;
        goto L6
    }

    public static void disableShortcuts(@NonNull Context r10, @NonNull List<String> r11, @Nullable CharSequence r12) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).disableShortcuts(r11, r12);
    L5:
        getShortcutInfoSaverInstance(r10).removeShortcuts(r11);
        Iterator<ShortcutInfoChangeListener> r13 = getShortcutInfoListeners(r10).iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r13.next().onShortcutRemoved(r11);
        goto L7
    }

    public static void enableShortcuts(@NonNull Context r10, @NonNull List<ShortcutInfoCompat> r11) {
        List<ShortcutInfoCompat> r12 = removeShortcutsExcludedFromSurface(r11, 1);
        if (Build.VERSION.SDK_INT < 25) goto L9;
        ArrayList r13 = new ArrayList(r11.size());
        Iterator<ShortcutInfoCompat> r14 = r12.iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        r13.add(r14.next().mId);
        goto L6
    L8:
        ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).enableShortcuts(r13);
    L9:
        getShortcutInfoSaverInstance(r10).addShortcuts(r12);
        Iterator<ShortcutInfoChangeListener> r15 = getShortcutInfoListeners(r10).iterator();
    L11:
        if (r15.hasNext() == false) goto L13;
        r15.next().onShortcutAdded(r11);
        goto L11
    }

    @NonNull
    public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT < 25) goto L13;
        List<ShortcutInfo> r11 = ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        ArrayList r12 = new ArrayList(r11.size());
        Iterator<ShortcutInfo> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12.add(new ShortcutInfoCompat.Builder(r10, r13.next()).build());
        goto L6
    L8:
        return r12;
    L13:
        return getShortcutInfoSaverInstance(r10).getShortcuts();
    L12:
        return new ArrayList();
    }

    private static int getIconDimensionInternal(@NonNull Context r10, boolean r11) {
        ActivityManager r12 = (ActivityManager) r10.getSystemService("activity");
        if (Build.VERSION.SDK_INT < 19) goto L9;
        if (r12 == null) goto L9;
        if (r12.isLowRamDevice() == true) goto L9;
        boolean r13 = false;
    L10:
        if (r13 == false) goto L12;
        int r14 = 48;
    L13:
        int r15 = Math.max(1, r14);
        DisplayMetrics r16 = r10.getResources().getDisplayMetrics();
        if (r11 == false) goto L16;
        float r17 = r16.xdpi;
    L18:
        return (int) (r15 * (r17 / 160.0f));
    L16:
        r17 = r16.ydpi;
        goto L18
    L12:
        r14 = 96;
    L9:
        r13 = true;
        goto L10
    }

    public static int getIconMaxHeight(@NonNull Context r10) {
        Preconditions.checkNotNull(r10);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).getIconMaxHeight();
    L7:
        return getIconDimensionInternal(r10, false);
    }

    public static int getIconMaxWidth(@NonNull Context r10) {
        Preconditions.checkNotNull(r10);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).getIconMaxWidth();
    L7:
        return getIconDimensionInternal(r10, true);
    }

    public static int getMaxShortcutCountPerActivity(@NonNull Context r10) {
        Preconditions.checkNotNull(r10);
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        return 5;
    L5:
        return ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    @VisibleForTesting
    static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static String getShortcutInfoCompatWithLowestRank(@NonNull List<ShortcutInfoCompat> r10) {
        Iterator<ShortcutInfoCompat> r11 = r10.iterator();
        int r12 = -1;
        String r13 = null;
    L4:
        if (r11.hasNext() == false) goto L8;
        ShortcutInfoCompat r14 = r11.next();
        if (r14.getRank() <= r12) goto L4;
        String r15 = r14.getId();
        r13 = r15;
        r12 = r14.getRank();
        goto L4
    L8:
        return r13;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context r10) {
        if (sShortcutInfoChangeListeners != null) goto L24;
        ArrayList r11 = new ArrayList();
        if (Build.VERSION.SDK_INT < 21) goto L21;
        PackageManager r12 = r10.getPackageManager();
        Intent r13 = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
        r13.setPackage(r10.getPackageName());
        Iterator<ResolveInfo> r14 = r12.queryIntentActivities(r13, 128).iterator();
    L8:
        if (r14.hasNext() == false) goto L21;
        ActivityInfo r15 = r14.next().activityInfo;
        if (r15 == null) goto L8;
        Bundle r16 = r15.metaData;
        if (r16 == null) goto L8;
        String r17 = r16.getString(SHORTCUT_LISTENER_META_DATA_KEY);
        if (r17 == null) goto L8;
        r11.add((ShortcutInfoChangeListener) Class.forName(r17, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r10}));     // Catch: Exception -> L25
    L21:
        if (sShortcutInfoChangeListeners != null) goto L24;
        sShortcutInfoChangeListeners = r11;
    L24:
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context r10) {
        if (sShortcutInfoCompatSaver != null) goto L11;
        if (Build.VERSION.SDK_INT < 23) goto L8;
        sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r10});     // Catch: Exception -> L12
    L8:
        if (sShortcutInfoCompatSaver != null) goto L11;
        sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
    L11:
        return sShortcutInfoCompatSaver;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getShortcuts(@NonNull Context r10, int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 30) goto L7;
        return ShortcutInfoCompat.fromShortcuts(r10, ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).getShortcuts(r11));
    L7:
        if (r12 < 25) goto L20;
        ShortcutManager r13 = (ShortcutManager) r10.getSystemService(ShortcutManager.class);
        ArrayList r14 = new ArrayList();
        if ((r11 & 1) == 0) goto L12;
        r14.addAll(r13.getManifestShortcuts());
    L12:
        if ((r11 & 2) == 0) goto L15;
        r14.addAll(r13.getDynamicShortcuts());
    L15:
        if ((r11 & 4) == 0) goto L18;
        r14.addAll(r13.getPinnedShortcuts());
    L18:
        return ShortcutInfoCompat.fromShortcuts(r10, r14);
    L20:
        if ((r11 & 2) == 0) goto L24;
        return getShortcutInfoSaverInstance(r10).getShortcuts();
    L24:
        return Collections.emptyList();
    }

    public static boolean isRateLimitingActive(@NonNull Context r10) {
        Preconditions.checkNotNull(r10);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).isRateLimitingActive();
    L7:
        if (getShortcuts(r10, 3).size() != getMaxShortcutCountPerActivity(r10)) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isRequestPinShortcutSupported(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    L7:
        if (ContextCompat.checkSelfPermission(r10, INSTALL_SHORTCUT_PERMISSION) == 0) goto L9;
        return false;
    L9:
        Iterator<ResolveInfo> r11 = r10.getPackageManager().queryBroadcastReceivers(new Intent(ACTION_INSTALL_SHORTCUT), 0).iterator();
    L11:
        if (r11.hasNext() == false) goto L18;
        String r12 = r11.next().activityInfo.permission;
        if (TextUtils.isEmpty(r12) == true) goto L16;
        if (INSTALL_SHORTCUT_PERMISSION.equals(r12) == false) goto L11;
        return true;
    L16:
        return true;
    L18:
        return false;
    }

    public static boolean pushDynamicShortcut(@NonNull Context r10, @NonNull ShortcutInfoCompat r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        int r12 = Build.VERSION.SDK_INT;
        if (r12 <= 32) goto L5;
    L11:
        int r13 = getMaxShortcutCountPerActivity(r10);
        if (r13 != 0) goto L15;
        return false;
    L15:
        if (r12 > 29) goto L18;
        convertUriIconToBitmapIcon(r10, r11);
    L18:
        if (r12 < 30) goto L21;
        ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).pushDynamicShortcut(r11.toShortcutInfo());
    L29:
        ShortcutInfoCompatSaver<?> r14 = getShortcutInfoSaverInstance(r10);
        List<ShortcutInfoCompat> r15 = r14.getShortcuts();     // Catch: Throwable -> L40 Exception -> L47
        if (r15.size() < r13) goto L33;
        r14.removeShortcuts(Arrays.asList(new String[]{getShortcutInfoCompatWithLowestRank(r15)}));     // Catch: Throwable -> L40 Exception -> L47
    L33:
        r14.addShortcuts(Arrays.asList(new ShortcutInfoCompat[]{r11}));     // Catch: Throwable -> L40 Exception -> L47
        Iterator<ShortcutInfoChangeListener> r16 = getShortcutInfoListeners(r10).iterator();
    L36:
        if (r16.hasNext() == false) goto L38;
        r16.next().onShortcutAdded(Collections.singletonList(r11));
        goto L36
    L38:
        reportShortcutUsed(r10, r11.getId());
        return true;
    L47:
        Iterator<ShortcutInfoChangeListener> r17 = getShortcutInfoListeners(r10).iterator();
    L49:
        if (r17.hasNext() == false) goto L51;
        r17.next().onShortcutAdded(Collections.singletonList(r11));
        goto L49
    L51:
        reportShortcutUsed(r10, r11.getId());
        return false;
    L40:
        th = move-exception;
        Iterator<ShortcutInfoChangeListener> r18 = getShortcutInfoListeners(r10).iterator();
    L43:
        if (r18.hasNext() == false) goto L45;
        r18.next().onShortcutAdded(Collections.singletonList(r11));
        goto L43
    L45:
        reportShortcutUsed(r10, r11.getId());
        throw th;
    L21:
        if (r12 < 25) goto L29;
        ShortcutManager r19 = (ShortcutManager) r10.getSystemService(ShortcutManager.class);
        if (r19.isRateLimitingActive() == false) goto L25;
        return false;
    L25:
        List<ShortcutInfo> r20 = r19.getDynamicShortcuts();
        if (r20.size() < r13) goto L28;
        r19.removeDynamicShortcuts(Arrays.asList(new String[]{Api25Impl.getShortcutInfoWithLowestRank(r20)}));
    L28:
        r19.addDynamicShortcuts(Arrays.asList(new ShortcutInfo[]{r11.toShortcutInfo()}));
        goto L29
    L5:
        if (r11.isExcludedFromSurfaces(1) == false) goto L11;
        Iterator<ShortcutInfoChangeListener> r21 = getShortcutInfoListeners(r10).iterator();
    L8:
        if (r21.hasNext() == false) goto L10;
        r21.next().onShortcutAdded(Collections.singletonList(r11));
        goto L8
    L10:
        return true;
    }

    public static void removeAllDynamicShortcuts(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
    L5:
        getShortcutInfoSaverInstance(r10).removeAllShortcuts();
        Iterator<ShortcutInfoChangeListener> r11 = getShortcutInfoListeners(r10).iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().onAllShortcutsRemoved();
        goto L7
    }

    public static void removeDynamicShortcuts(@NonNull Context r10, @NonNull List<String> r11) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(r11);
    L5:
        getShortcutInfoSaverInstance(r10).removeShortcuts(r11);
        Iterator<ShortcutInfoChangeListener> r12 = getShortcutInfoListeners(r10).iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r12.next().onShortcutRemoved(r11);
        goto L7
    }

    public static void removeLongLivedShortcuts(@NonNull Context r10, @NonNull List<String> r11) {
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        removeDynamicShortcuts(r10, r11);
        return;
    L6:
        ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(r11);
        getShortcutInfoSaverInstance(r10).removeShortcuts(r11);
        Iterator<ShortcutInfoChangeListener> r12 = getShortcutInfoListeners(r10).iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r12.next().onShortcutRemoved(r11);
        goto L8
    }

    @NonNull
    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(@NonNull List<ShortcutInfoCompat> r10, int r11) {
        Objects.requireNonNull(r10);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
        return r10;
    L5:
        ArrayList r12 = new ArrayList(r10);
        Iterator<ShortcutInfoCompat> r13 = r10.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        ShortcutInfoCompat r14 = r13.next();
        if (r14.isExcludedFromSurfaces(r11) == false) goto L7;
        r12.remove(r14);
        goto L7
    L11:
        return r12;
    }

    public static void reportShortcutUsed(@NonNull Context r10, @NonNull String r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r10.getSystemService(ShortcutManager.class)).reportShortcutUsed(r11);
    L5:
        Iterator<ShortcutInfoChangeListener> r12 = getShortcutInfoListeners(r10).iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r12.next().onShortcutUsageReported(Collections.singletonList(r11));
        goto L7
    }

    public static boolean requestPinShortcut(@NonNull Context r11, @NonNull ShortcutInfoCompat r12, @Nullable final IntentSender r13) {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 > 32) goto L8;
        if (r12.isExcludedFromSurfaces(1) == false) goto L8;
        return false;
    L8:
        if (r10 < 26) goto L12;
        return ((ShortcutManager) r11.getSystemService(ShortcutManager.class)).requestPinShortcut(r12.toShortcutInfo(), r13);
    L12:
        if (isRequestPinShortcutSupported(r11) == true) goto L14;
        return false;
    L14:
        Intent r14 = r12.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
        if (r13 != null) goto L18;
        r11.sendBroadcast(r14);
        return true;
    L18:
        r11.sendOrderedBroadcast(r14, null, new AnonymousClass1(r13), null, -1, null, null);
        return true;
    }

    public static boolean setDynamicShortcuts(@NonNull Context r10, @NonNull List<ShortcutInfoCompat> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        List<ShortcutInfoCompat> r12 = removeShortcutsExcludedFromSurface(r11, 1);
        if (Build.VERSION.SDK_INT < 25) goto L12;
        ArrayList r13 = new ArrayList(r12.size());
        Iterator<ShortcutInfoCompat> r14 = r12.iterator();
    L6:
        if (r14.hasNext() == false) goto L9;
        r13.add(r14.next().toShortcutInfo());
        goto L6
    L9:
        if (((ShortcutManager) r10.getSystemService(ShortcutManager.class)).setDynamicShortcuts(r13) == true) goto L12;
        return false;
    L12:
        getShortcutInfoSaverInstance(r10).removeAllShortcuts();
        getShortcutInfoSaverInstance(r10).addShortcuts(r12);
        Iterator<ShortcutInfoChangeListener> r15 = getShortcutInfoListeners(r10).iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        ShortcutInfoChangeListener r16 = r15.next();
        r16.onAllShortcutsRemoved();
        r16.onShortcutAdded(r11);
        goto L14
    L16:
        return true;
    }

    @VisibleForTesting
    static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> r10) {
        sShortcutInfoChangeListeners = r10;
    }

    @VisibleForTesting
    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> r10) {
        sShortcutInfoCompatSaver = r10;
    }

    public static boolean updateShortcuts(@NonNull Context r10, @NonNull List<ShortcutInfoCompat> r11) {
        List<ShortcutInfoCompat> r12 = removeShortcutsExcludedFromSurface(r11, 1);
        int r13 = Build.VERSION.SDK_INT;
        if (r13 > 29) goto L6;
        convertUriIconsToBitmapIcons(r10, r12);
    L6:
        if (r13 < 25) goto L15;
        ArrayList r14 = new ArrayList();
        Iterator<ShortcutInfoCompat> r15 = r12.iterator();
    L9:
        if (r15.hasNext() == false) goto L12;
        r14.add(r15.next().toShortcutInfo());
        goto L9
    L12:
        if (((ShortcutManager) r10.getSystemService(ShortcutManager.class)).updateShortcuts(r14) == true) goto L15;
        return false;
    L15:
        getShortcutInfoSaverInstance(r10).addShortcuts(r12);
        Iterator<ShortcutInfoChangeListener> r16 = getShortcutInfoListeners(r10).iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        r16.next().onShortcutUpdated(r11);
        goto L17
    L19:
        return true;
    }
}
