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
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static class Api25Impl {
        private Api25Impl() {
        }

        static String getShortcutInfoWithLowestRank(List<ShortcutInfo> r6) {
            Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
            int r0 = -1;
            String r2 = null;
        L4:
            if (r7.hasNext() == false) goto L8;
            ShortcutInfo r3 = (ShortcutInfo) ZeusTransformUtils.preCheckCast(r7.next(), ShortcutInfo.class, "com.obric.memorydata.plugin");
            if (r3.getRank() <= r0) goto L4;
            String r1 = r3.getId();
            r2 = r1;
            r0 = r3.getRank();
            goto L4
        L8:
            return r2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }

    static {
    }

    private ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(Context r7, List<ShortcutInfoCompat> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        List<ShortcutInfoCompat> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<ShortcutInfoCompat> r2 = removeShortcutsExcludedFromSurface(r10, 1);
        if (Build.VERSION.SDK_INT > 29) goto L6;
        convertUriIconsToBitmapIcons(r9, r2);
    L6:
        if (Build.VERSION.SDK_INT < 25) goto L15;
        ArrayList r3 = new ArrayList();
        Iterator<ShortcutInfoCompat> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L12;
        r3.add(((ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(r4.next(), ShortcutInfoCompat.class, "com.obric.memorydata.plugin")).toShortcutInfo());
        goto L9
    L12:
        if (((ShortcutManager) ZeusTransformUtils.preCheckCast(r9.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).addDynamicShortcuts(r3) == true) goto L15;
        return false;
    L15:
        getShortcutInfoSaverInstance(r9).addShortcuts(r2);
        Iterator<ShortcutInfoChangeListener> r11 = getShortcutInfoListeners(r9).iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r11.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutAdded(r10);
        goto L17
    L19:
        return true;
    }

    static boolean convertUriIconToBitmapIcon(Context r5, ShortcutInfoCompat r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6.mIcon != null) goto L5;
        return false;
    L5:
        int r0 = r6.mIcon.mType;
        if (r0 != 6) goto L8;
    L10:
        InputStream r8 = r6.mIcon.getUriInputStream(r7);
        if (r8 != null) goto L13;
        return false;
    L13:
        Bitmap r9 = BitmapFactory.decodeStream(r8);
        if (r9 != null) goto L16;
        return false;
    L16:
        if (r0 != 6) goto L18;
        IconCompat r10 = IconCompat.createWithAdaptiveBitmap(r9);
    L19:
        r6.mIcon = r10;
        return true;
    L18:
        r10 = IconCompat.createWithBitmap(r9);
        goto L19
    L8:
        if (r0 == 4) goto L10;
        return true;
    }

    static void convertUriIconsToBitmapIcons(Context r4, List<ShortcutInfoCompat> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Iterator r0 = new ArrayList(r7).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ShortcutInfoCompat r2 = (ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(r0.next(), ShortcutInfoCompat.class, "com.obric.memorydata.plugin");
        if (convertUriIconToBitmapIcon(r6, r2) == true) goto L4;
        r7.remove(r2);
        goto L4
    }

    public static Intent createShortcutResultIntent(Context r3, ShortcutInfoCompat r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Intent r6 = ((ShortcutManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).createShortcutResultIntent(r4.toShortcutInfo());
    L6:
        if (r6 != null) goto L9;
        r6 = new Intent();
    L9:
        return r4.addToIntent(r6);
    L5:
        r6 = null;
        goto L6
    }

    public static void disableShortcuts(Context r3, List<String> r4, CharSequence r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) ZeusTransformUtils.preCheckCast(r6.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).disableShortcuts(r7, r8);
    L5:
        getShortcutInfoSaverInstance(r6).removeShortcuts(r7);
        Iterator<ShortcutInfoChangeListener> r9 = getShortcutInfoListeners(r6).iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r9.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutRemoved(r7);
        goto L7
    }

    public static void enableShortcuts(Context r6, List<ShortcutInfoCompat> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        List<ShortcutInfoCompat> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<ShortcutInfoCompat> r0 = removeShortcutsExcludedFromSurface(r9, 1);
        if (Build.VERSION.SDK_INT < 25) goto L9;
        ArrayList r2 = new ArrayList(r9.size());
        Iterator<ShortcutInfoCompat> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.add(((ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(r3.next(), ShortcutInfoCompat.class, "com.obric.memorydata.plugin")).mId);
        goto L6
    L8:
        ((ShortcutManager) ZeusTransformUtils.preCheckCast(r8.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).enableShortcuts(r2);
    L9:
        getShortcutInfoSaverInstance(r8).addShortcuts(r0);
        Iterator<ShortcutInfoChangeListener> r10 = getShortcutInfoListeners(r8).iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r10.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutAdded(r9);
        goto L11
    }

    public static List<ShortcutInfoCompat> getDynamicShortcuts(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 25) goto L13;
        List<ShortcutInfo> r0 = ((ShortcutManager) ZeusTransformUtils.preCheckCast(r6.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).getDynamicShortcuts();
        ArrayList r2 = new ArrayList(r0.size());
        Iterator<ShortcutInfo> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r2.add(new ShortcutInfoCompat.Builder(r6, (ShortcutInfo) ZeusTransformUtils.preCheckCast(r1.next(), ShortcutInfo.class, "com.obric.memorydata.plugin")).build());
        goto L6
    L8:
        return r2;
    L13:
        return getShortcutInfoSaverInstance(r6).getShortcuts();
    L12:
        return new ArrayList();
    }

    private static int getIconDimensionInternal(Context r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        ActivityManager r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(r7.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L9;
        if (r0 == null) goto L9;
        if (r0.isLowRamDevice() == true) goto L9;
        boolean r1 = false;
    L10:
        if (r1 == false) goto L12;
        int r2 = 48;
    L13:
        int r3 = Math.max(1, r2);
        DisplayMetrics r8 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDisplayMetrics();
        if (r6 == false) goto L16;
        float r9 = r8.xdpi;
    L18:
        return (int) (r3 * (r9 / 160.0f));
    L16:
        r9 = r8.ydpi;
        goto L18
    L12:
        r2 = DEFAULT_MAX_ICON_DIMENSION_DP;
    L9:
        r1 = true;
        goto L10
    }

    public static int getIconMaxHeight(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Preconditions.checkNotNull(r4);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).getIconMaxHeight();
    L7:
        return getIconDimensionInternal(r4, false);
    }

    public static int getIconMaxWidth(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Preconditions.checkNotNull(r4);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).getIconMaxWidth();
    L7:
        return getIconDimensionInternal(r4, true);
    }

    public static int getMaxShortcutCountPerActivity(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Preconditions.checkNotNull(r4);
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        return 5;
    L5:
        return ((ShortcutManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).getMaxShortcutCountPerActivity();
    }

    static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static String getShortcutInfoCompatWithLowestRank(List<ShortcutInfoCompat> r6) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = -1;
        String r2 = null;
    L4:
        if (r7.hasNext() == false) goto L8;
        ShortcutInfoCompat r3 = (ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(r7.next(), ShortcutInfoCompat.class, "com.obric.memorydata.plugin");
        if (r3.getRank() <= r0) goto L4;
        String r1 = r3.getId();
        r2 = r1;
        r0 = r3.getRank();
        goto L4
    L8:
        return r2;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        if (sShortcutInfoChangeListeners != null) goto L24;
        ArrayList r0 = new ArrayList();
        if (Build.VERSION.SDK_INT < 21) goto L21;
        PackageManager r2 = r10.getPackageManager();
        Intent r3 = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
        r3.setPackage(r10.getPackageName());
        Iterator<ResolveInfo> r4 = r2.queryIntentActivities(r3, 128).iterator();
    L8:
        if (r4.hasNext() == false) goto L21;
        ActivityInfo r5 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r4.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).activityInfo;
        if (r5 == null) goto L8;
        Bundle r6 = r5.metaData;
        if (r6 == null) goto L8;
        String r7 = r6.getString(SHORTCUT_LISTENER_META_DATA_KEY);
        if (r7 == null) goto L8;
        r0.add((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(Class.forName(r7, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r10}), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L25
    L21:
        if (sShortcutInfoChangeListeners != null) goto L24;
        sShortcutInfoChangeListeners = r0;
    L24:
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (sShortcutInfoCompatSaver != null) goto L11;
        if (Build.VERSION.SDK_INT < 23) goto L8;
        sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) ZeusTransformUtils.preCheckCast(Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r8}), ShortcutInfoCompatSaver.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
    L8:
        if (sShortcutInfoCompatSaver != null) goto L11;
        sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
    L11:
        return sShortcutInfoCompatSaver;
    }

    public static List<ShortcutInfoCompat> getShortcuts(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return ShortcutInfoCompat.fromShortcuts(r5, ((ShortcutManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).getShortcuts(r4));
    L7:
        if (Build.VERSION.SDK_INT < 25) goto L20;
        ShortcutManager r0 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin");
        ArrayList r1 = new ArrayList();
        if ((r4 & 1) == 0) goto L12;
        r1.addAll(r0.getManifestShortcuts());
    L12:
        if ((r4 & 2) == 0) goto L15;
        r1.addAll(r0.getDynamicShortcuts());
    L15:
        if ((r4 & 4) == 0) goto L18;
        r1.addAll(r0.getPinnedShortcuts());
    L18:
        return ShortcutInfoCompat.fromShortcuts(r5, r1);
    L20:
        if ((r4 & 2) == 0) goto L24;
        return getShortcutInfoSaverInstance(r5).getShortcuts();
    L24:
        return Collections.emptyList();
    }

    public static boolean isRateLimitingActive(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Preconditions.checkNotNull(r4);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).isRateLimitingActive();
    L7:
        if (getShortcuts(r4, 3).size() != getMaxShortcutCountPerActivity(r4)) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isRequestPinShortcutSupported(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ((ShortcutManager) ZeusTransformUtils.preCheckCast(r6.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).isRequestPinShortcutSupported();
    L7:
        if (ContextCompat.checkSelfPermission(r6, INSTALL_SHORTCUT_PERMISSION) == 0) goto L9;
        return false;
    L9:
        Iterator<ResolveInfo> r7 = r6.getPackageManager().queryBroadcastReceivers(new Intent(ACTION_INSTALL_SHORTCUT), 0).iterator();
    L11:
        if (r7.hasNext() == false) goto L18;
        String r2 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r7.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).activityInfo.permission;
        if (TextUtils.isEmpty(r2) == true) goto L16;
        if (INSTALL_SHORTCUT_PERMISSION.equals(r2) == false) goto L11;
        return true;
    L16:
        return true;
    L18:
        return false;
    }

    public static boolean pushDynamicShortcut(Context r7, ShortcutInfoCompat r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r8);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
    L11:
        int r0 = getMaxShortcutCountPerActivity(r9);
        if (r0 != 0) goto L15;
        return false;
    L15:
        if (Build.VERSION.SDK_INT > 29) goto L18;
        convertUriIconToBitmapIcon(r9, r8);
    L18:
        if (Build.VERSION.SDK_INT < 30) goto L21;
        ((ShortcutManager) ZeusTransformUtils.preCheckCast(r9.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).pushDynamicShortcut(r8.toShortcutInfo());
    L29:
        ShortcutInfoCompatSaver<?> r4 = getShortcutInfoSaverInstance(r9);
        List<ShortcutInfoCompat> r5 = r4.getShortcuts();     // Catch: Throwable -> L40 Exception -> L47
        if (r5.size() < r0) goto L33;
        r4.removeShortcuts(Arrays.asList(new String[]{getShortcutInfoCompatWithLowestRank(r5)}));     // Catch: Throwable -> L40 Exception -> L47
    L33:
        r4.addShortcuts(Arrays.asList(new ShortcutInfoCompat[]{r8}));     // Catch: Throwable -> L40 Exception -> L47
        Iterator<ShortcutInfoChangeListener> r1 = getShortcutInfoListeners(r9).iterator();
    L36:
        if (r1.hasNext() == false) goto L38;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r1.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutAdded(Collections.singletonList(r8));
        goto L36
    L38:
        reportShortcutUsed(r9, r8.getId());
        return true;
    L47:
        Iterator<ShortcutInfoChangeListener> r2 = getShortcutInfoListeners(r9).iterator();
    L49:
        if (r2.hasNext() == false) goto L51;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r2.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutAdded(Collections.singletonList(r8));
        goto L49
    L51:
        reportShortcutUsed(r9, r8.getId());
        return false;
    L40:
        th = move-exception;
        Iterator<ShortcutInfoChangeListener> r3 = getShortcutInfoListeners(r9).iterator();
    L43:
        if (r3.hasNext() == false) goto L45;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r3.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutAdded(Collections.singletonList(r8));
        goto L43
    L45:
        reportShortcutUsed(r9, r8.getId());
        throw th;
    L21:
        if (Build.VERSION.SDK_INT < 25) goto L29;
        ShortcutManager r6 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r9.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin");
        if (r6.isRateLimitingActive() == false) goto L25;
        return false;
    L25:
        List<ShortcutInfo> r10 = r6.getDynamicShortcuts();
        if (r10.size() < r0) goto L28;
        r6.removeDynamicShortcuts(Arrays.asList(new String[]{Api25Impl.getShortcutInfoWithLowestRank(r10)}));
    L28:
        r6.addDynamicShortcuts(Arrays.asList(new ShortcutInfo[]{r8.toShortcutInfo()}));
        goto L29
    L5:
        if (r8.isExcludedFromSurfaces(1) == false) goto L11;
        Iterator<ShortcutInfoChangeListener> r11 = getShortcutInfoListeners(r9).iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r11.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutAdded(Collections.singletonList(r8));
        goto L8
    L10:
        return true;
    }

    public static void removeAllDynamicShortcuts(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).removeAllDynamicShortcuts();
    L5:
        getShortcutInfoSaverInstance(r4).removeAllShortcuts();
        Iterator<ShortcutInfoChangeListener> r5 = getShortcutInfoListeners(r4).iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r5.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onAllShortcutsRemoved();
        goto L7
    }

    public static void removeDynamicShortcuts(Context r3, List<String> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).removeDynamicShortcuts(r6);
    L5:
        getShortcutInfoSaverInstance(r5).removeShortcuts(r6);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r7.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutRemoved(r6);
        goto L7
    }

    public static void removeLongLivedShortcuts(Context r3, List<String> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        removeDynamicShortcuts(r5, r6);
        return;
    L6:
        ((ShortcutManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).removeLongLivedShortcuts(r6);
        getShortcutInfoSaverInstance(r5).removeShortcuts(r6);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r7.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutRemoved(r6);
        goto L8
    }

    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(List<ShortcutInfoCompat> r4, int r5) {
        List<ShortcutInfoCompat> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
        return r6;
    L5:
        ArrayList r0 = new ArrayList(r6);
        Iterator<ShortcutInfoCompat> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L11;
        ShortcutInfoCompat r2 = (ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(r7.next(), ShortcutInfoCompat.class, "com.obric.memorydata.plugin");
        if (r2.isExcludedFromSurfaces(r5) == false) goto L7;
        r0.remove(r2);
        goto L7
    L11:
        return r0;
    }

    public static void reportShortcutUsed(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r4);
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).reportShortcutUsed(r4);
    L5:
        Iterator<ShortcutInfoChangeListener> r6 = getShortcutInfoListeners(r5).iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r6.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutUsageReported(Collections.singletonList(r4));
        goto L7
    }

    public static boolean requestPinShortcut(Context r11, ShortcutInfoCompat r12, final IntentSender r13) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT > 32) goto L8;
        if (r12.isExcludedFromSurfaces(1) == false) goto L8;
        return false;
    L8:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        return ((ShortcutManager) ZeusTransformUtils.preCheckCast(r2.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).requestPinShortcut(r12.toShortcutInfo(), r13);
    L12:
        if (isRequestPinShortcutSupported(r2) == true) goto L14;
        return false;
    L14:
        Intent r3 = r12.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
        if (r13 != null) goto L18;
        r2.sendBroadcast(r3);
        return true;
    L18:
        r2.sendOrderedBroadcast(r3, null, new AnonymousClass1(r13), null, -1, null, null);
        return true;
    }

    public static boolean setDynamicShortcuts(Context r7, List<ShortcutInfoCompat> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        List<ShortcutInfoCompat> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Preconditions.checkNotNull(r9);
        Preconditions.checkNotNull(r10);
        List<ShortcutInfoCompat> r2 = removeShortcutsExcludedFromSurface(r10, 1);
        if (Build.VERSION.SDK_INT < 25) goto L12;
        ArrayList r3 = new ArrayList(r2.size());
        Iterator<ShortcutInfoCompat> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        r3.add(((ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(r4.next(), ShortcutInfoCompat.class, "com.obric.memorydata.plugin")).toShortcutInfo());
        goto L6
    L9:
        if (((ShortcutManager) ZeusTransformUtils.preCheckCast(r9.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).setDynamicShortcuts(r3) == true) goto L12;
        return false;
    L12:
        getShortcutInfoSaverInstance(r9).removeAllShortcuts();
        getShortcutInfoSaverInstance(r9).addShortcuts(r2);
        Iterator<ShortcutInfoChangeListener> r11 = getShortcutInfoListeners(r9).iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        ShortcutInfoChangeListener r5 = (ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r11.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin");
        r5.onAllShortcutsRemoved();
        r5.onShortcutAdded(r10);
        goto L14
    L16:
        return true;
    }

    static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> r2) {
        sShortcutInfoChangeListeners = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> r0) {
        sShortcutInfoCompatSaver = r0;
    }

    public static boolean updateShortcuts(Context r7, List<ShortcutInfoCompat> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        List<ShortcutInfoCompat> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<ShortcutInfoCompat> r2 = removeShortcutsExcludedFromSurface(r10, 1);
        if (Build.VERSION.SDK_INT > 29) goto L6;
        convertUriIconsToBitmapIcons(r9, r2);
    L6:
        if (Build.VERSION.SDK_INT < 25) goto L15;
        ArrayList r3 = new ArrayList();
        Iterator<ShortcutInfoCompat> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L12;
        r3.add(((ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(r4.next(), ShortcutInfoCompat.class, "com.obric.memorydata.plugin")).toShortcutInfo());
        goto L9
    L12:
        if (((ShortcutManager) ZeusTransformUtils.preCheckCast(r9.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.memorydata.plugin")).updateShortcuts(r3) == true) goto L15;
        return false;
    L15:
        getShortcutInfoSaverInstance(r9).addShortcuts(r2);
        Iterator<ShortcutInfoChangeListener> r11 = getShortcutInfoListeners(r9).iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        ((ShortcutInfoChangeListener) ZeusTransformUtils.preCheckCast(r11.next(), ShortcutInfoChangeListener.class, "com.obric.memorydata.plugin")).onShortcutUpdated(r10);
        goto L17
    L19:
        return true;
    }
}
