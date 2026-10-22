package com.obric.aiproactive.ui.entry;

import com.obric.aiproactive.api.AiProactiveRecommendationFeedbackClassification;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0000\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0000\u001a\u0017\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0016\u001a\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a6\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u001fj\b\u0012\u0004\u0012\u00020\u0001` 2\u0006\u0010!\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"PROACTIVE_UI_TAG", "", "NOW_FIRST_PAGE_LIMIT", "", "ALL_DAY_PAGE_LIMIT_VALUE", "PROACTIVE_DAY_KEY_FORMATTER", "Ljava/time/format/DateTimeFormatter;", "getPROACTIVE_DAY_KEY_FORMATTER", "()Ljava/time/format/DateTimeFormatter;", "shouldAcceptStrictlyNewerBatch", "", "currentBatchId", "", "newBatchId", "isEmptyReset", "findCanonicalRecommendationByInspirationId", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "inspirationId", "recommendations", "", "shouldPinNowAdoptedAfterLocalPatch", "recommendStatus", "(Ljava/lang/Integer;)Z", "shouldShowRecommendationFeedbackToast", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "shouldApplyRecommendationFeedbackPatch", "shouldDispatchRecommendationFeedback", "removeDismissedNowRecommendation", "Lcom/obric/aiproactive/ui/entry/NowDismissRemovalResult;", "pinnedInspirationIds", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "recommendId", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DateTimeFormatter f6609a = null;

    static {
        DateTimeFormatter r0 = DateTimeFormatter.ISO_LOCAL_DATE;
        Intrinsics.checkNotNullExpressionValue(r0, "ISO_LOCAL_DATE");
        f6609a = r0;
    }

    public static final ProactiveRecommendationDto a(String r3, List<ProactiveRecommendationDto> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "recommendations");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if (Intrinsics.areEqual(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r0, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getInspirationId(), r3) == false) goto L4;
    L10:
        return (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r0, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
    L8:
        r0 = null;
        goto L10
    }

    public static final k a(List<ProactiveRecommendationDto> r6, LinkedHashSet<String> r7, String r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "recommendations");
        Intrinsics.checkNotNullParameter(r7, "pinnedInspirationIds");
        Intrinsics.checkNotNullParameter(r8, "recommendId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        String r3 = null;
        if (r0.hasNext() == false) goto L12;
        Object r2 = r0.next();
        if (Intrinsics.areEqual(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r2, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendId(), r8) == false) goto L7;
    L13:
        ProactiveRecommendationDto r1 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r2, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        Object r5 = r11.next();
        if (Intrinsics.areEqual(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendId(), r8) == true) goto L15;
        r4.add(r5);
        goto L15
    L19:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        LinkedHashSet r13 = new LinkedHashSet((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L29;
        String r14 = r1.getInspirationId();
        if (r14 == null) goto L29;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L26;
        r3 = r14;
    L26:
        if (r3 == null) goto L29;
        r13.remove(r3);
    L29:
        return new k(r12, r13);
    L12:
        r2 = null;
        goto L13
    L5:
        return new k(r9, new LinkedHashSet((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")));
    }

    public static final DateTimeFormatter a() {
        return f6609a;
    }

    public static final boolean a(long r3, long r5, boolean r7) {
        if (r7 == false) goto L8;
        if (r5 != 0) goto L8;
        return true;
    L8:
        if (r5 > 0) goto L10;
    L12:
        return false;
    L10:
        if (r5 == r3) goto L12;
        return true;
    }

    public static final boolean a(com.obric.aiproactive.api.u r4) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.c(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L19;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        return false;
    L13:
        if (StringsKt.isBlank(r5) == true) goto L16;
        r6 = false;
    L19:
        return true;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final boolean a(Integer r1) {
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() != 2) goto L7;
        return true;
    }

    public static final boolean b(com.obric.aiproactive.api.u r3) {
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
        return SetsKt.setOf(new AiProactiveRecommendationFeedbackClassification[]{AiProactiveRecommendationFeedbackClassification.ORDINARY_OR_MIXED, AiProactiveRecommendationFeedbackClassification.EXPLICIT_CLEAR}).contains(r3.h());
    }

    public static final boolean c(com.obric.aiproactive.api.u r1) {
        Intrinsics.checkNotNullParameter(r1, Ext.KEY_REQUEST);
        if (r1.h() == AiProactiveRecommendationFeedbackClassification.INVALID_VALUE_ONLY) goto L5;
        return true;
    L5:
        return false;
    }
}
