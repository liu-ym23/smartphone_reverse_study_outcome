package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface MsaIdInterface extends IInterface {

    public static class Default implements MsaIdInterface {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
        public final String b() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements MsaIdInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f3803a = 0;

        public static class Proxy implements MsaIdInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f3804a;

            public Proxy(IBinder r8) {
                this.f3804a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f3804a;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.MsaIdInterface
            public final String b() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.bun.lib.MsaIdInterface");     // Catch: Throwable -> L9
                if (this.f3804a.transact(1, r8, r10, 0) == true) goto L6;
                int r11 = Stub.f3803a;     // Catch: Throwable -> L9
            L6:
                r10.readException();     // Catch: Throwable -> L9
                String r12 = r10.readString();     // Catch: Throwable -> L9
                r10.recycle();
                r8.recycle();
                return r12;
            L9:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.bun.lib.MsaIdInterface");
        }

        public static MsaIdInterface H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (r10 == null) goto L12;
            if ((r10 instanceof MsaIdInterface) == false) goto L12;
            return (MsaIdInterface) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 == 1598968902) goto L19;
            switch(r8) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r10.enforceInterface("com.bun.lib.MsaIdInterface");
            h();
            r11.writeNoException();
            return true;
        L9:
            r10.enforceInterface("com.bun.lib.MsaIdInterface");
            boolean r13 = r0();
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            return true;
        L11:
            r10.enforceInterface("com.bun.lib.MsaIdInterface");
            boolean r14 = B();
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            return true;
        L13:
            r10.enforceInterface("com.bun.lib.MsaIdInterface");
            String r15 = e();
            r11.writeNoException();
            r11.writeString(r15);
            return true;
        L15:
            r10.enforceInterface("com.bun.lib.MsaIdInterface");
            String r16 = d();
            r11.writeNoException();
            r11.writeString(r16);
            return true;
        L17:
            r10.enforceInterface("com.bun.lib.MsaIdInterface");
            String r17 = b();
            r11.writeNoException();
            r11.writeString(r17);
            return true;
        L6:
            return super.onTransact(r8, r10, r11, r12);
        L19:
            r11.writeString("com.bun.lib.MsaIdInterface");
            return true;
        }
    }

    boolean B();

    String b();

    String d();

    String e();

    void h();

    boolean r0();
}
