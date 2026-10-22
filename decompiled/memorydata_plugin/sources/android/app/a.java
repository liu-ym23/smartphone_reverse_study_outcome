package android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.app.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0004a extends Binder implements a {
        public AbstractBinderC0004a() {
            attachInterface(this, "android.app.ITopActivityAssistDataReceiver");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Bundle r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface("android.app.ITopActivityAssistDataReceiver");
            int r10 = r7.readInt();
            if (r7.readInt() == 0) goto L20;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L20:
            a(r10, r1);
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface("android.app.ITopActivityAssistDataReceiver");
            int r11 = r7.readInt();
            if (r7.readInt() == 0) goto L15;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L15:
            b(r11, r1);
            return true;
        L7:
            if (r6 != 1598968902) goto L9;
            r8.writeString("android.app.ITopActivityAssistDataReceiver");
            return true;
        L9:
            return super.onTransact(r6, r7, r8, r9);
        }
    }

    void a(int r1, Bundle r2);

    void b(int r1, Bundle r2);
}
