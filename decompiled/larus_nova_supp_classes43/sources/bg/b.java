package bg;

import cf.f;
import com.bytedance.android.ec.common.api.IECPendantStateService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements IECPendantStateService {
    public b() {
    }

    @Override // com.bytedance.android.ec.common.api.IECPendantStateService
    public final f getPendantStateListener(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Map<String, f> r0 = a.a;
        return (f) ((LinkedHashMap) a.a).get(r10);
    }

    @Override // com.bytedance.android.ec.common.api.IECPendantStateService
    public final f removePendantStateListener(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Map<String, f> r0 = a.a;
        return a.a.remove(r10);
    }

    @Override // com.bytedance.android.ec.common.api.IECPendantStateService
    public final void addPendantStateListener(String r10, f r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "listener");
        Map<String, f> r0 = a.a;
        a.a.put(r10, r11);
    }
}
