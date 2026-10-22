package com.bytedance.applog.n;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public long A;
    public String v;
    public String w;
    public String x;
    public String y;
    public long z;

    c() {
    }

    public c(String r3, String r4, String r5) {
        a(0);
        this.m = r3;
        this.v = r4;
        this.w = r5;
    }

    public c(String r3, String r4, String r5, String r6, long r7, long r9, String r11) {
        a(0);
        this.v = r4;
        this.w = r5;
        this.x = r6;
        this.z = r7;
        this.A = r9;
        this.y = r11;
        this.m = r3;
    }

    @Override // com.bytedance.applog.n.a
    public int a(Cursor r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        int r0 = super.a(r6);
        int r1 = r0 + 1;
        this.v = r6.getString(r0);
        int r2 = r1 + 1;
        this.w = r6.getString(r1);
        int r3 = r2 + 1;
        this.z = r6.getLong(r2);
        int r4 = r3 + 1;
        this.A = r6.getLong(r3);
        int r7 = r4 + 1;
        this.y = r6.getString(r4);
        int r8 = r7 + 1;
        this.x = r6.getString(r7);
        return r8;
    }

    @Override // com.bytedance.applog.n.a
    public void a(ContentValues r6) {
        super.a(r6);
        r6.put(EventBody.KEY_CATEGORY, this.v);
        r6.put(LocationMonitorConst.TAG, this.w);
        r6.put(EventBody.KEY_VALUE, Long.valueOf(this.z));
        r6.put("ext_value", Long.valueOf(this.A));
        if (com.bytedance.applog.b.e.f1531a == false) goto L5;
        String r0 = com.bytedance.applog.b.d.a(this.m, StageEventType.V1_EVENT, this.w, this.y);
    L6:
        r6.put(TrackerImpl.PARAMS, r0);
        r6.put(AnnotatedPrivateKey.LABEL, this.x);
        return;
    L5:
        r0 = this.y;
        goto L6
    }

    @Override // com.bytedance.applog.n.a
    public void a(JSONObject r4) {
        super.a(r4);
        r4.put("tea_event_index", this.c);
        r4.put(EventBody.KEY_CATEGORY, this.v);
        r4.put(LocationMonitorConst.TAG, this.w);
        r4.put(EventBody.KEY_VALUE, this.z);
        r4.put("ext_value", this.A);
        r4.put(TrackerImpl.PARAMS, this.y);
        r4.put(AnnotatedPrivateKey.LABEL, this.x);
    }

    @Override // com.bytedance.applog.n.a
    public a b(JSONObject r7) {
        super.b(r7);
        this.c = r7.optLong("tea_event_index", 0);
        this.v = r7.optString(EventBody.KEY_CATEGORY, null);
        this.w = r7.optString(LocationMonitorConst.TAG, null);
        this.z = r7.optLong(EventBody.KEY_VALUE, 0);
        this.A = r7.optLong("ext_value", 0);
        this.y = r7.optString(TrackerImpl.PARAMS, null);
        this.x = r7.optString(AnnotatedPrivateKey.LABEL, null);
        return this;
    }

    @Override // com.bytedance.applog.n.a
    public List<String> e() {
        List<String> r14 = super.e();
        ArrayList r0 = new ArrayList(r14.size());
        r0.addAll(r14);
        r0.addAll(Arrays.asList(new String[]{EventBody.KEY_CATEGORY, "varchar", LocationMonitorConst.TAG, "varchar", EventBody.KEY_VALUE, TypedValues.Custom.S_INT, "ext_value", TypedValues.Custom.S_INT, TrackerImpl.PARAMS, "varchar", AnnotatedPrivateKey.LABEL, "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.n.a
    public JSONObject f() {
        if (TextUtils.isEmpty(this.y) == true) goto L5;
        JSONObject r0 = new JSONObject(this.y);
    L6:
        if (r0 != null) goto L8;
        r0 = new JSONObject();
    L8:
        r0.put("local_time_ms", this.f1725b);
        r0.put("tea_event_index", this.c);
        r0.put("session_id", this.d);
        c(r0);
        if (this.i == NetworkUtils.NetworkType.UNKNOWN.getValue()) goto L12;
        r0.put("nt", this.i);
    L12:
        if (TextUtils.isEmpty(this.g) == true) goto L14;
        r0.put(Api.KEY_USER_UNIQUE_ID, this.g);
    L14:
        r0.put(EventBody.KEY_CATEGORY, this.v);
        r0.put(LocationMonitorConst.TAG, this.w);
        r0.put(EventBody.KEY_VALUE, this.z);
        r0.put("ext_value", this.A);
        r0.put(AnnotatedPrivateKey.LABEL, this.x);
        r0.put("datetime", this.n);
        if (TextUtils.isEmpty(this.h) == true) goto L18;
        r0.put("ab_sdk_version", this.h);
    L18:
        if (this.q <= 0) goto L21;
        r0.put("event_id", this.q);
    L21:
        if (this.r <= 0) goto L24;
        r0.put("monitor_id", String.valueOf(this.r));
    L24:
        if (this.s <= 0) goto L26;
        r0.put("event_stained", this.s);
    L26:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.applog.n.a
    String h() {
        return "event";
    }

    @Override // com.bytedance.applog.n.a
    public String i() {
        return this.w;
    }

    @Override // com.bytedance.applog.n.a
    public String o() {
        return "" + this.w + ", " + this.x;
    }

    @Override // com.bytedance.applog.n.a
    public String p() {
        return this.y;
    }
}
