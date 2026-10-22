package com.bytedance.android.bcm.impl.monitor;

import com.bytedance.android.bcm.impl.paramcheck.checker.BcmCheckErrorType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(com.bytedance.android.bcm.impl.paramcheck.checker.b r10, String r11, String r12) {
        StringBuilder r0 = new StringBuilder();
        if (r12 == null) goto L5;
        r11 = r12;
    L5:
        r0.append(r11);
        r0.append('\n');
        BcmCheckErrorType[] r13 = BcmCheckErrorType.values();
        int r14 = r13.length;
        int r1 = 0;
    L6:
        if (r1 >= r14) goto L34;
        BcmCheckErrorType r15 = r13[r1];
        List<com.bytedance.android.bcm.impl.paramcheck.checker.a> r16 = r10.a;
        ArrayList r17 = new ArrayList();
        Iterator r18 = ((ArrayList) r16).iterator();
    L9:
        if (r18.hasNext() == false) goto L13;
        Object r19 = r18.next();
        if ((r19 instanceof com.bytedance.android.bcm.impl.paramcheck.checker.a.b) == false) goto L9;
        r17.add(r19);
        goto L9
    L13:
        ArrayList r20 = new ArrayList();
        Iterator r21 = r17.iterator();
    L14:
        boolean r22 = true;
        if (r21.hasNext() == false) goto L23;
        Object r23 = r21.next();
        if (((com.bytedance.android.bcm.impl.paramcheck.checker.a.b) r23).b == r15) goto L20;
        r22 = false;
    L20:
        if (r22 == false) goto L14;
        r20.add(r23);
        goto L14
    L23:
        if ((!r20.isEmpty()) == false) goto L33;
        StringBuilder r24 = new StringBuilder("【参数");
        r24.append(r15.getErrorTip());
        r24.append("】\n");
        Iterator r25 = r20.iterator();
    L26:
        if (r25.hasNext() == false) goto L33;
        com.bytedance.android.bcm.impl.paramcheck.checker.a.b r26 = (com.bytedance.android.bcm.impl.paramcheck.checker.a.b) r25.next();
        StringBuilder r27 = new StringBuilder(" - ");
        r27.append(r26.a);
        r27.append(": ");
        if (r26.c.containsKey("expect_value") == false) goto L31;
        StringBuilder r28 = new StringBuilder("[预期：");
        r28.append(r26.c.get("expect_value"));
        r28.append(']');
    L31:
        if (r26.c.containsKey("actual_value") == false) goto L26;
        StringBuilder r29 = new StringBuilder("[实际：");
        r29.append(r26.c.get("actual_value"));
        r29.append(']');
    L33:
        r1 = r1 + 1;
        goto L6
    L34:
        com.bytedance.android.bcm.impl.paramcheck.checker.a.C0106a r30 = r10.b();
        if (r30 == null) goto L55;
        new StringBuilder("规则校验不通过,规则表达式: ").append(r30.a);
        return;
    }
}
