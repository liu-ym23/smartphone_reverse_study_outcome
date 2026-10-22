package l1;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.bdinstall.Api;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i extends a {
    public long A;
    public String B;
    public Integer C;
    public String D;
    public String E;
    public Integer F;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f10866z;

    public i() {
    }

    @Override // l1.a
    protected void B(@NonNull ContentValues r10) {
        o().b(4, this.f10844w, "write db not implemented", new Object[0]);
    }

    @Override // l1.a
    protected void C(@NonNull JSONObject r10) {
        o().b(4, this.f10844w, "write ipc not implemented", new Object[0]);
    }

    @Override // l1.a
    protected JSONObject D() {
        JSONObject r10 = new JSONObject();
        r10.put("local_time_ms", this.f10828g);
        r10.put("tea_event_index", this.f10829h);
        r10.put("session_id", this.f10830i);
        r10.put("stop_timestamp", this.A / 1000);
        r10.put("duration", this.f10866z / 1000);
        r10.put("datetime", this.f10840s);
        e(r10);
        if (TextUtils.isEmpty(this.f10833l) == true) goto L6;
        r10.put(Api.KEY_USER_UNIQUE_ID, this.f10833l);
    L6:
        if (TextUtils.isEmpty(this.f10834m) == true) goto L9;
        r10.put("ab_sdk_version", this.f10834m);
    L9:
        if (TextUtils.isEmpty(this.B) == true) goto L13;
        r10.put("uuid_changed", true);
        if (TextUtils.equals(this.B, this.f10830i) == true) goto L13;
        r10.put("original_session_id", this.B);
    L13:
        Integer r11 = this.C;
        if (r11 == null) goto L17;
        r10.put("session_type", r11);
    L17:
        if (TextUtils.isEmpty(this.E) == true) goto L20;
        r10.put("from_session", this.E);
    L20:
        if (TextUtils.isEmpty(this.D) == true) goto L22;
        r10.put("to_session", this.D);
    L22:
        Integer r12 = this.F;
        if (r12 == null) goto L25;
        r10.put("bg_session", r12);
    L25:
        r10.put("$$EVENT_LOCAL_ID", this.f10843v);
        return r10;
    }

    @Override // l1.a
    protected List<String> k() {
        return null;
    }

    @Override // l1.a
    protected String m() {
        return String.valueOf(this.f10866z);
    }

    @Override // l1.a
    @NonNull
    String q() {
        return "terminate";
    }

    @Override // l1.a
    public int r(@NonNull Cursor r10) {
        o().b(4, this.f10844w, "read db not implemented", new Object[0]);
        return 0;
    }

    @Override // l1.a
    protected a s(@NonNull JSONObject r10) {
        o().b(4, this.f10844w, "read ipc not implemented", new Object[0]);
        return this;
    }
}
