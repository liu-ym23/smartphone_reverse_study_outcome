package com.bytedance.apm.agent.instrumentation;

import android.text.TextUtils;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.apm.e;
import com.lynx.tasm.behavior.ui.utils.p;
import java.util.HashSet;
import org.json.JSONObject;
import z6.b;

/* JADX INFO: loaded from: classes2.dex */
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

    public static boolean isValid(String r5) {
        if (TextUtils.isEmpty(sActivityName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r5, sActivityName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onTrace(String r10, String r11, boolean r12) {
        if (TextUtils.equals("onCreate", r11) == false) goto L14;
        if (r12 == false) goto L9;
        sActivityName = r10;
        sOnCreateStart = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L46;
        AppInstrumentation.launcherActivityOnCreateStart(sActivityName);
        return;
    L46:
        return;
    L9:
        if (isValid(r10) == false) goto L48;
        sOnCreateEnd = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L49;
        AppInstrumentation.launcherActivityOnCreateEnd();
        return;
    L49:
        return;
    L48:
        return;
    L14:
        if (TextUtils.equals("onResume", r11) == false) goto L30;
        if (isValid(r10) == false) goto L30;
        if (r12 == false) goto L25;
        if (sOnCreateStart <= 0) goto L51;
        sOnResumeStart = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L23;
        AppInstrumentation.launcherActivityOnResumeStart(sActivityName);
    L23:
        p.A(sActivityName, true);
        return;
    L51:
        return;
    L25:
        if (sOnCreateStart <= 0) goto L53;
        sOnResumeEnd = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L54;
        AppInstrumentation.launcherActivityOnResumeEnd();
        return;
    L54:
        return;
    L53:
        return;
    L30:
        if (TextUtils.equals("onWindowFocusChanged", r11) == true) goto L32;
        return;
    L32:
        if (isValid(r10) == true) goto L34;
        return;
    L34:
        if (sOnCreateStart > 0) goto L36;
        return;
    L36:
        if (isFirstWindowFocusChanged == true) goto L38;
        AppInstrumentation.launcherActivityOnWindowFocusChangedStart(sActivityName);
        isFirstWindowFocusChanged = true;
    L38:
        long r13 = System.currentTimeMillis();
        sOnWindowFocusedChangeStart = r13;
        if ((r13 - sOnCreateStart) < 5000) goto L44;
    L41:
        sOnCreateStart = 0;
        sActivityName = null;
        return;
    L44:
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L43
        r14.put("begin_time", sOnCreateStart);     // Catch: Exception -> L43
        r14.put(Constant.UPLOAD_END_TIME, sOnWindowFocusedChangeStart);     // Catch: Exception -> L43
        r14.put("page_type", "activity");     // Catch: Exception -> L43
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L43
        r15.put("onCreate", sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L43
        r15.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L43
        r15.put("activityOnCreateToWindowFocusChanged", sOnWindowFocusedChangeStart - sOnCreateStart);     // Catch: Exception -> L43
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L43
        r5.put("scene", sActivityName);     // Catch: Exception -> L43
        r5.put("is_first", !sMethodSet.contains(sActivityName + r11));     // Catch: Exception -> L43
        sMethodSet.add(sActivityName + r11);     // Catch: Exception -> L43
        b.f23409a.d(new e("page_load", r15, r5, r14));     // Catch: Exception -> L43
        goto L41
    }
}
