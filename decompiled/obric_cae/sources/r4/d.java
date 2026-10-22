package r4;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {
    public String H;
    public String I;

    public d(JSONObject r8) {
        this.I = "";
        this.H = r8.toString();
        this.f11461w = null;
    }

    @Override // r4.a
    public final List<String> e() {
        List<String> r8 = super.e();
        ArrayList r10 = new ArrayList(r8.size());
        r10.addAll(r8);
        r10.addAll(Arrays.asList(new String[]{"params", "varchar", "log_type", "varchar"}));
        return r10;
    }

    @Override // r4.a
    public final String f() {
        return this.H;
    }

    @Override // r4.a
    public final String g() {
        return "logType:" + this.I;
    }

    @Override // r4.a
    public final String i() {
        return "event_misc";
    }

    @Override // r4.a
    public final void j(Cursor r8) {
        super.j(r8);
        this.H = r8.getString(18);
        this.I = r8.getString(19);
    }

    @Override // r4.a
    public final a k(JSONObject r8) {
        super.k(r8);
        this.H = r8.optString("params", null);
        this.I = r8.optString("log_type", null);
        return this;
    }

    @Override // r4.a
    public final void n(ContentValues r8) {
        super.n(r8);
        r8.put("params", this.H);
        r8.put("log_type", this.I);
    }

    @Override // r4.a
    public final void o(JSONObject r8) {
        super.o(r8);
        r8.put("params", this.H);
        r8.put("log_type", this.I);
    }

    @Override // r4.a
    public final JSONObject p() {
        JSONObject r8 = new JSONObject();
        r8.put("local_time_ms", this.f11450b);
        r8.put("tea_event_index", this.f11451m);
        r8.put(QesdkUtils.TAGS.JSON_TAG_SESSION_ID, this.f11452n);
        c(r8);
        if (TextUtils.isEmpty(this.f11455q) == true) goto L5;
        r8.put("user_unique_id", this.f11455q);
    L5:
        r8.put("log_type", this.I);
        JSONObject r10 = new JSONObject(this.H);     // Catch: Exception -> L14
        Iterator<String> r11 = r10.keys();     // Catch: Exception -> L14
    L7:
        if (r11.hasNext() == false) goto L16;
        String r12 = r11.next();     // Catch: Exception -> L14
        Object r13 = r10.get(r12);     // Catch: Exception -> L14
        if (r8.opt(r12) == null) goto L12;
        h().f(4, this.D, "misc event exists key already!", new Object[0]);     // Catch: Exception -> L14
    L12:
        r8.put(r12, r13);     // Catch: Exception -> L14
    L16:
        long r14 = this.A;
        if (r14 <= 0) goto L19;
        r8.put("event_id", r14);
    L19:
        long r15 = this.B;
        if (r15 <= 0) goto L22;
        r8.put("monitor_id", String.valueOf(r15));
    L22:
        int r16 = this.C;
        if (r16 <= 0) goto L25;
        r8.put("event_stained", r16);
    L25:
        return r8;
    L14:
        e = move-exception;
        h().k(e, 4, "parse misc event params failed", new Object[0]);
        goto L16
    }
}
