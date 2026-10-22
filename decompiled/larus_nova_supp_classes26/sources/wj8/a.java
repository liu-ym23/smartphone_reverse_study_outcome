package wj8;

import com.larus.platform.service.z2;
import hq9.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        n0 r3 = (n0) z2.a.getCommonButtonV2AICreationConfig().get(r2);
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.a();
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L9
    }
}
