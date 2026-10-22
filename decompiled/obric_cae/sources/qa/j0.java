package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f10610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile List<String> f10611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, b> f10612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Random f10613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<String, String> f10614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static List<t0> f10615f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f10618c;

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n0 f10619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f10620b;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashMap f10621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HashMap f10622b;

        public c() {
            this.f10621a = new HashMap(8);
            this.f10622b = new HashMap(8);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L5;
            return true;
        L5:
            if (r8 != null) goto L7;
            return false;
        L7:
            if (c.class != r8.getClass()) goto L18;
            c r10 = (c) r8;
            if (this.f10621a.equals(r10.f10621a) == true) goto L12;
            return false;
        L12:
            if (this.f10622b.equals(r10.f10622b) == false) goto L17;
            return true;
        L17:
            return false;
        L18:
            return false;
        }

        public final int hashCode() {
            HashMap r8 = this.f10621a;
            int r10 = 0;
            if (r8 == null) goto L5;
            int r11 = r8.hashCode();
        L6:
            HashMap r12 = this.f10622b;
            if (r12 == null) goto L10;
            r10 = r12.hashCode();
        L10:
            return r11 + r10;
        L5:
            r11 = 0;
            goto L6
        }
    }

    static {
        f10610a = new ConcurrentHashMap(8);
        f10611b = Collections.synchronizedList(new ArrayList(8));
        f10612c = new ConcurrentHashMap(8);
        f10613d = new Random();
        f10614e = new ConcurrentHashMap(8);
        f10615f = Collections.synchronizedList(new ArrayList(16));
    }

    public static synchronized void a(String r8) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<qa.j0> r0 = qa.j0.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, qa.j0$c> r1 = qa.j0.f10610a     // Catch: java.lang.Throwable -> L32
            boolean r1 = r1.containsKey(r4)     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L10
            java.util.concurrent.ConcurrentHashMap<java.lang.String, qa.j0$c> r1 = qa.j0.f10610a     // Catch: java.lang.Throwable -> L32
            r1.remove(r4)     // Catch: java.lang.Throwable -> L32
        L10:
            android.content.Context r1 = qa.i4.f10543c     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = "Yb3Blbl9odHRwX2NvbnRyb2w"
            android.content.SharedPreferences$Editor r1 = qa.z.b(r1, r2)     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L2d
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L21
            goto L2d
        L21:
            r1.remove(r4)     // Catch: java.lang.Throwable -> L25
            goto L2d
        L25:
            r4 = move-exception
            java.lang.String r2 = "sp"
            java.lang.String r3 = "rk"
            qa.l.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L32
        L2d:
            qa.z.e(r1)     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)
            return
        L32:
            r4 = move-exception
            java.lang.String r1 = "hlUtil"
            java.lang.String r2 = "rc"
            qa.l.a(r1, r2, r4)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r0)
            return
        L3c:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: qa.j0.a(java.lang.String):void");
    }

    public static void b(String r8, String r10, int r11, boolean r12) {
        Context r13 = i4.f10543c;     // Catch: Throwable -> L35
        if (r13 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L43;
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L35
        r14.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L35
        String r15 = qa.b.a(r8);     // Catch: Throwable -> L35
        if (r12 == false) goto L12;
        String r16 = "type";
        Integer r17 = qa.b.f10227h;     // Catch: Throwable -> L35
    L13:
        r14.put(r16, r17);     // Catch: Throwable -> L35
        r14.put(QesdkUtils.TAGS.JSON_TAG_NAME, r8);     // Catch: Throwable -> L35
        r14.put("version", r15);     // Catch: Throwable -> L35
        r14.put("uri", Uri.parse(r10).getPath());     // Catch: Throwable -> L35
        r14.put("blockLevel", r11);     // Catch: Throwable -> L35
        String r18 = r14.toString();     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r18) == false) goto L16;
        return;
    L16:
        t0 r19 = new t0(r13, "core", "2.0", "O005");     // Catch: Throwable -> L35
        r19.a(r18);     // Catch: Throwable -> L35
        if (f10615f != null) goto L19;
        f10615f = Collections.synchronizedList(new ArrayList(16));     // Catch: Throwable -> L35
    L19:
        List<t0> r20 = f10615f;     // Catch: Throwable -> L35
        monitor-enter(r20);     // Catch: Throwable -> L35
        f10615f.add(r19);     // Catch: Throwable -> L30
        if (f10615f.size() >= 15) goto L36;
    L28:
        monitor-exit(r20);     // Catch: Throwable -> L30
        return;
        goto L44
    L36:
        Context r21 = i4.f10543c;     // Catch: Throwable -> L34
        if (r21 == null) goto L28;
        u0.a(r21, l());     // Catch: Throwable -> L34
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
        goto L44
    L12:
        r16 = "type";
        r17 = qa.b.f10226g;     // Catch: Throwable -> L35
        goto L13
    L43:
        return;
    }

    public static void c(String r8, String r10, String r11) {
        Context r12 = i4.f10543c;     // Catch: Throwable -> L27
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L8;
        return;
    L8:
        if (f10614e != null) goto L10;
        f10614e = new ConcurrentHashMap(8);     // Catch: Throwable -> L27
    L10:
        ConcurrentHashMap<String, String> r13 = f10614e;     // Catch: Throwable -> L27
        monitor-enter(r13);     // Catch: Throwable -> L27
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L13:
        if (f10614e.containsKey(r10) == false) goto L16;
        monitor-exit(r13);     // Catch: Throwable -> L23
        return;
    L16:
        f10614e.put(r10, r11);     // Catch: Throwable -> L23
        monitor-exit(r13);     // Catch: Throwable -> L23
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L27
        r14.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L27
        r14.put("type", qa.b.f10228i);     // Catch: Throwable -> L27
        r14.put(QesdkUtils.TAGS.JSON_TAG_NAME, r8);     // Catch: Throwable -> L27
        r14.put("version", qa.b.a(r8));     // Catch: Throwable -> L27
        r14.put("hostname", r10 + "#" + r11);     // Catch: Throwable -> L27
        String r15 = r14.toString();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r15) == false) goto L21;
        return;
    L21:
        t0 r16 = new t0(r12, "core", "2.0", "O005");     // Catch: Throwable -> L27
        r16.a(r15);     // Catch: Throwable -> L27
        u0.c(r16, r12);     // Catch: Throwable -> L27
        return;
    }

    public static void d(String r10, JSONObject r11) {
        c r8 = new c();     // Catch: Throwable -> L32
        g(r8, r11);     // Catch: Throwable -> L32
        JSONObject r12 = r11.optJSONObject("domainMap");     // Catch: Throwable -> L16
        if (r12 == null) goto L19;
        JSONArray r13 = r12.names();     // Catch: Throwable -> L16
        if (r13 == null) goto L19;
        HashMap r14 = new HashMap(8);     // Catch: Throwable -> L16
        int r15 = r13.length();     // Catch: Throwable -> L16
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L14;
        String r17 = r13.optString(r16);     // Catch: Throwable -> L16
        r14.put(r17, r12.optString(r17));     // Catch: Throwable -> L16
        r16 = r16 + 1;     // Catch: Throwable -> L16
        goto L12
    L14:
        r8.f10622b = r14;     // Catch: Throwable -> L16
    L19:
        if (r8.f10622b == null) goto L21;
    L36:
    L29:
        th = move-exception;
        l.a("hlUtil", "ucr", th);     // Catch: Throwable -> L32
        return;
    L25:
        if (f10610a != null) goto L27;
        f10610a = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L27:
        f10610a.put(r10, r8);     // Catch: Throwable -> L29
        goto L40
    L39:
        return;
    L21:
        if (r8.f10621a != null) goto L36;
        a(r10);     // Catch: Throwable -> L32
        return;
    L16:
        th = move-exception;
        l.a("hlUtil", "pdr", th);     // Catch: Throwable -> L32
    }

    public static void e(String r8, boolean r10) {
        Context r11 = i4.f10543c;     // Catch: Throwable -> L15
        if (r11 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L19;
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L15
        r12.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L15
        if (r10 == false) goto L12;
        Integer r13 = qa.b.f10225f;     // Catch: Throwable -> L15
    L11:
        r12.put("type", r13);     // Catch: Throwable -> L15
        r12.put(QesdkUtils.TAGS.JSON_TAG_NAME, r8);     // Catch: Throwable -> L15
        r12.put("version", qa.b.a(r8));     // Catch: Throwable -> L15
        String r14 = r12.toString();     // Catch: Throwable -> L15
        t0 r15 = new t0(r11, "core", "2.0", "O005");     // Catch: Throwable -> L15
        r15.a(r14);     // Catch: Throwable -> L15
        u0.c(r15, r11);     // Catch: Throwable -> L15
        return;
    L12:
        r13 = qa.b.f10224e;     // Catch: Throwable -> L15
        goto L11
    L19:
        return;
    }

    public static void f(URL r10, n0 r11) {
        if (f10612c != null) goto L6;
        f10612c = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L6:
        Map<String, List<String>> r8 = r11.f10843b;     // Catch: Throwable -> L29
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.containsKey("nb") == false) goto L32;
        List<String> r12 = r11.f10843b.get("nb");     // Catch: Throwable -> L29
        if (r12 != null) goto L13;
        return;
    L13:
        if (r12.size() <= 0) goto L34;
        String[] r13 = r12.get(0).split("#");     // Catch: Throwable -> L29
        if (r13.length >= 2) goto L18;
        return;
    L18:
        int r14 = Integer.parseInt(r13[0]);     // Catch: Throwable -> L29
        long r15 = Integer.parseInt(r13[1]);     // Catch: Throwable -> L29
        b r16 = new b();     // Catch: Throwable -> L29
        r16.f10619a = r11;     // Catch: Throwable -> L29
        if (r15 > 0) goto L21;
        r15 = 30;
    L21:
        r16.f10620b = (r15 * 1000) + SystemClock.elapsedRealtime();     // Catch: Throwable -> L29
        if (r14 != 1) goto L25;
        f10612c.put("app", r16);     // Catch: Throwable -> L29
        return;
    L25:
        if (r14 != 2) goto L35;
        if (r10 == null) goto L36;
        f10612c.put(r10.getPath(), r16);     // Catch: Throwable -> L29
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L32:
        return;
    }

    public static void g(c r12, JSONObject r13) {
        JSONArray r14 = r13.optJSONArray("block");     // Catch: Throwable -> L30
        if (r14 != null) goto L6;
        return;
    L6:
        HashMap r8 = new HashMap(8);     // Catch: Throwable -> L30
        int r10 = 0;
    L8:
        if (r10 >= r14.length()) goto L28;
        JSONObject r11 = r14.optJSONObject(r10);     // Catch: Throwable -> L30
        if (r11 == null) goto L27;
        String r15 = r11.optString("api");     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r15) == true) goto L27;
        if (r15.startsWith("/") == true) goto L17;
        r15 = "/".concat(r15);     // Catch: Throwable -> L30
    L17:
        if (r15.endsWith("/") == false) goto L19;
        r15 = r15.substring(0, r15.length() - 1);     // Catch: Throwable -> L30
    L19:
        JSONArray r16 = r11.optJSONArray("periods");     // Catch: Throwable -> L30
        ArrayList r17 = new ArrayList();     // Catch: Throwable -> L30
        int r18 = 0;
    L21:
        if (r18 >= r16.length()) goto L26;
        JSONObject r19 = r16.optJSONObject(r18);     // Catch: Throwable -> L30
        if (r19 == null) goto L25;
        a r20 = new a();     // Catch: Throwable -> L30
        r20.f10616a = r19.optString("begin");     // Catch: Throwable -> L30
        r20.f10617b = r19.optInt("duration");     // Catch: Throwable -> L30
        r20.f10618c = r19.optDouble("percent");     // Catch: Throwable -> L30
        r17.add(r20);     // Catch: Throwable -> L30
    L25:
        r18 = r18 + 1;     // Catch: Throwable -> L30
        goto L21
    L26:
        r8.put(r15, r17);     // Catch: Throwable -> L30
    L27:
        r10 = r10 + 1;     // Catch: Throwable -> L30
        goto L8
    L28:
        r12.f10621a = r8;     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        l.a("hlUtil", "pbr", th);
    }

    public static synchronized void h(s4 r8, JSONObject r10) {
        monitor-enter(j0.class);
        if (r8 != null) goto L30;
        monitor-exit(j0.class);
        return;
    L30:
        String r11 = r8.a();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r11) == false) goto L11;
        monitor-exit(j0.class);
        return;
    L11:
        if (r10 != null) goto L14;
        a(r11);     // Catch: Throwable -> L21
    L14:
        if (i4.o(r10.optString("able", null), false) == true) goto L18;
        a(r11);     // Catch: Throwable -> L21
        monitor-exit(j0.class);
        return;
    L18:
        z.d(i4.f10543c, "Yb3Blbl9odHRwX2NvbnRyb2w", r11, r10.toString());     // Catch: Throwable -> L21
        d(r11, r10);     // Catch: Throwable -> L21
        monitor-exit(j0.class);
        return;
    L21:
        th = move-exception;
        l.a("hlUtil", "par", th);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public static boolean i(String r8, c r10, String r11) {
        HashMap r12 = r10.f10621a;     // Catch: Throwable -> L24
        if (r12 != null) goto L6;
    L23:
        return false;
    L6:
        if (r12.size() <= 0) goto L23;
        if (r12.containsKey("*") == false) goto L17;
        Iterator r13 = r12.entrySet().iterator();     // Catch: Throwable -> L24
    L12:
        if (r13.hasNext() == false) goto L26;
        if (j((List) ((Map.Entry) r13.next()).getValue()) == false) goto L12;
        b(r11, r8, 1, false);     // Catch: Throwable -> L24
        return true;
    L26:
        return false;
    L17:
        String r14 = Uri.parse(r8).getPath();     // Catch: Throwable -> L24
        if (r12.containsKey(r14) == false) goto L26;
        if (j((List) r12.get(r14)) == false) goto L26;
        b(r11, r8, 2, false);     // Catch: Throwable -> L24
        return true;
    L24:
        th = move-exception;
        l.a("hlUtil", "inb", th);
        goto L26
    }

    public static boolean j(List<a> r17) {
        if (r17 != null) goto L5;
    L40:
        return false;
    L5:
        if (r17.size() <= 0) goto L40;
        Iterator<a> r8 = r17.iterator();
    L9:
        if (r8.hasNext() == false) goto L40;
        a r10 = r8.next();
        if (r10 != null) goto L14;
    L12:
        boolean r11 = false;
    L38:
        if (r11 == false) goto L9;
        return true;
    L14:
        if (r10.f10618c == 1.0d) goto L12;
        long r12 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r10.f10616a) == true) goto L12;
        if (r10.f10617b <= 0) goto L12;
        String r13 = r10.f10616a;
        String[] r14 = t4.f11124a;
        SimpleDateFormat r15 = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);     // Catch: ParseException -> L23
        Calendar r16 = Calendar.getInstance();     // Catch: ParseException -> L23
        Calendar r18 = Calendar.getInstance();     // Catch: ParseException -> L23
        r18.setTime(r15.parse(r13));     // Catch: ParseException -> L23
        r16.set(r16.get(1), r16.get(2), r16.get(5), r18.get(11), r18.get(12), r18.get(13));     // Catch: ParseException -> L23
    L25:
        long r19 = r12 - r16.getTimeInMillis();
        if (r19 <= 0) goto L12;
        if (r19 >= (r10.f10617b * 1000)) goto L12;
        if (r10.f10618c != 0.0d) goto L33;
    L31:
        r11 = true;
        goto L38
    L33:
        if (f10613d != null) goto L35;
        f10613d = new Random();
    L35:
        f10613d.setSeed(((long) UUID.randomUUID().hashCode()) + r12);
        if (f10613d.nextDouble() <= r10.f10618c) goto L12;
    L23:
        e = move-exception;
        l.a("ut", "ctt", e);
        r16 = null;
        goto L25
    }

    public static String k(String r8, c r10, String r11) {
        HashMap r12 = r10.f10622b;     // Catch: Throwable -> L12
        if (r12 != null) goto L5;
    L11:
        return r8;
    L5:
        if (r12.size() <= 0) goto L11;
        Uri r13 = Uri.parse(r8);     // Catch: Throwable -> L12
        String r14 = r13.getAuthority();     // Catch: Throwable -> L12
        if (r12.containsKey(r14) == false) goto L17;
        String r15 = (String) r12.get(r14);     // Catch: Throwable -> L12
        r8 = r13.buildUpon().authority(r15).toString();     // Catch: Throwable -> L12
        c(r11, r14, r15);     // Catch: Throwable -> L12
        return r8;
    L17:
        return r8;
    L12:
        th = move-exception;
        l.a("hlUtil", "pdr", th);
        return r8;
    }

    public static ArrayList l() {
        ArrayList r8 = null;
        List<t0> r10 = f10615f;     // Catch: Throwable -> L20
        monitor-enter(r10);     // Catch: Throwable -> L20
        List<t0> r11 = f10615f;     // Catch: Throwable -> L16
        if (r11 != null) goto L8;
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L16
        goto L19
    L8:
        if (r11.size() <= 0) goto L14;
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L16
        r12.addAll(f10615f);     // Catch: Throwable -> L12
        f10615f.clear();     // Catch: Throwable -> L12
        r8 = r12;
    L12:
        th = move-exception;
        th = th;
        r8 = r12;
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L20
    L16:
        th = th;
    L19:
        return r8;
    }

    public static n0 m(String r8, String r10) {
        String r11 = "app";
        if (f10612c != null) goto L7;
        return null;
    L7:
        if (f10612c.containsKey("app") == false) goto L14;
        b r12 = f10612c.get("app");     // Catch: Throwable -> L25
        if (SystemClock.elapsedRealtime() > r12.f10620b) goto L12;
        n0 r13 = r12.f10619a;     // Catch: Throwable -> L25
        b(r10, r8, 1, true);     // Catch: Throwable -> L25
        return r13;
    L12:
        f10612c.remove(r11);     // Catch: Throwable -> L25
        goto L24
    L14:
        if (TextUtils.isEmpty(r8) == false) goto L16;
        return null;
    L16:
        Uri r14 = Uri.parse(r8);     // Catch: Throwable -> L25
        if (r14 == null) goto L24;
        r11 = r14.getPath();     // Catch: Throwable -> L25
        if (f10612c.containsKey(r11) == false) goto L24;
        b r15 = f10612c.get(r11);     // Catch: Throwable -> L25
        if (SystemClock.elapsedRealtime() > r15.f10620b) goto L12;
        n0 r16 = r15.f10619a;     // Catch: Throwable -> L25
        b(r10, r8, 2, true);     // Catch: Throwable -> L25
        return r16;
    L24:
        return null;
    }
}
