package com.ss.ugc.effectplatform.util;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean b(Effect r5) {
        List<String> r0 = r5.getRequirements_sec();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        List<String> r2 = r5.getRequirements();
        if ((r2 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r3 = r2.iterator();
        int r4 = 0;
    L18:
        if (r3.hasNext() == false) goto L24;
        if ((!StringsKt.isBlank((String) r3.next())) == false) goto L18;
        r4 = r4 + 1;
        if (r4 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();
    L24:
        List<String> r6 = r5.getRequirements_sec();
        if (r6 == null) goto L39;
        List<String> r7 = r6;
        if ((r7 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r8 = r7.iterator();
        int r9 = 0;
    L33:
        if (r8.hasNext() == false) goto L40;
        if ((!StringsKt.isBlank((String) r8.next())) == false) goto L33;
        r9 = r9 + 1;
        if (r9 >= 0) goto L33;
        CollectionsKt.throwCountOverflow();
    L40:
        if (r9 == 0) goto L43;
        if (r9 == r4) goto L43;
        return true;
    L43:
        return false;
    L29:
        if (r7.isEmpty() == false) goto L31;
    L39:
        r9 = 0;
        goto L40
    L14:
        if (r2.isEmpty() == false) goto L16;
        r4 = 0;
        goto L24
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final String[] a(Effect r11, dlc.a r12, Object r13) {
        List r0 = CollectionsKt.toMutableList(r11.getRequirements());
        Logger r1 = Logger.INSTANCE;
        r1.d("effect_platform", "getResourceNameArrayOfEffect::requirements, effect: " + r11.getEffect_id() + ", name: " + r11.getName() + ", returned requirements: " + r0);
        String r2 = r11.getModel_names();
        StringBuilder r5 = new StringBuilder("EffectUtils#getModelNamesOfEffect->effectId = ");
        r5.append(r11.getEffect_id());
        r5.append(", modelNames = ");
        r5.append(r2);
        r1.d("effect_platform", r5.toString());
        List r6 = null;
        if (r.b(r2) == true) goto L12;
        if (r12 == null) goto L12;
        if (r2 == null) goto L79;
    L8:
        Map r3 = (Map) r12.a.convertJsonToObj(r2, Map.class);     // Catch: Exception -> L10
    L13:
        boolean r7 = true;
        if (r3 != null) goto L16;
    L35:
        boolean r8 = true;
    L37:
        if (r8 == false) goto L51;
        List r4 = r0;
        if ((!r4.isEmpty()) == false) goto L51;
        Object[] r9 = r4.toArray(new String[0]);
        if (r9 == null) goto L50;
        String[] r14 = com.ss.ugc.effectplatform.algorithm.i.d((String[]) r9, r12, r13);
        if (r14 == null) goto L52;
        Object[] r15 = ArraysKt.distinct(r14).toArray(new String[0]);
        if (r15 == null) goto L48;
        r14 = (String[]) r15;
        goto L52
    L48:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L52:
        int r16 = bytekn.foundation.utils.a.a;
        if (r3 != null) goto L55;
    L58:
        if (r7 == true) goto L74;
        if (r3 == null) goto L73;
        ArrayList r17 = new ArrayList();
        Iterator r10 = r3.entrySet().iterator();
    L63:
        if (r10.hasNext() == false) goto L65;
        r17.addAll((List) ((Map.Entry) r10.next()).getValue());
        goto L63
    L65:
        ArrayList r18 = new ArrayList();
        if (r14 == null) goto L68;
        r18.addAll(ArraysKt.toList(r14));
    L68:
        r18.addAll(r17);
        Object[] r19 = r18.toArray(new String[0]);
        if (r19 == null) goto L72;
        r14 = (String[]) r19;
        goto L74
    L72:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L73:
        r14 = null;
    L74:
        Logger r110 = Logger.INSTANCE;
        StringBuilder r20 = new StringBuilder("fetchModels::effectId=");
        r20.append(r11.getEffect_id());
        r20.append(", name: ");
        r20.append(r11.getName());
        r20.append(", returned toDownloadRequirements: ");
        if (r14 == null) goto L77;
        r6 = ArraysKt.toList(r14);
    L77:
        r20.append(r6);
        r110.d("effect_platform", r20.toString());
        return r14;
    L55:
        if (r3.isEmpty() == true) goto L58;
        r7 = false;
        goto L58
    L50:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L51:
        r14 = null;
        goto L52
    L16:
        if ((!r3.isEmpty()) == false) goto L18;
        Map r21 = r3;
    L19:
        if (r21 == null) goto L35;
        ArrayList r22 = new ArrayList();
        Iterator r23 = r0.iterator();
    L22:
        if (r23.hasNext() == false) goto L26;
        String r24 = (String) r23.next();
        if (r3.containsKey(r24) == false) goto L22;
        r22.add(r24);
        goto L22
    L26:
        int r25 = bytekn.foundation.utils.a.a;
        if (r22.isEmpty() == false) goto L29;
        boolean r26 = true;
    L30:
        if (r26 == true) goto L35;
        if (Intrinsics.areEqual(r22, r0) == false) goto L34;
        r8 = false;
        goto L37
    L34:
        r0.removeAll(r22);
        goto L35
    L29:
        r26 = false;
        goto L30
    L18:
        r21 = null;
    L10:
        e = move-exception;
        Logger.INSTANCE.e("effect_platform", "EffectUtils#getModelNamesOfEffect", e);
        goto L12
    L79:
        Intrinsics.throwNpe();     // Catch: Exception -> L10
    L12:
        r3 = null;
        goto L13
    }
}
