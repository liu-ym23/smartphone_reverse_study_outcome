package com.ss.android.socialbase.downloader.impls;

import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class j implements com.ss.android.socialbase.downloader.downloader.l, com.ss.android.socialbase.downloader.downloader.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15501a = "j";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.downloader.g f15502b;
    private com.ss.android.socialbase.downloader.downloader.n<IndependentProcessDownloadService> c;
    private com.ss.android.socialbase.downloader.downloader.l d;

    static {
    }

    public j() {
        this.d = new m();
        com.ss.android.socialbase.downloader.downloader.n<IndependentProcessDownloadService> r0 = com.ss.android.socialbase.downloader.downloader.b.E();
        this.c = r0;
        r0.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int a(String r1, String r2) {
        return com.ss.android.socialbase.downloader.downloader.b.a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> a(String r2) {
        if (this.f15502b == null) goto L5;
        return this.f15502b.a(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.d.a(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a() {
        if (this.f15502b != null) goto L10;
        return;
    L10:
        this.f15502b.a();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r2, int r3) {
        if (this.f15502b == null) goto L11;
        this.f15502b.a(r2, r3);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r8, int r9, IDownloadListener r10, ListenerType r11, boolean r12) {
        IDownloadListener r13 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (this.f15502b != null) goto L14;
        return;
    L14:
        com.ss.android.socialbase.downloader.downloader.g r1 = this.f15502b;     // Catch: RemoteException -> L11
        if (r11 != ListenerType.SUB) goto L8;
        boolean r7 = false;
    L9:
        r1.b(r8, r9, com.ss.android.socialbase.downloader.utils.h.a(r13, r7), r11.ordinal(), r12);     // Catch: RemoteException -> L11
        return;
    L8:
        r7 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r9, int r10, IDownloadListener r11, ListenerType r12, boolean r13, boolean r14) {
        IDownloadListener r15 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r11, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (this.f15502b != null) goto L14;
        return;
    L14:
        com.ss.android.socialbase.downloader.downloader.g r1 = this.f15502b;     // Catch: RemoteException -> L11
        if (r12 != ListenerType.SUB) goto L8;
        boolean r8 = false;
    L9:
        r1.a(r9, r10, com.ss.android.socialbase.downloader.utils.h.a(r15, r8), r12.ordinal(), r13, r14);     // Catch: RemoteException -> L11
        return;
    L8:
        r8 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r2, long r3, int r5) {
        if (this.f15502b != null) goto L10;
        return;
    L10:
        this.f15502b.a(r2, r3, r5);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r3, aa r4) {
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");
        if (this.f15502b == null) goto L11;
        this.f15502b.a(r3, com.ss.android.socialbase.downloader.utils.h.a(r5));     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r2, boolean r3) {
        if (this.f15502b != null) goto L10;
        return;
    L10:
        this.f15502b.a(r2, r3);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r2, boolean r3, boolean r4) {
        if (this.f15502b != null) goto L10;
        this.d.a(r2, r3, r4);
        return;
    L10:
        this.f15502b.a(r2, r3, r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(IBinder r3) {
        this.f15502b = com.ss.android.socialbase.downloader.downloader.g.a.a((IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin"));
        if (com.ss.android.socialbase.downloader.utils.c.a() == false) goto L6;
        a(new AnonymousClass1(this));
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(ak r3) {
        ak r4 = (ak) ZeusTransformUtils.wrapperContextForParams(r3, ak.class, "com.obric.memorydata.plugin");
        if (this.f15502b == null) goto L11;
        this.f15502b.a(com.ss.android.socialbase.downloader.utils.h.a(r4));     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(DownloadTask r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        com.ss.android.socialbase.downloader.downloader.n<IndependentProcessDownloadService> r0 = this.c;
        if (r0 == null) goto L8;
        r0.b(r1);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (this.f15502b != null) goto L10;
        this.d.a(r4);
        return;
    L10:
        this.f15502b.a(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean a(int r3) {
        if (this.f15502b != null) goto L10;
        return false;
    L10:
        return this.f15502b.a(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean a(DownloadInfo r2) {
        if (this.f15502b == null) goto L5;
        this.f15502b.a(r2);     // Catch: RemoteException -> L8
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.d.a(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public DownloadInfo b(String r1, String r2) {
        return g(a(r1, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> b(String r2) {
        if (this.f15502b == null) goto L5;
        return this.f15502b.b(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.d.b(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(int r2) {
        if (this.f15502b != null) goto L10;
        return;
    L10:
        this.f15502b.b(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(int r8, int r9, IDownloadListener r10, ListenerType r11, boolean r12) {
        IDownloadListener r13 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (this.f15502b != null) goto L14;
        return;
    L14:
        com.ss.android.socialbase.downloader.downloader.g r1 = this.f15502b;     // Catch: RemoteException -> L11
        if (r11 != ListenerType.SUB) goto L8;
        boolean r7 = false;
    L9:
        r1.a(r8, r9, com.ss.android.socialbase.downloader.utils.h.a(r13, r7), r11.ordinal(), r12);     // Catch: RemoteException -> L11
        return;
    L8:
        r7 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(int r2, boolean r3) {
        if (this.f15502b != null) goto L10;
        return;
    L10:
        this.f15502b.b(r2, r3);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(DownloadInfo r1) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(DownloadTask r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        com.ss.android.socialbase.downloader.downloader.n<IndependentProcessDownloadService> r0 = this.c;
        if (r0 == null) goto L8;
        r0.c(r1);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (this.f15502b != null) goto L10;
        this.d.b(r4);
        return;
    L10:
        this.f15502b.b(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean b() {
        return com.ss.android.socialbase.downloader.downloader.b.T();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> c() {
        if (this.f15502b == null) goto L5;
        return this.f15502b.b();
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.d.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> c(String r2) {
        if (this.f15502b == null) goto L5;
        return this.f15502b.e(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.d.c(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> c(String r2, String r3) {
        if (this.f15502b == null) goto L5;
        return this.f15502b.c(r2, r3);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.d.c(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void c(int r2) {
        if (this.f15502b != null) goto L10;
        return;
    L10:
        this.f15502b.c(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void c(int r2, boolean r3) {
        if (this.f15502b != null) goto L10;
        return;
    L10:
        this.f15502b.d(r2, r3);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean c(DownloadInfo r2) {
        if (this.f15502b == null) goto L5;
        return this.f15502b.b(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.d.c(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public long d(int r4) {
        if (this.f15502b != null) goto L10;
        return 0;
    L10:
        return this.f15502b.d(r4);
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> d(String r2) {
        if (this.f15502b == null) goto L12;
        return this.f15502b.c(r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean d() {
        if (this.f15502b == null) goto L5;
        return this.f15502b.d();
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.d.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int e(int r3) {
        if (this.f15502b != null) goto L10;
        return 0;
    L10:
        return this.f15502b.e(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> e(String r2) {
        if (this.f15502b == null) goto L5;
        return this.f15502b.d(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.d.e(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void e() {
        if (this.f15502b != null) goto L10;
        this.d.e();
        return;
    L10:
        this.f15502b.e();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean f() {
        if (this.f15502b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean f(int r3) {
        if (this.f15502b != null) goto L10;
        return false;
    L10:
        return this.f15502b.f(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public DownloadInfo g(int r2) {
        if (this.f15502b == null) goto L5;
        return this.f15502b.g(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.d.g(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void g() {
        this.f15502b = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void h(int r1) {
        com.ss.android.socialbase.downloader.downloader.n<IndependentProcessDownloadService> r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int i(int r2) {
        if (this.f15502b == null) goto L5;
        return this.f15502b.i(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L5:
        return com.ss.android.socialbase.downloader.downloader.c.a().b(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean j(int r2) {
        if (this.f15502b == null) goto L5;
        return this.f15502b.j(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.d.j(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean k(int r2) {
        if (this.f15502b == null) goto L5;
        return this.f15502b.k(r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.d.k(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void l(int r2) {
        if (this.f15502b != null) goto L10;
        this.d.l(r2);
        return;
    L10:
        this.f15502b.l(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public aa m(int r2) {
        if (this.f15502b == null) goto L12;
        return com.ss.android.socialbase.downloader.utils.h.a(this.f15502b.m(r2));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public ah n(int r2) {
        if (this.f15502b == null) goto L12;
        return com.ss.android.socialbase.downloader.utils.h.a(this.f15502b.n(r2));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public t o(int r2) {
        if (this.f15502b == null) goto L12;
        return com.ss.android.socialbase.downloader.utils.h.a(this.f15502b.o(r2));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.n<IndependentProcessDownloadService> r0 = this.c;
        if (r0 == null) goto L6;
        r0.startService();
        return;
    }
}
