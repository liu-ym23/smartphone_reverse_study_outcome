package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.config.xl;
import com.bytedance.common.utility.StringUtils;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i5 implements Consumer<Response<com.bytedance.android.livesdk.chatroom.model.k3>> {
    public final /* synthetic */ HashMap a;
    public final /* synthetic */ ShareParams.Builder b;

    public final void accept(Object r4) throws Exception {
        Response r5 = (Response) r4;
        if (r5 != null) goto L6;
        ALogger.e("MoreMixSharePanel", "response is null");
        return;
    L6:
        if (((BaseResponse) r5).statusCode != 0) goto L30;
        Object r1 = ((BaseResponse) r5).data;
        if (r1 != null) goto L11;
        ALogger.e("MoreMixSharePanel", "ShopGuideID Error: response.data == null，获取导购信息失败! ");
        return;
    L11:
        if (((com.bytedance.android.livesdk.chatroom.model.k3) r1).b() == null) goto L16;
        if (xl.a.getValue().booleanValue() == false) goto L16;
        this.a.putAll(((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r5).data).b());
    L16:
        if (((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r5).data).a() != null) goto L18;
    L24:
        ALogger.e("MoreMixSharePanel", "ShopGuideID Error: 导购信息 == null! ");
    L25:
        m50 r6 = m50.a;
        if (r6.getValue().p() == false) goto L28;
    L29:
        this.b.setEnableLandscapeOpt(true);
        return;
    L28:
        if (r6.getValue().o() == true) goto L29;
        return;
    L18:
        if (((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r5).data).a().booleanValue() != true) goto L24;
        if (StringUtils.isEmpty(((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r5).data).c()) == true) goto L24;
        if (StringUtils.isEmpty(((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r5).data).d()) == true) goto L24;
        this.b.setUrl(((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r5).data).c());
        this.b.getExtras().putString("shop_guide_id", ((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r5).data).d());
        goto L25
    L30:
        ALogger.e("MoreMixSharePanel", "ShopGuideID Error: response.statusCode != 0! ");
    }

    public i5(HashMap r1, ShareParams.Builder r2) {
        this.a = r1;
        this.b = r2;
    }
}
