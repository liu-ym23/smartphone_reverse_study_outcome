package luc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import nuc.m2;
import nuc.n2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n {
    public static final m2 a(String r5, e r6) {
        Intrinsics.checkNotNullParameter(r5, "serialName");
        Intrinsics.checkNotNullParameter(r6, "kind");
        if ((!StringsKt.isBlank(r5)) == false) goto L17;
        Map<KClass<? extends Object>, juc.d<? extends Object>> r2 = n2.a;
        Intrinsics.checkNotNullParameter(r5, "serialName");
        Intrinsics.checkNotNullParameter(r6, "kind");
        Iterator<KClass<? extends Object>> r0 = n2.a.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next().getSimpleName();
        Intrinsics.checkNotNull(r1);
        String r3 = n2.a(r1);
        if (StringsKt.equals(r5, "kotlin." + r3, true) == true) goto L13;
        if (StringsKt.equals(r5, r3, true) == false) goto L6;
    L13:
        throw new IllegalArgumentException(StringsKt.trimIndent("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + r5 + " there already exist " + n2.a(r3) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
    L15:
        return new m2(r5, r6);
    L17:
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    @ExperimentalSerializationApi
    public static final q b(String r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "serialName");
        Intrinsics.checkNotNullParameter(r3, "original");
        if ((!StringsKt.isBlank(r2)) == false) goto L15;
        if ((!(r3.getKind() instanceof e)) == false) goto L13;
        if ((!Intrinsics.areEqual(r2, r3.f())) == false) goto L11;
        return new q(r2, r3);
    L11:
        throw new IllegalArgumentException(("The name of the wrapped descriptor (" + r2 + ") cannot be the same as the name of the original descriptor (" + r3.f() + ')').toString());
    L13:
        throw new IllegalArgumentException("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead".toString());
    L15:
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static /* synthetic */ i d(String r1, f[] r2) {
        return c(r1, r2, new m());
    }

    public static final i c(String r7, f[] r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r7, "serialName");
        Intrinsics.checkNotNullParameter(r8, "typeParameters");
        Intrinsics.checkNotNullParameter(r9, "builderAction");
        if ((!StringsKt.isBlank(r7)) == false) goto L7;
        a r6 = new a(r7);
        r9.invoke(r6);
        return new i(r7, p.a.a, ((ArrayList) r6.c).size(), ArraysKt.toList(r8), r6);
    L7:
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static /* synthetic */ i f(String r1, o r2, f[] r3) {
        return e(r1, r2, r3, new l());
    }

    @InternalSerializationApi
    public static final i e(String r7, o r8, f[] r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r7, "serialName");
        Intrinsics.checkNotNullParameter(r8, "kind");
        Intrinsics.checkNotNullParameter(r9, "typeParameters");
        Intrinsics.checkNotNullParameter(r10, "builder");
        if ((!StringsKt.isBlank(r7)) == false) goto L11;
        if ((!Intrinsics.areEqual(r8, p.a.a)) == false) goto L9;
        a r6 = new a(r7);
        r10.invoke(r6);
        return new i(r7, r8, ((ArrayList) r6.c).size(), ArraysKt.toList(r9), r6);
    L9:
        throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
    L11:
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }
}
