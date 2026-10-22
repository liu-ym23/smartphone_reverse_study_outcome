package hb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: hb.b$a$a, reason: collision with other inner class name */
        private static class C0178a implements b {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static b f9201g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9202c;

            C0178a(IBinder r10) {
                this.f9202c = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9202c;
            }

            @Override // hb.b
            public void c1(Map r10, Map r11, Map r12, boolean r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");     // Catch: Throwable -> L17
                r14.writeMap(r10);     // Catch: Throwable -> L17
                r14.writeMap(r11);     // Catch: Throwable -> L17
                r14.writeMap(r12);     // Catch: Throwable -> L17
                if (r13 == false) goto L6;
                int r16 = 1;
            L7:
                r14.writeInt(r16);     // Catch: Throwable -> L17
                if (this.f9202c.transact(1, r14, r15, 0) == false) goto L10;
            L14:
                r15.readException();     // Catch: Throwable -> L17
                r15.recycle();
                r14.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().c1(r10, r11, r12, r13);     // Catch: Throwable -> L17
                r15.recycle();
                r14.recycle();
                return;
            L6:
                r16 = 0;
            L17:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
        }

        public static b U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            if (r11 == null) goto L12;
            if ((r11 instanceof b) == false) goto L12;
            return (b) r11;
        L12:
            return new C0178a(r10);
        }

        public static b k1() {
            return C0178a.f9201g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            ClassLoader r14 = getClass().getClassLoader();
            HashMap r15 = r11.readHashMap(r14);
            HashMap r16 = r11.readHashMap(r14);
            HashMap r17 = r11.readHashMap(r14);
            if (r11.readInt() == 0) goto L13;
            boolean r18 = true;
        L14:
            c1(r15, r16, r17, r18);
            r12.writeNoException();
            return true;
        L13:
            r18 = false;
            goto L14
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void c1(Map r10, Map r11, Map r12, boolean r13);
}
