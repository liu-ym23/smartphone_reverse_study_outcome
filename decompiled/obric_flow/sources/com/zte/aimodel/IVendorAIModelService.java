package com.zte.aimodel;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.activity.e;

/* JADX INFO: loaded from: classes3.dex */
public interface IVendorAIModelService extends IInterface {
    public static final String DESCRIPTOR = "com.zte.aimodel.IVendorAIModelService";

    public static class Default implements IVendorAIModelService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zte.aimodel.IVendorAIModelService
        public String getSecuritySerialNo() throws RemoteException {
            return null;
        }

        @Override // com.zte.aimodel.IVendorAIModelService
        public String performByteInference(String r5, byte[] r10, IResponseCallback r11, String r12, boolean r13) throws RemoteException {
            return null;
        }

        @Override // com.zte.aimodel.IVendorAIModelService
        public String performStringInference(String r5, String r10, IResponseCallback r11, String r12, boolean r13) throws RemoteException {
            return null;
        }

        @Override // com.zte.aimodel.IVendorAIModelService
        public int queryRemainToken(String r5) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IVendorAIModelService {
        static final int TRANSACTION_getSecuritySerialNo = 4;
        static final int TRANSACTION_performByteInference = 2;
        static final int TRANSACTION_performStringInference = 1;
        static final int TRANSACTION_queryRemainToken = 3;

        public static class Proxy implements IVendorAIModelService {
            private IBinder mRemote;

            public Proxy(IBinder r5) {
                this.mRemote = r5;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVendorAIModelService.DESCRIPTOR;
            }

            @Override // com.zte.aimodel.IVendorAIModelService
            public String getSecuritySerialNo() throws RemoteException {
                Parcel r5 = e.g(asBinder());
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken(IVendorAIModelService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r5, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                String r11 = r10.readString();     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.zte.aimodel.IVendorAIModelService
            public String performByteInference(String r5, byte[] r10, IResponseCallback r11, String r12, boolean r13) throws RemoteException {
                Parcel r14 = e.g(asBinder());
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken(IVendorAIModelService.DESCRIPTOR);     // Catch: Throwable -> L6
                r14.writeString(r5);     // Catch: Throwable -> L6
                r14.writeByteArray(r10);     // Catch: Throwable -> L6
                r14.writeStrongInterface(r11);     // Catch: Throwable -> L6
                r14.writeString(r12);     // Catch: Throwable -> L6
                r14.writeBoolean(r13);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r14, r15, 0);     // Catch: Throwable -> L6
                r15.readException();     // Catch: Throwable -> L6
                String r16 = r15.readString();     // Catch: Throwable -> L6
                r15.recycle();
                r14.recycle();
                return r16;
            L6:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // com.zte.aimodel.IVendorAIModelService
            public String performStringInference(String r5, String r10, IResponseCallback r11, String r12, boolean r13) throws RemoteException {
                Parcel r14 = e.g(asBinder());
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken(IVendorAIModelService.DESCRIPTOR);     // Catch: Throwable -> L6
                r14.writeString(r5);     // Catch: Throwable -> L6
                r14.writeString(r10);     // Catch: Throwable -> L6
                r14.writeStrongInterface(r11);     // Catch: Throwable -> L6
                r14.writeString(r12);     // Catch: Throwable -> L6
                r14.writeBoolean(r13);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r14, r15, 0);     // Catch: Throwable -> L6
                r15.readException();     // Catch: Throwable -> L6
                String r16 = r15.readString();     // Catch: Throwable -> L6
                r15.recycle();
                r14.recycle();
                return r16;
            L6:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // com.zte.aimodel.IVendorAIModelService
            public int queryRemainToken(String r5) throws RemoteException {
                Parcel r10 = e.g(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(IVendorAIModelService.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                int r12 = r11.readInt();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IVendorAIModelService.DESCRIPTOR);
        }

        public static IVendorAIModelService asInterface(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface(IVendorAIModelService.DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IVendorAIModelService) == false) goto L12;
            return (IVendorAIModelService) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(IVendorAIModelService.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L23;
            if (r10 != 1) goto L11;
            String r5 = r11.readString();
            String r14 = r11.readString();
            IResponseCallback r15 = IResponseCallback.Stub.asInterface(r11.readStrongBinder());
            String r16 = r11.readString();
            boolean r17 = r11.readBoolean();
            e.q(r11);
            String r18 = performStringInference(r5, r14, r15, r16, r17);
            r12.writeNoException();
            r12.writeString(r18);
        L22:
            return true;
        L11:
            if (r10 != 2) goto L13;
            String r19 = r11.readString();
            byte[] r20 = r11.createByteArray();
            IResponseCallback r21 = IResponseCallback.Stub.asInterface(r11.readStrongBinder());
            String r22 = r11.readString();
            boolean r23 = r11.readBoolean();
            e.q(r11);
            String r24 = performByteInference(r19, r20, r21, r22, r23);
            r12.writeNoException();
            r12.writeString(r24);
            goto L22
        L13:
            if (r10 != 3) goto L15;
            String r25 = r11.readString();
            e.q(r11);
            int r26 = queryRemainToken(r25);
            r12.writeNoException();
            r12.writeInt(r26);
            goto L22
        L15:
            if (r10 != 4) goto L17;
            String r27 = getSecuritySerialNo();
            r12.writeNoException();
            r12.writeString(r27);
            goto L22
        L17:
            return super.onTransact(r10, r11, r12, r13);
        L23:
            r12.writeString(IVendorAIModelService.DESCRIPTOR);
            return true;
        }
    }

    String getSecuritySerialNo() throws RemoteException;

    String performByteInference(String r5, byte[] r10, IResponseCallback r11, String r12, boolean r13) throws RemoteException;

    String performStringInference(String r5, String r10, IResponseCallback r11, String r12, boolean r13) throws RemoteException;

    int queryRemainToken(String r5) throws RemoteException;
}
