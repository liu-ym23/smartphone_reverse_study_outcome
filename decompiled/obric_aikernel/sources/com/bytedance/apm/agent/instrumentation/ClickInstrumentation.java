package com.bytedance.apm.agent.instrumentation;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import f.a;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
    public static void onClick(View r10) {
        if (r10 != null) goto L45;
        return;
    L45:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L42
        Resources r12 = r10.getContext().getResources();     // Catch: Exception -> L42
        if (r10.getId() == (-1)) goto L9;
        r11.put(VIEW_ID, r10.getId());     // Catch: Exception -> L42
        r11.put(VIEW_NAME, r12.getResourceEntryName(r10.getId()));     // Catch: Exception -> L42
    L9:
        if ((r10 instanceof TextView) == false) goto L17;
        CharSequence r13 = ((TextView) r10).getText();     // Catch: Exception -> L42
        if (r13 == null) goto L17;
        String r14 = r13.toString();     // Catch: Exception -> L42
        if (r14.length() <= 100) goto L15;
        r14 = r14.substring(0, 100);     // Catch: Exception -> L42
    L15:
        r11.put(VIEW_TEXT, r14);     // Catch: Exception -> L42
    L17:
        if (r10.getParent() == null) goto L23;
        String r15 = r10.getParent().getClass().getSimpleName();     // Catch: Exception -> L42
        if (r10.getParent().getParent() == null) goto L21;
        r15 = r10.getParent().getParent().getClass().getSimpleName() + "#" + r15 + "#" + r10.getClass().getSimpleName();     // Catch: Exception -> L42
    L21:
        r11.put("view_path", r15);     // Catch: Exception -> L42
    L23:
        if (r10.getTag(-16777215) == null) goto L28;
        if (TextUtils.isEmpty(r10.getTag(-16777215).toString()) == true) goto L28;
        r11.put("view_tag_1", r10.getTag(-16777215).toString());     // Catch: Exception -> L42
    L28:
        if (r10.getTag(-16777214) == null) goto L33;
        if (TextUtils.isEmpty(r10.getTag(-16777214).toString()) == true) goto L33;
        r11.put("view_tag_2", r10.getTag(-16777214).toString());     // Catch: Exception -> L42
    L33:
        if (r10.getTag(-16777213) != null) goto L35;
    L40:
        r11.put(CLICK_TYPE, "View#OnClick");     // Catch: Exception -> L42
        a.c(ACTION_NAME, "", r11);     // Catch: Exception -> L42
        return;
    L35:
        if ((r10.getTag(-16777213) instanceof Map) == false) goto L40;
        Iterator r16 = ((Map) r10.getTag(-16777213)).entrySet().iterator();     // Catch: Exception -> L42
    L38:
        if (r16.hasNext() == false) goto L40;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Exception -> L42
        r11.put("view_tag_map_" + r17.getKey().toString(), r17.getValue().toString());     // Catch: Exception -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
    }

    @Keep
    public static void onTabChanged(String r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L4
        r11.put(VIEW_NAME, r10);     // Catch: Exception -> L4
        r11.put(CLICK_TYPE, "TabHost#OnTabChanged");     // Catch: Exception -> L4
        a.c(ACTION_NAME, "", r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
