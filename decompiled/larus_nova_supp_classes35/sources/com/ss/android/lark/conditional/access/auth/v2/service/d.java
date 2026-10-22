package com.ss.android.lark.conditional.access.auth.v2.service;

import android.os.Handler;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.conditional.access.auth.v2.b0;
import com.ss.android.lark.conditional.access.auth.v2.service.chain.HandleInvalidDataInterceptor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.n;
import i8b.q;
import i8b.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends i8b.a {
    public final ExecutorCoroutineDispatcher b;
    public final HandleInvalidDataInterceptor c;
    public final ArrayList<n> d;

    public static final class a {
    }

    static {
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // i8b.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
    }

    @Override // i8b.a
    public final void a() {
        HandleInvalidDataInterceptor r0 = this.c;
        Object r1 = r0.c;
        monitor-enter(r1);
        ((Handler) r0.e.getValue()).removeCallbacks(r0.g);     // Catch: Throwable -> L7
        r0.d.clear();     // Catch: Throwable -> L7
        r0.f = false;     // Catch: Throwable -> L7
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public d(q r7) {
        Intrinsics.checkNotNullParameter(r7, "mManager");
        super(r7);
        this.b = ExecutorsKt.from(CoreThreadPool.getDefault().getFixedThreadPool());
        com.ss.android.lark.conditional.access.auth.v2.service.chain.f r0 = new com.ss.android.lark.conditional.access.auth.v2.service.chain.f(r7);
        com.ss.android.lark.conditional.access.auth.v2.service.chain.d r1 = new com.ss.android.lark.conditional.access.auth.v2.service.chain.d(r7);
        HandleInvalidDataInterceptor r2 = new HandleInvalidDataInterceptor(r7);
        this.c = r2;
        this.d = CollectionsKt.arrayListOf(new n[]{r0, r1, r2, new com.ss.android.lark.conditional.access.auth.v2.service.chain.b(r7), new com.ss.android.lark.conditional.access.auth.v2.service.chain.c(r7)});
    }

    public final void f(List r12, ValidateConfig r13, b0 r14) {
        Intrinsics.checkNotNullParameter(r12, "models");
        Intrinsics.checkNotNullParameter(r14, "callback");
        String r2 = qqb.a.d();
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.a, this.b, null, new CheckAuthService$asyncCheckAuthorityWithMergedResult$1(r2, this, r12, r13, r14, null), 2, null);
    }

    public static final Map e(d r6, List r7, Map r8, ValidateConfig r9) {
        r6.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r10 = r7.iterator();
    L3:
        boolean r3 = false;
        if (r10.hasNext() == false) goto L16;
        PolicyModel r1 = (PolicyModel) r10.next();
        com.ss.android.lark.conditional.access.auth.v2.c r4 = (com.ss.android.lark.conditional.access.auth.v2.c) r8.get(r1.getTaskId());
        if (r4 != null) goto L8;
        ArrayList<String> r5 = com.ss.android.lark.conditional.access.utils.c.a;
        Intrinsics.checkNotNullParameter("SecurityPolicy_CheckAuthService", "eventName");
        Intrinsics.checkNotNullParameter("authResult is null, fallback", "msg");
        ScsLogger.c("SecurityPolicy_CheckAuthService", "authResult is null, fallback");
        r4 = r6.a.a(r1);
    L8:
        com.ss.android.lark.conditional.access.utils.e.c(r9, r4);
        if (r9 != null) goto L11;
    L13:
        if (r3 == false) goto L15;
        r6.c(new t(r4.i()));
    L15:
        r4.q(r1.getPointKey());
        r0.put(r1.getTaskId(), com.ss.android.lark.conditional.access.auth.v2.g.a(r4));
        goto L3
    L11:
        if (r9.getIgnoreReportUserOperate() == true) goto L13;
        r3 = true;
        goto L13
    L16:
        ArrayList<String> r11 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_CheckAuthService", "do transValidateResultMap(), results is " + r0.values() + '!', false);
        return r0;
    }
}
