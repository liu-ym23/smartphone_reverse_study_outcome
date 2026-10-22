package com.bytedance.awemeopen.infra.base.event;

import android.text.TextUtils;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.servicesapi.event.AoEventService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static Function0<String> f;
    public static Function0<String> g;
    public static Function0<Boolean> h;
    public final long a;
    public final String b;
    public final String c;
    public final JSONObject d;
    public final d[] e;

    public class a implements Runnable {
        public final /* synthetic */ b a;

        public final void a() {
            JSONObject r0 = this.a.c();
            if (AoEventReportRules.check(this.a.b, r0) == false) goto L5;
            b r1 = this.a;
            String r2 = r1.b;
            r1.getClass();
            j64.a.a(AoEventService.class).k2(r2, r0, r1.c, r1.d);
        L5:
            AoLogger.g("AoEvent", new Object[]{this.a.b, r0.toString()});
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.infra.base.event.b$b, reason: collision with other inner class name */
    public static class C0189b {
        public final long a;
        public final String b;
        public String c;
        public JSONObject d;
        public final d e;
        public final c f;

        public final b a() {
            return new b(this.a, this.b, this.c, this.d, new d[]{null, this.f, null, this.e});
        }

        public C0189b(String r4) {
            com.bytedance.awemeopen.infra.base.event.c r0 = com.bytedance.awemeopen.infra.base.event.c.a;
            this.a = System.currentTimeMillis();
            this.b = r4;
            this.e = r0;
            this.f = new c();
        }

        public final b b(d r11, d r12) {
            return new b(this.a, this.b, this.c, this.d, new d[]{null, this.f, null, this.e, r11, null, r12});
        }

        public final b c(d r11, d r12) {
            return new b(this.a, this.b, this.c, this.d, new d[]{null, this.f, null, this.e, r11, r12});
        }

        public final void d(String r3, Object r4) {
            c r0 = this.f;
            r0.getClass();
            if (r3 == null) goto L15;
            if (r4 == null) goto L16;
        L10:
            e = move-exception;
            AoLogger.j(e);
            return;
        L6:
            if (r0.a != null) goto L8;
            r0.a = new JSONObject();     // Catch: JSONException -> L10
        L8:
            r0.a.put(r3, r4);     // Catch: JSONException -> L10
            return;
        L16:
            return;
        }
    }

    public static class c implements d {
        public JSONObject a;

        public c() {
        }

        @Override // com.bytedance.awemeopen.infra.base.event.d
        public final JSONObject getParams() {
            return this.a;
        }
    }

    public final void b() {
        if (TextUtils.isEmpty(this.b) == false) goto L5;
        return;
    L5:
        a r0 = new a(this);
        AoPool r1 = AoPool.a;
        Intrinsics.checkNotNullParameter(r0, "task");
        AoPool.a.getClass();
        AoPool.c().executeLogic(r0);
    }

    public final JSONObject c() {
        JSONObject r0 = new JSONObject();
        d[] r1 = this.e;     // Catch: Throwable -> L11
        int r2 = r1.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L9;
        d r4 = r1[r3];     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        d(r0, r4.getParams());     // Catch: Throwable -> L11
    L8:
        r3 = r3 + 1;     // Catch: Throwable -> L11
        goto L4
    L9:
        r0.put("report_timestamp", this.a);     // Catch: Throwable -> L11
    L13:
        return r0;
    L11:
        th = move-exception;
        AoLogger.j(th);
        goto L13
    }

    public static C0189b a(String r2) {
        com.bytedance.awemeopen.infra.base.event.c r1 = com.bytedance.awemeopen.infra.base.event.c.a;
        return new C0189b(r2);
    }

    public static void d(JSONObject r7, JSONObject r8) {
        if (r8 == null) goto L36;
        Iterator<String> r0 = r8.keys();     // Catch: Throwable -> L23
    L5:
        if (r0.hasNext() == false) goto L37;
        String r1 = r0.next();     // Catch: Throwable -> L23
        if (r7.has(r1) == false) goto L9;
        AoLogger.c("AoEvent", new Object[]{"collition key: " + r1});     // Catch: Throwable -> L23
        String r3 = "";
        if (r8.has(r1) == true) goto L21;
        int r2 = 0;
    L15:
        if (r2 >= 10) goto L20;
        String r4 = r1 + "_" + r2;     // Catch: Throwable -> L23
        if (r8.has(r4) == false) goto L18;
        r2 = r2 + 1;     // Catch: Throwable -> L23
        goto L15
    L18:
        r3 = r4;
        goto L21
    L20:
        AoLogger.c("not detect valid key", new Object[0]);     // Catch: Throwable -> L23
    L21:
        r7.put(r3, r8.get(r1));     // Catch: Throwable -> L23
        goto L5
    L9:
        r7.put(r1, r8.get(r1));     // Catch: Throwable -> L23
        goto L5
    L37:
        return;
    L23:
        th = move-exception;
        AoLogger.j(th);
        return;
    }

    public b(long r1, String r3, String r4, JSONObject r5, d[] r6) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
