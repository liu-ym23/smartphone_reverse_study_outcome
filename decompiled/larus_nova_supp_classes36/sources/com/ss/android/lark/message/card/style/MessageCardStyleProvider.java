package com.ss.android.lark.message.card.style;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.ee.lark.infra.storage.kv.LarkOpKVStorage;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.HttpMethod;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.setting.MessageCardStyleSetting;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.storage.LarkKVStorage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import okio.ByteString;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MessageCardStyleProvider {
    public HashMap<String, HashMap<String, String>> a;

    public class a implements SdkSender.IParser<SendHttpResponse> {
        public a() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return (SendHttpResponse) SendHttpResponse.ADAPTER.decode(r2);
        }
    }

    public MessageCardStyleProvider() {
    }

    public final synchronized HashMap a() {
        monitor-enter(this);
        HashMap<String, HashMap<String, String>> r0 = this.a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static com.ss.android.lark.storage.kv.repo.a b() {
        Lazy r0 = LarkOpKVStorage.a;
        return LarkKVStorage.q(new com.ss.android.lark.storage.a("open_platform"), true);
    }

    public final void c() {
        Log.d("MessageCardStyleProvider", "msg card init begin");
        hrb.a r1 = com.ss.android.lark.message.card.b.a();
        Context r2 = r1.getContext();
        int r3 = 42;
        com.ss.android.lark.storage.kv.repo.a r4 = b();     // Catch: Throwable -> L13
        int r5 = r4.getInt("msg_card_style_narrow_version", -1);     // Catch: Throwable -> L13
        String r6 = r4.getString("msg_card_style_narrow_content", null);     // Catch: Throwable -> L13
        int r7 = Math.max(42, r5);     // Catch: Throwable -> L13
        FileUtils.getFilesDirPath(r2);     // Catch: Throwable -> L11
        String r8 = File.separator;     // Catch: Throwable -> L11
        if (r5 >= 42) goto L7;
    L9:
        d(r2);     // Catch: Throwable -> L11
    L10:
        f(r1, r7);
    L16:
        e(r1);
        return;
    L7:
        if (TextUtils.isEmpty(r6) == true) goto L9;
        Log.d("MessageCardStyleProvider", "kv content is in use");     // Catch: Throwable -> L11
        h(g(new JSONObject(r6).optJSONObject("style")));     // Catch: Throwable -> L11
    L11:
        th = th;
        r3 = r7;
    L21:
        Log.e("MessageCardStyleProvider", "process local style failed", th);     // Catch: Throwable -> L18
        f(r1, r3);
    L18:
        th = move-exception;
        f(r1, r3);
        e(r1);
        throw th;
    L13:
        th = th;
        goto L21
    }

    public static HashMap g(JSONObject r14) {
        if (r14 != null) goto L6;
        Log.e("MessageCardStyleProvider", "parse null json style");
        return new HashMap();
    L6:
        HashMap r1 = new HashMap(r14.length());
        Iterator<String> r2 = r14.keys();
    L8:
        if (r2.hasNext() == false) goto L27;
        String r3 = r2.next();
        String r4 = r14.optString(r3);
        if (TextUtils.isEmpty(r4) == true) goto L11;
        if (r4.contains(";") == false) goto L14;
        String[] r5 = r4.split(";");
        HashMap r7 = new HashMap(r5.length);
        int r8 = r5.length;
        int r10 = 0;
    L16:
        if (r10 >= r8) goto L26;
        String r11 = r5[r10];
        if (r11.contains(":") == true) goto L20;
        Log.w("MessageCardStyleProvider", "style " + r3 + " is invalid styleValue=" + r4);
    L25:
        r10 = r10 + 1;
        goto L16
    L20:
        String[] r12 = r11.split(":");
        if (r12 == null) goto L25;
        if (r12.length != 2) goto L25;
        r7.put(r12[0], r12[1]);
        goto L25
    L26:
        r1.put(r3, r7);
        goto L8
    L14:
        Log.w("MessageCardStyleProvider", "style " + r3 + " is invalid");
        Log.d("MessageCardStyleProvider", "style " + r3 + "=" + r4 + " is invalid");
        goto L8
    L11:
        Log.w("MessageCardStyleProvider", "style " + r3 + " is null");
        goto L8
    L27:
        return r1;
    }

    public final void d(Context r3) {
        InputStream r4 = r3.getAssets().open("default_card_style.json");     // Catch: Exception -> L15
        i(Okio.buffer(Okio.source(r4)).readUtf8());     // Catch: Throwable -> L8
        Log.i("MessageCardStyleProvider", "loadDefaultStyleFromJson success ");     // Catch: Throwable -> L8
        if (r4 == null) goto L23;
        r4.close();     // Catch: Exception -> L15
        return;
    L23:
        return;
    L8:
        th = move-exception;
        if (r4 != null) goto L20;
    L14:
        throw th;     // Catch: Exception -> L15
    L20:
        r4.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.e("MessageCardStyleProvider", "process loadStyleFromJson", e);
    }

    public final void e(hrb.a r5) {
        if (r5.getFgValue("message_card.gray.enable_setting") == true) goto L6;
        Log.d("MessageCardStyleProvider", "msg card gray style close");
        return;
    L6:
        MessageCardStyleSetting r6 = (MessageCardStyleSetting) SettingManager.getInstance().get(MessageCardStyleSetting.class);
        if (r6 != null) goto L9;
    L19:
        Log.i("MessageCardStyleProvider", "msg card gray style res setting is null");
        return;
    L9:
        if (TextUtils.isEmpty(r6.grayResUrl) == true) goto L19;
        String r1 = b().getString("msg_card_style_narrow_content_gray", null);
        if (TextUtils.isEmpty(r1) == false) goto L21;
    L17:
        SdkSender.asynSendRequestNonWrap(Command.SEND_HTTP, new SendHttpRequest.Builder().method(SendHttpRequest.Method.GET).url(r6.grayResUrl), new AnonymousClass3(this), new a());
        return;
    L21:
        h(g(new JSONObject(r1).optJSONObject("style")));     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        Log.e("MessageCardStyleProvider", "gray card style parse error e=" + e.getMessage());
        goto L17
    }

    public final synchronized void h(HashMap r1) {
        monitor-enter(this);
        this.a = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void i(String r6) throws JSONException {
        Log.d("MessageCardStyleProvider", "card style size=" + r6.length());
        JSONObject r7 = new JSONObject(r6).optJSONObject("narrow");
        h(g(r7.optJSONObject("style")));
        com.ss.android.lark.storage.kv.repo.a r0 = b();
        r0.putInt("msg_card_style_narrow_version", r7.optInt("version"));
        r0.putString("msg_card_style_narrow_content", r7.toString());
        Log.d("MessageCardStyleProvider", "assets version=" + r7.optInt("version") + " code version=42");
    }

    public final void f(hrb.a r5, int r6) {
        String r7 = String.format("https://%s/lark/card/api/GetCardStyle", new Object[]{r5.getDynamicDomain("open_msg_card")});
        Log.d("MessageCardStyleProvider", "pull style url=" + r7 + " narrowVersion=" + r6 + " wideVersion=2147483647");
        JSONObject r0 = new JSONObject();
        r0.put("narrow_version", r6);     // Catch: JSONException -> L6
        r0.put("wide_version", Integer.MAX_VALUE);     // Catch: JSONException -> L6
        ArrayList r8 = new ArrayList();
        r8.add(new HttpHeader(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/json; charset=utf-8"));
        UserSendHttpRequest.Builder r9 = new UserSendHttpRequest.Builder().method(HttpMethod.POST).url(r7).headers(new HttpHeaderMap(r8)).body(ByteString.encodeUtf8(r0.toString()));
        r9.disable_cookie = Boolean.FALSE;
        SdkSender.asynSendRequestNonWrap(Command.USER_SEND_HTTP, r9, new AnonymousClass1(this), new b());
        return;
    L6:
        e = move-exception;
        Log.e("MessageCardStyleProvider", "put version to body", e);
    }
}
