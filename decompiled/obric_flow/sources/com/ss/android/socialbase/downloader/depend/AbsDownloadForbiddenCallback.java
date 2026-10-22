package com.ss.android.socialbase.downloader.depend;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsDownloadForbiddenCallback implements IDownloadForbiddenCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15481a;

    public AbsDownloadForbiddenCallback() {
        this.f15481a = false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
    public final boolean h() {
        return this.f15481a;
    }
}
