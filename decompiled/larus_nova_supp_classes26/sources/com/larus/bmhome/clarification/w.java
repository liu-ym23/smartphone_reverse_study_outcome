package com.larus.bmhome.clarification;

import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.InteractionAskBlock;
import com.larus.im.bean.message.block.InteractionAskOption;
import com.larus.im.bean.message.block.InteractionAskQuestion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w {
    public static final boolean a(Block r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.getBlockType();
        int r1 = com.larus.bmhome.chat.deepresearch.view.j.a;
        if (r0 == com.larus.bmhome.chat.deepresearch.view.j.q0) goto L5;
        return false;
    L5:
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L48;
        InteractionAskBlock r7 = r6.getInteractionAskBlock();
        if (r7 != null) goto L11;
        return false;
    L11:
        if (r7.getQuickReplyScene() == 11) goto L38;
        List r8 = r7.getQuestions();
        if (r8 != null) goto L15;
        r8 = CollectionsKt.emptyList();
    L15:
        ArrayList r2 = new ArrayList();
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L23;
        List r3 = ((InteractionAskQuestion) r9.next()).getOptions();
        if (r3 != null) goto L21;
        r3 = CollectionsKt.emptyList();
    L21:
        CollectionsKt.addAll(r2, r3);
        goto L17
    L23:
        if (r2.isEmpty() == false) goto L25;
    L24:
        boolean r10 = false;
    L37:
        if (r10 == true) goto L38;
        return false;
    L25:
        Iterator r11 = r2.iterator();
    L27:
        if (r11.hasNext() == false) goto L24;
        InteractionAskOption r4 = (InteractionAskOption) r11.next();
        if (r4.getActionType() != 50) goto L31;
    L34:
        boolean r12 = true;
    L35:
        if (r12 == false) goto L27;
        r10 = true;
        goto L37
    L31:
        if (r4.getActionType() == 51) goto L34;
        r12 = false;
    L38:
        return true;
    L48:
        return false;
    }
}
