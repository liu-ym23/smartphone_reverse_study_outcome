package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowFrontierIDL$Stub$Proxy implements IFlowFrontierIDL {
    public static IFlowFrontierIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowFrontierIDL";
    }

    public int getState() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowFrontierIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        int r2 = r1.readInt();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowFrontierIDL.Stub.getDefaultImpl() == null) goto L10;
        int r3 = IFlowFrontierIDL.Stub.getDefaultImpl().getState();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IFlowFrontierIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void registerDataListener(int r6, IFlowFrontierDataListenerIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowFrontierIDL");     // Catch: Throwable -> L16
        r0.writeInt(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowFrontierIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowFrontierIDL.Stub.getDefaultImpl().registerDataListener(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void registerStateListener(int r6, IFlowFrontierStateListenerIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowFrontierIDL");     // Catch: Throwable -> L16
        r0.writeInt(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowFrontierIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowFrontierIDL.Stub.getDefaultImpl().registerStateListener(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void unregisterDataListener(int r6, IFlowFrontierDataListenerIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowFrontierIDL");     // Catch: Throwable -> L16
        r0.writeInt(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowFrontierIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowFrontierIDL.Stub.getDefaultImpl().unregisterDataListener(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void unregisterStateListener(int r6, IFlowFrontierStateListenerIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowFrontierIDL");     // Catch: Throwable -> L16
        r0.writeInt(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowFrontierIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowFrontierIDL.Stub.getDefaultImpl().unregisterStateListener(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void cacheScreenshot(int r6, Bitmap r7, Map r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowFrontierIDL");     // Catch: Throwable -> L17
        r0.writeInt(r6);     // Catch: Throwable -> L17
        if (r7 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L17
        r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
    L7:
        r0.writeMap(r8);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L10:
        if (IFlowFrontierIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowFrontierIDL.Stub.getDefaultImpl().cacheScreenshot(r6, r7, r8);     // Catch: Throwable -> L17
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

    public void sendData(int r6, byte[] r7, Map r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowFrontierIDL");     // Catch: Throwable -> L12
        r0.writeInt(r6);     // Catch: Throwable -> L12
        r0.writeByteArray(r7);     // Catch: Throwable -> L12
        r0.writeMap(r8);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowFrontierIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowFrontierIDL.Stub.getDefaultImpl().sendData(r6, r7, r8);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void cacheScreenshotFd(int r6, String r7, ParcelFileDescriptor r8, Map r9) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowFrontierIDL");     // Catch: Throwable -> L16
        r0.writeInt(r6);     // Catch: Throwable -> L16
        r0.writeString(r7);     // Catch: Throwable -> L16
        if (r8 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L16
        r8.writeToParcel(r0, 0);     // Catch: Throwable -> L16
    L7:
        r0.writeMap(r9);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowFrontierIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowFrontierIDL.Stub.getDefaultImpl().cacheScreenshotFd(r6, r7, r8, r9);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
