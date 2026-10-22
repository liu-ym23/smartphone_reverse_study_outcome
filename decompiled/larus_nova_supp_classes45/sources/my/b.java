package my;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final DynamicCenterGetType a;
    public final JsonObject b;

    public static final class a {
    }

    static {
    }

    public final DynamicCenterGetType getType() {
        return this.a;
    }

    public b(DynamicCenterGetType r2, String r3, JsonObject r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "bizId");
        this.a = r2;
        this.b = r4;
    }
}
