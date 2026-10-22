package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r42.n;
import r42.o;
import r42.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements o {
    public final /* synthetic */ d a;

    public h(d r1) {
        this.a = r1;
    }

    @Override // r42.o
    public final void a(n r13) {
        Intrinsics.checkNotNullParameter(r13, "data");
        i.b.getClass();
        i.v();
        this.a.c("历史消息返回");
        d r0 = this.a;
        p r1 = r13.a;
        String r14 = r13.b;
        r0.getClass();
        int r2 = r42.a.a;
        StringBuilder r3 = new StringBuilder("on fetch first history messages done, has history message: ");
        boolean r4 = false;
        if (r1 == null) goto L9;
        List<tlc.d> r5 = r1.a;
        if (r5 == null) goto L9;
        if ((!r5.isEmpty()) != true) goto L9;
        boolean r6 = true;
    L10:
        r3.append(r6);
        r42.a.c(r3.toString());
        if (r14 != null) goto L34;
        if (r1 == null) goto L34;
        boolean r15 = r1.b;
        List<tlc.d> r7 = r1.a;
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L16:
        if (r9.hasNext() == false) goto L21;
        Object r10 = r9.next();
        if ((!r0.c.contains(Long.valueOf(((tlc.d) r10).getMessageId()))) == false) goto L16;
        r8.add(r10);
        goto L16
    L21:
        if (r8.isEmpty() == true) goto L33;
        Iterator r11 = r8.iterator();
    L25:
        if (r11.hasNext() == false) goto L32;
        tlc.d r16 = (tlc.d) r11.next();
        if ((r16 instanceof t) == true) goto L29;
        r16 = null;
    L29:
        t r17 = (t) r16;
        if (r17 == null) goto L25;
        r17.setIsFirstHistoryMessage(true);
        goto L25
    L32:
        r4 = r15;
    L33:
        r0.s.invoke(new p(r8, r4));
        return;
    L34:
        if (r14 != null) goto L36;
        r14 = "resp is null";
    L36:
        String r18 = r14;
        s0 r19 = PublicScreenTraceMonitor.a;
        Intrinsics.checkNotNullParameter(r18, "errorTip");
        if (PublicScreenTraceMonitor.a.monitorHistoryFail == false) goto L40;
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("errorMsg", r18);
        Unit r110 = Unit.INSTANCE;
        new com.bytedance.android.livesdk.interactivity.api.monitor.c(-1, r18, 0, r20, 4).b(InteractivityTraceMonitor.Event.PublicScreenHistoryMsgFailEvent);
    L40:
        r0.s.invoke(new p(CollectionsKt.emptyList(), false));
        return;
    L9:
        r6 = false;
        goto L10
    }
}
