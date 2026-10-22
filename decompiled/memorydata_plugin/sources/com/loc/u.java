package com.loc;

import android.content.Context;
import android.util.Log;
import com.obric.capabilitykit.entity.app.EntityType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f5632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f5633b;
    private static volatile String c;
    private static volatile String d;
    private static volatile long e;
    private static volatile a f;
    private static volatile long g;
    private static volatile String h;
    private static volatile String i;
    private static volatile long j;
    private static volatile long k;
    private static volatile boolean l;
    private static volatile boolean m;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5637a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f5638b = null;
        public static final a c = null;
        private static final /* synthetic */ a[] e = null;
        private int d;

        static {
            a r0 = new a("Unknow", 0, -1);
            f5637a = r0;
            a r1 = new a("NotAgree", 1, 0);
            f5638b = r1;
            a r3 = new a("DidAgree", 2, 1);
            c = r3;
            e = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.d = r3;
        }

        public static a a(int r2) {
            a r0 = f5638b;
            if (r2 != r0.a()) goto L5;
            return r0;
        L5:
            a r1 = c;
            if (r2 != r1.a()) goto L9;
            return r1;
        L9:
            return f5637a;
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.memorydata.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(e.clone(), a[].class, "com.obric.memorydata.plugin");
        }

        public final int a() {
            return this.d;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5639a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f5640b = null;
        public static final b c = null;
        private static final /* synthetic */ b[] e = null;
        private int d;

        static {
            b r0 = new b("Unknow", 0, -1);
            f5639a = r0;
            b r1 = new b("NotContain", 1, 0);
            f5640b = r1;
            b r3 = new b("DidContain", 2, 1);
            c = r3;
            e = new b[]{r0, r1, r3};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.d = r3;
        }

        public static b a(int r2) {
            b r0 = f5640b;
            if (r2 != r0.a()) goto L5;
            return r0;
        L5:
            b r1 = c;
            if (r2 != r1.a()) goto L9;
            return r1;
        L9:
            return f5639a;
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.memorydata.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(e.clone(), b[].class, "com.obric.memorydata.plugin");
        }

        public final int a() {
            return this.d;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5641a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f5642b = null;
        public static final c c = null;
        public static final c d = null;
        public static final c e = null;
        public static final c f = null;
        public static final c g = null;
        public static final c h = null;
        public static final c i = null;
        private static final /* synthetic */ c[] k = null;
        private final int j;

        static {
            c r0 = new c("SuccessCode", 0, 0);
            f5641a = r0;
            c r1 = new c("ShowUnknowCode", 1, 555570);
            f5642b = r1;
            c r3 = new c("ShowNoShowCode", 2, 555571);
            c = r3;
            c r5 = new c("InfoUnknowCode", 3, 555572);
            d = r5;
            c r7 = new c("InfoNotContainCode", 4, 555573);
            e = r7;
            c r9 = new c("AgreeUnknowCode", 5, 555574);
            f = r9;
            c r11 = new c("AgreeNotAgreeCode", 6, 555575);
            g = r11;
            c r13 = new c("InvaildUserKeyCode", 7, 10001);
            h = r13;
            c r12 = new c("IllegalArgument", 8, EntityType.PROACTIVE_MEMORY);
            i = r12;
            k = new c[]{r0, r1, r3, r5, r7, r9, r11, r13, r12};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.j = r3;
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.memorydata.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(k.clone(), c[].class, "com.obric.memorydata.plugin");
        }

        public final int a() {
            return this.j;
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f5643a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f5644b = null;
        public static final d c = null;
        private static final /* synthetic */ d[] e = null;
        private int d;

        static {
            d r0 = new d("Unknow", 0, -1);
            f5643a = r0;
            d r1 = new d("NotShow", 1, 0);
            f5644b = r1;
            d r3 = new d("DidShow", 2, 1);
            c = r3;
            e = new d[]{r0, r1, r3};
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.d = r3;
        }

        public static d a(int r2) {
            d r0 = f5644b;
            if (r2 != r0.a()) goto L5;
            return r0;
        L5:
            d r1 = c;
            if (r2 != r1.a()) goto L9;
            return r1;
        L9:
            return f5643a;
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.memorydata.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(e.clone(), d[].class, "com.obric.memorydata.plugin");
        }

        public final int a() {
            return this.d;
        }
    }

    static {
        f5632a = b.f5639a;
        f5633b = d.f5643a;
        c = "";
        d = "";
        e = -1;
        f = a.f5637a;
        g = -1;
        h = "";
        i = "";
        j = 0;
        k = 0;
        l = false;
        m = true;
    }

    public static synchronized fu a(Context r13, fw r14) {
        monitor-enter(u.class);
        final Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        fu r1 = null;
        if (r15 == null) goto L60;
        if (r14 == null) goto L60;
        if (l == true) goto L12;
        e(r15);     // Catch: Throwable -> L63
        l = true;     // Catch: Throwable -> L63
    L12:
        if (f5633b != d.c) goto L14;
        boolean r2 = true;
    L21:
        if (r2 == true) goto L23;
    L31:
        if (r2 == true) goto L33;
    L41:
        fu r9 = r1;
        boolean r10 = r2;
    L43:
        if (k == j) goto L48;
        final long r4 = j;     // Catch: Throwable -> L63
        k = j;     // Catch: Throwable -> L63
        final JSONObject r6 = new JSONObject();     // Catch: Throwable -> L66
        r6.put("privacyInfo", f5632a.a());     // Catch: Throwable -> L66
        r6.put("privacyShow", f5633b.a());     // Catch: Throwable -> L66
        r6.put("showTime", e);     // Catch: Throwable -> L66
        r6.put("show2SDK", c);     // Catch: Throwable -> L66
        r6.put("show2SDKVer", d);     // Catch: Throwable -> L66
        r6.put("privacyAgree", f.a());     // Catch: Throwable -> L66
        r6.put("agreeTime", g);     // Catch: Throwable -> L66
        r6.put("agree2SDK", h);     // Catch: Throwable -> L66
        r6.put("agree2SDKVer", i);     // Catch: Throwable -> L66
        final boolean r3 = m;     // Catch: Throwable -> L63
        bp.a().b(new AnonymousClass2(r3, r15, r4, r6));     // Catch: Throwable -> L63
    L50:
        m = false;     // Catch: Throwable -> L63
        String r16 = fm.f(r15);     // Catch: Throwable -> L63
        if (r16 != null) goto L53;
    L54:
        r9 = new fu(c.h, r14);     // Catch: Throwable -> L63
        Log.e(r14.a(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", new Object[]{Integer.valueOf(r9.f5592a.a()), r9.f5593b}));     // Catch: Throwable -> L63
    L55:
        if (r10 == false) goto L57;
        r9 = new fu(c.f5641a, r14);     // Catch: Throwable -> L63
    L58:
        monitor-exit(u.class);
        return r9;
    L57:
        Log.e(r14.a(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", new Object[]{Integer.valueOf(r9.f5592a.a()), r9.f5593b}));     // Catch: Throwable -> L63
        goto L58
    L53:
        if (r16.length() > 0) goto L55;
    L48:
        if (m == false) goto L50;
        bp.a().b(new AnonymousClass1(r15));     // Catch: Throwable -> L63
        goto L50
    L33:
        if (f == a.c) goto L41;
        if (f != a.f5637a) goto L38;
        r1 = new fu(c.f, r14);     // Catch: Throwable -> L63
    L40:
        r9 = r1;
        r10 = false;
        goto L43
    L38:
        if (f != a.f5638b) goto L40;
        r1 = new fu(c.g, r14);     // Catch: Throwable -> L63
        goto L40
    L23:
        if (f5632a == b.c) goto L31;
        if (f5632a != b.f5639a) goto L28;
        r1 = new fu(c.d, r14);     // Catch: Throwable -> L63
    L30:
        r2 = false;
        goto L31
    L28:
        if (f5632a != b.f5640b) goto L30;
        r1 = new fu(c.e, r14);     // Catch: Throwable -> L63
        goto L30
    L14:
        if (f5633b != d.f5643a) goto L17;
        r1 = new fu(c.f5642b, r14);     // Catch: Throwable -> L63
    L19:
        r2 = false;
        goto L21
    L17:
        if (f5633b != d.f5644b) goto L19;
        r1 = new fu(c.c, r14);     // Catch: Throwable -> L63
    L60:
        fu r17 = new fu(c.i, r14);     // Catch: Throwable -> L63
        monitor-exit(u.class);
        return r17;
    L63:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ String a(long r0) {
        return b(r0);
    }

    static /* synthetic */ String a(Context r2) {
        return f((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ ArrayList a(String r0) {
        return b(r0);
    }

    private static synchronized void a(Context r3, a r4, fw r5) {
        monitor-enter(u.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r6 == null) goto L16;
        if (r5 == null) goto L16;
        if (l == true) goto L11;
        e(r6);     // Catch: Throwable -> L18
        l = true;     // Catch: Throwable -> L18
    L11:
        Boolean r1 = Boolean.FALSE;     // Catch: Throwable -> L18
        if (r4 == f) goto L14;
        Boolean r2 = Boolean.TRUE;     // Catch: Throwable -> L18
        f = r4;     // Catch: Throwable -> L18
        h = r5.a();     // Catch: Throwable -> L18
        i = r5.b();     // Catch: Throwable -> L18
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L18
        g = r7;     // Catch: Throwable -> L18
        j = r7;     // Catch: Throwable -> L18
        d(r6);     // Catch: Throwable -> L18
    L14:
        monitor-exit(u.class);
        return;
    L16:
        monitor-exit(u.class);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private static synchronized void a(Context r3, d r4, b r5, fw r6) {
        monitor-enter(u.class);
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r7 == null) goto L22;
        if (r6 == null) goto L22;
        if (l == true) goto L11;
        e(r7);     // Catch: Throwable -> L24
        l = true;     // Catch: Throwable -> L24
    L11:
        Boolean r1 = Boolean.FALSE;     // Catch: Throwable -> L24
        if (r4 == f5633b) goto L15;
        r1 = Boolean.TRUE;     // Catch: Throwable -> L24
        f5633b = r4;     // Catch: Throwable -> L24
    L15:
        if (r5 == f5632a) goto L18;
        r1 = Boolean.TRUE;     // Catch: Throwable -> L24
        f5632a = r5;     // Catch: Throwable -> L24
    L18:
        if (r1.booleanValue() == false) goto L20;
        c = r6.a();     // Catch: Throwable -> L24
        d = r6.b();     // Catch: Throwable -> L24
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L24
        e = r8;     // Catch: Throwable -> L24
        j = r8;     // Catch: Throwable -> L24
        d(r7);     // Catch: Throwable -> L24
    L20:
        monitor-exit(u.class);
        return;
    L22:
        monitor-exit(u.class);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length() == 0) goto L21;
        File r2 = new File(f(r5) + "/" + r4);     // Catch: Throwable -> L15
        if (r2.exists() == true) goto L10;
        return;
    L10:
        File r6 = new File(g(r5) + "/" + r4);     // Catch: Throwable -> L15
        if (r6.getParentFile().exists() == true) goto L13;
        r6.getParentFile().mkdirs();     // Catch: Throwable -> L15
    L13:
        r2.renameTo(r6);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    static /* synthetic */ void a(Context r2, JSONObject r3, long r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        FileOutputStream r0 = null;
        byte[] r6 = z.a(r5, r3.toString().getBytes());     // Catch: Throwable -> L15
        String r7 = b(r4);     // Catch: Throwable -> L15
        File r8 = new File(f(r5) + "/" + r7);     // Catch: Throwable -> L15
        if (r8.getParentFile().exists() == true) goto L6;
        r8.getParentFile().mkdirs();     // Catch: Throwable -> L15
    L6:
        FileOutputStream r9 = new FileOutputStream(r8);     // Catch: Throwable -> L15
        r9.write(r6);     // Catch: Throwable -> L13
        r9.close();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L13:
        th = move-exception;
        r0 = r9;
        th = th;
    L30:
        th.printStackTrace();     // Catch: Throwable -> L23
        if (r0 == null) goto L42;
        r0.close();     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L42:
        return;
    L23:
        th = move-exception;
        if (r0 != null) goto L34;
    L29:
        throw th;
    L34:
        r0.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = th;
        goto L30
    }

    public static void a(Context r2, boolean r3, fw r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L5;
        a r6 = a.c;
    L6:
        a(r5, r6, r4);
        return;
    L5:
        r6 = a.f5638b;
        goto L6
    }

    public static void a(Context r2, boolean r3, boolean r4, fw r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L5;
        d r7 = d.c;
    L6:
        if (r3 == false) goto L8;
        b r8 = b.c;
    L9:
        a(r6, r7, r8, r5);
        return;
    L8:
        r8 = b.f5640b;
        goto L9
    L5:
        r7 = d.f5644b;
        goto L6
    }

    static /* synthetic */ boolean a(Context r2, JSONObject r3) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    private static String b(long r1) {
        return String.format("%d-%s", new Object[]{Long.valueOf(r1), "privacy.data"});
    }

    private static ArrayList<File> b(String r4) {
        ArrayList<File> r0 = new ArrayList();
        if (r4 != null) goto L5;
    L17:
        return r0;
    L5:
        if (r4.length() == 0) goto L17;
        File r1 = new File(r4);
        if (r1.exists() == true) goto L10;
        return r0;
    L10:
        File[] r5 = r1.listFiles();
        int r2 = 0;
    L12:
        if (r2 >= r5.length) goto L17;
        File r3 = r5[r2];
        if (r3.isFile() == false) goto L16;
        r0.add(r3);
    L16:
        r2 = r2 + 1;
        goto L12
    }

    static /* synthetic */ void b(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Iterator<File> r0 = b(g(r8)).iterator();     // Catch: Throwable -> L25
    L4:
        if (r0.hasNext() == false) goto L24;
        File r2 = (File) ZeusTransformUtils.preCheckCast(r0.next(), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        String r3 = r2.getName();     // Catch: Throwable -> L21
    L8:
        if (r3.endsWith("-privacy.data") == false) goto L9;
        String[] r4 = r3.split("-");     // Catch: Throwable -> L21
        if (r4 != null) goto L16;
        if (r4.length != 2) goto L9;
    L16:
        if (Long.parseLong(r4[0]) <= 0) goto L9;
        FileInputStream r5 = new FileInputStream(r2);     // Catch: Throwable -> L21
        byte[] r6 = new byte[r5.available()];     // Catch: Throwable -> L21
        r5.read(r6);     // Catch: Throwable -> L21
        if (b(r8, new JSONObject(new String(z.b(r8, r6)))) == false) goto L4;
    L9:
        r2.delete();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        goto L4
    L24:
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
    }

    static /* synthetic */ void b(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.length() == 0) goto L18;
        File r5 = new File(f(r4) + "/" + r3);     // Catch: Throwable -> L12
        if (r5.exists() == true) goto L10;
        return;
    L10:
        r5.delete();     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private static boolean b(Context r4, JSONObject r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        s r3 = new s();     // Catch: Throwable -> L10
        r3.f5631b = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        r3.f5630a = r5;     // Catch: Throwable -> L10
        new ak();     // Catch: Throwable -> L10
        aq r7 = ak.a(r3);     // Catch: Throwable -> L10
        if (r7 == null) goto L15;
        JSONObject r2 = new JSONObject(fx.a(r7.f5322a));     // Catch: Throwable -> L10
        if (r2.has("status") == false) goto L16;
        if (r2.getInt("status") == 1) goto L18;
        return false;
    L18:
        return true;
    L16:
        return false;
    L15:
        return false;
    L10:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    static /* synthetic */ void c(Context r2) {
        d((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    private static synchronized void d(Context r6) {
        monitor-enter(u.class);
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r7 != null) goto L9;
        monitor-exit(u.class);
        return;
    L9:
        if (l == true) goto L23;
        e(r7);     // Catch: Throwable -> L18
        l = true;     // Catch: Throwable -> L18
    L23:
        z.a(r7, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", new Object[]{Integer.valueOf(f5632a.a()), Integer.valueOf(f5633b.a()), Long.valueOf(e), c, d, Integer.valueOf(f.a()), Long.valueOf(g), h, i, Long.valueOf(j), Long.valueOf(k)}));     // Catch: Throwable -> L14
        monitor-exit(u.class);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private static void e(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        String r1 = null;
        r1 = z.a(r4, "AMap.privacy.data", "AMap.privacy.data");     // Catch: Throwable -> L8
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        String[] r5 = r1.split("&");
        if (r5.length == 11) goto L23;
        return;
    L23:
        f5632a = b.a(Integer.parseInt(r5[0]));     // Catch: Throwable -> L18
        f5633b = d.a(Integer.parseInt(r5[1]));     // Catch: Throwable -> L18
        e = Long.parseLong(r5[2]);     // Catch: Throwable -> L18
        d = r5[3];     // Catch: Throwable -> L18
        d = r5[4];     // Catch: Throwable -> L18
        f = a.a(Integer.parseInt(r5[5]));     // Catch: Throwable -> L18
        g = Long.parseLong(r5[6]);     // Catch: Throwable -> L18
        h = r5[7];     // Catch: Throwable -> L18
        i = r5[8];     // Catch: Throwable -> L18
        j = Long.parseLong(r5[9]);     // Catch: Throwable -> L18
        k = Long.parseLong(r5[10]);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    private static String f(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    private static String g(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload";
    }
}
