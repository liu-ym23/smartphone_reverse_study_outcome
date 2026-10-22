package com.obric.aiproactive.ui.detail;

import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.n;
import com.obric.aiproactive.ui.feedback.ProactiveVoteStore;
import com.obric.aiproactive.ui.model.l;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002\u001a\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002\u001a\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\fH\u0002\u001a\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001d\u0010\u001d\u001a\u00020\u0016*\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001f\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"buildRecommendationDetailUiState", "Lcom/obric/aiproactive/ui/detail/RecommendationDetailUiState;", "dto", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "selectedVote", "Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore$Vote;", "isIgnoredRecommendation", "", "isAutoDismissedRecommendation", "isManualActionConsumedRecommendation", "isDetailConsumedRecommendation", "extractInstructionText", "", "resolveCurrentRawInstruction", "hasExecutableInstruction", "shouldShowModifyAction", "resolveAiProactiveCurrentInstruction", "parsePresetQuery", "rawInstruction", "extractPresetQueryByText", "buildExecutableActionItems", "", "Lcom/obric/aiproactive/ui/detail/RecommendationActionItemUiState;", "instruction", "buildDetailActionItems", "MAX_DETAIL_ACTIONS", "", "resolveAiProactiveActionItems", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "toSelectedUiState", "actionIndex", "(Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;Ljava/lang/Integer;)Lcom/obric/aiproactive/ui/detail/RecommendationActionItemUiState;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class d {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6565a = null;

        static {
            int[] r0 = new int[RecommendationDetailMode.values().length];
            r0[RecommendationDetailMode.NOTICE_PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[RecommendationDetailMode.NOTICE_KNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[RecommendationDetailMode.NOTICE_IGNORED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[RecommendationDetailMode.EXECUTABLE_DONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[RecommendationDetailMode.EXECUTABLE_PENDING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f6565a = r0;
        }
    }

    private static final com.obric.aiproactive.ui.detail.a a(com.obric.aiproactive.api.b r11, Integer r12) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L5:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r1) == false) goto L8;
        r1 = "-";
    L8:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r2) == false) goto L12;
        r2 = r6;
    L12:
        return new com.obric.aiproactive.ui.detail.a(r6, (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), r6, false, true, r12, r11);
    }

    public static final c a(ProactiveRecommendationDto r14, ProactiveVoteStore.Vote r15) {
        Intrinsics.checkNotNullParameter(r14, "dto");
        List<com.obric.aiproactive.ui.detail.a> r9 = i(r14);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
    L8:
        boolean r16 = true;
    L9:
        boolean r3 = a(r14);
        boolean r4 = d(r14);
        if (r16 == false) goto L13;
        if (r4 == false) goto L13;
        RecommendationDetailMode r17 = RecommendationDetailMode.EXECUTABLE_DONE;
    L20:
        e(r14);
        int r18 = a.f6565a[r17.ordinal()];
        if (r18 == 1) goto L35;
        if (r18 != 2) goto L24;
        String r19 = "已知晓";
    L37:
        if (SetsKt.setOf(new RecommendationDetailMode[]{RecommendationDetailMode.NOTICE_KNOWN, RecommendationDetailMode.NOTICE_IGNORED}).contains(r17) == false) goto L39;
    L43:
        boolean r5 = false;
    L45:
        return new c(r17, r19, null, r5, false, !((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty(), false, false, r9, null, null);
    L39:
        if (r17 == RecommendationDetailMode.EXECUTABLE_PENDING) goto L43;
        if (r17 == RecommendationDetailMode.EXECUTABLE_DONE) goto L43;
        r5 = true;
        goto L45
    L24:
        if (r18 != 3) goto L26;
        r19 = "已忽略";
        goto L37
    L26:
        if (r18 != 4) goto L28;
    L32:
        r19 = null;
        goto L37
    L28:
        if (r18 == 5) goto L32;
        throw new NoWhenBranchMatchedException();
    L35:
        r19 = "知道了";
    L13:
        if (r16 == false) goto L15;
        r17 = RecommendationDetailMode.EXECUTABLE_PENDING;
        goto L20
    L15:
        if (r3 == false) goto L17;
        r17 = RecommendationDetailMode.NOTICE_IGNORED;
        goto L20
    L17:
        if (r4 == false) goto L19;
        r17 = RecommendationDetailMode.NOTICE_KNOWN;
        goto L20
    L19:
        r17 = RecommendationDetailMode.NOTICE_PENDING;
        goto L20
    L5:
        if (g(r14) == true) goto L8;
        r16 = false;
        goto L9
    }

    private static final String a(String r5) {
        Object r4 = null;
        if (StringsKt.startsWith$default(r5, "{", false, 2, null) == true) goto L5;
        return null;
    L5:
        String r1 = b(r5);
        if (r1 == null) goto L21;
        return r1;
    L21:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        String r6 = new JSONObject(r5).optString("preset_query");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r6, "optString(...)");     // Catch: Throwable -> L13
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (StringsKt.isBlank(r7) == false) goto L11;
        r7 = null;
    L11:
        Object r8 = Result.m1421constructorimpl((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r8) == true) goto L20;
        r4 = r8;
    L20:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L13:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public static final boolean a(ProactiveRecommendationDto r3) {
        Intrinsics.checkNotNullParameter(r3, "dto");
        if (r3.getRecommendStatus() == 2) goto L5;
    L7:
        return false;
    L5:
        if (StringsKt.equals(r3.getInspirationFeedbackAction(), "ignore", true) == false) goto L7;
        return true;
    }

    private static final String b(String r10) {
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), "\"preset_query\"", 0, false, 6, null);
        CharSequence r2 = null;
        if (r0 >= 0) goto L5;
        return null;
    L5:
        int r1 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), ':', r0 + 14, false, 4, null);
        if (r1 >= 0) goto L8;
        return null;
    L8:
        int r3 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), Typography.quote, r1 + 1, false, 4, null);
        if (r3 >= 0) goto L11;
        return null;
    L11:
        StringBuilder r4 = new StringBuilder();
    L12:
        r3 = r3 + 1;
    L14:
        if (r3 >= r10.length()) goto L32;
        char r5 = r10.charAt(r3);
        if (r5 != '\\') goto L30;
        int r7 = r3 + 1;
        if (r7 >= r10.length()) goto L30;
        char r6 = r10.charAt(r7);
        if (r6 == '\"') goto L28;
        if (r6 != '\\') goto L23;
        r4.append('\\');
    L29:
        r3 = r3 + 2;
        goto L14
    L23:
        if (r6 != 'n') goto L26;
        r6 = '\n';
    L26:
        r4.append(r6);
        goto L29
    L28:
        r4.append(Typography.quote);
    L30:
        if (r5 == '\"') goto L32;
        r4.append(r5);
    L32:
        String r11 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r12) == true) goto L37;
        r2 = r12;
    L37:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    }

    public static final boolean b(ProactiveRecommendationDto r2) {
        Intrinsics.checkNotNullParameter(r2, "dto");
        if (r2.getRecommendStatus() == 1) goto L5;
    L7:
        return false;
    L5:
        if (StringsKt.equals(r2.getInspirationFeedbackAction(), "auto_dismiss", true) == false) goto L7;
        return true;
    }

    private static final List<com.obric.aiproactive.ui.detail.a> c(String r14) {
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r15) == false) goto L5;
        r15 = "-";
    L5:
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin");
        int r8 = 0;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'\n'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r3.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L7
    L9:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L15;
        Object r9 = r7.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L11;
        r6.add(r9);
        goto L11
    L15:
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        if (r0.isEmpty() == false) goto L18;
        r0 = CollectionsKt.listOf(r16);
    L18:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L20:
        if (r18.hasNext() == false) goto L26;
        Object r10 = r18.next();
        int r11 = r8 + 1;
        if (r8 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        String r12 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
        r1.add(new com.obric.aiproactive.ui.detail.a("行动建议 " + r11, r12, r12, true, false, null, null, 96, null));
        r8 = r11;
        goto L20
    L26:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    public static final boolean c(ProactiveRecommendationDto r2) {
        Intrinsics.checkNotNullParameter(r2, "dto");
        if (r2.getRecommendStatus() == 2) goto L5;
    L7:
        return false;
    L5:
        if (b(r2) == true) goto L7;
        return true;
    }

    public static final boolean d(ProactiveRecommendationDto r1) {
        Intrinsics.checkNotNullParameter(r1, "dto");
        return c(r1);
    }

    public static final String e(ProactiveRecommendationDto r3) {
        Intrinsics.checkNotNullParameter(r3, "dto");
        String r0 = f(r3);
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3.getReason(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r1) == false) goto L14;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3.getRecommendText(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r4) == false) goto L12;
        r4 = "-";
    L12:
        r1 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L14:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L15:
        String r5 = a(r0);
        if (r5 != null) goto L19;
        return r0;
    L19:
        return r5;
    }

    public static final String f(ProactiveRecommendationDto r3) {
        Intrinsics.checkNotNullParameter(r3, "dto");
        if (Intrinsics.areEqual(r3.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == false) goto L7;
        String r0 = h(r3);
        if (r0 == null) goto L7;
        return r0;
    L7:
        String r4 = r3.getActionExecuteInstruction();
        if (r4 == null) goto L15;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r5 != null) goto L12;
        return null;
    L12:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L14;
        return null;
    L14:
        return r5;
    L15:
        return null;
    }

    public static final boolean g(ProactiveRecommendationDto r2) {
        Intrinsics.checkNotNullParameter(r2, "dto");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(f(r2), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        return !r4;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r4 = false;
        goto L10
    }

    public static final String h(ProactiveRecommendationDto r6) {
        Intrinsics.checkNotNullParameter(r6, "dto");
        n r7 = l.a(r6.getActionCondition());
        if (r7 == null) goto L12;
        String r3 = r7.c();
        if (r3 == null) goto L12;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L12;
        return r3;
    L12:
        if (r7 == null) goto L14;
        String r8 = r7.a();
    L15:
        List<com.obric.aiproactive.api.b> r9 = com.obric.aiproactive.api.c.a(r8);
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r4.hasNext() == false) goto L24;
        Object r5 = r4.next();
        if (((com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r5, com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")).c() != 0) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == false) goto L17;
    L25:
        com.obric.aiproactive.api.b r11 = (com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r5, com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L35;
        String r12 = r11.b();
        if (r12 == null) goto L35;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L33;
        r12 = null;
    L33:
        if (r12 == null) goto L35;
        return r12;
    L35:
        com.obric.aiproactive.api.b r13 = (com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r9), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L49;
        String r14 = r13.b();
        if (r14 != null) goto L40;
        return null;
    L40:
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L42;
        return null;
    L42:
        return r14;
    L49:
        return null;
    L21:
        r10 = false;
        goto L22
    L24:
        r5 = null;
        goto L25
    L14:
        r8 = null;
        goto L15
    }

    private static final List<com.obric.aiproactive.ui.detail.a> i(ProactiveRecommendationDto r13) {
        List<com.obric.aiproactive.api.b> r0 = j(r13);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L53;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
        int r4 = 0;
        int r5 = 0;
    L6:
        if (r15.hasNext() == false) goto L11;
        Object r6 = r15.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        r1.add(TuplesKt.to(Integer.valueOf(r5), (com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r6, com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")));
        r5 = r7;
        goto L6
    L11:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        ListIterator r17 = r16.listIterator(r16.size());
    L13:
        if (r17.hasPrevious() == false) goto L17;
        Object r2 = r17.previous();
        if ((!((com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin")).component2(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")).h()) == false) goto L13;
    L18:
        Pair r18 = (Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L21;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r19.iterator();
        int r8 = 0;
    L24:
        if (r110.hasNext() == false) goto L35;
        Object r9 = r110.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        com.obric.aiproactive.api.b r11 = (com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r9, com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin");
        if (r11.h() == true) goto L31;
        Pair r12 = null;
    L32:
        if (r12 == null) goto L34;
        r3.add(r12);
    L34:
        r8 = r10;
        goto L24
    L31:
        r12 = TuplesKt.to(Integer.valueOf(r8), r11);
        goto L32
    L35:
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 3), Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r112 = r111.iterator();
    L37:
        if (r112.hasNext() == false) goto L52;
        Object r21 = r112.next();
        int r22 = r4 + 1;
        if (r4 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        Pair r23 = (Pair) ZeusTransformUtils.preCheckCast(r21, Pair.class, "com.obric.memorydata.plugin");
        CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r23.getSecond(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r24) == false) goto L44;
        r24 = "行动建议 " + r22;
    L44:
        String r25 = (String) ZeusTransformUtils.preCheckCast(r24, String.class, "com.obric.memorydata.plugin");
        CharSequence r26 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r23.getSecond(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")).b(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r26) == false) goto L47;
        r26 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r23.getSecond(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L47:
        String r27 = (String) ZeusTransformUtils.preCheckCast(r26, String.class, "com.obric.memorydata.plugin");
        CharSequence r28 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r23.getSecond(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r28) == false) goto L50;
        r28 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r23.getSecond(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")).b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L50:
        r20.add(new com.obric.aiproactive.ui.detail.a(r25, r27, (String) ZeusTransformUtils.preCheckCast(r28, String.class, "com.obric.memorydata.plugin"), true, false, (Integer) ZeusTransformUtils.preCheckCast(r23.getFirst(), Integer.class, "com.obric.memorydata.plugin"), (com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r23.getSecond(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")));
        r4 = r22;
        goto L37
    L52:
        return (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin");
    L21:
        return CollectionsKt.listOf(a((com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r18.getSecond(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r18.getFirst(), Integer.class, "com.obric.memorydata.plugin")));
    L17:
        r2 = null;
        goto L18
    L53:
        String r29 = f(r13);
        if (r29 != null) goto L57;
        r29 = "";
    L57:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L59;
        String r30 = e(r13);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L65;
        return CollectionsKt.emptyList();
    L65:
        if (d(r13) == false) goto L68;
        return CollectionsKt.listOf(new com.obric.aiproactive.ui.detail.a(r30, r30, r30, false, true, null, null, 96, null));
    L68:
        return c(r30);
    L59:
        return CollectionsKt.emptyList();
    }

    private static final List<com.obric.aiproactive.api.b> j(ProactiveRecommendationDto r16) {
        n r0 = l.a(r16.getActionCondition());
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a();
    L6:
        List<com.obric.aiproactive.api.b> r3 = com.obric.aiproactive.api.c.a(r2);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        return r3;
    L9:
        String r4 = f(r16);
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L15;
        String r5 = a(r4);
        if (r5 != null) goto L19;
        String r8 = r4;
    L20:
        if (r0 == null) goto L24;
        String r6 = r0.b();
        if (r6 == null) goto L24;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L25:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L28;
    L31:
        boolean r10 = true;
    L33:
        if ((!r10) == false) goto L35;
        r1 = r7;
    L35:
        if (r1 != null) goto L37;
        String r11 = r8;
    L39:
        return CollectionsKt.listOf(new com.obric.aiproactive.api.b(r11, r8, d(r16) ? 1 : 0, null, null, false, false, 120, null));
    L37:
        r11 = r1;
        goto L39
    L28:
        if (StringsKt.isBlank(r9) == true) goto L31;
        r10 = false;
    L24:
        r7 = null;
        goto L25
    L19:
        r8 = r5;
        goto L20
    L15:
        return CollectionsKt.emptyList();
    L5:
        r2 = null;
        goto L6
    }
}
