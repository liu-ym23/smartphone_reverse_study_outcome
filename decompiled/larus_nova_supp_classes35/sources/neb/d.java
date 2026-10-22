package neb;

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
public final class d extends c0c.b implements neb.a {
    public final /* synthetic */ neb.a b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<neb.a> d;

    public static final class a {
    }

    static {
    }

    @Override // neb.a
    public final boolean e1() {
        return this.b.e1();
    }

    @Override // neb.a
    public final void qe(String r2) {
        Intrinsics.checkNotNullParameter(r2, "feedId");
        this.b.qe(r2);
    }

    public d(j r4, v r5) {
        UserSession r0 = r4.b();
        if (r0 != null) goto L5;
        Log.w("PriorityDataCacheProxy", "init feed priority cache failed, userSession is invalid");
        r0 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<neb.a> r2 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r0), neb.a.class), neb.a.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r2, "proxy");
        super(r4);
        this.b = (neb.a) r2.b();
        this.c = r5;
        this.d = r2;
    }

    public final void qf(g r3, g r4) {
        if (r4 == null) goto L6;
        UserSession r5 = r4.b;
        if (r5 == null) goto L6;
    L7:
        neb.a r6 = (neb.a) k.b(this.c.c(r5), neb.a.class);
        StringBuilder r0 = new StringBuilder("PriorityDataCacheProxy, onUserChanged, new=");
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
        Log.i("PriorityDataCacheProxy", r0.toString());
        this.d.e(r6);
        return;
    L13:
        r2 = BuildConfig.FLAVOR;
    L6:
        Log.w("PriorityDataCacheProxy", "onUserChanged currentUserSession is invalid.");
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
