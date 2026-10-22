package com.ss.android.lark.reaction.service.impl;

import com.bytedance.lark.pb.im.v1.EmojiPanel;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static DefaultEmojiPanelData a(EmojiPanel r7) {
        DefaultEmojiPanelData r0 = new DefaultEmojiPanelData();
        if (r7 != null) goto L6;
        return r0;
    L6:
        if (CollectionUtils.isEmpty(r7.emojis_order) == false) goto L8;
        return r0;
    L8:
        Iterator r8 = r7.emojis_order.iterator();
    L10:
        if (r8.hasNext() == false) goto L47;
        EmojiPanel.Emojis r1 = (EmojiPanel.Emojis) r8.next();
        DefaultEmojiPanelData.a r2 = new DefaultEmojiPanelData.a();
        DefaultEmojiPanelData.Type.a r3 = DefaultEmojiPanelData.Type.Companion;
        int r4 = r1.type.getValue();
        r3.getClass();
        if (r4 != 1) goto L14;
        DefaultEmojiPanelData.Type r5 = DefaultEmojiPanelData.Type.DEFAULT;
    L18:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r2.a = r5;
        String r6 = r1.title;
        if (r6 != null) goto L21;
    L23:
        String r9 = r1.source;
        if (r9 != null) goto L26;
    L28:
        String r10 = r1.icon_key;
        if (r10 != null) goto L31;
    L33:
        ArrayList r11 = new ArrayList();
        if (CollectionUtils.isNotEmpty(r1.keys) == false) goto L46;
        Iterator r12 = r1.keys.iterator();
    L37:
        if (r12.hasNext() == false) goto L46;
        EmojiPanel.Emojis.EmojiKey r13 = (EmojiPanel.Emojis.EmojiKey) r12.next();
        String r14 = r13.selected_skin_key;
        if (r14 != null) goto L41;
    L44:
        String r15 = r13.key;
    L45:
        r11.add(new Pair(r13.key, r15));
        goto L37
    L41:
        if (r14.length() <= 0) goto L44;
        r15 = r13.selected_skin_key;
    L46:
        r2.c(r11);
        Intrinsics.checkNotNullParameter(r2, "group");
        ((ArrayList) r0.a).add(r2);
        goto L10
    L31:
        if (r10.length() <= 0) goto L33;
        String r16 = r1.icon_key;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r2.b = r16;
        goto L33
    L26:
        if (r9.length() <= 0) goto L28;
        Intrinsics.checkNotNullParameter(r1.source, "<set-?>");
        goto L28
    L21:
        if (r6.length() <= 0) goto L23;
        String r17 = r1.title;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r2.c = r17;
        goto L23
    L14:
        if (r4 == 2) goto L16;
        r5 = DefaultEmojiPanelData.Type.UNKNOWN;
        goto L18
    L16:
        r5 = DefaultEmojiPanelData.Type.CUSTOM;
        goto L18
    L47:
        return r0;
    }
}
