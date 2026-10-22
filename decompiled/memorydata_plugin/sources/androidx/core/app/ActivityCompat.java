package androidx.core.app;

import android.app.Activity;
import android.app.Application;
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
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    static class Api16Impl {
        private Api16Impl() {
        }

        static void finishAffinity(Activity r2) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).finishAffinity();
        }

        static void startActivityForResult(Activity r2, Intent r3, int r4, Bundle r5) {
            ZeusTransformUtils.startActivityForResult((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), r3, r4, r5, "com.obric.memorydata.plugin");
        }

        static void startIntentSenderForResult(Activity r8, IntentSender r9, int r10, Intent r11, int r12, int r13, int r14, Bundle r15) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin")).startIntentSenderForResult(r9, r10, r11, r12, r13, r14, r15);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void finishAfterTransition(Activity r2) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).finishAfterTransition();
        }

        static void postponeEnterTransition(Activity r2) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).postponeEnterTransition();
        }

        static void setEnterSharedElementCallback(Activity r2, android.app.SharedElementCallback r3) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).setEnterSharedElementCallback(r3);
        }

        static void setExitSharedElementCallback(Activity r2, android.app.SharedElementCallback r3) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).setExitSharedElementCallback(r3);
        }

        static void startPostponedEnterTransition(Activity r2) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).startPostponedEnterTransition();
        }
    }

    static class Api22Impl {
        private Api22Impl() {
        }

        static Uri getReferrer(Activity r2) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).getReferrer();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static void onSharedElementsReady(Object r2) {
            ((android.app.SharedElementCallback.OnSharedElementsReadyListener) ZeusTransformUtils.preCheckCast(r2, android.app.SharedElementCallback.OnSharedElementsReadyListener.class, "com.obric.memorydata.plugin")).onSharedElementsReady();
        }

        static void requestPermissions(Activity r2, String[] r3, int r4) {
            ZeusTransformUtils.requestPermissions((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), r3, r4, "com.obric.memorydata.plugin");
        }

        static boolean shouldShowRequestPermissionRationale(Activity r2, String r3) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).shouldShowRequestPermissionRationale(r3);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static <T> T requireViewById(Activity r2, int r3) {
            return (T) ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).requireViewById(r3);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Display getDisplay(ContextWrapper r2) {
            return ((ContextWrapper) ZeusTransformUtils.wrapperContextForParams(r2, ContextWrapper.class, "com.obric.memorydata.plugin")).getDisplay();
        }

        static void setLocusContext(Activity r2, LocusIdCompat r3, Bundle r4) {
            Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L5;
            LocusId r6 = null;
        L6:
            r5.setLocusContext(r6, r4);
            return;
        L5:
            r6 = r3.toLocusId();
            goto L6
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static boolean isLaunchedFromBubble(Activity r2) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).isLaunchedFromBubble();
        }

        static boolean shouldShowRequestPermissionRationale(Activity r8, String r9) {
            Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
            PackageManager r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageManager();     // Catch: Throwable -> L5
            return ((Boolean) ZeusTransformUtils.preCheckCast(PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(r0, new Object[]{r9}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        L6:
            return r10.shouldShowRequestPermissionRationale(r9);
        }
    }

    static class Api32Impl {
        private Api32Impl() {
        }

        static boolean shouldShowRequestPermissionRationale(Activity r2, String r3) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).shouldShowRequestPermissionRationale(r3);
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int r1, String[] r2, int[] r3);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(Activity r1, int r2, int r3, Intent r4);

        boolean requestPermissions(Activity r1, String[] r2, int r3);
    }

    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int r1);
    }

    static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final SharedElementCallback mCallback;

        SharedElementCallback21Impl(SharedElementCallback r1) {
            this.mCallback = r1;
        }

        static /* synthetic */ void lambda$onSharedElementsArrived$0(android.app.SharedElementCallback.OnSharedElementsReadyListener r2) {
            Api23Impl.onSharedElementsReady((android.app.SharedElementCallback.OnSharedElementsReadyListener) ZeusTransformUtils.wrapperContextForParams(r2, android.app.SharedElementCallback.OnSharedElementsReadyListener.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View r1, Matrix r2, RectF r3) {
            return this.mCallback.onCaptureSharedElementSnapshot(r1, r2, r3);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context r3, Parcelable r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.memorydata.plugin");
            return this.mCallback.onCreateSnapshotView(r5, r6);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> r3, Map<String, View> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Map<String, View> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            this.mCallback.onMapSharedElements(r5, r6);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> r3) {
            List<View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            this.mCallback.onRejectSharedElements(r4);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> r3, List<View> r4, List<View> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List<View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            this.mCallback.onSharedElementEnd(r6, r7, r8);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> r3, List<View> r4, List<View> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List<View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            this.mCallback.onSharedElementStart(r6, r7, r8);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List<String> r3, List<View> r4, android.app.SharedElementCallback.OnSharedElementsReadyListener r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            final android.app.SharedElementCallback.OnSharedElementsReadyListener r8 = (android.app.SharedElementCallback.OnSharedElementsReadyListener) ZeusTransformUtils.wrapperContextForParams(r5, android.app.SharedElementCallback.OnSharedElementsReadyListener.class, "com.obric.memorydata.plugin");
            this.mCallback.onSharedElementsArrived(r6, r7, new $$Lambda$ActivityCompat$SharedElementCallback21Impl$kn1YM_uTx1fSsWel_fA7Io4GQIA(r8));
        }
    }

    public ActivityCompat() {
    }

    public static void finishAffinity(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.finishAffinity(r3);
        return;
    L5:
        r3.finish();
    }

    public static void finishAfterTransition(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.finishAfterTransition(r3);
        return;
    L5:
        r3.finish();
    }

    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    public static Uri getReferrer(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        Intent r5 = r4.getIntent();
        Uri r0 = (Uri) ZeusTransformUtils.preCheckCast(r5.getParcelableExtra("android.intent.extra.REFERRER"), Uri.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        return r0;
    L9:
        String r6 = r5.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (r6 != null) goto L12;
        return null;
    L12:
        return Uri.parse(r6);
    L5:
        return Api22Impl.getReferrer(r4);
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity r2) {
        ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).invalidateOptionsMenu();
        return true;
    }

    public static boolean isLaunchedFromBubble(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.isLaunchedFromBubble(r5);
    L7:
        if (Build.VERSION.SDK_INT != 30) goto L16;
        if (Api30Impl.getDisplay(r5) == null) goto L14;
        if (Api30Impl.getDisplay(r5).getDisplayId() == 0) goto L14;
        return true;
    L14:
        return false;
    L16:
        if (Build.VERSION.SDK_INT == 29) goto L18;
        return false;
    L18:
        if (r5.getWindowManager().getDefaultDisplay() == null) goto L23;
        if (r5.getWindowManager().getDefaultDisplay().getDisplayId() == 0) goto L23;
        return true;
    L23:
        return false;
    }

    static /* synthetic */ void lambda$recreate$0(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (r3.isFinishing() == false) goto L5;
        return;
    L5:
        if (ActivityRecreator.recreate(r3) == true) goto L9;
        r3.recreate();
        return;
    }

    public static void postponeEnterTransition(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.postponeEnterTransition(r3);
        return;
    }

    public static void recreate(Activity r2) {
        final Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r3.recreate();
        return;
    L5:
        new Handler(r3.getMainLooper()).post(new $$Lambda$ActivityCompat$gwIVdSe1wJYEvrkKzQghxQatlNg(r3));
    }

    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity r2, DragEvent r3) {
        return DragAndDropPermissionsCompat.request((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), r3);
    }

    public static void requestPermissions(Activity r7, String[] r8, final int r9) {
        final Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r7, Activity.class, "com.obric.memorydata.plugin");
        PermissionCompatDelegate r0 = sDelegate;
        if (r0 != null) goto L5;
    L7:
        HashSet r1 = new HashSet();
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r3 >= r8.length) goto L20;
        if (TextUtils.isEmpty(r8[r3]) == true) goto L19;
        if (Build.VERSION.SDK_INT >= 33) goto L17;
        if (TextUtils.equals(r8[r3], "android.permission.POST_NOTIFICATIONS") == false) goto L17;
        r1.add(Integer.valueOf(r3));
    L17:
        r3 = r3 + 1;
        goto L9
    L19:
        throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(r8) + " must not contain null or empty values");
    L20:
        int r4 = r1.size();
        if (r4 <= 0) goto L23;
        final String[] r5 = new String[r8.length - r4];
    L24:
        if (r4 <= 0) goto L36;
        if (r4 != r8.length) goto L28;
        return;
    L28:
        int r6 = 0;
    L30:
        if (r2 >= r8.length) goto L36;
        if (r1.contains(Integer.valueOf(r2)) == true) goto L34;
        r5[r6] = r8[r2];
        r6 = r6 + 1;
    L34:
        r2 = r2 + 1;
    L36:
        if (Build.VERSION.SDK_INT < 23) goto L42;
        if (ZeusTransformUtils.instanceOf(r10, RequestPermissionsRequestCodeValidator.class) == false) goto L40;
        ((RequestPermissionsRequestCodeValidator) ZeusTransformUtils.preCheckCast(r10, RequestPermissionsRequestCodeValidator.class, "com.obric.memorydata.plugin")).validateRequestPermissionsRequestCode(r9);
    L40:
        Api23Impl.requestPermissions(r10, r8, r9);
        return;
    L42:
        if (ZeusTransformUtils.instanceOf(r10, OnRequestPermissionsResultCallback.class) == false) goto L54;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r5, r10, r9));
        return;
    L54:
        return;
    L23:
        r5 = r8;
        goto L24
    L5:
        if (r0.requestPermissions(r10, r8, r9) == false) goto L7;
    }

    public static <T extends View> T requireViewById(Activity r3, int r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r6 = (T) r5.findViewById(r4);
        if (r6 == null) goto L10;
        return r6;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    L5:
        return (T) ZeusTransformUtils.preCheckCast(Api28Impl.requireViewById(r5, r4), View.class, "com.obric.memorydata.plugin");
    }

    public static void setEnterSharedElementCallback(Activity r2, SharedElementCallback r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (r3 == null) goto L6;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r3);
    L7:
        Api21Impl.setEnterSharedElementCallback(r4, r0);
        return;
    L6:
        r0 = null;
        goto L7
    }

    public static void setExitSharedElementCallback(Activity r2, SharedElementCallback r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (r3 == null) goto L6;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r3);
    L7:
        Api21Impl.setExitSharedElementCallback(r4, r0);
        return;
    L6:
        r0 = null;
        goto L7
    }

    public static void setLocusContext(Activity r2, LocusIdCompat r3, Bundle r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setLocusContext(r5, r3, r4);
        return;
    }

    public static void setPermissionCompatDelegate(PermissionCompatDelegate r2) {
        sDelegate = (PermissionCompatDelegate) ZeusTransformUtils.wrapperContextForParams(r2, PermissionCompatDelegate.class, "com.obric.memorydata.plugin");
    }

    public static boolean shouldShowRequestPermissionRationale(Activity r3, String r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 33) goto L8;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r4) == false) goto L8;
        return false;
    L8:
        if (Build.VERSION.SDK_INT < 32) goto L12;
        return Api32Impl.shouldShowRequestPermissionRationale(r5, r4);
    L12:
        if (Build.VERSION.SDK_INT != 31) goto L16;
        return Api31Impl.shouldShowRequestPermissionRationale(r5, r4);
    L16:
        if (Build.VERSION.SDK_INT >= 23) goto L18;
        return false;
    L18:
        return Api23Impl.shouldShowRequestPermissionRationale(r5, r4);
    }

    public static void startActivityForResult(Activity r3, Intent r4, int r5, Bundle r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startActivityForResult(r7, r4, r5, r6);
        return;
    L5:
        ZeusTransformUtils.startActivityForResult(r7, r4, r5, "com.obric.memorydata.plugin");
    }

    public static void startIntentSenderForResult(Activity r8, IntentSender r9, int r10, Intent r11, int r12, int r13, int r14, Bundle r15) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startIntentSenderForResult(r0, r9, r10, r11, r12, r13, r14, r15);
        return;
    L5:
        r0.startIntentSenderForResult(r9, r10, r11, r12, r13, r14);
    }

    public static void startPostponedEnterTransition(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.startPostponedEnterTransition(r3);
        return;
    }
}
