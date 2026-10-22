package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements kotlinx.serialization.c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
    @Override // kotlinx.serialization.b
    public final Object a(eu.b r10) {
        Intrinsics.checkNotNullParameter(r10, "decoder");
        kotlinx.serialization.e r5 = (kotlinx.serialization.e) this;
        kotlinx.serialization.descriptors.g r11 = r5.getDescriptor();
        eu.a r12 = r10.i(r11);
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        Object r14 = null;
    L3:
        int r15 = r12.l(r5.getDescriptor());
        if (r15 == (-1)) goto L27;
        if (r15 != 0) goto L7;
        r13.element = r12.k(r5.getDescriptor(), r15);
        goto L3
    L7:
        if (r15 != 1) goto L8;
        T r16 = r13.element;
        if (r16 == 0) goto L25;
        r13.element = r16;
        String r17 = (String) r16;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r12, "decoder");
        kotlinx.serialization.b r18 = b(r12, r17);
        if (r18 == null) goto L17;
        r14 = f4.a.f(r12, r5.getDescriptor(), r15, r18);
        goto L3
    L17:
        KClass r19 = ((kotlinx.serialization.e) this).f19245a;
        Intrinsics.checkNotNullParameter(r19, "baseClass");
        String r20 = "in the scope of '" + r19.getSimpleName() + '\'';
        if (r17 != null) goto L20;
        String r21 = ai.j0.C("Class discriminator was missing and no default polymorphic serializers were registered ", r20);
    L22:
        throw new SerializationException(r21);
    L20:
        StringBuilder r22 = androidx.constraintlayout.motion.widget.a.y("Class '", r17, "' is not registered for polymorphic serialization ", r20, ".\nTo be registered automatically, class '");
        r22.append(r17);
        r22.append("' has to be '@Serializable', and the base class '");
        r22.append(r19.getSimpleName());
        r22.append("' has to be sealed and '@Serializable'.\nAlternatively, register the serializer for '");
        r21 = ai.j0.q(r22, r17, "' explicitly in a corresponding SerializersModule.");
        goto L22
    L25:
        throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
    L8:
        StringBuilder r23 = new StringBuilder("Invalid index in polymorphic deserialization of ");
        String r24 = (String) r13.element;
        if (r24 != null) goto L11;
        r24 = "unknown class";
    L11:
        r23.append(r24);
        r23.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
        r23.append(r15);
        throw new SerializationException(r23.toString());
    L27:
        if (r14 == null) goto L31;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
        r12.u(r11);
        return r14;
    L31:
        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) r13.element)).toString());
    }

    public final kotlinx.serialization.b b(eu.a r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        jk.a r11 = r5.x();
        r11.getClass();
        KClass r12 = ((kotlinx.serialization.e) this).f19245a;
        Intrinsics.checkNotNullParameter(r12, "baseClass");
        Map r13 = (Map) ((Map) r11.d).get(r12);
        kotlinx.serialization.b r14 = null;
        if (r13 == null) goto L5;
        kotlinx.serialization.c r15 = (kotlinx.serialization.c) r13.get(r10);
    L6:
        if (r15 != null) goto L9;
        r15 = null;
    L9:
        if (r15 != null) goto L19;
        Object r16 = ((Map) r11.e).get(r12);
        if (TypeIntrinsics.isFunctionOfArity(r16, 1) == false) goto L14;
        Function1 r17 = (Function1) r16;
    L15:
        if (r17 == null) goto L18;
        r14 = (kotlinx.serialization.b) r17.invoke(r10);
    L18:
        return r14;
    L14:
        r17 = null;
        goto L15
    L19:
        return r15;
    L5:
        r15 = null;
        goto L6
    }
}
