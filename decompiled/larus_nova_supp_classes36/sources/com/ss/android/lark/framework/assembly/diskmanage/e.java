package com.ss.android.lark.framework.assembly.diskmanage;

import com.bytedance.lark.pb.basic.v1.TriggerDataCleanRequest;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import ebb.g;
import java.util.concurrent.CountDownLatch;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class e implements g {

    public static final class a {
    }

    static {
    }

    @Inject
    public e() {
    }

    public final void b() {
    }

    public final Biz getBiz() {
        return Biz.RUST;
    }

    public final cbb.a a(cbb.d r10) {
        Intrinsics.checkNotNullParameter(r10, "remoteConfig");
        int r4 = 0;
        final cbb.a r0 = new cbb.a(false, 0, 7);
    L4:
        if (r4 >= 3) goto L9;
        final Ref.BooleanRef r1 = new Ref.BooleanRef();
        final CountDownLatch r2 = new CountDownLatch(1);
        cbb.c r3 = r10.a;
        int r6 = (int) r3.e;
        int r5 = (int) r3.c;
        ((qpc.e) ApiUtils.getApi(qpc.e.class)).triggerDataClean(Integer.valueOf(r6), Integer.valueOf(r5), TriggerDataCleanRequest.CleanType.AUTO, new RustCleanTask$performRemoteClean$1(r0, r2, r1));
        r2.await();
        if (r1.element == false) goto L8;
        Log.i("RustCleanTask", "retry perform remote clean");
        r4 = r4 + 1;
        goto L4
    L8:
        Log.i("RustCleanTask", "finish remote clean");
    L9:
        return r0;
    }
}
