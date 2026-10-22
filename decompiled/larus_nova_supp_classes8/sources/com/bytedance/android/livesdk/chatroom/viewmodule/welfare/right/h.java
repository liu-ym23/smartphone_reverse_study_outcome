package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.utils.q4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends b7.a {
    public final /* synthetic */ WelfareProjectBottomRightCardWidget a;

    public h(WelfareProjectBottomRightCardWidget r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r4) {
        if ((r4 instanceof WebView) == true) goto L5;
        r4 = null;
    L5:
        WebView r5 = (WebView) r4;
        if (r5 == null) goto L32;
        WelfareProjectBottomRightCardWidget r0 = this.a;
        int r1 = WelfareProjectBottomRightCardWidget.i;
        if (r0.isViewValid() == false) goto L34;
        UtilityKotlinExtentionsKt.w(r5);
        ImageView r6 = r0.d;
        if (r6 == null) goto L30;
        UtilityKotlinExtentionsKt.w(r6);
    L30:
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L27
        r7.put("type", "init");     // Catch: JSONException -> L27
        r7.put("log", r0.wq());     // Catch: JSONException -> L27
        if (SettingKeyUtils.b() == true) goto L17;
    L23:
        q4.b r8 = r0.f;     // Catch: JSONException -> L27
        if (r8 == null) goto L33;
        r8.c();     // Catch: JSONException -> L27
        return;
    L33:
        return;
    L17:
        if (r0.b == null) goto L23;
        if (TextUtils.isEmpty("H5_roomStatusChange") == true) goto L23;
        IHybridComponent r2 = r0.b;     // Catch: JSONException -> L27
        if (r2 == null) goto L23;
        r2.sendJsEvent("H5_roomStatusChange", r7);     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        ALogger.e("welfare_bottom_right", e.toString());
        return;
    L34:
        return;
    }
}
