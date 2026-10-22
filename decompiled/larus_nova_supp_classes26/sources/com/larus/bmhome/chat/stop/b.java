package com.larus.bmhome.chat.stop;

import com.larus.bmhome.chat.adapter.h0;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.Message;
import ic8.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final List<Message> c(a r8) {
        List r0 = CollectionsKt.listOfNotNull(new String[]{r8.a.getMessageId(), r8.a.getLocalMessageId()});
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r4 = r2.next();
        if ((!StringsKt.isBlank((String) r4)) == false) goto L4;
        r1.add(r4);
        goto L4
    L8:
        Set r3 = CollectionsKt.toSet(r1);
        List r5 = CollectionsKt.createListBuilder();
        r5.add(r8.a);
        List r6 = r8.a.getSubList();
        if (r6 != null) goto L11;
        r6 = CollectionsKt.emptyList();
    L11:
        r5.addAll(CollectionsKt.filterNotNull(r6));
        List r7 = r8.a.getSubListGroup();
        if (r7 != null) goto L14;
        r7 = CollectionsKt.emptyList();
    L14:
        r5.addAll(CollectionsKt.filterNotNull(CollectionsKt.flatten(r7)));
        List<Message> r9 = r8.c;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L16:
        if (r11.hasNext() == false) goto L32;
        Object r12 = r11.next();
        Message r13 = (Message) r12;
        if (com.larus.im.bean.message.a.y0(r13) == false) goto L20;
    L21:
        String r14 = com.larus.im.bean.message.a.D(r13);
        if (r14 != null) goto L24;
    L26:
        boolean r15 = false;
    L27:
        if (r15 == false) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L16;
        r10.add(r12);
    L29:
        r16 = false;
        goto L30
    L24:
        if (r3.contains(r14) != true) goto L26;
        r15 = true;
        goto L27
    L20:
        if (com.larus.im.bean.message.a.x0(r13) == false) goto L29;
    L32:
        r5.addAll(r10);
        return CollectionsKt.build(r5);
    }

    public static final boolean a(a r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "target");
        List<Message> r0 = c(r4);
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (b((Message) r1.next(), r5) == false) goto L9;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L16;
    L17:
        return true;
    L16:
        if (b(r4.b, r5) == true) goto L17;
        return false;
    L13:
        r2 = false;
        goto L14
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public static final boolean b(Message r6, String r7) {
        int r0 = d.a;
        Intrinsics.checkNotNullParameter(r6, "message");
        if (d.d(r6) == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (ArraysKt.contains(new String[]{"image", "music", CreativeScene.AVATAR_IMAGE, CreativeScene.AI_BEAUTIFY_IMAGE, CreativeScene.IMAGE_TO_IMAGE}, ap8.a.b(r6)) == false) goto L18;
        return true;
    L18:
        if (Intrinsics.areEqual(ap8.a.b(r6), "video") == false) goto L20;
        return true;
    L20:
        Map r8 = r6.getExt();
        String r2 = null;
        if (r8 == null) goto L23;
        String r9 = (String) r8.get("use_creation");
    L25:
        if (Intrinsics.areEqual(r9, "1") == false) goto L27;
        return true;
    L27:
        Set<Integer> r10 = aq8.b.a;
        Integer r11 = j.b(r6);
        if (r11 != null) goto L30;
    L32:
        boolean r12 = false;
    L33:
        if (r12 == true) goto L48;
        Map r13 = r6.getExt();
        if (r13 == null) goto L39;
        String r14 = (String) r13.get("action_bar_instruction_type");
        if (r14 == null) goto L39;
        Integer r15 = StringsKt.toIntOrNull(r14);
    L40:
        if (r15 != null) goto L42;
    L44:
        boolean r16 = false;
    L45:
        if (r16 == true) goto L48;
        boolean r17 = false;
    L49:
        if (r17 == false) goto L52;
        return true;
    L52:
        if (Intrinsics.areEqual(r6.getBizContentType(), "dora_record") == false) goto L55;
        return true;
    L55:
        if (Intrinsics.areEqual(r6.getBizContentType(), "deep_search_card") == false) goto L58;
        return true;
    L58:
        if (h0.e(r6) == false) goto L60;
        return true;
    L60:
        Map r18 = r6.getExt();
        if (r18 == null) goto L63;
        String r19 = (String) r18.get("o_not_interrupt");
    L65:
        if (Intrinsics.areEqual(r19, "1") == false) goto L67;
        return true;
    L67:
        Map r20 = r6.getExt();
        if (r20 == null) goto L71;
        r2 = (String) r20.get("should_interrupt");
    L71:
        if (Intrinsics.areEqual(r2, TriggerSendLoading.NO_LOADING) == false) goto L73;
        return true;
    L73:
        return false;
    L63:
        r19 = null;
        goto L65
    L42:
        if (aq8.b.a.contains(r15) == false) goto L44;
        r16 = true;
    L39:
        r15 = null;
    L48:
        r17 = true;
        goto L49
    L30:
        if (aq8.b.a.contains(r11) == false) goto L32;
        r12 = true;
        goto L33
    L23:
        r9 = null;
        goto L25
    L13:
        return !Intrinsics.areEqual(r7, "agent_work");
    L5:
        if (d.c(r6) == true) goto L10;
        if (d.a(r6) == true) goto L10;
        r1 = false;
        goto L11
    }
}
