package com.bytedance.privacy.d;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.keymanager.KeyManager;
import com.aiassistant.security.keymanager.KeyManagerResult;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.QueryResult;
import com.aiassistant.security.secretdata.SecretData;
import com.aiassistant.security.secretdata.SecretDataManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f3008a;

    /* JADX INFO: renamed from: com.bytedance.privacy.d.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.privacy.d.a$a, reason: collision with other inner class name */
    private static final class C0151a implements b {
        private C0151a() {
        }

        /* synthetic */ C0151a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.privacy.d.a.b
        public int a(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return KeyManager.getInstance().generateKeyPair(r1, r3, r4);
        L5:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "generateKeyPair failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int a(Context r2, String r3, String r4, String r5, String r6, Bundle r7) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            SecretData r0 = new SecretData();     // Catch: Throwable -> L7
            r0.privateData = r3;     // Catch: Throwable -> L7
            r0.associate = r4;     // Catch: Throwable -> L7
            r0.alias = r5;     // Catch: Throwable -> L7
            r0.dataType = r6;     // Catch: Throwable -> L7
            AddResult r8 = SecretDataManager.getInstance().addData(r1, r0, r7);     // Catch: Throwable -> L7
            if (r8 == null) goto L12;
            return r8.getResultCode();
        L12:
            return -1;
        L7:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "SecretDataManager.addData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.d.a.b
        public c a(Context r2, String r3, byte[] r4, Bundle r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            KeyManagerResult r6 = KeyManager.getInstance().sign(r1, r3, r4, r5);     // Catch: Throwable -> L9
            if (r6 != null) goto L8;
            return c.a();
        L8:
            return c.a(r6.getResultCode(), r6.getCertChain(), r6.getOutData());
        L9:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "sign failed", th);
            return c.a();
        }

        @Override // com.bytedance.privacy.d.a.b
        public String a() {
            return "com.aiassistant.security";
        }

        @Override // com.bytedance.privacy.d.a.b
        public int b(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return KeyManager.getInstance().deleteKey(r1, r3, r4);
        L5:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "deleteKey failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.d.a.b
        public String b() {
            return "key_algorithm";
        }

        @Override // com.bytedance.privacy.d.a.b
        public c c(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            KeyManagerResult r5 = KeyManager.getInstance().keyAttestation(r1, r3, r4);     // Catch: Throwable -> L9
            if (r5 != null) goto L8;
            return c.a();
        L8:
            return c.a(r5.getResultCode(), r5.getCertChain(), r5.getOutData());
        L9:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "keyAttestation failed", th);
            return c.a();
        }

        @Override // com.bytedance.privacy.d.a.b
        public String c() {
            return "key_length";
        }

        @Override // com.bytedance.privacy.d.a.b
        public e d(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            QueryResult r5 = SecretDataManager.getInstance().queryData(r1, r3, r4);     // Catch: Throwable -> L16
            if (r5 == null) goto L6;
            String r6 = null;
            List<SecretData> r7 = r5.getDataList();     // Catch: Throwable -> L16
            if (r7 == null) goto L15;
            if (r7.isEmpty() == true) goto L15;
            SecretData r8 = (SecretData) ZeusTransformUtils.preCheckCast(r7.get(0), SecretData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            if (r8 == null) goto L15;
            r6 = r8.privateData;     // Catch: Throwable -> L16
        L15:
            return e.a(r5.getResultCode(), r6);
        L6:
            return e.a();
        L16:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "SecretDataManager.queryData failed", th);
            return e.a();
        }

        @Override // com.bytedance.privacy.d.a.b
        public String d() {
            return "key_purpose";
        }

        @Override // com.bytedance.privacy.d.a.b
        public int e() {
            return 2;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int e(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return SecretDataManager.getInstance().deleteData(r1, r3, r4);
        L5:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "SecretDataManager.deleteData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int f() {
            return 64;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int g() {
            return 4;
        }

        @Override // com.bytedance.privacy.d.a.b
        public String h() {
            return "challenge";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String i() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String j() {
            return "attest_appid";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String k() {
            return "attest_rpdid";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String l() {
            return "attest_rpuid";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String m() {
            return "attest_udid";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String n() {
            return "attest_custom_info";
        }

        @Override // com.bytedance.privacy.d.a.b
        public int o() {
            return 128;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int p() {
            return 1024;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int q() {
            return 0;
        }

        @Override // com.bytedance.privacy.d.a.b
        public String r() {
            return "query_mode";
        }

        @Override // com.bytedance.privacy.d.a.b
        public int s() {
            return 0;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int t() {
            return 2;
        }
    }

    private interface b {
        int a(Context r1, String r2, Bundle r3);

        int a(Context r1, String r2, String r3, String r4, String r5, Bundle r6);

        c a(Context r1, String r2, byte[] r3, Bundle r4);

        String a();

        int b(Context r1, String r2, Bundle r3);

        String b();

        c c(Context r1, String r2, Bundle r3);

        String c();

        e d(Context r1, String r2, Bundle r3);

        String d();

        int e();

        int e(Context r1, String r2, Bundle r3);

        int f();

        int g();

        String h();

        String i();

        String j();

        String k();

        String l();

        String m();

        String n();

        int o();

        int p();

        int q();

        String r();

        int s();

        int t();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f3009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3010b;
        private final List<Certificate> c;
        private final byte[] d;

        private c(boolean r3, int r4, List<Certificate> r5, byte[] r6) {
            List<Certificate> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            this.f3009a = r3;
            this.f3010b = r4;
            if (r7 != null) goto L6;
            r7 = Collections.emptyList();
        L6:
            this.c = r7;
            this.d = r6;
        }

        static c a() {
            return new c(true, -1, Collections.emptyList(), null);
        }

        static c a(int r2, List<Certificate> r3, byte[] r4) {
            return new c(false, r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
        }

        public int b() {
            return this.f3010b;
        }

        public List<Certificate> c() {
            return this.c;
        }

        public byte[] d() {
            return this.d;
        }
    }

    private static final class d implements b {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.privacy.d.a.b
        public int a(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return com.obric.security.keymanager.KeyManager.getInstance().generateKeyPair(r1, r3, r4);
        L5:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "generateKeyPair failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int a(Context r2, String r3, String r4, String r5, String r6, Bundle r7) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            com.obric.security.secretdata.SecretData r0 = new com.obric.security.secretdata.SecretData();     // Catch: Throwable -> L7
            r0.privateData = r3;     // Catch: Throwable -> L7
            r0.associate = r4;     // Catch: Throwable -> L7
            r0.alias = r5;     // Catch: Throwable -> L7
            r0.dataType = r6;     // Catch: Throwable -> L7
            com.obric.security.secretdata.AddResult r8 = com.obric.security.secretdata.SecretDataManager.getInstance().addData(r1, r0, r7);     // Catch: Throwable -> L7
            if (r8 == null) goto L12;
            return r8.getResultCode();
        L12:
            return -1;
        L7:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "SecretDataManager.addData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.d.a.b
        public c a(Context r2, String r3, byte[] r4, Bundle r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            com.obric.security.keymanager.KeyManagerResult r6 = com.obric.security.keymanager.KeyManager.getInstance().sign(r1, r3, r4, r5);     // Catch: Throwable -> L9
            if (r6 != null) goto L8;
            return c.a();
        L8:
            return c.a(r6.getResultCode(), r6.getCertChain(), r6.getOutData());
        L9:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "sign failed", th);
            return c.a();
        }

        @Override // com.bytedance.privacy.d.a.b
        public String a() {
            return "com.obric.security";
        }

        @Override // com.bytedance.privacy.d.a.b
        public int b(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return com.obric.security.keymanager.KeyManager.getInstance().deleteKey(r1, r3, r4);
        L5:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "deleteKey failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.d.a.b
        public String b() {
            return "key_algorithm";
        }

        @Override // com.bytedance.privacy.d.a.b
        public c c(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            com.obric.security.keymanager.KeyManagerResult r5 = com.obric.security.keymanager.KeyManager.getInstance().keyAttestation(r1, r3, r4);     // Catch: Throwable -> L9
            if (r5 != null) goto L8;
            return c.a();
        L8:
            return c.a(r5.getResultCode(), r5.getCertChain(), r5.getOutData());
        L9:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "keyAttestation failed", th);
            return c.a();
        }

        @Override // com.bytedance.privacy.d.a.b
        public String c() {
            return "key_length";
        }

        @Override // com.bytedance.privacy.d.a.b
        public e d(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            com.obric.security.secretdata.QueryResult r5 = com.obric.security.secretdata.SecretDataManager.getInstance().queryData(r1, r3, r4);     // Catch: Throwable -> L16
            if (r5 == null) goto L6;
            String r6 = null;
            List<com.obric.security.secretdata.SecretData> r7 = r5.getDataList();     // Catch: Throwable -> L16
            if (r7 == null) goto L15;
            if (r7.isEmpty() == true) goto L15;
            com.obric.security.secretdata.SecretData r8 = (com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r7.get(0), com.obric.security.secretdata.SecretData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            if (r8 == null) goto L15;
            r6 = r8.privateData;     // Catch: Throwable -> L16
        L15:
            return e.a(r5.getResultCode(), r6);
        L6:
            return e.a();
        L16:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "SecretDataManager.queryData failed", th);
            return e.a();
        }

        @Override // com.bytedance.privacy.d.a.b
        public String d() {
            return "key_purpose";
        }

        @Override // com.bytedance.privacy.d.a.b
        public int e() {
            return 2;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int e(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return com.obric.security.secretdata.SecretDataManager.getInstance().deleteData(r1, r3, r4);
        L5:
            th = move-exception;
            com.bytedance.privacy.e.c.a("SecurityFrameworkCompat", "SecretDataManager.deleteData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int f() {
            return 64;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int g() {
            return 4;
        }

        @Override // com.bytedance.privacy.d.a.b
        public String h() {
            return "challenge";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String i() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String j() {
            return "attest_appid";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String k() {
            return "attest_rpdid";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String l() {
            return "attest_rpuid";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String m() {
            return "attest_udid";
        }

        @Override // com.bytedance.privacy.d.a.b
        public String n() {
            return "attest_custom_info";
        }

        @Override // com.bytedance.privacy.d.a.b
        public int o() {
            return 128;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int p() {
            return 1024;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int q() {
            return 0;
        }

        @Override // com.bytedance.privacy.d.a.b
        public String r() {
            return "query_mode";
        }

        @Override // com.bytedance.privacy.d.a.b
        public int s() {
            return 0;
        }

        @Override // com.bytedance.privacy.d.a.b
        public int t() {
            return 2;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f3011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3012b;
        private final String c;

        private e(boolean r1, int r2, String r3) {
            this.f3011a = r1;
            this.f3012b = r2;
            this.c = r3;
        }

        static e a() {
            return new e(true, -1, null);
        }

        static e a(int r2, String r3) {
            return new e(false, r2, r3);
        }

        public boolean b() {
            return this.f3011a;
        }

        public int c() {
            return this.f3012b;
        }

        public String d() {
            return this.c;
        }
    }

    private a() {
    }

    public static int a(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return t().a(r5, r3, r4);
    }

    public static int a(Context r7, String r8, String r9, String r10, String r11, Bundle r12) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        return t().a(r1, r8, r9, r10, r11, r12);
    }

    public static c a(Context r2, String r3, byte[] r4, Bundle r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return t().a(r6, r3, r4, r5);
    }

    public static String a() {
        return t().b();
    }

    private static boolean a(String r3) {
        Class.forName(r3, false, null);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        e = move-exception;
        com.bytedance.privacy.e.c.d("SecurityFrameworkCompat", "Class not found:" + e);
        return false;
    }

    public static int b(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return t().b(r5, r3, r4);
    }

    public static String b() {
        return t().c();
    }

    public static c c(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return t().c(r5, r3, r4);
    }

    public static String c() {
        return t().d();
    }

    public static int d() {
        return t().e();
    }

    public static e d(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return t().d(r5, r3, r4);
    }

    public static int e() {
        return t().f();
    }

    public static int e(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return t().e(r5, r3, r4);
    }

    public static int f() {
        return t().g();
    }

    public static String g() {
        return t().h();
    }

    public static String h() {
        return t().i();
    }

    public static String i() {
        return t().j();
    }

    public static String j() {
        return t().k();
    }

    public static String k() {
        return t().l();
    }

    public static String l() {
        return t().m();
    }

    public static String m() {
        return t().n();
    }

    public static int n() {
        return t().o();
    }

    public static int o() {
        return t().p();
    }

    public static int p() {
        return t().q();
    }

    public static String q() {
        return t().r();
    }

    public static int r() {
        return t().s();
    }

    public static int s() {
        return t().t();
    }

    private static b t() {
        b r0 = f3008a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        monitor-enter(a.class);
        b r1 = f3008a;     // Catch: Throwable -> L21
        if (r1 == null) goto L11;
        monitor-exit(a.class);     // Catch: Throwable -> L21
        return r1;
    L11:
        boolean r2 = a("com.obric.security.secretdata.SecretDataManager");     // Catch: Throwable -> L21
        boolean r3 = a("com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L21
        AnonymousClass1 r4 = null;
        if (r2 == false) goto L14;
        b r5 = new d(r4);     // Catch: Throwable -> L21
    L16:
        f3008a = r5;     // Catch: Throwable -> L21
        com.bytedance.privacy.e.c.b("SecurityFrameworkCompat", "Using security framework package: " + r5.a());     // Catch: Throwable -> L21
        monitor-exit(a.class);     // Catch: Throwable -> L21
        return r5;
    L14:
        if (r3 == false) goto L19;
        r5 = new C0151a(r4);     // Catch: Throwable -> L21
        goto L16
    L19:
        com.bytedance.privacy.e.c.d("SecurityFrameworkCompat", "No supported security framework found. Tried: com.obric.security.secretdata.SecretDataManager, com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L21
        throw new IllegalStateException("No supported security framework found. Tried: com.obric.security.secretdata.SecretDataManager, com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }
}
