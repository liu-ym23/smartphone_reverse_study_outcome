package u7a;

import android.text.TextUtils;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static void b(final LynxContext r17, final String r18, final boolean r19, final boolean r20, final long r21, long r23, final int r25, final JSONObject r26) {
        if (TextUtils.isEmpty(r18) == false) goto L6;
        return;
    L6:
        if (r21 > 0) goto L8;
        return;
    L8:
        if (r23 <= 0) goto L13;
        final long r7 = r23 - r21;
        final long r11 = System.currentTimeMillis();
        final long r9 = r11 - r21;
        LynxThreadPool.b().execute(new e(r17, r18, r19, r20, r21, r7, r9, r11, r25, r26));
        return;
    }

    public static JSONObject a(LynxContext r22, String r23, boolean r24, boolean r25, long r26, long r28, long r30, long r32, int r34, JSONObject r35) {
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L41
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L41
        r8.put("fetchTime", r28 / 1000.0d);     // Catch: Exception -> L41
        r8.put("completeTime", r30 / 1000.0d);     // Catch: Exception -> L41
        r8.put("fetchTimeStamp", r26);     // Catch: Exception -> L41
        r8.put("finishTimeStamp", r32);     // Catch: Exception -> L41
        r7.put("timeMetrics", r8);     // Catch: Exception -> L41
        if (r22 == null) goto L6;
        LynxView r9 = r22.getLynxView();     // Catch: Exception -> L41
    L7:
        if (r9 == null) goto L31;
        String r10 = r9.getTemplateUrl();     // Catch: Exception -> L41
        if (TextUtils.isEmpty(r10) == false) goto L11;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L41
        r11.put(LynxEventReporter.PROP_NAME_URL, r10);     // Catch: Exception -> L41
        if (r35 == null) goto L30;
        long r12 = r35.optLong("viewWidth");     // Catch: Exception -> L41
        long r13 = r35.optLong("viewHeight");     // Catch: Exception -> L41
        long r14 = r35.optLong("width");     // Catch: Exception -> L41
        long r16 = r35.optLong("height");     // Catch: Exception -> L41
        if (r12 > 0) goto L17;
        r12 = -1;
    L17:
        r11.put("viewWidth", r12);     // Catch: Exception -> L41
        if (r13 > 0) goto L21;
        r13 = -1;
    L21:
        r11.put("viewHeight", r13);     // Catch: Exception -> L41
        if (r14 > 0) goto L25;
        r14 = -1;
    L25:
        r11.put("width", r14);     // Catch: Exception -> L41
        if (r16 <= 0) goto L28;
        long r3 = r16;
    L29:
        r11.put("height", r3);     // Catch: Exception -> L41
        r11.put("flattenAnim", r35.optInt("isFlattenAnim"));     // Catch: Exception -> L41
        r11.put("config", r35.optString("config"));     // Catch: Exception -> L41
        goto L30
    L28:
        r3 = -1;
    L30:
        r7.put("metric", r11);     // Catch: Exception -> L41
    L31:
        r7.put("image_url", r23);     // Catch: Exception -> L41
        int r1 = 1;
        if (r24 == false) goto L34;
        int r4 = 1;
    L35:
        r7.put("successRate", r4);     // Catch: Exception -> L41
        r7.put("memoryCost", r34);     // Catch: Exception -> L41
        if (r25 == true) goto L39;
        r1 = 0;
    L39:
        r7.put("resourceFromMemoryCache", r1);     // Catch: Exception -> L41
        return r7;
    L34:
        r4 = 0;
        goto L35
    L6:
        r9 = null;
    L41:
        return null;
    }

    public static void c(LynxContext r3, String r4, int r5, boolean r6, int r7, long r8, long r10, boolean r12, int r13, int r14, Map<String, String> r15) {
        if (r3 != null) goto L10;
        return;
    L10:
        HashMap r0 = new HashMap();     // Catch: Exception -> L9
        r0.put("load_start", Long.valueOf(r8));     // Catch: Exception -> L9
        r0.put("load_finish", Long.valueOf(r10));     // Catch: Exception -> L9
        r0.put("cost", Long.valueOf(r10 - r8));     // Catch: Exception -> L9
        r0.put(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, r4);     // Catch: Exception -> L9
        r0.put("memory", Boolean.valueOf(r6));     // Catch: Exception -> L9
        r0.put("origin", Integer.valueOf(r7));     // Catch: Exception -> L9
        r0.put("error_code", Integer.valueOf(r5));     // Catch: Exception -> L9
        r0.put("flatten", Boolean.valueOf(r12));     // Catch: Exception -> L9
        r0.put("width", Integer.valueOf(r13));     // Catch: Exception -> L9
        r0.put("height", Integer.valueOf(r14));     // Catch: Exception -> L9
        if (r15 == null) goto L7;
        r0.putAll(r15);     // Catch: Exception -> L9
    L7:
        LynxEventReporter.onEvent("lynxsdk_image_event", r0, r3.getInstanceId());     // Catch: Exception -> L9
        return;
    }
}
