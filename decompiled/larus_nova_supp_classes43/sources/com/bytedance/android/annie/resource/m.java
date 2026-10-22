package com.bytedance.android.annie.resource;

import com.bytedance.android.annie.Annie;
import java.io.File;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m {
    static {
    }

    @JvmStatic
    public static final String b() {
        if (com.bytedance.android.annie.ng.g.g == true) goto L5;
        return "test";
    L5:
        String r0 = com.bytedance.android.annie.ng.g.b().b.b;
        if (r0 == null) goto L9;
        StringsKt.isBlank(r0);
        return r0;
    L9:
        return "test";
    }

    @JvmStatic
    public static final String c() {
        String r10 = null;
        String r0 = ((f9.b) Annie.getService$default(f9.b.class, null, 2, null)).getHostGeckoCacheDir();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return r0;
    L11:
        StringBuilder r11 = new StringBuilder();
        File r12 = com.bytedance.android.annie.ng.g.a().getFilesDir();
        if (r12 == null) goto L14;
        r10 = r12.getAbsolutePath();
    L14:
        r11.append(r10);
        r11.append(File.separator);
        r11.append("offlineX");
        return r11.toString();
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final String a(g r10) {
        String r0 = "";
        if (r10 == null) goto L5;
        CharSequence r11 = "";
    L6:
        if (r11 != null) goto L8;
    L11:
        boolean r12 = true;
    L12:
        if (r12 == true) goto L18;
        if (r10 != null) goto L16;
        r0 = null;
    L16:
        Intrinsics.checkNotNull(r0);
        return r0;
    L18:
        Boolean r13 = o8.c.c;
        Pair r14 = o8.c.a.b();
        boolean r1 = ((Boolean) r14.component1()).booleanValue();
        if (((Boolean) r14.component2()).booleanValue() == false) goto L21;
        return "68f927652a5370ec9f4ae1dbaf56fd85";
    L21:
        if (r1 == false) goto L23;
        return "36723dc3e85a23e701d1697d57de07ed";
    L23:
        return "5fb33cde3ebff01c8433ddc22aac0816";
    L8:
        if (StringsKt.isBlank(r11) == true) goto L11;
        r12 = false;
        goto L12
    L5:
        r11 = null;
        goto L6
    }
}
