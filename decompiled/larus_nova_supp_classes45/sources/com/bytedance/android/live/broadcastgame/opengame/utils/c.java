package com.bytedance.android.live.broadcastgame.opengame.utils;

import com.bytedance.android.live.base.model.morepanel.ColumnElement;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;

    public c(d r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r11) {
        Long r12 = (Long) r11;
        d r0 = this.a;
        monitor-enter(r0);
        int r1 = this.a.b.size();     // Catch: Throwable -> L71
        if (r1 != 0) goto L8;
    L68:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L71
        monitor-exit(r0);
        return;
    L8:
        if (r1 > 4) goto L61;
        Iterator<Map.Entry<Integer, Long>> r2 = this.a.b.entrySet().iterator();     // Catch: Throwable -> L71
    L11:
        if (r2.hasNext() == false) goto L67;
        long r3 = TimeUnit.NANOSECONDS.toMillis(r12.longValue() - r2.next().getValue().longValue());     // Catch: Throwable -> L71
        int r4 = x10.a.a;     // Catch: Throwable -> L71
        x10.a.C0290a.C0291a r5 = x10.a.a(this.a.c, "bootconfig_499");     // Catch: Throwable -> L71
        r5.a(GamePromoteDataContext.GAME_TYPE_MOBILE);     // Catch: Throwable -> L71
        Integer r6 = Integer.valueOf((int) r3);     // Catch: Throwable -> L71
        HashMap<String, String> r7 = r5.a;     // Catch: Throwable -> L71
        if (r6 == null) goto L16;
        String r8 = String.valueOf(r6.intValue());     // Catch: Throwable -> L71
        if (r8 == null) goto L16;
    L17:
        r7.put("param3", r8);     // Catch: Throwable -> L71
        this.a.getClass();     // Catch: Throwable -> L71
        long r9 = 50;
        if (1 <= r3) goto L21;
    L23:
        long r14 = 100;
        if (51 <= r3) goto L27;
    L29:
        long r15 = 500;
        if (101 <= r3) goto L33;
    L35:
        long r16 = 1000;
        if (501 <= r3) goto L39;
    L41:
        long r17 = 2000;
        if (ColumnElement.typeLocalSimpleDivider <= r3) goto L45;
    L47:
        long r18 = 5000;
        if (2001 <= r3) goto L51;
    L53:
        long r19 = 10000;
        if (5001 <= r3) goto L57;
    L59:
        String r21 = "(10000, more)";
    L60:
        r5.a.put("param4", r21);     // Catch: Throwable -> L71
        r5.a.put("param5", this.b);     // Catch: Throwable -> L71
        new x10.a.C0290a(r5).a();     // Catch: Throwable -> L71
        goto L11
    L57:
        if (r19 < r3) goto L59;
        r21 = "(5001, 10000)";
        goto L60
    L51:
        if (r18 < r3) goto L53;
        r21 = "(2001, 5000)";
        goto L60
    L45:
        if (r17 < r3) goto L47;
        r21 = "(1001, 2000)";
        goto L60
    L39:
        if (r16 < r3) goto L41;
        r21 = "(501, 1000)";
        goto L60
    L33:
        if (r15 < r3) goto L35;
        r21 = "(101, 500)";
        goto L60
    L27:
        if (r14 < r3) goto L29;
        r21 = "(51, 100)";
        goto L60
    L21:
        if (r9 < r3) goto L23;
        r21 = "(1, 50)";
    L16:
        r8 = "";
    L67:
        this.a.b.clear();     // Catch: Throwable -> L71
        goto L68
    L61:
        int r110 = x10.a.a;     // Catch: Throwable -> L71
        x10.a.C0290a.C0291a r111 = x10.a.a(this.a.c, "bootconfig_499");     // Catch: Throwable -> L71
        r111.a(String.valueOf(r1));     // Catch: Throwable -> L71
        Integer r22 = -1;     // Catch: Throwable -> L71
        HashMap<String, String> r23 = r111.a;     // Catch: Throwable -> L71
        if (r22 == null) goto L65;
        String r24 = String.valueOf(r22.intValue());     // Catch: Throwable -> L71
        if (r24 == null) goto L65;
    L66:
        r23.put("param3", r24);     // Catch: Throwable -> L71
        r111.a.put("param4", "unknown");     // Catch: Throwable -> L71
        r111.a.put("param5", this.b);     // Catch: Throwable -> L71
        new x10.a.C0290a(r111).a();     // Catch: Throwable -> L71
    L65:
        r24 = "";
    L71:
        th = move-exception;
        throw th;
    }
}
