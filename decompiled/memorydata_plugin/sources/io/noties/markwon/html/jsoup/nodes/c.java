package io.noties.markwon.html.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.html.r;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import org.commonmark.internal.util.Html5Entities;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, String> f16581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, String> f16582b;

    static {
        if (r.f16609a.a() == false) goto L5;
        b();
        return;
    L5:
        a();
    }

    public static int a(String r4, int[] r5) {
        String r6 = b(r4);
        if (r6 == null) goto L9;
        int r1 = r6.length();
        if (r1 != 1) goto L7;
        r5[0] = r6.charAt(0);
    L8:
        return r1;
    L7:
        r5[0] = r6.charAt(0);
        r5[1] = r6.charAt(1);
        goto L8
    L9:
        return 0;
    }

    private static void a() {
        Field r0 = Html5Entities.class.getDeclaredField("NAMED_CHARACTER_REFERENCES");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        Map<String, String> r1 = (Map) ZeusTransformUtils.preCheckCast(r0.get(null), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
    L6:
        f16581a = r1;
        return;
    L4:
        th = move-exception;
        Map<String, String> r2 = Collections.emptyMap();
        th.printStackTrace();
        r1 = r2;
        goto L6
    }

    public static boolean a(String r0) {
        if (b(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static String b(String r3) {
        Map<String, String> r0 = f16582b;
        if (r0 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get(r3), String.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        if (f16581a != null) goto L12;
        a();
    L12:
        return (String) ZeusTransformUtils.preCheckCast(f16581a.get(r3), String.class, "com.obric.memorydata.plugin");
    L5:
        r1 = null;
        goto L6
    }

    private static void b() {
        f16582b = new CommonMarkEntities$1();
    }
}
