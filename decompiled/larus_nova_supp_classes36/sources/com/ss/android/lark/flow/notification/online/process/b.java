package com.ss.android.lark.flow.notification.online.process;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final btb.c a;
    public final btb.e b;

    public b() {
        btb.c r0 = new btb.c();
        this.a = r0;
        this.b = new btb.e(r0);
    }

    public static void a(b r9, Notice r10) {
        r9.getClass();
        if (r10 != null) goto L5;
        thb.a.a("FlowNotificationDispatcher", "notice is empty!");
        return;
    L5:
        ArrayList r1 = new ArrayList();
        int r2 = r10.type;
        if (r2 != 20001) goto L8;
        r1.add(20001);
    L49:
        Iterator r3 = r1.iterator();
    L51:
        if (r3.hasNext() == false) goto L93;
        Integer r4 = (Integer) r3.next();
        btb.e r5 = r9.b;
        int r6 = r4.intValue();
        if (((ConcurrentHashMap) r5.a).containsKey(Integer.valueOf(r6)) == true) goto L55;
        Log.e("NotificationFactory", "no push type found! for type " + r6);
        AbstractNotification r7 = null;
    L56:
        if (r7 == null) goto L57;
        btb.c r8 = r9.a;
        AbstractNotification.b r11 = r7.a();
        AbstractNotification.AbstractNotificationDisplayer r12 = r7.c();
        AbstractNotification.a r13 = r7.b();
        if (r11 != null) goto L61;
        Notice r14 = r10;
    L62:
        boolean r15 = false;
        if (r14 == null) goto L84;
        if (r11 != null) goto L67;
        int r16 = 0;
    L68:
        if (r16 == 0) goto L70;
        if (r16 != 1) goto L84;
        if (r13 == null) goto L84;
        r13.a(r14);
        goto L84
    L70:
        if (r12.c(r14) == false) goto L84;
        atb.a r17 = r12.b(r14);
        if (r17 == null) goto L84;
        AbstractNotification.AbstractNotificationDisplayer.a r18 = (AbstractNotification.AbstractNotificationDisplayer.a) ((ConcurrentHashMap) r8.a).get(r17.getClass());
        if (r18 != null) goto L77;
        Log.e("no notification display is suit!");
    L77:
        if (r18 == null) goto L79;
        r18.a(r17);
    L79:
        r15 = true;
        goto L84
    L67:
        r16 = r11.b(r14);
    L84:
        if (r15 == false) goto L51;
        return;
    L61:
        r14 = r11.a(r10);
        goto L62
    L57:
        thb.a.a("FlowNotificationDispatcher", "notification for " + r4 + " is not registered!");
        goto L51
    L55:
        r7 = (AbstractNotification) ((ConcurrentHashMap) r5.a).get(Integer.valueOf(r6));
        goto L56
    L93:
        return;
    L8:
        if (r2 != 20002) goto L10;
        r1.add(20002);
        goto L49
    L10:
        switch(r2) {
            case 1: goto L24;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            default: goto L11;
        };
    L11:
        switch(r2) {
            case 10001: goto L46;
            case 10002: goto L45;
            case 10003: goto L44;
            case 10004: goto L43;
            case 10005: goto L42;
            case 10006: goto L41;
            default: goto L49;
        };
    L41:
        r1.add(Integer.valueOf(AbstractNotification.NoticeType.TODO_REMINDER));
        goto L49
    L42:
        r1.add(10006);
        goto L49
    L43:
        r1.add(10005);
        goto L49
    L44:
        r1.add(10004);
        goto L49
    L45:
        r1.add(10003);
        goto L49
    L46:
        r1.add(10001);
        goto L49
    L13:
        r1.add(14);
        goto L49
    L14:
        r1.add(13);
        goto L49
    L15:
        r1.add(12);
        goto L49
    L16:
        r1.add(10);
        goto L49
    L17:
        r1.add(9);
        goto L49
    L18:
        r1.add(8);
        goto L49
    L19:
        r1.add(7);
        goto L49
    L20:
        r1.add(6);
        goto L49
    L21:
        r1.add(5);
        goto L49
    L22:
        r1.add(4);
        goto L49
    L23:
        r1.add(3);
        goto L49
    L24:
        int r19 = r10.state;
        if (r19 == 3) goto L40;
        if (r19 == 2) goto L40;
        if (r19 != 4) goto L30;
        r1.add(10002);
        goto L49
    L30:
        r1 = new ArrayList();
        Notice.Extra r20 = r10.extra;
        if (r20 == null) goto L49;
        int r21 = r20.i;
        if (r21 == 0) goto L49;
        if (r10.type != 1) goto L39;
        if (r21 != 3) goto L39;
        r1.add(Integer.valueOf(AbstractNotification.NoticeType.DOCFEED));
    L39:
        r1.add(2);
    L40:
        r1.add(2);
        r1.add(4);
        r1.add(5);
        goto L49
    }

    public final <T extends Notice, R extends atb.a> void b(int r4, final AbstractNotification<T, R> r5) {
        btb.e r0 = this.b;
        if (((ConcurrentHashMap) r0.a).containsKey(Integer.valueOf(r4)) == true) goto L19;
        ((ConcurrentHashMap) r0.a).put(Integer.valueOf(r4), r5);
        btb.b r1 = new btb.b(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new btb.d(r5)));
        Class r6 = (Class) ((ParameterizedType) r5.getClass().getGenericSuperclass()).getActualTypeArguments()[1];     // Catch: Exception -> L8
    L10:
        if (r6 == null) goto L18;
        btb.c r7 = r0.b;
        if (((ConcurrentHashMap) r7.a).containsKey(r6) == true) goto L20;
        ((ConcurrentHashMap) r7.a).put(r6, r1);
        return;
    L20:
        return;
    L18:
        return;
    L8:
        e = move-exception;
        Log.e("NotificationFactory", "notification register failed Reason: " + e.getMessage());
        r6 = null;
        goto L10
    }
}
