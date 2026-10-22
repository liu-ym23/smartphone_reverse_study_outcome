package com.ss.android.socialbase.downloader.core.module.fast;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadNetworkService;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadFastModule extends BaseDownloadNetworkModule {
    public IDownloadHttpConnection g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DownloadSingleResponseHandler f15326h;

    public DownloadFastModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        if (r5.f15310c.b1 == true) goto L6;
        return null;
    L6:
        IDownloadCache r10 = r5.f15308a;
        if ((r10 instanceof DefaultDownloadCache) == false) goto L10;
        r5.f15308a = ((DefaultDownloadCache) r10).f15674a;
    L10:
        return super.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void cancel() {
        DownloadSingleResponseHandler r5 = this.f15326h;
        if (r5 == null) goto L6;
        r5.a();
        return;
    L6:
        BaseDownloadNetworkModule.a(this.g);
    }

    public final void d() {
        String r5 = this.f15290c.h();
        ArrayList r10 = this.f15290c.f15818i;
        ArrayList r15 = new ArrayList();
        if (r10 == null) goto L16;
        Iterator r11 = r10.iterator();
        boolean r12 = false;
    L6:
        if (r11.hasNext() == false) goto L18;
        HttpHeader r13 = (HttpHeader) r11.next();
        if (r13 == null) goto L6;
        if ("Accept-Encoding".equalsIgnoreCase(r13.f15909a) == false) goto L15;
        if ("gzip".equalsIgnoreCase(r13.f15910b) == false) goto L15;
        r12 = true;
    L15:
        r15.add(r13);
    L18:
        if (r12 == false) goto L20;
        String r14 = "gzip";
    L21:
        r15.add(new HttpHeader("Accept-Encoding", r14));
        int r16 = this.d.a("ttnet_proto_type", 0);
        if (r16 <= 0) goto L97;
        r15.add(new HttpHeader("x-ttnet-http-proto-type", String.valueOf(r16)));
    L97:
        DownloadInfo r17 = this.f15290c;     // Catch: Throwable -> L32
        boolean r18 = r17.E;     // Catch: Throwable -> L32
        int r19 = r17.f15819j;     // Catch: Throwable -> L32
        int r110 = this.d.a("net_lib_strategy", 0);     // Catch: Throwable -> L32
        DownloadInfo r20 = this.f15290c;     // Catch: Throwable -> L32
        Context r21 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L32
        IDownloadHttpConnection r22 = ((IDownloadNetworkService) DownloadServiceManager.a(IDownloadNetworkService.class)).a(r18, r19, r5, null, r15, r110, false, r20);     // Catch: Throwable -> L32
        if (r22 == null) goto L29;
        int r23 = r22.b();     // Catch: Throwable -> L30
        IDownloadHttpConnection r24 = r22;
        Throwable r25 = null;
    L101:
        if (r23 <= 0) goto L39;
        if (r23 >= 200) goto L39;
    L40:
        if (r25 == null) goto L44;
        SparseArray r26 = DownloadHelper.f16133a;     // Catch: Throwable -> L42
        DownloadComponentManager.s().getClass();     // Catch: Throwable -> L42
        ITTNetHandler r27 = DownloadComponentManager.s();     // Catch: Throwable -> L42
        r25.getCause();     // Catch: Throwable -> L42
        r27.getClass();     // Catch: Throwable -> L42
    L44:
        DownloadTTNetException r28 = new DownloadTTNetException(r23 + 2000);     // Catch: Throwable -> L42
        String r29 = "Http Status Error: " + r23;     // Catch: Throwable -> L42
        c();     // Catch: Throwable -> L42
        throw new BaseException(1089, r29, r28);     // Catch: Throwable -> L42
    L39:
        if (r23 >= 300) goto L40;
        if (r25 != null) goto L88;
        this.g = r24;
        HttpResponse r30 = new HttpResponse(r5, r24);     // Catch: Throwable -> L53
        String r31 = r30.f15912b.a("Content-Type");     // Catch: Throwable -> L53
        if (TextUtils.isEmpty(this.f15290c.f15839u) == true) goto L51;
    L55:
        this.f15290c.N0 = DownloadUtils.a(r30.f15912b, "Content-Encoding");     // Catch: Throwable -> L53
        if ("gzip".equalsIgnoreCase(this.f15290c.N0) == false) goto L59;
        this.f15290c.I = true;     // Catch: Throwable -> L53
    L59:
        if (r30.d() == true) goto L67;
        String r32 = DownloadUtils.a(r30.f15912b, "Content-Range");     // Catch: Throwable -> L53
        if (TextUtils.isEmpty(r32) == true) goto L64;
        long r33 = DownloadHelper.c(r32);     // Catch: Throwable -> L53
    L75:
        if (Logger.a(this.f15290c) == false) goto L78;
        Logger.a("DownloadFastModule", this.f15290c, "handleResponseHeader", "totalLength:" + r33);     // Catch: Throwable -> L53
    L78:
        if (b() == true) goto L82;
        this.f15290c.b(0);     // Catch: Throwable -> L53
        this.e.a(r33, null, this.f15290c.f15808b);     // Catch: Throwable -> L53
    L82:
        if (b() == false) goto L84;
        return;
    L84:
        DownloadSingleResponseHandler r34 = new DownloadSingleResponseHandler(this.f, this.g, 0, this.f15290c.f15817h0, this);
        this.f15326h = r34;
        r34.b();
        return;
    L64:
        if (r30.d > 0) goto L66;
        r30.d = DownloadUtils.a(r30.f15912b);     // Catch: Throwable -> L53
    L66:
        r33 = r30.d;     // Catch: Throwable -> L53
        goto L75
    L67:
        DownloadInfo r35 = this.f15290c;     // Catch: Throwable -> L53
        String r36 = DownloadUtils.a(r30.f15912b, "X-Content-Length");     // Catch: Throwable -> L53
        if (TextUtils.isEmpty(r36) == false) goto L94;
    L72:
        long r37 = -1;
    L73:
        r35.i0 = r37;     // Catch: Throwable -> L53
        r33 = -1;
        goto L75
    L94:
        r37 = Long.parseLong(r36);     // Catch: Throwable -> L53 NumberFormatException -> L93
    L51:
        if (TextUtils.isEmpty(r31) == true) goto L55;
        this.f15290c.f15839u = r31;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        DownloadHelper.a(th, "handleResponseHeader");
        throw null;
    L88:
        DownloadHelper.a(r25, "DoConnect");     // Catch: Throwable -> L42
        throw null;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        if (r24 == null) goto L92;
        r24.c();
    L92:
        throw th;
    L29:
        throw new BaseException(1022, DownloadUtils.a(new IOException("Connection is null")));     // Catch: Throwable -> L30
    L30:
        th = th;
    L34:
        ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).a().getClass();
        IDownloadHttpConnection r111 = r22;
        r25 = th;
        r23 = -1;
        r24 = r111;
    L32:
        th = th;
        r22 = null;
        goto L34
    L20:
        r14 = "identity";
        goto L21
    L16:
        r12 = false;
        goto L18
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r5) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadFastModule", this.f15290c, "proceed", "Run");
    L5:
        DownloadCommonParams r10 = this.f;
        if (r10.f15312i == false) goto L9;
        r5.c();
        return;
    L9:
        r10.f15312i = true;
        if (b() == true) goto L21;
        DownloadInfo r11 = this.f15290c;
        if (new DownloadFile(r11.e, r11.f15808b, true).f() == false) goto L22;
        DownloadCommonParams r12 = this.f;
        r12.f = RunStatus.d;
        r12.f15310c.M0 = true;
        return;
    L22:
        d();     // Catch: Throwable -> L18
        BaseDownloadNetworkModule.a(this.g);
        r5.c();
        return;
    L18:
        th = move-exception;
        BaseDownloadNetworkModule.a(this.g);
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a() {
        DownloadSingleResponseHandler r5 = this.f15326h;
        if (r5 == null) goto L6;
        r5.c();
        return;
    L6:
        BaseDownloadNetworkModule.a(this.g);
    }
}
