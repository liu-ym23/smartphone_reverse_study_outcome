package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class h extends com.ss.android.socialbase.downloader.downloader.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15499a = "h";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.l f15500b;

    static {
    }

    public h() {
        this.f15500b = new m(true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int a(String r1, String r2) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> a(String r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a() {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a(int r1, int r2) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a(int r7, int r8, com.ss.android.socialbase.downloader.depend.g r9, int r10, boolean r11) {
        com.ss.android.socialbase.downloader.depend.g r12 = (com.ss.android.socialbase.downloader.depend.g) ZeusTransformUtils.wrapperContextForParams(r9, com.ss.android.socialbase.downloader.depend.g.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(r7, r8, com.ss.android.socialbase.downloader.utils.h.a(r12), com.ss.android.socialbase.downloader.utils.c.b(r10), r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a(int r8, int r9, com.ss.android.socialbase.downloader.depend.g r10, int r11, boolean r12, boolean r13) {
        com.ss.android.socialbase.downloader.depend.g r14 = (com.ss.android.socialbase.downloader.depend.g) ZeusTransformUtils.wrapperContextForParams(r10, com.ss.android.socialbase.downloader.depend.g.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r8, r9, com.ss.android.socialbase.downloader.utils.h.a(r14), com.ss.android.socialbase.downloader.utils.c.b(r11), r12, r13);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a(int r1, long r2, int r4) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2, r4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a(int r3, z r4) {
        z r5 = (z) ZeusTransformUtils.wrapperContextForParams(r4, z.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.l r2 = this.f15500b;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.a(r3, com.ss.android.socialbase.downloader.utils.h.a(r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a(int r1, boolean r2) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a(int r1, boolean r2, boolean r3) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a(aj r3) {
        aj r4 = (aj) ZeusTransformUtils.wrapperContextForParams(r3, aj.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.l r2 = this.f15500b;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.a(com.ss.android.socialbase.downloader.utils.h.a(r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a(com.ss.android.socialbase.downloader.model.a r3) {
        com.ss.android.socialbase.downloader.model.a r4 = (com.ss.android.socialbase.downloader.model.a) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.model.a.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.l r2 = this.f15500b;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.b(com.ss.android.socialbase.downloader.utils.h.a(r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.l r2 = this.f15500b;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.a(r4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean a(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean a(DownloadInfo r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public DownloadInfo b(String r1, String r2) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> b() {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> b(String r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void b(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void b(int r7, int r8, com.ss.android.socialbase.downloader.depend.g r9, int r10, boolean r11) {
        com.ss.android.socialbase.downloader.depend.g r12 = (com.ss.android.socialbase.downloader.depend.g) ZeusTransformUtils.wrapperContextForParams(r9, com.ss.android.socialbase.downloader.depend.g.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r7, r8, com.ss.android.socialbase.downloader.utils.h.a(r12), com.ss.android.socialbase.downloader.utils.c.b(r10), r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void b(int r1, boolean r2) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void b(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.l r2 = this.f15500b;
        if (r2 == null) goto L6;
        r2.b(r4);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean b(DownloadInfo r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> c(String r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> c(String r1, String r2) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void c(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.c(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void c(int r2, boolean r3) {
        com.ss.android.socialbase.downloader.downloader.l r1 = this.f15500b;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.a(r2, r3, false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean c() {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public long d(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> d(String r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void d(int r1, boolean r2) {
        com.ss.android.socialbase.downloader.downloader.c.a().b(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean d() {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int e(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.e(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> e(String r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void e() {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.e();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean f(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.f(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public DownloadInfo g(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void h(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.h(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int i(int r1) {
        return com.ss.android.socialbase.downloader.downloader.c.a().b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean j(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.j(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean k(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.k(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void l(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.l(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public z m(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return com.ss.android.socialbase.downloader.utils.h.a(r0.m(r1));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public ag n(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return com.ss.android.socialbase.downloader.utils.h.a(r0.n(r1));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public com.ss.android.socialbase.downloader.depend.e o(int r1) {
        com.ss.android.socialbase.downloader.downloader.l r0 = this.f15500b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return com.ss.android.socialbase.downloader.utils.h.a(r0.o(r1));
    }
}
