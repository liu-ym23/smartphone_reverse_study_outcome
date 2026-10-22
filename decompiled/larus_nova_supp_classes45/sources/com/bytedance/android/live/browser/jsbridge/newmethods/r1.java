package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.ChangeVsCameraViewResultModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.eventbus.VSJumpCameraEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "changeVsCameraView")
public final class r1 extends w20.q<w20.z7, ChangeVsCameraViewResultModel> {

    public static final class a {
    }

    static {
    }

    public r1() {
    }

    public final void invoke(Object r11, CallContext r12) {
        w20.z7 r13 = (w20.z7) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        JsonObject r14 = r13.b();
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r0 instanceof com.bytedance.android.livesdk.log.filter.n0) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.livesdk.log.filter.n0 r1 = (com.bytedance.android.livesdk.log.filter.n0) r0;
        if (r1 == null) goto L41;
        Map r2 = ((com.bytedance.android.livesdk.log.filter.a) r1).b;
        if (r2 == null) goto L41;
        if (r14 == null) goto L41;
        JsonElement r4 = r14.get("enter_from_merge");
        if (r4 == null) goto L15;
        String r5 = r4.getAsString();
    L16:
        JsonElement r15 = r14.get("enter_method");
        if (r15 == null) goto L19;
        String r16 = r15.getAsString();
    L20:
        boolean r6 = false;
        if (r5 != null) goto L23;
    L31:
        if (r16 == null) goto L41;
        if (r16.length() <= 0) goto L35;
        r6 = true;
    L35:
        if (r6 == true) goto L38;
        r16 = null;
    L38:
        if (r16 == null) goto L41;
        r2.put("enter_method", r16);
        goto L41
    L23:
        if (r5.length() <= 0) goto L25;
        boolean r7 = true;
    L26:
        if (r7 == true) goto L29;
        r5 = null;
    L29:
        if (r5 == null) goto L31;
        r2.put("enter_from_merge", r5);
        goto L31
    L25:
        r7 = false;
        goto L26
    L19:
        r16 = null;
        goto L20
    L15:
        r5 = null;
    L41:
        if (dq1.b.b(true) == false) goto L49;
        dq1.a r3 = pm1.f.a();
        if (r3 == null) goto L54;
        String r17 = r13.a();
        if (r17 == null) goto L47;
        long r8 = CastLongProtector.parseLong(r17);
    L48:
        dq1.a.a.a(r3, Long.valueOf(r8), null, false, null, null, 30);
        goto L54
    L47:
        r8 = 0;
    L54:
        RoomContext r18 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r18 == null) goto L62;
        com.bytedance.live.datacontext.m r19 = r18.getCameraId();
        if (r19 == null) goto L63;
        Observable r110 = r19.a();
        if (r110 == null) goto L64;
        r110.subscribe(new s1(this, r13));
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L49:
        xs2.b r111 = xs2.b.a();
        VSJumpCameraEvent r9 = new VSJumpCameraEvent();
        String r21 = r13.a();
        if (r21 == null) goto L52;
        long r22 = CastLongProtector.parseLong(r21);
    L53:
        r9.setCameraId(r22);
        Unit r23 = Unit.INSTANCE;
        r111.post(r9);
        goto L54
    L52:
        r22 = 0;
        goto L53
    }
}
