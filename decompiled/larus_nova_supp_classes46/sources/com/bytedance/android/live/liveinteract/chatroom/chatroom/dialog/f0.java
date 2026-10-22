package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.widget.Button;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0 implements TalkRoomFeedbackView.b {
    public final /* synthetic */ TalkRoomFeedbackDialog a;

    public f0(TalkRoomFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView.b
    public final void a(String r3, List r4) {
        Intrinsics.checkNotNullParameter(r4, "subTag");
        TalkRoomFeedbackDialog r0 = this.a;
        if (r0.n == false) goto L14;
        Button r1 = (Button) r0.S90(2131389551);
        if (mz.c.b(r3) == false) goto L7;
    L11:
        String r5 = s1.B(2131922738);
    L12:
        r1.setText(r5);
        return;
    L7:
        if ((!r4.isEmpty()) == false) goto L9;
    L10:
        r5 = s1.B(2131922739);
        goto L12
    L9:
        if (mz.c.b(null) == true) goto L11;
    }
}
