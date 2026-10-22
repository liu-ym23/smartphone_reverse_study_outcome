package dxb;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void d(cxb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        c.a r0 = c.a;
        int r1 = com.ss.android.lark.officesdk.utils.di.l.a;
        ntb.o r3 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r3 == null) goto L6;
        ntb.o.a r4 = r3.d();
        if (r4 == null) goto L6;
    L7:
        if (r2 != null) goto L22;
        Map<String, Object> r5 = null;
    L12:
        if (r5 == null) goto L16;
        boolean r6 = true;
        if ((!r5.isEmpty()) != true) goto L16;
    L17:
        if (r6 == false) goto L19;
        r4.b();     // Catch: Throwable -> L9
    L19:
        r4.flush();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L16:
        r6 = false;
        goto L17
    L22:
        r5 = r2.getCommonParams();     // Catch: Throwable -> L9
    L6:
        r4 = new com.ss.android.lark.officesdk.utils.di.k();
        goto L7
    }

    public static void b(g r2, Uri r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        String r0 = com.ss.android.lark.officesdk.utils.di.p.a(r3);
        String r4 = com.ss.android.lark.officesdk.utils.di.p.c(r3.toString());
        r2.a("host", r0);
        r2.a("current_url", r4);
    }

    public static void c(g r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        b(r1, UriProtector.parse(r2));
    }

    public static void a(cxb.a r1, g r2, String r3) {
        if (r1 == null) goto L4;
        String r4 = r1.getBizType();
    L6:
        if (Intrinsics.areEqual(r4, b.b.a()) == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L17;
        Uri r5 = UriProtector.parse(r3);     // Catch: Exception -> L11
        r2.a("host", r5.getHost());     // Catch: Exception -> L11
        List<String> r0 = com.ss.android.lark.officesdk.utils.di.p.a;     // Catch: Exception -> L11
        r2.a(AppbrandHostConstants.Schema_RESERVED_FIELD.PATH, com.ss.android.lark.officesdk.utils.di.p.b(r5.getPath()));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("WebMonitorManager", "add url exception " + e);
        return;
    L17:
        return;
    L4:
        r4 = null;
        goto L6
    }
}
