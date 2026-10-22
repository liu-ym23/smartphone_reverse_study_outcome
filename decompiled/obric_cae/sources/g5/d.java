package g5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;

/* JADX INFO: loaded from: classes.dex */
public final class d extends b<IDeviceIdManager> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f7646c;

    public class a implements t.b<IDeviceIdManager, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7647a;

        public a(d r8) {
            this.f7647a = r8;
        }

        @Override // g5.t.b
        public final IDeviceIdManager a(IBinder r8) {
            return IDeviceIdManager.Stub.H2(r8);
        }

        @Override // g5.t.b
        public final String b(IDeviceIdManager r8) {
            IDeviceIdManager r10 = r8;
            if (r10 != null) goto L6;
            return null;
        L6:
            return r10.h0(this.f7647a.f7646c.getPackageName());
        }
    }

    public d(Context r8) {
        super("com.coolpad.deviceidsupport");
        this.f7646c = r8;
    }

    @Override // g5.b, g5.m
    public final m.a a(Context r8) {
        String r10 = Settings.Global.getString(r8.getContentResolver(), "coolos.oaid");     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r10) == true) goto L9;
        m.a r11 = new m.a();     // Catch: Throwable -> L6
        r11.f7667a = r10;     // Catch: Throwable -> L6
        return r11;
    L9:
        return super.a(r8);
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    @Override // g5.b
    public final Intent c(Context r8) {
        Intent r10 = new Intent();
        r10.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return r10;
    }

    @Override // g5.b
    public final t.b<IDeviceIdManager, String> d() {
        return new a(this);
    }

    @Override // g5.m
    public final String getName() {
        return "coolpad";
    }
}
