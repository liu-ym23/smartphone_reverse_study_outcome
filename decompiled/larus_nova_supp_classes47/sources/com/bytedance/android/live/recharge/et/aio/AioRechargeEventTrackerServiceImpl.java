package com.bytedance.android.live.recharge.et.aio;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.scope.o;
import com.google.gson.Gson;
import dw0.c;
import ix0.e;
import ix0.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jy0.b;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AioRechargeEventTrackerServiceImpl implements o, com.bytedance.android.live.recharge.et.aio.a {
    public final boolean a;
    public final ix0.a b;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public AioRechargeEventTrackerServiceImpl(ix0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "tokenManager");
        this.b = r2;
        this.a = v.a();
    }

    @Override // com.bytedance.android.live.recharge.et.aio.a
    public final void reportEvent(String r12, Map<String, String> r13, List<? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r12, "eventName");
        Intrinsics.checkNotNullParameter(r13, "eventProperties");
        Intrinsics.checkNotNullParameter(r14, "eventContext");
        if (this.a == false) goto L9;
        String r0 = CollectionsKt.joinToString$default(r13.entrySet(), "; ", null, null, 0, null, AioRechargeEventTrackerServiceImpl$reportEvent$props$1.INSTANCE, 30, null);
        if ((!r14.isEmpty()) == false) goto L7;
        String r2 = r14.toString();
    L8:
        b.d("AioRechargeEventTrackerService", "reportEvent: " + r12 + " { " + r0 + " } " + r2);
        goto L9
    L7:
        r2 = "";
    L9:
        Gson r1 = GsonHelper.get();
        ArrayList r3 = new ArrayList();
        Iterator<T> r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L19;
        Object r4 = r15.next();
        Object r5 = g.a(this.b, (e) r1.fromJson(r1.toJsonTree(r4), e.class));     // Catch: Throwable -> L15
    L17:
        if (r5 == null) goto L11;
        r3.add(r5);
    L15:
        th = move-exception;
        b.c("AioRechargeEventTrackerService", "failed to evaluate object '" + r4 + "': " + th.getMessage(), null, 4);
        r5 = null;
        goto L17
    L19:
        c.b.c(r12, r13, r3);
    }
}
