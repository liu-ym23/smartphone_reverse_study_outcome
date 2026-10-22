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
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import el9.a;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ShortcutManagerCompat {
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    public static class Api25Impl {
        private Api25Impl() {
        }

        public static String getShortcutInfoWithLowestRank(List<ShortcutInfo> r5) {
            Iterator<ShortcutInfo> r6 = r5.iterator();
            int r0 = -1;
            String r1 = null;
        L4:
            if (r6.hasNext() == false) goto L8;
            ShortcutInfo r2 = r6.next();
            if (r2.getRank() <= r0) goto L4;
            String r3 = r2.getId();
            r1 = r3;
            r0 = r2.getRank();
            goto L4
        L8:
            return r1;
        }
    }

    public static /* synthetic */ Class access$000(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    private ShortcutManagerCompat() {
    }

    public static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_core_content_pm_ShortcutManagerCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static List<ShortcutInfoCompat> getDynamicShortcuts(Context r4) {
        if (Build.VERSION.SDK_INT < 25) goto L13;
        List<ShortcutInfo> r0 = ((ShortcutManager) r4.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<ShortcutInfo> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.add(new ShortcutInfoCompat.Builder(r4, r2.next()).build());
        goto L6
    L8:
        return r1;
    L13:
        return getShortcutInfoSaverInstance(r4).getShortcuts();
    L12:
        return new ArrayList();
    }

    public static int getIconMaxHeight(Context r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).getIconMaxHeight();
    L7:
        return getIconDimensionInternal(r2, false);
    }

    public static int getIconMaxWidth(Context r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).getIconMaxWidth();
    L7:
        return getIconDimensionInternal(r2, true);
    }

    public static int getMaxShortcutCountPerActivity(Context r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        return 5;
    L5:
        return ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    private static String getShortcutInfoCompatWithLowestRank(List<ShortcutInfoCompat> r5) {
        Iterator<ShortcutInfoCompat> r6 = r5.iterator();
        int r0 = -1;
        String r1 = null;
    L4:
        if (r6.hasNext() == false) goto L8;
        ShortcutInfoCompat r2 = r6.next();
        if (r2.getRank() <= r0) goto L4;
        String r3 = r2.getId();
        r1 = r3;
        r0 = r2.getRank();
        goto L4
    L8:
        return r1;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context r8) {
        if (sShortcutInfoChangeListeners != null) goto L23;
        ArrayList r0 = new ArrayList();
        PackageManager r1 = r8.getPackageManager();
        Intent r2 = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
        r2.setPackage(r8.getPackageName());
        Iterator<ResolveInfo> r3 = r1.queryIntentActivities(r2, 128).iterator();
    L6:
        if (r3.hasNext() == false) goto L20;
        ActivityInfo r4 = r3.next().activityInfo;
        if (r4 == null) goto L6;
        Bundle r5 = r4.metaData;
        if (r5 == null) goto L6;
        String r6 = r5.getString(SHORTCUT_LISTENER_META_DATA_KEY);
        if (r6 == null) goto L6;
        r0.add((ShortcutInfoChangeListener) INVOKESTATIC_androidx_core_content_pm_ShortcutManagerCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r6, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r8}));     // Catch: Exception -> L18
        goto L6
    L20:
        if (sShortcutInfoChangeListeners != null) goto L23;
        sShortcutInfoChangeListeners = r0;
    L23:
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context r6) {
        if (sShortcutInfoCompatSaver != null) goto L13;
        if (Build.VERSION.SDK_INT < 23) goto L10;
        sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) INVOKESTATIC_androidx_core_content_pm_ShortcutManagerCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r6});     // Catch: Exception -> L8
    L10:
        if (sShortcutInfoCompatSaver != null) goto L13;
        sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
    L13:
        return sShortcutInfoCompatSaver;
    }

    public static boolean isRateLimitingActive(Context r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).isRateLimitingActive();
    L7:
        if (getShortcuts(r2, 3).size() != getMaxShortcutCountPerActivity(r2)) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isRequestPinShortcutSupported(Context r4) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ((ShortcutManager) r4.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    L7:
        if (ContextCompat.checkSelfPermission(r4, INSTALL_SHORTCUT_PERMISSION) == 0) goto L9;
        return false;
    L9:
        Iterator<ResolveInfo> r5 = r4.getPackageManager().queryBroadcastReceivers(new Intent(ACTION_INSTALL_SHORTCUT), 0).iterator();
    L11:
        if (r5.hasNext() == false) goto L18;
        String r1 = r5.next().activityInfo.permission;
        if (TextUtils.isEmpty(r1) == true) goto L16;
        if (INSTALL_SHORTCUT_PERMISSION.equals(r1) == false) goto L11;
        return true;
    L16:
        return true;
    L18:
        return false;
    }

    public static void removeAllDynamicShortcuts(Context r2) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
    L5:
        getShortcutInfoSaverInstance(r2).removeAllShortcuts();
        Iterator<ShortcutInfoChangeListener> r3 = getShortcutInfoListeners(r2).iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r3.next().onAllShortcutsRemoved();
        goto L7
    }

    public static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> r0) {
        sShortcutInfoChangeListeners = r0;
    }

    public static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> r0) {
        sShortcutInfoCompatSaver = r0;
    }

    public static boolean addDynamicShortcuts(Context r5, List<ShortcutInfoCompat> r6) {
        List<ShortcutInfoCompat> r1 = removeShortcutsExcludedFromSurface(r6, 1);
        int r2 = Build.VERSION.SDK_INT;
        if (r2 > 29) goto L6;
        convertUriIconsToBitmapIcons(r5, r1);
    L6:
        if (r2 < 25) goto L15;
        ArrayList r3 = new ArrayList();
        Iterator<ShortcutInfoCompat> r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L12;
        r3.add(r4.next().toShortcutInfo());
        goto L9
    L12:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).addDynamicShortcuts(r3) == true) goto L15;
        return false;
    L15:
        getShortcutInfoSaverInstance(r5).addShortcuts(r1);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L17:
        if (r7.hasNext() == false) goto L19;
        r7.next().onShortcutAdded(r6);
        goto L17
    L19:
        return true;
    }

    public static boolean convertUriIconToBitmapIcon(Context r6, ShortcutInfoCompat r7) {
        IconCompat r0 = r7.mIcon;
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = r0.mType;
        if (r2 != 6) goto L8;
    L10:
        InputStream r8 = r0.getUriInputStream(r6);
        if (r8 != null) goto L13;
        return false;
    L13:
        Bitmap r9 = BitmapFactory.decodeStream(r8);
        if (r9 != null) goto L16;
        return false;
    L16:
        if (r2 != 6) goto L18;
        IconCompat r10 = IconCompat.createWithAdaptiveBitmap(r9);
    L19:
        r7.mIcon = r10;
        return true;
    L18:
        r10 = IconCompat.createWithBitmap(r9);
        goto L19
    L8:
        if (r2 == 4) goto L10;
        return true;
    }

    public static void convertUriIconsToBitmapIcons(Context r3, List<ShortcutInfoCompat> r4) {
        Iterator r0 = new ArrayList(r4).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ShortcutInfoCompat r1 = (ShortcutInfoCompat) r0.next();
        if (convertUriIconToBitmapIcon(r3, r1) == true) goto L4;
        r4.remove(r1);
        goto L4
    }

    public static Intent createShortcutResultIntent(Context r2, ShortcutInfoCompat r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Intent r4 = ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).createShortcutResultIntent(r3.toShortcutInfo());
    L6:
        if (r4 != null) goto L9;
        r4 = new Intent();
    L9:
        return r3.addToIntent(r4);
    L5:
        r4 = null;
        goto L6
    }

    public static void enableShortcuts(Context r4, List<ShortcutInfoCompat> r5) {
        List<ShortcutInfoCompat> r0 = removeShortcutsExcludedFromSurface(r5, 1);
        if (Build.VERSION.SDK_INT < 25) goto L9;
        ArrayList r1 = new ArrayList(r5.size());
        Iterator<ShortcutInfoCompat> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.add(r2.next().mId);
        goto L6
    L8:
        ((ShortcutManager) r4.getSystemService(ShortcutManager.class)).enableShortcuts(r1);
    L9:
        getShortcutInfoSaverInstance(r4).addShortcuts(r0);
        Iterator<ShortcutInfoChangeListener> r6 = getShortcutInfoListeners(r4).iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        r6.next().onShortcutAdded(r5);
        goto L11
    }

    private static int getIconDimensionInternal(Context r2, boolean r3) {
        ActivityManager r0 = (ActivityManager) r2.getSystemService("activity");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        int r4 = 48;
    L12:
        int r5 = Math.max(1, r4);
        DisplayMetrics r6 = INVOKEVIRTUAL_androidx_core_content_pm_ShortcutManagerCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r2.getResources());
        if (r3 == false) goto L15;
        float r7 = r6.xdpi;
    L17:
        return (int) (r5 * (r7 / 160.0f));
    L15:
        r7 = r6.ydpi;
        goto L17
    L11:
        r4 = DEFAULT_MAX_ICON_DIMENSION_DP;
        goto L12
    L5:
        if (r0.isLowRamDevice() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static List<ShortcutInfoCompat> getShortcuts(Context r3, int r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L7;
        return ShortcutInfoCompat.fromShortcuts(r3, ((ShortcutManager) r3.getSystemService(ShortcutManager.class)).getShortcuts(r4));
    L7:
        if (r0 < 25) goto L20;
        ShortcutManager r1 = (ShortcutManager) r3.getSystemService(ShortcutManager.class);
        ArrayList r2 = new ArrayList();
        if ((r4 & 1) == 0) goto L12;
        r2.addAll(r1.getManifestShortcuts());
    L12:
        if ((r4 & 2) == 0) goto L15;
        r2.addAll(r1.getDynamicShortcuts());
    L15:
        if ((r4 & 4) == 0) goto L18;
        r2.addAll(r1.getPinnedShortcuts());
    L18:
        return ShortcutInfoCompat.fromShortcuts(r3, r2);
    L20:
        if ((r4 & 2) == 0) goto L24;
        return getShortcutInfoSaverInstance(r3).getShortcuts();
    L24:
        return Collections.emptyList();
    }

    public static boolean pushDynamicShortcut(Context r6, ShortcutInfoCompat r7) {
        Preconditions.checkNotNull(r6);
        Preconditions.checkNotNull(r7);
        int r0 = Build.VERSION.SDK_INT;
        if (r0 <= 32) goto L5;
    L11:
        int r1 = getMaxShortcutCountPerActivity(r6);
        if (r1 != 0) goto L15;
        return false;
    L15:
        if (r0 > 29) goto L18;
        convertUriIconToBitmapIcon(r6, r7);
    L18:
        if (r0 < 30) goto L21;
        ((ShortcutManager) r6.getSystemService(ShortcutManager.class)).pushDynamicShortcut(r7.toShortcutInfo());
    L29:
        ShortcutInfoCompatSaver<?> r2 = getShortcutInfoSaverInstance(r6);
        List<ShortcutInfoCompat> r4 = r2.getShortcuts();     // Catch: Throwable -> L40 Exception -> L47
        if (r4.size() < r1) goto L33;
        r2.removeShortcuts(Arrays.asList(new String[]{getShortcutInfoCompatWithLowestRank(r4)}));     // Catch: Throwable -> L40 Exception -> L47
    L33:
        r2.addShortcuts(Arrays.asList(new ShortcutInfoCompat[]{r7}));     // Catch: Throwable -> L40 Exception -> L47
        Iterator<ShortcutInfoChangeListener> r3 = getShortcutInfoListeners(r6).iterator();
    L36:
        if (r3.hasNext() == false) goto L38;
        r3.next().onShortcutAdded(Collections.singletonList(r7));
        goto L36
    L38:
        reportShortcutUsed(r6, r7.getId());
        return true;
    L47:
        Iterator<ShortcutInfoChangeListener> r5 = getShortcutInfoListeners(r6).iterator();
    L49:
        if (r5.hasNext() == false) goto L51;
        r5.next().onShortcutAdded(Collections.singletonList(r7));
        goto L49
    L51:
        reportShortcutUsed(r6, r7.getId());
        return false;
    L40:
        th = move-exception;
        Iterator<ShortcutInfoChangeListener> r8 = getShortcutInfoListeners(r6).iterator();
    L43:
        if (r8.hasNext() == false) goto L45;
        r8.next().onShortcutAdded(Collections.singletonList(r7));
        goto L43
    L45:
        reportShortcutUsed(r6, r7.getId());
        throw th;
    L21:
        if (r0 < 25) goto L29;
        ShortcutManager r9 = (ShortcutManager) r6.getSystemService(ShortcutManager.class);
        if (r9.isRateLimitingActive() == false) goto L25;
        return false;
    L25:
        List<ShortcutInfo> r10 = r9.getDynamicShortcuts();
        if (r10.size() < r1) goto L28;
        r9.removeDynamicShortcuts(Arrays.asList(new String[]{Api25Impl.getShortcutInfoWithLowestRank(r10)}));
    L28:
        r9.addDynamicShortcuts(Arrays.asList(new ShortcutInfo[]{r7.toShortcutInfo()}));
        goto L29
    L5:
        if (r7.isExcludedFromSurfaces(1) == false) goto L11;
        Iterator<ShortcutInfoChangeListener> r11 = getShortcutInfoListeners(r6).iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r11.next().onShortcutAdded(Collections.singletonList(r7));
        goto L8
    L10:
        return true;
    }

    public static void removeDynamicShortcuts(Context r2, List<String> r3) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(r3);
    L5:
        getShortcutInfoSaverInstance(r2).removeShortcuts(r3);
        Iterator<ShortcutInfoChangeListener> r4 = getShortcutInfoListeners(r2).iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().onShortcutRemoved(r3);
        goto L7
    }

    public static void removeLongLivedShortcuts(Context r2, List<String> r3) {
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        removeDynamicShortcuts(r2, r3);
        return;
    L6:
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(r3);
        getShortcutInfoSaverInstance(r2).removeShortcuts(r3);
        Iterator<ShortcutInfoChangeListener> r4 = getShortcutInfoListeners(r2).iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r4.next().onShortcutRemoved(r3);
        goto L8
    }

    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(List<ShortcutInfoCompat> r3, int r4) {
        Objects.requireNonNull(r3);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
        return r3;
    L5:
        ArrayList r0 = new ArrayList(r3);
        Iterator<ShortcutInfoCompat> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        ShortcutInfoCompat r1 = r5.next();
        if (r1.isExcludedFromSurfaces(r4) == false) goto L7;
        r0.remove(r1);
        goto L7
    L11:
        return r0;
    }

    public static void reportShortcutUsed(Context r2, String r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).reportShortcutUsed(r3);
    L5:
        Iterator<ShortcutInfoChangeListener> r4 = getShortcutInfoListeners(r2).iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().onShortcutUsageReported(Collections.singletonList(r3));
        goto L7
    }

    public static boolean setDynamicShortcuts(Context r5, List<ShortcutInfoCompat> r6) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        List<ShortcutInfoCompat> r1 = removeShortcutsExcludedFromSurface(r6, 1);
        if (Build.VERSION.SDK_INT < 25) goto L12;
        ArrayList r2 = new ArrayList(r1.size());
        Iterator<ShortcutInfoCompat> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        r2.add(r3.next().toShortcutInfo());
        goto L6
    L9:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).setDynamicShortcuts(r2) == true) goto L12;
        return false;
    L12:
        getShortcutInfoSaverInstance(r5).removeAllShortcuts();
        getShortcutInfoSaverInstance(r5).addShortcuts(r1);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        ShortcutInfoChangeListener r4 = r7.next();
        r4.onAllShortcutsRemoved();
        r4.onShortcutAdded(r6);
        goto L14
    L16:
        return true;
    }

    public static boolean updateShortcuts(Context r5, List<ShortcutInfoCompat> r6) {
        List<ShortcutInfoCompat> r1 = removeShortcutsExcludedFromSurface(r6, 1);
        int r2 = Build.VERSION.SDK_INT;
        if (r2 > 29) goto L6;
        convertUriIconsToBitmapIcons(r5, r1);
    L6:
        if (r2 < 25) goto L15;
        ArrayList r3 = new ArrayList();
        Iterator<ShortcutInfoCompat> r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L12;
        r3.add(r4.next().toShortcutInfo());
        goto L9
    L12:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).updateShortcuts(r3) == true) goto L15;
        return false;
    L15:
        getShortcutInfoSaverInstance(r5).addShortcuts(r1);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L17:
        if (r7.hasNext() == false) goto L19;
        r7.next().onShortcutUpdated(r6);
        goto L17
    L19:
        return true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_content_pm_ShortcutManagerCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r5 = access$000(r2, r3, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r2);
    L12:
        throw th;
    L34:
        Class r6 = access$000(r2, r3, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r2);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r2);
    }

    public static void disableShortcuts(Context r2, List<String> r3, CharSequence r4) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).disableShortcuts(r3, r4);
    L5:
        getShortcutInfoSaverInstance(r2).removeShortcuts(r3);
        Iterator<ShortcutInfoChangeListener> r5 = getShortcutInfoListeners(r2).iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r5.next().onShortcutRemoved(r3);
        goto L7
    }

    public static boolean requestPinShortcut(Context r12, ShortcutInfoCompat r13, final IntentSender r14) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 > 32) goto L8;
        if (r13.isExcludedFromSurfaces(1) == false) goto L8;
        return false;
    L8:
        if (r0 < 26) goto L12;
        return ((ShortcutManager) r12.getSystemService(ShortcutManager.class)).requestPinShortcut(r13.toShortcutInfo(), r14);
    L12:
        if (isRequestPinShortcutSupported(r12) == true) goto L14;
        return false;
    L14:
        Intent r5 = r13.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
        if (r14 != null) goto L18;
        r12.sendBroadcast(r5);
        return true;
    L18:
        r12.sendOrderedBroadcast(r5, null, new AnonymousClass1(r14), null, -1, null, null);
        return true;
    }
}
