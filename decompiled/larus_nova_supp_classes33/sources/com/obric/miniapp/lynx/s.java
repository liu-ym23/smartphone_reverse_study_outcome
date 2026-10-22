package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s {
    public static DisplayMetrics a(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final int d(int r3) {
        return Color.argb(RangesKt.coerceIn((int) (Color.alpha(r3) * 0.45f), 0, 255), Color.red(r3), Color.green(r3), Color.blue(r3));
    }

    public static final Float g(Object r3) {
        if ((r3 instanceof Number) == false) goto L6;
        Float r4 = Float.valueOf(((Number) r3).floatValue());
    L9:
        if (r4 != null) goto L11;
        return null;
    L11:
        if (r4.floatValue() < 0.0f) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == true) goto L17;
        r4 = null;
    L17:
        if (r4 != null) goto L19;
        return null;
    L19:
        return Float.valueOf(MathKt.roundToInt(r4.floatValue() * 100) / 100.0f);
    L13:
        r0 = false;
        goto L14
    L6:
        if ((r3 instanceof String) == false) goto L8;
        r4 = StringsKt.toFloatOrNull(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.trim((String) r3).toString(), "dp"), "sp"), "px"));
        goto L9
    L8:
        r4 = null;
        goto L9
    }

    public static final Boolean e(JSONObject r6, String... r7) {
        int r0 = r7.length;
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L55;
        String r4 = r7[r2];
        if (r6.has(r4) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        Object r8 = r6.opt(r4);
        if ((r8 instanceof Boolean) == false) goto L11;
        return (Boolean) r8;
    L11:
        if ((r8 instanceof Number) == false) goto L17;
        if (((Number) r8).intValue() == 0) goto L59;
        r1 = true;
    L59:
        return Boolean.valueOf(r1);
    L17:
        if ((r8 instanceof String) == false) goto L60;
        String r9 = StringsKt.trim((String) r8).toString().toLowerCase(Locale.ROOT);
        switch(r9.hashCode()) {
            case 48: goto L50;
            case 49: goto L46;
            case 110: goto L43;
            case 121: goto L40;
            case 3521: goto L37;
            case 3551: goto L34;
            case 109935: goto L31;
            case 119527: goto L28;
            case 3569038: goto L25;
            case 97196323: goto L22;
            default: goto L63;
        };
    L63:
        return null;
    L22:
        if (r9.equals("false") == true) goto L53;
        return null;
    L53:
        return Boolean.FALSE;
    L25:
        if (r9.equals("true") == true) goto L62;
        return null;
    L62:
        return Boolean.TRUE;
    L28:
        if (r9.equals("yes") == true) goto L62;
        return null;
    L31:
        if (r9.equals("off") == true) goto L53;
        return null;
    L34:
        if (r9.equals("on") == true) goto L62;
        return null;
    L37:
        if (r9.equals("no") == true) goto L53;
        return null;
    L40:
        if (r9.equals("y") == true) goto L62;
        return null;
    L43:
        if (r9.equals("n") == true) goto L53;
        return null;
    L46:
        if (r9.equals("1") == true) goto L62;
        return null;
    L50:
        if (r9.equals("0") == true) goto L53;
        return null;
    L60:
        return null;
    L55:
        return null;
    }

    public static final String f(JSONObject r5, String... r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        String r2 = null;
        if (r1 >= r0) goto L11;
        String r3 = r5.optString(r6[r1]);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == false) goto L8;
        r2 = r3;
    L8:
        if (r2 != null) goto L9;
        r1 = r1 + 1;
        goto L3
    L9:
        return r2;
    L11:
        return null;
    }

    public static final Drawable h(Context r4, String r5) {
        String r6 = StringsKt.trimStart(StringsKt.trim(r5).toString(), new char[]{65279});
        Object r2 = null;
        if (StringsKt.isBlank(r6) == false) goto L5;
        return null;
    L5:
        com.obric.miniapp.utils.e1.a.getClass();
        Drawable r1 = com.obric.miniapp.utils.e1.b(r4, r6);
        if (r1 == null) goto L9;
        return r1;
    L9:
        if (StringsKt.endsWith(r6, ".svg", true) == false) goto L13;
        Drawable r0 = com.obric.miniapp.utils.e1.a(r4, r6);
        if (r0 == null) goto L13;
        return r0;
    L13:
        cla.a.a.getClass();
        String r3 = cla.a.e(r6);
        if (r3 == null) goto L18;
        Drawable r7 = com.obric.miniapp.utils.e1.a(r4, r3);
        if (r7 == null) goto L18;
        return r7;
    L18:
        Integer r8 = cla.a.d(r6);
        if (r8 == null) goto L31;
        int r9 = r8.intValue();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L23
        Object r11 = Result.constructor-impl(ContextCompat.getDrawable(r4, r9));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r11) == true) goto L30;
        r2 = r11;
    L30:
        return (Drawable) r2;
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L31:
        int r13 = r4.getResources().getIdentifier(StringsKt.removePrefix(StringsKt.removePrefix(r6, "@drawable/"), "drawable/"), "drawable", r4.getPackageName());
        if (r13 != 0) goto L44;
        return null;
    L44:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L36
        Object r15 = Result.constructor-impl(ContextCompat.getDrawable(r4, r13));     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r15) == true) goto L43;
        r2 = r15;
    L43:
        return (Drawable) r2;
    L36:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }

    public static final boolean b(JSONObject r3, boolean r4, boolean r5) {
        if (r5 == true) goto L4;
    L6:
        if (r4 == true) goto L8;
    L10:
        if (r4 == true) goto L15;
        if (o1.D(r3, new String[]{"textUnselectColor", "unselectedTextColor", "text_unselect_color", "unselected_text_color"}) == null) goto L15;
    L16:
        return true;
    L15:
        if (o1.D(r3, new String[]{"textColor", "text_color"}) != null) goto L16;
        return false;
    L8:
        if (o1.D(r3, new String[]{"textSelectColor", "selectedTextColor", "text_select_color", "selected_text_color"}) == null) goto L10;
    L4:
        if (o1.D(r3, new String[]{"disabledTextColor", "disabled_text_color"}) == null) goto L6;
        goto L6
    }

    public static final Integer c(Context r4, JSONObject r5, boolean r6) {
        Float r0 = g(o1.D(r5, new String[]{"horizontalPadding", "horizontalInset", "horizontal_padding", "horizontal_inset"}));
        String[] r1 = new String[8];
        if (r6 == false) goto L5;
        String r2 = "paddingStart";
    L6:
        r1[0] = r2;
        if (r6 == false) goto L9;
        String r3 = "paddingLeft";
    L10:
        r1[1] = r3;
        if (r6 == false) goto L13;
        String r7 = "leftPadding";
    L14:
        r1[2] = r7;
        if (r6 == false) goto L17;
        String r8 = "startPadding";
    L18:
        r1[3] = r8;
        if (r6 == false) goto L21;
        String r9 = "leftInset";
    L22:
        r1[4] = r9;
        if (r6 == false) goto L25;
        String r10 = "padding_start";
    L26:
        r1[5] = r10;
        if (r6 == false) goto L29;
        String r11 = "padding_left";
    L30:
        r1[6] = r11;
        if (r6 == false) goto L33;
        String r12 = "left_padding";
    L34:
        r1[7] = r12;
        Float r13 = g(o1.D(r5, r1));
        if (r13 == null) goto L37;
        float r14 = r13.floatValue();
    L42:
        return Integer.valueOf((int) ((r14 * a(r4.getResources()).density) + 0.5f));
    L37:
        if (r0 == null) goto L40;
        r14 = r0.floatValue();
        goto L42
    L40:
        return null;
    L33:
        r12 = "right_padding";
        goto L34
    L29:
        r11 = "padding_right";
        goto L30
    L25:
        r10 = "padding_end";
        goto L26
    L21:
        r9 = "rightInset";
        goto L22
    L17:
        r8 = "endPadding";
        goto L18
    L13:
        r7 = "rightPadding";
        goto L14
    L9:
        r3 = "paddingRight";
        goto L10
    L5:
        r2 = "paddingEnd";
        goto L6
    }

    public static final Drawable i(Context r8, JSONObject r9, String[] r10, String[] r11, String[] r12) {
        int r0 = r10.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        Object r4 = null;
        Object r5 = null;
        String r6 = null;
        Object r7 = null;
        if (r2 >= r0) goto L61;
        Object r13 = r9.opt(r10[r2]);
        if ((r13 instanceof Number) == false) goto L20;
        if (((Number) r13).intValue() <= 0) goto L60;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L11
        Object r15 = Result.constructor-impl(ContextCompat.getDrawable(r8, ((Number) r13).intValue()));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r15) == true) goto L18;
        r5 = r15;
    L18:
        return (Drawable) r5;
    L11:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L60:
        r2 = r2 + 1;
        goto L3
    L20:
        if ((r13 instanceof String) == false) goto L25;
        Drawable r3 = h(r8, (String) r13);
        if (r3 == null) goto L60;
        return r3;
    L25:
        if ((r13 instanceof JSONObject) == false) goto L60;
        JSONObject r17 = (JSONObject) r13;
        Integer r18 = Integer.valueOf(r17.optInt("resId"));
        if (r18.intValue() <= 0) goto L29;
        boolean r19 = true;
    L30:
        if (r19 == true) goto L33;
        r18 = null;
    L33:
        if (r18 != null) goto L34;
        String r20 = r17.optString("resName");
        Intrinsics.checkNotNull(r20);
        if ((!StringsKt.isBlank(r20)) == true) goto L49;
        r20 = null;
    L49:
        if (r20 == null) goto L53;
        Drawable r21 = h(r8, r20);
        if (r21 == null) goto L53;
        return r21;
    L53:
        String r22 = r17.optString("iconResName");
        Intrinsics.checkNotNull(r22);
        if ((true ^ StringsKt.isBlank(r22)) == false) goto L56;
        r6 = r22;
    L56:
        if (r6 == null) goto L60;
        Drawable r23 = h(r8, r6);
        if (r23 == null) goto L60;
        return r23;
    L34:
        int r24 = r18.intValue();
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L37
        Object r25 = Result.constructor-impl(ContextCompat.getDrawable(r8, r24));     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r25) == true) goto L44;
        r7 = r25;
    L44:
        return (Drawable) r7;
    L37:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L29:
        r19 = false;
        goto L30
    L61:
        int r111 = r11.length;
        int r27 = 0;
    L62:
        if (r27 >= r111) goto L83;
        Integer r28 = Integer.valueOf(r9.optInt(r11[r27]));
        if (r28.intValue() <= 0) goto L66;
        boolean r29 = true;
    L67:
        if (r29 == true) goto L70;
        r28 = null;
    L70:
        if (r28 != null) goto L71;
        r27 = r27 + 1;
        goto L62
    L71:
        int r30 = r28.intValue();
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L74
        Object r31 = Result.constructor-impl(ContextCompat.getDrawable(r8, r30));     // Catch: Throwable -> L74
    L77:
        if (Result.isFailure-impl(r31) == true) goto L81;
        r4 = r31;
    L81:
        return (Drawable) r4;
    L74:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L77
    L66:
        r29 = false;
        goto L67
    L83:
        int r113 = r12.length;
    L84:
        if (r1 >= r113) goto L93;
        String r114 = r9.optString(r12[r1]);
        Intrinsics.checkNotNull(r114);
        if ((!StringsKt.isBlank(r114)) == true) goto L89;
        r114 = null;
    L89:
        if (r114 != null) goto L91;
        r1 = r1 + 1;
        goto L84
    L91:
        return h(r8, r114);
    L93:
        return null;
    }
}
