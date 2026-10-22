package com.bytedance.android.annie.pia;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.param.k;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.services.IPiaLifeCycleService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o7.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final c47.c a = null;

    public static final class a {
        public final String a;
        public final String b;

        public a(String r1, String r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.pia.b$b, reason: collision with other inner class name */
    public static final class C0074b implements l47.b<Map<String, ?>> {
        public C0074b() {
        }

        public final Object create() {
            return a(null);
        }

        public final Map<String, ?> a(Object r10) {
            String r1 = null;
            if ((r10 instanceof a) == false) goto L5;
            a r11 = (a) r10;
        L6:
            Context r0 = c47.c.a.a;
            if (r11 == null) goto L9;
            String r12 = r11.a;
        L10:
            if (r11 == null) goto L12;
            r1 = r11.b;
        L12:
            k r13 = com.bytedance.android.annie.a.a(r0, r12, false, r1, "host");
            LinkedHashMap r14 = new LinkedHashMap();
            r14.putAll(com.bytedance.android.annie.param.b.b(r13));
            return r14;
        L9:
            r12 = null;
            goto L10
        L5:
            r11 = null;
            goto L6
        }

        public final /* bridge */ /* synthetic */ Object create(Object r1) {
            return a(r1);
        }
    }

    public static final class c<T> implements l47.b {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object create() {
            return new PiaResourceLoader();
        }

        public final Object create(Object r1) {
            return create();
        }
    }

    public static final class d<T> implements l47.b {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object create() {
            return l.b(new StringBuilder());
        }

        public final Object create(Object r1) {
            return create();
        }
    }

    static {
        c47.c r0 = new c47.c();
        r0.a = "annie";
        r0.g = new C0074b();
        r0.c = c.a;
        r0.b = d.a;
        a = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    @JvmStatic
    public static final boolean a(String r10, com.bytedance.android.annie.param.a r11) {
        Intrinsics.checkNotNullParameter(r11, "annieContext");
        IPiaLifeCycleService r0 = k47.c.a();
        if (r0 == null) goto L5;
        ?? r12 = r0.a(r10);
    L6:
        String r1 = r11.getMonitorID();
        if (r1 == null) goto L9;
        ((k9.e) Annie.getService(k9.e.class, r11.getBizKey())).V0().a(r1, "is_pia", r12);
    L9:
        return r12;
    L5:
        r12 = 0;
        goto L6
    }

    public static void b(String r10, String r11, String r12, com.bytedance.android.annie.param.a r13) {
        Intrinsics.checkNotNullParameter(r13, "annieContext");
        if (r11 != null) goto L6;
        return;
    L6:
        if (a(r11, r13) == true) goto L9;
        return;
    L9:
        if (r10 == null) goto L47;
        Iterator<T> r14 = AnnieConfigSettingKeys.LIVE_SKIP_PIA_WARMUP.a().iterator();
    L12:
        if (r14.hasNext() == false) goto L16;
        Object r15 = r14.next();
        if (StringsKt.contains$default(r11, (String) r15, false, 2, null) == false) goto L12;
    L17:
        boolean r16 = true;
        if (r15 == null) goto L20;
        boolean r17 = true;
    L21:
        if (r17 == false) goto L47;
        ConcurrentHashMap<Integer, s9.f> r18 = s9.a.a;
        String r19 = r13.getBizKey();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r19, "bizKey");
        com.bytedance.android.annie.ng.a r20 = g.c.get(r19);
        if (r20 == null) goto L29;
        o8.g r21 = r20.d;
        if (r21 == null) goto L29;
        if (r21.b == true) goto L29;
    L30:
        if (r16 == true) goto L43;
        Uri r22 = UriProtector.parse(r10);
        String r23 = UriProtector.getQueryParameter(r22, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r23 == null) goto L43;
        String r24 = UriProtector.getQueryParameter(r22, "prerender_cache_key");
        Uri r25 = UriProtector.parse(r23);     // Catch: Exception -> L42
        StringBuilder r26 = new StringBuilder();     // Catch: Exception -> L42
        r26.append(r25.getScheme());     // Catch: Exception -> L42
        r26.append(':');     // Catch: Exception -> L42
        if (r25.getPort() != (-1)) goto L39;
        Object r27 = "";
    L40:
        r26.append(r27);     // Catch: Exception -> L42
        r26.append("//");     // Catch: Exception -> L42
        r26.append(r25.getHost());     // Catch: Exception -> L42
        r26.append(r25.getPath());     // Catch: Exception -> L42
        boolean r110 = s9.a.d(r19, r26.toString() + '_' + r24);
    L44:
        if (r110 == false) goto L47;
        int r28 = x8.a.a;
        x8.a.d("PiaCore", r11.concat(" is in skip list and has prerenderCard, skip warmup"), false);
        return;
    L39:
        r27 = Integer.valueOf(r25.getPort());     // Catch: Exception -> L42
    L42:
        int r111 = x8.a.a;
        x8.a.b(Annie.ANNIE_TAG, "解析schema种的url失败:".concat(r10), false);
    L43:
        r110 = false;
    L29:
        r16 = false;
        goto L30
    L20:
        r17 = false;
        goto L21
    L16:
        r15 = null;
    L47:
        IPiaLifeCycleService r112 = k47.c.a();
        if (r112 == null) goto L58;
        if (r12 != null) goto L51;
        r12 = "";
    L51:
        String r29 = l.c(r11, null, r12);
        r112.c(r29, "annie", new a(r10, r29));
        return;
    }
}
