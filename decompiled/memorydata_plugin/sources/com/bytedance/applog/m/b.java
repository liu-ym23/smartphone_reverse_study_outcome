package com.bytedance.applog.m;

import android.content.Context;
import com.bytedance.applog.e.c;
import com.bytedance.applog.p;
import com.bytedance.applog.util.f;
import com.bytedance.bdinstall.Level;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.b f1658a;

    public b(com.bytedance.applog.b r1) {
        this.f1658a = r1;
    }

    public <T> T a(JSONObject r3, String r4, T r5, Class<T> r6) {
        if (r3 == null) goto L4;
        T r0 = null;
        Object r7 = r3.opt(r4);
        if (r7 == null) goto L12;
        if (r6 == null) goto L12;
        r0 = r6.cast(r7);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.f1658a.aA().a(Collections.singletonList("ApiParamsUtil"), "getValue cast failed", th, new Object[0]);
    L12:
        if (r0 != null) goto L15;
        return r5;
    L15:
        return r0;
    L4:
        return (T) this.f1658a.a(r4, r5, r6);
    }

    public String a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (this.f1658a.k() == false) goto L10;
        String r0 = "?";
        if (r5.contains("?") == false) goto L7;
        StringBuilder r7 = new StringBuilder().append(r5);
        r0 = "&";
    L8:
        r5 = r7.append(r0).append("tt_data=a").toString();
        goto L10
    L7:
        r7 = new StringBuilder().append(r5);
    L10:
        return a.a(this.f1658a.a(r6, r5, true, Level.L1), f.f1883a);
    }

    public String[] a(Context r5, String[] r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        int r0 = r6.length;
        String[] r1 = new String[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = a(r7, r6[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public String[] a(c r2, boolean r3, com.bytedance.applog.priority.b r4) {
        p r0 = r2.i();
        if (r3 == false) goto L5;
        String[] r5 = r0.d();
    L6:
        if (r4 == null) goto L13;
        String[] r6 = r4.a(r5, "/service/2/app_log/");
        if (r6 == null) goto L13;
        if (r6.length <= 0) goto L13;
        r5 = r6;
    L13:
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    L5:
        r5 = r0.c();
        goto L6
    }
}
