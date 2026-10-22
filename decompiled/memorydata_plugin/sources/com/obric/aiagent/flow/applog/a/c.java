package com.obric.aiagent.flow.applog.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.obric.aiagent.flow.applog.a.c$a$a, reason: collision with other inner class name */
        private static class C0234a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static c f5921a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f5922b;

            C0234a(IBinder r3) {
                this.f5922b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void a() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
                if (this.f5922b.transact(12, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.i() == null) goto L10;
                a.i().a();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void a(com.obric.aiagent.flow.applog.a.a r5) {
                com.obric.aiagent.flow.applog.a.a r6 = (com.obric.aiagent.flow.applog.a.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.flow.applog.a.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f5922b.transact(9, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.i() == null) goto L14;
                a.i().a(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void a(b r5) {
                b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f5922b.transact(7, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.i() == null) goto L14;
                a.i().a(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void a(d r5) {
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f5922b.transact(5, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.i() == null) goto L14;
                a.i().a(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void a(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.f5922b.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.i() == null) goto L10;
                a.i().a(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void a(String r5, int r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (this.f5922b.transact(11, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.i() == null) goto L10;
                a.i().a(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void a(String r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.f5922b.transact(4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.i() == null) goto L14;
                a.i().a(r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void a(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.f5922b.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.i() == null) goto L10;
                a.i().a(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void a(Map r4) {
                Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
                r0.writeMap(r5);     // Catch: Throwable -> L12
                if (this.f5922b.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.i() == null) goto L10;
                a.i().a(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5922b;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void b() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
                if (this.f5922b.transact(13, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.i() == null) goto L10;
                a.i().b();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void b(com.obric.aiagent.flow.applog.a.a r5) {
                com.obric.aiagent.flow.applog.a.a r6 = (com.obric.aiagent.flow.applog.a.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.flow.applog.a.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f5922b.transact(10, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.i() == null) goto L14;
                a.i().b(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void b(b r5) {
                b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f5922b.transact(8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.i() == null) goto L14;
                a.i().b(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void b(d r5) {
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f5922b.transact(6, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.i() == null) goto L14;
                a.i().b(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void b(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.f5922b.transact(14, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.i() == null) goto L10;
                a.i().b(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public void c() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
                if (this.f5922b.transact(15, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.i() == null) goto L10;
                a.i().c();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public String d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L13
                if (this.f5922b.transact(16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.i() == null) goto L10;
                String r5 = a.i().d();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public String e() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L13
                if (this.f5922b.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.i() == null) goto L10;
                String r5 = a.i().e();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public String f() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L13
                if (this.f5922b.transact(18, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.i() == null) goto L10;
                String r5 = a.i().f();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public String g() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L13
                if (this.f5922b.transact(19, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.i() == null) goto L10;
                String r5 = a.i().g();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.c
            public String h() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L13
                if (this.f5922b.transact(20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.i() == null) goto L10;
                String r5 = a.i().h();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
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
            IInterface r0 = r4.queryLocalInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L13;
            return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
        L13:
            return new C0234a(r4);
        }

        public static c i() {
            return C0234a.f5921a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L51;
            switch(r4) {
                case 1: goto L49;
                case 2: goto L47;
                case 3: goto L45;
                case 4: goto L39;
                case 5: goto L37;
                case 6: goto L35;
                case 7: goto L33;
                case 8: goto L31;
                case 9: goto L29;
                case 10: goto L27;
                case 11: goto L25;
                case 12: goto L23;
                case 13: goto L21;
                case 14: goto L19;
                case 15: goto L17;
                case 16: goto L15;
                case 17: goto L13;
                case 18: goto L11;
                case 19: goto L9;
                case 20: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            String r3 = h();
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L9:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            String r8 = g();
            r6.writeNoException();
            r6.writeString(r8);
            return true;
        L11:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            String r9 = f();
            r6.writeNoException();
            r6.writeString(r9);
            return true;
        L13:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            String r10 = e();
            r6.writeNoException();
            r6.writeString(r10);
            return true;
        L15:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            String r11 = d();
            r6.writeNoException();
            r6.writeString(r11);
            return true;
        L17:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            c();
            return true;
        L19:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            b(r5.readString());
            return true;
        L21:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            b();
            return true;
        L23:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            a();
            return true;
        L25:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            a(r5.readString(), r5.readInt());
            return true;
        L27:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            b(com.obric.aiagent.flow.applog.a.a.AbstractBinderC0231a.a(r5.readStrongBinder()));
            return true;
        L29:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            a(com.obric.aiagent.flow.applog.a.a.AbstractBinderC0231a.a(r5.readStrongBinder()));
            return true;
        L31:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            b(b.a.a(r5.readStrongBinder()));
            return true;
        L33:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            a(b.a.a(r5.readStrongBinder()));
            return true;
        L35:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            b(d.a.a(r5.readStrongBinder()));
            return true;
        L37:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            a(d.a.a(r5.readStrongBinder()));
            return true;
        L39:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            String r12 = r5.readString();
            if (r5.readInt() == 0) goto L42;
            Bundle r13 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r5), Bundle.class, "com.obric.memorydata.plugin");
        L43:
            a(r12, r13);
            return true;
        L42:
            r13 = null;
            goto L43
        L45:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            a(r5.readString(), r5.readString());
            return true;
        L47:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            a(r5.readString());
            return true;
        L49:
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            a(r5.readHashMap(getClass().getClassLoader()));
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L51:
            r6.writeString("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");
            return true;
        }
    }

    void a();

    void a(com.obric.aiagent.flow.applog.a.a r1);

    void a(b r1);

    void a(d r1);

    void a(String r1);

    void a(String r1, int r2);

    void a(String r1, Bundle r2);

    void a(String r1, String r2);

    void a(Map r1);

    void b();

    void b(com.obric.aiagent.flow.applog.a.a r1);

    void b(b r1);

    void b(d r1);

    void b(String r1);

    void c();

    String d();

    String e();

    String f();

    String g();

    String h();
}
