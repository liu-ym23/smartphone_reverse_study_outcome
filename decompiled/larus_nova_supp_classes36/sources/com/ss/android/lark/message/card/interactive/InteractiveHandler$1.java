package com.ss.android.lark.message.card.interactive;

import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import jrb.c;
import jrb.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class InteractiveHandler$1 implements IGetDataCallback<UserSendHttpResponse> {
    final /* synthetic */ a this$0;
    final /* synthetic */ long val$startTime;

    public void onError(ErrorResult r7) {
        a.a(this.this$0, false, r7.getMessage(), this.val$startTime);     // Catch: Exception -> L5
        Log.e("InteractiveHandler", "generateTokenForRefreshCard fail:" + r7.getMessage());     // Catch: Exception -> L5
        d r8 = d.d;     // Catch: Exception -> L5
        OPMonitor r0 = c.a(r8);     // Catch: Exception -> L5
        r0.setErrorMessage(((OPMonitorCode) r8).message);     // Catch: Exception -> L5
        r0.flush();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void onSuccess(UserSendHttpResponse r5) {
        JSONObject r1 = new JSONObject(r5.body.utf8());     // Catch: JSONException -> L9
        if (r1.optInt("code") != 0) goto L7;
        Log.d("InteractiveHandler", "generateTokenForRefreshCard success!");     // Catch: JSONException -> L9
    L13:
    L11:
        a.a(this.this$0, true, "", this.val$startTime);
        return;
    L7:
        Log.d("InteractiveHandler", "generateTokenForRefreshCard fail!" + r1.optString(INotificationHitPoint.NoticeType.MESSAGE));     // Catch: JSONException -> L9
        d r6 = d.d;     // Catch: JSONException -> L9
        OPMonitor r0 = c.a(r6);     // Catch: JSONException -> L9
        r0.setErrorMessage(((OPMonitorCode) r6).message);     // Catch: JSONException -> L9
        r0.flush();     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((UserSendHttpResponse) r1);
    }

    public InteractiveHandler$1(a r1, long r2) {
        this.this$0 = r1;
        this.val$startTime = r2;
    }
}
