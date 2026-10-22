package py8;

import android.companion.CompanionDeviceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class e extends d {
    public e(CompanionDeviceManager r2) {
        Intrinsics.checkNotNullParameter(r2, "companionDeviceManager");
        super(r2);
    }

    @Override // py8.d, py8.b
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "deviceAddress");
        this.a.stopObservingDevicePresence(r2);
    }

    @Override // py8.d, py8.b
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "deviceAddress");
        this.a.startObservingDevicePresence(r2);
    }
}
