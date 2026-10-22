package rz0;

import com.bytedance.android.live.revenue.platform.log.api.LogDSLMaker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@LogDSLMaker
public final class b {
    public final JSONObject a;

    public b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.a = r2;
    }

    public final void a(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.put(r2, r3);
    }
}
