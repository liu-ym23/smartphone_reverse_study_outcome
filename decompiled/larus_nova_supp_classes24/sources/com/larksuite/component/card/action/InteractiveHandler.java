package com.larksuite.component.card.action;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.HttpMethod;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.request.HttpHeaders;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.sdk.SdkSender;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Objects;
import okio.ByteString;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class InteractiveHandler {
    public InteractiveHandler() {
    }

    public static boolean d(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return false;
    L5:
        if (r1.startsWith("sslocal://") == false) goto L8;
        return true;
    L8:
        Uri r2 = UriProtector.parse(r1);
        ova.f.m().getClass();
        if (ova.f.q(r2) == true) goto L11;
        return false;
    L11:
        return TextUtils.equals("/client/mini_program/open", r2.getPath());
    }

    public static String b(String r7, String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L31;
        if (d(r7) == false) goto L31;
        if (TextUtils.isEmpty(r8) == true) goto L43;
        String r2 = UriProtector.getQueryParameter(UriProtector.parse(r7), "bdp_launch_query");
        if (r2 != null) goto L37;
        JSONObject r3 = new JSONObject();
        r3.put("__trigger_id__", r8);     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        StringBuilder r9 = new StringBuilder("bdp_launch_query=");     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        r9.append(URLEncoder.encode(r3.toString(), "utf-8"));     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        int r1 = r7.length();     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        int r4 = r7.indexOf("?");     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        if (r4 > (-1)) goto L15;
        r7 = r7 + "?" + r9;     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
    L34:
        return r7;
    L15:
        if ((r1 - 1) != r4) goto L17;
        r7 = r7 + r9.toString();     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        goto L34
    L17:
        r7 = r7 + "&" + r9;     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
    L22:
        e = move-exception;
        Log.e("InteractiveHandler", "error:" + e.getMessage());
        return r7;
    L37:
        JSONObject r5 = new JSONObject(URLDecoder.decode(r2, "utf-8").replace("\\", ""));     // Catch: UnsupportedEncodingException -> L26 Throwable -> L28
        r5.put("__trigger_id__", r8);     // Catch: UnsupportedEncodingException -> L26 Throwable -> L28
        return e(r7, URLEncoder.encode(r5.toString(), "utf-8"));
    L28:
        e = move-exception;
        Log.e("InteractiveHandler", "error:" + e.getMessage());
        return r7;
    L43:
        return r7;
    L31:
        if (TextUtils.isEmpty(r8) == false) goto L42;
        fyb.e r10 = com.larksuite.component.card.monitor.b.a;
        com.larksuite.component.card.monitor.c r11 = com.larksuite.component.card.monitor.c.c;
        com.larksuite.component.card.monitor.b r0 = com.larksuite.component.card.monitor.b.c.a(r11);
        r0.setErrorMessage(((OPMonitorCode) r11).message);
        r0.flush();
        return r7;
    L42:
        return r7;
    }

    public static String e(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r2;
    L5:
        if (TextUtils.isEmpty("bdp_launch_query") == false) goto L7;
        return r2;
    L7:
        return r2.replaceAll("(bdp_launch_query=[^&]*)", "bdp_launch_query=" + r3);
    }

    public final void c(String r7, String r8) {
        JSONObject r0 = new JSONObject();
        r0.put("user_id", ty7.a.a().getLoginUserId());     // Catch: JSONException -> L5
        r0.put("message_id", r8);     // Catch: JSONException -> L5
        r0.put("trigger_code", r7);     // Catch: JSONException -> L5
    L7:
        final long r9 = System.currentTimeMillis();
        ArrayList r1 = new ArrayList();
        r1.add(new HttpHeader(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/json; charset=utf-8"));
        UserSendHttpRequest.Builder r2 = new UserSendHttpRequest.Builder().method(HttpMethod.POST);
        String r3 = String.format("https://%s/lark/card/api/bindTriggerCode", new Object[]{ty7.a.a().getDynamicDomain("open_msg_card")});
        Log.d("UrlConfig", "dynamicUrl:" + r3);
        UserSendHttpRequest.Builder r4 = r2.url(r3).headers(new HttpHeaderMap(r1)).body(ByteString.encodeUtf8(r0.toString()));
        r4.disable_cookie = Boolean.FALSE;
        Command r5 = Command.USER_SEND_HTTP;
        IGetDataCallback<UserSendHttpResponse> r6 = new AnonymousClass1(this, r9);
        final ProtoAdapter r10 = UserSendHttpResponse.ADAPTER;
        Objects.requireNonNull(r10);
        SdkSender.asynSendRequestNonWrap(r5, r4, r6, new e(r10));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void a(InteractiveHandler r2, boolean r3, String r4, long r5) {
        r2.getClass();
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L12
        if (r3 == false) goto L6;
        String r1 = "success";
    L7:
        r6.put("state", r1);     // Catch: Exception -> L12
        if (r3 == true) goto L10;
        r6.put("errorMsg", r4);     // Catch: Exception -> L12
    L10:
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L12
        r7.put("duration", System.currentTimeMillis() - r5);     // Catch: Exception -> L12
        MonitorUtils.monitorEvent("op_messagecard_trigger_code", r6, r7, null);     // Catch: Exception -> L12
        return;
    L6:
        r1 = "fail";
    L12:
        e = move-exception;
        Log.e("InteractiveHandler", e.getMessage(), e);
    }
}
