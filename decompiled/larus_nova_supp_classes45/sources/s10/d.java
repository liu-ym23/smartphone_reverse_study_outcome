package s10;

import com.bytedance.android.live.broadcastgame.opengame.network.a0;
import com.bytedance.android.livesdk.config.ic1;
import com.bytedance.android.livesdk.utils.d4;
import com.ss.ugc.live.sdk.msg.network.l;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements amc.g {
    public final /* synthetic */ s10.a a;

    public static final class a<T> implements h80.d {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // h80.d
        public final Object get() {
            return Long.valueOf(this.a.a.m);
        }
    }

    public static final class b<T> implements h80.d {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // h80.d
        public final Object get() {
            String r0 = this.a.a.o;
            if (r0 != null) goto L6;
            return "";
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

        @Override // h80.d
        public final Object get() {
            return new HashMap();
        }
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

    public final Map<String, String> a() {
        return this.a.f();
    }

    public final boolean b() {
        Integer r0 = (Integer) ic1.a.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public final com.ss.ugc.live.sdk.msg.network.i d() {
        return new im2.h(new a(this), new b(this), c.a);
    }

    public final String e() {
        StringBuilder r0 = new StringBuilder("https://");
        int r1 = a0.a;
        r0.append(a0.a.a());
        r0.append("/webcast/im/fetch/");
        return r0.toString();
    }

    public final l f() {
        return this.a.g;
    }

    public final im2.d h() {
        return this.a.c;
    }

    public final amc.d l() {
        return new im2.l(this.a.g);
    }

    public final int c() {
        return d4.i();
    }

    public d(s10.a r1) {
        this.a = r1;
    }
}
