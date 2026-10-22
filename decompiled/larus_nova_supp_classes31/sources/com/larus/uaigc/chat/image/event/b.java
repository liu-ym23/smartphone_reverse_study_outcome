package com.larus.uaigc.chat.image.event;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageShareClickMethod;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.h;
import com.larus.im.bean.message.Message;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.uaigc.helper.h0;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.b2;
import tx9.c2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements ky9.b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static JSONObject d(ImageShareClickMethod r4, df8.a r5) {
        JSONObject r0 = new JSONObject();
        Map r1 = r5.d;
        if (r1 == null) goto L8;
        Iterator r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) r2.next();
        r0.put((String) r3.getKey(), r3.getValue());
    L8:
        String r6 = r5.b.getKey();
        if (r6 == null) goto L11;
        r0.put("pic_id", r6);
    L11:
        r0.put("position", r5.a + 1);
        String r7 = r5.b.getRequestId();
        if (r7 == null) goto L14;
        r0.put("request_id", r7);
    L14:
        TemplateInfo$TemplateInfo r8 = r5.c;
        if (r8 == null) goto L17;
        r0.put("from_template_id", r8.a);
    L17:
        r0.put("click_method", r4.getValue());
        return r0;
    }

    public static String e(JSONObject r1, String r2) {
        String r3 = r1.optString(r2);
        Intrinsics.checkNotNull(r3);
        boolean r0 = true;
        if ((!StringsKt.isBlank(r3)) == true) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == true) goto L12;
        return null;
    L12:
        return r3;
    L5:
        if (Intrinsics.areEqual(r3, "null") == true) goto L7;
        goto L7
    }

    @Override // ky9.b
    public final void a(ImageShareClickMethod r6, df8.a r7, String r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r6, "clickMethod");
        Intrinsics.checkNotNullParameter(r7, "imageItemInfo");
        ShareServiceDelegate r0 = ShareServiceDelegate.b;
        JSONObject r1 = new JSONObject();
        Map r2 = r7.d;
        if (r2 == null) goto L8;
        Iterator r3 = r2.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Map.Entry r4 = (Map.Entry) r3.next();
        r1.put((String) r4.getKey(), r4.getValue());
    L8:
        String r5 = r7.b.getKey();
        if (r5 == null) goto L11;
        r1.put("pic_id", r5);
    L11:
        if (r8 == null) goto L13;
        r1.put("is_replica_gen", Intrinsics.areEqual(r8, "avatar_image") ? 1 : 0);
    L13:
        if (r9 == null) goto L15;
        h0.a(r1, r9);
    L15:
        r1.put("is_image_edit", Intrinsics.areEqual(r8, "ai_beautify_image") ? 1 : 0);
        r1.put("position", r7.a + 1);
        r1.put("share_content", "picture");
        r1.put("click_method", r6.getValue());
        r0.w(r1);
    }

    @Override // ky9.b
    public final h c(ImageShareClickMethod r77, df8.a r78, Integer r79, JSONObject r80, Message r81) {
        Intrinsics.checkNotNullParameter(r77, "clickMethod");
        Intrinsics.checkNotNullParameter(r78, "imageItemInfo");
        JSONObject r8 = d(r77, r78);
        r8.put("click_method", r77.getValue());
        r8.put("click_from", "share_panel");
        Iterator<T> r1 = c2.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) r1.next();
        if (r80 == null) goto L4;
        Object r3 = r80.opt(r2);
        if (r3 == null) goto L4;
        if (Intrinsics.areEqual(r3, JSONObject.NULL) == true) goto L4;
        r8.putOpt(r2, r3);
        goto L4
    L12:
        if (r79 != null) goto L15;
    L17:
        boolean r10 = false;
    L18:
        String r25 = AccountService.a.getUserId();
        if (r80 == null) goto L21;
        String r29 = r80.optString("creation_task_id");
    L22:
        if (r81 == null) goto L24;
        String r7 = r81.getMessageId();
    L25:
        if (r80 == null) goto L27;
        String r42 = r80.optString("creation_id");
    L28:
        String r15 = e(r8, "template_rec_req_id");
        String r16 = e(r8, "template_rec_extra");
        String r17 = e(r8, "from_template_id");
        String r18 = e(r8, "recommend_from");
        if (r81 == null) goto L31;
        String r63 = com.larus.im.bean.message.a.r(r81);
    L32:
        if (r81 == null) goto L34;
        String r64 = com.larus.im.bean.message.a.s(r81);
    L36:
        return new h(null, null, null, null, null, null, r7, r8, null, r10, r79, null, null, null, r15, r16, r17, r18, null, null, null, null, null, null, r25, null, null, null, r29, null, null, null, null, null, null, null, null, null, r81, null, null, r42, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r63, r64, null, null, false, null, null, null, null, -1141840257, -4353, 1017);
    L34:
        r64 = null;
        goto L36
    L31:
        r63 = null;
        goto L32
    L27:
        r42 = null;
        goto L28
    L24:
        r7 = null;
        goto L25
    L21:
        r29 = null;
        goto L22
    L15:
        if (r79.intValue() != 3) goto L17;
        r10 = true;
        goto L18
    }

    @Override // ky9.b
    public final void b(ImageShareClickMethod r11, df8.a r12, String r13, Integer r14, String r15, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "clickMethod");
        Intrinsics.checkNotNullParameter(r12, "imageItemInfo");
        f(r11, r12, r13, r14, r15, r16, r17, r18, null);
    }

    public static void f(ImageShareClickMethod r2, df8.a r3, String r4, Integer r5, String r6, String r7, String r8, String r9, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r2, "clickMethod");
        Intrinsics.checkNotNullParameter(r3, "imageItemInfo");
        JSONObject r11 = d(r2, r3);
        r11.put("click_from", "click_download");
        if (r4 == null) goto L5;
        r11.put("is_replica_gen", Intrinsics.areEqual(r4, "avatar_image") ? 1 : 0);
    L5:
        r11.put("is_image_edit", Intrinsics.areEqual(r4, "ai_beautify_image") ? 1 : 0);
        boolean r0 = true;
        r11.put("is_ai_creation", 1);
        if (r3.b.getRefImage() == null) goto L8;
        int r12 = 1;
    L9:
        r11.put("has_origin_image", r12);
        if (r8 != null) goto L12;
    L14:
        if (r9 != null) goto L16;
    L18:
        r11.put("is_search_card", 0);
        r11.putOpt("position", r5);
        r11.putOpt("creation_task_id", r6);
        r11.put("download_method", "click_icon");
        r11.put("user_type", "bot");
        r11.put("creation_id", r7);
        Iterator<T> r13 = c2.a.iterator();
    L20:
        if (r13.hasNext() == false) goto L29;
        String r14 = (String) r13.next();
        if (r10 == null) goto L20;
        Object r15 = r10.opt(r14);
        if (r15 == null) goto L20;
        if (Intrinsics.areEqual(r15, JSONObject.NULL) == true) goto L20;
        r11.putOpt(r14, r15);
        goto L20
    L29:
        if (b2.a(r11) == false) goto L31;
    L34:
        boolean r16 = true;
    L36:
        if (b2.d(r11, "_mixed_richmedia_download_suppress") != true) goto L38;
        boolean r17 = true;
    L39:
        if (r17 == true) goto L48;
        if (r10 != null) goto L42;
    L44:
        boolean r18 = false;
    L45:
        if (r18 == true) goto L48;
        r0 = false;
        goto L48
    L42:
        if (b2.d(r10, "_mixed_richmedia_download_suppress") != true) goto L44;
        r18 = true;
    L48:
        b2.g(r11, r16, r0, false);
        o.a.reportEvent("picture_download", r11);
        return;
    L38:
        r17 = false;
        goto L39
    L31:
        if (b2.a(r10) == true) goto L34;
        r16 = false;
        goto L36
    L16:
        if (o0.d(r9) == false) goto L18;
        r11.put("chat_id", r9);
        goto L18
    L12:
        if (o0.d(r8) == false) goto L14;
        r11.put("is_general_agent", r8);
        goto L14
    L8:
        r12 = 0;
        goto L9
    }
}
