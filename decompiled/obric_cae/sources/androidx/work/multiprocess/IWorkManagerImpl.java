package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IWorkManagerImpl extends IInterface {

    public static class Default implements IWorkManagerImpl {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImpl {

        public static class Proxy implements IWorkManagerImpl {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }
        }

        public Stub() {
            attachInterface(this, "androidx.work.multiprocess.IWorkManagerImpl");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("androidx.work.multiprocess.IWorkManagerImpl");
        L8:
            if (r8 == 1598968902) goto L23;
            switch(r8) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                default: goto L11;
            };
        L12:
            r10.createByteArray();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            y0();
        L22:
            return true;
        L13:
            r10.createByteArray();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            A();
            goto L22
        L14:
            r10.createByteArray();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            c0();
            goto L22
        L15:
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            Y1();
            goto L22
        L16:
            r10.readString();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            x();
            goto L22
        L17:
            r10.readString();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            z();
            goto L22
        L18:
            r10.readString();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            L0();
            goto L22
        L19:
            r10.createByteArray();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            j2();
            goto L22
        L20:
            r10.readString();
            r10.createByteArray();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            f0();
            goto L22
        L21:
            r10.createByteArray();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            y1();
            goto L22
        L11:
            return super.onTransact(r8, r10, r11, r12);
        L23:
            r11.writeString("androidx.work.multiprocess.IWorkManagerImpl");
            return true;
        }
    }

    void A();

    void L0();

    void Y1();

    void c0();

    void f0();

    void j2();

    void x();

    void y0();

    void y1();

    void z();
}
