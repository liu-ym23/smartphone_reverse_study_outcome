package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.obric.cae.libs.cldReport.b$a$a, reason: collision with other inner class name */
        public static class C0322a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f6953a;

            public C0322a(IBinder r3) {
                this.f6953a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.cae.libs.cldReport.b
            public void a(int r4, int r5, int r6, int r7, String r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cldReport.ICldReportManager");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                r0.writeString(r8);     // Catch: Throwable -> L6
                this.f6953a.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cldReport.b
            public void a(com.obric.cae.libs.cldReport.a r4, int r5, int r6) {
                com.obric.cae.libs.cldReport.a r7 = (com.obric.cae.libs.cldReport.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.cldReport.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cldReport.ICldReportManager");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r7);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                this.f6953a.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cldReport.b
            public void a(com.obric.cae.libs.cldReport.a r4, int r5, int r6, int r7, int r8, String r9, boolean r10) {
                com.obric.cae.libs.cldReport.a r11 = (com.obric.cae.libs.cldReport.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.cldReport.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.cae.libs.cldReport.ICldReportManager");     // Catch: Throwable -> L6
                r0.writeStrongInterface(r11);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                r0.writeInt(r8);     // Catch: Throwable -> L6
                r0.writeString(r9);     // Catch: Throwable -> L6
                r0.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L6
                this.f6953a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6953a;
            }
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.cae.libs.cldReport.ICldReportManager");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0322a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r13, Parcel r14, Parcel r15, int r16) {
            if (r13 < 1) goto L9;
            if (r13 > 16777215) goto L9;
            r14.enforceInterface("com.obric.cae.libs.cldReport.ICldReportManager");
        L9:
            if (r13 == 1598968902) goto L26;
            if (r13 != 1) goto L12;
            a(r14.readInt(), r14.readInt(), r14.readInt(), r14.readInt(), r14.readString());
        L24:
            r15.writeNoException();
            return true;
        L12:
            if (r13 != 2) goto L14;
            com.obric.cae.libs.cldReport.a r5 = com.obric.cae.libs.cldReport.a.AbstractBinderC0320a.a(r14.readStrongBinder());
            int r6 = r14.readInt();
            int r7 = r14.readInt();
            int r8 = r14.readInt();
            int r9 = r14.readInt();
            String r10 = r14.readString();
            if (r14.readInt() == 0) goto L21;
            boolean r11 = true;
        L22:
            a(r5, r6, r7, r8, r9, r10, r11);
            goto L24
        L21:
            r11 = false;
            goto L22
        L14:
            if (r13 != 3) goto L16;
            a(com.obric.cae.libs.cldReport.a.AbstractBinderC0320a.a(r14.readStrongBinder()), r14.readInt(), r14.readInt());
            goto L24
        L16:
            return super.onTransact(r13, r14, r15, r16);
        L26:
            r15.writeString("com.obric.cae.libs.cldReport.ICldReportManager");
            return true;
        }
    }

    void a(int r1, int r2, int r3, int r4, String r5);

    void a(com.obric.cae.libs.cldReport.a r1, int r2, int r3);

    void a(com.obric.cae.libs.cldReport.a r1, int r2, int r3, int r4, int r5, String r6, boolean r7);
}
