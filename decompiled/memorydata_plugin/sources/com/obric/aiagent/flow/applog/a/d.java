package com.obric.aiagent.flow.applog.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: com.obric.aiagent.flow.applog.a.d$a$a, reason: collision with other inner class name */
        private static class C0235a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static d f5923a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f5924b;

            C0235a(IBinder r3) {
                this.f5924b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.aiagent.flow.applog.a.d
            public void a(long r4, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL");     // Catch: Throwable -> L12
                r0.writeLong(r4);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.f5924b.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().a(r4, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5924b;
            }

            @Override // com.obric.aiagent.flow.applog.a.d
            public void b(long r5, String r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL");     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (this.f5924b.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().b(r5, r7);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.d
            public void c(long r5, String r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL");     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (this.f5924b.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().c(r5, r7);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public static d a() {
            return C0235a.f5923a;
        }

        public static d a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L13;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");
        L13:
            return new C0235a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL");
            a(r5.readLong(), r5.readString());
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL");
            b(r5.readLong(), r5.readString());
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL");
            c(r5.readLong(), r5.readString());
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString("com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL");
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(long r1, String r3);

    void b(long r1, String r3);

    void c(long r1, String r3);
}
