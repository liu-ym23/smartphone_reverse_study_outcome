package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final int a;
    public final String b;
    public final long c;
    public final Map<String, String> d;

    public c() {
        this(0, null, 0, null, 15);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L14;
        c r7 = (c) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        long r4 = this.c;
        int r5 = (((r0 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        Map<String, String> r6 = this.d;
        if (r6 == null) goto L10;
        r2 = r6.hashCode();
    L10:
        return r5 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "InteractivityMonitorData(statusCode=" + this.a + ", statusMsg=" + this.b + ", duration=" + this.c + ", extraInfo=" + this.d + ")";
    }

    public final void a(InteractivityMonitor.Event r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        int r1 = this.a;
        String r2 = this.b;
        long r3 = this.c;
        Map<String, String> r5 = this.d;
        int r6 = InteractivityMonitor.a;
        Intrinsics.checkNotNullParameter(r11, "event");
        Intrinsics.checkNotNullParameter(r2, "statusMsg");
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        o r4 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r4 == null) goto L9;
        m r7 = r4.getRoom();
        if (r7 == null) goto L9;
        IRoom r8 = (IRoom) r7.getValue();
    L10:
        LiveMonitor.a r13 = InteractivityMonitor.a(r11, r8, null);
        r13.l(r1);
        r13.h(r3);
        r13.e("status", r2);
        if (r5 == null) goto L16;
        Iterator<Map.Entry<String, String>> r9 = r5.entrySet().iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        Map.Entry<String, String> r10 = r9.next();
        r13.i(r10.getKey(), r10.getValue());
    L16:
        r13.a().report();
        return;
    L9:
        r8 = null;
        goto L10
    }

    public final void b(InteractivityTraceMonitor.Event r14) {
        Intrinsics.checkNotNullParameter(r14, "event");
        int r1 = this.a;
        String r2 = this.b;
        long r3 = this.c;
        Map<String, String> r5 = this.d;
        int r6 = InteractivityTraceMonitor.a;
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r2, "statusMsg");
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L8;
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Map.Entry<String, String> r8 = r7.next();
        d.a(r0, r8.getKey(), r8.getValue());
    L8:
        d.a(r0, "status_code", String.valueOf(r1));
        d.a(r0, "status_msg", r2);
        d.a(r0, "duration", String.valueOf(r3));
        if (r14.getNeedRoomCommonParams() == false) goto L37;
        int r4 = InteractivityTraceMonitor.a.a;
        Intrinsics.checkNotNullParameter(r0, "extra");
        IRoomContextService r9 = k.f(IRoomContextService.class);
        IRoom r10 = null;
        if (r9 == null) goto L17;
        o r11 = IRoomContextService.a.a(r9, null, 0, 3);
        if (r11 == null) goto L17;
        m r13 = r11.getRoom();
        if (r13 == null) goto L17;
        IRoom r15 = (IRoom) r13.getValue();
    L18:
        if (r15 != null) goto L20;
    L24:
        boolean r16 = false;
    L25:
        if (r16 == false) goto L27;
        r10 = r15;
    L27:
        if (r10 == null) goto L29;
        d.a(r0, "room_id", String.valueOf(r10.getId()));
        LiveMode r17 = r10.getStreamType();
        int r18 = h1.a;
        d.a(r0, "room_type", i1.a(r17));
        d.a(r0, "anchor_id", r10.getOwnerUserIdString());
    L29:
        IMiddlewareUserService r19 = k.f(IMiddlewareUserService.class);
        if (r19 == null) goto L35;
        com.bytedance.android.livesdk.user.e r20 = r19.user();
        if (r20 == null) goto L35;
        String r21 = r20.n();
        if (r21 == null) goto L35;
    L36:
        d.a(r0, "user_id", r21);
    L35:
        r21 = BuildConfig.FLAVOR;
        goto L36
    L20:
        if (r15.getId() <= 0) goto L24;
        if (r15.getOwner() == null) goto L24;
        r16 = true;
    L17:
        r15 = null;
    L37:
        int r23 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r24 = com.bytedance.android.live.core.monitor.trace.e.b.a(r14.getEventType(), r14.getBusinessType());
        r24.c = r14.getProductId();
        r24.h = Integer.valueOf(r1);
        r24.i = r2;
        r24.e = r0.optString("room_id");
        r24.f = r0.optString("anchor_id");
        r24.g = r0.optString("user_id");
        com.bytedance.android.live.core.monitor.trace.c.b(r24.a(), r0);
    }

    public c(int r2, String r3, long r4, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r3, "statusMsg");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }

    public /* synthetic */ c(int r7, String r8, long r9, Map r11, int r13) {
        if ((r13 & 1) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r13 & 2) == 0) goto L9;
        r8 = BuildConfig.FLAVOR;
    L9:
        String r2 = r8;
        if ((r13 & 4) == 0) goto L12;
        r9 = 0;
    L12:
        long r3 = r9;
        if ((r13 & 8) == 0) goto L15;
        r11 = null;
    L15:
        this(r1, r2, r3, r11);
        return;
    L5:
        r1 = r7;
        goto L7
    }
}
