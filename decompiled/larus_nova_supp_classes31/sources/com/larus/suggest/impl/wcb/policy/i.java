package com.larus.suggest.impl.wcb.policy;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.suggest.impl.wcb.model.WcbSurface;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i implements y {
    public static final i b = null;
    public static final Lazy c = null;
    public final /* synthetic */ w a;

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void a(com.larus.suggest.impl.wcb.request.f r2, NexPulseResponseData r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        Intrinsics.checkNotNullParameter(r3, "response");
        this.a.a(r2, r3, r4);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final String b(com.larus.suggest.impl.wcb.request.f r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        return this.a.b(r2);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long c(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return this.a.c(r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void d(com.larus.suggest.impl.wcb.request.f r2, NexPulseConf r3) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        this.a.d(r2, r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long e(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return this.a.e(r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long f(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return this.a.f(r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long g(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return this.a.g(r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void h(com.larus.suggest.impl.wcb.request.f r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "snapshot");
        this.a.h(r8, r9, r11);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long i(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return this.a.i(r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final String j(com.larus.suggest.impl.wcb.request.f r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        return this.a.j(r2);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final v k(com.larus.suggest.impl.wcb.request.f r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        return this.a.k(r2);
    }

    static {
        b = new i();
        c = LazyKt.lazy(new g());
    }

    public i() {
        this.a = new w(new h());
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final boolean l(com.larus.suggest.impl.wcb.request.f r15) {
        Intrinsics.checkNotNullParameter(r15, "snapshot");
        com.larus.suggest.impl.repo.e r0 = com.larus.suggest.impl.repo.e.a;
        String r1 = r15.b;
        String r2 = r15.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "conversationId");
        Intrinsics.checkNotNullParameter(r2, "userId");
        String r3 = "wcb_conversation_consumed_until_v2_" + r1;
        com.larus.suggest.impl.repo.e.b.getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r2, "userId");
        long r4 = ((Keva) com.larus.suggest.impl.repo.c.b.getValue()).getLong(com.larus.suggest.impl.repo.c.b(r3, r2), 0);
        if (r4 > 0) goto L5;
        return false;
    L5:
        long r7 = AppHost.a.getAppClock().currentTimeMillis() / 1000;
        if (r4 <= r7) goto L9;
        FLogger.a.i("WcbLog", "[LocalCache] conversation consumed, executionId=" + r15.e + ", conv_id=" + r15.b + ", consumedUntilSec=" + x.a(Long.valueOf(r4), r7) + ", nowSec=" + r7);
        return true;
    L9:
        String r12 = r15.b;
        String r13 = r15.a;
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        Intrinsics.checkNotNullParameter(r13, "userId");
        com.larus.suggest.impl.repo.c.a("wcb_conversation_consumed_until_v2_" + r12, r13);
        FLogger.a.i("WcbLog", "[LocalCache] clear expired consumed marker, executionId=" + r15.e + ", conv_id=" + r15.b + ", consumedUntilSec=" + x.a(Long.valueOf(r4), r7) + ", nowSec=" + r7);
        return false;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void m(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        com.larus.suggest.impl.repo.e r1 = com.larus.suggest.impl.repo.e.a;
        AccountService r2 = AccountService.a;
        String r3 = r2.getUserId();
        r1.getClass();
        com.larus.suggest.impl.repo.d r4 = com.larus.suggest.impl.repo.e.b(r10, r11, r3);
        long r5 = AppHost.a.getAppClock().currentTimeMillis() / 1000;
        if (r4 == null) goto L5;
        long r6 = r4.a;
    L6:
        long r7 = Math.max(r6, ((long) ((Number) c.getValue()).intValue()) + r5);
        String r8 = r2.getUserId();
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        Intrinsics.checkNotNullParameter(r8, "userId");
        com.larus.suggest.impl.repo.c r9 = com.larus.suggest.impl.repo.e.b;
        String r12 = "wcb_conversation_consumed_until_v2_".concat(r10);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r12, "key");
        Intrinsics.checkNotNullParameter(r8, "userId");
        ((Keva) com.larus.suggest.impl.repo.c.b.getValue()).storeLong(com.larus.suggest.impl.repo.c.b(r12, r8), r7);
        FLogger.a.i("WcbLog", "[LocalCache] record consumed, conv_id=" + r10 + ", scene=" + r11 + ", consumedUntilSec=" + x.a(Long.valueOf(r7), r5));
        Collection r13 = ((LinkedHashMap) lx9.b.a).values();
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L15;
        Object r16 = r15.next();
        if (((z) r16).getKey().a != WcbSurface.MAIN_CONVERSATION) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L8;
        r14.add(r16);
        goto L8
    L12:
        r17 = false;
        goto L13
    L15:
        LinkedHashSet r18 = new LinkedHashSet();
        Iterator r19 = r14.iterator();
    L17:
        if (r19.hasNext() == false) goto L19;
        r18.add(Integer.valueOf(((z) r19.next()).getScene()));
        goto L17
    L19:
        Iterator r110 = r18.iterator();
    L21:
        if (r110.hasNext() == false) goto L23;
        int r20 = ((Number) r110.next()).intValue();
        com.larus.suggest.impl.repo.e r21 = com.larus.suggest.impl.repo.e.a;
        String r22 = AccountService.a.getUserId();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        Intrinsics.checkNotNullParameter(r22, "userId");
        com.larus.suggest.impl.repo.c r23 = com.larus.suggest.impl.repo.e.b;
        String r24 = com.larus.suggest.impl.repo.e.d(r10, r20);
        r23.getClass();
        com.larus.suggest.impl.repo.c.a(r24, r22);
        com.larus.suggest.impl.repo.c.a(com.larus.suggest.impl.repo.e.c(r10, r20), r22);
        goto L21
    L23:
        return;
    L5:
        r6 = 0;
        goto L6
    }
}
