package com.obric.aiproactive.impl.aidb;

import com.obric.aiproactive.api.AiRuleItemDto;
import com.obric.aiproactive.api.aa;
import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
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
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a,\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0000\u001a\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0016H\u0002\u001a*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0000\u001a\f\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a.\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0007H\u0000\u001a\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\r*\b\u0012\u0004\u0012\u00020 0\rH\u0000\u001a\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"PREFERENCE_TYPE_USER", "", "PREFERENCE_TYPE_ASSISTANT", "PREFERENCE_TYPE_INTERVIEW", "buildPreferenceActionParams", "", "preferenceId", "", "actionType", "preferenceType", "FIRST_WAKE_FALLBACK_EVENT_TEXT", "HISTORY_EMPTY_TODAY_FALLBACK_EVENT_TEXT", "normalizeGeneratedAiRuleContents", "", "contents", "buildAiRuleFollowupCounts", "Lcom/obric/aiproactive/api/AiRuleFollowupCountDto;", "rows", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactivePreferenceEntity;", "resolveUpdatedPreferenceType", "currentDbType", "requestedRuleType", "Lcom/obric/aiproactive/api/AiRuleItemDto$RuleType;", "toDbType", "bindInsertedPreferenceEntities", "entities", "ids", "toPreferenceActionType", "buildGeneratedAiRuleEntities", "type", "now", "filterDisplayableEventRecords", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveEventRecordEntity;", "resolveFallbackEventText", "totalCount", "", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6358a = null;

        static {
            int[] r0 = new int[AiRuleItemDto.RuleType.values().length];
            r0[AiRuleItemDto.RuleType.CUSTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AiRuleItemDto.RuleType.AI_GENERATED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f6358a = r0;
        }
    }

    public static final String a(int r0) {
        if (r0 > 0) goto L4;
        return "用户唤醒我了！有什么值得重点关注？💬";
    L4:
        return "用户又来监督我了！打起精神来！💪";
    }

    private static final String a(AiRuleItemDto.RuleType r1) {
        int r2 = a.f6358a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "user";
    L5:
        if (r2 != 2) goto L8;
        return "assistant";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ String a(String r0) {
        return b(r0);
    }

    public static final String a(String r1, AiRuleItemDto.RuleType r2) {
        Intrinsics.checkNotNullParameter(r1, "currentDbType");
        Intrinsics.checkNotNullParameter(r2, "requestedRuleType");
        return a(r2);
    }

    public static final List<String> a(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "contents");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r0.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L4
    L6:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L16;
        Object r2 = r10.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L8;
        r1.add(r2);
        goto L8
    L12:
        r3 = false;
        goto L13
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    public static final List<com.obric.aiproactive.impl.aidb.a.f> a(List<String> r21, String r22, long r23) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "contents");
        Intrinsics.checkNotNullParameter(r22, "type");
        List<String> r1 = a(r0);
        int r2 = CollectionsKt.getLastIndex(r1);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
        int r5 = 0;
    L4:
        if (r4.hasNext() == false) goto L10;
        Object r6 = r4.next();
        int r16 = r5 + 1;
        if (r5 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        long r12 = r23 + ((long) (r2 - r5));
        Collection r20 = r14;
        r20.add(new com.obric.aiproactive.impl.aidb.a.f(0, r12, (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"), r22, r12, r12, 1, null));
        r14 = r20;
        r5 = r16;
        goto L4
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
    }

    public static final List<com.obric.aiproactive.impl.aidb.a.f> a(List<com.obric.aiproactive.impl.aidb.a.f> r20, List<Long> r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "entities");
        Intrinsics.checkNotNullParameter(r2, "ids");
        boolean r5 = false;
        if (r2.size() != r0.size()) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L30;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L10;
    L12:
        Iterator r6 = r4.iterator();
    L14:
        if (r6.hasNext() == false) goto L11;
        if (((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L14;
    L20:
        if (r5 == false) goto L28;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L23:
        if (r10.hasNext() == false) goto L26;
        int r11 = ((IntIterator) ZeusTransformUtils.preCheckCast(r10, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        r9.add(com.obric.aiproactive.impl.aidb.a.f.a((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r0.get(r11), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r2.get(r11), Number.class, "com.obric.memorydata.plugin")).longValue(), 0, null, null, 0, 0, 62, null));
        goto L23
    L26:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    L28:
        throw new IllegalArgumentException("Preference insert returned an invalid database id".toString());
    L18:
        r7 = false;
    L11:
        r5 = true;
        goto L20
    L10:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L12;
    L30:
        throw new IllegalArgumentException("Preference insert result count did not match the requested count".toString());
    L5:
        r3 = false;
        goto L6
    }

    public static final Map<String, String> a(long r1, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "preferenceType");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("preference_id", String.valueOf(r1)), TuplesKt.to(AwarenessManagerImpl.KEY_ACTION_TYPE, r3), TuplesKt.to("preference_type", r4)});
    }

    public static final aa b(List<com.obric.aiproactive.impl.aidb.a.f> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "rows");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L15;
        if (StringsKt.equals(((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin")).getType(), "assistant", true) == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L18;
    L20:
        Iterator r5 = r3.iterator();
        int r6 = 0;
    L22:
        if (r5.hasNext() == false) goto L28;
        if (StringsKt.equals(((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin")).getType(), "user", true) == false) goto L22;
        r6 = r6 + 1;
        if (r6 >= 0) goto L22;
        CollectionsKt.throwCountOverflow();
    L28:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L31;
    L33:
        Iterator r11 = r10.iterator();
    L35:
        if (r11.hasNext() == false) goto L42;
        if (StringsKt.equals(((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin")).getType(), "interview", true) == false) goto L35;
        r4 = r4 + 1;
        if (r4 >= 0) goto L35;
        CollectionsKt.throwCountOverflow();
    L42:
        return new aa(r2, r6, r4);
    L31:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L33;
    L18:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L20;
        r6 = 0;
        goto L28
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        r2 = 0;
        goto L15
    }

    private static final String b(String r3) {
        String r4 = r3.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "toLowerCase(...)");
        if (Intrinsics.areEqual(r4, "user") == false) goto L6;
        return "user";
    L6:
        if (Intrinsics.areEqual(r4, "interview") == true) goto L10;
        return "assistant";
    L10:
        return "interview";
    }

    public static final List<com.obric.aiproactive.impl.aidb.a.c> c(List<com.obric.aiproactive.impl.aidb.a.c> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Object r2 = r8.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.impl.aidb.a.c) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.impl.aidb.a.c.class, "com.obric.memorydata.plugin")).g(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }
}
