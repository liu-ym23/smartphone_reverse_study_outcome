package ouc;

import juc.d;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import luc.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r implements d<i> {
    public static final r a = null;
    public static final i b = null;

    public r() {
    }

    static {
        a = new r();
        b = luc.n.e("kotlinx.serialization.json.JsonElement", luc.d.b.a, new luc.f[0], new l());
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return t.a(r2).a();
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        i r4 = (i) r3;
        Intrinsics.checkNotNullParameter(r2, "encoder");
        Intrinsics.checkNotNullParameter(r4, "value");
        t.b(r2);
        if ((r4 instanceof g0) == false) goto L6;
        r2.encodeSerializableValue(h0.a, r4);
        return;
    L6:
        if ((r4 instanceof d0) == false) goto L9;
        r2.encodeSerializableValue(f0.a, r4);
        return;
    L9:
        if ((r4 instanceof b) == false) goto L13;
        r2.encodeSerializableValue(d.a, r4);
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
