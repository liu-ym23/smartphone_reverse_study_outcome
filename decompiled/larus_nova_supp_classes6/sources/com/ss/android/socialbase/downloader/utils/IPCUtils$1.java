package com.ss.android.socialbase.downloader.utils;

import android.os.RemoteException;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IPCUtils$1 extends DownloadAidlTask.Stub {
    final /* synthetic */ DownloadTask val$downloadTask;

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public IDownloadAidlDepend getDepend() throws RemoteException {
        return IPCUtils.convertDependToAidl(this.val$downloadTask.getDepend());
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
        return IPCUtils.convertDiskSpaceHandlerToAidl(this.val$downloadTask.getDiskSpaceHandler());
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public int getDownloadCompleteHandlerSize() throws RemoteException {
        return this.val$downloadTask.getDownloadCompleteHandlers().size();
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public DownloadInfo getDownloadInfo() throws RemoteException {
        return this.val$downloadTask.getDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
        return IPCUtils.convertDownloadNotificationEventListenerToAidl(this.val$downloadTask.getNotificationEventListener());
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
        return IPCUtils.convertFileProviderToAidl(this.val$downloadTask.getFileUriProvider());
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
        return IPCUtils.convertForbiddenHandlerToAidl(this.val$downloadTask.getForbiddenHandler());
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
        return IPCUtils.convertInterceptorToAidl(this.val$downloadTask.getInterceptor());
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
        return IPCUtils.convertMonitorDependToAidl(this.val$downloadTask.getMonitorDepend());
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
        return IPCUtils.convertNotificationClickCallbackToAidl(this.val$downloadTask.getNotificationClickCallback());
    }

    public IPCUtils$1(DownloadTask r1) {
        this.val$downloadTask = r1;
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int r2) throws RemoteException {
        return IPCUtils.convertDownloadCompleteHandlerToAidl(this.val$downloadTask.getDownloadCompleteHandlerByIndex(r2));
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public int[] getDownloadListenerHashCodeLists(int r2) {
        return this.val$downloadTask.getDownloadListenerHashCodeLists(DownloadHelper.convertListenerType(r2));
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public IDownloadAidlListener getSingleDownloadListener(int r3) throws RemoteException {
        IDownloadListener r0 = this.val$downloadTask.getSingleDownloadListener(DownloadHelper.convertListenerType(r3));
        if (r3 != ListenerType.SUB.ordinal()) goto L5;
        boolean r4 = false;
    L7:
        return IPCUtils.convertListenerToAidl(r0, r4);
    L5:
        r4 = true;
        goto L7
    }

    @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
    public IDownloadAidlListener getDownloadListenerByHashCode(int r3, int r4) {
        IDownloadListener r5 = this.val$downloadTask.getDownloadListenerByHashCode(DownloadHelper.convertListenerType(r3), r4);
        if (r3 != ListenerType.SUB.ordinal()) goto L5;
        boolean r6 = false;
    L7:
        return IPCUtils.convertListenerToAidl(r5, r6);
    L5:
        r6 = true;
        goto L7
    }
}
