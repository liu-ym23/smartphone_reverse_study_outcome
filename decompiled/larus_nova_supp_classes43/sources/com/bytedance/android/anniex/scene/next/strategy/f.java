package com.bytedance.android.anniex.scene.next.strategy;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.android.anniex.scene.next.g;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends wa.d {
    public final ya.b b;
    public final String c;

    public f() {
        this.b = new ya.b();
        this.c = "ThresholdStrategy";
    }

    @Override // wa.b
    public final String getName() {
        return this.c;
    }

    @Override // wa.b
    public final List<xa.b<String>> a(com.bytedance.android.anniex.scene.next.a r11) {
        g r12 = (g) r11;
        Intrinsics.checkNotNullParameter(r12, "input");
        float r1 = ((Number) SwitchCenter.a0.getValue()).floatValue();
        int r10 = ((Number) SwitchCenter.c0.getValue()).intValue();
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r12, "input");
        Map<String, Pair<Integer, Double>> r13 = r12.c;
        if (r13 == null) goto L5;
        Set<Map.Entry<String, Pair<Integer, Double>>> r14 = r13.entrySet();
    L6:
        if (r14 != null) goto L8;
        r14 = SetsKt.emptySet();
    L8:
        List r15 = CollectionsKt.sortedWith(r14, new ya.a());
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        Map.Entry r17 = (Map.Entry) r16.next();
        r0.add(new xa.c((String) r17.getKey(), ((Number) ((Pair) r17.getValue()).getSecond()).doubleValue()));
        goto L10
    L12:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r0.iterator();
    L14:
        if (r19.hasNext() == false) goto L21;
        Object r20 = r19.next();
        if (((xa.c) r20).b <= r1) goto L18;
        boolean r21 = true;
    L19:
        if (r21 == false) goto L14;
        r18.add(r20);
        goto L14
    L18:
        r21 = false;
        goto L19
    L21:
        List r110 = CollectionsKt.take(CollectionsKt.sortedWith(r18, new e()), r10);
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r111 = r110.iterator();
    L23:
        if (r111.hasNext() == false) goto L25;
        xa.c r23 = (xa.c) r111.next();
        r22.add(new xa.b(PredictElementType.SceneId, r23.a, r23.b));
        goto L23
    L25:
        return r22;
    L5:
        r14 = null;
        goto L6
    }
}
