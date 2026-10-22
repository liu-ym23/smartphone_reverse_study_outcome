package qb;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements r {
    public g() {
    }

    private nb.h b(int r12, String r13, String r14, List<HttpHeader> r15, int r16, boolean r17, DownloadInfo r18) {
        nb.i r10 = e(r16);
        if (r10 == null) goto L28;
        IOException r11 = null;
        long r19 = 0;
        if (r17 == false) goto L33;
        r19 = System.currentTimeMillis();     // Catch: Throwable -> L8 IOException -> L10
    L10:
        e = e;
    L20:
        IOException r20 = e;
        throw r20;     // Catch: Throwable -> L22
    L22:
        th = th;
        r11 = r20;
    L24:
        if (r17 == false) goto L26;
        mb.a.e(null, r13, r14, System.currentTimeMillis() - r19, "get", r16, r11, r18);
    L26:
        throw th;
    L8:
        th = th;
    L33:
        nb.h r21 = r10.a(r12, r13, r15);     // Catch: Throwable -> L17 IOException -> L19
        if (r17 == false) goto L16;
        mb.a.e(r21, r13, r14, System.currentTimeMillis() - r19, "get", r16, null, r18);
    L16:
        return r21;
    L19:
        e = e;
    L17:
        th = th;
        goto L24
    L28:
        throw new BaseException(1022, new IOException("httpService not exist, netLib = " + r16));
    }

    private boolean c(DownloadInfo r10) {
        if (r10 == null) goto L10;
        JSONObject r11 = rb.a.g(r10.getId()).q("segment_config");
        if (r11 != null) goto L7;
        return false;
    L7:
        if (r11.optInt("enable_ttnet_ip_request", 0) <= 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private int[] d(int r10) {
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L17;
        if (r10 == 3) goto L15;
        if (r10 == 5) goto L13;
        return new int[]{1, 0};
    L13:
        return new int[]{2};
    L15:
        return new int[]{0, 1};
    L17:
        return new int[]{1};
    L19:
        return new int[]{0};
    }

    private nb.i e(int r10) {
        if (2 != r10) goto L10;
        nb.i r11 = com.ss.android.socialbase.downloader.downloader.a.G();
        if (r11 == null) goto L8;
        return r11;
    L8:
        return com.ss.android.socialbase.downloader.downloader.a.n();
    L10:
        if (r10 != 1) goto L13;
        return com.ss.android.socialbase.downloader.downloader.a.G();
    L13:
        return com.ss.android.socialbase.downloader.downloader.a.n();
    }

    @Override // qb.r
    public nb.h a(boolean r18, int r19, String r20, String r21, List<HttpHeader> r22, int r23, boolean r24, DownloadInfo r25) {
        if (TextUtils.isEmpty(r21) == true) goto L12;
        if (r22 != null) goto L6;
        List<HttpHeader> r10 = new ArrayList();
    L7:
        r10.add(new HttpHeader("ss_d_request_host_ip_114", r21));
        if (c(r25) == true) goto L10;
        List<HttpHeader> r12 = r10;
        int r11 = 1;
    L16:
        int[] r13 = d(r11);
        int r14 = r13.length;
        int r15 = 0;
        Exception r16 = null;
    L17:
        if (r15 >= r14) goto L35;
        int r17 = r15;
        nb.h r26 = b(r19, r20, r21, r12, r13[r15], r24, r25);     // Catch: Exception -> L22
        if (r26 == null) goto L34;
        return r26;
    L34:
        r15 = r17 + 1;
    L22:
        e = move-exception;
        if (r25 != null) goto L26;
    L33:
        r16 = e;
        goto L34
    L26:
        if (r25.isExpiredRedownload() == false) goto L33;
        if (com.ss.android.socialbase.downloader.utils.g.S(e) == false) goto L33;
        if (com.ss.android.socialbase.downloader.utils.g.H(r12) == false) goto L33;
        throw e;
    L35:
        if (r16 != null) goto L37;
        return null;
    L37:
        throw r16;
    L10:
        r12 = r10;
    L15:
        r11 = r23;
        goto L16
    L6:
        r10 = r22;
        goto L7
    L12:
        if (r18 == true) goto L14;
        r11 = 2;
        r12 = r22;
        goto L16
    L14:
        r12 = r22;
        goto L15
    }
}
