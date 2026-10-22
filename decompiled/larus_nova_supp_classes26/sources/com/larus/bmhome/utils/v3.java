package com.larus.bmhome.utils;

import com.larus.bmhome.social.page.datasource.event.c;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v3 {
    public static final ConcurrentHashMap<u3, j3> a = null;
    public static final Set<String> b = null;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public v3() {
    }

    static {
        a = new ConcurrentHashMap();
        b = new LinkedHashSet();
    }

    public static Map b() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("message_group_id", UUID.randomUUID().toString());
        return r0;
    }

    public static void e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        j3 r4 = a.remove(new u3(r3, null));
        if (r4 == null) goto L6;
        r4.a();
        return;
    }

    public static c c(c r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "list");
        b r1 = (b) CollectionsKt.firstOrNull(r17.a);
        if (r1 == null) goto L47;
        Message r2 = r1.getMessage();
        if (r2 == null) goto L48;
        String r3 = r2.getConversationId();
        if (r3 == null) goto L49;
        j3 r4 = a.get(new u3(r3, r18));
        Integer r5 = null;
        if (r4 == null) goto L36;
        List<b> r6 = r4.a.filter(r4.b.a);
        b r7 = (b) CollectionsKt.lastOrNull(r6);
        if (r7 == null) goto L16;
        Message r8 = r7.getMessage();
        if (r8 == null) goto L16;
        long r9 = r8.getCreateTime();
    L17:
        b r10 = (b) CollectionsKt.firstOrNull(r6);
        if (r10 == null) goto L24;
        Message r11 = r10.getMessage();
        if (r11 == null) goto L24;
        if (com.larus.bmhome.chat.bean.d.Y(r11) != true) goto L24;
        boolean r12 = true;
    L26:
        if (r4.f.a.size() == r6.size()) goto L28;
        boolean r13 = true;
    L30:
        if (r9 >= r4.g) goto L34;
        if (r12 == true) goto L34;
        if (r13 == true) goto L34;
        r6 = r4.f.a;
    L35:
        c<b> r14 = c.a(r4.b, r6, 0, CollectionsKt.mutableListOf(new com.larus.bmhome.social.page.datasource.event.b.d[]{new com.larus.bmhome.social.page.datasource.event.b.d(true)}), null, 10);
        r4.f = r14;
    L37:
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("getToppingList conversationId=");
        r16.append(r3);
        r16.append(" toppingListSize=");
        if (r14 == null) goto L42;
        List<b> r19 = r14.a;
        if (r19 == null) goto L42;
        r5 = Integer.valueOf(r19.size());
    L42:
        r16.append(r5);
        r16.append(" listSize=");
        r16.append(r17.a.size());
        r15.i("ToppingManager", r16.toString());
        if (r14 != null) goto L46;
        return r17;
    L46:
        return r14;
    L34:
        r4.g = r9;
        goto L35
    L28:
        r13 = false;
    L24:
        r12 = false;
    L16:
        r9 = 0;
        goto L17
    L36:
        r14 = null;
        goto L37
    L49:
        return r17;
    L48:
        return r17;
    L47:
        return r17;
    }

    public static boolean d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        j3 r4 = a.get(new u3(r2, r3));
        if (r4 != null) goto L7;
        return false;
    L7:
        return !Intrinsics.areEqual(r4.f.a, r4.b.a);
    }

    public static void a(wc9.e r6, Boolean r7, String r8) {
        if (r6 != null) goto L4;
        return;
    L4:
        String r0 = r6.a;
        u3 r1 = new u3(r0, r8);
        boolean r9 = false;
        if (r7 == null) goto L7;
        boolean r10 = r7.booleanValue();
    L27:
        if (r10 == true) goto L33;
        j3 r11 = a.remove(r1);
        if (r11 == null) goto L43;
        r11.a();
        return;
    L43:
        return;
    L33:
        if (b.contains(r0) == false) goto L35;
        return;
    L35:
        ConcurrentHashMap<u3, j3> r12 = a;
        if (r7 != null) goto L38;
        int r13 = a.a;
        r9 = !com.larus.platform.service.z2.a.v();
    L41:
        r12.put(r1, new j3(new d2(r9)));
        return;
    L38:
        if (r7.booleanValue() == true) goto L41;
        r9 = true;
        goto L41
    L7:
        int r3 = a.a;
        Intrinsics.checkNotNullParameter(r6, "conversation");
        com.larus.platform.service.z2 r4 = com.larus.platform.service.z2.a;
        if (r4.K() == true) goto L10;
    L26:
        r10 = false;
        goto L27
    L10:
        if (r4.D() != 2) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
    L23:
        boolean r14 = true;
    L24:
        if (r14 == false) goto L26;
        r10 = true;
        goto L27
    L15:
        if (r4.D() != 1) goto L17;
        boolean r15 = true;
    L18:
        if (r15 == true) goto L20;
    L22:
        r14 = false;
        goto L24
    L20:
        if (i.f(r6) == false) goto L22;
    L17:
        r15 = false;
        goto L18
    L12:
        r5 = false;
        goto L13
    }

    public static void f(wc9.e r2, Boolean r3, String r4) {
        if (r2 == null) goto L11;
        String r0 = r2.a;
        if (r0 == null) goto L12;
        u3 r1 = new u3(r0, r4);
        if (a.containsKey(r1) == false) goto L9;
        return;
    L9:
        a(r2, r3, r4);
        return;
    L12:
        return;
    }

    public static void g(c r4, Function1 r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "messages");
        Intrinsics.checkNotNullParameter(r5, "recoverAction");
        b r1 = (b) CollectionsKt.firstOrNull(r4.a);
        if (r1 == null) goto L14;
        Message r2 = r1.getMessage();
        if (r2 == null) goto L15;
        String r3 = r2.getConversationId();
        if (r3 == null) goto L16;
        j3 r7 = a.get(new u3(r3, r6));
        if (r7 != null) goto L12;
        return;
    L12:
        Intrinsics.checkNotNullParameter(r4, "updateEvent");
        Intrinsics.checkNotNullParameter(r5, "recoverAction");
        r7.b = r4;
        r7.c = r5;
        return;
    L16:
        return;
    L15:
        return;
    }
}
