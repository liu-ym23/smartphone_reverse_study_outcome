package e84;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.IDeviceidInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends b<IDeviceidInterface> {

    public class a implements u.b<IDeviceidInterface, String> {
        public a() {
        }

        @Override // e84.u.b
        public final String a(IDeviceidInterface r1) throws Exception {
            IDeviceidInterface r2 = r1;
            if (r2 != null) goto L6;
            return null;
        L6:
            return r2.getOAID();
        }

        @Override // e84.u.b
        public final IDeviceidInterface b(IBinder r1) {
            return IDeviceidInterface.Stub.asInterface(r1);
        }
    }

    public final String getName() {
        return "Lenovo";
    }

    public h() {
        super("com.zui.deviceidservice");
    }

    public final u.b<IDeviceidInterface, String> c() {
        return new a();
    }

    public final Intent b(Context r3) {
        Intent r4 = new Intent();
        r4.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return r4;
    }
}
