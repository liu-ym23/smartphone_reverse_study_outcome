package com.ss.android.socialbase.downloader.utils;

import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadExtListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IPCUtils$2 extends IDownloadAidlListener.Stub {
    final /* synthetic */ boolean val$isInMainThread;
    final /* synthetic */ IDownloadListener val$listener;

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public int getOriginHashCode() throws RemoteException {
        return this.val$listener.hashCode();
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onCanceled(DownloadInfo r3) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 7(this, r3));
        return;
    L5:
        this.val$listener.onCanceled(r3);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onFirstStart(DownloadInfo r3) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 8(this, r3));
        return;
    L5:
        this.val$listener.onFirstStart(r3);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onFirstSuccess(DownloadInfo r3) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 9(this, r3));
        return;
    L5:
        this.val$listener.onFirstSuccess(r3);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onPause(DownloadInfo r3) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 4(this, r3));
        return;
    L5:
        this.val$listener.onPause(r3);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onPrepare(DownloadInfo r3) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 1(this, r3));
        return;
    L5:
        this.val$listener.onPrepare(r3);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onProgress(DownloadInfo r3) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 3(this, r3));
        return;
    L5:
        this.val$listener.onProgress(r3);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onStart(DownloadInfo r3) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 2(this, r3));
        return;
    L5:
        this.val$listener.onStart(r3);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onSuccessed(DownloadInfo r3) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 5(this, r3));
        return;
    L5:
        this.val$listener.onSuccessed(r3);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onWaitingDownloadCompleteHandler(DownloadInfo r3) throws RemoteException {
        IDownloadExtListener r0 = this.val$listener;
        if ((r0 instanceof IDownloadExtListener) == true) goto L5;
        return;
    L5:
        if (this.val$isInMainThread == false) goto L7;
        IPCUtils.access$000().post(new 12(this, r3));
        return;
    L7:
        r0.onWaitingDownloadCompleteHandler(r3);
    }

    public IPCUtils$2(IDownloadListener r1, boolean r2) {
        this.val$listener = r1;
        this.val$isInMainThread = r2;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onFailed(DownloadInfo r3, BaseException r4) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 6(this, r3, r4));
        return;
    L5:
        this.val$listener.onFailed(r3, r4);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onRetry(DownloadInfo r3, BaseException r4) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 10(this, r3, r4));
        return;
    L5:
        this.val$listener.onRetry(r3, r4);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
    public void onRetryDelay(DownloadInfo r3, BaseException r4) throws RemoteException {
        if (this.val$isInMainThread == false) goto L5;
        IPCUtils.access$000().post(new 11(this, r3, r4));
        return;
    L5:
        this.val$listener.onRetryDelay(r3, r4);
    }
}
