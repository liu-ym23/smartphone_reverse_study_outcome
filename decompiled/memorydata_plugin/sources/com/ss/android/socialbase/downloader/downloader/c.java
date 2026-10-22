package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f15405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile SparseArray<Boolean> f15406b;
    private volatile List<af> c;

    static {
    }

    public c() {
        this.f15406b = new SparseArray();
        this.c = new ArrayList();
    }

    public static c a() {
        if (f15405a != null) goto L13;
        monitor-enter(c.class);
        f15405a = new c();     // Catch: Throwable -> L9
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f15405a;
    }

    private List<DownloadInfo> a(List<DownloadInfo> r4, List<DownloadInfo> r5, SparseArray<DownloadInfo> r6) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        ArrayList r8 = new ArrayList();
        if (r3 == null) goto L12;
        Iterator r9 = r3.iterator();
    L6:
        if (r9.hasNext() == false) goto L12;
        DownloadInfo r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r9.next(), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        if (r6.get(r1.getId()) != null) goto L6;
        r6.put(r1.getId(), r1);
    L12:
        if (r7 == null) goto L21;
        Iterator r10 = r7.iterator();
    L15:
        if (r10.hasNext() == false) goto L21;
        DownloadInfo r11 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r10.next(), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        if (r6.get(r11.getId()) != null) goto L15;
        r6.put(r11.getId(), r11);
    L21:
        int r12 = 0;
    L23:
        if (r12 >= r6.size()) goto L28;
        DownloadInfo r13 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r6.get(r6.keyAt(r12)), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.cleaner.a.a().a(r13.getId()) == true) goto L27;
        r8.add(r13);
    L27:
        r12 = r12 + 1;
        goto L23
    L28:
        return r8;
    }

    private l b(DownloadTask r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        DownloadInfo r1 = r6.getDownloadInfo();
        if (r1 != null) goto L8;
        return null;
    L8:
        boolean r2 = false;
        if (r1.isFastDownload() == true) goto L41;
        if (r1.isNeedCurrentProcess() == true) goto L41;
        boolean r0 = r1.isNeedIndependentProcess();
        if (com.ss.android.socialbase.downloader.utils.c.c() == false) goto L16;
    L17:
        r0 = true;
    L18:
        int r3 = a(r1.getId());
        if (r3 < 0) goto L31;
        if (r3 == r0) goto L31;
        if (r3 != 1) goto L28;
        if (com.ss.android.socialbase.downloader.utils.c.a() == false) goto L43;
        com.ss.android.socialbase.downloader.impls.g.a(true).a(r1.getId(), true);     // Catch: Throwable -> L42
        DownloadInfo r7 = com.ss.android.socialbase.downloader.impls.g.a(true).g(r1.getId());     // Catch: Throwable -> L42
        if (r7 == null) goto L43;
        com.ss.android.socialbase.downloader.impls.g.a(false).b(r7);     // Catch: Throwable -> L42
    L43:
        goto L31
    L28:
        if (com.ss.android.socialbase.downloader.utils.c.a() == false) goto L30;
        com.ss.android.socialbase.downloader.impls.g.a(false).a(r1.getId(), true);     // Catch: Throwable -> L42
        goto L43
    L30:
        r6.setNeedDelayForCacheSync(true);     // Catch: Throwable -> L42
        com.ss.android.socialbase.downloader.impls.g.a(true).a(1, r1.getId());     // Catch: Throwable -> L42
    L31:
        int r8 = r1.getId();
        if (r0 != true) goto L34;
        boolean r4 = true;
    L35:
        a(r8, r4);
        if (r0 != true) goto L39;
        r2 = true;
    L39:
        return com.ss.android.socialbase.downloader.impls.g.a(r2);
    L34:
        r4 = false;
        goto L35
    L16:
        if (com.ss.android.socialbase.downloader.utils.c.a() == true) goto L18;
    L41:
        return com.ss.android.socialbase.downloader.impls.g.a(false);
    }

    public int a(int r3) {
        if (b.X() == true) goto L7;
        return -1;
    L7:
        if (com.ss.android.socialbase.downloader.utils.c.c() == true) goto L13;
        if (com.ss.android.socialbase.downloader.impls.g.a(true).f() == false) goto L13;
        return com.ss.android.socialbase.downloader.impls.g.a(true).i(r3);
    L13:
        return b(r3);
    }

    public int a(String r1, String r2) {
        return b.a(r1, r2);
    }

    public List<DownloadInfo> a(String r5) {
        List<DownloadInfo> r4 = com.ss.android.socialbase.downloader.impls.g.a(false).a(r5);
        List<DownloadInfo> r6 = com.ss.android.socialbase.downloader.impls.g.a(true).a(r5);
        if (r4 != null) goto L8;
        if (r6 != null) goto L8;
        return null;
    L8:
        if (r4 == null) goto L15;
        Iterator<DownloadInfo> r1 = r4.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        DownloadInfo r2 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r1.next(), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.cleaner.a.a().a(r2.getId()) == false) goto L11;
        r1.remove();
    L15:
        if (r6 == null) goto L22;
        Iterator<DownloadInfo> r3 = r6.iterator();
    L18:
        if (r3.hasNext() == false) goto L22;
        DownloadInfo r7 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r3.next(), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.cleaner.a.a().a(r7.getId()) == false) goto L18;
        r3.remove();
    L22:
        if (r4 == null) goto L26;
        if (r6 == null) goto L26;
        ArrayList r0 = new ArrayList(r4);
        r0.addAll(r6);
        return r0;
    L26:
        if (r4 == null) goto L29;
        return r4;
    L29:
        return r6;
    }

    public void a(int r1, long r2, int r4) {
        l r0 = c(r1);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2, r4);
    }

    public void a(int r7, IDownloadListener r8, ListenerType r9, boolean r10) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r8, IDownloadListener.class, "com.obric.memorydata.plugin");
        l r0 = c(r7);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        int r6 = 0;
    L8:
        r0.b(r7, r6, r3, r9, r10);
        return;
    L7:
        r6 = r3.hashCode();
        goto L8
    }

    public void a(int r8, IDownloadListener r9, ListenerType r10, boolean r11, boolean r12) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadListener.class, "com.obric.memorydata.plugin");
        l r0 = c(r8);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r8, r3.hashCode(), r3, r10, r11, r12);
    }

    public void a(int r3, aa r4) {
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");
        l r2 = c(r3);
        if (r2 != null) goto L5;
        return;
    L5:
        r2.a(r3, r5);
    }

    public void a(int r3, boolean r4) {
        b(r3, r4);
        if (b.X() == false) goto L10;
        if (com.ss.android.socialbase.downloader.utils.c.c() == true) goto L10;
        if (com.ss.android.socialbase.downloader.impls.g.a(true).f() == false) goto L10;
        com.ss.android.socialbase.downloader.impls.g.a(true).c(r3, r4);
    L10:
        if (b.c() == false) goto L12;
        return;
    L12:
        if (com.ss.android.socialbase.downloader.utils.c.c() == false) goto L14;
        return;
    L14:
        if (com.ss.android.socialbase.downloader.utils.c.a() == true) goto L24;
        Intent r2 = new Intent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), DownloadHandleService.class);     // Catch: Throwable -> L17
        r2.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");     // Catch: Throwable -> L17
        r2.putExtra("extra_download_id", r3);     // Catch: Throwable -> L17
        ZeusTransformUtils.startService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void a(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (com.ss.android.socialbase.downloader.utils.c.c() == false) goto L10;
        r4.a();
        return;
    L10:
        if (com.ss.android.socialbase.downloader.impls.g.a(true).f() == false) goto L12;
        r4.a();
    L12:
        List<af> r0 = this.c;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (this.c.contains(r4) == true) goto L17;
        this.c.add(r4);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
    }

    public void a(com.ss.android.socialbase.downloader.depend.i r2) {
        b.a((com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin"));
    }

    public void a(final DownloadTask r5) {
        final l r0 = b(r5);
        if (r0 != null) goto L11;
        if (r5 == null) goto L16;
        IDownloadMonitorDepend r4 = r5.getMonitorDepend();
        DownloadInfo r1 = r5.getDownloadInfo();
        BaseException r2 = new BaseException(1003, "tryDownload but getDownloadHandler failed");
        if (r5.getDownloadInfo() == null) goto L8;
        int r6 = r5.getDownloadInfo().getStatus();
    L9:
        com.ss.android.socialbase.downloader.f.a.a(r4, r1, r2, r6);
        return;
    L8:
        r6 = 0;
        goto L9
    L16:
        return;
    L11:
        com.ss.android.socialbase.downloader.cleaner.a.a().b(r5.getDownloadId());
        if (r5.isNeedDelayForCacheSync() == false) goto L14;
        b.a(new AnonymousClass1(this, r0, r5), 500, TimeUnit.MILLISECONDS);
        return;
    L14:
        r0.a(r5);
    }

    public void a(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        l r3 = com.ss.android.socialbase.downloader.impls.g.a(false);
        if (r3 == null) goto L5;
        r3.a(r1);
    L5:
        l r4 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r4 == null) goto L9;
        r4.a(r1);
        return;
    }

    public boolean a(DownloadInfo r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        l r2 = c(r3.getId());
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.a(r3);
    }

    public synchronized int b(int r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f15406b.get(r3) == null) goto L6;
        boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(this.f15406b.get(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4 ? 1 : 0;
    L6:
        monitor-exit(this);
        return -1;
    }

    public DownloadInfo b(String r2, String r3) {
        int r4 = a(r2, r3);
        if (com.ss.android.socialbase.downloader.cleaner.a.a().a(r4) == false) goto L5;
        return null;
    L5:
        l r1 = c(r4);
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.g(r4);
    }

    public List<DownloadInfo> b(String r5) {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        l r1 = com.ss.android.socialbase.downloader.impls.g.a(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.b(r5);
    L6:
        l r4 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r4 == null) goto L10;
        r2 = r4.b(r5);
    L10:
        return a(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public void b() {
        List<af> r0 = this.c;
        monitor-enter(r0);
        Iterator<af> r4 = this.c.iterator();     // Catch: Throwable -> L12
    L6:
        if (r4.hasNext() == false) goto L10;
        af r1 = (af) ZeusTransformUtils.preCheckCast(r4.next(), af.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L6;
        r1.a();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void b(int r7, IDownloadListener r8, ListenerType r9, boolean r10) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r8, IDownloadListener.class, "com.obric.memorydata.plugin");
        l r0 = c(r7);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r7, r3.hashCode(), r3, r9, r10);
    }

    public synchronized void b(int r2, boolean r3) {
        monitor-enter(this);
        SparseArray<Boolean> r0 = this.f15406b;     // Catch: Throwable -> L10
        if (r3 == false) goto L6;
        Boolean r4 = Boolean.TRUE;     // Catch: Throwable -> L10
    L7:
        r0.put(r2, r4);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r4 = Boolean.FALSE;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void b(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        List<af> r0 = this.c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.c.contains(r4) == false) goto L10;
        this.c.remove(r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void b(com.ss.android.socialbase.downloader.depend.i r2) {
        b.b((com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin"));
    }

    public void b(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        l r3 = com.ss.android.socialbase.downloader.impls.g.a(false);
        if (r3 == null) goto L5;
        r3.b(r1);
    L5:
        l r4 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r4 == null) goto L9;
        r4.b(r1);
        return;
    }

    public l c(int r1) {
        int r0 = a(r1);
        boolean r2 = true;
        if (r0 == 1) goto L5;
    L7:
        r2 = false;
    L9:
        return com.ss.android.socialbase.downloader.impls.g.a(r2);
    L5:
        if (com.ss.android.socialbase.downloader.utils.c.c() == true) goto L7;
        goto L7
    }

    public List<DownloadInfo> c(String r5) {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        l r1 = com.ss.android.socialbase.downloader.impls.g.a(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.c(r5);
    L6:
        l r4 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r4 == null) goto L10;
        r2 = r4.c(r5);
    L10:
        return a(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public void c() {
        l r0 = com.ss.android.socialbase.downloader.impls.g.a(false);
        if (r0 == null) goto L5;
        r0.a();
    L5:
        l r1 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r1 == null) goto L9;
        r1.a();
        return;
    }

    public void c(int r3, boolean r4) {
        if (com.ss.android.socialbase.downloader.utils.c.a() == false) goto L10;
        l r2 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r2 == null) goto L7;
        r2.b(r3, r4);
    L7:
        l r5 = com.ss.android.socialbase.downloader.impls.g.a(false);
        if (r5 == null) goto L15;
        r5.b(r3, r4);
        return;
    L15:
        return;
    L10:
        l r6 = c(r3);
        if (r6 == null) goto L13;
        r6.b(r3, r4);
    L13:
        com.ss.android.socialbase.downloader.impls.g.a(true).a(2, r3);
    }

    public List<DownloadInfo> d(String r5) {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        l r1 = com.ss.android.socialbase.downloader.impls.g.a(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.d(r5);
    L6:
        l r4 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r4 == null) goto L10;
        r2 = r4.d(r5);
    L10:
        return a(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public void d(int r2) {
        l r1 = c(r2);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.a(r2, false);
    }

    public void d(int r2, boolean r3) {
        l r1 = c(r2);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.a(r2, r3, true);
    }

    public boolean d() {
        return b.T();
    }

    public List<DownloadInfo> e() {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        l r1 = com.ss.android.socialbase.downloader.impls.g.a(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.c();
    L6:
        l r4 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r4 == null) goto L10;
        r2 = r4.c();
    L10:
        return a(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public List<DownloadInfo> e(String r5) {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        l r1 = com.ss.android.socialbase.downloader.impls.g.a(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.e(r5);
    L6:
        l r4 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r4 == null) goto L10;
        r2 = r4.e(r5);
    L10:
        return a(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public boolean e(int r1) {
        l r0 = c(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r1);
    }

    public void f(int r1) {
        l r0 = c(r1);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(r1);
    }

    public boolean f() {
        l r0 = com.ss.android.socialbase.downloader.impls.g.a(false);
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.d();
    }

    public void g(int r1) {
        l r0 = c(r1);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.c(r1);
    }

    public long h(int r2) {
        l r1 = c(r2);
        if (r1 != null) goto L5;
        return 0;
    L5:
        if (com.ss.android.socialbase.downloader.cleaner.a.a().a(r2) == false) goto L8;
        return 0;
    L8:
        return r1.d(r2);
    }

    public int i(int r1) {
        l r0 = c(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.e(r1);
    }

    public boolean j(int r1) {
        l r0 = c(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.f(r1);
    }

    public DownloadInfo k(int r3) {
        l r2 = c(r3);
        if (r2 != null) goto L6;
        return null;
    L6:
        if (com.ss.android.socialbase.downloader.cleaner.a.a().a(r3) == false) goto L9;
        return null;
    L9:
        return r2.g(r3);
    }

    public aa l(int r1) {
        l r0 = c(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m(r1);
    }

    public void m(int r1) {
        l r0 = com.ss.android.socialbase.downloader.impls.g.a(false);
        if (r0 == null) goto L5;
        r0.h(r1);
    L5:
        l r2 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r2 == null) goto L9;
        r2.h(r1);
        return;
    }

    public void n(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        b(r2, Boolean.TRUE.booleanValue());
        l r1 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r1 != null) goto L7;
        return;
    L7:
        r1.startService();
    }

    public com.ss.android.socialbase.downloader.depend.t o(int r1) {
        l r0 = c(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o(r1);
    }
}
