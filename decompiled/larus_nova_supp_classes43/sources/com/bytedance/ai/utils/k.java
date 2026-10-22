package com.bytedance.ai.utils;

import androidx.collection.LruCache;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements k5.j {
    public final /* synthetic */ j.a a;

    public k(j.a r1) {
        this.a = r1;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.f("message_id", String.valueOf(this.a.a));
        r10.f("questionId", String.valueOf(this.a.b));
        String r1 = this.a.c;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r10.f("apiName", r1);
        String r11 = this.a.d;
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        r10.f("applet_id", r11);
        r10.e(MessageIndication.STATUS_RECEIVED, this.a.f);
        r10.d("sendAckTimes", this.a.h);
        r10.g("sendAckSucceed", Intrinsics.areEqual(this.a.i, j.b.d.c));
        r10.d("errorCode", this.a.i.a);
        r10.f("errorMsg", this.a.i.a());
        j.a r0 = this.a;
        Iterator<T> r12 = r0.w.iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        j.c r13 = (j.c) r12.next();
        String r14 = r13.b;
        LruCache<Long, j.a> r15 = j.a;
        r10.e(r14, j.a(r13.d, Long.valueOf(r0.f)));
        goto L10
    L12:
        LruCache<Long, j.a> r16 = j.a;
        j.a r17 = this.a;
        monitor-enter(r17);
        Map<String, Object> r18 = r17.g;     // Catch: Throwable -> L51
        Map r19 = null;
        if (r18 == null) goto L18;
        Map r20 = MapsKt.toMap(r18);     // Catch: Throwable -> L51
    L19:
        monitor-exit(r17);
        if (r20 == null) goto L34;
        Map r21 = MapsKt.toMutableMap(r20);
        if (r21 == null) goto L34;
        if (r21.containsKey("client_tool_result_success") == true) goto L33;
        r21.put("client_tool_result_success", 0);
        if (r21.containsKey("client_tool_failure_reason") == true) goto L33;
        r21.put("client_tool_failure_stage", "execute");
        if (r17.i.a != 101) goto L31;
        String r22 = "outer_timeout";
    L32:
        r21.put("client_tool_failure_reason", r22);
        goto L33
    L31:
        r22 = "pipeline_error";
    L33:
        r19 = r21;
    L34:
        if (r19 == null) goto L50;
        Iterator r23 = r19.entrySet().iterator();
    L37:
        if (r23.hasNext() == false) goto L71;
        Map.Entry r24 = (Map.Entry) r23.next();
        String r25 = (String) r24.getKey();
        Object r26 = r24.getValue();
        if ((r26 instanceof String) == true) goto L40;
        if ((r26 instanceof Integer) == true) goto L43;
        if ((r26 instanceof Long) == true) goto L46;
        if ((r26 instanceof Boolean) == false) goto L37;
        r10.g(r25, ((Boolean) r26).booleanValue());
        goto L37
    L46:
        r10.e(r25, ((Number) r26).longValue());
        goto L37
    L43:
        r10.d(r25, ((Number) r26).intValue());
        goto L37
    L40:
        r10.f(r25, (String) r26);
        goto L37
    L71:
        return;
    L50:
        return;
    L18:
        r20 = null;
    L51:
        th = move-exception;
        throw th;
    }
}
