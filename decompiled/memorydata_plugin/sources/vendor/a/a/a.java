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
public interface a extends IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20315a = null;

    /* JADX INFO: renamed from: vendor.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0905a extends Binder implements a {

        /* JADX INFO: renamed from: vendor.a.a.a$a$a, reason: collision with other inner class name */
        public static class C0906a implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f20316b;
            private int c;
            private String d;

            public C0906a(IBinder r3) {
                IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
                this.c = -1;
                this.d = StructuredDataId.RESERVED;
                this.f20316b = r4;
            }

            @Override // vendor.a.a.a
            public int a() {
                if (this.c != (-1)) goto L11;
                Parcel r0 = Parcel.obtain(asBinder());
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(a.f20315a);     // Catch: Throwable -> L7
                this.f20316b.transact(ViewCompat.MEASURED_SIZE_MASK, r0, r1, 0);     // Catch: Throwable -> L7
                r1.readException();     // Catch: Throwable -> L7
                this.c = r1.readInt();     // Catch: Throwable -> L7
                r1.recycle();
                r0.recycle();
            L7:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L11:
                return this.c;
            }

            @Override // vendor.a.a.a
            public int a(b r4) {
                b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain(asBinder());
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(a.f20315a);     // Catch: Throwable -> L10
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L10
                if (this.f20316b.transact(1, r0, r1, 0) == false) goto L9;
                r1.readException();     // Catch: Throwable -> L10
                int r3 = r1.readInt();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r3;
            L9:
                throw new RemoteException("Method registerCallback is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // vendor.a.a.a
            public void a(int r4) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken(a.f20315a);     // Catch: Throwable -> L9
                r0.writeInt(r4);     // Catch: Throwable -> L9
                if (this.f20316b.transact(2, r0, null, 1) == false) goto L8;
                r0.recycle();
                return;
            L8:
                throw new RemoteException("Method unregisterCallback is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // vendor.a.a.a
            public void a(int r3, int r4, int r5, int r6) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken(a.f20315a);     // Catch: Throwable -> L9
                r0.writeInt(r3);     // Catch: Throwable -> L9
                r0.writeInt(r4);     // Catch: Throwable -> L9
                r0.writeInt(r5);     // Catch: Throwable -> L9
                r0.writeInt(r6);     // Catch: Throwable -> L9
                if (this.f20316b.transact(3, r0, null, 1) == false) goto L8;
                r0.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyDbUpdate is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // vendor.a.a.a
            public void a(int r3, int r4, int r5, boolean r6) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken(a.f20315a);     // Catch: Throwable -> L9
                r0.writeInt(r3);     // Catch: Throwable -> L9
                r0.writeInt(r4);     // Catch: Throwable -> L9
                r0.writeInt(r5);     // Catch: Throwable -> L9
                r0.writeBoolean(r6);     // Catch: Throwable -> L9
                if (this.f20316b.transact(4, r0, null, 1) == false) goto L8;
                r0.recycle();
                return;
            L8:
                throw new RemoteException("Method startOemSensor is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20316b;
            }

            @Override // vendor.a.a.a
            public synchronized String b() {
                monitor-enter(this);
            L14:
                th = move-exception;
                throw th;
            L4:
                if (StructuredDataId.RESERVED.equals(this.d) == false) goto L11;
                Parcel r0 = Parcel.obtain(asBinder());     // Catch: Throwable -> L14
                Parcel r1 = Parcel.obtain();     // Catch: Throwable -> L14
                r0.writeInterfaceToken(a.f20315a);     // Catch: Throwable -> L8
                this.f20316b.transact(16777214, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                this.d = r1.readString();     // Catch: Throwable -> L8
                r1.recycle();     // Catch: Throwable -> L14
                r0.recycle();     // Catch: Throwable -> L14
                goto L11
            L8:
                th = move-exception;
                r1.recycle();     // Catch: Throwable -> L14
                r0.recycle();     // Catch: Throwable -> L14
                throw th;     // Catch: Throwable -> L14
            L11:
                String r2 = this.d;     // Catch: Throwable -> L14
                monitor-exit(this);
                return r2;
            }
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(a.f20315a);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0906a(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            String r0 = a.f20315a;
            if (r5 < 1) goto L7;
            if (r5 > 16777215) goto L7;
            r6.enforceInterface(r0);
        L7:
            if (r5 != 1598968902) goto L10;
            r7.writeString(r0);
            return true;
        L10:
            if (r5 != 16777215) goto L14;
            r7.writeNoException();
            r7.writeInt(a());
            return true;
        L14:
            if (r5 != 16777214) goto L17;
            r7.writeNoException();
            r7.writeString(b());
            return true;
        L17:
            if (r5 != 1) goto L19;
            b r9 = b.a.a(r6.readStrongBinder());
            r6.enforceNoDataAvail();
            int r4 = a(r9);
            r7.writeNoException();
            r7.writeInt(r4);
        L30:
            return true;
        L19:
            if (r5 != 2) goto L21;
            int r10 = r6.readInt();
            r6.enforceNoDataAvail();
            a(r10);
            goto L30
        L21:
            if (r5 != 3) goto L23;
            int r11 = r6.readInt();
            int r12 = r6.readInt();
            int r13 = r6.readInt();
            int r1 = r6.readInt();
            r6.enforceNoDataAvail();
            a(r11, r12, r13, r1);
            goto L30
        L23:
            if (r5 != 4) goto L25;
            int r14 = r6.readInt();
            int r15 = r6.readInt();
            int r16 = r6.readInt();
            boolean r2 = r6.readBoolean();
            r6.enforceNoDataAvail();
            a(r14, r15, r16, r2);
            goto L30
        L25:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    static {
        f20315a = "vendor$bytedance$wwansensor$ISensorNotify".replace(Typography.dollar, '.');
    }

    int a();

    int a(b r1);

    void a(int r1);

    void a(int r1, int r2, int r3, int r4);

    void a(int r1, int r2, int r3, boolean r4);

    String b();
}
