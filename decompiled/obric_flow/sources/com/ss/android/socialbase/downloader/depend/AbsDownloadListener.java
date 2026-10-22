package com.ss.android.socialbase.downloader.depend;

import androidx.constraintlayout.motion.widget.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import f4.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    public AbsDownloadListener() {
    }

    public void a(DownloadInfo r10) {
        if (Logger.a(r10) == false) goto L7;
        if (r10 == null) goto L8;
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onIntercept", "Name: " + r10.f15808b, false);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void b(DownloadInfo r10, BaseException r11) {
        if (Logger.a(r10) == false) goto L11;
        if (r10 == null) goto L12;
        String r12 = r10.f15808b;
        if (r11 == null) goto L8;
        String r13 = r11.f15602b;
    L9:
        String r14 = a.p("Name: ", r12, " because of : ", r13);
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onRetry", r14, false);
        return;
    L8:
        r13 = "unkown";
        goto L9
    L12:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void c(DownloadInfo r10, BaseException r11) {
        if (Logger.a(r10) == false) goto L11;
        if (r10 == null) goto L12;
        String r12 = r10.f15808b;
        if (r11 == null) goto L8;
        String r13 = r11.f15602b;
    L9:
        String r14 = a.p("Name: ", r12, " because of : ", r13);
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onRetryDelay", r14, false);
        return;
    L8:
        r13 = "unkown";
        goto L9
    L12:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void d(DownloadInfo r10) {
        if (Logger.a(r10) == false) goto L7;
        if (r10 == null) goto L8;
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onPause", "Name: " + r10.f15808b, false);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void f(DownloadInfo r10) {
        if (Logger.a(r10) == false) goto L7;
        if (r10 == null) goto L8;
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onFirstStart", "Name: " + r10.f15808b, false);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void g(DownloadInfo r10) {
        if (Logger.a(r10) == false) goto L7;
        if (r10 == null) goto L8;
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onCanceled", "Name: " + r10.f15808b, false);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void i(DownloadInfo r10) {
        if (Logger.a(r10) == false) goto L7;
        if (r10 == null) goto L8;
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onPrepare", "Name: " + r10.f15808b, false);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void j(DownloadInfo r10) {
        if (Logger.a(r10) == false) goto L7;
        if (r10 == null) goto L8;
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onFirstSuccess", "Name: " + r10.f15808b, false);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void m(DownloadInfo r10) {
        if (Logger.a(r10) == false) goto L7;
        if (r10 == null) goto L8;
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onStart", "Name: " + r10.f15808b, false);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void n(DownloadInfo r10) {
        if (Logger.a(r10) == false) goto L9;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.f15817h0 == 0) goto L11;
        Logger.a("AbsDownloadListener", r10.l(), null, "onProgress", String.format("Name: %s %.2f%%", new Object[]{r10.f15808b, Float.valueOf((r10.i() / r10.f15817h0) * 100.0f)}), false);
        return;
    L11:
        return;
    }

    public static void a(DownloadInfo r10, int r11) {
        if (Logger.a(r10) == false) goto L7;
        if (r10 == null) goto L8;
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onReceiveData", "Name: " + r10.f15808b + " data len:" + r11, false);
        return;
    L8:
        return;
    }

    public static void a(DownloadInfo r10, ArrayList r11) {
        if (Logger.a(r10) == false) goto L7;
        if (r10 == null) goto L8;
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onReceiveHeader", "Name: " + r10.f15808b + " header:" + r11, false);
        return;
    L8:
        return;
    }

    public static void a(DownloadInfo r10, String r11) {
        if (Logger.a(r10) == false) goto L7;
        if (r10 == null) goto L8;
        String r12 = b.b(new StringBuilder("Name: "), r10.f15808b, " requestLog:", r11);
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onReceiveRequestLog", r12, false);
        return;
    L8:
        return;
    }
}
