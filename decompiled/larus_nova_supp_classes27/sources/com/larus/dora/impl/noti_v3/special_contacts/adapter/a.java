package com.larus.dora.impl.noti_v3.special_contacts.adapter;

import com.larus.dora.impl.nl.notification_rule.ui.SwipeLayout;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements SwipeLayout.b {
    public final /* synthetic */ NotificationBroadcastV3SpecialContactsAdapter a;

    public a(NotificationBroadcastV3SpecialContactsAdapter r1) {
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
        NotificationBroadcastV3SpecialContactsAdapter r0 = this.a;
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
