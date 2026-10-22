package wy0;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class c<P extends j<P>, R> extends com.bytedance.ies.web.jsbridge2.g<Object, R> {
    public abstract Type j();

    public abstract R k(P r1, CallContext r2);

    public c() {
    }

    public final R invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callContext");
        if ((r3 instanceof JsonObject) == false) goto L5;
        Type r0 = j();
        JsonObject r5 = (JsonObject) r3;
        Intrinsics.checkNotNullParameter(r0, "metaType");
        Intrinsics.checkNotNullParameter(r5, "json");
        return k((j) GsonProtectorUtils.fromJson(l97.a.a, r5, r0), r4);
    L5:
        Intrinsics.checkNotNullParameter(r3, "$this$isSerializableObject");
        if ((r3 instanceof j) == false) goto L10;
        return k((j) r3, r4);
    L10:
        throw new IllegalArgumentException("blame lifengji for more help");
    }
}
