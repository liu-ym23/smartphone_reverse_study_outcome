package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PiaRenderingExecuteResultModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e1<T> implements l47.a {
    public final /* synthetic */ g1 a;

    public e1(g1 r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Gson r0 = com.bytedance.android.annie.util.h.c;
        JsonElement r11 = GsonProtectorUtils.toJsonTree(r0, (Map) r10);
        if (r11.isJsonObject() == false) goto L5;
        JsonElement r12 = r11.getAsJsonObject().get(com.bytedance.android.ec.core.event.a.KEY_RESULT);
    L6:
        if (r12 == null) goto L10;
        boolean r1 = true;
        if (r12.isJsonObject() != true) goto L10;
    L11:
        if (r1 == false) goto L13;
        g1 r13 = this.a;
        PiaRenderingExecuteResultModel r14 = new PiaRenderingExecuteResultModel();
        PiaRenderingExecuteResultModel.a r15 = new PiaRenderingExecuteResultModel.a();
        r15.setResult(r12.getAsJsonObject());
        r14.a(r15);
        r13.finishWithResult(r14);
        return;
    L13:
        this.a.finishWithFailure(new PiaMethod.Error("result is null!"));
        return;
    L10:
        r1 = false;
        goto L11
    L5:
        r12 = null;
        goto L6
    }
}
