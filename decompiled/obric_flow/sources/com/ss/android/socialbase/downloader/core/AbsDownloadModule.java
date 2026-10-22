package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsDownloadModule implements IDownloadModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IDownloadCache f15288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DownloadTask f15289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DownloadInfo f15290c;
    public DownloadSetting d;
    public DownloadStatusHandler e;
    public DownloadCommonParams f;

    public AbsDownloadModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void a() {
    }

    public final boolean b() {
        if (this.f.f15310c.o() != (-2)) goto L9;
        DownloadCommonParams r5 = this.f;
        RunStatus r10 = r5.f;
        RunStatus r11 = RunStatus.f15284b;
        if (r10 == r11) goto L7;
        r5.f = r11;
    L7:
        return true;
    L9:
        if (this.f.f15310c.o() != (-4)) goto L14;
        DownloadCommonParams r12 = this.f;
        RunStatus r13 = r12.f;
        RunStatus r14 = RunStatus.f15285c;
        if (r13 == r14) goto L13;
        r12.f = r14;
    L13:
        return true;
    L14:
        RunStatus r15 = this.f.f;
        if (r15 != RunStatus.f15285c) goto L17;
    L21:
        return true;
    L17:
        if (r15 == RunStatus.f15284b) goto L21;
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void a(long r5, int r10) {
    }

    public AbsDownloadModule a(DownloadCommonParams r5) {
        this.f = r5;
        this.f15288a = r5.f15308a;
        this.f15289b = r5.f15309b;
        this.f15290c = r5.f15310c;
        this.d = r5.d;
        this.e = r5.e;
        return this;
    }
}
