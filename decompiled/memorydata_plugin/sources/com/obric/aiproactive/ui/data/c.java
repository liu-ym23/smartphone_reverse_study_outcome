package com.obric.aiproactive.ui.data;

import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.g;
import com.obric.aiproactive.api.n;
import com.obric.aiproactive.api.t;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0000\u001a\u001a\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\tH\u0000\u001a\u000e\u0010\u0010\u001a\u00020\u0011*\u0004\u0018\u00010\tH\u0002\u001a\f\u0010\u0012\u001a\u00020\u0001*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"DEFAULT_AI_PROACTIVE_DB_READY_TIMEOUT_MS", "", "USER_REQUIREMENT_REPOSITORY_TIMEOUT_MS", "observeAgentRunFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "service", "Lcom/obric/aiproactive/api/IProactiveService;", "executionId", "", "toUiCompatRecommendationDto", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "Lcom/obric/aiproactive/api/AiProactiveRecommendationDto;", "buildAiProactiveDisplayMarkdown", "recommendTitle", "recommendText", "isVoteOnlyAiFeedback", "", "effectiveCreatedAt", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6557a = null;

        static {
            int[] r0 = new int[AiProactiveCardStatus.values().length];
            r0[AiProactiveCardStatus.PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AiProactiveCardStatus.DISMISSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AiProactiveCardStatus.ACKNOWLEDGED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AiProactiveCardStatus.EXECUTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f6557a = r0;
        }
    }

    public static final ProactiveRecommendationDto a(t r41) {
        Intrinsics.checkNotNullParameter(r41, "<this>");
        n r0 = com.obric.aiproactive.api.c.c(r41.f());
        String r2 = r0.c();
        if (r2 == null) goto L9;
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r3 == null) goto L9;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        String r14 = r3;
    L10:
        boolean r7 = false;
        if (r41.l() == AiProactiveCardStatus.PENDING) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L19;
    L17:
        AiProactiveCardStatus r6 = AiProactiveCardStatus.PENDING;
    L24:
        if (r4 == false) goto L28;
    L25:
        String r5 = r41.m();
    L26:
        String r28 = r5;
    L34:
        String r8 = r41.n();
        if (r8 == null) goto L41;
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r9 == null) goto L41;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L41;
        String r30 = r9;
    L42:
        String r10 = r41.o();
        if (r10 == null) goto L49;
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r11 == null) goto L49;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L49;
        String r31 = r11;
    L50:
        List r12 = CollectionsKt.listOfNotNull(new String[]{r30, r31});
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L54;
        r12 = null;
    L54:
        if (r12 == null) goto L56;
        String r29 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L57:
        String r13 = String.valueOf(r41.a());
        String r15 = a(r41.d(), r41.c());
        String r16 = r41.g();
        if (r16 != null) goto L60;
        String r17 = "";
    L61:
        String r18 = com.obric.aiproactive.api.c.a(r0);
        List r19 = CollectionsKt.emptyList();
        long r110 = b(r41);
        Integer r1 = r41.i();
        if (r1 == null) goto L64;
        int r20 = r1.intValue();
    L65:
        double r21 = r20;
        String r22 = r41.j();
        if (r22 != null) goto L70;
        r22 = r41.k();
        if (r22 != null) goto L70;
        String r23 = "";
    L71:
        String r24 = r41.k();
        int r25 = a.f6557a[r6.ordinal()];
        if (r25 != 1) goto L74;
        int r26 = 1;
    L84:
        String r27 = r6.name();
        Integer r32 = r41.h();
        if (r32 != null) goto L87;
    L94:
        Long r210 = null;
    L96:
        return new ProactiveRecommendationDto(r13, "", "", r15, r17, r18, r14, null, r19, r110, r21, r23, r24, r26, r27, AutoMemoryViewModel.SOURCE_AI_PROACTIVE, r210, String.valueOf(r41.a()), r28, r29, r30, r31, null, r41.s(), r41.b(), r41.q(), r41.t(), 4194304, null);
    L87:
        if (((Number) ZeusTransformUtils.preCheckCast(r32, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L89;
        r7 = true;
    L89:
        if (r7 == true) goto L92;
        r32 = null;
    L92:
        if (r32 == null) goto L94;
        r210 = Long.valueOf(b(r41) + (((long) ((Number) ZeusTransformUtils.preCheckCast(r32, Number.class, "com.obric.memorydata.plugin")).intValue()) * 1000));
        goto L96
    L74:
        if (r25 != 2) goto L76;
    L82:
        r26 = 2;
        goto L84
    L76:
        if (r25 == 3) goto L82;
        if (r25 == 4) goto L82;
        throw new NoWhenBranchMatchedException();
    L70:
        r23 = r22;
        goto L71
    L64:
        r20 = 0;
        goto L65
    L60:
        r17 = r16;
        goto L61
    L56:
        r29 = null;
    L49:
        r31 = null;
    L41:
        r30 = null;
        goto L42
    L28:
        if (a(r41.m()) == true) goto L25;
        if (r6 != AiProactiveCardStatus.DISMISSED) goto L33;
        r5 = "ignore";
        goto L26
    L33:
        r28 = null;
        goto L34
    L19:
        if (r41.l() == AiProactiveCardStatus.DISMISSED) goto L21;
    L23:
        r6 = r41.l();
        goto L24
    L21:
        if (a(r41.m()) == false) goto L23;
    L13:
        if (StringsKt.equals(r41.m(), "auto_dismiss", true) == false) goto L15;
        r4 = true;
    L9:
        r14 = null;
        goto L10
    }

    public static final String a(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "recommendText");
        if (r12 == null) goto L37;
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r14 == null) goto L37;
        Object r3 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r14 = null;
    L10:
        if (r14 == null) goto L37;
        String r0 = StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"**" + r14 + "**", r14}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r5.hasNext() == false) goto L26;
        Object r6 = r5.next();
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r0, r9) == false) goto L18;
    L23:
        boolean r10 = true;
    L24:
        if (r10 == false) goto L14;
        r3 = r6;
        goto L26
    L18:
        if (StringsKt.startsWith$default(r0, r9 + '\n', false, 2, null) == true) goto L23;
        if (StringsKt.startsWith$default(r0, r9 + "\r\n", false, 2, null) == true) goto L23;
        r10 = false;
    L26:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L32;
        String r1 = StringsKt.trimStart(StringsKt.removePrefix(r0, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")), new char[]{'\n', '\r', ' '});
        if (r1 == null) goto L32;
        r13 = r1;
    L32:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L34;
        StringBuilder r15 = new StringBuilder().append("**").append(r14).append("**");
    L36:
        return r15.toString();
    L34:
        r15 = new StringBuilder().append("**").append(r14).append("**\n").append(r13);
    L37:
        return r13;
    }

    public static final i<g> a(IProactiveService r3, String r4) {
        IProactiveService r5 = (IProactiveService) ZeusTransformUtils.wrapperContextForParams(r3, IProactiveService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "executionId");
        return k.a(k.b((Function2) ZeusTransformUtils.preCheckCast(new ProactiveRepositoryKt$observeAgentRunFlow$1(r5, r4, null), Function2.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    private static final boolean a(String r1) {
        if (Intrinsics.areEqual(r1, "LIKE") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "DISLIKE") == true) goto L8;
        return false;
    }

    private static final long b(t r4) {
        if (r4.b() <= 0) goto L6;
        return r4.b();
    L6:
        if (r4.r() <= 0) goto L9;
        return r4.r();
    L9:
        return r4.s();
    }
}
