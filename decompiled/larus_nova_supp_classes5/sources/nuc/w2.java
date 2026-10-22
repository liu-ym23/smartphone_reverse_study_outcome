package nuc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import muc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@InternalSerializationApi
public abstract class w2<Tag> implements muc.e, c {
    public final ArrayList<Tag> a;
    public boolean b;

    public abstract boolean b(Tag r1);

    public abstract byte c(Tag r1);

    public abstract char d(Tag r1);

    @Override // muc.e
    public final Void decodeNull() {
        return null;
    }

    @Override // muc.c
    @ExperimentalSerializationApi
    public final boolean decodeSequentially() {
        return false;
    }

    @Override // muc.e
    public abstract <T> T decodeSerializableValue(juc.c<? extends T> r1);

    public abstract double e(Tag r1);

    public abstract int f(Tag r1, luc.f r2);

    public abstract float g(Tag r1);

    public abstract muc.e h(Tag r1, luc.f r2);

    public abstract int i(Tag r1);

    public abstract long j(Tag r1);

    public abstract short k(Tag r1);

    public abstract String l(Tag r1);

    public abstract Tag m(luc.f r1, int r2);

    public final Tag n() {
        ArrayList<Tag> r0 = this.a;
        Tag r1 = (Tag) ListProtector.remove(r0, CollectionsKt.getLastIndex(r0));
        this.b = true;
        return r1;
    }

    public w2() {
        this.a = new ArrayList();
    }

    @Override // muc.e
    public final boolean decodeBoolean() {
        return b(n());
    }

    @Override // muc.e
    public final byte decodeByte() {
        return c(n());
    }

    @Override // muc.e
    public final char decodeChar() {
        return d(n());
    }

    @Override // muc.e
    public final double decodeDouble() {
        return e(n());
    }

    @Override // muc.e
    public final float decodeFloat() {
        return g(n());
    }

    @Override // muc.e
    public final int decodeInt() {
        return i(n());
    }

    @Override // muc.e
    public final long decodeLong() {
        return j(n());
    }

    @Override // muc.e
    public final short decodeShort() {
        return k(n());
    }

    @Override // muc.e
    public final String decodeString() {
        return l(n());
    }

    @Override // muc.c
    public final int decodeCollectionSize(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return -1;
    }

    @Override // muc.e
    public final int decodeEnum(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "enumDescriptor");
        return f(n(), r2);
    }

    @Override // muc.e
    public muc.e decodeInline(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return h(n(), r2);
    }

    @Override // muc.c
    public final boolean decodeBooleanElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return b(m(r2, r3));
    }

    @Override // muc.c
    public final byte decodeByteElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return c(m(r2, r3));
    }

    @Override // muc.c
    public final char decodeCharElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return d(m(r2, r3));
    }

    @Override // muc.c
    public final double decodeDoubleElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return e(m(r2, r3));
    }

    @Override // muc.c
    public final float decodeFloatElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return g(m(r2, r3));
    }

    @Override // muc.c
    public final muc.e decodeInlineElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return h(m(r2, r3), ((d1) r2).h(r3));
    }

    @Override // muc.c
    public final int decodeIntElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return i(m(r2, r3));
    }

    @Override // muc.c
    public final long decodeLongElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return j(m(r2, r3));
    }

    @Override // muc.c
    public final short decodeShortElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return k(m(r2, r3));
    }

    @Override // muc.c
    public final String decodeStringElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return l(m(r2, r3));
    }

    @Override // muc.c
    public final <T> T decodeNullableSerializableElement(luc.f r1, int r2, juc.c<? extends T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        Intrinsics.checkNotNullParameter(r3, "deserializer");
        this.a.add(m(r1, r2));
        Intrinsics.checkNotNullParameter(this, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$deserializer");
        if (r3.getDescriptor().a() == false) goto L5;
    L8:
        Intrinsics.checkNotNullParameter(r3, "deserializer");
        T r5 = (T) decodeSerializableValue(r3);
    L10:
        if (this.b == true) goto L12;
        n();
    L12:
        this.b = false;
        return r5;
    L5:
        if (decodeNotNullMark() == true) goto L8;
        r5 = null;
        goto L10
    }

    @Override // muc.c
    public final <T> T decodeSerializableElement(luc.f r1, int r2, juc.c<? extends T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        Intrinsics.checkNotNullParameter(r3, "deserializer");
        Tag r5 = m(r1, r2);
        this.a.add(r5);
        Intrinsics.checkNotNullParameter(this, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$deserializer");
        Intrinsics.checkNotNullParameter(r3, "deserializer");
        T r6 = (T) decodeSerializableValue(r3);
        if (this.b == true) goto L5;
        n();
    L5:
        this.b = false;
        return r6;
    }
}
