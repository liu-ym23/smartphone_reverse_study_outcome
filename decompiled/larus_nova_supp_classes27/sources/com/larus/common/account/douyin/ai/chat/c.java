package com.larus.common.account.douyin.ai.chat;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.common_ui.dialog.u;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements u {
    public final /* synthetic */ IAiChatOpenDouyinAuthService.c a;
    public final /* synthetic */ JSONObject b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.a.onResult(false);
        e.c = null;
        FLogger.a.i("AiChatDouyinAuthPreDialogHelper", "Douyin auth pre-asking dialog is cancelled");
        w0.b(this.b.optString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD), this.b.optString("content_type"), this.b.optString("scene"), "later", this.b.optString("message_id"), this.b.optString("sec_enter_method"));
    }

    public c(IAiChatOpenDouyinAuthService.c r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }
}
