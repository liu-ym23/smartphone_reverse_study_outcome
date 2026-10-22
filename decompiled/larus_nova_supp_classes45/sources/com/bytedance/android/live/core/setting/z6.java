package com.bytedance.android.live.core.setting;

import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z6 implements OnLiveWsMessageReceiveListener {
    public static final z6 a = null;

    public z6() {
    }

    public final void onReceiveConnectEvent(LiveWsConnectState r1, JSONObject r2) {
    }

    static {
        a = new z6();
    }

    public final void onReceiveMsg(LiveWsMessage r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.E2.getValue()).booleanValue() == false) goto L7;
        Toast.makeText(jc1.a.b(), "receive setting update notify by frontier", 0).show();
    L7:
        e7.a("receive setting change ws message");
        if (f7.b > 0) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == true) goto L16;
        e7.a("ignore setting change ws message due to current can not request lite");
        return;
    L16:
        HashMap r3 = new HashMap();
        List r9 = r8.getMsgHeaders();
        if (r9 == null) goto L37;
        ArrayList r4 = new ArrayList();
        Iterator r11 = r9.iterator();
    L20:
        if (r11.hasNext() == false) goto L33;
        Object r5 = r11.next();
        LiveWsMessage.MsgHeader r6 = (LiveWsMessage.MsgHeader) r5;
        if (TextUtils.isEmpty(r6.getKey()) == false) goto L24;
    L30:
        boolean r7 = false;
    L31:
        if (r7 == false) goto L20;
        r4.add(r5);
        goto L20
    L24:
        if (TextUtils.isEmpty(r6.getValue()) == true) goto L30;
        String r12 = r6.getKey();
        if (r12 == null) goto L30;
        if (StringsKt.startsWith(r12, "x-im", true) != true) goto L30;
        r7 = true;
        goto L31
    L33:
        Iterator r13 = r4.iterator();
    L35:
        if (r13.hasNext() == false) goto L37;
        LiveWsMessage.MsgHeader r0 = (LiveWsMessage.MsgHeader) r13.next();
        r3.put(r0.getKey(), r0.getValue());
    L37:
        e7.a("start request setting lite");
        TTLiveSettingUtil.requestLite(r3);
        return;
    L10:
        if ((System.currentTimeMillis() - f7.b) <= 5000) goto L12;
        r2 = true;
        goto L13
    }
}
