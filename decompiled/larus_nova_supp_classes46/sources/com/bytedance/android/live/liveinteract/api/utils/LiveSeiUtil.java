package com.bytedance.android.live.liveinteract.api.utils;

import android.text.TextUtils;
import com.bytedance.android.livesdk.config.b50;
import com.bytedance.android.livesdk.config.ir0;
import com.bytedance.android.livesdk.f2;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveSeiUtil {
    public static final List<String> a = null;
    public static final List<String> b = null;
    public static final Lazy c = null;
    public static final FifoMap<Integer, JSONObject> d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final FIFOConcurrentMap<Integer, JSONObject> h = null;
    public static final LiveSeiUtil i = null;

    public LiveSeiUtil() {
    }

    static {
        i = new LiveSeiUtil();
        a = (List) b50.a.getValue();
        b = (List) ir0.a.getValue();
        c = LazyKt.lazy(LiveSeiUtil$seiOptimizeEnable$2.INSTANCE);
        f2 r1 = f2.a;
        d = new FifoMap(((Integer) r1.getValue()).intValue());
        e = LazyKt.lazy(LiveSeiUtil$seiCacheOptimize$2.INSTANCE);
        Lazy r0 = LazyKt.lazy(LiveSeiUtil$seiRemoveOptimize$2.INSTANCE);
        f = r0;
        g = LazyKt.lazy(LiveSeiUtil$harmonySeiFixEnable$2.INSTANCE);
        h = new FIFOConcurrentMap(((Integer) r1.getValue()).intValue(), ((Boolean) r0.getValue()).booleanValue());
    }

    public static boolean b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "seiString");
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        if (e(r6) == false) goto L27;
        List<String> r0 = b;
        if (r0 == null) goto L16;
        Iterator<T> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L16;
        String r3 = (String) r1.next();
        if (TextUtils.isEmpty(r3) == true) goto L10;
        if (StringsKt.contains$default(r6, r3, false, 2, null) == false) goto L10;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L28;
        return true;
    L28:
        return false;
    L16:
        r7 = false;
        goto L17
    L27:
        return false;
    }

    public static JSONObject c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "rawJson");
        if (TextUtils.isEmpty(r2) == true) goto L5;
        if (((Boolean) c.getValue()).booleanValue() == true) goto L9;
        JSONObject r0 = new JSONObject(r2);     // Catch: Exception -> L18
    L20:
        return r0;
    L9:
        if (((Boolean) e.getValue()).booleanValue() == false) goto L13;
        r0 = h.get(Integer.valueOf(r2.hashCode()));     // Catch: Exception -> L18
        if (r0 != null) goto L20;
        r0 = new JSONObject(r2);     // Catch: Exception -> L18
        goto L20
    L13:
        r0 = d.get(Integer.valueOf(r2.hashCode()));     // Catch: Exception -> L18
        if (r0 != null) goto L20;
        r0 = new JSONObject(r2);     // Catch: Exception -> L18
    L23:
        return new JSONObject();
    L5:
        return new JSONObject();
    }

    public static boolean d(String r4) {
        if (((Boolean) g.getValue()).booleanValue() == false) goto L10;
        if (r4 == null) goto L6;
        boolean r5 = StringsKt.contains$default(r4, "TTLiveSDK_Harmony", false, 2, null);
    L7:
        if (r5 == false) goto L11;
        return true;
    L11:
        return false;
    L6:
        r5 = false;
        goto L7
    L10:
        return false;
    }

    public static boolean e(String r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if ((!StringsKt.isBlank(r7)) == false) goto L44;
        int r1 = r7.length() - 1;
        int r3 = 0;
        boolean r4 = false;
    L8:
        if (r3 > r1) goto L23;
        if (r4 == true) goto L11;
        int r5 = r3;
    L13:
        if (Intrinsics.compare(r7.charAt(r5), 32) > 0) goto L15;
        boolean r6 = true;
    L16:
        if (r4 == false) goto L17;
        if (r6 == false) goto L23;
        r1 = r1 - 1;
        goto L8
    L17:
        if (r6 == false) goto L18;
        r3 = r3 + 1;
        goto L8
    L18:
        r4 = true;
        goto L8
    L15:
        r6 = false;
        goto L16
    L11:
        r5 = r1;
    L23:
        String r8 = r7.subSequence(r3, r1 + 1).toString();
        if (StringsKt.startsWith$default(r8, "{", false, 2, null) == false) goto L29;
        if (StringsKt.endsWith$default(r8, "}", false, 2, null) == false) goto L29;
    L32:
        return true;
    L29:
        if (StringsKt.startsWith$default(r8, "[", false, 2, null) == true) goto L31;
        return false;
    L31:
        if (StringsKt.endsWith$default(r8, "]", false, 2, null) == true) goto L32;
        return false;
    L44:
        return false;
    }

    public static JSONObject g(String r1) {
        if (r1 == null) goto L7;
        i.getClass();
        if (((Boolean) e.getValue()).booleanValue() == false) goto L10;
        return h.get(Integer.valueOf(r1.hashCode()));
    L10:
        return d.get(Integer.valueOf(r1.hashCode()));
    L7:
        return null;
    }

    public static Pair a(String r7, JSONObject r8) {
        if (r7 == null) goto L28;
        if (StringsKt.contains$default(r7, "app_data", false, 2, null) != true) goto L28;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L22
        if (r8 != null) goto L10;
        i.getClass();     // Catch: Throwable -> L22
        r8 = c(r7);     // Catch: Throwable -> L22
    L10:
        if (r8.has("info") == true) goto L12;
    L20:
        String r9 = r8.optString("app_data");     // Catch: Throwable -> L22
        String r10 = new Regex("\\\\").replace(r9, "");     // Catch: Throwable -> L22
        return TuplesKt.to(r10, new JSONObject(r10));
    L12:
        if (r8.has("source") == false) goto L20;
        if (TextUtils.equals(r8.optString("source"), "zego") == false) goto L20;
        Object r11 = r8.get("info");     // Catch: Throwable -> L22
        if (r11 == null) goto L19;
        r8 = (JSONObject) r11;     // Catch: Throwable -> L22
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th))) == null) goto L28;
        return TuplesKt.to("", null);
    L28:
        return TuplesKt.to("", null);
    }

    public static boolean f(String r4, boolean r5) {
        if (r5 == false) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L27:
        return false;
    L8:
        if (StringsKt.contains$default(r4, "TTLiveSDK_Android", false, 2, null) == false) goto L10;
    L21:
        boolean r1 = true;
    L22:
        if (r1 == true) goto L25;
        r4 = null;
    L25:
        if (r4 == null) goto L27;
        return true;
    L10:
        if (StringsKt.contains$default(r4, "TTLiveSDK_IOS", false, 2, null) == true) goto L21;
        i.getClass();
        if (d(r4) == true) goto L21;
        if (StringsKt.contains$default(r4, "TTLiveSDK_Windows", false, 2, null) == true) goto L21;
        if (StringsKt.contains$default(r4, "app_data", false, 2, null) == true) goto L21;
        if (StringsKt.contains$default(r4, "multi_view_data", false, 2, null) == true) goto L21;
        r1 = false;
        goto L22
    }
}
