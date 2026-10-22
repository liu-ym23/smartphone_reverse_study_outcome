package com.ss.android.lark.chat.message.menu.v2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FetchMessageActionListConfig {
    public static List<ActionGroup> a;
    public static List<String> b;
    public static final Lazy c = null;
    public static final Lazy d = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageActionType.values().length];
            r0[MessageActionType.REPLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MessageActionType.REPLY_IN_THREAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        c = LazyKt.lazy(FetchMessageActionListConfig$allMessageActionGroups$2.INSTANCE);
        d = LazyKt.lazy(FetchMessageActionListConfig$partialMessageActionGroups$2.INSTANCE);
    }

    public static List a(List r8) {
        Intrinsics.checkNotNullParameter(r8, "setting");
        LinkedHashMap r0 = new LinkedHashMap();
        MessageActionType[] r1 = MessageActionType.values();
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        MessageActionType r5 = r1[r4];
        String r6 = r5.getKey();
        Object r7 = r0.get(r6);
        if (r7 != null) goto L7;
        r7 = new ArrayList();
        r0.put(r6, r7);
    L7:
        ((List) r7).add(r5);
        r4 = r4 + 1;
        goto L3
    L8:
        ArrayList r3 = new ArrayList();
        Iterator r9 = r8.iterator();
    L9:
        boolean r10 = true;
        if (r9.hasNext() == false) goto L21;
        String r11 = (String) r9.next();
        List r12 = (List) r0.get(r11);
        if (r12 != null) goto L14;
    L17:
        if (r10 == true) goto L18;
        r3.addAll(r12);
        goto L9
    L18:
        Log.w("FetchMessageActionListConfig", "parse partial actions failed, not found key in local, setting key = " + r11);
        goto L9
    L14:
        if (r12.isEmpty() == true) goto L17;
        r10 = false;
        goto L17
    L21:
        return CollectionsKt.mutableListOf(new yya.k[]{new yya.k(r3, 2, 8)});
    }

    public static List b(com.ss.android.lark.chat.chatwindow.chat.v2.push.v r9, Chat r10) {
        Intrinsics.checkNotNullParameter(r9, "chatContainer");
        List r0 = (List) c.getValue();
        if (ReplyInThreadUtil.e(r9.C(), r10) != ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE) goto L31;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r0.iterator();
    L7:
        if (r12.hasNext() == false) goto L30;
        yya.k r1 = (yya.k) r12.next();
        Iterator r4 = r1.b.iterator();
        boolean r5 = false;
    L10:
        if (r4.hasNext() == false) goto L16;
        MessageActionType r6 = (MessageActionType) r4.next();
        if (r6 == MessageActionType.REPLY) goto L15;
        if (r6 != MessageActionType.REPLY_IN_THREAD) goto L10;
    L15:
        r5 = true;
        goto L10
    L16:
        if (r5 == true) goto L17;
        r11.add(r1);
        goto L7
    L17:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r1.b.iterator();
    L19:
        if (r8.hasNext() == false) goto L28;
        MessageActionType r13 = (MessageActionType) r8.next();
        int r14 = a.a[r13.ordinal()];
        if (r14 != 1) goto L23;
        r13 = MessageActionType.REPLY_IN_THREAD;
    L27:
        r7.add(r13);
        goto L19
    L23:
        if (r14 != 2) goto L27;
        r13 = MessageActionType.REPLY;
        goto L27
    L28:
        r11.add(new yya.k(r7, r1.c, 8));
        goto L7
    L30:
        r0 = r11;
    L31:
        MessageActionType[] r15 = MessageActionType.values();
        ArrayList r16 = new ArrayList();
        int r17 = r15.length;
        int r18 = 0;
    L32:
        if (r18 >= r17) goto L38;
        MessageActionType r19 = r15[r18];
        if (r19.getIgnoreSetting() == false) goto L36;
        r16.add(r19);
    L36:
        r18 = r18 + 1;
        goto L32
    L38:
        if (r16.isEmpty() == true) goto L61;
        yya.k r20 = new yya.k(r16, 0, 8);
        List r2 = CollectionsKt.toMutableList(r0);
        ListProtector.add(r2, 1, r20);
        return r2;
    L61:
        return r0;
    }
}
