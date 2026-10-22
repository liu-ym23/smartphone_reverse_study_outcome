package vendor.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.text.Typography;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes8.dex */
public interface b extends IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f20317b = 1;
    public static final String c = "44ab3fe75b6d6bed13a14ac4fb590d4501db5c40";
    public static final String d = null;

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: vendor.a.a.b$a$a, reason: collision with other inner class name */
        public static class C0907a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f20318a;
            private int e;
            private String f;

            public C0907a(IBinder r3) {
                IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
                this.e = -1;
                this.f = StructuredDataId.RESERVED;
                this.f20318a = r4;
            }

            @Override // vendor.a.a.b
            public int a() {
                if (this.e != (-1)) goto L11;
                Parcel r0 = Parcel.obtain(asBinder());
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(b.d);     // Catch: Throwable -> L7
                this.f20318a.transact(ViewCompat.MEASURED_SIZE_MASK, r0, r1, 0);     // Catch: Throwable -> L7
                r1.readException();     // Catch: Throwable -> L7
                this.e = r1.readInt();     // Catch: Throwable -> L7
                r1.recycle();
                r0.recycle();
            L7:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L11:
                return this.e;
            }

            @Override // vendor.a.a.b
            public void a(int r3, int r4, int r5, int r6, int r7) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken(b.d);     // Catch: Throwable -> L9
                r0.writeInt(r3);     // Catch: Throwable -> L9
                r0.writeInt(r4);     // Catch: Throwable -> L9
                r0.writeInt(r5);     // Catch: Throwable -> L9
                r0.writeInt(r6);     // Catch: Throwable -> L9
                r0.writeInt(r7);     // Catch: Throwable -> L9
                if (this.f20318a.transact(1, r0, null, 1) == false) goto L8;
                r0.recycle();
                return;
            L8:
                throw new RemoteException("Method onDbUpdateResult is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // vendor.a.a.b
            public void a(int r3, int r4, int r5, int r6, long r7, int r9) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken(b.d);     // Catch: Throwable -> L9
                r0.writeInt(r3);     // Catch: Throwable -> L9
                r0.writeInt(r4);     // Catch: Throwable -> L9
                r0.writeInt(r5);     // Catch: Throwable -> L9
                r0.writeInt(r6);     // Catch: Throwable -> L9
                r0.writeLong(r7);     // Catch: Throwable -> L9
                r0.writeInt(r9);     // Catch: Throwable -> L9
                if (this.f20318a.transact(3, r0, null, 1) == false) goto L8;
                r0.recycle();
                return;
            L8:
                throw new RemoteException("Method onCellPoiStatusChange is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // vendor.a.a.b
            public void a(int r3, int r4, int r5, boolean r6, int r7) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken(b.d);     // Catch: Throwable -> L9
                r0.writeInt(r3);     // Catch: Throwable -> L9
                r0.writeInt(r4);     // Catch: Throwable -> L9
                r0.writeInt(r5);     // Catch: Throwable -> L9
                r0.writeBoolean(r6);     // Catch: Throwable -> L9
                r0.writeInt(r7);     // Catch: Throwable -> L9
                if (this.f20318a.transact(2, r0, null, 1) == false) goto L8;
                r0.recycle();
                return;
            L8:
                throw new RemoteException("Method onStartOemSensorResult is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20318a;
            }

            @Override // vendor.a.a.b
            public synchronized String b() {
                monitor-enter(this);
            L14:
                th = move-exception;
                throw th;
            L4:
                if (StructuredDataId.RESERVED.equals(this.f) == false) goto L11;
                Parcel r0 = Parcel.obtain(asBinder());     // Catch: Throwable -> L14
                Parcel r1 = Parcel.obtain();     // Catch: Throwable -> L14
                r0.writeInterfaceToken(b.d);     // Catch: Throwable -> L8
                this.f20318a.transact(16777214, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                this.f = r1.readString();     // Catch: Throwable -> L8
                r1.recycle();     // Catch: Throwable -> L14
                r0.recycle();     // Catch: Throwable -> L14
                goto L11
            L8:
                th = move-exception;
                r1.recycle();     // Catch: Throwable -> L14
                r0.recycle();     // Catch: Throwable -> L14
                throw th;     // Catch: Throwable -> L14
            L11:
                String r2 = this.f;     // Catch: Throwable -> L14
                monitor-exit(this);
                return r2;
            }
        }

        public a() {
            markVintfStability();
            attachInterface(this, b.d);
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(b.d);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0907a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r20, Parcel r21, Parcel r22, int r23) {
            String r2 = b.d;
            if (r20 < 1) goto L8;
            if (r20 > 16777215) goto L8;
            r21.enforceInterface(r2);
        L8:
            if (r20 != 1598968902) goto L11;
            r22.writeString(r2);
            return true;
        L11:
            if (r20 != 16777215) goto L15;
            r22.writeNoException();
            r22.writeInt(a());
            return true;
        L15:
            if (r20 != 16777214) goto L18;
            r22.writeNoException();
            r22.writeString(b());
            return true;
        L18:
            if (r20 != 1) goto L20;
            int r6 = r21.readInt();
            int r7 = r21.readInt();
            int r8 = r21.readInt();
            int r9 = r21.readInt();
            int r10 = r21.readInt();
            r21.enforceNoDataAvail();
            a(r6, r7, r8, r9, r10);
        L28:
            return true;
        L20:
            if (r20 != 2) goto L22;
            int r14 = r21.readInt();
            int r15 = r21.readInt();
            int r16 = r21.readInt();
            boolean r17 = r21.readBoolean();
            int r18 = r21.readInt();
            r21.enforceNoDataAvail();
            a(r14, r15, r16, r17, r18);
            goto L28
        L22:
            if (r20 != 3) goto L24;
            int r11 = r21.readInt();
            int r12 = r21.readInt();
            int r13 = r21.readInt();
            int r19 = r21.readInt();
            long r110 = r21.readLong();
            int r111 = r21.readInt();
            r21.enforceNoDataAvail();
            a(r11, r12, r13, r19, r110, r111);
            goto L28
        L24:
            return super.onTransact(r20, r21, r22, r23);
        }
    }

    static {
        d = "vendor$bytedance$wwansensor$ISensorNotifyCallback".replace(Typography.dollar, '.');
    }

    int a();

    void a(int r1, int r2, int r3, int r4, int r5);

    void a(int r1, int r2, int r3, int r4, long r5, int r7);

    void a(int r1, int r2, int r3, boolean r4, int r5);

    String b();
}
