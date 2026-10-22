package com.bytedance.android.live.effect;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final Map<ILiveEffectComposerManager.EffectInstanceType, String[]> a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Map<ILiveEffectComposerManager.EffectInstanceType, String[]> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "GetPathResult(pathMap=" + this.a + ")";
        }

        public a(Map<ILiveEffectComposerManager.EffectInstanceType, String[]> r2) {
            Intrinsics.checkNotNullParameter(r2, "pathMap");
            this.a = r2;
        }
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.bytedance.android.live.effect.composer.n) r3).g), Long.valueOf(((com.bytedance.android.live.effect.composer.n) r4).g));
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.bytedance.android.live.effect.composer.n) r3).g), Long.valueOf(((com.bytedance.android.live.effect.composer.n) r4).g));
        }
    }

    static {
    }

    public static List f(List r3) {
        Intrinsics.checkNotNullParameter(r3, "composerNodeList");
        ArrayList r0 = new ArrayList();
        r0.addAll(r3);
        if (r0.size() <= 1) goto L5;
        CollectionsKt.sortWith(r0, new c());
    L5:
        ArrayList r4 = new ArrayList();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (((com.bytedance.android.live.effect.composer.n) r2).j == false) goto L7;
        r4.add(r2);
        goto L7
    L11:
        return r4;
    }

    @JvmStatic
    public static final int a(Sticker.ComposerConfig r3, float r4) {
        if (r4 != 0.0f) goto L5;
        return 0;
    L5:
        if (r3 == null) goto L7;
        int r0 = r3.getMaxValue();
        int r5 = r3.getMinValue();
    L8:
        if (r5 >= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        float r6 = r4 * 10000;
        float r7 = r0 - r5;
    L19:
        return (int) (r6 / r7);
    L13:
        if (r4 <= 0) goto L15;
        float r8 = 5000 / r0;
    L16:
        r6 = r4 * r8;
        r7 = 2;
        goto L19
    L15:
        r8 = (-5000) / r5;
        goto L16
    L10:
        r2 = false;
        goto L11
    L7:
        r0 = 100;
        r5 = 0;
        goto L8
    }

    @JvmStatic
    public static final int b(Sticker r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "sticker");
        return a(r1.getSmallItemConfig(), r2);
    }

    @JvmStatic
    public static final float c(Sticker.ComposerConfig r6, int r7) {
        if (r7 != 0) goto L5;
        return 0.0f;
    L5:
        boolean r0 = false;
        if (r6 == null) goto L8;
        int r1 = r6.getMaxValue();
        int r8 = r6.getMinValue();
    L9:
        if (r8 >= 0) goto L12;
        r0 = true;
    L12:
        if (r0 == false) goto L19;
        if (r7 <= 0) goto L16;
        double r4 = ((double) r1) * 1.0d;
        double r2 = 5000.0d;
    L20:
        return (float) (((r4 / r2) * ((double) r7)) * ((double) 2));
    L16:
        r4 = ((double) r8) * 1.0d;
        r2 = -5000.0d;
        goto L20
    L19:
        return (float) (((((double) (r1 - r8)) * 1.0d) / 10000.0d) * ((double) r7));
    L8:
        r1 = 100;
        r8 = 0;
        goto L9
    }

    @JvmStatic
    public static final float d(Sticker r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "sticker");
        return c(r1.getSmallItemConfig(), r2);
    }

    public static a e(List r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "composerNodeList");
        ArrayList r0 = new ArrayList();
        r0.addAll(r11);
        if (r0.size() <= 1) goto L5;
        CollectionsKt.sortWith(r0, new b());
    L5:
        Map r13 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ILiveEffectComposerManager.EffectInstanceType.DEFAULT, new ArrayList()), TuplesKt.to(ILiveEffectComposerManager.EffectInstanceType.RENDER_FILTER, new ArrayList())});
        ArrayList r2 = new ArrayList();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r4 = r1.next();
        if (((com.bytedance.android.live.effect.composer.n) r4).j == false) goto L7;
        r2.add(r4);
        goto L7
    L11:
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L56;
        com.bytedance.android.live.effect.composer.n r5 = (com.bytedance.android.live.effect.composer.n) r3.next();
        ArrayList r6 = (ArrayList) r13.get(r5.l);
        Iterator<T> r7 = r5.i.iterator();
    L16:
        if (r7.hasNext() == false) goto L26;
        Object r8 = r7.next();
        com.bytedance.android.live.effect.composer.p r9 = (com.bytedance.android.live.effect.composer.p) r8;
        if (r12 == false) goto L20;
    L23:
        boolean r14 = true;
    L24:
        if (r14 == false) goto L16;
    L27:
        if (r8 == null) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == true) goto L33;
        if (r6 == null) goto L54;
        r6.add(r5.d);
    L54:
        if (r6 == null) goto L13;
        r13.put(r5.l, r6);
        goto L13
    L33:
        List<com.bytedance.android.live.effect.composer.p> r16 = r5.i;
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L35:
        if (r18.hasNext() == false) goto L45;
        Object r19 = r18.next();
        com.bytedance.android.live.effect.composer.p r21 = (com.bytedance.android.live.effect.composer.p) r19;
        if (r12 == false) goto L39;
    L42:
        boolean r22 = true;
    L43:
        if (r22 == false) goto L35;
        r17.add(r19);
        goto L35
    L39:
        if (r21.a != null) goto L42;
        r22 = false;
        goto L43
    L45:
        Iterator r23 = r17.iterator();
    L47:
        if (r23.hasNext() == false) goto L54;
        com.bytedance.android.live.effect.composer.p r24 = (com.bytedance.android.live.effect.composer.p) r23.next();
        if (r12 == true) goto L50;
        if (r6 == null) goto L47;
        r6.add(r5.d + ':' + r24.b + ':' + r24.a);
        goto L47
    L50:
        if (r6 == null) goto L47;
        r6.add(r5.d + ':' + r24.b + ":0");
        goto L47
    L29:
        r15 = false;
        goto L30
    L20:
        if (r9.a != null) goto L23;
        r14 = false;
        goto L24
    L26:
        r8 = null;
        goto L27
    L56:
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator r111 = r13.entrySet().iterator();
    L58:
        if (r111.hasNext() == false) goto L65;
        Map.Entry r25 = (Map.Entry) r111.next();
        Object r26 = r25.getKey();
        Object[] r27 = ((Collection) r25.getValue()).toArray(new String[0]);
        if (r27 == null) goto L63;
        r110.put(r26, r27);
        goto L58
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L65:
        return new a(r110);
    }
}
