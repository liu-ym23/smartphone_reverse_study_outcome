package com.bytedance.applog.n;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    protected String v;
    protected boolean w;
    protected String x;
    public String y;
    public final boolean z;

    public e(String r1, String r2) {
        this.m = r1;
        this.x = r2;
        this.z = false;
    }

    public e(String r7, String r8, boolean r9, String r10) {
        this(r7, r8, r9, r10, false);
    }

    public e(String r1, String r2, boolean r3, String r4, boolean r5) {
        this.m = r1;
        this.x = r2;
        this.w = r3;
        this.v = r4;
        com.bytedance.applog.b r6 = com.bytedance.applog.a.b(r1);
        if (r6 != null) goto L5;
    L7:
        this.z = r5;
        return;
    L5:
        if (r6.Y() == null) goto L7;
        this.y = String.valueOf(r6.Y());
        goto L7
    }

    @Override // com.bytedance.applog.n.a
    public int a(Cursor r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        int r0 = super.a(r5);
        int r1 = r0 + 1;
        this.x = r5.getString(r0);
        int r2 = r1 + 1;
        this.v = r5.getString(r1);
        int r3 = r2 + 1;
        boolean r6 = true;
        if (r5.getInt(r2) == 1) goto L6;
        r6 = false;
    L6:
        this.w = r6;
        int r7 = r3 + 1;
        this.y = r5.getString(r3);
        int r8 = r7 + 1;
        String r9 = r5.getString(r7);
        if (TextUtils.isEmpty(r9) == false) goto L9;
        com.bytedance.applog.collector.d.a r10 = null;
    L10:
        this.u = r10;
        return r8;
    L9:
        r10 = com.bytedance.applog.collector.d.a.f1557a.a(r9);
        goto L10
    }

    @Override // com.bytedance.applog.n.a
    public void a(ContentValues r8) {
        super.a(r8);
        r8.put("event", this.x);
        if (this.w == false) goto L11;
        if (this.v != null) goto L11;
        t();     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        s().a(4, this.t, "write db failed", e, new Object[0]);
    L11:
        if (com.bytedance.applog.b.e.f1531a == false) goto L13;
        String r0 = com.bytedance.applog.b.d.a(this.m, StageEventType.V3_EVENT, this.x, this.v);
    L14:
        r8.put(TrackerImpl.PARAMS, com.bytedance.applog.l.b.a(this, r0));
        r8.put("is_bav", Integer.valueOf(this.w ? 1 : 0));
        r8.put("disable_personalization", this.y);
        if (this.u == null) goto L17;
        String r7 = this.u.a();
    L18:
        r8.put("page_info", r7);
        return;
    L17:
        r7 = null;
        goto L18
    L13:
        r0 = this.v;
        goto L14
    }

    public void a(com.bytedance.applog.priority.a r3) {
        if (r3 == null) goto L5;
        this.o = r3.a(this.x, this.v);
        return;
    }

    @Override // com.bytedance.applog.n.a
    public void a(JSONObject r3) {
        super.a(r3);
        r3.put("event", this.x);
        if (this.w == true) goto L5;
    L7:
        r3.put(TrackerImpl.PARAMS, this.v);
        r3.put("is_bav", this.w);
        r3.put("disable_personalization", this.y);
        return;
    L5:
        if (this.v != null) goto L7;
        t();
        goto L7
    }

    @Override // com.bytedance.applog.n.a
    public a b(JSONObject r4) {
        super.b(r4);
        this.x = r4.optString("event", null);
        this.v = r4.optString(TrackerImpl.PARAMS, null);
        this.w = r4.optBoolean("is_bav", false);
        this.y = r4.optString("disable_personalization", null);
        return this;
    }

    public void c(String r1) {
        this.v = r1;
    }

    @Override // com.bytedance.applog.n.a
    public List<String> e() {
        List<String> r12 = super.e();
        ArrayList r0 = new ArrayList(r12.size());
        r0.addAll(r12);
        r0.addAll(Arrays.asList(new String[]{"event", "varchar", TrackerImpl.PARAMS, "varchar", "is_bav", TypedValues.Custom.S_INT, "disable_personalization", "varchar", "page_info", "varchar"}));
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
        r0.put("event", this.x);
        if (this.w == false) goto L9;
        r0.put("is_bav", 1);
    L9:
        if (TextUtils.isEmpty(this.v) == true) goto L12;
        r0.put(TrackerImpl.PARAMS, com.bytedance.applog.l.b.a(this, new JSONObject(this.v)));
    L12:
        if (this.i == NetworkUtils.NetworkType.UNKNOWN.getValue()) goto L14;
        r0.put("nt", this.i);
    L14:
        r0.put("datetime", this.n);
        if (TextUtils.isEmpty(this.h) == true) goto L18;
        r0.put("ab_sdk_version", this.h);
    L18:
        if (TextUtils.isEmpty(this.y) == true) goto L21;
        r0.put("disable_personalization", Integer.valueOf(this.y));
    L21:
        if (this.q <= 0) goto L24;
        r0.put("event_id", this.q);
    L24:
        if (this.r <= 0) goto L27;
        r0.put("monitor_id", String.valueOf(this.r));
    L27:
        if (this.s <= 0) goto L30;
        r0.put("event_stained", this.s);
    L30:
        if (this.u == null) goto L32;
        this.u.a(r0);
    L32:
        return r0;
    }

    @Override // com.bytedance.applog.n.a
    String h() {
        return "eventv3";
    }

    @Override // com.bytedance.applog.n.a
    public String i() {
        return this.x;
    }

    @Override // com.bytedance.applog.n.a
    public String o() {
        return this.x;
    }

    @Override // com.bytedance.applog.n.a
    public String p() {
        return this.v;
    }

    public void t() {
    }

    public String u() {
        return this.x;
    }
}
