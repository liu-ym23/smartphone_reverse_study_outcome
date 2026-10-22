package com.bytedance.apm.agent.instrumentation;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class ClickInstrumentation {
    private static final String ACTION_NAME = "view_click";
    private static final String CLICK_TYPE = "click_type";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_NAME = "view_name";
    private static final String VIEW_TEXT = "view_text";
    private static final int VIEW_TEXT_LENGTH_LIMIT = 100;

    public ClickInstrumentation() {
    }

    @Keep
    public static void onClick(View r5) {
        if (r5 != null) goto L46;
        return;
    L46:
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L8
        Resources r11 = r5.getContext().getResources();     // Catch: Exception -> L8
        if (r5.getId() == (-1)) goto L11;
        r10.put(VIEW_ID, r5.getId());     // Catch: Exception -> L8
        r10.put(VIEW_NAME, r11.getResourceEntryName(r5.getId()));     // Catch: Exception -> L8
    L11:
        if ((r5 instanceof TextView) == false) goto L19;
        CharSequence r12 = ((TextView) r5).getText();     // Catch: Exception -> L8
        if (r12 == null) goto L19;
        String r13 = r12.toString();     // Catch: Exception -> L8
        if (r13.length() <= 100) goto L17;
        r13 = r13.substring(0, 100);     // Catch: Exception -> L8
    L17:
        r10.put(VIEW_TEXT, r13);     // Catch: Exception -> L8
    L19:
        if (r5.getParent() == null) goto L25;
        String r14 = r5.getParent().getClass().getSimpleName();     // Catch: Exception -> L8
        if (r5.getParent().getParent() == null) goto L23;
        r14 = r5.getParent().getParent().getClass().getSimpleName() + "#" + r14 + "#" + r5.getClass().getSimpleName();     // Catch: Exception -> L8
    L23:
        r10.put("view_path", r14);     // Catch: Exception -> L8
    L25:
        if (r5.getTag(-16777215) == null) goto L30;
        if (TextUtils.isEmpty(r5.getTag(-16777215).toString()) == true) goto L30;
        r10.put("view_tag_1", r5.getTag(-16777215).toString());     // Catch: Exception -> L8
    L30:
        if (r5.getTag(-16777214) == null) goto L35;
        if (TextUtils.isEmpty(r5.getTag(-16777214).toString()) == true) goto L35;
        r10.put("view_tag_2", r5.getTag(-16777214).toString());     // Catch: Exception -> L8
    L35:
        if (r5.getTag(-16777213) != null) goto L37;
    L42:
        r10.put(CLICK_TYPE, "View#OnClick");     // Catch: Exception -> L8
        f4.a.k(ACTION_NAME, "", r10);     // Catch: Exception -> L8
        return;
    L37:
        if ((r5.getTag(-16777213) instanceof Map) == false) goto L42;
        Iterator r15 = ((Map) r5.getTag(-16777213)).entrySet().iterator();     // Catch: Exception -> L8
    L40:
        if (r15.hasNext() == false) goto L42;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: Exception -> L8
        r10.put("view_tag_map_" + r16.getKey().toString(), r16.getValue().toString());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Keep
    public static void onTabChanged(String r5) {
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L4
        r10.put(VIEW_NAME, r5);     // Catch: Exception -> L4
        r10.put(CLICK_TYPE, "TabHost#OnTabChanged");     // Catch: Exception -> L4
        f4.a.k(ACTION_NAME, "", r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
