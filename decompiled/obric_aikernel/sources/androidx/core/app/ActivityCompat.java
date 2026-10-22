package androidx.core.app;

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
import android.os.Handler;
import android.os.Looper;
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
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void finishAffinity(Activity r10) {
            r10.finishAffinity();
        }

        @DoNotInline
        static void startActivityForResult(Activity r10, Intent r11, int r12, Bundle r13) {
            r10.startActivityForResult(r11, r12, r13);
        }

        @DoNotInline
        static void startIntentSenderForResult(Activity r10, IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) {
            r10.startIntentSenderForResult(r11, r12, r13, r14, r15, r16, r17);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void finishAfterTransition(Activity r10) {
            r10.finishAfterTransition();
        }

        @DoNotInline
        static void postponeEnterTransition(Activity r10) {
            r10.postponeEnterTransition();
        }

        @DoNotInline
        static void setEnterSharedElementCallback(Activity r10, android.app.SharedElementCallback r11) {
            r10.setEnterSharedElementCallback(r11);
        }

        @DoNotInline
        static void setExitSharedElementCallback(Activity r10, android.app.SharedElementCallback r11) {
            r10.setExitSharedElementCallback(r11);
        }

        @DoNotInline
        static void startPostponedEnterTransition(Activity r10) {
            r10.startPostponedEnterTransition();
        }
    }

    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static Uri getReferrer(Activity r10) {
            return r10.getReferrer();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void onSharedElementsReady(Object r10) {
            ((android.app.SharedElementCallback.OnSharedElementsReadyListener) r10).onSharedElementsReady();
        }

        @DoNotInline
        static void requestPermissions(Activity r10, String[] r11, int r12) {
            r10.requestPermissions(r11, r12);
        }

        @DoNotInline
        static boolean shouldShowRequestPermissionRationale(Activity r10, String r11) {
            return r10.shouldShowRequestPermissionRationale(r11);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static <T> T requireViewById(Activity r10, int r11) {
            return (T) r10.requireViewById(r11);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static Display getDisplay(ContextWrapper r10) {
            return r10.getDisplay();
        }

        @DoNotInline
        static void setLocusContext(@NonNull Activity r10, @Nullable LocusIdCompat r11, @Nullable Bundle r12) {
            if (r11 != null) goto L4;
            LocusId r13 = null;
        L5:
            r10.setLocusContext(r13, r12);
            return;
        L4:
            r13 = r11.toLocusId();
            goto L5
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean isLaunchedFromBubble(@NonNull Activity r10) {
            return r10.isLaunchedFromBubble();
        }

        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        static boolean shouldShowRequestPermissionRationale(Activity r10, String r11) {
            PackageManager r12 = r10.getApplication().getPackageManager();     // Catch: Throwable -> L4
            return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(r12, new Object[]{r11})).booleanValue();
        L5:
            return r10.shouldShowRequestPermissionRationale(r11);
        }
    }

    @RequiresApi(32)
    static class Api32Impl {
        private Api32Impl() {
        }

        @DoNotInline
        static boolean shouldShowRequestPermissionRationale(Activity r10, String r11) {
            return r10.shouldShowRequestPermissionRationale(r11);
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int r10, @NonNull String[] r11, @NonNull int[] r12);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(@NonNull Activity r10, @IntRange(from = 0) int r11, int r12, @Nullable Intent r13);

        boolean requestPermissions(@NonNull Activity r10, @NonNull String[] r11, @IntRange(from = 0) int r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int r10);
    }

    @RequiresApi(21)
    static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final SharedElementCallback mCallback;

        SharedElementCallback21Impl(SharedElementCallback r10) {
            this.mCallback = r10;
        }

        public static /* synthetic */ void a(android.app.SharedElementCallback.OnSharedElementsReadyListener r10) {
            lambda$onSharedElementsArrived$0(r10);
        }

        private static /* synthetic */ void lambda$onSharedElementsArrived$0(android.app.SharedElementCallback.OnSharedElementsReadyListener r10) {
            Api23Impl.onSharedElementsReady(r10);
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View r10, Matrix r11, RectF r12) {
            return this.mCallback.onCaptureSharedElementSnapshot(r10, r11, r12);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context r10, Parcelable r11) {
            return this.mCallback.onCreateSnapshotView(r10, r11);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> r10, Map<String, View> r11) {
            this.mCallback.onMapSharedElements(r10, r11);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> r10) {
            this.mCallback.onRejectSharedElements(r10);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> r10, List<View> r11, List<View> r12) {
            this.mCallback.onSharedElementEnd(r10, r11, r12);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> r10, List<View> r11, List<View> r12) {
            this.mCallback.onSharedElementStart(r10, r11, r12);
        }

        @Override // android.app.SharedElementCallback
        @RequiresApi(23)
        public void onSharedElementsArrived(List<String> r10, List<View> r11, final android.app.SharedElementCallback.OnSharedElementsReadyListener r12) {
            this.mCallback.onSharedElementsArrived(r10, r11, new b(r12));
        }
    }

    protected ActivityCompat() {
    }

    public static /* synthetic */ void a(Activity r10) {
        lambda$recreate$0(r10);
    }

    public static void finishAffinity(@NonNull Activity r10) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.finishAffinity(r10);
        return;
    L5:
        r10.finish();
    }

    public static void finishAfterTransition(@NonNull Activity r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.finishAfterTransition(r10);
        return;
    L5:
        r10.finish();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    @Nullable
    public static Uri getReferrer(@NonNull Activity r10) {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        Intent r11 = r10.getIntent();
        Uri r12 = (Uri) r11.getParcelableExtra("android.intent.extra.REFERRER");
        if (r12 == null) goto L9;
        return r12;
    L9:
        String r13 = r11.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (r13 != null) goto L12;
        return null;
    L12:
        return Uri.parse(r13);
    L5:
        return Api22Impl.getReferrer(r10);
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity r10) {
        r10.invalidateOptionsMenu();
        return true;
    }

    public static boolean isLaunchedFromBubble(@NonNull Activity r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 31) goto L7;
        return Api31Impl.isLaunchedFromBubble(r10);
    L7:
        if (r11 != 30) goto L16;
        if (Api30Impl.getDisplay(r10) == null) goto L14;
        if (Api30Impl.getDisplay(r10).getDisplayId() == 0) goto L14;
        return true;
    L14:
        return false;
    L16:
        if (r11 == 29) goto L18;
        return false;
    L18:
        if (r10.getWindowManager().getDefaultDisplay() == null) goto L23;
        if (r10.getWindowManager().getDefaultDisplay().getDisplayId() == 0) goto L23;
        return true;
    L23:
        return false;
    }

    private static /* synthetic */ void lambda$recreate$0(Activity r10) {
        if (r10.isFinishing() == false) goto L5;
        return;
    L5:
        if (ActivityRecreator.recreate(r10) == true) goto L9;
        r10.recreate();
        return;
    }

    public static void postponeEnterTransition(@NonNull Activity r10) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.postponeEnterTransition(r10);
        return;
    }

    public static void recreate(@NonNull final Activity r10) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r10.recreate();
        return;
    L5:
        new Handler(r10.getMainLooper()).post(new a(r10));
    }

    @Nullable
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(@NonNull Activity r10, @NonNull DragEvent r11) {
        return DragAndDropPermissionsCompat.request(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static void requestPermissions(@NonNull final Activity r10, @NonNull String[] r11, @IntRange(from = 0) final int r12) {
        PermissionCompatDelegate r13 = sDelegate;
        if (r13 != null) goto L5;
    L7:
        HashSet r14 = new HashSet();
        int r15 = 0;
        int r16 = 0;
    L9:
        if (r16 >= r11.length) goto L20;
        if (TextUtils.isEmpty(r11[r16]) == true) goto L19;
        if (BuildCompat.isAtLeastT() == true) goto L17;
        if (TextUtils.equals(r11[r16], "android.permission.POST_NOTIFICATIONS") == false) goto L17;
        r14.add(Integer.valueOf(r16));
    L17:
        r16 = r16 + 1;
        goto L9
    L19:
        throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(r11) + " must not contain null or empty values");
    L20:
        int r17 = r14.size();
        if (r17 <= 0) goto L23;
        final String[] r18 = new String[r11.length - r17];
    L24:
        if (r17 <= 0) goto L36;
        if (r17 != r11.length) goto L28;
        return;
    L28:
        int r19 = 0;
    L30:
        if (r15 >= r11.length) goto L36;
        if (r14.contains(Integer.valueOf(r15)) == true) goto L34;
        r18[r19] = r11[r15];
        r19 = r19 + 1;
    L34:
        r15 = r15 + 1;
    L36:
        if (Build.VERSION.SDK_INT < 23) goto L42;
        if ((r10 instanceof RequestPermissionsRequestCodeValidator) == false) goto L40;
        ((RequestPermissionsRequestCodeValidator) r10).validateRequestPermissionsRequestCode(r12);
    L40:
        Api23Impl.requestPermissions(r10, r11, r12);
        return;
    L42:
        if ((r10 instanceof OnRequestPermissionsResultCallback) == false) goto L54;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r18, r10, r12));
        return;
    L54:
        return;
    L23:
        r18 = r11;
        goto L24
    L5:
        if (r13.requestPermissions(r10, r11, r12) == false) goto L7;
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Activity r10, @IdRes int r11) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r12 = (T) r10.findViewById(r11);
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    L5:
        return (T) Api28Impl.requireViewById(r10, r11);
    }

    public static void setEnterSharedElementCallback(@NonNull Activity r10, @Nullable SharedElementCallback r11) {
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (r11 == null) goto L6;
        SharedElementCallback21Impl r12 = new SharedElementCallback21Impl(r11);
    L7:
        Api21Impl.setEnterSharedElementCallback(r10, r12);
        return;
    L6:
        r12 = null;
        goto L7
    }

    public static void setExitSharedElementCallback(@NonNull Activity r10, @Nullable SharedElementCallback r11) {
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (r11 == null) goto L6;
        SharedElementCallback21Impl r12 = new SharedElementCallback21Impl(r11);
    L7:
        Api21Impl.setExitSharedElementCallback(r10, r12);
        return;
    L6:
        r12 = null;
        goto L7
    }

    public static void setLocusContext(@NonNull Activity r10, @Nullable LocusIdCompat r11, @Nullable Bundle r12) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setLocusContext(r10, r11, r12);
        return;
    }

    public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate r10) {
        sDelegate = r10;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity r10, @NonNull String r11) {
        if (BuildCompat.isAtLeastT() == false) goto L5;
    L7:
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 32) goto L12;
        return Api32Impl.shouldShowRequestPermissionRationale(r10, r11);
    L12:
        if (r12 != 31) goto L16;
        return Api31Impl.shouldShowRequestPermissionRationale(r10, r11);
    L16:
        if (r12 >= 23) goto L18;
        return false;
    L18:
        return Api23Impl.shouldShowRequestPermissionRationale(r10, r11);
    L5:
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r11) == false) goto L7;
        return false;
    }

    public static void startActivityForResult(@NonNull Activity r10, @NonNull Intent r11, int r12, @Nullable Bundle r13) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startActivityForResult(r10, r11, r12, r13);
        return;
    L5:
        r10.startActivityForResult(r11, r12);
    }

    public static void startIntentSenderForResult(@NonNull Activity r10, @NonNull IntentSender r11, int r12, @Nullable Intent r13, int r14, int r15, int r16, @Nullable Bundle r17) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startIntentSenderForResult(r10, r11, r12, r13, r14, r15, r16, r17);
        return;
    L5:
        r10.startIntentSenderForResult(r11, r12, r13, r14, r15, r16);
    }

    public static void startPostponedEnterTransition(@NonNull Activity r10) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.startPostponedEnterTransition(r10);
        return;
    }
}
