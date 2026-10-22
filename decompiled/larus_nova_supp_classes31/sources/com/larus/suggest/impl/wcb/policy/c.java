package com.larus.suggest.impl.wcb.policy;

import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final c0 a(com.larus.suggest.impl.wcb.request.e r9, com.larus.suggest.impl.wcb.request.f r10, hx9.l r11, long r12) {
        Intrinsics.checkNotNullParameter(r9, "transportResult");
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        Intrinsics.checkNotNullParameter(r11, "context");
        boolean r3 = false;
        if ((r9 instanceof com.larus.suggest.impl.wcb.request.e.b) == false) goto L8;
        com.larus.suggest.impl.repo.a.C0035a r13 = ((com.larus.suggest.impl.wcb.request.e.b) r9).a;
        long r6 = r13.a;
        String r14 = r13.b;
        if (r14 != null) goto L7;
        r14 = "";
    L7:
        c0 r15 = new c0(r6, r14, false);
    L35:
        if (r15 == null) goto L37;
        return r15;
    L37:
        wc9.e r16 = r11.O8();
        if (r16 == null) goto L40;
        String r17 = r16.a;
    L42:
        if (Intrinsics.areEqual(r17, r10.b) == false) goto L45;
        return null;
    L45:
        return new c0(0, "invalid conversation", true);
    L40:
        r17 = null;
        goto L42
    L8:
        NexPulseResponseData r18 = r9.getResponse();
        if (r18 != null) goto L12;
        r15 = new c0(0, "resp is null", true);
        goto L35
    L12:
        if (r18.isValid() == false) goto L14;
        r15 = null;
        goto L35
    L14:
        List r0 = r18.getCandidateList();
        if (r0 != null) goto L17;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == true) goto L23;
    L34:
        r15 = new c0(0, "invalid resp", true);
        goto L35
    L23:
        if (r12 <= 0) goto L34;
        NexPulseConf r19 = r18.getConf();
        if (r19 == null) goto L32;
        Long r20 = r19.getExpireTime();
        if (r20 == null) goto L32;
        if (r20.longValue() != r12) goto L32;
        r3 = true;
    L32:
        if (r3 == false) goto L34;
        r15 = new c0(0, "within expire time", true);
        goto L35
    L17:
        if (r0.isEmpty() == true) goto L20;
        r1 = false;
        goto L21
    }
}
