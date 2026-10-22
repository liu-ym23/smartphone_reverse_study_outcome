package py8;

import com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements b {
    public g() {
    }

    @Override // py8.b
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macAddress");
    }

    @Override // py8.b
    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macAddress");
        return false;
    }

    @Override // py8.b
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "deviceAddress");
    }

    @Override // py8.b
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "deviceAddress");
    }

    @Override // py8.b
    public final List<String> e() {
        return CollectionsKt.emptyList();
    }

    @Override // py8.b
    public final void c(String r2, FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "macAddress");
        Intrinsics.checkNotNullParameter(r3, "callback");
        r3.a("companion device not support or companion device manager null ");
    }
}
