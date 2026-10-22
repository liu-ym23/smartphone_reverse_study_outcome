package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "toast")
public final class ed extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName("image")
        String image;

        @SerializedName("position")
        int position;

        @SerializedName("status")
        String status;

        @SerializedName("text")
        String text;

        @SerializedName("type")
        String type;

        @SerializedName("useOriginalToast")
        Boolean useOriginalToast;

        public a() {
            this.useOriginalToast = Boolean.FALSE;
        }
    }

    public ed() {
    }

    public final Object invoke(Object r6, CallContext r7) throws Exception {
        a r8 = (a) r6;
        if (TextUtils.isEmpty(r8.type) == false) goto L6;
        r8.type = "prompt";
    L6:
        if (TextUtils.equals("icon", r8.type) == false) goto L9;
        HashMap r0 = new HashMap();
        r0.put("status", r8.status);
        r0.put("text", r8.text);
        jc1.k.f(IMiddlewareHostApp.class).centerIconToast(r7.getContext(), r0);
    L23:
        return null;
    L9:
        if (TextUtils.equals("prompt", r8.type) == false) goto L15;
        if (r8.position != 1) goto L13;
        com.bytedance.android.live.core.utils.f2.c(r8.text, 0);
        goto L23
    L13:
        IESUIUtils.displayToast(r7.getContext(), r8.text);
        goto L23
    L15:
        if (TextUtils.equals("image", r8.type) == false) goto L23;
        byte[] r1 = Base64.decode(r8.image.split(",")[1], 0);     // Catch: Exception -> L19
        Bitmap r2 = BitmapFactory.decodeByteArray(r1, 0, r1.length);     // Catch: Exception -> L19
    L21:
        if (r2 == null) goto L23;
        String r3 = rm3.c.a;
        rm3.c.c(r7.getContext(), r8.text, new BitmapDrawable(r2));
    L19:
        e = move-exception;
        e.printStackTrace();
        r2 = null;
        goto L21
    }
}
