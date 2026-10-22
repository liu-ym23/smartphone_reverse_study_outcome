package com.ss.android.socialbase.downloader.downloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadAidlService extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadAidlService {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService";
        static final int TRANSACTION_addDownloadListener = 26;
        static final int TRANSACTION_addDownloadListener1 = 27;
        static final int TRANSACTION_addProcessCallback = 40;
        static final int TRANSACTION_canResume = 4;
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_clearData = 38;
        static final int TRANSACTION_clearDownloadData = 23;
        static final int TRANSACTION_dispatchProcessCallback = 41;
        static final int TRANSACTION_getAllDownloadInfo = 18;
        static final int TRANSACTION_getCurBytes = 8;
        static final int TRANSACTION_getDownloadFileUriProvider = 45;
        static final int TRANSACTION_getDownloadId = 13;
        static final int TRANSACTION_getDownloadInfo = 11;
        static final int TRANSACTION_getDownloadInfoByUrlAndPath = 14;
        static final int TRANSACTION_getDownloadInfoList = 12;
        static final int TRANSACTION_getDownloadInfosByFileExtension = 17;
        static final int TRANSACTION_getDownloadInfosByFilters = 19;
        static final int TRANSACTION_getDownloadInfosByMonitorScene = 20;
        static final int TRANSACTION_getDownloadNotificationEventListener = 42;
        static final int TRANSACTION_getDownloadWithIndependentProcessStatus = 34;
        static final int TRANSACTION_getDownloadingDownloadInfosWithMimeType = 16;
        static final int TRANSACTION_getNotificationClickCallback = 43;
        static final int TRANSACTION_getStatus = 9;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 15;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 30;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 32;
        static final int TRANSACTION_isDownloadSuccessAndFileNotExist = 28;
        static final int TRANSACTION_isDownloading = 10;
        static final int TRANSACTION_isHttpServiceInit = 29;
        static final int TRANSACTION_pause = 2;
        static final int TRANSACTION_pauseAll = 7;
        static final int TRANSACTION_removeDownloadInfo = 36;
        static final int TRANSACTION_removeDownloadListener = 25;
        static final int TRANSACTION_removeDownloadTaskData = 37;
        static final int TRANSACTION_resetDownloadData = 24;
        static final int TRANSACTION_restart = 6;
        static final int TRANSACTION_restartAllFailedDownloadTasks = 21;
        static final int TRANSACTION_restartAllPauseReserveOnWifiDownloadTasks = 22;
        static final int TRANSACTION_resume = 5;
        static final int TRANSACTION_setDownloadNotificationEventListener = 44;
        static final int TRANSACTION_setDownloadWithIndependentProcessStatus = 33;
        static final int TRANSACTION_setLogLevel = 31;
        static final int TRANSACTION_setThrottleNetSpeed = 46;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 39;
        static final int TRANSACTION_tryDownload = 1;
        static final int TRANSACTION_updateDownloadInfo = 35;

        public static class Proxy implements IDownloadAidlService {
            public static IDownloadAidlService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearData() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_clearData, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearData();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r2 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r3 = Stub.getDefaultImpl().getAllDownloadInfo();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadCacheSyncSuccess() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 32, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r2 = Stub.getDefaultImpl().isDownloadCacheSyncSuccess();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r2;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isHttpServiceInit() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_isHttpServiceInit, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r2 = Stub.getDefaultImpl().isHttpServiceInit();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r2;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pauseAll() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().pauseAll();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addProcessCallback(ProcessAidlCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_addProcessCallback, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addProcessCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean canResume(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r7 = Stub.getDefaultImpl().canResume(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public long getCurBytes(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long r2 = r1.readLong();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r3 = Stub.getDefaultImpl().getCurBytes(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public IDownloadAidlFileProvider getDownloadFileUriProvider(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getDownloadFileUriProvider, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadAidlFileProvider r7 = IDownloadAidlFileProvider.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlFileProvider r8 = Stub.getDefaultImpl().getDownloadFileUriProvider(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public DownloadInfo getDownloadInfo(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                DownloadInfo r7 = DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DownloadInfo r8 = Stub.getDefaultImpl().getDownloadInfo(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfoList(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r8 = Stub.getDefaultImpl().getDownloadInfoList(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfosByFileExtension(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r8 = Stub.getDefaultImpl().getDownloadInfosByFileExtension(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringList(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r8 = Stub.getDefaultImpl().getDownloadInfosByMonitorScene(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getDownloadNotificationEventListener, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadNotificationEventAidlListener r7 = IDownloadNotificationEventAidlListener.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadNotificationEventAidlListener r8 = Stub.getDefaultImpl().getDownloadNotificationEventListener(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadWithIndependentProcessStatus(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getDownloadWithIndependentProcessStatus, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r7 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().getDownloadWithIndependentProcessStatus(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r8 = Stub.getDefaultImpl().getDownloadingDownloadInfosWithMimeType(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public INotificationClickAidlCallback getNotificationClickCallback(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getNotificationClickCallback, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                INotificationClickAidlCallback r7 = INotificationClickAidlCallback.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                INotificationClickAidlCallback r8 = Stub.getDefaultImpl().getNotificationClickCallback(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getStatus(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r7 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().getStatus(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r8 = Stub.getDefaultImpl().getSuccessedDownloadInfosWithMimeType(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getUnCompletedDownloadInfosWithMimeType, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r8 = Stub.getDefaultImpl().getUnCompletedDownloadInfosWithMimeType(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_isDownloadSuccessAndFileNotExist, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r8 = Stub.getDefaultImpl().isDownloadSuccessAndFileNotExist(r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloading(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r7 = Stub.getDefaultImpl().isDownloading(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadInfo(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_removeDownloadInfo, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r7 = Stub.getDefaultImpl().removeDownloadInfo(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadTaskData(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_removeDownloadTaskData, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r7 = Stub.getDefaultImpl().removeDownloadTaskData(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restart(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().restart(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllFailedDownloadTasks(List<String> r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringList(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_restartAllFailedDownloadTasks, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().restartAllFailedDownloadTasks(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringList(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_restartAllPauseReserveOnWifiDownloadTasks, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().restartAllPauseReserveOnWifiDownloadTasks(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resume(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().resume(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setLogLevel(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_setLogLevel, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setLogLevel(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void syncDownloadInfoFromOtherCache(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_syncDownloadInfoFromOtherCache, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().syncDownloadInfoFromOtherCache(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void tryDownload(DownloadAidlTask r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().tryDownload(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean updateDownloadInfo(DownloadInfo r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_updateDownloadInfo, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r8 = Stub.getDefaultImpl().updateDownloadInfo(r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void cancel(int r6, boolean r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r7 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cancel(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void dispatchProcessCallback(int r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_dispatchProcessCallback, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().dispatchProcessCallback(r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadId(String r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeString(r7);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r8 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r9 = Stub.getDefaultImpl().getDownloadId(r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public DownloadInfo getDownloadInfoByUrlAndPath(String r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeString(r7);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                DownloadInfo r8 = DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r8;
            L14:
                r8 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DownloadInfo r9 = Stub.getDefaultImpl().getDownloadInfoByUrlAndPath(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r9;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfosByFilters(String r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeString(r7);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r8 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r9 = Stub.getDefaultImpl().getDownloadInfosByFilters(r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pause(int r6, boolean r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r7 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().pause(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resetDownloadData(int r6, boolean r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r7 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_resetDownloadData, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().resetDownloadData(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadNotificationEventListener(int r6, IDownloadNotificationEventAidlListener r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_setDownloadNotificationEventListener, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setDownloadNotificationEventListener(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadWithIndependentProcessStatus(int r6, boolean r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r7 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_setDownloadWithIndependentProcessStatus, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setDownloadWithIndependentProcessStatus(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearDownloadData(int r6, boolean r7, boolean r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r0.writeInt(r6);     // Catch: Throwable -> L21
                int r2 = 1;
                if (r7 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L21
                if (r8 == true) goto L11;
                r2 = 0;
            L11:
                r0.writeInt(r2);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_clearDownloadData, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().clearDownloadData(r6, r7, r8);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r4 = 0;
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setThrottleNetSpeed(int r6, long r7, int r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeLong(r7);     // Catch: Throwable -> L13
                r0.writeInt(r9);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_setThrottleNetSpeed, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setThrottleNetSpeed(r6, r7, r9);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r15 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r15.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r15.transact(r16, r17, r18, r19);
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener(int r10, int r11, IDownloadAidlListener r12, int r13, boolean r14) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r0.writeInt(r10);     // Catch: Throwable -> L21
                r0.writeInt(r11);     // Catch: Throwable -> L21
                if (r12 == null) goto L6;
                IBinder r2 = r12.asBinder();     // Catch: Throwable -> L21
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L21
                r0.writeInt(r13);     // Catch: Throwable -> L21
                if (r14 == false) goto L10;
                int r3 = 1;
            L11:
                r0.writeInt(r3);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_addDownloadListener, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().addDownloadListener(r10, r11, r12, r13, r14);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r3 = 0;
                goto L11
            L6:
                r2 = null;
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void removeDownloadListener(int r10, int r11, IDownloadAidlListener r12, int r13, boolean r14) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r0.writeInt(r10);     // Catch: Throwable -> L21
                r0.writeInt(r11);     // Catch: Throwable -> L21
                if (r12 == null) goto L6;
                IBinder r2 = r12.asBinder();     // Catch: Throwable -> L21
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L21
                r0.writeInt(r13);     // Catch: Throwable -> L21
                if (r14 == false) goto L10;
                int r3 = 1;
            L11:
                r0.writeInt(r3);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_removeDownloadListener, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().removeDownloadListener(r10, r11, r12, r13, r14);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r3 = 0;
                goto L11
            L6:
                r2 = null;
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener1(int r12, int r13, IDownloadAidlListener r14, int r15, boolean r16, boolean r17) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L29
                r1.writeInt(r12);     // Catch: Throwable -> L29
                r1.writeInt(r13);     // Catch: Throwable -> L29
                if (r14 == null) goto L6;
                IBinder r3 = r14.asBinder();     // Catch: Throwable -> L29
            L7:
                r1.writeStrongBinder(r3);     // Catch: Throwable -> L29
                r1.writeInt(r15);     // Catch: Throwable -> L29
                int r4 = 1;
                if (r16 == false) goto L10;
                int r6 = 1;
            L11:
                r1.writeInt(r6);     // Catch: Throwable -> L29
                if (r17 == true) goto L15;
                r4 = 0;
            L15:
                r1.writeInt(r4);     // Catch: Throwable -> L29
            L27:
                th = th;
            L31:
                r2.recycle();
                r1.recycle();
                throw th;
            L18:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_addDownloadListener1, r1, r2, 0) == false) goto L20;
            L24:
                r2.readException();     // Catch: Throwable -> L27
                r2.recycle();
                r1.recycle();
                return;
            L20:
                if (Stub.getDefaultImpl() == null) goto L24;
                Stub.getDefaultImpl().addDownloadListener1(r12, r13, r14, r15, r16, r17);     // Catch: Throwable -> L27
                r2.recycle();
                r1.recycle();
                return;
            L10:
                r6 = 0;
                goto L11
            L6:
                r3 = null;
            L29:
                th = th;
                goto L31
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadAidlService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDownloadAidlService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IDownloadAidlService) == false) goto L12;
            return (IDownloadAidlService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IDownloadAidlService r1) {
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
        public boolean onTransact(int r13, Parcel r14, Parcel r15, int r16) throws RemoteException {
            if (r13 == 1598968902) goto L156;
            DownloadInfo r2 = null;
            IBinder r3 = null;
            IBinder r4 = null;
            IBinder r5 = null;
            DownloadInfo r6 = null;
            boolean r7 = false;
            switch(r13) {
                case 1: goto L154;
                case 2: goto L149;
                case 3: goto L144;
                case 4: goto L142;
                case 5: goto L140;
                case 6: goto L138;
                case 7: goto L136;
                case 8: goto L134;
                case 9: goto L132;
                case 10: goto L130;
                case 11: goto L125;
                case 12: goto L123;
                case 13: goto L121;
                case 14: goto L116;
                case 15: goto L114;
                case 16: goto L112;
                case 17: goto L110;
                case 18: goto L108;
                case 19: goto L106;
                case 20: goto L104;
                case 21: goto L102;
                case 22: goto L100;
                case 23: goto L91;
                case 24: goto L86;
                case 25: goto L80;
                case 26: goto L74;
                case 27: goto L64;
                case 28: goto L59;
                case 29: goto L57;
                case 30: goto L55;
                case 31: goto L53;
                case 32: goto L51;
                case 33: goto L46;
                case 34: goto L44;
                case 35: goto L39;
                case 36: goto L37;
                case 37: goto L35;
                case 38: goto L33;
                case 39: goto L31;
                case 40: goto L29;
                case 41: goto L27;
                case 42: goto L22;
                case 43: goto L17;
                case 44: goto L15;
                case 45: goto L10;
                case 46: goto L8;
                default: goto L7;
            };
        L8:
            r14.enforceInterface(DESCRIPTOR);
            setThrottleNetSpeed(r14.readInt(), r14.readLong(), r14.readInt());
            r15.writeNoException();
            return true;
        L10:
            r14.enforceInterface(DESCRIPTOR);
            IDownloadAidlFileProvider r0 = getDownloadFileUriProvider(r14.readInt());
            r15.writeNoException();
            if (r0 == null) goto L13;
            r3 = r0.asBinder();
        L13:
            r15.writeStrongBinder(r3);
            return true;
        L15:
            r14.enforceInterface(DESCRIPTOR);
            setDownloadNotificationEventListener(r14.readInt(), IDownloadNotificationEventAidlListener.Stub.asInterface(r14.readStrongBinder()));
            r15.writeNoException();
            return true;
        L17:
            r14.enforceInterface(DESCRIPTOR);
            INotificationClickAidlCallback r1 = getNotificationClickCallback(r14.readInt());
            r15.writeNoException();
            if (r1 == null) goto L20;
            r4 = r1.asBinder();
        L20:
            r15.writeStrongBinder(r4);
            return true;
        L22:
            r14.enforceInterface(DESCRIPTOR);
            IDownloadNotificationEventAidlListener r8 = getDownloadNotificationEventListener(r14.readInt());
            r15.writeNoException();
            if (r8 == null) goto L25;
            r5 = r8.asBinder();
        L25:
            r15.writeStrongBinder(r5);
            return true;
        L27:
            r14.enforceInterface(DESCRIPTOR);
            dispatchProcessCallback(r14.readInt(), r14.readInt());
            r15.writeNoException();
            return true;
        L29:
            r14.enforceInterface(DESCRIPTOR);
            addProcessCallback(ProcessAidlCallback.Stub.asInterface(r14.readStrongBinder()));
            r15.writeNoException();
            return true;
        L31:
            r14.enforceInterface(DESCRIPTOR);
            syncDownloadInfoFromOtherCache(r14.readInt());
            r15.writeNoException();
            return true;
        L33:
            r14.enforceInterface(DESCRIPTOR);
            clearData();
            r15.writeNoException();
            return true;
        L35:
            r14.enforceInterface(DESCRIPTOR);
            boolean r9 = removeDownloadTaskData(r14.readInt());
            r15.writeNoException();
            r15.writeInt(r9 ? 1 : 0);
            return true;
        L37:
            r14.enforceInterface(DESCRIPTOR);
            boolean r10 = removeDownloadInfo(r14.readInt());
            r15.writeNoException();
            r15.writeInt(r10 ? 1 : 0);
            return true;
        L39:
            r14.enforceInterface(DESCRIPTOR);
            if (r14.readInt() == 0) goto L42;
            r6 = DownloadInfo.CREATOR.createFromParcel(r14);
        L42:
            boolean r11 = updateDownloadInfo(r6);
            r15.writeNoException();
            r15.writeInt(r11 ? 1 : 0);
            return true;
        L44:
            r14.enforceInterface(DESCRIPTOR);
            int r12 = getDownloadWithIndependentProcessStatus(r14.readInt());
            r15.writeNoException();
            r15.writeInt(r12);
            return true;
        L46:
            r14.enforceInterface(DESCRIPTOR);
            int r17 = r14.readInt();
            if (r14.readInt() == 0) goto L49;
            r7 = true;
        L49:
            setDownloadWithIndependentProcessStatus(r17, r7);
            r15.writeNoException();
            return true;
        L51:
            r14.enforceInterface(DESCRIPTOR);
            boolean r18 = isDownloadCacheSyncSuccess();
            r15.writeNoException();
            r15.writeInt(r18 ? 1 : 0);
            return true;
        L53:
            r14.enforceInterface(DESCRIPTOR);
            setLogLevel(r14.readInt());
            r15.writeNoException();
            return true;
        L55:
            r14.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r19 = getUnCompletedDownloadInfosWithMimeType(r14.readString());
            r15.writeNoException();
            r15.writeTypedList(r19);
            return true;
        L57:
            r14.enforceInterface(DESCRIPTOR);
            boolean r20 = isHttpServiceInit();
            r15.writeNoException();
            r15.writeInt(r20 ? 1 : 0);
            return true;
        L59:
            r14.enforceInterface(DESCRIPTOR);
            if (r14.readInt() == 0) goto L62;
            r2 = DownloadInfo.CREATOR.createFromParcel(r14);
        L62:
            boolean r21 = isDownloadSuccessAndFileNotExist(r2);
            r15.writeNoException();
            r15.writeInt(r21 ? 1 : 0);
            return true;
        L64:
            r14.enforceInterface(DESCRIPTOR);
            int r22 = r14.readInt();
            int r23 = r14.readInt();
            IDownloadAidlListener r24 = IDownloadAidlListener.Stub.asInterface(r14.readStrongBinder());
            int r25 = r14.readInt();
            if (r14.readInt() == 0) goto L67;
            boolean r110 = true;
        L69:
            if (r14.readInt() == 0) goto L71;
            boolean r111 = true;
        L72:
            addDownloadListener1(r22, r23, r24, r25, r110, r111);
            r15.writeNoException();
            return true;
        L71:
            r111 = false;
            goto L72
        L67:
            r110 = false;
            goto L69
        L74:
            r14.enforceInterface(DESCRIPTOR);
            int r26 = r14.readInt();
            int r27 = r14.readInt();
            IDownloadAidlListener r28 = IDownloadAidlListener.Stub.asInterface(r14.readStrongBinder());
            int r29 = r14.readInt();
            if (r14.readInt() == 0) goto L77;
            boolean r112 = true;
        L78:
            addDownloadListener(r26, r27, r28, r29, r112);
            r15.writeNoException();
            return true;
        L77:
            r112 = false;
            goto L78
        L80:
            r14.enforceInterface(DESCRIPTOR);
            int r30 = r14.readInt();
            int r31 = r14.readInt();
            IDownloadAidlListener r32 = IDownloadAidlListener.Stub.asInterface(r14.readStrongBinder());
            int r33 = r14.readInt();
            if (r14.readInt() == 0) goto L83;
            boolean r113 = true;
        L84:
            removeDownloadListener(r30, r31, r32, r33, r113);
            r15.writeNoException();
            return true;
        L83:
            r113 = false;
            goto L84
        L86:
            r14.enforceInterface(DESCRIPTOR);
            int r34 = r14.readInt();
            if (r14.readInt() == 0) goto L89;
            r7 = true;
        L89:
            resetDownloadData(r34, r7);
            r15.writeNoException();
            return true;
        L91:
            r14.enforceInterface(DESCRIPTOR);
            int r35 = r14.readInt();
            if (r14.readInt() == 0) goto L94;
            boolean r36 = true;
        L96:
            if (r14.readInt() == 0) goto L98;
            r7 = true;
        L98:
            clearDownloadData(r35, r36, r7);
            r15.writeNoException();
            return true;
        L94:
            r36 = false;
            goto L96
        L100:
            r14.enforceInterface(DESCRIPTOR);
            restartAllPauseReserveOnWifiDownloadTasks(r14.createStringArrayList());
            r15.writeNoException();
            return true;
        L102:
            r14.enforceInterface(DESCRIPTOR);
            restartAllFailedDownloadTasks(r14.createStringArrayList());
            r15.writeNoException();
            return true;
        L104:
            r14.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r37 = getDownloadInfosByMonitorScene(r14.createStringArrayList());
            r15.writeNoException();
            r15.writeTypedList(r37);
            return true;
        L106:
            r14.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r38 = getDownloadInfosByFilters(r14.readString(), r14.readString());
            r15.writeNoException();
            r15.writeTypedList(r38);
            return true;
        L108:
            r14.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r39 = getAllDownloadInfo();
            r15.writeNoException();
            r15.writeTypedList(r39);
            return true;
        L110:
            r14.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r40 = getDownloadInfosByFileExtension(r14.readString());
            r15.writeNoException();
            r15.writeTypedList(r40);
            return true;
        L112:
            r14.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r41 = getDownloadingDownloadInfosWithMimeType(r14.readString());
            r15.writeNoException();
            r15.writeTypedList(r41);
            return true;
        L114:
            r14.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r42 = getSuccessedDownloadInfosWithMimeType(r14.readString());
            r15.writeNoException();
            r15.writeTypedList(r42);
            return true;
        L116:
            r14.enforceInterface(DESCRIPTOR);
            DownloadInfo r43 = getDownloadInfoByUrlAndPath(r14.readString(), r14.readString());
            r15.writeNoException();
            if (r43 == null) goto L119;
            r15.writeInt(1);
            r43.writeToParcel(r15, 1);
        L120:
            return true;
        L119:
            r15.writeInt(0);
            goto L120
        L121:
            r14.enforceInterface(DESCRIPTOR);
            int r44 = getDownloadId(r14.readString(), r14.readString());
            r15.writeNoException();
            r15.writeInt(r44);
            return true;
        L123:
            r14.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r45 = getDownloadInfoList(r14.readString());
            r15.writeNoException();
            r15.writeTypedList(r45);
            return true;
        L125:
            r14.enforceInterface(DESCRIPTOR);
            DownloadInfo r46 = getDownloadInfo(r14.readInt());
            r15.writeNoException();
            if (r46 == null) goto L128;
            r15.writeInt(1);
            r46.writeToParcel(r15, 1);
        L129:
            return true;
        L128:
            r15.writeInt(0);
            goto L129
        L130:
            r14.enforceInterface(DESCRIPTOR);
            boolean r47 = isDownloading(r14.readInt());
            r15.writeNoException();
            r15.writeInt(r47 ? 1 : 0);
            return true;
        L132:
            r14.enforceInterface(DESCRIPTOR);
            int r48 = getStatus(r14.readInt());
            r15.writeNoException();
            r15.writeInt(r48);
            return true;
        L134:
            r14.enforceInterface(DESCRIPTOR);
            long r49 = getCurBytes(r14.readInt());
            r15.writeNoException();
            r15.writeLong(r49);
            return true;
        L136:
            r14.enforceInterface(DESCRIPTOR);
            pauseAll();
            r15.writeNoException();
            return true;
        L138:
            r14.enforceInterface(DESCRIPTOR);
            restart(r14.readInt());
            r15.writeNoException();
            return true;
        L140:
            r14.enforceInterface(DESCRIPTOR);
            resume(r14.readInt());
            r15.writeNoException();
            return true;
        L142:
            r14.enforceInterface(DESCRIPTOR);
            boolean r50 = canResume(r14.readInt());
            r15.writeNoException();
            r15.writeInt(r50 ? 1 : 0);
            return true;
        L144:
            r14.enforceInterface(DESCRIPTOR);
            int r51 = r14.readInt();
            if (r14.readInt() == 0) goto L147;
            r7 = true;
        L147:
            cancel(r51, r7);
            r15.writeNoException();
            return true;
        L149:
            r14.enforceInterface(DESCRIPTOR);
            int r52 = r14.readInt();
            if (r14.readInt() == 0) goto L152;
            r7 = true;
        L152:
            pause(r52, r7);
            r15.writeNoException();
            return true;
        L154:
            r14.enforceInterface(DESCRIPTOR);
            tryDownload(DownloadAidlTask.Stub.asInterface(r14.readStrongBinder()));
            r15.writeNoException();
            return true;
        L7:
            return super.onTransact(r13, r14, r15, r16);
        L156:
            r15.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addDownloadListener(int r1, int r2, IDownloadAidlListener r3, int r4, boolean r5) throws RemoteException;

    void addDownloadListener1(int r1, int r2, IDownloadAidlListener r3, int r4, boolean r5, boolean r6) throws RemoteException;

    void addProcessCallback(ProcessAidlCallback r1) throws RemoteException;

    boolean canResume(int r1) throws RemoteException;

    void cancel(int r1, boolean r2) throws RemoteException;

    void clearData() throws RemoteException;

    void clearDownloadData(int r1, boolean r2, boolean r3) throws RemoteException;

    void dispatchProcessCallback(int r1, int r2) throws RemoteException;

    List<DownloadInfo> getAllDownloadInfo() throws RemoteException;

    long getCurBytes(int r1) throws RemoteException;

    IDownloadAidlFileProvider getDownloadFileUriProvider(int r1) throws RemoteException;

    int getDownloadId(String r1, String r2) throws RemoteException;

    DownloadInfo getDownloadInfo(int r1) throws RemoteException;

    DownloadInfo getDownloadInfoByUrlAndPath(String r1, String r2) throws RemoteException;

    List<DownloadInfo> getDownloadInfoList(String r1) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFileExtension(String r1) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r1) throws RemoteException;

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int r1) throws RemoteException;

    int getDownloadWithIndependentProcessStatus(int r1) throws RemoteException;

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1) throws RemoteException;

    INotificationClickAidlCallback getNotificationClickCallback(int r1) throws RemoteException;

    int getStatus(int r1) throws RemoteException;

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) throws RemoteException;

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) throws RemoteException;

    boolean isDownloadCacheSyncSuccess() throws RemoteException;

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1) throws RemoteException;

    boolean isDownloading(int r1) throws RemoteException;

    boolean isHttpServiceInit() throws RemoteException;

    void pause(int r1, boolean r2) throws RemoteException;

    void pauseAll() throws RemoteException;

    boolean removeDownloadInfo(int r1) throws RemoteException;

    void removeDownloadListener(int r1, int r2, IDownloadAidlListener r3, int r4, boolean r5) throws RemoteException;

    boolean removeDownloadTaskData(int r1) throws RemoteException;

    void resetDownloadData(int r1, boolean r2) throws RemoteException;

    void restart(int r1) throws RemoteException;

    void restartAllFailedDownloadTasks(List<String> r1) throws RemoteException;

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> r1) throws RemoteException;

    void resume(int r1) throws RemoteException;

    void setDownloadNotificationEventListener(int r1, IDownloadNotificationEventAidlListener r2) throws RemoteException;

    void setDownloadWithIndependentProcessStatus(int r1, boolean r2) throws RemoteException;

    void setLogLevel(int r1) throws RemoteException;

    void setThrottleNetSpeed(int r1, long r2, int r4) throws RemoteException;

    void syncDownloadInfoFromOtherCache(int r1) throws RemoteException;

    void tryDownload(DownloadAidlTask r1) throws RemoteException;

    boolean updateDownloadInfo(DownloadInfo r1) throws RemoteException;
}
