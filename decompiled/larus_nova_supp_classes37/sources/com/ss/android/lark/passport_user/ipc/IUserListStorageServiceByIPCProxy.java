package com.ss.android.lark.passport_user.ipc;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.ArrayList;
import java.util.List;
import krc.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IUserListStorageServiceByIPCProxy implements IUserListStorageServiceByIPC, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.passport_user.ipc.IUserListStorageServiceByIPC";
    public static final int TRANSACTION_getForegroundUser = 2;
    public static final int TRANSACTION_getUsers = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // com.ss.android.lark.passport_user.ipc.IUserListStorageServiceByIPC
    public User getForegroundUser() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L7 RemoteException -> L9
        INVOKEINTERFACE_com_ss_android_lark_passport_user_ipc_IUserListStorageServiceByIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L7 RemoteException -> L9
        r1.readException();     // Catch: Throwable -> L7 RemoteException -> L9
        if (r1.readInt() == 0) goto L11;
        User r2 = User.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L7 RemoteException -> L9
    L12:
        r1.recycle();
        r0.recycle();
        return r2;
    L11:
        r2 = null;
    L7:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        b.b("IUserListStorageServiceByIPCProxy", "call method getForegroundUser throw RemoteException", e);     // Catch: Throwable -> L7
        goto L11
    }

    @Override // com.ss.android.lark.passport_user.ipc.IUserListStorageServiceByIPC
    public List<User> getUsers() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_passport_user_ipc_IUserListStorageServiceByIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        ArrayList r2 = r1.readArrayList(IUserListStorageServiceByIPCProxy.class.getClassLoader());     // Catch: Throwable -> L5 RemoteException -> L7
        r1.recycle();
        r0.recycle();
    L13:
        return r2;
    L5:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("IUserListStorageServiceByIPCProxy", "call method getUsers throw RemoteException", e);     // Catch: Throwable -> L5
        r1.recycle();
        r0.recycle();
        r2 = null;
        goto L13
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public IUserListStorageServiceByIPCProxy(Context r1, IBinder r2) {
        this.mRemote = r2;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_passport_user_ipc_IUserListStorageServiceByIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
