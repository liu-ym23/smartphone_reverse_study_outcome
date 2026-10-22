package nz9;

import android.text.TextUtils;
import com.larus.trace.CopyContentTypeString;
import com.larus.ugc.perf.impl.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements vy9.a {
    public static final b a = null;
    public static String b;
    public static String c;
    public static final Map<String, Boolean> d = null;

    public b() {
    }

    static {
        a = new b();
        b = "";
        c = "";
        d = new LinkedHashMap();
    }

    @Override // vy9.a
    public final void a() {
        Intrinsics.checkNotNullParameter("1", CopyContentTypeString.CODE);
        e("creation_page", "1", null);
    }

    public static String b(String r1, String r2) {
        return r1 + '/' + r2;
    }

    @JvmStatic
    public static final void d(String r2, List<Pair<String, String>> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "keyValues");
        String r5 = b(r2, r4);
        com.larus.ugc.perf.impl.c r6 = com.larus.ugc.perf.impl.c.a;
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r3, "keyValues");
        if (TextUtils.isEmpty(r5) == true) goto L15;
        com.larus.ugc.perf.impl.c.a.getClass();
        g r7 = com.larus.ugc.perf.impl.c.b(r5);
        if (r7 == null) goto L14;
        Iterator<T> r8 = r3.iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        Pair r0 = (Pair) r8.next();
        r7.d((String) r0.component1(), (String) r0.component2());
        goto L9
    L11:
        com.larus.ugc.perf.impl.c.a.getClass();
        com.larus.ugc.perf.impl.c.d(r5, r7);
        return;
    L14:
        return;
    }

    @JvmStatic
    public static final void e(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "errorCode");
        String r6 = b(r3, r5);
        com.larus.ugc.perf.impl.c.a.getClass();
        g r7 = com.larus.ugc.perf.impl.c.b(r6);
        if (r7 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, "0") == false) goto L7;
        r7.d("success", "1");
    L8:
        com.larus.ugc.perf.impl.c.e(r6);
        JSONObject r8 = r7.c();
        com.larus.ugc.perf.impl.c.f(r7.a, r8);
        return;
    L7:
        r7.d("success", "0");
        r7.d("err_code", r4);
        goto L8
    }

    @JvmStatic
    public static final void f(String r1, List<String> r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "errorCode");
        Intrinsics.checkNotNullParameter(r2, "scenes");
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        e((String) r4.next(), r1, r3);
        goto L4
    }

    @JvmStatic
    public static final void c(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        com.larus.ugc.perf.impl.c.c(b(r1, r4), new String[]{r2, r3});
    }

    @JvmStatic
    public static final void g(String r3, String r4, String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "parentScene");
        String r8 = b(r4, r6);
        if (Intrinsics.areEqual(r3, r4) == true) goto L7;
        com.larus.ugc.perf.impl.c.a.getClass();
        if (com.larus.ugc.perf.impl.c.b(r8) != null) goto L7;
        return;
    L7:
        String r9 = b(r3, r5);
        g r10 = new g("creation_page_perf_report");
        r10.d("trace_id", b);
        r10.d("instruction_type", c);
        r10.d("scene", r3);
        r10.d("parent_scene", r4);
        com.larus.ugc.perf.impl.c.a.getClass();
        com.larus.ugc.perf.impl.c.d(r9, r10);
        if (r7 == false) goto L11;
        d.put(r3, Boolean.FALSE);
        return;
    }

    public static /* synthetic */ void h(String r2, String r3, String r4, String r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        g(r2, r3, r4, r5, false);
    }
}
