package com.ss.android.socialbase.downloader.b.a;

import android.util.Log;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadMultiSegmentException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.exception.DownloadPCDNException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.exception.RetryCheckStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: classes6.dex */
public class n extends com.ss.android.socialbase.downloader.b.a {
    private com.ss.android.socialbase.downloader.b.b g;
    private int h;

    public n(com.ss.android.socialbase.downloader.b.b r1) {
        this.g = r1;
    }

    private RetryCheckStatus a(BaseException r2) {
        if (b(r2) == false) goto L7;
        return RetryCheckStatus.CONTINUE;
    L7:
        if (d(r2) == false) goto L11;
        return RetryCheckStatus.RETURN;
    L11:
        if (e(r2) == false) goto L15;
        return f(r2);
    L15:
        throw c(r2);
    }

    static /* synthetic */ void a(n r0) {
        r0.e();
    }

    static /* synthetic */ void a(n r2, List r3) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private void a(List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L17;
        DownloadInfo r0 = this.c;
        if (this.f.f != RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L10;
        boolean r1 = true;
    L11:
        r0.setForbiddenBackupUrls(r5, r1);
        com.ss.android.socialbase.downloader.impls.a r6 = com.ss.android.socialbase.downloader.downloader.b.F();
        if (r6 == null) goto L16;
        r6.k(this.c.getId());
        return;
    L16:
        return;
    L10:
        r1 = false;
        goto L11
    }

    private boolean b(BaseException r4) {
        if (r4.getErrorCode() == 1089) goto L7;
        return false;
    L7:
        if (this.h <= 0) goto L11;
        DownloadInfo r5 = this.c;
        int r0 = this.h - 1;
        this.h = r0;
        r5.updateCurRetryTime(r0);
        this.c.setStatus(5);
        return true;
    L11:
        if (this.c.trySwitchToNextBackupUrl() == false) goto L15;
        this.c.setStatus(5);
        this.h = this.c.getRetryCount();
        this.c.updateCurRetryTime(this.h);
        return true;
    L15:
        throw c(r4);
    }

    private BaseException c(BaseException r2) {
        Throwable r1 = r2.getCause();
        if (r1 != null) goto L5;
        return r2;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, BaseException.class) == false) goto L9;
        return (BaseException) ZeusTransformUtils.preCheckCast(r1, BaseException.class, "com.obric.memorydata.plugin");
    L9:
        return new BaseException(1089, r1);
    }

    private void d() {
        if (this.c.getRetryCount() > 0) goto L5;
        this.c.setRetryCount(1);
    L5:
        this.h = this.c.getRetryCount();
    }

    private boolean d(BaseException r2) {
        if (r2.getErrorCode() != 1025) goto L6;
        i r1 = this.f;
        r1.f = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        return true;
    L6:
        return false;
    }

    private void e() {
        if (j_() == false) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.impls.a r0 = com.ss.android.socialbase.downloader.downloader.b.F();
        if (r0 == null) goto L9;
        r0.k(this.c.getId());
        return;
    }

    private boolean e(BaseException r5) {
        if (com.ss.android.socialbase.downloader.utils.c.g(r5) == false) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DownloadMultiSegmentException.class) == false) goto L17;
        if (com.ss.android.socialbase.downloader.utils.g.b(r5) == false) goto L13;
        if (this.h >= this.c.getRetryCount()) goto L13;
        return false;
    L13:
        if (com.ss.android.socialbase.downloader.utils.c.b(r5) == false) goto L25;
        f();
        return true;
    L25:
        if (this.h > 0) goto L33;
        if (this.c.hasNextBackupUrl() == true) goto L33;
        if (com.ss.android.socialbase.downloader.utils.c.c(r5) == true) goto L31;
        return false;
    L31:
        if (this.c.canReplaceHttpForRetry() == true) goto L33;
        return false;
    L33:
        if (ZeusTransformUtils.instanceOf(r5, DownloadRetryNeedlessException.class) == false) goto L35;
        return false;
    L35:
        return true;
    L17:
        if (ZeusTransformUtils.instanceOf(r5, DownloadPCDNException.class) == false) goto L22;
        if (com.ss.android.socialbase.downloader.utils.g.b(r5) == false) goto L25;
        return false;
    L22:
        if (this.f.m.a(r5) == false) goto L25;
        return true;
    }

    private RetryCheckStatus f(BaseException r3) {
        if (com.ss.android.socialbase.downloader.utils.c.a(r3) == false) goto L5;
        f();
    L5:
        this.f15249a.a(this.c);
        if (j_() == false) goto L10;
        return RetryCheckStatus.RETURN;
    L10:
        if (r3.getErrorCode() != 1047) goto L16;
        if (g(r3) == RetryCheckStatus.RETURN) goto L14;
    L22:
        this.e.a(r3);
        return RetryCheckStatus.CONTINUE;
    L14:
        return RetryCheckStatus.RETURN;
    L16:
        if (com.ss.android.socialbase.downloader.utils.g.c(r3) == true) goto L18;
        i(r3);
        goto L22
    L18:
        if (h(r3) != RetryCheckStatus.RETURN) goto L22;
        return RetryCheckStatus.RETURN;
    }

    private void f() {
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L10;
        com.ss.android.socialbase.downloader.e.a.a("DownloadRetryModule", this.c, "clearCurrentDownloadData", "Trace:" + Log.getStackTraceString(new Throwable()));
    L10:
        this.f15249a.l(this.c.getId());     // Catch: Throwable -> L7
        com.ss.android.socialbase.downloader.utils.g.c(this.c);     // Catch: Throwable -> L7
        this.c.resetDataForEtagEndure("");     // Catch: Throwable -> L7
        this.f15249a.a(this.c);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    private RetryCheckStatus g(BaseException r3) {
        x r0 = this.f15250b.getForbiddenHandler();
        if (r0 != null) goto L5;
    L13:
        i(r3);
    L15:
        return RetryCheckStatus.CONTINUE;
    L5:
        if (this.c.isForbiddenRetryed() == true) goto L13;
        com.ss.android.socialbase.downloader.depend.a r4 = new AnonymousClass1(this);
        boolean r1 = r0.a(r4);
        this.c.setForbiddenRetryed();
        if (r1 == false) goto L15;
        if (r4.a() == true) goto L15;
        this.e.i();
        i r2 = this.f;
        r2.f = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
        return RetryCheckStatus.RETURN;
    }

    private RetryCheckStatus h(BaseException r8) {
        r r1 = this.f15250b.getDiskSpaceHandler();
        if (r1 == null) goto L31;
        final AtomicBoolean r0 = new AtomicBoolean(false);
        q r6 = new AnonymousClass2(this, r0);
        if (ZeusTransformUtils.instanceOf(r8, DownloadOutOfSpaceException.class) == false) goto L7;
        long r2 = ((DownloadOutOfSpaceException) ZeusTransformUtils.preCheckCast(r8, DownloadOutOfSpaceException.class, "com.obric.memorydata.plugin")).getAvaliableSpaceBytes();
        long r4 = ((DownloadOutOfSpaceException) ZeusTransformUtils.preCheckCast(r8, DownloadOutOfSpaceException.class, "com.obric.memorydata.plugin")).getRequiredSpaceBytes();
    L8:
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L10:
        if (r1.a(r2, r4, r6) == false) goto L23;
        if (r0.get() == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L28
        i(r8);
        return RetryCheckStatus.CONTINUE;
    L14:
        if (this.f.f == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L16;
        i r9 = this.f;     // Catch: Throwable -> L28
        r9.f = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;     // Catch: Throwable -> L28
        this.e.i();     // Catch: Throwable -> L28
    L16:
        RetryCheckStatus r10 = RetryCheckStatus.RETURN;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return r10;
    L23:
        if (this.f.f != RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L27;
        RetryCheckStatus r11 = RetryCheckStatus.RETURN;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return r11;
    L27:
        throw r8;     // Catch: Throwable -> L28
    L7:
        r2 = -1;
        r4 = this.c.getTotalBytes();
        goto L8
    L31:
        throw r8;
    }

    private void i(BaseException r8) {
        if (ZeusTransformUtils.instanceOf(r8, DownloadMultiSegmentException.class) == false) goto L5;
    L10:
        boolean r1 = false;
        if (this.h <= 0) goto L16;
        if (r8.getErrorCode() == 1070) goto L16;
        r1 = true;
    L27:
        if (r1 == false) goto L32;
        DownloadInfo r9 = this.c;
        int r0 = this.h - 1;
        this.h = r0;
        r9.updateCurRetryTime(r0);
        return;
    L32:
        return;
    L16:
        if (this.c.trySwitchToNextBackupUrl() == false) goto L19;
        this.h = this.c.getBackUpUrlRetryCount();
        this.c.updateCurRetryTime(this.h);
        goto L27
    L19:
        if (r8.getErrorCode() == 1011) goto L25;
        if (r8.getCause() == null) goto L31;
        if (ZeusTransformUtils.instanceOf(r8.getCause(), SSLHandshakeException.class) == true) goto L25;
    L31:
        throw new BaseException(r8.getErrorCode(), String.format(Locale.US, "retry for exception, but current retry time : %s , retry Time %d all used, last error is %s", new Object[]{String.valueOf(this.h), Integer.valueOf(this.c.getRetryCount()), r8.getErrorMessage()}));
    L25:
        if (this.c.canReplaceHttpForRetry() == false) goto L31;
        this.h = this.c.getRetryCount();
        this.c.updateCurRetryTime(this.h);
        this.c.setHttpsToHttpRetryUsed(true);
        goto L27
    L5:
        if (ZeusTransformUtils.instanceOf(r8, DownloadPCDNException.class) == true) goto L10;
        this.f.n.a(r8);
        if (this.f.m.a(r8) == false) goto L10;
        this.f.m.b();
        this.c.setCurNetworkRetryCount(this.f.m.c());
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void a() {
        com.ss.android.socialbase.downloader.b.b r0 = this.g;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void a(long r1, int r3) {
        com.ss.android.socialbase.downloader.b.b r0 = this.g;
        if (r0 == null) goto L6;
        r0.a(r1, r3);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r6) {
        com.ss.android.socialbase.downloader.b.f r7 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r6, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadRetryModule", this.c, "proceed", "Run");
    L5:
        d();
    L23:
        this.g.e();     // Catch: Throwable -> L8 BaseException -> L14 DownloadFileExistException -> L21
        this.g.a();     // Catch: Throwable -> L8 BaseException -> L14 DownloadFileExistException -> L21
    L29:
        return;
    L21:
        c.b(this.f);
        return;
    L14:
        e = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadRetryModule", this.c.getId(), "proceed", "BaseException:" + e);
        if (j_() == true) goto L17;
        if (a(e) != RetryCheckStatus.RETURN) goto L23;
        return;
    L17:
        return;
    L8:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadRetryModule", this.c.getId(), "proceed", "Throwable:" + th);
        if (j_() == false) goto L13;
        return;
    L13:
        throw new BaseException(1000, th);
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void b() {
        com.ss.android.socialbase.downloader.b.b r0 = this.g;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }
}
