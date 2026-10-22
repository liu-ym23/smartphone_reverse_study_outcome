package com.obric.aiproactive.ui.preference;

import com.obric.aiproactive.api.AiRuleItemDto;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¨\u0006\r"}, d2 = {"buildAiRuleAdapterItems", "", "Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem;", "rules", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "latestAssistantUpdatedText", "", "showGuidedEntry", "", "getAiRulePositionType", "", "index", "size", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {
    private static final int a(int r1, int r2) {
        if (r2 != 1) goto L5;
        return 0;
    L5:
        if (r1 != 0) goto L8;
        return 1;
    L8:
        if (r1 != (r2 - 1)) goto L10;
        return 3;
    L10:
        return 2;
    }

    public static final List<b.a> a(List<AiRuleItemDto> r11, String r12, boolean r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "rules");
        List<b.a> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L3:
        boolean r5 = false;
        if (r4.hasNext() == false) goto L10;
        Object r6 = r4.next();
        if (((AiRuleItemDto) ZeusTransformUtils.preCheckCast(r6, AiRuleItemDto.class, "com.obric.memorydata.plugin")).getType() != AiRuleItemDto.RuleType.CUSTOM) goto L8;
        r5 = true;
    L8:
        if (r5 == false) goto L3;
        r3.add(r6);
        goto L3
    L10:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L19;
        Object r9 = r16.next();
        if (((AiRuleItemDto) ZeusTransformUtils.preCheckCast(r9, AiRuleItemDto.class, "com.obric.memorydata.plugin")).getType() != AiRuleItemDto.RuleType.AI_GENERATED) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == false) goto L12;
        r8.add(r9);
        goto L12
    L16:
        r10 = false;
        goto L17
    L19:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        if (r13 == false) goto L23;
        r0.add(b.a.C0308a.f6759a);
    L23:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L36;
        r0.add(new b.a.C0309b("用户自定义 " + r7.size(), null));
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r19 = 0;
    L26:
        if (r18.hasNext() == false) goto L36;
        Object r20 = r18.next();
        int r21 = r19 + 1;
        if (r19 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        AiRuleItemDto r22 = (AiRuleItemDto) ZeusTransformUtils.preCheckCast(r20, AiRuleItemDto.class, "com.obric.memorydata.plugin");
        int r23 = a(r19, r7.size());
        if (r19 == CollectionsKt.getLastIndex(r7)) goto L33;
        boolean r24 = true;
    L34:
        r0.add(new b.a.c(r22, r23, r24));
        r19 = r21;
        goto L26
    L33:
        r24 = false;
    L36:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L48;
        r0.add(new b.a.C0309b("豆包生成 " + r17.size(), r12));
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r111 = 0;
    L39:
        if (r110.hasNext() == false) goto L48;
        Object r25 = r110.next();
        int r26 = r111 + 1;
        if (r111 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        AiRuleItemDto r27 = (AiRuleItemDto) ZeusTransformUtils.preCheckCast(r25, AiRuleItemDto.class, "com.obric.memorydata.plugin");
        int r28 = a(r111, r17.size());
        if (r111 == CollectionsKt.getLastIndex(r17)) goto L46;
        boolean r112 = true;
    L47:
        r0.add(new b.a.c(r27, r28, r112));
        r111 = r26;
        goto L39
    L46:
        r112 = false;
    L48:
        return r0;
    }
}
