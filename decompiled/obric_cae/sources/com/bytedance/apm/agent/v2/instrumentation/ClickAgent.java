package com.bytedance.apm.agent.v2.instrumentation;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import c2.k;
import defpackage.c;
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
    public static void onClick(View r8) {
        if (r8 != null) goto L29;
        return;
    L29:
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L24
        Resources r11 = r8.getContext().getResources();     // Catch: Exception -> L24
        if (r8.getId() == (-1)) goto L9;
        r10.put(VIEW_ID, r8.getId());     // Catch: Exception -> L24
        r10.put(VIEW_NAME, r11.getResourceEntryName(r8.getId()));     // Catch: Exception -> L24
    L9:
        if ((r8 instanceof TextView) == false) goto L17;
        CharSequence r12 = ((TextView) r8).getText();     // Catch: Exception -> L24
        if (r12 == null) goto L17;
        String r13 = r12.toString();     // Catch: Exception -> L24
        if (r13.length() <= 100) goto L15;
        r13 = r13.substring(0, 100);     // Catch: Exception -> L24
    L15:
        r10.put(VIEW_TEXT, r13);     // Catch: Exception -> L24
    L17:
        if (r8.getParent() == null) goto L22;
        String r14 = r8.getParent().getClass().getSimpleName();     // Catch: Exception -> L24
        if (r8.getParent().getParent() == null) goto L21;
        r14 = r8.getParent().getParent().getClass().getSimpleName() + "#" + r14 + "#" + r8.getClass().getSimpleName();     // Catch: Exception -> L24
    L21:
        r10.put("view_path", r14);     // Catch: Exception -> L24
    L22:
        r10.put(CLICK_TYPE, "View#OnClick");     // Catch: Exception -> L24
        c.T(r10, ACTION_NAME, "");     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        if (k.d() == false) goto L31;
        e.printStackTrace();
        return;
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
