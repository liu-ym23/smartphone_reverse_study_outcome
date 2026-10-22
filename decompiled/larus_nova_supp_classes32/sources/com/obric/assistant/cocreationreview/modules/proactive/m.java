package com.obric.assistant.cocreationreview.modules.proactive;

import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.s3;
import com.obric.memorydata.sdk.proactive.ProactiveRecommendationDto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Vote.values().length];
            r0[Vote.UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Vote.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final boolean b(ProactiveRecommendationDto r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return StringsKt.equals(r2.getType(), "ai_proactive", true);
    }

    public static final List<com.obric.assistant.cocreationreview.modules.proactive.a> c(String r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r12 = Result.constructor-impl(new JSONArray(r11));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r12) == false) goto L9;
        r12 = null;
    L9:
        JSONArray r13 = (JSONArray) r12;
        if (r13 == null) goto L12;
        List r1 = CollectionsKt.createListBuilder();
        LinkedHashSet r2 = new LinkedHashSet();
        int r3 = r13.length();
        int r5 = 0;
    L14:
        if (r5 >= r3) goto L51;
        JSONObject r6 = r13.optJSONObject(r5);
        if (r6 == null) goto L18;
        String r7 = r6.optString("title");
    L19:
        String r8 = NameKeys.UnloadStrategy_No_Strategy;
        if (r7 != null) goto L23;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
    L23:
        if (StringsKt.isBlank(r7) == false) goto L30;
        if (r6 == null) goto L26;
        r7 = r6.optString("execute_instruction");
    L27:
        if (r7 != null) goto L30;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
        goto L30
    L26:
        r7 = null;
    L30:
        if (StringsKt.isBlank(r7) == false) goto L38;
        if (r6 == null) goto L33;
        String r9 = r6.optString(LynxAccessibilityModule.MSG_CONTENT);
    L34:
        if (r9 == null) goto L37;
        r8 = r9;
    L37:
        r7 = r8;
        goto L38
    L33:
        r9 = null;
    L38:
        String r10 = StringsKt.trim(r7).toString();
        boolean r14 = true;
        if ((!StringsKt.isBlank(r10)) == false) goto L49;
        if (r2.add(r10) == false) goto L49;
        if (r6 != null) goto L45;
    L47:
        r14 = false;
    L48:
        r1.add(new com.obric.assistant.cocreationreview.modules.proactive.a(r10, r14));
        goto L49
    L45:
        if (r6.optInt("status", 0) != 1) goto L47;
    L49:
        r5 = r5 + 1;
        goto L14
    L18:
        r7 = null;
        goto L19
    L51:
        return CollectionsKt.build(r1);
    L12:
        return CollectionsKt.emptyList();
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final List<com.obric.assistant.cocreationreview.modules.proactive.a> d(String r4) {
        com.obric.assistant.cocreationreview.modules.proactive.a r0 = null;
        if (r4 == null) goto L5;
        String r5 = StringsKt.trim(r4).toString();
    L6:
        if (r5 != null) goto L9;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        if (StringsKt.isBlank(r5) == false) goto L13;
        return CollectionsKt.emptyList();
    L13:
        if (StringsKt.startsWith$default(r5, "[", false, 2, null) == true) goto L15;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        Object r6 = Result.constructor-impl(new JSONObject(r5));     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r6) == false) goto L23;
        r6 = null;
    L23:
        JSONObject r7 = (JSONObject) r6;
        if (r7 == null) goto L26;
        String r2 = r7.optString("raw_action_list");
        Intrinsics.checkNotNull(r2);
        if ((!StringsKt.isBlank(r2)) == true) goto L31;
        r2 = null;
    L31:
        if (r2 == null) goto L33;
        List<com.obric.assistant.cocreationreview.modules.proactive.a> r3 = c(r2);
    L34:
        if (r3 != null) goto L37;
        r3 = CollectionsKt.emptyList();
    L37:
        if ((!r3.isEmpty()) == false) goto L39;
        return r3;
    L39:
        String r8 = r7.optString("current_title");
        Intrinsics.checkNotNull(r8);
        if ((!StringsKt.isBlank(r8)) == true) goto L43;
        r8 = null;
    L43:
        if (r8 != null) goto L48;
        r8 = r7.optString("current_instruction");
        Intrinsics.checkNotNull(r8);
        if ((!StringsKt.isBlank(r8)) == true) goto L48;
        r8 = null;
    L48:
        if (r8 == null) goto L51;
        r0 = new com.obric.assistant.cocreationreview.modules.proactive.a(r8, false);
    L51:
        return CollectionsKt.listOfNotNull(r0);
    L33:
        r3 = null;
        goto L34
    L26:
        return CollectionsKt.emptyList();
    L18:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L15:
        return c(r5);
    L5:
        r5 = null;
        goto L6
    }

    public static final String e(ProactiveRecommendationDto r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r0 = StringsKt.trim(r4.r).toString();
        if (StringsKt.isBlank(r0) == false) goto L6;
        r0 = StringsKt.trim(r4.a).toString();
    L6:
        if (StringsKt.isBlank(r0) == false) goto L17;
        String r1 = StringsKt.trim(r4.b).toString();
        String r2 = null;
        if ((!StringsKt.isBlank(r1)) == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        r2 = r1 + ':' + r4.j;
    L13:
        if (r2 != null) goto L15;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
        goto L17
    L15:
        r0 = r2;
    L17:
        if (StringsKt.isBlank(r0) == true) goto L19;
        return r0;
    L19:
        return "created:" + r4.j;
    }

    public static final q f(ProactiveRecommendationDto r40) {
        Intrinsics.checkNotNullParameter(r40, "<this>");
        Intrinsics.checkNotNullParameter(r40, "dto");
        String r2 = "proactive:" + e(r40);
        List r0 = r40.i;
        if ((!r0.isEmpty()) == true) goto L7;
        r0 = null;
    L7:
        if (r0 != null) goto L43;
        String r1 = r40.h;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L20
        if (r1 != null) goto L12;
    L17:
        JSONObject r7 = null;
    L18:
        Object r3 = Result.constructor-impl(r7);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r3) == false) goto L25;
        r3 = null;
    L25:
        JSONObject r4 = (JSONObject) r3;
        if (r4 != null) goto L28;
        r0 = CollectionsKt.emptyList();
        goto L43
    L28:
        JSONArray r5 = r4.optJSONArray("packages");
        if (r5 != null) goto L31;
        r0 = CollectionsKt.emptyList();
        goto L43
    L31:
        List r8 = CollectionsKt.createListBuilder();
        int r9 = r5.length();
        int r10 = 0;
    L32:
        if (r10 >= r9) goto L42;
        String r11 = r5.optString(r10);
        if (r11 == null) goto L41;
        if ((!StringsKt.isBlank(r11)) == true) goto L39;
        r11 = null;
    L39:
        if (r11 == null) goto L41;
        r8.add(r11);
    L41:
        r10 = r10 + 1;
        goto L32
    L42:
        r0 = CollectionsKt.build(r8);
        goto L43
    L12:
        if ((!StringsKt.isBlank(r1)) == true) goto L15;
        r1 = null;
    L15:
        if (r1 == null) goto L17;
        r7 = new JSONObject(r1);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L43:
        List r18 = r0;
        ModuleKey r13 = ModuleKey.PROACTIVE_AGENT;
        String r14 = r40.a;
        String r15 = r40.r;
        String r16 = r40.b;
        long r17 = r40.j;
        String r19 = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r17));
        String r20 = r40.getType();
        if ((!StringsKt.isBlank(r20)) == true) goto L47;
        r20 = null;
    L47:
        if (r20 != null) goto L49;
        String r110 = null;
    L56:
        String r21 = StringsKt.trim(r40.e).toString();
        if (StringsKt.isBlank(r21) == false) goto L59;
        r21 = "💡";
    L59:
        String r111 = r21;
        String r22 = StringsKt.trim(r40.l).toString();
        if (StringsKt.isBlank(r22) == false) goto L62;
        r22 = "无触发原因";
    L62:
        String r23 = r22;
        String r24 = StringsKt.trim(r40.d).toString();
        if (StringsKt.isBlank(r24) == false) goto L65;
        r24 = "无建议内容";
    L65:
        String r25 = r24;
        String r26 = r40.f;
        String r27 = r40.g;
        List r28 = CollectionsKt.createListBuilder();
        List<com.obric.assistant.cocreationreview.modules.proactive.a> r29 = d(r26);
        if (r29.isEmpty() == false) goto L68;
        List<com.obric.assistant.cocreationreview.modules.proactive.a> r30 = d(r27);
    L69:
        List<com.obric.assistant.cocreationreview.modules.proactive.a> r31 = r29;
        if (r31.isEmpty() == false) goto L72;
        List<com.obric.assistant.cocreationreview.modules.proactive.a> r112 = r30;
    L73:
        List<com.obric.assistant.cocreationreview.modules.proactive.a> r113 = r112;
        int r210 = s3.a;
        StringBuilder r32 = new StringBuilder("source=");
        if ((!r31.isEmpty()) == false) goto L77;
        String r33 = "actionCondition";
    L80:
        r32.append(r33);
        r32.append(", count=");
        r32.append(r113.size());
        r32.append(", actions=");
        List<com.obric.assistant.cocreationreview.modules.proactive.a> r34 = r113;
        ArrayList r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));
        Iterator r36 = r34.iterator();
    L82:
        if (r36.hasNext() == false) goto L84;
        com.obric.assistant.cocreationreview.modules.proactive.a r37 = (com.obric.assistant.cocreationreview.modules.proactive.a) r36.next();
        StringBuilder r38 = new StringBuilder();
        r38.append(r37.a);
        r38.append(':');
        r38.append(r37.b);
        r35.add(r38.toString());
        r36 = r36;
        goto L82
    L84:
        r32.append(r35);
        s3.b("proactive_agent.actions", r32.toString());
        r28.addAll(r113);
        if (r28.isEmpty() == true) goto L87;
    L97:
        List r39 = CollectionsKt.build(r28);
        String r41 = r40.o;
        double r42 = r40.k;
        int r43 = r18.size();
        h[] r44 = new h[2];
        if (StringsKt.isBlank(r41) == false) goto L100;
        r41 = "-";
    L100:
        r44[0] = new h("状态", r41);
        r44[1] = new h("评分", String.valueOf((int) r42));
        List r211 = CollectionsKt.mutableListOf(r44);
        if (r43 <= 0) goto L103;
        r211.add(new h("来源", String.valueOf(r43)));
    L103:
        String r114 = r40.h;
        String r45 = r40.m;
        String r46 = r40.g;
        int r47 = r40.n;
        String r48 = r40.s;
        String r49 = r40.t;
        Long r50 = Long.valueOf(r40.u);
        if (r50.longValue() <= 0) goto L106;
        boolean r51 = true;
    L107:
        if (r51 == true) goto L110;
        r50 = null;
    L110:
        if (r50 == null) goto L112;
        long r52 = r50.longValue();
    L113:
        long r53 = r52;
        Intrinsics.checkNotNullParameter(r2, "recordId");
        if (r48 != null) goto L116;
    L119:
        boolean r54 = true;
    L120:
        if (r54 == false) goto L212;
        if (r49 != null) goto L123;
    L126:
        boolean r55 = true;
    L127:
        if (r55 == false) goto L212;
        String r212 = r48;
        int r213 = r47;
        String r310 = r46;
    L202:
        String r311 = r212;
        int r312 = r213;
        a5 r214 = null;
    L211:
        return new q(r2, r13, r14, r15, r16, r17, r19, r110, r111, r23, r25, r39, r211, r18, r114, r45, r310, r312, r311, r214, r40.o, r40.getType(), r40.k, new JSONObject().put("recommendId", r40.a).put("inspirationId", r40.r).put("taskId", r40.b).put("status", r40.o).put("type", r40.getType()).put("created", r40.j).toString());
    L123:
        if (StringsKt.isBlank(r49) == true) goto L126;
        r55 = false;
    L212:
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L140
        if (r49 != null) goto L132;
    L137:
        JSONObject r57 = null;
    L138:
        Object r58 = Result.constructor-impl(r57);     // Catch: Throwable -> L140
    L143:
        if (Result.isFailure-impl(r58) == false) goto L145;
        r58 = null;
    L145:
        JSONObject r59 = (JSONObject) r58;
        Vote.a r60 = Vote.Companion;
        if (r59 == null) goto L148;
        String r61 = r59.optString("vote");
    L149:
        r60.getClass();
        Vote r62 = Vote.a.a(r61);
        if (r62 == null) goto L153;
    L151:
        Vote r63 = r62;
    L159:
        Set r64 = SetsKt.createSetBuilder();
        r212 = r48;
        if (r59 == null) goto L163;
        JSONArray r65 = r59.optJSONArray("reasons");
        if (r65 == null) goto L163;
    L164:
        r213 = r47;
        int r66 = r65.length();
        r310 = r46;
        int r67 = 0;
    L165:
        if (r67 >= r66) goto L176;
        String r313 = r65.optString(r67);
        if (r313 != null) goto L169;
        r65 = r65;
    L175:
        r67 = r67 + 1;
        r65 = r65;
        goto L165
    L169:
        if ((!StringsKt.isBlank(r313)) == false) goto L171;
        String r68 = r313;
    L172:
        if (r68 == null) goto L175;
        r64.add(r68);
        goto L175
    L171:
        r68 = null;
        goto L172
    L176:
        Set r69 = SetsKt.build(r64);
        if (r59 == null) goto L179;
        String r70 = r59.optString("comment");
    L180:
        if (r70 != null) goto L182;
        r70 = NameKeys.UnloadStrategy_No_Strategy;
    L182:
        String r314 = r70;
        if (r59 != null) goto L185;
    L195:
        Integer r71 = null;
    L196:
        if (r63 != null) goto L204;
        if (r69.isEmpty() == false) goto L204;
        if (StringsKt.isBlank(r314) == false) goto L204;
        if (r71 == null) goto L202;
    L204:
        if (r63 != null) goto L206;
    L208:
        boolean r215 = false;
    L209:
        r311 = r212;
        r312 = r213;
        r214 = new a5(r2, r63, r69, r314, r215, r53, r71, 64);
        goto L211
    L206:
        if ((!r69.isEmpty()) == false) goto L208;
        r215 = true;
        goto L209
    L185:
        if (r59.has("feedbackValue") == true) goto L187;
    L189:
        boolean r72 = false;
    L190:
        if (r72 == true) goto L193;
        r59 = null;
    L193:
        if (r59 == null) goto L195;
        r71 = Integer.valueOf(r59.optInt("feedbackValue"));
        goto L196
    L187:
        if (r59.isNull("feedbackValue") == true) goto L189;
        r72 = true;
        goto L190
    L179:
        r70 = null;
    L163:
        r65 = new JSONArray();
        goto L164
    L153:
        if (StringsKt.equals(r48, "LIKE", true) == false) goto L156;
        r62 = Vote.UP;
        goto L151
    L156:
        if (StringsKt.equals(r48, "DISLIKE", true) == false) goto L158;
        r62 = Vote.DOWN;
        goto L151
    L158:
        r63 = null;
        goto L159
    L148:
        r61 = null;
        goto L149
    L132:
        if ((!StringsKt.isBlank(r49)) == true) goto L135;
        r49 = null;
    L135:
        if (r49 == null) goto L137;
        r57 = new JSONObject(r49);     // Catch: Throwable -> L140
    L140:
        th = move-exception;
        Result.Companion r73 = Result.Companion;
        r58 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L143
    L116:
        if (StringsKt.isBlank(r48) == true) goto L119;
        r54 = false;
        goto L120
    L112:
        r52 = r40.j;
        goto L113
    L106:
        r51 = false;
        goto L107
    L87:
        if (r27 != null) goto L89;
    L92:
        boolean r74 = true;
    L93:
        if (r74 == false) goto L95;
        String r75 = "知道了";
    L96:
        r28.add(new com.obric.assistant.cocreationreview.modules.proactive.a(r75, false));
        goto L97
    L95:
        r75 = "立即执行";
        goto L96
    L89:
        if (StringsKt.isBlank(r27) == true) goto L92;
        r74 = false;
        goto L93
    L77:
        if ((!r30.isEmpty()) == false) goto L79;
        r33 = "actionExecuteInstruction";
        goto L80
    L79:
        r33 = "fallback";
        goto L80
    L72:
        r112 = r31;
        goto L73
    L68:
        r30 = CollectionsKt.emptyList();
        goto L69
    L49:
        if (r20.length() <= 0) goto L51;
        boolean r76 = true;
    L52:
        if (r76 == false) goto L54;
        r20 = CharsKt.titlecase(r20.charAt(0), Locale.getDefault()) + r20.substring(1);
    L54:
        r110 = r20;
        goto L56
    L51:
        r76 = false;
        goto L52
    }

    public static boolean a(g5 r4, long r5) {
        long r0 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r4.getClass();
        long r2 = r4.a;
        if (r5 <= RangesKt.coerceAtLeast(r0, r2)) goto L5;
    L7:
        return false;
    L5:
        if (r2 > r5) goto L7;
        return true;
    }
}
