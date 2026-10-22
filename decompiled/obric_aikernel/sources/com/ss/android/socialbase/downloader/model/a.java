package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ib.c0;
import ib.i;
import ib.j0;
import ib.l;
import ib.q;
import ib.w;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0149a extends Binder implements a {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.a$a$a, reason: collision with other inner class name */
        private static class C0150a implements a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static a f8141g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f8142c;

            C0150a(IBinder r10) {
                this.f8142c = r10;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ib.e B1() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f8142c.transact(8, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                ib.e r12 = ib.e.a.U0(r11.readStrongBinder());     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                ib.e r13 = AbstractBinderC0149a.k1().B1();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public DownloadInfo M1() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L17
                if (this.f8142c.transact(1, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L17
                if (r11.readInt() == 0) goto L14;
                DownloadInfo r12 = DownloadInfo.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L17
            L15:
                r11.recycle();
                r10.recycle();
                return r12;
            L14:
                r12 = null;
                goto L15
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                DownloadInfo r13 = AbstractBinderC0149a.k1().M1();     // Catch: Throwable -> L17
                r11.recycle();
                r10.recycle();
                return r13;
            L17:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int N0() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f8142c.transact(13, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                int r12 = r11.readInt();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                int r13 = AbstractBinderC0149a.k1().N0();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public l P1(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f8142c.transact(14, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                l r13 = l.a.U0(r12.readStrongBinder());     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                l r14 = AbstractBinderC0149a.k1().P1(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ib.f R1() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f8142c.transact(12, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                ib.f r12 = ib.f.a.U0(r11.readStrongBinder());     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                ib.f r13 = AbstractBinderC0149a.k1().R1();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public j0 V0() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f8142c.transact(6, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                j0 r12 = j0.a.U0(r11.readStrongBinder());     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                j0 r13 = AbstractBinderC0149a.k1().V0();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ib.h W0(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f8142c.transact(4, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                ib.h r13 = ib.h.a.U0(r12.readStrongBinder());     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                ib.h r14 = AbstractBinderC0149a.k1().W0(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int[] a1(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f8142c.transact(2, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                int[] r13 = r12.createIntArray();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                int[] r14 = AbstractBinderC0149a.k1().a1(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return r14;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public q a2() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f8142c.transact(10, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                q r12 = q.a.U0(r11.readStrongBinder());     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                q r13 = AbstractBinderC0149a.k1().a2();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8142c;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i b2() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f8142c.transact(11, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                i r12 = i.a.U0(r11.readStrongBinder());     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                i r13 = AbstractBinderC0149a.k1().b2();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public w d1() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f8142c.transact(9, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                w r12 = w.a.U0(r11.readStrongBinder());     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                w r13 = AbstractBinderC0149a.k1().d1();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ib.g m1() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f8142c.transact(7, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                ib.g r12 = ib.g.a.U0(r11.readStrongBinder());     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                ib.g r13 = AbstractBinderC0149a.k1().m1();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public c0 r1() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                if (this.f8142c.transact(5, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                c0 r12 = c0.a.U0(r11.readStrongBinder());     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                c0 r13 = AbstractBinderC0149a.k1().r1();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ib.h w1(int r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");     // Catch: Throwable -> L13
                r12.writeInt(r10);     // Catch: Throwable -> L13
                r12.writeInt(r11);     // Catch: Throwable -> L13
                if (this.f8142c.transact(3, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L13
                ib.h r14 = ib.h.a.U0(r13.readStrongBinder());     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                if (AbstractBinderC0149a.k1() == null) goto L10;
                ib.h r15 = AbstractBinderC0149a.k1().w1(r10, r11);     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return r15;
            L13:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public AbstractBinderC0149a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static a U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (r11 == null) goto L12;
            if ((r11 instanceof a) == false) goto L12;
            return (a) r11;
        L12:
            return new C0150a(r10);
        }

        public static a k1() {
            return C0150a.f8141g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L72;
            IBinder r14 = null;
            switch(r10) {
                case 1: goto L67;
                case 2: goto L65;
                case 3: goto L60;
                case 4: goto L55;
                case 5: goto L50;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L35;
                case 9: goto L30;
                case 10: goto L25;
                case 11: goto L20;
                case 12: goto L15;
                case 13: goto L13;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            l r15 = P1(r11.readInt());
            r12.writeNoException();
            if (r15 == null) goto L11;
            r14 = r15.asBinder();
        L11:
            r12.writeStrongBinder(r14);
            return true;
        L13:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            int r16 = N0();
            r12.writeNoException();
            r12.writeInt(r16);
            return true;
        L15:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            ib.f r17 = R1();
            r12.writeNoException();
            if (r17 == null) goto L18;
            r14 = r17.asBinder();
        L18:
            r12.writeStrongBinder(r14);
            return true;
        L20:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            i r18 = b2();
            r12.writeNoException();
            if (r18 == null) goto L23;
            r14 = r18.asBinder();
        L23:
            r12.writeStrongBinder(r14);
            return true;
        L25:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            q r19 = a2();
            r12.writeNoException();
            if (r19 == null) goto L28;
            r14 = r19.asBinder();
        L28:
            r12.writeStrongBinder(r14);
            return true;
        L30:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            w r20 = d1();
            r12.writeNoException();
            if (r20 == null) goto L33;
            r14 = r20.asBinder();
        L33:
            r12.writeStrongBinder(r14);
            return true;
        L35:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            ib.e r21 = B1();
            r12.writeNoException();
            if (r21 == null) goto L38;
            r14 = r21.asBinder();
        L38:
            r12.writeStrongBinder(r14);
            return true;
        L40:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            ib.g r22 = m1();
            r12.writeNoException();
            if (r22 == null) goto L43;
            r14 = r22.asBinder();
        L43:
            r12.writeStrongBinder(r14);
            return true;
        L45:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            j0 r23 = V0();
            r12.writeNoException();
            if (r23 == null) goto L48;
            r14 = r23.asBinder();
        L48:
            r12.writeStrongBinder(r14);
            return true;
        L50:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            c0 r24 = r1();
            r12.writeNoException();
            if (r24 == null) goto L53;
            r14 = r24.asBinder();
        L53:
            r12.writeStrongBinder(r14);
            return true;
        L55:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            ib.h r25 = W0(r11.readInt());
            r12.writeNoException();
            if (r25 == null) goto L58;
            r14 = r25.asBinder();
        L58:
            r12.writeStrongBinder(r14);
            return true;
        L60:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            ib.h r26 = w1(r11.readInt(), r11.readInt());
            r12.writeNoException();
            if (r26 == null) goto L63;
            r14 = r26.asBinder();
        L63:
            r12.writeStrongBinder(r14);
            return true;
        L65:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            int[] r27 = a1(r11.readInt());
            r12.writeNoException();
            r12.writeIntArray(r27);
            return true;
        L67:
            r11.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            DownloadInfo r28 = M1();
            r12.writeNoException();
            if (r28 == null) goto L70;
            r12.writeInt(1);
            r28.writeToParcel(r12, 1);
        L71:
            return true;
        L70:
            r12.writeInt(0);
            goto L71
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L72:
            r12.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return true;
        }
    }

    ib.e B1();

    DownloadInfo M1();

    int N0();

    l P1(int r10);

    ib.f R1();

    j0 V0();

    ib.h W0(int r10);

    int[] a1(int r10);

    q a2();

    i b2();

    w d1();

    ib.g m1();

    c0 r1();

    ib.h w1(int r10, int r11);
}
