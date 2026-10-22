package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.ao0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "closeLiveRoom")
public final class CloseLiveRoomMethod extends b<h0, CloseLiveRoomResultModel> {
    public CloseLiveRoomMethod() {
    }

    public final /* bridge */ /* synthetic */ void invoke(Object r1, CallContext r2) {
        j((h0) r1, r2);
    }

    public final void j(h0 r9, final CallContext r10) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "context");
        if (((Boolean) ao0.a.getValue()).booleanValue() == true) goto L5;
        finishWithFailure(new Throwable("客户端关闭了此功能"));
        return;
    L5:
        if ((r10.getContext() instanceof Activity) == false) goto L21;
        String r0 = r9.a();
        if (r0 != null) goto L9;
    L20:
        zg1.h1 r11 = new zg1.h1(6);
        Bundle r13 = new Bundle();
        r13.putBoolean("DATA_BOOLEAN_SKIP_INTERCEPTOR", true);
        r11.d = r13;
        xs2.b.a().post(r11);
        finishWithSuccess();
        return;
    L9:
        if (r0.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 != true) goto L20;
        String r1 = UriProtector.getQueryParameter(UriProtector.parse(r0), "type");
        if (r1 != null) goto L16;
    L19:
        com.bytedance.android.livesdk.service.l.d().a().handle(r10.getContext(), r9.a());
        UtilityKotlinExtentionsKt.s(100, false, true, new AnonymousClass1(this, r10), 2);
        return;
    L16:
        if (r1.equals("fullscreen") == true) goto L19;
        finishWithFailure(new Throwable("new FE page is not fullscreen"));
        return;
    L11:
        r2 = false;
        goto L12
    L21:
        finishWithFailure(new Throwable("context is not activity"));
    }
}
