package eb;

import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import bb.f;
import cb.k;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadMultiSegmentException;
import com.ss.android.socialbase.downloader.segment.i;
import com.ss.android.socialbase.downloader.segment.j;
import com.ss.android.socialbase.downloader.segment.m;
import com.ss.android.socialbase.downloader.utils.c;
import com.ss.android.socialbase.downloader.utils.g;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends cb.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private j f8763l;

    public a() {
    }

    private boolean A(int r10, String r11, String r12, boolean r13, boolean r14) {
        if (r10 != 412) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        if (TextUtils.isEmpty(r12) == true) goto L15;
        if (r11.equals(r12) == true) goto L15;
        if (r13 == true) goto L13;
        if (r14 == false) goto L15;
    L13:
        return true;
    L15:
        if (r10 == 201) goto L19;
        if (r10 == 416) goto L19;
    L21:
        return false;
    L19:
        if (this.f544h.getCurBytes() <= 0) goto L21;
        return true;
    }

    private void y() {
        if (this.f544h.isExpiredRedownload() == false) goto L6;
        return;
    L6:
        if (this.f544h.getChunkCount() == 1) goto L8;
        return;
    L8:
        if (this.f544h.getThrottleNetSpeed() <= 0) goto L11;
        return;
    L11:
        if (this.f547k.f683h == true) goto L13;
        return;
    L13:
        JSONObject r10 = this.f545i.q("segment_config");
        List<i> r11 = this.f542c.k1(this.f544h.getId());
        if (this.f544h.getCurBytes() <= 0) goto L22;
        if (r11 != null) goto L17;
        return;
    L17:
        if (r11.isEmpty() == true) goto L46;
        if (r10 != null) goto L22;
        r10 = new JSONObject();
        goto L22
    L46:
        return;
    L22:
        if (r10 != null) goto L24;
        return;
    L24:
        m r12 = m.b(r10);
        this.f8763l = new j(this.f543g, this.f544h, r12, this);
        if (m() == true) goto L27;
        this.f547k.f684i = true;
        this.f8763l.F(r11);     // Catch: Throwable -> L37 BaseException -> L40
        return;
    L40:
        e = move-exception;
        throw new DownloadMultiSegmentException(e.getErrorCode(), e.getErrorMessage());
    L37:
        th = move-exception;
        throw new DownloadMultiSegmentException(1000, th.getMessage());
    L27:
        if (lb.a.a() == false) goto L29;
        lb.a.g("DownloadMultiSegmentModule", this.f544h.getId(), "downloadSegments", "Stopped by user");
    L29:
        RunStatus r13 = this.f547k.f681f;
        RunStatus r14 = RunStatus.RUN_STATUS_CANCELED;
        j r15 = this.f8763l;
        if (r13 != r14) goto L32;
        r15.z();
        return;
    L32:
        r15.h0();
    }

    private void z(String r10, String r11) {
        this.f542c.f2(this.f544h.getId());
        g.i(this.f544h);
        this.f544h.resetDataForEtagEndure(r10);
        this.f542c.b(this.f544h);
        throw new BaseException(1089, r11);
    }

    @Override // bb.a, bb.e
    public void cancel() {
        j r10 = this.f8763l;
        if (r10 == null) goto L6;
        r10.z();
        return;
    }

    @Override // cb.a, sb.d
    public void d(String r19, nb.g r20, long r21) {
        if (r20 != null) goto L114;
        return;
    L114:
        com.ss.android.socialbase.downloader.model.g r10 = new com.ss.android.socialbase.downloader.model.g(r19, r20);     // Catch: Throwable -> L109 BaseException -> L112
        int r11 = r10.f8195c;     // Catch: Throwable -> L109 BaseException -> L112
        String r12 = r10.f();     // Catch: Throwable -> L109 BaseException -> L112
        if (TextUtils.isEmpty(this.f544h.getMimeType()) == true) goto L8;
    L10:
        boolean r13 = r10.a();     // Catch: Throwable -> L109 BaseException -> L112
        this.f544h.setSupportPartial(r13);     // Catch: Throwable -> L109 BaseException -> L112
        boolean r14 = r10.m();     // Catch: Throwable -> L109 BaseException -> L112
        String r15 = this.f544h.geteTag();     // Catch: Throwable -> L109 BaseException -> L112
        String r16 = r10.g();     // Catch: Throwable -> L109 BaseException -> L112
        if (lb.a.a() == false) goto L15;
        lb.a.g("DownloadMultiSegmentModule", this.f544h.getId(), "handleFirstConnection", "ResponseCode=" + r11 + " isDeleteCacheIfCheckFailed=" + this.f544h.isDeleteCacheIfCheckFailed());     // Catch: Throwable -> L109 BaseException -> L112
        lb.a.g("DownloadMultiSegmentModule", this.f544h.getId(), "handleFirstConnection", "firstOffset=" + r21 + " cur=" + r10.j() + " before=" + this.f544h.getTotalBytes());     // Catch: Throwable -> L109 BaseException -> L112
    L15:
        if ((r20 instanceof nb.a) == false) goto L21;
        String r17 = ((nb.a) r20).g();     // Catch: Throwable -> L109 BaseException -> L112
        if (TextUtils.isEmpty(r17) == true) goto L21;
        this.f544h.setRedirectPartialUrlResults(r17);     // Catch: Throwable -> L109 BaseException -> L112
    L21:
        if (A(r11, r15, r16, r14, r13) == false) goto L29;
        if (TextUtils.isEmpty(r15) == false) goto L25;
    L27:
        z(r16, "eTag of server file changed");     // Catch: Throwable -> L109 BaseException -> L112
        goto L29
    L25:
        if (r15.equals(r16) == false) goto L27;
        r16 = "";
    L29:
        if (r13 == true) goto L47;
        if (r14 == true) goto L47;
        if (r11 == 403) goto L46;
        if (this.f544h.getStartOffset() < 0) goto L44;
        if (this.f544h.getEndOffset() < 0) goto L42;
        if (this.f544h.getStartOffset() > this.f544h.getEndOffset()) goto L44;
    L42:
        throw new DownloadHttpException(PointerIconCompat.TYPE_WAIT, r11, "response code error : " + r11);     // Catch: Throwable -> L109 BaseException -> L112
    L44:
        throw new BaseException(1084, "startOffset = " + this.f544h.getStartOffset() + ", endOffset = " + this.f544h.getEndOffset() + ", response code error : " + r11);     // Catch: Throwable -> L109 BaseException -> L112
    L46:
        throw new BaseException(1047, "response code error : 403");     // Catch: Throwable -> L109 BaseException -> L112
    L47:
        if (r14 == true) goto L49;
    L51:
        long r18 = r10.d();     // Catch: Throwable -> L109 BaseException -> L112
        if (r10.l() == true) goto L66;
        String r22 = g.B(r20, "Content-Range");     // Catch: Throwable -> L109 BaseException -> L112
        if (lb.a.a() == false) goto L56;
        String r23 = "DownloadMultiSegmentModule";
        String r110 = "handleFirstConnection";
        lb.a.g(r23, this.f544h.getId(), r110, "ContentRange:" + r22);     // Catch: Throwable -> L109 BaseException -> L112
    L58:
        if (TextUtils.isEmpty(r22) == true) goto L63;
        long r24 = c.R(r22);     // Catch: Throwable -> L109 BaseException -> L112
        if (lb.a.a() == false) goto L68;
        int r25 = this.f544h.getId();     // Catch: Throwable -> L109 BaseException -> L112
        String r111 = "TotalLength:" + r24;     // Catch: Throwable -> L109 BaseException -> L112
    L62:
        lb.a.g(r23, r25, r110, r111);     // Catch: Throwable -> L109 BaseException -> L112
    L68:
        if (this.f544h.getStartOffset() > 0) goto L72;
        if (this.f544h.getEndOffset() >= 0) goto L72;
    L84:
        if (TextUtils.isEmpty(this.f544h.getTaskKey()) == true) goto L91;
        if (this.f544h.getTotalBytes() <= 0) goto L91;
        if (r24 == this.f544h.getTotalBytes()) goto L91;
        z("", "file totalLength changed");     // Catch: Throwable -> L109 BaseException -> L112
    L91:
        if (m() == false) goto L94;
        return;
    L94:
        if (this.f544h.getExpectFileLength() <= 0) goto L103;
        if (this.f545i.n("force_check_file_length") != 1) goto L103;
        if (this.f544h.getExpectFileLength() == r24) goto L103;
        throw new BaseException(1070, "expectFileLength = " + this.f544h.getExpectFileLength() + " , totalLength = " + r24);     // Catch: Throwable -> L109 BaseException -> L112
    L103:
        if (k.n(this.f544h) == true) goto L106;
        this.f546j.m(r24, r16, this.f544h.getName());     // Catch: Throwable -> L109 BaseException -> L112
        return;
    L106:
        throw new BaseException(1083, "download global intercept");     // Catch: Throwable -> L109 BaseException -> L112
    L72:
        if (this.f544h.getStartOffset() < 0) goto L108;
        if (this.f544h.getEndOffset() >= r24) goto L108;
        if (this.f544h.getEndOffset() < 0) goto L80;
        if (this.f544h.getStartOffset() > this.f544h.getEndOffset()) goto L108;
    L80:
        if (this.f544h.getEndOffset() >= 0) goto L82;
        r24 = r24 - this.f544h.getStartOffset();     // Catch: Throwable -> L109 BaseException -> L112
        goto L84
    L82:
        r24 = 1 + (this.f544h.getEndOffset() - this.f544h.getStartOffset());     // Catch: Throwable -> L109 BaseException -> L112
    L108:
        throw new BaseException(1084, "startOffset = " + this.f544h.getStartOffset() + ", endOffset = " + this.f544h.getEndOffset() + ", totalLength = " + r24);     // Catch: Throwable -> L109 BaseException -> L112
    L63:
        r24 = r21 + r18;     // Catch: Throwable -> L109 BaseException -> L112
        if (lb.a.a() == false) goto L68;
        r25 = this.f544h.getId();     // Catch: Throwable -> L109 BaseException -> L112
        r111 = "TotalLength2:" + r24;     // Catch: Throwable -> L109 BaseException -> L112
        goto L62
    L56:
        r23 = "DownloadMultiSegmentModule";
        r110 = "handleFirstConnection";
        goto L58
    L66:
        r24 = -1;
        this.f544h.setXTotalBytes(r10.k());     // Catch: Throwable -> L109 BaseException -> L112
        goto L68
    L49:
        if (r21 <= 0) goto L51;
        z("", "isResponseFromBegin but firstOffset > 0");     // Catch: Throwable -> L109 BaseException -> L112
        goto L51
    L8:
        if (TextUtils.isEmpty(r12) == true) goto L10;
        this.f544h.setMimeType(r12);     // Catch: Throwable -> L109 BaseException -> L112
    L112:
        e = move-exception;
        throw e;
    L109:
        th = move-exception;
        c.T(th, "HandleFirstConnection");
    }

    @Override // bb.a, bb.e
    public void f() {
        j r10 = this.f8763l;
        if (r10 == null) goto L6;
        r10.h0();
        return;
    }

    @Override // cb.a, bb.e
    public void k(f r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.g("DownloadMultiSegmentModule", this.f544h.getId(), "proceed", "Run");
    L6:
        if (r(r10, false) == false) goto L8;
        return;
    L8:
        if (m() == true) goto L13;
        y();
        r10.b();
        return;
    }
}
