package com.larksuite.component.card.monitor;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.card.settings.LynxCardCommonConfig;
import com.larksuite.component.card.utils.e;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    @JvmStatic
    public static final void a(String r9, String r10, UniversalCardMonitorData r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter("", "templateId");
        b(r9, "interaction", r10, r11, r12, "", r13, null, 128);
    }

    public static JSONArray e(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L8;
        Uri r6 = UriProtector.parse(r5);
        if (TextUtils.isEmpty(r6.getEncodedPath()) == true) goto L8;
        String r7 = String.valueOf(r6.getEncodedPath());
    L9:
        int r1 = 0;
        List r8 = new Regex("/").split(r7, 0);
        if (r8.isEmpty() == true) goto L20;
        ListIterator r0 = r8.listIterator(r8.size());
    L13:
        if (r0.hasPrevious() == false) goto L20;
        if (((String) r0.previous()).length() != 0) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L13;
        List r9 = CollectionsKt.take(r8, r0.nextIndex() + 1);
    L21:
        String[] r10 = (String[]) r9.toArray(new String[0]);
        ArrayList r3 = new ArrayList();
        int r4 = r10.length;
    L22:
        if (r1 >= r4) goto L28;
        String r11 = r10[r1];
        if (TextUtils.isEmpty(r11) == true) goto L26;
        r3.add(e.b(r11));
    L26:
        r1 = r1 + 1;
        goto L22
    L28:
        return new JSONArray(r3);
    L17:
        r2 = false;
    L20:
        r9 = CollectionsKt.emptyList();
    L8:
        r7 = "";
        goto L9
    }

    public static String f(String r9, LynxCardCommonConfig r10) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return "";
    L5:
        Uri r11 = UriProtector.parse(r9);
        Set r0 = UriProtector.getQueryParameterNames(r11);
        if (CollectionUtils.isEmpty(r0) == false) goto L8;
        return "";
    L8:
        StringBuilder r1 = new StringBuilder();
        Iterator r2 = r0.iterator();
    L9:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L28;
        String r4 = (String) r2.next();
        if (TextUtils.isEmpty(r4) == true) goto L9;
        Intrinsics.checkNotNull(r4);
        JSONArray r5 = r10.blackMonitorQueryKey;
        if (r5 == null) goto L21;
        int r6 = r5.length();
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L21;
        if (JSONArrayProtectorUtils.getString(r5, r7).equals(r4) == true) goto L22;
        r7 = r7 + 1;
    L22:
        if (r3 == true) goto L9;
        r1.append(e.b(r4));
        r1.append("=");
        String r8 = UriProtector.getQueryParameter(r11, r4);
        if (TextUtils.isEmpty(r8) == true) goto L26;
        r1.append(e.b(r8));
    L26:
        r1.append("&");
    L21:
        r3 = false;
        goto L22
    L28:
        if (r1.length() <= 1) goto L31;
        r1.deleteCharAt(r1.length() - 1);
    L31:
        return r1.toString();
    }

    @JvmStatic
    public static final void d(String r3, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        JSONObject r1 = new JSONObject();
        r1.put("scene", r3);     // Catch: JSONException -> L5
        r1.put(CardActionService.CARD_ID, r4 + '#' + r5);     // Catch: JSONException -> L5
        r1.put("biz_id", r4);     // Catch: JSONException -> L5
        r1.put("streaming_mode", r6);     // Catch: JSONException -> L5
    L7:
        Statistics.sendEvent("openplatform_universal_card_view", r1);
        return;
    L5:
        e = move-exception;
        Log.e("CardStatisticsUtil", "card action click statistics args fail", e);
        goto L7
    }

    public static void c(String r8, String r9, String r10, UniversalCardMonitorData r11, String r12) {
        String r2 = "";
        Intrinsics.checkNotNullParameter("", "templateId");
        JSONObject r1 = new JSONObject();
        r1.put("click", "message_card");     // Catch: Exception -> L39
        r1.put("target", "none");     // Catch: Exception -> L39
        r1.put(CardActionService.CARD_ID, r12 + '#' + r8);     // Catch: Exception -> L39
        r1.put("click_element", r9);     // Catch: Exception -> L39
        r1.put("element_type", r9);     // Catch: Exception -> L39
        r1.put("action_type", "open_link");     // Catch: Exception -> L39
        if (r11 == null) goto L11;
        Map<String, Object> r13 = r11.getBusinessMonitorMap();     // Catch: Exception -> L39
        if (r13 == null) goto L11;
        Iterator<Map.Entry<String, Object>> r14 = r13.entrySet().iterator();     // Catch: Exception -> L39
    L9:
        if (r14.hasNext() == false) goto L11;
        Map.Entry<String, Object> r15 = r14.next();     // Catch: Exception -> L39
        r1.put(r15.getKey(), r15.getValue());     // Catch: Exception -> L39
    L11:
        r1.put("biz_id", r12);     // Catch: Exception -> L39
        r1.put("template_id", "");     // Catch: Exception -> L39
        if (TextUtils.isEmpty(r10) == true) goto L18;
        Uri r16 = UriProtector.parse(r10);     // Catch: Exception -> L39
        if (TextUtils.isEmpty(r16.getAuthority()) == true) goto L18;
        r2 = r16.getAuthority();     // Catch: Exception -> L39
    L18:
        if (TextUtils.isEmpty(r2) == false) goto L20;
        Log.w("CardStatisticsUtil", "open url host is null");     // Catch: Exception -> L39
        return;
    L20:
        LynxCardCommonConfig r17 = (LynxCardCommonConfig) SettingManager.getInstance().get(LynxCardCommonConfig.class);     // Catch: Exception -> L39
        JSONArray r19 = r17.trackDomains;     // Catch: Exception -> L39
        boolean r110 = false;
        if (r19 == null) goto L31;
        int r111 = r19.length();     // Catch: Exception -> L39
        int r3 = 0;
        boolean r4 = false;
    L23:
        if (r3 >= r111) goto L30;
        String r5 = JSONArrayProtectorUtils.getString(r19, r3);     // Catch: Exception -> L39
        if (r2 == null) goto L29;
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L39
        if (StringsKt.endsWith$default(r2, r5, false, 2, null) == false) goto L29;
        r4 = true;
    L29:
        r3 = r3 + 1;     // Catch: Exception -> L39
        goto L23
    L30:
        r110 = r4;
    L31:
        if (r110 == false) goto L41;
        r1.put("url_domain", r2);     // Catch: Exception -> L39
        JSONArray r20 = e(r10);     // Catch: Exception -> L39
        if (r20.length() == 0) goto L35;
        r1.put("url_path", r20);     // Catch: Exception -> L39
    L35:
        String r21 = f(r10, r17);     // Catch: Exception -> L39
        if (TextUtils.isEmpty(r21) == true) goto L41;
        r1.put("url_query", r21);     // Catch: Exception -> L39
    L41:
        Statistics.sendEvent("openplatform_universal_card_click", r1);
        return;
    L39:
        e = move-exception;
        Log.e("CardStatisticsUtil", "card action click statistics args fail", e);
        goto L41
    }

    public static void b(String r3, String r4, String r5, UniversalCardMonitorData r6, String r7, String r8, boolean r9, Map r10, int r11) {
        if ((r11 & 32) == 0) goto L6;
        r8 = "";
    L6:
        if ((r11 & 64) == 0) goto L9;
        r9 = false;
    L9:
        if ((r11 & 128) == 0) goto L11;
        r10 = null;
    L11:
        Intrinsics.checkNotNullParameter(r8, "templateId");
        JSONObject r12 = new JSONObject();
        r12.put("click", "message_card");     // Catch: JSONException -> L29
        r12.put(CardActionService.CARD_ID, r7 + '#' + r3);     // Catch: JSONException -> L29
        r12.put("target", "none");     // Catch: JSONException -> L29
        r12.put("click_element", r5);     // Catch: JSONException -> L29
        r12.put("element_type", r5);     // Catch: JSONException -> L29
        r12.put("action_type", r4);     // Catch: JSONException -> L29
        if (r6 == null) goto L20;
        Map<String, Object> r13 = r6.getBusinessMonitorMap();     // Catch: JSONException -> L29
        if (r13 == null) goto L20;
        Iterator<Map.Entry<String, Object>> r14 = r13.entrySet().iterator();     // Catch: JSONException -> L29
    L18:
        if (r14.hasNext() == false) goto L20;
        Map.Entry<String, Object> r15 = r14.next();     // Catch: JSONException -> L29
        r12.put(r15.getKey(), r15.getValue());     // Catch: JSONException -> L29
    L20:
        if (r7 == null) goto L22;
        r12.put("biz_id", r7);     // Catch: JSONException -> L29
    L22:
        r12.put("template_id", r8);     // Catch: JSONException -> L29
        r12.put("streaming_mode", r9);     // Catch: JSONException -> L29
        if (r10 == null) goto L31;
        Iterator r16 = r10.entrySet().iterator();     // Catch: JSONException -> L29
    L25:
        if (r16.hasNext() == false) goto L31;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: JSONException -> L29
        r12.put((String) r17.getKey(), r17.getValue());     // Catch: JSONException -> L29
    L31:
        Statistics.sendEvent("openplatform_universal_card_click", r12);
        return;
    L29:
        e = move-exception;
        Log.e("CardStatisticsUtil", "card action click statistics args fail", e);
        goto L31
    }
}
