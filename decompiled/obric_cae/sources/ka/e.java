package ka;

import ha.b0;
import ha.c0;
import ha.d0;
import ha.w;

/* JADX INFO: loaded from: classes.dex */
public final class e implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ja.i f8995a;

    public e(ja.i r8) {
        this.f8995a = r8;
    }

    public static c0 b(ja.i r8, ha.j r10, oa.a r11, ia.a r12) {
        Object r13 = r8.b(oa.a.get(r12.value())).b();
        boolean r14 = r12.nullSafe();
        if ((r13 instanceof c0) == false) goto L6;
        c0 r15 = (c0) r13;
    L24:
        if (r15 == null) goto L28;
        if (r14 == true) goto L27;
        return r15;
    L27:
        return new b0(r15);
    L28:
        return r15;
    L6:
        if ((r13 instanceof d0) == false) goto L8;
        r15 = ((d0) r13).a(r10, r11);
        goto L24
    L8:
        boolean r16 = r13 instanceof w;
        if (r16 == true) goto L16;
        if ((r13 instanceof ha.o) == true) goto L16;
        throw new IllegalArgumentException("Invalid attempt to bind an instance of " + r13.getClass().getName() + " as a @JsonAdapter for " + r11.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    L16:
        if (r16 == false) goto L18;
        w r17 = (w) r13;
    L20:
        if ((r13 instanceof ha.o) == false) goto L22;
        ha.o r18 = (ha.o) r13;
    L23:
        r15 = new p(r17, r18, r10, r11, null, r14);
        r14 = false;
        goto L24
    L22:
        r18 = null;
        goto L23
    L18:
        r17 = null;
        goto L20
    }

    @Override // ha.d0
    public final <T> c0<T> a(ha.j r8, oa.a<T> r10) {
        ia.a r11 = (ia.a) r10.getRawType().getAnnotation(ia.a.class);
        if (r11 != null) goto L7;
        return null;
    L7:
        return b(this.f8995a, r8, r10, r11);
    }
}
