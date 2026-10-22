package com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch;

import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ MultiAnchorPkLaunchControlWidget a;

    public d(MultiAnchorPkLaunchControlWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        zy0.d r6 = this.a.h;
        if (r6 == null) goto L8;
        JSONObject r0 = new JSONObject();
        r0.put("type", "invite_user_button_status");
        this.a.getClass();
        r0.put(Constants.Keys.DATA, MultiAnchorPkLaunchControlWidget.Aq());
        xy0.a<?> r7 = r6.g();
        if (r7 == null) goto L9;
        r7.sendJsEvent("H5_webcastNotification", r0);
        return;
    L9:
        return;
    }
}
