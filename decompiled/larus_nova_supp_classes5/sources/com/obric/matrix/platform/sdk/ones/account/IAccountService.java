package com.obric.matrix.platform.sdk.ones.account;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IAccountService extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.account.IAccountService";

    public static abstract class Stub extends Binder implements IAccountService {
        static final int TRANSACTION_checkPassword = 12;
        static final int TRANSACTION_forceUpdateAccount = 3;
        static final int TRANSACTION_login = 1;
        static final int TRANSACTION_loginWithPassword = 8;
        static final int TRANSACTION_logout = 2;
        static final int TRANSACTION_quickLogin = 5;
        static final int TRANSACTION_resetPassword = 14;
        static final int TRANSACTION_sendCode = 4;
        static final int TRANSACTION_setInitPassword = 11;
        static final int TRANSACTION_ticketResetPassword = 10;
        static final int TRANSACTION_updatePassword = 13;
        static final int TRANSACTION_updateUserInfo = 6;
        static final int TRANSACTION_uploadAvatar = 7;
        static final int TRANSACTION_verifyPassword = 15;
        static final int TRANSACTION_verifyPasswordWithoutLogin = 16;
        static final int TRANSACTION_verifySmsCode = 9;

        public static class Proxy implements IAccountService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IAccountService.DESCRIPTOR;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void forceUpdateAccount() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void login(PendingIntent r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void logout(IAccountActionCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void checkPassword(String r4, IAccountActionCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void setInitPassword(String r4, IAccountActionCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void uploadAvatar(String r4, IAccountActionCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void loginWithPassword(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void quickLogin(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void sendCode(String r4, int r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void ticketResetPassword(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updatePassword(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updateUserInfo(Bundle r5, String r6, IAccountActionCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                r0.writeString(r6);     // Catch: Throwable -> L10
                r0.writeStrongInterface(r7);     // Catch: Throwable -> L10
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPassword(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPasswordWithoutLogin(String r4, String r5, IAccountActionCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void resetPassword(String r4, String r5, String r6, IAccountActionCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r7);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifySmsCode(String r4, String r5, int r6, IAccountActionCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r7);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IAccountService.DESCRIPTOR);
        }

        public static IAccountService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IAccountService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAccountService) == false) goto L12;
            return (IAccountService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IAccountService.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IAccountService.DESCRIPTOR);
            return true;
        L11:
            Object r0 = null;
            switch(r4) {
                case 1: goto L33;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L25;
                case 7: goto L24;
                case 8: goto L23;
                case 9: goto L22;
                case 10: goto L21;
                case 11: goto L20;
                case 12: goto L19;
                case 13: goto L18;
                case 14: goto L17;
                case 15: goto L16;
                case 16: goto L15;
                default: goto L14;
            };
        L15:
            verifyPasswordWithoutLogin(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
        L37:
            return true;
        L16:
            verifyPassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L17:
            resetPassword(r5.readString(), r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L18:
            updatePassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L19:
            checkPassword(r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L20:
            setInitPassword(r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L21:
            ticketResetPassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L22:
            verifySmsCode(r5.readString(), r5.readString(), r5.readInt(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L23:
            loginWithPassword(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L24:
            uploadAvatar(r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L25:
            Parcelable.Creator r8 = Bundle.CREATOR;
            if (r5.readInt() == 0) goto L28;
            r0 = r8.createFromParcel(r5);
        L28:
            updateUserInfo((Bundle) r0, r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L29:
            quickLogin(r5.readString(), r5.readString(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L30:
            sendCode(r5.readString(), r5.readInt(), IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L31:
            forceUpdateAccount();
            r6.writeNoException();
            goto L37
        L32:
            logout(IAccountActionCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L37
        L33:
            Parcelable.Creator r9 = PendingIntent.CREATOR;
            if (r5.readInt() == 0) goto L36;
            r0 = r9.createFromParcel(r5);
        L36:
            login((PendingIntent) r0);
            r6.writeNoException();
            goto L37
        L14:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void checkPassword(String r1, IAccountActionCallback r2) throws RemoteException;

    void forceUpdateAccount() throws RemoteException;

    void login(PendingIntent r1) throws RemoteException;

    void loginWithPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void logout(IAccountActionCallback r1) throws RemoteException;

    void quickLogin(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void resetPassword(String r1, String r2, String r3, IAccountActionCallback r4) throws RemoteException;

    void sendCode(String r1, int r2, IAccountActionCallback r3) throws RemoteException;

    void setInitPassword(String r1, IAccountActionCallback r2) throws RemoteException;

    void ticketResetPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void updatePassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void updateUserInfo(Bundle r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void uploadAvatar(String r1, IAccountActionCallback r2) throws RemoteException;

    void verifyPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void verifyPasswordWithoutLogin(String r1, String r2, IAccountActionCallback r3) throws RemoteException;

    void verifySmsCode(String r1, String r2, int r3, IAccountActionCallback r4) throws RemoteException;
}
