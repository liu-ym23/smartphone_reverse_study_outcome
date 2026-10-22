package com.bytedance.android.live.profit.lottery;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f3 {
    public static x2 a;
    public static final HashMap<String, x2> b = null;

    static {
        b = new HashMap();
    }

    public static void a(t r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        ReadOnlyProperty r0 = w2.e;
        KProperty[] r1 = w2.a;
        if (((ArrayList) r0.getValue(null, r1[3])) != null) goto L7;
        return;
    L7:
        if (((ArrayList) r0.getValue(null, r1[3])).size() <= 0) goto L61;
        Iterator r2 = ((ArrayList) r0.getValue(null, r1[3])).iterator();
    L10:
        if (r2.hasNext() == false) goto L62;
        x2 r3 = (x2) r2.next();
        if (TextUtils.isEmpty(r3.lotteryType) == true) goto L10;
        String r4 = r3.lotteryType;
        Integer r5 = Integer.valueOf(r6.d);
        if (r5 != null) goto L28;
        i r7 = yt0.c.f();
        if (r7 == null) goto L26;
        com.bytedance.live.datacontext.n<? extends g> r8 = r7.getCurrentLottery();
        if (r8 == null) goto L26;
        g r9 = (g) r8.getValue();
        if (r9 == null) goto L26;
        LotteryState r10 = r9.getState();
        if (r10 == null) goto L26;
        t r12 = l.a(r10);
        if (r12 == null) goto L26;
        int r13 = r12.d;
    L27:
        String r14 = String.valueOf(r13);
    L30:
        if (TextUtils.equals(r4, r14) == false) goto L10;
        a = r3;
        String r15 = r6.j;
        if (r15 != null) goto L52;
    L50:
        b.put(r3.lotteryType, a);
        goto L10
    L52:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L47
        a3 r17 = (a3) GsonHelper.get().fromJson(r15, a3.class);     // Catch: Throwable -> L47
        u0 r18 = r17.iconConfig;     // Catch: Throwable -> L47
        if (r18 == null) goto L38;
        x2 r19 = a;     // Catch: Throwable -> L47
        if (r19 == null) goto L38;
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L47
        r19.iconConfig = r18;     // Catch: Throwable -> L47
    L38:
        l3 r20 = r17.tempStateConfig;     // Catch: Throwable -> L47
        if (r20 == null) goto L44;
        x2 r22 = a;     // Catch: Throwable -> L47
        if (r22 == null) goto L43;
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L47
        r22.tempStateConfig = r20;     // Catch: Throwable -> L47
    L43:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L47
    L45:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L47
    L49:
        Result.box-impl(r24);
        goto L50
    L44:
        r23 = null;
    L47:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L26:
        r13 = 0;
        goto L27
    L28:
        r14 = String.valueOf(r5.intValue());
        goto L30
    L62:
        return;
    }

    public static boolean b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "lotteryType");
        if (b.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
