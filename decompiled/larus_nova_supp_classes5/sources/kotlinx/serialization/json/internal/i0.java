package kotlinx.serialization.json.internal;

import java.util.List;
import juc.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.modules.f;
import luc.e;
import luc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i0 implements kotlinx.serialization.modules.g {
    public final boolean a;
    public final String b;

    @Override // kotlinx.serialization.modules.g
    public final <T> void a(KClass<T> r2, Function1<? super List<? extends juc.d<?>>, ? extends juc.d<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        Intrinsics.checkNotNullParameter(r3, "provider");
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base> void c(KClass<Base> r2, Function1<? super String, ? extends juc.c<? extends Base>> r3) {
        Intrinsics.checkNotNullParameter(r2, "baseClass");
        Intrinsics.checkNotNullParameter(r3, "defaultDeserializerProvider");
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base> void d(KClass<Base> r2, Function1<? super Base, ? extends n<? super Base>> r3) {
        Intrinsics.checkNotNullParameter(r2, "baseClass");
        Intrinsics.checkNotNullParameter(r3, "defaultSerializerProvider");
    }

    public i0(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "discriminator");
        this.a = r2;
        this.b = r3;
    }

    @Override // kotlinx.serialization.modules.g
    public final <T> void b(KClass<T> r2, final juc.d<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        Intrinsics.checkNotNullParameter(r3, "serializer");
        a(r2, new f(r3));
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base, Sub extends Base> void e(KClass<Base> r4, KClass<Sub> r5, juc.d<Sub> r6) {
        Intrinsics.checkNotNullParameter(r4, "baseClass");
        Intrinsics.checkNotNullParameter(r5, "actualClass");
        Intrinsics.checkNotNullParameter(r6, "actualSerializer");
        luc.f r7 = r6.getDescriptor();
        o r8 = r7.getKind();
        if ((r8 instanceof luc.d) == true) goto L30;
        if (Intrinsics.areEqual(r8, o.a.a) == true) goto L30;
        if (this.a == true) goto L18;
        if (Intrinsics.areEqual(r8, luc.p.b.a) == true) goto L28;
        if (Intrinsics.areEqual(r8, luc.p.c.a) == true) goto L28;
        if ((r8 instanceof e) == true) goto L28;
        if ((r8 instanceof o.b) == false) goto L18;
    L28:
        throw new IllegalArgumentException("Serializer for " + r5.getSimpleName() + " of kind " + r8 + " cannot be serialized polymorphically with class discriminator.");
    L18:
        if (this.a == true) goto L26;
        int r9 = r7.d();
        int r0 = 0;
    L20:
        if (r0 >= r9) goto L33;
        String r1 = r7.b(r0);
        if (Intrinsics.areEqual(r1, this.b) == true) goto L25;
        r0 = r0 + 1;
        goto L20
    L25:
        throw new IllegalArgumentException("Polymorphic serializer for " + r5 + " has property '" + r1 + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
    L33:
        return;
    L26:
        return;
    L30:
        throw new IllegalArgumentException("Serializer for " + r5.getSimpleName() + " can't be registered as a subclass for polymorphic serialization because its kind " + r8 + " is not concrete. To work with multiple hierarchies, register it as a base class.");
    }
}
