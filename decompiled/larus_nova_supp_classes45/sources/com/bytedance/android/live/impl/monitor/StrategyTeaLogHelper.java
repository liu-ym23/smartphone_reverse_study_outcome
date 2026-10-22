package com.bytedance.android.live.impl.monitor;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import j40.f3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class StrategyTeaLogHelper {
    public static final ConcurrentHashMap<String, Map<String, String>> a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    static {
        a = new ConcurrentHashMap();
        b = LazyKt.lazy(StrategyTeaLogHelper$filterMap$2.INSTANCE);
        c = LazyKt.lazy(StrategyTeaLogHelper$filterMapV2$2.INSTANCE);
        d = LazyKt.lazy(StrategyTeaLogHelper$detailIdFilterList$2.INSTANCE);
        e = LazyKt.lazy(StrategyTeaLogHelper$filterFactorList$2.INSTANCE);
        f = LazyKt.lazy(StrategyTeaLogHelper$useAsyncLog$2.INSTANCE);
    }

    public static String b(String r12) {
        Intrinsics.checkNotNullParameter(r12, "faName");
        Set<String> r0 = a.keySet();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L17;
        Object r4 = r2.next();
        String r11 = (String) r4;
        if (Intrinsics.areEqual((String) ListProtector.get(StringsKt.split$default(r11, new String[]{"|"}, false, 0, 6, null), 0), r12) == false) goto L14;
        Map<String, String> r5 = a.get(r11);
        if (r5 == null) goto L13;
        String r6 = r5.get("combine_info_type");
        if (r6 == null) goto L13;
        if (r6.equals("3") == true) goto L14;
    L13:
        r3 = true;
    L14:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L17:
        if ((!r1.isEmpty()) == false) goto L22;
        Map<String, String> r13 = a.get(ListProtector.get(r1, 0));
        if (r13 == null) goto L22;
        String r14 = r13.get("detail_combine_id");
        if (r14 == null) goto L22;
        return r14;
    L22:
        return "";
    }

    public static void e(String r11) {
        Intrinsics.checkNotNullParameter(r11, "faName");
        Set<String> r0 = a.keySet();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (Intrinsics.areEqual((String) ListProtector.get(StringsKt.split$default((String) r3, new String[]{"|"}, false, 0, 6, null), 0), r11) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L24;
        Map<String, String> r5 = a.get((String) r4.next());
        if (r5 == null) goto L10;
        if (c(r5, r11) == false) goto L10;
        IRoomContextService r6 = k.f(IRoomContextService.class);
        Class r7 = null;
        if (r6 == null) goto L21;
        o r8 = IRoomContextService.a.a(r6, null, 0, 3);
        if (r8 == null) goto L21;
        r7 = r8.Q2();
    L21:
        if (((Boolean) f.getValue()).booleanValue() == true) goto L22;
        j0.l().sendLog("livesdk_live_strategy_info", r5, new Object[]{r7});
        goto L10
    L22:
        j0.l().o("livesdk_live_strategy_info", r5, new Object[]{r7});
        goto L10
    }

    public static boolean c(Map r11, String r12) {
        if (ArraysKt.contains((String[]) e.getValue(), r12) == false) goto L5;
        return false;
    L5:
        String[] r0 = (String[]) d.getValue();
        String r2 = (String) r11.get("detail_combine_id");
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        if (ArraysKt.contains(r0, r2) == false) goto L11;
        return false;
    L11:
        Map r1 = (Map) ((Map) b.getValue()).get(r12);
        if (r1 == null) goto L28;
        String r9 = (String) r11.get("fa_value");
        if (r9 == null) goto L18;
        String r13 = (String) r1.get("filter_fa_value");
        if (r13 == null) goto L18;
        Boolean r14 = Boolean.valueOf(StringsKt.contains$default(r13, r9, false, 2, null));
    L20:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L28;
        if (r1.get("filter_type") == null) goto L28;
        if (Intrinsics.areEqual((String) r1.get("filter_type"), "0") == false) goto L26;
    L27:
        return false;
    L26:
        if (Intrinsics.areEqual((String) r1.get("filter_type"), (String) r11.get("combine_info_type")) == false) goto L28;
    L18:
        r14 = null;
    L28:
        Map r15 = (Map) ((Map) c.getValue()).get(r12);
        if (r15 == null) goto L46;
        String r3 = (String) r11.get("fa_value");
        if (r3 == null) goto L35;
        String r4 = (String) r15.get("filter_fa_value");
        if (r4 == null) goto L35;
        Boolean r5 = Boolean.valueOf(StringsKt.contains$default(r4, r3, false, 2, null));
    L37:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L46;
        if (r15.get("filter_type") == null) goto L46;
        if (Intrinsics.areEqual((String) r15.get("filter_type"), "0") == false) goto L43;
    L44:
        return false;
    L43:
        if (Intrinsics.areEqual((String) r15.get("filter_type"), (String) r11.get("combine_info_type")) == false) goto L46;
    L35:
        r5 = null;
    L46:
        if (StringsKt.equals$default((String) r11.get("combine_info_type"), GamePromoteDataContext.GAME_TYPE_MOBILE, false, 2, null) == true) goto L48;
        return true;
    L48:
        if ((Math.random() * ((double) 100)) > f3.a.getValue().intValue()) goto L52;
        return true;
    L52:
        return false;
    }

    public static void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "faName");
        Intrinsics.checkNotNullParameter(r2, "strategyId");
        a.remove(r1 + '|' + r2);
    }

    public static void a(String r9, String r11, Map r12) {
        Intrinsics.checkNotNullParameter(r9, "faName");
        Intrinsics.checkNotNullParameter(r11, "strategyId");
        Intrinsics.checkNotNullParameter(r12, "extra");
        Iterator<Map.Entry<String, Map<String, String>>> r0 = a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        Map.Entry<String, Map<String, String>> r1 = r0.next();
        if (Intrinsics.areEqual((String) ListProtector.get(StringsKt.split$default(r1.getKey(), new String[]{"|"}, false, 0, 6, null), 0), r9) == false) goto L4;
        String r2 = r1.getValue().get("combine_info_type");
        if (r2 != null) goto L10;
    L11:
        String r3 = r1.getValue().get("combine_info_type");
        if (r3 == null) goto L4;
        if (CastIntegerProtector.parseInt(r3) != 2) goto L4;
    L15:
        r0.remove();
        goto L4
    L10:
        if (CastIntegerProtector.parseInt(r2) == 1) goto L15;
    L16:
        f(r9, r11, r12);
    }

    public static void f(String r1, String r2, Map r3) {
        Intrinsics.checkNotNullParameter(r1, "faName");
        Intrinsics.checkNotNullParameter(r2, "strategyId");
        Intrinsics.checkNotNullParameter(r3, "extra");
        a.put(r1 + '|' + r2, r3);
    }
}
