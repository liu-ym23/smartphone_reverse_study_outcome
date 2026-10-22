package e84;

import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.IOAIDService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class g$a implements u.b<IOAIDService, String> {
    public final /* synthetic */ g a;

    public g$a(g r1) {
        this.a = r1;
    }

    @Override // e84.u.b
    public final String a(IOAIDService r2) throws Exception {
        IOAIDService r3 = r2;
        if (r3 != null) goto L5;
        com.bytedance.bdinstall.t.b("honor# service is null");
        return null;
    L5:
        r3.getOAID(this.a.c);
        r3.isOAIDTrackingLimited(this.a.d);
        return "";
    }

    @Override // e84.u.b
    public final IOAIDService b(IBinder r1) {
        return IOAIDService.Stub.asInterface(r1);
    }
}
