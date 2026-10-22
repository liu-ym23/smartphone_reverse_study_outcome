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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001a,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¨\u0006\n"}, d2 = {"computeAiBatchId", "", "rows", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "shouldApplyNowSnapshotWhenBatchNotAccepted", "", "uiLoading", "currentRecommendations", "incomingRecommendations", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class o {
    public static final long a(List<ProactiveRecommendationDto> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "rows");
        if (r10.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L47;
        ProactiveRecommendationDto r4 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r12.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        String r5 = com.obric.aiproactive.ui.model.l.a(r4);
        if (r5 != null) goto L11;
    L16:
        r5 = r4.getRecommendId();
    L17:
        StringBuilder r6 = new StringBuilder();
        r6.append(r4.getRecommendId());
        r6.append('#');
        r6.append(r5);
        r6.append('#');
        r6.append(r4.getRecommendStatus());
        r6.append('#');
        String r7 = r4.getInspirationFeedbackAction();
        String r8 = "";
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r6.append(r7);
        r6.append('#');
        String r13 = r4.getStatus();
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        r6.append(r13);
        r6.append('#');
        String r14 = r4.getRecommendText();
        if (r14 != null) goto L26;
        r14 = "";
    L26:
        r6.append(r14);
        r6.append('#');
        String r15 = r4.getReason();
        if (r15 != null) goto L29;
        r15 = "";
    L29:
        r6.append(r15);
        r6.append('#');
        String r16 = r4.getEmoji();
        if (r16 != null) goto L32;
        r16 = "";
    L32:
        r6.append(r16);
        r6.append('#');
        String r17 = r4.getType();
        if (r17 != null) goto L35;
        r17 = "";
    L35:
        r6.append(r17);
        r6.append('#');
        String r18 = r4.getActionCondition();
        if (r18 != null) goto L38;
        r18 = "";
    L38:
        r6.append(r18);
        r6.append('#');
        String r19 = r4.getActionExecuteInstruction();
        if (r19 == null) goto L42;
        r8 = r19;
    L42:
        r6.append(r8);
        r6.append('#');
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.getArtifacts(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L44:
        if (r20.hasNext() == false) goto L46;
        com.obric.aiproactive.api.j r21 = (com.obric.aiproactive.api.j) ZeusTransformUtils.preCheckCast(r20.next(), com.obric.aiproactive.api.j.class, "com.obric.memorydata.plugin");
        r6.append(r21.a());
        r6.append(':');
        r6.append(r21.c().getWireValue());
        r6.append(';');
        goto L44
    L46:
        String r22 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r22, "toString(...)");
        r0.add(r22);
        goto L7
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L16;
    L47:
        long r23 = 1125899906842597L;
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L49:
        if (r24.hasNext() == false) goto L52;
        r23 = (r23 * ((long) 31)) + ((long) ((String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.memorydata.plugin")).hashCode());
        goto L49
    L52:
        if (r23 != Long.MIN_VALUE) goto L55;
        return 0;
    L55:
        return Math.abs(r23);
    }

    public static final boolean a(boolean r2, List<ProactiveRecommendationDto> r3, List<ProactiveRecommendationDto> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "currentRecommendations");
        Intrinsics.checkNotNullParameter(r6, "incomingRecommendations");
        if (r2 == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r5, r6) == false) goto L8;
        return false;
    }
}
