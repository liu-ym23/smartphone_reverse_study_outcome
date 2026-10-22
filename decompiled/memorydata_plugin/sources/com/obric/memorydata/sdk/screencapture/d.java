package com.obric.memorydata.sdk.screencapture;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: com.obric.memorydata.sdk.screencapture.d$a$a, reason: collision with other inner class name */
        private static class C0701a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static d f12848a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f12849b;

            C0701a(IBinder r3) {
                this.f12849b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.memorydata.sdk.screencapture.d
            public void a(int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.screencapture.IEventReactionCallback");     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.f12849b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.a() == null) goto L10;
                a.a().a(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.screencapture.d
            public void a(ScreenEvent r5, ScreenData r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.memorydata.sdk.screencapture.IEventReactionCallback");     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L11:
                if (this.f12849b.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (a.a() == null) goto L17;
                a.a().a(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L11
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
                return this.f12849b;
            }
        }

        public a() {
            attachInterface(this, "com.obric.memorydata.sdk.screencapture.IEventReactionCallback");
        }

        public static d a() {
            return C0701a.f12848a;
        }

        public static d a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.memorydata.sdk.screencapture.IEventReactionCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L13;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");
        L13:
            return new C0701a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.memorydata.sdk.screencapture.IEventReactionCallback");
            ScreenData r8 = null;
            if (r5.readInt() == 0) goto L18;
            ScreenEvent r9 = ScreenEvent.CREATOR.a(r5);
        L20:
            if (r5.readInt() == 0) goto L22;
            r8 = (ScreenData) ZeusTransformUtils.preCheckCast(ScreenData.CREATOR.createFromParcel(r5), ScreenData.class, "com.obric.memorydata.plugin");
        L22:
            a(r9, r8);
        L13:
            r6.writeNoException();
            return true;
        L18:
            r9 = null;
            goto L20
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.obric.memorydata.sdk.screencapture.IEventReactionCallback");
            a(r5.readInt(), r5.readString());
            goto L13
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString("com.obric.memorydata.sdk.screencapture.IEventReactionCallback");
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(int r1, String r2);

    void a(ScreenEvent r1, ScreenData r2);
}
