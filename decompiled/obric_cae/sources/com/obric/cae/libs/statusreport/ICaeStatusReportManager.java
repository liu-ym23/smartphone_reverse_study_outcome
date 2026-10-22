package com.obric.cae.libs.statusreport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeStatusReportManager extends IInterface {

    public static class Default implements ICaeStatusReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public String getCaeVersion() {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public LinkLayerQuality getLinkLayerQuality(String r8) {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public boolean registerLinkLayerQualityChangedListener(String r8, ILinkLayerQualityListener r10) {
            return false;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public boolean unregisterLinkLayerQualityChangedListener(String r8, ILinkLayerQualityListener r10) {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeStatusReportManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.statusreport.ICaeStatusReportManager";
        static final int TRANSACTION_getCaeVersion = 4;
        static final int TRANSACTION_getLinkLayerQuality = 3;
        static final int TRANSACTION_registerLinkLayerQualityChangedListener = 1;
        static final int TRANSACTION_unregisterLinkLayerQualityChangedListener = 2;

        public static class Proxy implements ICaeStatusReportManager {
            public static ICaeStatusReportManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public String getCaeVersion() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                String r11 = r10.readString();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getCaeVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public LinkLayerQuality getLinkLayerQuality(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r10.writeString(r8);     // Catch: Throwable -> L15
                if (this.mRemote.transact(3, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L14;
                LinkLayerQuality r12 = LinkLayerQuality.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L15
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L14:
                r12 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r12 = Stub.getDefaultImpl().getLinkLayerQuality(r8);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public boolean registerLinkLayerQualityChangedListener(String r8, ILinkLayerQualityListener r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r11.writeString(r8);     // Catch: Throwable -> L19
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L19
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L19
                boolean r14 = false;
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L19
                if (r12.readInt() == 0) goto L17;
                r14 = true;
            L17:
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r15 = Stub.getDefaultImpl().registerLinkLayerQualityChangedListener(r8, r10);     // Catch: Throwable -> L19
                r12.recycle();
                r11.recycle();
                return r15;
            L6:
                r13 = null;
            L19:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public boolean unregisterLinkLayerQualityChangedListener(String r8, ILinkLayerQualityListener r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r11.writeString(r8);     // Catch: Throwable -> L19
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L19
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L19
                boolean r14 = false;
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L19
                if (r12.readInt() == 0) goto L17;
                r14 = true;
            L17:
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r15 = Stub.getDefaultImpl().unregisterLinkLayerQualityChangedListener(r8, r10);     // Catch: Throwable -> L19
                r12.recycle();
                r11.recycle();
                return r15;
            L6:
                r13 = null;
            L19:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeStatusReportManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeStatusReportManager) == false) goto L12;
            return (ICaeStatusReportManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeStatusReportManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeStatusReportManager r8) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r8 == null) goto L7;
            Proxy.sDefaultImpl = r8;
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
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 == 1598968902) goto L24;
            if (r8 != 1) goto L6;
            r10.enforceInterface(DESCRIPTOR);
            boolean r13 = registerLinkLayerQualityChangedListener(r10.readString(), ILinkLayerQualityListener.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            return true;
        L6:
            if (r8 != 2) goto L8;
            r10.enforceInterface(DESCRIPTOR);
            boolean r14 = unregisterLinkLayerQualityChangedListener(r10.readString(), ILinkLayerQualityListener.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            return true;
        L8:
            if (r8 != 3) goto L10;
            r10.enforceInterface(DESCRIPTOR);
            LinkLayerQuality r15 = getLinkLayerQuality(r10.readString());
            r11.writeNoException();
            if (r15 == null) goto L18;
            r11.writeInt(1);
            r15.writeToParcel(r11, 1);
        L19:
            return true;
        L18:
            r11.writeInt(0);
            goto L19
        L10:
            if (r8 != 4) goto L12;
            r10.enforceInterface(DESCRIPTOR);
            String r16 = getCaeVersion();
            r11.writeNoException();
            r11.writeString(r16);
            return true;
        L12:
            return super.onTransact(r8, r10, r11, r12);
        L24:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCaeVersion();

    LinkLayerQuality getLinkLayerQuality(String r8);

    boolean registerLinkLayerQualityChangedListener(String r8, ILinkLayerQualityListener r10);

    boolean unregisterLinkLayerQualityChangedListener(String r8, ILinkLayerQualityListener r10);
}
