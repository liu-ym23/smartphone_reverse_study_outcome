package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.miui.easygo.constant.EasyGoDbTable;
import com.monitor.cloudmessage.consts.CloudControlInf;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k0 {
    public static volatile ConcurrentHashMap<String, c> a;
    public static volatile List<String> b;
    public static volatile ConcurrentHashMap<String, b> c;
    public static Random d;
    public static ConcurrentHashMap<String, String> e;
    public static List<r0> f;

    public static class a {
        public String a;
        public int b;
        public double c;

        public a() {
        }
    }

    public static class b {
        public l0 a;
        public long b;

        public b() {
        }
    }

    public static class c {
        public Map<String, List<a>> a;
        public Map<String, String> b;

        public c() {
            this.a = new HashMap(8);
            this.b = new HashMap(8);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L15:
            return false;
        L8:
            if (c.class != r5.getClass()) goto L15;
            c r6 = (c) r5;
            if (this.a.equals(r6.a) == false) goto L15;
            if (this.b.equals(r6.b) == false) goto L15;
            return true;
        }

        public final int hashCode() {
            Map<String, List<a>> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            Map<String, String> r3 = this.b;
            if (r3 == null) goto L10;
            r1 = r3.hashCode();
        L10:
            return r2 + r1;
        L5:
            r2 = 0;
            goto L6
        }
    }

    static {
        a = new ConcurrentHashMap(8);
        b = Collections.synchronizedList(new ArrayList(8));
        c = new ConcurrentHashMap(8);
        d = new Random();
        e = new ConcurrentHashMap(8);
        f = Collections.synchronizedList(new ArrayList(16));
    }

    public static void b(String r5, String r6, String r7) {
        Context r0 = com.loc.i.c;     // Catch: Throwable -> L27
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return;
    L8:
        if (e != null) goto L10;
        e = new ConcurrentHashMap(8);     // Catch: Throwable -> L27
    L10:
        ConcurrentHashMap<String, String> r1 = e;     // Catch: Throwable -> L27
        monitor-enter(r1);     // Catch: Throwable -> L27
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L13:
        if (e.containsKey(r6) == false) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L23
        return;
    L16:
        e.put(r6, r7);     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L27
        r2.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L27
        r2.put("type", n4a.c.i);     // Catch: Throwable -> L27
        r2.put(EasyGoDbTable.Server.NAME, r5);     // Catch: Throwable -> L27
        r2.put("version", n4a.c.a(r5));     // Catch: Throwable -> L27
        r2.put("hostname", r6 + "#" + r7);     // Catch: Throwable -> L27
        String r8 = r2.toString();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r8) == false) goto L21;
        return;
    L21:
        r0 r9 = new r0(r0, "core", "2.0", "O005");     // Catch: Throwable -> L27
        r9.a(r8);     // Catch: Throwable -> L27
        s0.c(r9, r0);     // Catch: Throwable -> L27
        return;
    }

    public static synchronized void f(e5 r4, JSONObject r5) {
        monitor-enter(k0.class);
        if (r4 != null) goto L30;
        monitor-exit(k0.class);
        return;
    L30:
        String r6 = r4.a();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r6) == false) goto L11;
        monitor-exit(k0.class);
        return;
    L11:
        if (r5 != null) goto L14;
        a(r6);     // Catch: Throwable -> L21
    L14:
        if (com.loc.i.o(r5.optString("able", null), false) == true) goto L18;
        a(r6);     // Catch: Throwable -> L21
        monitor-exit(k0.class);
        return;
    L18:
        y.d(com.loc.i.c, "Yb3Blbl9odHRwX2NvbnRyb2w", r6, r5.toString());     // Catch: Throwable -> L21
        c(r6, r5);     // Catch: Throwable -> L21
        monitor-exit(k0.class);
        return;
    L21:
        th = move-exception;
        n.a(th, "hlUtil", "par");     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public static void g(boolean r5, String r6) {
        Context r0 = com.loc.i.c;     // Catch: Throwable -> L15
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L19;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L15
        r1.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L15
        if (r5 == false) goto L12;
        Integer r7 = n4a.c.f;     // Catch: Throwable -> L15
    L11:
        r1.put("type", r7);     // Catch: Throwable -> L15
        r1.put(EasyGoDbTable.Server.NAME, r6);     // Catch: Throwable -> L15
        r1.put("version", n4a.c.a(r6));     // Catch: Throwable -> L15
        String r8 = r1.toString();     // Catch: Throwable -> L15
        r0 r9 = new r0(r0, "core", "2.0", "O005");     // Catch: Throwable -> L15
        r9.a(r8);     // Catch: Throwable -> L15
        s0.c(r9, r0);     // Catch: Throwable -> L15
        return;
    L12:
        r7 = n4a.c.e;     // Catch: Throwable -> L15
        goto L11
    L19:
        return;
    }

    public static boolean i(String r4, c r5, String r6) {
        Map<String, List<a>> r7 = r5.a;     // Catch: Throwable -> L24
        if (r7 == null) goto L23;
        HashMap r8 = (HashMap) r7;     // Catch: Throwable -> L24
        if (r8.size() <= 0) goto L23;
        if (r8.containsKey("*") == false) goto L17;
        Iterator r9 = r8.entrySet().iterator();     // Catch: Throwable -> L24
    L12:
        if (r9.hasNext() == false) goto L26;
        if (j((List) ((Map.Entry) r9.next()).getValue()) == false) goto L12;
        h(false, r6, r4, 1);     // Catch: Throwable -> L24
        return true;
    L26:
        return false;
    L17:
        String r1 = UriProtector.parse(r4).getPath();     // Catch: Throwable -> L24
        if (r8.containsKey(r1) == false) goto L26;
        if (j((List) r8.get(r1)) == false) goto L26;
        h(false, r6, r4, 2);     // Catch: Throwable -> L24
        return true;
    L23:
        return false;
    L24:
        th = move-exception;
        n.a(th, "hlUtil", "inb");
        goto L26
    }

    public static String k(String r3, c r4, String r5) {
        Map<String, String> r6 = r4.b;     // Catch: Throwable -> L12
        if (r6 == null) goto L11;
        HashMap r7 = (HashMap) r6;     // Catch: Throwable -> L12
        if (r7.size() <= 0) goto L11;
        Uri r0 = UriProtector.parse(r3);     // Catch: Throwable -> L12
        String r1 = r0.getAuthority();     // Catch: Throwable -> L12
        if (r7.containsKey(r1) == false) goto L17;
        String r8 = (String) r7.get(r1);     // Catch: Throwable -> L12
        r3 = r0.buildUpon().authority(r8).toString();     // Catch: Throwable -> L12
        b(r5, r1, r8);     // Catch: Throwable -> L12
        return r3;
    L17:
        return r3;
    L11:
        return r3;
    L12:
        th = move-exception;
        n.a(th, "hlUtil", "pdr");
        return r3;
    }

    public static List<r0> l() {
        ArrayList r0 = null;
        List<r0> r1 = f;     // Catch: Throwable -> L22
        monitor-enter(r1);     // Catch: Throwable -> L22
        List<r0> r2 = f;     // Catch: Throwable -> L14
        if (r2 != null) goto L8;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r0;
    L8:
        if (r2.size() <= 0) goto L12;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L14
        r3.addAll(f);     // Catch: Throwable -> L19
        f.clear();     // Catch: Throwable -> L19
        r0 = r3;
        goto L12
    L31:
        Throwable th = th;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L18
    L21:
        return r3;
    L19:
        th = th;
    L14:
        th = move-exception;
        r3 = r0;
        th = th;
    L34:
        return null;
    }

    public static l0 m(String r9, String r10) {
        String r0 = "app";
        if (c != null) goto L7;
        return null;
    L7:
        if (c.containsKey("app") == false) goto L14;
        b r2 = c.get("app");     // Catch: Throwable -> L25
        if (SystemClock.elapsedRealtime() > r2.b) goto L12;
        l0 r1 = r2.a;     // Catch: Throwable -> L25
        h(true, r10, r9, 1);     // Catch: Throwable -> L25
        return r1;
    L12:
        c.remove(r0);     // Catch: Throwable -> L25
        goto L24
    L14:
        if (TextUtils.isEmpty(r9) == false) goto L16;
        return null;
    L16:
        Uri r3 = UriProtector.parse(r9);     // Catch: Throwable -> L25
        if (r3 == null) goto L24;
        r0 = r3.getPath();     // Catch: Throwable -> L25
        if (c.containsKey(r0) == false) goto L24;
        b r4 = c.get(r0);     // Catch: Throwable -> L25
        if (SystemClock.elapsedRealtime() > r4.b) goto L12;
        l0 r5 = r4.a;     // Catch: Throwable -> L25
        h(true, r10, r9, 2);     // Catch: Throwable -> L25
        return r5;
    L24:
        return null;
    }

    public static synchronized void a(String r4) {
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
            java.lang.Class<n4a.k0> r0 = n4a.k0.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, n4a.k0$c> r1 = n4a.k0.a     // Catch: java.lang.Throwable -> L32
            boolean r1 = r1.containsKey(r4)     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L10
            java.util.concurrent.ConcurrentHashMap<java.lang.String, n4a.k0$c> r1 = n4a.k0.a     // Catch: java.lang.Throwable -> L32
            r1.remove(r4)     // Catch: java.lang.Throwable -> L32
        L10:
            android.content.Context r1 = com.loc.i.c     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = "Yb3Blbl9odHRwX2NvbnRyb2w"
            android.content.SharedPreferences$Editor r1 = n4a.y.b(r1, r2)     // Catch: java.lang.Throwable -> L32
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
            n4a.n.a(r4, r2, r3)     // Catch: java.lang.Throwable -> L32
        L2d:
            n4a.y.e(r1)     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)
            return
        L32:
            r4 = move-exception
            java.lang.String r1 = "hlUtil"
            java.lang.String r2 = "rc"
            n4a.n.a(r4, r1, r2)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r0)
            return
        L3c:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n4a.k0.a(java.lang.String):void");
    }

    public static boolean j(List<a> r17) {
        if (r17 != null) goto L5;
    L40:
        return false;
    L5:
        if (r17.size() <= 0) goto L40;
        Iterator<a> r2 = r17.iterator();
    L9:
        if (r2.hasNext() == false) goto L40;
        a r3 = r2.next();
        if (r3 != null) goto L14;
    L12:
        boolean r0 = false;
    L38:
        if (r0 == false) goto L9;
        return true;
    L14:
        if (r3.c == 1.0d) goto L12;
        long r5 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r3.a) == true) goto L12;
        if (r3.b <= 0) goto L12;
        String r1 = r3.a;
        String[] r8 = f5.a;
        SimpleDateFormat r9 = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);     // Catch: ParseException -> L23
        Calendar r7 = Calendar.getInstance();     // Catch: ParseException -> L23
        Calendar r10 = Calendar.getInstance();     // Catch: ParseException -> L23
        r10.setTime(r9.parse(r1));     // Catch: ParseException -> L23
        r7.set(r7.get(1), r7.get(2), r7.get(5), r10.get(11), r10.get(12), r10.get(13));     // Catch: ParseException -> L23
    L25:
        long r11 = r5 - r7.getTimeInMillis();
        if (r11 <= 0) goto L12;
        if (r11 >= (r3.b * 1000)) goto L12;
        if (r3.c != 0.0d) goto L33;
    L31:
        r0 = true;
        goto L38
    L33:
        if (d != null) goto L35;
        d = new Random();
    L35:
        d.setSeed(((long) UUID.randomUUID().hashCode()) + r5);
        if (d.nextDouble() <= r3.c) goto L12;
    L23:
        e = move-exception;
        n.a(e, "ut", "ctt");
        r7 = null;
        goto L25
    }

    public static void c(String r9, JSONObject r10) {
        c r1 = new c();     // Catch: Throwable -> L32
        e(r1, r10);     // Catch: Throwable -> L32
        JSONObject r11 = r10.optJSONObject("domainMap");     // Catch: Throwable -> L16
        if (r11 == null) goto L19;
        JSONArray r3 = r11.names();     // Catch: Throwable -> L16
        if (r3 == null) goto L19;
        HashMap r4 = new HashMap(8);     // Catch: Throwable -> L16
        int r5 = r3.length();     // Catch: Throwable -> L16
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L14;
        String r7 = r3.optString(r6);     // Catch: Throwable -> L16
        r4.put(r7, r11.optString(r7));     // Catch: Throwable -> L16
        r6 = r6 + 1;     // Catch: Throwable -> L16
        goto L12
    L14:
        r1.b = r4;     // Catch: Throwable -> L16
    L19:
        if (r1.b == null) goto L21;
    L36:
    L29:
        th = move-exception;
        n.a(th, "hlUtil", "ucr");     // Catch: Throwable -> L32
        return;
    L25:
        if (a != null) goto L27;
        a = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L27:
        a.put(r9, r1);     // Catch: Throwable -> L29
        goto L40
    L39:
        return;
    L21:
        if (r1.a != null) goto L36;
        a(r9);     // Catch: Throwable -> L32
        return;
    L16:
        th = move-exception;
        n.a(th, "hlUtil", "pdr");     // Catch: Throwable -> L32
    }

    public static void d(URL r10, l0 r11) {
        if (c != null) goto L6;
        c = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L6:
        Map<String, List<String>> r1 = r11.b;     // Catch: Throwable -> L29
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.containsKey("nb") == false) goto L32;
        List<String> r0 = r11.b.get("nb");     // Catch: Throwable -> L29
        if (r0 != null) goto L13;
        return;
    L13:
        if (r0.size() <= 0) goto L34;
        String[] r2 = ((String) ListProtector.get(r0, 0)).split("#");     // Catch: Throwable -> L29
        if (r2.length >= 2) goto L18;
        return;
    L18:
        int r3 = CastIntegerProtector.parseInt(r2[0]);     // Catch: Throwable -> L29
        long r4 = CastIntegerProtector.parseInt(r2[1]);     // Catch: Throwable -> L29
        b r5 = new b();     // Catch: Throwable -> L29
        r5.a = r11;     // Catch: Throwable -> L29
        if (r4 > 0) goto L21;
        r4 = 30;
    L21:
        r5.b = SystemClock.elapsedRealtime() + (r4 * 1000);     // Catch: Throwable -> L29
        if (r3 != 1) goto L25;
        c.put("app", r5);     // Catch: Throwable -> L29
        return;
    L25:
        if (r3 != 2) goto L35;
        if (r10 == null) goto L36;
        c.put(r10.getPath(), r5);     // Catch: Throwable -> L29
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

    public static void e(c r12, JSONObject r13) {
        JSONArray r14 = r13.optJSONArray("block");     // Catch: Throwable -> L30
        if (r14 != null) goto L6;
        return;
    L6:
        HashMap r1 = new HashMap(8);     // Catch: Throwable -> L30
        int r3 = 0;
    L8:
        if (r3 >= r14.length()) goto L28;
        JSONObject r4 = r14.optJSONObject(r3);     // Catch: Throwable -> L30
        if (r4 == null) goto L27;
        String r5 = r4.optString("api");     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r5) == true) goto L27;
        if (r5.startsWith("/") == true) goto L17;
        r5 = "/".concat(r5);     // Catch: Throwable -> L30
    L17:
        if (r5.endsWith("/") == false) goto L19;
        r5 = r5.substring(0, r5.length() - 1);     // Catch: Throwable -> L30
    L19:
        JSONArray r6 = r4.optJSONArray("periods");     // Catch: Throwable -> L30
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L30
        int r8 = 0;
    L21:
        if (r8 >= r6.length()) goto L26;
        JSONObject r9 = r6.optJSONObject(r8);     // Catch: Throwable -> L30
        if (r9 == null) goto L25;
        a r10 = new a();     // Catch: Throwable -> L30
        r10.a = r9.optString("begin");     // Catch: Throwable -> L30
        r10.b = r9.optInt("duration");     // Catch: Throwable -> L30
        r10.c = r9.optDouble("percent");     // Catch: Throwable -> L30
        r7.add(r10);     // Catch: Throwable -> L30
    L25:
        r8 = r8 + 1;     // Catch: Throwable -> L30
        goto L21
    L26:
        r1.put(r5, r7);     // Catch: Throwable -> L30
    L27:
        r3 = r3 + 1;     // Catch: Throwable -> L30
        goto L8
    L28:
        r12.a = r1;     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        n.a(th, "hlUtil", "pbr");
    }

    public static void h(boolean r5, String r6, String r7, int r8) {
        Context r0 = com.loc.i.c;     // Catch: Throwable -> L35
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L42;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L35
        r1.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L35
        String r2 = n4a.c.a(r6);     // Catch: Throwable -> L35
        if (r5 == false) goto L12;
        String r9 = "type";
        Integer r3 = n4a.c.h;     // Catch: Throwable -> L35
    L13:
        r1.put(r9, r3);     // Catch: Throwable -> L35
        r1.put(EasyGoDbTable.Server.NAME, r6);     // Catch: Throwable -> L35
        r1.put("version", r2);     // Catch: Throwable -> L35
        r1.put(LynxResourceModule.URI_KEY, UriProtector.parse(r7).getPath());     // Catch: Throwable -> L35
        r1.put("blockLevel", r8);     // Catch: Throwable -> L35
        String r10 = r1.toString();     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r10) == false) goto L16;
        return;
    L16:
        r0 r11 = new r0(r0, "core", "2.0", "O005");     // Catch: Throwable -> L35
        r11.a(r10);     // Catch: Throwable -> L35
        if (f != null) goto L19;
        f = Collections.synchronizedList(new ArrayList(16));     // Catch: Throwable -> L35
    L19:
        List<r0> r12 = f;     // Catch: Throwable -> L35
        monitor-enter(r12);     // Catch: Throwable -> L35
        f.add(r11);     // Catch: Throwable -> L30
        if (f.size() >= 15) goto L37;
    L28:
        monitor-exit(r12);     // Catch: Throwable -> L30
        return;
        goto L43
    L37:
        Context r13 = com.loc.i.c;     // Catch: Throwable -> L34
        if (r13 == null) goto L28;
        s0.b(l(), r13);     // Catch: Throwable -> L34
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L12:
        r9 = "type";
        r3 = n4a.c.g;     // Catch: Throwable -> L35
        goto L13
    L42:
        return;
    }
}
