package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;

/* JADX INFO: loaded from: classes3.dex */
public class PCDNChunkAllocater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DownloadInfo f15347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15349c;
    public long d;

    public PCDNChunkAllocater(DownloadInfo r5, long r10) {
        this.f15347a = r5;
        this.f15348b = r10;
        SparseArray r11 = DownloadHelper.f16133a;
        if (r5 != null) goto L5;
        long r12 = -1;
    L6:
        r5.d();
        this.d = r5.T0.optLong("start_offset") + r12;
        return;
    L5:
        r12 = r5.i();
        goto L6
    }
}
