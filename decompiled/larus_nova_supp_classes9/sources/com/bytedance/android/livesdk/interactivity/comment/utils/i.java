package com.bytedance.android.livesdk.interactivity.comment.utils;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(com.bytedance.android.livesdk.interactivity.comment.model.a r4, boolean r5, boolean r6) {
        HashMap r0 = new HashMap();
        r0.put("module_name", "comment_expansion");
        if (r6 == false) goto L16;
        String r7 = null;
        if (r4 == null) goto L7;
        Long r2 = Long.valueOf(r4.a());
    L8:
        r0.put("tag_id", String.valueOf(r2));
        if (r4 == null) goto L11;
        r7 = r4.b();
    L11:
        r0.put("tag_text", String.valueOf(r7));
        if (r5 == false) goto L14;
        String r8 = "1";
    L15:
        r0.put("status", r8);
        r0.put("element_name", "interest_tag");
    L17:
        j0.l().sendLog("livesdk_interest_card_click", r0, new Object[]{IRoom.class, new x()});
        return;
    L14:
        r8 = "0";
        goto L15
    L7:
        r2 = null;
        goto L8
    L16:
        r0.put("element_name", "change");
        goto L17
    }

    public static void b(com.bytedance.android.livesdk.interactivity.comment.model.c r4, boolean r5, boolean r6) {
        HashMap r0 = new HashMap();
        r0.put("module_name", "comment_expansion");
        if (r6 == false) goto L17;
        if (r4 == null) goto L6;
        Long r7 = Long.valueOf(r4.b());
    L7:
        r0.put("question_id", String.valueOf(r7));
        if (r4 == null) goto L11;
        String r8 = r4.a();
        if (r8 == null) goto L11;
    L12:
        r0.put("question_text", r8);
        if (r5 == false) goto L15;
        String r9 = "1";
    L16:
        r0.put("status", r9);
        r0.put("element_name", "question");
    L18:
        j0.l().sendLog("livesdk_truth_question_click", r0, new Object[]{IRoom.class, new x()});
        return;
    L15:
        r9 = "0";
    L11:
        r8 = BuildConfig.FLAVOR;
        goto L12
    L6:
        r7 = null;
        goto L7
    L17:
        r0.put("element_name", "change");
        goto L18
    }
}
