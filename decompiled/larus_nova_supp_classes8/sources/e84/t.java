package e84;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t extends b<IDeviceIdService> {

    public class a implements u.b<IDeviceIdService, String> {
        public a() {
        }

        @Override // e84.u.b
        public final String a(IDeviceIdService r1) throws Exception {
            return r1.getOAID();
        }

        @Override // e84.u.b
        public final IDeviceIdService b(IBinder r1) {
            return IDeviceIdService.Stub.asInterface(r1);
        }
    }

    public final String getName() {
        return "Samsung";
    }

    public t() {
        super("com.samsung.android.deviceidservice");
    }

    public final u.b<IDeviceIdService, String> c() {
        return new a();
    }

    public final Intent b(Context r3) {
        Intent r4 = new Intent();
        r4.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return r4;
    }
}
