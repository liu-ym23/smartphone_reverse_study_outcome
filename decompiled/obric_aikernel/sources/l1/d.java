package l1;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.bdinstall.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {

    @NonNull
    private String A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    private String f10858z;

    public d(String r10, @NonNull String r11, @NonNull JSONObject r12) {
        this.A = r11;
        this.f10858z = r12.toString();
        this.f10839r = r10;
    }

    @Override // l1.a
    protected void B(@NonNull ContentValues r10) {
        super.B(r10);
        r10.put("params", this.f10858z);
        r10.put("log_type", this.A);
    }

    @Override // l1.a
    protected void C(@NonNull JSONObject r10) {
        super.C(r10);
        r10.put("params", this.f10858z);
        r10.put("log_type", this.A);
    }

    @Override // l1.a
    protected JSONObject D() {
        JSONObject r10 = new JSONObject();
        r10.put("local_time_ms", this.f10828g);
        r10.put("tea_event_index", this.f10829h);
        r10.put("session_id", this.f10830i);
        e(r10);
        if (TextUtils.isEmpty(this.f10833l) == true) goto L5;
        r10.put(Api.KEY_USER_UNIQUE_ID, this.f10833l);
    L5:
        r10.put("log_type", this.A);
        JSONObject r11 = new JSONObject(this.f10858z);     // Catch: Exception -> L14
        Iterator<String> r12 = r11.keys();     // Catch: Exception -> L14
    L7:
        if (r12.hasNext() == false) goto L16;
        String r13 = r12.next();     // Catch: Exception -> L14
        Object r14 = r11.get(r13);     // Catch: Exception -> L14
        if (r10.opt(r13) == null) goto L12;
        o().l(4, this.f10844w, "misc event exists key already!", new Object[0]);     // Catch: Exception -> L14
    L12:
        r10.put(r13, r14);     // Catch: Exception -> L14
    L16:
        r10.put("$$EVENT_LOCAL_ID", this.f10843v);
        return r10;
    L14:
        e = move-exception;
        o().v(4, "parse misc event params failed", e, new Object[0]);
        goto L16
    }

    public String E() {
        return this.A;
    }

    @Override // l1.a
    protected List<String> k() {
        List<String> r10 = super.k();
        ArrayList r11 = new ArrayList(r10.size());
        r11.addAll(r10);
        r11.addAll(Arrays.asList(new String[]{"params", "varchar", "log_type", "varchar"}));
        return r11;
    }

    @Override // l1.a
    public String l() {
        return this.f10858z;
    }

    @Override // l1.a
    protected String m() {
        return "param:" + this.f10858z + " logType:" + this.A;
    }

    @Override // l1.a
    @NonNull
    String q() {
        return "event_misc";
    }

    @Override // l1.a
    public int r(@NonNull Cursor r10) {
        int r11 = super.r(r10);
        int r12 = r11 + 1;
        this.f10858z = r10.getString(r11);
        int r13 = r12 + 1;
        this.A = r10.getString(r12);
        return r13;
    }

    @Override // l1.a
    protected a s(@NonNull JSONObject r10) {
        super.s(r10);
        this.f10858z = r10.optString("params", null);
        this.A = r10.optString("log_type", null);
        return this;
    }
}
