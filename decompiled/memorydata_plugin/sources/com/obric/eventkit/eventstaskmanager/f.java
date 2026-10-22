package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        /* JADX INFO: renamed from: com.obric.eventkit.eventstaskmanager.f$a$a, reason: collision with other inner class name */
        public static class C0390a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static f f8026a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f8027b;

            public C0390a(IBinder r3) {
                this.f8027b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.eventkit.eventstaskmanager.f
            public void a(int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IEventTaskChangeListener");     // Catch: Throwable -> L12
                r0.writeInt(r4);     // Catch: Throwable -> L12
                if (this.f8027b.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().a(r4);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8027b;
            }
        }

        public static f a() {
            return C0390a.f8026a;
        }

        public static f a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.eventkit.eventstaskmanager.IEventTaskChangeListener");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L13;
            return (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin");
        L13:
            return new C0390a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IEventTaskChangeListener");
            a(r5.readInt());
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.eventkit.eventstaskmanager.IEventTaskChangeListener");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(int r1);
}
