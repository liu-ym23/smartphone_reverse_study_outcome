package com.obric.aikernel.model_preset.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface PresetDecryptIPCUtil extends IInterface {

    public static class Default implements PresetDecryptIPCUtil {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aikernel.model_preset.impl.PresetDecryptIPCUtil
        public void decryptPresetModel(List<String> r10) {
        }

        @Override // com.obric.aikernel.model_preset.impl.PresetDecryptIPCUtil
        public void decryptPresetModelWithCallback(List<String> r10, ICallback r11) {
        }
    }

    public static abstract class Stub extends Binder implements PresetDecryptIPCUtil {
        private static final String DESCRIPTOR = "com.obric.aikernel.model_preset.impl.PresetDecryptIPCUtil";
        static final int TRANSACTION_decryptPresetModel = 1;
        static final int TRANSACTION_decryptPresetModelWithCallback = 2;

        private static class Proxy implements PresetDecryptIPCUtil {
            public static PresetDecryptIPCUtil sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.aikernel.model_preset.impl.PresetDecryptIPCUtil
            public void decryptPresetModel(List<String> r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r11.writeStringList(r10);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().decryptPresetModel(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.aikernel.model_preset.impl.PresetDecryptIPCUtil
            public void decryptPresetModelWithCallback(List<String> r10, ICallback r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r12.writeStringList(r10);     // Catch: Throwable -> L17
                if (r11 == null) goto L6;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L17
            L7:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().decryptPresetModelWithCallback(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L6:
                r14 = null;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static PresetDecryptIPCUtil asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof PresetDecryptIPCUtil) == false) goto L12;
            return (PresetDecryptIPCUtil) r11;
        L12:
            return new Proxy(r10);
        }

        public static PresetDecryptIPCUtil getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(PresetDecryptIPCUtil r10) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r10 == null) goto L7;
            Proxy.sDefaultImpl = r10;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface(DESCRIPTOR);
            decryptPresetModel(r11.createStringArrayList());
        L13:
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface(DESCRIPTOR);
            decryptPresetModelWithCallback(r11.createStringArrayList(), ICallback.Stub.asInterface(r11.readStrongBinder()));
            goto L13
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void decryptPresetModel(List<String> r10);

    void decryptPresetModelWithCallback(List<String> r10, ICallback r11);
}
