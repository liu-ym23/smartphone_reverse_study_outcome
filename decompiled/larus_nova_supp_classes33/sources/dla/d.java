package dla;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements h37.e {
    public d() {
    }

    public final SharedPreferences a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return new c(r2, r3);
    }
}
