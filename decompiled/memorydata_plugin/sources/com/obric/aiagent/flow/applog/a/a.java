package com.obric.aiagent.flow.applog.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.aiagent.flow.applog.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0231a extends Binder implements a {

        /* JADX INFO: renamed from: com.obric.aiagent.flow.applog.a.a$a$a, reason: collision with other inner class name */
        private static class C0232a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f5917a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f5918b;

            C0232a(IBinder r3) {
                this.f5918b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.aiagent.flow.applog.a.a
            public void a(String r4, String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL");     // Catch: Throwable -> L12
                r0.writeString(r4);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.f5918b.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (AbstractBinderC0231a.a() == null) goto L10;
                AbstractBinderC0231a.a().a(r4, r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.a.a
            public void a(boolean r12, String r13, String r14, String r15, String r16, String r17, String r18) {
                Parcel r1 = Parcel.obtain();
                r1.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL");     // Catch: Throwable -> L16
                if (r12 == false) goto L6;
                int r2 = 1;
            L7:
                r1.writeInt(r2);     // Catch: Throwable -> L16
                r1.writeString(r13);     // Catch: Throwable -> L16
                r1.writeString(r14);     // Catch: Throwable -> L16
                r1.writeString(r15);     // Catch: Throwable -> L16
                r1.writeString(r16);     // Catch: Throwable -> L16
                r1.writeString(r17);     // Catch: Throwable -> L16
                r1.writeString(r18);     // Catch: Throwable -> L16
                if (this.f5918b.transact(2, r1, null, 1) == false) goto L10;
            L14:
                r1.recycle();
                return;
            L10:
                if (AbstractBinderC0231a.a() == null) goto L14;
                AbstractBinderC0231a.a().a(r12, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L16
                r1.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r1.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5918b;
            }
        }

        public AbstractBinderC0231a() {
            attachInterface(this, "com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL");
        }

        public static a a() {
            return C0232a.f5917a;
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0232a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL");
            a(r11.readString(), r11.readString(), r11.readString());
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface("com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL");
            if (r11.readInt() == 0) goto L15;
            boolean r2 = true;
        L16:
            a(r2, r11.readString(), r11.readString(), r11.readString(), r11.readString(), r11.readString(), r11.readString());
            return true;
        L15:
            r2 = false;
            goto L16
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString("com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL");
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void a(String r1, String r2, String r3);

    void a(boolean r1, String r2, String r3, String r4, String r5, String r6, String r7);
}
