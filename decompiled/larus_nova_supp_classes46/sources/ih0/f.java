package ih0;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final View a;
    public final DynamicUpdateType b;
    public final String c;
    public final JsonObject d;

    public static final class a {
    }

    static {
    }

    public final DynamicUpdateType getType() {
        return this.b;
    }

    public f(View r2, DynamicUpdateType r3, String r4, JsonObject r5) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "bizId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
