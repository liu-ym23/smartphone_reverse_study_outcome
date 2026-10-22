package com.ss.android.socialbase.downloader.core.module;

import ai.j0;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.room.writer.DaoWriter;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadNetworkService;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadHttpUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDownloadNetworkModule extends AbsDownloadModule implements IDownloadRunnableCallback {
    public BaseDownloadNetworkModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void a(DownloadModuleChain r5) {
    }

    public final void b(long r5, int r10) {
        if (r5 <= 0) goto L10;
        if (r10 > 0) goto L6;
        return;
    L6:
        if (r5 > r10) goto L9;
        return;
    L9:
        throw new BaseException(1088, "Current Bytes:" + r5 + "Limit bytes:" + r10);
    }

    public final void c() {
        DownloadUtils.b(this.f15290c, true);
        this.f.f15313j = false;
        this.f15290c.a("");
        this.f15288a.a(this.f15290c);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public boolean a(long r10) {
        DownloadStatusHandler r11 = this.e;
        r11.f15556l.addAndGet(r10);
        DownloadInfo r5 = r11.f15551c;
        r5.f15815f0.addAndGet(r10);
        if (r5.b1 == false) goto L5;
    L7:
        long r12 = SystemClock.uptimeMillis();
        boolean r13 = false;
        if (r11.f15557m == true) goto L10;
        r11.f15557m = true;
        boolean r14 = true;
    L19:
        long r15 = r11.f15551c.i();
        DownloadInfo r16 = r11.f15551c;
        if (r15 != r16.f15817h0) goto L27;
        r11.d.b(r16.l(), r11.f15551c.i());     // Catch: Exception -> L23
    L25:
        return false;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L27:
        if (r11.f15554j == false) goto L30;
        r11.f15554j = false;
        r16.a(4);
    L30:
        if (r11.f15551c.f15830p == false) goto L33;
        if (r14 == false) goto L33;
        r13 = true;
    L33:
        r11.a(4, null, r13);
        return r14;
    L10:
        long r17 = r12 - r11.f15555k;
        if (r11.f15556l.get() < r11.f15559o) goto L13;
    L16:
        r14 = true;
    L17:
        if (r14 == false) goto L19;
        r11.f15555k = r12;
        r11.f15556l.set(0);
        goto L19
    L13:
        if (r17 >= r11.f15558n) goto L16;
        r14 = false;
        goto L17
    L5:
        if (AppStatusManager.b().c() != 0) goto L7;
        r5.g0.addAndGet(r10);
        goto L7
    }

    public final void a(HttpResponse r10) {
        if (TextUtils.isEmpty(DownloadUtils.a(r10.f15912b, "Cache-Control")) == false) goto L6;
        return;
    L6:
        if (r10.b() <= 0) goto L13;
        DownloadInfo r11 = this.f15290c;
        long r5 = System.currentTimeMillis();
        long r12 = (r10.b() * 1000) + r5;
        r11.e();
        r11.S0.put("cache-control/expired_time", r12);     // Catch: Exception -> L10
        r11.C();     // Catch: Exception -> L10
        return;
    L15:
        return;
    }

    public final ArrayList a(long r17, long r19, boolean r21) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("AbsDownloadNetworkModule", this.f15290c, "buildRequestHeader", "CurrentOffset: endOffset:" + r19 + " handleBody:" + r21);
    L5:
        ArrayList r10 = this.f15290c.f15818i;
        ArrayList r11 = new ArrayList();
        String r12 = "gzip";
        if (r10 != null) goto L8;
    L21:
        boolean r13 = false;
    L22:
        String r14 = this.f15290c.F;
        if (this.f.f15313j == false) goto L31;
        if (TextUtils.isEmpty(r14) == true) goto L28;
        r11.add(new HttpHeader("If-None-Match", r14));
    L28:
        if (TextUtils.isEmpty(this.f15290c.m()) == true) goto L34;
        r11.add(new HttpHeader("if-modified-since", this.f15290c.m()));
        r11.add(new HttpHeader("download-tc21-1-15", "download-tc21-1-15"));
    L34:
        if (r19 <= 0) goto L37;
        Locale r5 = Locale.US;
        StringBuilder r15 = j0.t(r17, "bytes=", DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r15.append(r19);
        String r16 = r15.toString();
    L42:
        if (r16 == null) goto L44;
        r11.add(new HttpHeader("Range", r16));
        boolean r18 = false;
    L46:
        if (r18 == true) goto L49;
        r12 = "identity";
    L49:
        r11.add(new HttpHeader("Accept-Encoding", r12));
        r11.add(new HttpHeader("extra_download_id", String.valueOf(this.f15290c.l())));
        DownloadHelper.a(this.d, r11, this.f15290c);
        this.f.f15317n.a(r10);
        return r11;
    L44:
        r18 = r13;
        goto L46
    L37:
        if (r17 <= 0) goto L39;
        Locale r20 = Locale.US;
        r16 = "bytes=" + r17 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
        goto L42
    L39:
        if (r21 == true) goto L41;
        r16 = "bytes=0-0";
        goto L42
    L41:
        r16 = null;
        goto L42
    L31:
        if (TextUtils.isEmpty(r14) == true) goto L34;
        r11.add(new HttpHeader("If-Match", r14));
        goto L34
    L8:
        if (r10.size() <= 0) goto L21;
        Iterator r110 = r10.iterator();
        r13 = false;
    L11:
        if (r110.hasNext() == false) goto L22;
        HttpHeader r111 = (HttpHeader) r110.next();
        if (r111 == null) goto L11;
        if ("Accept-Encoding".equalsIgnoreCase(r111.f15909a) == false) goto L20;
        if ("gzip".equalsIgnoreCase(r111.f15910b) == false) goto L20;
        r13 = true;
    L20:
        r11.add(r111);
        goto L11
    }

    public final IDownloadHttpConnection a(String r18, ArrayList r19, long r20) {
        long r5 = System.currentTimeMillis();
        DownloadInfo r10 = this.f15290c;     // Catch: Throwable -> L10
        boolean r11 = r10.E;     // Catch: Throwable -> L10
        int r12 = r10.f15819j;     // Catch: Throwable -> L10
        int r13 = this.d.a("net_lib_strategy", 0);     // Catch: Throwable -> L10
        DownloadInfo r15 = this.f15290c;     // Catch: Throwable -> L10
        Context r14 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L10
        IDownloadHttpConnection r16 = ((IDownloadNetworkService) DownloadServiceManager.a(IDownloadNetworkService.class)).a(r11, r12, r18, null, r19, r13, false, r15);     // Catch: Throwable -> L10
        if (r16 == null) goto L7;
        int r17 = r16.b();     // Catch: Throwable -> L8
        IDownloadHttpConnection r21 = r16;
        Throwable r22 = null;
    L15:
        a(r21, r17);
        this.f15289b.getClass();
        if (r17 != 304) goto L29;
        DownloadInfo r23 = this.f15290c;     // Catch: Throwable -> L22
        r23.getClass();     // Catch: Throwable -> L22
        char[] r24 = DownloadUtils.f16142a;     // Catch: Throwable -> L22
        if (DownloadUtils.a(r23, r23.f15828o, r23.C) == true) goto L20;
        c();     // Catch: Throwable -> L22
        throw new BaseException(1089, "Status 304 file not found", null);     // Catch: Throwable -> L22
    L20:
        if (System.currentTimeMillis() <= this.f15290c.g()) goto L25;
        a(new HttpResponse(r18, r21, 0));     // Catch: Throwable -> L22
    L25:
        throw new DownloadFileExistException();     // Catch: Throwable -> L22
    L29:
        if (r17 == 403) goto L70;
        if (r17 <= 0) goto L34;
        if (r17 >= 200) goto L34;
    L35:
        if (r22 == null) goto L37;
        SparseArray r25 = DownloadHelper.f16133a;     // Catch: Throwable -> L22
        DownloadComponentManager.s().getClass();     // Catch: Throwable -> L22
        ITTNetHandler r26 = DownloadComponentManager.s();     // Catch: Throwable -> L22
        r22.getCause();     // Catch: Throwable -> L22
        r26.getClass();     // Catch: Throwable -> L22
    L37:
        DownloadTTNetException r27 = new DownloadTTNetException(r17 + 2000);     // Catch: Throwable -> L22
        String r28 = "Http Status Error: " + r17;     // Catch: Throwable -> L22
        c();     // Catch: Throwable -> L22
        throw new BaseException(1089, r28, r27);     // Catch: Throwable -> L22
    L34:
        if (r17 >= 300) goto L35;
        if (this.f.f15313j == false) goto L50;
        if (r17 < 200) goto L45;
        if (r17 >= 300) goto L45;
        c();     // Catch: Throwable -> L22
    L66:
        return r21;
    L45:
        if (DownloadUtils.a(this.f15290c, false, null) == true) goto L49;
        c();     // Catch: Throwable -> L22
        throw new BaseException(1089, "CheckIfModified file not found", null);     // Catch: Throwable -> L22
    L49:
        throw new DownloadFileExistException();     // Catch: Throwable -> L22
    L50:
        if (r22 == null) goto L52;
        DownloadHelper.a(r22, "DoConnect");     // Catch: Throwable -> L22
        throw null;     // Catch: Throwable -> L22
    L52:
        if (r17 != 206) goto L54;
    L58:
        DownloadInfo r29 = this.f15290c;     // Catch: Throwable -> L22
        long r30 = System.currentTimeMillis() - r5;     // Catch: Throwable -> L22
        if (r30 <= 0) goto L65;
        r29.d();     // Catch: Throwable -> L22
        if (r29.D != null) goto L64;
        r29.D = new AtomicLong(r29.T0.optLong("dbjson_key_all_connect_time"));     // Catch: Throwable -> L22
    L64:
        r29.D.get();     // Catch: Throwable -> L22
        r29.a("dbjson_key_all_connect_time", Long.valueOf(r29.D.addAndGet(r30)));     // Catch: Throwable -> L22
        goto L66
    L65:
        r29.getClass();     // Catch: Throwable -> L22
        goto L66
    L54:
        if (r20 <= 0) goto L58;
        c();     // Catch: Throwable -> L22
        throw new BaseException(1089, "Http range not support", null);     // Catch: Throwable -> L22
    L70:
        throw new BaseException(1047, "Status Error:403", r22);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r21 == null) goto L73;
        r21.c();
    L73:
        throw th;
    L7:
        throw new BaseException(1022, DownloadUtils.a(new IOException("Connection is null")));     // Catch: Throwable -> L8
    L8:
        th = th;
    L78:
        ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).a().getClass();     // Catch: Throwable -> L74
        IDownloadHttpConnection r110 = r16;
        r22 = th;
        r17 = -1;
        r21 = r110;
    L74:
        th = move-exception;
        a(r16, -1);
        this.f15289b.getClass();
        throw th;
    L10:
        th = th;
        r16 = null;
        goto L78
    }

    public final void a(String r20, long r21, IDownloadHttpConnection r23) {
        HttpResponse r15 = new HttpResponse(r20, r23);     // Catch: Throwable -> L8 BaseException -> L10
        int r14 = r15.f15913c;     // Catch: Throwable -> L8 BaseException -> L10
        String r10 = r15.f15912b.a("Content-Type");     // Catch: Throwable -> L8 BaseException -> L10
        if (TextUtils.isEmpty(this.f15290c.f15839u) == true) goto L6;
    L12:
        this.f15290c.L = r15.a();     // Catch: Throwable -> L8 BaseException -> L10
        String r11 = r15.f15912b.a("Etag");     // Catch: Throwable -> L8 BaseException -> L10
        if (TextUtils.isEmpty(r11) == true) goto L15;
        this.f15290c.F = r11;     // Catch: Throwable -> L8 BaseException -> L10
    L15:
        String r12 = DownloadUtils.a(r15.f15912b, "last-modified");     // Catch: Throwable -> L8 BaseException -> L10
        if (TextUtils.isEmpty(r12) == false) goto L20;
        r12 = DownloadUtils.a(r15.f15912b, "Last-Modified");     // Catch: Throwable -> L8 BaseException -> L10
    L20:
        if (TextUtils.isEmpty(r12) == true) goto L25;
        DownloadInfo r13 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r13.e();     // Catch: Throwable -> L8 BaseException -> L10
        String r18 = "dbjson_key_expect_file_length";
        r13.S0.put("last-modified", r12);     // Catch: Throwable -> L8 Exception -> L106
        r13.C();     // Catch: Throwable -> L8 Exception -> L106
    L26:
        this.f15290c.N0 = DownloadUtils.a(r15.f15912b, "Content-Encoding");     // Catch: Throwable -> L8 BaseException -> L10
        if ("gzip".equalsIgnoreCase(this.f15290c.N0) == false) goto L29;
        this.f15290c.I = true;     // Catch: Throwable -> L8 BaseException -> L10
    L29:
        a(r15);     // Catch: Throwable -> L8 BaseException -> L10
        if (Logger.a(this.f15290c) == false) goto L34;
        Logger.a("AbsDownloadNetworkModule", this.f15290c, "handleResponseHeader", "ResponseCode=" + r14 + " last_modified=" + r12 + " CACHE_CONTROL=" + DownloadUtils.a(r15.f15912b, "Cache-Control") + " max-age=" + r15.b() + " isDeleteCacheIfCheckFailed=" + this.f15290c.T);     // Catch: Throwable -> L8 BaseException -> L10
        DownloadInfo r5 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        StringBuilder r16 = new StringBuilder(" cur=");     // Catch: Throwable -> L8 BaseException -> L10
        r16.append(r12);     // Catch: Throwable -> L8 BaseException -> L10
        r16.append(" before=");     // Catch: Throwable -> L8 BaseException -> L10
        r16.append(this.f15290c.m());     // Catch: Throwable -> L8 BaseException -> L10
        r16.append(" cur=");     // Catch: Throwable -> L8 BaseException -> L10
        r16.append(r15.c());     // Catch: Throwable -> L8 BaseException -> L10
        r16.append(" before=");     // Catch: Throwable -> L8 BaseException -> L10
        r16.append(this.f15290c.f15817h0);     // Catch: Throwable -> L8 BaseException -> L10
        Logger.a("AbsDownloadNetworkModule", r5, "handleResponseHeader", r16.toString());     // Catch: Throwable -> L8 BaseException -> L10
    L34:
        if ((r23 instanceof AbsDownloadHttpConnection) == false) goto L39;
        if (TextUtils.isEmpty("") == true) goto L39;
        this.f15290c.a("redirect_partial_url_results", "");     // Catch: Throwable -> L8 BaseException -> L10
    L39:
        if (r15.d() == true) goto L55;
        String r17 = DownloadUtils.a(r15.f15912b, "Content-Range");     // Catch: Throwable -> L8 BaseException -> L10
        if (Logger.a(this.f15290c) == false) goto L44;
        Logger.a("AbsDownloadNetworkModule", this.f15290c, "handleResponseHeader", "ContentRange:" + r17);     // Catch: Throwable -> L8 BaseException -> L10
    L44:
        if (TextUtils.isEmpty(r17) == true) goto L49;
        long r19 = DownloadHelper.c(r17);     // Catch: Throwable -> L8 BaseException -> L10
        if (Logger.a(this.f15290c) == false) goto L62;
        Logger.a("AbsDownloadNetworkModule", this.f15290c, "handleResponseHeader", "TotalLength:" + r19);     // Catch: Throwable -> L8 BaseException -> L10
    L62:
        DownloadInfo r22 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r22.d();     // Catch: Throwable -> L8 BaseException -> L10
        if (r22.T0.optLong("start_offset") <= 0) goto L65;
    L66:
        DownloadInfo r24 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r24.d();     // Catch: Throwable -> L8 BaseException -> L10
        if (r24.T0.optLong("start_offset") >= 0) goto L69;
    L101:
        StringBuilder r25 = new StringBuilder("startOffset = ");     // Catch: Throwable -> L8 BaseException -> L10
        DownloadInfo r26 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r26.d();     // Catch: Throwable -> L8 BaseException -> L10
        r25.append(r26.T0.optLong("start_offset"));     // Catch: Throwable -> L8 BaseException -> L10
        r25.append(", endOffset = ");     // Catch: Throwable -> L8 BaseException -> L10
        r25.append(this.f15290c.k());     // Catch: Throwable -> L8 BaseException -> L10
        r25.append(", totalLength = ");     // Catch: Throwable -> L8 BaseException -> L10
        r25.append(r19);     // Catch: Throwable -> L8 BaseException -> L10
        throw new BaseException(1084, r25.toString());     // Catch: Throwable -> L8 BaseException -> L10
    L69:
        if (this.f15290c.k() >= r19) goto L101;
        if (this.f15290c.k() < 0) goto L75;
        DownloadInfo r27 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r27.d();     // Catch: Throwable -> L8 BaseException -> L10
        if (r27.T0.optLong("start_offset") > this.f15290c.k()) goto L101;
    L75:
        if (this.f15290c.k() >= 0) goto L77;
        DownloadInfo r28 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r28.d();     // Catch: Throwable -> L8 BaseException -> L10
        r19 = r19 - r28.T0.optLong("start_offset");     // Catch: Throwable -> L8 BaseException -> L10
    L78:
        DownloadInfo r29 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r29.d();     // Catch: Throwable -> L8 BaseException -> L10
        if (TextUtils.isEmpty(r29.T0.optString("task_key")) == true) goto L88;
        long r30 = this.f15290c.f15817h0;     // Catch: Throwable -> L8 BaseException -> L10
        if (r30 <= 0) goto L88;
        if (r19 == r30) goto L88;
        c();     // Catch: Throwable -> L8 BaseException -> L10
        throw new BaseException(1089, "file totalLength changed", null);     // Catch: Throwable -> L8 BaseException -> L10
    L88:
        if (b() == false) goto L90;
        return;
    L90:
        DownloadInfo r31 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r31.d();     // Catch: Throwable -> L8 BaseException -> L10
        String r32 = r18;
        if (r31.T0.optLong(r32) > 0) goto L93;
    L99:
        DownloadMimeTypeInterceptModule.a(this.f15290c);     // Catch: Throwable -> L8 BaseException -> L10
        this.e.a(r19, r11, this.f15290c.f15808b);     // Catch: Throwable -> L8 BaseException -> L10
        return;
    L93:
        if (this.d.a("force_check_file_length", 0) != 1) goto L99;
        DownloadInfo r33 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r33.d();     // Catch: Throwable -> L8 BaseException -> L10
        if (r33.T0.optLong(r32) == r19) goto L99;
        StringBuilder r34 = new StringBuilder("expectFileLength = ");     // Catch: Throwable -> L8 BaseException -> L10
        DownloadInfo r35 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r35.d();     // Catch: Throwable -> L8 BaseException -> L10
        r34.append(r35.T0.optLong(r32));     // Catch: Throwable -> L8 BaseException -> L10
        r34.append(" , totalLength = ");     // Catch: Throwable -> L8 BaseException -> L10
        r34.append(r19);     // Catch: Throwable -> L8 BaseException -> L10
        throw new BaseException(1070, r34.toString());     // Catch: Throwable -> L8 BaseException -> L10
    L77:
        long r36 = this.f15290c.k();     // Catch: Throwable -> L8 BaseException -> L10
        DownloadInfo r37 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        r37.d();     // Catch: Throwable -> L8 BaseException -> L10
        r19 = (r36 - r37.T0.optLong("start_offset")) + 1;     // Catch: Throwable -> L8 BaseException -> L10
        goto L78
    L65:
        if (this.f15290c.k() < 0) goto L78;
    L49:
        if (r15.d > 0) goto L51;
        r15.d = DownloadUtils.a(r15.f15912b);     // Catch: Throwable -> L8 BaseException -> L10
    L51:
        long r110 = r21 + r15.d;     // Catch: Throwable -> L8 BaseException -> L10
        if (Logger.a(this.f15290c) == false) goto L54;
        Logger.a("AbsDownloadNetworkModule", this.f15290c, "handleResponseHeader", "TotalLength2:" + r110);     // Catch: Throwable -> L8 BaseException -> L10
    L54:
        r19 = r110;
        goto L62
    L55:
        DownloadInfo r38 = this.f15290c;     // Catch: Throwable -> L8 BaseException -> L10
        String r39 = DownloadUtils.a(r15.f15912b, "X-Content-Length");     // Catch: Throwable -> L8 BaseException -> L10
        r19 = -1;
        if (TextUtils.isEmpty(r39) == false) goto L111;
    L60:
        long r111 = -1;
    L61:
        r38.i0 = r111;     // Catch: Throwable -> L8 BaseException -> L10
        goto L62
    L111:
        r111 = Long.parseLong(r39);     // Catch: Throwable -> L8 BaseException -> L10 NumberFormatException -> L107
    L25:
        r18 = "dbjson_key_expect_file_length";
        goto L26
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L12;
        this.f15290c.f15839u = r10;     // Catch: Throwable -> L8 BaseException -> L10
    L8:
        th = move-exception;
        DownloadHelper.a(th, "handleResponseHeader");
        throw null;
    L10:
        e = move-exception;
        throw e;
    }

    public static void a(final IDownloadHttpConnection r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        DownloadComponentManager.a(new AnonymousClass1(r5), true);
    }

    public final void a(IDownloadHttpConnection r10, int r11) {
        if (r10 != null) goto L32;
        DownloadInfo r5 = this.f15290c;
        r5.A0 = -1;
        r5.B0 = "";
        return;
    L32:
        DownloadInfo r12 = this.f15290c;     // Catch: Throwable -> L20
        r12.A0 = r11;     // Catch: Throwable -> L20
        r12.B0 = DownloadHttpUtils.a(r11);     // Catch: Throwable -> L20
        List r13 = this.f15290c.Z0;     // Catch: Throwable -> L20
        if (r13 != null) goto L9;
        return;
    L9:
        if (r13.isEmpty() == true) goto L46;
        HashMap r14 = new HashMap();     // Catch: Throwable -> L20
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L20
    L12:
        if (r15.hasNext() == false) goto L23;
        String r16 = (String) r15.next();     // Catch: Throwable -> L20
        if (r16 == null) goto L12;
        String r17 = r10.a(r16);     // Catch: Throwable -> L20
        if (r17 == null) goto L12;
        r14.put(r16, r17);     // Catch: Throwable -> L20
        goto L12
    L23:
        if (r14.isEmpty() == true) goto L47;
        this.f15290c.f15807a1 = r14;     // Catch: Throwable -> L20
        return;
    L47:
        return;
    L46:
        return;
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
        DownloadInfo r18 = this.f15290c;
        r18.A0 = -1;
        r18.B0 = "";
        return;
    L29:
        th = move-exception;
        this.f15290c.A0 = -1;
        this.f15290c.B0 = "";
        throw th;
    }
}
