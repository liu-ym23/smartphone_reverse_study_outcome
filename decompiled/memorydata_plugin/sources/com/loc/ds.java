package com.loc;

import android.content.Context;
import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ds extends dq<dt> {
    public ds(Context r3, String r4, Handler r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    private static String a(dt r0) {
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.b();
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(dt r0, long r1) {
        if (r0 == null) goto L5;
        r0.t = r1;
        return;
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(dt r0) {
        if (r0 != null) goto L6;
        return 99;
    L6:
        return r0.s;
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(dt r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.t;
    }

    @Override // com.loc.dq
    final /* synthetic */ void a(dt r2, long r3) {
        a2((dt) ZeusTransformUtils.preCheckCast(r2, dt.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.loc.dq
    final long b() {
        return Cdo.g;
    }

    @Override // com.loc.dq
    public final /* synthetic */ String b(dt r2) {
        return a((dt) ZeusTransformUtils.preCheckCast(r2, dt.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.loc.dq
    final /* synthetic */ int c(dt r2) {
        return b2((dt) ZeusTransformUtils.preCheckCast(r2, dt.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.loc.dq
    final long c() {
        return Cdo.h;
    }

    @Override // com.loc.dq
    final /* synthetic */ long d(dt r2) {
        return c2((dt) ZeusTransformUtils.preCheckCast(r2, dt.class, "com.obric.memorydata.plugin"));
    }
}
