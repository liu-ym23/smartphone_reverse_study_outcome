package com.ss.ugc.effectplatform.util;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k {
    public static boolean a;
    public static final Map<String, String> b = null;

    static {
        b = new LinkedHashMap();
    }

    public static String a(ModelInfo r2) {
        return r2.getName() + "_v" + r2.getVersion() + "_size" + r2.getType() + "_md5" + ilc.b.a(r2) + ".model";
    }

    public static String b(String r12) {
        if (StringsKt.contains$default(r12, DBDefinition.MD5, false, 2, null) == true) goto L5;
        return null;
    L5:
        int r2 = StringsKt.indexOf$default(r12, DBDefinition.MD5, 0, false, 6, null);
        int r0 = StringsKt.lastIndexOf$default(r12, "_model", 0, false, 6, null);
        if (r0 != (-1)) goto L12;
        r0 = StringsKt.lastIndexOf$default(r12, ".model", 0, false, 6, null);
    L12:
        return r12.substring(r2 + 3, r0);
    L14:
        return null;
    }

    public static String d(String r3) {
        if (a == false) goto L15;
        Map<String, String> r0 = b;
        String r1 = (String) ((LinkedHashMap) r0).get(r3);
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        return r1;
    L13:
        String r4 = c(r3, "_v[0-9]+[\\._][0-9]+[\\._](size[0-9]+_md5[a-z0-9]+_)?(model|dat|bin|bytenn|zip)");
        r0.put(r3, r4);
        return r4;
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
        goto L11
    L15:
        return c(r3, "_v[0-9]");
    }

    public static int e(String r10) {
        if (StringsKt.contains$default(r10, "size", false, 2, null) == true) goto L5;
        return 0;
    L5:
        int r0 = StringsKt.lastIndexOf$default(r10, "size", 0, false, 6, null);
        if (StringsKt.contains$default(r10, DBDefinition.MD5, false, 2, null) == false) goto L8;
        int r1 = bytekn.foundation.utils.g.a;
        int r2 = bytekn.foundation.utils.g.a.a(r10, "_md5");
    L10:
        if (r0 < r2) goto L16;
        return -1;
    L16:
        return CastIntegerProtector.parseInt(r10.substring(r0 + 4, r2));
    L18:
        return -1;
    L8:
        int r3 = bytekn.foundation.utils.g.a;
        r2 = bytekn.foundation.utils.g.a.a(r10, "\\.model|_model|\\.dat");
        goto L10
    }

    public static String f(String r12) {
        StringsKt.lastIndexOf$default(r12, "/", 0, false, 6, null);
        int r0 = StringsKt.lastIndexOf$default(r12, "_v", 0, false, 6, null);
        int r1 = bytekn.foundation.utils.g.a;
        int r2 = bytekn.foundation.utils.g.a.a(r12, "\\.model|_model|\\.dat");
        if (r0 > 0) goto L7;
        return "1.0";
    L7:
        return r12.substring(r0 + 2, r2);
    }

    public static String c(String r6, String r7) {
        int r0 = StringsKt.lastIndexOf$default(r6, "/", 0, false, 6, null);
        int r1 = bytekn.foundation.utils.g.a;
        int r8 = bytekn.foundation.utils.g.a.a(r6, r7);
        int r2 = o.a;
        int r3 = r0 + 1;
        if (r.b(r6) == true) goto L14;
        if (r3 < 0) goto L14;
        if (r8 < 0) goto L14;
        if (r3 >= r8) goto L14;
        if (r3 >= r6.length()) goto L14;
        if (r8 > r6.length()) goto L14;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L21;
        if (r6 == null) goto L20;
        return r6.substring(r3, r8);
    L20:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L21:
        int r9 = bytekn.foundation.utils.g.a.a(r6, "\\.model|_model|\\.dat");
        if (r9 <= 0) goto L29;
        if (r9 <= r0) goto L29;
        if (r6 == null) goto L27;
        return r6.substring(r3, r9);
    L27:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L29:
        return r6.substring(r3, r6.length());
    L14:
        r4 = false;
        goto L16
    }
}
