package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDownloadHttpConnection f15912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15913c;
    public long d;
    public long e;

    public HttpResponse(String r5, IDownloadHttpConnection r10) {
        this.f15911a = r5;
        this.f15913c = r10.b();
        this.f15912b = r10;
    }

    public final boolean a() {
        int r5 = this.f15913c;
        String r10 = this.f15912b.a("Accept-Ranges");
        SparseArray r11 = DownloadHelper.f16133a;
        if (r5 < 400) goto L6;
        return false;
    L6:
        if (r5 == 206) goto L12;
        if (r5 == 1) goto L12;
        if ("bytes".equals(r10) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public final long b() {
        String r5 = DownloadUtils.a(this.f15912b, "Cache-Control");
        SparseArray r10 = DownloadHelper.f16133a;
        if (TextUtils.isEmpty(r5) == false) goto L13;
        return 0;
    L13:
        Matcher r11 = Pattern.compile("max-age=([0-9]+)").matcher(r5);     // Catch: Throwable -> L10
        if (r11.find() == false) goto L12;
        return Long.parseLong(r11.group(1));
    L12:
        return 0;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    public final long c() {
        if (this.e > 0) goto L11;
        if (d() == true) goto L9;
        String r5 = DownloadUtils.a(this.f15912b, "Content-Range");
        if (TextUtils.isEmpty(r5) == true) goto L11;
        this.e = DownloadHelper.c(r5);
        goto L11
    L9:
        this.e = -1;
    L11:
        return this.e;
    }

    public final boolean d() {
        IDownloadHttpConnection r5 = this.f15912b;
        SparseArray r10 = DownloadHelper.f16133a;
        if (r5 != null) goto L6;
        return false;
    L6:
        if ("chunked".equals(r5.a("Transfer-Encoding")) == false) goto L8;
        return true;
    L8:
        if (DownloadUtils.a(r5) == (-1)) goto L13;
        return false;
    L13:
        return true;
    }

    public HttpResponse(String r5, IDownloadHttpConnection r10, int r11) {
        this.f15911a = r5;
        this.f15913c = 304;
        this.f15912b = r10;
    }
}
