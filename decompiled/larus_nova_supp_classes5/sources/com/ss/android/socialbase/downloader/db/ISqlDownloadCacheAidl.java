package com.ss.android.socialbase.downloader.db;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface ISqlDownloadCacheAidl extends IInterface {

    public static abstract class Stub extends Binder implements ISqlDownloadCacheAidl {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl";
        static final int TRANSACTION_OnDownloadTaskCancel = 22;
        static final int TRANSACTION_OnDownloadTaskCompleted = 20;
        static final int TRANSACTION_OnDownloadTaskConnected = 16;
        static final int TRANSACTION_OnDownloadTaskError = 18;
        static final int TRANSACTION_OnDownloadTaskIntercept = 24;
        static final int TRANSACTION_OnDownloadTaskPause = 21;
        static final int TRANSACTION_OnDownloadTaskPrepare = 23;
        static final int TRANSACTION_OnDownloadTaskProgress = 17;
        static final int TRANSACTION_OnDownloadTaskRetry = 19;
        static final int TRANSACTION_cacheExist = 2;
        static final int TRANSACTION_clearData = 14;
        static final int TRANSACTION_ensureDownloadCacheSyncSuccess = 26;
        static final int TRANSACTION_getAllDownloadInfo = 8;
        static final int TRANSACTION_getDownloadInfo = 3;
        static final int TRANSACTION_getDownloadInfoList = 4;
        static final int TRANSACTION_getDownloadInfosByFileExtension = 7;
        static final int TRANSACTION_getDownloadInfosByFilters = 9;
        static final int TRANSACTION_getDownloadInfosByMonitorScene = 10;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 5;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 6;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 25;
        static final int TRANSACTION_onDownloadTaskStart = 15;
        static final int TRANSACTION_removeDownloadInfo = 12;
        static final int TRANSACTION_removeDownloadTaskData = 13;
        static final int TRANSACTION_setInitCallback = 29;
        static final int TRANSACTION_syncDownloadInfo = 27;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 28;
        static final int TRANSACTION_updateDownloadInfo = 11;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISqlDownloadCacheAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ISqlDownloadCacheAidl asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ISqlDownloadCacheAidl) == false) goto L12;
            return (ISqlDownloadCacheAidl) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ISqlDownloadCacheAidl r1) {
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
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) throws RemoteException {
            if (r11 == 1598968902) goto L108;
            DownloadInfo r0 = null;
            boolean r3 = false;
            switch(r11) {
                case 1: goto L103;
                case 2: goto L101;
                case 3: goto L96;
                case 4: goto L94;
                case 5: goto L92;
                case 6: goto L90;
                case 7: goto L88;
                case 8: goto L86;
                case 9: goto L84;
                case 10: goto L82;
                case 11: goto L77;
                case 12: goto L75;
                case 13: goto L73;
                case 14: goto L71;
                case 15: goto L66;
                case 16: goto L61;
                case 17: goto L56;
                case 18: goto L51;
                case 19: goto L46;
                case 20: goto L41;
                case 21: goto L36;
                case 22: goto L31;
                case 23: goto L26;
                case 24: goto L21;
                case 25: goto L19;
                case 26: goto L17;
                case 27: goto L12;
                case 28: goto L10;
                case 29: goto L8;
                default: goto L7;
            };
        L8:
            r12.enforceInterface(DESCRIPTOR);
            setInitCallback(ISqlCacheLoadCompleteCallbackAidl.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            return true;
        L10:
            r12.enforceInterface(DESCRIPTOR);
            syncDownloadInfoFromOtherCache(r12.readInt());
            r13.writeNoException();
            return true;
        L12:
            r12.enforceInterface(DESCRIPTOR);
            if (r12.readInt() == 0) goto L15;
            r0 = DownloadInfo.CREATOR.createFromParcel(r12);
        L15:
            syncDownloadInfo(r0);
            r13.writeNoException();
            return true;
        L17:
            r12.enforceInterface(DESCRIPTOR);
            boolean r15 = ensureDownloadCacheSyncSuccess();
            r13.writeNoException();
            r13.writeInt(r15 ? 1 : 0);
            return true;
        L19:
            r12.enforceInterface(DESCRIPTOR);
            boolean r16 = isDownloadCacheSyncSuccess();
            r13.writeNoException();
            r13.writeInt(r16 ? 1 : 0);
            return true;
        L21:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r17 = OnDownloadTaskIntercept(r12.readInt());
            r13.writeNoException();
            if (r17 == null) goto L24;
            r13.writeInt(1);
            r17.writeToParcel(r13, 1);
        L25:
            return true;
        L24:
            r13.writeInt(0);
            goto L25
        L26:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r18 = OnDownloadTaskPrepare(r12.readInt());
            r13.writeNoException();
            if (r18 == null) goto L29;
            r13.writeInt(1);
            r18.writeToParcel(r13, 1);
        L30:
            return true;
        L29:
            r13.writeInt(0);
            goto L30
        L31:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r19 = OnDownloadTaskCancel(r12.readInt(), r12.readLong());
            r13.writeNoException();
            if (r19 == null) goto L34;
            r13.writeInt(1);
            r19.writeToParcel(r13, 1);
        L35:
            return true;
        L34:
            r13.writeInt(0);
            goto L35
        L36:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r110 = OnDownloadTaskPause(r12.readInt(), r12.readLong());
            r13.writeNoException();
            if (r110 == null) goto L39;
            r13.writeInt(1);
            r110.writeToParcel(r13, 1);
        L40:
            return true;
        L39:
            r13.writeInt(0);
            goto L40
        L41:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r111 = OnDownloadTaskCompleted(r12.readInt(), r12.readLong());
            r13.writeNoException();
            if (r111 == null) goto L44;
            r13.writeInt(1);
            r111.writeToParcel(r13, 1);
        L45:
            return true;
        L44:
            r13.writeInt(0);
            goto L45
        L46:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r112 = OnDownloadTaskRetry(r12.readInt());
            r13.writeNoException();
            if (r112 == null) goto L49;
            r13.writeInt(1);
            r112.writeToParcel(r13, 1);
        L50:
            return true;
        L49:
            r13.writeInt(0);
            goto L50
        L51:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r113 = OnDownloadTaskError(r12.readInt(), r12.readLong());
            r13.writeNoException();
            if (r113 == null) goto L54;
            r13.writeInt(1);
            r113.writeToParcel(r13, 1);
        L55:
            return true;
        L54:
            r13.writeInt(0);
            goto L55
        L56:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r114 = OnDownloadTaskProgress(r12.readInt(), r12.readLong());
            r13.writeNoException();
            if (r114 == null) goto L59;
            r13.writeInt(1);
            r114.writeToParcel(r13, 1);
        L60:
            return true;
        L59:
            r13.writeInt(0);
            goto L60
        L61:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r115 = OnDownloadTaskConnected(r12.readInt(), r12.readLong(), r12.readString(), r12.readString());
            r13.writeNoException();
            if (r115 == null) goto L64;
            r13.writeInt(1);
            r115.writeToParcel(r13, 1);
        L65:
            return true;
        L64:
            r13.writeInt(0);
            goto L65
        L66:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r116 = onDownloadTaskStart(r12.readInt());
            r13.writeNoException();
            if (r116 == null) goto L69;
            r13.writeInt(1);
            r116.writeToParcel(r13, 1);
        L70:
            return true;
        L69:
            r13.writeInt(0);
            goto L70
        L71:
            r12.enforceInterface(DESCRIPTOR);
            clearData();
            r13.writeNoException();
            return true;
        L73:
            r12.enforceInterface(DESCRIPTOR);
            boolean r117 = removeDownloadTaskData(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r117 ? 1 : 0);
            return true;
        L75:
            r12.enforceInterface(DESCRIPTOR);
            boolean r118 = removeDownloadInfo(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r118 ? 1 : 0);
            return true;
        L77:
            r12.enforceInterface(DESCRIPTOR);
            if (r12.readInt() == 0) goto L80;
            r0 = DownloadInfo.CREATOR.createFromParcel(r12);
        L80:
            boolean r119 = updateDownloadInfo(r0);
            r13.writeNoException();
            r13.writeInt(r119 ? 1 : 0);
            return true;
        L82:
            r12.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r120 = getDownloadInfosByMonitorScene(r12.createStringArrayList());
            r13.writeNoException();
            r13.writeTypedList(r120);
            return true;
        L84:
            r12.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r121 = getDownloadInfosByFilters(r12.readString(), r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r121);
            return true;
        L86:
            r12.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r122 = getAllDownloadInfo();
            r13.writeNoException();
            r13.writeTypedList(r122);
            return true;
        L88:
            r12.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r123 = getDownloadInfosByFileExtension(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r123);
            return true;
        L90:
            r12.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r124 = getUnCompletedDownloadInfosWithMimeType(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r124);
            return true;
        L92:
            r12.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r125 = getSuccessedDownloadInfosWithMimeType(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r125);
            return true;
        L94:
            r12.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r126 = getDownloadInfoList(r12.readString());
            r13.writeNoException();
            r13.writeTypedList(r126);
            return true;
        L96:
            r12.enforceInterface(DESCRIPTOR);
            DownloadInfo r127 = getDownloadInfo(r12.readInt());
            r13.writeNoException();
            if (r127 == null) goto L99;
            r13.writeInt(1);
            r127.writeToParcel(r13, 1);
        L100:
            return true;
        L99:
            r13.writeInt(0);
            goto L100
        L101:
            r12.enforceInterface(DESCRIPTOR);
            boolean r128 = cacheExist(r12.readInt());
            r13.writeNoException();
            r13.writeInt(r128 ? 1 : 0);
            return true;
        L103:
            r12.enforceInterface(DESCRIPTOR);
            if (r12.readInt() == 0) goto L106;
            r3 = true;
        L106:
            init(r3);
            r13.writeNoException();
            return true;
        L7:
            return super.onTransact(r11, r12, r13, r14);
        L108:
            r13.writeString(DESCRIPTOR);
            return true;
        }
    }

    DownloadInfo OnDownloadTaskCancel(int r1, long r2) throws RemoteException;

    DownloadInfo OnDownloadTaskCompleted(int r1, long r2) throws RemoteException;

    DownloadInfo OnDownloadTaskConnected(int r1, long r2, String r4, String r5) throws RemoteException;

    DownloadInfo OnDownloadTaskError(int r1, long r2) throws RemoteException;

    DownloadInfo OnDownloadTaskIntercept(int r1) throws RemoteException;

    DownloadInfo OnDownloadTaskPause(int r1, long r2) throws RemoteException;

    DownloadInfo OnDownloadTaskPrepare(int r1) throws RemoteException;

    DownloadInfo OnDownloadTaskProgress(int r1, long r2) throws RemoteException;

    DownloadInfo OnDownloadTaskRetry(int r1) throws RemoteException;

    boolean cacheExist(int r1) throws RemoteException;

    void clearData() throws RemoteException;

    boolean ensureDownloadCacheSyncSuccess() throws RemoteException;

    List<DownloadInfo> getAllDownloadInfo() throws RemoteException;

    DownloadInfo getDownloadInfo(int r1) throws RemoteException;

    List<DownloadInfo> getDownloadInfoList(String r1) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFileExtension(String r1) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r1) throws RemoteException;

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) throws RemoteException;

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) throws RemoteException;

    void init(boolean r1) throws RemoteException;

    boolean isDownloadCacheSyncSuccess() throws RemoteException;

    DownloadInfo onDownloadTaskStart(int r1) throws RemoteException;

    boolean removeDownloadInfo(int r1) throws RemoteException;

    boolean removeDownloadTaskData(int r1) throws RemoteException;

    void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r1) throws RemoteException;

    void syncDownloadInfo(DownloadInfo r1) throws RemoteException;

    void syncDownloadInfoFromOtherCache(int r1) throws RemoteException;

    boolean updateDownloadInfo(DownloadInfo r1) throws RemoteException;
}
