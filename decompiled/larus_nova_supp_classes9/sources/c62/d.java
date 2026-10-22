package c62;

import android.content.Context;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.yj1;
import com.bytedance.android.livesdk.utils.d4;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements amc.e {
    public final String a;
    public final HashMap<String, String> b;
    public final im2.d c;
    public Disposable d;
    public final im2.n e;
    public final vlc.c f;
    public final bc2.e g;
    public final com.ss.ugc.live.sdk.msg.network.l h;
    public final g i;
    public final Set<String> j;
    public final e k;
    public final f l;
    public final i m;
    public final long n;
    public final String o;
    public final String p;
    public final List<vlc.b> q;
    public final List<vlc.j> r;
    public final vlc.c s;

    public static final class a {
    }

    static {
    }

    public final List<cmc.b<?>> e() {
        return null;
    }

    public final amc.b b() {
        return this.k;
    }

    public final com.ss.ugc.live.sdk.msg.b c() {
        return this.l;
    }

    public final amc.i d() {
        return this.m;
    }

    public final im2.n g() {
        return this.e;
    }

    public final vlc.c getLogger() {
        return this.f;
    }

    public final bc2.e getMonitor() {
        return this.g;
    }

    public final amc.g getNetworkConfig() {
        return this.i;
    }

    public final long getRoomId() {
        return this.n;
    }

    public d(Context r8, long r9, String r11, boolean r13, List r14, List r15, com.bytedance.android.livesdk.interactivity.base.im.b r16) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "userId");
        Intrinsics.checkNotNullParameter(r16, "channelLogger");
        this.n = r9;
        this.o = r11;
        this.p = null;
        this.q = r14;
        this.r = r15;
        this.s = r16;
        if (r13 == false) goto L5;
        String r10 = "anchor";
    L6:
        this.a = r10;
        this.b = new HashMap();
        this.c = new im2.d(r13);
        Context r2 = r8.getApplicationContext();
        this.e = new im2.n();
        this.f = r16;
        this.g = new bc2.e();
        if (((Boolean) yj1.a.getValue()).booleanValue() == true) goto L9;
    L11:
        com.ss.ugc.live.sdk.msg.network.a r17 = new im2.k(10010, r2, m.a, new j(this), new k(this), new l(this));
    L12:
        this.h = r17;
        this.i = new g(this);
        this.j = CollectionsKt.toSet(d4.m());
        this.k = new e(this);
        this.l = new f(this);
        this.m = new i();
        return;
    L9:
        if (v.a() == false) goto L11;
        r17 = new com.ss.ugc.live.sdk.msg.network.a();
        goto L12
    L5:
        r10 = "audience";
        goto L6
    }
}
