package com.bytedance.android.live.revlink.impl.jsb;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v extends wy0.c<c, Object> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    @Override // wy0.c
    public final Type j() {
        return this.a;
    }

    public v(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(c.class));
    }

    @Override // wy0.c
    public final Object k(vh7.j r8, CallContext r9) {
        Intrinsics.checkNotNullParameter((c) r8, "param");
        Intrinsics.checkNotNullParameter(r9, "callContext");
        JsonObject r10 = new JsonObject();
        com.bytedance.android.live.revlink.impl.global.c r12 = this.b;
        Long r0 = null;
        if (r12 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r13 = r12.Ig();
    L6:
        com.bytedance.android.live.revlink.impl.global.c r1 = this.b;
        if (r1 == null) goto L9;
        com.bytedance.android.live.revlink.impl.pk.utils.q r2 = r1.getPkUtils();
    L10:
        if (r2 == null) goto L12;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r3 = r2.g();
    L13:
        com.bytedance.android.live.revlink.impl.global.c r4 = this.b;
        if (r4 == null) goto L16;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r5 = r4.getPKBaseUtils();
    L18:
        if (r5 == null) goto L22;
        cf2.a r6 = r5.a();
        if (r6 == null) goto L22;
        long r7 = r6.a;
    L23:
        r10.add("left_score", GsonProtectorUtils.toJsonTree(l97.a.a, Long.valueOf(r7)));
        com.bytedance.android.live.revlink.impl.global.c r14 = this.b;
        if (r14 == null) goto L26;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r15 = r14.el();
    L27:
        if (r15 == null) goto L31;
        cf2.a r16 = r15.a();
        if (r16 == null) goto L31;
        long r17 = r16.a;
    L32:
        r10.add("right_score", GsonProtectorUtils.toJsonTree(l97.a.a, Long.valueOf(r17)));
        if (r13 == null) goto L40;
        LiveData<Map<String, PkBaseResult>> r18 = r13.getPkBaseResult();
        if (r18 == null) goto L40;
        Map r19 = (Map) r18.getValue();
        if (r19 == null) goto L40;
        PkBaseResult r20 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.f.a(r19, this.b);
        if (r20 == null) goto L40;
    L41:
        int r22 = u.a[r20.ordinal()];
        int r23 = 1;
        if (r22 != 1) goto L44;
        r23 = 0;
    L50:
        r10.add("pk_result", GsonProtectorUtils.toJsonTree(l97.a.a, Integer.valueOf(r23)));
        if (r13 == null) goto L56;
        LiveData<Long> r24 = r13.getBaseTimeLeft();
        if (r24 == null) goto L56;
        long r25 = (Long) r24.getValue();
        if (r25 == null) goto L56;
    L57:
        r10.add("remain_time", GsonProtectorUtils.toJsonTree(l97.a.a, r25));
        com.bytedance.android.live.revlink.impl.global.c r26 = this.b;
        if (r26 == null) goto L60;
        w31.c r27 = r26.getPkLinkUtils();
    L61:
        if (r27 == null) goto L63;
        Long r28 = Long.valueOf(r27.i());
    L64:
        r10.add("pk_id", GsonProtectorUtils.toJsonTree(l97.a.a, String.valueOf(r28)));
        com.bytedance.android.live.revlink.impl.global.c r29 = this.b;
        if (r29 == null) goto L67;
        LinkCrossRoomDataHolder r30 = r29.getLinkCrossRoomDataHolder();
    L68:
        if (r30 == null) goto L70;
        r0 = Long.valueOf(r30.c());
    L70:
        r10.add("channel_id", GsonProtectorUtils.toJsonTree(l97.a.a, String.valueOf(r0)));
        if (r13 == null) goto L75;
        IBaseBattleSetting r32 = r13.getBattleSettings();
        if (r32 == null) goto L75;
        long r33 = r32.getPunishDuration();
    L76:
        r10.add("punish_time", GsonProtectorUtils.toJsonTree(l97.a.a, Long.valueOf(r33)));
        if (r3 == null) goto L84;
        LiveData<IBaseUser> r34 = r3.getGuestUser();
        if (r34 == null) goto L84;
        IBaseUser r35 = (IBaseUser) r34.getValue();
        if (r35 == null) goto L84;
        String r36 = r35.getNickName();
        if (r36 == null) goto L84;
    L85:
        r10.add("pk_rival_name", GsonProtectorUtils.toJsonTree(l97.a.a, r36));
        return r10;
    L84:
        r36 = "";
    L75:
        r33 = 180;
        goto L76
    L67:
        r30 = null;
        goto L68
    L63:
        r28 = null;
        goto L64
    L60:
        r27 = null;
    L56:
        r25 = 0L;
        goto L57
    L44:
        if (r22 == 2) goto L50;
        r23 = 3;
        if (r22 != 3) goto L50;
        r23 = 2;
    L40:
        r20 = PkBaseResult.NOT_FINISH;
    L31:
        r17 = 0;
        goto L32
    L26:
        r15 = null;
    L22:
        r7 = 0;
        goto L23
    L16:
        r5 = null;
        goto L18
    L12:
        r3 = null;
        goto L13
    L9:
        r2 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }
}
