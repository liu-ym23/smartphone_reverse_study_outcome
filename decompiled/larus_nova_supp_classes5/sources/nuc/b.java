package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import muc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@InternalSerializationApi
public abstract class b<T> implements d<T> {
    public b() {
    }

    public abstract KClass<T> c();

    @Override // juc.c
    public final T deserialize(muc.e r8) {
        Intrinsics.checkNotNullParameter(r8, "decoder");
        luc.f r0 = getDescriptor();
        c r9 = r8.beginStructure(r0);
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        if (r9.decodeSequentially() == false) goto L5;
        T r2 = (T) r9.decodeSerializableElement(getDescriptor(), 1, juc.h.a(this, r9, r9.decodeStringElement(getDescriptor(), 0)), null);
    L23:
        r9.endStructure(r0);
        return r2;
    L5:
        Object r3 = null;
    L6:
        int r5 = r9.decodeElementIndex(getDescriptor());
        if (r5 == (-1)) goto L21;
        if (r5 != 0) goto L9;
        r1.element = r9.decodeStringElement(getDescriptor(), r5);
        goto L6
    L9:
        if (r5 != 1) goto L10;
        Object r4 = r1.element;
        if (r4 == null) goto L19;
        r1.element = r4;
        r3 = r9.decodeSerializableElement(getDescriptor(), r5, juc.h.a(this, r9, (String) r4), null);
        goto L6
    L19:
        throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
    L10:
        StringBuilder r6 = new StringBuilder("Invalid index in polymorphic deserialization of ");
        String r7 = (String) r1.element;
        if (r7 != null) goto L13;
        r7 = "unknown class";
    L13:
        r6.append(r7);
        r6.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
        r6.append(r5);
        throw new SerializationException(r6.toString());
    L21:
        if (r3 == null) goto L26;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
        r2 = (T) r3;
        goto L23
    L26:
        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) r1.element)).toString());
    }

    @InternalSerializationApi
    public juc.c<T> a(c r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return r2.getSerializersModule().e(c(), r3);
    }

    @InternalSerializationApi
    public juc.n<T> b(muc.f r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "encoder");
        Intrinsics.checkNotNullParameter(r3, "value");
        return r2.getSerializersModule().f(c(), r3);
    }

    @Override // juc.n
    public final void serialize(muc.f r6, T r7) {
        Intrinsics.checkNotNullParameter(r6, "encoder");
        Intrinsics.checkNotNullParameter(r7, "value");
        juc.n<? super T> r0 = juc.h.b(this, r6, r7);
        luc.f r1 = getDescriptor();
        muc.d r8 = r6.beginStructure(r1);
        r8.encodeStringElement(getDescriptor(), 0, r0.getDescriptor().f());
        luc.f r2 = getDescriptor();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        r8.encodeSerializableElement(r2, 1, r0, r7);
        r8.endStructure(r1);
    }
}
