package com.bytedance.apm.agent.instrumentation;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.util.HashSet;
import org.json.JSONObject;
import t2.b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ActivityInstrumentation {
    private static final String TAG = "ActivityInstrumentation";
    static boolean isFirstWindowFocusChanged = false;
    private static String sActivityName;
    private static HashSet<String> sMethodSet;
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnWindowFocusedChangeStart;

    static {
        sMethodSet = new HashSet(32);
    }

    public ActivityInstrumentation() {
    }

    public static boolean isValid(String r8) {
        if (TextUtils.isEmpty(sActivityName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r8, sActivityName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onTrace(String r10, String r11, boolean r12) {
        if (TextUtils.equals("onCreate", r11) == false) goto L13;
        if (r12 == false) goto L9;
        sActivityName = r10;
        sOnCreateStart = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L49;
        AppInstrumentation.launcherActivityOnCreateStart(sActivityName);
        return;
    L49:
        return;
    L9:
        if (isValid(r10) == false) goto L51;
        sOnCreateEnd = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L52;
        AppInstrumentation.launcherActivityOnCreateEnd();
        return;
    L52:
        return;
    L51:
        return;
    L13:
        boolean r8 = true;
        if (TextUtils.equals("onResume", r11) == false) goto L29;
        if (isValid(r10) == false) goto L29;
        long r13 = sOnCreateStart;
        if (r12 == false) goto L24;
        if (r13 <= 0) goto L54;
        sOnResumeStart = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L23;
        AppInstrumentation.launcherActivityOnResumeStart(sActivityName);
    L23:
        b.L(sActivityName, true);
        return;
    L54:
        return;
    L24:
        if (r13 <= 0) goto L56;
        sOnResumeEnd = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L57;
        AppInstrumentation.launcherActivityOnResumeEnd();
        return;
    L57:
        return;
    L56:
        return;
    L29:
        if (TextUtils.equals("onWindowFocusChanged", r11) == true) goto L31;
        return;
    L31:
        if (isValid(r10) == true) goto L33;
        return;
    L33:
        if (sOnCreateStart > 0) goto L35;
        return;
    L35:
        if (isFirstWindowFocusChanged == true) goto L37;
        AppInstrumentation.launcherActivityOnWindowFocusChangedStart(sActivityName);
        isFirstWindowFocusChanged = true;
    L37:
        long r14 = System.currentTimeMillis();
        sOnWindowFocusedChangeStart = r14;
        if ((r14 - sOnCreateStart) < 5000) goto L47;
    L44:
        sOnCreateStart = 0;
        sActivityName = null;
        return;
    L47:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L46
        r15.put("begin_time", sOnCreateStart);     // Catch: Exception -> L46
        r15.put("end_time", sOnWindowFocusedChangeStart);     // Catch: Exception -> L46
        r15.put("page_type", "activity");     // Catch: Exception -> L46
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L46
        r16.put("onCreate", sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L46
        r16.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L46
        r16.put("activityOnCreateToWindowFocusChanged", sOnWindowFocusedChangeStart - sOnCreateStart);     // Catch: Exception -> L46
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L46
        r17.put("scene", sActivityName);     // Catch: Exception -> L46
        if (sMethodSet.contains(sActivityName + r11) == false) goto L43;
        r8 = false;
    L43:
        r17.put("is_first", r8);     // Catch: Exception -> L46
        sMethodSet.add(sActivityName + r11);     // Catch: Exception -> L46
        b3.b.C0032b.f3038a.c(new e2.b("page_load", r16, r17, r15));     // Catch: Exception -> L46
        goto L44
    }
}
