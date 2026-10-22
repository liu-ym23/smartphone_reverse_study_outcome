package com.larus.dora.impl.noti_v3.social_message.ui;

import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3SocialMessageBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f<T> implements FlowCollector {
    public final /* synthetic */ NotificationBroadcastV3SocialMessageFragment a;

    public f(NotificationBroadcastV3SocialMessageFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r4, Continuation r5) {
        q59.a r6 = (q59.a) r4;
        NotificationBroadcastV3SocialMessageFragment r7 = this.a;
        r7.h = r6.c;
        r7.i = r6.d;
        LarusDoraPageNotiV3SocialMessageBinding r0 = r7.f;
        if (r0 == null) goto L7;
        ItemTextArrow r1 = r0.c;
        if (r1 == null) goto L7;
        String r8 = r7.W90().resolveSingleMessageSummary(r6.c);
        int r2 = ItemTextArrow.k;
        r1.Z5(r8, null);
    L7:
        NotificationBroadcastV3SocialMessageFragment r9 = this.a;
        LarusDoraPageNotiV3SocialMessageBinding r3 = r9.f;
        if (r3 == null) goto L12;
        ItemTextArrow r10 = r3.b;
        if (r10 == null) goto L12;
        String r11 = r9.W90().resolveGroupMessageSummary(r6.d);
        int r12 = ItemTextArrow.k;
        r10.Z5(r11, null);
    L12:
        NotificationBroadcastV3SocialMessageFragment r13 = this.a;
        LarusDoraPageNotiV3SocialMessageBinding r14 = r13.f;
        if (r14 == null) goto L18;
        ItemTextArrow r15 = r14.d;
        if (r15 == null) goto L18;
        String r16 = r13.W90().resolveSpecialMessageSummary(r6.e, r6.f);
        int r17 = ItemTextArrow.k;
        r15.Z5(r16, null);
    L18:
        return Unit.INSTANCE;
    }
}
