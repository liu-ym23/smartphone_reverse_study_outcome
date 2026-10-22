package com.bytedance.android.annie.bridge.method;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "showToast")
public final class n2 extends e7.c0<e7.y0, JsonObject> {
    public final void onTerminate() {
    }

    public n2() {
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.y0 r12 = (e7.y0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = r12.b();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        finishWithFailure();
        return;
    L11:
        String r13 = r12.a();
        if (r13 != null) goto L14;
    L16:
        boolean r14 = false;
    L17:
        if (r14 == false) goto L29;
        String r15 = r12.a();
        Intrinsics.checkNotNull(r15);
        Object[] r16 = new Regex(",").split(r15, 0).toArray(new String[0]);     // Catch: Exception -> L24
        if (r16 == null) goto L23;
        byte[] r17 = Base64.decode(((String[]) r16)[1], 0);     // Catch: Exception -> L24
        Bitmap r18 = BitmapFactory.decodeByteArray(r17, 0, r17.length);     // Catch: Exception -> L24
    L25:
        if (r18 == null) goto L32;
        String r19 = r12.b();
        if (r19 == null) goto L32;
        String r20 = fa.a.a;
        fa.a.a(r11.getContext(), r19, new BitmapDrawable(r18));
    L32:
        JsonObject r21 = new JsonObject();
        r21.addProperty("code", 1);
        r21.addProperty(MessageIndication.MESSAGE_TYPE_MSG, "SUCCESS");
        finishWithResult(r21);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L24
    L24:
        r18 = null;
        goto L25
    L29:
        String r22 = r12.b();
        if (r22 == null) goto L32;
        String r23 = fa.a.a;
        fa.a.b(r11.getContext(), r22);
        goto L32
    L14:
        if ((!StringsKt.isBlank(r13)) != true) goto L16;
        r14 = true;
        goto L17
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
