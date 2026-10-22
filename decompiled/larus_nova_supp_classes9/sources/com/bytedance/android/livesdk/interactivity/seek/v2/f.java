package com.bytedance.android.livesdk.interactivity.seek.v2;

import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.bdlocation.BuildConfig;
import com.ss.ugc.live.sdk.msg.network.l;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements amc.g {
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.seek.v2.b a;

    public static final class a<T> implements h80.d {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final Object get() {
            return Long.valueOf(this.a.a.s);
        }
    }

    public static final class b<T> implements h80.d {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        public final Object get() {
            String r0 = this.a.a.u;
            if (r0 != null) goto L6;
            return BuildConfig.FLAVOR;
        L6:
            return r0;
        }
    }

    public static final class c<T> implements h80.d {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object get() {
            return new HashMap();
        }
    }

    public final boolean b() {
        return false;
    }

    public final l f() {
        return null;
    }

    public final String g() {
        return null;
    }

    public final boolean i() {
        return false;
    }

    public final void j() {
    }

    public final boolean k() {
        return false;
    }

    public final amc.d l() {
        return null;
    }

    public final Map<String, String> a() {
        return this.a.h();
    }

    public final com.ss.ugc.live.sdk.msg.network.i d() {
        return new j(new a(this), new b(this), this.a.j);
    }

    public final String e() {
        return this.a.f();
    }

    public final im2.d h() {
        return this.a.c;
    }

    public final int c() {
        return d4.i();
    }

    public f(com.bytedance.android.livesdk.interactivity.seek.v2.b r1) {
        this.a = r1;
    }
}
