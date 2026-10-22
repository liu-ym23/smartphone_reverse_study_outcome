package com.obric.aikernel;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.obric.aikernel.b$a$a, reason: collision with other inner class name */
        private static class C0104a implements b {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static b f4475g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f4476c;

            C0104a(IBinder r10) {
                this.f4476c = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4476c;
            }

            @Override // com.obric.aikernel.b
            public void j2(Bundle r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.aikernel.AIKListener");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f4476c.transact(1, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().j2(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.obric.aikernel.AIKListener");
        }

        public static b U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.aikernel.AIKListener");
            if (r11 == null) goto L12;
            if ((r11 instanceof b) == false) goto L12;
            return (b) r11;
        L12:
            return new C0104a(r10);
        }

        public static b k1() {
            return C0104a.f4475g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.obric.aikernel.AIKListener");
            if (r11.readInt() == 0) goto L13;
            Bundle r14 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L14:
            j2(r14);
            r12.writeNoException();
            return true;
        L13:
            r14 = null;
            goto L14
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.obric.aikernel.AIKListener");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void j2(Bundle r10);
}
