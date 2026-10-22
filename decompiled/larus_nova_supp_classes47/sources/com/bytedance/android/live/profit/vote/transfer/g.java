package com.bytedance.android.live.profit.vote.transfer;

import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.livesdk.revenue.ktv.RevKtvRoomKind;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import cy0.j;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends com.bytedance.ies.web.jsbridge2.g<Object, JSONObject> {

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    static {
    }

    public g() {
    }

    public final Object invoke(Object r8, CallContext r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callContext");
        cy0.e.a.getClass();
        j r10 = cy0.e.a.a;
        m.e.getClass();
        Object r12 = m.b(r10).b(er2.b.class);
        Intrinsics.checkNotNull(r12);
        iq2.h r13 = ((com.bytedance.live.kmp.core.c) r12).getKtvRoomInfo();
        iq2.c r14 = null;
        if (r13 == null) goto L31;
        b r0 = new b();
        iq2.f r1 = r13.c();
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(String.valueOf(r1.a()), "<set-?>");
        String r2 = r1.c();
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        Intrinsics.checkNotNullParameter(r1, "$this$singer");
        iq2.g r3 = r1.b();
        if (r3 == null) goto L13;
        r14 = r3.a();
    L13:
        if (r14 == null) goto L15;
        Intrinsics.checkNotNullParameter(r14.a(), "<set-?>");
        Intrinsics.checkNotNullParameter(r14.b(), "<set-?>");
    L15:
        Long r15 = r13.a();
        if (r15 == null) goto L18;
        long r4 = r15.longValue();
        long r5 = r4 / 1000;
        i97.a r16 = i97.a.a;
        long r6 = (System.currentTimeMillis() + r4) / 1000;
    L18:
        RevKtvRoomKind r17 = r13.b();
        int r18 = h.a[r17.ordinal()];
        if (r18 != 1) goto L21;
    L29:
        JSONObject r19 = new JSONObject();
        String r20 = GsonProtectorUtils.toJson(l97.a.a, r0);
        r19.put(Constants.Keys.DATA, new JSONObject(r20));
        int r7 = v.a;
        v.a("VoteKtvInfoMethod", r20);
        return r19;
    L21:
        if (r18 == 2) goto L29;
        if (r18 == 3) goto L29;
        if (r18 == 4) goto L29;
        throw new NoWhenBranchMatchedException();
    L31:
        return null;
    }
}
