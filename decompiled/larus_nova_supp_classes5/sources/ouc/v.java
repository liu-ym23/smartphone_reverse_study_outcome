package ouc;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.modules.d;
import kotlinx.serialization.modules.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v extends a {
    public v(f r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "configuration");
        Intrinsics.checkNotNullParameter(r4, "module");
        super(r3, r4);
        if (Intrinsics.areEqual(r4, i.a) == true) goto L7;
        r4.a(new kotlinx.serialization.json.internal.i0(r3.i, r3.j));
        return;
    }
}
