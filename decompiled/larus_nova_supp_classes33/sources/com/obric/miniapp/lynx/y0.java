package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y0 {
    public static final void b(View r2) {
        ViewParent r0 = r2.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L9;
        r1.removeView(r2);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final int d(Integer r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    public static final Float f(Object r1) {
        if ((r1 instanceof Number) == false) goto L6;
        return Float.valueOf(((Number) r1).floatValue());
    L6:
        if ((r1 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toFloatOrNull(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.trim((String) r1).toString(), "dp"), "sp"), "px"));
    }

    public static final int g(JSONObject r3) {
        String r4 = j(r3, new String[]{"placement", "position", "gravity"});
        if (r4 == null) goto L7;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 == null) goto L7;
        String r6 = r5.toLowerCase(Locale.ROOT);
    L8:
        if (r6 != null) goto L10;
    L33:
        return 80;
    L10:
        switch(r6.hashCode()) {
            case 3739: goto L30;
            case 100571: goto L26;
            case 115029: goto L23;
            case 3317767: goto L19;
            case 108511772: goto L16;
            case 109757538: goto L13;
            default: goto L33;
        };
    L13:
        if (r6.equals("start") == false) goto L33;
    L21:
        return 3;
    L16:
        if (r6.equals("right") == false) goto L33;
    L28:
        return 5;
    L19:
        if (r6.equals("left") == true) goto L21;
    L23:
        if (r6.equals("top") == false) goto L33;
    L32:
        return 48;
    L26:
        if (r6.equals("end") == true) goto L28;
    L30:
        if (r6.equals("up") == true) goto L32;
    L7:
        r6 = null;
        goto L8
    }

    public static final void i(View r3) {
        r3.forceLayout();
        r3.requestLayout();
        if ((r3 instanceof ViewGroup) == false) goto L11;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L15;
        View r2 = r4.getChildAt(r1);
        if (r2 == null) goto L10;
        i(r2);
    L10:
        r1 = r1 + 1;
        goto L5
    L15:
        return;
    }

    public static final Integer l(String r5) {
        Float r1 = StringsKt.toFloatOrNull(StringsKt.removeSuffix(r5, "%"));
        if (r1 == null) goto L10;
        float r2 = r1.floatValue();
        if (StringsKt.endsWith$default(r5, "%", false, 2, null) == false) goto L7;
        float r6 = RangesKt.coerceIn(r2, 0.0f, 100.0f) * 2.55f;
    L9:
        return Integer.valueOf((int) r6);
    L7:
        r6 = RangesKt.coerceIn(r2, 0.0f, 255.0f);
        goto L9
    L10:
        return null;
    }

    public static final int c(Context r1, int r2) {
        Resources r3 = r1.getResources();
        return (int) (r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density);
    }

    public static final Integer e(Object r12, Context r13) {
        Integer r14 = o1.E(r12, r13);
        if (r14 != null) goto L62;
        Integer r0 = null;
        if ((r12 instanceof String) == false) goto L7;
        String r15 = (String) r12;
    L8:
        if (r15 == null) goto L60;
        String r16 = StringsKt.trim(r15).toString();
        if (r16 == null) goto L60;
        String r17 = r16.toLowerCase(Locale.ROOT);
        if (r17 == null) goto L60;
        if ((!StringsKt.isBlank(r17)) == true) goto L17;
        r17 = null;
    L17:
        if (r17 == null) goto L60;
        String r2 = r17;
        int r11 = StringsKt.indexOf$default(r2, '(', 0, false, 6, null);
        int r18 = StringsKt.lastIndexOf$default(r2, ')', 0, false, 6, null);
        if (r11 <= 0) goto L60;
        if (r18 <= r11) goto L60;
        String r3 = r17.substring(0, r11);
        if (Intrinsics.areEqual(r3, "rgb") == false) goto L26;
    L28:
        List r19 = StringsKt.split$default(r17.substring(r11 + 1, r18), new char[]{','}, false, 0, 6, null);
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r111 = r19.iterator();
    L30:
        if (r111.hasNext() == false) goto L32;
        r110.add(StringsKt.trim((String) r111.next()).toString());
        goto L30
    L32:
        int r112 = r110.size();
        if (3 <= r112) goto L35;
    L37:
        boolean r113 = false;
    L38:
        if (r113 == false) goto L60;
        Integer r114 = l((String) ListProtector.get(r110, 0));
        if (r114 == null) goto L60;
        int r115 = r114.intValue();
        Integer r1 = l((String) ListProtector.get(r110, 1));
        if (r1 == null) goto L60;
        int r4 = r1.intValue();
        Integer r5 = l((String) ListProtector.get(r110, 2));
        if (r5 == null) goto L60;
        int r6 = r5.intValue();
        String r116 = (String) CollectionsKt.getOrNull(r110, 3);
        if (r116 == null) goto L57;
        Float r117 = StringsKt.toFloatOrNull(r116);
        if (r117 == null) goto L55;
        float r118 = r117.floatValue();
        if (r118 > 1.0f) goto L53;
        float r119 = RangesKt.coerceIn(r118, 0.0f, 1.0f) * 255.0f;
    L54:
        r0 = Integer.valueOf((int) r119);
        goto L55
    L53:
        r119 = RangesKt.coerceIn(r118, 0.0f, 255.0f);
    L55:
        if (r0 == null) goto L57;
        int r120 = r0.intValue();
    L63:
        return Integer.valueOf(Color.argb(r120, r115, r4, r6));
    L57:
        r120 = 255;
        goto L63
    L35:
        if (r112 >= 5) goto L37;
        r113 = true;
        goto L38
    L26:
        if (Intrinsics.areEqual(r3, "rgba") == true) goto L28;
    L60:
        return null;
    L7:
        r15 = null;
        goto L8
    L62:
        return r14;
    }

    public static final String j(JSONObject r5, String... r6) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r1 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L17;
        String r3 = r5.optString(r6[r2]);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == true) goto L11;
        r3 = null;
    L11:
        if (r3 != null) goto L14;
        r2 = r2 + 1;
        goto L6
    L14:
        return r3;
    L17:
        return null;
    }

    public static final Object k(JSONObject r5, String... r6) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r1 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L20;
        String r3 = r6[r2];
        if (r5.has(r3) == true) goto L10;
    L13:
        Object r4 = null;
    L14:
        if (r4 != null) goto L17;
        r2 = r2 + 1;
        goto L6
    L17:
        return r4;
    L10:
        if (r5.isNull(r3) == true) goto L13;
        r4 = r5.opt(r3);
        goto L14
    L20:
        return null;
    }

    public static final k4 h(List r7, final int r8, final int r9) {
        Iterator r10 = SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r7), new w0()), new x0(r8, r9)).iterator();
        if (r10.hasNext() == true) goto L5;
        Object r11 = null;
    L16:
        return (k4) r11;
    L5:
        Object r12 = r10.next();
        if (r10.hasNext() == true) goto L8;
    L7:
        r11 = r12;
        goto L16
    L8:
        k4 r13 = (k4) r12;
        long r0 = ((long) r13.c) * ((long) r13.d);
    L9:
        Object r14 = r10.next();
        k4 r2 = (k4) r14;
        long r3 = ((long) r2.c) * ((long) r2.d);
        if (r0 >= r3) goto L13;
        r12 = r14;
        r0 = r3;
    L13:
        if (r10.hasNext() == true) goto L9;
        goto L7
    }

    public static final k4 a(k4 r19, k4 r20, k4 r21, int r22, int r23) {
        if (r19 == null) goto L5;
        long r7 = RangesKt.coerceAtLeast(r19.c, 0) * RangesKt.coerceAtLeast(r19.d, 0);
    L6:
        long r9 = RangesKt.coerceAtLeast(r22, 1) * RangesKt.coerceAtLeast(r23, 1);
        long r11 = RangesKt.coerceAtLeast(r20.c, 0) * RangesKt.coerceAtLeast(r20.d, 0);
        long r13 = RangesKt.coerceAtLeast(r21.c, 0) * RangesKt.coerceAtLeast(r21.d, 0);
        if (r19 == null) goto L17;
        int r12 = r19.c;
        if (r12 <= 0) goto L17;
        int r15 = r19.d;
        if (r15 <= 0) goto L17;
        if (r12 > r22) goto L17;
        if (r15 > r23) goto L17;
        if (r7 > (r9 / ((long) 2))) goto L17;
        boolean r5 = true;
    L18:
        int r6 = r20.c;
        if (r6 <= 0) goto L27;
        int r14 = r20.d;
        if (r14 <= 0) goto L27;
        if (r6 > r22) goto L27;
        if (r14 > r23) goto L27;
        if (r11 > (r9 / ((long) 2))) goto L27;
        boolean r16 = true;
    L28:
        if (r5 == false) goto L34;
        long r8 = 2;
        if (r7 <= ((((long) 3) * r11) / r8)) goto L34;
        if (r7 <= (r8 * r13)) goto L34;
        return r19;
    L34:
        if (r16 == false) goto L39;
        if (r11 <= (r13 * ((long) 2))) goto L39;
        return new k4(Math.max(r20.a, r21.a), Math.max(r20.b, r21.b), Math.max(r20.c, r21.c), Math.max(r20.d, r21.d));
    L39:
        return r21;
    L27:
        r16 = false;
    L17:
        r5 = false;
        goto L18
    L5:
        r7 = 0;
        goto L6
    }
}
