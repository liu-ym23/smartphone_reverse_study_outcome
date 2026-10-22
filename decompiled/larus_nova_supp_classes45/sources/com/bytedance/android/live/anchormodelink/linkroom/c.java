package com.bytedance.android.live.anchormodelink.linkroom;

import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements qh0.d<rh0.a> {
    public final /* synthetic */ int a;
    public final /* synthetic */ my.d b;

    public final void b(BaseCheckException r4) {
        Intrinsics.checkNotNullParameter(r4, "exception");
        boolean r5 = iy.b.a;
        iy.b.b("[LinkBasicJsbHandler] checkPermission fail linkType=" + this.a);
        my.d r6 = this.b;
        JsonObject r0 = new JsonObject();
        r0.addProperty("has_permission", Boolean.FALSE);
        Unit r1 = Unit.INSTANCE;
        r6.a(0, "fail", r0);
    }

    public final void onResult(Object r4) {
        rh0.a r5 = (rh0.a) r4;
        boolean r6 = iy.b.a;
        iy.b.d("[LinkBasicJsbHandler] checkPermission suc linkType=" + this.a);
        my.d r7 = this.b;
        JsonObject r0 = new JsonObject();
        r0.addProperty("has_permission", Boolean.TRUE);
        Unit r1 = Unit.INSTANCE;
        r7.a(1, "", r0);
    }

    public c(int r1, k r2) {
        this.a = r1;
        this.b = r2;
    }
}
