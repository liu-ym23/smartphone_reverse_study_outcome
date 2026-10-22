package com.ss.android.lark.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.bytedance.supervisor.token.Token;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class StoragePermissionUtils {

    public @interface PartialPermissionState {
    }

    public @interface StoragePermissions {
    }

    public interface a {
        void b(c r1);
    }

    public static class b {
        public final boolean a;
        public final String[] b;

        public b(String[] r1) {
            this.b = r1;
            if (r1.length != 0) goto L5;
            boolean r2 = true;
        L6:
            this.a = r2;
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    public static class c {
        public final int a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final Map<String, Boolean> e;

        public final String toString() {
            StringBuilder r0 = new StringBuilder("StoragePermissionState { image: ");
            int r1 = this.a;
            String r2 = "NO_PERMISSION";
            if (r1 != 0) goto L5;
            String r3 = "FULL_PERMISSION";
        L10:
            r0.append(r3);
            r0.append(", video: ");
            int r4 = this.b;
            if (r4 != 0) goto L13;
            r2 = "FULL_PERMISSION";
        L18:
            r0.append(r2);
            r0.append(", audio: ");
            r0.append(this.c);
            r0.append(", writeMedia: ");
            r0.append(this.d);
            r0.append(" }");
            return r0.toString();
        L13:
            if (r4 != 1) goto L15;
            r2 = "PARTIAL_PERMISSION";
            goto L18
        L15:
            if (r4 == 2) goto L18;
            r2 = "UNKNOWN";
            goto L18
        L5:
            if (r1 != 1) goto L7;
            r3 = "PARTIAL_PERMISSION";
            goto L10
        L7:
            if (r1 != 2) goto L9;
            r3 = "NO_PERMISSION";
            goto L10
        L9:
            r3 = "UNKNOWN";
            goto L10
        }

        public c(Context r6, String... r7) {
            this.e = new HashMap();
            this.a = StoragePermissionUtils.a(r6, StoragePermissionUtils.d(r6, 2));
            this.b = StoragePermissionUtils.a(r6, StoragePermissionUtils.d(r6, 4));
            this.c = StoragePermissionUtils.d(r6, 8);
            this.d = StoragePermissionUtils.e(r6);
            int r0 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            String r2 = r7[r1];
            Map<String, Boolean> r3 = this.e;
            HashMap r4 = (HashMap) r3;
            r4.put(r2, Boolean.valueOf(com.ss.android.lark.permission.a.a(r6, r2)));
            r1 = r1 + 1;
            goto L3
        }
    }

    public static boolean b() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L6;
        return true;
    L6:
        if (r0 >= 29) goto L15;
    L13:
        return false;
    L15:
        if (Environment.isExternalStorageLegacy() == true) goto L13;
        return true;
    L11:
        if (Build.VERSION.SDK_INT < 30) goto L13;
        return true;
    }

    public static boolean e(Context r1) {
        return d(r1, 16);
    }

    public static int a(Context r0, boolean r1) {
        if (r1 == false) goto L5;
        return 0;
    L5:
        if (com.ss.android.lark.permission.a.a(r0, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L7;
        return 1;
    L7:
        return 2;
    }

    public static boolean d(Context r5, int r6) {
        b r7 = c(r5, r6, new String[0]);
        if (r7.a == false) goto L5;
    L4:
        return true;
    L5:
        String[] r8 = r7.b;
        int r1 = r8.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L4;
        if (com.ss.android.lark.permission.a.a(r5, r8[r3]) == false) goto L14;
        r3 = r3 + 1;
        goto L6
    L14:
        return false;
    }

    public static b c(Context r8, int r9, String... r10) {
        boolean r0 = b();
        boolean r2 = true;
        if ((r9 & 32) == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L66;
    L18:
        boolean r3 = false;
    L20:
        if (Build.VERSION.SDK_INT >= 33) goto L22;
    L24:
        boolean r11 = false;
    L26:
        if ((r9 & 16) == 0) goto L28;
        boolean r4 = true;
    L30:
        if ((r9 & 2) == 0) goto L32;
        boolean r5 = true;
    L34:
        if ((r9 & 4) == 0) goto L36;
        boolean r6 = true;
    L38:
        if ((r9 & 8) == 0) goto L40;
        boolean r12 = true;
    L41:
        if (r5 == true) goto L45;
        if (r6 == true) goto L45;
        boolean r7 = false;
    L46:
        if (r7 == true) goto L50;
        if (r12 == true) goto L50;
        r2 = false;
    L50:
        ArrayList r13 = new ArrayList();
        if (r4 == false) goto L54;
        if (r0 == true) goto L54;
        r13.add("android.permission.WRITE_EXTERNAL_STORAGE");
    L54:
        if (r11 == false) goto L61;
        if (r5 == false) goto L57;
        r13.add("android.permission.READ_MEDIA_IMAGES");
    L57:
        if (r6 == false) goto L59;
        r13.add("android.permission.READ_MEDIA_VIDEO");
    L59:
        if (r12 == false) goto L64;
        r13.add("android.permission.READ_MEDIA_AUDIO");
    L64:
        r13.addAll(Arrays.asList(r10));
        return new b((String[]) r13.toArray(new String[0]));
    L61:
        if (r2 == true) goto L63;
        if (r3 == false) goto L64;
    L63:
        r13.add("android.permission.READ_EXTERNAL_STORAGE");
    L45:
        r7 = true;
        goto L46
    L40:
        r12 = false;
        goto L41
    L36:
        r6 = false;
        goto L38
    L32:
        r5 = false;
        goto L34
    L28:
        r4 = false;
        goto L30
    L22:
        if (r8.getApplicationInfo().targetSdkVersion < 33) goto L24;
        r11 = true;
        goto L26
    L66:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        if (Environment.isExternalStorageLegacy() == true) goto L12;
    L11:
        boolean r14 = true;
    L16:
        if (r14 == true) goto L18;
        r3 = true;
    L12:
        r14 = false;
    L14:
        if (Build.VERSION.SDK_INT < 30) goto L12;
    L5:
        r1 = false;
        goto L6
    }

    public static void f(final Activity r3, final a r4, int r5, Token r6, final String... r7) {
        b r8 = c(r3, r5, r7);
        if (r8.a == false) goto L5;
        r4.b(new c(r3, r7));
        return;
    L5:
        String[] r9 = r8.b;
        o0c.c r0 = new o0c.c(r3);
        Observable.just(o0c.c.b).compose(r0.c(r6, true, r9)).subscribe(new n0c.c(r4, r3, r7));
    }
}
