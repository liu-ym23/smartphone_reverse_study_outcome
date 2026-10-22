package com.bytedance.android.live.service.prerequest;

import am2.x;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        b r8 = this.a;
        r8.getClass();
        ALogger.i("NewUserProfile_ProfilePre", "predict pre request");
        JSONObject r0 = new JSONObject();
        m r1 = r8.h.getRoom();
        String r2 = null;
        if (r1 == null) goto L7;
        IRoom r3 = (IRoom) r1.getValue();
        if (r3 == null) goto L7;
        Long r4 = Long.valueOf(r3.getRoomId());
    L8:
        JSONObject r5 = r0.putOpt("predict_room_id", r4);
        o r9 = j0.l().c(x.class);
        if (r9 == null) goto L13;
        Map r10 = r9.getMap();
        if (r10 == null) goto L13;
        String r12 = (String) r10.get("enter_from_merge");
    L14:
        JSONObject r13 = r5.putOpt("enter_from_merge", r12);
        o r14 = j0.l().c(x.class);
        if (r14 == null) goto L19;
        Map r15 = r14.getMap();
        if (r15 == null) goto L19;
        String r16 = (String) r15.get("enter_method");
    L20:
        JSONObject r17 = r13.putOpt("enter_method", r16);
        IAiService r18 = k.f(IAiService.class);
        if (r18 == null) goto L23;
        r18.runPredict("aweme_live_profile_card_preload", r17, null);
    L23:
        ProfileMonitor.a r19 = ProfileMonitor.g;
        IMiddlewareUserService r20 = k.f(IMiddlewareUserService.class);
        if (r20 == null) goto L28;
        com.bytedance.android.livesdk.user.e r22 = r20.user();
        if (r22 == null) goto L28;
        String r23 = r22.n();
    L29:
        String r24 = String.valueOf(r23);
        m r25 = r8.h.getRoom();
        if (r25 == null) goto L36;
        IRoom r26 = (IRoom) r25.getValue();
        if (r26 == null) goto L36;
        IBaseUser r27 = r26.getOwner();
        if (r27 == null) goto L36;
        r2 = r27.getIdString();
    L36:
        String r28 = String.valueOf(r2);
        m r29 = r8.h.getRoom();
        if (r29 == null) goto L41;
        IRoom r30 = (IRoom) r29.getValue();
        if (r30 == null) goto L41;
        long r32 = r30.getRoomId();
    L42:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r24, "currentId");
        Intrinsics.checkNotNullParameter(r28, "anchorId");
        Map r33 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("current_id", r24), TuplesKt.to("anchor_id", r28), TuplesKt.to("room_id", String.valueOf(r32))});
        ProfileMonitor.a.a(r33);
        j0.l().sendLog("livesdk_profile_pre_request_predict", r33, new Object[0]);
        return;
    L41:
        r32 = 0;
    L28:
        r23 = null;
    L19:
        r16 = null;
    L13:
        r12 = null;
    L7:
        r4 = null;
        goto L8
    }
}
