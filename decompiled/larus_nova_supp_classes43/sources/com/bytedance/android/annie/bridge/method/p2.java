package com.bytedance.android.annie.bridge.method;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = com.bytedance.android.ec.core.event.a.VALUE_SHOW_TOAST)
public final class p2 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName("image")
        String image;

        @SerializedName("position")
        int position;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_STATUS)
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

    public p2() {
    }

    public final Object invoke(Object r10, CallContext r11) throws Exception {
        a r12 = (a) r10;
        if (TextUtils.isEmpty(r12.type) == false) goto L6;
        r12.type = "prompt";
    L6:
        if (r12.useOriginalToast.booleanValue() == false) goto L13;
        Toast r13 = Toast.makeText(r11.getContext(), r12.text, 0);
        if (r12.position != 1) goto L10;
        r13.setGravity(17, 0, 0);
    L11:
        r13.show();
    L30:
        return null;
    L10:
        r13.setGravity(48, 0, 0);
        goto L11
    L13:
        if (TextUtils.equals("icon", r12.type) == false) goto L16;
        String r0 = fa.a.a;
        fa.a.b(r11.getContext(), r12.text);
        goto L30
    L16:
        if (TextUtils.equals("prompt", r12.type) == false) goto L22;
        if (r12.position != 1) goto L20;
        com.bytedance.android.annie.util.c.a(r12.text);
        goto L30
    L20:
        String r1 = fa.a.a;
        fa.a.b(r11.getContext(), r12.text);
        goto L30
    L22:
        if (TextUtils.equals("image", r12.type) == false) goto L30;
        byte[] r14 = Base64.decode(r12.image.split(",")[1], 0);     // Catch: Exception -> L26
        Bitmap r15 = BitmapFactory.decodeByteArray(r14, 0, r14.length);     // Catch: Exception -> L26
    L28:
        if (r15 == null) goto L30;
        String r16 = fa.a.a;
        fa.a.a(r11.getContext(), r12.text, new BitmapDrawable(r15));
    L26:
        e = move-exception;
        e.printStackTrace();
        r15 = null;
        goto L28
    }
}
