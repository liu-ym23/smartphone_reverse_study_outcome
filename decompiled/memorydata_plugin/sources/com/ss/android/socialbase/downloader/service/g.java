package com.ss.android.socialbase.downloader.service;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class g implements r {
    public g() {
    }

    private com.ss.android.socialbase.downloader.network.h a(int r12, String r13, String r14, List<HttpHeader> r15, int r16, boolean r17, DownloadInfo r18) {
        List<HttpHeader> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.network.i r1 = a(r16);
        if (r1 == null) goto L28;
        IOException r8 = null;
        long r3 = 0;
        if (r17 == false) goto L31;
        r3 = System.currentTimeMillis();     // Catch: Throwable -> L8 IOException -> L10
    L10:
        e = e;
    L20:
        IOException r2 = e;
        throw r2;     // Catch: Throwable -> L22
    L22:
        th = th;
        r8 = r2;
    L24:
        if (r17 == false) goto L26;
        com.ss.android.socialbase.downloader.f.a.a(null, r13, r14, System.currentTimeMillis() - r3, "get", r16, r8, r18);
    L26:
        throw th;
    L8:
        th = th;
    L31:
        com.ss.android.socialbase.downloader.network.h r4 = r1.a(r12, r13, r0);     // Catch: Throwable -> L17 IOException -> L19
        if (r17 == false) goto L16;
        com.ss.android.socialbase.downloader.f.a.a(r4, r13, r14, System.currentTimeMillis() - r3, "get", r16, null, r18);
    L16:
        return r4;
    L19:
        e = e;
    L17:
        th = th;
        goto L24
    L28:
        throw new BaseException(1022, new IOException("httpService not exist, netLib = " + r16));
    }

    private com.ss.android.socialbase.downloader.network.i a(int r1) {
        if (2 != r1) goto L10;
        com.ss.android.socialbase.downloader.network.i r0 = com.ss.android.socialbase.downloader.downloader.b.d();
        if (r0 == null) goto L8;
        return r0;
    L8:
        return com.ss.android.socialbase.downloader.downloader.b.g();
    L10:
        if (r1 != 1) goto L13;
        return com.ss.android.socialbase.downloader.downloader.b.d();
    L13:
        return com.ss.android.socialbase.downloader.downloader.b.g();
    }

    private boolean a(DownloadInfo r2) {
        if (r2 == null) goto L10;
        JSONObject r3 = com.ss.android.socialbase.downloader.g.a.a(r2.getId()).e("segment_config");
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r3.optInt("enable_ttnet_ip_request", 0) <= 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private int[] b(int r4) {
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L17;
        if (r4 == 3) goto L15;
        if (r4 == 5) goto L13;
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

    @Override // com.ss.android.socialbase.downloader.service.r
    public com.ss.android.socialbase.downloader.network.h a(boolean r18, int r19, String r20, String r21, List<HttpHeader> r22, int r23, boolean r24, DownloadInfo r25) {
        List<HttpHeader> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r21) == true) goto L10;
        if (r0 != null) goto L6;
        r0 = new ArrayList();
    L6:
        r0.add(new HttpHeader("ss_d_request_host_ip_114", r21));
        if (a(r25) == true) goto L12;
        int r1 = 1;
    L13:
        List<HttpHeader> r12 = r0;
        int[] r13 = b(r1);
        int r14 = r13.length;
        int r8 = 0;
        Exception r2 = null;
    L14:
        if (r8 >= r14) goto L32;
        int r16 = r8;
        com.ss.android.socialbase.downloader.network.h r3 = a(r19, r20, r21, r12, r13[r8], r24, r25);     // Catch: Exception -> L19
        if (r3 == null) goto L31;
        return r3;
    L31:
        r8 = r16 + 1;
    L19:
        e = move-exception;
        if (r25 != null) goto L23;
    L30:
        r2 = e;
        goto L31
    L23:
        if (r25.isExpiredRedownload() == false) goto L30;
        if (com.ss.android.socialbase.downloader.utils.g.d(e) == false) goto L30;
        if (com.ss.android.socialbase.downloader.utils.g.a(r12) == false) goto L30;
        throw e;
    L32:
        if (r2 != null) goto L34;
        return null;
    L34:
        throw r2;
    L12:
        r1 = r23;
        goto L13
    L10:
        if (r18 == true) goto L12;
        r1 = 2;
        goto L13
    }
}
