package nuc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a2 {
    public static final luc.f[] a = null;

    static {
        a = new luc.f[0];
    }

    public static final Set<String> a(luc.f r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((r4 instanceof n) == true) goto L5;
        HashSet r0 = new HashSet(r4.d());
        int r1 = r4.d();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r0.add(r4.b(r2));
        r2 = r2 + 1;
        goto L7
    L9:
        return r0;
    L5:
        return ((n) r4).c();
    }

    public static final luc.f[] b(List<? extends luc.f> r2) {
        List<? extends luc.f> r0 = r2;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L16;
        luc.f[] r3 = (luc.f[]) r2.toArray(new luc.f[0]);
        if (r3 == null) goto L16;
        return r3;
    L16:
        return a;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final KClass<Object> c(KType r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        KClass<Object> r4 = r3.getClassifier();
        if ((r4 instanceof KClass) == false) goto L7;
        return r4;
    L7:
        if ((r4 instanceof KTypeParameter) == false) goto L11;
        throw new IllegalArgumentException("Captured type parameter " + r4 + " from generic non-reified function. Such functionality cannot be supported because " + r4 + " is erased, either specify serializer explicitly or make calling function inline with reified " + r4 + '.');
    L11:
        throw new IllegalArgumentException("Only KClass supported as classifier, got " + r4);
    }

    public static final void d(KClass r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r4 = r3.getSimpleName();
        if (r4 != null) goto L5;
        r4 = "<local class name not available>";
    L5:
        Intrinsics.checkNotNullParameter(r4, "className");
        throw new SerializationException("Serializer for class '" + r4 + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n");
    }
}
