package l1;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.constants.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    public String A;
    public boolean B;
    public String C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f10860z;

    public f() {
    }

    @Override // l1.a
    protected void B(@NonNull ContentValues r10) {
        super.B(r10);
        r10.put("ver_name", this.A);
        r10.put("ver_code", Long.valueOf(this.f10860z));
        r10.put("last_session", this.C);
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
        e(r10);
        if (TextUtils.isEmpty(this.f10833l) == true) goto L5;
        r10.put(Api.KEY_USER_UNIQUE_ID, this.f10833l);
    L5:
        boolean r11 = this.B;
        if (r11 == false) goto L8;
        r10.put(Constants.IS_BACKGROUND, r11);
    L8:
        r10.put("datetime", this.f10840s);
        if (TextUtils.isEmpty(this.f10834m) == true) goto L12;
        r10.put("ab_sdk_version", this.f10834m);
    L12:
        if (TextUtils.isEmpty(this.C) == true) goto L14;
        r10.put("uuid_changed", true);
        r10.put("original_session_id", this.C);
    L14:
        r10.put("$$EVENT_LOCAL_ID", this.f10843v);
        return r10;
    }

    @Override // l1.a
    protected List<String> k() {
        List<String> r10 = super.k();
        ArrayList r11 = new ArrayList(r10.size());
        r11.addAll(r10);
        r11.addAll(Arrays.asList(new String[]{"ver_name", "varchar", "ver_code", TypedValues.Custom.S_INT, "last_session", "varchar"}));
        return r11;
    }

    @Override // l1.a
    protected String m() {
        if (this.B == false) goto L5;
        return "bg";
    L5:
        return "fg";
    }

    @Override // l1.a
    @NonNull
    String q() {
        return Constants.LAUNCH_TAG;
    }

    @Override // l1.a
    public int r(@NonNull Cursor r10) {
        int r11 = super.r(r10);
        int r12 = r11 + 1;
        this.A = r10.getString(r11);
        int r13 = r12 + 1;
        this.f10860z = r10.getLong(r12);
        int r14 = r13 + 1;
        this.C = r10.getString(r13);
        return r14;
    }

    @Override // l1.a
    protected a s(@NonNull JSONObject r10) {
        o().b(4, this.f10844w, "read ipc not implemented", new Object[0]);
        return null;
    }
}
