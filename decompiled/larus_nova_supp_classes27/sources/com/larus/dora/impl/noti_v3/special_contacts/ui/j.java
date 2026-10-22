package com.larus.dora.impl.noti_v3.special_contacts.ui;

import com.larus.dora.impl.nl.notification_rule.ui.SwipeLayout;
import com.larus.dora.impl.noti_v3.special_contacts.adapter.NotificationBroadcastV3SpecialContactsAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j<T> implements FlowCollector {
    public final /* synthetic */ NotificationBroadcastV3SpecialContactsFragment a;

    public j(NotificationBroadcastV3SpecialContactsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        List r5 = (List) r3;
        NotificationBroadcastV3SpecialContactsAdapter r6 = this.a.h;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r6 = null;
    L5:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "newItems");
        WeakReference<SwipeLayout> r1 = r6.f;
        if (r1 == null) goto L10;
        SwipeLayout r2 = r1.get();
        if (r2 == null) goto L10;
        r2.a();
    L10:
        r6.f = null;
        ((ArrayList) r6.e).clear();
        ((ArrayList) r6.e).addAll(r5);
        r6.notifyDataSetChanged();
        return Unit.INSTANCE;
    }
}
