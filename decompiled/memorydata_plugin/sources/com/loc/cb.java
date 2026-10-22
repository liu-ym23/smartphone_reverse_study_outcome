package com.loc;

import android.util.Base64;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public final class cb {
    public static boolean a(byte[] r7) {
        if (r7 == null) goto L28;
        byte[] r1 = null;
        df r2 = new df();     // Catch: Exception -> L23
        r2.f5433b.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream");     // Catch: Exception -> L23
        r2.f5433b.put("aps_c_src", Base64.encodeToString(df.a().getBytes(), 2));     // Catch: Exception -> L23
        r2.f5433b.put("aps_c_key", Base64.encodeToString(df.b().getBytes(), 2));     // Catch: Exception -> L23
        r2.d = r7;     // Catch: Exception -> L23
        if (bs.f5378a == false) goto L10;
        String r8 = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
    L8:
        r2.f5432a = r8;     // Catch: Exception -> L23
        dg r9 = cx.b().a(r2);     // Catch: Exception -> L23
        if (r9 != null) goto L17;
    L19:
        if (r1 == null) goto L29;
        if ("true".equals(new String(r1, StandardCharsets.UTF_8)) == true) goto L31;
        return false;
    L31:
        return true;
    L29:
        return false;
    L17:
        if (r9.f5434a != 200) goto L19;
        r1 = r9.c;     // Catch: Exception -> L23
        goto L19
    L10:
        if (bs.f5379b == false) goto L12;
        String r10 = ReportConsts.HTTPS;
    L13:
        r8 = r10 + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";     // Catch: Exception -> L23
        goto L8
    L12:
        r10 = "http://";
    L23:
        e = move-exception;
        de.a(e);
        return false;
    L28:
        return false;
    }
}
