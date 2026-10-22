package com.bytedance.android.accessibilityLib_Core.config.remote.step;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.ClassType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.ConfigType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.EventTextType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.EventType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.LabelMode;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.SelectMode;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.d;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.e;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.f;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.g;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.config.remote.repo.ConfigFileProviderMode;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ParseStep extends a<Boolean, List<? extends f>> {
    public List<f> a;
    public boolean b;
    public final b c;

    public ParseStep(b r1) {
        this.c = r1;
    }

    public static h b(String r10) {
        if (r10 == null) goto L43;
        List r11 = StringsKt.split$default(StringsKt.trim(r10).toString(), new String[]{"-"}, false, 0, 6, null);
        int r12 = -1;
        if ((!r11.isEmpty()) == false) goto L11;
        String r1 = (String) ListProtector.get(r11, 0);
        if (r1 == null) goto L10;
        int r13 = CastIntegerProtector.parseInt(StringsKt.trim(r1).toString());
    L13:
        if (r11.size() <= 1) goto L19;
        String r14 = (String) ListProtector.get(r11, 1);
        if (r14 == null) goto L18;
        r12 = CastIntegerProtector.parseInt(StringsKt.trim(r14).toString());
        goto L19
    L18:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L19:
        String r15 = "";
        if (r11.size() <= 2) goto L26;
        String r16 = (String) ListProtector.get(r11, 2);
        if (r16 == null) goto L25;
        String r17 = StringsKt.trim(r16).toString();
    L28:
        if (r11.size() <= 3) goto L44;
        String r18 = (String) ListProtector.get(r11, 3);
        if (r18 == null) goto L33;
        r15 = StringsKt.trim(r18).toString();
        goto L44
    L33:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L44:
        return new h(r13, r12, r17, r15);
    L36:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L40;
        Context r19 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L40:
        return null;
    L25:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L26:
        r17 = "";
        goto L28
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L11:
        r13 = -1;
        goto L13
    L43:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static List c(JSONObject r15) {
    L44:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L49;
        Context r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L49:
        if (("parseEventConfigDsl error = " + e + ".message") == null) goto L51;
        Context r16 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L51:
        return null;
    L4:
        if (r15.has("event") == true) goto L6;
        return null;
    L6:
        JSONArray r17 = JSONObjectProtectorUtils.getJSONArray(r15, "event");     // Catch: Exception -> L44
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L44
        int r10 = r17.length();     // Catch: Exception -> L44
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L43;
        JSONObject r12 = JSONArrayProtectorUtils.getJSONObject(r17, r11);     // Catch: Exception -> L44
        String r13 = JSONObjectProtectorUtils.getString(r12, "type");     // Catch: Exception -> L44
        EventType r14 = EventType.CLICK;     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r13, r14.getValue()) == true) goto L22;
        r14 = EventType.CHECK;     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r13, r14.getValue()) == true) goto L22;
        r14 = EventType.UNCHECK;     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r13, r14.getValue()) == true) goto L22;
        r14 = EventType.MAP;     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r13, r14.getValue()) == true) goto L22;
        r14 = EventType.UNKNOWN;     // Catch: Exception -> L44
    L22:
        if (r14 == EventType.UNKNOWN) goto L42;
        d r18 = e(r12);     // Catch: Exception -> L44
        if (r14 != EventType.MAP) goto L40;
        JSONObject r19 = JSONObjectProtectorUtils.getJSONObject(r12, "map");     // Catch: Exception -> L44
        Iterator<String> r20 = r19.keys();     // Catch: Exception -> L44
        LinkedHashMap r21 = new LinkedHashMap();     // Catch: Exception -> L44
    L28:
        if (r20.hasNext() == false) goto L41;
        String r110 = r20.next();     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r110, EventTextType.NUMBER.getValue()) == true) goto L31;
        EventTextType r111 = EventTextType.DEFAULT;     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r110, r111.getValue()) == false) goto L28;
        if (r19.has(r111.getValue()) == false) goto L28;
        JSONArray r112 = JSONObjectProtectorUtils.getJSONArray(r19, r111.getValue());     // Catch: Exception -> L44
        int r113 = r112.length();     // Catch: Exception -> L44
        int r114 = 0;
    L38:
        if (r114 >= r113) goto L28;
        JSONObject r115 = JSONArrayProtectorUtils.getJSONObject(r112, r114);     // Catch: Exception -> L44
        r21.put(JSONObjectProtectorUtils.getString(r115, "text"), e(r115));     // Catch: Exception -> L44
        r114 = r114 + 1;     // Catch: Exception -> L44
        goto L38
    L31:
        r21.put(r110, e(JSONObjectProtectorUtils.getJSONObject(r19, r110)));     // Catch: Exception -> L44
    L41:
        r1.add(new com.bytedance.android.accessibilityLib_Core.config.remote.dsl.b(r14, r18, r21));     // Catch: Exception -> L44
        goto L42
    L40:
        r21 = null;
    L42:
        r11 = r11 + 1;
        goto L7
    L43:
        return r1;
    }

    public static h[] d(JSONObject r10) {
    L21:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L25;
        Context r11 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L25:
        return null;
    L4:
        if (r10.has("hide_exclude") == true) goto L6;
        return null;
    L6:
        JSONArray r12 = JSONObjectProtectorUtils.getJSONArray(r10, "hide_exclude");     // Catch: Exception -> L21
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L21
        int r13 = r12.length();     // Catch: Exception -> L21
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L13;
        h r15 = b(JSONArrayProtectorUtils.getString(r12, r14));     // Catch: Exception -> L21
        if (com.bytedance.android.accessibilityLib_Core.config.remote.dsl.a.b(r15) == false) goto L11;
        r0.add(r15);     // Catch: Exception -> L21
    L11:
        r14 = r14 + 1;     // Catch: Exception -> L21
        goto L7
    L13:
        if ((!r0.isEmpty()) == false) goto L20;
        Object[] r16 = r0.toArray(new h[0]);     // Catch: Exception -> L21
        if (r16 == null) goto L18;
        return (h[]) r16;
    L18:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L21
    L20:
        return new h[0];
    }

    public static d e(JSONObject r14) {
        if (r14.has("label") == false) goto L5;
        JSONArray r15 = JSONObjectProtectorUtils.getJSONArray(r14, "label");
        ArrayList r0 = new ArrayList();
        int r1 = r15.length();
        int r10 = 0;
    L7:
        if (r10 >= r1) goto L31;
        JSONObject r11 = JSONArrayProtectorUtils.getJSONObject(r15, r10);
        ArrayList r12 = new ArrayList();
        if (r11.has(com.bytedance.android.ec.core.event.a.KEY_LIST) == false) goto L21;
        JSONArray r13 = JSONObjectProtectorUtils.getJSONArray(r11, com.bytedance.android.ec.core.event.a.KEY_LIST);
        int r16 = r13.length();
        int r17 = 0;
    L11:
        if (r17 >= r16) goto L21;
        JSONObject r18 = JSONArrayProtectorUtils.getJSONObject(r13, r17);
        e r19 = null;
        if (r18.has(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE) == false) goto L16;
        r19 = new e(JSONObjectProtectorUtils.getString(r18, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE), true, null);
    L18:
        if (r19 == null) goto L20;
        r12.add(r19);
    L20:
        r17 = r17 + 1;
        goto L11
    L16:
        if (r18.has("aid") == false) goto L18;
        String r110 = JSONObjectProtectorUtils.getString(r18, "aid");
        r19 = new e(r110, false, b(r110));
    L21:
        ArrayList r20 = new ArrayList();
        if (r11.has("terms") == false) goto L29;
        JSONArray r21 = JSONObjectProtectorUtils.getJSONArray(r11, "terms");
        int r22 = r21.length();
        int r23 = 0;
    L24:
        if (r23 >= r22) goto L29;
        h r111 = f(JSONArrayProtectorUtils.getJSONObject(r21, r23), "aid");
        if (com.bytedance.android.accessibilityLib_Core.config.remote.dsl.a.b(r111) == false) goto L28;
        r20.add(r111);
    L28:
        r23 = r23 + 1;
    L29:
        r0.add(new com.bytedance.android.accessibilityLib_Core.config.remote.dsl.c(r12, r20));
        r10 = r10 + 1;
        goto L7
    L31:
        return new d(r0);
    L5:
        return new d(0);
    }

    public static h f(JSONObject r10, String r11) {
    L8:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L12;
        Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L12:
        return null;
    L4:
        if (r10.has(r11) == true) goto L6;
        return null;
    L6:
        return b(JSONObjectProtectorUtils.getString(r10, r11));
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final Object a(Boolean r43, Continuation<? super List<f>> r44) {
        if ((r44 instanceof ParseStep$excute$1) == false) goto L7;
        ParseStep$excute$1 r10 = (ParseStep$excute$1) r44;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r0 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        int r14 = 0;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        ParseStep r15 = (ParseStep) r10.L$0;
        ResultKt.throwOnFailure(r0);
    L27:
        j6.b r1 = (j6.b) r0;
        if (r1 == null) goto L216;
        String r16 = r1.a;
        r15.getClass();
        String r17 = "selectMode";
        String r18 = "label_mode";
        String r19 = "desc";
        if (r16 == null) goto L216;
        JSONArray r110 = new JSONArray(r16);     // Catch: Exception -> L208
        if (("original jsonObject = " + r110) == null) goto L34;
        Context r20 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L208
    L34:
        ArrayList r111 = new ArrayList();     // Catch: Exception -> L208
        int r21 = r110.length();     // Catch: Exception -> L208
    L35:
        if (r14 >= r21) goto L207;
        JSONObject r22 = JSONArrayProtectorUtils.getJSONObject(r110, r14);     // Catch: Exception -> L208
        String r23 = JSONObjectProtectorUtils.getString(r22, "activity_id");     // Catch: Exception -> L208
        int r45 = r21;
        JSONArray r24 = JSONObjectProtectorUtils.getJSONArray(r22, "rules");     // Catch: Exception -> L208
        JSONArray r112 = r110;
        ArrayList r113 = new ArrayList();     // Catch: Exception -> L208
        ParseStep r114 = r15;
        int r25 = r24.length();     // Catch: Exception -> L205
        int r115 = r14;
        int r26 = 0;
    L39:
        if (r26 >= r25) goto L203;
        int r116 = r25;
        JSONObject r27 = JSONArrayProtectorUtils.getJSONObject(r24, r26);     // Catch: Exception -> L205
        h r28 = f(r27, "aid");     // Catch: Exception -> L205
    L47:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L52;
        Context r29 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L52:
        String r30 = "";
    L241:
    L59:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L64;
        Context r31 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L64:
        String r210 = "";
    L245:
    L71:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L75;
        Context r32 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L75:
        String r117 = "";
    L77:
        String r40 = r18;
        boolean r211 = r27.optBoolean("overwrite", false);     // Catch: Exception -> L80
    L243:
        if (r27.has(r17) == false) goto L91;
        String r33 = JSONObjectProtectorUtils.getString(r27, r17);     // Catch: Exception -> L110
    L92:
        if (r33 != null) goto L94;
        String r41 = r17;
    L247:
        SelectMode r34 = SelectMode.Default;     // Catch: Exception -> L108
    L107:
        SelectMode r212 = r34;
        boolean r213 = r27.optBoolean("disableClick", false);     // Catch: Exception -> L119
    L124:
        if (r117 != null) goto L127;
    L132:
        LabelMode r35 = LabelMode.Append;     // Catch: Exception -> L205
    L133:
        LabelMode r214 = r35;
        if (Intrinsics.areEqual(r27.optString("type", ""), "dialog") == false) goto L137;
        ConfigType r36 = ConfigType.Dialog;     // Catch: Exception -> L139
    L138:
        ConfigType r215 = r36;
        String r216 = r27.optString("panelTitle", "");     // Catch: Exception -> L147
    L249:
        boolean r37 = r27.optBoolean("verify", false);     // Catch: Exception -> L156
    L227:
    L170:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L174;
        Context r38 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L174:
        String r39 = "";
    L237:
        if (r27.has("classType") == false) goto L183;
        ClassType r42 = ClassType.Default;     // Catch: Exception -> L185
        String r46 = r27.optString("classType", r42.getValue());     // Catch: Exception -> L185
        ClassType r118 = ClassType.Button;     // Catch: Exception -> L185
        if (Intrinsics.areEqual(r46, r118.getValue()) == true) goto L182;
        r118 = ClassType.EditText;     // Catch: Exception -> L185
        if (Intrinsics.areEqual(r46, r118.getValue()) == true) goto L182;
    L190:
        ClassType r310 = r42;
    L191:
        boolean r47 = StringsKt.equals("disable", r30, true);     // Catch: Exception -> L205
        h r311 = f(r27, "before");     // Catch: Exception -> L205
        h r312 = f(r27, "next");     // Catch: Exception -> L205
        h[] r313 = d(r27);     // Catch: Exception -> L205
        d r314 = e(r27);     // Catch: Exception -> L205
        List r315 = c(r27);     // Catch: Exception -> L205
        if (com.bytedance.android.accessibilityLib_Core.config.remote.dsl.a.b(r28) == true) goto L194;
        Context r48 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L202:
        r26 = r26 + 1;     // Catch: Exception -> L205
        r25 = r116;
        r24 = r24;
        r19 = r19;
        r18 = r40;
        r17 = r41;
        goto L39
    L194:
        if (r47 == true) goto L196;
        boolean r217 = true;
    L197:
        g r49 = new g(r210, r28, r217, r211, r212, r213, r214, r215, r216, r313, r314, r311, r312, r315, r37, r39, r310);     // Catch: Exception -> L205
        if (("had paresd >>> viewConfigDsl = " + r49) == null) goto L200;
        Context r50 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L200:
        r113.add(r49);     // Catch: Exception -> L205
        goto L202
    L196:
        r217 = false;
    L182:
        r310 = r118;
        goto L191
    L183:
        r42 = ClassType.Default;     // Catch: Exception -> L185
        goto L190
    L185:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L189;
        Context r51 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L189:
        r42 = ClassType.Default;     // Catch: Exception -> L205
        goto L190
    L165:
        if (r27.has("onlyAppMode") == false) goto L168;
        String r52 = r27.optString("onlyAppMode", "");     // Catch: Exception -> L170
    L169:
        r39 = r52;
        goto L237
    L168:
        r52 = "";
    L156:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L163;
        Context r53 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L163:
        r37 = false;
        goto L227
    L147:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L151;
        Context r54 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L151:
        r216 = "";
        goto L249
    L137:
        r36 = ConfigType.Normal;     // Catch: Exception -> L139
        goto L138
    L139:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L143;
        Context r55 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L143:
        r36 = ConfigType.Normal;     // Catch: Exception -> L205
        goto L138
    L127:
        if (r117.hashCode() != 1094496948) goto L132;
        if (r117.equals("replace") == false) goto L132;
        r35 = LabelMode.Replace;     // Catch: Exception -> L205
        goto L133
    L119:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L123;
        Context r56 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L123:
        r213 = false;
    L108:
        e = e;
    L113:
        if (("Try exception occur " + e.getMessage()) == null) goto L115;
        Context r57 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L115:
        r34 = SelectMode.Default;     // Catch: Exception -> L205
        goto L107
    L94:
        int r58 = r33.hashCode();     // Catch: Exception -> L110
        r41 = r17;
        if (r58 == (-1298848381)) goto L104;
        if (r58 != 1671308008) goto L247;
        if (r33.equals("disable") == false) goto L247;
        r34 = SelectMode.Disable;     // Catch: Exception -> L108
        goto L107
    L104:
        if (r33.equals("enable") == false) goto L247;
        r34 = SelectMode.Enable;     // Catch: Exception -> L108
        goto L107
    L91:
        r33 = "";
    L110:
        e = e;
        r41 = r17;
    L80:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L87;
        Context r59 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L205
    L87:
        r211 = false;
        goto L243
    L66:
        if (r27.has(r18) == false) goto L69;
        String r60 = JSONObjectProtectorUtils.getString(r27, r18);     // Catch: Exception -> L71
    L70:
        r117 = r60;
        goto L77
    L69:
        r60 = "";
        goto L70
    L54:
        if (r27.has(r19) == false) goto L57;
        String r61 = r27.optString(r19, "");     // Catch: Exception -> L59
    L58:
        r210 = r61;
        goto L245
    L57:
        r61 = "";
        goto L58
    L42:
        if (r27.has("focus") == false) goto L45;
        String r62 = JSONObjectProtectorUtils.getString(r27, "focus");     // Catch: Exception -> L47
    L46:
        r30 = r62;
        goto L241
    L45:
        r62 = "";
        goto L46
    L203:
        String r410 = r17;
        String r411 = r18;
        String r316 = r19;
        r111.add(new f(r23, r113));     // Catch: Exception -> L205
        r14 = r115 + 1;
        r21 = r45;
        r110 = r112;
        r15 = r114;
        r19 = r316;
        r18 = r411;
        r17 = r410;
    L205:
        e = e;
    L211:
        if (("Try exception occur " + e.getMessage()) == null) goto L214;
        Context r63 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L214:
        if (("parse config error , " + e.getMessage()) == null) goto L217;
        Context r64 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L217:
        r111 = null;
        ParseStep r65 = r114;
    L218:
        r65.a = r111;
        if (("ParseStep excute parsedConfig = " + r65.a) == null) goto L221;
        Context r66 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L221:
        r65.b = true;
        return r65.a;
    L207:
        r65 = r15;
    L208:
        e = e;
        r114 = r15;
    L216:
        r114 = r15;
        goto L217
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (this.b == true) goto L17;
    L20:
        Context r67 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        b r68 = this.c;
        Boolean r69 = Boxing.boxBoolean(false);
        r10.L$0 = this;
        r10.label = 1;
        r68.getClass();
        j6.a r70 = r68.a;
        if (r69 == null) goto L23;
        r69.booleanValue();
    L23:
        ConfigFileProviderMode r71 = ConfigFileProviderMode.LOCAL;
        r0 = r70.a();
        if (r0 != r12) goto L26;
        return r12;
    L26:
        r15 = this;
        goto L27
    L17:
        if (Intrinsics.areEqual(r43, Boxing.boxBoolean(false)) == false) goto L20;
        return this.a;
    L7:
        r10 = new ParseStep$excute$1(this, r44);
        goto L8
    }
}
