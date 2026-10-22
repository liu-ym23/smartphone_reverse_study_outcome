package com.obric.matrix.platform.sdk.ones.account;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.account.c$a$a, reason: collision with other inner class name */
        private static class C0402a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static c f8076a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f8077b;

            C0402a(IBinder r3) {
                this.f8077b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L13
                if (this.f8077b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.b() == null) goto L10;
                a.b().a();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void a(PendingIntent r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f8077b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().a(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void a(Bundle r5, String r6, b r7) {
                b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L21
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeString(r6);     // Catch: Throwable -> L21
                if (r8 == null) goto L10;
                IBinder r3 = r8.asBinder();     // Catch: Throwable -> L21
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L21
                if (this.f8077b.transact(6, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (a.b() == null) goto L18;
                a.b().a(r5, r6, r8);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void a(b r5) {
                b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().a(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void a(String r5, int r6, b r7) {
                b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().a(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void a(String r5, b r6) {
                b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().a(r5, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void a(String r5, String r6, int r7, b r8) {
                b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r8, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeInt(r7);     // Catch: Throwable -> L17
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().a(r5, r6, r7, r9);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void a(String r5, String r6, b r7) {
                b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().a(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void a(String r5, String r6, String r7, b r8) {
                b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r8, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeString(r7);     // Catch: Throwable -> L17
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(14, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().a(r5, r6, r7, r9);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8077b;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void b(String r5, b r6) {
                b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(11, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().b(r5, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void b(String r5, String r6, b r7) {
                b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().b(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void c(String r5, b r6) {
                b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().c(r5, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void c(String r5, String r6, b r7) {
                b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(10, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().c(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void d(String r5, String r6, b r7) {
                b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(13, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().d(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void e(String r5, String r6, b r7) {
                b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(15, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().e(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.c
            public void f(String r5, String r6, b r7) {
                b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.f8077b.transact(16, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.b() == null) goto L14;
                a.b().f(r5, r6, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public static c a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L13;
            return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
        L13:
            return new C0402a(r4);
        }

        public static c b() {
            return C0402a.f8076a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L32;
            PendingIntent r3 = null;
            Bundle r4 = null;
            switch(r5) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L12;
                case 15: goto L11;
                case 16: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            f(r6.readString(), r6.readString(), b.a.a(r6.readStrongBinder()));
        L9:
            r7.writeNoException();
            return true;
        L11:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            e(r6.readString(), r6.readString(), b.a.a(r6.readStrongBinder()));
            goto L9
        L12:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            a(r6.readString(), r6.readString(), r6.readString(), b.a.a(r6.readStrongBinder()));
            goto L9
        L13:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            d(r6.readString(), r6.readString(), b.a.a(r6.readStrongBinder()));
            goto L9
        L14:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            c(r6.readString(), b.a.a(r6.readStrongBinder()));
            goto L9
        L15:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            b(r6.readString(), b.a.a(r6.readStrongBinder()));
            goto L9
        L16:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            c(r6.readString(), r6.readString(), b.a.a(r6.readStrongBinder()));
            goto L9
        L17:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            a(r6.readString(), r6.readString(), r6.readInt(), b.a.a(r6.readStrongBinder()));
            goto L9
        L18:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            b(r6.readString(), r6.readString(), b.a.a(r6.readStrongBinder()));
            goto L9
        L19:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            a(r6.readString(), b.a.a(r6.readStrongBinder()));
            goto L9
        L20:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            if (r6.readInt() == 0) goto L23;
            r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r6), Bundle.class, "com.obric.memorydata.plugin");
        L23:
            a(r4, r6.readString(), b.a.a(r6.readStrongBinder()));
            goto L9
        L24:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            a(r6.readString(), r6.readString(), b.a.a(r6.readStrongBinder()));
            goto L9
        L25:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            a(r6.readString(), r6.readInt(), b.a.a(r6.readStrongBinder()));
            goto L9
        L26:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            a();
            goto L9
        L27:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            a(b.a.a(r6.readStrongBinder()));
            goto L9
        L28:
            r6.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            if (r6.readInt() == 0) goto L31;
            r3 = (PendingIntent) ZeusTransformUtils.preCheckCast(PendingIntent.CREATOR.createFromParcel(r6), PendingIntent.class, "com.obric.memorydata.plugin");
        L31:
            a(r3);
            goto L9
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L32:
            r7.writeString("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            return true;
        }
    }

    void a();

    void a(PendingIntent r1);

    void a(Bundle r1, String r2, b r3);

    void a(b r1);

    void a(String r1, int r2, b r3);

    void a(String r1, b r2);

    void a(String r1, String r2, int r3, b r4);

    void a(String r1, String r2, b r3);

    void a(String r1, String r2, String r3, b r4);

    void b(String r1, b r2);

    void b(String r1, String r2, b r3);

    void c(String r1, b r2);

    void c(String r1, String r2, b r3);

    void d(String r1, String r2, b r3);

    void e(String r1, String r2, b r3);

    void f(String r1, String r2, b r3);
}
