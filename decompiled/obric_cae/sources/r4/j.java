package r4;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j extends a {
    public long H;
    public String I;
    public String J;
    public int K;
    public String L;
    public String M;

    public j() {
    }

    @Override // r4.a
    public final List<String> e() {
        List<String> r14 = super.e();
        ArrayList r8 = new ArrayList(r14.size());
        r8.addAll(r14);
        r8.addAll(Arrays.asList(new String[]{"page_key", "varchar", "refer_page_key", "varchar", "duration", MultiProcessSharedProvider.INT_TYPE, "is_back", MultiProcessSharedProvider.INT_TYPE, "last_session", "varchar", "flat_params", "varchar"}));
        return r8;
    }

    @Override // r4.a
    public final String g() {
        return this.J + ", " + this.H;
    }

    @Override // r4.a
    public final String i() {
        return "page";
    }

    @Override // r4.a
    public final void j(Cursor r8) {
        super.j(r8);
        this.J = r8.getString(18);
        this.I = r8.getString(19);
        this.H = r8.getLong(20);
        this.K = r8.getInt(21);
        this.L = r8.getString(22);
        this.M = r8.getString(23);
    }

    @Override // r4.a
    public final a k(JSONObject r8) {
        super.k(r8);
        this.J = r8.optString("page_key", null);
        this.I = r8.optString("refer_page_key", null);
        this.H = r8.optLong("duration", 0);
        this.K = r8.optInt("is_back", 0);
        return this;
    }

    @Override // r4.a
    public final void n(ContentValues r8) {
        super.n(r8);
        r8.put("page_key", this.J);
        r8.put("refer_page_key", this.I);
        r8.put("duration", Long.valueOf(this.H));
        r8.put("is_back", Integer.valueOf(this.K));
        r8.put("last_session", this.L);
        r8.put("flat_params", this.M);
    }

    @Override // r4.a
    public final void o(JSONObject r8) {
        super.o(r8);
        r8.put("page_key", this.J);
        r8.put("refer_page_key", this.I);
        r8.put("duration", this.H);
        r8.put("is_back", this.K);
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
        r8.put("event", "bav2b_page");
        r8.put("is_bav", 1);
        JSONObject r10 = new JSONObject();
        r10.put("page_key", this.J);
        r10.put("refer_page_key", this.I);
        r10.put("is_back", this.K);
        r10.put("duration", this.H);
        r8.put("params", r10);
        r8.put("datetime", this.f11462x);
        long r11 = this.A;
        if (r11 <= 0) goto L8;
        r8.put("event_id", r11);
    L8:
        return r8;
    }
}
