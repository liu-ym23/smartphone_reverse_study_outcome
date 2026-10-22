package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.common.wschannel.client.k f2131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<Integer, i> f2132b;
    private static AtomicBoolean c;
    private static boolean d;

    private static class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Application f2133a;

        a(Application r3) {
            this.f2133a = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.common.wschannel.d.a
        public void a() {
            k.a(false);
            if (k.a().get() == false) goto L6;
            k.b().a(this.f2133a);
            return;
        }

        @Override // com.bytedance.common.wschannel.d.a
        public void b() {
            k.a(true);
            if (k.a().get() == false) goto L6;
            k.b().b(this.f2133a);
            return;
        }
    }

    static {
        f2131a = new com.bytedance.common.wschannel.client.m();
        f2132b = new ConcurrentHashMap();
        c = new AtomicBoolean(false);
        d = true;
    }

    static i a(int r2) {
        return (i) ZeusTransformUtils.preCheckCast(f2132b.get(Integer.valueOf(r2)), i.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ AtomicBoolean a() {
        return c;
    }

    static void a(Context r2) {
        Application r3 = (Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        d r0 = new d();
        r0.a(new a(r3));
        r3.registerActivityLifecycleCallbacks(r0);
    }

    static /* synthetic */ boolean a(boolean r0) {
        d = r0;
        return r0;
    }

    static /* synthetic */ com.bytedance.common.wschannel.client.k b() {
        return f2131a;
    }

    static void b(int r1) {
        f2132b.remove(Integer.valueOf(r1));
    }
}
