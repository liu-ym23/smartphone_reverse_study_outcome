package com.bytedance.ttnet.diagnosis;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class a implements IDiagnosisRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3282a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IDiagnosisCallback f3283b;
    private int c;
    private List<String> d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private String j;
    private com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0126a k;
    private com.bytedance.frameworks.baselib.network.http.cronet.a.a l;

    /* JADX INFO: renamed from: com.bytedance.ttnet.diagnosis.a$a, reason: collision with other inner class name */
    class C0166a implements com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0126a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f3284a;

        C0166a(a r1) {
            this.f3284a = r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0126a
        public void a(String r2) {
            if (a.a(this.f3284a) == null) goto L6;
            a.a(this.f3284a).onDiagnosisComplete(r2);
            return;
        }
    }

    static {
    }

    public a(int r3, List<String> r4, int r5, int r6, int r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.k = new C0166a(this);
        this.h = false;
        this.i = false;
        this.c = r3;
        this.d = r8;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        a();
    }

    static /* synthetic */ IDiagnosisCallback a(a r0) {
        return r0.f3283b;
    }

    private Class<?> a(String r1) {
        return ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin");
    L4:
        return null;
    }

    private void a() {
        if (this.l != null) goto L11;
        Class<?> r0 = a("org.chromium.diagnosis.CronetDiagnosisRequestImpl");
        if (r0 == null) goto L10;
        Object r1 = r0.getDeclaredConstructor(new Class[]{com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0126a.class, Integer.TYPE, List.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}).newInstance(new Object[]{this.k, Integer.valueOf(this.c), this.d, Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g)});
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.frameworks.baselib.network.http.cronet.a.a.class) == false) goto L12;
        this.l = (com.bytedance.frameworks.baselib.network.http.cronet.a.a) ZeusTransformUtils.preCheckCast(r1, com.bytedance.frameworks.baselib.network.http.cronet.a.a.class, "com.obric.memorydata.plugin");
        return;
    L12:
        return;
    L10:
        throw new ClassNotFoundException("org.chromium.diagnosis.CronetDiagnosisRequestImpl class not found");
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void cancel() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.h == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (this.i == true) goto L11;
        this.l.cancel();     // Catch: Throwable -> L13
        this.i = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void doExtraCommand(String r2, String r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.h == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.l.doExtraCommand(r2, r3);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void setUserExtraInfo(String r2) {
        monitor-enter(this);
        this.j = r2;     // Catch: Throwable -> L6
        doExtraCommand("extra_info", r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void start(IDiagnosisCallback r3) {
        IDiagnosisCallback r4 = (IDiagnosisCallback) ZeusTransformUtils.wrapperContextForParams(r3, IDiagnosisCallback.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.h == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L8:
        this.f3283b = r4;     // Catch: Throwable -> L15
        this.l.start();     // Catch: Throwable -> L15
        this.h = true;     // Catch: Throwable -> L15
        String r5 = this.j;     // Catch: Throwable -> L15
        if (r5 != null) goto L11;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L11:
        if (r5.isEmpty() == true) goto L13;
        doExtraCommand("extra_info", this.j);     // Catch: Throwable -> L15
        goto L13
    }
}
