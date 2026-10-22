package kotlinx.serialization.json.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import luc.f;
import luc.o;
import nuc.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class a0 extends c {
    public final ouc.d0 f;
    public final f g;
    public int h;
    public boolean i;

    @Override // kotlinx.serialization.json.internal.c, muc.e
    public final boolean decodeNotNullMark() {
        if (this.i == false) goto L5;
    L7:
        return false;
    L5:
        if (super.decodeNotNullMark() == false) goto L7;
        return true;
    }

    @Override // kotlinx.serialization.json.internal.c
    public /* bridge */ /* synthetic */ ouc.i t() {
        return w();
    }

    public ouc.d0 w() {
        return this.f;
    }

    @Override // kotlinx.serialization.json.internal.c, muc.e
    public final muc.c beginStructure(f r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        if (r5 != this.g) goto L11;
        ouc.a r0 = this.c;
        ouc.d0 r1 = s();
        String r2 = this.g.f();
        if ((r1 instanceof ouc.d0) == false) goto L9;
        return new a0(r0, r1, this.d, this.g);
    L9:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.d0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r1.getClass()).getSimpleName() + " as the serialized body of " + r2 + " at element: " + q(), r1.toString());
    L11:
        return super.beginStructure(r5);
    }

    @Override // muc.c
    public int decodeElementIndex(f r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
    L4:
        if (this.h >= r10.d()) goto L55;
        int r0 = this.h;
        this.h = r0 + 1;
        String r1 = p(r10, r0);
        boolean r2 = true;
        int r3 = this.h - 1;
        this.i = false;
        if (w().containsKey(r1) == true) goto L18;
        if (this.c.a.f == false) goto L10;
    L14:
        boolean r4 = false;
    L15:
        this.i = r4;
        if (r4 == false) goto L4;
    L10:
        if (r10.i(r3) == true) goto L14;
        if (r10.h(r3).a() == false) goto L14;
        r4 = true;
    L18:
        if (this.e.h == false) goto L54;
        ouc.a r5 = this.c;
        boolean r6 = r10.i(r3);
        f r7 = r10.h(r3);
        if (r6 == false) goto L27;
        if (r7.a() == true) goto L27;
        if ((r(r1) instanceof ouc.a0) == false) goto L27;
    L53:
        if (r2 == true) goto L4;
    L27:
        if (Intrinsics.areEqual(r7.getKind(), o.b.a) == true) goto L29;
    L52:
        r2 = false;
        goto L53
    L29:
        if (r7.a() == true) goto L31;
    L33:
        ouc.g0 r8 = r(r1);
        String r9 = null;
        if ((r8 instanceof ouc.g0) == false) goto L36;
        ouc.g0 r11 = r8;
    L37:
        if (r11 == null) goto L39;
        r9 = ouc.k.g(r11);
    L39:
        if (r9 == null) goto L52;
        int r12 = u.c(r7, r5, r9);
        if (r5.a.f == false) goto L44;
    L46:
        boolean r13 = false;
    L48:
        if (r12 != (-3)) goto L52;
        if (r6 == true) goto L53;
        if (r13 == false) goto L52;
    L44:
        if (r7.a() == false) goto L46;
        r13 = true;
        goto L48
    L36:
        r11 = null;
        goto L37
    L31:
        if ((r(r1) instanceof ouc.a0) == false) goto L33;
    L54:
        return r3;
    L55:
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.c, muc.c
    public void endStructure(f r4) {
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        if (this.e.b == false) goto L5;
        return;
    L5:
        if ((r4.getKind() instanceof luc.d) == true) goto L34;
        u.e(r4, this.c);
        if (this.e.l == true) goto L10;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Set<String> r5 = a2.a(r4);
    L17:
        Iterator r0 = w().keySet().iterator();
    L19:
        if (r0.hasNext() == false) goto L35;
        String r1 = (String) r0.next();
        if (r5.contains(r1) == true) goto L19;
        if (Intrinsics.areEqual(r1, this.d) == true) goto L19;
        String r6 = w().toString();
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r6, "input");
        throw s.c(-1, "Encountered an unknown key '" + r1 + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + s.f(r6, -1));
    L35:
        return;
    L10:
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Set<String> r2 = a2.a(r4);
        ouc.a r3 = this.c;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map r7 = (Map) r3.c.a(r4, u.a);
        if (r7 == null) goto L13;
        Set r8 = r7.keySet();
    L14:
        if (r8 != null) goto L16;
        r8 = SetsKt.emptySet();
    L16:
        r5 = SetsKt.plus(r2, r8);
        goto L17
    L13:
        r8 = null;
        goto L14
    }

    @Override // kotlinx.serialization.json.internal.c
    public ouc.i r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return (ouc.i) MapsKt.getValue(w(), r2);
    }

    @Override // nuc.m1
    public String o(f r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        u.e(r5, this.c);
        String r0 = r5.b(r6);
        if (this.e.l == true) goto L6;
        return r0;
    L6:
        if (w().keySet().contains(r0) == false) goto L8;
        return r0;
    L8:
        Map<String, Integer> r7 = u.b(this.c, r5);
        Iterator r1 = w().keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L20;
        Object r2 = r1.next();
        Integer r3 = r7.get((String) r2);
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L10;
    L21:
        String r8 = (String) r2;
        if (r8 == null) goto L24;
        return r8;
    L24:
        return r0;
    L15:
        if (r3.intValue() != r6) goto L17;
        r4 = true;
        goto L18
    L20:
        r2 = null;
        goto L21
    }

    public a0(ouc.a r2, ouc.d0 r3, String r4, f r5) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "value");
        super(r2, r3, r4);
        this.f = r3;
        this.g = r5;
    }

    public /* synthetic */ a0(ouc.a r2, ouc.d0 r3, String r4, int r5) {
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        this(r2, r3, r4, null);
    }
}
