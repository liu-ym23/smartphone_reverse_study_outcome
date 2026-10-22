package com.larus.common.account.douyin;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import n38.q;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements q {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ IAiChatOpenDouyinAuthService.b b;
    public final /* synthetic */ JSONObject c;

    public c(JSONObject r1, a r2, JSONObject r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(boolean r17, Integer r18, String r110, String r20, String r21, String r22) {
        if (this.a == null) goto L29;
        JSONObject r1 = this.c;
        String r2 = null;
        if (r1 == null) goto L7;
        String r4 = r1.optString("scene");
    L8:
        if (r1 == null) goto L10;
        String r5 = r1.optString("page_type");
    L11:
        if (r1 == null) goto L13;
        String r6 = r1.optString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
    L14:
        if (r1 == null) goto L16;
        String r9 = r1.optString("message_id");
    L17:
        if (r1 == null) goto L19;
        String r10 = r1.optString("sec_enter_method");
    L20:
        if (r1 == null) goto L22;
        String r13 = r1.optString("action");
    L23:
        if (r1 == null) goto L25;
        String r12 = r1.optString("bot_id");
    L26:
        if (r1 == null) goto L28;
        r2 = r1.optString("authorize_scopes");
    L28:
        w0.d(r4, r5, r6, r17 ? 1 : 0, r22, r9, r10, r2, r12, r13, null, 3072);
        goto L29
    L25:
        r12 = null;
        goto L26
    L22:
        r13 = null;
        goto L23
    L19:
        r10 = null;
        goto L20
    L16:
        r9 = null;
        goto L17
    L13:
        r6 = null;
        goto L14
    L10:
        r5 = null;
        goto L11
    L7:
        r4 = null;
    L29:
        IAiChatOpenDouyinAuthService.b r3 = this.b;
        if (r3 == null) goto L33;
        r3.a(r17, r18);
        return;
    }
}
