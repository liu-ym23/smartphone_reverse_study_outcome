package com.bytedance.android.anniex.scene.next.strategy;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.android.anniex.scene.next.g;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends wa.d {
    public final String b;

    public c() {
        this.b = "FuzzyThresholdStrategy";
    }

    @Override // wa.b
    public final String getName() {
        return this.b;
    }

    @Override // wa.b
    public final List<xa.b<String>> a(com.bytedance.android.anniex.scene.next.a r22) {
        g r0 = (g) r22;
        Intrinsics.checkNotNullParameter(r0, "input");
        Map<String, Pair<Integer, Double>> r1 = r0.c;
        int r10 = ((Number) SwitchCenter.c0.getValue()).intValue() * 2;
        int r11 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L58;
        List r13 = CollectionsKt.take(CollectionsKt.sortedWith(r1.entrySet(), new a()), r10);
        HashMap r14 = new HashMap(r10 * 2);
        List r15 = r13;
        Iterator r16 = r15.iterator();
    L13:
        if (r16.hasNext() == false) goto L21;
        Map.Entry r17 = (Map.Entry) r16.next();
        double r18 = ((Number) ((Pair) r17.getValue()).getSecond()).doubleValue();
        Iterator r19 = SequencesKt.filter(CollectionsKt.asSequence(StringsKt.split$default((CharSequence) r17.getKey(), new String[]{","}, false, 0, 6, null)), FuzzyThresholdStrategy$predict$1$1.INSTANCE).iterator();
    L16:
        if (r19.hasNext() == false) goto L13;
        String r20 = (String) r19.next();
        Pair r110 = (Pair) r14.get(r20);
        if (r110 != null) goto L20;
        r110 = TuplesKt.to(Double.valueOf(0.0d), 0);
    L20:
        r14.put(r20, TuplesKt.to(Double.valueOf(((Number) r110.component1()).doubleValue() + r18), Integer.valueOf(((Number) r110.component2()).intValue() + 1)));
        goto L16
    L21:
        Iterator r21 = r15.iterator();
        double r23 = 0.0d;
        double r111 = 0.0d;
    L23:
        if (r21.hasNext() == false) goto L32;
        Map.Entry r24 = (Map.Entry) r21.next();
        double r112 = ((Number) ((Pair) r24.getValue()).getSecond()).doubleValue();
        List r25 = StringsKt.split$default((CharSequence) r24.getKey(), new String[]{","}, false, 0, 6, null);
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L26:
        if (r27.hasNext() == false) goto L30;
        Object r113 = r27.next();
        if ((!StringsKt.isBlank((String) r113)) == false) goto L26;
        r26.add(r113);
        goto L26
    L30:
        r111 = r111 + (((double) r26.size()) * r112);
        r23 = r23 + r112;
        goto L23
    L32:
        if (r23 <= 0) goto L34;
        r11 = RangesKt.coerceAtLeast(MathKt.roundToInt(r111 / r23), 1);
    L34:
        List r28 = SequencesKt.toList(SequencesKt.take(SequencesKt.sortedWith(SequencesKt.map(MapsKt.asSequence(r14), FuzzyThresholdStrategy$predict$sortedWithProb$1.INSTANCE), new b()), r11 * ((Number) SwitchCenter.l0.getValue()).intValue()));
        List r29 = r28;
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator r31 = r29.iterator();
        double r32 = 0.0d;
    L36:
        if (r31.hasNext() == false) goto L39;
        Pair r33 = (Pair) r31.next();
        r32 = r32 + ((Number) r33.getSecond()).doubleValue();
        r30.add((String) r33.getFirst());
        goto L36
    L39:
        if ((!r28.isEmpty()) == false) goto L41;
        double r34 = r32 / ((double) r28.size());
    L43:
        if (r34 > ((Number) SwitchCenter.k0.getValue()).floatValue()) goto L46;
        return CollectionsKt.emptyList();
    L46:
        return CollectionsKt.listOf(new xa.b(PredictElementType.SceneId, CollectionsKt.joinToString$default(r30, ",", null, null, 0, null, null, 62, null), r34));
    L41:
        r34 = 0.0d;
        goto L43
    L58:
        return CollectionsKt.emptyList();
    L5:
        if (r1.isEmpty() == true) goto L8;
        r12 = false;
        goto L9
    }
}
