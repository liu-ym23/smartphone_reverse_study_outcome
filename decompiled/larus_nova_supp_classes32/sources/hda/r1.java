package hda;

import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r1 {
    public static final r1 a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;
    public static final List<String> d = null;

    public r1() {
    }

    static {
        a = new r1();
        b = CollectionsKt.listOf(new String[]{"sandboxImageUri", "imageUri", "screenshotUri", "sourceImageUri", "sourceScreenshot", "source_screenshot", "screenshotPath", "screenshot_path", "contentUrl", "content_url", LynxResourceModule.URI_KEY, LynxEventReporter.PROP_NAME_URL, SVGRenderEngine.PATH, "localPath", "local_path", "filePath", "file_path", "screenshot"});
        c = CollectionsKt.listOf(new String[]{"sourceText", "source_text", "originalText", "original_text", "rawText", "raw_text", "screenText", "screen_text", "pageText", "page_text", "ocrText", "ocr_text", "text", LynxAccessibilityModule.MSG_CONTENT, "message"});
        d = CollectionsKt.listOf(new String[]{"sourceQuery", "source_query", "query"});
    }

    public static List j() {
        return CollectionsKt.listOf(new String[]{"rawObservations", "sourceEvidence", "evidenceList", "sources"});
    }

    public static String c(String r3) {
        if (r3 == null) goto L7;
        String r1 = StringsKt.trim(r3).toString();
        if (r1 == null) goto L7;
        String r2 = r1.toLowerCase(Locale.ROOT);
    L9:
        if (Intrinsics.areEqual(r2, "user") == false) goto L12;
        return "用户";
    L12:
        if (Intrinsics.areEqual(r2, "assistant") == false) goto L14;
        return "豆包";
    L14:
        if (r3 == null) goto L19;
        if ((!StringsKt.isBlank(r3)) == false) goto L19;
        return r3;
    L19:
        return null;
    L7:
        r2 = null;
        goto L9
    }

    public static List d(final Object r6) {
        int r1 = 0;
        if ((r6 instanceof String) == false) goto L48;
        String r7 = StringsKt.trim((String) r6).toString();
        if (StringsKt.isBlank(r7) == false) goto L58;
        return CollectionsKt.emptyList();
    L58:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        if (StringsKt.startsWith$default(r7, "{", false, 2, null) == false) goto L12;
        List r4 = d(new JSONObject(r7));     // Catch: Throwable -> L17
    L15:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L17
    L19:
        List r8 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r5) == false) goto L22;
        r5 = r8;
    L22:
        List r9 = (List) r5;
        if ((!r9.isEmpty()) == true) goto L62;
        String r10 = StringsKt.trim(r7).toString();
        if (StringsKt.isBlank(r10) == false) goto L29;
    L41:
        r10 = null;
    L42:
        if (r10 == null) goto L44;
        List r11 = CollectionsKt.listOf(r10);
    L45:
        if (r11 == null) goto L64;
        return r11;
    L64:
        return CollectionsKt.emptyList();
    L44:
        r11 = null;
        goto L45
    L29:
        if (StringsKt.startsWith$default(r10, "http://", false, 2, null) == true) goto L41;
        if (StringsKt.startsWith$default(r10, "https://", false, 2, null) == true) goto L41;
        if (StringsKt.startsWith$default(r10, "content://", false, 2, null) == true) goto L42;
        if (StringsKt.startsWith$default(r10, "file://", false, 2, null) == true) goto L42;
        if (StringsKt.startsWith$default(r10, "/", false, 2, null) == false) goto L41;
        r10 = "file://" + r10;
        goto L42
    L62:
        return r9;
    L12:
        if (StringsKt.startsWith$default(r7, "[", false, 2, null) == false) goto L14;
        r4 = d(new JSONArray(r7));     // Catch: Throwable -> L17
        goto L15
    L14:
        r4 = CollectionsKt.emptyList();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L48:
        if ((r6 instanceof JSONObject) == false) goto L51;
        return SequencesKt.toList(SequencesKt.distinct(SequencesKt.flatMap(SequencesKt.filter(CollectionsKt.asSequence(b), new m1(r6)), new n1(r6))));
    L51:
        if ((r6 instanceof JSONArray) == false) goto L57;
        ArrayList r0 = new ArrayList();
        JSONArray r13 = (JSONArray) r6;
        int r2 = r13.length();
    L53:
        if (r1 >= r2) goto L66;
        r0.addAll(d(r13.opt(r1)));
        r1 = r1 + 1;
        goto L53
    L66:
        return CollectionsKt.distinct(r0);
    L57:
        return CollectionsKt.emptyList();
    }

    public static boolean e(JSONObject r4) {
        if (Intrinsics.areEqual(f1.a(r4, new String[]{"type", "sourceType", "source_type"}), "dialog_bubble") == false) goto L5;
        return true;
    L5:
        boolean r2 = false;
        String[] r0 = (String[]) d.toArray(new String[0]);
        String r5 = f1.a(r4, (String[]) Arrays.copyOf(r0, r0.length));
        if (r5 != null) goto L8;
    L9:
        r2 = true;
    L11:
        return !r2;
    L8:
        if (StringsKt.isBlank(r5) == false) goto L11;
        goto L9
    }

    public static e1 f(q0 r1) {
        Intrinsics.checkNotNullParameter(r1, "record");
        return h(r1, true);
    }

    public static boolean i(o0 r4) {
        if (Intrinsics.areEqual(r4.c(new String[]{"sourceType"}), "dialog_bubble") == false) goto L5;
        return true;
    L5:
        boolean r2 = false;
        String[] r0 = (String[]) d.toArray(new String[0]);
        String r1 = r4.c((String[]) Arrays.copyOf(r0, r0.length));
        if (r1 != null) goto L8;
    L9:
        r2 = true;
    L10:
        if (r2 == true) goto L12;
        return true;
    L12:
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        Iterator r5 = j().iterator();
    L14:
        if (r5.hasNext() == false) goto L19;
        JSONArray r6 = r4.a((String) r5.next());
        if (r6 == null) goto L14;
        f1.b(r6, new q1(r3));
        goto L14
    L19:
        return r3.element;
    L8:
        if (StringsKt.isBlank(r1) == false) goto L10;
        goto L9
    }

    public final List<d> g(String r7) {
        String r0 = StringsKt.trim(r7).toString();
        List<d> r4 = null;
        if (StringsKt.startsWith$default(r0, "[", false, 2, null) == false) goto L5;
    L31:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L13
        if (StringsKt.startsWith$default(r0, "[", false, 2, null) == false) goto L10;
        JSONArray r1 = new JSONArray(r0);     // Catch: Throwable -> L13
    L11:
        final ArrayList r2 = new ArrayList();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L13
        f1.b(r1, new h1(r2, this));     // Catch: Throwable -> L13
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L13
    L15:
        List r6 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r3) == false) goto L18;
        r3 = r6;
    L18:
        List<d> r8 = (List) r3;
    L20:
        if ((!r8.isEmpty()) == true) goto L23;
        r8 = null;
    L23:
        if (r8 == null) goto L25;
        return r8;
    L25:
        List<d> r9 = SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.mapNotNull(StringsKt.lineSequence(r7), new o1()), new p1()));
        if ((!r9.isEmpty()) == false) goto L28;
        r4 = r9;
    L28:
        if (r4 == null) goto L30;
        return r4;
    L30:
        return CollectionsKt.emptyList();
    L10:
        r1 = new JSONArray().put(new JSONObject(r0));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (StringsKt.startsWith$default(r0, "{", false, 2, null) == true) goto L31;
        r8 = CollectionsKt.emptyList();
        goto L20
    }

    public static final void b(List<String> r3, String r4) {
        String r5 = c1.c(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        List<String> r0 = r3;
        boolean r2 = true;
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        if (Intrinsics.areEqual((String) r1.next(), r5) == false) goto L12;
        r2 = false;
    L16:
        if (r2 == false) goto L22;
        r3.add(r5);
        return;
    L22:
        return;
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L10
    }

    public static e1 h(final q0 r38, boolean r39) {
        o0 r1 = new o0(r38);
        String r2 = r1.c(new String[]{"title"});
        if (r2 != null) goto L10;
        r2 = r38.c;
        if (r2 != null) goto L10;
        r2 = r1.c(new String[]{"displayTitle", EasyGoDbTable.Server.NAME, "topic", "keyPhrase", "tagPath", "sourceEntityId", "entityId"});
        if (r2 != null) goto L10;
        r2 = r38.a;
    L10:
        if (r38.b != MemoryDataReviewModuleKey.AUTO_MEMORY_PRO) goto L12;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = StringsKt.trim(r2).toString();
    L13:
        String r9 = r3;
        String r4 = r38.d;
        String r5 = NameKeys.UnloadStrategy_No_Strategy;
        if (r4 != null) goto L18;
        r4 = r1.c(new String[]{"displaySummary", "summaryText", "summary", "memoryContent", "currentContent", LynxAccessibilityModule.MSG_CONTENT, "description", "embeddingContent", "transcriptText"});
        if (r4 != null) goto L18;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r10 = b1.a(r4);
        String r19 = c1.c(r1.c(new String[]{"currentContent", "memoryContent", LynxAccessibilityModule.MSG_CONTENT, "description", "embeddingContent", "summaryText", "displaySummary", "transcriptText"}));
        String r20 = c1.c(r1.c(new String[]{"previousContent", "oldContent", "oldDescription", "previousSummary", "oldSummary", "previousTranscript", "oldTranscript"}));
        String r6 = c1.c(r1.c(new String[]{"diffCurrentContent", "diffCurrentText", "currentKeyPhrase", "keyPhrase"}));
        if (r38.b != MemoryDataReviewModuleKey.PERSONAL_MEMORY) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == true) goto L25;
        r6 = null;
    L25:
        if (r6 != null) goto L29;
        r6 = c1.c(r1.c(new String[]{"diffCurrentContent", "diffCurrentText"}));
        if (r6 != null) goto L29;
        String r21 = r19;
    L30:
        String r8 = c1.c(r1.c(new String[]{"diffPreviousContent", "diffOldContent", "diffOldText", "previousKeyPhrase", "oldKeyPhrase"}));
        if (r8 != null) goto L33;
        String r22 = r20;
    L35:
        if (r38.b == MemoryDataReviewModuleKey.COLLECTION_MEMORY) goto L37;
        if (r19 != null) goto L45;
        String r11 = r10;
    L46:
        final ArrayList r12 = new ArrayList();
        Iterator r13 = CollectionsKt.listOf(new String[]{"chatBubbles", "conversation", "dialogBubbles", "messageBubbles"}).iterator();
    L48:
        if (r13.hasNext() == false) goto L52;
        JSONArray r14 = r1.a((String) r13.next());
        if (r14 == null) goto L48;
        f1.b(r14, new j1(r12));
        goto L48
    L52:
        Iterator r15 = j().iterator();
    L54:
        if (r15.hasNext() == false) goto L59;
        JSONArray r16 = r1.a((String) r15.next());
        if (r16 == null) goto L54;
        f1.b(r16, new k1(r12));
        goto L54
    L59:
        if (r12.isEmpty() == false) goto L66;
        if (i(r1) == false) goto L66;
        String r17 = r1.c(new String[]{"sourceText", "source_text"});
        if (r17 == null) goto L66;
        r12.addAll(a.g(r17));
    L66:
        if (r39 == false) goto L70;
        JSONArray r18 = r1.a("versionRecords");
        if (r18 == null) goto L70;
        Integer r110 = Integer.valueOf(r18.length());
    L72:
        if (r38.b != MemoryDataReviewModuleKey.PERSONAL_MEMORY) goto L92;
        String[] r111 = {"type", "productType", "product_type"};
        Intrinsics.checkNotNullParameter(r111, "keys");
        int r112 = 0;
    L76:
        if (r112 >= 3) goto L86;
        String r113 = r111[r112];
        if (r1.a.has(r113) == false) goto L85;
        if (r1.a.isNull(r113) == true) goto L85;
        Integer r23 = StringsKt.toIntOrNull(r1.a.optString(r113));
        if (r23 == null) goto L85;
        Integer r24 = Integer.valueOf(r23.intValue());
    L87:
        if (r24 == null) goto L92;
        if (r24.intValue() != 1001) goto L92;
        boolean r25 = true;
    L94:
        if (r38.b != MemoryDataReviewModuleKey.AUTO_MEMORY_PRO) goto L112;
        Long r114 = r1.b(new String[]{"modifyTime", "modify_time"});
        if (r114 != null) goto L98;
    L111:
        r5 = p0.a(r38);
    L113:
        String r26 = r38.a;
        MemoryDataReviewModuleKey r115 = r38.b;
        String r27 = r5;
        String r28 = r11;
        String r29 = r1.c(new String[]{"sourceEntityId", "source_entity_id", "entityId", "entity_id"});
        String r116 = r1.d();
        JSONObject r30 = r1.a.optJSONObject("sourceInfo");
        if (r30 == null) goto L117;
        String r31 = p0.b(r30, "packageName");
        if (r31 == null) goto L117;
    L120:
        String r117 = r31;
        if (r25 == false) goto L123;
        final List r32 = CollectionsKt.emptyList();
        String r33 = r29;
        String r34 = r10;
        String r210 = r116;
    L139:
        if (r25 == false) goto L141;
        List r35 = CollectionsKt.emptyList();
    L142:
        if (r25 == false) goto L144;
        List r36 = CollectionsKt.emptyList();
    L156:
        String r37 = r1.c(new String[]{"availableVersionCount", "versionCount"});
        if (r37 == null) goto L161;
        Integer r40 = StringsKt.toIntOrNull(r37);
        if (r40 == null) goto L161;
        int r41 = RangesKt.coerceAtLeast(r40.intValue() - 1, 0);
    L181:
        int r310 = r41;
    L183:
        if (r39 == false) goto L188;
        final ArrayList r42 = new ArrayList();
        JSONArray r43 = r1.a("versionRecords");
        if (r43 == null) goto L187;
        f1.b(r43, new i1(r38, r42));
    L187:
        List<e1> r44 = f1.d(r42);
    L190:
        return new e1(r26, r115, r9, r34, r28, r33, r27, r210, r117, r32, r35, r36, r19, r20, r21, r22, r310, r44, r38.e, r38.g);
    L188:
        r44 = CollectionsKt.emptyList();
    L161:
        if (r110 != null) goto L163;
    L171:
        String r45 = r1.c(new String[]{"updateCount", "updateTimes"});
        if (r45 == null) goto L176;
        Integer r46 = StringsKt.toIntOrNull(r45);
        if (r46 == null) goto L176;
        r41 = RangesKt.coerceAtLeast(r46.intValue(), 0);
    L176:
        String r47 = r1.c(new String[]{"snapshotVersion", "version"});
        if (r47 == null) goto L182;
        Integer r48 = StringsKt.toIntOrNull(r47);
        if (r48 == null) goto L182;
        r41 = RangesKt.coerceAtLeast(r48.intValue() - 1, 0);
    L182:
        r310 = 0;
        goto L183
    L163:
        if (r110.intValue() <= 0) goto L165;
        boolean r49 = true;
    L166:
        if (r49 == false) goto L168;
        Integer r118 = r110;
    L169:
        if (r118 == null) goto L171;
        r41 = RangesKt.coerceAtLeast(r118.intValue() - 1, 0);
        goto L181
    L168:
        r118 = null;
        goto L169
    L165:
        r49 = false;
        goto L166
    L144:
        final ArrayList r50 = new ArrayList();
        if (r12.isEmpty() == true) goto L147;
    L149:
        b(r50, r1.c(new String[]{"originalText", "original_text", "rawText", "raw_text"}));
        b(r50, r1.c(new String[]{"screenText", "screen_text", "pageText", "page_text", "ocrText", "ocr_text"}));
        Iterator r51 = j().iterator();
    L151:
        if (r51.hasNext() == false) goto L155;
        JSONArray r52 = r1.a((String) r51.next());
        if (r52 == null) goto L151;
        f1.b(r52, new l1(r50));
        goto L151
    L155:
        r36 = r50;
        goto L156
    L147:
        if (i(r1) == true) goto L149;
        b(r50, r1.c(new String[]{"sourceText", "source_text"}));
        goto L149
    L141:
        r35 = r12;
        goto L142
    L123:
        r32 = new ArrayList();
        final HashSet r119 = new HashSet();
        Iterator<T> r211 = b.iterator();
    L125:
        if (r211.hasNext() == false) goto L133;
        String r212 = r116;
        String r120 = (String) r211.next();
        String r311 = r29;
        if (r1.a.has(r120) == false) goto L132;
        if (r1.a.isNull(r120) == true) goto L132;
        a(r119, r32, "图片", r1.a.opt(r120), null);
    L132:
        r116 = r212;
        r29 = r311;
        r10 = r10;
        goto L125
    L133:
        r33 = r29;
        r34 = r10;
        r210 = r116;
        Iterator r53 = CollectionsKt.plus(j(), CollectionsKt.listOf(new String[]{"images", "screenshots"})).iterator();
    L135:
        if (r53.hasNext() == false) goto L139;
        final String r121 = (String) r53.next();
        JSONArray r122 = r1.a(r121);
        if (r122 == null) goto L135;
        f1.b(r122, new g1(r121, r119, r32));
        r53 = r53;
    L117:
        r31 = p0.b(r1.a, "sourcePackageName");
        if (r31 != null) goto L120;
        r31 = p0.b(r1.a, "sourceAppPackage");
        goto L120
    L98:
        if (r114.longValue() <= 0) goto L100;
        boolean r123 = true;
    L101:
        if (r123 == true) goto L104;
        r114 = null;
    L104:
        if (r114 == null) goto L111;
        long r124 = r114.longValue();
        if (r124 <= 0) goto L109;
        r5 = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r124));
    L109:
        if (r5 == null) goto L111;
    L100:
        r123 = false;
        goto L101
    L112:
        r5 = p0.a(r38);
    L85:
        r112 = r112 + 1;
        goto L76
    L86:
        r24 = null;
    L92:
        r25 = false;
    L70:
        r110 = null;
    L45:
        r11 = r19;
        goto L46
    L37:
        if ((!StringsKt.isBlank(r10)) == false) goto L39;
        r11 = r10;
    L40:
        if (r11 != null) goto L46;
        if (r19 != null) goto L45;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
        goto L46
    L39:
        r11 = null;
        goto L40
    L33:
        r22 = r8;
    L29:
        r21 = r6;
        goto L30
    L21:
        r7 = false;
        goto L22
    L12:
        r3 = c1.b(r2);
        goto L13
    }

    public static final void a(HashSet<String> r2, List<h0> r3, String r4, Object r5, String r6) {
        a.getClass();
        Iterator r7 = d(r5).iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        String r0 = (String) r7.next();
        if (r2.add(r0) == false) goto L4;
        r3.add(new h0(r4, r0, r6));
        goto L4
    }
}
