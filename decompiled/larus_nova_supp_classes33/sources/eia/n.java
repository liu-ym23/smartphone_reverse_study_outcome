package eia;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class n extends v {
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
    }

    static {
    }

    @Override // eia.v
    public void a() {
        boolean r0 = b();
        FLogger r1 = FLogger.a;
        r1.i("BaseInputStrategy", "applyOrientationChange " + hashCode());
        if (r0 == false) goto L21;
        maa.e r2 = (maa.e) this.f.getValue();
        if (r2 == null) goto L7;
        Boolean r3 = Boolean.valueOf(r2.x3());
    L8:
        maa.e r4 = (maa.e) this.f.getValue();
        if (r4 == null) goto L13;
        boolean r5 = true;
        if (r4.L4() != true) goto L13;
    L14:
        r1.i("BaseInputStrategy", "resumeClickTalk " + hashCode() + ", isClickTalking " + r3 + ", isClickTalkClosing " + r5);
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L22;
        if (r5 == true) goto L23;
        laa.m r6 = (laa.m) this.g.getValue();
        if (r6 == null) goto L24;
        r6.Tb();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L13:
        r5 = false;
        goto L14
    L7:
        r3 = null;
        goto L8
    }

    public n(Context r2, final t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        super(r2, r3);
        this.d = LazyKt.lazy(new f(r3));
        this.e = LazyKt.lazy(new g(r3));
        this.f = LazyKt.lazy(new h(r3));
        this.g = LazyKt.lazy(new i(r3));
        this.h = LazyKt.lazy(new j(r3));
        this.i = LazyKt.lazy(new k(r3));
        this.j = LazyKt.lazy(new l(r3));
        this.k = LazyKt.lazy(new m(r3));
    }
}
