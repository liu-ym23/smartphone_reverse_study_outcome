package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCommonParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IDownloadCache f15308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DownloadTask f15309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DownloadInfo f15310c;
    public DownloadSetting d;
    public DownloadStatusHandler e;
    public RunStatus f;
    public volatile boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f15312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f15313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f15314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f15315l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public NetworkRetryStrategy f15316m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public NetworkFailoverStrategy f15317n;

    public DownloadCommonParams() {
        this.f = RunStatus.f15283a;
        this.g = true;
        this.f15311h = true;
        this.f15312i = false;
    }
}
