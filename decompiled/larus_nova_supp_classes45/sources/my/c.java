package my;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final DynamicCenterUpdateType a;
    public final JsonObject b;

    public static final class a {
    }

    static {
    }

    public final DynamicCenterUpdateType getType() {
        return this.a;
    }

    public c(DynamicCenterUpdateType r2, String r3, JsonObject r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "bizId");
        this.a = r2;
        this.b = r4;
    }
}
