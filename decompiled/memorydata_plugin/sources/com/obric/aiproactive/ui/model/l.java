package com.obric.aiproactive.ui.model;

import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.n;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080@¢\u0006\u0002\u0010\u0007\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\tH\u0000\u001a\u0014\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0014\u0010\u000e\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\u000fH\u0001\u001a\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r*\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\r*\u00020\tH\u0000\u001a\u001e\u0010\u0013\u001a\u0004\u0018\u00010\r*\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0000\u001a\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0004*\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a5\u0010\u0019\u001a\u0004\u0018\u00010\u0004*\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u001a\u001a\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0000\u001a(\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u00012\b\u0010!\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0014\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0012\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d*\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"INSPIRATION_PATCH_TAG", "", "dispatchTo", "", "Lcom/obric/aiproactive/ui/model/AiProactiveActionExecutionPlan;", "writer", "Lcom/obric/aiproactive/ui/model/AiProactiveActionCommandWriter;", "(Lcom/obric/aiproactive/ui/model/AiProactiveActionExecutionPlan;Lcom/obric/aiproactive/ui/model/AiProactiveActionCommandWriter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inspirationIdentityKeyOrNull", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "requireInspirationId", "applyInspirationPatch", "patch", "Lcom/obric/aiproactive/ui/model/InspirationLocalPatch;", "applyRecommendationPatch", "Lcom/obric/aiproactive/ui/model/RecommendationLocalPatch;", "buildAiProactiveInstructionPatch", "updatedInstruction", "buildAiProactiveExecutePatch", "buildAiProactiveActionExecutedPatch", "actionIndex", "", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "buildAiProactiveCurrentActionExecutionPlan", "buildAiProactiveActionExecutionPlan", "(Lcom/obric/aiproactive/api/ProactiveRecommendationDto;Lcom/obric/aiproactive/ui/model/InspirationLocalPatch;Ljava/lang/Integer;Lcom/obric/aiproactive/api/AiProactiveCardStatus;)Lcom/obric/aiproactive/ui/model/AiProactiveActionExecutionPlan;", "buildAiProactiveActionListJson", "items", "", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "buildAiProactiveCompatActionCondition", "rawActionListJson", "currentTitle", "currentInstruction", "parseAiProactiveActionSnapshot", "Lcom/obric/aiproactive/api/AiProactiveCompatActionPayload;", "actionCondition", "resolveAiProactiveActionItems", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class l {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6751a = null;

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
            f6751a = r0;
        }
    }

    public static final ProactiveRecommendationDto a(ProactiveRecommendationDto r39, h r40) {
        ProactiveRecommendationDto r0 = r39;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r40, "patch");
        String r1 = a(r39);
        if (r1 != null) goto L5;
        return r0;
    L5:
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r40.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[InspirationPatch] ignoreBlankPatchInspirationId recommendId=" + r39.getRecommendId(), null, 4, null);
        return r0;
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return r0;
    L12:
        Integer r3 = r40.c();
        if (r3 == null) goto L15;
        r0 = ProactiveRecommendationDto.copy$default(r39, null, null, null, null, null, null, null, null, null, 0, 0.0d, null, null, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), null, null, null, null, null, null, null, null, null, 0, 0, null, null, 134209535, null);
    L15:
        ProactiveRecommendationDto r4 = r0;
        if (r40.d() == false) goto L18;
        r4 = ProactiveRecommendationDto.copy$default(r4, null, null, null, null, null, null, r40.e(), null, null, 0, 0.0d, null, null, 0, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 134217663, null);
    L18:
        ProactiveRecommendationDto r5 = r4;
        if (r40.f() == false) goto L21;
        r5 = ProactiveRecommendationDto.copy$default(r5, null, null, null, null, null, r40.g(), null, null, null, 0, 0.0d, null, null, 0, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 134217695, null);
    L21:
        ProactiveRecommendationDto r6 = r5;
        if (r40.h() == false) goto L24;
        r6 = ProactiveRecommendationDto.copy$default(r6, null, null, null, null, null, null, null, null, null, 0, 0.0d, null, null, 0, null, null, null, null, r40.i(), null, null, null, null, 0, 0, null, null, 133955583, null);
    L24:
        ProactiveRecommendationDto r7 = r6;
        if (r40.j() == false) goto L27;
        r7 = ProactiveRecommendationDto.copy$default(r7, null, null, null, null, null, null, null, null, null, 0, 0.0d, null, null, 0, null, null, null, null, null, r40.k(), null, null, null, 0, 0, null, null, 133693439, null);
    L27:
        ProactiveRecommendationDto r8 = r7;
        if (r40.l() == true) goto L30;
        return r8;
    L30:
        return ProactiveRecommendationDto.copy$default(r8, null, null, null, null, null, null, null, null, null, 0, 0.0d, null, null, 0, null, null, null, null, null, null, r40.m(), r40.n(), null, 0, 0, null, null, 131071999, null);
    }

    public static final n a(String r0) {
        return com.obric.aiproactive.api.c.b(r0);
    }

    private static final b a(ProactiveRecommendationDto r9, h r10, Integer r11, AiProactiveCardStatus r12) {
        ProactiveRecommendationDto r1 = null;
        if (Intrinsics.areEqual(r9.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == true) goto L5;
        return null;
    L5:
        Long r0 = StringsKt.toLongOrNull(r9.getRecommendId());
        if (r0 != null) goto L8;
    L20:
        return null;
    L8:
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L20;
        long r3 = r0.longValue();
        if (r10 == null) goto L19;
        r1 = a(r9, r10);
    L19:
        return new b(r3, r11, r12, r10, r1);
    L10:
        r2 = false;
        goto L11
    }

    static /* synthetic */ b a(ProactiveRecommendationDto r1, h r2, Integer r3, AiProactiveCardStatus r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return a(r1, r2, r3, r4);
    }

    public static final h a(ProactiveRecommendationDto r22, int r23, AiProactiveCardStatus r24) {
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Intrinsics.checkNotNullParameter(r24, "cardStatus");
        if (Intrinsics.areEqual(r22.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == true) goto L5;
        return null;
    L5:
        String r6 = a(r22);
        if (r6 != null) goto L8;
        return null;
    L8:
        List<com.obric.aiproactive.api.b> r1 = e(r22);
        if (r1.isEmpty() == true) goto L30;
        boolean r2 = false;
        int r5 = 1;
        if (r23 >= 0) goto L13;
    L15:
        if (r2 == false) goto L30;
        List<com.obric.aiproactive.api.b> r0 = com.obric.aiproactive.api.c.a(r1, r23);
        n r3 = com.obric.aiproactive.api.c.c(r0);
        int r4 = a.f6751a[r24.ordinal()];
        if (r4 == 1) goto L29;
        if (r4 != 2) goto L21;
    L27:
        r5 = 2;
        goto L29
    L21:
        if (r4 == 3) goto L27;
        if (r4 == 4) goto L27;
        throw new NoWhenBranchMatchedException();
    L29:
        return new h(r6, null, Integer.valueOf(r5), true, r3.c(), true, a(a(r0), r3.b(), r3.c()), false, null, false, null, false, null, null, 16258, null);
    L13:
        if (r23 >= ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).size()) goto L15;
        r2 = true;
    L30:
        return null;
    }

    public static final h a(ProactiveRecommendationDto r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        if (Intrinsics.areEqual(r20.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == true) goto L5;
        return null;
    L5:
        String r4 = a(r20);
        if (r4 != null) goto L8;
        return null;
    L8:
        List<com.obric.aiproactive.api.b> r0 = e(r20);
        if (r0.isEmpty() == false) goto L11;
        return null;
    L11:
        List<com.obric.aiproactive.api.b> r1 = com.obric.aiproactive.api.c.a(r0, r21);
        n r2 = com.obric.aiproactive.api.c.c(r1);
        return new h(r4, null, 1, true, r2.c(), true, a(a(r1), r2.b(), r2.c()), false, null, false, null, false, null, null, 16258, null);
    }

    public static final Object a(b r8, com.obric.aiproactive.ui.model.a r9, Continuation<? super Unit> r10) {
        com.obric.aiproactive.ui.model.a r2 = (com.obric.aiproactive.ui.model.a) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.aiproactive.ui.model.a.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Integer r11 = r8.b();
        if (r11 != null) goto L9;
        Object r12 = r2.a(r8.a(), r7);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r12;
    L8:
        return Unit.INSTANCE;
    L9:
        long r3 = r8.a();
        int r5 = r11.intValue();
        AiProactiveCardStatus r6 = r8.c();
        if (r6 == null) goto L17;
        Object r13 = r2.a(r3, r5, r6, r7);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r13;
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final String a(ProactiveRecommendationDto r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7.getInspirationId(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[InspirationIdentity] ignoreBlankInspirationId recommendId=" + r7.getRecommendId() + " recommendText=" + StringsKt.take(r7.getRecommendText(), 32), null, 4, null);
        return null;
    L6:
        return r0;
    }

    public static final String a(String r1, String r2, String r3) {
        return com.obric.aiproactive.api.c.a(new n(r1, r2, r3));
    }

    public static final String a(List<com.obric.aiproactive.api.b> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "items");
        return com.obric.aiproactive.api.c.a(r3);
    }

    public static final b b(ProactiveRecommendationDto r1, int r2, AiProactiveCardStatus r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "cardStatus");
        if (r2 >= 0) goto L7;
        return null;
    L7:
        return a(r1, a(r1, r2, r3), Integer.valueOf(r2), r3);
    }

    public static final String b(ProactiveRecommendationDto r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = a(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("inspirationId must not be blank");
    }

    public static final h c(ProactiveRecommendationDto r20) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        if (Intrinsics.areEqual(r20.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == true) goto L5;
        return null;
    L5:
        String r4 = a(r20);
        if (r4 != null) goto L8;
        return null;
    L8:
        List<com.obric.aiproactive.api.b> r0 = e(r20);
        if (r0.isEmpty() == false) goto L11;
        return null;
    L11:
        List<com.obric.aiproactive.api.b> r1 = com.obric.aiproactive.api.c.d(r0);
        n r2 = com.obric.aiproactive.api.c.c(r1);
        if (com.obric.aiproactive.api.c.e(r1) == false) goto L14;
        int r3 = 2;
    L16:
        return new h(r4, null, Integer.valueOf(r3), true, r2.c(), true, a(a(r1), r2.b(), r2.c()), false, null, false, null, false, null, null, 16258, null);
    L14:
        r3 = 1;
        goto L16
    }

    public static final b d(ProactiveRecommendationDto r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return a(r7, c(r7), null, null, 6, null);
    }

    private static final List<com.obric.aiproactive.api.b> e(ProactiveRecommendationDto r16) {
        n r0 = a(r16.getActionCondition());
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a();
    L6:
        List<com.obric.aiproactive.api.b> r3 = com.obric.aiproactive.api.c.a(r2);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        return r3;
    L9:
        String r4 = r16.getActionExecuteInstruction();
        if (r4 == null) goto L12;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        String r8 = r5;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L18;
        if (r0 == null) goto L23;
        String r6 = r0.b();
        if (r6 == null) goto L23;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L24:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L27;
    L30:
        boolean r10 = true;
    L32:
        if ((!r10) == false) goto L34;
        r1 = r7;
    L34:
        if (r1 != null) goto L36;
        String r11 = r8;
    L38:
        return CollectionsKt.listOf(new com.obric.aiproactive.api.b(r11, r8, 0, null, null, false, false, 120, null));
    L36:
        r11 = r1;
        goto L38
    L27:
        if (StringsKt.isBlank(r9) == true) goto L30;
        r10 = false;
    L23:
        r7 = null;
        goto L24
    L18:
        return CollectionsKt.emptyList();
    L12:
        r5 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }
}
