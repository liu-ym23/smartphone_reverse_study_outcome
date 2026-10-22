package kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import juc.n;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.JsonClassDiscriminator;
import luc.e;
import luc.f;
import luc.o;
import nuc.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h0 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ClassDiscriminatorMode.values().length];
            r0[ClassDiscriminatorMode.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ClassDiscriminatorMode.POLYMORPHIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ClassDiscriminatorMode.ALL_JSON_OBJECTS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final void b(o r1) {
        Intrinsics.checkNotNullParameter(r1, "kind");
        if ((r1 instanceof o.b) == true) goto L14;
        if ((r1 instanceof e) == true) goto L12;
        if ((r1 instanceof luc.d) == true) goto L10;
        return;
    L10:
        throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
    L12:
        throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
    L14:
        throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
    }

    public static final String c(f r2, ouc.a r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "json");
        Iterator<Annotation> r4 = r2.getAnnotations().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        JsonClassDiscriminator r0 = (Annotation) r4.next();
        if ((r0 instanceof JsonClassDiscriminator) == false) goto L4;
        return r0.discriminator();
    L10:
        return r3.a.j;
    }

    public static final void d(String r3, ouc.i r4) {
        Intrinsics.checkNotNullParameter(r4, "element");
        throw new JsonEncodingException("Class with serial name " + r3 + " cannot be serialized polymorphically because it is represented as " + Reflection.getOrCreateKotlinClass(r4.getClass()).getSimpleName() + ". Make sure that its JsonTransformingSerializer returns JsonObject, so class discriminator can be added to it.");
    }

    public static final void a(n r3, n r4, String r5) {
        if ((r3 instanceof juc.l) == false) goto L10;
        f r0 = r4.getDescriptor();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (a2.a(r0).contains(r5) == true) goto L8;
        return;
    L8:
        String r6 = ((juc.l) r3).getDescriptor().f();
        throw new IllegalStateException(("Sealed class '" + r4.getDescriptor().f() + "' cannot be serialized as base class '" + r6 + "' because it has property name that conflicts with JSON class discriminator '" + r5 + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
    }
}
