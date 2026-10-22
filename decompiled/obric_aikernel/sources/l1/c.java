package l1;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public String A;
    public String B;
    public String C;
    public long D;
    public long E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f10857z;

    c() {
    }

    public c(String r10, String r11, String r12) {
        x(0);
        this.f10839r = r10;
        this.f10857z = r11;
        this.A = r12;
    }

    @Override // l1.a
    protected void B(@NonNull ContentValues r10) {
        super.B(r10);
        r10.put(EventBody.KEY_CATEGORY, this.f10857z);
        r10.put("tag", this.A);
        r10.put(EventBody.KEY_VALUE, Long.valueOf(this.D));
        r10.put("ext_value", Long.valueOf(this.E));
        r10.put("params", this.C);
        r10.put("label", this.B);
    }

    @Override // l1.a
    protected void C(@NonNull JSONObject r10) {
        super.C(r10);
        r10.put("tea_event_index", this.f10829h);
        r10.put(EventBody.KEY_CATEGORY, this.f10857z);
        r10.put("tag", this.A);
        r10.put(EventBody.KEY_VALUE, this.D);
        r10.put("ext_value", this.E);
        r10.put("params", this.C);
        r10.put("label", this.B);
    }

    @Override // l1.a
    protected JSONObject D() {
        if (TextUtils.isEmpty(this.C) == true) goto L5;
        JSONObject r10 = new JSONObject(this.C);
    L6:
        if (r10 != null) goto L8;
        r10 = new JSONObject();
    L8:
        r10.put("local_time_ms", this.f10828g);
        r10.put("tea_event_index", this.f10829h);
        r10.put("session_id", this.f10830i);
        e(r10);
        if (this.f10835n == NetworkUtils.NetworkType.UNKNOWN.getValue()) goto L12;
        r10.put("nt", this.f10835n);
    L12:
        if (TextUtils.isEmpty(this.f10833l) == true) goto L14;
        r10.put(Api.KEY_USER_UNIQUE_ID, this.f10833l);
    L14:
        r10.put(EventBody.KEY_CATEGORY, this.f10857z);
        r10.put("tag", this.A);
        r10.put(EventBody.KEY_VALUE, this.D);
        r10.put("ext_value", this.E);
        r10.put("label", this.B);
        r10.put("datetime", this.f10840s);
        if (TextUtils.isEmpty(this.f10834m) == true) goto L17;
        r10.put("ab_sdk_version", this.f10834m);
    L17:
        r10.put("$$EVENT_LOCAL_ID", this.f10843v);
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    @Override // l1.a
    protected List<String> k() {
        List<String> r14 = super.k();
        ArrayList r10 = new ArrayList(r14.size());
        r10.addAll(r14);
        r10.addAll(Arrays.asList(new String[]{EventBody.KEY_CATEGORY, "varchar", "tag", "varchar", EventBody.KEY_VALUE, TypedValues.Custom.S_INT, "ext_value", TypedValues.Custom.S_INT, "params", "varchar", "label", "varchar"}));
        return r10;
    }

    @Override // l1.a
    protected String l() {
        return this.C;
    }

    @Override // l1.a
    protected String m() {
        return "" + this.A + ", " + this.B;
    }

    @Override // l1.a
    @NonNull
    String q() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    @Override // l1.a
    public int r(@NonNull Cursor r10) {
        int r11 = super.r(r10);
        int r12 = r11 + 1;
        this.f10857z = r10.getString(r11);
        int r13 = r12 + 1;
        this.A = r10.getString(r12);
        int r14 = r13 + 1;
        this.D = r10.getLong(r13);
        int r15 = r14 + 1;
        this.E = r10.getLong(r14);
        int r16 = r15 + 1;
        this.C = r10.getString(r15);
        int r17 = r16 + 1;
        this.B = r10.getString(r16);
        return r17;
    }

    @Override // l1.a
    protected a s(@NonNull JSONObject r10) {
        super.s(r10);
        this.f10829h = r10.optLong("tea_event_index", 0);
        this.f10857z = r10.optString(EventBody.KEY_CATEGORY, null);
        this.A = r10.optString("tag", null);
        this.D = r10.optLong(EventBody.KEY_VALUE, 0);
        this.E = r10.optLong("ext_value", 0);
        this.C = r10.optString("params", null);
        this.B = r10.optString("label", null);
        return this;
    }
}
