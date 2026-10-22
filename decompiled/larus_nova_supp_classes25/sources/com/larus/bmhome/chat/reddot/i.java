package com.larus.bmhome.chat.reddot;

import com.larus.bmhome.FlowLarkSocialServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.SocialIMData;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import xp9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public final Function0<Unit> a;
    public volatile SocialIMData b;
    public volatile boolean c;
    public volatile boolean d;
    public final g e;
    public final h f;

    public static final class a {
    }

    static {
    }

    public static boolean d() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L9;
        FlowLarkSocialServiceImpl r1 = r0.J();
        if (r1 == null) goto L9;
        if (r1.c() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void a() {
        if (this.c == false) goto L10;
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L9;
        FlowLarkSocialServiceImpl r1 = r0.J();
        if (r1 == null) goto L9;
        r1.e(this.e);
    L9:
        Object r2 = o.a;
        o.d(this.f);
        this.c = false;
        FLogger.a.i("MixedFeedRedDotManager", "clear");
    L10:
        this.b = null;
        this.d = false;
    }

    public final void e() {
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == true) goto L7;
        FLogger.a.e("MixedFeedRedDotManager", "not mix feed");
        a();
        return;
    L7:
        if (this.c == false) goto L10;
        FLogger.a.e("MixedFeedRedDotManager", "isRegistered");
        return;
    L10:
        this.c = true;
        Object r0 = o.a;
        o.a(this.f);
        FLogger.a.i("MixedFeedRedDotManager", "start");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.bmhome.chat.reddot.g] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.bmhome.chat.reddot.h] */
    public i(c r2) {
        Intrinsics.checkNotNullParameter(r2, "onRedDotChanged");
        this.a = r2;
        this.e = new g(this);
        this.f = new h(this);
    }

    public static long f(Integer r2) {
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L7:
        return RangesKt.coerceAtLeast(r3, 0);
    L5:
        r3 = 0;
        goto L7
    }

    public final long b(long r3) {
        Integer r1 = null;
        if (d() == false) goto L8;
        SocialIMData r4 = this.b;
        if (r4 == null) goto L7;
        r1 = r4.getRedBadge();
    L7:
        long r5 = f(r1);
    L13:
        return RangesKt.coerceAtLeast(r5, 0);
    L8:
        SocialIMData r0 = this.b;
        if (r0 == null) goto L11;
        r1 = r0.getRedBadgeWithoutDoubao();
    L11:
        r5 = r3 + f(r1);
        goto L13
    }

    public static long c(SocialIMData r2, boolean r3) {
        Integer r0 = null;
        if (r3 == false) goto L7;
        if (r2 == null) goto L6;
        r0 = r2.getRedBadge();
    L6:
        long r4 = f(r0);
    L11:
        return RangesKt.coerceAtLeast(r4, 0);
    L7:
        if (r2 == null) goto L9;
        r0 = r2.getRedBadgeWithoutDoubao();
    L9:
        r4 = f(r0);
        goto L11
    }

    public final void g(SocialIMData r9, String r10) {
        if (this.c == true) goto L5;
        return;
    L5:
        boolean r0 = d();
        long r1 = c(this.b, this.d);
        this.b = r9;
        long r3 = c(this.b, r0);
        if (r0 == this.d) goto L8;
        boolean r5 = true;
    L9:
        this.d = r0;
        if (r3 != r1) goto L13;
        if (r5 == true) goto L13;
        return;
    L13:
        FLogger.a.i("MixedFeedRedDotManager", "updateRedDotCount " + r1 + " -> " + r3 + ", source=" + r10 + " migrateFinished=" + r0 + ", current=" + r9);
        this.a.invoke();
        return;
    L8:
        r5 = false;
        goto L9
    }
}
