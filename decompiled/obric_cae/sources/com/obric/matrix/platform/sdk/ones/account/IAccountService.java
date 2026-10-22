package com.obric.matrix.platform.sdk.ones.account;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IAccountService extends IInterface {

    public static class Default implements IAccountService {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAccountService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f6094a = 0;

        public static class Proxy implements IAccountService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f6095a;

            public Proxy(IBinder r8) {
                this.f6095a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f6095a;
            }
        }

        public Stub() {
            attachInterface(this, "com.obric.matrix.platform.sdk.ones.account.IAccountService");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 == 1598968902) goto L31;
            switch(r8) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L10;
                case 14: goto L9;
                case 15: goto L8;
                case 16: goto L7;
                default: goto L6;
            };
        L7:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            r1();
        L29:
            r11.writeNoException();
            return true;
        L8:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            B0();
            goto L29
        L9:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            r10.readString();
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            j1();
            goto L29
        L10:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            Q();
            goto L29
        L11:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            W();
            goto L29
        L12:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            X1();
            goto L29
        L13:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            R();
            goto L29
        L14:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            r10.readString();
            r10.readInt();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            x2();
            goto L29
        L15:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            l0();
            goto L29
        L16:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            m();
            goto L29
        L17:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            if (r10.readInt() == 0) goto L20;
            Bundle r13 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L20:
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            i0();
            goto L29
        L21:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            r10.readString();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            Z1();
            goto L29
        L22:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            r10.readString();
            r10.readInt();
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            C();
            goto L29
        L23:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            O0();
            goto L29
        L24:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            IAccountActionCallback.Stub.H2(r10.readStrongBinder());
            t();
            goto L29
        L25:
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            if (r10.readInt() == 0) goto L28;
            PendingIntent r14 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(r10);
        L28:
            M0();
            goto L29
        L6:
            return super.onTransact(r8, r10, r11, r12);
        L31:
            r11.writeString("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            return true;
        }
    }

    void B0();

    void C();

    void M0();

    void O0();

    void Q();

    void R();

    void W();

    void X1();

    void Z1();

    void i0();

    void j1();

    void l0();

    void m();

    void r1();

    void t();

    void x2();
}
