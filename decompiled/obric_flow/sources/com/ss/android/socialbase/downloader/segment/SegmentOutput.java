package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class SegmentOutput implements IOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Segment f16062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RandomAccessOutputStream f16063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IOutput f16064c;

    public SegmentOutput(DownloadInfo r10, BufferQueue r11, Segment r12) {
        this.f16062a = r12;
        DownloadSetting r5 = DownloadSetting.a(r10.l(), null);
        String r13 = r10.q();
        String r14 = r10.p();
        int r15 = r5.a("flush_buffer_size_byte", -1);
        boolean r16 = false;
        if (r5.a("segment_nio", 0) <= 0) goto L5;
        r16 = true;
    L5:
        RandomAccessOutputStream r17 = DownloadHelper.a(r10, r13, r14, r15, r16);
        r10.d();
        long r18 = r10.T0.optLong("start_offset");
        if (r18 >= 0) goto L14;
        r18 = 0;
    L14:
        r17.a(r12.b() - r18);     // Catch: IOException -> L11
        this.f16063b = r17;
        this.f16064c = new OutputStub(r11, this);
        return;
    L11:
        e = move-exception;
        throw new BaseException(1054, DownloadUtils.a(e));
    }

    public final void a(Buffer r5) {
        this.f16063b.a(r5.f16006a, r5.f16008c);
        Segment r10 = this.f16062a;
        r10.f16035b.addAndGet(r5.f16008c);
    }
}
