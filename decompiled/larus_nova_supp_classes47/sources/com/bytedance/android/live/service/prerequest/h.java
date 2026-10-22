package com.bytedance.android.live.service.prerequest;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements z90.a.b {
    public final /* synthetic */ b a;

    public h(b r1) {
        this.a = r1;
    }

    public final <T> void a(String r9, T r10) {
        Intrinsics.checkNotNullParameter(r9, "name");
        if (Intrinsics.areEqual(r9, "profile_card_preload_predict_result") == false) goto L61;
        ALogger.i("NewUserProfile_ProfilePre", "feature listener onDataChanged, value = " + r10);
        if (Boolean.parseBoolean(String.valueOf(r10)) == false) goto L62;
        m r12 = this.a.h.getRoom();
        if (r12 == null) goto L13;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L13;
        IBaseUser r14 = r13.getOwner();
        if (r14 == null) goto L13;
        String r15 = r14.getIdString();
    L14:
        Integer r0 = (Integer) ((HashMap) this.a.d).get(r15);
        if (r0 == null) goto L17;
        int r1 = r0.intValue();
    L18:
        ProfileMonitor.a r2 = ProfileMonitor.g;
        IMiddlewareUserService r3 = k.f(IMiddlewareUserService.class);
        if (r3 == null) goto L23;
        com.bytedance.android.livesdk.user.e r4 = r3.user();
        if (r4 == null) goto L23;
        String r5 = r4.n();
    L24:
        String r6 = String.valueOf(r5);
        m r7 = this.a.h.getRoom();
        if (r7 == null) goto L31;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L31;
        IBaseUser r16 = r8.getOwner();
        if (r16 == null) goto L31;
        String r17 = r16.getIdString();
    L32:
        String r18 = String.valueOf(r17);
        m r19 = this.a.h.getRoom();
        if (r19 == null) goto L37;
        IRoom r20 = (IRoom) r19.getValue();
        if (r20 == null) goto L37;
        long r22 = r20.getRoomId();
    L39:
        if (r1 <= 0) goto L41;
    L44:
        boolean r23 = true;
    L45:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "currentId");
        Intrinsics.checkNotNullParameter(r18, "anchorId");
        Map r24 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("current_id", r6), TuplesKt.to("anchor_id", r18), TuplesKt.to("room_id", String.valueOf(r22)), TuplesKt.to("is_too_late", String.valueOf(r23))});
        ProfileMonitor.a.a(r24);
        j0.l().sendLog("livesdk_profile_pre_request_predict_datachange", r24, new Object[0]);
        m r25 = this.a.h.getRoom();
        if (r25 == null) goto L54;
        IRoom r26 = (IRoom) r25.getValue();
        if (r26 == null) goto L54;
        IBaseUser r27 = r26.getOwner();
        if (r27 == null) goto L54;
        String r28 = r27.getIdString();
        if (r28 == null) goto L54;
        this.a.g(r28, true);
    L54:
        b r29 = this.a;
        r29.getClass();
        IFeatureService r30 = k.f(IFeatureService.class);
        if (r30 == null) goto L59;
        z90.a r32 = r30.getFeatureManager();
        if (r32 == null) goto L59;
        r32.h(r29.e);
    L59:
        r29.e = null;
        return;
    L41:
        if (Intrinsics.areEqual((Boolean) ((HashMap) this.a.c).get(r15), Boolean.TRUE) == true) goto L44;
        r23 = false;
    L37:
        r22 = 0;
    L31:
        r17 = null;
    L23:
        r5 = null;
        goto L24
    L17:
        r1 = 0;
    L13:
        r15 = null;
        goto L14
    L62:
        return;
    }
}
