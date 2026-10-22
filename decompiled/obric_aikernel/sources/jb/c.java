package jb;

import android.content.Intent;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.a0;
import ib.b0;
import ib.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile c f9806c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile SparseArray<Boolean> f9807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile List<i0> f9808b;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ m f9809c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f9810g;

        a(c r10, m r11, com.ss.android.socialbase.downloader.model.d r12) {
            this.f9809c = r11;
            this.f9810g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9809c.y(this.f9810g);
        }
    }

    static {
    }

    public c() {
        this.f9807a = new SparseArray();
        this.f9808b = new ArrayList();
    }

    private m e(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        DownloadInfo r11 = r10.y();
        if (r11 != null) goto L8;
        return null;
    L8:
        boolean r12 = false;
        if (r11.isFastDownload() == true) goto L41;
        if (r11.isNeedCurrentProcess() == true) goto L41;
        boolean r13 = r11.isNeedIndependentProcess();
        if (com.ss.android.socialbase.downloader.utils.c.A() == false) goto L16;
    L17:
        r13 = true;
    L18:
        int r14 = g(r11.getId());
        if (r14 < 0) goto L31;
        if (r14 == r13) goto L31;
        if (r14 != 1) goto L28;
        if (com.ss.android.socialbase.downloader.utils.c.F() == false) goto L43;
        com.ss.android.socialbase.downloader.impls.g.a(true).o0(r11.getId(), true);     // Catch: Throwable -> L42
        DownloadInfo r15 = com.ss.android.socialbase.downloader.impls.g.a(true).a(r11.getId());     // Catch: Throwable -> L42
        if (r15 == null) goto L43;
        com.ss.android.socialbase.downloader.impls.g.a(false).v(r15);     // Catch: Throwable -> L42
    L43:
        goto L31
    L28:
        if (com.ss.android.socialbase.downloader.utils.c.F() == false) goto L30;
        com.ss.android.socialbase.downloader.impls.g.a(false).o0(r11.getId(), true);     // Catch: Throwable -> L42
        goto L43
    L30:
        r10.f0(true);     // Catch: Throwable -> L42
        com.ss.android.socialbase.downloader.impls.g.a(true).J0(1, r11.getId());     // Catch: Throwable -> L42
    L31:
        int r16 = r11.getId();
        if (r13 != true) goto L34;
        boolean r17 = true;
    L35:
        t(r16, r17);
        if (r13 != true) goto L39;
        r12 = true;
    L39:
        return com.ss.android.socialbase.downloader.impls.g.a(r12);
    L34:
        r17 = false;
        goto L35
    L16:
        if (com.ss.android.socialbase.downloader.utils.c.F() == true) goto L18;
    L41:
        return com.ss.android.socialbase.downloader.impls.g.a(false);
    }

    public static c i() {
        if (f9806c != null) goto L13;
        monitor-enter(c.class);
        f9806c = new c();     // Catch: Throwable -> L9
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f9806c;
    }

    public void a(int r10, a0 r11, ListenerType r12, boolean r13) {
        m r14 = d(r10);
        if (r14 != null) goto L5;
        return;
    L5:
        r14.I(r10, r11.hashCode(), r11, r12, r13);
    }

    public void b(int r10, boolean r11) {
        if (com.ss.android.socialbase.downloader.utils.c.F() == false) goto L10;
        m r12 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r12 == null) goto L7;
        r12.q(r10, r11);
    L7:
        m r13 = com.ss.android.socialbase.downloader.impls.g.a(false);
        if (r13 == null) goto L15;
        r13.q(r10, r11);
        return;
    L15:
        return;
    L10:
        m r14 = d(r10);
        if (r14 == null) goto L13;
        r14.q(r10, r11);
    L13:
        com.ss.android.socialbase.downloader.impls.g.a(true).J0(2, r10);
    }

    public void c() {
        List<i0> r10 = this.f9808b;
        monitor-enter(r10);
        Iterator<i0> r11 = this.f9808b.iterator();     // Catch: Throwable -> L12
    L6:
        if (r11.hasNext() == false) goto L10;
        i0 r12 = r11.next();     // Catch: Throwable -> L12
        if (r12 == null) goto L6;
        r12.a();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public m d(int r10) {
        int r11 = g(r10);
        boolean r12 = true;
        if (r11 == 1) goto L5;
    L7:
        r12 = false;
    L9:
        return com.ss.android.socialbase.downloader.impls.g.a(r12);
    L5:
        if (com.ss.android.socialbase.downloader.utils.c.A() == true) goto L7;
        goto L7
    }

    @Nullable
    public DownloadInfo f(int r10) {
        m r11 = d(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        if (com.ss.android.socialbase.downloader.cleaner.a.b().d(r10) == false) goto L9;
        return null;
    L9:
        return r11.a(r10);
    }

    public int g(int r10) {
        if (com.ss.android.socialbase.downloader.downloader.a.N0() == true) goto L7;
        return -1;
    L7:
        if (com.ss.android.socialbase.downloader.utils.c.A() == true) goto L13;
        if (com.ss.android.socialbase.downloader.impls.g.a(true).A() == false) goto L13;
        return com.ss.android.socialbase.downloader.impls.g.a(true).y0(r10);
    L13:
        return h(r10);
    }

    public synchronized int h(int r10) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f9807a.get(r10) == null) goto L6;
        boolean r11 = this.f9807a.get(r10).booleanValue();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r11 ? 1 : 0;
    L6:
        monitor-exit(this);
        return -1;
    }

    public int j(int r10) {
        m r11 = d(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.n(r10);
    }

    public boolean k(int r10) {
        m r11 = d(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.o(r10);
    }

    public void l(int r10) {
        m r11 = d(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        r11.o0(r10, false);
    }

    public void m() {
        m r10 = com.ss.android.socialbase.downloader.impls.g.a(false);
        if (r10 == null) goto L5;
        r10.u();
    L5:
        m r11 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r11 == null) goto L9;
        r11.u();
        return;
    }

    public void n(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        s(r10, true);
        m r11 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r11 != null) goto L7;
        return;
    L7:
        r11.B();
    }

    public void o(int r10) {
        m r11 = d(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        r11.z(r10);
    }

    public void p(List<String> r10) {
        m r11 = com.ss.android.socialbase.downloader.impls.g.a(false);
        if (r11 == null) goto L5;
        r11.w(r10);
    L5:
        m r12 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r12 == null) goto L9;
        r12.w(r10);
        return;
    }

    public void q(List<String> r10) {
        m r11 = com.ss.android.socialbase.downloader.impls.g.a(false);
        if (r11 == null) goto L5;
        r11.r(r10);
    L5:
        m r12 = com.ss.android.socialbase.downloader.impls.g.a(true);
        if (r12 == null) goto L9;
        r12.r(r10);
        return;
    }

    public void r(int r10) {
        m r11 = d(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        r11.s(r10);
    }

    public synchronized void s(int r10, boolean r11) {
        monitor-enter(this);
        SparseArray<Boolean> r12 = this.f9807a;     // Catch: Throwable -> L10
        if (r11 == false) goto L6;
        Boolean r13 = Boolean.TRUE;     // Catch: Throwable -> L10
    L7:
        r12.put(r10, r13);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r13 = Boolean.FALSE;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void t(int r10, boolean r11) {
        s(r10, r11);
        if (com.ss.android.socialbase.downloader.downloader.a.N0() == false) goto L10;
        if (com.ss.android.socialbase.downloader.utils.c.A() == true) goto L10;
        if (com.ss.android.socialbase.downloader.impls.g.a(true).A() == false) goto L10;
        com.ss.android.socialbase.downloader.impls.g.a(true).D(r10, r11);
    L10:
        if (com.ss.android.socialbase.downloader.downloader.a.X() == false) goto L12;
        return;
    L12:
        if (com.ss.android.socialbase.downloader.utils.c.A() == false) goto L14;
        return;
    L14:
        if (com.ss.android.socialbase.downloader.utils.c.F() == true) goto L24;
        Intent r12 = new Intent(com.ss.android.socialbase.downloader.downloader.a.h(), DownloadHandleService.class);     // Catch: Throwable -> L17
        r12.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");     // Catch: Throwable -> L17
        r12.putExtra("extra_download_id", r10);     // Catch: Throwable -> L17
        com.ss.android.socialbase.downloader.downloader.a.h().startService(r12);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void u(int r10, boolean r11) {
        m r12 = d(r10);
        if (r12 != null) goto L5;
        return;
    L5:
        r12.p(r10, r11);
    }

    public void v(int r10, long r11, int r12) {
        m r13 = d(r10);
        if (r13 != null) goto L5;
        return;
    L5:
        r13.t(r10, r11, r12);
    }

    public void w(com.ss.android.socialbase.downloader.model.d r10) {
        m r11 = e(r10);
        if (r11 != null) goto L11;
        if (r10 == null) goto L16;
        b0 r12 = r10.G();
        DownloadInfo r13 = r10.y();
        BaseException r14 = new BaseException(PointerIconCompat.TYPE_HELP, "tryDownload but getDownloadHandler failed");
        if (r10.y() == null) goto L8;
        int r15 = r10.y().getStatus();
    L9:
        mb.a.n(r12, r13, r14, r15);
        return;
    L8:
        r15 = 0;
        goto L9
    L16:
        return;
    L11:
        com.ss.android.socialbase.downloader.cleaner.a.b().e(r10.x());
        if (r10.P() == false) goto L14;
        com.ss.android.socialbase.downloader.downloader.a.L0(new a(this, r11, r10), 500, TimeUnit.MILLISECONDS);
        return;
    L14:
        r11.y(r10);
    }
}
