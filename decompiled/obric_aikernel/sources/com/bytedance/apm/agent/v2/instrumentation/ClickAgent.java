package com.bytedance.apm.agent.v2.instrumentation;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.bytedance.apm.d;
import f.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ClickAgent {
    private static final String ACTION_NAME = "view_click";
    private static final String CLICK_TYPE = "click_type";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_NAME = "view_name";
    private static final String VIEW_TEXT = "view_text";
    private static final int VIEW_TEXT_LENGTH_LIMIT = 100;

    public ClickAgent() {
    }

    @Keep
    public static void onClick(View r10) {
        if (r10 != null) goto L29;
        return;
    L29:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L24
        Resources r12 = r10.getContext().getResources();     // Catch: Exception -> L24
        if (r10.getId() == (-1)) goto L9;
        r11.put(VIEW_ID, r10.getId());     // Catch: Exception -> L24
        r11.put(VIEW_NAME, r12.getResourceEntryName(r10.getId()));     // Catch: Exception -> L24
    L9:
        if ((r10 instanceof TextView) == false) goto L17;
        CharSequence r13 = ((TextView) r10).getText();     // Catch: Exception -> L24
        if (r13 == null) goto L17;
        String r14 = r13.toString();     // Catch: Exception -> L24
        if (r14.length() <= 100) goto L15;
        r14 = r14.substring(0, 100);     // Catch: Exception -> L24
    L15:
        r11.put(VIEW_TEXT, r14);     // Catch: Exception -> L24
    L17:
        if (r10.getParent() == null) goto L22;
        String r15 = r10.getParent().getClass().getSimpleName();     // Catch: Exception -> L24
        if (r10.getParent().getParent() == null) goto L21;
        r15 = r10.getParent().getParent().getClass().getSimpleName() + "#" + r15 + "#" + r10.getClass().getSimpleName();     // Catch: Exception -> L24
    L21:
        r11.put("view_path", r15);     // Catch: Exception -> L24
    L22:
        r11.put(CLICK_TYPE, "View#OnClick");     // Catch: Exception -> L24
        a.c(ACTION_NAME, "", r11);     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        if (d.D() == false) goto L31;
        e.printStackTrace();
        return;
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
