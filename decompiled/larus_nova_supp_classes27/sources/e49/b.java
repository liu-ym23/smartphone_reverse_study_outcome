package e49;

import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final OTAUpdatePackage a(a r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        z39.a r2 = r1.a;
        if (r2 == null) goto L7;
        List<OTAUpdatePackage> r3 = r2.b();
        if (r3 == null) goto L7;
        return (OTAUpdatePackage) CollectionsKt.firstOrNull(r3);
    L7:
        return null;
    }
}
