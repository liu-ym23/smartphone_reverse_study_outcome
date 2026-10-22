package com.larus.bmhome.instruction;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements i {
    public static final c a = null;
    public static final Lazy b = null;
    public static final Map<String, ReplyOption> c = null;
    public static final Map<String, ReplyOption> d = null;
    public static final Map<String, Boolean> e = null;

    public c() {
    }

    static {
        a = new c();
        b = LazyKt.lazy(new b());
        c = new LinkedHashMap();
        d = new LinkedHashMap();
        e = new LinkedHashMap();
    }

    public static String b(String r1, int r2) {
        return r1 + '-' + r2 + '-' + com.larus.platform.service.o.a.getUserID();
    }

    @Override // com.larus.bmhome.instruction.i
    public final ReplyOption a(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "botId");
        String r6 = b(r4, r5);
        ReplyOption r7 = (ReplyOption) ((LinkedHashMap) c).get(r6);
        if (r7 != null) goto L8;
        ReplyOption r8 = (ReplyOption) ((LinkedHashMap) d).get(r6);
        if (r8 != null) goto L7;
        Object r9 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        r8 = com.larus.bmhome.view.actionbar.custom.cache.e.b(ReplyOption.Companion, wa8.t0.a, null, null);
    L7:
        r7 = r8;
    L8:
        Object r10 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        ReplyOption r11 = com.larus.bmhome.view.actionbar.custom.cache.e.a(r7);
        FLogger.a.d("ActiveSwitchHelper", "isSwitchOpen, status: " + r7 + ", realStatus: " + r11);
        return r11;
    }

    public static void c(String r2, int r3, ReplyOption r4) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        String r5 = b(r2, r3);
        Map<String, ReplyOption> r6 = d;
        if (r4 != null) goto L5;
        Object r7 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        r4 = com.larus.bmhome.view.actionbar.custom.cache.e.b(ReplyOption.Companion, wa8.t0.a, null, null);
    L5:
        r6.put(r5, r4);
        e.put(r5, Boolean.TRUE);
    }

    public static void d(String r1, ReplyOption r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "botId");
        Intrinsics.checkNotNullParameter(r2, "status");
        c.put(b(r1, r3), r2);
    }
}
