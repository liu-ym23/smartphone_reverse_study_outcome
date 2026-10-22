package o6;

import android.util.Log;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.cae.userAware.datacollection.NetworkClient;
import java.io.IOException;
import n6.c;
import org.json.JSONObject;
import q6.b;
import we.a0;
import we.c0;
import we.t;
import we.v;
import we.x;
import we.y;
import we.z;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9757c;

    public a() {
        m6.a r8 = b.a().f10170a;
        if (r8 == null) goto L5;
        boolean r10 = r8.onIsBoeEnv();
    L6:
        if (r10 == false) goto L8;
        this.f9755a = "https://ocean-secret-boe.bytedance.net/api/device/sharedKey/ex";
        this.f9756b = "https://ocean-secret-boe.bytedance.net/api/device/sharedKey/exResult";
        String r11 = "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEveLhMZvIaKypKND3AGzpwpAVWXHh\nhaiHQN6/WMgq2jE4vBR/6L0gO7ubgoU1Q1Yh9Q/qwz0+w6RN5rp0j13RiQ==\n-----END PUBLIC KEY-----";
    L9:
        this.f9757c = r11;
        return;
    L8:
        this.f9755a = "https://ocean-secret.oceancloudapi.com/api/device/sharedKey/ex";
        this.f9756b = "https://ocean-secret.oceancloudapi.com/api/device/sharedKey/exResult";
        r11 = "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEKALR6oZdBB8SHBCGj4XZDseXEIHo\nIIcL77rmRu6i97Ui5NDAFtTjjbyQPn7WayyZ0uTlMUIGyzdfIg1LLP1SZg==\n-----END PUBLIC KEY-----";
        goto L9
    L5:
        r10 = false;
        goto L6
    }

    public static String a(long r8, int r10, String r11, String r12) {
        JSONObject r13 = new JSONObject();
        r13.put("app_id", r11);     // Catch: Exception -> L6
        r13.put("did", r12);     // Catch: Exception -> L6
        r13.put("key_version", r8);     // Catch: Exception -> L6
        r13.put("status", r10);     // Catch: Exception -> L6
        return r13.toString();
    L6:
        e = move-exception;
        throw new c("constructBodyJson failed, " + e.getMessage());
    }

    public static n6.a c(String r8) {
        n6.a r10 = new n6.a();
        n6.a.C0118a r11 = r10.f9440b;
        r10.f9441c = r8;
        JSONObject r12 = new JSONObject(r8);     // Catch: Exception -> L9
        int r13 = r12.getInt("code");     // Catch: Exception -> L9
        r10.f9439a = r13;     // Catch: Exception -> L9
        if (r13 != 200) goto L7;
        Log.i("DSKExchangeResponse", "Request success!");     // Catch: Exception -> L9
        r12.getString("msg");     // Catch: Exception -> L9
        r12.getString("log_id");     // Catch: Exception -> L9
        JSONObject r14 = r12.getJSONObject("data");     // Catch: Exception -> L9
        r11.f9442a = r14.getString("cloud_public_key");     // Catch: Exception -> L9
        r11.f9443b = r14.getString("shared_key_hash");     // Catch: Exception -> L9
        r11.f9444c = r14.getLong("key_version");     // Catch: Exception -> L9
        r11.f9445d = r14.getLong("expect_expiry_time");     // Catch: Exception -> L9
        r11.f9446e = r14.getString("signature");     // Catch: Exception -> L9
    L8:
        return r10;
    L7:
        Log.e("DSKExchangeResponse", "Request failed, error: " + r13);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        r10.f9439a = -1;
        throw new c("parse body json failed, " + e.getMessage());
    }

    public final String b(String r8) {
        z r10 = z.create(t.a("application/json; charset=utf-8"), r8);     // Catch: Exception -> L13
        y.a r11 = new y.a();     // Catch: Exception -> L13
        r11.e(this.f9756b);     // Catch: Exception -> L13
        r11.f13347d.a("Content-Type", NetworkClient.UPLOAD_FILE_TYPE_JSON);     // Catch: Exception -> L13
        r11.c(r10, HttpMethodContrants.POST);     // Catch: Exception -> L13
        a0 r12 = x.f(new v(), r11.a(), false).d();     // Catch: Exception -> L13
        if (r12.r() == false) goto L12;
        c0 r13 = r12.f13120q;     // Catch: Exception -> L13
        if (r13 != null) goto L8;
        return null;
    L8:
        return r13.n();
    L12:
        throw new IOException("Unexpected code " + r12);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        throw new c("dskExchangeResult failed, " + e.getMessage());
    }
}
