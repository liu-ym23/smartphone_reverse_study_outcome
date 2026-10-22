package cb;

import android.util.Log;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadMultiSegmentException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.exception.DownloadPCDNException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.exception.RetryCheckStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.r;
import ib.s;
import ib.y;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: classes2.dex */
public class m extends bb.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private bb.b f693l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f694m;

    class a extends ib.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f695b;

        a(m r10) {
            this.f695b = r10;
        }

        @Override // ib.a, ib.x
        public void H(List<String> r10) {
            super.H(r10);
            m.n(this.f695b, r10);
        }
    }

    class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f697b;

        b(m r10, AtomicBoolean r11) {
            this.f697b = r10;
            this.f696a = r11;
        }

        @Override // ib.r
        public void C0() {
            m r10 = this.f697b;
            monitor-enter(r10);
            this.f696a.set(true);     // Catch: Throwable -> L7
            m.o(this.f697b);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public m(bb.b r10) {
        this.f693l = r10;
    }

    private RetryCheckStatus A(BaseException r10) {
        if (com.ss.android.socialbase.downloader.utils.c.C(r10) == false) goto L5;
        q();
    L5:
        this.f542c.b(this.f544h);
        if (m() == false) goto L10;
        return RetryCheckStatus.RETURN;
    L10:
        if (r10.getErrorCode() != 1047) goto L15;
        RetryCheckStatus r11 = B(r10);
        RetryCheckStatus r12 = RetryCheckStatus.RETURN;
        if (r11 != r12) goto L20;
        return r12;
    L20:
        this.f546j.u(r10);
        return RetryCheckStatus.CONTINUE;
    L15:
        if (com.ss.android.socialbase.downloader.utils.g.N(r10) == false) goto L19;
        RetryCheckStatus r13 = C(r10);
        RetryCheckStatus r14 = RetryCheckStatus.RETURN;
        if (r13 != r14) goto L20;
        return r14;
    L19:
        y(r10);
        goto L20
    }

    private RetryCheckStatus B(BaseException r10) {
        y r11 = this.f543g.D();
        if (r11 != null) goto L5;
    L13:
        y(r10);
    L15:
        return RetryCheckStatus.CONTINUE;
    L5:
        if (this.f544h.isForbiddenRetryed() == true) goto L13;
        a r12 = new a(this);
        boolean r13 = r11.a(r12);
        this.f544h.setForbiddenRetryed();
        if (r13 == false) goto L15;
        if (r12.c0() == true) goto L15;
        this.f546j.f();
        h r14 = this.f547k;
        r14.f681f = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
        return RetryCheckStatus.RETURN;
    }

    private RetryCheckStatus C(BaseException r10) {
        s r11 = this.f543g.u();
        if (r11 == null) goto L31;
        AtomicBoolean r12 = new AtomicBoolean(false);
        b r13 = new b(this, r12);
        if ((r10 instanceof DownloadOutOfSpaceException) == false) goto L7;
        DownloadOutOfSpaceException r14 = (DownloadOutOfSpaceException) r10;
        long r15 = r14.getAvaliableSpaceBytes();
        long r16 = r14.getRequiredSpaceBytes();
        long r17 = r15;
        long r18 = r16;
    L8:
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L10:
        if (r11.a(r17, r18, r13) == false) goto L23;
        if (r12.get() == true) goto L19;
        h r19 = this.f547k;     // Catch: Throwable -> L28
        RunStatus r20 = r19.f681f;     // Catch: Throwable -> L28
        RunStatus r21 = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;     // Catch: Throwable -> L28
        if (r20 == r21) goto L16;
        r19.f681f = r21;     // Catch: Throwable -> L28
        this.f546j.f();     // Catch: Throwable -> L28
    L16:
        RetryCheckStatus r110 = RetryCheckStatus.RETURN;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return r110;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L28
        y(r10);
        return RetryCheckStatus.CONTINUE;
    L23:
        if (this.f547k.f681f != RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L27;
        RetryCheckStatus r111 = RetryCheckStatus.RETURN;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return r111;
    L27:
        throw r10;     // Catch: Throwable -> L28
    L7:
        r17 = -1;
        r18 = this.f544h.getTotalBytes();
        goto L8
    L31:
        throw r10;
    }

    private void E() {
        if (this.f544h.getRetryCount() > 0) goto L5;
        this.f544h.setRetryCount(1);
    L5:
        this.f694m = this.f544h.getRetryCount();
    }

    static /* synthetic */ void n(m r10, List r11) {
        r10.x(r11);
    }

    static /* synthetic */ void o(m r10) {
        r10.s();
    }

    private boolean p(BaseException r10) {
        if (com.ss.android.socialbase.downloader.utils.c.E(r10) == false) goto L6;
        return false;
    L6:
        if ((r10 instanceof DownloadMultiSegmentException) == false) goto L17;
        if (com.ss.android.socialbase.downloader.utils.g.R(r10) == false) goto L13;
        if (this.f694m >= this.f544h.getRetryCount()) goto L13;
        return false;
    L13:
        if (com.ss.android.socialbase.downloader.utils.c.J(r10) == false) goto L25;
        q();
        return true;
    L25:
        if (this.f694m > 0) goto L33;
        if (this.f544h.hasNextBackupUrl() == true) goto L33;
        if (com.ss.android.socialbase.downloader.utils.c.D(r10) == true) goto L31;
        return false;
    L31:
        if (this.f544h.canReplaceHttpForRetry() == true) goto L33;
        return false;
    L33:
        if ((r10 instanceof DownloadRetryNeedlessException) == false) goto L35;
        return false;
    L35:
        return true;
    L17:
        if ((r10 instanceof DownloadPCDNException) == false) goto L22;
        if (com.ss.android.socialbase.downloader.utils.g.R(r10) == false) goto L25;
        return false;
    L22:
        if (this.f547k.f688m.a(r10) == false) goto L25;
        return true;
    }

    private void q() {
        if (lb.a.a() == false) goto L10;
        lb.a.g("DownloadRetryModule", this.f544h.getId(), "clearCurrentDownloadData", "Trace:" + Log.getStackTraceString(new Throwable()));
    L10:
        this.f542c.f2(this.f544h.getId());     // Catch: Throwable -> L7
        com.ss.android.socialbase.downloader.utils.g.i(this.f544h);     // Catch: Throwable -> L7
        this.f544h.resetDataForEtagEndure("");     // Catch: Throwable -> L7
        this.f542c.b(this.f544h);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    private BaseException r(BaseException r10) {
        Throwable r11 = r10.getCause();
        if (r11 != null) goto L5;
        return r10;
    L5:
        if ((r11 instanceof BaseException) == false) goto L9;
        return (BaseException) r11;
    L9:
        return new BaseException(1089, r11);
    }

    private void s() {
        if (m() == false) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.impls.a r10 = com.ss.android.socialbase.downloader.downloader.a.s();
        if (r10 == null) goto L9;
        r10.S(this.f544h.getId());
        return;
    }

    private boolean t(BaseException r10) {
        if (r10.getErrorCode() != 1025) goto L6;
        h r11 = this.f547k;
        r11.f681f = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        return true;
    L6:
        return false;
    }

    private RetryCheckStatus w(BaseException r10) {
        if (z(r10) == false) goto L7;
        return RetryCheckStatus.CONTINUE;
    L7:
        if (t(r10) == false) goto L11;
        return RetryCheckStatus.RETURN;
    L11:
        if (p(r10) == false) goto L15;
        return A(r10);
    L15:
        throw r(r10);
    }

    private void x(List<String> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L16;
        DownloadInfo r11 = this.f544h;
        if (this.f547k.f681f != RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L9;
        boolean r12 = true;
    L10:
        r11.setForbiddenBackupUrls(r10, r12);
        com.ss.android.socialbase.downloader.impls.a r13 = com.ss.android.socialbase.downloader.downloader.a.s();
        if (r13 == null) goto L15;
        r13.S(this.f544h.getId());
        return;
    L15:
        return;
    L9:
        r12 = false;
        goto L10
    }

    private void y(BaseException r10) {
        if ((r10 instanceof DownloadMultiSegmentException) == false) goto L5;
    L10:
        boolean r11 = false;
        if (this.f694m <= 0) goto L16;
        if (r10.getErrorCode() == 1070) goto L16;
        r11 = true;
    L27:
        if (r11 == false) goto L32;
        DownloadInfo r12 = this.f544h;
        int r13 = this.f694m - 1;
        this.f694m = r13;
        r12.updateCurRetryTime(r13);
        return;
    L32:
        return;
    L16:
        if (this.f544h.trySwitchToNextBackupUrl() == false) goto L19;
        int r14 = this.f544h.getBackUpUrlRetryCount();
        this.f694m = r14;
        this.f544h.updateCurRetryTime(r14);
        goto L27
    L19:
        if (r10.getErrorCode() == 1011) goto L25;
        if (r10.getCause() == null) goto L31;
        if ((r10.getCause() instanceof SSLHandshakeException) == true) goto L25;
    L31:
        throw new BaseException(r10.getErrorCode(), String.format(Locale.US, "retry for exception, but current retry time : %s , retry Time %d all used, last error is %s", new Object[]{String.valueOf(this.f694m), Integer.valueOf(this.f544h.getRetryCount()), r10.getErrorMessage()}));
    L25:
        if (this.f544h.canReplaceHttpForRetry() == false) goto L31;
        int r15 = this.f544h.getRetryCount();
        this.f694m = r15;
        this.f544h.updateCurRetryTime(r15);
        this.f544h.setHttpsToHttpRetryUsed(true);
        goto L27
    L5:
        if ((r10 instanceof DownloadPCDNException) == true) goto L10;
        this.f547k.f689n.m(r10);
        if (this.f547k.f688m.a(r10) == false) goto L10;
        this.f547k.f688m.c();
        this.f544h.setCurNetworkRetryCount(this.f547k.f688m.d());
    }

    private boolean z(BaseException r10) {
        if (r10.getErrorCode() == 1089) goto L6;
        return false;
    L6:
        int r11 = this.f694m;
        if (r11 <= 0) goto L11;
        DownloadInfo r12 = this.f544h;
        int r13 = r11 - 1;
        this.f694m = r13;
        r12.updateCurRetryTime(r13);
        this.f544h.setStatus(5);
        return true;
    L11:
        if (this.f544h.trySwitchToNextBackupUrl() == false) goto L15;
        this.f544h.setStatus(5);
        int r14 = this.f544h.getRetryCount();
        this.f694m = r14;
        this.f544h.updateCurRetryTime(r14);
        return true;
    L15:
        throw r(r10);
    }

    @Override // bb.a, bb.e
    public void c(long r10, int r11) {
        bb.b r12 = this.f693l;
        if (r12 == null) goto L6;
        r12.i(r10, r11);
        return;
    }

    @Override // bb.a, bb.e
    public void cancel() {
        bb.b r10 = this.f693l;
        if (r10 == null) goto L6;
        r10.d();
        return;
    }

    @Override // bb.a, bb.e
    public void f() {
        bb.b r10 = this.f693l;
        if (r10 == null) goto L6;
        r10.f();
        return;
    }

    @Override // bb.a, bb.e
    public void h(boolean r10) {
        bb.b r11 = this.f693l;
        if (r11 == null) goto L6;
        r11.h(r10);
        return;
    }

    @Override // bb.e
    public void k(bb.f r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadRetryModule", this.f544h.getId(), "proceed", "Run");
    L5:
        E();
    L23:
        this.f693l.g();     // Catch: Throwable -> L8 BaseException -> L14 DownloadFileExistException -> L21
        this.f693l.b();     // Catch: Throwable -> L8 BaseException -> L14 DownloadFileExistException -> L21
    L29:
        return;
    L21:
        c.n(this.f547k);
        return;
    L14:
        e = move-exception;
        lb.a.h("DownloadRetryModule", this.f544h.getId(), "proceed", "BaseException:" + e);
        if (m() == true) goto L17;
        if (w(e) != RetryCheckStatus.RETURN) goto L23;
        return;
    L17:
        return;
    L8:
        th = move-exception;
        lb.a.h("DownloadRetryModule", this.f544h.getId(), "proceed", "Throwable:" + th);
        if (m() == false) goto L13;
        return;
    L13:
        throw new BaseException(1000, th);
    }
}
