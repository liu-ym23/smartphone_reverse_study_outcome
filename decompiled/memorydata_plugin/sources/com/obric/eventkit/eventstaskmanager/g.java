package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface g extends IInterface {

    public static abstract class a extends Binder implements g {

        /* JADX INFO: renamed from: com.obric.eventkit.eventstaskmanager.g$a$a, reason: collision with other inner class name */
        public static class C0391a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static g f8028a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f8029b;

            public C0391a(IBinder r3) {
                this.f8029b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.eventkit.eventstaskmanager.g
            public void a(EventTask r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.IEventTaskScheduleListener");     // Catch: Throwable -> L16
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.f8029b.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.a() == null) goto L14;
                a.a().a(r4);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8029b;
            }
        }

        public static g a() {
            return C0391a.f8028a;
        }

        public static g a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.eventkit.eventstaskmanager.IEventTaskScheduleListener");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L13;
            return (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.memorydata.plugin");
        L13:
            return new C0391a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.eventkit.eventstaskmanager.IEventTaskScheduleListener");
            if (r5.readInt() == 0) goto L13;
            EventTask r8 = (EventTask) ZeusTransformUtils.preCheckCast(EventTask.CREATOR.createFromParcel(r5), EventTask.class, "com.obric.memorydata.plugin");
        L14:
            a(r8);
            return true;
        L13:
            r8 = null;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.eventkit.eventstaskmanager.IEventTaskScheduleListener");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(EventTask r1);
}
