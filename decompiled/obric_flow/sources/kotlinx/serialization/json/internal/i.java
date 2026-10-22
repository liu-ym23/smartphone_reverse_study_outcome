package kotlinx.serialization.json.internal;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.internal.z0;
import kotlinx.serialization.json.b0;
import kotlinx.serialization.json.u;
import kotlinx.serialization.json.x;

/* JADX INFO: loaded from: classes3.dex */
public class i extends a {
    public final x e;
    public final String f;
    public final kotlinx.serialization.descriptors.g g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f19426i;

    public i(kotlinx.serialization.json.b r5, x r10, String r11, kotlinx.serialization.descriptors.g r12) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r10, "value");
        super(r5);
        this.e = r10;
        this.f = r11;
        this.g = r12;
    }

    @Override // kotlinx.serialization.json.internal.a, kotlinx.serialization.internal.n1, eu.b
    public final boolean B() {
        if (this.f19426i == false) goto L5;
    L7:
        return false;
    L5:
        if (super.B() == false) goto L7;
        return true;
    }

    @Override // kotlinx.serialization.json.internal.a
    public kotlinx.serialization.json.l O(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        return (kotlinx.serialization.json.l) MapsKt.getValue(V(), r5);
    }

    @Override // kotlinx.serialization.json.internal.a
    public String Q(kotlinx.serialization.descriptors.g r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        kotlinx.serialization.json.b r11 = this.f19416c;
        f.n(r5, r11);
        String r12 = r5.e(r10);
        if (this.d.f19412l == true) goto L6;
        return r12;
    L6:
        if (V().f19451a.keySet().contains(r12) == false) goto L8;
        return r12;
    L8:
        Map r13 = f.j(r5, r11);
        Iterator r14 = V().f19451a.keySet().iterator();
    L10:
        if (r14.hasNext() == false) goto L17;
        Object r15 = r14.next();
        Integer r16 = (Integer) r13.get((String) r15);
        if (r16 == null) goto L10;
        if (r16.intValue() != r10) goto L10;
    L18:
        String r17 = (String) r15;
        if (r17 == null) goto L21;
        return r17;
    L21:
        return r12;
    L17:
        r15 = null;
        goto L18
    }

    @Override // kotlinx.serialization.json.internal.a
    public /* bridge */ /* synthetic */ kotlinx.serialization.json.l T() {
        return V();
    }

    public x V() {
        return this.e;
    }

    @Override // kotlinx.serialization.json.internal.a, eu.b
    public final eu.a i(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        kotlinx.serialization.descriptors.g r10 = this.g;
        if (r5 != r10) goto L11;
        kotlinx.serialization.json.l r11 = P();
        if ((r11 instanceof x) == false) goto L9;
        String r12 = this.f;
        return new i(this.f19416c, (x) r11, r12, r10);
    L9:
        throw f.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(x.class) + " as the serialized body of " + r10.h() + ", but had " + Reflection.getOrCreateKotlinClass(r11.getClass()));
    L11:
        return super.i(r5);
    }

    @Override // eu.a
    public int l(kotlinx.serialization.descriptors.g r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
    L4:
        if (this.f19425h >= r10.d()) goto L45;
        int r5 = this.f19425h;
        this.f19425h = r5 + 1;
        String r11 = S(r10, r5);
        int r12 = this.f19425h - 1;
        boolean r13 = false;
        this.f19426i = false;
        boolean r14 = V().containsKey(r11);
        kotlinx.serialization.json.b r15 = this.f19416c;
        if (r14 == true) goto L17;
        if (r15.f19384a.f == false) goto L10;
    L14:
        this.f19426i = r13;
        if (r13 == false) goto L4;
    L10:
        if (r10.i(r12) == true) goto L14;
        if (r10.g(r12).b() == false) goto L14;
        r13 = true;
    L17:
        if (this.d.f19408h == false) goto L44;
        kotlinx.serialization.descriptors.g r16 = r10.g(r12);
        if (r16.b() == true) goto L24;
        if ((O(r11) instanceof u) == true) goto L4;
    L24:
        if (Intrinsics.areEqual(r16.getKind(), kotlinx.serialization.descriptors.m.f19242b) == false) goto L44;
        if (r16.b() == true) goto L28;
    L30:
        kotlinx.serialization.json.l r17 = O(r11);
        String r18 = null;
        if ((r17 instanceof b0) == false) goto L33;
        b0 r19 = (b0) r17;
    L34:
        if (r19 == null) goto L39;
        int r20 = kotlinx.serialization.json.m.f19441a;
        Intrinsics.checkNotNullParameter(r19, "<this>");
        if ((r19 instanceof u) == true) goto L39;
        r18 = r19.b();
    L39:
        if (r18 == null) goto L44;
        if (f.k(r16, r15, r18) != (-3)) goto L44;
    L33:
        r19 = null;
        goto L34
    L28:
        if ((O(r11) instanceof u) == false) goto L30;
    L44:
        return r12;
    L45:
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.a, eu.a
    public void u(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        kotlinx.serialization.json.i r10 = this.d;
        if (r10.f19406b == false) goto L5;
        return;
    L5:
        if ((r5.getKind() instanceof kotlinx.serialization.descriptors.d) == true) goto L34;
        kotlinx.serialization.json.b r11 = this.f19416c;
        f.n(r5, r11);
        if (r10.f19412l == true) goto L10;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Set r12 = z0.b(r5);
    L17:
        Iterator r13 = V().f19451a.keySet().iterator();
    L19:
        if (r13.hasNext() == false) goto L35;
        String r14 = (String) r13.next();
        if (r12.contains(r14) == true) goto L19;
        if (Intrinsics.areEqual(r14, this.f) == true) goto L19;
        String r15 = V().toString();
        Intrinsics.checkNotNullParameter(r14, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r15, "input");
        StringBuilder r16 = j0.x("Encountered an unknown key '", r14, "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: ");
        r16.append(f.m(r15, -1));
        throw f.d(-1, r16.toString());
    L35:
        return;
    L10:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Set r17 = z0.b(r5);
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Map r18 = (Map) r11.f19386c.i(r5);
        if (r18 == null) goto L13;
        Set r19 = r18.keySet();
    L14:
        if (r19 != null) goto L16;
        r19 = SetsKt.emptySet();
    L16:
        r12 = SetsKt.plus(r17, r19);
        goto L17
    L13:
        r19 = null;
        goto L14
    }
}
