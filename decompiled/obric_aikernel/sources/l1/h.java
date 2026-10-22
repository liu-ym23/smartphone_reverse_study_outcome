package l1;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends a {
    public String A;
    public String B;
    public int C;
    public String D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f10865z;

    public h() {
    }

    private JSONObject E() {
        JSONObject r10 = new JSONObject();
        r10.put("page_key", this.B);
        r10.put("refer_page_key", this.A);
        r10.put("is_back", this.C);
        r10.put("duration", this.f10865z);
        return r10;
    }

    @Override // l1.a
    protected void B(@NonNull ContentValues r10) {
        super.B(r10);
        r10.put("page_key", this.B);
        r10.put("refer_page_key", this.A);
        r10.put("duration", Long.valueOf(this.f10865z));
        r10.put("is_back", Integer.valueOf(this.C));
        r10.put("last_session", this.D);
    }

    @Override // l1.a
    protected void C(@NonNull JSONObject r10) {
        super.C(r10);
        r10.put("page_key", this.B);
        r10.put("refer_page_key", this.A);
        r10.put("duration", this.f10865z);
        r10.put("is_back", this.C);
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
        r10.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        r10.put("is_bav", 1);
        r10.put("params", E());
        r10.put("datetime", this.f10840s);
        r10.put("$$EVENT_LOCAL_ID", this.f10843v);
        return r10;
    }

    public boolean F() {
        return this.B.contains(":");
    }

    public boolean G() {
        if (this.f10865z != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // l1.a
    protected List<String> k() {
        List<String> r12 = super.k();
        ArrayList r10 = new ArrayList(r12.size());
        r10.addAll(r12);
        r10.addAll(Arrays.asList(new String[]{"page_key", "varchar", "refer_page_key", "varchar", "duration", TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar"}));
        return r10;
    }

    @Override // l1.a
    protected String m() {
        return this.B + ", " + this.f10865z;
    }

    @Override // l1.a
    @NonNull
    String q() {
        return "page";
    }

    @Override // l1.a
    public int r(@NonNull Cursor r10) {
        int r11 = super.r(r10);
        int r12 = r11 + 1;
        this.B = r10.getString(r11);
        int r13 = r12 + 1;
        this.A = r10.getString(r12);
        int r14 = r13 + 1;
        this.f10865z = r10.getLong(r13);
        int r15 = r14 + 1;
        this.C = r10.getInt(r14);
        int r16 = r15 + 1;
        this.D = r10.getString(r15);
        return r16;
    }

    @Override // l1.a
    protected a s(@NonNull JSONObject r10) {
        super.s(r10);
        this.B = r10.optString("page_key", null);
        this.A = r10.optString("refer_page_key", null);
        this.f10865z = r10.optLong("duration", 0);
        this.C = r10.optInt("is_back", 0);
        return this;
    }
}
