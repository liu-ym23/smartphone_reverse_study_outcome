package com.bytedance.common.wschannel;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.common.wschannel.app.b f2136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Application f2137b;
    private com.bytedance.common.wschannel.app.d c;
    private boolean d;
    private boolean e;
    private boolean f;
    private b<Boolean> g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Application f2138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bytedance.common.wschannel.app.d f2139b;
        private boolean c;
        private boolean d;
        private boolean e;
        private com.bytedance.common.wschannel.app.b f;

        public a() {
            this.c = false;
            this.d = true;
            this.e = false;
        }

        public a a(Application r3) {
            this.f2138a = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a a(com.bytedance.common.wschannel.app.b r3) {
            this.f = (com.bytedance.common.wschannel.app.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.app.b.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a a(com.bytedance.common.wschannel.app.d r3) {
            this.f2139b = (com.bytedance.common.wschannel.app.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.app.d.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a a(boolean r1) {
            this.c = r1;
            return this;
        }

        public m a() {
            return new m(this.f2138a, this.f2139b, this.c, this.d, this.e, this.f);
        }

        public a b(boolean r1) {
            this.d = r1;
            return this;
        }

        public a c(boolean r1) {
            this.e = r1;
            return this;
        }
    }

    public m(Application r3, com.bytedance.common.wschannel.app.d r4, boolean r5, boolean r6, boolean r7, com.bytedance.common.wschannel.app.b r8) {
        Application r9 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        com.bytedance.common.wschannel.app.d r10 = (com.bytedance.common.wschannel.app.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.common.wschannel.app.d.class, "com.obric.memorydata.plugin");
        com.bytedance.common.wschannel.app.b r11 = (com.bytedance.common.wschannel.app.b) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.common.wschannel.app.b.class, "com.obric.memorydata.plugin");
        this.f2137b = r9;
        this.c = r10;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.f2136a = r11;
    }

    public Application a() {
        return this.f2137b;
    }

    public com.bytedance.common.wschannel.app.d b() {
        return this.c;
    }

    public boolean c() {
        return this.f;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public b<Boolean> f() {
        return this.g;
    }
}
