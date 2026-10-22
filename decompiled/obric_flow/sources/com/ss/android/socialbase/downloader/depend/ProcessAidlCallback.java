package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface ProcessAidlCallback extends IInterface {

    public static abstract class Stub extends Binder implements ProcessAidlCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15506a = 0;

        public static class Proxy implements ProcessAidlCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15507a;

            public Proxy(IBinder r5) {
                this.f15507a = r5;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ProcessAidlCallback
            public final void a(int r5, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");     // Catch: Throwable -> L6
                r11.writeInt(r5);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                if (this.f15507a.transact(1, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15506a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15507a;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static ProcessAidlCallback a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof ProcessAidlCallback) == false) goto L12;
            return (ProcessAidlCallback) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
            if (r5 != 1) goto L5;
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            a(r10.readInt(), r10.readInt());
            r11.writeNoException();
            return true;
        L5:
            if (r5 != 1598968902) goto L7;
            r11.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            return true;
        L7:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    void a(int r5, int r10);
}
