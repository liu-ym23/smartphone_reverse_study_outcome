package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.s2;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t0<T> implements Consumer {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public t0(p0 r1, String r2, long r3, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void accept(Object r19) {
        Throwable r1 = (Throwable) r19;
        int r2 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"pay diamond fail, error: ", r1});
        if ((r1 instanceof CustomApiServerException) == true) goto L5;
        Throwable r3 = null;
    L6:
        CustomApiServerException r4 = (CustomApiServerException) r3;
        if (r4 == null) goto L34;
        if (r4.getErrorCode() != 4014048) goto L23;
        JsonElement r5 = GsonProtectorUtils.parse(GsonHelper.parser(), r4.getExtra());
        if (r5 == null) goto L17;
        JsonObject r6 = r5.getAsJsonObject();
        if (r6 == null) goto L17;
        JsonElement r7 = r6.get("shark_code");
        if (r7 == null) goto L17;
        int r8 = r7.getAsInt();
    L18:
        p0 r13 = this.a;
        Context r9 = r13.i;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L21:
        String r14 = this.b;
        long r11 = this.c;
        String r12 = this.d;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"show verify code dialog, order id: " + r14});
        TTLiveSDK.hostService().verify().showCaptcha(s2.a(r9), r8, new u0(r13, r14, r11, r12));
        int r15 = x10.f.a;
        x10.f.d(this.a.d, 4, OpenApiErrorInfo.INTERNAL_ERROR, null, 4014048);
        return;
    L17:
        r8 = 0;
        goto L18
    L23:
        if (r4.getErrorCode() != 41104) goto L26;
        p0 r16 = this.a;
        OpenApiErrorInfo r17 = OpenApiErrorInfo.ORDER_PAID;
        r16.w(r17, this.b, 2131921033);
        int r18 = x10.f.a;
        x10.f.e(this.a.d, 4, r17, 24);
        return;
    L26:
        if (r4.getErrorCode() != 4005238) goto L29;
        p0 r21 = this.a;
        OpenApiErrorInfo r22 = OpenApiErrorInfo.ORDER_EXPIRED;
        p0.x(r21, r22, this.b);
        int r23 = x10.f.a;
        x10.f.e(this.a.d, 4, r22, 24);
        return;
    L29:
        if (r4.getErrorCode() == 0) goto L34;
        if (this.a.h.contains(Integer.valueOf(r4.getErrorCode())) == true) goto L34;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"error code: ", Integer.valueOf(r4.getErrorCode()), ", need query again, order id: ", this.b});
        p0.s(this.a, this.c, this.b, 3);
        return;
    L34:
        if ((r1 instanceof SocketTimeoutException) == false) goto L36;
    L41:
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethodV3", new Object[]{"pay diamond request timeout, order id: " + this.b});
        p0.s(this.a, this.c, this.b, 3);
        return;
    L36:
        if ((r1 instanceof IOException) == true) goto L41;
        if ((r1 instanceof NetworkErrorException) == true) goto L41;
        com.bytedance.android.live.broadcastgame.opengame.q.e("PayMethodV3", new Object[]{"unknown pay error, order id: " + this.b});
        p0.y(this.a, r1);
        int r24 = x10.f.a;
        x10.f.d(this.a.d, 4, OpenApiErrorInfo.INTERNAL_ERROR, r1, com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r1));
        return;
    L5:
        r3 = r1;
        goto L6
    }
}
