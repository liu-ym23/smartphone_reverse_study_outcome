package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.browser.jsbridge.base.LiveCloseLinkResultModel;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 extends vb6.a {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ LiveCloseLinkResultModel b;

    public c0(d0 r1, LiveCloseLinkResultModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void F2(long r4, Throwable r6) {
        Intrinsics.checkNotNullParameter(r6, "throwable");
        super.F2(r4, r6);
        JsonObject r1 = new JsonObject();
        r1.addProperty("duration", Long.valueOf(r4));
        r1.add("throwable", GsonProtectorUtils.toJsonTree(new Gson(), r6).getAsJsonObject());
        this.b.a(LiveCloseLinkResultModel.Code.Failed);
        this.b.c("failed");
        this.a.finishWithResult(this.b);
    }

    public final void Xf(long r4, ExtraResponse<? extends com.bytedance.android.livesdk.chatroom.model.g1, Extra> r6) {
        Intrinsics.checkNotNullParameter(r6, "response");
        super.Xf(r4, r6);
        JsonObject r1 = new JsonObject();
        r1.addProperty("duration", Long.valueOf(r4));
        r1.add("response", GsonProtectorUtils.toJsonTree(new Gson(), r6).getAsJsonObject());
        this.b.a(LiveCloseLinkResultModel.Code.Success);
        this.b.c("success");
        this.b.b(r1);
        this.a.finishWithResult(this.b);
    }
}
