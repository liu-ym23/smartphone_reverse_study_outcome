package com.cae.caed;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ISmartNetworkService extends IInterface {

    public static class Default implements ISmartNetworkService {
        public Default() {
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int C1(byte r8, int r10, boolean r11) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int F0(int r8) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int H0(byte r8, int r10, boolean r11) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int N1(int r8, int r10, int r11) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int U(int r8) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int V(byte r8, int r10) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int V1(byte r8, int r10, boolean r11) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int a1(byte r8, String r10) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int a2(byte r8, int r10, boolean r11) {
            return 0;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int g2(SocketTupleParcel r8) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int i2(int r8, int r10, boolean r11) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int l2(byte r8, int r10, boolean r11) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int n1(SocketFilterParcel r8) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int x0(byte r8, int r10) {
            return 0;
        }

        @Override // com.cae.caed.ISmartNetworkService
        public final int x1(byte r8) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ISmartNetworkService {

        public static class Proxy implements ISmartNetworkService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4128a;

            public Proxy(IBinder r8) {
                this.f4128a = r8;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int C1(byte r8, int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L10
                r12.writeByte(r8);     // Catch: Throwable -> L10
                r12.writeInt(r10);     // Catch: Throwable -> L10
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L10
                this.f4128a.transact(4, r12, r13, 0);     // Catch: Throwable -> L10
                r13.readException();     // Catch: Throwable -> L10
                int r15 = r13.readInt();     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return r15;
            L6:
                r14 = 0;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int F0(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.f4128a.transact(6, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.cae.caed.ISmartNetworkService
            public final int H0(byte r8, int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L10
                r12.writeByte(r8);     // Catch: Throwable -> L10
                r12.writeInt(r10);     // Catch: Throwable -> L10
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L10
                this.f4128a.transact(5, r12, r13, 0);     // Catch: Throwable -> L10
                r13.readException();     // Catch: Throwable -> L10
                int r15 = r13.readInt();     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return r15;
            L6:
                r14 = 0;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int N1(int r8, int r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.f4128a.transact(8, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                int r14 = r13.readInt();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int U(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.f4128a.transact(7, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.cae.caed.ISmartNetworkService
            public final int V(byte r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L6
                r11.writeByte(r8);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.f4128a.transact(14, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                int r13 = r12.readInt();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int V1(byte r8, int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L10
                r12.writeByte(r8);     // Catch: Throwable -> L10
                r12.writeInt(r10);     // Catch: Throwable -> L10
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L10
                this.f4128a.transact(3, r12, r13, 0);     // Catch: Throwable -> L10
                r13.readException();     // Catch: Throwable -> L10
                int r15 = r13.readInt();     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return r15;
            L6:
                r14 = 0;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int a1(byte r8, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L6
                r11.writeByte(r8);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                this.f4128a.transact(1, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                int r13 = r12.readInt();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int a2(byte r8, int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L10
                r12.writeByte(r8);     // Catch: Throwable -> L10
                r12.writeInt(r10);     // Catch: Throwable -> L10
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L10
                this.f4128a.transact(2, r12, r13, 0);     // Catch: Throwable -> L10
                r13.readException();     // Catch: Throwable -> L10
                int r15 = r13.readInt();     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return r15;
            L6:
                r14 = 0;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4128a;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int g2(SocketTupleParcel r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L6
                r10.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                this.f4128a.transact(10, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.cae.caed.ISmartNetworkService
            public final int i2(int r8, int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L10
                r12.writeInt(r8);     // Catch: Throwable -> L10
                r12.writeInt(r10);     // Catch: Throwable -> L10
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L10
                this.f4128a.transact(11, r12, r13, 0);     // Catch: Throwable -> L10
                r13.readException();     // Catch: Throwable -> L10
                int r15 = r13.readInt();     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return r15;
            L6:
                r14 = 0;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int l2(byte r8, int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L10
                r12.writeByte(r8);     // Catch: Throwable -> L10
                r12.writeInt(r10);     // Catch: Throwable -> L10
                if (r11 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L10
                this.f4128a.transact(13, r12, r13, 0);     // Catch: Throwable -> L10
                r13.readException();     // Catch: Throwable -> L10
                int r15 = r13.readInt();     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return r15;
            L6:
                r14 = 0;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int n1(SocketFilterParcel r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L6
                r10.writeTypedObject(r8, 0);     // Catch: Throwable -> L6
                this.f4128a.transact(9, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.cae.caed.ISmartNetworkService
            public final int x0(byte r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L6
                r11.writeByte(r8);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.f4128a.transact(15, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                int r13 = r12.readInt();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.cae.caed.ISmartNetworkService
            public final int x1(byte r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.ISmartNetworkService");     // Catch: Throwable -> L6
                r10.writeByte(r8);     // Catch: Throwable -> L6
                this.f4128a.transact(12, r10, r11, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, "com.cae.caed.ISmartNetworkService");
        }

        public static ISmartNetworkService H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.cae.caed.ISmartNetworkService");
            if (r10 == null) goto L12;
            if ((r10 instanceof ISmartNetworkService) == false) goto L12;
            return (ISmartNetworkService) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("com.cae.caed.ISmartNetworkService");
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.cae.caed.ISmartNetworkService");
            return true;
        L11:
            boolean r13 = false;
            switch(r8) {
                case 1: goto L47;
                case 2: goto L43;
                case 3: goto L39;
                case 4: goto L35;
                case 5: goto L31;
                case 6: goto L30;
                case 7: goto L29;
                case 8: goto L28;
                case 9: goto L27;
                case 10: goto L26;
                case 11: goto L22;
                case 12: goto L21;
                case 13: goto L17;
                case 14: goto L16;
                case 15: goto L15;
                default: goto L14;
            };
        L15:
            int r14 = x0(r10.readByte(), r10.readInt());
        L48:
            r11.writeNoException();
            r11.writeInt(r14);
            return true;
        L16:
            r14 = V(r10.readByte(), r10.readInt());
            goto L48
        L17:
            byte r15 = r10.readByte();
            int r16 = r10.readInt();
            if (r10.readInt() == 0) goto L20;
            r13 = true;
        L20:
            r14 = l2(r15, r16, r13);
            goto L48
        L21:
            r14 = x1(r10.readByte());
            goto L48
        L22:
            int r17 = r10.readInt();
            int r18 = r10.readInt();
            if (r10.readInt() == 0) goto L25;
            r13 = true;
        L25:
            r14 = i2(r17, r18, r13);
            goto L48
        L26:
            r14 = g2((SocketTupleParcel) r10.readTypedObject(SocketTupleParcel.CREATOR));
            goto L48
        L27:
            r14 = n1((SocketFilterParcel) r10.readTypedObject(SocketFilterParcel.CREATOR));
            goto L48
        L28:
            r14 = N1(r10.readInt(), r10.readInt(), r10.readInt());
            goto L48
        L29:
            r14 = U(r10.readInt());
            goto L48
        L30:
            r14 = F0(r10.readInt());
            goto L48
        L31:
            byte r19 = r10.readByte();
            int r20 = r10.readInt();
            if (r10.readInt() == 0) goto L34;
            r13 = true;
        L34:
            r14 = H0(r19, r20, r13);
            goto L48
        L35:
            byte r21 = r10.readByte();
            int r22 = r10.readInt();
            if (r10.readInt() == 0) goto L38;
            r13 = true;
        L38:
            r14 = C1(r21, r22, r13);
            goto L48
        L39:
            byte r23 = r10.readByte();
            int r24 = r10.readInt();
            if (r10.readInt() == 0) goto L42;
            r13 = true;
        L42:
            r14 = V1(r23, r24, r13);
            goto L48
        L43:
            byte r25 = r10.readByte();
            int r26 = r10.readInt();
            if (r10.readInt() == 0) goto L46;
            r13 = true;
        L46:
            r14 = a2(r25, r26, r13);
            goto L48
        L47:
            r14 = a1(r10.readByte(), r10.readString());
            goto L48
        L14:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    int C1(byte r8, int r10, boolean r11);

    int F0(int r8);

    int H0(byte r8, int r10, boolean r11);

    int N1(int r8, int r10, int r11);

    int U(int r8);

    int V(byte r8, int r10);

    int V1(byte r8, int r10, boolean r11);

    int a1(byte r8, String r10);

    int a2(byte r8, int r10, boolean r11);

    int g2(SocketTupleParcel r8);

    int i2(int r8, int r10, boolean r11);

    int l2(byte r8, int r10, boolean r11);

    int n1(SocketFilterParcel r8);

    int x0(byte r8, int r10);

    int x1(byte r8);
}
