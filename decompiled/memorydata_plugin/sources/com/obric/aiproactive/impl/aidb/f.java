package com.obric.aiproactive.impl.aidb;

import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.AiProactiveRecommendationFeedbackClassification;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\u0010\u0012\u001a\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a\u001c\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001c\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u001a\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0000\u001a#\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\u0010%\u001a\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"AI_PROACTIVE_FEEDBACK_EVENT_NAME", "", "AI_PROACTIVE_FEEDBACK_OPERATE_TYPE_CARD_CLICK", "", "AI_PROACTIVE_FEEDBACK_OPERATE_TYPE_VOTE", "AI_PROACTIVE_FEEDBACK_OPERATE_TYPE_OVERALL", "AI_PROACTIVE_FEEDBACK_TYPE_LIKE", "AI_PROACTIVE_FEEDBACK_TYPE_DISLIKE", "AI_PROACTIVE_FEEDBACK_TYPE_OVERALL", "buildFeedbackAwarenessExtra", "", "", "operateType", "rawTable", "rawId", "", "mapReporterFeedbackType", "feedbackType", "(Ljava/lang/String;)Ljava/lang/Integer;", "shouldTrackRecommendationFeedback", "", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "resolveRecommendationFeedbackExecutionPolicy", "Lcom/obric/aiproactive/impl/aidb/RecommendationFeedbackExecutionPolicy;", "shouldUpdateRecommendationFeedbackInDb", "shouldTrackRecommendationCardAction", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "shouldReportRecommendationCardAction", "mapRecommendationCardActionReportText", "isRecommendationCardActionMarker", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "resolveDirectFeedbackTraceContext", "Lcom/obric/aiproactive/impl/aidb/AiProactiveDirectFeedbackTraceContext;", "latestRecommendationTraceId", "logId", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/aiproactive/impl/aidb/AiProactiveDirectFeedbackTraceContext;", "parseFeedbackReportPolicy", "Lcom/obric/aiproactive/impl/aidb/FeedbackReportPolicy;", "raw", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class f {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6359a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6360b = null;

        static {
            int[] r0 = new int[AiProactiveRecommendationFeedbackClassification.values().length];
            r0[AiProactiveRecommendationFeedbackClassification.VALID_VALUE_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[AiProactiveRecommendationFeedbackClassification.INVALID_VALUE_ONLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r0[AiProactiveRecommendationFeedbackClassification.EXPLICIT_CLEAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[AiProactiveRecommendationFeedbackClassification.ORDINARY_OR_MIXED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            f6359a = r0;
            int[] r1 = new int[AiProactiveCardStatus.values().length];
            r1[AiProactiveCardStatus.DISMISSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r1[AiProactiveCardStatus.ACKNOWLEDGED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r1[AiProactiveCardStatus.EXECUTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r1[AiProactiveCardStatus.PENDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            f6360b = r1;
        }
    }

    public static final Integer a(String r1) {
        if (Intrinsics.areEqual(r1, "LIKE") == false) goto L7;
        int r2 = 1;
    L11:
        return Integer.valueOf(r2);
    L7:
        if (Intrinsics.areEqual(r1, "DISLIKE") == false) goto L9;
        r2 = 2;
        goto L11
    L9:
        return null;
    }

    public static final String a(AiProactiveCardStatus r1) {
        Intrinsics.checkNotNullParameter(r1, "cardStatus");
        int r2 = a.f6360b[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "ignore";
    L5:
        if (r2 != 2) goto L7;
        return "known";
    L7:
        if (r2 != 3) goto L9;
        return "execute";
    L9:
        if (r2 != 4) goto L12;
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static final Map<String, Object> a(int r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "rawTable");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("operate_type", Integer.valueOf(r2)), TuplesKt.to("raw_table", r3), TuplesKt.to("raw_id", Long.valueOf(r4))});
    }

    public static final boolean a(AiProactiveCardStatus r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "cardStatus");
        if (Intrinsics.areEqual(r2, "auto_dismiss") == false) goto L6;
        return false;
    L6:
        if (r1 == AiProactiveCardStatus.PENDING) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean a(com.obric.aiproactive.api.u r5) {
        Intrinsics.checkNotNullParameter(r5, Ext.KEY_REQUEST);
        if (a(r5.b()) != null) goto L23;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L23;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L23;
        if (com.obric.aiproactive.api.r.f6271a.a(r5.g()) != null) goto L23;
        return false;
    L15:
        if (StringsKt.isBlank(r2) == true) goto L18;
        r3 = false;
        goto L19
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
    L23:
        return true;
    }

    public static final t b(com.obric.aiproactive.api.u r12) {
        Intrinsics.checkNotNullParameter(r12, Ext.KEY_REQUEST);
        Integer r7 = com.obric.aiproactive.api.r.f6271a.a(r12.g());
        boolean r6 = a(r12);
        AiProactiveRecommendationFeedbackClassification r13 = r12.h();
        int r14 = a.f6359a[r13.ordinal()];
        if (r14 == 1) goto L16;
        if (r14 == 2) goto L19;
        if (r14 == 3) goto L18;
        if (r14 != 4) goto L12;
        return new t(false, true, r6, r6, r7);
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return new t(false, true, false, false, null);
    L19:
        return new t(true, false, false, false, null);
    L16:
        return new t(false, false, false, true, r7);
    }

    public static final boolean b(AiProactiveCardStatus r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "cardStatus");
        if (a(r1, r2) == true) goto L7;
        return false;
    L7:
        return !b(a(r1));
    }

    public static final boolean b(String r2) {
        if (r2 == null) goto L6;
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r3 == null) goto L6;
        String r4 = r3.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "toLowerCase(...)");
    L7:
        if (r4 == null) goto L24;
        int r0 = r4.hashCode();
        if (r0 == (-1319569547)) goto L22;
        if (r0 == (-1190396462)) goto L19;
        if (r0 != 102204227) goto L24;
        if (r4.equals("known") == false) goto L24;
    L23:
        return true;
    L19:
        if (r4.equals("ignore") == true) goto L23;
    L22:
        if (r4.equals("execute") == true) goto L23;
    L24:
        return false;
    L6:
        r4 = null;
        goto L7
    }

    public static final r c(String r10) {
        if (r10 == null) goto L28;
        Object r11 = com.obric.memorydata.utils.u.a().fromJson(r10, q.class);     // Catch: Exception -> L6
    L8:
        q r12 = (q) ZeusTransformUtils.preCheckCast(r11, q.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L28;
        boolean r2 = r12.a();
        List<p> r13 = r12.b();
        if (r13 != null) goto L14;
        r13 = CollectionsKt.emptyList();
    L14:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L16:
        if (r15.hasNext() == false) goto L26;
        String r4 = ((p) ZeusTransformUtils.preCheckCast(r15.next(), p.class, "com.obric.memorydata.plugin")).a();
        if (r4 != null) goto L20;
    L22:
        r4 = null;
    L23:
        if (r4 == null) goto L16;
        r3.add(r4);
        goto L16
    L20:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L22;
    L26:
        return new r(r2, CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
    L6:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r10 + " toObj error : " + e, null, 4, null);
        r11 = null;
    L28:
        return new r(false, null, 3, null);
    }
}
