package androidx.core.app;

import ai.j0;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    /* JADX INFO: renamed from: androidx.core.app.ActivityCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ String[] val$permissionsArray;
        final /* synthetic */ int val$requestCode;

        public AnonymousClass1(String[] r5, Activity r10, int r11) {
            this.val$permissionsArray = r5;
            this.val$activity = r10;
            this.val$requestCode = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] r5 = new int[this.val$permissionsArray.length];
            PackageManager r10 = this.val$activity.getPackageManager();
            String r11 = this.val$activity.getPackageName();
            int r12 = this.val$permissionsArray.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r5[r13] = r10.checkPermission(this.val$permissionsArray[r13], r11);
            r13 = r13 + 1;
            goto L3
        L5:
            ((OnRequestPermissionsResultCallback) this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissionsArray, r5);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void finishAfterTransition(Activity r5) {
            r5.finishAfterTransition();
        }

        @DoNotInline
        public static void postponeEnterTransition(Activity r5) {
            r5.postponeEnterTransition();
        }

        @DoNotInline
        public static void setEnterSharedElementCallback(Activity r5, android.app.SharedElementCallback r10) {
            r5.setEnterSharedElementCallback(r10);
        }

        @DoNotInline
        public static void setExitSharedElementCallback(Activity r5, android.app.SharedElementCallback r10) {
            r5.setExitSharedElementCallback(r10);
        }

        @DoNotInline
        public static void startPostponedEnterTransition(Activity r5) {
            r5.startPostponedEnterTransition();
        }
    }

    @RequiresApi(22)
    public static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        public static Uri getReferrer(Activity r5) {
            return r5.getReferrer();
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void onSharedElementsReady(Object r5) {
            ((android.app.SharedElementCallback.OnSharedElementsReadyListener) r5).onSharedElementsReady();
        }

        @DoNotInline
        public static void requestPermissions(Activity r5, String[] r10, int r11) {
            r5.requestPermissions(r10, r11);
        }

        @DoNotInline
        public static boolean shouldShowRequestPermissionRationale(Activity r5, String r10) {
            return r5.shouldShowRequestPermissionRationale(r10);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static <T> T requireViewById(Activity r5, int r10) {
            return (T) r5.requireViewById(r10);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static Display getDisplay(ContextWrapper r5) {
            return r5.getDisplay();
        }

        @DoNotInline
        public static void setLocusContext(@NonNull Activity r5, @Nullable LocusIdCompat r10, @Nullable Bundle r11) {
            if (r10 != null) goto L4;
            LocusId r12 = null;
        L5:
            r5.setLocusContext(r12, r11);
            return;
        L4:
            r12 = r10.toLocusId();
            goto L5
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static boolean isLaunchedFromBubble(@NonNull Activity r5) {
            return r5.isLaunchedFromBubble();
        }

        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        public static boolean shouldShowRequestPermissionRationale(Activity r5, String r10) {
            PackageManager r11 = r5.getApplication().getPackageManager();     // Catch: Throwable -> L4
            return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(r11, new Object[]{r10})).booleanValue();
        L5:
            return r5.shouldShowRequestPermissionRationale(r10);
        }
    }

    @RequiresApi(32)
    public static class Api32Impl {
        private Api32Impl() {
        }

        @DoNotInline
        public static boolean shouldShowRequestPermissionRationale(Activity r5, String r10) {
            return r5.shouldShowRequestPermissionRationale(r10);
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int r5, @NonNull String[] r10, @NonNull int[] r11);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(@NonNull Activity r5, @IntRange(from = 0) int r10, int r11, @Nullable Intent r12);

        boolean requestPermissions(@NonNull Activity r5, @NonNull String[] r10, @IntRange(from = 0) int r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int r5);
    }

    @RequiresApi(21)
    public static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final SharedElementCallback mCallback;

        public SharedElementCallback21Impl(SharedElementCallback r5) {
            this.mCallback = r5;
        }

        public static /* synthetic */ void a(android.app.SharedElementCallback.OnSharedElementsReadyListener r5) {
            lambda$onSharedElementsArrived$0(r5);
        }

        private static /* synthetic */ void lambda$onSharedElementsArrived$0(android.app.SharedElementCallback.OnSharedElementsReadyListener r5) {
            Api23Impl.onSharedElementsReady(r5);
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View r5, Matrix r10, RectF r11) {
            return this.mCallback.onCaptureSharedElementSnapshot(r5, r10, r11);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context r5, Parcelable r10) {
            return this.mCallback.onCreateSnapshotView(r5, r10);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> r5, Map<String, View> r10) {
            this.mCallback.onMapSharedElements(r5, r10);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> r5) {
            this.mCallback.onRejectSharedElements(r5);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> r5, List<View> r10, List<View> r11) {
            this.mCallback.onSharedElementEnd(r5, r10, r11);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> r5, List<View> r10, List<View> r11) {
            this.mCallback.onSharedElementStart(r5, r10, r11);
        }

        @Override // android.app.SharedElementCallback
        @RequiresApi(23)
        public void onSharedElementsArrived(List<String> r5, List<View> r10, final android.app.SharedElementCallback.OnSharedElementsReadyListener r11) {
            this.mCallback.onSharedElementsArrived(r5, r10, new a(r11));
        }
    }

    public ActivityCompat() {
    }

    public static void finishAffinity(@NonNull Activity r5) {
        r5.finishAffinity();
    }

    public static void finishAfterTransition(@NonNull Activity r5) {
        Api21Impl.finishAfterTransition(r5);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    @Nullable
    public static Uri getReferrer(@NonNull Activity r5) {
        return Api22Impl.getReferrer(r5);
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity r5) {
        r5.invalidateOptionsMenu();
        return true;
    }

    public static boolean isLaunchedFromBubble(@NonNull Activity r5) {
        return Api31Impl.isLaunchedFromBubble(r5);
    }

    private static /* synthetic */ void lambda$recreate$0(Activity r5) {
        if (r5.isFinishing() == false) goto L5;
        return;
    L5:
        if (ActivityRecreator.recreate(r5) == true) goto L9;
        r5.recreate();
        return;
    }

    public static void postponeEnterTransition(@NonNull Activity r5) {
        Api21Impl.postponeEnterTransition(r5);
    }

    public static void recreate(@NonNull Activity r5) {
        r5.recreate();
    }

    @Nullable
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(@NonNull Activity r5, @NonNull DragEvent r10) {
        return DragAndDropPermissionsCompat.request(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(@NonNull Activity r10, @NonNull String[] r11, @IntRange(from = 0) int r12) {
        PermissionCompatDelegate r5 = sDelegate;
        if (r5 != null) goto L5;
    L7:
        HashSet r13 = new HashSet();
        int r14 = 0;
        int r15 = 0;
    L9:
        if (r15 >= r11.length) goto L20;
        if (TextUtils.isEmpty(r11[r15]) == true) goto L19;
        if (Build.VERSION.SDK_INT >= 33) goto L17;
        if (TextUtils.equals(r11[r15], "android.permission.POST_NOTIFICATIONS") == false) goto L17;
        r13.add(Integer.valueOf(r15));
    L17:
        r15 = r15 + 1;
        goto L9
    L19:
        throw new IllegalArgumentException(j0.q(new StringBuilder("Permission request for permissions "), Arrays.toString(r11), " must not contain null or empty values"));
    L20:
        int r16 = r13.size();
        if (r16 <= 0) goto L23;
        String[] r17 = new String[r11.length - r16];
    L24:
        if (r16 <= 0) goto L36;
        if (r16 != r11.length) goto L28;
        return;
    L28:
        int r18 = 0;
    L30:
        if (r14 >= r11.length) goto L36;
        if (r13.contains(Integer.valueOf(r14)) == true) goto L34;
        r17[r18] = r11[r14];
        r18 = r18 + 1;
    L34:
        r14 = r14 + 1;
    L36:
        if ((r10 instanceof RequestPermissionsRequestCodeValidator) == false) goto L38;
        ((RequestPermissionsRequestCodeValidator) r10).validateRequestPermissionsRequestCode(r12);
    L38:
        Api23Impl.requestPermissions(r10, r11, r12);
        return;
    L23:
        r17 = r11;
        goto L24
    L5:
        if (r5.requestPermissions(r10, r11, r12) == false) goto L7;
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Activity r5, @IdRes int r10) {
        return (T) Api28Impl.requireViewById(r5, r10);
    }

    public static void setEnterSharedElementCallback(@NonNull Activity r5, @Nullable SharedElementCallback r10) {
        if (r10 == null) goto L4;
        SharedElementCallback21Impl r11 = new SharedElementCallback21Impl(r10);
    L5:
        Api21Impl.setEnterSharedElementCallback(r5, r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public static void setExitSharedElementCallback(@NonNull Activity r5, @Nullable SharedElementCallback r10) {
        if (r10 == null) goto L4;
        SharedElementCallback21Impl r11 = new SharedElementCallback21Impl(r10);
    L5:
        Api21Impl.setExitSharedElementCallback(r5, r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public static void setLocusContext(@NonNull Activity r5, @Nullable LocusIdCompat r10, @Nullable Bundle r11) {
        Api30Impl.setLocusContext(r5, r10, r11);
    }

    public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate r5) {
        sDelegate = r5;
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity r5, @NonNull String r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 >= 33) goto L9;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r10) == false) goto L9;
        return false;
    L9:
        if (r11 < 32) goto L13;
        return Api32Impl.shouldShowRequestPermissionRationale(r5, r10);
    L13:
        if (r11 != 31) goto L17;
        return Api31Impl.shouldShowRequestPermissionRationale(r5, r10);
    L17:
        return Api23Impl.shouldShowRequestPermissionRationale(r5, r10);
    }

    public static void startActivityForResult(@NonNull Activity r5, @NonNull Intent r10, int r11, @Nullable Bundle r12) {
        r5.startActivityForResult(r10, r11, r12);
    }

    public static void startIntentSenderForResult(@NonNull Activity r5, @NonNull IntentSender r10, int r11, @Nullable Intent r12, int r13, int r14, int r15, @Nullable Bundle r16) throws IntentSender.SendIntentException {
        r5.startIntentSenderForResult(r10, r11, r12, r13, r14, r15, r16);
    }

    public static void startPostponedEnterTransition(@NonNull Activity r5) {
        Api21Impl.startPostponedEnterTransition(r5);
    }
}
