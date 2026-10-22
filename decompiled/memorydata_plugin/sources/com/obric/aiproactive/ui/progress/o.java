package com.obric.aiproactive.ui.progress;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\b*\u00020\u0006H\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\bH\u0002\u001a\u001a\u0010\u000e\u001a\u00020\n*\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0002\u001a \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00110\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0016\u001a\u00020\r*\u00020\u0006H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\rH\u0002\u001a\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\rH\u0002\u001a\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\rH\u0002\u001a\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002\u001a\f\u0010\u001d\u001a\u00020\n*\u00020\bH\u0002\"\u000e\u0010\u001e\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"buildV3AgentRunUiSteps", "", "Lcom/obric/aiproactive/ui/progress/AgentRunUiStep;", "run", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "toStatefulActivityUiStep", "Lcom/obric/aiproactive/api/AiProactiveAgentRunStepDto;", "executionId", "", "isMobileUse", "", "mobileUseStageTitle", "toMobileItemUiState", "Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "isSupersededTransientPlanningStage", "latestStages", "mergeAdjacentTerminalOutcome", "Lcom/obric/aiproactive/ui/progress/V3MappedStage;", "suggestionCount", "", "shouldShowV3CollapsedSubtitle", "stage", "toV3UiState", "unifiedV3Title", "state", "fallbackV3Title", "fallbackV3Subtitle", "fallbackV3ActionTitle", "fallbackV3ActionSubtitle", "isV3NonTerminalState", "RESULT_STEP_ID", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class o {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6838a = null;

        static {
            int[] r0 = new int[AgentRunUiState.values().length];
            r0[AgentRunUiState.PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[AgentRunUiState.RUNNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[AgentRunUiState.COMPLETED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[AgentRunUiState.CANCELLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[AgentRunUiState.FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[AgentRunUiState.UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f6838a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).l()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).l()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6839a;

        public c(Comparator r3) {
            this.f6839a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f6839a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.f) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.f.class, "com.obric.memorydata.plugin")).i()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.f) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.f.class, "com.obric.memorydata.plugin")).i()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    private static final AgentRunUiState a(String r1) {
        switch(r1.hashCode()) {
            case -2146525273: goto L32;
            case -1281977283: goto L28;
            case -896145315: goto L26;
            case -682587753: goto L24;
            case 40661574: goto L21;
            case 476588369: goto L17;
            case 945734241: goto L13;
            case 1116313165: goto L10;
            case 1550783935: goto L6;
            default: goto L36;
        };
    L26:
        r1.equals("outcome_unknown");
        goto L36
    L6:
        if (r1.equals("running") == false) goto L36;
        return AgentRunUiState.RUNNING;
    L10:
        if (r1.equals("waiting") == false) goto L36;
    L41:
        return AgentRunUiState.PENDING;
    L13:
        if (r1.equals("succeeded") == false) goto L36;
        return AgentRunUiState.COMPLETED;
    L17:
        if (r1.equals("cancelled") == false) goto L36;
        return AgentRunUiState.CANCELLED;
    L21:
        if (r1.equals("timed_out") == false) goto L36;
    L40:
        return AgentRunUiState.FAILED;
    L24:
        if (r1.equals("pending") == true) goto L41;
    L28:
        if (r1.equals("failed") == true) goto L40;
    L32:
        if (r1.equals("accepted") == true) goto L41;
    L36:
        return AgentRunUiState.UNKNOWN;
    }

    private static final ad a(r r24, com.obric.aiproactive.api.g r25, com.obric.aiproactive.api.i r26) {
        Intrinsics.checkNotNullParameter(r26, "stage");
        q r1 = (q) ZeusTransformUtils.preCheckCast(r24.a().get(r26.k()), q.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        String r2 = null;
        if (r24.b().contains(r26.k()) == false) goto L9;
        return null;
    L9:
        boolean r7 = true;
        if (r26.j() < 4) goto L18;
        if (Intrinsics.areEqual(r26.v(), "mobile_use") == false) goto L18;
        if (Intrinsics.areEqual(r26.m(), "action") == false) goto L18;
        return new ad(r26.m(), a(r26, r25.a(), true));
    L18:
        if (r26.j() >= 5) goto L20;
    L25:
        AgentRunUiState r13 = c(r26);
        if (Intrinsics.areEqual(r26.m(), "observation") == false) goto L28;
        List<k> r3 = com.obric.aiproactive.ui.progress.c.a(r26.k(), r26.y(), r13);
    L29:
        List<k> r14 = r3;
        String r4 = m.b(r14);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r26.s(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L32;
    L34:
        boolean r9 = false;
    L35:
        if (r9 == false) goto L37;
        String r10 = r4;
    L39:
        if (m.c(r26.s()) == true) goto L43;
        r4 = null;
    L43:
        if (r25.f() <= 0) goto L45;
    L51:
        boolean r6 = false;
    L52:
        if (r6 == false) goto L54;
        String r8 = "已完成本轮判断";
    L55:
        if (r8 != null) goto L59;
        if (r10 == null) goto L61;
        r4 = r10;
    L61:
        if (m.b(r26.s()) == null) goto L63;
    L96:
        boolean r11 = true;
    L98:
        if (Intrinsics.areEqual(r26.m(), "result") == false) goto L106;
        if (r13 != AgentRunUiState.COMPLETED) goto L106;
        if (r25.f() > 0) goto L106;
        if (r11 == true) goto L106;
        return null;
    L106:
        if (r4 != null) goto L111;
        String r12 = m.a(a(r26, r13));
        if (r12 != null) goto L110;
        String r15 = "";
    L113:
        if (Intrinsics.areEqual(r26.m(), "result") == false) goto L115;
        String r16 = "phase-result";
    L116:
        String r17 = r16;
        if (Intrinsics.areEqual(r26.m(), "observation") == true) goto L119;
    L121:
        if (r4 == null) goto L123;
    L122:
        String r18 = "";
    L127:
        String r5 = r26.u();
        if (Intrinsics.areEqual(r26.m(), "observation") == true) goto L130;
        r2 = r5;
    L130:
        if (r2 != null) goto L132;
        String r19 = "";
    L133:
        n r20 = new n(r17, r15, r18, r13, r14, r19, b(r26), null, null, null, null, null, Utf8.MASK_2BYTES, null);
        if (r4 != null) goto L138;
        r7 = false;
    L138:
        return new ad(r26.m(), m.a(r20, r7));
    L132:
        r19 = r2;
        goto L133
    L123:
        CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r26.t(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r21) == false) goto L126;
        r21 = c(r26, r13);
    L126:
        r18 = (String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.memorydata.plugin");
        goto L127
    L119:
        if (SetsKt.setOf(new String[]{"pending", "running", "succeeded"}).contains(r26.d()) == false) goto L121;
    L115:
        r16 = "stage-" + r26.k();
        goto L116
    L110:
        r15 = r12;
        goto L113
    L111:
        r15 = r4;
        goto L113
    L63:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r26.u(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L96;
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r22, Collection.class) == true) goto L67;
    L69:
        Iterator r23 = r22.iterator();
    L71:
        if (r23.hasNext() == false) goto L68;
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(((k) ZeusTransformUtils.preCheckCast(r23.next(), k.class, "com.obric.memorydata.plugin")).c(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r27, Collection.class) == true) goto L75;
    L77:
        Iterator r28 = r27.iterator();
    L79:
        if (r28.hasNext() == false) goto L76;
        l r110 = (l) ZeusTransformUtils.preCheckCast(r28.next(), l.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r110.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L83;
    L88:
        boolean r111 = true;
    L89:
        if (r111 == false) goto L79;
        boolean r29 = true;
    L91:
        if (r29 == false) goto L71;
        boolean r30 = true;
    L93:
        if (r30 == true) goto L96;
        r11 = false;
        goto L98
    L83:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r110.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L88;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r110.c(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L88;
        r111 = false;
    L76:
        r29 = false;
        goto L91
    L75:
        if (((Collection) ZeusTransformUtils.preCheckCast(r27, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L77;
    L68:
        r30 = false;
        goto L93
    L67:
        if (((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L69;
    L59:
        r4 = r8;
        goto L61
    L54:
        r8 = null;
        goto L55
    L45:
        if (r13 != AgentRunUiState.COMPLETED) goto L51;
        if (Intrinsics.areEqual(r26.m(), "action") == false) goto L51;
        if (m.a(r14) == false) goto L51;
        r6 = true;
        goto L52
    L37:
        r10 = null;
        goto L39
    L32:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r26.t(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L34;
        r9 = true;
        goto L35
    L28:
        r3 = com.obric.aiproactive.ui.progress.c.a(r26.k(), r26.m(), r26.y(), r13, m.a(r26));
        goto L29
    L20:
        if (Intrinsics.areEqual(r26.v(), "activity") == false) goto L25;
        if (Intrinsics.areEqual(r26.m(), "action") == false) goto L25;
        return new ad(r26.m(), a(r26, r25.a(), false));
    L5:
        return new ad(r26.m(), s.a(r1, r25));
    }

    private static final n a(com.obric.aiproactive.api.i r16, String r17, boolean r18) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r16.y(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        com.obric.aiproactive.api.f r4 = (com.obric.aiproactive.api.f) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.f.class, "com.obric.memorydata.plugin");
        boolean r6 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.h(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
    L10:
        r6 = false;
    L11:
        if (r6 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        if (r4.i() <= 0) goto L10;
    L13:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r5.iterator();
    L15:
        if (r8.hasNext() == false) goto L17;
        com.obric.aiproactive.api.f r9 = (com.obric.aiproactive.api.f) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.aiproactive.api.f.class, "com.obric.memorydata.plugin");
        r7.add(new com.obric.aiproactive.ui.progress.a(r9.h(), r9.i(), r9.c(), a(r9.j()), r9.k(), r9.l(), r9.f()));
        goto L15
    L17:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        String r10 = "stage-" + r16.k();
        String r11 = r16.k();
        if (r18 == false) goto L20;
        String r13 = a(r16);
    L24:
        String r14 = r13;
        AgentRunUiState r15 = c(r16);
        String r19 = r16.x();
        if (r18 == true) goto L28;
        r19 = null;
    L28:
        if (r19 != null) goto L30;
        r19 = "";
    L30:
        String r110 = r19;
        if (r18 == false) goto L33;
        AgentRunSecondaryListStyle r20 = AgentRunSecondaryListStyle.ORDERED;
    L35:
        return new n(r10, r14, "", r15, null, null, false, r17, r11, r110, r12, r20, 112, null);
    L33:
        r20 = m.a(r16);
        goto L35
    L20:
        r13 = m.b(r16.s());
        if (r13 != null) goto L24;
        r13 = b(r16, c(r16));
        goto L24
    }

    public static final String a(com.obric.aiproactive.api.i r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = r1.d();
        switch(r2.hashCode()) {
            case -1281977283: goto L30;
            case -682587753: goto L26;
            case 40661574: goto L22;
            case 476588369: goto L18;
            case 945734241: goto L14;
            case 1116313165: goto L10;
            case 1550783935: goto L6;
            default: goto L33;
        };
    L33:
        return "手机操作状态未知";
    L6:
        if (r2.equals("running") == false) goto L33;
        return "正在操作手机";
    L10:
        if (r2.equals("waiting") == false) goto L33;
        return "等待继续操作手机";
    L14:
        if (r2.equals("succeeded") == false) goto L33;
        return "已完成手机操作";
    L18:
        if (r2.equals("cancelled") == false) goto L33;
        return "手机操作已停止";
    L22:
        if (r2.equals("timed_out") == false) goto L33;
        return "手机操作已超时";
    L26:
        if (r2.equals("pending") == false) goto L33;
        return "等待操作手机";
    L30:
        if (r2.equals("failed") == false) goto L33;
        return "手机操作未完成";
    }

    private static final String a(com.obric.aiproactive.api.i r2, AgentRunUiState r3) {
        if (Intrinsics.areEqual(r2.m(), "observation") == true) goto L10;
        String r0 = m.b(r2.s());
        if (r0 != null) goto L9;
        return b(r2, r3);
    L9:
        return r0;
    L10:
        return m.a(r2.m(), r3, r2.d());
    }

    public static final List<n> a(final com.obric.aiproactive.api.g r8) {
        Intrinsics.checkNotNullParameter(r8, "run");
        Sequence r0 = SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r8.g(), Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$o$AbPudtTy5fD0JU52N2_2ef2JY.INSTANCE);
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Object r3 = r2.next();
        String r4 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).k();
        Object r5 = r1.get(r4);
        if (r5 != null) goto L8;
        r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r1.put(r4, r5);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).add(r3);
        goto L4
    L9:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r1.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r6.iterator();
    L11:
        if (r9.hasNext() == false) goto L28;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9.next(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == true) goto L15;
        Object r11 = null;
    L25:
        com.obric.aiproactive.api.i r12 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r11, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L11;
        r7.add(r12);
        goto L11
    L15:
        Object r13 = r10.next();
        if (r10.hasNext() == true) goto L18;
    L17:
        r11 = r13;
        goto L25
    L18:
        int r14 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r13, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
    L19:
        Object r15 = r10.next();
        int r16 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r15, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
        if (r14 >= r16) goto L23;
        r13 = r15;
        r14 = r16;
    L23:
        if (r10.hasNext() == true) goto L19;
    L28:
        final List r17 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c((Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"));
        List r18 = SequencesKt.toList(SequencesKt.filterNot(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$o$SrzT89ohx_xsIzBxnOwaWdi_rFM(r17)));
        final r r19 = s.a(r18);
        return a(SequencesKt.toList(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$o$6Ar48FDOJbikJRWbH0icXrAzgr0(r19, r8))), r8.f());
    }

    private static final List<n> a(List<ad> r8, int r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r0 = CollectionsKt.createListBuilder();
        int r2 = 0;
    L4:
        if (r2 >= r10.size()) goto L15;
        ad r3 = (ad) ZeusTransformUtils.preCheckCast(r10.get(r2), ad.class, "com.obric.memorydata.plugin");
        int r4 = r2 + 1;
        ad r5 = (ad) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r10, r4), ad.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r3.a(), "conclusion") == false) goto L13;
        if (r5 == null) goto L9;
        String r6 = r5.a();
    L11:
        if (Intrinsics.areEqual(r6, "result") == false) goto L13;
        r0.add(m.a(r3.b(), r5.b(), r9));
        r2 = r2 + 2;
        goto L4
    L9:
        r6 = null;
    L13:
        r0.add(r3.b());
        r2 = r4;
        goto L4
    L15:
        return CollectionsKt.build(r0);
    }

    private static final boolean a(com.obric.aiproactive.api.i r6, List<com.obric.aiproactive.api.i> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r6.c(), "planning_started") == false) goto L27;
        if (Intrinsics.areEqual(r6.d(), "running") == false) goto L27;
        if (r6.p() == true) goto L27;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L11;
    L13:
        Iterator r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L12;
        com.obric.aiproactive.api.i r0 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r0.l() > r6.l()) goto L19;
    L21:
        boolean r1 = false;
    L22:
        if (r1 == false) goto L15;
        boolean r11 = true;
    L24:
        if (r11 == false) goto L27;
        return true;
    L19:
        if (r0.h() <= r6.h()) goto L21;
        r1 = true;
    L12:
        r11 = false;
        goto L24
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L13;
    L27:
        return false;
    }

    private static final boolean a(List r2, com.obric.aiproactive.api.i r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "stage");
        return a(r3, r4);
    }

    private static final String b(com.obric.aiproactive.api.i r2, AgentRunUiState r3) {
        String r0 = r2.m();
        switch(r0.hashCode()) {
            case -1731259873: goto L12;
            case -1422950858: goto L9;
            case -934426595: goto L7;
            case 122345516: goto L5;
            default: goto L14;
        };
    L5:
        String r1 = "observation";
    L6:
        r0.equals(r1);
        goto L14
    L7:
        r1 = "result";
        goto L6
    L12:
        r1 = "conclusion";
        goto L6
    L9:
        if (r0.equals("action") == false) goto L14;
        return d(r2);
    L14:
        return m.a(r2.m(), r3, r2.d());
    }

    public static final boolean b(com.obric.aiproactive.api.i r4) {
        Intrinsics.checkNotNullParameter(r4, "stage");
        if (r4.p() == true) goto L5;
    L6:
        String r5 = r4.d();
        int r0 = r5.hashCode();
        if (r0 == (-682587753)) goto L20;
        if (r0 == 945734241) goto L17;
        if (r0 == 1550783935) goto L14;
    L21:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L25;
        return false;
    L25:
        return true;
    L14:
        if (r5.equals("running") == false) goto L21;
    L22:
        r6 = false;
        goto L23
    L17:
        if (r5.equals("succeeded") == false) goto L21;
    L20:
        if (r5.equals("pending") == true) goto L22;
    L5:
        if (b(r4.d()) == true) goto L25;
        goto L6
    }

    private static final boolean b(String r1) {
        if (Intrinsics.areEqual(r1, "pending") == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "running") == true) goto L12;
        if (Intrinsics.areEqual(r1, "waiting") == true) goto L12;
        if (Intrinsics.areEqual(r1, "accepted") == true) goto L12;
        return false;
    }

    private static final AgentRunUiState c(com.obric.aiproactive.api.i r2) {
        if (r2.p() == false) goto L8;
        if (b(r2.d()) == false) goto L8;
    L33:
        return AgentRunUiState.PENDING;
    L8:
        if (Intrinsics.areEqual(r2.d(), "pending") == true) goto L33;
        if (Intrinsics.areEqual(r2.d(), "waiting") == true) goto L33;
        if (Intrinsics.areEqual(r2.d(), "accepted") == true) goto L33;
        if (Intrinsics.areEqual(r2.d(), "running") == false) goto L20;
        return AgentRunUiState.RUNNING;
    L20:
        if (Intrinsics.areEqual(r2.d(), "succeeded") == false) goto L23;
        return AgentRunUiState.COMPLETED;
    L23:
        if (Intrinsics.areEqual(r2.d(), "failed") == false) goto L26;
    L36:
        return AgentRunUiState.FAILED;
    L26:
        if (Intrinsics.areEqual(r2.d(), "cancelled") == false) goto L29;
        return AgentRunUiState.CANCELLED;
    L29:
        if (Intrinsics.areEqual(r2.d(), "timed_out") == true) goto L36;
        Intrinsics.areEqual(r2.d(), "outcome_unknown");
        return AgentRunUiState.UNKNOWN;
    }

    private static final String c(com.obric.aiproactive.api.i r2, AgentRunUiState r3) {
        if (Intrinsics.areEqual(r2.m(), "action") == false) goto L6;
        return e(r2);
    L6:
        switch(a.f6838a[r3.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        return "暂时无法确认状态";
    L10:
        return "执行失败";
    L11:
        return "本轮任务已停止";
    L12:
        return "已完成";
    L13:
        return "正在进行";
    L14:
        return "等待开始";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private static final String d(com.obric.aiproactive.api.i r4) {
        if (r4.p() == false) goto L8;
        if (b(r4.d()) == false) goto L8;
        return "等待你确认";
    L8:
        if (Intrinsics.areEqual(r4.d(), "waiting") == false) goto L17;
        String r5 = r4.n();
        if (Intrinsics.areEqual(r5, ChatMessage.TYPE_QUERY) == false) goto L13;
        return "等待继续查询";
    L13:
        if (Intrinsics.areEqual(r5, "execute") == false) goto L15;
        return "等待继续操作";
    L15:
        return "等待继续处理";
    L17:
        if (Intrinsics.areEqual(r4.d(), "pending") == false) goto L26;
        String r6 = r4.n();
        if (Intrinsics.areEqual(r6, ChatMessage.TYPE_QUERY) == false) goto L22;
        return "等待查询信息";
    L22:
        if (Intrinsics.areEqual(r6, "execute") == false) goto L24;
        return "等待执行操作";
    L24:
        return "等待处理";
    L26:
        if (Intrinsics.areEqual(r4.d(), "running") == false) goto L35;
        String r7 = r4.n();
        if (Intrinsics.areEqual(r7, ChatMessage.TYPE_QUERY) == false) goto L31;
        return "正在查询信息";
    L31:
        if (Intrinsics.areEqual(r7, "execute") == false) goto L33;
        return "正在执行一项操作";
    L33:
        return "正在处理";
    L35:
        if (Intrinsics.areEqual(r4.d(), "succeeded") == false) goto L44;
        String r8 = r4.n();
        if (Intrinsics.areEqual(r8, ChatMessage.TYPE_QUERY) == false) goto L40;
        return "已完成信息查询";
    L40:
        if (Intrinsics.areEqual(r8, "execute") == false) goto L42;
        return "已完成一项操作";
    L42:
        return "已完成一个步骤";
    L44:
        if (Intrinsics.areEqual(r4.d(), "failed") == false) goto L53;
        String r9 = r4.n();
        if (Intrinsics.areEqual(r9, ChatMessage.TYPE_QUERY) == false) goto L49;
        return "信息查询未完成";
    L49:
        if (Intrinsics.areEqual(r9, "execute") == false) goto L51;
        return "操作未完成";
    L51:
        return "一个步骤未完成";
    L53:
        if (Intrinsics.areEqual(r4.d(), "cancelled") == false) goto L62;
        String r10 = r4.n();
        if (Intrinsics.areEqual(r10, ChatMessage.TYPE_QUERY) == false) goto L58;
        return "信息查询已取消";
    L58:
        if (Intrinsics.areEqual(r10, "execute") == false) goto L60;
        return "操作已取消";
    L60:
        return "步骤已取消";
    L62:
        if (Intrinsics.areEqual(r4.d(), "timed_out") == false) goto L71;
        String r11 = r4.n();
        if (Intrinsics.areEqual(r11, ChatMessage.TYPE_QUERY) == false) goto L67;
        return "信息查询已超时";
    L67:
        if (Intrinsics.areEqual(r11, "execute") == false) goto L69;
        return "操作已超时";
    L69:
        return "步骤已超时";
    L71:
        if (Intrinsics.areEqual(r4.d(), "accepted") == false) goto L74;
        return "已受理，等待完成";
    L74:
        if (Intrinsics.areEqual(r4.d(), "outcome_unknown") == false) goto L76;
        return "结果仍待确认";
    L76:
        return "步骤状态未知";
    }

    private static final String e(com.obric.aiproactive.api.i r4) {
        if (r4.p() == false) goto L14;
        if (b(r4.d()) == false) goto L14;
        String r5 = r4.o();
        if (Intrinsics.areEqual(r5, "device_write") == false) goto L10;
        return "确认后会修改手机中的内容或设置";
    L10:
        if (Intrinsics.areEqual(r5, "external_write") == false) goto L12;
        return "确认后会修改外部服务中的内容";
    L12:
        return "确认后再继续";
    L14:
        if (Intrinsics.areEqual(r4.d(), "waiting") == false) goto L17;
        return "正在等待可用条件";
    L17:
        if (Intrinsics.areEqual(r4.d(), "pending") == false) goto L20;
        return "等待开始";
    L20:
        if (Intrinsics.areEqual(r4.d(), "running") == false) goto L23;
        return "正在进行";
    L23:
        if (Intrinsics.areEqual(r4.d(), "succeeded") == false) goto L29;
        if (Intrinsics.areEqual(r4.n(), "execute") == false) goto L27;
        return "操作已完成";
    L27:
        return "已完成";
    L29:
        if (Intrinsics.areEqual(r4.d(), "failed") == false) goto L38;
        String r6 = r4.n();
        if (Intrinsics.areEqual(r6, ChatMessage.TYPE_QUERY) == false) goto L34;
        return "查询失败";
    L34:
        if (Intrinsics.areEqual(r6, "execute") == false) goto L36;
        return "执行失败";
    L36:
        return "本次处理未完成";
    L38:
        if (Intrinsics.areEqual(r4.d(), "cancelled") == false) goto L47;
        String r7 = r4.n();
        if (Intrinsics.areEqual(r7, ChatMessage.TYPE_QUERY) == false) goto L43;
        return "本次查询已取消";
    L43:
        if (Intrinsics.areEqual(r7, "execute") == false) goto L45;
        return "本次操作已取消";
    L45:
        return "本次处理已取消";
    L47:
        if (Intrinsics.areEqual(r4.d(), "timed_out") == false) goto L50;
        return "未在预期时间内完成";
    L50:
        if (Intrinsics.areEqual(r4.d(), "accepted") == false) goto L53;
        return "请求已受理，正在等待可验证结果";
    L53:
        if (Intrinsics.areEqual(r4.d(), "outcome_unknown") == false) goto L55;
        return "暂时无法确认是否完成";
    L55:
        return "暂时无法确认状态";
    }

    private static final boolean f(com.obric.aiproactive.api.i r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.j() >= 3) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.k(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        return true;
    }

    public static /* synthetic */ ad lambda$6Ar48FDOJbikJRWbH0icXrAzgr0(r r0, com.obric.aiproactive.api.g r1, com.obric.aiproactive.api.i r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Ab-PudtTy5fD0JU52N2_2ef2-JY, reason: not valid java name */
    public static /* synthetic */ boolean m342lambda$AbPudtTy5fD0JU52N2_2ef2JY(com.obric.aiproactive.api.i r0) {
        return f(r0);
    }

    public static /* synthetic */ boolean lambda$SrzT89ohx_xsIzBxnOwaWdi_rFM(List r0, com.obric.aiproactive.api.i r1) {
        return a(r0, r1);
    }
}
