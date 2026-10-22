package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class p0 {
    public static final <T> T a(ouc.a r2, String r3, ouc.d0 r4, juc.c<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "discriminator");
        Intrinsics.checkNotNullParameter(r4, "element");
        Intrinsics.checkNotNullParameter(r5, "deserializer");
        return (T) new a0(r2, r4, r3, r5.getDescriptor()).decodeSerializableValue(r5);
    }
}
