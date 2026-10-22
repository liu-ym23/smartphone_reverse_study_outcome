package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showToast")
public final class ad extends x<bd, JSONObject> {
    public ad() {
    }

    public final void invoke(Object r7, CallContext r8) {
        bd r9 = (bd) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        String r0 = r9.c();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        finishWithFailure();
        return;
    L11:
        String r2 = r9.a();
        String r3 = "";
        if (r2 != null) goto L14;
    L28:
        String r4 = r9.b();
        if (r4 != null) goto L31;
    L52:
        com.bytedance.android.live.core.utils.f2.c(r9.c(), 0);
    L53:
        JSONObject r11 = new JSONObject();
        r11.put("code", 1);
        r11.put("msg", "SUCCESS");
        finishWithResult(r11);
        return;
    L31:
        if ((!StringsKt.isBlank(r4)) != true) goto L52;
        LinkedHashMap r5 = new LinkedHashMap();
        String r6 = r9.b();
        if (r6 == null) goto L46;
        int r12 = r6.hashCode();
        if (r12 == (-1867169789)) goto L44;
        if (r12 != 96784904) goto L46;
        if (r6.equals("error") == false) goto L46;
        int r13 = 2;
    L47:
        r5.put("status", Integer.valueOf(r13));
        String r14 = r9.c();
        if (r14 == null) goto L51;
        r3 = r14;
    L51:
        r5.put("text", r3);
        jc1.k.n(IHostApp.class).centerIconToast(r8.getContext(), r5);
        goto L53
    L44:
        if (r6.equals("success") == false) goto L46;
        r13 = 1;
    L46:
        r13 = -1;
        goto L47
    L14:
        if ((!StringsKt.isBlank(r2)) != true) goto L28;
        String r15 = r9.a();
        Intrinsics.checkNotNull(r15);
        Object[] r16 = new Regex(",").split(r15, 0).toArray(new String[0]);     // Catch: Exception -> L21
        if (r16 == null) goto L20;
        byte[] r17 = Base64.decode(((String[]) r16)[1], 0);     // Catch: Exception -> L21
        Bitmap r18 = BitmapFactory.decodeByteArray(r17, 0, r17.length);     // Catch: Exception -> L21
    L22:
        if (r18 == null) goto L53;
        String r19 = rm3.c.a;
        Context r21 = r8.getContext();
        String r22 = r9.c();
        if (r22 == null) goto L27;
        r3 = r22;
    L27:
        rm3.c.c(r21, r3, new BitmapDrawable(r18));
        goto L53
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L21
    L21:
        r18 = null;
        goto L22
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
