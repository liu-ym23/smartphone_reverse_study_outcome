package s10;

import gm2.l;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import vlc.j;
import vlc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements amc.b {
    public final /* synthetic */ s10.a a;

    public static final class a<T> implements h80.d {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // h80.d
        public final Object get() {
            return Long.valueOf(this.a.a.m);
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

    public final k f() {
        return new l(new a(this));
    }

    public final List<vlc.b> getInterceptors() {
        return this.a.p;
    }

    public final Set<String> h() {
        return this.a.i;
    }

    public final List<j> i() {
        return this.a.q;
    }

    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> b() {
        return CollectionsKt.emptyList();
    }

    public b(s10.a r1) {
        this.a = r1;
    }
}
