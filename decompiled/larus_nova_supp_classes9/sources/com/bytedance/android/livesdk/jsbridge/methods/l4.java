package com.bytedance.android.livesdk.jsbridge.methods;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showToolTip")
public final class l4 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {
    public yo2.e a;

    public static final class a {

        @SerializedName("text")
        String text;

        @SerializedName("type")
        String type;

        public a() {
        }
    }

    public final void onTerminate() {
    }

    public l4() {
    }

    public final void invoke(Object r10, CallContext r11) throws Exception {
        a r13 = (a) r10;
        ls2.b r14 = ns2.a.a();
        if (r14 != null) goto L5;
    L7:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r15 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.l();
    L9:
        if ((r15 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) == false) goto L29;
        Map r16 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) r15).c;
        if (r16 == null) goto L29;
        if ("pk".equals(r13.type) == false) goto L15;
        ToolbarButton r0 = ToolbarButton.PK;
    L16:
        if (r0 == null) goto L29;
        if ("pk".equals(r13.type) == false) goto L20;
        ToolbarButton r1 = ToolbarButton.PK;
    L21:
        View r4 = (View) ((HashMap) r16).get(ExtendedToolbarButton.e(r1));
        if (r4 == null) goto L29;
        String r17 = r13.text;
        yo2.e r18 = this.a;
        if (r18 != null) goto L26;
    L28:
        View r19 = LayoutInflater.from(getCallContext().getContext()).inflate(2131565309, null);
        ((TextView) r19.findViewById(2131390805)).setText(r17);
        yo2.e r3 = new yo2.e(getCallContext().getContext());
        ((yo2.d) r3).m = 5;
        ((yo2.d) r3).d = r19;
        ((yo2.d) r3).e = 0;
        ((yo2.d) r3).n = true;
        ((yo2.d) r3).l = true;
        r3.a();
        this.a = r3;
        r3.i(r4, 1, 0, com.bytedance.android.live.core.utils.s1.f(1.0f), com.bytedance.android.live.core.utils.s1.f(-4.0f));
        goto L29
    L26:
        if (r18.h() == false) goto L28;
        this.a.d();
        goto L28
    L20:
        r1 = null;
        goto L21
    L15:
        r0 = null;
    L29:
        finishWithSuccess();
        return;
    L5:
        if (TextUtils.isEmpty(r14.r) == false) goto L7;
        r15 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.n(r14.r);
        goto L9
    }
}
