package m02;

import com.bytedance.android.live.core.resources.j;
import com.bytedance.android.live.core.resources.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final int a(String r3, com.bytedance.android.live.core.resources.e r4) {
        if (r4 == null) goto L26;
        if (r3 != null) goto L5;
        return -1;
    L5:
        if (r3.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return -1;
    L10:
        if (r3.equals(r4.getMD5()) == false) goto L12;
        return 0;
    L12:
        j r1 = r4.getH265ResourceModel();
        String r2 = null;
        if (r1 == null) goto L15;
        String r5 = r1.getMd5();
    L17:
        if (r3.equals(r5) == false) goto L19;
        return 1;
    L19:
        k r6 = r4.getH265SuperResourceModel();
        if (r6 == null) goto L23;
        r2 = r6.getMd5();
    L23:
        if (r3.equals(r2) == false) goto L30;
        return 2;
    L30:
        return -1;
    L15:
        r5 = null;
        goto L17
    L7:
        r0 = false;
        goto L8
    L26:
        return -1;
    }
}
