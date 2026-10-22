package r4;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.lifecycle.s;
import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    public String H;
    public boolean I;
    public String J;
    public String K;

    public e(String r8, String r10) {
        this.f11461w = r8;
        this.J = r10;
    }

    @Override // r4.a
    public final List<String> e() {
        List<String> r12 = super.e();
        ArrayList r8 = new ArrayList(r12.size());
        r8.addAll(r12);
        r8.addAll(Arrays.asList(new String[]{"event", "varchar", "params", "varchar", "is_bav", MultiProcessSharedProvider.INT_TYPE, "disable_personalization", "varchar", "page_info", "varchar"}));
        return r8;
    }

    @Override // r4.a
    public final String f() {
        return this.H;
    }

    @Override // r4.a
    public final String g() {
        return this.J;
    }

    @Override // r4.a
    public String i() {
        return "eventv3";
    }

    @Override // r4.a
    public final void j(Cursor r8) {
        super.j(r8);
        this.J = r8.getString(18);
        this.H = r8.getString(19);
        boolean r10 = true;
        if (r8.getInt(20) == 1) goto L6;
        r10 = false;
    L6:
        this.I = r10;
        this.K = r8.getString(21);
        String r11 = r8.getString(22);
        if (TextUtils.isEmpty(r11) == true) goto L14;
        he.i.f(r11, "json");
        JSONObject r12 = new JSONObject(r11);     // Catch: Throwable -> L12
        String r13 = r12.optString("pid");     // Catch: Throwable -> L12
        he.i.e(r13, "optString(\"pid\")");     // Catch: Throwable -> L12
        String r14 = r12.optString("pName");     // Catch: Throwable -> L12
        he.i.e(r14, "optString(\"pName\")");     // Catch: Throwable -> L12
        String r15 = r12.optString("sdkPageId");     // Catch: Throwable -> L12
        he.i.e(r15, "optString(\"sdkPageId\")");     // Catch: Throwable -> L12
        v3.c.a r16 = new v3.c.a(r13, r14, r15);     // Catch: Throwable -> L12
    L15:
        this.E = r16;
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    L14:
        r16 = null;
        goto L15
    }

    @Override // r4.a
    public final a k(JSONObject r8) {
        super.k(r8);
        this.J = r8.optString("event", null);
        this.H = r8.optString("params", null);
        this.I = r8.optBoolean("is_bav", false);
        this.K = r8.optString("disable_personalization", null);
        return this;
    }

    @Override // r4.a
    public final void n(ContentValues r8) {
        super.n(r8);
        r8.put("event", this.J);
        String r10 = this.H;
        r3.c r11 = r3.b.a(this.f11461w);
        String r12 = null;
        if (r11 == null) goto L5;
        s r13 = r11.M;
    L6:
        if (r13 == null) goto L13;
        Iterator r14 = ((List) r13.f2194b).iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        l4.b r15 = (l4.b) r14.next();
        if ((r15 instanceof l4.a) == false) goto L9;
        r10 = ((l4.a) r15).b(this, r10);
    L13:
        r8.put("params", r10);
        r8.put("is_bav", Integer.valueOf(this.I ? 1 : 0));
        r8.put("disable_personalization", this.K);
        v3.c.a r16 = this.E;
        if (r16 == null) goto L16;
        JSONObject r17 = new JSONObject();
        r17.put("pid", r16.f12716a);
        r17.put("pName", r16.f12717b);
        r17.put("sdkPageId", r16.f12718c);
        r12 = r17.toString();
        he.i.e(r12, "JSONObject().apply {\n   …\n            }.toString()");
    L16:
        r8.put("page_info", r12);
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // r4.a
    public final void o(JSONObject r8) {
        super.o(r8);
        r8.put("event", this.J);
        r8.put("params", this.H);
        r8.put("is_bav", this.I);
        r8.put("disable_personalization", this.K);
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
        r8.put("event", this.J);
        if (this.I == false) goto L9;
        r8.put("is_bav", 1);
    L9:
        if (TextUtils.isEmpty(this.H) == true) goto L22;
        JSONObject r10 = new JSONObject(this.H);
        r3.c r11 = r3.b.a(this.f11461w);
        if (r11 == null) goto L13;
        s r12 = r11.M;
    L14:
        if (r12 == null) goto L21;
        Iterator r13 = ((List) r12.f2194b).iterator();
    L17:
        if (r13.hasNext() == false) goto L21;
        l4.b r14 = (l4.b) r13.next();
        if ((r14 instanceof l4.a) == false) goto L17;
        r10 = ((l4.a) r14).c(r10);
    L21:
        r8.put("params", r10);
        goto L22
    L13:
        r12 = null;
    L22:
        int r15 = this.f11457s;
        r5.e.a r16 = r5.e.a.f11506b;
        if (r15 == (-1)) goto L25;
        r8.put("nt", r15);
    L25:
        r8.put("datetime", this.f11462x);
        if (TextUtils.isEmpty(this.f11456r) == true) goto L29;
        r8.put("ab_sdk_version", this.f11456r);
    L29:
        if (TextUtils.isEmpty(this.K) == true) goto L31;
        r8.put("disable_personalization", Integer.valueOf(this.K));
    L31:
        long r17 = this.A;
        if (r17 <= 0) goto L34;
        r8.put("event_id", r17);
    L34:
        long r18 = this.B;
        if (r18 <= 0) goto L37;
        r8.put("monitor_id", String.valueOf(r18));
    L37:
        int r19 = this.C;
        if (r19 <= 0) goto L40;
        r8.put("event_stained", r19);
    L40:
        v3.c.a r20 = this.E;
        if (r20 == null) goto L43;
        r8.putOpt("__pid", r20.f12716a);
        r8.putOpt("__pname", r20.f12717b);
        r8.putOpt("__sdk_pid", r20.f12718c);
    L43:
        return r8;
    }

    public void q(m4.a r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(this.J) == false) goto L6;
        this.f11463y = -1;
        return;
    L6:
        r8.getClass();
        r8.getClass();
        throw null;
    }

    public e(String r8, String r10, String r11, int r12) {
        this.f11461w = r8;
        this.J = r10;
        this.I = false;
        this.H = r11;
        r3.b.a(r8);
    }
}
