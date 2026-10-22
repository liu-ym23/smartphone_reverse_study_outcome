package com.ss.android.lark.compose.util;

import com.bytedance.lark.pb.basic.v1.Chat;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Chat.Type.values().length];
            r0[Chat.Type.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Chat.Type.P2P.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static void a(String r2, String r3, String r4) {
        Map<String, Object> r0 = ChatParamUtils.e();
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r5 = new JSONObject(r0).put("click", r2).put("target", r3);
        if (r4 == null) goto L8;
        r5.put("status", r4);
    L8:
        Statistics.sendEvent("im_chat_setting_click", r5);
    }

    public static void b(String r3, Chat.Type r4, boolean r5) {
        if (r4 != null) goto L4;
        int r6 = -1;
    L6:
        if (r6 != 1) goto L8;
        Pair r7 = TuplesKt.to("group_chat_setting", "group");
    L12:
        String r0 = (String) r7.component1();
        String r8 = (String) r7.component2();
        JSONObject r9 = new JSONObject().put("current_page", r0).put("chat_type", r8);
        if (r5 == false) goto L15;
        String r10 = "on";
    L16:
        Statistics.sendEvent(r3, r9.put("to_status", r10));
        return;
    L15:
        r10 = "off";
        goto L16
    L8:
        if (r6 == 2) goto L10;
        return;
    L10:
        r7 = TuplesKt.to("single_chat_setting", "real_people");
        goto L12
    L4:
        r6 = a.a[r4.ordinal()];
        goto L6
    }
}
