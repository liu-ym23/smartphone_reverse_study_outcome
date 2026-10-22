package com.loc;

import android.content.Context;
import android.os.Handler;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ee extends dq<db> {
    public ee(Context r3, String r4, Handler r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    private static String a(db r0) {
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.a();
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(db r0, long r1) {
        if (r0 == null) goto L5;
        r0.f = r1;
        return;
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(db r0) {
        if (r0 != null) goto L6;
        return NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
    L6:
        return r0.c;
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(db r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.f;
    }

    @Override // com.loc.dq
    final /* synthetic */ void a(db r2, long r3) {
        a2((db) ZeusTransformUtils.preCheckCast(r2, db.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.loc.dq
    final long b() {
        return Cdo.e;
    }

    @Override // com.loc.dq
    public final /* synthetic */ String b(db r2) {
        return a((db) ZeusTransformUtils.preCheckCast(r2, db.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.loc.dq
    final /* synthetic */ int c(db r2) {
        return b2((db) ZeusTransformUtils.preCheckCast(r2, db.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.loc.dq
    final long c() {
        return Cdo.f;
    }

    @Override // com.loc.dq
    final /* synthetic */ long d(db r2) {
        return c2((db) ZeusTransformUtils.preCheckCast(r2, db.class, "com.obric.memorydata.plugin"));
    }
}
