package g5;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdService;

/* JADX INFO: loaded from: classes.dex */
public final class s extends b<IDeviceIdService> {

    public class a implements t.b<IDeviceIdService, String> {
        @Override // g5.t.b
        public final IDeviceIdService a(IBinder r8) {
            return IDeviceIdService.Stub.H2(r8);
        }

        @Override // g5.t.b
        public final String b(IDeviceIdService r8) {
            return r8.b();
        }
    }

    public s() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // g5.b
    public final Intent c(Context r8) {
        Intent r10 = new Intent();
        r10.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return r10;
    }

    @Override // g5.b
    public final t.b<IDeviceIdService, String> d() {
        return new a();
    }

    @Override // g5.m
    public final String getName() {
        return "Samsung";
    }
}
