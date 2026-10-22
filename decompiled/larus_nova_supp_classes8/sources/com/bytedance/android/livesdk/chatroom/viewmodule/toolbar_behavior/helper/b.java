package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ToolbarComponentData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final Map a(Room r7) {
        if (r7 == null) goto L21;
        LiveToolbarData r4 = r7.getToolbarData();
        if (r4 == null) goto L21;
        List r5 = r4.getToolbarDataList();
        if (r5 == null) goto L21;
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L17;
        Object r8 = r6.next();
        if (((IToolbarComponentData) r8).getId() != 20) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L10;
    L18:
        IToolbarComponentData r10 = (IToolbarComponentData) r8;
        if (r10 == null) goto L21;
        String r11 = r10.getExtraData();
    L22:
        if (r11 != null) goto L24;
    L27:
        boolean r12 = true;
    L28:
        if (r12 == false) goto L48;
        if (r7 == null) goto L47;
        LiveToolbarData r13 = r7.getToolbarData();
        if (r13 == null) goto L47;
        List r14 = r13.getMorePanelDataList();
        if (r14 == null) goto L47;
        Iterator r15 = r14.iterator();
    L36:
        if (r15.hasNext() == false) goto L43;
        Object r16 = r15.next();
        if (((ToolbarComponentData) r16).getId() != 20) goto L40;
        boolean r17 = true;
    L41:
        if (r17 == false) goto L36;
    L44:
        ToolbarComponentData r18 = (ToolbarComponentData) r16;
        if (r18 == null) goto L47;
        r11 = r18.getExtraData();
        goto L48
    L40:
        r17 = false;
        goto L41
    L43:
        r16 = null;
    L47:
        r11 = null;
    L48:
        LinkedHashMap r19 = new LinkedHashMap();
        return JsonUtil.jsonObjectToMap(new JSONObject(r11));
    L51:
        e = move-exception;
        SafetyGuard.a(null, null, e.getMessage());
        return r19;
    L24:
        if (r11.length() == 0) goto L27;
        r12 = false;
        goto L28
    L14:
        r9 = false;
        goto L15
    L17:
        r8 = null;
    L21:
        r11 = null;
        goto L22
    }
}
