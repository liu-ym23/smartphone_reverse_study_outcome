package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadMultiSegmentException;
import com.ss.android.socialbase.downloader.exception.DownloadPCDNException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.exception.RetryCheckStatus;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadRetryModule extends AbsDownloadModule {
    public final DownloadModuleChain g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15320h;

    public DownloadRetryModule(DownloadModuleChain r5) {
        this.g = r5;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a() {
        DownloadModuleChain r5 = this.g;
        if (r5 == null) goto L6;
        r5.b();
        return;
    }

    public final void c() {
        if (Logger.a(this.f15290c) == false) goto L10;
        Logger.a("DownloadRetryModule", this.f15290c, "clearCurrentDownloadData", "Trace:" + Log.getStackTraceString(new Throwable()));
    L10:
        this.f15288a.q(this.f15290c.l());     // Catch: Throwable -> L7
        DownloadUtils.b(this.f15290c, true);     // Catch: Throwable -> L7
        this.f15290c.a("");     // Catch: Throwable -> L7
        this.f15288a.a(this.f15290c);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void cancel() {
        DownloadModuleChain r5 = this.g;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(long r5, int r10) {
        DownloadModuleChain r11 = this.g;
        if (r11 == null) goto L6;
        r11.a(r5, r10);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r13) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadRetryModule", this.f15290c, "proceed", "Run");
    L5:
        DownloadInfo r5 = this.f15290c;
        if (r5.f15824m > 0) goto L8;
        r5.f15824m = 1;
    L8:
        this.f15320h = r5.f15824m;
    L177:
        DownloadModuleChain r10 = this.g;     // Catch: Throwable -> L12 BaseException -> L14 DownloadFileExistException -> L173
        r10.f15292b = 0;     // Catch: Throwable -> L12 BaseException -> L14 DownloadFileExistException -> L173
        r10.f15293c.f15312i = false;     // Catch: Throwable -> L12 BaseException -> L14 DownloadFileExistException -> L173
        r10.c();     // Catch: Throwable -> L12 BaseException -> L14 DownloadFileExistException -> L173
    L201:
        return;
    L173:
        DownloadCheckFileExistModule.b(this.f);
        return;
    L14:
        e = move-exception;
        Logger.a("DownloadRetryModule", this.f15290c.l(), "proceed", "BaseException:" + e);
        if (b() == true) goto L202;
        int r11 = e.f15601a;
        if (r11 != 1089) goto L27;
        int r12 = this.f15320h;
        if (r12 <= 0) goto L160;
        DownloadInfo r14 = this.f15290c;
        int r15 = r12 - 1;
        this.f15320h = r15;
        r14.b(r15);
        this.f15290c.a(5);
    L162:
        RetryCheckStatus r16 = RetryCheckStatus.f15605b;
    L164:
        if (r16 != RetryCheckStatus.f15604a) goto L177;
        return;
    L160:
        if (this.f15290c.A() == false) goto L166;
        this.f15290c.a(5);
        DownloadInfo r17 = this.f15290c;
        int r18 = r17.f15824m;
        this.f15320h = r18;
        r17.b(r18);
        goto L162
    L166:
        Throwable r19 = e.getCause();
        if (r19 != null) goto L169;
        throw e;
    L169:
        if ((r19 instanceof BaseException) == false) goto L172;
        throw ((BaseException) r19);
    L172:
        throw new BaseException(1089, DownloadUtils.a(r19));
    L27:
        if (r11 != 1025) goto L29;
        this.f.f = RunStatus.d;
        r16 = RetryCheckStatus.f15604a;
        goto L164
    L29:
        SparseArray r20 = DownloadHelper.f16133a;
        if (r11 == 1083) goto L149;
        if ((e instanceof DownloadMultiSegmentException) == false) goto L45;
        if (DownloadUtils.c(e) == false) goto L38;
        if (this.f15320h < this.f15290c.f15824m) goto L149;
    L38:
        if ((e instanceof DownloadHttpException) == false) goto L53;
        int r21 = ((DownloadHttpException) e).d;
        if (r21 != 412) goto L42;
    L43:
        c();
    L81:
        int r22 = e.f15601a;
        if (r22 != 1051) goto L84;
    L89:
        c();
    L90:
        this.f15288a.a(this.f15290c);
        if (b() == false) goto L94;
        r16 = RetryCheckStatus.f15604a;
        goto L164
    L94:
        if (e.f15601a != 1047) goto L114;
        IDownloadForbiddenHandler r23 = this.f15289b.f15885l;
        if (r23 != null) goto L98;
    L108:
        a(e);
    L109:
        RetryCheckStatus r24 = RetryCheckStatus.f15605b;
    L110:
        RetryCheckStatus r25 = RetryCheckStatus.f15604a;
        if (r24 != r25) goto L148;
    L112:
        r16 = r25;
    L148:
        DownloadStatusHandler r26 = this.e;
        r26.f15551c.f15822k0 = false;
        r26.f15556l.set(0);
        r26.d.e(r26.f15551c.l());
        r26.a(5, e);
        r16 = RetryCheckStatus.f15605b;
        goto L164
    L98:
        if (this.f15290c.G0 == true) goto L108;
        AbsDownloadForbiddenCallback r27 = new AnonymousClass1(this);
        boolean r28 = r23.a(r27);
        this.f15290c.G0 = true;
        if (r28 == false) goto L109;
        if (r27.f15481a == true) goto L109;
        DownloadStatusHandler r29 = this.e;
        r29.f15551c.a(8);
        r29.f15551c.H = AsyncHandleStatus.f15264b;
        AbsDownloadEngine r30 = DownloadComponentManager.j();
        if (r30 == null) goto L107;
        r30.a(r29.f15551c.l(), r29.f.f15894v, 8);
    L107:
        this.f.f = RunStatus.e;
        r24 = RetryCheckStatus.f15604a;
        goto L110
    L114:
        if (DownloadUtils.b(e) == false) goto L147;
        IDownloadDiskSpaceHandler r31 = this.f15289b.f15886m;
        if (r31 == null) goto L146;
        final AtomicBoolean r32 = new AtomicBoolean(false);
        IDownloadDiskSpaceCallback r110 = new AnonymousClass2(this, r32);
        long r33 = this.f15290c.f15817h0;
        monitor-enter(this);
    L129:
        th = move-exception;
        throw th;
    L121:
        if (r31.a(-1, r33, r110) == false) goto L137;
        if (r32.get() == true) goto L135;
        DownloadCommonParams r34 = this.f;     // Catch: Throwable -> L129
        RunStatus r35 = r34.f;     // Catch: Throwable -> L129
        RunStatus r36 = RunStatus.e;     // Catch: Throwable -> L129
        if (r35 == r36) goto L131;
        r34.f = r36;     // Catch: Throwable -> L129
        DownloadStatusHandler r37 = this.e;     // Catch: Throwable -> L129
        r37.f15551c.a(8);     // Catch: Throwable -> L129
        r37.f15551c.H = AsyncHandleStatus.f15264b;     // Catch: Throwable -> L129
        AbsDownloadEngine r38 = DownloadComponentManager.j();     // Catch: Throwable -> L129
        if (r38 == null) goto L131;
        r38.a(r37.f15551c.l(), r37.f.f15894v, 8);     // Catch: Throwable -> L129
    L131:
        RetryCheckStatus r39 = RetryCheckStatus.f15604a;     // Catch: Throwable -> L129
    L140:
        r25 = RetryCheckStatus.f15604a;
        if (r39 != r25) goto L148;
    L135:
        a(e);
        r39 = RetryCheckStatus.f15605b;
        goto L140
    L137:
        if (this.f.f != RunStatus.e) goto L143;
        r39 = RetryCheckStatus.f15604a;     // Catch: Throwable -> L129
        goto L140
    L143:
        throw e;     // Catch: Throwable -> L129
    L146:
        throw e;
    L147:
        a(e);
        goto L148
    L84:
        if (r22 == 1027) goto L89;
        if (r22 == 1026) goto L89;
        if (r22 != 1044) goto L90;
    L42:
        if (r21 == 416) goto L43;
    L53:
        if (this.f15320h > 0) goto L80;
        DownloadInfo r40 = this.f15290c;
        ArrayList r41 = r40.s;
        if (r41 == null) goto L66;
        if (r41.size() <= 0) goto L66;
        if (r40.f15831p0 == false) goto L80;
        int r42 = r40.f15811c0;
        if (r42 < 0) goto L66;
        if (r42 < (r40.s.size() - 1)) goto L80;
    L66:
        if (e.f15601a != 1011) goto L68;
    L71:
        DownloadInfo r43 = this.f15290c;
        if (TextUtils.isEmpty(r43.d) == true) goto L149;
        if (r43.d.startsWith(IIvyAIPackageResourceService.SCHEMA) == false) goto L149;
        if (r43.f15841v == false) goto L149;
        if (r43.f15833q0 == true) goto L149;
    L68:
        if (e.getCause() == null) goto L149;
        if ((e.getCause() instanceof SSLHandshakeException) == false) goto L149;
    L80:
        if ((e instanceof DownloadRetryNeedlessException) == true) goto L149;
    L45:
        if ((e instanceof DownloadPCDNException) == false) goto L50;
        if (DownloadUtils.c(e) == true) goto L149;
    L50:
        if (this.f.f15316m.a(e) == false) goto L53;
    L149:
        Throwable r111 = e.getCause();
        if (r111 != null) goto L152;
        throw e;
    L152:
        if ((r111 instanceof BaseException) == false) goto L155;
        throw ((BaseException) r111);
    L155:
        throw new BaseException(1089, DownloadUtils.a(r111));
    L202:
        return;
    L12:
        th = move-exception;
        Logger.a("DownloadRetryModule", this.f15290c.l(), "proceed", "Throwable:" + th);
        if (b() == false) goto L20;
        return;
    L20:
        throw new BaseException(1000, DownloadUtils.a(th));
    }

    public final void a(BaseException r10) {
        if ((r10 instanceof DownloadMultiSegmentException) == false) goto L5;
    L10:
        int r5 = this.f15320h;
        if (r5 <= 0) goto L17;
        if (r10.f15601a == 1070) goto L17;
        DownloadInfo r11 = this.f15290c;
        int r12 = r5 - 1;
        this.f15320h = r12;
        r11.b(r12);
        return;
    L17:
        if (this.f15290c.A() == false) goto L21;
        DownloadInfo r13 = this.f15290c;
        int r14 = r13.f15826n;
        this.f15320h = r14;
        r13.b(r14);
        return;
    L21:
        if (r10.f15601a != 1011) goto L23;
    L26:
        DownloadInfo r15 = this.f15290c;
        if (TextUtils.isEmpty(r15.d) == false) goto L29;
    L36:
        int r16 = r10.f15601a;
        Locale r17 = Locale.US;
        throw new BaseException(r16, "retry for exception, but current retry time : " + String.valueOf(this.f15320h) + " , retry Time " + this.f15290c.f15824m + " all used, last error is " + r10.f15602b);
    L29:
        if (r15.d.startsWith(IIvyAIPackageResourceService.SCHEMA) == false) goto L36;
        if (r15.f15841v == false) goto L36;
        if (r15.f15833q0 == true) goto L36;
        DownloadInfo r18 = this.f15290c;
        int r19 = r18.f15824m;
        this.f15320h = r19;
        r18.b(r19);
        this.f15290c.f15833q0 = true;
        return;
    L23:
        if (r10.getCause() == null) goto L36;
        if ((r10.getCause() instanceof SSLHandshakeException) == false) goto L36;
    L5:
        if ((r10 instanceof DownloadPCDNException) == true) goto L10;
        this.f.f15317n.a(r10);
        if (this.f.f15316m.a(r10) == false) goto L10;
        this.f.f15316m.a();
        this.f15290c.N = this.f.f15316m.f15597i;
    }
}
