package com.ss.android.lark.contact.base.statistics;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class InvHitPoint extends q5c.a {
    public static String a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShareMethod {
        public static final String COPY_LINK = "copy_link";
        public static final String INVITE_EMAIL = "invite_email";
        public static final String INVITE_MESSAGE = "invite_message";
        public static final String SAVE_QR_CODE = "save_qr_code";
        public static final String SHARE_LINK = "share_link";
        public static final String SHARE_QR_CODE = "share_qr_code";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShareType {
        public static final String LINK = "link";
        public static final String QR_CODE = "qr_code";
    }

    public static JSONObject a() {
        return b(a);
    }

    public static JSONObject b(String r2) {
        a = r2;     // Catch: JSONException -> L4
        return new JSONObject().put("source", r2);
    L4:
        e = move-exception;
        Log.e("InvHitPoint", e);
        return new JSONObject();
    }

    public static void d(boolean r3) {
        JSONObject r1 = a();     // Catch: JSONException -> L8
        if (r3 == false) goto L5;
        int r4 = 1;
    L6:
        Statistics.sendEvent("invite_people_external_search_invite_cancel", r1.put("change_to", r4));     // Catch: JSONException -> L8
        return;
    L5:
        r4 = 0;
    L8:
        e = move-exception;
        Log.e("InvHitPoint", e.getMessage());
    }

    public static void e(boolean r3) {
        JSONObject r1 = a();     // Catch: JSONException -> L8
        if (r3 == false) goto L5;
        String r4 = "1";
    L6:
        Statistics.sendEvent("invite_people_external_search_invite_send", r1.put(ChameleonOpenTracker.ParamKey.RESULT, r4));     // Catch: JSONException -> L8
        return;
    L5:
        r4 = DocTabPayload.DocType.UNKNOWN;
    L8:
        e = move-exception;
        Log.e("InvHitPoint", e.getMessage());
    }

    public static void c(String r3, String r4) {
        JSONObject r1 = new JSONObject();
        r1.put(IPortraitService.TYPE, "link");     // Catch: JSONException -> L5
        r1.put("method", r3);     // Catch: JSONException -> L5
        r1.put("unique_id", r4);     // Catch: JSONException -> L5
        r1.put("platform", "android");     // Catch: JSONException -> L5
        Statistics.sendEvent("invite_people_h5_share", r1);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InvHitPoint", "failed to invitePeopleH5Share, e:" + e);
    }
}
