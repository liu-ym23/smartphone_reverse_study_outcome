package com.bytedance.bdlocation.permission.request;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.a;
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

    public static /* synthetic */ boolean access$000(int[] r8) {
        return verifyPermissions(r8);
    }

    private static List<String> getDeniedPermissions(Context r8, String... r10) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        String r14 = r10[r13];
        if (a.a(r8, r14) != (-1)) goto L10;
        r11.add(r14);
    L10:
        r13 = r13 + 1;
        goto L6
    L11:
        return r11;
    }

    public static void requestPermissionsLimited(Activity r8, String[] r10, final OnPermissionListener r11) {
        if (r8 == null) goto L11;
        List<String> r12 = getDeniedPermissions(r8, r10);
        if (r12 != null) goto L6;
    L8:
        if (r11 == null) goto L13;
        r11.onPermissionGranted();
        return;
    L13:
        return;
    L6:
        if (r12.isEmpty() == true) goto L8;
        Permissions.requestPermissions(r8, r10, new AnonymousClass1(r11));
        return;
    }

    private static boolean verifyPermissions(int[] r8) {
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (r8[r11] != 0) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }
}
