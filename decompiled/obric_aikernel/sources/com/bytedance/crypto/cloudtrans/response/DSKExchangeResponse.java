package com.bytedance.crypto.cloudtrans.response;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudtrans.CloudDskBody;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import okhttp3.u;
import okhttp3.w;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
        String r10 = SIGN_PUBLIC_KEY_BOE;
    L6:
        this.publicKey = r10;
        return;
    L5:
        this.url = DSK_URL;
        this.resultUrl = DSK_RESULT_URL;
        r10 = SIGN_PUBLIC_KEY_PRO;
        goto L6
    }

    public String constructBodyJson(String r10, String r11, long r12, int r13) {
        JSONObject r14 = new JSONObject();
        r14.put("app_id", r10);     // Catch: Exception -> L6
        r14.put("did", r11);     // Catch: Exception -> L6
        r14.put("key_version", r12);     // Catch: Exception -> L6
        r14.put("status", r13);     // Catch: Exception -> L6
        return r14.toString();
    L6:
        e = move-exception;
        throw new CloudTransException("constructBodyJson failed, " + e.getMessage());
    }

    public String dskExchangeByCert(String r10) {
        z r11 = new w().A(new x.a().k(this.url).a(NetConst.KEY_CONTENT_TYPE, "application/json").a("x-att-certchain", r10).g(y.c(u.e(NetConst.CONTENT_TYPE), "{}")).b()).execute();     // Catch: Exception -> L12
        if (r11.B() == false) goto L11;
        if (r11.a() != null) goto L7;
        return null;
    L7:
        return r11.a().l();
    L11:
        throw new IOException("Unexpected code " + r11);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        throw new CloudTransException("dskExchange failed, " + e.getMessage());
    }

    public String dskExchangeByTempKey(String r10, String r11) {
        z r12 = new w().A(new x.a().k(this.url).a(NetConst.KEY_CONTENT_TYPE, "application/json").a("x-client-pubkey", r10).g(y.c(u.e(NetConst.CONTENT_TYPE), r11)).b()).execute();     // Catch: Exception -> L12
        if (r12.B() == true) goto L5;
        LogUtils.d(TAG, "responseBody:" + r12.a().l());     // Catch: Exception -> L12
        throw new IOException("Unexpected code " + r12);     // Catch: Exception -> L12
    L5:
        if (r12.a() != null) goto L7;
        return null;
    L7:
        return r12.a().l();
    L12:
        e = move-exception;
        throw new CloudTransException("dskExchange failed, " + e.getMessage());
    }

    public String dskExchangeResult(String r10) {
        z r11 = new w().A(new x.a().k(this.resultUrl).a(NetConst.KEY_CONTENT_TYPE, "application/json").g(y.c(u.e(NetConst.CONTENT_TYPE), r10)).b()).execute();     // Catch: Exception -> L12
        if (r11.B() == false) goto L11;
        if (r11.a() != null) goto L7;
        return null;
    L7:
        return r11.a().l();
    L11:
        throw new IOException("Unexpected code " + r11);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        throw new CloudTransException("dskExchangeResult failed, " + e.getMessage());
    }

    public String getPlublicKey() {
        return this.publicKey;
    }

    public CloudDskBody jsonParsing(String r10) {
        CloudDskBody r11 = new CloudDskBody();
        r11.bodyJson = r10;
        JSONObject r12 = new JSONObject(r10);     // Catch: Exception -> L9
        int r13 = r12.getInt("code");     // Catch: Exception -> L9
        r11.code = r13;     // Catch: Exception -> L9
        if (r13 != 200) goto L7;
        Log.i(TAG, "Request success!");     // Catch: Exception -> L9
        r11.msg = r12.getString(NotificationCompat.CATEGORY_MESSAGE);     // Catch: Exception -> L9
        r11.logId = r12.getString("log_id");     // Catch: Exception -> L9
        JSONObject r14 = r12.getJSONObject("data");     // Catch: Exception -> L9
        r11.data.cloudPublicKey = r14.getString("cloud_public_key");     // Catch: Exception -> L9
        r11.data.sharedKeyHash = r14.getString("shared_key_hash");     // Catch: Exception -> L9
        r11.data.keyVersion = r14.getLong("key_version");     // Catch: Exception -> L9
        r11.data.expectExpiryTime = r14.getLong("expect_expiry_time");     // Catch: Exception -> L9
        r11.data.signature = r14.getString("signature");     // Catch: Exception -> L9
    L8:
        return r11;
    L7:
        Log.e(TAG, "Request failed, error: " + r13);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        r11.code = -1;
        throw new CloudTransException("parse body json failed, " + e.getMessage());
    }
}
