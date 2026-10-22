package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    public static /* synthetic */ void a(Activity r0) {
        lambda$recreate$0(r0);
    }

    public ActivityCompat() {
    }

    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    public static void finishAffinity(Activity r0) {
        r0.finishAffinity();
    }

    public static void finishAfterTransition(Activity r0) {
        Api21Impl.finishAfterTransition(r0);
    }

    public static Uri getReferrer(Activity r2) {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        Intent r3 = r2.getIntent();
        Uri r0 = (Uri) r3.getParcelableExtra("android.intent.extra.REFERRER");
        if (r0 == null) goto L9;
        return r0;
    L9:
        String r4 = r3.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (r4 != null) goto L12;
        return null;
    L12:
        return UriProtector.parse(r4);
    L5:
        return Api22Impl.getReferrer(r2);
    }

    public static boolean invalidateOptionsMenu(Activity r0) {
        r0.invalidateOptionsMenu();
        return true;
    }

    public static boolean isLaunchedFromBubble(Activity r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L7;
        return Api31Impl.isLaunchedFromBubble(r4);
    L7:
        if (r0 != 30) goto L16;
        if (Api30Impl.getDisplay(r4) != null) goto L11;
    L13:
        return false;
    L11:
        if (Api30Impl.getDisplay(r4).getDisplayId() == 0) goto L13;
        return true;
    L16:
        if (r0 == 29) goto L18;
        return false;
    L18:
        if (r4.getWindowManager().getDefaultDisplay() != null) goto L20;
    L22:
        return false;
    L20:
        if (r4.getWindowManager().getDefaultDisplay().getDisplayId() == 0) goto L22;
        return true;
    }

    private static /* synthetic */ void lambda$recreate$0(Activity r1) {
        if (r1.isFinishing() == false) goto L5;
        return;
    L5:
        if (ActivityRecreator.recreate(r1) == true) goto L9;
        r1.recreate();
        return;
    }

    public static void postponeEnterTransition(Activity r0) {
        Api21Impl.postponeEnterTransition(r0);
    }

    public static void recreate(Activity r2) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r2.recreate();
        return;
    L5:
        new Handler(r2.getMainLooper()).post(new a(r2));
    }

    public static void setPermissionCompatDelegate(PermissionCompatDelegate r0) {
        sDelegate = r0;
    }

    public static void startPostponedEnterTransition(Activity r0) {
        Api21Impl.startPostponedEnterTransition(r0);
    }

    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity r0, DragEvent r1) {
        return DragAndDropPermissionsCompat.request(r0, r1);
    }

    public static <T extends View> T requireViewById(Activity r2, int r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r4 = (T) r2.findViewById(r3);
        if (r4 == null) goto L10;
        return r4;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    L5:
        return (T) Api28Impl.requireViewById(r2, r3);
    }

    public static void setEnterSharedElementCallback(Activity r1, SharedElementCallback r2) {
        if (r2 == null) goto L4;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r2);
    L5:
        Api21Impl.setEnterSharedElementCallback(r1, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static void setExitSharedElementCallback(Activity r1, SharedElementCallback r2) {
        if (r2 == null) goto L4;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r2);
    L5:
        Api21Impl.setExitSharedElementCallback(r1, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static boolean shouldShowRequestPermissionRationale(Activity r3, String r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 33) goto L8;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r4) == false) goto L8;
        return false;
    L8:
        if (r0 < 32) goto L12;
        return Api32Impl.shouldShowRequestPermissionRationale(r3, r4);
    L12:
        if (r0 != 31) goto L16;
        return Api31Impl.shouldShowRequestPermissionRationale(r3, r4);
    L16:
        if (r0 >= 23) goto L18;
        return false;
    L18:
        return Api23Impl.shouldShowRequestPermissionRationale(r3, r4);
    }

    public static void requestPermissions(Activity r6, String[] r7, int r8) {
        PermissionCompatDelegate r0 = sDelegate;
        if (r0 != null) goto L5;
    L7:
        HashSet r1 = new HashSet();
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r3 >= r7.length) goto L20;
        if (TextUtils.isEmpty(r7[r3]) == true) goto L19;
        if (Build.VERSION.SDK_INT >= 33) goto L17;
        if (TextUtils.equals(r7[r3], "android.permission.POST_NOTIFICATIONS") == false) goto L17;
        r1.add(Integer.valueOf(r3));
    L17:
        r3 = r3 + 1;
        goto L9
    L19:
        throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(r7) + " must not contain null or empty values");
    L20:
        int r4 = r1.size();
        if (r4 <= 0) goto L23;
        String[] r5 = new String[r7.length - r4];
    L24:
        if (r4 <= 0) goto L36;
        if (r4 != r7.length) goto L28;
        return;
    L28:
        int r9 = 0;
    L30:
        if (r2 >= r7.length) goto L36;
        if (r1.contains(Integer.valueOf(r2)) == true) goto L34;
        r5[r9] = r7[r2];
        r9 = r9 + 1;
    L34:
        r2 = r2 + 1;
    L36:
        if (Build.VERSION.SDK_INT < 23) goto L42;
        if ((r6 instanceof RequestPermissionsRequestCodeValidator) == false) goto L40;
        ((RequestPermissionsRequestCodeValidator) r6).validateRequestPermissionsRequestCode(r8);
    L40:
        Api23Impl.requestPermissions(r6, r7, r8);
        return;
    L42:
        if ((r6 instanceof OnRequestPermissionsResultCallback) == false) goto L54;
        new Handler(Looper.getMainLooper()).post(new 1(r5, r6, r8));
        return;
    L54:
        return;
    L23:
        r5 = r7;
        goto L24
    L5:
        if (r0.requestPermissions(r6, r7, r8) == false) goto L7;
    }

    public static void setLocusContext(Activity r2, LocusIdCompat r3, Bundle r4) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setLocusContext(r2, r3, r4);
        return;
    }

    public static void startActivityForResult(Activity r0, Intent r1, int r2, Bundle r3) {
        r0.startActivityForResult(r1, r2, r3);
    }

    public static void startIntentSenderForResult(Activity r0, IntentSender r1, int r2, Intent r3, int r4, int r5, int r6, Bundle r7) throws IntentSender.SendIntentException {
        r0.startIntentSenderForResult(r1, r2, r3, r4, r5, r6, r7);
    }
}
