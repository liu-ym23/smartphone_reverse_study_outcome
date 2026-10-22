package com.ss.android.socialbase.downloader.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class IPCUtils {
    private static Handler mMainThreadHandler;

    public IPCUtils() {
    }

    static {
        mMainThreadHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ Handler access$000() {
        return mMainThreadHandler;
    }

    public static IDownloadAidlDepend convertDependToAidl(IDownloadDepend r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 10(r1);
    }

    public static IDownloadDiskSpaceCallback convertDiskSpaceCallbackFromAidl(IDownloadDiskSpaceAidlCallback r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 9(r1);
    }

    public static IDownloadDiskSpaceAidlCallback convertDiskSpaceCallbackToAidl(IDownloadDiskSpaceCallback r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 24(r1);
    }

    public static IDownloadDiskSpaceHandler convertDiskSpaceHandlerFromAidl(IDownloadDiskSpaceAidlHandler r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 23(r1);
    }

    public static IDownloadDiskSpaceAidlHandler convertDiskSpaceHandlerToAidl(IDownloadDiskSpaceHandler r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 8(r1);
    }

    public static IDownloadCompleteHandler convertDownloadCompleteHandlerFromAidl(IDownloadCompleteAidlHandler r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 14(r1);
    }

    public static IDownloadCompleteAidlHandler convertDownloadCompleteHandlerToAidl(IDownloadCompleteHandler r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 15(r1);
    }

    public static IDownloadDepend convertDownloadDependFromAidl(IDownloadAidlDepend r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 17(r1);
    }

    public static IDownloadMonitorDepend convertDownloadMonitorDependFromAidl(IDownloadAidlMonitorDepend r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 18(r1);
    }

    public static IDownloadNotificationEventListener convertDownloadNotificationEventListenerFromAidl(IDownloadNotificationEventAidlListener r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 13(r1);
    }

    public static IDownloadNotificationEventAidlListener convertDownloadNotificationEventListenerToAidl(IDownloadNotificationEventListener r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 3(r1);
    }

    public static DownloadTask convertDownloadTaskFromAidl(DownloadAidlTask r7) {
        if (r7 != null) goto L19;
        return null;
    L19:
        DownloadTask r1 = new DownloadTask(r7.getDownloadInfo());     // Catch: RemoteException -> L16
        r1.notificationEventListener(convertDownloadNotificationEventListenerFromAidl(r7.getDownloadNotificationEventListener())).interceptor(convertInterceptorFromAidl(r7.getInterceptor())).depend(convertDownloadDependFromAidl(r7.getDepend())).monitorDepend(convertDownloadMonitorDependFromAidl(r7.getMonitorDepend())).forbiddenHandler(convertForbiddenHandlerFromAidl(r7.getForbiddenHandler())).diskSpaceHandler(convertDiskSpaceHandlerFromAidl(r7.getDiskSpaceHandler())).fileUriProvider(convertFileProviderFromAidl(r7.getFileProvider())).notificationClickCallback(convertNotificationClickCallbackFromAidl(r7.getNotificationClickCallback()));     // Catch: RemoteException -> L16
        ListenerType r2 = ListenerType.MAIN;     // Catch: RemoteException -> L16
        IDownloadAidlListener r3 = r7.getSingleDownloadListener(r2.ordinal());     // Catch: RemoteException -> L16
        if (r3 == null) goto L8;
        r1.mainThreadListenerWithHashCode(r3.hashCode(), convertListenerFromAidl(r3));     // Catch: RemoteException -> L16
    L8:
        ListenerType r4 = ListenerType.SUB;     // Catch: RemoteException -> L16
        IDownloadAidlListener r5 = r7.getSingleDownloadListener(r4.ordinal());     // Catch: RemoteException -> L16
        if (r5 == null) goto L11;
        r1.subThreadListenerWithHashCode(r5.hashCode(), convertListenerFromAidl(r5));     // Catch: RemoteException -> L16
    L11:
        ListenerType r6 = ListenerType.NOTIFICATION;     // Catch: RemoteException -> L16
        IDownloadAidlListener r8 = r7.getSingleDownloadListener(r6.ordinal());     // Catch: RemoteException -> L16
        if (r8 == null) goto L14;
        r1.notificationListenerWithHashCode(r8.hashCode(), convertListenerFromAidl(r8));     // Catch: RemoteException -> L16
    L14:
        setDownloadListeners(r1, r7, r2);     // Catch: RemoteException -> L16
        setDownloadListeners(r1, r7, r4);     // Catch: RemoteException -> L16
        setDownloadListeners(r1, r7, r6);     // Catch: RemoteException -> L16
        setCompletedHandlers(r1, r7);     // Catch: RemoteException -> L16
        return r1;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static DownloadAidlTask convertDownloadTaskToAidl(DownloadTask r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 1(r1);
    }

    public static IDownloadFileUriProvider convertFileProviderFromAidl(IDownloadAidlFileProvider r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 26(r1);
    }

    public static IDownloadAidlFileProvider convertFileProviderToAidl(IDownloadFileUriProvider r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 6(r1);
    }

    public static IDownloadForbiddenCallback convertForbiddenCallbackFromAidl(IDownloadForbiddenAidlCallback r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 7(r1);
    }

    public static IDownloadForbiddenAidlCallback convertForbiddenCallbackToAidl(IDownloadForbiddenCallback r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 20(r1);
    }

    public static IDownloadForbiddenHandler convertForbiddenHandlerFromAidl(IDownloadForbiddenAidlHandler r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 19(r1);
    }

    public static IDownloadForbiddenAidlHandler convertForbiddenHandlerToAidl(IDownloadForbiddenHandler r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 5(r1);
    }

    public static IDownloadInterceptor convertInterceptorFromAidl(IDownloadAidlInterceptor r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 25(r1);
    }

    public static IDownloadAidlInterceptor convertInterceptorToAidl(IDownloadInterceptor r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 12(r1);
    }

    public static IDownloadListener convertListenerFromAidl(IDownloadAidlListener r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 27(r1);
    }

    public static IDownloadAidlMonitorDepend convertMonitorDependToAidl(IDownloadMonitorDepend r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 11(r1);
    }

    public static INotificationClickCallback convertNotificationClickCallbackFromAidl(INotificationClickAidlCallback r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 16(r1);
    }

    public static INotificationClickAidlCallback convertNotificationClickCallbackToAidl(INotificationClickCallback r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 4(r1);
    }

    public static ProcessCallback convertProcessAidlCallbackFromAidl(ProcessAidlCallback r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 22(r1);
    }

    public static ProcessAidlCallback convertProcessCallbackToAidl(final ProcessCallback r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass21(r1);
    }

    public static IDownloadAidlListener convertListenerToAidl(IDownloadListener r1, boolean r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new 2(r1, r2);
    }

    private static void setCompletedHandlers(DownloadTask r2, DownloadAidlTask r3) throws RemoteException {
        int r0 = 0;
    L4:
        if (r0 >= r3.getDownloadCompleteHandlerSize()) goto L9;
        IDownloadCompleteAidlHandler r1 = r3.getDownloadCompleteAidlHandlerByIndex(r0);
        if (r1 == null) goto L8;
        r2.addDownloadCompleteHandler(convertDownloadCompleteHandlerFromAidl(r1));
    L8:
        r0 = r0 + 1;
        goto L4
    }

    private static void setDownloadListeners(DownloadTask r5, DownloadAidlTask r6, ListenerType r7) throws RemoteException {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        int[] r1 = r6.getDownloadListenerHashCodeLists(r7.ordinal());
        if (r1 != null) goto L5;
    L13:
        r5.setDownloadListeners(r0, r7);
        return;
    L5:
        if (r1.length <= 0) goto L13;
        int r2 = 0;
    L8:
        if (r2 >= r1.length) goto L13;
        IDownloadAidlListener r3 = r6.getDownloadListenerByHashCode(r7.ordinal(), r1[r2]);
        if (r3 == null) goto L12;
        r0.put(Integer.valueOf(r3.getOriginHashCode()), convertListenerFromAidl(r3));
    L12:
        r2 = r2 + 1;
        goto L8
    }
}
