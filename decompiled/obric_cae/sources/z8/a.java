package z8;

import com.bytedance.ttnet.diagnosis.IDiagnosisCallback;
import com.bytedance.ttnet.diagnosis.IDiagnosisRequest;
import java.lang.reflect.Constructor;
import java.util.List;
import org.chromium.diagnosis.CronetDiagnosisRequestImpl;

/* JADX INFO: loaded from: classes.dex */
public final class a implements IDiagnosisRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IDiagnosisCallback f14295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f14297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C0205a f14303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z6.a f14304j;

    /* JADX INFO: renamed from: z8.a$a, reason: collision with other inner class name */
    public class C0205a implements z6.a.InterfaceC0204a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f14305a;

        public C0205a(a r8) {
            this.f14305a = r8;
        }

        @Override // z6.a.InterfaceC0204a
        public final void a(String r8) {
            IDiagnosisCallback r10 = this.f14305a.f14295a;
            if (r10 == null) goto L6;
            r10.onDiagnosisComplete(r8);
            return;
        }
    }

    public a(int r8, List<String> r10, int r11, int r12) {
        this.f14303i = new C0205a(this);
        this.f14300f = false;
        this.f14301g = false;
        this.f14296b = r8;
        this.f14297c = r10;
        this.f14298d = r11;
        this.f14299e = r12;
        if (this.f14304j == null) goto L7;
        return;
    L7:
        if (CronetDiagnosisRequestImpl.class == 0) goto L12;
        Class r13 = Integer.TYPE;
        Constructor r14 = CronetDiagnosisRequestImpl.class.getDeclaredConstructor(new Class[]{z6.a.InterfaceC0204a.class, r13, List.class, r13, r13});
        Integer r15 = Integer.valueOf(this.f14296b);
        Integer r16 = Integer.valueOf(this.f14298d);
        Integer r17 = Integer.valueOf(this.f14299e);
        Object r18 = r14.newInstance(new Object[]{this.f14303i, r15, this.f14297c, r16, r17});
        if ((r18 instanceof z6.a) == false) goto L14;
        this.f14304j = (z6.a) r18;
        return;
    L14:
        return;
    L12:
        throw new ClassNotFoundException("org.chromium.diagnosis.CronetDiagnosisRequestImpl class not found");
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public final void cancel() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f14300f == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (this.f14301g == true) goto L11;
        this.f14304j.cancel();     // Catch: Throwable -> L13
        this.f14301g = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public final void doExtraCommand(String r8, String r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f14300f == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.f14304j.doExtraCommand(r8, r10);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public final void setUserExtraInfo(String r8) {
        monitor-enter(this);
        this.f14302h = r8;     // Catch: Throwable -> L6
        doExtraCommand("extra_info", r8);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public final void start(IDiagnosisCallback r8) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f14300f == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        this.f14295a = r8;     // Catch: Throwable -> L14
        this.f14304j.start();     // Catch: Throwable -> L14
        this.f14300f = true;     // Catch: Throwable -> L14
        String r10 = this.f14302h;     // Catch: Throwable -> L14
        if (r10 != null) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        if (r10.isEmpty() == true) goto L12;
        doExtraCommand("extra_info", this.f14302h);     // Catch: Throwable -> L14
        goto L12
    }
}
