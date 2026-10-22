package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.s2;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n0<T> implements Consumer {
    public final /* synthetic */ PayMethod a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public n0(PayMethod r1, String r2, long r3, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void accept(Object r19) {
        Throwable r1 = (Throwable) r19;
        int r2 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethod", new Object[]{"pay diamond fail, error: ", r1});
        if ((r1 instanceof CustomApiServerException) == true) goto L5;
        Throwable r3 = null;
    L6:
        CustomApiServerException r4 = (CustomApiServerException) r3;
        if (r4 == null) goto L28;
        if (r4.getErrorCode() != 4014048) goto L23;
        JsonElement r5 = GsonProtectorUtils.parse(GsonHelper.parser(), r4.getExtra());
        if (r5 == null) goto L17;
        JsonObject r6 = r5.getAsJsonObject();
        if (r6 == null) goto L17;
        JsonElement r7 = r6.get("shark_code");
        if (r7 == null) goto L17;
        int r8 = r7.getAsInt();
    L18:
        PayMethod r13 = this.a;
        Context r9 = r13.k;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L21:
        String r14 = this.b;
        long r11 = this.c;
        String r12 = this.d;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"show verify code dialog, order id: " + r14});
        Logger.d("showCaptcha", "showVerifyCodeDialog, errorCode=" + r8);
        TTLiveSDK.hostService().verify().showCaptcha(s2.a(r9), r8, new o0(r13, r14, r11, r12));
        int r15 = x10.f.a;
        x10.f.b(this.a.d, 4, OpenApiErrorInfo.INTERNAL_ERROR, null, 4014048);
        return;
    L17:
        r8 = 0;
        goto L18
    L23:
        if (r4.getErrorCode() == 0) goto L28;
        if (this.a.i.contains(Integer.valueOf(r4.getErrorCode())) == true) goto L28;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"error code: ", Integer.valueOf(r4.getErrorCode()), ", need query again, order id: ", this.b});
        PayMethod.s(this.a, this.c, 3);
        return;
    L28:
        if ((r1 instanceof SocketTimeoutException) == false) goto L30;
    L35:
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethod", new Object[]{"pay diamond request timeout, order id: " + this.b});
        PayMethod.s(this.a, this.c, 3);
        return;
    L30:
        if ((r1 instanceof IOException) == true) goto L35;
        if ((r1 instanceof NetworkErrorException) == true) goto L35;
        com.bytedance.android.live.broadcastgame.opengame.q.e("PayMethod", new Object[]{"unknown pay error, order id: " + this.b});
        PayMethod.u(this.a, r1);
        int r16 = x10.f.a;
        x10.f.b(this.a.d, 4, OpenApiErrorInfo.INTERNAL_ERROR, r1, com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r1));
        return;
    L5:
        r3 = r1;
        goto L6
    }
}
