package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static Intent getParentActivityIntent(Activity r10) {
            return r10.getParentActivityIntent();
        }

        @DoNotInline
        static boolean navigateUpTo(Activity r10, Intent r11) {
            return r10.navigateUpTo(r11);
        }

        @DoNotInline
        static boolean shouldUpRecreateTask(Activity r10, Intent r11) {
            return r10.shouldUpRecreateTask(r11);
        }
    }

    private NavUtils() {
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Activity r10) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Intent r11 = Api16Impl.getParentActivityIntent(r10);
        if (r11 == null) goto L7;
        return r11;
    L7:
        String r12 = getParentActivityName(r10);
        if (r12 != null) goto L10;
        return null;
    L10:
        ComponentName r13 = new ComponentName(r10, r12);
    L16:
        Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + r12 + "' in manifest");
        return null;
    L12:
        if (getParentActivityName(r10, r13) != null) goto L15;
        return Intent.makeMainActivity(r13);
    L15:
        return new Intent().setComponent(r13);
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context r10, @NonNull ComponentName r11) {
        String r12 = getParentActivityName(r10, r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        ComponentName r13 = new ComponentName(r11.getPackageName(), r12);
        if (getParentActivityName(r10, r13) != null) goto L10;
        return Intent.makeMainActivity(r13);
    L10:
        return new Intent().setComponent(r13);
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context r10, @NonNull Class<?> r11) {
        String r12 = getParentActivityName(r10, new ComponentName(r10, r11));
        if (r12 != null) goto L6;
        return null;
    L6:
        ComponentName r13 = new ComponentName(r10, r12);
        if (getParentActivityName(r10, r13) != null) goto L10;
        return Intent.makeMainActivity(r13);
    L10:
        return new Intent().setComponent(r13);
    }

    @Nullable
    public static String getParentActivityName(@NonNull Activity r10) {
        return getParentActivityName(r10, r10.getComponentName());
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Nullable
    public static String getParentActivityName(@NonNull Context r10, @NonNull ComponentName r11) {
        PackageManager r12 = r10.getPackageManager();
        int r13 = Build.VERSION.SDK_INT;
        int r14 = 640;
        if (r13 < 29) goto L6;
        r14 = 269222528;
    L8:
        ActivityInfo r15 = r12.getActivityInfo(r11, r14);
        if (r13 < 16) goto L13;
        String r16 = r15.parentActivityName;
        if (r16 == null) goto L13;
        return r16;
    L13:
        Bundle r17 = r15.metaData;
        if (r17 != null) goto L16;
        return null;
    L16:
        String r18 = r17.getString(PARENT_ACTIVITY);
        if (r18 != null) goto L20;
        return null;
    L20:
        if (r18.charAt(0) == '.') goto L22;
        return r18;
    L22:
        return r10.getPackageName() + r18;
    L6:
        if (r13 < 24) goto L8;
        r14 = 787072;
        goto L8
    }

    public static void navigateUpFromSameTask(@NonNull Activity r10) {
        Intent r11 = getParentActivityIntent(r10);
        if (r11 == null) goto L7;
        navigateUpTo(r10, r11);
        return;
    L7:
        throw new IllegalArgumentException("Activity " + r10.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(@NonNull Activity r10, @NonNull Intent r11) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.navigateUpTo(r10, r11);
        return;
    L5:
        r11.addFlags(67108864);
        r10.startActivity(r11);
        r10.finish();
    }

    public static boolean shouldUpRecreateTask(@NonNull Activity r10, @NonNull Intent r11) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        String r12 = r10.getIntent().getAction();
        if (r12 != null) goto L9;
    L11:
        return false;
    L9:
        if (r12.equals("android.intent.action.MAIN") == true) goto L11;
        return true;
    L5:
        return Api16Impl.shouldUpRecreateTask(r10, r11);
    }
}
