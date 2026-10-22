package com.larus.common.account.douyin;

import com.larus.home.impl.sdk.o0;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import n38.e;
import n38.p;
import ua7.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j extends sa7.h<xa7.k> {
    public final /* synthetic */ DouyinLogin a;
    public final /* synthetic */ p b;

    public final void onSuccess(ua7.b r18) {
        xa7.k r1 = (xa7.k) r18;
        if (r1 != null) goto L5;
        FLogger.a.i(this.a.a, "onSuccess: accessToken is NULL---true");
        this.b.onFail(-1);
        return;
    L5:
        FLogger r2 = FLogger.a;
        String r3 = this.a.a;
        StringBuilder r4 = new StringBuilder("onSuccess: accessToken is NULL---");
        String r5 = ((g) r1).r;
        boolean r6 = false;
        if (r5 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        r4.append(r7);
        r2.i(r3, r4.toString());
        sc7.a r8 = com.bytedance.sdk.account.impl.h.a().l();
        if (r8 == null) goto L21;
        Map r9 = r8.d;
        if (r9 == null) goto L21;
        Map r10 = (Map) ((HashMap) r9).get("aweme_v2");
        if (r10 == null) goto L21;
        cra.a r11 = (cra.a) r10.get("8943");
        if (r11 == null) goto L21;
        long r12 = r11.i;
    L22:
        String r13 = ((g) r1).r;
        String r14 = ((g) r1).w;
        String r15 = ((g) r1).t;
        long r16 = ((g) r1).s;
        String r17 = ((g) r1).u;
        e r20 = new e(r13, r15, r14, r16, r17, r12);
        this.a.k = r20;
        this.b.a(r20);
        Iterator r21 = this.a.j.iterator();
    L24:
        if (r21.hasNext() == false) goto L29;
        Function1 r22 = (Function1) r21.next();
        String r23 = r20.a;
        if (r23 != null) goto L28;
        r23 = "";
    L28:
        r22.invoke(r23);
        goto L24
    L29:
        n.a.post(new l());
        String r24 = r20.a;
        if (r24 != null) goto L32;
    L33:
        r6 = true;
    L34:
        if (r6 == false) goto L36;
        String r25 = "0";
    L37:
        String r26 = r20.c;
        String r27 = r20.b;
        long r28 = ((g) r1).v;
        long r30 = ((g) r1).s;
        e.a(r25, r26, r27, Long.valueOf(((g) r1).x), null, null, Long.valueOf(r30), Long.valueOf(r28), 48);
        return;
    L36:
        r25 = "1";
        goto L37
    L32:
        if (StringsKt.isBlank(r24) == false) goto L34;
    L21:
        r12 = 0;
        goto L22
    L8:
        if (r5.length() == 0) goto L11;
        r7 = false;
        goto L12
    }

    public j(DouyinLogin r1, o0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onError(ua7.b r11, int r12) {
        xa7.k r13 = (xa7.k) r11;
        FLogger.a.i(this.a.a, "onError: onError----errorcode:" + r12 + "---response:" + r13);
        this.b.onFail(r12);
        Integer r5 = Integer.valueOf(r12);
        if (r13 == null) goto L5;
        String r14 = ((ua7.b) r13).i;
    L6:
        e.a("0", null, null, null, r5, r14, null, null, 206);
        return;
    L5:
        r14 = null;
        goto L6
    }
}
