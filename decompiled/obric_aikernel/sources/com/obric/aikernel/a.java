package com.obric.aikernel;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.aikernel.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0095a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.aikernel.a$a$a, reason: collision with other inner class name */
        private static class C0096a implements a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static a f4426g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f4427c;

            C0096a(IBinder r10) {
                this.f4427c = r10;
            }

            @Override // com.obric.aikernel.a
            public void A1(Bundle r10, b r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.aikernel.AIKBinder");     // Catch: Throwable -> L20
                if (r10 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L20
            L7:
                if (r11 == null) goto L9;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L20
            L10:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L20
                if (this.f4427c.transact(2, r12, r13, 0) == false) goto L13;
            L17:
                r13.readException();     // Catch: Throwable -> L20
                r13.recycle();
                r12.recycle();
                return;
            L13:
                if (AbstractBinderC0095a.k1() == null) goto L17;
                AbstractBinderC0095a.k1().A1(r10, r11);     // Catch: Throwable -> L20
                r13.recycle();
                r12.recycle();
                return;
            L9:
                r14 = null;
                goto L10
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.aikernel.a
            public void F1(Bundle r10, b r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.aikernel.AIKBinder");     // Catch: Throwable -> L20
                if (r10 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L20
            L7:
                if (r11 == null) goto L9;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L20
            L10:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L20
                if (this.f4427c.transact(3, r12, r13, 0) == false) goto L13;
            L17:
                r13.readException();     // Catch: Throwable -> L20
                r13.recycle();
                r12.recycle();
                return;
            L13:
                if (AbstractBinderC0095a.k1() == null) goto L17;
                AbstractBinderC0095a.k1().F1(r10, r11);     // Catch: Throwable -> L20
                r13.recycle();
                r12.recycle();
                return;
            L9:
                r14 = null;
                goto L10
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.aikernel.a
            public Bundle Z0(Bundle r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.aikernel.AIKBinder");     // Catch: Throwable -> L21
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L21
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L21
            L8:
                if (this.f4427c.transact(1, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L21
                if (r12.readInt() == 0) goto L18;
                Bundle r13 = (Bundle) Bundle.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L21
            L19:
                r12.recycle();
                r11.recycle();
                return r13;
            L18:
                r13 = null;
                goto L19
            L10:
                if (AbstractBinderC0095a.k1() == null) goto L14;
                Bundle r14 = AbstractBinderC0095a.k1().Z0(r10);     // Catch: Throwable -> L21
                r12.recycle();
                r11.recycle();
                return r14;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4427c;
            }
        }

        public AbstractBinderC0095a() {
            attachInterface(this, "com.obric.aikernel.AIKBinder");
        }

        public static a U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.aikernel.AIKBinder");
            if (r11 == null) goto L12;
            if ((r11 instanceof a) == false) goto L12;
            return (a) r11;
        L12:
            return new C0096a(r10);
        }

        public static a k1() {
            return C0096a.f4426g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            Bundle r14 = null;
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.obric.aikernel.AIKBinder");
            if (r11.readInt() == 0) goto L27;
            r14 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L27:
            Bundle r15 = Z0(r14);
            r12.writeNoException();
            if (r15 == null) goto L30;
            r12.writeInt(1);
            r15.writeToParcel(r12, 1);
        L31:
            return true;
        L30:
            r12.writeInt(0);
            goto L31
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface("com.obric.aikernel.AIKBinder");
            if (r11.readInt() == 0) goto L23;
            r14 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L23:
            A1(r14, b.a.U0(r11.readStrongBinder()));
        L18:
            r12.writeNoException();
            return true;
        L7:
            if (r10 != 3) goto L9;
            r11.enforceInterface("com.obric.aikernel.AIKBinder");
            if (r11.readInt() == 0) goto L17;
            r14 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L17:
            F1(r14, b.a.U0(r11.readStrongBinder()));
            goto L18
        L9:
            if (r10 != 1598968902) goto L11;
            r12.writeString("com.obric.aikernel.AIKBinder");
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void A1(Bundle r10, b r11);

    void F1(Bundle r10, b r11);

    Bundle Z0(Bundle r10);
}
