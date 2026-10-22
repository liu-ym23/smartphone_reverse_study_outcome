package jeb;

import com.larksuite.framework.utils.w;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import f0c.g;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends c0c.b implements d {
    public final /* synthetic */ d b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<d> d;

    public static final class a {
    }

    static {
    }

    @Override // jeb.d
    public final void Xa() {
        this.b.Xa();
    }

    @Override // jeb.d
    public final void g5(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.g5(r2);
    }

    @Override // jeb.d
    public final void k4(String r2) {
        Intrinsics.checkNotNullParameter(r2, "feedId");
        this.b.k4(r2);
    }

    @Override // jeb.d
    public final void od(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.od(r2);
    }

    @Override // jeb.d
    public final String q3() {
        return this.b.q3();
    }

    public c(j r4, v r5) {
        UserSession r0 = r4.b();
        if (r0 != null) goto L5;
        Log.w("FeedClickDataCacheProxy", "init feed click data cache failed, userSession is invalid");
        r0 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<d> r2 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r0), d.class), d.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r2, "proxy");
        super(r4);
        this.b = (d) r2.b();
        this.c = r5;
        this.d = r2;
    }

    public final void qf(g r3, g r4) {
        if (r4 == null) goto L6;
        UserSession r5 = r4.b;
        if (r5 == null) goto L6;
    L7:
        d r6 = (d) k.b(this.c.c(r5), d.class);
        StringBuilder r0 = new StringBuilder("FeedClickDataCacheProxy, onUserChanged, new=");
        r0.append(w.a(r6));
        r0.append(", old=");
        Provider r1 = this.d.a;
        if (r1 != null) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        String r2 = w.a(r1);
        if (r2 == null) goto L13;
    L14:
        r0.append(r2);
        Log.i("FeedClickDataCacheProxy", r0.toString());
        this.d.e(r6);
        return;
    L13:
        r2 = BuildConfig.FLAVOR;
    L6:
        Log.w("FeedClickDataCacheProxy", "onUserChanged currentUserSession is invalid.");
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
