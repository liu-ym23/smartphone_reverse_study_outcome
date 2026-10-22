package j6;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.lynx.jsbridge.LynxResourceModule;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements h6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18248c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JSONObject f18249h;

    public a(String r5, long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
        this.f18246a = r5;
        this.f18247b = r10;
        this.f18248c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        if (r16 != null) goto L5;
        this.f18249h = new JSONObject();
        return;
    L5:
        this.f18249h = r16;
    }

    @Override // h6.b
    public final String a() {
        return null;
    }

    @Override // h6.b
    public final boolean b(JSONObject r5) {
        return false;
    }

    @Override // h6.b
    public final JSONObject c() {
        String r5 = this.f;
        String r10 = this.e;
        String r11 = this.f18246a;
        if (TextUtils.isEmpty(r11) == false) goto L18;
        return null;
    L18:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L17
        r12.put("log_type", r11);     // Catch: Exception -> L17
        r12.put("duration", this.f18247b);     // Catch: Exception -> L17
        r12.put(LynxResourceModule.URI_KEY, Uri.parse(this.d));     // Catch: Exception -> L17
        long r13 = this.f18248c;     // Catch: Exception -> L17
        if (r13 <= 0) goto L8;
        r12.put("timestamp", r13);     // Catch: Exception -> L17
    L8:
        r12.put(NotificationCompat.CATEGORY_STATUS, this.g);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r10) == true) goto L13;
        r12.put("ip", r10);     // Catch: Exception -> L17
    L13:
        if (TextUtils.isEmpty(r5) == true) goto L15;
        r12.put("trace_code", r5);     // Catch: Exception -> L17
    L16:
        return r12;
    L15:
        r12.put("trace_code", "");     // Catch: Exception -> L17
    L17:
        return null;
    }

    @Override // h6.b
    public final boolean d() {
        return true;
    }

    @Override // h6.b
    public final String e() {
        return null;
    }
}
