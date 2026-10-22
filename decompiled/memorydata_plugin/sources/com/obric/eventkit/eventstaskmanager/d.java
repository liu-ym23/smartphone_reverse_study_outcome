package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: com.obric.eventkit.eventstaskmanager.d$a$a, reason: collision with other inner class name */
        public static class C0389a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static d f8024a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f8025b;

            public C0389a(IBinder r3) {
                this.f8025b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.eventkit.eventstaskmanager.d
            public void a(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener");     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.f8025b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().a(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8025b;
            }
        }

        public static d a() {
            return C0389a.f8024a;
        }

        public static d a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L13;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");
        L13:
            return new C0389a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener");
            a(r5.readInt());
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(int r1);
}
