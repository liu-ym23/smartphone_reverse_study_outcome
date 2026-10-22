package kotlinx.serialization.json.internal;

import juc.n;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r0 {
    @JsonFriendModuleApi
    public static final <T> ouc.i a(ouc.a r3, T r4, n<? super T> r5) {
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter(r5, "serializer");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        new b0(r3, new q0(r0)).encodeSerializableValue(r5, r4);
        Object r6 = r0.element;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return null;
    L6:
        return (ouc.i) r6;
    }
}
