package z60;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final c a;

    public b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "updateStrategy");
        this.a = r2;
    }

    public final boolean update(JsonObject r2, JsonObject r3, c70.a r4) {
        return this.a.update(r2, r3, r4);
    }
}
