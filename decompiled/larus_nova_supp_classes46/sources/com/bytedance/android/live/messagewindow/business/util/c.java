package com.bytedance.android.live.messagewindow.business.util;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final Keva a = null;

    static {
        a = Keva.getRepo("common_card_params_record");
    }

    @JvmStatic
    public static final int a(String r19, Integer r20, boolean r21) {
        String r3 = "put";
        int r6 = 0;
        if (r20 != null) goto L5;
        return 0;
    L5:
        String r0 = Intrinsics.stringPlus(r19, r20);
        Keva r7 = a;
        if (r7 == null) goto L8;
        String r8 = r7.getString("card_close_times", "");
    L9:
        mm0.a r9 = (mm0.a) JsonUtil.parse(r8, mm0.a.class);
        if (r9 != null) goto L12;
        r9 = new mm0.a();
    L12:
        long r10 = System.currentTimeMillis();
    L48:
        e = e;
        r6 = 0;
    L50:
        SafetyGuard.a(null, e, null);
        StringBuilder r1 = new StringBuilder("error ");
        if (r21 == false) goto L53;
        String r11 = "put";
    L54:
        r1.append(r11);
        r1.append(" card ");
        r1.append(r20);
        r1.append(" MicRoomCloseTimes in keva");
        ALogger.e("RecordCardParamsHelper", r1.toString());
    L55:
        StringBuilder r2 = new StringBuilder();
        if (r21 == true) goto L59;
        r3 = "get";
    L59:
        r2.append(r3);
        r2.append(" card ");
        r2.append(r20);
        r2.append(" MicRoomCloseTimes ");
        r2.append(r6);
        r2.append(" in keva");
        ALogger.d("RecordCardParamsHelper", r2.toString());
        return r6;
    L53:
        r11 = "get";
        goto L54
    L14:
        long r14 = 86400000;
        if (Math.abs(r10 - Long.valueOf(r9.a).longValue()) > r14) goto L63;
    L20:
        HashMap<String, Pair<Object, Long>> r12 = r9.b;     // Catch: Exception -> L48
        r9.a = r10;     // Catch: Exception -> L48
        if (r12 == null) goto L26;
        Set<Map.Entry<String, Pair<Object, Long>>> r13 = r12.entrySet();     // Catch: Exception -> L18
        if (r13 == null) goto L26;
        Iterator<Map.Entry<String, Pair<Object, Long>>> r15 = r13.iterator();     // Catch: Exception -> L18
    L27:
        if (r15 == null) goto L39;
        if (r15.hasNext() != true) goto L39;
        Map.Entry<String, Pair<Object, Long>> r16 = r15.next();     // Catch: Exception -> L48
        if (Math.abs(r10 - ((Number) r16.getValue().getSecond()).longValue()) <= r14) goto L34;
        r15.remove();     // Catch: Exception -> L48
        goto L27
    L34:
        if (TextUtils.equals(r0, r16.getKey()) == false) goto L27;
        r6 = CastIntegerProtector.parseInt(String.valueOf(r16.getValue().getFirst()));     // Catch: Exception -> L48
        if (r12 == null) goto L40;
        Pair<Object, Long> r17 = r12.put(r0, new Pair(String.valueOf(r6), Long.valueOf(r10)));     // Catch: Exception -> L18
    L40:
        if (r21 == false) goto L55;
        r6 = r6 + 1;     // Catch: Exception -> L18
        if (r12 == null) goto L44;
        Pair<Object, Long> r4 = r12.put(r0, new Pair(String.valueOf(r6), Long.valueOf(r10)));     // Catch: Exception -> L18
    L44:
        Keva r5 = a;     // Catch: Exception -> L18
        if (r5 == null) goto L55;
        r5.storeString("card_close_times", GsonHelper.get().toJson(r9));     // Catch: Exception -> L18
    L18:
        e = e;
    L39:
        r6 = 0;
    L26:
        r15 = null;
        goto L27
    L63:
        HashMap<String, Pair<Object, Long>> r18 = new HashMap();     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r18, "<set-?>");     // Catch: Exception -> L18
        r9.b = r18;     // Catch: Exception -> L18
        goto L20
    L8:
        r8 = null;
        goto L9
    }

    @JvmStatic
    public static final long b(String r9, Integer r10, boolean r11) {
        long r0 = System.currentTimeMillis();
        String r12 = Intrinsics.stringPlus(r9, r10);
        long r2 = 0;
        if (r10 == null) goto L14;
        r10.intValue();
        Keva r13 = a;
        if (r13 == null) goto L8;
        r2 = r13.getLong(r12, 0);
    L8:
        if ((r0 - r2) <= 86400000) goto L11;
        if (r13 == null) goto L11;
        r13.erase(r12);
    L11:
        if (r11 == false) goto L14;
        if (r13 == null) goto L14;
        r13.storeLong(r12, r0);
    L14:
        StringBuilder r14 = new StringBuilder();
        if (r11 == false) goto L17;
        String r15 = "put";
    L18:
        r14.append(r15);
        r14.append(" CardLastShowTime ");
        r14.append(r2);
        r14.append(" in keva");
        ALogger.d("RecordCardParamsHelper", r14.toString());
        return r2;
    L17:
        r15 = "get";
        goto L18
    }

    @JvmStatic
    public static final boolean c(String r16, String r17, Integer r18, boolean r19) {
        String r0 = r17 + r18 + r16;
        Keva r2 = a;
        if (r2 == null) goto L5;
        String r3 = r2.getString("is_same_anchor_info", "");
    L6:
        mm0.a r4 = (mm0.a) JsonUtil.parse(r3, mm0.a.class);
        if (r4 != null) goto L9;
        r4 = new mm0.a();
    L9:
        long r5 = System.currentTimeMillis();
        long r9 = 86400000;
        if (Math.abs(r5 - Long.valueOf(r4.a).longValue()) <= r9) goto L13;
        HashMap<String, Pair<Object, Long>> r7 = new HashMap();     // Catch: Exception -> L35
        Intrinsics.checkNotNullParameter(r7, "<set-?>");     // Catch: Exception -> L35
        r4.b = r7;     // Catch: Exception -> L35
    L13:
        HashMap<String, Pair<Object, Long>> r8 = r4.b;     // Catch: Exception -> L35
        r4.a = r5;     // Catch: Exception -> L35
        if (r8 == null) goto L18;
        Set<Map.Entry<String, Pair<Object, Long>>> r10 = r8.entrySet();     // Catch: Exception -> L35
        if (r10 == null) goto L18;
        Iterator<Map.Entry<String, Pair<Object, Long>>> r11 = r10.iterator();     // Catch: Exception -> L35
    L19:
        if (r11 == null) goto L28;
        if (r11.hasNext() != true) goto L28;
        Map.Entry<String, Pair<Object, Long>> r12 = r11.next();     // Catch: Exception -> L35
        if (Math.abs(r5 - ((Number) r12.getValue().getSecond()).longValue()) > r9) goto L24;
        if (TextUtils.equals(r0, r12.getKey()) == false) goto L19;
        return true;
    L24:
        r11.remove();     // Catch: Exception -> L35
    L28:
        if (r19 == false) goto L54;
        if (r8 == null) goto L31;
        Pair<Object, Long> r1 = r8.put(r0, new Pair(r0, Long.valueOf(r5)));     // Catch: Exception -> L35
    L31:
        Keva r6 = a;     // Catch: Exception -> L35
        if (r6 == null) goto L55;
        r6.storeString("is_same_anchor_info", GsonHelper.get().toJson(r4));     // Catch: Exception -> L35
        return false;
    L55:
        return false;
    L54:
        return false;
    L18:
        r11 = null;
    L35:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        StringBuilder r13 = new StringBuilder("error ");
        if (r19 == false) goto L39;
        String r14 = "put";
    L40:
        r13.append(r14);
        r13.append(" card ");
        r13.append(r18);
        r13.append(" IsSameAnchorInfo in keva");
        ALogger.e("RecordCardParamsHelper", r13.toString());
        return false;
    L39:
        r14 = "get";
        goto L40
    L5:
        r3 = null;
        goto L6
    }
}
