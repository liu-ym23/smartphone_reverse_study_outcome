package i8;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.log.LogLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements j9.b {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // j9.b
    public final void a(View r10, String r11, String r12, JSONObject r13, JSONObject r14, JSONObject r15, int r16) {
        Intrinsics.checkNotNullParameter(r10, "view");
        int r17 = j9.c.a;
        Intrinsics.checkNotNullParameter(r10, "view");
        if (((r9.c) Annie.getService$default(r9.c.class, null, 2, null)).c(r10) == false) goto L6;
        ((l9.b) Annie.getService$default(l9.b.class, null, 2, null)).g(r10, r11, r12, r13, r14, r15, r16);
    L8:
        b8.a r0 = b8.a.a;
        b8.a.d(new b8.b("reportAutoCustom", LogLevel.INFO, null, r11, 4));
        return;
    L6:
        if ((r10 instanceof WebView) == false) goto L8;
        ((n9.b) Annie.getService$default(n9.b.class, null, 2, null)).g(r10, r11, r12, r13, r14, r15, r16);
        goto L8
    }

    @Override // j9.b
    public final void b(View r10, String r11, String r12, JSONObject r13, JSONObject r14, JSONObject r15, JSONObject r16, int r17, String r18) {
        com.bytedance.android.monitorV2.g r0 = com.bytedance.android.monitorV2.g.e();
        jz2.d.a r1 = new jz2.d.a(r11);
        r1.a = r12;
        r1.d = r13;
        r1.e = r14;
        r1.f = r15;
        if (r16 != null) goto L5;
        r16 = new JSONObject();
    L5:
        r1.h = r16;
        r1.b(r17);
        r1.l = null;
        if (r18 == null) goto L8;
        r1.i = r18;
    L8:
        if (r10 != null) goto L24;
        boolean r19 = true;
        if (r12 != null) goto L12;
    L15:
        boolean r20 = true;
    L16:
        if (r20 == false) goto L24;
        if (r18 != null) goto L19;
    L22:
        if (r19 == false) goto L24;
        r1.b = "webcast_cn_container";
        goto L24
    L19:
        if (StringsKt.isBlank(r18) == true) goto L22;
        r19 = false;
        goto L22
    L12:
        if (StringsKt.isBlank(r12) == true) goto L15;
        r20 = false;
    L24:
        jz2.d r21 = r1.a();
        r0.getClass();
        com.bytedance.android.monitorV2.g.c(r21);
    }
}
