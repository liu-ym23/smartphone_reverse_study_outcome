package com.bytedance.android.live.browser;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u000020\u0012,\u0012*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/android/live/browser/o$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<HashMap<String, Object>> {
        public a() {
        }
    }

    static {
    }

    public static String a(String r11, Uri r12) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        Matcher r1 = PatternProtector.compile("\\$\\{([^}]*)\\}").matcher(r11);     // Catch: Throwable -> L20
        String r2 = r11;
    L4:
        if (r1.find() == false) goto L19;
        String r3 = r1.group();     // Catch: Throwable -> L20
        if (r3 == null) goto L4;
        List r13 = StringsKt.split$default(StringsKt.removeSuffix(StringsKt.removePrefix(r3, "${"), "}"), new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L20
        if (r13.size() != 2) goto L4;
        String r4 = (String) ListProtector.get(r13, 0);     // Catch: Throwable -> L20
        if (r4.hashCode() != 107944136) goto L4;
        if (r4.equals("query") == false) goto L4;
        if (r12 == null) goto L4;
        String r5 = UriProtector.getQueryParameter(r12, (String) ListProtector.get(r13, 1));     // Catch: Throwable -> L20
        if (r5 == null) goto L4;
        r2 = StringsKt.replace$default(r2, r3, r5, false, 4, null);     // Catch: Throwable -> L20
        goto L4
    L19:
        return r2;
    L20:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public static void b(String r4, Map r5, Context r6, Function1 r7) {
        JsonElement r8 = (JsonElement) r7.invoke(r4);
        String r0 = null;
        if (r8 != null) goto L5;
    L17:
        String r9 = null;
    L18:
        boolean r1 = true;
        if (r9 != null) goto L21;
    L24:
        boolean r3 = true;
    L25:
        if (r3 == true) goto L55;
    L45:
        if (r9 != null) goto L47;
        return;
    L47:
        if (r9.length() > 0) goto L50;
        r1 = false;
    L50:
        if (r1 == false) goto L52;
        r0 = r9;
    L52:
        if (r0 == null) goto L58;
        r5.put(r4, GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r0, new a().getType()));
        return;
    L58:
        return;
    L55:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L42
        if (r6 == null) goto L44;
        SharedPreferences r12 = r6.getSharedPreferences("xbridge-storage", 0);     // Catch: Throwable -> L42
        if (r12 == null) goto L44;
        if (r12.contains(r4) == false) goto L44;
        String r13 = r12.getString(r4, null);     // Catch: Throwable -> L42
        if (r13 == null) goto L44;
        Map r14 = (Map) JsonUtil.parse(r13, Map.class);     // Catch: Throwable -> L42
        if (r14 == null) goto L44;
        r9 = Uri.decode((String) r14.get("value"));     // Catch: Throwable -> L42
    L44:
        r9 = null;
    L42:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L21:
        if (r9.length() == 0) goto L24;
        r3 = false;
        goto L25
    L5:
        if ((r8 instanceof JsonObject) == true) goto L8;
        r8 = null;
    L8:
        if (r8 == null) goto L17;
        JsonPrimitive r16 = ((JsonObject) r8).getAsJsonPrimitive(r4);
        if (r16 == null) goto L17;
        if (r16.isString() == true) goto L15;
        r16 = null;
    L15:
        if (r16 == null) goto L17;
        r9 = r16.getAsString();
        goto L18
    }

    public static void c(boolean r11, boolean r12, String r13, String r14, Function2 r15) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        int r2 = x8.a.a;     // Catch: Throwable -> L14
        x8.a.d("CacheParamUtil", "prefetch_data: " + r11 + ", storage_data: " + r12, false);     // Catch: Throwable -> L14
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L14
        if (r11 == false) goto L6;
        String r16 = "only_prefetch";
    L9:
        r0.put("injectState", r16);     // Catch: Throwable -> L14
        if (r14 == null) goto L12;
        r0.put("failedCause", r14);     // Catch: Throwable -> L14
    L12:
        LiveTracingMonitor.c("ttlive_inject_data_to_props", LiveTracingMonitor.EventModule.hybrid, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, "", r0, null, null);     // Catch: Throwable -> L14
        r15.invoke(r13, r0);     // Catch: Throwable -> L14
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L6:
        if (r12 == false) goto L8;
        r16 = "only_storage";
        goto L9
    L8:
        r16 = "null";
    L14:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
