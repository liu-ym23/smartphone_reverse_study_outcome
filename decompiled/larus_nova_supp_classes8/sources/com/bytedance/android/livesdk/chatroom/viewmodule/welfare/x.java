package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.utils.q4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x extends b7.a {
    public final /* synthetic */ WelfareProjectCardWidget a;

    public x(WelfareProjectCardWidget r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r4) {
        WelfareProjectCardWidget r0 = this.a;
        int r1 = WelfareProjectCardWidget.h;
        if (r0.isViewValid() == false) goto L28;
        if (r4 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r4);
    L7:
        ImageView r5 = r0.d;
        if (r5 == null) goto L25;
        UtilityKotlinExtentionsKt.w(r5);
    L25:
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L22
        r6.put("type", "init");     // Catch: JSONException -> L22
        r6.put("log", r0.wq());     // Catch: JSONException -> L22
        if (TextUtils.isEmpty("H5_roomStatusChange") == false) goto L13;
    L18:
        q4.b r7 = r0.f;     // Catch: JSONException -> L22
        if (r7 == null) goto L27;
        r7.c();     // Catch: JSONException -> L22
        return;
    L27:
        return;
    L13:
        if (SettingKeyUtils.b() == false) goto L18;
        IHybridComponent r2 = r0.b;     // Catch: JSONException -> L22
        if (r2 == null) goto L18;
        r2.sendJsEvent("H5_roomStatusChange", r6);     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
