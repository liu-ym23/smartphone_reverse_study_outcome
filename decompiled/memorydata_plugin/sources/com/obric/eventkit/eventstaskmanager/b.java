package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.obric.eventkit.eventstaskmanager.b$a$a, reason: collision with other inner class name */
        public static class C0387a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static b f8020a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f8021b;

            public C0387a(IBinder r3) {
                this.f8021b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.eventkit.eventstaskmanager.b
            public void a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");     // Catch: Throwable -> L12
                if (this.f8021b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.e() == null) goto L10;
                a.e().a();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.b
            public void a(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.f8021b.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.e() == null) goto L10;
                a.e().a(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.b
            public void a(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.f8021b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.e() == null) goto L10;
                a.e().a(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8021b;
            }

            @Override // com.obric.eventkit.eventstaskmanager.b
            public void b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");     // Catch: Throwable -> L12
                if (this.f8021b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.e() == null) goto L10;
                a.e().b();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.b
            public void b(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.f8021b.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.e() == null) goto L10;
                a.e().b(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.b
            public void b(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.f8021b.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.e() == null) goto L10;
                a.e().b(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.b
            public void c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");     // Catch: Throwable -> L12
                if (this.f8021b.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.e() == null) goto L10;
                a.e().c();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.b
            public void d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");     // Catch: Throwable -> L12
                if (this.f8021b.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.e() == null) goto L10;
                a.e().d();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0387a(r4);
        }

        public static b e() {
            return C0387a.f8020a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L17;
            switch(r4) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");
            b(r5.readString());
        L8:
            r6.writeNoException();
            return true;
        L10:
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");
            d();
            goto L8
        L11:
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");
            c();
            goto L8
        L12:
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");
            b(r5.readInt());
            goto L8
        L13:
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");
            a(r5.readInt());
            goto L8
        L14:
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");
            b();
            goto L8
        L15:
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");
            a(r5.readString());
            goto L8
        L16:
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");
            a();
            goto L8
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString("com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener");
            return true;
        }
    }

    void a();

    void a(int r1);

    void a(String r1);

    void b();

    void b(int r1);

    void b(String r1);

    void c();

    void d();
}
