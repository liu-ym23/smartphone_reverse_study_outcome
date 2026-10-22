package com.ss.ugc.effectplatform.task.algorithm;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public final z.b<String, Pair<Integer, Long>> a;

    public b() {
        this.a = new z.b(false);
    }

    public final void a(Effect r5) {
        Pair r0 = (Pair) this.a.get(r5.getPanel());
        if (r0 == null) goto L9;
        int r1 = ((Number) r0.getFirst()).intValue() - 1;
        if (r1 > 0) goto L7;
        this.a.remove(r5.getPanel());
        return;
    L7:
        this.a.put(r5.getPanel(), new Pair(Integer.valueOf(r1), r0.getSecond()));
        return;
    }

    public final void update(Effect r6) {
        Pair r0 = (Pair) this.a.get(r6.getPanel());
        if (r0 == null) goto L7;
        Integer r1 = (Integer) r0.getFirst();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        z.b<String, Pair<Integer, Long>> r3 = this.a;
        String r7 = r6.getPanel();
        Integer r4 = Integer.valueOf(r2 + 1);
        int r5 = b0.a.a;
        r3.put(r7, new Pair(r4, Long.valueOf(System.currentTimeMillis())));
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public final String b(String r14, String r15) {
        String r3 = "null";
        if (this.a.isEmpty() == false) goto L6;
        Logger.e$default(Logger.INSTANCE, "JKL", "[EffectBlock][BlockSingle][Result][" + r14 + "][Scene:" + r15 + "][None]", null, 4, null);
        return "null";
    L6:
        Iterator r0 = this.a.entrySet().iterator();
        int r4 = 0;
        long r5 = 0;
    L8:
        if (r0.hasNext() == false) goto L19;
        Map.Entry r7 = (Map.Entry) r0.next();
        StringBuilder r8 = new StringBuilder("<");
        r8.append((String) r7.getKey());
        r8.append(", ");
        r8.append(((Number) ((Pair) r7.getValue()).getFirst()).intValue());
        r8.append(", ");
        r8.append(((Number) ((Pair) r7.getValue()).getSecond()).longValue());
        r8.append('>');
        if (Intrinsics.areEqual((String) r7.getKey(), r15) == true) goto L8;
        if (((Number) ((Pair) r7.getValue()).getFirst()).intValue() > r4) goto L18;
        if (((Number) ((Pair) r7.getValue()).getFirst()).intValue() != r4) goto L8;
        if (((Number) ((Pair) r7.getValue()).getSecond()).longValue() <= r5) goto L8;
    L18:
        r3 = (String) r7.getKey();
        long r6 = ((Number) ((Pair) r7.getValue()).getSecond()).longValue();
        r4 = ((Number) ((Pair) r7.getValue()).getFirst()).intValue();
        r5 = r6;
        goto L8
    L19:
        Logger.INSTANCE.d("JKL", "[EffectBlock][BlockSingle][Result][" + r14 + "][Scene:" + r15 + "][maxScene : " + r3 + "][maxCount : " + r4 + ']');
        return r3;
    }

    public final String c(String r11, String r12) {
        b r0 = a.a;
        String r1 = "null";
        if (a.c == true) goto L6;
        return "null";
    L6:
        if (this.a.isEmpty() == false) goto L9;
        Logger.e$default(Logger.INSTANCE, "JKL", "[EffectBlock][BlockList][Source][" + r11 + "][Scene:" + r12 + "][None]", null, 4, null);
        return "null";
    L9:
        StringBuilder r2 = new StringBuilder();
        Iterator r4 = this.a.entrySet().iterator();
    L10:
        int r6 = 0;
        if (r4.hasNext() == false) goto L19;
        Map.Entry r5 = (Map.Entry) r4.next();
        StringBuilder r8 = new StringBuilder("<");
        r8.append((String) r5.getKey());
        r8.append(", ");
        r8.append(((Number) ((Pair) r5.getValue()).getFirst()).intValue());
        r8.append(">");
        if (Intrinsics.areEqual((String) r5.getKey(), r12) == true) goto L10;
        int r9 = ((Number) ((Pair) r5.getValue()).getFirst()).intValue();
    L16:
        if (r6 >= r9) goto L10;
        r2.append((String) r5.getKey());
        r2.append(",");
        r6 = r6 + 1;
        goto L16
    L19:
        if (r2.length() != 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L25;
    L28:
        Logger.INSTANCE.w("JKL", "[EffectBlock][BlockList][Source][" + r11 + "][Scene:" + r12 + "][" + r1 + ']');
        return r1;
    L25:
        if (StringsKt.endsWith$default(r2, ",", false, 2, null) == false) goto L27;
        r1 = StringsKt.removeSuffix(r2, ",").toString();
        goto L28
    L27:
        r1 = r2.toString();
        goto L28
    L21:
        r7 = false;
        goto L22
    }
}
