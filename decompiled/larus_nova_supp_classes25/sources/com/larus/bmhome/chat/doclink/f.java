package com.larus.bmhome.chat.doclink;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final f a = null;
    public static final Lazy b = null;
    public static final ThreadLocal<MessageDigest> c = null;

    public f() {
    }

    static {
        a = new f();
        b = LazyKt.lazy(new a());
        c = ThreadLocal.withInitial(new b());
    }

    public static Keva d() {
        return (Keva) b.getValue();
    }

    public static List g() {
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.map(StringsKt.lineSequence(d().getString("__cache_index__", "")), new d()), new e()));
    }

    public static String i(String r10) {
        MessageDigest r0 = c.get();
        r0.reset();
        byte[] r1 = r0.digest(r10.getBytes(Charsets.UTF_8));
        Intrinsics.checkNotNull(r1);
        return ArraysKt.joinToString$default(r1, "", null, null, 0, null, new c(), 30, null);
    }

    public static JSONObject j(h r4) {
        JSONObject r0 = new JSONObject().put("preview_id", r4.a).put("title", r4.b).put("url", r4.c);
        String r1 = r4.d;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        JSONObject r3 = r0.put("icon_key", r1);
        String r5 = r4.e;
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        JSONObject r6 = f(f(f(f(r3.put("icon_color_token", r5), "icon_color_value", r4.f), "icon_color_key_type", r4.g), "icon_color_key_value", r4.h), "icon_color_key_alpha", r4.i);
        String r7 = r4.j;
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        JSONObject r8 = r6.put("icon_unicode", r7);
        String r9 = r4.k;
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        JSONObject r10 = r8.put("net_icon_key", r9);
        String r11 = r4.l;
        if (r11 != null) goto L17;
        r11 = "";
    L17:
        JSONObject r12 = r10.put("file_type", r11);
        String r13 = r4.m;
        if (r13 == null) goto L22;
        r2 = r13;
    L22:
        return r12.put("matched_url", r2).put("update_time", System.currentTimeMillis());
    }

    public static h k(JSONObject r15) {
        String r2 = r15.optString("preview_id");
        String r3 = r15.optString("title");
        String r4 = r15.optString("url");
        String r0 = r15.optString("icon_key");
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank(r0)) == true) goto L6;
        r0 = null;
    L6:
        String r1 = r15.optString("icon_color_token");
        Intrinsics.checkNotNull(r1);
        if ((!StringsKt.isBlank(r1)) == false) goto L9;
        String r6 = r1;
    L10:
        Integer r7 = e(r15, "icon_color_value");
        Integer r8 = e(r15, "icon_color_key_type");
        Integer r9 = e(r15, "icon_color_key_value");
        Integer r10 = e(r15, "icon_color_key_alpha");
        String r5 = r15.optString("icon_unicode");
        Intrinsics.checkNotNull(r5);
        if ((!StringsKt.isBlank(r5)) == false) goto L13;
        String r11 = r5;
    L14:
        String r12 = r15.optString("net_icon_key");
        Intrinsics.checkNotNull(r12);
        if ((!StringsKt.isBlank(r12)) == false) goto L17;
        String r13 = r12;
    L18:
        String r14 = r15.optString("file_type");
        Intrinsics.checkNotNull(r14);
        if ((!StringsKt.isBlank(r14)) == false) goto L21;
        String r16 = r14;
    L22:
        String r17 = r15.optString("matched_url");
        Intrinsics.checkNotNull(r17);
        if ((!StringsKt.isBlank(r17)) == false) goto L25;
        String r18 = r17;
    L27:
        return new h(r2, r3, r4, r0, r6, r7, r8, r9, r10, r11, r13, r16, r18);
    L25:
        r18 = null;
        goto L27
    L21:
        r16 = null;
        goto L22
    L17:
        r13 = null;
        goto L18
    L13:
        r11 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    }

    public final synchronized void b(String r11) {
        monitor-enter(this);
        d().erase(r11);     // Catch: Throwable -> L8
        LinkedHashSet r1 = new LinkedHashSet(g());     // Catch: Throwable -> L8
        if (r1.remove(r11) == false) goto L6;
        d().storeString("__cache_index__", CollectionsKt.joinToString$default(r1, "\n", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void h(String r11) {
        monitor-enter(this);
        LinkedHashSet r0 = new LinkedHashSet(g());     // Catch: Throwable -> L13
        r0.remove(r11);     // Catch: Throwable -> L13
        r0.add(r11);     // Catch: Throwable -> L13
    L5:
        if (r0.size() <= 500) goto L10;
        Iterator r12 = r0.iterator();     // Catch: Throwable -> L13
        if (r12.hasNext() == false) goto L10;
        String r1 = (String) r12.next();     // Catch: Throwable -> L13
        r12.remove();     // Catch: Throwable -> L13
        d().erase(r1);     // Catch: Throwable -> L13
    L10:
        d().storeString("__cache_index__", CollectionsKt.joinToString$default(r0, "\n", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static String a(String r2, String r3) {
        String r4 = StringsKt.removePrefix(r2, "long_screenshot_");
        String r5 = l.a(r3);
        if (StringsKt.isBlank(r4) == false) goto L5;
        return null;
    L5:
        if (StringsKt.isBlank(r5) == false) goto L8;
        return null;
    L8:
        return "v1:" + i(r4) + ':' + i(r5);
    }

    public static Map c(String r13, List r14) {
        Intrinsics.checkNotNullParameter(r13, "messageId");
        Intrinsics.checkNotNullParameter(r14, "urls");
        if (StringsKt.isBlank(r13) == true) goto L50;
        if (r14.isEmpty() == true) goto L50;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L48;
        String r2 = (String) r15.next();
        f r3 = a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r13, "messageId");
        Intrinsics.checkNotNullParameter(r2, "url");
        String r4 = a(r13, r2);
        if (r4 == null) goto L18;
        String r6 = d().getString(r4, "");
        Intrinsics.checkNotNull(r6);
        boolean r8 = true;
        if ((!StringsKt.isBlank(r6)) == true) goto L17;
        r6 = null;
    L17:
        if (r6 == null) goto L18;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L30
        JSONObject r9 = new JSONObject(r6);     // Catch: Throwable -> L30
        long r10 = r9.optLong("update_time");     // Catch: Throwable -> L30
        if (r10 > 0) goto L22;
    L25:
        if (r8 == false) goto L27;
        r3.b(r4);     // Catch: Throwable -> L30
        h r5 = null;
    L28:
        Object r11 = Result.constructor-impl(r5);     // Catch: Throwable -> L30
    L32:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L36;
        FLogger.a.w("MessageDocPreviewCache", "get failed, key=" + r4 + ", err=" + r12.getMessage());
    L36:
        if (Result.isFailure-impl(r11) == false) goto L38;
        r11 = null;
    L38:
        h r16 = (h) r11;
    L39:
        if (r16 == null) goto L9;
        String r17 = l.a(r2);
        String r18 = r16.c;
        if (StringsKt.isBlank(r18) == false) goto L43;
        r18 = r2;
    L43:
        String r19 = r16.m;
        if (r19 == null) goto L47;
        r2 = r19;
    L47:
        r1.put(r17, h.a(r16, null, r18, r2, 4091));
        goto L9
    L27:
        r5 = k(r9);     // Catch: Throwable -> L30
        goto L28
    L22:
        if ((System.currentTimeMillis() - r10) > 259200000) goto L25;
        r8 = false;
    L30:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        r16 = null;
        goto L39
    L48:
        return r1;
    L50:
        return MapsKt.emptyMap();
    }

    public static Integer e(JSONObject r1, String r2) {
        if (r1.has(r2) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(r1.optInt(r2));
    }

    public static JSONObject f(JSONObject r0, String r1, Integer r2) {
        if (r2 == null) goto L6;
        JSONObject r3 = r0.put(r1, r2.intValue());
        Intrinsics.checkNotNull(r3);
        return r3;
    L6:
        return r0;
    }
}
