package r4;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    public String H;
    public String I;
    public String J;
    public String K;
    public long L;
    public long M;

    public c() {
    }

    public c(String r8, String r10, String r11, String r12) {
        l(0);
        this.H = "event_v1";
        this.I = r10;
        this.J = r11;
        this.L = 0;
        this.M = 0;
        this.K = r12;
        this.f11461w = r8;
    }

    @Override // r4.a
    public final List<String> e() {
        List<String> r14 = super.e();
        ArrayList r8 = new ArrayList(r14.size());
        r8.addAll(r14);
        r8.addAll(Arrays.asList(new String[]{"category", "varchar", LocationMonitorConst.TAG, "varchar", "value", MultiProcessSharedProvider.INT_TYPE, "ext_value", MultiProcessSharedProvider.INT_TYPE, "params", "varchar", "label", "varchar"}));
        return r8;
    }

    @Override // r4.a
    public final String f() {
        return this.K;
    }

    @Override // r4.a
    public final String g() {
        return "" + this.I + ", " + this.J;
    }

    @Override // r4.a
    public final String i() {
        return "event";
    }

    @Override // r4.a
    public final void j(Cursor r8) {
        super.j(r8);
        this.H = r8.getString(18);
        this.I = r8.getString(19);
        this.L = r8.getLong(20);
        this.M = r8.getLong(21);
        this.K = r8.getString(22);
        this.J = r8.getString(23);
    }

    @Override // r4.a
    public final a k(JSONObject r8) {
        super.k(r8);
        this.f11451m = r8.optLong("tea_event_index", 0);
        this.H = r8.optString("category", null);
        this.I = r8.optString(LocationMonitorConst.TAG, null);
        this.L = r8.optLong("value", 0);
        this.M = r8.optLong("ext_value", 0);
        this.K = r8.optString("params", null);
        this.J = r8.optString("label", null);
        return this;
    }

    @Override // r4.a
    public final void n(ContentValues r8) {
        super.n(r8);
        r8.put("category", this.H);
        r8.put(LocationMonitorConst.TAG, this.I);
        r8.put("value", Long.valueOf(this.L));
        r8.put("ext_value", Long.valueOf(this.M));
        r8.put("params", this.K);
        r8.put("label", this.J);
    }

    @Override // r4.a
    public final void o(JSONObject r8) {
        super.o(r8);
        r8.put("tea_event_index", this.f11451m);
        r8.put("category", this.H);
        r8.put(LocationMonitorConst.TAG, this.I);
        r8.put("value", this.L);
        r8.put("ext_value", this.M);
        r8.put("params", this.K);
        r8.put("label", this.J);
    }

    @Override // r4.a
    public final JSONObject p() {
        if (TextUtils.isEmpty(this.K) == true) goto L5;
        JSONObject r8 = new JSONObject(this.K);
    L6:
        if (r8 != null) goto L8;
        r8 = new JSONObject();
    L8:
        r8.put("local_time_ms", this.f11450b);
        r8.put("tea_event_index", this.f11451m);
        r8.put(QesdkUtils.TAGS.JSON_TAG_SESSION_ID, this.f11452n);
        c(r8);
        int r10 = this.f11457s;
        r5.e.a r11 = r5.e.a.f11506b;
        if (r10 == (-1)) goto L12;
        r8.put("nt", r10);
    L12:
        if (TextUtils.isEmpty(this.f11455q) == true) goto L14;
        r8.put("user_unique_id", this.f11455q);
    L14:
        r8.put("category", this.H);
        r8.put(LocationMonitorConst.TAG, this.I);
        r8.put("value", this.L);
        r8.put("ext_value", this.M);
        r8.put("label", this.J);
        r8.put("datetime", this.f11462x);
        if (TextUtils.isEmpty(this.f11456r) == true) goto L17;
        r8.put("ab_sdk_version", this.f11456r);
    L17:
        long r12 = this.A;
        if (r12 <= 0) goto L20;
        r8.put("event_id", r12);
    L20:
        long r13 = this.B;
        if (r13 <= 0) goto L23;
        r8.put("monitor_id", String.valueOf(r13));
    L23:
        int r14 = this.C;
        if (r14 <= 0) goto L26;
        r8.put("event_stained", r14);
    L26:
        return r8;
    L5:
        r8 = null;
        goto L6
    }
}
