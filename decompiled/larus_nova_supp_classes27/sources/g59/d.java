package g59;

import android.content.Context;
import com.google.gson.Gson;
import com.larus.dora.impl.dynamic.a2;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public final h59.a a;

    public static final class a {
    }

    static {
    }

    public d() {
        h59.a r0 = new h59.a();
        Intrinsics.checkNotNullParameter(r0, "localPageDataSource");
        this.a = r0;
    }

    public final a2 a(Context r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "pageName");
        h59.a r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "pageName");
        String r0 = r10 + '_' + r11;
        if (r2.a.containsKey(r0) == false) goto L5;
        a2 r12 = (a2) ((LinkedHashMap) r2.a).get(r0);
        g49.d.d("LocalPageDataSource", "fetchPageData: cache hit, productId=" + r11 + ", page=" + r10 + ", data=" + r12);
        return r12;
    L5:
        int r1 = r10.hashCode();
        if (r1 == (-1543122713)) goto L21;
        if (r1 == (-1156133010)) goto L17;
        if (r1 == (-857462632)) goto L13;
    L22:
        String r3 = "";
    L25:
        if (r3.length() != 0) goto L27;
        boolean r6 = true;
    L29:
        if (r6 == false) goto L42;
        g49.d.b("LocalPageDataSource", "fetchPageData: ERROR fileName is empty");
    L45:
        return null;
    L42:
        String r13 = h59.a.a(r9, r3);     // Catch: Exception -> L36
        if (r13 == null) goto L45;
        a2 r14 = (a2) new Gson().fromJson(r13, a2.class);     // Catch: Exception -> L36
    L38:
        if (r14 == null) goto L40;
        r2.a.put(r0, r14);
    L40:
        g49.d.d("LocalPageDataSource", "fetchPageData: productId=" + r11 + ", page=" + r10 + ", data=" + r14);
        return r14;
    L36:
        e = move-exception;
        g49.d.c("LocalPageDataSource", "fetchPageData: ERROR " + e.getMessage(), e);
        r14 = null;
        goto L38
    L27:
        r6 = false;
        goto L29
    L13:
        if (r10.equals("bind_device") == false) goto L22;
        r3 = h59.a.b(r11, "dora_bind_device.json");
        goto L25
    L17:
        if (r10.equals("device_manage") == false) goto L22;
        r3 = h59.a.b(r11, "dora_device_manage.json");
        goto L25
    L21:
        if (r10.equals("device_list") == false) goto L22;
        r3 = h59.a.b(-1, "dora_device_list.json");
        goto L25
    }
}
