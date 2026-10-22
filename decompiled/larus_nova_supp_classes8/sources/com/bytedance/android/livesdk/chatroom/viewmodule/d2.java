package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareParams;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.config.oc;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d2 implements IShareCallback {
    public final /* synthetic */ LiveShareWidget a;

    public final void onFail(Throwable r1) {
    }

    public final /* synthetic */ void onShareUiDismiss() {
        IShareCallback.-CC.$default$onShareUiDismiss(this);
    }

    public final /* synthetic */ void onShareUiShow() {
        IShareCallback.-CC.$default$onShareUiShow(this);
    }

    public d2(LiveShareWidget r1) {
        this.a = r1;
    }

    public final boolean interceptReportAction(IShareParams r4) {
        if (tb1.c.a == false) goto L12;
        oc r5 = oc.a;
        if (TextUtils.isEmpty(r5.getValue()) == true) goto L14;
        UrlBuilder r0 = new UrlBuilder(r5.getValue());
        r0.addParam("web_bg_color", "%2300000000");
        r0.addParam("anchor_id", this.a.c.getBaseOwner().getCastSecUid());
        r0.addParam("room_id", this.a.c.getId());
        r0.addParam("user_id", jc1.k.f(IUserService.class).user().b().getCastSecUid());
        if (this.a.c.isHasCommerceGoods() == false) goto L9;
        String r6 = "1";
    L10:
        r0.addParam("is_sale", r6);
        r0.addParam("livesdk_profile_hide_confirm", "0");
        TTLiveSDKContext.getHostService().a().openLiveBrowser(r0.build(), new Bundle(), this.a.getContext());
        return true;
    L9:
        r6 = "0";
        goto L10
    L14:
        return false;
    L12:
        return false;
    }

    public final void onSuccess(String r9, String r10) {
        final LiveShareWidget r0 = this.a;
        long r1 = r0.c.getId();
        String r3 = this.a.c.getLabels();
        HashMap r4 = new HashMap();
        com.bytedance.android.livesdk.share.e.a.getClass();
        String r5 = String.valueOf(com.bytedance.android.livesdk.share.e.a.b(r9));
        if (TextUtils.isEmpty(r5) == true) goto L5;
        r4.put("target_id", r5);
    L5:
        String r6 = String.valueOf(1);
        if (TextUtils.isEmpty(r6) == true) goto L8;
        r4.put("share_type", r6);
    L8:
        String r7 = String.valueOf(r3);
        if (TextUtils.isEmpty(r7) == true) goto L11;
        r4.put("common_label_list", r7);
    L11:
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).sendShare(r1, r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new c2(r0), RxUtil.getNoOpThrowable());
        LiveShareWidget r2 = this.a;
        r2.getClass();
        HashMap r8 = new HashMap();
        r8.put("platform", r9);
        r8.put("is_pyramid_sale", "0");
        r8.put("type", r10);
        r8.put("log_pb", r2.c.getLog_pb());
        com.bytedance.android.livesdk.log.g r11 = com.bytedance.android.livesdk.log.u.l();
        am2.x r12 = new am2.x();
        r12.f = "click";
        r11.sendLog("share", r8, new Object[]{r12, Room.class});
        if (com.bytedance.android.livesdk.utils.c1.b(((Widget) this.a).dataCenter) == false) goto L28;
        if (this.a.c.author() == null) goto L28;
        JSONObject r13 = new JSONObject();
        r13.put("anchor_id", this.a.c.author().getIdString());     // Catch: JSONException -> L18
        r13.put("room_id", String.valueOf(this.a.c.getId()));     // Catch: JSONException -> L18
    L20:
        com.bytedance.android.livesdk.chatroom.utils.k1.f(r13);
        ILiveDouPlusService r14 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r15 = new HashMap();
        r15.put("ad_extra_data", r13.toString());
        Map r16 = com.bytedance.android.livesdk.utils.c1.e(((Widget) this.a).dataCenter);
        if (r16 != null) goto L23;
    L26:
        r14.logEvent(true, "live_ad", "live_share", r15);
        goto L28
    L23:
        if (r16.isEmpty() == true) goto L26;
        r15.putAll(r16);
    L18:
        e = move-exception;
        e.printStackTrace();
    L28:
        if (com.bytedance.android.livesdk.utils.c1.c(((Widget) this.a).dataCenter) == true) goto L30;
    L41:
        DataCenter r17 = ((Widget) this.a).dataCenter;
        int r18 = com.bytedance.android.livesdk.utils.x1.a;
        return;
    L30:
        if (this.a.c.author() == null) goto L41;
        JSONObject r19 = new JSONObject();
        r19.put("anchor_id", this.a.c.author().getIdString());     // Catch: JSONException -> L34
        r19.put("room_id", String.valueOf(this.a.c.getId()));     // Catch: JSONException -> L34
    L36:
        com.bytedance.android.livesdk.chatroom.utils.k1.f(r19);
        ILiveDouPlusService r110 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r20 = new HashMap();
        r20.put("ad_extra_data", r19.toString());
        Map r21 = com.bytedance.android.livesdk.utils.c1.f(((Widget) this.a).dataCenter);
        if (r21.isEmpty() == true) goto L40;
        r20.putAll(r21);
    L40:
        r110.logEvent(true, "live_ad", "live_share", r20);
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    }
}
