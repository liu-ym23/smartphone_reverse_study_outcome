package com.larus.bmhome.chat.list.cell.record;

import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class RecordCardCell$d implements f09.a.b {
    public final /* synthetic */ RecordCardCell a;

    public final void onAllActivityDestroyed() {
    }

    public final void onAppBackground() {
        RecordCardCell r0 = this.a;
        k r1 = (k) ((BaseMessageListCell) r0).d;
        if (r1 == null) goto L15;
        Message r2 = r1.a;
        if (r2 == null) goto L16;
        String r3 = r2.getMessageId();
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        String r5 = r2.getConversationId();
        if (r5 == null) goto L13;
        r4 = r5;
    L13:
        Map r6 = RecordCardCell.m;
        r0.w(r3, r4);
        return;
    L16:
        return;
    }

    public final void onAppForeground() {
        RecordCardCell r0 = this.a;
        k r1 = (k) ((BaseMessageListCell) r0).d;
        if (r1 == null) goto L18;
        Message r2 = r1.a;
        if (r2 == null) goto L19;
        Map r3 = RecordCardCell.m;
        String r4 = r2.getMessageId();
        String r5 = "";
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        RecordCardCell$b.a(r4);
        String r6 = r2.getMessageId();
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        String r7 = r2.getConversationId();
        if (r7 == null) goto L16;
        r5 = r7;
    L16:
        r0.x("voice_note_card_show", r6, r5, new Pair[0]);
        return;
    L19:
        return;
    }

    public RecordCardCell$d(RecordCardCell r1) {
        this.a = r1;
    }
}
