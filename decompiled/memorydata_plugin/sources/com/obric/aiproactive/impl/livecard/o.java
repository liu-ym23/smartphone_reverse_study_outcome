package com.obric.aiproactive.impl.livecard;

import android.content.Intent;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\u0012\u0010\u001a\u001a\u00020\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001c\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0000\u001a!\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0002\u0010%\u001a5\u0010&\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0002\u0010'\u001a\u001c\u0010(\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0002\u001a&\u0010)\u001a\u0004\u0018\u00010\u00012\b\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010+\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u0001H\u0000\u001a+\u0010-\u001a\u0004\u0018\u00010#2\b\u0010.\u001a\u0004\u0018\u00010#2\b\u0010+\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010/\u001a\u0012\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0000\u001a!\u00102\u001a\u00020\u001e2\b\u00103\u001a\u0004\u0018\u00010\u00182\b\u00104\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\u00105\u001a\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00142\f\u00108\u001a\b\u0012\u0004\u0012\u0002090\u0014H\u0000\u001a\u001a\u0010:\u001a\u00020\u001e2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020#H\u0000\u001a\u0012\u0010>\u001a\b\u0012\u0004\u0012\u0002090\u0014*\u00020\u0015H\u0000\u001a\u001a\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0001H\u0000\u001a\u0012\u0010C\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"LOCK_SCREEN_CONSUMED_CANDIDATE_SET_KEY", "", "LOCK_SCREEN_CONSUMED_TOP_ROW_ID", "LOCK_SCREEN_ACTION_IGNORE", "LOCK_SCREEN_ACTION_GET", "LOCK_SCREEN_ACTION_EXECUTE_NOW", "LOCK_SCREEN_ACTION_AUTO_DISMISS", "LOCK_SCREEN_ACTION_CLOSE", "buildLockscreenDetailIntentSpec", "Lcom/obric/aiproactive/impl/livecard/LockscreenDetailIntentSpec;", "hostPackageName", "inspirationId", "buildLockscreenDetailIntent", "Landroid/content/Intent;", "spec", "resolveLockScreenDetachPolicy", "Lcom/obric/aiproactive/impl/livecard/LockScreenDetachPolicy;", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/aiproactive/impl/livecard/LockScreenDetachReason;", "selectLockScreenRecommendationsForVersion", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "recommendations", "liveCardVersion", "", "orderLockScreenRecommendationsForSync", "buildConsumedCandidateSetStoreKey", "uid", "buildConsumedTopRowIdStoreKey", "shouldSuppressCandidateSet", "", "candidateSetKey", "consumedCandidateSetKey", "shouldSuppressTopRowId", "topRowId", "", "consumedTopRowId", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "shouldSuppressTopRowIdForCandidate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Z", "isSameConsumedNamespace", "resolveConsumedCandidateSetKey", "activeCandidateSetKey", "activeRecommendId", "processedRecommendId", "resolveConsumedTopRowId", "activeTopRowId", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "shouldDestroyLockScreenCardAfterProcessedSync", "feedbackAction", "shouldRefreshLiveCardTheme", "previousNightMode", "currentNightMode", "(Ljava/lang/Integer;Ljava/lang/Integer;)Z", "buildAiSuggestionLockScreenActions", "Lcom/obric/aiproactive/impl/livecard/AiSuggestionLockScreenAction;", "items", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "isSuccessfulLockScreenContinueResult", "result", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementResult;", "requestId", "resolveAiSuggestionActionItems", "buildAiProactiveLockScreenDbMutation", "Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenDbMutation;", "recommendId", "actionLabel", "mapDismissReasonToLockScreenAction", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class o {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6480a = null;

        static {
            int[] r0 = new int[LockScreenDetachReason.values().length];
            r0[LockScreenDetachReason.PROCESSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LockScreenDetachReason.DETAIL_OPEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f6480a = r0;
        }
    }

    public static final Intent a(k r3) {
        Intrinsics.checkNotNullParameter(r3, "spec");
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.MAIN");
        r0.addCategory("android.intent.category.LAUNCHER");
        r0.setClassName(r3.a(), r3.b());
        r0.putExtra("inspirationId", r3.c());
        r0.putExtra("enter_from", r3.d());
        r0.addFlags(r3.e());
        return r0;
    }

    public static final j a(LockScreenDetachReason r2) {
        Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
        int r3 = a.f6480a[r2.ordinal()];
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L8;
        return new j(true, true, false);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return new j(true, true, true);
    }

    public static final k a(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "hostPackageName");
        Intrinsics.checkNotNullParameter(r8, "inspirationId");
        return new k(r7, "com.obric.memorydata.plugin_api.stub.activity.ProactiveNowShortcutActivity", r8, "lockscreen_card", 335544320);
    }

    public static final Long a(Long r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "processedRecommendId");
        if (r3 != null) goto L5;
        return null;
    L5:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        return null;
    L15:
        if (Intrinsics.areEqual(r4, r5) == true) goto L17;
        return null;
    L17:
        return r3;
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r2 = false;
        goto L12
    }

    public static final String a(String r2) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return "lock_screen_consumed_candidate_set_key";
    L12:
        return r2 + "_lock_screen_consumed_candidate_set_key";
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final String a(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "processedRecommendId");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L15;
    L16:
        r2 = true;
    L17:
        if (r2 == false) goto L20;
        return null;
    L20:
        if (Intrinsics.areEqual(r6, r7) == true) goto L22;
        return null;
    L22:
        return r5;
    L15:
        if (StringsKt.isBlank(r3) == false) goto L17;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    public static final List<com.obric.aiproactive.api.b> a(ProactiveRecommendationDto r17) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        com.obric.aiproactive.api.n r0 = com.obric.aiproactive.api.c.b(r17.getActionCondition());
        String r2 = null;
        if (r0 == null) goto L5;
        String r3 = r0.a();
    L6:
        List<com.obric.aiproactive.api.b> r4 = com.obric.aiproactive.api.c.a(r3);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        return r4;
    L9:
        String r1 = r17.getActionExecuteInstruction();
        if (r1 == null) goto L12;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        String r9 = r5;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L18;
        if (r0 == null) goto L23;
        String r6 = r0.b();
        if (r6 == null) goto L23;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L24:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L27;
    L30:
        boolean r10 = true;
    L32:
        if ((!r10) == false) goto L34;
        r2 = r7;
    L34:
        if (r2 != null) goto L36;
        String r11 = r9;
    L38:
        return CollectionsKt.listOf(new com.obric.aiproactive.api.b(r11, r9, 0, null, null, false, false, 120, null));
    L36:
        r11 = r2;
        goto L38
    L27:
        if (StringsKt.isBlank(r8) == true) goto L30;
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
        r3 = null;
        goto L6
    }

    public static final List<h> a(List<com.obric.aiproactive.api.b> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "items");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
        int r4 = 0;
    L4:
        if (r14.hasNext() == false) goto L25;
        Object r2 = r14.next();
        int r10 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.obric.aiproactive.api.b r9 = (com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r3) == false) goto L11;
        r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L11:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r6) == false) goto L14;
        r6 = r5;
    L14:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (r9.h() == true) goto L17;
    L20:
        h r8 = null;
    L21:
        if (r8 == null) goto L23;
        r0.add(r8);
    L23:
        r4 = r10;
        goto L4
    L17:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L20;
        r8 = new h(r4, r5, r7, r9.j(), r9.i(), r9);
        goto L21
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static final List<ProactiveRecommendationDto> a(List<ProactiveRecommendationDto> r2, int r3) {
        List<ProactiveRecommendationDto> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "recommendations");
        if (m.a(r3) == false) goto L6;
        return r4;
    L6:
        return CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), 1);
    }

    public static final boolean a(z r4, long r5) {
        if (r4 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L13;
        if (r4.c() != r5) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r4.a() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static final boolean a(Integer r0, Integer r1) {
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        if (Intrinsics.areEqual(r0, r1) == true) goto L7;
        return true;
    L7:
        return false;
    }

    public static final boolean a(Long r3, Long r4) {
        if (r3 == null) goto L10;
        if (r4 != null) goto L7;
        return false;
    L7:
        if (r3.longValue() > r4.longValue()) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public static final boolean a(String r0, String r1, Long r2, Long r3) {
        if (d(r0, r1) == true) goto L7;
        return false;
    L7:
        return a(r2, r3);
    }

    public static final String b(String r2) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return "lock_screen_consumed_top_row_id";
    L12:
        return r2 + "_lock_screen_consumed_top_row_id";
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final List<ProactiveRecommendationDto> b(List<ProactiveRecommendationDto> r2, int r3) {
        List<ProactiveRecommendationDto> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "recommendations");
        if (m.a(r3) == true) goto L5;
        return r4;
    L5:
        return CollectionsKt.reversed((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean b(String r4, String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L20;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L13;
    L16:
        if (r2 == true) goto L20;
        return Intrinsics.areEqual(r4, r5);
    L13:
        if (StringsKt.isBlank(r3) == true) goto L16;
        r2 = false;
    L20:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final c c(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "recommendId");
        Intrinsics.checkNotNullParameter(r8, "actionLabel");
        Long r9 = StringsKt.toLongOrNull(r7);
        if (r9 != null) goto L5;
        return null;
    L5:
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r9 = null;
    L11:
        if (r9 == null) goto L37;
        long r3 = r9.longValue();
        switch(r8.hashCode()) {
            case -1190396462: goto L31;
            case -659661552: goto L28;
            case -503572486: goto L24;
            case -459075828: goto L20;
            case 102230: goto L16;
            default: goto L38;
        };
    L38:
        return null;
    L16:
        if (r8.equals("get") == false) goto L39;
        Object r10 = new c.b(r3, AiProactiveCardStatus.ACKNOWLEDGED);
    L35:
        return (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin");
    L39:
        return null;
    L20:
        if (r8.equals("execute_now") == false) goto L40;
        r10 = new c.a(r3);
        goto L35
    L40:
        return null;
    L24:
        if (r8.equals("auto_dismiss") == false) goto L41;
        r10 = new c.b(r3, AiProactiveCardStatus.PENDING);
        goto L35
    L41:
        return null;
    L28:
        if (r8.equals("lockscreen_close") == false) goto L42;
    L33:
        r10 = new c.b(r3, AiProactiveCardStatus.DISMISSED);
        goto L35
    L42:
        return null;
    L31:
        if (r8.equals("ignore") == true) goto L33;
        return null;
    L37:
        return null;
    L7:
        r1 = false;
        goto L8
    }

    public static final boolean c(String r0) {
        return true;
    }

    public static final String d(String r1) {
        if (Intrinsics.areEqual(r1, "auto_dismiss") == true) goto L7;
        return "lockscreen_close";
    L7:
        return "auto_dismiss";
    }

    private static final boolean d(String r5, String r6) {
        if (r5 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r6 != null) goto L10;
    L12:
        boolean r8 = false;
    L13:
        if (r7 != r8) goto L16;
        return true;
    L16:
        return false;
    L10:
        if (StringsKt.startsWith$default(r6, "ai_proactive:", false, 2, null) != true) goto L12;
        r8 = true;
        goto L13
    L5:
        if (StringsKt.startsWith$default(r5, "ai_proactive:", false, 2, null) != true) goto L7;
        r7 = true;
        goto L8
    }
}
