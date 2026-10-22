package com.bytedance.android.live.room.api.screenrotation.rotate;

import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RotateInnerRequest<T> extends h<T> {
    public static final a g = null;
    public final Lazy d;
    public final f e;
    public final g<T> f;

    public static final class a {
        public a() {
        }
    }

    static {
        g = new a();
    }

    public final HorizontalPlayEvent b() {
        g.getClass();
        Intrinsics.checkNotNullParameter(this, "innerRequest");
        g<T> r0 = this.f;
        f r1 = this.e;
        int r3 = 1;
        if (Intrinsics.areEqual(r1, f.b.a) == false) goto L6;
        int r2 = 1;
    L8:
        HorizontalPlayEvent r4 = new HorizontalPlayEvent(r2);
        i r5 = r0.b;
        if (Intrinsics.areEqual(r5, i.a.a) == false) goto L12;
    L20:
        r4.rotationType = r3;
        r4.source = r0.a;
        r4.extra = r0.c;
        r4.rotateInnerReq = this;
        return r4;
    L12:
        if (Intrinsics.areEqual(r5, i.c.a) == false) goto L15;
        r3 = 3;
        goto L20
    L15:
        if (Intrinsics.areEqual(r5, i.d.a) == false) goto L18;
        r3 = 2;
        goto L20
    L18:
        if (Intrinsics.areEqual(r5, i.b.a) == false) goto L23;
        r3 = 0;
        goto L20
    L23:
        throw new NoWhenBranchMatchedException();
    L6:
        if (Intrinsics.areEqual(r1, f.a.a) == false) goto L25;
        r2 = 2;
        goto L8
    L25:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final RotateInnerRequest a(HorizontalPlayEvent r6) {
        g.getClass();
        Intrinsics.checkNotNullParameter(r6, "event");
        Object r0 = r6.rotateInnerReq;
        if ((r0 instanceof RotateInnerRequest) == true) goto L5;
        r0 = null;
    L5:
        RotateInnerRequest r1 = (RotateInnerRequest) r0;
        if (r1 != null) goto L27;
        int r2 = r6.what;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        f r3 = f.b.a;
    L14:
        int r4 = r6.rotationType;
        if (r4 == 0) goto L24;
        if (r4 == 1) goto L23;
        if (r4 != 2) goto L19;
        i r5 = i.d.a;
    L25:
        String r7 = String.valueOf(System.currentTimeMillis());
        g r8 = new g();
        String r9 = r6.source;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.a = r9;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r8.b = r5;
        r8.c = (T) r6.extra;
        Unit r10 = Unit.INSTANCE;
        return new RotateInnerRequest(r7, r3, r8);
    L19:
        if (r4 == 3) goto L21;
        r5 = i.b.a;
        goto L25
    L21:
        r5 = i.c.a;
        goto L25
    L23:
        r5 = i.a.a;
        goto L25
    L24:
        r5 = i.b.a;
        goto L25
    L12:
        r3 = f.a.a;
        goto L14
    L13:
        r3 = f.b.a;
        goto L14
    L27:
        return r1;
    }

    public RotateInnerRequest(String r3, f r4, g<T> r5) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "orientation");
        Intrinsics.checkNotNullParameter(r5, "builder");
        super(r4, r5.a, r5.b, r5.c);
        this.e = r4;
        this.f = r5;
        this.d = LazyKt.lazy(new RotateInnerRequest$curRotateHandler$2(this));
    }
}
