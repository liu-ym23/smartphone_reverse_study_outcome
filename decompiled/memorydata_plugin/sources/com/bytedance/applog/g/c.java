package com.bytedance.applog.g;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.applog.f;
import com.bytedance.applog.log.q;
import com.bytedance.applog.n.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f1603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f1604b;
    private final String c;
    private final AtomicInteger d;
    private boolean e;
    private final com.bytedance.applog.log.b<com.bytedance.applog.params.extract.f> f;

    private class a extends com.bytedance.applog.l.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f1606a;

        private a(c r1) {
            this.f1606a = r1;
        }

        /* synthetic */ a(c r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.applog.l.c
        public String a(e r4, String r5) {
            if (r4.z == true) goto L5;
            return r5;
        L5:
            if (c.a(this.f1606a).ag() == false) goto L14;
            JSONObject r0 = new JSONObject(r5);     // Catch: Throwable -> L8
            c.a(this.f1606a, r0);     // Catch: Throwable -> L8
            r5 = r0.toString();     // Catch: Throwable -> L8
            q.a().c("ParamsExtract clearCommonParams event:" + r4, new Object[0]);     // Catch: Throwable -> L8
            return r5;
        L8:
            th = move-exception;
            c.a(this.f1606a).ab().a("params_extract_clear_exception", th);
            return r5;
        L14:
            return r5;
        }

        @Override // com.bytedance.applog.l.c
        public JSONObject a(e r5, JSONObject r6) {
            if (c.a(this.f1606a).ag() == true) goto L5;
        L9:
            return r6;
        L5:
            if (r6.has("__applog_cp_ids") == false) goto L9;
            boolean r0 = c.b(this.f1606a, r6);
            q.a().c("ParamsExtract fillCommonParams event:" + r5 + " success: " + r0, new Object[0]);
            if (r0 == true) goto L9;
            c.a(this.f1606a).ab().a("params_extract_fill_failed", new Throwable(r5.i()));
            goto L9
        }

        @Override // com.bytedance.applog.l.c
        public void a() {
            c.b(this.f1606a);
        }
    }

    public c(f r3, Looper r4, String r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        this.d = new AtomicInteger(0);
        this.e = false;
        this.f = new AnonymousClass1(this);
        this.f1603a = new Handler(r4);
        this.f1604b = r6;
        this.c = r5;
        r6.ai().a(new a(this, null));
    }

    static /* synthetic */ f a(c r0) {
        return r0.f1604b;
    }

    private void a() {
        if (this.e == false) goto L5;
        return;
    L5:
        String r0 = this.f1604b.E();
        if (TextUtils.isEmpty(r0) == false) goto L8;
        return;
    L8:
        ((com.bytedance.applog.params.extract.f) ZeusTransformUtils.preCheckCast(this.f.c(new Object[0]), com.bytedance.applog.params.extract.f.class, "com.obric.memorydata.plugin")).a(r0);
        this.e = true;
    }

    static /* synthetic */ void a(c r0, JSONObject r1) {
        r0.a(r1);
    }

    private void a(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ((com.bytedance.applog.params.extract.f) ZeusTransformUtils.preCheckCast(this.f.c(new Object[0]), com.bytedance.applog.params.extract.f.class, "com.obric.memorydata.plugin")).a(r3);
    }

    static /* synthetic */ void b(c r0) {
        r0.a();
    }

    static /* synthetic */ boolean b(c r0, JSONObject r1) {
        return r0.b(r1);
    }

    private boolean b(JSONObject r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        return ((com.bytedance.applog.params.extract.f) ZeusTransformUtils.preCheckCast(this.f.c(new Object[0]), com.bytedance.applog.params.extract.f.class, "com.obric.memorydata.plugin")).b(r3);
    }
}
