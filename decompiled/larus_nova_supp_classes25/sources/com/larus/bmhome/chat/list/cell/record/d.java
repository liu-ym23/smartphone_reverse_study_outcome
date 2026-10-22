package com.larus.bmhome.chat.list.cell.record;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.layout.item.RecordStatus;
import com.larus.bmhome.chat.layout.item.u3;
import com.larus.im.bean.message.Message;
import ic8.p0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements View.OnClickListener {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ RecordCardCell c;

    public /* synthetic */ d(p0 r1, Message r2, RecordCardCell r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        p0 r0 = this.a;
        Message r1 = this.b;
        RecordCardCell r9 = this.c;
        Map r2 = RecordCardCell.m;
        Context r3 = r11.getContext();
        String r4 = r0.c();
        String r12 = r1.getMessageId();
        String r5 = "";
        if (r12 != null) goto L5;
        String r6 = "";
    L6:
        String r13 = r1.getConversationId();
        if (r13 != null) goto L9;
        String r7 = "";
    L10:
        r9.u(r3, r4, true, r6, r7, "play_button");
        String r14 = r1.getMessageId();
        if (r14 != null) goto L13;
        r14 = "";
    L13:
        String r8 = r1.getConversationId();
        if (r8 == null) goto L17;
        r5 = r8;
    L17:
        Pair[] r10 = new Pair[2];
        u3 r15 = r9.e;
        if (r15 == null) goto L20;
        RecordStatus r16 = r15.getRecordStatus();
    L21:
        r10[0] = TuplesKt.to("card_status", RecordCardCell.s(r16));
        r10[1] = TuplesKt.to("action_type", "click_play_button");
        r9.x("voice_note_card_click", r14, r5, r10);
        return;
    L20:
        r16 = null;
        goto L21
    L9:
        r7 = r13;
        goto L10
    L5:
        r6 = r12;
        goto L6
    }
}
