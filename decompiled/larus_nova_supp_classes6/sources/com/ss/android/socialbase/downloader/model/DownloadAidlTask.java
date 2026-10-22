package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface DownloadAidlTask extends IInterface {

    public static abstract class Stub extends Binder implements DownloadAidlTask {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.model.DownloadAidlTask";
        static final int TRANSACTION_getDepend = 8;
        static final int TRANSACTION_getDiskSpaceHandler = 10;
        static final int TRANSACTION_getDownloadCompleteAidlHandlerByIndex = 14;
        static final int TRANSACTION_getDownloadCompleteHandlerSize = 13;
        static final int TRANSACTION_getDownloadInfo = 1;
        static final int TRANSACTION_getDownloadListenerByHashCode = 3;
        static final int TRANSACTION_getDownloadListenerHashCodeLists = 2;
        static final int TRANSACTION_getDownloadNotificationEventListener = 5;
        static final int TRANSACTION_getFileProvider = 12;
        static final int TRANSACTION_getForbiddenHandler = 9;
        static final int TRANSACTION_getInterceptor = 7;
        static final int TRANSACTION_getMonitorDepend = 11;
        static final int TRANSACTION_getNotificationClickCallback = 6;
        static final int TRANSACTION_getSingleDownloadListener = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static DownloadAidlTask getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static DownloadAidlTask asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof DownloadAidlTask) == false) goto L12;
            return (DownloadAidlTask) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(DownloadAidlTask r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 == 1598968902) goto L72;
            IBinder r0 = null;
            switch(r4) {
                case 1: goto L67;
                case 2: goto L65;
                case 3: goto L60;
                case 4: goto L55;
                case 5: goto L50;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L35;
                case 9: goto L30;
                case 10: goto L25;
                case 11: goto L20;
                case 12: goto L15;
                case 13: goto L13;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadCompleteAidlHandler r8 = getDownloadCompleteAidlHandlerByIndex(r5.readInt());
            r6.writeNoException();
            if (r8 == null) goto L11;
            r0 = r8.asBinder();
        L11:
            r6.writeStrongBinder(r0);
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            int r9 = getDownloadCompleteHandlerSize();
            r6.writeNoException();
            r6.writeInt(r9);
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlFileProvider r10 = getFileProvider();
            r6.writeNoException();
            if (r10 == null) goto L18;
            r0 = r10.asBinder();
        L18:
            r6.writeStrongBinder(r0);
            return true;
        L20:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlMonitorDepend r11 = getMonitorDepend();
            r6.writeNoException();
            if (r11 == null) goto L23;
            r0 = r11.asBinder();
        L23:
            r6.writeStrongBinder(r0);
            return true;
        L25:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadDiskSpaceAidlHandler r12 = getDiskSpaceHandler();
            r6.writeNoException();
            if (r12 == null) goto L28;
            r0 = r12.asBinder();
        L28:
            r6.writeStrongBinder(r0);
            return true;
        L30:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadForbiddenAidlHandler r13 = getForbiddenHandler();
            r6.writeNoException();
            if (r13 == null) goto L33;
            r0 = r13.asBinder();
        L33:
            r6.writeStrongBinder(r0);
            return true;
        L35:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlDepend r14 = getDepend();
            r6.writeNoException();
            if (r14 == null) goto L38;
            r0 = r14.asBinder();
        L38:
            r6.writeStrongBinder(r0);
            return true;
        L40:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlInterceptor r15 = getInterceptor();
            r6.writeNoException();
            if (r15 == null) goto L43;
            r0 = r15.asBinder();
        L43:
            r6.writeStrongBinder(r0);
            return true;
        L45:
            r5.enforceInterface(DESCRIPTOR);
            INotificationClickAidlCallback r16 = getNotificationClickCallback();
            r6.writeNoException();
            if (r16 == null) goto L48;
            r0 = r16.asBinder();
        L48:
            r6.writeStrongBinder(r0);
            return true;
        L50:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadNotificationEventAidlListener r17 = getDownloadNotificationEventListener();
            r6.writeNoException();
            if (r17 == null) goto L53;
            r0 = r17.asBinder();
        L53:
            r6.writeStrongBinder(r0);
            return true;
        L55:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlListener r18 = getSingleDownloadListener(r5.readInt());
            r6.writeNoException();
            if (r18 == null) goto L58;
            r0 = r18.asBinder();
        L58:
            r6.writeStrongBinder(r0);
            return true;
        L60:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlListener r19 = getDownloadListenerByHashCode(r5.readInt(), r5.readInt());
            r6.writeNoException();
            if (r19 == null) goto L63;
            r0 = r19.asBinder();
        L63:
            r6.writeStrongBinder(r0);
            return true;
        L65:
            r5.enforceInterface(DESCRIPTOR);
            int[] r20 = getDownloadListenerHashCodeLists(r5.readInt());
            r6.writeNoException();
            r6.writeIntArray(r20);
            return true;
        L67:
            r5.enforceInterface(DESCRIPTOR);
            DownloadInfo r21 = getDownloadInfo();
            r6.writeNoException();
            if (r21 == null) goto L70;
            r6.writeInt(1);
            r21.writeToParcel(r6, 1);
        L71:
            return true;
        L70:
            r6.writeInt(0);
            goto L71
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L72:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    IDownloadAidlDepend getDepend() throws RemoteException;

    IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException;

    IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int r1) throws RemoteException;

    int getDownloadCompleteHandlerSize() throws RemoteException;

    DownloadInfo getDownloadInfo() throws RemoteException;

    IDownloadAidlListener getDownloadListenerByHashCode(int r1, int r2) throws RemoteException;

    int[] getDownloadListenerHashCodeLists(int r1) throws RemoteException;

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException;

    IDownloadAidlFileProvider getFileProvider() throws RemoteException;

    IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException;

    IDownloadAidlInterceptor getInterceptor() throws RemoteException;

    IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException;

    INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException;

    IDownloadAidlListener getSingleDownloadListener(int r1) throws RemoteException;
}
