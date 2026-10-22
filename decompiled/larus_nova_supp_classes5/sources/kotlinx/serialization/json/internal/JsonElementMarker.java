package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import luc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JsonElementMarker {
    public final nuc.d0 a;
    public boolean b;

    public JsonElementMarker(f r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        this.a = new nuc.d0(r3, new JsonElementMarker$origin$1(this));
    }
}
