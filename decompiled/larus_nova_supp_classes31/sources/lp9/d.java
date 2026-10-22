package lp9;

import kotlin.jvm.internal.Intrinsics;
import kq9.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static e a;

    static {
    }

    public static JSONObject a() {
        JSONObject r0 = new JSONObject();
        e r1 = a;
        if (r1 == null) goto L34;
        String r2 = r1.a;
        String r3 = "";
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.put("bot_id", r2);
        String r4 = r1.b;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r0.put("conversation_id", r4);
        r0.put("bot_conversation_type", r1.c);
        String r5 = r1.d;
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r0.put("chat_type", r5);
        String r6 = r1.e;
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r0.put("previous_page", r6);
        String r7 = r1.f;
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r0.put("click_from", r7);
        String r8 = r1.g;
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        r0.put("cited_from_user_type", r8);
        String r9 = r1.h;
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r0.put("cited_message_id", r9);
        String r10 = r1.i;
        if (r10 != null) goto L29;
        r10 = "";
    L29:
        r0.put("previous_camera_tab_name", r10);
        Boolean r11 = r1.j;
        Boolean r12 = Boolean.TRUE;
        r0.put("is_ai_doc", Intrinsics.areEqual(r11, r12) ? 1 : 0);
        r0.put("is_replica_create", Intrinsics.areEqual(r1.k, r12) ? 1 : 0);
        String r13 = r1.l;
        if (r13 == null) goto L33;
        r3 = r13;
    L33:
        r0.put("replica_create_id", r3);
    L34:
        return r0;
    }
}
