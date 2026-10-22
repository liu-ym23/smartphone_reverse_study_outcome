package g5;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.IDeviceidInterface;

/* JADX INFO: loaded from: classes.dex */
public final class h extends b<IDeviceidInterface> {

    public class a implements t.b<IDeviceidInterface, String> {
        @Override // g5.t.b
        public final IDeviceidInterface a(IBinder r8) {
            return IDeviceidInterface.Stub.H2(r8);
        }

        @Override // g5.t.b
        public final String b(IDeviceidInterface r8) {
            IDeviceidInterface r10 = r8;
            if (r10 != null) goto L6;
            return null;
        L6:
            return r10.b();
        }
    }

    public h() {
        super("com.zui.deviceidservice");
    }

    @Override // g5.b
    public final Intent c(Context r8) {
        Intent r10 = new Intent();
        r10.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return r10;
    }

    @Override // g5.b
    public final t.b<IDeviceidInterface, String> d() {
        return new a();
    }

    @Override // g5.m
    public final String getName() {
        return "Lenovo";
    }
}
