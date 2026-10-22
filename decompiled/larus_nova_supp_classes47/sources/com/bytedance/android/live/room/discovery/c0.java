package com.bytedance.android.live.room.discovery;

import com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveCircleHashTag;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTag;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHashTagUseInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 implements ILiveHashTagCallback {
    public final /* synthetic */ LiveHashtagWidget a;

    public final void onHashTagJoinFailed() {
    }

    public final void onHashTagPanelDismiss() {
    }

    public final void onHashTagPanelShow() {
    }

    public c0(LiveHashtagWidget r1) {
        this.a = r1;
    }

    public final void onHashTagJoinSuccess(LiveHashTag r5) {
        LiveHashtagWidget r0 = this.a;
        DataCenter r1 = ((Widget) r0).dataCenter;
        if (r1 == null) goto L10;
        if (r5 == null) goto L10;
        r5.setCreationId((String) r1.get("log_challenge_creation_id", null));
        r0.xq(r5);
        LiveHashTagUseInfo r2 = (LiveHashTagUseInfo) ((Widget) r0).dataCenter.get("data_hash_tag_use_info", new LiveHashTagUseInfo());
        if (r2 != null) goto L9;
        r2 = new LiveHashTagUseInfo();
    L9:
        r2.useHashTagSource(r5.getSource());
        ((Widget) r0).dataCenter.put("data_hash_tag_use_info", r2);
    L10:
        this.a.zq(r5.getId(), r5.getName());
    }

    public final void onHashTagRefreshSuccess(String r3) {
        DataCenter r0 = ((Widget) this.a).dataCenter;
        if (r0 == null) goto L6;
        r0.put("log_challenge_creation_id", r3);
        return;
    }

    public final void onLiveCircleSelectSuccess(LiveCircleHashTag r1) {
        r1.getCircleName();
    }
}
