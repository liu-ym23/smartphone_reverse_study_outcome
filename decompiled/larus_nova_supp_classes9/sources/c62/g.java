package c62;

import android.text.TextUtils;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.config.zn0;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements amc.g {
    public final /* synthetic */ d a;

    public static final class a<T> implements h80.d {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        public final Object get() {
            return Long.valueOf(this.a.a.n);
        }
    }

    public static final class b<T> implements h80.d {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        public final Object get() {
            String r0 = this.a.a.p;
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

    public final void j() {
    }

    public final boolean k() {
        return false;
    }

    public final Map<String, String> a() {
        d r0 = this.a;
        r0.getClass();
        IHostContext r1 = jc1.k.n(IHostContext.class);
        HashMap r3 = new HashMap(jc1.k.n(INetworkService.class).getCommonParams());
        r3.put("room_id", String.valueOf(r0.n));
        r3.put("rid", String.valueOf(r0.n));
        r3.put("aid", String.valueOf(r1.hostAppId()));
        r3.put("user_id", r0.o);
        r3.put("identity", r0.a);
        r3.put("live_id", String.valueOf(jc1.k.n(IHostContext.class).liveId()));
        String r2 = r0.p;
        if (r2 == null) goto L5;
        r3.put("room_tag", r2);
    L5:
        r3.putAll(r0.b);
        return r3;
    }

    public final boolean b() {
        int r0 = d4.a;
        return ((Boolean) zn0.a.getValue()).booleanValue();
    }

    public final com.ss.ugc.live.sdk.msg.network.i d() {
        return new im2.h(new a(this), new b(this), c.a);
    }

    public final String e() {
        return "https://" + jc1.k.n(IHostNetwork.class).getHostDomain() + "/webcast/im/fetch/channel/";
    }

    public final com.ss.ugc.live.sdk.msg.network.l f() {
        return this.a.h;
    }

    public final im2.d h() {
        return this.a.c;
    }

    public final amc.d l() {
        return new im2.l(this.a.h);
    }

    public final int c() {
        return d4.i();
    }

    public final String g() {
        if (TextUtils.isEmpty(d4.g().b()) == false) goto L7;
        return "wss://webcast100-ws-c.amemv.com/webcast/im/push/channel/";
    L7:
        return d4.g().b();
    }

    public final boolean i() {
        return d4.g().a();
    }

    public g(d r1) {
        this.a = r1;
    }
}
