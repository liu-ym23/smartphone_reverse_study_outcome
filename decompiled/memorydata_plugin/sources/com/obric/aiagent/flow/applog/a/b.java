package com.obric.aiagent.flow.applog.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.obric.aiagent.flow.applog.a.b$a$a, reason: collision with other inner class name */
        private static class C0233a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static b f5919a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f5920b;

            C0233a(IBinder r3) {
                this.f5920b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.aiagent.flow.applog.a.b
            public void a(String r4, String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL");     // Catch: Throwable -> L12
                r0.writeString(r4);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.f5920b.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().a(r4, r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5920b;
            }
        }

        public static b a() {
            return C0233a.f5919a;
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0233a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL");
            a(r5.readString(), r5.readString());
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(String r1, String r2);
}
