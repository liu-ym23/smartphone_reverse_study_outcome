package krb;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.card.settings.LynxCardCommonConfig;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import jrb.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static JSONArray c(String r4) {
        String r1 = "";
        if (TextUtils.isEmpty(r4) == true) goto L9;
        Uri r5 = UriProtector.parse(r4);
        if (TextUtils.isEmpty(r5.getEncodedPath()) == true) goto L9;
        r1 = r5.getEncodedPath();
    L9:
        if (TextUtils.isEmpty(r1) == true) goto L11;
        String[] r6 = r1.split("/");
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L14:
        if (r2 >= r6.length) goto L20;
        String r3 = r6[r2];
        if (TextUtils.isEmpty(r3) == true) goto L18;
        r0.add(e.b(r3));
    L18:
        r2 = r2 + 1;
        goto L14
    L20:
        return new JSONArray(r0);
    L11:
        return new JSONArray();
    }

    public static String d(String r9, LynxCardCommonConfig r10) {
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
        if (r2.hasNext() == false) goto L31;
        String r4 = (String) r2.next();
        if (TextUtils.isEmpty(r4) == true) goto L9;
        JSONArray r5 = r10.blackMonitorQueryKey;
        if (r5 == null) goto L24;
        int r6 = 0;
    L17:
        if (r6 >= r5.length()) goto L24;
        if (TextUtils.equals(JSONArrayProtectorUtils.getString(r5, r6), r4) == false) goto L23;
    L25:
        if (r3 == true) goto L9;
        r1.append(e.b(r4));
        r1.append("=");
        String r7 = UriProtector.getQueryParameter(r11, r4);
        if (TextUtils.isEmpty(r7) == true) goto L29;
        r1.append(e.b(r7));
    L29:
        r1.append("&");
    L23:
        r6 = r6 + 1;
    L21:
        e = move-exception;
        Log.w("CardStatisticsUtil", e);
    L24:
        r3 = false;
        goto L25
    L31:
        if (r1.length() <= 1) goto L34;
        r1.deleteCharAt(r1.length() - 1);
    L34:
        return r1.toString();
    }

    public static void a(String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("click", "message_card");     // Catch: JSONException -> L5
        r0.put("msg_id", r3);     // Catch: JSONException -> L5
        r0.put("target", "none");     // Catch: JSONException -> L5
        r0.put("click_element", r5);     // Catch: JSONException -> L5
        r0.put("action_type", r4);     // Catch: JSONException -> L5
    L7:
        Statistics.sendEvent("openplatform_im_message_card_click", r0);
        return;
    L5:
        e = move-exception;
        Log.e("CardStatisticsUtil", "card action click statistics args fail", e);
        goto L7
    }

    public static void b(String r6, String r7, String r8) {
        JSONObject r1 = new JSONObject();
        r1.put("click", "message_card");     // Catch: Exception -> L28
        r1.put("msg_id", r6);     // Catch: Exception -> L28
        r1.put("target", "none");     // Catch: Exception -> L28
        r1.put("click_element", r7);     // Catch: Exception -> L28
        r1.put("action_type", "open_link");     // Catch: Exception -> L28
        String r9 = "";
        if (TextUtils.isEmpty(r8) == true) goto L10;
        Uri r10 = UriProtector.parse(r8);     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r10.getAuthority()) == true) goto L10;
        r9 = r10.getAuthority();     // Catch: Exception -> L28
    L10:
        if (TextUtils.isEmpty(r9) == false) goto L13;
        Log.w("CardStatisticsUtil", "open url host is null");     // Catch: Exception -> L28
        return;
    L13:
        LynxCardCommonConfig r11 = (LynxCardCommonConfig) SettingManager.getInstance().get(LynxCardCommonConfig.class);     // Catch: Exception -> L28
        JSONArray r2 = r11.trackDomains;     // Catch: Exception -> L28
        int r3 = 0;
        boolean r4 = false;
    L15:
        if (r3 >= r2.length()) goto L20;
        if (r9.endsWith(JSONArrayProtectorUtils.getString(r2, r3)) == false) goto L19;
        r4 = true;
    L19:
        r3 = r3 + 1;     // Catch: Exception -> L28
        goto L15
    L20:
        if (r4 == false) goto L30;
        r1.put("url_domain", r9);     // Catch: Exception -> L28
        JSONArray r12 = c(r8);     // Catch: Exception -> L28
        if (r12.length() == 0) goto L24;
        r1.put("url_path", r12);     // Catch: Exception -> L28
    L24:
        String r13 = d(r8, r11);     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r13) == true) goto L30;
        r1.put("url_query", r13);     // Catch: Exception -> L28
    L30:
        Statistics.sendEvent("openplatform_im_message_card_click", r1);
        return;
    L28:
        e = move-exception;
        Log.e("CardStatisticsUtil", "card action click statistics args fail", e);
        goto L30
    }
}
