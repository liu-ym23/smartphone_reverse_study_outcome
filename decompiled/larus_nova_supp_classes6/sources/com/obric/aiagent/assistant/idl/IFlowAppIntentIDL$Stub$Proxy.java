package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowAppIntentIDL$Stub$Proxy implements IFlowAppIntentIDL {
    public static IFlowAppIntentIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowAppIntentIDL";
    }

    public long currentTimeMillis() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        long r2 = r1.readLong();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L10;
        long r3 = IFlowAppIntentIDL.Stub.getDefaultImpl().currentTimeMillis();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public OTaskTimeoutConfig getObricTaskTimeoutConfig() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        OTaskTimeoutConfig r2 = (OTaskTimeoutConfig) OTaskTimeoutConfig.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r2;
    L14:
        r2 = null;
        goto L15
    L6:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L10;
        OTaskTimeoutConfig r3 = IFlowAppIntentIDL.Stub.getDefaultImpl().getObricTaskTimeoutConfig();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r3;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public String getUserId() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowAppIntentIDL.Stub.getDefaultImpl().getUserId();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isDoraConnected() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowAppIntentIDL.Stub.getDefaultImpl().isDoraConnected();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isEnterpriseAccount() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowAppIntentIDL.Stub.getDefaultImpl().isEnterpriseAccount();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isLogin() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowAppIntentIDL.Stub.getDefaultImpl().isLogin();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void jumpDoraPage() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppIntentIDL.Stub.getDefaultImpl().jumpDoraPage();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IFlowAppIntentIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void getLocation(IFlowGetLocationCallbackIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppIntentIDL.Stub.getDefaultImpl().getLocation(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public boolean openMiniApp(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L15
        r0.writeString(r6);     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r7 = IFlowAppIntentIDL.Stub.getDefaultImpl().openMiniApp(r6);     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r7;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void setAppIntentActive(boolean r5) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L16
        if (r5 == false) goto L6;
        int r2 = 1;
    L7:
        r0.writeInt(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppIntentIDL.Stub.getDefaultImpl().setAppIntentActive(r5);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = 0;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void stopComplexTask(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppIntentIDL.Stub.getDefaultImpl().stopComplexTask(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public boolean syncAppletData(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L15
        r0.writeString(r6);     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r7 = IFlowAppIntentIDL.Stub.getDefaultImpl().syncAppletData(r6);     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r7;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean checkPermission(String r7, boolean r8, long r9) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppIntentIDL");     // Catch: Throwable -> L20
        r0.writeString(r7);     // Catch: Throwable -> L20
        boolean r2 = true;
        if (r8 == false) goto L6;
        int r4 = 1;
    L7:
        r0.writeInt(r4);     // Catch: Throwable -> L20
        r0.writeLong(r9);     // Catch: Throwable -> L20
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L20
        if (r1.readInt() != 0) goto L18;
        r2 = false;
    L18:
        r1.recycle();
        r0.recycle();
        return r2;
    L10:
        if (IFlowAppIntentIDL.Stub.getDefaultImpl() == null) goto L14;
        boolean r10 = IFlowAppIntentIDL.Stub.getDefaultImpl().checkPermission(r7, r8, r9);     // Catch: Throwable -> L20
        r1.recycle();
        r0.recycle();
        return r10;
    L6:
        r4 = 0;
    L20:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
