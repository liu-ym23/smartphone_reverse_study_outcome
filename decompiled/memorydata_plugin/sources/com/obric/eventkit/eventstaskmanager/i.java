package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface i extends IInterface {

    public static abstract class a extends Binder implements i {

        /* JADX INFO: renamed from: com.obric.eventkit.eventstaskmanager.i$a$a, reason: collision with other inner class name */
        public static class C0393a implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static i f8032a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f8033b;

            public C0393a(IBinder r3) {
                this.f8033b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.eventkit.eventstaskmanager.i
            public void a(int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITimerTaskChangeListener");     // Catch: Throwable -> L12
                r0.writeInt(r4);     // Catch: Throwable -> L12
                if (this.f8033b.transact(1, r0, null, 1) == false) goto L6;
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
                return this.f8033b;
            }
        }

        public static i a() {
            return C0393a.f8032a;
        }

        public static i a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.eventkit.eventstaskmanager.ITimerTaskChangeListener");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, i.class) == false) goto L13;
            return (i) ZeusTransformUtils.preCheckCast(r0, i.class, "com.obric.memorydata.plugin");
        L13:
            return new C0393a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.ITimerTaskChangeListener");
            a(r5.readInt());
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.eventkit.eventstaskmanager.ITimerTaskChangeListener");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(int r1);
}
