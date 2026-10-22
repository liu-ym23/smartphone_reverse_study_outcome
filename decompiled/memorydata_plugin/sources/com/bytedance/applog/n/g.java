package com.bytedance.applog.n;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.constants.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    public boolean A;
    public long v;
    public String w;
    public boolean x;
    public String y;
    public String z;

    public g() {
        this.A = true;
    }

    @Override // com.bytedance.applog.n.a
    public int a(Cursor r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        int r0 = super.a(r6);
        int r1 = r0 + 1;
        this.w = r6.getString(r0);
        int r2 = r1 + 1;
        this.v = r6.getLong(r1);
        int r3 = r2 + 1;
        this.y = r6.getString(r2);
        int r4 = r3 + 1;
        boolean r7 = false;
        if (r6.getInt(r3) != 1) goto L5;
        boolean r8 = true;
    L6:
        this.x = r8;
        int r9 = r4 + 1;
        this.z = r6.getString(r4);
        int r10 = r9 + 1;
        if (r6.getInt(r9) != 1) goto L9;
        r7 = true;
    L9:
        this.A = r7;
        return r10;
    L5:
        r8 = false;
        goto L6
    }

    @Override // com.bytedance.applog.n.a
    public void a(ContentValues r3) {
        super.a(r3);
        r3.put("ver_name", this.w);
        r3.put("ver_code", Long.valueOf(this.v));
        r3.put("last_session", this.y);
        r3.put("is_background", Integer.valueOf(this.x ? 1 : 0));
        r3.put("flat_params", this.z);
        r3.put("sendable", Integer.valueOf(this.A ? 1 : 0));
    }

    @Override // com.bytedance.applog.n.a
    public void a(JSONObject r4) {
        s().d(4, this.t, "write ipc not implemented", new Object[0]);
    }

    @Override // com.bytedance.applog.n.a
    public a b(JSONObject r4) {
        s().d(4, this.t, "read ipc not implemented", new Object[0]);
        return null;
    }

    @Override // com.bytedance.applog.n.a
    public List<String> e() {
        List<String> r14 = super.e();
        ArrayList r0 = new ArrayList(r14.size());
        r0.addAll(r14);
        r0.addAll(Arrays.asList(new String[]{"ver_name", "varchar", "ver_code", TypedValues.Custom.S_INT, "last_session", "varchar", "is_background", TypedValues.Custom.S_INT, "flat_params", "varchar", "sendable", TypedValues.Custom.S_INT}));
        return r0;
    }

    @Override // com.bytedance.applog.n.a
    public JSONObject f() {
        JSONObject r0 = new JSONObject();
        r0.put("local_time_ms", this.f1725b);
        r0.put("tea_event_index", this.c);
        r0.put("session_id", this.d);
        c(r0);
        if (TextUtils.isEmpty(this.g) == true) goto L6;
        r0.put(Api.KEY_USER_UNIQUE_ID, this.g);
    L6:
        if (this.x == false) goto L8;
        r0.put("is_background", true);
    L8:
        r0.put("datetime", this.n);
        if (TextUtils.isEmpty(this.h) == true) goto L12;
        r0.put("ab_sdk_version", this.h);
    L12:
        if (TextUtils.isEmpty(this.y) == true) goto L15;
        r0.put("uuid_changed", true);
        r0.put("original_session_id", this.y);
    L15:
        if (this.q <= 0) goto L18;
        r0.put("event_id", this.q);
    L18:
        if (this.r <= 0) goto L21;
        r0.put("monitor_id", String.valueOf(this.r));
    L21:
        if (this.s <= 0) goto L24;
        r0.put("event_stained", this.s);
    L24:
        if (TextUtils.isEmpty(this.z) == false) goto L37;
    L36:
        return r0;
    L37:
        JSONObject r3 = new JSONObject(this.z);     // Catch: Throwable -> L34
        Iterator<String> r4 = r3.keys();     // Catch: Throwable -> L34
    L27:
        if (r4.hasNext() == false) goto L36;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r0.has(r5) == false) goto L31;
        s().c(4, this.t, "Add params to launch conflict: {} - {}", new Object[]{r5, r3.opt(r5)});     // Catch: Throwable -> L34
        goto L27
    L31:
        r0.put(r5, r3.opt(r5));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        s().a(4, this.t, "Add flat params: {} to launch error", th, new Object[]{this.z});
        goto L36
    }

    @Override // com.bytedance.applog.n.a
    String h() {
        return Constants.LAUNCH_TAG;
    }

    @Override // com.bytedance.applog.n.a
    public String i() {
        return Constants.LAUNCH_TAG;
    }

    @Override // com.bytedance.applog.n.a
    public String o() {
        if (this.x == false) goto L5;
        return "bg";
    L5:
        return "fg";
    }
}
