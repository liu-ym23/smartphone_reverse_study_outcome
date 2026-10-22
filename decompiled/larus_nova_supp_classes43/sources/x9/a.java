package x9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // x9.b
    public final void logV3(String r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "map");
    }

    @Override // x9.b
    public final void t(String r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "map");
    }
}
