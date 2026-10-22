package com.bytedance.apm.agent.instrumentation;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.apm.agent.c.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ClickInstrumentation {
    private static final String ACTION_NAME = "view_click";
    private static final String CLICK_TYPE = "click_type";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_NAME = "view_name";
    private static final String VIEW_TEXT = "view_text";
    private static final int VIEW_TEXT_LENGTH_LIMIT = 100;

    public ClickInstrumentation() {
    }

    public static void onClick(View r6) {
        if (r6 != null) goto L45;
        return;
    L45:
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L42
        Resources r3 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Exception -> L42
        if (r6.getId() == (-1)) goto L9;
        r2.put(VIEW_ID, r6.getId());     // Catch: Exception -> L42
        r2.put(VIEW_NAME, r3.getResourceEntryName(r6.getId()));     // Catch: Exception -> L42
    L9:
        if (ZeusTransformUtils.instanceOf(r6, TextView.class) == false) goto L17;
        CharSequence r4 = ((TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin")).getText();     // Catch: Exception -> L42
        if (r4 == null) goto L17;
        String r5 = r4.toString();     // Catch: Exception -> L42
        if (r5.length() <= 100) goto L15;
        r5 = r5.substring(0, 100);     // Catch: Exception -> L42
    L15:
        r2.put(VIEW_TEXT, r5);     // Catch: Exception -> L42
    L17:
        if (r6.getParent() == null) goto L23;
        String r7 = r6.getParent().getClass().getSimpleName();     // Catch: Exception -> L42
        if (r6.getParent().getParent() == null) goto L21;
        r7 = r6.getParent().getParent().getClass().getSimpleName() + "#" + r7 + "#" + r6.getClass().getSimpleName();     // Catch: Exception -> L42
    L21:
        r2.put("view_path", r7);     // Catch: Exception -> L42
    L23:
        if (r6.getTag(-16777215) == null) goto L28;
        if (TextUtils.isEmpty(r6.getTag(-16777215).toString()) == true) goto L28;
        r2.put("view_tag_1", r6.getTag(-16777215).toString());     // Catch: Exception -> L42
    L28:
        if (r6.getTag(-16777214) == null) goto L33;
        if (TextUtils.isEmpty(r6.getTag(-16777214).toString()) == true) goto L33;
        r2.put("view_tag_2", r6.getTag(-16777214).toString());     // Catch: Exception -> L42
    L33:
        if (r6.getTag(-16777213) != null) goto L35;
    L40:
        r2.put(CLICK_TYPE, "View#OnClick");     // Catch: Exception -> L42
        a.a(ACTION_NAME, "", r2);     // Catch: Exception -> L42
        return;
    L35:
        if (ZeusTransformUtils.instanceOf(r6.getTag(-16777213), Map.class) == false) goto L40;
        Iterator r8 = ((Map) ZeusTransformUtils.preCheckCast(r6.getTag(-16777213), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();     // Catch: Exception -> L42
    L38:
        if (r8.hasNext() == false) goto L40;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L42
        r2.put("view_tag_map_" + r0.getKey().toString(), r0.getValue().toString());     // Catch: Exception -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
    }

    public static void onTabChanged(String r2) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put(VIEW_NAME, r2);     // Catch: Exception -> L4
        r0.put(CLICK_TYPE, "TabHost#OnTabChanged");     // Catch: Exception -> L4
        a.a(ACTION_NAME, "", r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
