package com.ss.android.lark.passport.flow.core.router;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import syb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a<CONTEXT> {
    public static final AtomicReference<b> c = null;
    public final List<syb.a<CONTEXT>> a;
    public final Set<String> b;

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.core.router.a$a, reason: collision with other inner class name */
    public static final class C0085a {
        @JvmStatic
        public static PassportRouterResult a(Context r4, String r5, JSONObject r6) {
            Intrinsics.checkNotNullParameter(r4, "context");
            boolean r0 = false;
            if (r5 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            String r3 = null;
            if (r2 == false) goto L14;
            return new PassportRouterResult(PassportRouterResult.Status.INVALID_NEXT_STEP, r5, null);
        L14:
            if (Intrinsics.areEqual(r5, "ok") == true) goto L16;
            b r7 = a.c.get();
            if (r7 == null) goto L23;
            if (r7.a(r4, r5, r6) != true) goto L23;
            r0 = true;
        L23:
            if (r0 == false) goto L25;
            PassportRouterResult.Status r8 = PassportRouterResult.Status.DISPATCHED;
        L26:
            if (r0 == false) goto L29;
            r3 = "step_data_router";
        L29:
            return new PassportRouterResult(r8, r5, r3);
        L25:
            r8 = PassportRouterResult.Status.UNSUPPORTED;
            goto L26
        L16:
            return new PassportRouterResult(PassportRouterResult.Status.TERMINAL, r5, null);
        L5:
            if (r5.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    static {
        c = new AtomicReference();
    }

    public a(List<? extends syb.a<CONTEXT>> r5, Set<String> r6) {
        Intrinsics.checkNotNullParameter(r5, "actions");
        Intrinsics.checkNotNullParameter(r6, "terminalSteps");
        Set<String> r7 = r6;
        boolean r1 = true;
        if ((r7 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r0 = r7.iterator();
    L9:
        if (r0.hasNext() == false) goto L16;
        if (((String) r0.next()).length() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
        r1 = false;
        goto L16
    L13:
        r2 = false;
    L16:
        if (r1 == false) goto L20;
        this.a = CollectionsKt.toList(r5);
        this.b = CollectionsKt.toSet(r7);
        return;
    L20:
        throw new IllegalArgumentException("terminal step must not be empty".toString());
    L5:
        if (r7.isEmpty() == false) goto L7;
        goto L7
    }
}
