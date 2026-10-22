package s10;

import android.content.Context;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.yj1;
import com.bytedance.android.livesdk.utils.d4;
import com.ss.ugc.live.sdk.msg.network.l;
import im2.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements amc.e {
    public final String a;
    public final HashMap<String, String> b;
    public final im2.d c;
    public final n d;
    public final bc2.a e;
    public final bc2.e f;
    public final l g;
    public final d h;
    public final Set<String> i;
    public final b j;
    public final c k;
    public final e l;
    public final long m;
    public final String n;
    public final String o;
    public final List<vlc.b> p;
    public final List<j> q;

    /* JADX INFO: renamed from: s10.a$a, reason: collision with other inner class name */
    public static final class C0272a {
    }

    static {
    }

    public final List<cmc.b<?>> e() {
        return null;
    }

    public final Map<String, String> f() {
        IHostContext r0 = k.n(IHostContext.class);
        HashMap r2 = new HashMap(k.n(INetworkService.class).getCommonParams());
        r2.put("room_id", String.valueOf(this.m));
        r2.put("rid", String.valueOf(this.m));
        r2.put("aid", String.valueOf(r0.appId()));
        r2.put("user_id", this.n.toString());
        r2.put("identity", this.a);
        r2.put("live_id", String.valueOf(k.n(IHostContext.class).liveId()));
        String r1 = this.o;
        if (r1 == null) goto L5;
        r2.put("room_tag", r1);
    L5:
        r2.putAll(this.b);
        return r2;
    }

    public final amc.b b() {
        return this.j;
    }

    public final com.ss.ugc.live.sdk.msg.b c() {
        return this.k;
    }

    public final amc.i d() {
        return this.l;
    }

    public final n g() {
        return this.d;
    }

    public final vlc.c getLogger() {
        return this.e;
    }

    public final bc2.e getMonitor() {
        return this.f;
    }

    public final amc.g getNetworkConfig() {
        return this.h;
    }

    public final long getRoomId() {
        return this.m;
    }

    public a(Context r8, long r9, String r11, boolean r12, List r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "userId");
        this.m = r9;
        this.n = r11;
        this.o = null;
        this.p = r13;
        this.q = null;
        if (r12 == false) goto L5;
        String r14 = "anchor";
    L6:
        this.a = r14;
        this.b = new HashMap();
        this.c = new im2.d(r12);
        Context r2 = r8.getApplicationContext();
        this.d = new n();
        this.e = new bc2.a("BroadcastGame");
        this.f = new bc2.e();
        if (((Boolean) yj1.a.getValue()).booleanValue() == true) goto L9;
    L11:
        com.ss.ugc.live.sdk.msg.network.a r15 = new im2.k(10009, r2, i.a, new f(this), new g(this), new h(this));
    L12:
        this.g = r15;
        this.h = new d(this);
        this.i = CollectionsKt.toSet(d4.m());
        this.j = new b(this);
        this.k = new c(this);
        this.l = new e();
        return;
    L9:
        if (v.a() == false) goto L11;
        r15 = new com.ss.ugc.live.sdk.msg.network.a();
        goto L12
    L5:
        r14 = "audience";
        goto L6
    }
}
