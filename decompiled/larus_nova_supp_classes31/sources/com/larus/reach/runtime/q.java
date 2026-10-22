package com.larus.reach.runtime;

import com.larus.reach.api.ReachPageScope;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachRequestSource;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q {
    public static final q a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReachPageScope.values().length];
            r0[ReachPageScope.Global.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ReachPageScope.TargetPage.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new q();
    }

    public q() {
    }

    public static Map a(Map r4) {
        Map r0 = null;
        if (r4 == null) goto L14;
        ArrayList r1 = new ArrayList();
        Iterator r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) r5.next();
        String r3 = (String) r2.getKey();
        String r6 = (String) r2.getValue();
        if (r6 == null) goto L10;
        Pair r7 = TuplesKt.to(r3, r6);
    L11:
        if (r7 == null) goto L6;
        r1.add(r7);
        goto L6
    L10:
        r7 = null;
        goto L11
    L13:
        r0 = MapsKt.toMap(r1);
    L14:
        if (r0 == null) goto L16;
        return r0;
    L16:
        return MapsKt.emptyMap();
    }

    public static String b(String r1) {
        if (r1 == null) goto L10;
        String r2 = StringsKt.trim(r1).toString();
        if (r2 == null) goto L10;
        String r3 = r2.toLowerCase(Locale.ROOT);
        if (r3 == null) goto L10;
        if ((!StringsKt.isBlank(r3)) == false) goto L10;
        return r3;
    L10:
        return null;
    }

    public static List d(List r6) {
        ArrayList r0 = null;
        if (r6 == null) goto L18;
        ArrayList r1 = new ArrayList();
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L17;
        ns9.n r2 = (ns9.n) r7.next();
        if (r2 != null) goto L10;
        ns9.b r3 = null;
    L15:
        if (r3 == null) goto L6;
        r1.add(r3);
        goto L6
    L10:
        Integer r4 = r2.getType();
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L14:
        q r8 = a;
        Map<String, String> r9 = r2.a();
        r8.getClass();
        r3 = new ns9.b(r5, a(r9));
        goto L15
    L13:
        r5 = 1;
        goto L14
    L17:
        r0 = r1;
    L18:
        if (r0 == null) goto L20;
        return r0;
    L20:
        return CollectionsKt.emptyList();
    }

    public static void c(ns9.m r3, int r4, ReachRequestSource r5, String r6) {
        FLogger.a.w("ReachDataHandler", "reach parse ignored, cmd_type=" + r4 + ", reason=" + r6);
        ConcurrentHashMap<String, Long> r7 = com.larus.reach.impl.b.a;
        Intrinsics.checkNotNullParameter(r3, "notify");
        Intrinsics.checkNotNullParameter(r5, "requestSource");
        if (r5 != ReachRequestSource.SERVER_CMD) goto L5;
    L7:
        Map<String, String> r8 = r3.l();
        String r9 = null;
        if (r8 == null) goto L14;
        String r10 = r8.get("tracking_info");
        if (r10 == null) goto L14;
        if ((!StringsKt.isBlank(r10)) == false) goto L14;
    L15:
        if (r10 != null) goto L56;
    L26:
        JSONObject r11 = new JSONObject();
    L27:
        String r12 = r3.m();
        if (r12 == null) goto L32;
        String r13 = StringsKt.trim(r12).toString();
        if (r13 == null) goto L32;
        String r14 = r13.toLowerCase(Locale.ROOT);
    L33:
        String r0 = "bottom";
        if (Intrinsics.areEqual(r14, "bottom") == true) goto L40;
        r0 = "top";
        if (Intrinsics.areEqual(r14, "top") == true) goto L40;
        r0 = "unknown";
    L40:
        r11.put("position", r0);
        String r15 = r3.p();
        String r1 = "";
        if (r15 != null) goto L43;
        r15 = "";
    L43:
        r11.put("push_scene", r15);
        String r16 = r3.o();
        if (r16 == null) goto L47;
        r1 = r16;
    L47:
        r11.put("push_id", r1);
        String r17 = r3.r();
        if (r17 != null) goto L50;
    L54:
        r11.put("discard_reason", ReachRejectReason.INVALID_PROTOCOL.getDiscardReason());
        com.larus.platform.service.o.a.reportEvent("inapp_push_discard", r11);
        return;
    L50:
        if ((!StringsKt.isBlank(r17)) == false) goto L52;
        r9 = r17;
    L52:
        if (r9 == null) goto L54;
        r11.put("template_id", r9);
    L32:
        r14 = null;
        goto L33
    L56:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L18
        Object r19 = Result.constructor-impl(new JSONObject(r10));     // Catch: Throwable -> L18
    L20:
        JSONObject r20 = new JSONObject();
        if (Result.isFailure-impl(r19) == false) goto L23;
        r19 = r20;
    L23:
        r11 = (JSONObject) r19;
        if (r11 == null) goto L26;
    L18:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        r10 = null;
        goto L15
    L5:
        if (r5 == ReachRequestSource.INAPP_PUSH_PULL) goto L7;
    }
}
