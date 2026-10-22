package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    private NavUtils() {
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Activity r5) {
        Intent r10 = r5.getParentActivityIntent();
        if (r10 == null) goto L5;
        return r10;
    L5:
        String r11 = getParentActivityName(r5);
        if (r11 != null) goto L8;
        return null;
    L8:
        ComponentName r12 = new ComponentName(r5, r11);
    L14:
        Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + r11 + "' in manifest");
        return null;
    L10:
        if (getParentActivityName(r5, r12) != null) goto L13;
        return Intent.makeMainActivity(r12);
    L13:
        return new Intent().setComponent(r12);
    }

    @Nullable
    public static String getParentActivityName(@NonNull Activity r5) {
        return getParentActivityName(r5, r5.getComponentName());
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static void navigateUpFromSameTask(@NonNull Activity r5) {
        Intent r10 = getParentActivityIntent(r5);
        if (r10 == null) goto L7;
        navigateUpTo(r5, r10);
        return;
    L7:
        throw new IllegalArgumentException("Activity " + r5.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(@NonNull Activity r5, @NonNull Intent r10) {
        r5.navigateUpTo(r10);
    }

    public static boolean shouldUpRecreateTask(@NonNull Activity r5, @NonNull Intent r10) {
        return r5.shouldUpRecreateTask(r10);
    }

    @Nullable
    public static String getParentActivityName(@NonNull Context r5, @NonNull ComponentName r10) throws PackageManager.NameNotFoundException {
        ActivityInfo r11 = r5.getPackageManager().getActivityInfo(r10, 269222528);
        String r12 = r11.parentActivityName;
        if (r12 == null) goto L5;
        return r12;
    L5:
        Bundle r13 = r11.metaData;
        if (r13 != null) goto L8;
        return null;
    L8:
        String r14 = r13.getString(PARENT_ACTIVITY);
        if (r14 != null) goto L12;
        return null;
    L12:
        if (r14.charAt(0) == '.') goto L14;
        return r14;
    L14:
        return r5.getPackageName() + r14;
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context r5, @NonNull Class<?> r10) throws PackageManager.NameNotFoundException {
        String r11 = getParentActivityName(r5, new ComponentName(r5, r10));
        if (r11 != null) goto L6;
        return null;
    L6:
        ComponentName r12 = new ComponentName(r5, r11);
        if (getParentActivityName(r5, r12) != null) goto L10;
        return Intent.makeMainActivity(r12);
    L10:
        return new Intent().setComponent(r12);
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context r5, @NonNull ComponentName r10) throws PackageManager.NameNotFoundException {
        String r11 = getParentActivityName(r5, r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        ComponentName r12 = new ComponentName(r10.getPackageName(), r11);
        if (getParentActivityName(r5, r12) != null) goto L10;
        return Intent.makeMainActivity(r12);
    L10:
        return new Intent().setComponent(r12);
    }
}
