package com.bytedance.badger.y;

import com.bytedance.badger.data.EventReportEnum;
import z64.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements z64.g {
    public final /* synthetic */ EventReportEnum a;

    public d(EventReportEnum r1) {
        this.a = r1;
    }

    @Override // z64.g
    public final void a(i r3) {
        if ((r3 instanceof i.b) == false) goto L16;
        if (EventReportEnum.LOGIN_BUTTON.getValue().equals(this.a.getValue()) == false) goto L14;
        Object r0 = g.b;
        monitor-enter(r0);
        a74.e.c();     // Catch: Throwable -> L11
        monitor-exit(r0);
    L11:
        th = move-exception;
        throw th;
    L14:
        StringBuilder r1 = new StringBuilder("event report success: event=");
        r1.append(this.a);
        r1.append(" scene=");
        i.b r4 = (i.b) r3;
        r1.append(r4.b);
        r1.append(" full=");
        r1.append(r4.c);
        com.bytedance.badger.e.f("event_behavior# ", r1.toString());
        return;
    L16:
        if ((r3 instanceof i.a) == false) goto L22;
        StringBuilder r2 = new StringBuilder("event report failed: event=");
        r2.append(this.a);
        r2.append(" generated=");
        i.a r5 = (i.a) r3;
        r2.append(r5.b);
        r2.append(" err=");
        r2.append(r5.a.getMessage());
        com.bytedance.badger.e.g("event_behavior# ", r2.toString());
        return;
    }
}
