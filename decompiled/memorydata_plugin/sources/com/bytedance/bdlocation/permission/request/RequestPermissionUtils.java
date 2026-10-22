package com.bytedance.bdlocation.permission.request;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RequestPermissionUtils {

    public interface OnPermissionListener {
        void onPermissionDenied();

        void onPermissionGranted();
    }

    public RequestPermissionUtils() {
    }

    static /* synthetic */ boolean access$000(int[] r0) {
        return verifyPermissions(r0);
    }

    private static List<String> getDeniedPermissions(Context r6, String... r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        int r1 = r7.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        String r3 = r7[r2];
        if (ContextCompat.checkSelfPermission(r8, r3) != (-1)) goto L11;
        r0.add(r3);
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        return r0;
    }

    public static void requestPermissionsLimited(Activity r2, String[] r3, OnPermissionListener r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        final OnPermissionListener r6 = (OnPermissionListener) ZeusTransformUtils.wrapperContextForParams(r4, OnPermissionListener.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L12;
        List<String> r0 = getDeniedPermissions(r5, r3);
        if (r0 != null) goto L7;
    L9:
        if (r6 == null) goto L14;
        r6.onPermissionGranted();
        return;
    L14:
        return;
    L7:
        if (r0.isEmpty() == true) goto L9;
        Permissions.requestPermissions(r5, r3, new AnonymousClass1(r6));
        return;
    }

    private static boolean verifyPermissions(int[] r4) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r4[r2] != 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }
}
