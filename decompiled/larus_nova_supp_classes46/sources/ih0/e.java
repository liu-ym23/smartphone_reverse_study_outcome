package ih0;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final DynamicGetType a;
    public final String b;
    public final JsonObject c;

    public static final class a {
    }

    static {
    }

    public final DynamicGetType getType() {
        return this.a;
    }

    public e(DynamicGetType r2, String r3, JsonObject r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "bizId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
