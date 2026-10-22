package com.bun.lib;

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

        @Override // com.bun.lib.MsaIdInterface
        public final String b() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements MsaIdInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f3680a = 0;

        public static class Proxy implements MsaIdInterface {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }

            @Override // com.bun.lib.MsaIdInterface
            public final String b() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.bun.lib.MsaIdInterface");     // Catch: Throwable -> L5
                throw null;     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.bun.lib.MsaIdInterface");
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
            boolean r13 = f2();
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            return true;
        L11:
            r10.enforceInterface("com.bun.lib.MsaIdInterface");
            String r14 = i();
            r11.writeNoException();
            r11.writeString(r14);
            return true;
        L13:
            r10.enforceInterface("com.bun.lib.MsaIdInterface");
            String r15 = b();
            r11.writeNoException();
            r11.writeString(r15);
            return true;
        L15:
            r10.enforceInterface("com.bun.lib.MsaIdInterface");
            boolean r16 = c();
            r11.writeNoException();
            r11.writeInt(r16 ? 1 : 0);
            return true;
        L17:
            r10.enforceInterface("com.bun.lib.MsaIdInterface");
            String r17 = a();
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

    String a();

    String b();

    boolean c();

    boolean f2();

    void h();

    String i();
}
