package l1;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    private boolean A;
    protected String B;
    public String C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected String f10859z;

    public e(String r10, String r11) {
        this.f10839r = r10;
        this.B = r11;
    }

    public e(String r10, String r11, boolean r12, String r13) {
        this.f10839r = r10;
        this.B = r11;
        this.A = r12;
        this.f10859z = r13;
        com.bytedance.applog.c r14 = com.bytedance.applog.b.a(r10);
        if (r14 != null) goto L5;
        return;
    L5:
        if (r14.C() == null) goto L9;
        this.C = String.valueOf(r14.C());
        return;
    }

    @Override // l1.a
    protected void B(@NonNull ContentValues r10) {
        super.B(r10);
        r10.put(NotificationCompat.CATEGORY_EVENT, this.B);
        if (this.A == true) goto L5;
    L10:
        r10.put("params", this.f10859z);
        r10.put("is_bav", Integer.valueOf(this.A ? 1 : 0));
        r10.put("disable_personalization", this.C);
        return;
    L5:
        if (this.f10859z != null) goto L10;
        E();     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        o().r(4, this.f10844w, "write db failed", e, new Object[0]);
        goto L10
    }

    @Override // l1.a
    protected void C(@NonNull JSONObject r10) {
        super.C(r10);
        r10.put(NotificationCompat.CATEGORY_EVENT, this.B);
        if (this.A == true) goto L5;
    L7:
        r10.put("params", this.f10859z);
        r10.put("is_bav", this.A);
        r10.put("disable_personalization", this.C);
        return;
    L5:
        if (this.f10859z != null) goto L7;
        E();
        goto L7
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
        r10.put(NotificationCompat.CATEGORY_EVENT, this.B);
        if (this.A == false) goto L9;
        r10.put("is_bav", 1);
    L9:
        if (TextUtils.isEmpty(this.f10859z) == true) goto L12;
        r10.put("params", new JSONObject(this.f10859z));
    L12:
        if (this.f10835n == NetworkUtils.NetworkType.UNKNOWN.getValue()) goto L14;
        r10.put("nt", this.f10835n);
    L14:
        r10.put("datetime", this.f10840s);
        if (TextUtils.isEmpty(this.f10834m) == true) goto L18;
        r10.put("ab_sdk_version", this.f10834m);
    L18:
        if (TextUtils.isEmpty(this.C) == true) goto L20;
        r10.put("disable_personalization", Integer.valueOf(this.C));
    L20:
        r10.put("$$EVENT_LOCAL_ID", this.f10843v);
        return r10;
    }

    protected void E() {
    }

    public String F() {
        return this.B;
    }

    public void G(String r10) {
        this.f10859z = r10;
    }

    public void H(h1.a r10) {
        if (r10 == null) goto L5;
        this.f10841t = r10.d(this.B, this.f10859z);
        return;
    }

    @Override // l1.a
    protected List<String> k() {
        List<String> r10 = super.k();
        ArrayList r11 = new ArrayList(r10.size());
        r11.addAll(r10);
        r11.addAll(Arrays.asList(new String[]{NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar", "is_bav", TypedValues.Custom.S_INT, "disable_personalization", "varchar"}));
        return r11;
    }

    @Override // l1.a
    public String l() {
        return this.f10859z;
    }

    @Override // l1.a
    protected String m() {
        return this.B;
    }

    @Override // l1.a
    @NonNull
    String q() {
        return "eventv3";
    }

    @Override // l1.a
    public int r(@NonNull Cursor r10) {
        int r11 = super.r(r10);
        int r12 = r11 + 1;
        this.B = r10.getString(r11);
        int r13 = r12 + 1;
        this.f10859z = r10.getString(r12);
        int r14 = r13 + 1;
        boolean r15 = true;
        if (r10.getInt(r13) == 1) goto L6;
        r15 = false;
    L6:
        this.A = r15;
        int r16 = r14 + 1;
        this.C = r10.getString(r14);
        return r16;
    }

    @Override // l1.a
    protected a s(@NonNull JSONObject r10) {
        super.s(r10);
        this.B = r10.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.f10859z = r10.optString("params", null);
        this.A = r10.optBoolean("is_bav", false);
        this.C = r10.optString("disable_personalization", null);
        return this;
    }
}
