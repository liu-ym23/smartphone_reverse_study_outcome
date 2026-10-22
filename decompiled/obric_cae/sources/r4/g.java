package r4;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g extends a {
    public long H;
    public String I;
    public boolean J;
    public String K;
    public String L;
    public boolean M;

    public g() {
        this.M = true;
    }

    @Override // r4.a
    public final List<String> e() {
        List<String> r14 = super.e();
        ArrayList r8 = new ArrayList(r14.size());
        r8.addAll(r14);
        r8.addAll(Arrays.asList(new String[]{"ver_name", "varchar", "ver_code", MultiProcessSharedProvider.INT_TYPE, "last_session", "varchar", LocationMonitorConst.IS_BACKGROUND, MultiProcessSharedProvider.INT_TYPE, "flat_params", "varchar", "sendable", MultiProcessSharedProvider.INT_TYPE}));
        return r8;
    }

    @Override // r4.a
    public final String g() {
        if (this.J == false) goto L5;
        return "bg";
    L5:
        return "fg";
    }

    @Override // r4.a
    public final String i() {
        return "launch";
    }

    @Override // r4.a
    public final void j(Cursor r8) {
        super.j(r8);
        this.I = r8.getString(18);
        this.H = r8.getLong(19);
        this.K = r8.getString(20);
        boolean r10 = false;
        if (r8.getInt(21) != 1) goto L5;
        boolean r11 = true;
    L6:
        this.J = r11;
        this.L = r8.getString(22);
        if (r8.getInt(23) != 1) goto L9;
        r10 = true;
    L9:
        this.M = r10;
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // r4.a
    public final a k(JSONObject r8) {
        List<String> r10 = this.D;
        h().a(4, r10, "read ipc not implemented", new Object[0]);
        return null;
    }

    @Override // r4.a
    public final void n(ContentValues r8) {
        super.n(r8);
        r8.put("ver_name", this.I);
        r8.put("ver_code", Long.valueOf(this.H));
        r8.put("last_session", this.K);
        r8.put(LocationMonitorConst.IS_BACKGROUND, Integer.valueOf(this.J ? 1 : 0));
        r8.put("flat_params", this.L);
        r8.put("sendable", Integer.valueOf(this.M ? 1 : 0));
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
        c(r8);
        if (TextUtils.isEmpty(this.f11455q) == true) goto L6;
        r8.put("user_unique_id", this.f11455q);
    L6:
        if (this.J == false) goto L8;
        r8.put(LocationMonitorConst.IS_BACKGROUND, true);
    L8:
        r8.put("datetime", this.f11462x);
        if (TextUtils.isEmpty(this.f11456r) == true) goto L12;
        r8.put("ab_sdk_version", this.f11456r);
    L12:
        if (TextUtils.isEmpty(this.K) == true) goto L14;
        r8.put("uuid_changed", true);
        r8.put("original_session_id", this.K);
    L14:
        long r10 = this.A;
        if (r10 <= 0) goto L17;
        r8.put("event_id", r10);
    L17:
        long r11 = this.B;
        if (r11 <= 0) goto L20;
        r8.put("monitor_id", String.valueOf(r11));
    L20:
        int r12 = this.C;
        if (r12 <= 0) goto L24;
        r8.put("event_stained", r12);
    L24:
        if (TextUtils.isEmpty(this.L) == false) goto L36;
    L35:
        return r8;
    L36:
        JSONObject r13 = new JSONObject(this.L);     // Catch: Throwable -> L33
        Iterator<String> r14 = r13.keys();     // Catch: Throwable -> L33
    L26:
        if (r14.hasNext() == false) goto L35;
        String r15 = r14.next();     // Catch: Throwable -> L33
        if (r8.has(r15) == false) goto L30;
        h().f(4, this.D, "Add params to launch conflict: {} - {}", new Object[]{r15, r13.opt(r15)});     // Catch: Throwable -> L33
        goto L26
    L30:
        r8.put(r15, r13.opt(r15));     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        h().m(4, this.D, "Add flat params: {} to launch error", th, new Object[]{this.L});
        goto L35
    }
}
