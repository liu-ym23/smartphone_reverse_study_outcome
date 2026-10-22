package swb;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static boolean a(VFSPath r2) {
        int r0 = j.a;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        com.ss.android.lark.officesdk.utils.di.j.f("CommonResUtils", "checkResourceIsValid, filePath is empty");
        return false;
    L12:
        return true;
    L5:
        if (TextUtils.isEmpty(r2.getRealPath()) == true) goto L8;
        r3 = false;
        goto L9
    }

    public static int b(String r7, String r8) {
    L36:
        return -2;
    L4:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return -2;
    L7:
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return -1;
    L10:
        if (TextUtils.equals(r7, r8) == false) goto L12;
        return 0;
    L12:
        String[] r9 = r7.split("\\.");     // Catch: Exception -> L36
        String[] r10 = r8.split("\\.");     // Catch: Exception -> L36
        int r0 = Math.min(r9.length, r10.length);     // Catch: Exception -> L36
        int r2 = 0;
        int r5 = 0;
    L13:
        if (r2 >= r0) goto L18;
        r5 = CastIntegerProtector.parseInt(r9[r2]) - CastIntegerProtector.parseInt(r10[r2]);     // Catch: Exception -> L36
        if (r5 != 0) goto L18;
        r2 = r2 + 1;     // Catch: Exception -> L36
    L18:
        if (r5 != 0) goto L33;
        int r6 = r2;
    L21:
        if (r6 >= r9.length) goto L26;
        if (CastIntegerProtector.parseInt(r9[r6]) > 0) goto L24;
        r6 = r6 + 1;     // Catch: Exception -> L36
        goto L21
    L24:
        return 1;
    L26:
        if (r2 >= r10.length) goto L32;
        if (CastIntegerProtector.parseInt(r10[r2]) > 0) goto L30;
        r2 = r2 + 1;
        goto L26
    L30:
        return -1;
    L32:
        return 0;
    L33:
        if (r5 <= 0) goto L45;
        return 1;
    L45:
        return -1;
    }
}
