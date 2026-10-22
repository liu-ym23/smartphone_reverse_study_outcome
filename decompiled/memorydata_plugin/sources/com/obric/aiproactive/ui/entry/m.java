package com.obric.aiproactive.ui.entry;

import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000\u001a \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000\u001a&\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tH\u0000\u001a\u0016\u0010\u001a\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tH\u0000\u001a\u0016\u0010\u001b\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tH\u0000\u001a\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0000\u001aJ\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000\u001a4\u0010%\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\t2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000\u001a\u0018\u0010(\u001a\u0004\u0018\u00010\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¨\u0006)"}, d2 = {"resolveNowVisualState", "Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment$NowVisualState;", "entryGate", "Lcom/obric/aiproactive/ui/entry/AiProactiveEntryGate;", "isProactiveEnabled", "", "celebrationPending", "celebrationActive", "recommendations", "", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "shouldRefreshNowPageOnResume", "resolveNowCelebrationRecommendations", "currentRecommendations", "previousRecommendations", "resolveNowCelebrationAfterAdoptingItem", "adoptedInspirationId", "", "shouldShowNowGuidedPreferenceEntry", "hasCompleted", "shouldShowNowRecyclerInSensingState", "sensingExitActive", "sensingExitRecommendationCount", "", "items", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "shouldResetNowViewportAfterCelebration", "hasNowSensingVisualCards", "resolveNowSensingVisualConfig", "Lcom/obric/aiproactive/ui/entry/NowVisualConfig;", "hasCards", "shouldStartNowCelebration", "previousHadPendingRecommendations", "activeBatchId", "", "celebratedBatchId", "previousCelebrationRecommendations", "shouldCancelNowCelebrationCache", "cachedInspirationIds", "currentInspirationIds", "pickOverallFeedbackRelatedInfo", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class m {
    public static final NowFeedPageFragment.NowVisualState a(AiProactiveEntryGate r6, boolean r7, boolean r8, boolean r9, List<com.obric.aiproactive.ui.model.j.f> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "entryGate");
        Intrinsics.checkNotNullParameter(r11, "recommendations");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendStatus() == 2) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
    L16:
        if (r6 == AiProactiveEntryGate.BLOCK) goto L29;
        if (r7 == false) goto L29;
        if (r11.isEmpty() == true) goto L35;
        if (r8 == true) goto L36;
        if (r9 == true) goto L37;
        if (r3 == false) goto L35;
    L37:
        return NowFeedPageFragment.NowVisualState.CELEBRATION;
    L36:
        return NowFeedPageFragment.NowVisualState.SUGGESTION;
    L35:
        return NowFeedPageFragment.NowVisualState.SENSING;
    L29:
        return NowFeedPageFragment.NowVisualState.SLEEP;
    L13:
        r2 = false;
    L6:
        r3 = false;
        goto L16
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public static final s a(boolean r0) {
        if (r0 == false) goto L5;
        return s.f6634a.b();
    L5:
        return s.f6634a.a();
    }

    public static final List<com.obric.aiproactive.ui.model.j.f> a(List<com.obric.aiproactive.ui.model.j.f> r43, String r44) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r43, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "currentRecommendations");
        if (r1.isEmpty() == true) goto L41;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r44, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r4 = true;
        if (r3 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L41;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r2.iterator();
        boolean r8 = false;
    L15:
        if (r7.hasNext() == false) goto L20;
        com.obric.aiproactive.ui.model.j.f r9 = (com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r9.b().getInspirationId(), r44) == false) goto L19;
        r9 = com.obric.aiproactive.ui.model.j.f.a(r9, ProactiveRecommendationDto.copy$default(r9.b(), null, null, null, null, null, null, null, null, null, 0, 0.0d, null, null, 2, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 134209535, null), null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
        r8 = true;
    L19:
        r6.add(r9);
        goto L15
    L20:
        List<com.obric.aiproactive.ui.model.j.f> r0 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        if (r8 == false) goto L39;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L25;
    L27:
        Iterator r11 = r10.iterator();
    L29:
        if (r11.hasNext() == false) goto L26;
        if (((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendStatus() == 2) goto L33;
        boolean r12 = true;
    L34:
        if (r12 == false) goto L29;
    L35:
        if (r4 == true) goto L39;
        return r0;
    L33:
        r12 = false;
    L26:
        r4 = false;
        goto L35
    L25:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L27;
    L39:
        return CollectionsKt.emptyList();
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r5 = false;
    L41:
        return CollectionsKt.emptyList();
    }

    public static final List<com.obric.aiproactive.ui.model.j.f> a(List<com.obric.aiproactive.ui.model.j.f> r41, List<com.obric.aiproactive.ui.model.j.f> r42) {
        List<com.obric.aiproactive.ui.model.j.f> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r41, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r42, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "currentRecommendations");
        Intrinsics.checkNotNullParameter(r2, "previousRecommendations");
        boolean r4 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L7;
    L9:
        Iterator r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L8;
        if (((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendStatus() == 2) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L11;
    L17:
        if (r4 == true) goto L19;
        return r0;
    L19:
        return CollectionsKt.emptyList();
    L15:
        r6 = false;
    L8:
        r4 = false;
        goto L17
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L21:
        if (r2.isEmpty() == true) goto L23;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r1.iterator();
    L26:
        if (r8.hasNext() == false) goto L33;
        com.obric.aiproactive.ui.model.j.f r9 = (com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin");
        if (r9.b().getRecommendStatus() == 2) goto L31;
        r9 = com.obric.aiproactive.ui.model.j.f.a(r9, ProactiveRecommendationDto.copy$default(r9.b(), null, null, null, null, null, null, null, null, null, 0, 0.0d, null, null, 2, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 134209535, null), null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
    L31:
        r7.add(r9);
        goto L26
    L33:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L23:
        return CollectionsKt.emptyList();
    }

    public static final boolean a(AiProactiveEntryGate r1) {
        Intrinsics.checkNotNullParameter(r1, "entryGate");
        if (r1 != AiProactiveEntryGate.ALLOW) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean a(List<? extends com.obric.aiproactive.ui.model.j> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "items");
        return ZeusTransformUtils.instanceOf(CollectionsKt.firstOrNull(r3), com.obric.aiproactive.ui.model.j.c.class);
    }

    public static final boolean a(List<String> r2, List<String> r3, boolean r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "cachedInspirationIds");
        Intrinsics.checkNotNullParameter(r7, "currentInspirationIds");
        if (r4 == true) goto L7;
        if (r5 == true) goto L7;
        return false;
    L7:
        if (r7.isEmpty() == false) goto L10;
        return false;
    L10:
        return !Intrinsics.areEqual(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")), CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")));
    }

    public static final boolean a(boolean r3, int r4, List<? extends com.obric.aiproactive.ui.model.j> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "items");
        if (r3 == false) goto L5;
        if (r4 <= 0) goto L5;
        return true;
    L5:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L8;
    L10:
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L9;
        if (ZeusTransformUtils.instanceOf((com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin"), com.obric.aiproactive.ui.model.j.c.class) == false) goto L12;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L19;
        return true;
    L19:
        return false;
    L9:
        r9 = false;
        goto L16
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        goto L9
    }

    public static final boolean a(boolean r2, List<com.obric.aiproactive.ui.model.j.f> r3, List<com.obric.aiproactive.ui.model.j.f> r4, long r5, long r7, List<com.obric.aiproactive.ui.model.j.f> r9) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "currentRecommendations");
        Intrinsics.checkNotNullParameter(r8, "previousRecommendations");
        Intrinsics.checkNotNullParameter(r10, "previousCelebrationRecommendations");
        if (r2 == true) goto L5;
        return false;
    L5:
        List<com.obric.aiproactive.ui.model.j.f> r11 = a(r6, r8);
        if (r11.isEmpty() == false) goto L9;
        return false;
    L9:
        if (r5 > 0) goto L11;
    L29:
        return false;
    L11:
        if (r7 == r5) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L16;
    L28:
        return true;
    L16:
        if (r11.size() != r10.size()) goto L28;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L19:
        if (r14.hasNext() == false) goto L21;
        r13.add(((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getInspirationId());
        goto L19
    L21:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L23:
        if (r18.hasNext() == false) goto L26;
        r17.add(((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getInspirationId());
        goto L23
    L26:
        if (Intrinsics.areEqual(r15, (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin")) == false) goto L28;
        return false;
    }

    public static final boolean a(boolean r0, boolean r1, boolean r2) {
        if (r0 == true) goto L6;
        if (r1 == true) goto L6;
        if (r2 == true) goto L6;
        return true;
    L6:
        return false;
    }

    public static final boolean b(List<? extends com.obric.aiproactive.ui.model.j> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "items");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L5;
    L7:
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L19;
        com.obric.aiproactive.ui.model.j r0 = (com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiproactive.ui.model.j.f.class) == false) goto L15;
        if (((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r0, com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendStatus() == 2) goto L15;
    L16:
        boolean r1 = true;
    L18:
        if (r1 == false) goto L9;
        return true;
    L15:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiproactive.ui.model.j.c.class) == true) goto L16;
        r1 = false;
    L19:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public static final String c(List<com.obric.aiproactive.ui.model.j.f> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "recommendations");
        com.obric.aiproactive.ui.model.j.f r5 = (com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r4), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L12;
        ProactiveRecommendationDto r6 = r5.b();
        if (r6 == null) goto L13;
        String r7 = r6.getRecommendText();
        if (r7 != null) goto L9;
        return null;
    L9:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
        return null;
    L11:
        return r7;
    L13:
        return null;
    L12:
        return null;
    }
}
