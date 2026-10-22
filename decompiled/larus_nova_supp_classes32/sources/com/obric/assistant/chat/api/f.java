package com.obric.assistant.chat.api;

import com.larus.im.bean.message.Message;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final CoroutineScope a = null;
    public static final Object b = null;
    public static final LinkedHashMap<String, Long> c = null;
    public static final LinkedHashMap<String, b> d = null;
    public static final d e = null;
    public static final Map<String, a> f = null;
    public static final Map<String, a> g = null;
    public static final Map<String, a> h = null;

    public static final class a {
        public final String a;
        public final String b;
        public final long c;
        public final long d;
        public String e;
        public long f;
        public long g;
        public long h;
        public long i;
        public String j;
        public long k;
        public boolean l;

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
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L27;
            return false;
        L27:
            if (this.g == r9.g) goto L30;
            return false;
        L30:
            if (this.h == r9.h) goto L33;
            return false;
        L33:
            if (this.i == r9.i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
            return false;
        L39:
            if (this.k == r9.k) goto L42;
            return false;
        L42:
            if (this.l == r9.l) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r3 = this.d;
            int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            String r5 = this.e;
            if (r5 != null) goto L5;
            int r6 = 0;
        L6:
            int r7 = (r4 + r6) * 31;
            long r8 = this.f;
            int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
            long r10 = this.g;
            int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
            long r12 = this.h;
            int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
            long r14 = this.i;
            int r15 = (((r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31) + this.j.hashCode()) * 31;
            long r16 = this.k;
            int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
            if (this.l == false) goto L9;
            int r18 = 1231;
        L11:
            return r17 + r18;
        L9:
            r18 = 1237;
            goto L11
        L5:
            r6 = r5.hashCode();
            goto L6
        }

        public final String toString() {
            return "TraceSession(traceKey=" + this.a + ", firstQueryId=" + this.b + ", firstQueryStartTime=" + this.c + ", semanticIntentTime=" + this.d + ", uploadIdentifier=" + this.e + ", uploadStartTime=" + this.f + ", uploadFinishTime=" + this.g + ", restoreStartTime=" + this.h + ", restoreFinishTime=" + this.i + ", secondQueryId=" + this.j + ", secondQuerySendSuccessTime=" + this.k + ", reported=" + this.l + ')';
        }

        public a(String r3, String r4, long r5, long r7) {
            Intrinsics.checkNotNullParameter(r3, "traceKey");
            Intrinsics.checkNotNullParameter(r4, "firstQueryId");
            Intrinsics.checkNotNullParameter(NameKeys.UnloadStrategy_No_Strategy, "secondQueryId");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r7;
            this.e = null;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = NameKeys.UnloadStrategy_No_Strategy;
            this.k = -1;
            this.l = false;
        }
    }

    public static final class b {
        public long a;
        public long b;
        public long c;
        public Boolean d;
        public String e;
        public String f;

        public b() {
            this(0);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r4 = this.c;
            int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
            Boolean r6 = this.d;
            int r7 = 0;
            if (r6 != null) goto L5;
            int r8 = 0;
        L6:
            int r9 = (r5 + r8) * 31;
            String r10 = this.e;
            if (r10 != null) goto L9;
            int r11 = 0;
        L10:
            int r12 = (r9 + r11) * 31;
            String r13 = this.f;
            if (r13 == null) goto L15;
            r7 = r13.hashCode();
        L15:
            return r12 + r7;
        L9:
            r11 = r10.hashCode();
            goto L10
        L5:
            r8 = r6.hashCode();
            goto L6
        }

        public final String toString() {
            return "UploadRecord(startTime=" + this.a + ", finishTime=" + this.b + ", duration=" + this.c + ", success=" + this.d + ", code=" + this.e + ", msg=" + this.f + ')';
        }

        public b(int r3) {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = null;
            this.e = null;
            this.f = null;
        }
    }

    public f() {
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        b = new Object();
        c = new LinkedHashMap();
        d = new LinkedHashMap();
        e = new d();
        f = new LinkedHashMap();
        g = new LinkedHashMap();
        h = new LinkedHashMap();
    }

    public static void c(long r9) {
        Collection r0 = ((LinkedHashMap) f).values();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        a r4 = (a) r3;
        if ((r9 - r4.d) <= 1800000) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        if (r4.l == true) goto L11;
        r5 = false;
        goto L12
    L14:
        Iterator r6 = r1.iterator();
    L16:
        if (r6.hasNext() == false) goto L21;
        a r7 = (a) r6.next();
        if (r7.l == true) goto L19;
        m(r7, r9);
        goto L16
    L19:
        k(r7);
        goto L16
    }

    public static String d(a r5) {
        if (r5.k <= 0) goto L6;
        return "reply_timeout";
    L6:
        if (r5.h <= 0) goto L11;
        if (r5.i > 0) goto L11;
        return "restore_timeout";
    L11:
        if (r5.f > 0) goto L13;
    L15:
        String r6 = r5.e;
        if (r6 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
        return "semantic_prepare_timeout";
    L24:
        return "second_query_not_sent";
    L18:
        if (StringsKt.isBlank(r6) == true) goto L21;
        r7 = false;
        goto L22
    L13:
        if (r5.g > 0) goto L15;
        return "upload_timeout";
    }

    public static void k(final a r2) {
        f.remove(r2.a);
        String r0 = r2.e;
        if (r0 == null) goto L5;
        a r1 = g.remove(r0);
    L5:
        CollectionsKt.removeAll(((LinkedHashMap) h).entrySet(), new e(r2));
    }

    public static List o(Message r5) {
        String[] r0 = new String[2];
        String r1 = r5.getMessageId();
        String r3 = null;
        if (r1 != null) goto L5;
    L7:
        r1 = null;
    L8:
        r0[0] = r1;
        String r6 = r5.getLocalMessageId();
        if (r6 != null) goto L11;
    L13:
        r0[1] = r3;
        return CollectionsKt.distinct(CollectionsKt.listOfNotNull(r0));
    L11:
        if ((!StringsKt.isBlank(r6)) == false) goto L13;
        r3 = r6;
        goto L13
    L5:
        if ((!StringsKt.isBlank(r1)) == false) goto L7;
        goto L7
    }

    public static String p(Message r3) {
        String r0 = r3.getMessageId();
        String r1 = null;
        if (r0 != null) goto L5;
    L9:
        String r4 = r3.getLocalMessageId();
        if (r4 != null) goto L12;
    L14:
        if (r1 != null) goto L17;
        return NameKeys.UnloadStrategy_No_Strategy;
    L17:
        return r1;
    L12:
        if ((!StringsKt.isBlank(r4)) == false) goto L14;
        r1 = r4;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L9;
        return r0;
    }

    public static void a(String r5, String r6) {
        long r0 = System.currentTimeMillis();
        boolean r2 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L28;
        if (r6 != null) goto L12;
    L13:
        r2 = true;
    L14:
        if (r2 == true) goto L31;
        Object r3 = b;
        monitor-enter(r3);
        c(r0);     // Catch: Throwable -> L25
        a r7 = (a) ((LinkedHashMap) f).get(r5);     // Catch: Throwable -> L25
        if (r7 != null) goto L22;
        monitor-exit(r3);
        return;
    L22:
        b(r7, r6, r0);     // Catch: Throwable -> L25
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r3);
        return;
    L25:
        th = move-exception;
        throw th;
    L31:
        return;
    L12:
        if (StringsKt.isBlank(r6) == false) goto L14;
    L28:
        return;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r4 = false;
        goto L9
    }

    public static void f(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "identifier");
        Object r0 = b;
        monitor-enter(r0);
        c(r3);     // Catch: Throwable -> L10
        a r4 = (a) ((LinkedHashMap) g).get(r2);     // Catch: Throwable -> L10
        if (r4 == null) goto L7;
        r4.h = r3;     // Catch: Throwable -> L10
    L7:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void m(a r3, long r4) {
        String r0 = d(r3);
        String r1 = d(r3);
        switch(r1.hashCode()) {
            case -988775156: goto L18;
            case -693282640: goto L14;
            case 324501936: goto L10;
            case 446263587: goto L6;
            default: goto L21;
        };
    L21:
        String r2 = "semantic second query not sent";
    L22:
        l(r3, r4, r0, r2);
        return;
    L6:
        if (r1.equals("upload_timeout") == false) goto L21;
        r2 = "semantic image upload timeout";
        goto L22
    L10:
        if (r1.equals("semantic_prepare_timeout") == false) goto L21;
        r2 = "semantic prepare timeout";
        goto L22
    L14:
        if (r1.equals("restore_timeout") == false) goto L21;
        r2 = "semantic image restore timeout";
        goto L22
    L18:
        if (r1.equals("reply_timeout") == false) goto L21;
        r2 = "semantic reply timeout";
        goto L22
    }

    public static void b(a r5, String r6, long r7) {
        boolean r0 = false;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        r5.e = r6;
        g.put(r6, r5);
        b r8 = d.get(r6);
        if (r8 == null) goto L40;
        r5.f = r8.a;
        r5.g = r8.b;
        if (Intrinsics.areEqual(r8.d, Boolean.FALSE) == false) goto L41;
        String r3 = r8.e;
        if (r3 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        String r9 = null;
        if ((!r4) == true) goto L26;
        r3 = null;
    L26:
        if (r3 != null) goto L28;
        r3 = "upload_failed";
    L28:
        String r10 = r8.f;
        if (r10 != null) goto L31;
    L32:
        r0 = true;
    L34:
        if ((!r0) == false) goto L36;
        r9 = r10;
    L36:
        if (r9 != null) goto L38;
        r9 = "upload failed";
    L38:
        l(r5, r7, r3, r9);
        return;
    L31:
        if (StringsKt.isBlank(r10) == false) goto L34;
    L18:
        if (StringsKt.isBlank(r3) == true) goto L21;
        r4 = false;
        goto L22
    L41:
        return;
    L40:
        return;
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static String g(Message r13, String r14, int r15) {
        if ((r15 & 2) == 0) goto L6;
        r14 = null;
    L6:
        if ((r15 & 4) == 0) goto L8;
        long r4 = System.currentTimeMillis();
    L9:
        Intrinsics.checkNotNullParameter(r13, "firstQuery");
        String r8 = p(r13);
        String r16 = UUID.randomUUID().toString();
        Object r0 = b;
        monitor-enter(r0);
        c(r4);     // Catch: Throwable -> L37
        Iterator r6 = o(r13).iterator();     // Catch: Throwable -> L37
    L13:
        if (r6.hasNext() == false) goto L17;
        Long r7 = c.get((String) r6.next());     // Catch: Throwable -> L37
        if (r7 == null) goto L13;
    L18:
        if (r7 == null) goto L20;
        long r2 = r7.longValue();     // Catch: Throwable -> L37
    L32:
        long r9 = r2;
    L34:
        a r17 = new a(r16, r8, r9, r4);     // Catch: Throwable -> L37
        f.put(r16, r17);     // Catch: Throwable -> L37
        BuildersKt.launch$default(a, null, null, new SemanticTraceReporter$scheduleSessionExpiry$1(r16, null), 3, null);     // Catch: Throwable -> L37
        b(r17, r14, r4);     // Catch: Throwable -> L37
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r0);
        return r16;
    L20:
        Long r19 = Long.valueOf(r13.getCreateTime());     // Catch: Throwable -> L37
        if (r19.longValue() <= 0) goto L23;
        boolean r3 = true;
    L24:
        if (r3 == true) goto L27;
        r19 = null;
    L27:
        if (r19 == null) goto L29;
        Long r110 = Long.valueOf(r19.longValue() * 1000);     // Catch: Throwable -> L37
    L30:
        if (r110 == null) goto L33;
        r2 = r110.longValue();     // Catch: Throwable -> L37
        goto L32
    L33:
        r9 = r4;
        goto L34
    L29:
        r110 = null;
        goto L30
    L23:
        r3 = false;
        goto L24
    L17:
        r7 = null;
    L37:
        th = move-exception;
        throw th;
    L8:
        r4 = 0;
        goto L9
    }

    public static void i(String r7, String r8, String r9) {
        long r0 = System.currentTimeMillis();
        Object r2 = b;
        monitor-enter(r2);
        c(r0);     // Catch: Throwable -> L26
        boolean r4 = false;
        if (StringsKt.isBlank(r8) == false) goto L7;
        boolean r3 = true;
    L9:
        if ((!r3) == true) goto L12;
        r8 = null;
    L12:
        if (r8 != null) goto L15;
        r8 = "query_not_found";
    L15:
        if (StringsKt.isBlank(r9) == false) goto L18;
        r4 = true;
    L18:
        if ((!r4) == true) goto L21;
        r9 = null;
    L21:
        if (r9 != null) goto L23;
        r9 = "semantic query not found";
    L23:
        n(r7, r0, r8, r9);     // Catch: Throwable -> L26
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r2);
        return;
    L7:
        r3 = false;
    L26:
        th = move-exception;
        throw th;
    }

    public static void l(a r21, long r22, String r24, String r25) {
        if (r21.l == false) goto L5;
        return;
    L5:
        r21.l = true;
        long r4 = r21.k;
        long r6 = r21.f;
        long r8 = r21.g;
        if (r6 > 0) goto L8;
    L13:
        long r7 = -1;
    L14:
        long r9 = r21.h;
        long r14 = r21.i;
        if (r9 > 0) goto L17;
    L22:
        long r10 = -1;
    L23:
        JSONObject r15 = new JSONObject();
        r15.put("first_query_id", r21.b);
        r15.put("second_query_id", r21.j);
        r15.put("all_duration", RangesKt.coerceAtLeast(r22 - r21.c, 0));
        r15.put("to_semantic_duration", RangesKt.coerceAtLeast(r21.d - r21.c, 0));
        Long r2 = Long.valueOf(r4);
        if (r2.longValue() <= 0) goto L26;
        boolean r11 = true;
    L28:
        if (r11 == true) goto L31;
        r2 = null;
    L31:
        if (r2 == null) goto L33;
        long r17 = r2.longValue();
    L34:
        r15.put("prepare_duration", RangesKt.coerceAtLeast(r17 - r21.d, 0));
        r15.put("upload_duration", r7);
        r15.put("restore_duration", r10);
        if (r24 == null) goto L37;
    L39:
        long r3 = -1;
    L40:
        r15.put("thinking_duration", r3);
        if (r24 != null) goto L43;
    L46:
        boolean r5 = true;
    L47:
        if (r5 == true) goto L50;
        r15.put("err_code", r24);
    L50:
        if (r25 != null) goto L52;
    L55:
        boolean r12 = true;
    L56:
        if (r12 == true) goto L58;
        r15.put("err_msg", r25);
    L58:
        BuildersKt.launch$default(a, null, null, new SemanticTraceReporter$report$1(r15, null), 3, null);
        k(r21);
        return;
    L52:
        if (StringsKt.isBlank(r25) == true) goto L55;
        r12 = false;
        goto L56
    L43:
        if (StringsKt.isBlank(r24) == true) goto L46;
        r5 = false;
        goto L47
    L37:
        if (r4 <= 0) goto L39;
        r3 = RangesKt.coerceAtLeast(r22 - r4, 0);
        goto L40
    L33:
        r17 = r22;
        goto L34
    L26:
        r11 = false;
        goto L28
    L17:
        if (r14 <= 0) goto L22;
        if (r14 < r9) goto L22;
        r10 = RangesKt.coerceAtLeast(r14 - r9, 0);
        goto L23
    L8:
        if (r8 <= 0) goto L13;
        if (r8 < r6) goto L13;
        r7 = RangesKt.coerceAtLeast(r8 - r6, 0);
        goto L14
    }

    public static void n(String r8, long r9, String r11, String r12) {
        if (r8 != null) goto L5;
    L7:
        r8 = null;
    L8:
        if (r8 == null) goto L10;
        Long r1 = c.get(r8);
    L12:
        if (r1 == null) goto L14;
        long r10 = RangesKt.coerceAtLeast(r9 - r1.longValue(), 0);
    L15:
        JSONObject r2 = new JSONObject();
        if (r8 != null) goto L18;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        r2.put("first_query_id", r8);
        r2.put("second_query_id", NameKeys.UnloadStrategy_No_Strategy);
        r2.put("all_duration", r10);
        r2.put("to_semantic_duration", r10);
        r2.put("prepare_duration", 0);
        r2.put("upload_duration", -1);
        r2.put("restore_duration", -1);
        r2.put("thinking_duration", -1);
        r2.put("err_code", r11);
        r2.put("err_msg", r12);
        BuildersKt.launch$default(a, null, null, new SemanticTraceReporter$report$1(r2, null), 3, null);
        return;
    L14:
        r10 = -1;
        goto L15
    L10:
        r1 = null;
        goto L12
    L5:
        if ((!StringsKt.isBlank(r8)) == false) goto L7;
        goto L7
    }

    public static void h(String r6, String r7, String r8, String r9, int r10) {
        String r1 = null;
        if ((r10 & 2) == 0) goto L6;
        r7 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r8 = null;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r9 = null;
    L12:
        if ((r10 & 16) == 0) goto L14;
        long r2 = System.currentTimeMillis();
    L15:
        Object r11 = b;
        monitor-enter(r11);
        if (r6 != null) goto L58;
    L25:
        a r12 = null;
    L26:
        boolean r4 = false;
        if (r8 != null) goto L29;
    L32:
        boolean r5 = true;
    L34:
        if ((!r5) == true) goto L37;
        r8 = null;
    L37:
        if (r8 != null) goto L39;
        r8 = "semantic_failed";
    L39:
        if (r9 != null) goto L41;
    L42:
        r4 = true;
    L44:
        if ((true ^ r4) == false) goto L46;
        r1 = r9;
    L46:
        if (r1 != null) goto L48;
        r1 = "semantic screen qa failed";
    L48:
        if (r12 == null) goto L52;
        l(r12, r2, r8, r1);     // Catch: Throwable -> L50
        c(r2);     // Catch: Throwable -> L50
    L53:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L50
        monitor-exit(r11);
        return;
    L50:
        th = move-exception;
        throw th;
    L52:
        c(r2);     // Catch: Throwable -> L50
        n(r7, r2, r8, r1);     // Catch: Throwable -> L50
        goto L53
    L41:
        if (StringsKt.isBlank(r9) == false) goto L44;
    L29:
        if (StringsKt.isBlank(r8) == true) goto L32;
        r5 = false;
        goto L34
    L58:
        if ((!StringsKt.isBlank(r6)) == true) goto L23;
        r6 = null;
    L23:
        if (r6 == null) goto L25;
        r12 = (a) ((LinkedHashMap) f).get(r6);     // Catch: Throwable -> L50
        goto L26
    L14:
        r2 = 0;
        goto L15
    }

    public static void j(String r10, boolean r11, String r12, String r13, int r14) {
        String r1 = null;
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = null;
    L9:
        if ((r14 & 16) == 0) goto L11;
        long r4 = System.currentTimeMillis();
    L12:
        Intrinsics.checkNotNullParameter(r10, "identifier");
        Object r15 = b;
        monitor-enter(r15);
        c(r4);     // Catch: Throwable -> L52
        LinkedHashMap<String, b> r0 = d;     // Catch: Throwable -> L52
        b r6 = r0.get(r10);     // Catch: Throwable -> L52
        boolean r7 = false;
        if (r6 != null) goto L17;
        r6 = new b(0);     // Catch: Throwable -> L52
        r0.put(r10, r6);     // Catch: Throwable -> L52
    L17:
        b r8 = r6;     // Catch: Throwable -> L52
        if (r8.a > 0) goto L20;
        r8.a = r4;     // Catch: Throwable -> L52
    L20:
        r8.b = r4;     // Catch: Throwable -> L52
        r8.c = RangesKt.coerceAtLeast(r4 - r8.a, 0);     // Catch: Throwable -> L52
        r8.d = Boolean.valueOf(r11);     // Catch: Throwable -> L52
        r8.e = r12;     // Catch: Throwable -> L52
        r8.f = r13;     // Catch: Throwable -> L52
        a r16 = (a) ((LinkedHashMap) g).get(r10);     // Catch: Throwable -> L52
        if (r16 != null) goto L24;
        monitor-exit(r15);
        return;
    L24:
        r16.f = r8.a;     // Catch: Throwable -> L52
        r16.g = r8.b;     // Catch: Throwable -> L52
        if (r11 == false) goto L27;
    L49:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L52
        monitor-exit(r15);
        return;
    L27:
        if (r12 != null) goto L29;
    L32:
        boolean r2 = true;
    L34:
        if ((!r2) == true) goto L37;
        r12 = null;
    L37:
        if (r12 != null) goto L39;
        r12 = "upload_failed";
    L39:
        if (r13 != null) goto L41;
    L42:
        r7 = true;
    L44:
        if ((true ^ r7) == false) goto L46;
        r1 = r13;
    L46:
        if (r1 != null) goto L48;
        r1 = "upload failed";
    L48:
        l(r16, r4, r12, r1);     // Catch: Throwable -> L52
        goto L49
    L41:
        if (StringsKt.isBlank(r13) == false) goto L44;
    L29:
        if (StringsKt.isBlank(r12) == true) goto L32;
        r2 = false;
    L52:
        th = move-exception;
        throw th;
    L11:
        r4 = 0;
        goto L12
    }

    public static void e(String r9, boolean r10, String r11, String r12, long r13, int r15) {
        String r1 = null;
        if ((r15 & 4) == 0) goto L6;
        r11 = null;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r12 = null;
    L9:
        if ((r15 & 16) == 0) goto L11;
        r13 = System.currentTimeMillis();
    L11:
        Intrinsics.checkNotNullParameter(r9, "identifier");
        Object r16 = b;
        monitor-enter(r16);
        c(r13);     // Catch: Throwable -> L54
        a r14 = (a) ((LinkedHashMap) g).get(r9);     // Catch: Throwable -> L54
        if (r14 != null) goto L17;
        monitor-exit(r16);
        return;
    L17:
        Long r0 = Long.valueOf(r14.h);     // Catch: Throwable -> L54
        boolean r6 = false;
        if (r0.longValue() <= 0) goto L20;
        boolean r2 = true;
    L21:
        if (r2 == true) goto L24;
        r0 = null;
    L24:
        if (r0 == null) goto L26;
        long r3 = r0.longValue();     // Catch: Throwable -> L54
    L27:
        r14.h = r3;     // Catch: Throwable -> L54
        r14.i = r13;     // Catch: Throwable -> L54
        if (r10 == true) goto L51;
        if (r11 != null) goto L31;
    L34:
        boolean r17 = true;
    L36:
        if ((!r17) == true) goto L39;
        r11 = null;
    L39:
        if (r11 != null) goto L41;
        r11 = "restore_failed";
    L41:
        if (r12 != null) goto L43;
    L44:
        r6 = true;
    L46:
        if ((!r6) == false) goto L48;
        r1 = r12;
    L48:
        if (r1 != null) goto L50;
        r1 = "restore image failed";
    L50:
        l(r14, r13, r11, r1);     // Catch: Throwable -> L54
        goto L51
    L43:
        if (StringsKt.isBlank(r12) == false) goto L46;
    L31:
        if (StringsKt.isBlank(r11) == true) goto L34;
        r17 = false;
    L51:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L54
        monitor-exit(r16);
        return;
    L26:
        r3 = r13;
        goto L27
    L20:
        r2 = false;
    L54:
        th = move-exception;
        throw th;
    }
}
