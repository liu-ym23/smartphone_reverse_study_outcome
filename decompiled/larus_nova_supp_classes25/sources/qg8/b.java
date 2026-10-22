package qg8;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.chat.p;
import ic8.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final Lazy a = null;
    public static final HashMap<String, DeepThinkFoldStatus> b = null;
    public static boolean c;

    public b() {
    }

    static {
        a = LazyKt.lazy(new a());
        b = new HashMap();
    }

    public static Message b(MessageAdapter r5) {
        Object r0 = null;
        if (r5 == null) goto L30;
        List<xc8.b> r6 = r5.z2();
        if (r6 == null) goto L31;
        List<xc8.b> r7 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        r1.add(((wq8.a) r8.next()).getMessage());
        goto L8
    L10:
        Iterator r9 = r1.iterator();
    L12:
        if (r9.hasNext() == false) goto L22;
        Object r2 = r9.next();
        Message r3 = (Message) r2;
        boolean r4 = true;
        if (r3.getContentType() == 1) goto L19;
        if (r3.getContentType() == 9999) goto L19;
        r4 = false;
    L19:
        if (r4 == false) goto L12;
        r0 = r2;
    L22:
        return (Message) r0;
    L31:
        return null;
    L30:
        return null;
    }

    public static boolean h(Message r4) {
        Boolean r0 = com.larus.im.bean.message.a.T(r4);
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (com.larus.im.bean.message.a.f0(r4) == false) goto L17;
        if (r2 == false) goto L17;
        if (d.f0(r4) == true) goto L17;
        if (com.larus.im.bean.message.a.m0(r4) == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (Intrinsics.areEqual(com.larus.im.bean.message.a.q(r4), r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    public static boolean e(Message r7, q0 r8) {
        if (com.larus.im.bean.message.a.f0(r7) == false) goto L36;
        List<wq8.a> r9 = r8.D7();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        r0.add(((wq8.a) r10.next()).getMessage());
        goto L6
    L8:
        Iterator r11 = r0.iterator();
    L9:
        String r3 = null;
        if (r11.hasNext() == false) goto L22;
        Object r1 = r11.next();
        Message r4 = (Message) r1;
        if (r4.getContentType() != 1) goto L14;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L9;
    L23:
        Message r2 = (Message) r1;
        if (r2 == null) goto L27;
        r3 = r2.getMessageId();
    L27:
        if (Intrinsics.areEqual(r3, r7.getMessageId()) == false) goto L37;
        return true;
    L37:
        return false;
    L14:
        if (r4.getContentType() == 2022) goto L19;
        if (r4.getContentType() == 9999) goto L19;
        r5 = false;
        goto L20
    L22:
        r1 = null;
        goto L23
    L36:
        return false;
    }

    public static void g(String r1, DeepThinkFoldStatus r2) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r2, "deepThinkFoldStatus");
        b.put(r1, r2);
    }

    public static DeepThinkFoldStatus a(boolean r0, boolean r1, DeepThinkFoldStatus r2) {
        if (r2 == null) goto L4;
        return r2;
    L4:
        if (r0 == true) goto L9;
        if (r1 == false) goto L8;
        return DeepThinkFoldStatus.CompleteExpand;
    L8:
        return DeepThinkFoldStatus.CompleteFold;
    L9:
        if (r1 == false) goto L12;
        return DeepThinkFoldStatus.HalfFold;
    L12:
        if (((p) a.getValue()).a() == false) goto L15;
        return DeepThinkFoldStatus.HalfFold;
    L15:
        return DeepThinkFoldStatus.CompleteFold;
    }

    public static DeepThinkFoldStatus d(Message r7, q0 r8, IChatMessageShareAbility r9, u7 r10, boolean r11) {
        boolean r0 = false;
        if (r7 == null) goto L5;
        boolean r1 = com.larus.im.bean.message.a.f0(r7);
    L7:
        if (r7 != null) goto L10;
        return a(r1, false, null);
    L10:
        if ((r10 instanceof va8.p) == false) goto L12;
        va8.p r3 = (va8.p) r10;
    L14:
        if (r3 != null) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == true) goto L96;
        if (r11 == true) goto L97;
        String r12 = r7.getMessageId();
        if (r12 != null) goto L26;
    L28:
        boolean r13 = false;
    L29:
        if (r13 == false) goto L31;
        Message r14 = r7;
    L32:
        if (r14 == null) goto L35;
        return DeepThinkFoldStatus.CompleteExpand;
    L35:
        if (com.larus.im.bean.message.a.m0(r7) == true) goto L37;
        Message r15 = r7;
    L38:
        if (r15 != null) goto L99;
        if (r9 != null) goto L42;
    L52:
        String r16 = r7.getMessageId();
        String r17 = "";
        if (r16 != null) goto L55;
        r16 = "";
    L55:
        HashMap<String, DeepThinkFoldStatus> r5 = b;
        if (r5.containsKey(r16) == true) goto L58;
        DeepThinkFoldStatus r18 = null;
    L59:
        if (r18 == null) goto L62;
        return r18;
    L62:
        if (h(r7) == false) goto L64;
        Message r19 = r7;
    L65:
        if (r19 == null) goto L72;
        DeepThinkFoldStatus r20 = a(com.larus.im.bean.message.a.f0(r7), false, null);
        String r21 = r7.getMessageId();
        if (r21 == null) goto L70;
        r17 = r21;
    L70:
        g(r17, r20);
    L102:
        return r20;
    L72:
        if (r8 == null) goto L74;
        boolean r22 = e(r7, r8);
    L76:
        if (com.larus.im.bean.message.a.f0(r7) == false) goto L84;
        if (r10 != null) goto L79;
    L81:
        boolean r23 = false;
    L82:
        if (r23 == false) goto L84;
        boolean r24 = true;
    L86:
        if (com.larus.im.bean.message.a.i(r7) == true) goto L90;
        if (r22 == true) goto L89;
        if (r24 == false) goto L90;
    L89:
        r0 = true;
    L90:
        r20 = a(r1, r0, null);
        String r25 = r7.getMessageId();
        if (r25 == null) goto L94;
        r17 = r25;
    L94:
        g(r17, r20);
        goto L102
    L79:
        if (r7.getLocalIndex() != r10.Mg()) goto L81;
        r23 = true;
    L84:
        r24 = false;
        goto L86
    L74:
        r22 = false;
        goto L76
    L64:
        r19 = null;
        goto L65
    L58:
        r18 = r5.get(r16);
        goto L59
    L42:
        if (r9.H1() == true) goto L44;
    L46:
        boolean r110 = false;
    L47:
        if (r110 == true) goto L50;
        r9 = null;
    L50:
        if (r9 == null) goto L52;
        return a(r1, false, null);
    L44:
        if (com.larus.im.bean.message.a.f0(r7) == false) goto L46;
        r110 = true;
        goto L47
    L99:
        return DeepThinkFoldStatus.CompleteExpand;
    L37:
        r15 = null;
        goto L38
    L31:
        r14 = null;
        goto L32
    L26:
        if (StringsKt.startsWith$default(r12, "long_screenshot_", false, 2, null) != true) goto L28;
        r13 = true;
        goto L29
    L97:
        return DeepThinkFoldStatus.CompleteExpand;
    L96:
        return DeepThinkFoldStatus.CompleteExpand;
    L16:
        if (r3.Q80(r7.getMessageId()) != true) goto L18;
        r4 = true;
        goto L19
    L12:
        r3 = null;
        goto L14
    L5:
        r1 = false;
        goto L7
    }

    public static void f(Map.Entry r5, MessageAdapter r6, Message r7, boolean r8, Message r9, List r10) {
        String r0 = (String) r5.getKey();
        DeepThinkFoldStatus r11 = (DeepThinkFoldStatus) r5.getValue();
        if (q.b(r11) == true) goto L7;
        r11 = null;
    L7:
        if (r11 == null) goto L39;
        boolean r12 = true;
        if (r6 == null) goto L11;
        r6.x7(r0, 1);
    L11:
        if (r9 == null) goto L39;
        if (Intrinsics.areEqual(r9.getMessageId(), r0) == true) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == true) goto L21;
        r9 = null;
    L21:
        if (r9 == null) goto L39;
        if (r6 == null) goto L25;
        int r13 = ((ArrayList) r6.getCurrentList()).indexOf(r9);
    L26:
        Integer r14 = Integer.valueOf(r13);
        if (r14.intValue() != (-1)) goto L30;
        r12 = false;
    L30:
        if (r12 == true) goto L33;
        r14 = null;
    L33:
        if (r14 == null) goto L39;
        int r15 = r14.intValue();
        if (r6 == null) goto L39;
        ChatMessageList r16 = r6.u;
        if (r16 == null) goto L39;
        r16.scrollToPosition(r15);
        goto L39
    L25:
        r13 = -1;
        goto L26
    L15:
        if (com.larus.im.bean.message.a.f0(r9) == false) goto L17;
        r3 = true;
    L39:
        if (r7 == null) goto L41;
        String r17 = r7.getMessageId();
    L43:
        if (Intrinsics.areEqual(r0, r17) == false) goto L46;
        if (r8 == true) goto L46;
        g(r0, a(com.larus.im.bean.message.a.f0(r7), false, null));
        return;
    L46:
        ((ArrayList) r10).add(r0);
        return;
    L41:
        r17 = null;
        goto L43
    }

    public static DeepThinkFoldStatus c(Message r7, q0 r8, boolean r9, Long r10, boolean r11, DeepThinkFoldStatus r12, boolean r13) {
        boolean r0 = com.larus.im.bean.message.a.f0(r7);
        Message r1 = null;
        if (r8 == null) goto L7;
        q0.a r2 = r8.getProvider();
        if (r2 == null) goto L7;
        u7 r3 = r2.u3();
    L9:
        if ((r3 instanceof va8.p) == false) goto L11;
        va8.p r4 = (va8.p) r3;
    L12:
        boolean r5 = true;
        if (r4 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == true) goto L20;
        String r14 = r7.getMessageId();
        if (r14 != null) goto L24;
    L26:
        boolean r15 = false;
    L27:
        if (r15 == false) goto L29;
        Message r16 = r7;
    L30:
        if (r16 != null) goto L32;
        if (r13 == false) goto L37;
        return DeepThinkFoldStatus.CompleteExpand;
    L37:
        if (com.larus.im.bean.message.a.m0(r7) == true) goto L39;
        Message r17 = r7;
    L40:
        if (r17 == null) goto L44;
        if (r12 == null) goto L43;
        return r12;
    L43:
        return DeepThinkFoldStatus.CompleteExpand;
    L44:
        if (r9 == true) goto L46;
    L49:
        String r18 = "";
        if (r11 == true) goto L61;
        String r19 = r7.getMessageId();
        if (r19 != null) goto L54;
        r19 = "";
    L54:
        HashMap<String, DeepThinkFoldStatus> r110 = b;
        if (r110.containsKey(r19) == true) goto L57;
        DeepThinkFoldStatus r111 = null;
    L58:
        if (r111 == null) goto L61;
        return r111;
    L57:
        r111 = r110.get(r19);
    L61:
        if (h(r7) == false) goto L63;
        r1 = r7;
    L63:
        if (r1 == null) goto L70;
        DeepThinkFoldStatus r20 = a(com.larus.im.bean.message.a.f0(r7), false, r12);
        String r21 = r7.getMessageId();
        if (r21 == null) goto L68;
        r18 = r21;
    L68:
        g(r18, r20);
        return r20;
    L70:
        if (r8 == null) goto L72;
        boolean r22 = e(r7, r8);
    L74:
        if (com.larus.im.bean.message.a.f0(r7) == false) goto L81;
        long r23 = r7.getLocalIndex();
        if (r10 == null) goto L81;
        if (r23 != r10.longValue()) goto L81;
        boolean r112 = true;
    L83:
        if (com.larus.im.bean.message.a.i(r7) == true) goto L87;
        if (r22 == true) goto L88;
        if (r112 == false) goto L87;
    L88:
        DeepThinkFoldStatus r24 = a(r0, r5, r12);
        String r25 = r7.getMessageId();
        if (r25 == null) goto L92;
        r18 = r25;
    L92:
        g(r18, r24);
        return r24;
    L87:
        r5 = false;
    L81:
        r112 = false;
        goto L83
    L72:
        r22 = false;
        goto L74
    L46:
        if (com.larus.im.bean.message.a.f0(r7) == false) goto L49;
        return a(r0, false, null);
    L39:
        r17 = null;
        goto L40
    L32:
        return DeepThinkFoldStatus.CompleteExpand;
    L29:
        r16 = null;
        goto L30
    L24:
        if (StringsKt.startsWith$default(r14, "long_screenshot_", false, 2, null) != true) goto L26;
        r15 = true;
        goto L27
    L20:
        return DeepThinkFoldStatus.CompleteExpand;
    L15:
        if (r4.Q80(r7.getMessageId()) != true) goto L17;
        r6 = true;
        goto L18
    L11:
        r4 = null;
    L7:
        r3 = null;
        goto L9
    }
}
