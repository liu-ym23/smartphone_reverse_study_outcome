package r3;

import com.bytedance.ai.bridge.doubao.chat.AbsSetChatActionBarMethodIDL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final r2.c a(List<AbsSetChatActionBarMethodIDL.ChatActionBarItem> r25) {
        Intrinsics.checkNotNullParameter(r25, "<this>");
        a r1 = new a();
        Intrinsics.checkNotNullParameter(r25, "items");
        List<AbsSetChatActionBarMethodIDL.ChatActionBarItem> r0 = r25;
        int r10 = 10;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r12 = r0.iterator();
    L4:
        if (r12.hasNext() == false) goto L75;
        AbsSetChatActionBarMethodIDL.ChatActionBarItem r13 = (AbsSetChatActionBarMethodIDL.ChatActionBarItem) r12.next();
        r1.c(r13.getId());
        int r14 = a.c.a[r13.getKind().ordinal()];
        int r15 = 0;
        boolean r16 = true;
        if (r14 != 1) goto L8;
        Iterator r18 = r12;
        String r17 = "action item " + r13.getId();
        String r19 = a.d(r13.getTitle(), r17 + " title is empty");
        List<AbsSetChatActionBarMethodIDL.ChatActionBarGroupItem> r20 = r13.getItems();
        if (r20 != null) goto L59;
    L62:
        boolean r21 = true;
    L63:
        if (r21 == false) goto L73;
        if (r13.getRowCount() != null) goto L67;
        r15 = 1;
    L67:
        if (r15 == 0) goto L71;
        a.b r22 = a.b(r13.getIcon(), r17);
        e r23 = new e(r13.getId(), r19, r22.a, r22.b, new r2.b.C0188b(a.a(r13.getAction(), r17)));
    L69:
        r11.add(r23);
        r12 = r18;
        r10 = 10;
        goto L4
    L71:
        throw new IllegalArgumentException((r17 + " rowCount is only supported by an action_group item").toString());
    L73:
        throw new IllegalArgumentException((r17 + " items must be empty").toString());
    L59:
        if (r20.isEmpty() == true) goto L62;
        r21 = false;
        goto L63
    L8:
        if (r14 != 2) goto L55;
        String r24 = "action group item " + r13.getId();
        String r110 = a.d(r13.getTitle(), r24 + " title is empty");
        if (r13.getAction() != null) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == false) goto L53;
        List<AbsSetChatActionBarMethodIDL.ChatActionBarGroupItem> r112 = r13.getItems();
        if (r112 != null) goto L18;
        r112 = CollectionsKt.emptyList();
    L18:
        if ((!r112.isEmpty()) == false) goto L51;
        Integer r113 = r13.getRowCount();
        if (r113 == null) goto L22;
        int r114 = r113.intValue();
    L23:
        if (1 <= r114) goto L25;
    L27:
        r16 = false;
    L28:
        if (r16 == false) goto L49;
        a.b r26 = a.b(r13.getIcon(), r24);
        String r115 = r13.getId();
        String r116 = r26.a;
        String r27 = r26.b;
        List<AbsSetChatActionBarMethodIDL.ChatActionBarGroupItem> r117 = r112;
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, r10));
        Iterator r118 = r117.iterator();
    L31:
        if (r118.hasNext() == false) goto L47;
        Object r119 = r118.next();
        int r120 = r15 + 1;
        if (r15 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        AbsSetChatActionBarMethodIDL.ChatActionBarGroupItem r121 = (AbsSetChatActionBarMethodIDL.ChatActionBarGroupItem) r119;
        Intrinsics.checkNotNull(r121);
        String r29 = r13.getId();
        Iterator r122 = r12;
        StringBuilder r30 = new StringBuilder("action group item ");
        r30.append(r29);
        Iterator r123 = r118;
        r30.append(" items[");
        r30.append(r15);
        r30.append(']');
        String r31 = r30.toString();
        String r32 = a.d(r121.getId(), r31 + " id is empty");
        r1.c(r32);
        String r33 = "action group item " + r29 + '/' + r32;
        String r210 = a.d(r121.getTitle(), r33 + " title is empty");
        AbsSetChatActionBarMethodIDL.ChatActionBarIcon r34 = r121.getIcon();
        if (r34 == null) goto L38;
        a.b r35 = a.b(r34, r33);
    L39:
        r2.a r211 = a.a(r121.getAction(), r33);
        if (r35 == null) goto L42;
        String r212 = r35.a;
    L43:
        if (r35 == null) goto L45;
        String r213 = r35.b;
    L46:
        r28.add(new r2.d(r32, r210, r212, r213, r211));
        r15 = r120;
        r118 = r123;
        r12 = r122;
        goto L31
    L45:
        r213 = null;
        goto L46
    L42:
        r212 = null;
        goto L43
    L38:
        r35 = null;
        goto L39
    L47:
        r18 = r12;
        r23 = new e(r115, r110, r116, r27, new r2.b.a(r28, r114));
        goto L69
    L49:
        throw new IllegalArgumentException((r24 + " rowCount must be between 1 and " + r112.size()).toString());
    L25:
        if (r114 > r112.size()) goto L27;
    L22:
        r114 = 1;
        goto L23
    L51:
        throw new IllegalArgumentException((r24 + " items is empty").toString());
    L53:
        throw new IllegalArgumentException((r24 + " action must be empty").toString());
    L12:
        r111 = false;
        goto L13
    L55:
        throw new NoWhenBranchMatchedException();
    L75:
        return new r2.c(r11);
    }
}
