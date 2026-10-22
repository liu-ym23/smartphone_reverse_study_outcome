package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.live.browser.jsbridge.base.ShareLiveResultModel;
import com.bytedance.android.livehostapi.business.depend.share.IUgShareCallback;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements IUgShareCallback {
    public final /* synthetic */ ShareLiveMethod a;

    public e(ShareLiveMethod r1) {
        this.a = r1;
    }

    public final void onSuccess(JSONObject r7) {
        ShareLiveMethod r0 = this.a;
        ShareLiveResultModel r1 = new ShareLiveResultModel();
        r1.a(ShareLiveResultModel.Code.Success);
        JsonObject r2 = new JsonObject();
        if (r7 == null) goto L9;
        Iterator<String> r3 = r7.keys();
        if (r3 == null) goto L9;
    L7:
        if (r3.hasNext() == false) goto L9;
        String r4 = r3.next();
        r2.addProperty(r4, r7.optString(r4));
    L9:
        Unit r8 = Unit.INSTANCE;
        r1.b(r2);
        r0.finishWithResult(r1);
    }

    public final void onFailed(int r5, String r6, Object r7) {
        ShareLiveMethod r0 = this.a;
        ShareLiveResultModel r1 = new ShareLiveResultModel();
        r1.a(ShareLiveResultModel.Code.Failed);
        JsonObject r2 = new JsonObject();
        r2.addProperty(Constants.OperatorKey.CODE, Integer.valueOf(r5));
        r2.addProperty(Constants.OperatorKey.MSG, r6);
        r2.addProperty(Constants.Keys.DATA, String.valueOf(r7));
        Unit r8 = Unit.INSTANCE;
        r1.b(r2);
        r0.finishWithResult(r1);
    }
}
