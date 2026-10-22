package nuc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@InternalSerializationApi
public abstract class x2<Tag> implements muc.f, d {
    public final ArrayList<Tag> a;

    public abstract void b(Tag r1, boolean r2);

    public abstract void c(Tag r1, byte r2);

    public abstract void d(Tag r1, char r2);

    public abstract void e(Tag r1, double r2);

    @Override // muc.f
    public abstract <T> void encodeSerializableValue(juc.n<? super T> r1, T r2);

    public abstract void f(Tag r1, luc.f r2, int r3);

    public abstract void g(Tag r1, float r2);

    public abstract muc.f h(Tag r1, luc.f r2);

    public abstract void i(Tag r1, int r2);

    public abstract void j(Tag r1, long r2);

    public abstract void k(Tag r1, short r2);

    public abstract void l(Tag r1, String r2);

    public abstract void m(luc.f r1);

    public abstract Tag n(luc.f r1, int r2);

    public final Tag o() {
        if ((!this.a.isEmpty()) == false) goto L7;
        ArrayList<Tag> r0 = this.a;
        return (Tag) ListProtector.remove(r0, CollectionsKt.getLastIndex(r0));
    L7:
        throw new SerializationException("No tag in stack for requested element");
    }

    public x2() {
        this.a = new ArrayList();
    }

    @Override // muc.f
    public final void encodeBoolean(boolean r2) {
        b(o(), r2);
    }

    @Override // muc.f
    public final void encodeByte(byte r2) {
        c(o(), r2);
    }

    @Override // muc.f
    public final void encodeChar(char r2) {
        d(o(), r2);
    }

    @Override // muc.f
    public final void encodeDouble(double r2) {
        e(o(), r2);
    }

    @Override // muc.f
    public final void encodeFloat(float r2) {
        g(o(), r2);
    }

    @Override // muc.f
    public muc.f encodeInline(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return h(o(), r2);
    }

    @Override // muc.f
    public final void encodeInt(int r2) {
        i(o(), r2);
    }

    @Override // muc.f
    public final void encodeLong(long r2) {
        j(o(), r2);
    }

    @Override // muc.f
    public final void encodeShort(short r2) {
        k(o(), r2);
    }

    @Override // muc.f
    public final void encodeString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        l(o(), r2);
    }

    @Override // muc.d
    public final void endStructure(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if ((!this.a.isEmpty()) == false) goto L5;
        o();
    L5:
        m(r2);
    }

    @Override // muc.f
    public final d beginCollection(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return beginStructure(r1);
    }

    @Override // muc.f
    public final void encodeEnum(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "enumDescriptor");
        f(o(), r2, r3);
    }

    @Override // muc.d
    public final muc.f encodeInlineElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return h(n(r2, r3), ((d1) r2).h(r3));
    }

    @Override // muc.d
    public final void encodeBooleanElement(luc.f r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        b(n(r2, r3), r4);
    }

    @Override // muc.d
    public final void encodeByteElement(luc.f r2, int r3, byte r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        c(n(r2, r3), r4);
    }

    @Override // muc.d
    public final void encodeCharElement(luc.f r2, int r3, char r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        d(n(r2, r3), r4);
    }

    @Override // muc.d
    public final void encodeDoubleElement(luc.f r2, int r3, double r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        e(n(r2, r3), r4);
    }

    @Override // muc.d
    public final void encodeFloatElement(luc.f r2, int r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        g(n(r2, r3), r4);
    }

    @Override // muc.d
    public final void encodeIntElement(luc.f r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        i(n(r2, r3), r4);
    }

    @Override // muc.d
    public final void encodeLongElement(luc.f r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        j(n(r2, r3), r4);
    }

    @Override // muc.d
    public final void encodeShortElement(luc.f r2, int r3, short r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        k(n(r2, r3), r4);
    }

    @Override // muc.d
    public final void encodeStringElement(luc.f r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "value");
        l(n(r2, r3), r4);
    }

    public <T> void encodeNullableSerializableElement(luc.f r2, int r3, juc.n<? super T> r4, T r5) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "serializer");
        Tag r6 = n(r2, r3);
        this.a.add(r6);
        muc.f.a.a(this, r4, r5);
    }

    @Override // muc.d
    public final <T> void encodeSerializableElement(luc.f r2, int r3, juc.n<? super T> r4, T r5) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "serializer");
        Tag r6 = n(r2, r3);
        this.a.add(r6);
        encodeSerializableValue(r4, r5);
    }
}
