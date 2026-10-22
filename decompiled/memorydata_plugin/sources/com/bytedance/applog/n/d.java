package com.bytedance.applog.n;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    private String v;
    private String w;

    public d(String r1, String r2, JSONObject r3) {
        this.w = r2;
        this.v = r3.toString();
        this.m = r1;
    }

    @Override // com.bytedance.applog.n.a
    public int a(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        int r0 = super.a(r4);
        int r1 = r0 + 1;
        this.v = r4.getString(r0);
        int r2 = r1 + 1;
        this.w = r4.getString(r1);
        return r2;
    }

    @Override // com.bytedance.applog.n.a
    public void a(ContentValues r6) {
        super.a(r6);
        if (com.bytedance.applog.b.e.f1531a == false) goto L5;
        String r0 = com.bytedance.applog.b.d.a(this.m, StageEventType.LOG_DATA, this.w, this.v);
    L6:
        r6.put(TrackerImpl.PARAMS, r0);
        r6.put("log_type", this.w);
        return;
    L5:
        r0 = this.v;
        goto L6
    }

    @Override // com.bytedance.applog.n.a
    public void a(JSONObject r3) {
        super.a(r3);
        r3.put(TrackerImpl.PARAMS, this.v);
        r3.put("log_type", this.w);
    }

    @Override // com.bytedance.applog.n.a
    public a b(JSONObject r3) {
        super.b(r3);
        this.v = r3.optString(TrackerImpl.PARAMS, null);
        this.w = r3.optString("log_type", null);
        return this;
    }

    @Override // com.bytedance.applog.n.a
    public List<String> e() {
        List<String> r3 = super.e();
        ArrayList r0 = new ArrayList(r3.size());
        r0.addAll(r3);
        r0.addAll(Arrays.asList(new String[]{TrackerImpl.PARAMS, "varchar", "log_type", "varchar"}));
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
        r0.put("log_type", this.w);
        JSONObject r3 = new JSONObject(this.v);     // Catch: Exception -> L14
        Iterator<String> r4 = r3.keys();     // Catch: Exception -> L14
    L7:
        if (r4.hasNext() == false) goto L17;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        Object r6 = r3.get(r5);     // Catch: Exception -> L14
        if (r0.opt(r5) == null) goto L12;
        s().c(4, this.t, "misc event exists key already!", new Object[0]);     // Catch: Exception -> L14
    L12:
        r0.put(r5, r6);     // Catch: Exception -> L14
    L17:
        if (this.q <= 0) goto L20;
        r0.put("event_id", this.q);
    L20:
        if (this.r <= 0) goto L23;
        r0.put("monitor_id", String.valueOf(this.r));
    L23:
        if (this.s <= 0) goto L25;
        r0.put("event_stained", this.s);
    L25:
        return r0;
    L14:
        e = move-exception;
        s().a(4, "parse misc event params failed", e, new Object[0]);
        goto L17
    }

    @Override // com.bytedance.applog.n.a
    String h() {
        return "event_misc";
    }

    @Override // com.bytedance.applog.n.a
    public String i() {
        return this.w;
    }

    @Override // com.bytedance.applog.n.a
    public String o() {
        return "logType:" + this.w;
    }

    @Override // com.bytedance.applog.n.a
    public String p() {
        return this.v;
    }

    public String t() {
        return this.w;
    }
}
