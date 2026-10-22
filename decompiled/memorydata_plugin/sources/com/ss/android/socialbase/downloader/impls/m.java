package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class m implements com.ss.android.socialbase.downloader.downloader.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f15518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.h f15519b;
    private final com.ss.android.socialbase.downloader.downloader.n c;
    private final boolean d;

    public m() {
        this(false);
    }

    public m(boolean r2) {
        this.f15518a = com.ss.android.socialbase.downloader.downloader.b.F();
        this.f15519b = com.ss.android.socialbase.downloader.downloader.b.C();
        if (r2 == true) goto L5;
        com.ss.android.socialbase.downloader.downloader.n r3 = com.ss.android.socialbase.downloader.downloader.b.D();
    L6:
        this.c = r3;
        if (com.ss.android.socialbase.downloader.g.a.c().b("single_async_handle_operation") <= 0) goto L9;
        boolean r4 = true;
    L10:
        this.d = r4;
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = com.ss.android.socialbase.downloader.downloader.b.E();
        goto L6
    }

    static /* synthetic */ a a(m r0) {
        return r0.f15518a;
    }

    private void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.d == false) goto L5;
        com.ss.android.socialbase.downloader.downloader.b.d(r4);
        return;
    L5:
        r4.run();
    }

    static /* synthetic */ com.ss.android.socialbase.downloader.downloader.n b(m r0) {
        return r0.c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int a(String r1, String r2) {
        return com.ss.android.socialbase.downloader.downloader.b.a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> a(String r1) {
        return this.f15518a.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a() {
        a(new AnonymousClass8(this));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r4, int r5) {
        if (com.ss.android.socialbase.downloader.downloader.b.e() == null) goto L10;
        Iterator<ak> r3 = com.ss.android.socialbase.downloader.downloader.b.e().iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        ak r0 = (ak) ZeusTransformUtils.preCheckCast(r3.next(), ak.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.a(r5, r4);
        goto L6
    L16:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r7, int r8, IDownloadListener r9, ListenerType r10, boolean r11) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadListener.class, "com.obric.memorydata.plugin");
        this.f15518a.b(r7, r8, r3, r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r8, int r9, IDownloadListener r10, ListenerType r11, boolean r12, boolean r13) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadListener.class, "com.obric.memorydata.plugin");
        this.f15518a.a(r8, r9, r3, r11, r12, r13);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(final int r8, final long r9, final int r11) {
        a(new AnonymousClass4(this, r8, r9, r11));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int r3, aa r4) {
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");
        this.f15518a.a(r3, r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(final int r2, boolean r3) {
        Runnable r0 = new AnonymousClass1(this, r2);
        if (r3 == false) goto L5;
        r0.run();
        return;
    L5:
        a(r0);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(final int r2, final boolean r3, final boolean r4) {
        a(new AnonymousClass11(this, r2, r3, r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(ak r2) {
        com.ss.android.socialbase.downloader.downloader.b.a((ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(final DownloadTask r2) {
        com.ss.android.socialbase.downloader.downloader.b.a(r2, true);
        a(new AnonymousClass2(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(List<String> r3) {
        final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        a(new AnonymousClass9(this, r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean a(int r1) {
        a r0 = this.f15518a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.l(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean a(DownloadInfo r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r0 = com.ss.android.socialbase.downloader.utils.g.a(r4.getStatus(), r4.getSavePath(), r4.getName());
        if (r0 == false) goto L8;
        d(r4.getId(), true);
    L8:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public DownloadInfo b(String r1, String r2) {
        return g(com.ss.android.socialbase.downloader.downloader.b.a(r1, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> b(String r1) {
        return this.f15519b.b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(final int r2) {
        a(new AnonymousClass6(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(int r7, int r8, IDownloadListener r9, ListenerType r10, boolean r11) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadListener.class, "com.obric.memorydata.plugin");
        this.f15518a.a(r7, r8, r3, r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(final int r2, final boolean r3) {
        a(new AnonymousClass5(this, r2, r3));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(DownloadInfo r1) {
        this.f15519b.b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(final DownloadTask r2) {
        com.ss.android.socialbase.downloader.downloader.b.a(r2, true);
        a(new AnonymousClass3(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(List<String> r3) {
        final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        a(new AnonymousClass10(this, r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean b() {
        return com.ss.android.socialbase.downloader.downloader.b.T();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> c() {
        com.ss.android.socialbase.downloader.downloader.h r0 = this.f15519b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> c(String r1) {
        return this.f15519b.c(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> c(String r1, String r2) {
        com.ss.android.socialbase.downloader.downloader.h r0 = this.f15519b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void c(final int r2) {
        a(new AnonymousClass7(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void c(int r1, boolean r2) {
        com.ss.android.socialbase.downloader.downloader.c.a().a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean c(DownloadInfo r1) {
        return this.f15519b.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public long d(int r3) {
        com.ss.android.socialbase.downloader.downloader.h r2 = this.f15519b;
        if (r2 != null) goto L5;
        return 0;
    L5:
        DownloadInfo r4 = r2.b(r3);
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.getCurBytes();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> d(String r1) {
        return this.f15518a.b(r1);
    }

    public void d(final int r2, final boolean r3) {
        a(new AnonymousClass12(this, r2, r3));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean d() {
        return this.f15519b.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int e(int r1) {
        DownloadInfo r0 = this.f15518a.d(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> e(String r1) {
        return this.f15519b.d(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void e() {
        this.f15519b.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean f() {
        com.ss.android.socialbase.downloader.downloader.n r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b() == false) goto L7;
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean f(int r1) {
        return this.f15518a.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public DownloadInfo g(int r1) {
        return this.f15518a.d(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void h(int r1) {
        com.ss.android.socialbase.downloader.e.a.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int i(int r1) {
        return com.ss.android.socialbase.downloader.downloader.c.a().a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean j(int r1) {
        return this.f15519b.c(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean k(int r1) {
        return this.f15519b.d(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void l(int r1) {
        this.f15519b.i(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public aa m(int r1) {
        return this.f15518a.i(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public ah n(int r1) {
        ah r0 = this.f15518a.h(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return com.ss.android.socialbase.downloader.downloader.b.O();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public t o(int r1) {
        return this.f15518a.j(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void startService() {
    }
}
