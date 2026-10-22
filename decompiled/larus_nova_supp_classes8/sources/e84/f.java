package e84;

import android.os.IBinder;
import android.util.Pair;
import com.bytedance.bdinstall.oaid.uodis.OpenDeviceIdentifierService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements u.b<OpenDeviceIdentifierService, Pair<String, Boolean>> {
    public f() {
    }

    @Override // e84.u.b
    public final Pair<String, Boolean> a(OpenDeviceIdentifierService r3) throws Exception {
        OpenDeviceIdentifierService r4 = r3;
        if (r4 != null) goto L6;
        return null;
    L6:
        return new Pair(r4.getOaid(), Boolean.valueOf(r4.isOaidTrackLimited()));
    }

    @Override // e84.u.b
    public final OpenDeviceIdentifierService b(IBinder r1) {
        return OpenDeviceIdentifierService.Stub.asInterface(r1);
    }
}
