package g5;

import android.os.IBinder;
import android.util.Pair;
import com.bytedance.bdinstall.oaid.uodis.OpenDeviceIdentifierService;

/* JADX INFO: loaded from: classes.dex */
public final class f implements t.b<OpenDeviceIdentifierService, Pair<String, Boolean>> {
    @Override // g5.t.b
    public final OpenDeviceIdentifierService a(IBinder r8) {
        return OpenDeviceIdentifierService.Stub.H2(r8);
    }

    @Override // g5.t.b
    public final Pair<String, Boolean> b(OpenDeviceIdentifierService r8) {
        OpenDeviceIdentifierService r10 = r8;
        if (r10 != null) goto L6;
        return null;
    L6:
        return new Pair(r10.E2(), Boolean.valueOf(r10.d0()));
    }
}
