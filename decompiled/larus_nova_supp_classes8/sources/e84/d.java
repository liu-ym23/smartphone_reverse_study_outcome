package e84;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends b<IDeviceIdManager> {
    public final Context c;

    public class a implements u.b<IDeviceIdManager, String> {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // e84.u.b
        public final String a(IDeviceIdManager r2) throws Exception {
            IDeviceIdManager r3 = r2;
            if (r3 != null) goto L6;
            return null;
        L6:
            return r3.getOAID(this.a.c.getPackageName());
        }

        @Override // e84.u.b
        public final IDeviceIdManager b(IBinder r1) {
            return IDeviceIdManager.Stub.asInterface(r1);
        }
    }

    public final String getName() {
        return "coolpad";
    }

    public final u.b<IDeviceIdManager, String> c() {
        return new a(this);
    }

    public d(Context r2) {
        super("com.coolpad.deviceidsupport");
        this.c = r2;
    }

    public final Intent b(Context r4) {
        Intent r5 = new Intent();
        r5.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return r5;
    }

    public final m$a getOaid(Context r3) {
        String r0 = Settings.Global.getString(r3.getContentResolver(), "coolos.oaid");     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r0) == true) goto L9;
        m$a r1 = new m$a();     // Catch: Throwable -> L6
        r1.a = r0;     // Catch: Throwable -> L6
        return r1;
    L9:
        return super.getOaid(r3);
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }
}
