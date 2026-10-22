package com.larksuite.component.blockit.service;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements BlockitService.g<String, ErrorResult> {
    public final /* synthetic */ BlockEntity a;
    public final /* synthetic */ IGetDataCallback b;

    @Override // com.larksuite.component.blockit.service.BlockitService.g
    public final void onError(ErrorResult r4) {
        ErrorResult r5 = r4;
        AppBrandLogger.e("BlockitService", new Object[]{"onError:" + r5.toString()});
        this.b.onError(r5);
    }

    public c(BlockEntity r1, IGetDataCallback r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larksuite.component.blockit.service.BlockitService.g
    public final void a(String r3, Map r4) {
        String r5 = r3;
        JsonObject r6 = GsonProtectorUtils.parse(new JsonParser(), r5).getAsJsonObject();
        int r0 = r6.get("code").getAsInt();
        if (r0 != 0) goto L5;
        String r7 = r6.get("data").getAsJsonObject().get("BlockId").getAsString();
        this.a.setBlockID(r7);
        this.b.onSuccess(this.a);
        return;
    L5:
        this.b.onError(new ErrorResult(r0, r5));
    }
}
