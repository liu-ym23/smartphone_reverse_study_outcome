package com.larus.bmhome.utils;

import com.larus.im.bean.message.Message;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Message r2) {
        if (r2 == null) goto L21;
        Map r3 = r2.getExt();
        if (r3 == null) goto L21;
        String r4 = (String) r3.get("action_bar_instruction");
        if (r4 == null) goto L21;
        int r5 = new JSONObject(r4).optInt("instruction_type");
        if (r5 != 12) goto L11;
        return "essay_report";
    L11:
        if (r5 != 13) goto L13;
        return "oral_calculation";
    L13:
        if (r5 == 29) goto L15;
        return "qa_take_photos";
    L15:
        return "check";
    L21:
        return "qa_take_photos";
    }

    public static boolean b(String r0) {
        if (r0 != null) goto L4;
        return false;
    L4:
        if (i.g(r0) == false) goto L10;
        return com.larus.platform.service.z2.a.getEduIntentionCameraConfig().a();
    L10:
        return com.larus.platform.service.z2.a.getEduIntentionCameraConfig().c();
    }
}
