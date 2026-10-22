package com.obric.assistant.state.impl.v2.utils;

import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.GenericToolBlock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final Set<Integer> a = null;
    public static final Set<Integer> b = null;

    static {
        a = SetsKt.setOf(new Integer[]{1, 2, 5, 7});
        b = SetsKt.setOf(new Integer[]{1, 2, 3, 4, 6, 10, 11, 9, 12});
    }

    public static final List<ArtifactBlock> a(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(com.larus.im.bean.message.a.d(r1)), new a()), new b()));
    }

    public static final List<Block> b(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        List r5 = com.larus.im.bean.message.a.d(r4);
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        BlockContent r2 = ((Block) r1).getContent();
        if (r2 == null) goto L10;
        GenericToolBlock r3 = r2.getGenericToolBlock();
        if (r3 == null) goto L10;
        String r7 = r3.toolName;
    L12:
        if (Intrinsics.areEqual(r7, "text_to_video") == false) goto L4;
        r0.add(r1);
    L10:
        r7 = null;
        goto L12
    L14:
        return r0;
    }

    public static final boolean c(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Set<Integer> r0 = b;
        ArtifactBlock r1 = com.larus.im.bean.message.a.n(r2);
        if (r1 == null) goto L5;
        Integer r3 = r1.getResourceType();
    L7:
        if (CollectionsKt.contains(r0, r3) == false) goto L9;
        return true;
    L9:
        if ((!a(r2).isEmpty()) == true) goto L14;
        return false;
    L14:
        return true;
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean d(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (com.larus.im.bean.message.a.l0(r5) == false) goto L5;
    L81:
        return true;
    L5:
        if (e.b(r5) == true) goto L81;
        if (e(r5) == true) goto L81;
        if (f(r5) == true) goto L81;
        Map r0 = r5.getExt();
        Map r2 = null;
        if (r0 == null) goto L14;
        String r1 = (String) r0.get("use_creation");
    L16:
        if (Intrinsics.areEqual(r1, "1") == false) goto L24;
        Map r3 = r5.getExt();
        if (r3 == null) goto L20;
        String r4 = (String) r3.get("is_image_related");
    L22:
        if (Intrinsics.areEqual(r4, "1") == false) goto L24;
        return true;
    L20:
        r4 = null;
    L24:
        boolean r6 = false;
        if (com.larus.bmhome.chat.bean.d.k(r5) == false) goto L44;
        List r7 = com.larus.im.bean.message.a.l(r5);
        if (r7.isEmpty() == false) goto L29;
    L28:
        boolean r8 = false;
    L41:
        if (r8 == false) goto L44;
        return true;
    L29:
        Iterator r9 = r7.iterator();
    L31:
        if (r9.hasNext() == false) goto L28;
        Integer r10 = ((CreationItem) r9.next()).type;
        if (r10 != null) goto L36;
    L38:
        boolean r11 = false;
    L39:
        if (r11 == false) goto L31;
        r8 = true;
        goto L41
    L36:
        if (r10.intValue() != 1) goto L38;
        r11 = true;
    L44:
        if (com.larus.bmhome.chat.component.regen.i.a(r5) == false) goto L73;
        CreationMsgContentData r12 = dp8.e.c(r5);
        if (r12 == null) goto L50;
        CreationInfo r13 = r12.creationInfo;
        if (r13 == null) goto L50;
        r2 = r13.taskInfo;
    L50:
        if (r2 != null) goto L52;
        r2 = MapsKt.emptyMap();
    L52:
        Collection r14 = r2.values();
        if ((r14 instanceof Collection) == true) goto L55;
    L57:
        Iterator r15 = r14.iterator();
    L59:
        if (r15.hasNext() == false) goto L70;
        CreationTask r16 = (CreationTask) r15.next();
        if (r16 == null) goto L67;
        Integer r17 = r16.taskType;
        if (r17 == null) goto L67;
        if (a.contains(Integer.valueOf(r17.intValue())) != true) goto L67;
        boolean r18 = true;
    L68:
        if (r18 == false) goto L59;
        r6 = true;
    L67:
        r18 = false;
    L70:
        if (r6 == false) goto L73;
        return true;
    L55:
        if (r14.isEmpty() == false) goto L57;
    L73:
        if (r5.getContentType() != 6) goto L80;
        if (com.larus.bmhome.chat.bean.d.o0(r5) == false) goto L80;
        if (com.larus.bmhome.chat.bean.d.N0(r5) == true) goto L80;
        return true;
    L80:
        return c(r5);
    L14:
        r1 = null;
        goto L16
    }

    public static final boolean e(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map r1 = r5.getExt();
        if (r1 == null) goto L5;
        String r2 = (String) r1.get("general_agent");
    L7:
        if (Intrinsics.areEqual(r2, "1") == false) goto L23;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List r6 = com.larus.im.bean.message.a.d(r5);
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L21;
        Object r3 = r7.next();
        BlockContent r4 = ((Block) r3).getContent();
        if (r4 == null) goto L16;
        GenericToolBlock r8 = r4.getGenericToolBlock();
        if (r8 == null) goto L16;
        String r9 = r8.toolName;
    L18:
        if (Intrinsics.areEqual(r9, "text_to_audio_plus") == false) goto L10;
        r0.add(r3);
    L16:
        r9 = null;
        goto L18
    L21:
        if ((!r0.isEmpty()) == false) goto L23;
        return true;
    L23:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public static final boolean f(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Map r0 = r4.getExt();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("general_agent");
    L7:
        if (Intrinsics.areEqual(r1, "1") == true) goto L9;
        return false;
    L9:
        if ((!b(r4).isEmpty()) == true) goto L26;
        List r5 = com.larus.im.bean.message.a.l(r4);
        if (r5.isEmpty() == false) goto L13;
    L12:
        boolean r6 = false;
    L25:
        if (r6 == true) goto L26;
        return false;
    L13:
        Iterator r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L12;
        Integer r2 = ((CreationItem) r7.next()).type;
        if (r2 != null) goto L20;
    L22:
        boolean r3 = false;
    L23:
        if (r3 == false) goto L15;
        r6 = true;
        goto L25
    L20:
        if (r2.intValue() != 2) goto L22;
        r3 = true;
    L26:
        return true;
    L5:
        r1 = null;
        goto L7
    }
}
