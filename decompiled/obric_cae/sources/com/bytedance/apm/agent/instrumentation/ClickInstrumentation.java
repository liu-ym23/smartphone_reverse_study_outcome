package com.bytedance.apm.agent.instrumentation;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import defpackage.c;
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
    public static void onClick(View r8) {
        if (r8 != null) goto L45;
        return;
    L45:
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L42
        Resources r11 = r8.getContext().getResources();     // Catch: Exception -> L42
        if (r8.getId() == (-1)) goto L9;
        r10.put(VIEW_ID, r8.getId());     // Catch: Exception -> L42
        r10.put(VIEW_NAME, r11.getResourceEntryName(r8.getId()));     // Catch: Exception -> L42
    L9:
        if ((r8 instanceof TextView) == false) goto L17;
        CharSequence r12 = ((TextView) r8).getText();     // Catch: Exception -> L42
        if (r12 == null) goto L17;
        String r13 = r12.toString();     // Catch: Exception -> L42
        if (r13.length() <= 100) goto L15;
        r13 = r13.substring(0, 100);     // Catch: Exception -> L42
    L15:
        r10.put(VIEW_TEXT, r13);     // Catch: Exception -> L42
    L17:
        if (r8.getParent() == null) goto L23;
        String r14 = r8.getParent().getClass().getSimpleName();     // Catch: Exception -> L42
        if (r8.getParent().getParent() == null) goto L21;
        r14 = r8.getParent().getParent().getClass().getSimpleName() + "#" + r14 + "#" + r8.getClass().getSimpleName();     // Catch: Exception -> L42
    L21:
        r10.put("view_path", r14);     // Catch: Exception -> L42
    L23:
        if (r8.getTag(-16777215) == null) goto L28;
        if (TextUtils.isEmpty(r8.getTag(-16777215).toString()) == true) goto L28;
        r10.put("view_tag_1", r8.getTag(-16777215).toString());     // Catch: Exception -> L42
    L28:
        if (r8.getTag(-16777214) == null) goto L33;
        if (TextUtils.isEmpty(r8.getTag(-16777214).toString()) == true) goto L33;
        r10.put("view_tag_2", r8.getTag(-16777214).toString());     // Catch: Exception -> L42
    L33:
        if (r8.getTag(-16777213) != null) goto L35;
    L40:
        r10.put(CLICK_TYPE, "View#OnClick");     // Catch: Exception -> L42
        c.T(r10, ACTION_NAME, "");     // Catch: Exception -> L42
        return;
    L35:
        if ((r8.getTag(-16777213) instanceof Map) == false) goto L40;
        Iterator r15 = ((Map) r8.getTag(-16777213)).entrySet().iterator();     // Catch: Exception -> L42
    L38:
        if (r15.hasNext() == false) goto L40;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: Exception -> L42
        r10.put("view_tag_map_" + r16.getKey().toString(), r16.getValue().toString());     // Catch: Exception -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
    }

    @Keep
    public static void onTabChanged(String r8) {
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L4
        r10.put(VIEW_NAME, r8);     // Catch: Exception -> L4
        r10.put(CLICK_TYPE, "TabHost#OnTabChanged");     // Catch: Exception -> L4
        c.T(r10, ACTION_NAME, "");     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
