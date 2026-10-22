package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import com.bytedance.android.livesdk.interactivity.l;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements SelectedMsgBuffer.a {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer.a
    public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4, SelectedMsgBuffer.DropReason r5) {
        Intrinsics.checkNotNullParameter(r4, "absTextMessage");
        Intrinsics.checkNotNullParameter(r5, "reason");
        int r1 = ga2.d.a;
        Intrinsics.checkNotNullParameter(r4, "msg");
        Intrinsics.checkNotNullParameter(r5, "reason");
        l.a("chosen_screen_message_drop", "reason: " + r5.name() + ",msg_type: " + r4.b.getMessageMethod() + ", msg_id: " + r4.b.getMessageId() + ", msg_drop_diff_time: " + (System.currentTimeMillis() - r4.p().longValue()));
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer.a
    public final void b(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "absTextMessage");
        int r0 = ga2.d.a;
        Intrinsics.checkNotNullParameter(r4, "msg");
        StringBuilder r1 = new StringBuilder("queue_size: ");
        r1.append(r5);
        r1.append(", msg_id: ");
        r1.append(r4.b.getMessageId());
        r1.append(", msg_type：");
        T r6 = r4.b;
        if (r6 == 0) goto L5;
        String r7 = r6.getMessageMethod();
    L6:
        r1.append(r7);
        l.a("chosen_screen_message_enqueue", r1.toString());
        return;
    L5:
        r7 = null;
        goto L6
    }
}
