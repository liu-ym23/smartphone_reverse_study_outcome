package com.bytedance.ai.resource;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Result;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.common.reflect.w f2558a;

    public a(com.google.common.reflect.w r5) {
        this.f2558a = r5;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void a(DownloadInfo r10, BaseException r11) {
        String r12 = null;
        if (r10 == null) goto L5;
        BaseException r5 = r10.Q0;
    L6:
        StringBuilder r13 = new StringBuilder("url: ");
        com.google.common.reflect.w r14 = this.f2558a;
        r13.append((String) r14.f9376b);
        r13.append(", path: ");
        String r15 = ug.a.c(r13, (String) r14.f9377c, " ===> download failed", "AIPackageManager");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L9;
        r16.i("AIPackageManager", r15);
    L9:
        Result.Companion r17 = Result.Companion;
        ((SafeContinuation) r14.d).resumeWith(Result.m124constructorimpl(Boolean.FALSE));
        StringBuilder r18 = new StringBuilder("Failed to download , status=");
        if (r10 == null) goto L12;
        Integer r19 = Integer.valueOf(r10.o());
    L13:
        r18.append(r19);
        r18.append(", code=");
        if (r5 == null) goto L16;
        Integer r20 = Integer.valueOf(r5.f15601a);
    L17:
        r18.append(r20);
        r18.append(", msg=");
        if (r5 == null) goto L20;
        r12 = r5.f15602b;
    L20:
        String r21 = androidx.room.jarjarred.org.antlr.runtime.a.v(r18, r12, "AIDownloadManager", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L24;
        r22.w("AIDownloadManager", r21);
        return;
    L24:
        return;
    L16:
        r20 = null;
        goto L17
    L12:
        r19 = null;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void l(DownloadInfo r5) {
        if (r5 == null) goto L5;
        String r10 = r5.d;
        if (r10 == null) goto L5;
    L6:
        StringBuilder r11 = new StringBuilder("url: ");
        com.google.common.reflect.w r12 = this.f2558a;
        r11.append((String) r12.f9376b);
        r11.append(", path: ");
        String r13 = ug.a.c(r11, (String) r12.f9377c, " ===> download successful", "AIPackageManager");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L9;
        r14.i("AIPackageManager", r13);
    L9:
        Result.Companion r15 = Result.Companion;
        Object r16 = Result.m124constructorimpl(Boolean.TRUE);
        ((SafeContinuation) r12.d).resumeWith(r16);
        String r17 = "download successes, url = ".concat(r10);
        Intrinsics.checkNotNullParameter("AIDownloadManager", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L13;
        r18.i("AIDownloadManager", r17);
        return;
    L13:
        return;
    L5:
        r10 = "";
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void n(DownloadInfo r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.f15817h0 > 0) goto L7;
        return;
    L7:
        if (r5.i() > r5.f15817h0) goto L13;
        long r10 = (r5.i() * 100) / r5.f15817h0;
        return;
    }
}
