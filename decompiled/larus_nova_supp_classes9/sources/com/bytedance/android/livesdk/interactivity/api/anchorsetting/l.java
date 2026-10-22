package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ CommentSettingDialog a;
    public final /* synthetic */ Ref.IntRef b;

    public l(CommentSettingDialog r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r13) {
        Response r14 = (Response) r13;
        boolean r2 = true;
        if (((BaseResponse) r14).statusCode != 0) goto L56;
        int r15 = this.b.element;
        if (r15 != 1) goto L8;
        f2.b(2131915873, 0);
    L17:
        com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.b.W0;
        Integer r5 = Integer.valueOf(this.a.q);
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r5);
        CommentSettingDialog r6 = this.a;
        if (r6.r == true) goto L70;
        r6.r = true;
        com.bytedance.android.livesdk.log.g r7 = com.bytedance.android.livesdk.log.u.l();
        HashMap r8 = new HashMap();
        r8.put("enter_from_merge", "direct_shoot");
        r8.put("enter_method", "live_anchor_setting_page");
        r8.put("anchor_id", jc1.k.n(IUserService.class).user().n());
        r8.put("room_id", String.valueOf(r6.h));
        Integer r9 = (Integer) r16.getValue();
        String r10 = "0";
        if (r9 != null) goto L24;
    L26:
        Object r3 = "1";
    L27:
        r8.put("comment_right", r3);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.Y0.getValue()).booleanValue() == false) goto L30;
        Object r4 = "1";
    L31:
        r8.put("speak_right", r4);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.b1.getValue()).booleanValue() == false) goto L34;
        Object r11 = "1";
    L35:
        r8.put("unpaid_right", r11);
        Integer r17 = (Integer) r16.getValue();
        if (r17 != null) goto L39;
    L41:
        if (r17 != null) goto L44;
    L46:
        if (r17 != null) goto L49;
    L51:
        String r18 = "null";
    L52:
        r8.put("group", r18);
        if (r6.j == false) goto L55;
        r10 = "1";
    L55:
        r8.put("is_paidlive", r10);
        r8.put("ticket_id", String.valueOf(r6.k));
        r8.put("ticket_name", r6.l);
        Unit r19 = Unit.INSTANCE;
        r7.sendLog("livesdk_anchor_interact_right_leave", r8, new Object[0]);
        return;
    L49:
        if (r17.intValue() != 5) goto L51;
        r18 = "fans";
        goto L52
    L44:
        if (r17.intValue() != 3) goto L46;
        r18 = "follow";
        goto L52
    L39:
        if (r17.intValue() != 9) goto L41;
        r18 = "all";
        goto L52
    L34:
        r11 = "0";
        goto L35
    L30:
        r4 = "0";
        goto L31
    L24:
        if (r9.intValue() != 1) goto L26;
        r3 = "0";
        goto L27
    L70:
        return;
    L8:
        if (this.a.p != 1) goto L10;
        f2.b(2131915874, 0);
        goto L17
    L10:
        if (r15 == 3) goto L16;
        if (r15 == 5) goto L15;
        if (r15 != 9) goto L17;
        f2.b(2131915872, 0);
        goto L17
    L15:
        f2.b(2131915883, 0);
        goto L17
    L16:
        f2.b(2131915882, 0);
        goto L17
    L56:
        RequestError r110 = ((BaseResponse) r14).error;
        if (r110 == null) goto L59;
        String r111 = r110.prompts;
    L60:
        if (r111 != null) goto L62;
    L65:
        if (r2 == true) goto L69;
        f2.c(r111, 0);
        return;
    L69:
        return;
    L62:
        if (StringsKt.isBlank(r111) == true) goto L65;
        r2 = false;
        goto L65
    L59:
        r111 = null;
        goto L60
    }
}
