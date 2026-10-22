package com.larus.dora.impl.nl.notification_rule.ui;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f0 implements SwipeLayout.b {
    public final /* synthetic */ NotificationRuleAdapter a;

    public f0(NotificationRuleAdapter r1) {
        this.a = r1;
    }

    @Override // com.larus.dora.impl.nl.notification_rule.ui.SwipeLayout.b
    public final void a(SwipeLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "layout");
        WeakReference<SwipeLayout> r0 = this.a.f;
        if (r0 == null) goto L5;
        SwipeLayout r1 = r0.get();
    L7:
        if (Intrinsics.areEqual(r1, r3) == false) goto L10;
        this.a.f = null;
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.dora.impl.nl.notification_rule.ui.SwipeLayout.b
    public final void b(SwipeLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "layout");
        NotificationRuleAdapter r0 = this.a;
        r0.f = new WeakReference(r3);
    }

    @Override // com.larus.dora.impl.nl.notification_rule.ui.SwipeLayout.b
    public final void c(SwipeLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        WeakReference<SwipeLayout> r0 = this.a.f;
        if (r0 == null) goto L5;
        SwipeLayout r1 = r0.get();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        r1.a();
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
