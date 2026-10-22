package com.bytedance.common.wschannel;

import android.app.Application;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f1331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private u1.d f1332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u1.b f1336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.bytedance.common.wschannel.a<Boolean> f1337g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Application f1338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private u1.d f1339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1341d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1342e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private u1.b f1343f;

        public a() {
            this.f1340c = false;
            this.f1341d = true;
            this.f1342e = false;
        }

        public a a(Application r10) {
            this.f1338a = r10;
            return this;
        }

        public a b(u1.b r10) {
            this.f1343f = r10;
            return this;
        }

        public m c() {
            return new m(this.f1338a, this.f1339b, this.f1340c, this.f1341d, this.f1342e, this.f1343f);
        }

        public a d(boolean r10) {
            this.f1341d = r10;
            return this;
        }

        public a e(boolean r10) {
            this.f1340c = r10;
            return this;
        }

        public a f(boolean r10) {
            this.f1342e = r10;
            return this;
        }

        public a g(u1.d r10) {
            this.f1339b = r10;
            return this;
        }
    }

    public m(Application r10, @Nullable u1.d r11, boolean r12, boolean r13, boolean r14, u1.b r15) {
        this.f1331a = r10;
        this.f1332b = r11;
        this.f1333c = r12;
        this.f1334d = r13;
        this.f1335e = r14;
        this.f1336f = r15;
    }

    public Application a() {
        return this.f1331a;
    }

    @Nullable
    public u1.d b() {
        return this.f1332b;
    }

    public com.bytedance.common.wschannel.a<Boolean> c() {
        return this.f1337g;
    }

    public boolean d() {
        return this.f1334d;
    }

    public boolean e() {
        return this.f1333c;
    }

    public boolean f() {
        return this.f1335e;
    }
}
