package com.bytedance.android.livesdk.interactivity.seek.v2;

import gm2.l;
import java.util.List;
import java.util.Set;
import vlc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements amc.b {
    public final /* synthetic */ b a;

    public static final class a<T> implements h80.d {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final Object get() {
            return Long.valueOf(this.a.a.s);
        }
    }

    public final long a() {
        return 200;
    }

    public final boolean c() {
        return true;
    }

    public final long d() {
        return 1200;
    }

    public final void e() {
    }

    public final com.ss.ugc.live.sdk.msg.dispatch.g g() {
        return null;
    }

    public final int j() {
        return 512;
    }

    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> b() {
        return this.a.l;
    }

    public final k f() {
        return new l(new a(this));
    }

    public final List<vlc.b> getInterceptors() {
        return this.a.z;
    }

    public final Set<String> h() {
        return this.a.m;
    }

    public final List<vlc.j> i() {
        return this.a.A;
    }

    public d(b r1) {
        this.a = r1;
    }
}
