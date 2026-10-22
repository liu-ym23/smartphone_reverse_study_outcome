package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s<STATE extends MVIState<?>> {
    public final Map<? extends com.bytedance.android.anya.v<?, ?>, Object> a;
    public final Map<? extends u0<?, ?>, s<?>> b;
    public final STATE c;
    public final boolean d;
    public final boolean e;
    public final MVIState<?> f;

    public final <T> T a(com.bytedance.android.anya.v<?, T> r10) {
        if (this.e == false) goto L23;
        Object r0 = this.a.get(r10);
        if (r0 != null) goto L19;
        Iterator<T> r1 = this.a.entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        T r11 = r1.next();
        if (Intrinsics.areEqual(((com.bytedance.android.anya.v) ((Map.Entry) r11).getKey()).getName(), r10.getName()) == false) goto L9;
    L14:
        Map.Entry r12 = (Map.Entry) r11;
        if (r12 == null) goto L17;
        r0 = r12.getValue();
        goto L19
    L17:
        r0 = null;
        goto L19
    L13:
        r11 = null;
    L19:
        if ((r0 instanceof Object) == true) goto L32;
        return null;
    L32:
        return (T) r0;
    L23:
        if (this.d == false) goto L25;
        boolean r13 = true;
    L26:
        if (r13 == true) goto L28;
        return null;
    L28:
        return (T) ((c) r10).c();
    L25:
        r13 = CollectionsKt.contains(this.c.modifiedProperties, r10);
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(STATE r10, boolean r11, boolean r12, MVIState<?> r13) {
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        if (r12 == false) goto L99;
        Class<?> r14 = r10.getClass();
        if (r13 == null) goto L7;
        Class<?> r15 = r13.getClass();
    L9:
        if (Intrinsics.areEqual(r14, r15) == false) goto L98;
        if (r13 == null) goto L36;
        LinkedHashMap<String, c<?, ?>> r16 = r13.properties;
        if (r16 == null) goto L36;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, c<?, ?>>> r17 = r16.entrySet().iterator();
    L16:
        if (r17.hasNext() == false) goto L20;
        Map.Entry<String, c<?, ?>> r1 = r17.next();
        if ((r1 instanceof u0) == true) goto L16;
        r0.put(r1.getKey(), r1.getValue());
        goto L16
    L20:
        LinkedHashMap r18 = new LinkedHashMap();
        Iterator r19 = r0.entrySet().iterator();
    L22:
        if (r19.hasNext() == false) goto L30;
        Map.Entry r20 = (Map.Entry) r19.next();
        Object r21 = ((c) r20.getValue()).c();
        c<?, ?> r22 = this.c.properties.get(r20.getKey());
        if (r22 == null) goto L26;
        Object r23 = r22.c();
    L28:
        if ((!Intrinsics.areEqual(r21, r23)) == false) goto L22;
        r18.put(r20.getKey(), r20.getValue());
        goto L22
    L26:
        r23 = null;
        goto L28
    L30:
        Collection r24 = r18.values();
        if (r24 == null) goto L36;
        Collection r25 = r24;
        Map r26 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r25, 10)), 16));
        Iterator r27 = r25.iterator();
    L34:
        if (r27.hasNext() == false) goto L38;
        Object r28 = r27.next();
        r26.put(r28, ((c) r28).c());
    L38:
        if (this.d == false) goto L45;
        MVIState<?> r29 = this.f;
        if (r29 == null) goto L44;
        LinkedHashMap<String, c<?, ?>> r30 = r29.properties;
        if (r30 == null) goto L44;
        Set<c<?, ?>> r31 = r30.values();
    L50:
        if (r31 == null) goto L54;
        Sequence r32 = CollectionsKt.asSequence(r31);
        if (r32 == null) goto L54;
    L55:
        LinkedHashMap r33 = new LinkedHashMap();
        Iterator r34 = r32.iterator();
    L57:
        if (r34.hasNext() == false) goto L63;
        Object r35 = r34.next();
        com.bytedance.android.anya.v r36 = (com.bytedance.android.anya.v) r35;
        if (r36 == null) goto L62;
        r33.put(r35, ((c) r36).c());
        goto L57
    L62:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.BasePropertyImpl<*, *>");
    L63:
        this.a = MapsKt.plus(r26, r33);
        MVIState<?> r37 = this.f;
        if (r37 == null) goto L95;
        LinkedHashMap<String, c<?, ?>> r38 = r37.properties;
        if (r38 == null) goto L95;
        Collection<c<?, ?>> r39 = r38.values();
        if (r39 == null) goto L95;
        ArrayList r40 = new ArrayList();
        Iterator<T> r41 = r39.iterator();
    L71:
        if (r41.hasNext() == false) goto L75;
        Object r42 = r41.next();
        if ((r42 instanceof SubStatePropertyImpl) == false) goto L71;
        r40.add(r42);
        goto L71
    L75:
        LinkedHashMap r43 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r40, 10)), 16));
        Iterator r44 = r40.iterator();
    L77:
        if (r44.hasNext() == false) goto L89;
        Object r45 = r44.next();
        SubStatePropertyImpl r46 = (SubStatePropertyImpl) r45;
        c<?, ?> r47 = this.c.properties.get(r46.a);
        if (r47 == null) goto L81;
        Object r48 = r47.c();
    L82:
        if (r48 != null) goto L84;
        Intrinsics.throwNpe();
    L84:
        MVIState r49 = (MVIState) r46.c();
        boolean r50 = this.d;
        boolean r51 = this.e;
        if (r48 == null) goto L88;
        r43.put(r45, new s(r49, r50, r51, (MVIState) r48));
        goto L77
    L88:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIState<*>");
    L81:
        r48 = null;
        goto L82
    L89:
        Map r52 = new LinkedHashMap();
        Iterator r53 = r43.entrySet().iterator();
    L91:
        if (r53.hasNext() == false) goto L96;
        Map.Entry r54 = (Map.Entry) r53.next();
        if ((!((s) r54.getValue()).a.isEmpty()) == false) goto L91;
        r52.put(r54.getKey(), r54.getValue());
    L96:
        this.b = r52;
        return;
    L95:
        r52 = MapsKt.emptyMap();
    L54:
        r32 = SequencesKt.emptySequence();
    L44:
        r31 = null;
        goto L50
    L45:
        MVIState<?> r55 = this.f;
        if (r55 == null) goto L48;
        Set<c<?, ?>> r56 = r55.modifiedProperties;
    L49:
        r31 = r56;
        goto L50
    L48:
        r56 = null;
    L36:
        r26 = MapsKt.emptyMap();
        goto L38
    L98:
        throw new IllegalStateException("stateInstance is not equal to newListState".toString());
    L7:
        r15 = null;
        goto L9
    L99:
        this.a = MapsKt.emptyMap();
        this.b = MapsKt.emptyMap();
    }
}
