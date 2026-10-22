package com.obric.memorydata.sdk.realtime;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.memorydata.sdk.realtime.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0698a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.memorydata.sdk.realtime.a$a$a, reason: collision with other inner class name */
        private static class C0699a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f12839a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f12840b;

            C0699a(IBinder r3) {
                this.f12840b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.memorydata.sdk.realtime.a
            public void a(ActionContext r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.realtime.IRealTimeContextCallback");     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f12840b.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (AbstractBinderC0698a.a() == null) goto L14;
                AbstractBinderC0698a.a().a(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.memorydata.sdk.realtime.a
            public void a(RealTimeContext r6, boolean r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.realtime.IRealTimeContextCallback");     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == false) goto L9;
                int r4 = 1;
            L10:
                r0.writeInt(r4);     // Catch: Throwable -> L20
                if (this.f12840b.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (AbstractBinderC0698a.a() == null) goto L17;
                AbstractBinderC0698a.a().a(r6, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r4 = 0;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12840b;
            }
        }

        public static a a() {
            return C0699a.f12839a;
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.memorydata.sdk.realtime.IRealTimeContextCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0699a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            RealTimeContext r0 = null;
            ActionContext r1 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface("com.obric.memorydata.sdk.realtime.IRealTimeContextCallback");
            if (r6.readInt() == 0) goto L22;
            r0 = (RealTimeContext) ZeusTransformUtils.preCheckCast(RealTimeContext.CREATOR.createFromParcel(r6), RealTimeContext.class, "com.obric.memorydata.plugin");
        L22:
            if (r6.readInt() == 0) goto L24;
            boolean r9 = true;
        L25:
            a(r0, r9);
        L16:
            r7.writeNoException();
            return true;
        L24:
            r9 = false;
            goto L25
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface("com.obric.memorydata.sdk.realtime.IRealTimeContextCallback");
            if (r6.readInt() == 0) goto L15;
            r1 = ActionContext.CREATOR.createFromParcel(r6);
        L15:
            a(r1);
            goto L16
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString("com.obric.memorydata.sdk.realtime.IRealTimeContextCallback");
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    void a(ActionContext r1);

    void a(RealTimeContext r1, boolean r2);
}
