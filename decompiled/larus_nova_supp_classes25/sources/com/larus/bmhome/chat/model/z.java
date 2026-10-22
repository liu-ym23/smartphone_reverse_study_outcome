package com.larus.bmhome.chat.model;

import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.service.z2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z {
    public static final boolean a(ChatDraftItem r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        String r1 = r3.getType();
        if (r1 != null) goto L8;
        return false;
    L8:
        switch(r1.hashCode()) {
            case -1763094588: goto L45;
            case -542119335: goto L41;
            case 3556653: goto L37;
            case 108401386: goto L33;
            case 502283980: goto L29;
            case 537203690: goto L25;
            case 1344059491: goto L21;
            case 1356666703: goto L18;
            case 1639449465: goto L14;
            case 2014995991: goto L11;
            default: goto L114;
        };
    L114:
        return false;
    L11:
        if (r1.equals(ChatDraftItem.TYPE_ACTION_BAR_SELECTION) == true) goto L106;
        return false;
    L106:
        return com.larus.utils.o0.d(r3.getContent());
    L14:
        if (r1.equals(ChatDraftItem.TYPE_SUGGESTED_ACTION_OPERATIONS) == true) goto L104;
        return false;
    L104:
        return com.larus.utils.o0.d(r3.getContent());
    L18:
        if (r1.equals(ChatDraftItem.TYPE_OBRIC_MENTION_SKILL_IDS) == true) goto L107;
        return false;
    L107:
        return com.larus.utils.o0.d(r3.getContent());
    L21:
        if (r1.equals(ChatDraftItem.TYPE_MSG_EXT) == true) goto L105;
        return false;
    L105:
        return com.larus.utils.o0.d(r3.getContent());
    L25:
        if (r1.equals(ChatDraftItem.TYPE_TASK_MODE_SELECTION) == true) goto L106;
        return false;
    L29:
        if (r1.equals(ChatDraftItem.TYPE_OBRIC_SELECTED_SKILL_IDS) == true) goto L107;
        return false;
    L33:
        if (r1.equals(ChatDraftItem.TYPE_REPLY) == true) goto L108;
        return false;
    L108:
        return com.larus.utils.o0.d(r3.getContent());
    L37:
        if (r1.equals(ChatDraftItem.TYPE_TEXT) == true) goto L109;
        return false;
    L109:
        return com.larus.utils.o0.d(r3.getContent());
    L41:
        if (r1.equals(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) == true) goto L110;
        return false;
    L110:
        return com.larus.utils.o0.d(r3.getContent());
    L45:
        if (r1.equals(ChatDraftItem.TYPE_NESTED_FILE) == false) goto L124;
        NestedFileContent r2 = r3.getNestedFileContent();
        if (r2 == null) goto L50;
        List r4 = r2.getEntities();
    L52:
        if (com.larus.utils.o0.d(r3.getKey()) == false) goto L111;
        List r5 = r4;
        if (r5 != null) goto L56;
    L59:
        boolean r6 = true;
    L60:
        if (r6 == true) goto L112;
        z2 r7 = z2.a;
        if (z2.c4() == false) goto L78;
        if (r4 == null) goto L93;
        List r8 = r4;
        if ((r8 instanceof Collection) == true) goto L67;
    L69:
        Iterator r9 = r8.iterator();
    L71:
        if (r9.hasNext() == false) goto L75;
        if (com.larus.utils.o0.d(((UplinkFileEntity) r9.next()).getFileIdentifier()) == true) goto L71;
        boolean r10 = false;
    L76:
        if (r10 != true) goto L93;
    L92:
        boolean r11 = true;
    L94:
        if (r11 == false) goto L113;
        return true;
    L113:
        return false;
    L75:
        r10 = true;
        goto L76
    L67:
        if (r8.isEmpty() == false) goto L69;
    L93:
        r11 = false;
        goto L94
    L78:
        if (r4 == null) goto L93;
        List r12 = r4;
        if ((r12 instanceof Collection) == true) goto L82;
    L84:
        Iterator r13 = r12.iterator();
    L86:
        if (r13.hasNext() == false) goto L90;
        if (yc9.l1.m((UplinkFileEntity) r13.next()) == true) goto L86;
        boolean r14 = false;
    L91:
        if (r14 != true) goto L93;
    L90:
        r14 = true;
        goto L91
    L82:
        if (r12.isEmpty() == false) goto L84;
    L112:
        return false;
    L56:
        if (r5.isEmpty() == true) goto L59;
        r6 = false;
        goto L60
    L111:
        return false;
    L50:
        r4 = null;
        goto L52
    L124:
        return false;
    }
}
