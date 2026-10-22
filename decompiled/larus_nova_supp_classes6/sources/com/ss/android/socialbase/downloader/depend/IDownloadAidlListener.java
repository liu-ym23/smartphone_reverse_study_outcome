package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IDownloadAidlListener extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadAidlListener {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener";
        static final int TRANSACTION_getOriginHashCode = 1;
        static final int TRANSACTION_onCanceled = 8;
        static final int TRANSACTION_onFailed = 7;
        static final int TRANSACTION_onFirstStart = 9;
        static final int TRANSACTION_onFirstSuccess = 10;
        static final int TRANSACTION_onPause = 5;
        static final int TRANSACTION_onPrepare = 2;
        static final int TRANSACTION_onProgress = 4;
        static final int TRANSACTION_onRetry = 11;
        static final int TRANSACTION_onRetryDelay = 12;
        static final int TRANSACTION_onStart = 3;
        static final int TRANSACTION_onSuccessed = 6;
        static final int TRANSACTION_onWaitingDownloadCompleteHandler = 13;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadAidlListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDownloadAidlListener asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IDownloadAidlListener) == false) goto L12;
            return (IDownloadAidlListener) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IDownloadAidlListener r1) {
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
            if (r4 == 1598968902) goto L82;
            DownloadInfo r0 = null;
            switch(r4) {
                case 1: goto L80;
                case 2: goto L75;
                case 3: goto L70;
                case 4: goto L65;
                case 5: goto L60;
                case 6: goto L55;
                case 7: goto L46;
                case 8: goto L41;
                case 9: goto L36;
                case 10: goto L31;
                case 11: goto L22;
                case 12: goto L13;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L11;
            r0 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L11:
            onWaitingDownloadCompleteHandler(r0);
            r6.writeNoException();
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L16;
            DownloadInfo r8 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L18:
            if (r5.readInt() == 0) goto L20;
            r0 = (BaseException) BaseException.CREATOR.createFromParcel(r5);
        L20:
            onRetryDelay(r8, r0);
            r6.writeNoException();
            return true;
        L16:
            r8 = null;
            goto L18
        L22:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L25;
            DownloadInfo r9 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L27:
            if (r5.readInt() == 0) goto L29;
            r0 = (BaseException) BaseException.CREATOR.createFromParcel(r5);
        L29:
            onRetry(r9, r0);
            r6.writeNoException();
            return true;
        L25:
            r9 = null;
            goto L27
        L31:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L34;
            r0 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L34:
            onFirstSuccess(r0);
            r6.writeNoException();
            return true;
        L36:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L39;
            r0 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L39:
            onFirstStart(r0);
            r6.writeNoException();
            return true;
        L41:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L44;
            r0 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L44:
            onCanceled(r0);
            r6.writeNoException();
            return true;
        L46:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L49;
            DownloadInfo r10 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L51:
            if (r5.readInt() == 0) goto L53;
            r0 = (BaseException) BaseException.CREATOR.createFromParcel(r5);
        L53:
            onFailed(r10, r0);
            r6.writeNoException();
            return true;
        L49:
            r10 = null;
            goto L51
        L55:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L58;
            r0 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L58:
            onSuccessed(r0);
            r6.writeNoException();
            return true;
        L60:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L63;
            r0 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L63:
            onPause(r0);
            r6.writeNoException();
            return true;
        L65:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L68;
            r0 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L68:
            onProgress(r0);
            r6.writeNoException();
            return true;
        L70:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L73;
            r0 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L73:
            onStart(r0);
            r6.writeNoException();
            return true;
        L75:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L78;
            r0 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r5);
        L78:
            onPrepare(r0);
            r6.writeNoException();
            return true;
        L80:
            r5.enforceInterface(DESCRIPTOR);
            int r11 = getOriginHashCode();
            r6.writeNoException();
            r6.writeInt(r11);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L82:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getOriginHashCode() throws RemoteException;

    void onCanceled(DownloadInfo r1) throws RemoteException;

    void onFailed(DownloadInfo r1, BaseException r2) throws RemoteException;

    void onFirstStart(DownloadInfo r1) throws RemoteException;

    void onFirstSuccess(DownloadInfo r1) throws RemoteException;

    void onPause(DownloadInfo r1) throws RemoteException;

    void onPrepare(DownloadInfo r1) throws RemoteException;

    void onProgress(DownloadInfo r1) throws RemoteException;

    void onRetry(DownloadInfo r1, BaseException r2) throws RemoteException;

    void onRetryDelay(DownloadInfo r1, BaseException r2) throws RemoteException;

    void onStart(DownloadInfo r1) throws RemoteException;

    void onSuccessed(DownloadInfo r1) throws RemoteException;

    void onWaitingDownloadCompleteHandler(DownloadInfo r1) throws RemoteException;
}
