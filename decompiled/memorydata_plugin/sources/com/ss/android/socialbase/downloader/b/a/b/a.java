package com.ss.android.socialbase.downloader.b.a.b;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.b.a.l;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadMultiSegmentException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.i;
import com.ss.android.socialbase.downloader.segment.j;
import com.ss.android.socialbase.downloader.segment.m;
import com.ss.android.socialbase.downloader.utils.c;
import com.ss.android.socialbase.downloader.utils.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class a extends com.ss.android.socialbase.downloader.b.a.a {
    private j g;

    public a() {
    }

    private void a(String r3, String r4) {
        this.f15249a.l(this.c.getId());
        g.c(this.c);
        this.c.resetDataForEtagEndure(r3);
        this.f15249a.a(this.c);
        throw new BaseException(1089, r4);
    }

    private boolean a(int r3, String r4, String r5, boolean r6, boolean r7) {
        if (r3 != 412) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L15;
        if (TextUtils.isEmpty(r5) == true) goto L15;
        if (r4.equals(r5) == true) goto L15;
        if (r6 == true) goto L13;
        if (r7 == false) goto L15;
    L13:
        return true;
    L15:
        if (r3 == 201) goto L19;
        if (r3 == 416) goto L19;
    L21:
        return false;
    L19:
        if (this.c.getCurBytes() <= 0) goto L21;
        return true;
    }

    private void d() {
        if (this.c.isExpiredRedownload() == false) goto L6;
        return;
    L6:
        if (this.c.getChunkCount() == 1) goto L8;
        return;
    L8:
        if (this.c.getThrottleNetSpeed() <= 0) goto L11;
        return;
    L11:
        if (this.f.h == true) goto L13;
        return;
    L13:
        JSONObject r0 = this.d.e("segment_config");
        List<i> r2 = this.f15249a.m(this.c.getId());
        if (this.c.getCurBytes() <= 0) goto L22;
        if (r2 != null) goto L17;
        return;
    L17:
        if (r2.isEmpty() == true) goto L46;
        if (r0 != null) goto L22;
        r0 = new JSONObject();
        goto L22
    L46:
        return;
    L22:
        if (r0 != null) goto L24;
        return;
    L24:
        m r1 = m.a(r0);
        this.g = new j(this.f15250b, this.c, r1, this);
        if (j_() == true) goto L27;
        this.f.i = true;
        this.g.a(r2);     // Catch: Throwable -> L37 BaseException -> L40
        return;
    L40:
        e = move-exception;
        throw new DownloadMultiSegmentException(e.getErrorCode(), e.getErrorMessage());
    L37:
        th = move-exception;
        throw new DownloadMultiSegmentException(1000, th.getMessage());
    L27:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L29;
        com.ss.android.socialbase.downloader.e.a.a("DownloadMultiSegmentModule", this.c, "downloadSegments", "Stopped by user");
    L29:
        RunStatus r3 = this.f.f;
        RunStatus r4 = RunStatus.RUN_STATUS_CANCELED;
        j r8 = this.g;
        if (r3 != r4) goto L32;
        r8.a();
        return;
    L32:
        r8.b();
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void a() {
        j r0 = this.g;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.b.a.a, com.ss.android.socialbase.downloader.b.e
    public void a(f r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadMultiSegmentModule", this.c, "proceed", "Run");
    L6:
        if (a(r6, false) == false) goto L8;
        return;
    L8:
        if (j_() == true) goto L13;
        d();
        r6.a();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.b.a.a, com.ss.android.socialbase.downloader.h.d
    public void a(String r17, com.ss.android.socialbase.downloader.network.g r18, long r19) {
        com.ss.android.socialbase.downloader.network.g r9 = (com.ss.android.socialbase.downloader.network.g) ZeusTransformUtils.wrapperContextForParams(r18, com.ss.android.socialbase.downloader.network.g.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L113;
        return;
    L113:
        com.ss.android.socialbase.downloader.model.f r10 = new com.ss.android.socialbase.downloader.model.f(r17, r9);     // Catch: Throwable -> L108 BaseException -> L111
        int r11 = r10.c;     // Catch: Throwable -> L108 BaseException -> L111
        String r1 = r10.d();     // Catch: Throwable -> L108 BaseException -> L111
        if (TextUtils.isEmpty(this.c.getMimeType()) == true) goto L8;
    L10:
        boolean r12 = r10.b();     // Catch: Throwable -> L108 BaseException -> L111
        this.c.setSupportPartial(r12);     // Catch: Throwable -> L108 BaseException -> L111
        boolean r13 = r10.a();     // Catch: Throwable -> L108 BaseException -> L111
        String r14 = this.c.geteTag();     // Catch: Throwable -> L108 BaseException -> L111
        String r15 = r10.c();     // Catch: Throwable -> L108 BaseException -> L111
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L15;
        com.ss.android.socialbase.downloader.e.a.a("DownloadMultiSegmentModule", this.c, "handleFirstConnection", "ResponseCode=" + r11 + " isDeleteCacheIfCheckFailed=" + this.c.isDeleteCacheIfCheckFailed());     // Catch: Throwable -> L108 BaseException -> L111
        com.ss.android.socialbase.downloader.e.a.a("DownloadMultiSegmentModule", this.c, "handleFirstConnection", "firstOffset=" + r19 + " cur=" + r10.k() + " before=" + this.c.getTotalBytes());     // Catch: Throwable -> L108 BaseException -> L111
    L15:
        if (ZeusTransformUtils.instanceOf(r9, com.ss.android.socialbase.downloader.network.a.class) == false) goto L21;
        String r2 = ((com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(r9, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin")).i();     // Catch: Throwable -> L108 BaseException -> L111
        if (TextUtils.isEmpty(r2) == true) goto L21;
        this.c.setRedirectPartialUrlResults(r2);     // Catch: Throwable -> L108 BaseException -> L111
    L21:
        if (a(r11, r14, r15, r13, r12) == false) goto L29;
        if (TextUtils.isEmpty(r14) == false) goto L25;
    L27:
        a(r15, "eTag of server file changed");     // Catch: Throwable -> L108 BaseException -> L111
        goto L29
    L25:
        if (r14.equals(r15) == false) goto L27;
        r15 = "";
    L29:
        if (r12 == true) goto L47;
        if (r13 == true) goto L47;
        if (r11 == 403) goto L46;
        if (this.c.getStartOffset() < 0) goto L44;
        if (this.c.getEndOffset() < 0) goto L42;
        if (this.c.getStartOffset() > this.c.getEndOffset()) goto L44;
    L42:
        throw new DownloadHttpException(1004, r11, "response code error : " + r11);     // Catch: Throwable -> L108 BaseException -> L111
    L44:
        throw new BaseException(1084, "startOffset = " + this.c.getStartOffset() + ", endOffset = " + this.c.getEndOffset() + ", response code error : " + r11);     // Catch: Throwable -> L108 BaseException -> L111
    L46:
        throw new BaseException(1047, "response code error : 403");     // Catch: Throwable -> L108 BaseException -> L111
    L47:
        if (r13 == true) goto L49;
    L51:
        long r16 = r10.h();     // Catch: Throwable -> L108 BaseException -> L111
        if (r10.i() == true) goto L65;
        String r20 = g.a(r9, "Content-Range");     // Catch: Throwable -> L108 BaseException -> L111
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L57;
        com.ss.android.socialbase.downloader.e.a.a("DownloadMultiSegmentModule", this.c, "handleFirstConnection", "ContentRange:" + r20);     // Catch: Throwable -> L108 BaseException -> L111
    L57:
        if (TextUtils.isEmpty(r20) == true) goto L62;
        long r21 = c.a(r20);     // Catch: Throwable -> L108 BaseException -> L111
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L67;
        DownloadInfo r110 = this.c;     // Catch: Throwable -> L108 BaseException -> L111
        String r111 = "TotalLength:" + r21;     // Catch: Throwable -> L108 BaseException -> L111
    L61:
        com.ss.android.socialbase.downloader.e.a.a("DownloadMultiSegmentModule", r110, "handleFirstConnection", r111);     // Catch: Throwable -> L108 BaseException -> L111
    L67:
        if (this.c.getStartOffset() > 0) goto L71;
        if (this.c.getEndOffset() >= 0) goto L71;
    L83:
        if (TextUtils.isEmpty(this.c.getTaskKey()) == true) goto L90;
        if (this.c.getTotalBytes() <= 0) goto L90;
        if (r21 == this.c.getTotalBytes()) goto L90;
        a("", "file totalLength changed");     // Catch: Throwable -> L108 BaseException -> L111
    L90:
        if (j_() == false) goto L93;
        return;
    L93:
        if (this.c.getExpectFileLength() <= 0) goto L102;
        if (this.d.b("force_check_file_length") != 1) goto L102;
        if (this.c.getExpectFileLength() == r21) goto L102;
        throw new BaseException(1070, "expectFileLength = " + this.c.getExpectFileLength() + " , totalLength = " + r21);     // Catch: Throwable -> L108 BaseException -> L111
    L102:
        if (l.a(this.c) == true) goto L105;
        this.e.a(r21, r15, this.c.getName());     // Catch: Throwable -> L108 BaseException -> L111
        return;
    L105:
        throw new BaseException(1083, "download global intercept");     // Catch: Throwable -> L108 BaseException -> L111
    L71:
        if (this.c.getStartOffset() < 0) goto L107;
        if (this.c.getEndOffset() >= r21) goto L107;
        if (this.c.getEndOffset() < 0) goto L79;
        if (this.c.getStartOffset() > this.c.getEndOffset()) goto L107;
    L79:
        if (this.c.getEndOffset() >= 0) goto L81;
        r21 = r21 - this.c.getStartOffset();     // Catch: Throwable -> L108 BaseException -> L111
        goto L83
    L81:
        r21 = (this.c.getEndOffset() - this.c.getStartOffset()) + 1;     // Catch: Throwable -> L108 BaseException -> L111
    L107:
        throw new BaseException(1084, "startOffset = " + this.c.getStartOffset() + ", endOffset = " + this.c.getEndOffset() + ", totalLength = " + r21);     // Catch: Throwable -> L108 BaseException -> L111
    L62:
        r21 = r19 + r16;     // Catch: Throwable -> L108 BaseException -> L111
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L67;
        r110 = this.c;     // Catch: Throwable -> L108 BaseException -> L111
        r111 = "TotalLength2:" + r21;     // Catch: Throwable -> L108 BaseException -> L111
        goto L61
    L65:
        this.c.setXTotalBytes(r10.j());     // Catch: Throwable -> L108 BaseException -> L111
        r21 = -1;
        goto L67
    L49:
        if (r19 <= 0) goto L51;
        a("", "isResponseFromBegin but firstOffset > 0");     // Catch: Throwable -> L108 BaseException -> L111
        goto L51
    L8:
        if (TextUtils.isEmpty(r1) == true) goto L10;
        this.c.setMimeType(r1);     // Catch: Throwable -> L108 BaseException -> L111
    L111:
        e = move-exception;
        throw e;
    L108:
        th = move-exception;
        c.a(th, "HandleFirstConnection");
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void b() {
        j r0 = this.g;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }
}
