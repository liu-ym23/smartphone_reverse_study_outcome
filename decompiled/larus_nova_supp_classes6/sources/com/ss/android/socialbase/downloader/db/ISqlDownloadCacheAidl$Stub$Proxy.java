package com.ss.android.socialbase.downloader.db;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ISqlDownloadCacheAidl$Stub$Proxy implements ISqlDownloadCacheAidl {
    public static ISqlDownloadCacheAidl sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl";
    }

    public void clearData() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        ISqlDownloadCacheAidl.Stub.getDefaultImpl().clearData();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean ensureDownloadCacheSyncSuccess() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().ensureDownloadCacheSyncSuccess();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        ArrayList r2 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        List<DownloadInfo> r3 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().getAllDownloadInfo();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isDownloadCacheSyncSuccess() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().isDownloadCacheSyncSuccess();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public ISqlDownloadCacheAidl$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public DownloadInfo OnDownloadTaskIntercept(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r7 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r7;
    L14:
        r7 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskIntercept(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r8;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public DownloadInfo OnDownloadTaskPrepare(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r7 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r7;
    L14:
        r7 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskPrepare(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r8;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public DownloadInfo OnDownloadTaskRetry(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r7 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r7;
    L14:
        r7 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskRetry(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r8;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean cacheExist(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
        r0.writeInt(r6);     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        boolean r7 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().cacheExist(r6);     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r7;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public DownloadInfo getDownloadInfo(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r7 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r7;
    L14:
        r7 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().getDownloadInfo(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r8;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public List<DownloadInfo> getDownloadInfoList(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r7;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        List<DownloadInfo> r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().getDownloadInfoList(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public List<DownloadInfo> getDownloadInfosByFileExtension(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r7;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        List<DownloadInfo> r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().getDownloadInfosByFileExtension(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
        r0.writeStringList(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r7;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        List<DownloadInfo> r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().getDownloadInfosByMonitorScene(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r7;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        List<DownloadInfo> r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().getSuccessedDownloadInfosWithMimeType(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        ArrayList r7 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r7;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        List<DownloadInfo> r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().getUnCompletedDownloadInfosWithMimeType(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void init(boolean r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        if (r6 == false) goto L6;
        int r4 = 1;
    L7:
        r0.writeInt(r4);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L10:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L14;
        ISqlDownloadCacheAidl.Stub.getDefaultImpl().init(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L6:
        r4 = 0;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public DownloadInfo onDownloadTaskStart(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r7 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r7;
    L14:
        r7 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().onDownloadTaskStart(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r8;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean removeDownloadInfo(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
        r0.writeInt(r6);     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        boolean r7 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().removeDownloadInfo(r6);     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r7;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean removeDownloadTaskData(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L15
        r0.writeInt(r6);     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        boolean r7 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().removeDownloadTaskData(r6);     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r7;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L10:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L14;
        ISqlDownloadCacheAidl.Stub.getDefaultImpl().setInitCallback(r6);     // Catch: Throwable -> L17
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

    public void syncDownloadInfo(DownloadInfo r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        if (r6 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L17
        r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
    L8:
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L10:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L14;
        ISqlDownloadCacheAidl.Stub.getDefaultImpl().syncDownloadInfo(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void syncDownloadInfoFromOtherCache(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
        r0.writeInt(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        ISqlDownloadCacheAidl.Stub.getDefaultImpl().syncDownloadInfoFromOtherCache(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean updateDownloadInfo(DownloadInfo r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L20
        boolean r2 = true;
        if (r7 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L20
        r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
    L8:
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L20
        if (r1.readInt() != 0) goto L18;
        r2 = false;
    L18:
        r1.recycle();
        r0.recycle();
        return r2;
    L10:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L14;
        boolean r8 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().updateDownloadInfo(r7);     // Catch: Throwable -> L20
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

    public DownloadInfo OnDownloadTaskCancel(int r6, long r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        r0.writeLong(r7);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r8 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r8;
    L14:
        r8 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r9 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskCancel(r6, r7);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r9;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public DownloadInfo OnDownloadTaskCompleted(int r6, long r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        r0.writeLong(r7);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r8 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r8;
    L14:
        r8 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r9 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskCompleted(r6, r7);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r9;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public DownloadInfo OnDownloadTaskError(int r6, long r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        r0.writeLong(r7);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r8 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r8;
    L14:
        r8 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r9 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskError(r6, r7);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r9;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public DownloadInfo OnDownloadTaskPause(int r6, long r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        r0.writeLong(r7);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r8 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r8;
    L14:
        r8 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r9 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskPause(r6, r7);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r9;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public DownloadInfo OnDownloadTaskProgress(int r6, long r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        r0.writeLong(r7);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r8 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r8;
    L14:
        r8 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r9 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskProgress(r6, r7);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r9;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public List<DownloadInfo> getDownloadInfosByFilters(String r6, String r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        r0.writeString(r7);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        ArrayList r8 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        List<DownloadInfo> r9 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().getDownloadInfosByFilters(r6, r7);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r9;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public DownloadInfo OnDownloadTaskConnected(int r10, long r11, String r13, String r14) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L17
        r0.writeInt(r10);     // Catch: Throwable -> L17
        r0.writeLong(r11);     // Catch: Throwable -> L17
        r0.writeString(r13);     // Catch: Throwable -> L17
        r0.writeString(r14);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        DownloadInfo r12 = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r12;
    L14:
        r12 = null;
        goto L15
    L6:
        if (ISqlDownloadCacheAidl.Stub.getDefaultImpl() == null) goto L10;
        DownloadInfo r15 = ISqlDownloadCacheAidl.Stub.getDefaultImpl().OnDownloadTaskConnected(r10, r11, r13, r14);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r15;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
}
