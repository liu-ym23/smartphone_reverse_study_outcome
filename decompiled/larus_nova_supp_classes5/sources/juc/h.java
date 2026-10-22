package juc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.InternalSerializationApi;
import muc.f;
import nuc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h {
    @InternalSerializationApi
    public static final <T> c<T> a(b<T> r1, muc.c r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "decoder");
        c<T> r4 = r1.a(r2, r3);
        if (r4 == null) goto L5;
        return r4;
    L5:
        nuc.c.a(r3, r1.c());
        throw null;
    }

    @InternalSerializationApi
    public static final <T> n<T> b(b<T> r1, f r2, T r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "encoder");
        Intrinsics.checkNotNullParameter(r3, "value");
        n<T> r4 = r1.b(r2, r3);
        if (r4 != null) goto L9;
        KClass r5 = Reflection.getOrCreateKotlinClass(r3.getClass());
        KClass<T> r6 = r1.c();
        Intrinsics.checkNotNullParameter(r5, "subClass");
        Intrinsics.checkNotNullParameter(r6, "baseClass");
        String r7 = r5.getSimpleName();
        if (r7 != null) goto L7;
        r7 = String.valueOf(r5);
    L7:
        nuc.c.a(r7, r6);
        throw null;
    L9:
        return r4;
    }
}
