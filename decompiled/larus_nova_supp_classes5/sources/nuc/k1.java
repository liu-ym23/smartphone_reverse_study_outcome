package nuc;

import java.util.Iterator;
import java.util.Map;
import juc.d;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.InternalSerializationApi;
import muc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@InternalSerializationApi
public abstract class k1<Key, Value, Collection, Builder extends Map<Key, Value>> extends a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {
    public final d<Key> a;
    public final d<Value> b;

    @Override // juc.d, juc.n, juc.c
    public abstract luc.f getDescriptor();

    public k1(d r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // juc.n
    public final void serialize(muc.f r8, Collection r9) {
        Intrinsics.checkNotNullParameter(r8, "encoder");
        int r0 = e(r9);
        luc.f r1 = getDescriptor();
        muc.d r10 = r8.beginCollection(r1, r0);
        Iterator<Map.Entry<? extends Key, ? extends Value>> r11 = d(r9);
        int r2 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<? extends Key, ? extends Value> r3 = r11.next();
        Key r4 = r3.getKey();
        Value r5 = r3.getValue();
        int r6 = r2 + 1;
        r10.encodeSerializableElement(getDescriptor(), r2, this.a, r4);
        r10.encodeSerializableElement(getDescriptor(), r6, this.b, r5);
        r2 = r6 + 1;
        goto L4
    L6:
        r10.endStructure(r1);
    }

    @Override // nuc.a
    public final void g(c r5, Object r6, int r7, int r8) {
        Map r9 = (Map) r6;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r9, "builder");
        if (r8 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L17;
        IntProgression r10 = RangesKt.step(RangesKt.until(0, r8 * 2), 2);
        int r2 = r10.getFirst();
        int r3 = r10.getLast();
        int r11 = r10.getStep();
        if (r11 <= 0) goto L10;
        if (r2 > r3) goto L10;
    L12:
        k(r5, r7 + r2, r9, false);
        if (r2 == r3) goto L21;
        r2 = r2 + r11;
        goto L12
    L21:
        return;
    L10:
        if (r11 >= 0) goto L15;
        if (r3 <= r2) goto L12;
        return;
    L15:
        return;
    L17:
        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // nuc.a
    public final /* bridge */ /* synthetic */ void h(c r1, int r2, Object r3, boolean r4) {
        k(r1, r2, (Map) r3, r4);
    }

    public final void k(c r5, int r6, Builder r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r7, "builder");
        Object r0 = r5.decodeSerializableElement(getDescriptor(), r6, this.a, null);
        boolean r1 = true;
        if (r8 == false) goto L12;
        int r9 = r5.decodeElementIndex(getDescriptor());
        if (r9 == (r6 + 1)) goto L8;
        r1 = false;
    L8:
        if (r1 == true) goto L14;
        throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + r6 + ", returned index for value: " + r9).toString());
    L14:
        if (r7.containsKey(r0) == true) goto L16;
    L18:
        Object r10 = r5.decodeSerializableElement(getDescriptor(), r9, this.b, null);
    L19:
        r7.put(r0, r10);
        return;
    L16:
        if ((this.b.getDescriptor().getKind() instanceof luc.e) == true) goto L18;
        r10 = r5.decodeSerializableElement(getDescriptor(), r9, this.b, MapsKt.getValue(r7, r0));
        goto L19
    L12:
        r9 = r6 + 1;
        goto L14
    }
}
