package com.bytedance.crypto.cloudtrans.response;

import com.bytedance.crypto.cloudtrans.CloudDskBody;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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

    public String constructBodyJson(String r3, String r4, long r5, int r7) {
        JSONObject r0 = new JSONObject();
        r0.put("app_id", r3);     // Catch: Exception -> L6
        r0.put("did", r4);     // Catch: Exception -> L6
        r0.put("key_version", r5);     // Catch: Exception -> L6
        r0.put("status", r7);     // Catch: Exception -> L6
        return r0.toString();
    L6:
        e = move-exception;
        throw new CloudTransException("constructBodyJson failed, " + e.getMessage());
    }

    public String dskExchangeByCert(String r6) {
        Response r7 = new OkHttpClient().newCall(new Request.Builder().url(this.url).addHeader("Content-Type", "application/json").addHeader("x-att-certchain", r6).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), "{}")).build()).execute();     // Catch: Exception -> L13
        if (r7.isSuccessful() == false) goto L12;
        if (r7.body() != null) goto L8;
        return null;
    L8:
        return r7.body().string();
    L12:
        throw new IOException("Unexpected code " + r7);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        throw new CloudTransException("dskExchange failed, " + e.getMessage());
    }

    public String dskExchangeByTempKey(String r6, String r7) {
        Response r8 = new OkHttpClient().newCall(new Request.Builder().url(this.url).addHeader("Content-Type", "application/json").addHeader("x-client-pubkey", r6).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), r7)).build()).execute();     // Catch: Exception -> L13
        if (r8.isSuccessful() == true) goto L6;
        LogUtils.d(TAG, "responseBody:" + r8.body().string());     // Catch: Exception -> L13
        throw new IOException("Unexpected code " + r8);     // Catch: Exception -> L13
    L6:
        if (r8.body() != null) goto L8;
        return null;
    L8:
        return r8.body().string();
    L13:
        e = move-exception;
        throw new CloudTransException("dskExchange failed, " + e.getMessage());
    }

    public String dskExchangeResult(String r5) {
        Response r6 = new OkHttpClient().newCall(new Request.Builder().url(this.resultUrl).addHeader("Content-Type", "application/json").post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), r5)).build()).execute();     // Catch: Exception -> L13
        if (r6.isSuccessful() == false) goto L12;
        if (r6.body() != null) goto L8;
        return null;
    L8:
        return r6.body().string();
    L12:
        throw new IOException("Unexpected code " + r6);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        throw new CloudTransException("dskExchangeResult failed, " + e.getMessage());
    }

    public String getPlublicKey() {
        return this.publicKey;
    }

    public CloudDskBody jsonParsing(String r5) {
        CloudDskBody r0 = new CloudDskBody();
        r0.bodyJson = r5;
        JSONObject r1 = new JSONObject(r5);     // Catch: Exception -> L8
        int r6 = JSONObjectProtectorUtils.getInt(r1, "code");     // Catch: Exception -> L8
        r0.code = r6;     // Catch: Exception -> L8
        if (r6 != 200) goto L7;
        r0.msg = JSONObjectProtectorUtils.getString(r1, "msg");     // Catch: Exception -> L8
        r0.logId = JSONObjectProtectorUtils.getString(r1, "log_id");     // Catch: Exception -> L8
        JSONObject r7 = JSONObjectProtectorUtils.getJSONObject(r1, "data");     // Catch: Exception -> L8
        r0.data.cloudPublicKey = JSONObjectProtectorUtils.getString(r7, "cloud_public_key");     // Catch: Exception -> L8
        r0.data.sharedKeyHash = JSONObjectProtectorUtils.getString(r7, "shared_key_hash");     // Catch: Exception -> L8
        r0.data.keyVersion = JSONObjectProtectorUtils.getLong(r7, "key_version");     // Catch: Exception -> L8
        r0.data.expectExpiryTime = JSONObjectProtectorUtils.getLong(r7, "expect_expiry_time");     // Catch: Exception -> L8
        r0.data.signature = JSONObjectProtectorUtils.getString(r7, "signature");     // Catch: Exception -> L8
    L7:
        return r0;
    L8:
        e = move-exception;
        r0.code = -1;
        throw new CloudTransException("parse body json failed, " + e.getMessage());
    }
}
