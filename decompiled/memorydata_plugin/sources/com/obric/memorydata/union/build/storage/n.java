package com.obric.memorydata.union.build.storage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000\u001a3\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u000f\u001aF\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fH\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002\u001a(\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0000\u001a9\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u00152\b\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010$\u001a0\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150(H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"TAG", "", "ALLOWED_CONSUMERS", "", "resolveConsumerCommitState", "Lcom/obric/memorydata/union/build/storage/ConsumerCommitState;", "current", "", "expected", "groupSeq", "validateRebuildAuthority", "replaceExisting", "", TypedValues.CycleType.S_WAVE_PHASE, "persistedTarget", "(ZLjava/lang/String;Ljava/lang/Long;J)Ljava/lang/String;", "validateReplacementCoverage", "consumerId", "expectedGroups", "outputGroups", "successfulRecordCount", "", "totalRecordCount", "fullSnapshotEmpty", "groupKey", "type", "treePath", "isValidInterestSummaryItem", "summary", "description", "resolveInterestSummaryWriteValues", "Lcom/obric/memorydata/union/build/storage/InterestSummaryWriteValues;", "modelCount", "previousCount", "previousCreateTime", "now", "(ILjava/lang/Integer;Ljava/lang/Integer;IZ)Lcom/obric/memorydata/union/build/storage/InterestSummaryWriteValues;", "summarizeInterestSummaryReplacement", "Lcom/obric/memorydata/union/build/storage/SummaryCountShrink;", "before", "", "after", "memory_build_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f13131a = null;

    static {
        f13131a = SetsKt.setOf(new String[]{"user_insight", "interest_summary"});
    }

    public static final ConsumerCommitState a(long r0, long r2, long r4) {
        if (r0 != r4) goto L6;
        return ConsumerCommitState.ALREADY_COMMITTED;
    L6:
        if (r0 == r2) goto L9;
        return ConsumerCommitState.CURSOR_CHANGED;
    L9:
        return ConsumerCommitState.APPLY;
    }

    public static final b a(int r1, Integer r2, Integer r3, int r4, boolean r5) {
        if (r5 == true) goto L9;
        if (r2 == null) goto L7;
        int r6 = r2.intValue();
    L8:
        r1 = Math.max(r1, r6);
        goto L9
    L7:
        r6 = 0;
    L9:
        if (r3 == null) goto L12;
        r4 = r3.intValue();
    L12:
        return new b(r1, r4);
    }

    public static final s a(Map<String, Integer> r8, Map<String, Integer> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "before");
        Intrinsics.checkNotNullParameter(r11, "after");
        Set r0 = SetsKt.plus(r10.keySet(), (Iterable) ZeusTransformUtils.preCheckCast(r11.keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        int r2 = r0.size();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L5;
    L7:
        Iterator r3 = r1.iterator();
        int r5 = 0;
    L9:
        if (r3.hasNext() == false) goto L25;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r11.get(r6), Integer.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        int r12 = r7.intValue();
    L14:
        Integer r13 = (Integer) ZeusTransformUtils.preCheckCast(r10.get(r6), Integer.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L17;
        int r14 = r13.intValue();
    L18:
        if (r12 >= r14) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L9;
        r5 = r5 + 1;
        if (r5 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L20:
        r15 = false;
        goto L21
    L17:
        r14 = 0;
        goto L18
    L13:
        r12 = 0;
        goto L14
    L25:
        r4 = r5;
    L27:
        return new s(r2, r4, CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(r10.values(), Iterable.class, "com.obric.memorydata.plugin")), CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(r11.values(), Iterable.class, "com.obric.memorydata.plugin")));
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public static final /* synthetic */ String a(String r0, String r1) {
        return b(r0, r1);
    }

    public static final String a(String r1, Set<String> r2, Set<String> r3, int r4, int r5, boolean r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "consumerId");
        Intrinsics.checkNotNullParameter(r7, "expectedGroups");
        Intrinsics.checkNotNullParameter(r8, "outputGroups");
        if (r6 == true) goto L5;
        return null;
    L5:
        if (r7.isEmpty() == true) goto L7;
    L10:
        return "INVALID_EMPTY_SNAPSHOT";
    L7:
        if (r8.isEmpty() == false) goto L10;
        if (r5 != 0) goto L10;
        return null;
    }

    public static final String a(boolean r3, String r4, Long r5, long r6) {
        if (r3 == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r4, "rebuild") == true) goto L9;
        return "REBUILD_NOT_AUTHORIZED";
    L9:
        if (r5 != null) goto L11;
        return "REBUILD_TARGET_CHANGED";
    L11:
        if (r5.longValue() > 0) goto L13;
        return "REBUILD_TARGET_CHANGED";
    L13:
        if (r5.longValue() != r6) goto L19;
        return null;
    L19:
        return "REBUILD_TARGET_CHANGED";
    }

    public static final /* synthetic */ Set a() {
        return f13131a;
    }

    public static final boolean a(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "treePath");
        Intrinsics.checkNotNullParameter(r4, "summary");
        Intrinsics.checkNotNullParameter(r5, "description");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L11:
        return false;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L11;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        return true;
    L9:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L11;
        return true;
    }

    private static final String b(String r1, String r2) {
        return r1 + 31 + r2;
    }
}
