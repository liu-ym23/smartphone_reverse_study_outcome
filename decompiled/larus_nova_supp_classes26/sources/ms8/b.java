package ms8;

import android.os.SystemClock;
import com.larus.bmhome.upload.instant.c;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mr9.i;
import mr9.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final b a = null;
    public static final ConcurrentHashMap<String, a> b = null;
    public static final ConcurrentHashMap<String, Long> c = null;
    public static final ConcurrentHashMap<Integer, String> d = null;
    public static final Set<String> e = null;

    public static final class a {
        public final String a;
        public final long b;
        public final String c;
        public final String d;
        public final boolean e;
        public final boolean f;
        public final c g;
        public final Long h;
        public final Long i;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r9.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31;
            String r3 = this.d;
            int r4 = 0;
            if (r3 != null) goto L5;
            int r5 = 0;
        L6:
            int r6 = (r2 + r5) * 31;
            int r7 = 1231;
            if (this.e == false) goto L9;
            int r8 = 1231;
        L10:
            int r9 = (r6 + r8) * 31;
            if (this.f == true) goto L14;
            r7 = 1237;
        L14:
            int r10 = (r9 + r7) * 31;
            c r11 = this.g;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Long r14 = this.h;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Long r17 = this.i;
            if (r17 == null) goto L27;
            r4 = r17.hashCode();
        L27:
            return r16 + r4;
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L9:
            r8 = 1237;
            goto L10
        L5:
            r5 = r3.hashCode();
            goto L6
        }

        public final String toString() {
            return "TraceSession(uploadId=" + this.a + ", startElapsedMs=" + this.b + ", chain=" + this.c + ", uploadScene=" + this.d + ", instantEnabled=" + this.e + ", instantChainEnabled=" + this.f + ", policyId=" + this.g + ", sourceFileSize=" + this.h + ", uploadFileSize=" + this.i + ')';
        }

        public static a a(a r15, c r16, Long r17, Long r18, int r19) {
            String r3 = null;
            if ((r19 & 1) == 0) goto L5;
            String r5 = r15.a;
        L7:
            if ((r19 & 2) == 0) goto L9;
            long r6 = r15.b;
        L11:
            if ((r19 & 4) == 0) goto L13;
            String r8 = r15.c;
        L15:
            if ((r19 & 8) == 0) goto L17;
            r3 = r15.d;
        L17:
            String r9 = r3;
            if ((r19 & 16) == 0) goto L20;
            boolean r10 = r15.e;
        L22:
            if ((r19 & 32) == 0) goto L24;
            boolean r11 = r15.f;
        L26:
            if ((r19 & 64) == 0) goto L28;
            c r12 = r15.g;
        L30:
            if ((r19 & 128) == 0) goto L32;
            Long r13 = r15.h;
        L34:
            if ((r19 & 256) == 0) goto L36;
            Long r14 = r15.i;
        L37:
            Intrinsics.checkNotNullParameter(r5, "uploadId");
            Intrinsics.checkNotNullParameter(r8, "chain");
            return new a(r5, r6, r8, r9, r10, r11, r12, r13, r14);
        L36:
            r14 = r18;
            goto L37
        L32:
            r13 = r17;
            goto L34
        L28:
            r12 = r16;
            goto L30
        L24:
            r11 = false;
            goto L26
        L20:
            r10 = false;
            goto L22
        L13:
            r8 = null;
            goto L15
        L9:
            r6 = 0;
            goto L11
        L5:
            r5 = null;
            goto L7
        }

        public a(String r2, long r3, String r5, String r6, boolean r7, boolean r8, c r9, Long r10, Long r11) {
            Intrinsics.checkNotNullParameter(r2, "uploadId");
            Intrinsics.checkNotNullParameter(r5, "chain");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
        }
    }

    public b() {
    }

    public static String j(long r3) {
        if (r3 >= 102400) goto L6;
        return "0_100k";
    L6:
        if (r3 >= 1048576) goto L9;
        return "100k_1m";
    L9:
        if (r3 >= 5242880) goto L12;
        return "1m_5m";
    L12:
        if (r3 >= 10485760) goto L15;
        return "5m_10m";
    L15:
        if (r3 >= 52428800) goto L17;
        return "10m_50m";
    L17:
        return "50m_plus";
    }

    static {
        a = new b();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static String l(j r5) {
        String r0 = r5.l;
        boolean r1 = false;
        String r3 = null;
        if (r0 != null) goto L5;
    L12:
        UplinkFileEntity r2 = r5.o.c;
        if (r2 == null) goto L21;
        String r4 = r2.getFileIdentifier();
        if (r4 == null) goto L21;
        if (r4.length() <= 0) goto L19;
        r1 = true;
    L19:
        if (r1 == false) goto L21;
        r3 = r4;
    L21:
        if (r3 != null) goto L30;
        ConcurrentHashMap<Integer, String> r6 = d;
        Integer r7 = Integer.valueOf(System.identityHashCode(r5));
        String r8 = r6.get(r7);
        if (r8 != null) goto L32;
        r8 = UUID.randomUUID().toString();
        String r9 = r6.putIfAbsent(r7, r8);
        if (r9 == null) goto L32;
        r8 = r9;
    L32:
        return r8;
    L30:
        return r3;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L12;
        return r0;
    L7:
        r10 = false;
        goto L8
    }

    public static void a(final String r1, j r2) {
        b.remove(r1);
        d.remove(Integer.valueOf(System.identityHashCode(r2)));
        e.remove(r1);
        CollectionsKt.removeAll(c.keySet(), new ms8.a(r1));
    }

    public static String h(String r1, String r2) {
        return r1 + '#' + r2;
    }

    public static void i(j r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "param");
        Intrinsics.checkNotNullParameter(r4, "stage");
        c.put(h(l(r3), r4), Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public static void k(j r4, c r5) {
        Intrinsics.checkNotNullParameter(r4, "param");
        Intrinsics.checkNotNullParameter(r5, "policyId");
        String r6 = l(r4);
        ConcurrentHashMap<String, a> r0 = b;
        a r1 = r0.get(r6);
        if (r1 != null) goto L5;
        return;
    L5:
        r0.put(r6, a.a(r1, r5, null, null, 447));
    }

    public static void e(JSONObject r0, String r1, Object r2) {
        if (r2 == null) goto L5;
        r0.put(r1, r2);
        return;
    }

    public static void b(j r8, String r9, String r10, ResourceUploadError r11, Map r12) {
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r9, "stage");
        Intrinsics.checkNotNullParameter(r10, "status");
        Intrinsics.checkNotNullParameter(r12, "extra");
        String r0 = l(r8);
        Long r1 = c.remove(h(r0, r9));
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
        a.getClass();
        Long r3 = Long.valueOf(SystemClock.elapsedRealtime() - r2);
    L6:
        f(r8, r9, r10, r3, r11, r12);
        if (Intrinsics.areEqual(r9, "fallback_register") == true) goto L9;
        return;
    L9:
        if (e.remove(r0) == false) goto L13;
        a(r0, r8);
        return;
    L13:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static void d(b r8, j r9, String r10, ResourceUploadError r11, int r12) {
        Long r1 = null;
        if ((r12 & 4) == 0) goto L5;
        ResourceUploadError r6 = null;
    L7:
        if ((r12 & 8) == 0) goto L9;
        Map r7 = MapsKt.emptyMap();
    L10:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "param");
        Intrinsics.checkNotNullParameter(r10, "status");
        Intrinsics.checkNotNullParameter(r7, "extra");
        String r13 = l(r9);
        a r14 = b.get(r13);
        if (r14 == null) goto L13;
        a.getClass();
        r1 = Long.valueOf(SystemClock.elapsedRealtime() - r14.b);
    L13:
        f(r9, "upload_total", r10, r1, r6, r7);
        if (c.containsKey(h(r13, "fallback_register")) == false) goto L16;
        e.add(r13);
        return;
    L16:
        a(r13, r9);
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = r11;
        goto L7
    }

    public static void f(j r16, String r17, String r18, Long r19, ResourceUploadError r20, Map r21) {
        Intrinsics.checkNotNullParameter(r16, "param");
        Intrinsics.checkNotNullParameter(r17, "stage");
        Intrinsics.checkNotNullParameter(r18, "status");
        Intrinsics.checkNotNullParameter(r21, "extra");
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L66
        String r9 = l(r16);     // Catch: Throwable -> L66
        Object r10 = r21.get("file_size");     // Catch: Throwable -> L66
        Long r11 = null;
        if ((r10 instanceof Long) == false) goto L6;
        Long r12 = (Long) r10;     // Catch: Throwable -> L66
    L7:
        Object r13 = r21.get("upload_file_size");     // Catch: Throwable -> L66
        if ((r13 instanceof Long) == false) goto L10;
        Long r14 = (Long) r13;     // Catch: Throwable -> L66
    L11:
        ConcurrentHashMap<String, a> r15 = b;     // Catch: Throwable -> L66
        a r110 = r15.get(r9);     // Catch: Throwable -> L66
        if (r110 == null) goto L22;
        if (r12 != null) goto L15;
        Long r111 = r110.h;     // Catch: Throwable -> L66
    L16:
        if (r14 != null) goto L18;
        Long r112 = r110.i;     // Catch: Throwable -> L66
    L19:
        a r3 = a.a(r110, null, r111, r112, 127);     // Catch: Throwable -> L66
        if (Intrinsics.areEqual(r3, r110) == true) goto L23;
        r15.put(r9, r3);     // Catch: Throwable -> L66
    L23:
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L66
        e(r113, "upload_id", r9);     // Catch: Throwable -> L66
        e(r113, "stage", r17);     // Catch: Throwable -> L66
        e(r113, "status", r18);     // Catch: Throwable -> L66
        e(r113, "duration_ms", r19);     // Catch: Throwable -> L66
        if (r3 == null) goto L27;
        String r7 = r3.c;     // Catch: Throwable -> L66
        if (r7 == null) goto L27;
    L28:
        e(r113, "chain", r7);     // Catch: Throwable -> L66
        e(r113, "data_type", r16.c.getType());     // Catch: Throwable -> L66
        e(r113, "biz_scene", r16.b);     // Catch: Throwable -> L66
        if (r3 == null) goto L31;
        String r22 = r3.d;     // Catch: Throwable -> L66
    L32:
        e(r113, "upload_scene", r22);     // Catch: Throwable -> L66
        e(r113, "resource_center_enabled", Boolean.valueOf(r16.o.a));     // Catch: Throwable -> L66
        if (r3 == null) goto L35;
        Boolean r6 = Boolean.valueOf(r3.e);     // Catch: Throwable -> L66
    L36:
        e(r113, "instant_enabled", r6);     // Catch: Throwable -> L66
        if (r3 == null) goto L39;
        Boolean r23 = Boolean.valueOf(r3.f);     // Catch: Throwable -> L66
    L40:
        e(r113, "instant_chain_enabled", r23);     // Catch: Throwable -> L66
        if (r3 == null) goto L45;
        c r0 = r3.g;     // Catch: Throwable -> L66
        if (r0 == null) goto L45;
        e(r113, "transform_policy_id", r0.e);     // Catch: Throwable -> L66
        e(r113, "policy_family", r0.a);     // Catch: Throwable -> L66
        e(r113, "policy_digest", r0.b);     // Catch: Throwable -> L66
        e(r113, "policy_schema_version", r0.c);     // Catch: Throwable -> L66
    L45:
        if (r20 == null) goto L47;
        e(r113, "error_code", i.a(r20.getCode()));     // Catch: Throwable -> L66
        e(r113, "error_msg", StringsKt.take(r20.getMsg(), 200));     // Catch: Throwable -> L66
    L47:
        Iterator r1 = r21.entrySet().iterator();     // Catch: Throwable -> L66
    L49:
        if (r1.hasNext() == false) goto L51;
        Map.Entry r24 = (Map.Entry) r1.next();     // Catch: Throwable -> L66
        e(r113, (String) r24.getKey(), r24.getValue());     // Catch: Throwable -> L66
        goto L49
    L51:
        if (r12 != null) goto L55;
        if (r3 == null) goto L54;
        r12 = r3.h;     // Catch: Throwable -> L66
        goto L55
    L54:
        r12 = null;
    L55:
        if (r14 != null) goto L58;
        if (r3 == null) goto L59;
        r11 = r3.i;     // Catch: Throwable -> L66
    L59:
        e(r113, "file_size", r12);     // Catch: Throwable -> L66
        e(r113, "upload_file_size", r11);     // Catch: Throwable -> L66
        if (r12 == null) goto L62;
        e(r113, "file_size_bucket", j(r12.longValue()));     // Catch: Throwable -> L66
    L62:
        if (r11 == null) goto L64;
        e(r113, "upload_file_size_bucket", j(r11.longValue()));     // Catch: Throwable -> L66
    L64:
        o.a.reportEvent("upload_sdk_stage", r113);     // Catch: Throwable -> L66
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L66
    L68:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L75;
        FLogger.a.e("UploadSdkTraceReporter", "[reportStage] failed, stage=" + r17 + ", status=" + r18 + ", error=" + r4);
        return;
    L75:
        return;
    L58:
        r11 = r14;
        goto L59
    L39:
        r23 = null;
        goto L40
    L35:
        r6 = null;
        goto L36
    L31:
        r22 = null;
    L27:
        r7 = "unknown";
        goto L28
    L18:
        r112 = r14;
        goto L19
    L15:
        r111 = r12;
        goto L16
    L22:
        r3 = null;
        goto L23
    L10:
        r14 = null;
        goto L11
    L6:
        r12 = null;
    L66:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L68
    }

    public static /* synthetic */ void c(b r1, j r2, String r3, String r4, ResourceUploadError r5, Map r6, int r7) {
        if ((r7 & 8) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 16) == 0) goto L8;
        r6 = MapsKt.emptyMap();
    L8:
        r1.getClass();
        b(r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void g(b r8, j r9, String r10, String r11, Long r12, ResourceUploadError r13, int r14) {
        Map r1 = null;
        if ((r14 & 8) == 0) goto L5;
        Long r5 = null;
    L7:
        if ((r14 & 16) == 0) goto L9;
        ResourceUploadError r6 = null;
    L11:
        if ((r14 & 32) == 0) goto L13;
        r1 = MapsKt.emptyMap();
    L13:
        r8.getClass();
        f(r9, r10, r11, r5, r6, r1);
        return;
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}
