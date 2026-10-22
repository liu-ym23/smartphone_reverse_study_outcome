package com.bytedance.ttnet.diagnosis;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class a implements IDiagnosisRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IDiagnosisCallback f2852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f2854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f2860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private q2.a.InterfaceC0281a f2861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private q2.a f2862k;

    /* JADX INFO: renamed from: com.bytedance.ttnet.diagnosis.a$a, reason: collision with other inner class name */
    class C0073a implements q2.a.InterfaceC0281a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f2863a;

        C0073a(a r10) {
            this.f2863a = r10;
        }

        @Override // q2.a.InterfaceC0281a
        public void a(String r10) {
            if (a.a(this.f2863a) == null) goto L6;
            a.a(this.f2863a).onDiagnosisComplete(r10);
            return;
        }
    }

    static {
    }

    public a(int r10, List<String> r11, int r12, int r13, int r14) {
        this.f2861j = new C0073a(this);
        this.f2858g = false;
        this.f2859h = false;
        this.f2853b = r10;
        this.f2854c = r11;
        this.f2855d = r12;
        this.f2856e = r13;
        this.f2857f = r14;
        c();
    }

    static /* synthetic */ IDiagnosisCallback a(a r10) {
        return r10.f2852a;
    }

    private Class<?> b(String r10) {
        return Class.forName(r10);
    L4:
        return null;
    }

    private void c() {
        if (this.f2862k != null) goto L11;
        Class<?> r10 = b("org.chromium.diagnosis.CronetDiagnosisRequestImpl");
        if (r10 == null) goto L10;
        Class<?> r11 = Integer.TYPE;
        Object r12 = r10.getDeclaredConstructor(new Class[]{q2.a.InterfaceC0281a.class, r11, List.class, r11, r11, r11}).newInstance(new Object[]{this.f2861j, Integer.valueOf(this.f2853b), this.f2854c, Integer.valueOf(this.f2855d), Integer.valueOf(this.f2856e), Integer.valueOf(this.f2857f)});
        if ((r12 instanceof q2.a) == false) goto L12;
        this.f2862k = (q2.a) r12;
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
        if (this.f2858g == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (this.f2859h == true) goto L11;
        this.f2862k.cancel();     // Catch: Throwable -> L13
        this.f2859h = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void doExtraCommand(String r10, String r11) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f2858g == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.f2862k.doExtraCommand(r10, r11);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void setUserExtraInfo(String r10) {
        monitor-enter(this);
        this.f2860i = r10;     // Catch: Throwable -> L6
        doExtraCommand("extra_info", r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void start(IDiagnosisCallback r10) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f2858g == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        this.f2852a = r10;     // Catch: Throwable -> L14
        this.f2862k.start();     // Catch: Throwable -> L14
        this.f2858g = true;     // Catch: Throwable -> L14
        String r11 = this.f2860i;     // Catch: Throwable -> L14
        if (r11 != null) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        if (r11.isEmpty() == true) goto L12;
        doExtraCommand("extra_info", this.f2860i);     // Catch: Throwable -> L14
        goto L12
    }
}
