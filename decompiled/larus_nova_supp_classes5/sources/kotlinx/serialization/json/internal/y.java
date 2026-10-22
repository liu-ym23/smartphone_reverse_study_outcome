package kotlinx.serialization.json.internal;

import juc.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class y {
    @JsonFriendModuleApi
    public static final void a(ouc.a r5, z r6, n r7, Object r8) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r6, "writer");
        Intrinsics.checkNotNullParameter(r7, "serializer");
        WriteMode r2 = WriteMode.OBJ;
        ouc.u[] r3 = new ouc.u[WriteMode.getEntries().size()];
        Intrinsics.checkNotNullParameter(r6, "output");
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "modeReuseCache");
        Intrinsics.checkNotNullParameter(r6, "sb");
        Intrinsics.checkNotNullParameter(r5, "json");
        if (r5.a.e == false) goto L5;
        o r0 = new o(r6, r5);
    L6:
        new k0(r0, r5, r2, r3).encodeSerializableValue(r7, r8);
        return;
    L5:
        r0 = new l(r6);
        goto L6
    }
}
