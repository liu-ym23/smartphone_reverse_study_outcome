package r4;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k extends a {
    public long H;
    public long I;
    public String J;
    public String K;

    public k() {
    }

    @Override // r4.a
    public final List<String> e() {
        return null;
    }

    @Override // r4.a
    public final String g() {
        return String.valueOf(this.H);
    }

    @Override // r4.a
    public final String i() {
        return "terminate";
    }

    @Override // r4.a
    public final void j(Cursor r8) {
        List<String> r10 = this.D;
        h().a(4, r10, "read db not implemented", new Object[0]);
    }

    @Override // r4.a
    public final a k(JSONObject r8) {
        List<String> r10 = this.D;
        h().a(4, r10, "read ipc not implemented", new Object[0]);
        return this;
    }

    @Override // r4.a
    public final void n(ContentValues r8) {
        List<String> r10 = this.D;
        h().a(4, r10, "write db not implemented", new Object[0]);
    }

    @Override // r4.a
    public final void o(JSONObject r8) {
        List<String> r10 = this.D;
        h().a(4, r10, "write ipc not implemented", new Object[0]);
    }

    @Override // r4.a
    public final JSONObject p() {
        JSONObject r8 = new JSONObject();
        r8.put("local_time_ms", this.f11450b);
        r8.put("tea_event_index", this.f11451m);
        r8.put(QesdkUtils.TAGS.JSON_TAG_SESSION_ID, this.f11452n);
        r8.put("stop_timestamp", this.I / 1000);
        r8.put("duration", this.H / 1000);
        r8.put("datetime", this.f11462x);
        c(r8);
        if (TextUtils.isEmpty(this.f11455q) == true) goto L6;
        r8.put("user_unique_id", this.f11455q);
    L6:
        if (TextUtils.isEmpty(this.f11456r) == true) goto L9;
        r8.put("ab_sdk_version", this.f11456r);
    L9:
        if (TextUtils.isEmpty(this.J) == true) goto L14;
        r8.put("uuid_changed", true);
        if (TextUtils.equals(this.J, this.f11452n) == true) goto L14;
        r8.put("original_session_id", this.J);
    L14:
        if (TextUtils.isEmpty(null) == true) goto L17;
        r8.put("from_session", null);
    L17:
        if (TextUtils.isEmpty(null) == true) goto L19;
        r8.put("to_session", null);
    L19:
        long r10 = this.A;
        if (r10 <= 0) goto L22;
        r8.put("event_id", r10);
    L22:
        long r11 = this.B;
        if (r11 <= 0) goto L25;
        r8.put("monitor_id", String.valueOf(r11));
    L25:
        int r12 = this.C;
        if (r12 <= 0) goto L29;
        r8.put("event_stained", r12);
    L29:
        if (TextUtils.isEmpty(this.K) == false) goto L42;
    L41:
        return r8;
    L42:
        JSONObject r13 = new JSONObject(this.K);     // Catch: Throwable -> L39
        Iterator<String> r14 = r13.keys();     // Catch: Throwable -> L39
    L32:
        if (r14.hasNext() == false) goto L41;
        String r15 = r14.next();     // Catch: Throwable -> L39
        if (r8.has(r15) == false) goto L36;
        h().f(4, this.D, "Add flat params to terminate conflict: {} - {}", new Object[]{r15, r13.opt(r15)});     // Catch: Throwable -> L39
        goto L32
    L36:
        r8.put(r15, r13.opt(r15));     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        h().m(4, this.D, "Add params to terminate error", th, new Object[0]);
        goto L41
    }
}
