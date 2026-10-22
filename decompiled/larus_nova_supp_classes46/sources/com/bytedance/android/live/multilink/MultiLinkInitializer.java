package com.bytedance.android.live.multilink;

import bc.a;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.t1;
import com.bytedance.android.scope.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/multilink/MultiLinkInitializer;", "", "()V", "ensureInitialized", "", "multilink-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkInitializer {
    public static final MultiLinkInitializer INSTANCE = null;

    private MultiLinkInitializer() {
    }

    public final void ensureInitialized() {
    }

    static {
        INSTANCE = new MultiLinkInitializer();
        ALogger.w("MultiLinkScope", "MultiLinkInitializer#init, call invokeBatchCall", new Throwable());
        Function0 r0 = t1.a;
        Function0 r1 = t1.a;
        if (r1 == null) goto L5;
        Unit r2 = (Unit) r1.invoke();
    L5:
        a.call("scope-modules");
        h23.a r3 = h23.a.a;
        m r4 = m.e;
        h23.a r5 = h23.a.a;
        r4.getClass();
        m.e(r5);
        a.call("settings");
        ALogger.i("MultiLinkScope", "MultiLinkInitializer#init, invokeBatchCall Finish");
    }
}
