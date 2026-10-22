package com.bytedance.applog.n;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i extends a {
    public String A;
    public long v;
    public String w;
    public String x;
    public int y;
    public String z;

    public i() {
    }

    private JSONObject v() {
        JSONObject r0 = new JSONObject();
        r0.put("page_key", this.x);
        r0.put("refer_page_key", this.w);
        r0.put("is_back", this.y);
        r0.put("duration", this.v);
        return r0;
    }

    @Override // com.bytedance.applog.n.a
    public int a(Cursor r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        int r0 = super.a(r6);
        int r1 = r0 + 1;
        this.x = r6.getString(r0);
        int r2 = r1 + 1;
        this.w = r6.getString(r1);
        int r3 = r2 + 1;
        this.v = r6.getLong(r2);
        int r4 = r3 + 1;
        this.y = r6.getInt(r3);
        int r7 = r4 + 1;
        this.z = r6.getString(r4);
        int r8 = r7 + 1;
        this.A = r6.getString(r7);
        return r8;
    }

    @Override // com.bytedance.applog.n.a
    public void a(ContentValues r3) {
        super.a(r3);
        r3.put("page_key", this.x);
        r3.put("refer_page_key", this.w);
        r3.put("duration", Long.valueOf(this.v));
        r3.put("is_back", Integer.valueOf(this.y));
        r3.put("last_session", this.z);
        r3.put("flat_params", this.A);
    }

    @Override // com.bytedance.applog.n.a
    public void a(JSONObject r4) {
        super.a(r4);
        r4.put("page_key", this.x);
        r4.put("refer_page_key", this.w);
        r4.put("duration", this.v);
        r4.put("is_back", this.y);
    }

    @Override // com.bytedance.applog.n.a
    public a b(JSONObject r4) {
        super.b(r4);
        this.x = r4.optString("page_key", null);
        this.w = r4.optString("refer_page_key", null);
        this.v = r4.optLong("duration", 0);
        this.y = r4.optInt("is_back", 0);
        return this;
    }

    @Override // com.bytedance.applog.n.a
    public List<String> e() {
        List<String> r14 = super.e();
        ArrayList r0 = new ArrayList(r14.size());
        r0.addAll(r14);
        r0.addAll(Arrays.asList(new String[]{"page_key", "varchar", "refer_page_key", "varchar", "duration", TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar", "flat_params", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.n.a
    public JSONObject f() {
        JSONObject r0 = new JSONObject();
        r0.put("local_time_ms", this.f1725b);
        r0.put("tea_event_index", this.c);
        r0.put("session_id", this.d);
        c(r0);
        if (TextUtils.isEmpty(this.g) == true) goto L5;
        r0.put(Api.KEY_USER_UNIQUE_ID, this.g);
    L5:
        r0.put("event", "bav2b_page");
        r0.put("is_bav", 1);
        r0.put(TrackerImpl.PARAMS, v());
        r0.put("datetime", this.n);
        if (this.q <= 0) goto L8;
        r0.put("event_id", this.q);
    L8:
        return r0;
    }

    @Override // com.bytedance.applog.n.a
    String h() {
        return "page";
    }

    @Override // com.bytedance.applog.n.a
    public String i() {
        return "";
    }

    @Override // com.bytedance.applog.n.a
    public String o() {
        return this.x + ", " + this.v;
    }

    public boolean t() {
        if (this.v != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean u() {
        return this.x.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR);
    }
}
