package com.bytedance.android.livesdk.dslservice.util;

import am2.x;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements yt1.h {
    public i() {
    }

    @Override // yt1.h
    public final String a() {
        return "send_track_log";
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.SendTrackLog;
    }

    @Override // yt1.h
    public final void b(Map r20, yt1.j r21) {
        Boolean r3 = null;
        if (r20 == null) goto L5;
        Object r4 = r20.get("event_name");
    L7:
        if ((r4 instanceof String) == true) goto L9;
        r4 = null;
    L9:
        String r5 = (String) r4;
        if (r5 != null) goto L77;
        return;
    L77:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L35
        String r8 = com.bytedance.android.livesdk.dsl.util.c.d(r20, "params");     // Catch: Throwable -> L35
        if (r8 == null) goto L17;
        AbstractMap r9 = com.bytedance.android.livesdk.dsl.util.c.h(r8);     // Catch: Throwable -> L35
        if (r9 == null) goto L17;
    L21:
        if (r9 != null) goto L23;
        r9 = new HashMap();     // Catch: Throwable -> L35
    L23:
        if (r20 == null) goto L33;
        Iterator r2 = r20.entrySet().iterator();     // Catch: Throwable -> L35
    L26:
        if (r2.hasNext() == false) goto L33;
        Map.Entry r10 = (Map.Entry) r2.next();     // Catch: Throwable -> L35
        String r11 = (String) r10.getKey();     // Catch: Throwable -> L35
        if (StringsKt.startsWith$default(r11, "custom_", false, 2, null) == false) goto L26;
        String r12 = StringsKt.removePrefix(r11, "custom_");     // Catch: Throwable -> L35
        Object r13 = r10.getValue();     // Catch: Throwable -> L35
        if ((r13 instanceof String) == true) goto L32;
        r13 = null;
    L32:
        String r14 = (String) r9.put(r12, (String) r13);     // Catch: Throwable -> L35
    L33:
        Object r0 = Result.constructor-impl(r9);     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r0) == false) goto L40;
        r0 = null;
    L40:
        Map r1 = (AbstractMap) r0;
        if (r1 != null) goto L43;
        r1 = new HashMap();
    L43:
        HashMap<String, Class<?>> r6 = l.a;
        if (r20 == null) goto L66;
        Iterator r15 = r20.entrySet().iterator();
    L48:
        if (r15.hasNext() == false) goto L66;
        Map.Entry r16 = (Map.Entry) r15.next();
        String r17 = (String) r16.getKey();
        Object r18 = r16.getValue();
        if ((r18 instanceof String) == false) goto L48;
        if (StringsKt.startsWith$default(r17, "Live_Common_Log#", false, 2, null) == false) goto L48;
        String r19 = StringsKt.replace$default(r17, "Live_Common_Log#", "", false, 4, null);
        List r22 = StringsKt.split$default((CharSequence) r18, new String[]{"#"}, false, 0, 6, null);
        if (r22.size() != 2) goto L48;
        String r110 = (String) ListProtector.get(r22, 0);
        String r23 = (String) ListProtector.get(r22, 1);
        Class<?> r111 = l.a.get(r110);
        if (r111 == null) goto L48;
        com.bytedance.android.livesdk.log.filter.o r112 = j0.l().c(r111);
        if (r112 == null) goto L62;
        Map r113 = r112.getMap();
        if (r113 == null) goto L62;
        String r24 = (String) r113.get(r23);
    L64:
        if ((r24 instanceof String) == false) goto L48;
        r1.put(r19, r24);
    L62:
        r24 = null;
    L66:
        String r25 = com.bytedance.android.livesdk.dsl.util.c.d(r20, "just_params");
        if (r25 != null) goto L70;
        r25 = "";
    L70:
        if (Intrinsics.areEqual(r25, "1") == false) goto L72;
        j0.l().h(r5, r1, new Object[0]);
        return;
    L72:
        j0 r26 = j0.l();
        Object[] r27 = new Object[3];
        r27[0] = IRoom.class;
        r27[1] = x.class;
        com.bytedance.android.livesdk.chatroom.o r28 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3);
        if (r28 == null) goto L75;
        r3 = r28.isAnchor();
    L75:
        r27[2] = new FollowLog(Intrinsics.areEqual(r3, Boolean.TRUE) ? 1 : 0);
        r26.h(r5, r1, r27);
        return;
    L17:
        Object r29 = r20.get("params");     // Catch: Throwable -> L35
        if ((r29 instanceof AbstractMap) == true) goto L20;
        r29 = null;
    L20:
        r9 = (AbstractMap) r29;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L5:
        r4 = null;
        goto L7
    }
}
