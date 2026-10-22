package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public e(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public final Map<String, PkBaseResult> a(Map<String, ? extends IBattleUserInfo> r9) {
        HashMap r0 = new HashMap();
        if (r9 != null) goto L5;
        return r0;
    L5:
        PkBaseResult r1 = PkBaseResult.NOT_FINISH;
        Iterator<Map.Entry<String, ? extends IBattleUserInfo>> r2 = r9.entrySet().iterator();
        s r3 = null;
        String r4 = null;
    L7:
        if (r2.hasNext() == false) goto L48;
        Map.Entry<String, ? extends IBattleUserInfo> r5 = r2.next();
        String r6 = r5.getKey();
        com.bytedance.android.live.revlink.impl.global.c r7 = this.a;
        if (r7 == null) goto L11;
        s r8 = r7.getRevLinkCommonUtil();
    L12:
        if (r8 == null) goto L14;
        String r10 = r8.c();
    L16:
        if (Intrinsics.areEqual(r6, r10) == true) goto L17;
        r4 = r5.getKey();
        goto L7
    L17:
        com.bytedance.android.live.revlink.impl.global.c r12 = this.a;
        if (r12 == null) goto L20;
        s r13 = r12.getRevLinkCommonUtil();
    L21:
        if (r13 == null) goto L23;
        String r14 = r13.c();
    L24:
        IBattleUserInfo r15 = r9.get(r14);
        if (r15 == null) goto L27;
        Integer r16 = Integer.valueOf(r15.getPkResult());
    L28:
        int r17 = IBattleUserInfo.PKResult.PKVictory.ordinal();
        if (r16 == null) goto L34;
        if (r16.intValue() != r17) goto L34;
        r1 = PkBaseResult.WIN;
    L34:
        int r18 = IBattleUserInfo.PKResult.PKFail.ordinal();
        if (r16 == null) goto L40;
        if (r16.intValue() != r18) goto L40;
        r1 = PkBaseResult.LOSE;
    L40:
        int r19 = IBattleUserInfo.PKResult.PKTie.ordinal();
        if (r16 == null) goto L46;
        if (r16.intValue() != r19) goto L46;
        r1 = PkBaseResult.EVEN;
    L46:
        r1 = PkBaseResult.NOT_FINISH;
        goto L7
    L27:
        r16 = null;
        goto L28
    L23:
        r14 = null;
        goto L24
    L20:
        r13 = null;
        goto L21
    L14:
        r10 = null;
        goto L16
    L11:
        r8 = null;
        goto L12
    L48:
        int r20 = d.a[r1.ordinal()];
        if (r20 != 1) goto L51;
        PkBaseResult r22 = PkBaseResult.LOSE;
    L58:
        com.bytedance.android.live.revlink.impl.global.c r23 = this.a;
        if (r23 == null) goto L61;
        r3 = r23.getRevLinkCommonUtil();
    L61:
        if (r3 == null) goto L65;
        String r24 = r3.c();
        if (r24 == null) goto L65;
        PkBaseResult r25 = (PkBaseResult) r0.put(r24, r1);
    L65:
        if (r4 == null) goto L67;
        PkBaseResult r26 = (PkBaseResult) r0.put(r4, r22);
    L67:
        return r0;
    L51:
        if (r20 != 2) goto L53;
        r22 = PkBaseResult.WIN;
        goto L58
    L53:
        if (r20 == 3) goto L55;
        r22 = PkBaseResult.NOT_FINISH;
        goto L58
    L55:
        r22 = PkBaseResult.EVEN;
        goto L58
    }
}
