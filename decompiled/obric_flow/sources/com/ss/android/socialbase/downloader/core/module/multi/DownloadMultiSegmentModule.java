package com.ss.android.socialbase.downloader.core.module.multi;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.core.module.DownloadMimeTypeInterceptModule;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadMultiSegmentException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.segment.SegmentDispatcher;
import com.ss.android.socialbase.downloader.segment.SegmentStrategy;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadMultiSegmentModule extends BaseDownloadNetworkModule {
    public SegmentDispatcher g;

    public DownloadMultiSegmentModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r10) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadMultiSegmentModule", this.f15290c, "proceed", "Run");
    L5:
        DownloadCommonParams r5 = this.f;
        if (r5.f15312i == false) goto L9;
        r10.c();
        return;
    L9:
        r5.f15312i = false;
        if (b() == false) goto L12;
        return;
    L12:
        DownloadInfo r11 = this.f15290c;
        if (r11.R == false) goto L16;
    L53:
        r10.c();
        return;
    L16:
        if (r11.f15814e0 != 1) goto L53;
        if (r11.I0 > 0) goto L53;
        if (this.f.f15311h == false) goto L53;
        JSONObject r12 = this.d.d("segment_config");
        List r13 = this.f15288a.o(this.f15290c.l());
        if (this.f15290c.i() <= 0) goto L31;
        if (r13 == null) goto L53;
        if (r13.isEmpty() == true) goto L53;
        if (r12 != null) goto L31;
        r12 = new JSONObject();
    L31:
        if (r12 == null) goto L53;
        SegmentStrategy r14 = new SegmentStrategy(r12);
        this.g = new SegmentDispatcher(this.f15289b, this.f15290c, r14, this);
        if (b() == true) goto L36;
        this.f.f15312i = true;
        this.g.a(r13);     // Catch: Throwable -> L45 BaseException -> L47
    L47:
        e = move-exception;
        throw new DownloadMultiSegmentException(e.f15601a, e.f15602b);
    L45:
        th = move-exception;
        throw new DownloadMultiSegmentException(1000, th.getMessage());
    L36:
        if (Logger.a(this.f15290c) == false) goto L39;
        Logger.a("DownloadMultiSegmentModule", this.f15290c, "downloadSegments", "Stopped by user");
    L39:
        if (this.f.f != RunStatus.f15285c) goto L41;
        this.g.a();
        goto L53
    L41:
        this.g.j();
        goto L53
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void cancel() {
        SegmentDispatcher r5 = this.g;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    public final void a(String r25, IDownloadHttpConnection r26, long r27) {
        if (r26 == null) goto L154;
        HttpResponse r13 = new HttpResponse(r25, r26);     // Catch: Throwable -> L10 BaseException -> L12
        int r14 = r13.f15913c;     // Catch: Throwable -> L10 BaseException -> L12
        String r12 = r13.f15912b.a("Content-Type");     // Catch: Throwable -> L10 BaseException -> L12
        if (TextUtils.isEmpty(this.f15290c.f15839u) == true) goto L8;
    L14:
        boolean r15 = r13.a();     // Catch: Throwable -> L10 BaseException -> L12
        DownloadInfo r16 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r16.L = r15;     // Catch: Throwable -> L10 BaseException -> L12
        int r5 = r13.f15913c;     // Catch: Throwable -> L10 BaseException -> L12
        SparseArray r17 = DownloadHelper.f16133a;     // Catch: Throwable -> L10 BaseException -> L12
        if (r5 == 200) goto L20;
        if (r5 == 201) goto L20;
        if (r5 == 0) goto L20;
        boolean r10 = false;
    L21:
        String r11 = r16.F;     // Catch: Throwable -> L10 BaseException -> L12
        String r18 = r13.f15912b.a("Etag");     // Catch: Throwable -> L10 BaseException -> L12
        if (Logger.a(this.f15290c) == false) goto L28;
        Logger.a("DownloadMultiSegmentModule", this.f15290c, "handleFirstConnection", "ResponseCode=" + r14 + " isDeleteCacheIfCheckFailed=" + this.f15290c.T);     // Catch: Throwable -> L10 BaseException -> L12
        Logger.a("DownloadMultiSegmentModule", this.f15290c, "handleFirstConnection", "firstOffset=" + r27 + " cur=" + r13.c() + " before=" + this.f15290c.f15817h0);     // Catch: Throwable -> L10 BaseException -> L12
    L28:
        if ((r26 instanceof AbsDownloadHttpConnection) == false) goto L33;
        AbsDownloadHttpConnection r19 = (AbsDownloadHttpConnection) r26;     // Catch: Throwable -> L10 BaseException -> L12
        if (TextUtils.isEmpty("") == true) goto L33;
        this.f15290c.a("redirect_partial_url_results", "");     // Catch: Throwable -> L10 BaseException -> L12
    L33:
        if (r14 != 412) goto L36;
    L51:
        if (TextUtils.isEmpty(r11) == false) goto L53;
    L55:
        a(r18, "eTag of server file changed");     // Catch: Throwable -> L10 BaseException -> L12
        throw null;     // Catch: Throwable -> L10 BaseException -> L12
    L53:
        if (r11.equals(r18) == false) goto L55;
        r18 = "";
        goto L55
    L36:
        if (TextUtils.isEmpty(r11) == true) goto L45;
        if (TextUtils.isEmpty(r18) == true) goto L45;
        if (r11.equals(r18) == true) goto L45;
        if (r10 == true) goto L51;
        if (r15 == true) goto L51;
    L45:
        if (r14 == 201) goto L49;
        if (r14 == 416) goto L49;
    L58:
        if (r15 == true) goto L76;
        if (r10 == true) goto L76;
        if (r14 == 403) goto L75;
        DownloadInfo r20 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r20.d();     // Catch: Throwable -> L10 BaseException -> L12
        if (r20.T0.optLong("start_offset") >= 0) goto L66;
    L72:
        StringBuilder r21 = new StringBuilder("startOffset = ");     // Catch: Throwable -> L10 BaseException -> L12
        DownloadInfo r22 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r22.d();     // Catch: Throwable -> L10 BaseException -> L12
        r21.append(r22.T0.optLong("start_offset"));     // Catch: Throwable -> L10 BaseException -> L12
        r21.append(", endOffset = ");     // Catch: Throwable -> L10 BaseException -> L12
        r21.append(this.f15290c.k());     // Catch: Throwable -> L10 BaseException -> L12
        r21.append(", response code error : ");     // Catch: Throwable -> L10 BaseException -> L12
        r21.append(r14);     // Catch: Throwable -> L10 BaseException -> L12
        throw new BaseException(1084, r21.toString());     // Catch: Throwable -> L10 BaseException -> L12
    L66:
        if (this.f15290c.k() < 0) goto L71;
        DownloadInfo r23 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r23.d();     // Catch: Throwable -> L10 BaseException -> L12
        if (r23.T0.optLong("start_offset") > this.f15290c.k()) goto L72;
    L71:
        throw new DownloadHttpException(r14, "response code error : " + r14);     // Catch: Throwable -> L10 BaseException -> L12
    L75:
        throw new BaseException(1047, "response code error : 403");     // Catch: Throwable -> L10 BaseException -> L12
    L76:
        if (r10 == false) goto L83;
        if (r27 <= 0) goto L83;
        a("", "isResponseFromBegin but firstOffset > 0");     // Catch: Throwable -> L10 BaseException -> L12
        throw null;     // Catch: Throwable -> L10 BaseException -> L12
    L83:
        if (r13.d > 0) goto L85;
        r13.d = DownloadUtils.a(r13.f15912b);     // Catch: Throwable -> L10 BaseException -> L12
    L85:
        long r24 = r13.d;     // Catch: Throwable -> L10 BaseException -> L12
        if (r13.d() == true) goto L99;
        String r28 = DownloadUtils.a(r26, "Content-Range");     // Catch: Throwable -> L10 BaseException -> L12
        if (Logger.a(this.f15290c) == false) goto L90;
        String r110 = "handleFirstConnection";
        Logger.a("DownloadMultiSegmentModule", this.f15290c, r110, "ContentRange:" + r28);     // Catch: Throwable -> L10 BaseException -> L12
    L92:
        if (TextUtils.isEmpty(r28) == true) goto L96;
        long r29 = DownloadHelper.c(r28);     // Catch: Throwable -> L10 BaseException -> L12
        if (Logger.a(this.f15290c) == false) goto L106;
        Logger.a("DownloadMultiSegmentModule", this.f15290c, r110, "TotalLength:" + r29);     // Catch: Throwable -> L10 BaseException -> L12
    L106:
        DownloadInfo r30 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r30.d();     // Catch: Throwable -> L10 BaseException -> L12
        if (r30.T0.optLong("start_offset") <= 0) goto L109;
    L110:
        DownloadInfo r31 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r31.d();     // Catch: Throwable -> L10 BaseException -> L12
        if (r31.T0.optLong("start_offset") >= 0) goto L113;
    L145:
        StringBuilder r32 = new StringBuilder("startOffset = ");     // Catch: Throwable -> L10 BaseException -> L12
        DownloadInfo r33 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r33.d();     // Catch: Throwable -> L10 BaseException -> L12
        r32.append(r33.T0.optLong("start_offset"));     // Catch: Throwable -> L10 BaseException -> L12
        r32.append(", endOffset = ");     // Catch: Throwable -> L10 BaseException -> L12
        r32.append(this.f15290c.k());     // Catch: Throwable -> L10 BaseException -> L12
        r32.append(", totalLength = ");     // Catch: Throwable -> L10 BaseException -> L12
        r32.append(r29);     // Catch: Throwable -> L10 BaseException -> L12
        throw new BaseException(1084, r32.toString());     // Catch: Throwable -> L10 BaseException -> L12
    L113:
        if (this.f15290c.k() >= r29) goto L145;
        if (this.f15290c.k() < 0) goto L119;
        DownloadInfo r34 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r34.d();     // Catch: Throwable -> L10 BaseException -> L12
        if (r34.T0.optLong("start_offset") > this.f15290c.k()) goto L145;
    L119:
        if (this.f15290c.k() >= 0) goto L121;
        DownloadInfo r35 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r35.d();     // Catch: Throwable -> L10 BaseException -> L12
        r29 = r29 - r35.T0.optLong("start_offset");     // Catch: Throwable -> L10 BaseException -> L12
    L122:
        DownloadInfo r36 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r36.d();     // Catch: Throwable -> L10 BaseException -> L12
        if (TextUtils.isEmpty(r36.T0.optString("task_key")) == true) goto L132;
        long r37 = this.f15290c.f15817h0;     // Catch: Throwable -> L10 BaseException -> L12
        if (r37 <= 0) goto L132;
        if (r29 == r37) goto L132;
        a("", "file totalLength changed");     // Catch: Throwable -> L10 BaseException -> L12
        throw null;     // Catch: Throwable -> L10 BaseException -> L12
    L132:
        if (b() == false) goto L134;
        return;
    L134:
        DownloadInfo r38 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r38.d();     // Catch: Throwable -> L10 BaseException -> L12
        if (r38.T0.optLong("dbjson_key_expect_file_length") > 0) goto L137;
    L143:
        DownloadMimeTypeInterceptModule.a(this.f15290c);     // Catch: Throwable -> L10 BaseException -> L12
        this.e.a(r29, r18, this.f15290c.f15808b);     // Catch: Throwable -> L10 BaseException -> L12
        return;
    L137:
        if (this.d.a("force_check_file_length", 0) != 1) goto L143;
        DownloadInfo r39 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r39.d();     // Catch: Throwable -> L10 BaseException -> L12
        if (r39.T0.optLong("dbjson_key_expect_file_length") == r29) goto L143;
        StringBuilder r40 = new StringBuilder("expectFileLength = ");     // Catch: Throwable -> L10 BaseException -> L12
        DownloadInfo r41 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r41.d();     // Catch: Throwable -> L10 BaseException -> L12
        r40.append(r41.T0.optLong("dbjson_key_expect_file_length"));     // Catch: Throwable -> L10 BaseException -> L12
        r40.append(" , totalLength = ");     // Catch: Throwable -> L10 BaseException -> L12
        r40.append(r29);     // Catch: Throwable -> L10 BaseException -> L12
        throw new BaseException(1070, r40.toString());     // Catch: Throwable -> L10 BaseException -> L12
    L121:
        long r42 = this.f15290c.k();     // Catch: Throwable -> L10 BaseException -> L12
        DownloadInfo r43 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        r43.d();     // Catch: Throwable -> L10 BaseException -> L12
        r29 = (r42 - r43.T0.optLong("start_offset")) + 1;     // Catch: Throwable -> L10 BaseException -> L12
        goto L122
    L109:
        if (this.f15290c.k() < 0) goto L122;
    L96:
        r29 = r27 + r24;     // Catch: Throwable -> L10 BaseException -> L12
        if (Logger.a(this.f15290c) == false) goto L106;
        Logger.a("DownloadMultiSegmentModule", this.f15290c, r110, "TotalLength2:" + r29);     // Catch: Throwable -> L10 BaseException -> L12
        goto L106
    L90:
        r110 = "handleFirstConnection";
        goto L92
    L99:
        DownloadInfo r44 = this.f15290c;     // Catch: Throwable -> L10 BaseException -> L12
        String r45 = DownloadUtils.a(r13.f15912b, "X-Content-Length");     // Catch: Throwable -> L10 BaseException -> L12
        if (TextUtils.isEmpty(r45) == false) goto L151;
    L104:
        long r46 = -1;
    L105:
        r44.i0 = r46;     // Catch: Throwable -> L10 BaseException -> L12
        r29 = -1;
        goto L106
    L151:
        r46 = Long.parseLong(r45);     // Catch: Throwable -> L10 BaseException -> L12 NumberFormatException -> L150
    L49:
        if (this.f15290c.i() <= 0) goto L58;
    L20:
        r10 = true;
        goto L21
    L8:
        if (TextUtils.isEmpty(r12) == true) goto L14;
        this.f15290c.f15839u = r12;     // Catch: Throwable -> L10 BaseException -> L12
    L12:
        e = move-exception;
        throw e;
    L10:
        th = move-exception;
        DownloadHelper.a(th, "HandleFirstConnection");
        throw null;
    }

    public final void a(String r5, String r10) {
        this.f15288a.q(this.f15290c.l());
        DownloadUtils.b(this.f15290c, true);
        this.f15290c.a(r5);
        this.f15288a.a(this.f15290c);
        throw new BaseException(1089, r10);
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a() {
        SegmentDispatcher r5 = this.g;
        if (r5 == null) goto L6;
        r5.j();
        return;
    }
}
