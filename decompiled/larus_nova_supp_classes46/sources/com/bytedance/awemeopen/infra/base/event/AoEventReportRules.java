package com.bytedance.awemeopen.infra.base.event;

import android.text.TextUtils;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class AoEventReportRules {
    private static final String ACTIONS = "actions";
    private static final double DEFAULT_RATE = 1.0d;
    private static final String EVENT_NAME_PATTERN = "event_name_pattern";
    private static final String EVENT_PARAMS_PATTERN = "event_params_pattern";
    private static final String ONLY_PARAMS = "only_params";
    private static final String REMOVE_PARAMS = "remove_params";
    private static final String RULES = "rules";
    private static final String SAMPLE_RATE = "sample_rate";
    public static String TAG = "BdpAppEventReportRules";
    private static JSONObject sEventLogReportConfig;

    public AoEventReportRules() {
    }

    private static boolean isNeedReportAfterSample(JSONObject r5) {
        if (r5 == null) goto L11;
        double r1 = r5.optDouble(SAMPLE_RATE, DEFAULT_RATE);
        if (0.0d < r1) goto L7;
    L9:
        return false;
    L7:
        if (Math.random() >= r1) goto L9;
        return true;
    L11:
        return true;
    }

    public static void setEventLogReportConfig(JSONObject r4) {
        sEventLogReportConfig = r4;
        AoLogger.g(TAG, new Object[]{"setEventLogReportConfig", r4});
    }

    public static boolean check(String r5, JSONObject r6) {
        JSONObject r0 = sEventLogReportConfig;
        if (r0 != null) goto L5;
    L27:
        return true;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L27;
        if (r6 == null) goto L27;
        JSONArray r1 = r0.optJSONArray(RULES);
        if (r1 == null) goto L27;
        int r2 = 0;
    L11:
        if (r2 >= r1.length()) goto L27;
        JSONObject r3 = r1.optJSONObject(r2);
        if (r3 == null) goto L26;
        if (ruleMatch(r3, r5, r6) == false) goto L26;
        JSONObject r4 = r3.optJSONObject(ACTIONS);
        if (r4 == null) goto L26;
        if (isNeedReportAfterSample(r4) == false) goto L34;
        String r7 = r4.optString(REMOVE_PARAMS);
        String r8 = r4.optString(ONLY_PARAMS);
        if (TextUtils.isEmpty(r7) == true) goto L24;
        processRemoveParams(r6, r7);
        goto L27
    L24:
        if (TextUtils.isEmpty(r8) == true) goto L27;
        processOnlyParams(r6, r8);
        goto L27
    L34:
        return false;
    L26:
        r2 = r2 + 1;
        goto L11
    }

    private static boolean patternMatches(String r0, CharSequence r1) {
        return Pattern.matches(r0, r1);
    L4:
        return false;
    }

    private static void processOnlyParams(JSONObject r4, String r5) {
        JSONArray r0 = r4.names();
        int r1 = 0;
    L4:
        if (r1 >= r0.length()) goto L9;
        String r2 = r0.optString(r1);
        if (patternMatches(r5, r2) == true) goto L8;
        r4.remove(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    }

    private static void processRemoveParams(JSONObject r4, String r5) {
        JSONArray r0 = r4.names();
        int r1 = 0;
    L4:
        if (r1 >= r0.length()) goto L9;
        String r2 = r0.optString(r1);
        if (patternMatches(r5, r2) == false) goto L8;
        r4.remove(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    }

    private static boolean ruleMatch(JSONObject r5, String r6, JSONObject r7) {
        String r0 = r5.optString(EVENT_NAME_PATTERN);
        if (TextUtils.isEmpty(r0) == true) goto L26;
        boolean r8 = patternMatches(r0, r6);
        if (r8 == false) goto L18;
        JSONObject r9 = r5.optJSONObject(EVENT_PARAMS_PATTERN);
        if (r9 == null) goto L18;
        Iterator<String> r1 = r9.keys();
    L10:
        if (r1.hasNext() == false) goto L18;
        String r2 = r1.next();
        String r3 = r9.optString(r2);
        if (TextUtils.isEmpty(r3) == true) goto L10;
        String r10 = r7.optString(r2);
        if (TextUtils.isEmpty(r10) == true) goto L27;
        r8 = patternMatches(r3, r10);
        if (r8 == true) goto L10;
    L27:
        return false;
    L18:
        return r8;
    L26:
        return false;
    }
}
