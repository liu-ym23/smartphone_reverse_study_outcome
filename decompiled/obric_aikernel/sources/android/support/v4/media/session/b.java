package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: android.support.v4.media.session.b$a$a, reason: collision with other inner class name */
        private static class C0011a implements b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f205c;

            C0011a(IBinder r10) {
                this.f205c = r10;
            }

            @Override // android.support.v4.media.session.b
            public boolean C1(KeyEvent r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L13
                boolean r13 = true;
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L13
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L13
            L7:
                this.f205c.transact(2, r11, r12, 0);     // Catch: Throwable -> L13
                r12.readException();     // Catch: Throwable -> L13
                if (r12.readInt() != 0) goto L11;
                r13 = false;
            L11:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void T0(android.support.v4.media.session.a r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L10
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L10
                this.f205c.transact(3, r11, r12, 0);     // Catch: Throwable -> L10
                r12.readException();     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r13 = null;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f205c;
            }
        }

        public static b U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (r11 == null) goto L12;
            if ((r11 instanceof b) == false) goto L12;
            return (b) r11;
        L12:
            return new C0011a(r10);
        }
    }

    boolean C1(KeyEvent r10);

    void T0(android.support.v4.media.session.a r10);
}
