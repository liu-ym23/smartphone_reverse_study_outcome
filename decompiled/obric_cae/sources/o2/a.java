package o2;

import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements m2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f9622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JSONObject f9624h;

    public a(String r8, long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
        this.f9617a = r8;
        this.f9618b = r10;
        this.f9619c = r11;
        this.f9620d = r12;
        this.f9621e = r13;
        this.f9622f = r14;
        this.f9623g = r15;
        if (r16 != null) goto L5;
        this.f9624h = new JSONObject();
        return;
    L5:
        this.f9624h = r16;
    }

    @Override // m2.c
    public final String a() {
        return null;
    }

    @Override // m2.c
    public final boolean b(JSONObject r8) {
        return false;
    }

    @Override // m2.c
    public final JSONObject c() {
        String r8 = this.f9622f;
        String r10 = this.f9621e;
        String r11 = this.f9617a;
        if (TextUtils.isEmpty(r11) == false) goto L18;
        return null;
    L18:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L17
        r12.put("log_type", r11);     // Catch: Exception -> L17
        r12.put("duration", this.f9618b);     // Catch: Exception -> L17
        r12.put("uri", Uri.parse(this.f9620d));     // Catch: Exception -> L17
        long r13 = this.f9619c;     // Catch: Exception -> L17
        if (r13 <= 0) goto L8;
        r12.put("timestamp", r13);     // Catch: Exception -> L17
    L8:
        r12.put("status", this.f9623g);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r10) == true) goto L13;
        r12.put("ip", r10);     // Catch: Exception -> L17
    L13:
        if (TextUtils.isEmpty(r8) == true) goto L15;
        r12.put("trace_code", r8);     // Catch: Exception -> L17
    L16:
        return r12;
    L15:
        r12.put("trace_code", "");     // Catch: Exception -> L17
    L17:
        return null;
    }

    @Override // m2.c
    public final boolean d() {
        return true;
    }

    @Override // m2.c
    public final String e() {
        return null;
    }
}
