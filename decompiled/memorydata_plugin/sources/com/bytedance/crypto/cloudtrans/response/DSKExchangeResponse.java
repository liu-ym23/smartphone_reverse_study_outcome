package com.bytedance.crypto.cloudtrans.response;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudtrans.CloudDskBody;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DSKExchangeResponse {
    private static String DSK_BOE_URL = "https://ocean-secret-boe.bytedance.net/api/device/sharedKey/ex";
    private static String DSK_RESULT_BOE_URL = "https://ocean-secret-boe.bytedance.net/api/device/sharedKey/exResult";
    private static String DSK_RESULT_URL = "https://ocean-secret.oceancloudapi.com/api/device/sharedKey/exResult";
    private static String DSK_URL = "https://ocean-secret.oceancloudapi.com/api/device/sharedKey/ex";
    public static String SIGN_PUBLIC_KEY_BOE = "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEveLhMZvIaKypKND3AGzpwpAVWXHh\nhaiHQN6/WMgq2jE4vBR/6L0gO7ubgoU1Q1Yh9Q/qwz0+w6RN5rp0j13RiQ==\n-----END PUBLIC KEY-----";
    public static String SIGN_PUBLIC_KEY_PRO = "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEKALR6oZdBB8SHBCGj4XZDseXEIHo\nIIcL77rmRu6i97Ui5NDAFtTjjbyQPn7WayyZ0uTlMUIGyzdfIg1LLP1SZg==\n-----END PUBLIC KEY-----";
    public static final int STATUS_FAILED = 2;
    public static final int STATUS_SUCCESS = 1;
    private static final String TAG = "DSKExchangeResponse";
    private final String publicKey;
    private final String resultUrl;
    private final String url;

    public DSKExchangeResponse() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L5;
        this.url = DSK_BOE_URL;
        this.resultUrl = DSK_RESULT_BOE_URL;
        String r0 = SIGN_PUBLIC_KEY_BOE;
    L6:
        this.publicKey = r0;
        return;
    L5:
        this.url = DSK_URL;
        this.resultUrl = DSK_RESULT_URL;
        r0 = SIGN_PUBLIC_KEY_PRO;
        goto L6
    }

    public String constructBodyJson(String r2, String r3, long r4, int r6) {
        JSONObject r1 = new JSONObject();
        r1.put("app_id", r2);     // Catch: Exception -> L6
        r1.put("did", r3);     // Catch: Exception -> L6
        r1.put("key_version", r4);     // Catch: Exception -> L6
        r1.put("status", r6);     // Catch: Exception -> L6
        return r1.toString();
    L6:
        e = move-exception;
        throw new CloudTransException("constructBodyJson failed, " + e.getMessage());
    }

    public String dskExchangeByCert(String r4) {
        Response r3 = new OkHttpClient().newCall(new Request.Builder().url(this.url).addHeader(NetConst.KEY_CONTENT_TYPE, "application/json").addHeader("x-att-certchain", r4).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), "{}")).build()).execute();     // Catch: Exception -> L12
        if (r3.isSuccessful() == false) goto L11;
        if (r3.body() != null) goto L7;
        return null;
    L7:
        return r3.body().string();
    L11:
        throw new IOException("Unexpected code " + r3);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        throw new CloudTransException("dskExchange failed, " + e.getMessage());
    }

    public String dskExchangeByTempKey(String r3, String r4) {
        Response r2 = new OkHttpClient().newCall(new Request.Builder().url(this.url).addHeader(NetConst.KEY_CONTENT_TYPE, "application/json").addHeader("x-client-pubkey", r3).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), r4)).build()).execute();     // Catch: Exception -> L12
        if (r2.isSuccessful() == true) goto L5;
        LogUtils.d(TAG, "responseBody:" + r2.body().string());     // Catch: Exception -> L12
        throw new IOException("Unexpected code " + r2);     // Catch: Exception -> L12
    L5:
        if (r2.body() != null) goto L7;
        return null;
    L7:
        return r2.body().string();
    L12:
        e = move-exception;
        throw new CloudTransException("dskExchange failed, " + e.getMessage());
    }

    public String dskExchangeResult(String r3) {
        Response r2 = new OkHttpClient().newCall(new Request.Builder().url(this.resultUrl).addHeader(NetConst.KEY_CONTENT_TYPE, "application/json").post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), r3)).build()).execute();     // Catch: Exception -> L12
        if (r2.isSuccessful() == false) goto L11;
        if (r2.body() != null) goto L7;
        return null;
    L7:
        return r2.body().string();
    L11:
        throw new IOException("Unexpected code " + r2);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        throw new CloudTransException("dskExchangeResult failed, " + e.getMessage());
    }

    public String getPlublicKey() {
        return this.publicKey;
    }

    public CloudDskBody jsonParsing(String r4) {
        CloudDskBody r3 = new CloudDskBody();
        r3.bodyJson = r4;
        JSONObject r0 = new JSONObject(r4);     // Catch: Exception -> L9
        int r5 = r0.getInt("code");     // Catch: Exception -> L9
        r3.code = r5;     // Catch: Exception -> L9
        if (r5 != 200) goto L7;
        Log.i(TAG, "Request success!");     // Catch: Exception -> L9
        r3.msg = r0.getString(NotificationCompat.CATEGORY_MESSAGE);     // Catch: Exception -> L9
        r3.logId = r0.getString("log_id");     // Catch: Exception -> L9
        JSONObject r6 = r0.getJSONObject("data");     // Catch: Exception -> L9
        r3.data.cloudPublicKey = r6.getString("cloud_public_key");     // Catch: Exception -> L9
        r3.data.sharedKeyHash = r6.getString("shared_key_hash");     // Catch: Exception -> L9
        r3.data.keyVersion = r6.getLong("key_version");     // Catch: Exception -> L9
        r3.data.expectExpiryTime = r6.getLong("expect_expiry_time");     // Catch: Exception -> L9
        r3.data.signature = r6.getString("signature");     // Catch: Exception -> L9
    L8:
        return r3;
    L7:
        Log.e(TAG, "Request failed, error: " + r5);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        r3.code = -1;
        throw new CloudTransException("parse body json failed, " + e.getMessage());
    }
}
