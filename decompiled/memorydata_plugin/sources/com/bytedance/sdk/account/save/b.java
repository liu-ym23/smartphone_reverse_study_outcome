package com.bytedance.sdk.account.save;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.account.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Integer f3140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3141b;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3153b;

        a(int r1, String r2) {
            this.f3152a = r1;
            this.f3153b = r2;
        }
    }

    static {
    }

    public static com.bytedance.sdk.account.save.entity.c a(com.bytedance.sdk.account.h.a r7) {
    L37:
        e = move-exception;
        e.printStackTrace();
    L39:
        com.bytedance.sdk.account.save.entity.c r8 = null;
    L40:
        f3140a = null;
        f3141b = null;
        return r8;
    L4:
        if (f3140a == null) goto L39;
        com.bytedance.sdk.account.save.entity.c.a r3 = new com.bytedance.sdk.account.save.entity.c.a().a(new Date().getTime());     // Catch: Exception -> L37
        if (r7 != null) goto L8;
    L35:
        r3.a(f3140a.intValue()).a(f3141b);     // Catch: Exception -> L37
        r8 = r3.a();     // Catch: Exception -> L37
        goto L40
    L8:
        if (r7.a() == null) goto L35;
        r3.b(r7.d());     // Catch: Exception -> L37
        r3.c(r7.j());     // Catch: Exception -> L37
        String r4 = r7.a().optString("screen_name");     // Catch: Exception -> L37
        String r5 = r7.a().optString("avatar_url");     // Catch: Exception -> L37
        r3.d(r4);     // Catch: Exception -> L37
        r3.b(r5);     // Catch: Exception -> L37
        if (f3140a.intValue() != 6) goto L22;
        Map<String, com.ss.android.account.b.a> r9 = r7.e();     // Catch: Exception -> L37
        if (r9 == null) goto L35;
        Iterator<String> r0 = r9.keySet().iterator();     // Catch: Exception -> L37
    L15:
        if (r0.hasNext() == false) goto L35;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L37
        if (r6.contains(f3141b) == false) goto L15;
        f3141b = r6;     // Catch: Exception -> L37
        com.ss.android.account.b.a r10 = (com.ss.android.account.b.a) ZeusTransformUtils.preCheckCast(r9.get(r6), com.ss.android.account.b.a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L37
        if (r10 == null) goto L15;
        String r11 = r10.d;     // Catch: Exception -> L37
        r3.e(r10.e);     // Catch: Exception -> L37
        r3.f(r11);     // Catch: Exception -> L37
        goto L15
    L22:
        if (f3140a.intValue() != 1) goto L26;
        f3141b = r7.g;     // Catch: Exception -> L37
        Integer r12 = Integer.valueOf(r7.f());     // Catch: Exception -> L37
    L24:
        r3.a(r12);     // Catch: Exception -> L37
        goto L35
    L26:
        if (f3140a.intValue() != 2) goto L28;
    L29:
        int r13 = r7.f();     // Catch: Exception -> L37
        if (TextUtils.isEmpty(f3141b) == false) goto L32;
    L34:
        r12 = Integer.valueOf(r13);     // Catch: Exception -> L37
        goto L24
    L32:
        if (f3141b.startsWith(Marker.ANY_NON_NULL_MARKER) == false) goto L34;
        f3141b = f3141b.replace(Marker.ANY_NON_NULL_MARKER + r13, "");     // Catch: Exception -> L37
        goto L34
    L28:
        if (f3140a.intValue() != 3) goto L35;
        goto L29
    }

    public static void a(Context r2, final String r3, final String r4, com.bytedance.sdk.account.save.b.a r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        final com.bytedance.sdk.account.save.b.a r7 = (com.bytedance.sdk.account.save.b.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.sdk.account.save.b.a.class, "com.obric.memorydata.plugin");
        new AnonymousClass4(r3, r4, r6, r7).c();
    }

    public static void a(final com.bytedance.sdk.account.save.entity.c r2, com.bytedance.sdk.account.save.b.c r3) {
        final com.bytedance.sdk.account.save.b.c r4 = (com.bytedance.sdk.account.save.b.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.sdk.account.save.b.c.class, "com.obric.memorydata.plugin");
        if (d.a().e() == true) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
    L9:
        new AnonymousClass1(r2, r4).c();
        return;
    L7:
        if (r2.getType() != 7) goto L9;
    }

    private static void delete(final int r2, final Object r3, com.bytedance.sdk.account.save.b.a r4) {
        final com.bytedance.sdk.account.save.b.a r5 = (com.bytedance.sdk.account.save.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.sdk.account.save.b.a.class, "com.obric.memorydata.plugin");
        new AnonymousClass3(r2, r3, r5).c();
    }

    private static void query(final int r7, final Long r8, final Integer r9, final String r10, final Long r11, com.bytedance.sdk.account.save.b.b r12) {
        final com.bytedance.sdk.account.save.b.b r6 = (com.bytedance.sdk.account.save.b.b) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.sdk.account.save.b.b.class, "com.obric.memorydata.plugin");
        new AnonymousClass2(r7, r8, r9, r10, r11, r6).c();
    }
}
